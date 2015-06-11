package org.xtext.ui.contentassist.antlr.internal; 

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_WS", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'.'", "'@startuml'", "'@enduml'", "':'", "'-'", "'>'", "'<'", "'x'", "'\\\\'", "'/'", "'\\\\\\\\'", "'o'", "'|'", "'\\''", "'/\\''", "'\\'/'", "'actor'", "'boundary'", "'control'", "'entity'", "'database'"
    };
    public static final int RULE_STRING=4;
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
    public static final int RULE_ID=6;
    public static final int RULE_WS=5;
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
    public String getGrammarFileName() { return "../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g"; }


     
     	private PlantumlGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(PlantumlGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleModel"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:61:1: ( ruleModel EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel68); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:69:1: ruleModel : ( ( rule__Model__DiagramsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:73:2: ( ( ( rule__Model__DiagramsAssignment )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:74:1: ( ( rule__Model__DiagramsAssignment )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:74:1: ( ( rule__Model__DiagramsAssignment )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:75:1: ( rule__Model__DiagramsAssignment )*
            {
             before(grammarAccess.getModelAccess().getDiagramsAssignment()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:76:1: ( rule__Model__DiagramsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:76:2: rule__Model__DiagramsAssignment
            	    {
            	    pushFollow(FOLLOW_rule__Model__DiagramsAssignment_in_ruleModel94);
            	    rule__Model__DiagramsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getDiagramsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDiagram"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:88:1: entryRuleDiagram : ruleDiagram EOF ;
    public final void entryRuleDiagram() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:89:1: ( ruleDiagram EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:90:1: ruleDiagram EOF
            {
             before(grammarAccess.getDiagramRule()); 
            pushFollow(FOLLOW_ruleDiagram_in_entryRuleDiagram122);
            ruleDiagram();

            state._fsp--;

             after(grammarAccess.getDiagramRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDiagram129); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:97:1: ruleDiagram : ( ( rule__Diagram__Group__0 ) ) ;
    public final void ruleDiagram() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:101:2: ( ( ( rule__Diagram__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:102:1: ( ( rule__Diagram__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:102:1: ( ( rule__Diagram__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:103:1: ( rule__Diagram__Group__0 )
            {
             before(grammarAccess.getDiagramAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:104:1: ( rule__Diagram__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:104:2: rule__Diagram__Group__0
            {
            pushFollow(FOLLOW_rule__Diagram__Group__0_in_ruleDiagram155);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:116:1: entryRuleInstruction : ruleInstruction EOF ;
    public final void entryRuleInstruction() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:117:1: ( ruleInstruction EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:118:1: ruleInstruction EOF
            {
             before(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_ruleInstruction_in_entryRuleInstruction182);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getInstructionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstruction189); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:125:1: ruleInstruction : ( ( rule__Instruction__Alternatives ) ) ;
    public final void ruleInstruction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:129:2: ( ( ( rule__Instruction__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:130:1: ( ( rule__Instruction__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:130:1: ( ( rule__Instruction__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:131:1: ( rule__Instruction__Alternatives )
            {
             before(grammarAccess.getInstructionAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:132:1: ( rule__Instruction__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:132:2: rule__Instruction__Alternatives
            {
            pushFollow(FOLLOW_rule__Instruction__Alternatives_in_ruleInstruction215);
            rule__Instruction__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getInstructionAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleSequence"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:144:1: entryRuleSequence : ruleSequence EOF ;
    public final void entryRuleSequence() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:145:1: ( ruleSequence EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:146:1: ruleSequence EOF
            {
             before(grammarAccess.getSequenceRule()); 
            pushFollow(FOLLOW_ruleSequence_in_entryRuleSequence242);
            ruleSequence();

            state._fsp--;

             after(grammarAccess.getSequenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequence249); 

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
    // $ANTLR end "entryRuleSequence"


    // $ANTLR start "ruleSequence"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:153:1: ruleSequence : ( ( rule__Sequence__Alternatives ) ) ;
    public final void ruleSequence() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:157:2: ( ( ( rule__Sequence__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:158:1: ( ( rule__Sequence__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:158:1: ( ( rule__Sequence__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:159:1: ( rule__Sequence__Alternatives )
            {
             before(grammarAccess.getSequenceAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:160:1: ( rule__Sequence__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:160:2: rule__Sequence__Alternatives
            {
            pushFollow(FOLLOW_rule__Sequence__Alternatives_in_ruleSequence275);
            rule__Sequence__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSequenceAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSequence"


    // $ANTLR start "entryRuleComment"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:172:1: entryRuleComment : ruleComment EOF ;
    public final void entryRuleComment() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:173:1: ( ruleComment EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:174:1: ruleComment EOF
            {
             before(grammarAccess.getCommentRule()); 
            pushFollow(FOLLOW_ruleComment_in_entryRuleComment302);
            ruleComment();

            state._fsp--;

             after(grammarAccess.getCommentRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComment309); 

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
    // $ANTLR end "entryRuleComment"


    // $ANTLR start "ruleComment"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:181:1: ruleComment : ( ( rule__Comment__Alternatives ) ) ;
    public final void ruleComment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:185:2: ( ( ( rule__Comment__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:186:1: ( ( rule__Comment__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:186:1: ( ( rule__Comment__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:187:1: ( rule__Comment__Alternatives )
            {
             before(grammarAccess.getCommentAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:188:1: ( rule__Comment__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:188:2: rule__Comment__Alternatives
            {
            pushFollow(FOLLOW_rule__Comment__Alternatives_in_ruleComment335);
            rule__Comment__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getCommentAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComment"


    // $ANTLR start "entryRuleDefinition"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:200:1: entryRuleDefinition : ruleDefinition EOF ;
    public final void entryRuleDefinition() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:201:1: ( ruleDefinition EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:202:1: ruleDefinition EOF
            {
             before(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition362);
            ruleDefinition();

            state._fsp--;

             after(grammarAccess.getDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition369); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:209:1: ruleDefinition : ( ( rule__Definition__Alternatives ) ) ;
    public final void ruleDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:213:2: ( ( ( rule__Definition__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:214:1: ( ( rule__Definition__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:214:1: ( ( rule__Definition__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:215:1: ( rule__Definition__Alternatives )
            {
             before(grammarAccess.getDefinitionAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:216:1: ( rule__Definition__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:216:2: rule__Definition__Alternatives
            {
            pushFollow(FOLLOW_rule__Definition__Alternatives_in_ruleDefinition395);
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


    // $ANTLR start "rule__Instruction__Alternatives"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:228:1: rule__Instruction__Alternatives : ( ( ( rule__Instruction__Group_0__0 ) ) | ( ruleComment ) | ( ruleDefinition ) );
    public final void rule__Instruction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:232:1: ( ( ( rule__Instruction__Group_0__0 ) ) | ( ruleComment ) | ( ruleDefinition ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt2=1;
                }
                break;
            case 24:
            case 25:
                {
                alt2=2;
                }
                break;
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:233:1: ( ( rule__Instruction__Group_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:233:1: ( ( rule__Instruction__Group_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:234:1: ( rule__Instruction__Group_0__0 )
                    {
                     before(grammarAccess.getInstructionAccess().getGroup_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:235:1: ( rule__Instruction__Group_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:235:2: rule__Instruction__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_0__0_in_rule__Instruction__Alternatives431);
                    rule__Instruction__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInstructionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:239:6: ( ruleComment )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:239:6: ( ruleComment )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:240:1: ruleComment
                    {
                     before(grammarAccess.getInstructionAccess().getCommentParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleComment_in_rule__Instruction__Alternatives449);
                    ruleComment();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getCommentParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:245:6: ( ruleDefinition )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:245:6: ( ruleDefinition )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:246:1: ruleDefinition
                    {
                     before(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDefinition_in_rule__Instruction__Alternatives466);
                    ruleDefinition();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_2()); 

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
    // $ANTLR end "rule__Instruction__Alternatives"


    // $ANTLR start "rule__Sequence__Alternatives"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:256:1: rule__Sequence__Alternatives : ( ( ( rule__Sequence__Group_0__0 ) ) | ( ( rule__Sequence__Group_1__0 ) ) | ( ( rule__Sequence__Group_2__0 ) ) | ( ( rule__Sequence__Group_3__0 ) ) | ( ( rule__Sequence__Group_4__0 ) ) | ( ( rule__Sequence__Group_5__0 ) ) | ( ( rule__Sequence__Group_6__0 ) ) | ( ( rule__Sequence__Group_7__0 ) ) | ( ( rule__Sequence__Group_8__0 ) ) | ( ( rule__Sequence__Group_9__0 ) ) | ( ( rule__Sequence__Group_10__0 ) ) | ( ( rule__Sequence__Group_11__0 ) ) | ( ( rule__Sequence__Group_12__0 ) ) | ( ( rule__Sequence__Group_13__0 ) ) | ( ( rule__Sequence__Group_14__0 ) ) | ( ( rule__Sequence__Group_15__0 ) ) | ( ( rule__Sequence__Group_16__0 ) ) | ( ( rule__Sequence__Group_17__0 ) ) | ( ( rule__Sequence__Group_18__0 ) ) | ( ( rule__Sequence__Group_19__0 ) ) | ( '.' ) );
    public final void rule__Sequence__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:260:1: ( ( ( rule__Sequence__Group_0__0 ) ) | ( ( rule__Sequence__Group_1__0 ) ) | ( ( rule__Sequence__Group_2__0 ) ) | ( ( rule__Sequence__Group_3__0 ) ) | ( ( rule__Sequence__Group_4__0 ) ) | ( ( rule__Sequence__Group_5__0 ) ) | ( ( rule__Sequence__Group_6__0 ) ) | ( ( rule__Sequence__Group_7__0 ) ) | ( ( rule__Sequence__Group_8__0 ) ) | ( ( rule__Sequence__Group_9__0 ) ) | ( ( rule__Sequence__Group_10__0 ) ) | ( ( rule__Sequence__Group_11__0 ) ) | ( ( rule__Sequence__Group_12__0 ) ) | ( ( rule__Sequence__Group_13__0 ) ) | ( ( rule__Sequence__Group_14__0 ) ) | ( ( rule__Sequence__Group_15__0 ) ) | ( ( rule__Sequence__Group_16__0 ) ) | ( ( rule__Sequence__Group_17__0 ) ) | ( ( rule__Sequence__Group_18__0 ) ) | ( ( rule__Sequence__Group_19__0 ) ) | ( '.' ) )
            int alt3=21;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:261:1: ( ( rule__Sequence__Group_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:261:1: ( ( rule__Sequence__Group_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:262:1: ( rule__Sequence__Group_0__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:263:1: ( rule__Sequence__Group_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:263:2: rule__Sequence__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_0__0_in_rule__Sequence__Alternatives498);
                    rule__Sequence__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:267:6: ( ( rule__Sequence__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:267:6: ( ( rule__Sequence__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:268:1: ( rule__Sequence__Group_1__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:269:1: ( rule__Sequence__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:269:2: rule__Sequence__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_1__0_in_rule__Sequence__Alternatives516);
                    rule__Sequence__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:273:6: ( ( rule__Sequence__Group_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:273:6: ( ( rule__Sequence__Group_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:274:1: ( rule__Sequence__Group_2__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:275:1: ( rule__Sequence__Group_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:275:2: rule__Sequence__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_2__0_in_rule__Sequence__Alternatives534);
                    rule__Sequence__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:279:6: ( ( rule__Sequence__Group_3__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:279:6: ( ( rule__Sequence__Group_3__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:280:1: ( rule__Sequence__Group_3__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_3()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:281:1: ( rule__Sequence__Group_3__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:281:2: rule__Sequence__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_3__0_in_rule__Sequence__Alternatives552);
                    rule__Sequence__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:285:6: ( ( rule__Sequence__Group_4__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:285:6: ( ( rule__Sequence__Group_4__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:286:1: ( rule__Sequence__Group_4__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_4()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:287:1: ( rule__Sequence__Group_4__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:287:2: rule__Sequence__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_4__0_in_rule__Sequence__Alternatives570);
                    rule__Sequence__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:291:6: ( ( rule__Sequence__Group_5__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:291:6: ( ( rule__Sequence__Group_5__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:292:1: ( rule__Sequence__Group_5__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_5()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:293:1: ( rule__Sequence__Group_5__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:293:2: rule__Sequence__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_5__0_in_rule__Sequence__Alternatives588);
                    rule__Sequence__Group_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:297:6: ( ( rule__Sequence__Group_6__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:297:6: ( ( rule__Sequence__Group_6__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:298:1: ( rule__Sequence__Group_6__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_6()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:299:1: ( rule__Sequence__Group_6__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:299:2: rule__Sequence__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_6__0_in_rule__Sequence__Alternatives606);
                    rule__Sequence__Group_6__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:303:6: ( ( rule__Sequence__Group_7__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:303:6: ( ( rule__Sequence__Group_7__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:304:1: ( rule__Sequence__Group_7__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_7()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:305:1: ( rule__Sequence__Group_7__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:305:2: rule__Sequence__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_7__0_in_rule__Sequence__Alternatives624);
                    rule__Sequence__Group_7__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:309:6: ( ( rule__Sequence__Group_8__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:309:6: ( ( rule__Sequence__Group_8__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:310:1: ( rule__Sequence__Group_8__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_8()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:311:1: ( rule__Sequence__Group_8__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:311:2: rule__Sequence__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_8__0_in_rule__Sequence__Alternatives642);
                    rule__Sequence__Group_8__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:315:6: ( ( rule__Sequence__Group_9__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:315:6: ( ( rule__Sequence__Group_9__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:316:1: ( rule__Sequence__Group_9__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_9()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:317:1: ( rule__Sequence__Group_9__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:317:2: rule__Sequence__Group_9__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_9__0_in_rule__Sequence__Alternatives660);
                    rule__Sequence__Group_9__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:321:6: ( ( rule__Sequence__Group_10__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:321:6: ( ( rule__Sequence__Group_10__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:322:1: ( rule__Sequence__Group_10__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_10()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:323:1: ( rule__Sequence__Group_10__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:323:2: rule__Sequence__Group_10__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_10__0_in_rule__Sequence__Alternatives678);
                    rule__Sequence__Group_10__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:327:6: ( ( rule__Sequence__Group_11__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:327:6: ( ( rule__Sequence__Group_11__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:328:1: ( rule__Sequence__Group_11__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_11()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:329:1: ( rule__Sequence__Group_11__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:329:2: rule__Sequence__Group_11__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_11__0_in_rule__Sequence__Alternatives696);
                    rule__Sequence__Group_11__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:333:6: ( ( rule__Sequence__Group_12__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:333:6: ( ( rule__Sequence__Group_12__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:334:1: ( rule__Sequence__Group_12__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_12()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:335:1: ( rule__Sequence__Group_12__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:335:2: rule__Sequence__Group_12__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_12__0_in_rule__Sequence__Alternatives714);
                    rule__Sequence__Group_12__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:339:6: ( ( rule__Sequence__Group_13__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:339:6: ( ( rule__Sequence__Group_13__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:340:1: ( rule__Sequence__Group_13__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_13()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:341:1: ( rule__Sequence__Group_13__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:341:2: rule__Sequence__Group_13__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_13__0_in_rule__Sequence__Alternatives732);
                    rule__Sequence__Group_13__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:345:6: ( ( rule__Sequence__Group_14__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:345:6: ( ( rule__Sequence__Group_14__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:346:1: ( rule__Sequence__Group_14__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_14()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:347:1: ( rule__Sequence__Group_14__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:347:2: rule__Sequence__Group_14__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_14__0_in_rule__Sequence__Alternatives750);
                    rule__Sequence__Group_14__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:351:6: ( ( rule__Sequence__Group_15__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:351:6: ( ( rule__Sequence__Group_15__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:352:1: ( rule__Sequence__Group_15__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_15()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:353:1: ( rule__Sequence__Group_15__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:353:2: rule__Sequence__Group_15__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_15__0_in_rule__Sequence__Alternatives768);
                    rule__Sequence__Group_15__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:357:6: ( ( rule__Sequence__Group_16__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:357:6: ( ( rule__Sequence__Group_16__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:358:1: ( rule__Sequence__Group_16__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_16()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:359:1: ( rule__Sequence__Group_16__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:359:2: rule__Sequence__Group_16__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_16__0_in_rule__Sequence__Alternatives786);
                    rule__Sequence__Group_16__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:363:6: ( ( rule__Sequence__Group_17__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:363:6: ( ( rule__Sequence__Group_17__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:364:1: ( rule__Sequence__Group_17__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_17()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:365:1: ( rule__Sequence__Group_17__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:365:2: rule__Sequence__Group_17__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_17__0_in_rule__Sequence__Alternatives804);
                    rule__Sequence__Group_17__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:369:6: ( ( rule__Sequence__Group_18__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:369:6: ( ( rule__Sequence__Group_18__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:370:1: ( rule__Sequence__Group_18__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_18()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:371:1: ( rule__Sequence__Group_18__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:371:2: rule__Sequence__Group_18__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_18__0_in_rule__Sequence__Alternatives822);
                    rule__Sequence__Group_18__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:375:6: ( ( rule__Sequence__Group_19__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:375:6: ( ( rule__Sequence__Group_19__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:376:1: ( rule__Sequence__Group_19__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_19()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:377:1: ( rule__Sequence__Group_19__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:377:2: rule__Sequence__Group_19__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_19__0_in_rule__Sequence__Alternatives840);
                    rule__Sequence__Group_19__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:381:6: ( '.' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:381:6: ( '.' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:382:1: '.'
                    {
                     before(grammarAccess.getSequenceAccess().getFullStopKeyword_20()); 
                    match(input,11,FOLLOW_11_in_rule__Sequence__Alternatives859); 
                     after(grammarAccess.getSequenceAccess().getFullStopKeyword_20()); 

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
    // $ANTLR end "rule__Sequence__Alternatives"


    // $ANTLR start "rule__Comment__Alternatives"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:394:1: rule__Comment__Alternatives : ( ( ( rule__Comment__Group_0__0 ) ) | ( ( rule__Comment__Group_1__0 ) ) );
    public final void rule__Comment__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:398:1: ( ( ( rule__Comment__Group_0__0 ) ) | ( ( rule__Comment__Group_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==24) ) {
                alt4=1;
            }
            else if ( (LA4_0==25) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:399:1: ( ( rule__Comment__Group_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:399:1: ( ( rule__Comment__Group_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:400:1: ( rule__Comment__Group_0__0 )
                    {
                     before(grammarAccess.getCommentAccess().getGroup_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:401:1: ( rule__Comment__Group_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:401:2: rule__Comment__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Comment__Group_0__0_in_rule__Comment__Alternatives893);
                    rule__Comment__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCommentAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:405:6: ( ( rule__Comment__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:405:6: ( ( rule__Comment__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:406:1: ( rule__Comment__Group_1__0 )
                    {
                     before(grammarAccess.getCommentAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:407:1: ( rule__Comment__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:407:2: rule__Comment__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Comment__Group_1__0_in_rule__Comment__Alternatives911);
                    rule__Comment__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCommentAccess().getGroup_1()); 

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
    // $ANTLR end "rule__Comment__Alternatives"


    // $ANTLR start "rule__Definition__Alternatives"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:416:1: rule__Definition__Alternatives : ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) );
    public final void rule__Definition__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:420:1: ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) )
            int alt5=5;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt5=1;
                }
                break;
            case 28:
                {
                alt5=2;
                }
                break;
            case 29:
                {
                alt5=3;
                }
                break;
            case 30:
                {
                alt5=4;
                }
                break;
            case 31:
                {
                alt5=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:421:1: ( ( rule__Definition__Group_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:421:1: ( ( rule__Definition__Group_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:422:1: ( rule__Definition__Group_0__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:423:1: ( rule__Definition__Group_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:423:2: rule__Definition__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives944);
                    rule__Definition__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:427:6: ( ( rule__Definition__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:427:6: ( ( rule__Definition__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:428:1: ( rule__Definition__Group_1__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:429:1: ( rule__Definition__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:429:2: rule__Definition__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives962);
                    rule__Definition__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:433:6: ( ( rule__Definition__Group_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:433:6: ( ( rule__Definition__Group_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:434:1: ( rule__Definition__Group_2__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:435:1: ( rule__Definition__Group_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:435:2: rule__Definition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives980);
                    rule__Definition__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:439:6: ( ( rule__Definition__Group_3__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:439:6: ( ( rule__Definition__Group_3__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:440:1: ( rule__Definition__Group_3__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_3()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:441:1: ( rule__Definition__Group_3__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:441:2: rule__Definition__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives998);
                    rule__Definition__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:445:6: ( ( rule__Definition__Group_4__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:445:6: ( ( rule__Definition__Group_4__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:446:1: ( rule__Definition__Group_4__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_4()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:447:1: ( rule__Definition__Group_4__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:447:2: rule__Definition__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives1016);
                    rule__Definition__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_4()); 

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


    // $ANTLR start "rule__Diagram__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:458:1: rule__Diagram__Group__0 : rule__Diagram__Group__0__Impl rule__Diagram__Group__1 ;
    public final void rule__Diagram__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:462:1: ( rule__Diagram__Group__0__Impl rule__Diagram__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:463:2: rule__Diagram__Group__0__Impl rule__Diagram__Group__1
            {
            pushFollow(FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__01047);
            rule__Diagram__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__01050);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:470:1: rule__Diagram__Group__0__Impl : ( '@startuml' ) ;
    public final void rule__Diagram__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:474:1: ( ( '@startuml' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:475:1: ( '@startuml' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:475:1: ( '@startuml' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:476:1: '@startuml'
            {
             before(grammarAccess.getDiagramAccess().getStartumlKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__Diagram__Group__0__Impl1078); 
             after(grammarAccess.getDiagramAccess().getStartumlKeyword_0()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:489:1: rule__Diagram__Group__1 : rule__Diagram__Group__1__Impl rule__Diagram__Group__2 ;
    public final void rule__Diagram__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:493:1: ( rule__Diagram__Group__1__Impl rule__Diagram__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:494:2: rule__Diagram__Group__1__Impl rule__Diagram__Group__2
            {
            pushFollow(FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__11109);
            rule__Diagram__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__11112);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:501:1: rule__Diagram__Group__1__Impl : ( ( rule__Diagram__InstructionsAssignment_1 )* ) ;
    public final void rule__Diagram__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:505:1: ( ( ( rule__Diagram__InstructionsAssignment_1 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:506:1: ( ( rule__Diagram__InstructionsAssignment_1 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:506:1: ( ( rule__Diagram__InstructionsAssignment_1 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:507:1: ( rule__Diagram__InstructionsAssignment_1 )*
            {
             before(grammarAccess.getDiagramAccess().getInstructionsAssignment_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:508:1: ( rule__Diagram__InstructionsAssignment_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID||(LA6_0>=24 && LA6_0<=25)||(LA6_0>=27 && LA6_0<=31)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:508:2: rule__Diagram__InstructionsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Diagram__InstructionsAssignment_1_in_rule__Diagram__Group__1__Impl1139);
            	    rule__Diagram__InstructionsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getDiagramAccess().getInstructionsAssignment_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:518:1: rule__Diagram__Group__2 : rule__Diagram__Group__2__Impl ;
    public final void rule__Diagram__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:522:1: ( rule__Diagram__Group__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:523:2: rule__Diagram__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__21170);
            rule__Diagram__Group__2__Impl();

            state._fsp--;


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:529:1: rule__Diagram__Group__2__Impl : ( '@enduml' ) ;
    public final void rule__Diagram__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:533:1: ( ( '@enduml' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:534:1: ( '@enduml' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:534:1: ( '@enduml' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:535:1: '@enduml'
            {
             before(grammarAccess.getDiagramAccess().getEndumlKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__Diagram__Group__2__Impl1198); 
             after(grammarAccess.getDiagramAccess().getEndumlKeyword_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__Instruction__Group_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:554:1: rule__Instruction__Group_0__0 : rule__Instruction__Group_0__0__Impl rule__Instruction__Group_0__1 ;
    public final void rule__Instruction__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:558:1: ( rule__Instruction__Group_0__0__Impl rule__Instruction__Group_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:559:2: rule__Instruction__Group_0__0__Impl rule__Instruction__Group_0__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0__0__Impl_in_rule__Instruction__Group_0__01235);
            rule__Instruction__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0__1_in_rule__Instruction__Group_0__01238);
            rule__Instruction__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0__0"


    // $ANTLR start "rule__Instruction__Group_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:566:1: rule__Instruction__Group_0__0__Impl : ( ( rule__Instruction__NameAssignment_0_0 ) ) ;
    public final void rule__Instruction__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:570:1: ( ( ( rule__Instruction__NameAssignment_0_0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:571:1: ( ( rule__Instruction__NameAssignment_0_0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:571:1: ( ( rule__Instruction__NameAssignment_0_0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:572:1: ( rule__Instruction__NameAssignment_0_0 )
            {
             before(grammarAccess.getInstructionAccess().getNameAssignment_0_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:573:1: ( rule__Instruction__NameAssignment_0_0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:573:2: rule__Instruction__NameAssignment_0_0
            {
            pushFollow(FOLLOW_rule__Instruction__NameAssignment_0_0_in_rule__Instruction__Group_0__0__Impl1265);
            rule__Instruction__NameAssignment_0_0();

            state._fsp--;


            }

             after(grammarAccess.getInstructionAccess().getNameAssignment_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0__0__Impl"


    // $ANTLR start "rule__Instruction__Group_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:583:1: rule__Instruction__Group_0__1 : rule__Instruction__Group_0__1__Impl rule__Instruction__Group_0__2 ;
    public final void rule__Instruction__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:587:1: ( rule__Instruction__Group_0__1__Impl rule__Instruction__Group_0__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:588:2: rule__Instruction__Group_0__1__Impl rule__Instruction__Group_0__2
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0__1__Impl_in_rule__Instruction__Group_0__11295);
            rule__Instruction__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0__2_in_rule__Instruction__Group_0__11298);
            rule__Instruction__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0__1"


    // $ANTLR start "rule__Instruction__Group_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:595:1: rule__Instruction__Group_0__1__Impl : ( ruleSequence ) ;
    public final void rule__Instruction__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:599:1: ( ( ruleSequence ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:600:1: ( ruleSequence )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:600:1: ( ruleSequence )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:601:1: ruleSequence
            {
             before(grammarAccess.getInstructionAccess().getSequenceParserRuleCall_0_1()); 
            pushFollow(FOLLOW_ruleSequence_in_rule__Instruction__Group_0__1__Impl1325);
            ruleSequence();

            state._fsp--;

             after(grammarAccess.getInstructionAccess().getSequenceParserRuleCall_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0__1__Impl"


    // $ANTLR start "rule__Instruction__Group_0__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:612:1: rule__Instruction__Group_0__2 : rule__Instruction__Group_0__2__Impl rule__Instruction__Group_0__3 ;
    public final void rule__Instruction__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:616:1: ( rule__Instruction__Group_0__2__Impl rule__Instruction__Group_0__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:617:2: rule__Instruction__Group_0__2__Impl rule__Instruction__Group_0__3
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0__2__Impl_in_rule__Instruction__Group_0__21354);
            rule__Instruction__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0__3_in_rule__Instruction__Group_0__21357);
            rule__Instruction__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0__2"


    // $ANTLR start "rule__Instruction__Group_0__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:624:1: rule__Instruction__Group_0__2__Impl : ( ( rule__Instruction__NameAssignment_0_2 ) ) ;
    public final void rule__Instruction__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:628:1: ( ( ( rule__Instruction__NameAssignment_0_2 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:629:1: ( ( rule__Instruction__NameAssignment_0_2 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:629:1: ( ( rule__Instruction__NameAssignment_0_2 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:630:1: ( rule__Instruction__NameAssignment_0_2 )
            {
             before(grammarAccess.getInstructionAccess().getNameAssignment_0_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:631:1: ( rule__Instruction__NameAssignment_0_2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:631:2: rule__Instruction__NameAssignment_0_2
            {
            pushFollow(FOLLOW_rule__Instruction__NameAssignment_0_2_in_rule__Instruction__Group_0__2__Impl1384);
            rule__Instruction__NameAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getInstructionAccess().getNameAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0__2__Impl"


    // $ANTLR start "rule__Instruction__Group_0__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:641:1: rule__Instruction__Group_0__3 : rule__Instruction__Group_0__3__Impl rule__Instruction__Group_0__4 ;
    public final void rule__Instruction__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:645:1: ( rule__Instruction__Group_0__3__Impl rule__Instruction__Group_0__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:646:2: rule__Instruction__Group_0__3__Impl rule__Instruction__Group_0__4
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0__3__Impl_in_rule__Instruction__Group_0__31414);
            rule__Instruction__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0__4_in_rule__Instruction__Group_0__31417);
            rule__Instruction__Group_0__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0__3"


    // $ANTLR start "rule__Instruction__Group_0__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:653:1: rule__Instruction__Group_0__3__Impl : ( ( rule__Instruction__Group_0_3__0 )? ) ;
    public final void rule__Instruction__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:657:1: ( ( ( rule__Instruction__Group_0_3__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:658:1: ( ( rule__Instruction__Group_0_3__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:658:1: ( ( rule__Instruction__Group_0_3__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:659:1: ( rule__Instruction__Group_0_3__0 )?
            {
             before(grammarAccess.getInstructionAccess().getGroup_0_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:660:1: ( rule__Instruction__Group_0_3__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:660:2: rule__Instruction__Group_0_3__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_0_3__0_in_rule__Instruction__Group_0__3__Impl1444);
                    rule__Instruction__Group_0_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getInstructionAccess().getGroup_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0__3__Impl"


    // $ANTLR start "rule__Instruction__Group_0__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:670:1: rule__Instruction__Group_0__4 : rule__Instruction__Group_0__4__Impl ;
    public final void rule__Instruction__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:674:1: ( rule__Instruction__Group_0__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:675:2: rule__Instruction__Group_0__4__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0__4__Impl_in_rule__Instruction__Group_0__41475);
            rule__Instruction__Group_0__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0__4"


    // $ANTLR start "rule__Instruction__Group_0__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:681:1: rule__Instruction__Group_0__4__Impl : ( ( ruleComment )? ) ;
    public final void rule__Instruction__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:685:1: ( ( ( ruleComment )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:686:1: ( ( ruleComment )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:686:1: ( ( ruleComment )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:687:1: ( ruleComment )?
            {
             before(grammarAccess.getInstructionAccess().getCommentParserRuleCall_0_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:688:1: ( ruleComment )?
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:688:3: ruleComment
                    {
                    pushFollow(FOLLOW_ruleComment_in_rule__Instruction__Group_0__4__Impl1503);
                    ruleComment();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getInstructionAccess().getCommentParserRuleCall_0_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0__4__Impl"


    // $ANTLR start "rule__Instruction__Group_0_3__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:708:1: rule__Instruction__Group_0_3__0 : rule__Instruction__Group_0_3__0__Impl rule__Instruction__Group_0_3__1 ;
    public final void rule__Instruction__Group_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:712:1: ( rule__Instruction__Group_0_3__0__Impl rule__Instruction__Group_0_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:713:2: rule__Instruction__Group_0_3__0__Impl rule__Instruction__Group_0_3__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_3__0__Impl_in_rule__Instruction__Group_0_3__01544);
            rule__Instruction__Group_0_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_3__1_in_rule__Instruction__Group_0_3__01547);
            rule__Instruction__Group_0_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_3__0"


    // $ANTLR start "rule__Instruction__Group_0_3__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:720:1: rule__Instruction__Group_0_3__0__Impl : ( ':' ) ;
    public final void rule__Instruction__Group_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:724:1: ( ( ':' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:725:1: ( ':' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:725:1: ( ':' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:726:1: ':'
            {
             before(grammarAccess.getInstructionAccess().getColonKeyword_0_3_0()); 
            match(input,14,FOLLOW_14_in_rule__Instruction__Group_0_3__0__Impl1575); 
             after(grammarAccess.getInstructionAccess().getColonKeyword_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_3__0__Impl"


    // $ANTLR start "rule__Instruction__Group_0_3__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:739:1: rule__Instruction__Group_0_3__1 : rule__Instruction__Group_0_3__1__Impl ;
    public final void rule__Instruction__Group_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:743:1: ( rule__Instruction__Group_0_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:744:2: rule__Instruction__Group_0_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_3__1__Impl_in_rule__Instruction__Group_0_3__11606);
            rule__Instruction__Group_0_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_3__1"


    // $ANTLR start "rule__Instruction__Group_0_3__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:750:1: rule__Instruction__Group_0_3__1__Impl : ( RULE_STRING ) ;
    public final void rule__Instruction__Group_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:754:1: ( ( RULE_STRING ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:755:1: ( RULE_STRING )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:755:1: ( RULE_STRING )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:756:1: RULE_STRING
            {
             before(grammarAccess.getInstructionAccess().getSTRINGTerminalRuleCall_0_3_1()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Instruction__Group_0_3__1__Impl1633); 
             after(grammarAccess.getInstructionAccess().getSTRINGTerminalRuleCall_0_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_3__1__Impl"


    // $ANTLR start "rule__Sequence__Group_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:771:1: rule__Sequence__Group_0__0 : rule__Sequence__Group_0__0__Impl rule__Sequence__Group_0__1 ;
    public final void rule__Sequence__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:775:1: ( rule__Sequence__Group_0__0__Impl rule__Sequence__Group_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:776:2: rule__Sequence__Group_0__0__Impl rule__Sequence__Group_0__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_0__0__Impl_in_rule__Sequence__Group_0__01666);
            rule__Sequence__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_0__1_in_rule__Sequence__Group_0__01669);
            rule__Sequence__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_0__0"


    // $ANTLR start "rule__Sequence__Group_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:783:1: rule__Sequence__Group_0__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:787:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:788:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:788:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:789:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_0_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:790:1: ( '-' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==15) ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1==15) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:791:2: '-'
            	    {
            	    match(input,15,FOLLOW_15_in_rule__Sequence__Group_0__0__Impl1698); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_0__0__Impl"


    // $ANTLR start "rule__Sequence__Group_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:802:1: rule__Sequence__Group_0__1 : rule__Sequence__Group_0__1__Impl rule__Sequence__Group_0__2 ;
    public final void rule__Sequence__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:806:1: ( rule__Sequence__Group_0__1__Impl rule__Sequence__Group_0__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:807:2: rule__Sequence__Group_0__1__Impl rule__Sequence__Group_0__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_0__1__Impl_in_rule__Sequence__Group_0__11731);
            rule__Sequence__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_0__2_in_rule__Sequence__Group_0__11734);
            rule__Sequence__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_0__1"


    // $ANTLR start "rule__Sequence__Group_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:814:1: rule__Sequence__Group_0__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:818:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:819:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:819:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:820:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_0_1()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_0__1__Impl1762); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_0__1__Impl"


    // $ANTLR start "rule__Sequence__Group_0__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:833:1: rule__Sequence__Group_0__2 : rule__Sequence__Group_0__2__Impl ;
    public final void rule__Sequence__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:837:1: ( rule__Sequence__Group_0__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:838:2: rule__Sequence__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_0__2__Impl_in_rule__Sequence__Group_0__21793);
            rule__Sequence__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_0__2"


    // $ANTLR start "rule__Sequence__Group_0__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:844:1: rule__Sequence__Group_0__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:848:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:849:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:849:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:850:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_0_2()); 
            match(input,16,FOLLOW_16_in_rule__Sequence__Group_0__2__Impl1821); 
             after(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_0__2__Impl"


    // $ANTLR start "rule__Sequence__Group_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:869:1: rule__Sequence__Group_1__0 : rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1 ;
    public final void rule__Sequence__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:873:1: ( rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:874:2: rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_1__0__Impl_in_rule__Sequence__Group_1__01858);
            rule__Sequence__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_1__1_in_rule__Sequence__Group_1__01861);
            rule__Sequence__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_1__0"


    // $ANTLR start "rule__Sequence__Group_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:881:1: rule__Sequence__Group_1__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:885:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:886:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:886:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:887:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_1_0()); 
            match(input,17,FOLLOW_17_in_rule__Sequence__Group_1__0__Impl1889); 
             after(grammarAccess.getSequenceAccess().getLessThanSignKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_1__0__Impl"


    // $ANTLR start "rule__Sequence__Group_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:900:1: rule__Sequence__Group_1__1 : rule__Sequence__Group_1__1__Impl rule__Sequence__Group_1__2 ;
    public final void rule__Sequence__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:904:1: ( rule__Sequence__Group_1__1__Impl rule__Sequence__Group_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:905:2: rule__Sequence__Group_1__1__Impl rule__Sequence__Group_1__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_1__1__Impl_in_rule__Sequence__Group_1__11920);
            rule__Sequence__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_1__2_in_rule__Sequence__Group_1__11923);
            rule__Sequence__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_1__1"


    // $ANTLR start "rule__Sequence__Group_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:912:1: rule__Sequence__Group_1__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:916:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:917:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:917:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:918:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_1_1()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_1__1__Impl1951); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_1__1__Impl"


    // $ANTLR start "rule__Sequence__Group_1__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:931:1: rule__Sequence__Group_1__2 : rule__Sequence__Group_1__2__Impl ;
    public final void rule__Sequence__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:935:1: ( rule__Sequence__Group_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:936:2: rule__Sequence__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_1__2__Impl_in_rule__Sequence__Group_1__21982);
            rule__Sequence__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_1__2"


    // $ANTLR start "rule__Sequence__Group_1__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:942:1: rule__Sequence__Group_1__2__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:946:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:947:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:947:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:948:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_1_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:949:1: ( '-' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==15) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:950:2: '-'
            	    {
            	    match(input,15,FOLLOW_15_in_rule__Sequence__Group_1__2__Impl2011); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_1__2__Impl"


    // $ANTLR start "rule__Sequence__Group_2__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:967:1: rule__Sequence__Group_2__0 : rule__Sequence__Group_2__0__Impl rule__Sequence__Group_2__1 ;
    public final void rule__Sequence__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:971:1: ( rule__Sequence__Group_2__0__Impl rule__Sequence__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:972:2: rule__Sequence__Group_2__0__Impl rule__Sequence__Group_2__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_2__0__Impl_in_rule__Sequence__Group_2__02050);
            rule__Sequence__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_2__1_in_rule__Sequence__Group_2__02053);
            rule__Sequence__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_2__0"


    // $ANTLR start "rule__Sequence__Group_2__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:979:1: rule__Sequence__Group_2__0__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:983:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:984:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:984:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:985:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_2_0()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_2__0__Impl2081); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_2__0__Impl"


    // $ANTLR start "rule__Sequence__Group_2__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:998:1: rule__Sequence__Group_2__1 : rule__Sequence__Group_2__1__Impl rule__Sequence__Group_2__2 ;
    public final void rule__Sequence__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1002:1: ( rule__Sequence__Group_2__1__Impl rule__Sequence__Group_2__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1003:2: rule__Sequence__Group_2__1__Impl rule__Sequence__Group_2__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_2__1__Impl_in_rule__Sequence__Group_2__12112);
            rule__Sequence__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_2__2_in_rule__Sequence__Group_2__12115);
            rule__Sequence__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_2__1"


    // $ANTLR start "rule__Sequence__Group_2__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1010:1: rule__Sequence__Group_2__1__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1014:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1015:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1015:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1016:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_2_1()); 
            match(input,16,FOLLOW_16_in_rule__Sequence__Group_2__1__Impl2143); 
             after(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_2__1__Impl"


    // $ANTLR start "rule__Sequence__Group_2__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1029:1: rule__Sequence__Group_2__2 : rule__Sequence__Group_2__2__Impl ;
    public final void rule__Sequence__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1033:1: ( rule__Sequence__Group_2__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1034:2: rule__Sequence__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_2__2__Impl_in_rule__Sequence__Group_2__22174);
            rule__Sequence__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_2__2"


    // $ANTLR start "rule__Sequence__Group_2__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1040:1: rule__Sequence__Group_2__2__Impl : ( 'x' ) ;
    public final void rule__Sequence__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1044:1: ( ( 'x' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1045:1: ( 'x' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1045:1: ( 'x' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1046:1: 'x'
            {
             before(grammarAccess.getSequenceAccess().getXKeyword_2_2()); 
            match(input,18,FOLLOW_18_in_rule__Sequence__Group_2__2__Impl2202); 
             after(grammarAccess.getSequenceAccess().getXKeyword_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_2__2__Impl"


    // $ANTLR start "rule__Sequence__Group_3__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1065:1: rule__Sequence__Group_3__0 : rule__Sequence__Group_3__0__Impl rule__Sequence__Group_3__1 ;
    public final void rule__Sequence__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1069:1: ( rule__Sequence__Group_3__0__Impl rule__Sequence__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1070:2: rule__Sequence__Group_3__0__Impl rule__Sequence__Group_3__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_3__0__Impl_in_rule__Sequence__Group_3__02239);
            rule__Sequence__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_3__1_in_rule__Sequence__Group_3__02242);
            rule__Sequence__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_3__0"


    // $ANTLR start "rule__Sequence__Group_3__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1077:1: rule__Sequence__Group_3__0__Impl : ( 'x' ) ;
    public final void rule__Sequence__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1081:1: ( ( 'x' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1082:1: ( 'x' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1082:1: ( 'x' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1083:1: 'x'
            {
             before(grammarAccess.getSequenceAccess().getXKeyword_3_0()); 
            match(input,18,FOLLOW_18_in_rule__Sequence__Group_3__0__Impl2270); 
             after(grammarAccess.getSequenceAccess().getXKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_3__0__Impl"


    // $ANTLR start "rule__Sequence__Group_3__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1096:1: rule__Sequence__Group_3__1 : rule__Sequence__Group_3__1__Impl rule__Sequence__Group_3__2 ;
    public final void rule__Sequence__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1100:1: ( rule__Sequence__Group_3__1__Impl rule__Sequence__Group_3__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1101:2: rule__Sequence__Group_3__1__Impl rule__Sequence__Group_3__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_3__1__Impl_in_rule__Sequence__Group_3__12301);
            rule__Sequence__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_3__2_in_rule__Sequence__Group_3__12304);
            rule__Sequence__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_3__1"


    // $ANTLR start "rule__Sequence__Group_3__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1108:1: rule__Sequence__Group_3__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1112:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1113:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1113:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1114:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_3_1()); 
            match(input,17,FOLLOW_17_in_rule__Sequence__Group_3__1__Impl2332); 
             after(grammarAccess.getSequenceAccess().getLessThanSignKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_3__1__Impl"


    // $ANTLR start "rule__Sequence__Group_3__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1127:1: rule__Sequence__Group_3__2 : rule__Sequence__Group_3__2__Impl ;
    public final void rule__Sequence__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1131:1: ( rule__Sequence__Group_3__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1132:2: rule__Sequence__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_3__2__Impl_in_rule__Sequence__Group_3__22363);
            rule__Sequence__Group_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_3__2"


    // $ANTLR start "rule__Sequence__Group_3__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1138:1: rule__Sequence__Group_3__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1142:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1143:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1143:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1144:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_3_2()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_3__2__Impl2391); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_3__2__Impl"


    // $ANTLR start "rule__Sequence__Group_4__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1163:1: rule__Sequence__Group_4__0 : rule__Sequence__Group_4__0__Impl rule__Sequence__Group_4__1 ;
    public final void rule__Sequence__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1167:1: ( rule__Sequence__Group_4__0__Impl rule__Sequence__Group_4__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1168:2: rule__Sequence__Group_4__0__Impl rule__Sequence__Group_4__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__0__Impl_in_rule__Sequence__Group_4__02428);
            rule__Sequence__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_4__1_in_rule__Sequence__Group_4__02431);
            rule__Sequence__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_4__0"


    // $ANTLR start "rule__Sequence__Group_4__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1175:1: rule__Sequence__Group_4__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1179:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1180:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1180:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1181:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_4_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1182:1: ( '-' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==15) ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1==15) ) {
                        alt11=1;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1183:2: '-'
            	    {
            	    match(input,15,FOLLOW_15_in_rule__Sequence__Group_4__0__Impl2460); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_4__0__Impl"


    // $ANTLR start "rule__Sequence__Group_4__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1194:1: rule__Sequence__Group_4__1 : rule__Sequence__Group_4__1__Impl rule__Sequence__Group_4__2 ;
    public final void rule__Sequence__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1198:1: ( rule__Sequence__Group_4__1__Impl rule__Sequence__Group_4__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1199:2: rule__Sequence__Group_4__1__Impl rule__Sequence__Group_4__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__1__Impl_in_rule__Sequence__Group_4__12493);
            rule__Sequence__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_4__2_in_rule__Sequence__Group_4__12496);
            rule__Sequence__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_4__1"


    // $ANTLR start "rule__Sequence__Group_4__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1206:1: rule__Sequence__Group_4__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1210:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1211:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1211:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1212:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_4_1()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_4__1__Impl2524); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_4__1__Impl"


    // $ANTLR start "rule__Sequence__Group_4__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1225:1: rule__Sequence__Group_4__2 : rule__Sequence__Group_4__2__Impl rule__Sequence__Group_4__3 ;
    public final void rule__Sequence__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1229:1: ( rule__Sequence__Group_4__2__Impl rule__Sequence__Group_4__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1230:2: rule__Sequence__Group_4__2__Impl rule__Sequence__Group_4__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__2__Impl_in_rule__Sequence__Group_4__22555);
            rule__Sequence__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_4__3_in_rule__Sequence__Group_4__22558);
            rule__Sequence__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_4__2"


    // $ANTLR start "rule__Sequence__Group_4__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1237:1: rule__Sequence__Group_4__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1241:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1242:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1242:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1243:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4_2()); 
            match(input,16,FOLLOW_16_in_rule__Sequence__Group_4__2__Impl2586); 
             after(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_4__2__Impl"


    // $ANTLR start "rule__Sequence__Group_4__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1256:1: rule__Sequence__Group_4__3 : rule__Sequence__Group_4__3__Impl ;
    public final void rule__Sequence__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1260:1: ( rule__Sequence__Group_4__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1261:2: rule__Sequence__Group_4__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__3__Impl_in_rule__Sequence__Group_4__32617);
            rule__Sequence__Group_4__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_4__3"


    // $ANTLR start "rule__Sequence__Group_4__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1267:1: rule__Sequence__Group_4__3__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1271:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1272:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1272:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1273:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4_3()); 
            match(input,16,FOLLOW_16_in_rule__Sequence__Group_4__3__Impl2645); 
             after(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_4__3__Impl"


    // $ANTLR start "rule__Sequence__Group_5__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1294:1: rule__Sequence__Group_5__0 : rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1 ;
    public final void rule__Sequence__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1298:1: ( rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1299:2: rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__0__Impl_in_rule__Sequence__Group_5__02684);
            rule__Sequence__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_5__1_in_rule__Sequence__Group_5__02687);
            rule__Sequence__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_5__0"


    // $ANTLR start "rule__Sequence__Group_5__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1306:1: rule__Sequence__Group_5__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1310:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1311:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1311:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1312:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_5_0()); 
            match(input,17,FOLLOW_17_in_rule__Sequence__Group_5__0__Impl2715); 
             after(grammarAccess.getSequenceAccess().getLessThanSignKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_5__0__Impl"


    // $ANTLR start "rule__Sequence__Group_5__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1325:1: rule__Sequence__Group_5__1 : rule__Sequence__Group_5__1__Impl rule__Sequence__Group_5__2 ;
    public final void rule__Sequence__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1329:1: ( rule__Sequence__Group_5__1__Impl rule__Sequence__Group_5__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1330:2: rule__Sequence__Group_5__1__Impl rule__Sequence__Group_5__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__1__Impl_in_rule__Sequence__Group_5__12746);
            rule__Sequence__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_5__2_in_rule__Sequence__Group_5__12749);
            rule__Sequence__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_5__1"


    // $ANTLR start "rule__Sequence__Group_5__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1337:1: rule__Sequence__Group_5__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1341:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1342:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1342:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1343:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_5_1()); 
            match(input,17,FOLLOW_17_in_rule__Sequence__Group_5__1__Impl2777); 
             after(grammarAccess.getSequenceAccess().getLessThanSignKeyword_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_5__1__Impl"


    // $ANTLR start "rule__Sequence__Group_5__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1356:1: rule__Sequence__Group_5__2 : rule__Sequence__Group_5__2__Impl rule__Sequence__Group_5__3 ;
    public final void rule__Sequence__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1360:1: ( rule__Sequence__Group_5__2__Impl rule__Sequence__Group_5__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1361:2: rule__Sequence__Group_5__2__Impl rule__Sequence__Group_5__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__2__Impl_in_rule__Sequence__Group_5__22808);
            rule__Sequence__Group_5__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_5__3_in_rule__Sequence__Group_5__22811);
            rule__Sequence__Group_5__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_5__2"


    // $ANTLR start "rule__Sequence__Group_5__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1368:1: rule__Sequence__Group_5__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1372:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1373:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1373:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1374:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_5_2()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_5__2__Impl2839); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_5__2__Impl"


    // $ANTLR start "rule__Sequence__Group_5__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1387:1: rule__Sequence__Group_5__3 : rule__Sequence__Group_5__3__Impl ;
    public final void rule__Sequence__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1391:1: ( rule__Sequence__Group_5__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1392:2: rule__Sequence__Group_5__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__3__Impl_in_rule__Sequence__Group_5__32870);
            rule__Sequence__Group_5__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_5__3"


    // $ANTLR start "rule__Sequence__Group_5__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1398:1: rule__Sequence__Group_5__3__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1402:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1403:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1403:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1404:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_5_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1405:1: ( '-' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==15) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1406:2: '-'
            	    {
            	    match(input,15,FOLLOW_15_in_rule__Sequence__Group_5__3__Impl2899); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_5_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_5__3__Impl"


    // $ANTLR start "rule__Sequence__Group_6__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1425:1: rule__Sequence__Group_6__0 : rule__Sequence__Group_6__0__Impl rule__Sequence__Group_6__1 ;
    public final void rule__Sequence__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1429:1: ( rule__Sequence__Group_6__0__Impl rule__Sequence__Group_6__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1430:2: rule__Sequence__Group_6__0__Impl rule__Sequence__Group_6__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__0__Impl_in_rule__Sequence__Group_6__02940);
            rule__Sequence__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_6__1_in_rule__Sequence__Group_6__02943);
            rule__Sequence__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_6__0"


    // $ANTLR start "rule__Sequence__Group_6__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1437:1: rule__Sequence__Group_6__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1441:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1442:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1442:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1443:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_6_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1444:1: ( '-' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==15) ) {
                    int LA13_1 = input.LA(2);

                    if ( (LA13_1==15) ) {
                        alt13=1;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1445:2: '-'
            	    {
            	    match(input,15,FOLLOW_15_in_rule__Sequence__Group_6__0__Impl2972); 

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_6__0__Impl"


    // $ANTLR start "rule__Sequence__Group_6__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1456:1: rule__Sequence__Group_6__1 : rule__Sequence__Group_6__1__Impl rule__Sequence__Group_6__2 ;
    public final void rule__Sequence__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1460:1: ( rule__Sequence__Group_6__1__Impl rule__Sequence__Group_6__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1461:2: rule__Sequence__Group_6__1__Impl rule__Sequence__Group_6__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__1__Impl_in_rule__Sequence__Group_6__13005);
            rule__Sequence__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_6__2_in_rule__Sequence__Group_6__13008);
            rule__Sequence__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_6__1"


    // $ANTLR start "rule__Sequence__Group_6__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1468:1: rule__Sequence__Group_6__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1472:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1473:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1473:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1474:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_6_1()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_6__1__Impl3036); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_6__1__Impl"


    // $ANTLR start "rule__Sequence__Group_6__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1487:1: rule__Sequence__Group_6__2 : rule__Sequence__Group_6__2__Impl rule__Sequence__Group_6__3 ;
    public final void rule__Sequence__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1491:1: ( rule__Sequence__Group_6__2__Impl rule__Sequence__Group_6__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1492:2: rule__Sequence__Group_6__2__Impl rule__Sequence__Group_6__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__2__Impl_in_rule__Sequence__Group_6__23067);
            rule__Sequence__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_6__3_in_rule__Sequence__Group_6__23070);
            rule__Sequence__Group_6__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_6__2"


    // $ANTLR start "rule__Sequence__Group_6__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1499:1: rule__Sequence__Group_6__2__Impl : ( '\\\\' ) ;
    public final void rule__Sequence__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1503:1: ( ( '\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1504:1: ( '\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1504:1: ( '\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1505:1: '\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusKeyword_6_2()); 
            match(input,19,FOLLOW_19_in_rule__Sequence__Group_6__2__Impl3098); 
             after(grammarAccess.getSequenceAccess().getReverseSolidusKeyword_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_6__2__Impl"


    // $ANTLR start "rule__Sequence__Group_6__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1518:1: rule__Sequence__Group_6__3 : rule__Sequence__Group_6__3__Impl ;
    public final void rule__Sequence__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1522:1: ( rule__Sequence__Group_6__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1523:2: rule__Sequence__Group_6__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__3__Impl_in_rule__Sequence__Group_6__33129);
            rule__Sequence__Group_6__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_6__3"


    // $ANTLR start "rule__Sequence__Group_6__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1529:1: rule__Sequence__Group_6__3__Impl : ( '\\\\' ) ;
    public final void rule__Sequence__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1533:1: ( ( '\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1534:1: ( '\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1534:1: ( '\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1535:1: '\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusKeyword_6_3()); 
            match(input,19,FOLLOW_19_in_rule__Sequence__Group_6__3__Impl3157); 
             after(grammarAccess.getSequenceAccess().getReverseSolidusKeyword_6_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_6__3__Impl"


    // $ANTLR start "rule__Sequence__Group_7__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1556:1: rule__Sequence__Group_7__0 : rule__Sequence__Group_7__0__Impl rule__Sequence__Group_7__1 ;
    public final void rule__Sequence__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1560:1: ( rule__Sequence__Group_7__0__Impl rule__Sequence__Group_7__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1561:2: rule__Sequence__Group_7__0__Impl rule__Sequence__Group_7__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_7__0__Impl_in_rule__Sequence__Group_7__03196);
            rule__Sequence__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_7__1_in_rule__Sequence__Group_7__03199);
            rule__Sequence__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_7__0"


    // $ANTLR start "rule__Sequence__Group_7__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1568:1: rule__Sequence__Group_7__0__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1572:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1573:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1573:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1574:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_7_0()); 
            match(input,20,FOLLOW_20_in_rule__Sequence__Group_7__0__Impl3227); 
             after(grammarAccess.getSequenceAccess().getSolidusKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_7__0__Impl"


    // $ANTLR start "rule__Sequence__Group_7__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1587:1: rule__Sequence__Group_7__1 : rule__Sequence__Group_7__1__Impl rule__Sequence__Group_7__2 ;
    public final void rule__Sequence__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1591:1: ( rule__Sequence__Group_7__1__Impl rule__Sequence__Group_7__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1592:2: rule__Sequence__Group_7__1__Impl rule__Sequence__Group_7__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_7__1__Impl_in_rule__Sequence__Group_7__13258);
            rule__Sequence__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_7__2_in_rule__Sequence__Group_7__13261);
            rule__Sequence__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_7__1"


    // $ANTLR start "rule__Sequence__Group_7__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1599:1: rule__Sequence__Group_7__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1603:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1604:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1604:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1605:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_7_1()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_7__1__Impl3289); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_7__1__Impl"


    // $ANTLR start "rule__Sequence__Group_7__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1618:1: rule__Sequence__Group_7__2 : rule__Sequence__Group_7__2__Impl ;
    public final void rule__Sequence__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1622:1: ( rule__Sequence__Group_7__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1623:2: rule__Sequence__Group_7__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_7__2__Impl_in_rule__Sequence__Group_7__23320);
            rule__Sequence__Group_7__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_7__2"


    // $ANTLR start "rule__Sequence__Group_7__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1629:1: rule__Sequence__Group_7__2__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1633:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1634:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1634:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1635:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_7_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1636:1: ( '-' )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==15) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1637:2: '-'
            	    {
            	    match(input,15,FOLLOW_15_in_rule__Sequence__Group_7__2__Impl3349); 

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_7__2__Impl"


    // $ANTLR start "rule__Sequence__Group_8__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1654:1: rule__Sequence__Group_8__0 : rule__Sequence__Group_8__0__Impl rule__Sequence__Group_8__1 ;
    public final void rule__Sequence__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1658:1: ( rule__Sequence__Group_8__0__Impl rule__Sequence__Group_8__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1659:2: rule__Sequence__Group_8__0__Impl rule__Sequence__Group_8__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_8__0__Impl_in_rule__Sequence__Group_8__03388);
            rule__Sequence__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_8__1_in_rule__Sequence__Group_8__03391);
            rule__Sequence__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_8__0"


    // $ANTLR start "rule__Sequence__Group_8__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1666:1: rule__Sequence__Group_8__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1670:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1671:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1671:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1672:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_8_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1673:1: ( '-' )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==15) ) {
                    int LA15_1 = input.LA(2);

                    if ( (LA15_1==15) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1674:2: '-'
            	    {
            	    match(input,15,FOLLOW_15_in_rule__Sequence__Group_8__0__Impl3420); 

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_8__0__Impl"


    // $ANTLR start "rule__Sequence__Group_8__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1685:1: rule__Sequence__Group_8__1 : rule__Sequence__Group_8__1__Impl rule__Sequence__Group_8__2 ;
    public final void rule__Sequence__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1689:1: ( rule__Sequence__Group_8__1__Impl rule__Sequence__Group_8__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1690:2: rule__Sequence__Group_8__1__Impl rule__Sequence__Group_8__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_8__1__Impl_in_rule__Sequence__Group_8__13453);
            rule__Sequence__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_8__2_in_rule__Sequence__Group_8__13456);
            rule__Sequence__Group_8__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_8__1"


    // $ANTLR start "rule__Sequence__Group_8__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1697:1: rule__Sequence__Group_8__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1701:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1702:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1702:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1703:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_8_1()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_8__1__Impl3484); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_8__1__Impl"


    // $ANTLR start "rule__Sequence__Group_8__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1716:1: rule__Sequence__Group_8__2 : rule__Sequence__Group_8__2__Impl ;
    public final void rule__Sequence__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1720:1: ( rule__Sequence__Group_8__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1721:2: rule__Sequence__Group_8__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_8__2__Impl_in_rule__Sequence__Group_8__23515);
            rule__Sequence__Group_8__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_8__2"


    // $ANTLR start "rule__Sequence__Group_8__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1727:1: rule__Sequence__Group_8__2__Impl : ( '\\\\\\\\' ) ;
    public final void rule__Sequence__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1731:1: ( ( '\\\\\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1732:1: ( '\\\\\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1732:1: ( '\\\\\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1733:1: '\\\\\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusReverseSolidusKeyword_8_2()); 
            match(input,21,FOLLOW_21_in_rule__Sequence__Group_8__2__Impl3543); 
             after(grammarAccess.getSequenceAccess().getReverseSolidusReverseSolidusKeyword_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_8__2__Impl"


    // $ANTLR start "rule__Sequence__Group_9__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1752:1: rule__Sequence__Group_9__0 : rule__Sequence__Group_9__0__Impl rule__Sequence__Group_9__1 ;
    public final void rule__Sequence__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1756:1: ( rule__Sequence__Group_9__0__Impl rule__Sequence__Group_9__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1757:2: rule__Sequence__Group_9__0__Impl rule__Sequence__Group_9__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__0__Impl_in_rule__Sequence__Group_9__03580);
            rule__Sequence__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_9__1_in_rule__Sequence__Group_9__03583);
            rule__Sequence__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_9__0"


    // $ANTLR start "rule__Sequence__Group_9__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1764:1: rule__Sequence__Group_9__0__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1768:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1769:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1769:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1770:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_9_0()); 
            match(input,20,FOLLOW_20_in_rule__Sequence__Group_9__0__Impl3611); 
             after(grammarAccess.getSequenceAccess().getSolidusKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_9__0__Impl"


    // $ANTLR start "rule__Sequence__Group_9__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1783:1: rule__Sequence__Group_9__1 : rule__Sequence__Group_9__1__Impl rule__Sequence__Group_9__2 ;
    public final void rule__Sequence__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1787:1: ( rule__Sequence__Group_9__1__Impl rule__Sequence__Group_9__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1788:2: rule__Sequence__Group_9__1__Impl rule__Sequence__Group_9__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__1__Impl_in_rule__Sequence__Group_9__13642);
            rule__Sequence__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_9__2_in_rule__Sequence__Group_9__13645);
            rule__Sequence__Group_9__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_9__1"


    // $ANTLR start "rule__Sequence__Group_9__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1795:1: rule__Sequence__Group_9__1__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1799:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1800:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1800:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1801:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_9_1()); 
            match(input,20,FOLLOW_20_in_rule__Sequence__Group_9__1__Impl3673); 
             after(grammarAccess.getSequenceAccess().getSolidusKeyword_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_9__1__Impl"


    // $ANTLR start "rule__Sequence__Group_9__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1814:1: rule__Sequence__Group_9__2 : rule__Sequence__Group_9__2__Impl rule__Sequence__Group_9__3 ;
    public final void rule__Sequence__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1818:1: ( rule__Sequence__Group_9__2__Impl rule__Sequence__Group_9__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1819:2: rule__Sequence__Group_9__2__Impl rule__Sequence__Group_9__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__2__Impl_in_rule__Sequence__Group_9__23704);
            rule__Sequence__Group_9__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_9__3_in_rule__Sequence__Group_9__23707);
            rule__Sequence__Group_9__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_9__2"


    // $ANTLR start "rule__Sequence__Group_9__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1826:1: rule__Sequence__Group_9__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1830:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1831:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1831:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1832:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_9_2()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_9__2__Impl3735); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_9_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_9__2__Impl"


    // $ANTLR start "rule__Sequence__Group_9__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1845:1: rule__Sequence__Group_9__3 : rule__Sequence__Group_9__3__Impl ;
    public final void rule__Sequence__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1849:1: ( rule__Sequence__Group_9__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1850:2: rule__Sequence__Group_9__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__3__Impl_in_rule__Sequence__Group_9__33766);
            rule__Sequence__Group_9__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_9__3"


    // $ANTLR start "rule__Sequence__Group_9__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1856:1: rule__Sequence__Group_9__3__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1860:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1861:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1861:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1862:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_9_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1863:1: ( '-' )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==15) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1864:2: '-'
            	    {
            	    match(input,15,FOLLOW_15_in_rule__Sequence__Group_9__3__Impl3795); 

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_9_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_9__3__Impl"


    // $ANTLR start "rule__Sequence__Group_10__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1883:1: rule__Sequence__Group_10__0 : rule__Sequence__Group_10__0__Impl rule__Sequence__Group_10__1 ;
    public final void rule__Sequence__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1887:1: ( rule__Sequence__Group_10__0__Impl rule__Sequence__Group_10__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1888:2: rule__Sequence__Group_10__0__Impl rule__Sequence__Group_10__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__0__Impl_in_rule__Sequence__Group_10__03836);
            rule__Sequence__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_10__1_in_rule__Sequence__Group_10__03839);
            rule__Sequence__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_10__0"


    // $ANTLR start "rule__Sequence__Group_10__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1895:1: rule__Sequence__Group_10__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1899:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1900:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1900:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1901:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_10_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1902:1: ( '-' )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==15) ) {
                    int LA17_1 = input.LA(2);

                    if ( (LA17_1==15) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1903:2: '-'
            	    {
            	    match(input,15,FOLLOW_15_in_rule__Sequence__Group_10__0__Impl3868); 

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_10__0__Impl"


    // $ANTLR start "rule__Sequence__Group_10__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1914:1: rule__Sequence__Group_10__1 : rule__Sequence__Group_10__1__Impl rule__Sequence__Group_10__2 ;
    public final void rule__Sequence__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1918:1: ( rule__Sequence__Group_10__1__Impl rule__Sequence__Group_10__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1919:2: rule__Sequence__Group_10__1__Impl rule__Sequence__Group_10__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__1__Impl_in_rule__Sequence__Group_10__13901);
            rule__Sequence__Group_10__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_10__2_in_rule__Sequence__Group_10__13904);
            rule__Sequence__Group_10__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_10__1"


    // $ANTLR start "rule__Sequence__Group_10__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1926:1: rule__Sequence__Group_10__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1930:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1931:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1931:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1932:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_10_1()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_10__1__Impl3932); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_10__1__Impl"


    // $ANTLR start "rule__Sequence__Group_10__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1945:1: rule__Sequence__Group_10__2 : rule__Sequence__Group_10__2__Impl rule__Sequence__Group_10__3 ;
    public final void rule__Sequence__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1949:1: ( rule__Sequence__Group_10__2__Impl rule__Sequence__Group_10__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1950:2: rule__Sequence__Group_10__2__Impl rule__Sequence__Group_10__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__2__Impl_in_rule__Sequence__Group_10__23963);
            rule__Sequence__Group_10__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_10__3_in_rule__Sequence__Group_10__23966);
            rule__Sequence__Group_10__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_10__2"


    // $ANTLR start "rule__Sequence__Group_10__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1957:1: rule__Sequence__Group_10__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1961:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1962:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1962:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1963:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_10_2()); 
            match(input,16,FOLLOW_16_in_rule__Sequence__Group_10__2__Impl3994); 
             after(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_10_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_10__2__Impl"


    // $ANTLR start "rule__Sequence__Group_10__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1976:1: rule__Sequence__Group_10__3 : rule__Sequence__Group_10__3__Impl ;
    public final void rule__Sequence__Group_10__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1980:1: ( rule__Sequence__Group_10__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1981:2: rule__Sequence__Group_10__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__3__Impl_in_rule__Sequence__Group_10__34025);
            rule__Sequence__Group_10__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_10__3"


    // $ANTLR start "rule__Sequence__Group_10__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1987:1: rule__Sequence__Group_10__3__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_10__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1991:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1992:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1992:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1993:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_10_3()); 
            match(input,22,FOLLOW_22_in_rule__Sequence__Group_10__3__Impl4053); 
             after(grammarAccess.getSequenceAccess().getOKeyword_10_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_10__3__Impl"


    // $ANTLR start "rule__Sequence__Group_11__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2014:1: rule__Sequence__Group_11__0 : rule__Sequence__Group_11__0__Impl rule__Sequence__Group_11__1 ;
    public final void rule__Sequence__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2018:1: ( rule__Sequence__Group_11__0__Impl rule__Sequence__Group_11__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2019:2: rule__Sequence__Group_11__0__Impl rule__Sequence__Group_11__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__0__Impl_in_rule__Sequence__Group_11__04092);
            rule__Sequence__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_11__1_in_rule__Sequence__Group_11__04095);
            rule__Sequence__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_11__0"


    // $ANTLR start "rule__Sequence__Group_11__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2026:1: rule__Sequence__Group_11__0__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2030:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2031:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2031:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2032:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_11_0()); 
            match(input,22,FOLLOW_22_in_rule__Sequence__Group_11__0__Impl4123); 
             after(grammarAccess.getSequenceAccess().getOKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_11__0__Impl"


    // $ANTLR start "rule__Sequence__Group_11__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2045:1: rule__Sequence__Group_11__1 : rule__Sequence__Group_11__1__Impl rule__Sequence__Group_11__2 ;
    public final void rule__Sequence__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2049:1: ( rule__Sequence__Group_11__1__Impl rule__Sequence__Group_11__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2050:2: rule__Sequence__Group_11__1__Impl rule__Sequence__Group_11__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__1__Impl_in_rule__Sequence__Group_11__14154);
            rule__Sequence__Group_11__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_11__2_in_rule__Sequence__Group_11__14157);
            rule__Sequence__Group_11__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_11__1"


    // $ANTLR start "rule__Sequence__Group_11__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2057:1: rule__Sequence__Group_11__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2061:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2062:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2062:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2063:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_11_1()); 
            match(input,17,FOLLOW_17_in_rule__Sequence__Group_11__1__Impl4185); 
             after(grammarAccess.getSequenceAccess().getLessThanSignKeyword_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_11__1__Impl"


    // $ANTLR start "rule__Sequence__Group_11__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2076:1: rule__Sequence__Group_11__2 : rule__Sequence__Group_11__2__Impl rule__Sequence__Group_11__3 ;
    public final void rule__Sequence__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2080:1: ( rule__Sequence__Group_11__2__Impl rule__Sequence__Group_11__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2081:2: rule__Sequence__Group_11__2__Impl rule__Sequence__Group_11__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__2__Impl_in_rule__Sequence__Group_11__24216);
            rule__Sequence__Group_11__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_11__3_in_rule__Sequence__Group_11__24219);
            rule__Sequence__Group_11__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_11__2"


    // $ANTLR start "rule__Sequence__Group_11__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2088:1: rule__Sequence__Group_11__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2092:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2093:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2093:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2094:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_11_2()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_11__2__Impl4247); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_11_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_11__2__Impl"


    // $ANTLR start "rule__Sequence__Group_11__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2107:1: rule__Sequence__Group_11__3 : rule__Sequence__Group_11__3__Impl ;
    public final void rule__Sequence__Group_11__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2111:1: ( rule__Sequence__Group_11__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2112:2: rule__Sequence__Group_11__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__3__Impl_in_rule__Sequence__Group_11__34278);
            rule__Sequence__Group_11__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_11__3"


    // $ANTLR start "rule__Sequence__Group_11__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2118:1: rule__Sequence__Group_11__3__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_11__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2122:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2123:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2123:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2124:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_11_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2125:1: ( '-' )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==15) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2126:2: '-'
            	    {
            	    match(input,15,FOLLOW_15_in_rule__Sequence__Group_11__3__Impl4307); 

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_11_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_11__3__Impl"


    // $ANTLR start "rule__Sequence__Group_12__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2145:1: rule__Sequence__Group_12__0 : rule__Sequence__Group_12__0__Impl rule__Sequence__Group_12__1 ;
    public final void rule__Sequence__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2149:1: ( rule__Sequence__Group_12__0__Impl rule__Sequence__Group_12__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2150:2: rule__Sequence__Group_12__0__Impl rule__Sequence__Group_12__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__0__Impl_in_rule__Sequence__Group_12__04348);
            rule__Sequence__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__1_in_rule__Sequence__Group_12__04351);
            rule__Sequence__Group_12__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_12__0"


    // $ANTLR start "rule__Sequence__Group_12__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2157:1: rule__Sequence__Group_12__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2161:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2162:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2162:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2163:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2164:1: ( '-' )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==15) ) {
                    int LA19_1 = input.LA(2);

                    if ( (LA19_1==15) ) {
                        int LA19_2 = input.LA(3);

                        if ( (LA19_2==15) ) {
                            alt19=1;
                        }


                    }


                }


                switch (alt19) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2165:2: '-'
            	    {
            	    match(input,15,FOLLOW_15_in_rule__Sequence__Group_12__0__Impl4380); 

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_12__0__Impl"


    // $ANTLR start "rule__Sequence__Group_12__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2176:1: rule__Sequence__Group_12__1 : rule__Sequence__Group_12__1__Impl rule__Sequence__Group_12__2 ;
    public final void rule__Sequence__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2180:1: ( rule__Sequence__Group_12__1__Impl rule__Sequence__Group_12__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2181:2: rule__Sequence__Group_12__1__Impl rule__Sequence__Group_12__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__1__Impl_in_rule__Sequence__Group_12__14413);
            rule__Sequence__Group_12__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__2_in_rule__Sequence__Group_12__14416);
            rule__Sequence__Group_12__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_12__1"


    // $ANTLR start "rule__Sequence__Group_12__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2188:1: rule__Sequence__Group_12__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2192:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2193:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2193:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2194:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_1()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_12__1__Impl4444); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_12__1__Impl"


    // $ANTLR start "rule__Sequence__Group_12__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2207:1: rule__Sequence__Group_12__2 : rule__Sequence__Group_12__2__Impl rule__Sequence__Group_12__3 ;
    public final void rule__Sequence__Group_12__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2211:1: ( rule__Sequence__Group_12__2__Impl rule__Sequence__Group_12__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2212:2: rule__Sequence__Group_12__2__Impl rule__Sequence__Group_12__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__2__Impl_in_rule__Sequence__Group_12__24475);
            rule__Sequence__Group_12__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__3_in_rule__Sequence__Group_12__24478);
            rule__Sequence__Group_12__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_12__2"


    // $ANTLR start "rule__Sequence__Group_12__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2219:1: rule__Sequence__Group_12__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_12__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2223:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2224:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2224:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2225:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_2()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_12__2__Impl4506); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_12__2__Impl"


    // $ANTLR start "rule__Sequence__Group_12__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2238:1: rule__Sequence__Group_12__3 : rule__Sequence__Group_12__3__Impl rule__Sequence__Group_12__4 ;
    public final void rule__Sequence__Group_12__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2242:1: ( rule__Sequence__Group_12__3__Impl rule__Sequence__Group_12__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2243:2: rule__Sequence__Group_12__3__Impl rule__Sequence__Group_12__4
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__3__Impl_in_rule__Sequence__Group_12__34537);
            rule__Sequence__Group_12__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__4_in_rule__Sequence__Group_12__34540);
            rule__Sequence__Group_12__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_12__3"


    // $ANTLR start "rule__Sequence__Group_12__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2250:1: rule__Sequence__Group_12__3__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_12__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2254:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2255:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2255:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2256:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_12_3()); 
            match(input,20,FOLLOW_20_in_rule__Sequence__Group_12__3__Impl4568); 
             after(grammarAccess.getSequenceAccess().getSolidusKeyword_12_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_12__3__Impl"


    // $ANTLR start "rule__Sequence__Group_12__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2269:1: rule__Sequence__Group_12__4 : rule__Sequence__Group_12__4__Impl rule__Sequence__Group_12__5 ;
    public final void rule__Sequence__Group_12__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2273:1: ( rule__Sequence__Group_12__4__Impl rule__Sequence__Group_12__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2274:2: rule__Sequence__Group_12__4__Impl rule__Sequence__Group_12__5
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__4__Impl_in_rule__Sequence__Group_12__44599);
            rule__Sequence__Group_12__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__5_in_rule__Sequence__Group_12__44602);
            rule__Sequence__Group_12__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_12__4"


    // $ANTLR start "rule__Sequence__Group_12__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2281:1: rule__Sequence__Group_12__4__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_12__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2285:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2286:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2286:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2287:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_12_4()); 
            match(input,20,FOLLOW_20_in_rule__Sequence__Group_12__4__Impl4630); 
             after(grammarAccess.getSequenceAccess().getSolidusKeyword_12_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_12__4__Impl"


    // $ANTLR start "rule__Sequence__Group_12__5"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2300:1: rule__Sequence__Group_12__5 : rule__Sequence__Group_12__5__Impl ;
    public final void rule__Sequence__Group_12__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2304:1: ( rule__Sequence__Group_12__5__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2305:2: rule__Sequence__Group_12__5__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__5__Impl_in_rule__Sequence__Group_12__54661);
            rule__Sequence__Group_12__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_12__5"


    // $ANTLR start "rule__Sequence__Group_12__5__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2311:1: rule__Sequence__Group_12__5__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_12__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2315:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2316:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2316:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2317:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_12_5()); 
            match(input,22,FOLLOW_22_in_rule__Sequence__Group_12__5__Impl4689); 
             after(grammarAccess.getSequenceAccess().getOKeyword_12_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_12__5__Impl"


    // $ANTLR start "rule__Sequence__Group_13__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2342:1: rule__Sequence__Group_13__0 : rule__Sequence__Group_13__0__Impl rule__Sequence__Group_13__1 ;
    public final void rule__Sequence__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2346:1: ( rule__Sequence__Group_13__0__Impl rule__Sequence__Group_13__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2347:2: rule__Sequence__Group_13__0__Impl rule__Sequence__Group_13__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__0__Impl_in_rule__Sequence__Group_13__04732);
            rule__Sequence__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__1_in_rule__Sequence__Group_13__04735);
            rule__Sequence__Group_13__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_13__0"


    // $ANTLR start "rule__Sequence__Group_13__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2354:1: rule__Sequence__Group_13__0__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2358:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2359:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2359:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2360:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_13_0()); 
            match(input,22,FOLLOW_22_in_rule__Sequence__Group_13__0__Impl4763); 
             after(grammarAccess.getSequenceAccess().getOKeyword_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_13__0__Impl"


    // $ANTLR start "rule__Sequence__Group_13__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2373:1: rule__Sequence__Group_13__1 : rule__Sequence__Group_13__1__Impl rule__Sequence__Group_13__2 ;
    public final void rule__Sequence__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2377:1: ( rule__Sequence__Group_13__1__Impl rule__Sequence__Group_13__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2378:2: rule__Sequence__Group_13__1__Impl rule__Sequence__Group_13__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__1__Impl_in_rule__Sequence__Group_13__14794);
            rule__Sequence__Group_13__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__2_in_rule__Sequence__Group_13__14797);
            rule__Sequence__Group_13__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_13__1"


    // $ANTLR start "rule__Sequence__Group_13__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2385:1: rule__Sequence__Group_13__1__Impl : ( '\\\\\\\\' ) ;
    public final void rule__Sequence__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2389:1: ( ( '\\\\\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2390:1: ( '\\\\\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2390:1: ( '\\\\\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2391:1: '\\\\\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusReverseSolidusKeyword_13_1()); 
            match(input,21,FOLLOW_21_in_rule__Sequence__Group_13__1__Impl4825); 
             after(grammarAccess.getSequenceAccess().getReverseSolidusReverseSolidusKeyword_13_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_13__1__Impl"


    // $ANTLR start "rule__Sequence__Group_13__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2404:1: rule__Sequence__Group_13__2 : rule__Sequence__Group_13__2__Impl rule__Sequence__Group_13__3 ;
    public final void rule__Sequence__Group_13__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2408:1: ( rule__Sequence__Group_13__2__Impl rule__Sequence__Group_13__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2409:2: rule__Sequence__Group_13__2__Impl rule__Sequence__Group_13__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__2__Impl_in_rule__Sequence__Group_13__24856);
            rule__Sequence__Group_13__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__3_in_rule__Sequence__Group_13__24859);
            rule__Sequence__Group_13__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_13__2"


    // $ANTLR start "rule__Sequence__Group_13__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2416:1: rule__Sequence__Group_13__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_13__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2420:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2421:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2421:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2422:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_2()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_13__2__Impl4887); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_13__2__Impl"


    // $ANTLR start "rule__Sequence__Group_13__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2435:1: rule__Sequence__Group_13__3 : rule__Sequence__Group_13__3__Impl rule__Sequence__Group_13__4 ;
    public final void rule__Sequence__Group_13__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2439:1: ( rule__Sequence__Group_13__3__Impl rule__Sequence__Group_13__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2440:2: rule__Sequence__Group_13__3__Impl rule__Sequence__Group_13__4
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__3__Impl_in_rule__Sequence__Group_13__34918);
            rule__Sequence__Group_13__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__4_in_rule__Sequence__Group_13__34921);
            rule__Sequence__Group_13__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_13__3"


    // $ANTLR start "rule__Sequence__Group_13__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2447:1: rule__Sequence__Group_13__3__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_13__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2451:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2452:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2452:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2453:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_3()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_13__3__Impl4949); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_13__3__Impl"


    // $ANTLR start "rule__Sequence__Group_13__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2466:1: rule__Sequence__Group_13__4 : rule__Sequence__Group_13__4__Impl ;
    public final void rule__Sequence__Group_13__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2470:1: ( rule__Sequence__Group_13__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2471:2: rule__Sequence__Group_13__4__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__4__Impl_in_rule__Sequence__Group_13__44980);
            rule__Sequence__Group_13__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_13__4"


    // $ANTLR start "rule__Sequence__Group_13__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2477:1: rule__Sequence__Group_13__4__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_13__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2481:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2482:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2482:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2483:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2484:1: ( '-' )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==15) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2485:2: '-'
            	    {
            	    match(input,15,FOLLOW_15_in_rule__Sequence__Group_13__4__Impl5009); 

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_13__4__Impl"


    // $ANTLR start "rule__Sequence__Group_14__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2506:1: rule__Sequence__Group_14__0 : rule__Sequence__Group_14__0__Impl rule__Sequence__Group_14__1 ;
    public final void rule__Sequence__Group_14__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2510:1: ( rule__Sequence__Group_14__0__Impl rule__Sequence__Group_14__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2511:2: rule__Sequence__Group_14__0__Impl rule__Sequence__Group_14__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_14__0__Impl_in_rule__Sequence__Group_14__05052);
            rule__Sequence__Group_14__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_14__1_in_rule__Sequence__Group_14__05055);
            rule__Sequence__Group_14__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_14__0"


    // $ANTLR start "rule__Sequence__Group_14__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2518:1: rule__Sequence__Group_14__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_14__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2522:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2523:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2523:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2524:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_14_0()); 
            match(input,17,FOLLOW_17_in_rule__Sequence__Group_14__0__Impl5083); 
             after(grammarAccess.getSequenceAccess().getLessThanSignKeyword_14_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_14__0__Impl"


    // $ANTLR start "rule__Sequence__Group_14__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2537:1: rule__Sequence__Group_14__1 : rule__Sequence__Group_14__1__Impl rule__Sequence__Group_14__2 ;
    public final void rule__Sequence__Group_14__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2541:1: ( rule__Sequence__Group_14__1__Impl rule__Sequence__Group_14__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2542:2: rule__Sequence__Group_14__1__Impl rule__Sequence__Group_14__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_14__1__Impl_in_rule__Sequence__Group_14__15114);
            rule__Sequence__Group_14__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_14__2_in_rule__Sequence__Group_14__15117);
            rule__Sequence__Group_14__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_14__1"


    // $ANTLR start "rule__Sequence__Group_14__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2549:1: rule__Sequence__Group_14__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_14__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2553:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2554:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2554:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2555:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_14_1()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_14__1__Impl5145); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_14_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_14__1__Impl"


    // $ANTLR start "rule__Sequence__Group_14__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2568:1: rule__Sequence__Group_14__2 : rule__Sequence__Group_14__2__Impl ;
    public final void rule__Sequence__Group_14__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2572:1: ( rule__Sequence__Group_14__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2573:2: rule__Sequence__Group_14__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_14__2__Impl_in_rule__Sequence__Group_14__25176);
            rule__Sequence__Group_14__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_14__2"


    // $ANTLR start "rule__Sequence__Group_14__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2579:1: rule__Sequence__Group_14__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_14__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2583:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2584:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2584:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2585:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_14_2()); 
            match(input,16,FOLLOW_16_in_rule__Sequence__Group_14__2__Impl5204); 
             after(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_14_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_14__2__Impl"


    // $ANTLR start "rule__Sequence__Group_15__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2604:1: rule__Sequence__Group_15__0 : rule__Sequence__Group_15__0__Impl rule__Sequence__Group_15__1 ;
    public final void rule__Sequence__Group_15__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2608:1: ( rule__Sequence__Group_15__0__Impl rule__Sequence__Group_15__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2609:2: rule__Sequence__Group_15__0__Impl rule__Sequence__Group_15__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__0__Impl_in_rule__Sequence__Group_15__05241);
            rule__Sequence__Group_15__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_15__1_in_rule__Sequence__Group_15__05244);
            rule__Sequence__Group_15__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_15__0"


    // $ANTLR start "rule__Sequence__Group_15__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2616:1: rule__Sequence__Group_15__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_15__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2620:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2621:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2621:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2622:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_15_0()); 
            match(input,17,FOLLOW_17_in_rule__Sequence__Group_15__0__Impl5272); 
             after(grammarAccess.getSequenceAccess().getLessThanSignKeyword_15_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_15__0__Impl"


    // $ANTLR start "rule__Sequence__Group_15__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2635:1: rule__Sequence__Group_15__1 : rule__Sequence__Group_15__1__Impl rule__Sequence__Group_15__2 ;
    public final void rule__Sequence__Group_15__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2639:1: ( rule__Sequence__Group_15__1__Impl rule__Sequence__Group_15__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2640:2: rule__Sequence__Group_15__1__Impl rule__Sequence__Group_15__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__1__Impl_in_rule__Sequence__Group_15__15303);
            rule__Sequence__Group_15__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_15__2_in_rule__Sequence__Group_15__15306);
            rule__Sequence__Group_15__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_15__1"


    // $ANTLR start "rule__Sequence__Group_15__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2647:1: rule__Sequence__Group_15__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_15__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2651:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2652:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2652:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2653:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_15_1()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_15__1__Impl5334); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_15_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_15__1__Impl"


    // $ANTLR start "rule__Sequence__Group_15__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2666:1: rule__Sequence__Group_15__2 : rule__Sequence__Group_15__2__Impl rule__Sequence__Group_15__3 ;
    public final void rule__Sequence__Group_15__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2670:1: ( rule__Sequence__Group_15__2__Impl rule__Sequence__Group_15__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2671:2: rule__Sequence__Group_15__2__Impl rule__Sequence__Group_15__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__2__Impl_in_rule__Sequence__Group_15__25365);
            rule__Sequence__Group_15__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_15__3_in_rule__Sequence__Group_15__25368);
            rule__Sequence__Group_15__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_15__2"


    // $ANTLR start "rule__Sequence__Group_15__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2678:1: rule__Sequence__Group_15__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_15__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2682:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2683:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2683:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2684:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_15_2()); 
            match(input,16,FOLLOW_16_in_rule__Sequence__Group_15__2__Impl5396); 
             after(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_15_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_15__2__Impl"


    // $ANTLR start "rule__Sequence__Group_15__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2697:1: rule__Sequence__Group_15__3 : rule__Sequence__Group_15__3__Impl ;
    public final void rule__Sequence__Group_15__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2701:1: ( rule__Sequence__Group_15__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2702:2: rule__Sequence__Group_15__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__3__Impl_in_rule__Sequence__Group_15__35427);
            rule__Sequence__Group_15__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_15__3"


    // $ANTLR start "rule__Sequence__Group_15__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2708:1: rule__Sequence__Group_15__3__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_15__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2712:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2713:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2713:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2714:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_15_3()); 
            match(input,22,FOLLOW_22_in_rule__Sequence__Group_15__3__Impl5455); 
             after(grammarAccess.getSequenceAccess().getOKeyword_15_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_15__3__Impl"


    // $ANTLR start "rule__Sequence__Group_16__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2735:1: rule__Sequence__Group_16__0 : rule__Sequence__Group_16__0__Impl rule__Sequence__Group_16__1 ;
    public final void rule__Sequence__Group_16__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2739:1: ( rule__Sequence__Group_16__0__Impl rule__Sequence__Group_16__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2740:2: rule__Sequence__Group_16__0__Impl rule__Sequence__Group_16__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__0__Impl_in_rule__Sequence__Group_16__05494);
            rule__Sequence__Group_16__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_16__1_in_rule__Sequence__Group_16__05497);
            rule__Sequence__Group_16__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_16__0"


    // $ANTLR start "rule__Sequence__Group_16__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2747:1: rule__Sequence__Group_16__0__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_16__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2751:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2752:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2752:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2753:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_16_0()); 
            match(input,22,FOLLOW_22_in_rule__Sequence__Group_16__0__Impl5525); 
             after(grammarAccess.getSequenceAccess().getOKeyword_16_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_16__0__Impl"


    // $ANTLR start "rule__Sequence__Group_16__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2766:1: rule__Sequence__Group_16__1 : rule__Sequence__Group_16__1__Impl rule__Sequence__Group_16__2 ;
    public final void rule__Sequence__Group_16__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2770:1: ( rule__Sequence__Group_16__1__Impl rule__Sequence__Group_16__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2771:2: rule__Sequence__Group_16__1__Impl rule__Sequence__Group_16__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__1__Impl_in_rule__Sequence__Group_16__15556);
            rule__Sequence__Group_16__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_16__2_in_rule__Sequence__Group_16__15559);
            rule__Sequence__Group_16__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_16__1"


    // $ANTLR start "rule__Sequence__Group_16__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2778:1: rule__Sequence__Group_16__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_16__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2782:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2783:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2783:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2784:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_16_1()); 
            match(input,17,FOLLOW_17_in_rule__Sequence__Group_16__1__Impl5587); 
             after(grammarAccess.getSequenceAccess().getLessThanSignKeyword_16_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_16__1__Impl"


    // $ANTLR start "rule__Sequence__Group_16__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2797:1: rule__Sequence__Group_16__2 : rule__Sequence__Group_16__2__Impl rule__Sequence__Group_16__3 ;
    public final void rule__Sequence__Group_16__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2801:1: ( rule__Sequence__Group_16__2__Impl rule__Sequence__Group_16__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2802:2: rule__Sequence__Group_16__2__Impl rule__Sequence__Group_16__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__2__Impl_in_rule__Sequence__Group_16__25618);
            rule__Sequence__Group_16__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_16__3_in_rule__Sequence__Group_16__25621);
            rule__Sequence__Group_16__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_16__2"


    // $ANTLR start "rule__Sequence__Group_16__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2809:1: rule__Sequence__Group_16__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_16__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2813:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2814:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2814:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2815:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_16_2()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_16__2__Impl5649); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_16_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_16__2__Impl"


    // $ANTLR start "rule__Sequence__Group_16__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2828:1: rule__Sequence__Group_16__3 : rule__Sequence__Group_16__3__Impl ;
    public final void rule__Sequence__Group_16__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2832:1: ( rule__Sequence__Group_16__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2833:2: rule__Sequence__Group_16__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__3__Impl_in_rule__Sequence__Group_16__35680);
            rule__Sequence__Group_16__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_16__3"


    // $ANTLR start "rule__Sequence__Group_16__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2839:1: rule__Sequence__Group_16__3__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_16__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2843:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2844:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2844:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2845:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_16_3()); 
            match(input,16,FOLLOW_16_in_rule__Sequence__Group_16__3__Impl5708); 
             after(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_16_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_16__3__Impl"


    // $ANTLR start "rule__Sequence__Group_17__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2866:1: rule__Sequence__Group_17__0 : rule__Sequence__Group_17__0__Impl rule__Sequence__Group_17__1 ;
    public final void rule__Sequence__Group_17__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2870:1: ( rule__Sequence__Group_17__0__Impl rule__Sequence__Group_17__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2871:2: rule__Sequence__Group_17__0__Impl rule__Sequence__Group_17__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__0__Impl_in_rule__Sequence__Group_17__05747);
            rule__Sequence__Group_17__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_17__1_in_rule__Sequence__Group_17__05750);
            rule__Sequence__Group_17__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_17__0"


    // $ANTLR start "rule__Sequence__Group_17__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2878:1: rule__Sequence__Group_17__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_17__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2882:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2883:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2883:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2884:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_17_0()); 
            match(input,17,FOLLOW_17_in_rule__Sequence__Group_17__0__Impl5778); 
             after(grammarAccess.getSequenceAccess().getLessThanSignKeyword_17_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_17__0__Impl"


    // $ANTLR start "rule__Sequence__Group_17__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2897:1: rule__Sequence__Group_17__1 : rule__Sequence__Group_17__1__Impl rule__Sequence__Group_17__2 ;
    public final void rule__Sequence__Group_17__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2901:1: ( rule__Sequence__Group_17__1__Impl rule__Sequence__Group_17__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2902:2: rule__Sequence__Group_17__1__Impl rule__Sequence__Group_17__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__1__Impl_in_rule__Sequence__Group_17__15809);
            rule__Sequence__Group_17__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_17__2_in_rule__Sequence__Group_17__15812);
            rule__Sequence__Group_17__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_17__1"


    // $ANTLR start "rule__Sequence__Group_17__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2909:1: rule__Sequence__Group_17__1__Impl : ( '|' ) ;
    public final void rule__Sequence__Group_17__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2913:1: ( ( '|' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2914:1: ( '|' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2914:1: ( '|' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2915:1: '|'
            {
             before(grammarAccess.getSequenceAccess().getVerticalLineKeyword_17_1()); 
            match(input,23,FOLLOW_23_in_rule__Sequence__Group_17__1__Impl5840); 
             after(grammarAccess.getSequenceAccess().getVerticalLineKeyword_17_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_17__1__Impl"


    // $ANTLR start "rule__Sequence__Group_17__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2928:1: rule__Sequence__Group_17__2 : rule__Sequence__Group_17__2__Impl rule__Sequence__Group_17__3 ;
    public final void rule__Sequence__Group_17__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2932:1: ( rule__Sequence__Group_17__2__Impl rule__Sequence__Group_17__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2933:2: rule__Sequence__Group_17__2__Impl rule__Sequence__Group_17__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__2__Impl_in_rule__Sequence__Group_17__25871);
            rule__Sequence__Group_17__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_17__3_in_rule__Sequence__Group_17__25874);
            rule__Sequence__Group_17__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_17__2"


    // $ANTLR start "rule__Sequence__Group_17__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2940:1: rule__Sequence__Group_17__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_17__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2944:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2945:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2945:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2946:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_17_2()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_17__2__Impl5902); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_17_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_17__2__Impl"


    // $ANTLR start "rule__Sequence__Group_17__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2959:1: rule__Sequence__Group_17__3 : rule__Sequence__Group_17__3__Impl ;
    public final void rule__Sequence__Group_17__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2963:1: ( rule__Sequence__Group_17__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2964:2: rule__Sequence__Group_17__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__3__Impl_in_rule__Sequence__Group_17__35933);
            rule__Sequence__Group_17__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_17__3"


    // $ANTLR start "rule__Sequence__Group_17__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2970:1: rule__Sequence__Group_17__3__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_17__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2974:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2975:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2975:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2976:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_17_3()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_17__3__Impl5961); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_17_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_17__3__Impl"


    // $ANTLR start "rule__Sequence__Group_18__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2997:1: rule__Sequence__Group_18__0 : rule__Sequence__Group_18__0__Impl rule__Sequence__Group_18__1 ;
    public final void rule__Sequence__Group_18__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3001:1: ( rule__Sequence__Group_18__0__Impl rule__Sequence__Group_18__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3002:2: rule__Sequence__Group_18__0__Impl rule__Sequence__Group_18__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__0__Impl_in_rule__Sequence__Group_18__06000);
            rule__Sequence__Group_18__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_18__1_in_rule__Sequence__Group_18__06003);
            rule__Sequence__Group_18__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_18__0"


    // $ANTLR start "rule__Sequence__Group_18__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3009:1: rule__Sequence__Group_18__0__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_18__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3013:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3014:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3014:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3015:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_18_0()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_18__0__Impl6031); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_18_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_18__0__Impl"


    // $ANTLR start "rule__Sequence__Group_18__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3028:1: rule__Sequence__Group_18__1 : rule__Sequence__Group_18__1__Impl rule__Sequence__Group_18__2 ;
    public final void rule__Sequence__Group_18__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3032:1: ( rule__Sequence__Group_18__1__Impl rule__Sequence__Group_18__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3033:2: rule__Sequence__Group_18__1__Impl rule__Sequence__Group_18__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__1__Impl_in_rule__Sequence__Group_18__16062);
            rule__Sequence__Group_18__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_18__2_in_rule__Sequence__Group_18__16065);
            rule__Sequence__Group_18__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_18__1"


    // $ANTLR start "rule__Sequence__Group_18__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3040:1: rule__Sequence__Group_18__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_18__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3044:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3045:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3045:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3046:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_18_1()); 
            match(input,15,FOLLOW_15_in_rule__Sequence__Group_18__1__Impl6093); 
             after(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_18_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_18__1__Impl"


    // $ANTLR start "rule__Sequence__Group_18__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3059:1: rule__Sequence__Group_18__2 : rule__Sequence__Group_18__2__Impl rule__Sequence__Group_18__3 ;
    public final void rule__Sequence__Group_18__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3063:1: ( rule__Sequence__Group_18__2__Impl rule__Sequence__Group_18__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3064:2: rule__Sequence__Group_18__2__Impl rule__Sequence__Group_18__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__2__Impl_in_rule__Sequence__Group_18__26124);
            rule__Sequence__Group_18__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_18__3_in_rule__Sequence__Group_18__26127);
            rule__Sequence__Group_18__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_18__2"


    // $ANTLR start "rule__Sequence__Group_18__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3071:1: rule__Sequence__Group_18__2__Impl : ( '|' ) ;
    public final void rule__Sequence__Group_18__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3075:1: ( ( '|' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3076:1: ( '|' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3076:1: ( '|' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3077:1: '|'
            {
             before(grammarAccess.getSequenceAccess().getVerticalLineKeyword_18_2()); 
            match(input,23,FOLLOW_23_in_rule__Sequence__Group_18__2__Impl6155); 
             after(grammarAccess.getSequenceAccess().getVerticalLineKeyword_18_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_18__2__Impl"


    // $ANTLR start "rule__Sequence__Group_18__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3090:1: rule__Sequence__Group_18__3 : rule__Sequence__Group_18__3__Impl ;
    public final void rule__Sequence__Group_18__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3094:1: ( rule__Sequence__Group_18__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3095:2: rule__Sequence__Group_18__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__3__Impl_in_rule__Sequence__Group_18__36186);
            rule__Sequence__Group_18__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_18__3"


    // $ANTLR start "rule__Sequence__Group_18__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3101:1: rule__Sequence__Group_18__3__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_18__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3105:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3106:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3106:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3107:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_18_3()); 
            match(input,16,FOLLOW_16_in_rule__Sequence__Group_18__3__Impl6214); 
             after(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_18_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_18__3__Impl"


    // $ANTLR start "rule__Sequence__Group_19__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3128:1: rule__Sequence__Group_19__0 : rule__Sequence__Group_19__0__Impl rule__Sequence__Group_19__1 ;
    public final void rule__Sequence__Group_19__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3132:1: ( rule__Sequence__Group_19__0__Impl rule__Sequence__Group_19__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3133:2: rule__Sequence__Group_19__0__Impl rule__Sequence__Group_19__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_19__0__Impl_in_rule__Sequence__Group_19__06253);
            rule__Sequence__Group_19__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_19__1_in_rule__Sequence__Group_19__06256);
            rule__Sequence__Group_19__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_19__0"


    // $ANTLR start "rule__Sequence__Group_19__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3140:1: rule__Sequence__Group_19__0__Impl : ( '.' ) ;
    public final void rule__Sequence__Group_19__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3144:1: ( ( '.' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3145:1: ( '.' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3145:1: ( '.' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3146:1: '.'
            {
             before(grammarAccess.getSequenceAccess().getFullStopKeyword_19_0()); 
            match(input,11,FOLLOW_11_in_rule__Sequence__Group_19__0__Impl6284); 
             after(grammarAccess.getSequenceAccess().getFullStopKeyword_19_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_19__0__Impl"


    // $ANTLR start "rule__Sequence__Group_19__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3159:1: rule__Sequence__Group_19__1 : rule__Sequence__Group_19__1__Impl ;
    public final void rule__Sequence__Group_19__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3163:1: ( rule__Sequence__Group_19__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3164:2: rule__Sequence__Group_19__1__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_19__1__Impl_in_rule__Sequence__Group_19__16315);
            rule__Sequence__Group_19__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_19__1"


    // $ANTLR start "rule__Sequence__Group_19__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3170:1: rule__Sequence__Group_19__1__Impl : ( '.' ) ;
    public final void rule__Sequence__Group_19__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3174:1: ( ( '.' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3175:1: ( '.' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3175:1: ( '.' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3176:1: '.'
            {
             before(grammarAccess.getSequenceAccess().getFullStopKeyword_19_1()); 
            match(input,11,FOLLOW_11_in_rule__Sequence__Group_19__1__Impl6343); 
             after(grammarAccess.getSequenceAccess().getFullStopKeyword_19_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_19__1__Impl"


    // $ANTLR start "rule__Comment__Group_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3193:1: rule__Comment__Group_0__0 : rule__Comment__Group_0__0__Impl rule__Comment__Group_0__1 ;
    public final void rule__Comment__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3197:1: ( rule__Comment__Group_0__0__Impl rule__Comment__Group_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3198:2: rule__Comment__Group_0__0__Impl rule__Comment__Group_0__1
            {
            pushFollow(FOLLOW_rule__Comment__Group_0__0__Impl_in_rule__Comment__Group_0__06378);
            rule__Comment__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comment__Group_0__1_in_rule__Comment__Group_0__06381);
            rule__Comment__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_0__0"


    // $ANTLR start "rule__Comment__Group_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3205:1: rule__Comment__Group_0__0__Impl : ( '\\'' ) ;
    public final void rule__Comment__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3209:1: ( ( '\\'' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3210:1: ( '\\'' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3210:1: ( '\\'' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3211:1: '\\''
            {
             before(grammarAccess.getCommentAccess().getApostropheKeyword_0_0()); 
            match(input,24,FOLLOW_24_in_rule__Comment__Group_0__0__Impl6409); 
             after(grammarAccess.getCommentAccess().getApostropheKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_0__0__Impl"


    // $ANTLR start "rule__Comment__Group_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3224:1: rule__Comment__Group_0__1 : rule__Comment__Group_0__1__Impl rule__Comment__Group_0__2 ;
    public final void rule__Comment__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3228:1: ( rule__Comment__Group_0__1__Impl rule__Comment__Group_0__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3229:2: rule__Comment__Group_0__1__Impl rule__Comment__Group_0__2
            {
            pushFollow(FOLLOW_rule__Comment__Group_0__1__Impl_in_rule__Comment__Group_0__16440);
            rule__Comment__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comment__Group_0__2_in_rule__Comment__Group_0__16443);
            rule__Comment__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_0__1"


    // $ANTLR start "rule__Comment__Group_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3236:1: rule__Comment__Group_0__1__Impl : ( RULE_STRING ) ;
    public final void rule__Comment__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3240:1: ( ( RULE_STRING ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3241:1: ( RULE_STRING )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3241:1: ( RULE_STRING )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3242:1: RULE_STRING
            {
             before(grammarAccess.getCommentAccess().getSTRINGTerminalRuleCall_0_1()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Comment__Group_0__1__Impl6470); 
             after(grammarAccess.getCommentAccess().getSTRINGTerminalRuleCall_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_0__1__Impl"


    // $ANTLR start "rule__Comment__Group_0__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3253:1: rule__Comment__Group_0__2 : rule__Comment__Group_0__2__Impl ;
    public final void rule__Comment__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3257:1: ( rule__Comment__Group_0__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3258:2: rule__Comment__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__Comment__Group_0__2__Impl_in_rule__Comment__Group_0__26499);
            rule__Comment__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_0__2"


    // $ANTLR start "rule__Comment__Group_0__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3264:1: rule__Comment__Group_0__2__Impl : ( '\\'' ) ;
    public final void rule__Comment__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3268:1: ( ( '\\'' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3269:1: ( '\\'' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3269:1: ( '\\'' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3270:1: '\\''
            {
             before(grammarAccess.getCommentAccess().getApostropheKeyword_0_2()); 
            match(input,24,FOLLOW_24_in_rule__Comment__Group_0__2__Impl6527); 
             after(grammarAccess.getCommentAccess().getApostropheKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_0__2__Impl"


    // $ANTLR start "rule__Comment__Group_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3289:1: rule__Comment__Group_1__0 : rule__Comment__Group_1__0__Impl rule__Comment__Group_1__1 ;
    public final void rule__Comment__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3293:1: ( rule__Comment__Group_1__0__Impl rule__Comment__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3294:2: rule__Comment__Group_1__0__Impl rule__Comment__Group_1__1
            {
            pushFollow(FOLLOW_rule__Comment__Group_1__0__Impl_in_rule__Comment__Group_1__06564);
            rule__Comment__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comment__Group_1__1_in_rule__Comment__Group_1__06567);
            rule__Comment__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_1__0"


    // $ANTLR start "rule__Comment__Group_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3301:1: rule__Comment__Group_1__0__Impl : ( '/\\'' ) ;
    public final void rule__Comment__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3305:1: ( ( '/\\'' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3306:1: ( '/\\'' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3306:1: ( '/\\'' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3307:1: '/\\''
            {
             before(grammarAccess.getCommentAccess().getSolidusApostropheKeyword_1_0()); 
            match(input,25,FOLLOW_25_in_rule__Comment__Group_1__0__Impl6595); 
             after(grammarAccess.getCommentAccess().getSolidusApostropheKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_1__0__Impl"


    // $ANTLR start "rule__Comment__Group_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3320:1: rule__Comment__Group_1__1 : rule__Comment__Group_1__1__Impl rule__Comment__Group_1__2 ;
    public final void rule__Comment__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3324:1: ( rule__Comment__Group_1__1__Impl rule__Comment__Group_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3325:2: rule__Comment__Group_1__1__Impl rule__Comment__Group_1__2
            {
            pushFollow(FOLLOW_rule__Comment__Group_1__1__Impl_in_rule__Comment__Group_1__16626);
            rule__Comment__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comment__Group_1__2_in_rule__Comment__Group_1__16629);
            rule__Comment__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_1__1"


    // $ANTLR start "rule__Comment__Group_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3332:1: rule__Comment__Group_1__1__Impl : ( RULE_STRING ) ;
    public final void rule__Comment__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3336:1: ( ( RULE_STRING ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3337:1: ( RULE_STRING )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3337:1: ( RULE_STRING )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3338:1: RULE_STRING
            {
             before(grammarAccess.getCommentAccess().getSTRINGTerminalRuleCall_1_1()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Comment__Group_1__1__Impl6656); 
             after(grammarAccess.getCommentAccess().getSTRINGTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_1__1__Impl"


    // $ANTLR start "rule__Comment__Group_1__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3349:1: rule__Comment__Group_1__2 : rule__Comment__Group_1__2__Impl rule__Comment__Group_1__3 ;
    public final void rule__Comment__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3353:1: ( rule__Comment__Group_1__2__Impl rule__Comment__Group_1__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3354:2: rule__Comment__Group_1__2__Impl rule__Comment__Group_1__3
            {
            pushFollow(FOLLOW_rule__Comment__Group_1__2__Impl_in_rule__Comment__Group_1__26685);
            rule__Comment__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comment__Group_1__3_in_rule__Comment__Group_1__26688);
            rule__Comment__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_1__2"


    // $ANTLR start "rule__Comment__Group_1__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3361:1: rule__Comment__Group_1__2__Impl : ( ( rule__Comment__Group_1_2__0 )* ) ;
    public final void rule__Comment__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3365:1: ( ( ( rule__Comment__Group_1_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3366:1: ( ( rule__Comment__Group_1_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3366:1: ( ( rule__Comment__Group_1_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3367:1: ( rule__Comment__Group_1_2__0 )*
            {
             before(grammarAccess.getCommentAccess().getGroup_1_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3368:1: ( rule__Comment__Group_1_2__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_WS) ) {
                    int LA21_1 = input.LA(2);

                    if ( (LA21_1==RULE_STRING) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3368:2: rule__Comment__Group_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Comment__Group_1_2__0_in_rule__Comment__Group_1__2__Impl6715);
            	    rule__Comment__Group_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getCommentAccess().getGroup_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_1__2__Impl"


    // $ANTLR start "rule__Comment__Group_1__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3378:1: rule__Comment__Group_1__3 : rule__Comment__Group_1__3__Impl rule__Comment__Group_1__4 ;
    public final void rule__Comment__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3382:1: ( rule__Comment__Group_1__3__Impl rule__Comment__Group_1__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3383:2: rule__Comment__Group_1__3__Impl rule__Comment__Group_1__4
            {
            pushFollow(FOLLOW_rule__Comment__Group_1__3__Impl_in_rule__Comment__Group_1__36746);
            rule__Comment__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comment__Group_1__4_in_rule__Comment__Group_1__36749);
            rule__Comment__Group_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_1__3"


    // $ANTLR start "rule__Comment__Group_1__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3390:1: rule__Comment__Group_1__3__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Comment__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3394:1: ( ( ( RULE_WS )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3395:1: ( ( RULE_WS )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3395:1: ( ( RULE_WS )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3396:1: ( RULE_WS )*
            {
             before(grammarAccess.getCommentAccess().getWSTerminalRuleCall_1_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3397:1: ( RULE_WS )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_WS) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3397:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Comment__Group_1__3__Impl6777); 

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getCommentAccess().getWSTerminalRuleCall_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_1__3__Impl"


    // $ANTLR start "rule__Comment__Group_1__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3407:1: rule__Comment__Group_1__4 : rule__Comment__Group_1__4__Impl ;
    public final void rule__Comment__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3411:1: ( rule__Comment__Group_1__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3412:2: rule__Comment__Group_1__4__Impl
            {
            pushFollow(FOLLOW_rule__Comment__Group_1__4__Impl_in_rule__Comment__Group_1__46808);
            rule__Comment__Group_1__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_1__4"


    // $ANTLR start "rule__Comment__Group_1__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3418:1: rule__Comment__Group_1__4__Impl : ( '\\'/' ) ;
    public final void rule__Comment__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3422:1: ( ( '\\'/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3423:1: ( '\\'/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3423:1: ( '\\'/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3424:1: '\\'/'
            {
             before(grammarAccess.getCommentAccess().getApostropheSolidusKeyword_1_4()); 
            match(input,26,FOLLOW_26_in_rule__Comment__Group_1__4__Impl6836); 
             after(grammarAccess.getCommentAccess().getApostropheSolidusKeyword_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_1__4__Impl"


    // $ANTLR start "rule__Comment__Group_1_2__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3447:1: rule__Comment__Group_1_2__0 : rule__Comment__Group_1_2__0__Impl rule__Comment__Group_1_2__1 ;
    public final void rule__Comment__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3451:1: ( rule__Comment__Group_1_2__0__Impl rule__Comment__Group_1_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3452:2: rule__Comment__Group_1_2__0__Impl rule__Comment__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__Comment__Group_1_2__0__Impl_in_rule__Comment__Group_1_2__06877);
            rule__Comment__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comment__Group_1_2__1_in_rule__Comment__Group_1_2__06880);
            rule__Comment__Group_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_1_2__0"


    // $ANTLR start "rule__Comment__Group_1_2__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3459:1: rule__Comment__Group_1_2__0__Impl : ( RULE_WS ) ;
    public final void rule__Comment__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3463:1: ( ( RULE_WS ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3464:1: ( RULE_WS )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3464:1: ( RULE_WS )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3465:1: RULE_WS
            {
             before(grammarAccess.getCommentAccess().getWSTerminalRuleCall_1_2_0()); 
            match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Comment__Group_1_2__0__Impl6907); 
             after(grammarAccess.getCommentAccess().getWSTerminalRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_1_2__0__Impl"


    // $ANTLR start "rule__Comment__Group_1_2__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3476:1: rule__Comment__Group_1_2__1 : rule__Comment__Group_1_2__1__Impl ;
    public final void rule__Comment__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3480:1: ( rule__Comment__Group_1_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3481:2: rule__Comment__Group_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Comment__Group_1_2__1__Impl_in_rule__Comment__Group_1_2__16936);
            rule__Comment__Group_1_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_1_2__1"


    // $ANTLR start "rule__Comment__Group_1_2__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3487:1: rule__Comment__Group_1_2__1__Impl : ( ( rule__Comment__StringsAssignment_1_2_1 ) ) ;
    public final void rule__Comment__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3491:1: ( ( ( rule__Comment__StringsAssignment_1_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3492:1: ( ( rule__Comment__StringsAssignment_1_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3492:1: ( ( rule__Comment__StringsAssignment_1_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3493:1: ( rule__Comment__StringsAssignment_1_2_1 )
            {
             before(grammarAccess.getCommentAccess().getStringsAssignment_1_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3494:1: ( rule__Comment__StringsAssignment_1_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3494:2: rule__Comment__StringsAssignment_1_2_1
            {
            pushFollow(FOLLOW_rule__Comment__StringsAssignment_1_2_1_in_rule__Comment__Group_1_2__1__Impl6963);
            rule__Comment__StringsAssignment_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getCommentAccess().getStringsAssignment_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__Group_1_2__1__Impl"


    // $ANTLR start "rule__Definition__Group_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3508:1: rule__Definition__Group_0__0 : rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 ;
    public final void rule__Definition__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3512:1: ( rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3513:2: rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__06997);
            rule__Definition__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__07000);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3520:1: rule__Definition__Group_0__0__Impl : ( 'actor' ) ;
    public final void rule__Definition__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3524:1: ( ( 'actor' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3525:1: ( 'actor' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3525:1: ( 'actor' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3526:1: 'actor'
            {
             before(grammarAccess.getDefinitionAccess().getActorKeyword_0_0()); 
            match(input,27,FOLLOW_27_in_rule__Definition__Group_0__0__Impl7028); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3539:1: rule__Definition__Group_0__1 : rule__Definition__Group_0__1__Impl ;
    public final void rule__Definition__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3543:1: ( rule__Definition__Group_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3544:2: rule__Definition__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__17059);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3550:1: rule__Definition__Group_0__1__Impl : ( ( rule__Definition__NameAssignment_0_1 ) ) ;
    public final void rule__Definition__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3554:1: ( ( ( rule__Definition__NameAssignment_0_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3555:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3555:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3556:1: ( rule__Definition__NameAssignment_0_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3557:1: ( rule__Definition__NameAssignment_0_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3557:2: rule__Definition__NameAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl7086);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3571:1: rule__Definition__Group_1__0 : rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 ;
    public final void rule__Definition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3575:1: ( rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3576:2: rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__07120);
            rule__Definition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__07123);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3583:1: rule__Definition__Group_1__0__Impl : ( 'boundary' ) ;
    public final void rule__Definition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3587:1: ( ( 'boundary' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3588:1: ( 'boundary' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3588:1: ( 'boundary' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3589:1: 'boundary'
            {
             before(grammarAccess.getDefinitionAccess().getBoundaryKeyword_1_0()); 
            match(input,28,FOLLOW_28_in_rule__Definition__Group_1__0__Impl7151); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3602:1: rule__Definition__Group_1__1 : rule__Definition__Group_1__1__Impl ;
    public final void rule__Definition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3606:1: ( rule__Definition__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3607:2: rule__Definition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__17182);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3613:1: rule__Definition__Group_1__1__Impl : ( ( rule__Definition__NameAssignment_1_1 ) ) ;
    public final void rule__Definition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3617:1: ( ( ( rule__Definition__NameAssignment_1_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3618:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3618:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3619:1: ( rule__Definition__NameAssignment_1_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3620:1: ( rule__Definition__NameAssignment_1_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3620:2: rule__Definition__NameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl7209);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3634:1: rule__Definition__Group_2__0 : rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 ;
    public final void rule__Definition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3638:1: ( rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3639:2: rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__07243);
            rule__Definition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__07246);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3646:1: rule__Definition__Group_2__0__Impl : ( 'control' ) ;
    public final void rule__Definition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3650:1: ( ( 'control' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3651:1: ( 'control' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3651:1: ( 'control' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3652:1: 'control'
            {
             before(grammarAccess.getDefinitionAccess().getControlKeyword_2_0()); 
            match(input,29,FOLLOW_29_in_rule__Definition__Group_2__0__Impl7274); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3665:1: rule__Definition__Group_2__1 : rule__Definition__Group_2__1__Impl ;
    public final void rule__Definition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3669:1: ( rule__Definition__Group_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3670:2: rule__Definition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__17305);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3676:1: rule__Definition__Group_2__1__Impl : ( ( rule__Definition__NameAssignment_2_1 ) ) ;
    public final void rule__Definition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3680:1: ( ( ( rule__Definition__NameAssignment_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3681:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3681:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3682:1: ( rule__Definition__NameAssignment_2_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3683:1: ( rule__Definition__NameAssignment_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3683:2: rule__Definition__NameAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl7332);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3697:1: rule__Definition__Group_3__0 : rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 ;
    public final void rule__Definition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3701:1: ( rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3702:2: rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__07366);
            rule__Definition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__07369);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3709:1: rule__Definition__Group_3__0__Impl : ( 'entity' ) ;
    public final void rule__Definition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3713:1: ( ( 'entity' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3714:1: ( 'entity' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3714:1: ( 'entity' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3715:1: 'entity'
            {
             before(grammarAccess.getDefinitionAccess().getEntityKeyword_3_0()); 
            match(input,30,FOLLOW_30_in_rule__Definition__Group_3__0__Impl7397); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3728:1: rule__Definition__Group_3__1 : rule__Definition__Group_3__1__Impl ;
    public final void rule__Definition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3732:1: ( rule__Definition__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3733:2: rule__Definition__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__17428);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3739:1: rule__Definition__Group_3__1__Impl : ( ( rule__Definition__NameAssignment_3_1 ) ) ;
    public final void rule__Definition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3743:1: ( ( ( rule__Definition__NameAssignment_3_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3744:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3744:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3745:1: ( rule__Definition__NameAssignment_3_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3746:1: ( rule__Definition__NameAssignment_3_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3746:2: rule__Definition__NameAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl7455);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3760:1: rule__Definition__Group_4__0 : rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 ;
    public final void rule__Definition__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3764:1: ( rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3765:2: rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__07489);
            rule__Definition__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__07492);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3772:1: rule__Definition__Group_4__0__Impl : ( 'database' ) ;
    public final void rule__Definition__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3776:1: ( ( 'database' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3777:1: ( 'database' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3777:1: ( 'database' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3778:1: 'database'
            {
             before(grammarAccess.getDefinitionAccess().getDatabaseKeyword_4_0()); 
            match(input,31,FOLLOW_31_in_rule__Definition__Group_4__0__Impl7520); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3791:1: rule__Definition__Group_4__1 : rule__Definition__Group_4__1__Impl ;
    public final void rule__Definition__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3795:1: ( rule__Definition__Group_4__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3796:2: rule__Definition__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__17551);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3802:1: rule__Definition__Group_4__1__Impl : ( ( rule__Definition__NameAssignment_4_1 ) ) ;
    public final void rule__Definition__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3806:1: ( ( ( rule__Definition__NameAssignment_4_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3807:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3807:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3808:1: ( rule__Definition__NameAssignment_4_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_4_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3809:1: ( rule__Definition__NameAssignment_4_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3809:2: rule__Definition__NameAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl7578);
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


    // $ANTLR start "rule__Model__DiagramsAssignment"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3824:1: rule__Model__DiagramsAssignment : ( ruleDiagram ) ;
    public final void rule__Model__DiagramsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3828:1: ( ( ruleDiagram ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3829:1: ( ruleDiagram )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3829:1: ( ruleDiagram )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3830:1: ruleDiagram
            {
             before(grammarAccess.getModelAccess().getDiagramsDiagramParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDiagram_in_rule__Model__DiagramsAssignment7617);
            ruleDiagram();

            state._fsp--;

             after(grammarAccess.getModelAccess().getDiagramsDiagramParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__DiagramsAssignment"


    // $ANTLR start "rule__Diagram__InstructionsAssignment_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3839:1: rule__Diagram__InstructionsAssignment_1 : ( ruleInstruction ) ;
    public final void rule__Diagram__InstructionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3843:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3844:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3844:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3845:1: ruleInstruction
            {
             before(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_17648);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Diagram__InstructionsAssignment_1"


    // $ANTLR start "rule__Instruction__NameAssignment_0_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3854:1: rule__Instruction__NameAssignment_0_0 : ( RULE_ID ) ;
    public final void rule__Instruction__NameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3858:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3859:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3859:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3860:1: RULE_ID
            {
             before(grammarAccess.getInstructionAccess().getNameIDTerminalRuleCall_0_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Instruction__NameAssignment_0_07679); 
             after(grammarAccess.getInstructionAccess().getNameIDTerminalRuleCall_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__NameAssignment_0_0"


    // $ANTLR start "rule__Instruction__NameAssignment_0_2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3869:1: rule__Instruction__NameAssignment_0_2 : ( RULE_ID ) ;
    public final void rule__Instruction__NameAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3873:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3874:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3874:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3875:1: RULE_ID
            {
             before(grammarAccess.getInstructionAccess().getNameIDTerminalRuleCall_0_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Instruction__NameAssignment_0_27710); 
             after(grammarAccess.getInstructionAccess().getNameIDTerminalRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__NameAssignment_0_2"


    // $ANTLR start "rule__Comment__StringsAssignment_1_2_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3884:1: rule__Comment__StringsAssignment_1_2_1 : ( RULE_STRING ) ;
    public final void rule__Comment__StringsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3888:1: ( ( RULE_STRING ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3889:1: ( RULE_STRING )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3889:1: ( RULE_STRING )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3890:1: RULE_STRING
            {
             before(grammarAccess.getCommentAccess().getStringsSTRINGTerminalRuleCall_1_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Comment__StringsAssignment_1_2_17741); 
             after(grammarAccess.getCommentAccess().getStringsSTRINGTerminalRuleCall_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comment__StringsAssignment_1_2_1"


    // $ANTLR start "rule__Definition__NameAssignment_0_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3899:1: rule__Definition__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3903:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3904:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3904:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3905:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_0_17772); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3914:1: rule__Definition__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3918:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3919:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3919:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3920:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_1_17803); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3929:1: rule__Definition__NameAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3933:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3934:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3934:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3935:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_2_17834); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3944:1: rule__Definition__NameAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3948:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3949:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3949:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3950:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_3_17865); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3959:1: rule__Definition__NameAssignment_4_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3963:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3964:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3964:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3965:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_4_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_4_17896); 
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

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA3_eotS =
        "\43\uffff";
    static final String DFA3_eofS =
        "\6\uffff\1\23\1\25\3\uffff\1\35\14\uffff\1\25\3\uffff\1\40\1\uffff"+
        "\1\42\4\uffff";
    static final String DFA3_minS =
        "\1\13\2\17\1\uffff\1\17\1\21\2\6\1\17\2\uffff\1\6\5\uffff\1\17"+
        "\6\uffff\1\6\1\17\2\uffff\1\6\1\uffff\1\6\4\uffff";
    static final String DFA3_maxS =
        "\1\26\1\25\1\27\1\uffff\1\24\1\25\1\13\1\26\1\27\2\uffff\1\20\5"+
        "\uffff\1\17\6\uffff\1\26\1\25\2\uffff\1\26\1\uffff\1\20\4\uffff";
    static final String DFA3_acceptS =
        "\3\uffff\1\4\5\uffff\1\7\1\11\1\uffff\1\6\1\22\1\10\1\12\1\16\1"+
        "\uffff\1\24\1\25\1\3\1\1\1\13\1\5\2\uffff\1\15\1\23\1\uffff\1\2"+
        "\1\uffff\1\20\1\17\1\21\1\14";
    static final String DFA3_specialS =
        "\43\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\6\3\uffff\1\1\1\uffff\1\2\1\3\1\uffff\1\4\1\uffff\1\5",
            "\1\10\1\7\2\uffff\1\11\1\uffff\1\12",
            "\1\13\1\uffff\1\14\5\uffff\1\15",
            "",
            "\1\16\4\uffff\1\17",
            "\1\21\3\uffff\1\20",
            "\1\23\4\uffff\1\22",
            "\1\25\11\uffff\1\27\1\uffff\1\24\3\uffff\1\26",
            "\1\31\1\30\2\uffff\1\11\1\32\1\12\1\uffff\1\33",
            "",
            "",
            "\1\35\10\uffff\1\35\1\34",
            "",
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
            "\1\25\11\uffff\1\27\5\uffff\1\26",
            "\1\31\1\30\2\uffff\1\11\1\32\1\12",
            "",
            "",
            "\1\40\17\uffff\1\37",
            "",
            "\1\42\10\uffff\1\42\1\41",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "256:1: rule__Sequence__Alternatives : ( ( ( rule__Sequence__Group_0__0 ) ) | ( ( rule__Sequence__Group_1__0 ) ) | ( ( rule__Sequence__Group_2__0 ) ) | ( ( rule__Sequence__Group_3__0 ) ) | ( ( rule__Sequence__Group_4__0 ) ) | ( ( rule__Sequence__Group_5__0 ) ) | ( ( rule__Sequence__Group_6__0 ) ) | ( ( rule__Sequence__Group_7__0 ) ) | ( ( rule__Sequence__Group_8__0 ) ) | ( ( rule__Sequence__Group_9__0 ) ) | ( ( rule__Sequence__Group_10__0 ) ) | ( ( rule__Sequence__Group_11__0 ) ) | ( ( rule__Sequence__Group_12__0 ) ) | ( ( rule__Sequence__Group_13__0 ) ) | ( ( rule__Sequence__Group_14__0 ) ) | ( ( rule__Sequence__Group_15__0 ) ) | ( ( rule__Sequence__Group_16__0 ) ) | ( ( rule__Sequence__Group_17__0 ) ) | ( ( rule__Sequence__Group_18__0 ) ) | ( ( rule__Sequence__Group_19__0 ) ) | ( '.' ) );";
        }
    }
    static final String DFA8_eotS =
        "\13\uffff";
    static final String DFA8_eofS =
        "\1\3\12\uffff";
    static final String DFA8_minS =
        "\1\6\2\4\1\uffff\1\30\1\5\1\uffff\1\4\1\uffff\2\5";
    static final String DFA8_maxS =
        "\1\37\2\4\1\uffff\1\30\1\32\1\uffff\1\32\1\uffff\2\32";
    static final String DFA8_acceptS =
        "\3\uffff\1\2\2\uffff\1\1\1\uffff\1\1\2\uffff";
    static final String DFA8_specialS =
        "\13\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\3\6\uffff\1\3\12\uffff\1\1\1\2\1\uffff\5\3",
            "\1\4",
            "\1\5",
            "",
            "\1\6",
            "\1\7\24\uffff\1\10",
            "",
            "\1\11\1\12\24\uffff\1\10",
            "",
            "\1\7\24\uffff\1\10",
            "\1\12\24\uffff\1\10"
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "688:1: ( ruleComment )?";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DiagramsAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleDiagram_in_entryRuleDiagram122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDiagram129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__0_in_ruleDiagram155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Alternatives_in_ruleInstruction215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequence_in_entryRuleSequence242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequence249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Alternatives_in_ruleSequence275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComment_in_entryRuleComment302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComment309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comment__Alternatives_in_ruleComment335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Alternatives_in_ruleDefinition395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__0_in_rule__Instruction__Alternatives431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComment_in_rule__Instruction__Alternatives449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_rule__Instruction__Alternatives466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__0_in_rule__Sequence__Alternatives498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__0_in_rule__Sequence__Alternatives516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__0_in_rule__Sequence__Alternatives534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__0_in_rule__Sequence__Alternatives552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__0_in_rule__Sequence__Alternatives570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__0_in_rule__Sequence__Alternatives588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__0_in_rule__Sequence__Alternatives606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__0_in_rule__Sequence__Alternatives624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__0_in_rule__Sequence__Alternatives642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__0_in_rule__Sequence__Alternatives660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__0_in_rule__Sequence__Alternatives678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__0_in_rule__Sequence__Alternatives696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__0_in_rule__Sequence__Alternatives714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__0_in_rule__Sequence__Alternatives732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__0_in_rule__Sequence__Alternatives750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__0_in_rule__Sequence__Alternatives768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__0_in_rule__Sequence__Alternatives786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__0_in_rule__Sequence__Alternatives804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__0_in_rule__Sequence__Alternatives822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__0_in_rule__Sequence__Alternatives840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Sequence__Alternatives859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comment__Group_0__0_in_rule__Comment__Alternatives893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comment__Group_1__0_in_rule__Comment__Alternatives911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives1016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__01047 = new BitSet(new long[]{0x00000000FB002040L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__01050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Diagram__Group__0__Impl1078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__11109 = new BitSet(new long[]{0x00000000FB002040L});
    public static final BitSet FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__11112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__InstructionsAssignment_1_in_rule__Diagram__Group__1__Impl1139 = new BitSet(new long[]{0x00000000FB000042L});
    public static final BitSet FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__21170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Diagram__Group__2__Impl1198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__0__Impl_in_rule__Instruction__Group_0__01235 = new BitSet(new long[]{0x0000000000568800L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__1_in_rule__Instruction__Group_0__01238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__NameAssignment_0_0_in_rule__Instruction__Group_0__0__Impl1265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__1__Impl_in_rule__Instruction__Group_0__11295 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__2_in_rule__Instruction__Group_0__11298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequence_in_rule__Instruction__Group_0__1__Impl1325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__2__Impl_in_rule__Instruction__Group_0__21354 = new BitSet(new long[]{0x0000000003004000L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__3_in_rule__Instruction__Group_0__21357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__NameAssignment_0_2_in_rule__Instruction__Group_0__2__Impl1384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__3__Impl_in_rule__Instruction__Group_0__31414 = new BitSet(new long[]{0x0000000003004000L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__4_in_rule__Instruction__Group_0__31417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_3__0_in_rule__Instruction__Group_0__3__Impl1444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__4__Impl_in_rule__Instruction__Group_0__41475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComment_in_rule__Instruction__Group_0__4__Impl1503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_3__0__Impl_in_rule__Instruction__Group_0_3__01544 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_3__1_in_rule__Instruction__Group_0_3__01547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Instruction__Group_0_3__0__Impl1575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_3__1__Impl_in_rule__Instruction__Group_0_3__11606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Instruction__Group_0_3__1__Impl1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__0__Impl_in_rule__Sequence__Group_0__01666 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__1_in_rule__Sequence__Group_0__01669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_0__0__Impl1698 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__1__Impl_in_rule__Sequence__Group_0__11731 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__2_in_rule__Sequence__Group_0__11734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_0__1__Impl1762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__2__Impl_in_rule__Sequence__Group_0__21793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Sequence__Group_0__2__Impl1821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__0__Impl_in_rule__Sequence__Group_1__01858 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__1_in_rule__Sequence__Group_1__01861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Sequence__Group_1__0__Impl1889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__1__Impl_in_rule__Sequence__Group_1__11920 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__2_in_rule__Sequence__Group_1__11923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_1__1__Impl1951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__2__Impl_in_rule__Sequence__Group_1__21982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_1__2__Impl2011 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__0__Impl_in_rule__Sequence__Group_2__02050 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__1_in_rule__Sequence__Group_2__02053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_2__0__Impl2081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__1__Impl_in_rule__Sequence__Group_2__12112 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__2_in_rule__Sequence__Group_2__12115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Sequence__Group_2__1__Impl2143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__2__Impl_in_rule__Sequence__Group_2__22174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Sequence__Group_2__2__Impl2202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__0__Impl_in_rule__Sequence__Group_3__02239 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__1_in_rule__Sequence__Group_3__02242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Sequence__Group_3__0__Impl2270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__1__Impl_in_rule__Sequence__Group_3__12301 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__2_in_rule__Sequence__Group_3__12304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Sequence__Group_3__1__Impl2332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__2__Impl_in_rule__Sequence__Group_3__22363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_3__2__Impl2391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__0__Impl_in_rule__Sequence__Group_4__02428 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__1_in_rule__Sequence__Group_4__02431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_4__0__Impl2460 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__1__Impl_in_rule__Sequence__Group_4__12493 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__2_in_rule__Sequence__Group_4__12496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_4__1__Impl2524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__2__Impl_in_rule__Sequence__Group_4__22555 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__3_in_rule__Sequence__Group_4__22558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Sequence__Group_4__2__Impl2586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__3__Impl_in_rule__Sequence__Group_4__32617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Sequence__Group_4__3__Impl2645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__0__Impl_in_rule__Sequence__Group_5__02684 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__1_in_rule__Sequence__Group_5__02687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Sequence__Group_5__0__Impl2715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__1__Impl_in_rule__Sequence__Group_5__12746 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__2_in_rule__Sequence__Group_5__12749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Sequence__Group_5__1__Impl2777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__2__Impl_in_rule__Sequence__Group_5__22808 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__3_in_rule__Sequence__Group_5__22811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_5__2__Impl2839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__3__Impl_in_rule__Sequence__Group_5__32870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_5__3__Impl2899 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__0__Impl_in_rule__Sequence__Group_6__02940 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__1_in_rule__Sequence__Group_6__02943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_6__0__Impl2972 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__1__Impl_in_rule__Sequence__Group_6__13005 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__2_in_rule__Sequence__Group_6__13008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_6__1__Impl3036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__2__Impl_in_rule__Sequence__Group_6__23067 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__3_in_rule__Sequence__Group_6__23070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Sequence__Group_6__2__Impl3098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__3__Impl_in_rule__Sequence__Group_6__33129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Sequence__Group_6__3__Impl3157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__0__Impl_in_rule__Sequence__Group_7__03196 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__1_in_rule__Sequence__Group_7__03199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Sequence__Group_7__0__Impl3227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__1__Impl_in_rule__Sequence__Group_7__13258 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__2_in_rule__Sequence__Group_7__13261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_7__1__Impl3289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__2__Impl_in_rule__Sequence__Group_7__23320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_7__2__Impl3349 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__0__Impl_in_rule__Sequence__Group_8__03388 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__1_in_rule__Sequence__Group_8__03391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_8__0__Impl3420 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__1__Impl_in_rule__Sequence__Group_8__13453 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__2_in_rule__Sequence__Group_8__13456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_8__1__Impl3484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__2__Impl_in_rule__Sequence__Group_8__23515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Sequence__Group_8__2__Impl3543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__0__Impl_in_rule__Sequence__Group_9__03580 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__1_in_rule__Sequence__Group_9__03583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Sequence__Group_9__0__Impl3611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__1__Impl_in_rule__Sequence__Group_9__13642 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__2_in_rule__Sequence__Group_9__13645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Sequence__Group_9__1__Impl3673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__2__Impl_in_rule__Sequence__Group_9__23704 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__3_in_rule__Sequence__Group_9__23707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_9__2__Impl3735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__3__Impl_in_rule__Sequence__Group_9__33766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_9__3__Impl3795 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__0__Impl_in_rule__Sequence__Group_10__03836 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__1_in_rule__Sequence__Group_10__03839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_10__0__Impl3868 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__1__Impl_in_rule__Sequence__Group_10__13901 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__2_in_rule__Sequence__Group_10__13904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_10__1__Impl3932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__2__Impl_in_rule__Sequence__Group_10__23963 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__3_in_rule__Sequence__Group_10__23966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Sequence__Group_10__2__Impl3994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__3__Impl_in_rule__Sequence__Group_10__34025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Sequence__Group_10__3__Impl4053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__0__Impl_in_rule__Sequence__Group_11__04092 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__1_in_rule__Sequence__Group_11__04095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Sequence__Group_11__0__Impl4123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__1__Impl_in_rule__Sequence__Group_11__14154 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__2_in_rule__Sequence__Group_11__14157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Sequence__Group_11__1__Impl4185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__2__Impl_in_rule__Sequence__Group_11__24216 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__3_in_rule__Sequence__Group_11__24219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_11__2__Impl4247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__3__Impl_in_rule__Sequence__Group_11__34278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_11__3__Impl4307 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__0__Impl_in_rule__Sequence__Group_12__04348 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__1_in_rule__Sequence__Group_12__04351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_12__0__Impl4380 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__1__Impl_in_rule__Sequence__Group_12__14413 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__2_in_rule__Sequence__Group_12__14416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_12__1__Impl4444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__2__Impl_in_rule__Sequence__Group_12__24475 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__3_in_rule__Sequence__Group_12__24478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_12__2__Impl4506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__3__Impl_in_rule__Sequence__Group_12__34537 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__4_in_rule__Sequence__Group_12__34540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Sequence__Group_12__3__Impl4568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__4__Impl_in_rule__Sequence__Group_12__44599 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__5_in_rule__Sequence__Group_12__44602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Sequence__Group_12__4__Impl4630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__5__Impl_in_rule__Sequence__Group_12__54661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Sequence__Group_12__5__Impl4689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__0__Impl_in_rule__Sequence__Group_13__04732 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__1_in_rule__Sequence__Group_13__04735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Sequence__Group_13__0__Impl4763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__1__Impl_in_rule__Sequence__Group_13__14794 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__2_in_rule__Sequence__Group_13__14797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Sequence__Group_13__1__Impl4825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__2__Impl_in_rule__Sequence__Group_13__24856 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__3_in_rule__Sequence__Group_13__24859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_13__2__Impl4887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__3__Impl_in_rule__Sequence__Group_13__34918 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__4_in_rule__Sequence__Group_13__34921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_13__3__Impl4949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__4__Impl_in_rule__Sequence__Group_13__44980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_13__4__Impl5009 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__0__Impl_in_rule__Sequence__Group_14__05052 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__1_in_rule__Sequence__Group_14__05055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Sequence__Group_14__0__Impl5083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__1__Impl_in_rule__Sequence__Group_14__15114 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__2_in_rule__Sequence__Group_14__15117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_14__1__Impl5145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__2__Impl_in_rule__Sequence__Group_14__25176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Sequence__Group_14__2__Impl5204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__0__Impl_in_rule__Sequence__Group_15__05241 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__1_in_rule__Sequence__Group_15__05244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Sequence__Group_15__0__Impl5272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__1__Impl_in_rule__Sequence__Group_15__15303 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__2_in_rule__Sequence__Group_15__15306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_15__1__Impl5334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__2__Impl_in_rule__Sequence__Group_15__25365 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__3_in_rule__Sequence__Group_15__25368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Sequence__Group_15__2__Impl5396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__3__Impl_in_rule__Sequence__Group_15__35427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Sequence__Group_15__3__Impl5455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__0__Impl_in_rule__Sequence__Group_16__05494 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__1_in_rule__Sequence__Group_16__05497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Sequence__Group_16__0__Impl5525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__1__Impl_in_rule__Sequence__Group_16__15556 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__2_in_rule__Sequence__Group_16__15559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Sequence__Group_16__1__Impl5587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__2__Impl_in_rule__Sequence__Group_16__25618 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__3_in_rule__Sequence__Group_16__25621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_16__2__Impl5649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__3__Impl_in_rule__Sequence__Group_16__35680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Sequence__Group_16__3__Impl5708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__0__Impl_in_rule__Sequence__Group_17__05747 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__1_in_rule__Sequence__Group_17__05750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Sequence__Group_17__0__Impl5778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__1__Impl_in_rule__Sequence__Group_17__15809 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__2_in_rule__Sequence__Group_17__15812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Sequence__Group_17__1__Impl5840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__2__Impl_in_rule__Sequence__Group_17__25871 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__3_in_rule__Sequence__Group_17__25874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_17__2__Impl5902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__3__Impl_in_rule__Sequence__Group_17__35933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_17__3__Impl5961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__0__Impl_in_rule__Sequence__Group_18__06000 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__1_in_rule__Sequence__Group_18__06003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_18__0__Impl6031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__1__Impl_in_rule__Sequence__Group_18__16062 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__2_in_rule__Sequence__Group_18__16065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Sequence__Group_18__1__Impl6093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__2__Impl_in_rule__Sequence__Group_18__26124 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__3_in_rule__Sequence__Group_18__26127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Sequence__Group_18__2__Impl6155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__3__Impl_in_rule__Sequence__Group_18__36186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Sequence__Group_18__3__Impl6214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__0__Impl_in_rule__Sequence__Group_19__06253 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__1_in_rule__Sequence__Group_19__06256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Sequence__Group_19__0__Impl6284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__1__Impl_in_rule__Sequence__Group_19__16315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Sequence__Group_19__1__Impl6343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comment__Group_0__0__Impl_in_rule__Comment__Group_0__06378 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Comment__Group_0__1_in_rule__Comment__Group_0__06381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Comment__Group_0__0__Impl6409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comment__Group_0__1__Impl_in_rule__Comment__Group_0__16440 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Comment__Group_0__2_in_rule__Comment__Group_0__16443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Comment__Group_0__1__Impl6470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comment__Group_0__2__Impl_in_rule__Comment__Group_0__26499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Comment__Group_0__2__Impl6527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comment__Group_1__0__Impl_in_rule__Comment__Group_1__06564 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Comment__Group_1__1_in_rule__Comment__Group_1__06567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Comment__Group_1__0__Impl6595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comment__Group_1__1__Impl_in_rule__Comment__Group_1__16626 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_rule__Comment__Group_1__2_in_rule__Comment__Group_1__16629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Comment__Group_1__1__Impl6656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comment__Group_1__2__Impl_in_rule__Comment__Group_1__26685 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_rule__Comment__Group_1__3_in_rule__Comment__Group_1__26688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comment__Group_1_2__0_in_rule__Comment__Group_1__2__Impl6715 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__Comment__Group_1__3__Impl_in_rule__Comment__Group_1__36746 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_rule__Comment__Group_1__4_in_rule__Comment__Group_1__36749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Comment__Group_1__3__Impl6777 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__Comment__Group_1__4__Impl_in_rule__Comment__Group_1__46808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Comment__Group_1__4__Impl6836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comment__Group_1_2__0__Impl_in_rule__Comment__Group_1_2__06877 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Comment__Group_1_2__1_in_rule__Comment__Group_1_2__06880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Comment__Group_1_2__0__Impl6907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comment__Group_1_2__1__Impl_in_rule__Comment__Group_1_2__16936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comment__StringsAssignment_1_2_1_in_rule__Comment__Group_1_2__1__Impl6963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__06997 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__07000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Definition__Group_0__0__Impl7028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__17059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl7086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__07120 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__07123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Definition__Group_1__0__Impl7151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__17182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl7209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__07243 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__07246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Definition__Group_2__0__Impl7274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__17305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl7332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__07366 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__07369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Definition__Group_3__0__Impl7397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__17428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl7455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__07489 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__07492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Definition__Group_4__0__Impl7520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__17551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl7578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_rule__Model__DiagramsAssignment7617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_17648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Instruction__NameAssignment_0_07679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Instruction__NameAssignment_0_27710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Comment__StringsAssignment_1_2_17741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_0_17772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_1_17803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_2_17834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_3_17865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_4_17896 = new BitSet(new long[]{0x0000000000000002L});

}