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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ID", "RULE_INT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "'AliceBlue'", "'AntiqueWhite'", "'Aqua'", "'Aquamarine'", "'Azure'", "'Beige'", "'Bisque'", "'Black'", "'BlanchedAlmond'", "'Blue'", "'BlueViolet'", "'Brown'", "'BurlyWood'", "'CadetBlue'", "'Chartreuse'", "'Chocolate'", "'Coral'", "'CornflowerBlue'", "'Cornsilk'", "'Crimson'", "'Cyan'", "'DarkBlue'", "'DarkCyan'", "'DarkGoldenRod'", "'DarkGray'", "'DarkGreen'", "'DarkGrey'", "'DarkKhaki'", "'DarkMagenta'", "'DarkOliveGreen'", "'DarkOrchid'", "'DarkRed'", "'DarkSalmo'", "'DarkSeaGreen'", "'DarkSlateBlue'", "'DarkSlateGray'", "'DarkSlateGrey'", "'DarkTurquoise'", "'DarkViolet'", "'Darkorange'", "'DeepPink'", "'DeepSkyBlue'", "'DimGray'", "'DimGrey'", "'DodgerBlue'", "'FireBrick'", "'FloralWhite'", "'ForestGreen'", "'Fuchsia'", "'Gainsboro'", "'GhostWhite'", "'Gold'", "'GoldenRod'", "'Gray'", "'Green'", "'GreenYellow'", "'Grey'", "'HoneyDew'", "'HotPink'", "'IndianRed'", "'Indigo'", "'Ivory'", "'Khaki'", "'Lavender'", "'LavenderBlush'", "'LawnGreen'", "'LemonChiffon'", "'LightBlue'", "'LightCoral'", "'LightCyan'", "'LightGoldenRodYellow'", "'LightGray'", "'LightGreen'", "'LightGrey'", "'LightPink'", "'LightSalmon'", "'LightSeaGreen'", "'LightSkyBlue'", "'LightSlateGray'", "'LightSlateGrey'", "'LightSteelBlue'", "'LightYellow'", "'Lime'", "'LimeGreen'", "'Linen'", "'Magenta'", "'Maroon'", "'MediumAquaMarine'", "'MediumBlue'", "'MediumOrchid'", "'MediumPurple'", "'MediumSeaGreen'", "'MediumSlateBlue'", "'MediumSpringGreen'", "'MediumTurquoise'", "'MediumVioletRed'", "'MidnightBlue'", "'MintCream'", "'MistyRose'", "'Moccasin'", "'NavajoWhite'", "'Navy'", "'OldLace'", "'Olive'", "'OliveDrab'", "'OrangeRed'", "'Orchid'", "'PaleGoldenRod'", "'PaleGreen'", "'PaleTurquoise'", "'PaleVioletRed'", "'PapayaWhip'", "'PeachPuff'", "'Peru'", "'Pink'", "'Plum'", "'PowderBlue'", "'Purple'", "'Red'", "'RosyBrown'", "'RoyalBlue'", "'SaddleBrown'", "'Salmon'", "'SandyBrown'", "'SeaGreen'", "'Sienna'", "'Silver'", "'SkyBlue'", "'SlateBlue'", "'SlateGray'", "'SlateGrey'", "'Snow'", "'SpringGreen'", "'SteelBlue'", "'Tan'", "'Teal'", "'Thistle'", "'Tomato'", "'Turquoise'", "'Violet'", "'Wheat'", "'White'", "'WhiteSmoke'", "'Yellow'", "'YellowGreen'", "'@startuml'", "'@enduml'", "':'", "'-'", "'>'", "'<'", "'x'", "'\\\\'", "'/'", "'\\\\\\\\'", "'o'", "'|'", "'actor'", "'boundary'", "'control'", "'entity'", "'database'", "'autonumber'", "'#'"
    };
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__146=146;
    public static final int T__50=50;
    public static final int T__145=145;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int T__141=141;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__137=137;
    public static final int T__52=52;
    public static final int T__136=136;
    public static final int T__53=53;
    public static final int T__139=139;
    public static final int T__54=54;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__135=135;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int RULE_ID=6;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=7;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=4;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__166=166;
    public static final int T__165=165;
    public static final int T__168=168;
    public static final int T__167=167;
    public static final int T__162=162;
    public static final int T__161=161;
    public static final int T__164=164;
    public static final int T__163=163;
    public static final int T__160=160;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__159=159;
    public static final int T__30=30;
    public static final int T__158=158;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__155=155;
    public static final int T__154=154;
    public static final int T__157=157;
    public static final int T__156=156;
    public static final int T__151=151;
    public static final int T__150=150;
    public static final int T__153=153;
    public static final int T__152=152;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__148=148;
    public static final int T__41=41;
    public static final int T__147=147;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__149=149;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__10=10;
    public static final int T__98=98;
    public static final int T__173=173;
    public static final int T__172=172;
    public static final int T__174=174;
    public static final int T__171=171;
    public static final int T__170=170;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__169=169;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_SL_COMMENT=5;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=8;
    public static final int RULE_ANY_OTHER=9;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

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

                if ( (LA1_0==156) ) {
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


    // $ANTLR start "entryRuleDefinition"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:172:1: entryRuleDefinition : ruleDefinition EOF ;
    public final void entryRuleDefinition() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:173:1: ( ruleDefinition EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:174:1: ruleDefinition EOF
            {
             before(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition302);
            ruleDefinition();

            state._fsp--;

             after(grammarAccess.getDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition309); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:181:1: ruleDefinition : ( ( rule__Definition__Alternatives ) ) ;
    public final void ruleDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:185:2: ( ( ( rule__Definition__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:186:1: ( ( rule__Definition__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:186:1: ( ( rule__Definition__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:187:1: ( rule__Definition__Alternatives )
            {
             before(grammarAccess.getDefinitionAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:188:1: ( rule__Definition__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:188:2: rule__Definition__Alternatives
            {
            pushFollow(FOLLOW_rule__Definition__Alternatives_in_ruleDefinition335);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:200:1: entryRuleAutoNumber : ruleAutoNumber EOF ;
    public final void entryRuleAutoNumber() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:201:1: ( ruleAutoNumber EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:202:1: ruleAutoNumber EOF
            {
             before(grammarAccess.getAutoNumberRule()); 
            pushFollow(FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber362);
            ruleAutoNumber();

            state._fsp--;

             after(grammarAccess.getAutoNumberRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAutoNumber369); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:209:1: ruleAutoNumber : ( ( rule__AutoNumber__Group__0 ) ) ;
    public final void ruleAutoNumber() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:213:2: ( ( ( rule__AutoNumber__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:214:1: ( ( rule__AutoNumber__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:214:1: ( ( rule__AutoNumber__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:215:1: ( rule__AutoNumber__Group__0 )
            {
             before(grammarAccess.getAutoNumberAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:216:1: ( rule__AutoNumber__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:216:2: rule__AutoNumber__Group__0
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__0_in_ruleAutoNumber395);
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


    // $ANTLR start "entryRuleColor"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:228:1: entryRuleColor : ruleColor EOF ;
    public final void entryRuleColor() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:229:1: ( ruleColor EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:230:1: ruleColor EOF
            {
             before(grammarAccess.getColorRule()); 
            pushFollow(FOLLOW_ruleColor_in_entryRuleColor422);
            ruleColor();

            state._fsp--;

             after(grammarAccess.getColorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColor429); 

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
    // $ANTLR end "entryRuleColor"


    // $ANTLR start "ruleColor"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:237:1: ruleColor : ( ( rule__Color__Group__0 ) ) ;
    public final void ruleColor() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:241:2: ( ( ( rule__Color__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:242:1: ( ( rule__Color__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:242:1: ( ( rule__Color__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:243:1: ( rule__Color__Group__0 )
            {
             before(grammarAccess.getColorAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:244:1: ( rule__Color__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:244:2: rule__Color__Group__0
            {
            pushFollow(FOLLOW_rule__Color__Group__0_in_ruleColor455);
            rule__Color__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getColorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleColor"


    // $ANTLR start "rule__Instruction__Alternatives"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:256:1: rule__Instruction__Alternatives : ( ( ( rule__Instruction__Group_0__0 ) ) | ( RULE_ML_COMMENT ) | ( RULE_SL_COMMENT ) | ( ( rule__Instruction__Group_3__0 ) ) | ( ruleAutoNumber ) );
    public final void rule__Instruction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:260:1: ( ( ( rule__Instruction__Group_0__0 ) ) | ( RULE_ML_COMMENT ) | ( RULE_SL_COMMENT ) | ( ( rule__Instruction__Group_3__0 ) ) | ( ruleAutoNumber ) )
            int alt2=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt2=1;
                }
                break;
            case RULE_ML_COMMENT:
                {
                alt2=2;
                }
                break;
            case RULE_SL_COMMENT:
                {
                alt2=3;
                }
                break;
            case 168:
            case 169:
            case 170:
            case 171:
            case 172:
                {
                alt2=4;
                }
                break;
            case 173:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:261:1: ( ( rule__Instruction__Group_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:261:1: ( ( rule__Instruction__Group_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:262:1: ( rule__Instruction__Group_0__0 )
                    {
                     before(grammarAccess.getInstructionAccess().getGroup_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:263:1: ( rule__Instruction__Group_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:263:2: rule__Instruction__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_0__0_in_rule__Instruction__Alternatives491);
                    rule__Instruction__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInstructionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:267:6: ( RULE_ML_COMMENT )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:267:6: ( RULE_ML_COMMENT )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:268:1: RULE_ML_COMMENT
                    {
                     before(grammarAccess.getInstructionAccess().getML_COMMENTTerminalRuleCall_1()); 
                    match(input,RULE_ML_COMMENT,FOLLOW_RULE_ML_COMMENT_in_rule__Instruction__Alternatives509); 
                     after(grammarAccess.getInstructionAccess().getML_COMMENTTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:273:6: ( RULE_SL_COMMENT )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:273:6: ( RULE_SL_COMMENT )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:274:1: RULE_SL_COMMENT
                    {
                     before(grammarAccess.getInstructionAccess().getSL_COMMENTTerminalRuleCall_2()); 
                    match(input,RULE_SL_COMMENT,FOLLOW_RULE_SL_COMMENT_in_rule__Instruction__Alternatives526); 
                     after(grammarAccess.getInstructionAccess().getSL_COMMENTTerminalRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:279:6: ( ( rule__Instruction__Group_3__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:279:6: ( ( rule__Instruction__Group_3__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:280:1: ( rule__Instruction__Group_3__0 )
                    {
                     before(grammarAccess.getInstructionAccess().getGroup_3()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:281:1: ( rule__Instruction__Group_3__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:281:2: rule__Instruction__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_3__0_in_rule__Instruction__Alternatives543);
                    rule__Instruction__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInstructionAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:285:6: ( ruleAutoNumber )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:285:6: ( ruleAutoNumber )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:286:1: ruleAutoNumber
                    {
                     before(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleAutoNumber_in_rule__Instruction__Alternatives561);
                    ruleAutoNumber();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_4()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:296:1: rule__Sequence__Alternatives : ( ( ( rule__Sequence__Group_0__0 ) ) | ( ( rule__Sequence__Group_1__0 ) ) | ( ( rule__Sequence__Group_2__0 ) ) | ( ( rule__Sequence__Group_3__0 ) ) | ( ( rule__Sequence__Group_4__0 ) ) | ( ( rule__Sequence__Group_5__0 ) ) | ( ( rule__Sequence__Group_6__0 ) ) | ( ( rule__Sequence__Group_7__0 ) ) | ( ( rule__Sequence__Group_8__0 ) ) | ( ( rule__Sequence__Group_9__0 ) ) | ( ( rule__Sequence__Group_10__0 ) ) | ( ( rule__Sequence__Group_11__0 ) ) | ( ( rule__Sequence__Group_12__0 ) ) | ( ( rule__Sequence__Group_13__0 ) ) | ( ( rule__Sequence__Group_14__0 ) ) | ( ( rule__Sequence__Group_15__0 ) ) | ( ( rule__Sequence__Group_16__0 ) ) | ( ( rule__Sequence__Group_17__0 ) ) | ( ( rule__Sequence__Group_18__0 ) ) | ( ( rule__Sequence__Group_19__0 ) ) | ( '.' ) );
    public final void rule__Sequence__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:300:1: ( ( ( rule__Sequence__Group_0__0 ) ) | ( ( rule__Sequence__Group_1__0 ) ) | ( ( rule__Sequence__Group_2__0 ) ) | ( ( rule__Sequence__Group_3__0 ) ) | ( ( rule__Sequence__Group_4__0 ) ) | ( ( rule__Sequence__Group_5__0 ) ) | ( ( rule__Sequence__Group_6__0 ) ) | ( ( rule__Sequence__Group_7__0 ) ) | ( ( rule__Sequence__Group_8__0 ) ) | ( ( rule__Sequence__Group_9__0 ) ) | ( ( rule__Sequence__Group_10__0 ) ) | ( ( rule__Sequence__Group_11__0 ) ) | ( ( rule__Sequence__Group_12__0 ) ) | ( ( rule__Sequence__Group_13__0 ) ) | ( ( rule__Sequence__Group_14__0 ) ) | ( ( rule__Sequence__Group_15__0 ) ) | ( ( rule__Sequence__Group_16__0 ) ) | ( ( rule__Sequence__Group_17__0 ) ) | ( ( rule__Sequence__Group_18__0 ) ) | ( ( rule__Sequence__Group_19__0 ) ) | ( '.' ) )
            int alt3=21;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:301:1: ( ( rule__Sequence__Group_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:301:1: ( ( rule__Sequence__Group_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:302:1: ( rule__Sequence__Group_0__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:303:1: ( rule__Sequence__Group_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:303:2: rule__Sequence__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_0__0_in_rule__Sequence__Alternatives593);
                    rule__Sequence__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:307:6: ( ( rule__Sequence__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:307:6: ( ( rule__Sequence__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:308:1: ( rule__Sequence__Group_1__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:309:1: ( rule__Sequence__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:309:2: rule__Sequence__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_1__0_in_rule__Sequence__Alternatives611);
                    rule__Sequence__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:313:6: ( ( rule__Sequence__Group_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:313:6: ( ( rule__Sequence__Group_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:314:1: ( rule__Sequence__Group_2__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:315:1: ( rule__Sequence__Group_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:315:2: rule__Sequence__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_2__0_in_rule__Sequence__Alternatives629);
                    rule__Sequence__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:319:6: ( ( rule__Sequence__Group_3__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:319:6: ( ( rule__Sequence__Group_3__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:320:1: ( rule__Sequence__Group_3__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_3()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:321:1: ( rule__Sequence__Group_3__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:321:2: rule__Sequence__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_3__0_in_rule__Sequence__Alternatives647);
                    rule__Sequence__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:325:6: ( ( rule__Sequence__Group_4__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:325:6: ( ( rule__Sequence__Group_4__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:326:1: ( rule__Sequence__Group_4__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_4()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:327:1: ( rule__Sequence__Group_4__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:327:2: rule__Sequence__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_4__0_in_rule__Sequence__Alternatives665);
                    rule__Sequence__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:331:6: ( ( rule__Sequence__Group_5__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:331:6: ( ( rule__Sequence__Group_5__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:332:1: ( rule__Sequence__Group_5__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_5()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:333:1: ( rule__Sequence__Group_5__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:333:2: rule__Sequence__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_5__0_in_rule__Sequence__Alternatives683);
                    rule__Sequence__Group_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:337:6: ( ( rule__Sequence__Group_6__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:337:6: ( ( rule__Sequence__Group_6__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:338:1: ( rule__Sequence__Group_6__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_6()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:339:1: ( rule__Sequence__Group_6__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:339:2: rule__Sequence__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_6__0_in_rule__Sequence__Alternatives701);
                    rule__Sequence__Group_6__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:343:6: ( ( rule__Sequence__Group_7__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:343:6: ( ( rule__Sequence__Group_7__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:344:1: ( rule__Sequence__Group_7__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_7()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:345:1: ( rule__Sequence__Group_7__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:345:2: rule__Sequence__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_7__0_in_rule__Sequence__Alternatives719);
                    rule__Sequence__Group_7__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:349:6: ( ( rule__Sequence__Group_8__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:349:6: ( ( rule__Sequence__Group_8__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:350:1: ( rule__Sequence__Group_8__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_8()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:351:1: ( rule__Sequence__Group_8__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:351:2: rule__Sequence__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_8__0_in_rule__Sequence__Alternatives737);
                    rule__Sequence__Group_8__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:355:6: ( ( rule__Sequence__Group_9__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:355:6: ( ( rule__Sequence__Group_9__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:356:1: ( rule__Sequence__Group_9__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_9()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:357:1: ( rule__Sequence__Group_9__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:357:2: rule__Sequence__Group_9__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_9__0_in_rule__Sequence__Alternatives755);
                    rule__Sequence__Group_9__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:361:6: ( ( rule__Sequence__Group_10__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:361:6: ( ( rule__Sequence__Group_10__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:362:1: ( rule__Sequence__Group_10__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_10()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:363:1: ( rule__Sequence__Group_10__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:363:2: rule__Sequence__Group_10__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_10__0_in_rule__Sequence__Alternatives773);
                    rule__Sequence__Group_10__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:367:6: ( ( rule__Sequence__Group_11__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:367:6: ( ( rule__Sequence__Group_11__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:368:1: ( rule__Sequence__Group_11__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_11()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:369:1: ( rule__Sequence__Group_11__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:369:2: rule__Sequence__Group_11__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_11__0_in_rule__Sequence__Alternatives791);
                    rule__Sequence__Group_11__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:373:6: ( ( rule__Sequence__Group_12__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:373:6: ( ( rule__Sequence__Group_12__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:374:1: ( rule__Sequence__Group_12__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_12()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:375:1: ( rule__Sequence__Group_12__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:375:2: rule__Sequence__Group_12__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_12__0_in_rule__Sequence__Alternatives809);
                    rule__Sequence__Group_12__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:379:6: ( ( rule__Sequence__Group_13__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:379:6: ( ( rule__Sequence__Group_13__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:380:1: ( rule__Sequence__Group_13__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_13()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:381:1: ( rule__Sequence__Group_13__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:381:2: rule__Sequence__Group_13__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_13__0_in_rule__Sequence__Alternatives827);
                    rule__Sequence__Group_13__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:385:6: ( ( rule__Sequence__Group_14__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:385:6: ( ( rule__Sequence__Group_14__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:386:1: ( rule__Sequence__Group_14__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_14()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:387:1: ( rule__Sequence__Group_14__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:387:2: rule__Sequence__Group_14__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_14__0_in_rule__Sequence__Alternatives845);
                    rule__Sequence__Group_14__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:391:6: ( ( rule__Sequence__Group_15__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:391:6: ( ( rule__Sequence__Group_15__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:392:1: ( rule__Sequence__Group_15__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_15()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:393:1: ( rule__Sequence__Group_15__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:393:2: rule__Sequence__Group_15__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_15__0_in_rule__Sequence__Alternatives863);
                    rule__Sequence__Group_15__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:397:6: ( ( rule__Sequence__Group_16__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:397:6: ( ( rule__Sequence__Group_16__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:398:1: ( rule__Sequence__Group_16__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_16()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:399:1: ( rule__Sequence__Group_16__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:399:2: rule__Sequence__Group_16__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_16__0_in_rule__Sequence__Alternatives881);
                    rule__Sequence__Group_16__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:403:6: ( ( rule__Sequence__Group_17__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:403:6: ( ( rule__Sequence__Group_17__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:404:1: ( rule__Sequence__Group_17__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_17()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:405:1: ( rule__Sequence__Group_17__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:405:2: rule__Sequence__Group_17__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_17__0_in_rule__Sequence__Alternatives899);
                    rule__Sequence__Group_17__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:409:6: ( ( rule__Sequence__Group_18__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:409:6: ( ( rule__Sequence__Group_18__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:410:1: ( rule__Sequence__Group_18__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_18()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:411:1: ( rule__Sequence__Group_18__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:411:2: rule__Sequence__Group_18__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_18__0_in_rule__Sequence__Alternatives917);
                    rule__Sequence__Group_18__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:415:6: ( ( rule__Sequence__Group_19__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:415:6: ( ( rule__Sequence__Group_19__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:416:1: ( rule__Sequence__Group_19__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_19()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:417:1: ( rule__Sequence__Group_19__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:417:2: rule__Sequence__Group_19__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_19__0_in_rule__Sequence__Alternatives935);
                    rule__Sequence__Group_19__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:421:6: ( '.' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:421:6: ( '.' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:422:1: '.'
                    {
                     before(grammarAccess.getSequenceAccess().getFullStopKeyword_20()); 
                    match(input,10,FOLLOW_10_in_rule__Sequence__Alternatives954); 
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


    // $ANTLR start "rule__Definition__Alternatives"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:434:1: rule__Definition__Alternatives : ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) );
    public final void rule__Definition__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:438:1: ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 168:
                {
                alt4=1;
                }
                break;
            case 169:
                {
                alt4=2;
                }
                break;
            case 170:
                {
                alt4=3;
                }
                break;
            case 171:
                {
                alt4=4;
                }
                break;
            case 172:
                {
                alt4=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:439:1: ( ( rule__Definition__Group_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:439:1: ( ( rule__Definition__Group_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:440:1: ( rule__Definition__Group_0__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:441:1: ( rule__Definition__Group_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:441:2: rule__Definition__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives988);
                    rule__Definition__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:445:6: ( ( rule__Definition__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:445:6: ( ( rule__Definition__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:446:1: ( rule__Definition__Group_1__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:447:1: ( rule__Definition__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:447:2: rule__Definition__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives1006);
                    rule__Definition__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:451:6: ( ( rule__Definition__Group_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:451:6: ( ( rule__Definition__Group_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:452:1: ( rule__Definition__Group_2__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:453:1: ( rule__Definition__Group_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:453:2: rule__Definition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives1024);
                    rule__Definition__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:457:6: ( ( rule__Definition__Group_3__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:457:6: ( ( rule__Definition__Group_3__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:458:1: ( rule__Definition__Group_3__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_3()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:459:1: ( rule__Definition__Group_3__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:459:2: rule__Definition__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives1042);
                    rule__Definition__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:463:6: ( ( rule__Definition__Group_4__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:463:6: ( ( rule__Definition__Group_4__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:464:1: ( rule__Definition__Group_4__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_4()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:465:1: ( rule__Definition__Group_4__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:465:2: rule__Definition__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives1060);
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


    // $ANTLR start "rule__Color__Alternatives_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:474:1: rule__Color__Alternatives_1 : ( ( 'AliceBlue' ) | ( 'AntiqueWhite' ) | ( 'Aqua' ) | ( 'Aquamarine' ) | ( 'Azure' ) | ( 'Beige' ) | ( 'Bisque' ) | ( 'Black' ) | ( 'BlanchedAlmond' ) | ( 'Blue' ) | ( 'BlueViolet' ) | ( 'Brown' ) | ( 'BurlyWood' ) | ( 'CadetBlue' ) | ( 'Chartreuse' ) | ( 'Chocolate' ) | ( 'Coral' ) | ( 'CornflowerBlue' ) | ( 'Cornsilk' ) | ( 'Crimson' ) | ( 'Cyan' ) | ( 'DarkBlue' ) | ( 'DarkCyan' ) | ( 'DarkGoldenRod' ) | ( 'DarkGray' ) | ( 'DarkGreen' ) | ( 'DarkGrey' ) | ( 'DarkKhaki' ) | ( 'DarkMagenta' ) | ( 'DarkOliveGreen' ) | ( 'DarkOrchid' ) | ( 'DarkRed' ) | ( 'DarkSalmo' ) | ( 'DarkSeaGreen' ) | ( 'DarkSlateBlue' ) | ( 'DarkSlateGray' ) | ( 'DarkSlateGrey' ) | ( 'DarkTurquoise' ) | ( 'DarkViolet' ) | ( 'Darkorange' ) | ( 'DeepPink' ) | ( 'DeepSkyBlue' ) | ( 'DimGray' ) | ( 'DimGrey' ) | ( 'DodgerBlue' ) | ( 'FireBrick' ) | ( 'FloralWhite' ) | ( 'ForestGreen' ) | ( 'Fuchsia' ) | ( 'Gainsboro' ) | ( 'GhostWhite' ) | ( 'Gold' ) | ( 'GoldenRod' ) | ( 'Gray' ) | ( 'Green' ) | ( 'GreenYellow' ) | ( 'Grey' ) | ( 'HoneyDew' ) | ( 'HotPink' ) | ( 'IndianRed' ) | ( 'Indigo' ) | ( 'Ivory' ) | ( 'Khaki' ) | ( 'Lavender' ) | ( 'LavenderBlush' ) | ( 'LawnGreen' ) | ( 'LemonChiffon' ) | ( 'LightBlue' ) | ( 'LightCoral' ) | ( 'LightCyan' ) | ( 'LightGoldenRodYellow' ) | ( 'LightGray' ) | ( 'LightGreen' ) | ( 'LightGrey' ) | ( 'LightPink' ) | ( 'LightSalmon' ) | ( 'LightSeaGreen' ) | ( 'LightSkyBlue' ) | ( 'LightSlateGray' ) | ( 'LightSlateGrey' ) | ( 'LightSteelBlue' ) | ( 'LightYellow' ) | ( 'Lime' ) | ( 'LimeGreen' ) | ( 'Linen' ) | ( 'Magenta' ) | ( 'Maroon' ) | ( 'MediumAquaMarine' ) | ( 'MediumBlue' ) | ( 'MediumOrchid' ) | ( 'MediumPurple' ) | ( 'MediumSeaGreen' ) | ( 'MediumSlateBlue' ) | ( 'MediumSpringGreen' ) | ( 'MediumTurquoise' ) | ( 'MediumVioletRed' ) | ( 'MidnightBlue' ) | ( 'MintCream' ) | ( 'MistyRose' ) | ( 'Moccasin' ) | ( 'NavajoWhite' ) | ( 'Navy' ) | ( 'OldLace' ) | ( 'Olive' ) | ( 'OliveDrab' ) | ( 'OrangeRed' ) | ( 'Orchid' ) | ( 'PaleGoldenRod' ) | ( 'PaleGreen' ) | ( 'PaleTurquoise' ) | ( 'PaleVioletRed' ) | ( 'PapayaWhip' ) | ( 'PeachPuff' ) | ( 'Peru' ) | ( 'Pink' ) | ( 'Plum' ) | ( 'PowderBlue' ) | ( 'Purple' ) | ( 'Red' ) | ( 'RosyBrown' ) | ( 'RoyalBlue' ) | ( 'SaddleBrown' ) | ( 'Salmon' ) | ( 'SandyBrown' ) | ( 'SeaGreen' ) | ( 'Sienna' ) | ( 'Silver' ) | ( 'SkyBlue' ) | ( 'SlateBlue' ) | ( 'SlateGray' ) | ( 'SlateGrey' ) | ( 'Snow' ) | ( 'SpringGreen' ) | ( 'SteelBlue' ) | ( 'Tan' ) | ( 'Teal' ) | ( 'Thistle' ) | ( 'Tomato' ) | ( 'Turquoise' ) | ( 'Violet' ) | ( 'Wheat' ) | ( 'White' ) | ( 'WhiteSmoke' ) | ( 'Yellow' ) | ( 'YellowGreen' ) );
    public final void rule__Color__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:478:1: ( ( 'AliceBlue' ) | ( 'AntiqueWhite' ) | ( 'Aqua' ) | ( 'Aquamarine' ) | ( 'Azure' ) | ( 'Beige' ) | ( 'Bisque' ) | ( 'Black' ) | ( 'BlanchedAlmond' ) | ( 'Blue' ) | ( 'BlueViolet' ) | ( 'Brown' ) | ( 'BurlyWood' ) | ( 'CadetBlue' ) | ( 'Chartreuse' ) | ( 'Chocolate' ) | ( 'Coral' ) | ( 'CornflowerBlue' ) | ( 'Cornsilk' ) | ( 'Crimson' ) | ( 'Cyan' ) | ( 'DarkBlue' ) | ( 'DarkCyan' ) | ( 'DarkGoldenRod' ) | ( 'DarkGray' ) | ( 'DarkGreen' ) | ( 'DarkGrey' ) | ( 'DarkKhaki' ) | ( 'DarkMagenta' ) | ( 'DarkOliveGreen' ) | ( 'DarkOrchid' ) | ( 'DarkRed' ) | ( 'DarkSalmo' ) | ( 'DarkSeaGreen' ) | ( 'DarkSlateBlue' ) | ( 'DarkSlateGray' ) | ( 'DarkSlateGrey' ) | ( 'DarkTurquoise' ) | ( 'DarkViolet' ) | ( 'Darkorange' ) | ( 'DeepPink' ) | ( 'DeepSkyBlue' ) | ( 'DimGray' ) | ( 'DimGrey' ) | ( 'DodgerBlue' ) | ( 'FireBrick' ) | ( 'FloralWhite' ) | ( 'ForestGreen' ) | ( 'Fuchsia' ) | ( 'Gainsboro' ) | ( 'GhostWhite' ) | ( 'Gold' ) | ( 'GoldenRod' ) | ( 'Gray' ) | ( 'Green' ) | ( 'GreenYellow' ) | ( 'Grey' ) | ( 'HoneyDew' ) | ( 'HotPink' ) | ( 'IndianRed' ) | ( 'Indigo' ) | ( 'Ivory' ) | ( 'Khaki' ) | ( 'Lavender' ) | ( 'LavenderBlush' ) | ( 'LawnGreen' ) | ( 'LemonChiffon' ) | ( 'LightBlue' ) | ( 'LightCoral' ) | ( 'LightCyan' ) | ( 'LightGoldenRodYellow' ) | ( 'LightGray' ) | ( 'LightGreen' ) | ( 'LightGrey' ) | ( 'LightPink' ) | ( 'LightSalmon' ) | ( 'LightSeaGreen' ) | ( 'LightSkyBlue' ) | ( 'LightSlateGray' ) | ( 'LightSlateGrey' ) | ( 'LightSteelBlue' ) | ( 'LightYellow' ) | ( 'Lime' ) | ( 'LimeGreen' ) | ( 'Linen' ) | ( 'Magenta' ) | ( 'Maroon' ) | ( 'MediumAquaMarine' ) | ( 'MediumBlue' ) | ( 'MediumOrchid' ) | ( 'MediumPurple' ) | ( 'MediumSeaGreen' ) | ( 'MediumSlateBlue' ) | ( 'MediumSpringGreen' ) | ( 'MediumTurquoise' ) | ( 'MediumVioletRed' ) | ( 'MidnightBlue' ) | ( 'MintCream' ) | ( 'MistyRose' ) | ( 'Moccasin' ) | ( 'NavajoWhite' ) | ( 'Navy' ) | ( 'OldLace' ) | ( 'Olive' ) | ( 'OliveDrab' ) | ( 'OrangeRed' ) | ( 'Orchid' ) | ( 'PaleGoldenRod' ) | ( 'PaleGreen' ) | ( 'PaleTurquoise' ) | ( 'PaleVioletRed' ) | ( 'PapayaWhip' ) | ( 'PeachPuff' ) | ( 'Peru' ) | ( 'Pink' ) | ( 'Plum' ) | ( 'PowderBlue' ) | ( 'Purple' ) | ( 'Red' ) | ( 'RosyBrown' ) | ( 'RoyalBlue' ) | ( 'SaddleBrown' ) | ( 'Salmon' ) | ( 'SandyBrown' ) | ( 'SeaGreen' ) | ( 'Sienna' ) | ( 'Silver' ) | ( 'SkyBlue' ) | ( 'SlateBlue' ) | ( 'SlateGray' ) | ( 'SlateGrey' ) | ( 'Snow' ) | ( 'SpringGreen' ) | ( 'SteelBlue' ) | ( 'Tan' ) | ( 'Teal' ) | ( 'Thistle' ) | ( 'Tomato' ) | ( 'Turquoise' ) | ( 'Violet' ) | ( 'Wheat' ) | ( 'White' ) | ( 'WhiteSmoke' ) | ( 'Yellow' ) | ( 'YellowGreen' ) )
            int alt5=145;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt5=1;
                }
                break;
            case 12:
                {
                alt5=2;
                }
                break;
            case 13:
                {
                alt5=3;
                }
                break;
            case 14:
                {
                alt5=4;
                }
                break;
            case 15:
                {
                alt5=5;
                }
                break;
            case 16:
                {
                alt5=6;
                }
                break;
            case 17:
                {
                alt5=7;
                }
                break;
            case 18:
                {
                alt5=8;
                }
                break;
            case 19:
                {
                alt5=9;
                }
                break;
            case 20:
                {
                alt5=10;
                }
                break;
            case 21:
                {
                alt5=11;
                }
                break;
            case 22:
                {
                alt5=12;
                }
                break;
            case 23:
                {
                alt5=13;
                }
                break;
            case 24:
                {
                alt5=14;
                }
                break;
            case 25:
                {
                alt5=15;
                }
                break;
            case 26:
                {
                alt5=16;
                }
                break;
            case 27:
                {
                alt5=17;
                }
                break;
            case 28:
                {
                alt5=18;
                }
                break;
            case 29:
                {
                alt5=19;
                }
                break;
            case 30:
                {
                alt5=20;
                }
                break;
            case 31:
                {
                alt5=21;
                }
                break;
            case 32:
                {
                alt5=22;
                }
                break;
            case 33:
                {
                alt5=23;
                }
                break;
            case 34:
                {
                alt5=24;
                }
                break;
            case 35:
                {
                alt5=25;
                }
                break;
            case 36:
                {
                alt5=26;
                }
                break;
            case 37:
                {
                alt5=27;
                }
                break;
            case 38:
                {
                alt5=28;
                }
                break;
            case 39:
                {
                alt5=29;
                }
                break;
            case 40:
                {
                alt5=30;
                }
                break;
            case 41:
                {
                alt5=31;
                }
                break;
            case 42:
                {
                alt5=32;
                }
                break;
            case 43:
                {
                alt5=33;
                }
                break;
            case 44:
                {
                alt5=34;
                }
                break;
            case 45:
                {
                alt5=35;
                }
                break;
            case 46:
                {
                alt5=36;
                }
                break;
            case 47:
                {
                alt5=37;
                }
                break;
            case 48:
                {
                alt5=38;
                }
                break;
            case 49:
                {
                alt5=39;
                }
                break;
            case 50:
                {
                alt5=40;
                }
                break;
            case 51:
                {
                alt5=41;
                }
                break;
            case 52:
                {
                alt5=42;
                }
                break;
            case 53:
                {
                alt5=43;
                }
                break;
            case 54:
                {
                alt5=44;
                }
                break;
            case 55:
                {
                alt5=45;
                }
                break;
            case 56:
                {
                alt5=46;
                }
                break;
            case 57:
                {
                alt5=47;
                }
                break;
            case 58:
                {
                alt5=48;
                }
                break;
            case 59:
                {
                alt5=49;
                }
                break;
            case 60:
                {
                alt5=50;
                }
                break;
            case 61:
                {
                alt5=51;
                }
                break;
            case 62:
                {
                alt5=52;
                }
                break;
            case 63:
                {
                alt5=53;
                }
                break;
            case 64:
                {
                alt5=54;
                }
                break;
            case 65:
                {
                alt5=55;
                }
                break;
            case 66:
                {
                alt5=56;
                }
                break;
            case 67:
                {
                alt5=57;
                }
                break;
            case 68:
                {
                alt5=58;
                }
                break;
            case 69:
                {
                alt5=59;
                }
                break;
            case 70:
                {
                alt5=60;
                }
                break;
            case 71:
                {
                alt5=61;
                }
                break;
            case 72:
                {
                alt5=62;
                }
                break;
            case 73:
                {
                alt5=63;
                }
                break;
            case 74:
                {
                alt5=64;
                }
                break;
            case 75:
                {
                alt5=65;
                }
                break;
            case 76:
                {
                alt5=66;
                }
                break;
            case 77:
                {
                alt5=67;
                }
                break;
            case 78:
                {
                alt5=68;
                }
                break;
            case 79:
                {
                alt5=69;
                }
                break;
            case 80:
                {
                alt5=70;
                }
                break;
            case 81:
                {
                alt5=71;
                }
                break;
            case 82:
                {
                alt5=72;
                }
                break;
            case 83:
                {
                alt5=73;
                }
                break;
            case 84:
                {
                alt5=74;
                }
                break;
            case 85:
                {
                alt5=75;
                }
                break;
            case 86:
                {
                alt5=76;
                }
                break;
            case 87:
                {
                alt5=77;
                }
                break;
            case 88:
                {
                alt5=78;
                }
                break;
            case 89:
                {
                alt5=79;
                }
                break;
            case 90:
                {
                alt5=80;
                }
                break;
            case 91:
                {
                alt5=81;
                }
                break;
            case 92:
                {
                alt5=82;
                }
                break;
            case 93:
                {
                alt5=83;
                }
                break;
            case 94:
                {
                alt5=84;
                }
                break;
            case 95:
                {
                alt5=85;
                }
                break;
            case 96:
                {
                alt5=86;
                }
                break;
            case 97:
                {
                alt5=87;
                }
                break;
            case 98:
                {
                alt5=88;
                }
                break;
            case 99:
                {
                alt5=89;
                }
                break;
            case 100:
                {
                alt5=90;
                }
                break;
            case 101:
                {
                alt5=91;
                }
                break;
            case 102:
                {
                alt5=92;
                }
                break;
            case 103:
                {
                alt5=93;
                }
                break;
            case 104:
                {
                alt5=94;
                }
                break;
            case 105:
                {
                alt5=95;
                }
                break;
            case 106:
                {
                alt5=96;
                }
                break;
            case 107:
                {
                alt5=97;
                }
                break;
            case 108:
                {
                alt5=98;
                }
                break;
            case 109:
                {
                alt5=99;
                }
                break;
            case 110:
                {
                alt5=100;
                }
                break;
            case 111:
                {
                alt5=101;
                }
                break;
            case 112:
                {
                alt5=102;
                }
                break;
            case 113:
                {
                alt5=103;
                }
                break;
            case 114:
                {
                alt5=104;
                }
                break;
            case 115:
                {
                alt5=105;
                }
                break;
            case 116:
                {
                alt5=106;
                }
                break;
            case 117:
                {
                alt5=107;
                }
                break;
            case 118:
                {
                alt5=108;
                }
                break;
            case 119:
                {
                alt5=109;
                }
                break;
            case 120:
                {
                alt5=110;
                }
                break;
            case 121:
                {
                alt5=111;
                }
                break;
            case 122:
                {
                alt5=112;
                }
                break;
            case 123:
                {
                alt5=113;
                }
                break;
            case 124:
                {
                alt5=114;
                }
                break;
            case 125:
                {
                alt5=115;
                }
                break;
            case 126:
                {
                alt5=116;
                }
                break;
            case 127:
                {
                alt5=117;
                }
                break;
            case 128:
                {
                alt5=118;
                }
                break;
            case 129:
                {
                alt5=119;
                }
                break;
            case 130:
                {
                alt5=120;
                }
                break;
            case 131:
                {
                alt5=121;
                }
                break;
            case 132:
                {
                alt5=122;
                }
                break;
            case 133:
                {
                alt5=123;
                }
                break;
            case 134:
                {
                alt5=124;
                }
                break;
            case 135:
                {
                alt5=125;
                }
                break;
            case 136:
                {
                alt5=126;
                }
                break;
            case 137:
                {
                alt5=127;
                }
                break;
            case 138:
                {
                alt5=128;
                }
                break;
            case 139:
                {
                alt5=129;
                }
                break;
            case 140:
                {
                alt5=130;
                }
                break;
            case 141:
                {
                alt5=131;
                }
                break;
            case 142:
                {
                alt5=132;
                }
                break;
            case 143:
                {
                alt5=133;
                }
                break;
            case 144:
                {
                alt5=134;
                }
                break;
            case 145:
                {
                alt5=135;
                }
                break;
            case 146:
                {
                alt5=136;
                }
                break;
            case 147:
                {
                alt5=137;
                }
                break;
            case 148:
                {
                alt5=138;
                }
                break;
            case 149:
                {
                alt5=139;
                }
                break;
            case 150:
                {
                alt5=140;
                }
                break;
            case 151:
                {
                alt5=141;
                }
                break;
            case 152:
                {
                alt5=142;
                }
                break;
            case 153:
                {
                alt5=143;
                }
                break;
            case 154:
                {
                alt5=144;
                }
                break;
            case 155:
                {
                alt5=145;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:479:1: ( 'AliceBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:479:1: ( 'AliceBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:480:1: 'AliceBlue'
                    {
                     before(grammarAccess.getColorAccess().getAliceBlueKeyword_1_0()); 
                    match(input,11,FOLLOW_11_in_rule__Color__Alternatives_11094); 
                     after(grammarAccess.getColorAccess().getAliceBlueKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:487:6: ( 'AntiqueWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:487:6: ( 'AntiqueWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:488:1: 'AntiqueWhite'
                    {
                     before(grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1_1()); 
                    match(input,12,FOLLOW_12_in_rule__Color__Alternatives_11114); 
                     after(grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:495:6: ( 'Aqua' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:495:6: ( 'Aqua' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:496:1: 'Aqua'
                    {
                     before(grammarAccess.getColorAccess().getAquaKeyword_1_2()); 
                    match(input,13,FOLLOW_13_in_rule__Color__Alternatives_11134); 
                     after(grammarAccess.getColorAccess().getAquaKeyword_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:503:6: ( 'Aquamarine' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:503:6: ( 'Aquamarine' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:504:1: 'Aquamarine'
                    {
                     before(grammarAccess.getColorAccess().getAquamarineKeyword_1_3()); 
                    match(input,14,FOLLOW_14_in_rule__Color__Alternatives_11154); 
                     after(grammarAccess.getColorAccess().getAquamarineKeyword_1_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:511:6: ( 'Azure' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:511:6: ( 'Azure' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:512:1: 'Azure'
                    {
                     before(grammarAccess.getColorAccess().getAzureKeyword_1_4()); 
                    match(input,15,FOLLOW_15_in_rule__Color__Alternatives_11174); 
                     after(grammarAccess.getColorAccess().getAzureKeyword_1_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:519:6: ( 'Beige' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:519:6: ( 'Beige' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:520:1: 'Beige'
                    {
                     before(grammarAccess.getColorAccess().getBeigeKeyword_1_5()); 
                    match(input,16,FOLLOW_16_in_rule__Color__Alternatives_11194); 
                     after(grammarAccess.getColorAccess().getBeigeKeyword_1_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:527:6: ( 'Bisque' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:527:6: ( 'Bisque' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:528:1: 'Bisque'
                    {
                     before(grammarAccess.getColorAccess().getBisqueKeyword_1_6()); 
                    match(input,17,FOLLOW_17_in_rule__Color__Alternatives_11214); 
                     after(grammarAccess.getColorAccess().getBisqueKeyword_1_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:535:6: ( 'Black' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:535:6: ( 'Black' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:536:1: 'Black'
                    {
                     before(grammarAccess.getColorAccess().getBlackKeyword_1_7()); 
                    match(input,18,FOLLOW_18_in_rule__Color__Alternatives_11234); 
                     after(grammarAccess.getColorAccess().getBlackKeyword_1_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:543:6: ( 'BlanchedAlmond' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:543:6: ( 'BlanchedAlmond' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:544:1: 'BlanchedAlmond'
                    {
                     before(grammarAccess.getColorAccess().getBlanchedAlmondKeyword_1_8()); 
                    match(input,19,FOLLOW_19_in_rule__Color__Alternatives_11254); 
                     after(grammarAccess.getColorAccess().getBlanchedAlmondKeyword_1_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:551:6: ( 'Blue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:551:6: ( 'Blue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:552:1: 'Blue'
                    {
                     before(grammarAccess.getColorAccess().getBlueKeyword_1_9()); 
                    match(input,20,FOLLOW_20_in_rule__Color__Alternatives_11274); 
                     after(grammarAccess.getColorAccess().getBlueKeyword_1_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:559:6: ( 'BlueViolet' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:559:6: ( 'BlueViolet' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:560:1: 'BlueViolet'
                    {
                     before(grammarAccess.getColorAccess().getBlueVioletKeyword_1_10()); 
                    match(input,21,FOLLOW_21_in_rule__Color__Alternatives_11294); 
                     after(grammarAccess.getColorAccess().getBlueVioletKeyword_1_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:567:6: ( 'Brown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:567:6: ( 'Brown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:568:1: 'Brown'
                    {
                     before(grammarAccess.getColorAccess().getBrownKeyword_1_11()); 
                    match(input,22,FOLLOW_22_in_rule__Color__Alternatives_11314); 
                     after(grammarAccess.getColorAccess().getBrownKeyword_1_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:575:6: ( 'BurlyWood' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:575:6: ( 'BurlyWood' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:576:1: 'BurlyWood'
                    {
                     before(grammarAccess.getColorAccess().getBurlyWoodKeyword_1_12()); 
                    match(input,23,FOLLOW_23_in_rule__Color__Alternatives_11334); 
                     after(grammarAccess.getColorAccess().getBurlyWoodKeyword_1_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:583:6: ( 'CadetBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:583:6: ( 'CadetBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:584:1: 'CadetBlue'
                    {
                     before(grammarAccess.getColorAccess().getCadetBlueKeyword_1_13()); 
                    match(input,24,FOLLOW_24_in_rule__Color__Alternatives_11354); 
                     after(grammarAccess.getColorAccess().getCadetBlueKeyword_1_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:591:6: ( 'Chartreuse' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:591:6: ( 'Chartreuse' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:592:1: 'Chartreuse'
                    {
                     before(grammarAccess.getColorAccess().getChartreuseKeyword_1_14()); 
                    match(input,25,FOLLOW_25_in_rule__Color__Alternatives_11374); 
                     after(grammarAccess.getColorAccess().getChartreuseKeyword_1_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:599:6: ( 'Chocolate' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:599:6: ( 'Chocolate' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:600:1: 'Chocolate'
                    {
                     before(grammarAccess.getColorAccess().getChocolateKeyword_1_15()); 
                    match(input,26,FOLLOW_26_in_rule__Color__Alternatives_11394); 
                     after(grammarAccess.getColorAccess().getChocolateKeyword_1_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:607:6: ( 'Coral' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:607:6: ( 'Coral' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:608:1: 'Coral'
                    {
                     before(grammarAccess.getColorAccess().getCoralKeyword_1_16()); 
                    match(input,27,FOLLOW_27_in_rule__Color__Alternatives_11414); 
                     after(grammarAccess.getColorAccess().getCoralKeyword_1_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:615:6: ( 'CornflowerBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:615:6: ( 'CornflowerBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:616:1: 'CornflowerBlue'
                    {
                     before(grammarAccess.getColorAccess().getCornflowerBlueKeyword_1_17()); 
                    match(input,28,FOLLOW_28_in_rule__Color__Alternatives_11434); 
                     after(grammarAccess.getColorAccess().getCornflowerBlueKeyword_1_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:623:6: ( 'Cornsilk' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:623:6: ( 'Cornsilk' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:624:1: 'Cornsilk'
                    {
                     before(grammarAccess.getColorAccess().getCornsilkKeyword_1_18()); 
                    match(input,29,FOLLOW_29_in_rule__Color__Alternatives_11454); 
                     after(grammarAccess.getColorAccess().getCornsilkKeyword_1_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:631:6: ( 'Crimson' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:631:6: ( 'Crimson' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:632:1: 'Crimson'
                    {
                     before(grammarAccess.getColorAccess().getCrimsonKeyword_1_19()); 
                    match(input,30,FOLLOW_30_in_rule__Color__Alternatives_11474); 
                     after(grammarAccess.getColorAccess().getCrimsonKeyword_1_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:639:6: ( 'Cyan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:639:6: ( 'Cyan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:640:1: 'Cyan'
                    {
                     before(grammarAccess.getColorAccess().getCyanKeyword_1_20()); 
                    match(input,31,FOLLOW_31_in_rule__Color__Alternatives_11494); 
                     after(grammarAccess.getColorAccess().getCyanKeyword_1_20()); 

                    }


                    }
                    break;
                case 22 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:647:6: ( 'DarkBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:647:6: ( 'DarkBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:648:1: 'DarkBlue'
                    {
                     before(grammarAccess.getColorAccess().getDarkBlueKeyword_1_21()); 
                    match(input,32,FOLLOW_32_in_rule__Color__Alternatives_11514); 
                     after(grammarAccess.getColorAccess().getDarkBlueKeyword_1_21()); 

                    }


                    }
                    break;
                case 23 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:655:6: ( 'DarkCyan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:655:6: ( 'DarkCyan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:656:1: 'DarkCyan'
                    {
                     before(grammarAccess.getColorAccess().getDarkCyanKeyword_1_22()); 
                    match(input,33,FOLLOW_33_in_rule__Color__Alternatives_11534); 
                     after(grammarAccess.getColorAccess().getDarkCyanKeyword_1_22()); 

                    }


                    }
                    break;
                case 24 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:663:6: ( 'DarkGoldenRod' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:663:6: ( 'DarkGoldenRod' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:664:1: 'DarkGoldenRod'
                    {
                     before(grammarAccess.getColorAccess().getDarkGoldenRodKeyword_1_23()); 
                    match(input,34,FOLLOW_34_in_rule__Color__Alternatives_11554); 
                     after(grammarAccess.getColorAccess().getDarkGoldenRodKeyword_1_23()); 

                    }


                    }
                    break;
                case 25 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:671:6: ( 'DarkGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:671:6: ( 'DarkGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:672:1: 'DarkGray'
                    {
                     before(grammarAccess.getColorAccess().getDarkGrayKeyword_1_24()); 
                    match(input,35,FOLLOW_35_in_rule__Color__Alternatives_11574); 
                     after(grammarAccess.getColorAccess().getDarkGrayKeyword_1_24()); 

                    }


                    }
                    break;
                case 26 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:679:6: ( 'DarkGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:679:6: ( 'DarkGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:680:1: 'DarkGreen'
                    {
                     before(grammarAccess.getColorAccess().getDarkGreenKeyword_1_25()); 
                    match(input,36,FOLLOW_36_in_rule__Color__Alternatives_11594); 
                     after(grammarAccess.getColorAccess().getDarkGreenKeyword_1_25()); 

                    }


                    }
                    break;
                case 27 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:687:6: ( 'DarkGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:687:6: ( 'DarkGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:688:1: 'DarkGrey'
                    {
                     before(grammarAccess.getColorAccess().getDarkGreyKeyword_1_26()); 
                    match(input,37,FOLLOW_37_in_rule__Color__Alternatives_11614); 
                     after(grammarAccess.getColorAccess().getDarkGreyKeyword_1_26()); 

                    }


                    }
                    break;
                case 28 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:695:6: ( 'DarkKhaki' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:695:6: ( 'DarkKhaki' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:696:1: 'DarkKhaki'
                    {
                     before(grammarAccess.getColorAccess().getDarkKhakiKeyword_1_27()); 
                    match(input,38,FOLLOW_38_in_rule__Color__Alternatives_11634); 
                     after(grammarAccess.getColorAccess().getDarkKhakiKeyword_1_27()); 

                    }


                    }
                    break;
                case 29 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:703:6: ( 'DarkMagenta' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:703:6: ( 'DarkMagenta' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:704:1: 'DarkMagenta'
                    {
                     before(grammarAccess.getColorAccess().getDarkMagentaKeyword_1_28()); 
                    match(input,39,FOLLOW_39_in_rule__Color__Alternatives_11654); 
                     after(grammarAccess.getColorAccess().getDarkMagentaKeyword_1_28()); 

                    }


                    }
                    break;
                case 30 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:711:6: ( 'DarkOliveGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:711:6: ( 'DarkOliveGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:712:1: 'DarkOliveGreen'
                    {
                     before(grammarAccess.getColorAccess().getDarkOliveGreenKeyword_1_29()); 
                    match(input,40,FOLLOW_40_in_rule__Color__Alternatives_11674); 
                     after(grammarAccess.getColorAccess().getDarkOliveGreenKeyword_1_29()); 

                    }


                    }
                    break;
                case 31 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:719:6: ( 'DarkOrchid' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:719:6: ( 'DarkOrchid' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:720:1: 'DarkOrchid'
                    {
                     before(grammarAccess.getColorAccess().getDarkOrchidKeyword_1_30()); 
                    match(input,41,FOLLOW_41_in_rule__Color__Alternatives_11694); 
                     after(grammarAccess.getColorAccess().getDarkOrchidKeyword_1_30()); 

                    }


                    }
                    break;
                case 32 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:727:6: ( 'DarkRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:727:6: ( 'DarkRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:728:1: 'DarkRed'
                    {
                     before(grammarAccess.getColorAccess().getDarkRedKeyword_1_31()); 
                    match(input,42,FOLLOW_42_in_rule__Color__Alternatives_11714); 
                     after(grammarAccess.getColorAccess().getDarkRedKeyword_1_31()); 

                    }


                    }
                    break;
                case 33 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:735:6: ( 'DarkSalmo' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:735:6: ( 'DarkSalmo' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:736:1: 'DarkSalmo'
                    {
                     before(grammarAccess.getColorAccess().getDarkSalmoKeyword_1_32()); 
                    match(input,43,FOLLOW_43_in_rule__Color__Alternatives_11734); 
                     after(grammarAccess.getColorAccess().getDarkSalmoKeyword_1_32()); 

                    }


                    }
                    break;
                case 34 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:743:6: ( 'DarkSeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:743:6: ( 'DarkSeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:744:1: 'DarkSeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getDarkSeaGreenKeyword_1_33()); 
                    match(input,44,FOLLOW_44_in_rule__Color__Alternatives_11754); 
                     after(grammarAccess.getColorAccess().getDarkSeaGreenKeyword_1_33()); 

                    }


                    }
                    break;
                case 35 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:751:6: ( 'DarkSlateBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:751:6: ( 'DarkSlateBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:752:1: 'DarkSlateBlue'
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateBlueKeyword_1_34()); 
                    match(input,45,FOLLOW_45_in_rule__Color__Alternatives_11774); 
                     after(grammarAccess.getColorAccess().getDarkSlateBlueKeyword_1_34()); 

                    }


                    }
                    break;
                case 36 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:759:6: ( 'DarkSlateGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:759:6: ( 'DarkSlateGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:760:1: 'DarkSlateGray'
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateGrayKeyword_1_35()); 
                    match(input,46,FOLLOW_46_in_rule__Color__Alternatives_11794); 
                     after(grammarAccess.getColorAccess().getDarkSlateGrayKeyword_1_35()); 

                    }


                    }
                    break;
                case 37 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:767:6: ( 'DarkSlateGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:767:6: ( 'DarkSlateGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:768:1: 'DarkSlateGrey'
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateGreyKeyword_1_36()); 
                    match(input,47,FOLLOW_47_in_rule__Color__Alternatives_11814); 
                     after(grammarAccess.getColorAccess().getDarkSlateGreyKeyword_1_36()); 

                    }


                    }
                    break;
                case 38 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:775:6: ( 'DarkTurquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:775:6: ( 'DarkTurquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:776:1: 'DarkTurquoise'
                    {
                     before(grammarAccess.getColorAccess().getDarkTurquoiseKeyword_1_37()); 
                    match(input,48,FOLLOW_48_in_rule__Color__Alternatives_11834); 
                     after(grammarAccess.getColorAccess().getDarkTurquoiseKeyword_1_37()); 

                    }


                    }
                    break;
                case 39 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:783:6: ( 'DarkViolet' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:783:6: ( 'DarkViolet' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:784:1: 'DarkViolet'
                    {
                     before(grammarAccess.getColorAccess().getDarkVioletKeyword_1_38()); 
                    match(input,49,FOLLOW_49_in_rule__Color__Alternatives_11854); 
                     after(grammarAccess.getColorAccess().getDarkVioletKeyword_1_38()); 

                    }


                    }
                    break;
                case 40 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:791:6: ( 'Darkorange' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:791:6: ( 'Darkorange' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:792:1: 'Darkorange'
                    {
                     before(grammarAccess.getColorAccess().getDarkorangeKeyword_1_39()); 
                    match(input,50,FOLLOW_50_in_rule__Color__Alternatives_11874); 
                     after(grammarAccess.getColorAccess().getDarkorangeKeyword_1_39()); 

                    }


                    }
                    break;
                case 41 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:799:6: ( 'DeepPink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:799:6: ( 'DeepPink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:800:1: 'DeepPink'
                    {
                     before(grammarAccess.getColorAccess().getDeepPinkKeyword_1_40()); 
                    match(input,51,FOLLOW_51_in_rule__Color__Alternatives_11894); 
                     after(grammarAccess.getColorAccess().getDeepPinkKeyword_1_40()); 

                    }


                    }
                    break;
                case 42 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:807:6: ( 'DeepSkyBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:807:6: ( 'DeepSkyBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:808:1: 'DeepSkyBlue'
                    {
                     before(grammarAccess.getColorAccess().getDeepSkyBlueKeyword_1_41()); 
                    match(input,52,FOLLOW_52_in_rule__Color__Alternatives_11914); 
                     after(grammarAccess.getColorAccess().getDeepSkyBlueKeyword_1_41()); 

                    }


                    }
                    break;
                case 43 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:815:6: ( 'DimGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:815:6: ( 'DimGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:816:1: 'DimGray'
                    {
                     before(grammarAccess.getColorAccess().getDimGrayKeyword_1_42()); 
                    match(input,53,FOLLOW_53_in_rule__Color__Alternatives_11934); 
                     after(grammarAccess.getColorAccess().getDimGrayKeyword_1_42()); 

                    }


                    }
                    break;
                case 44 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:823:6: ( 'DimGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:823:6: ( 'DimGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:824:1: 'DimGrey'
                    {
                     before(grammarAccess.getColorAccess().getDimGreyKeyword_1_43()); 
                    match(input,54,FOLLOW_54_in_rule__Color__Alternatives_11954); 
                     after(grammarAccess.getColorAccess().getDimGreyKeyword_1_43()); 

                    }


                    }
                    break;
                case 45 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:831:6: ( 'DodgerBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:831:6: ( 'DodgerBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:832:1: 'DodgerBlue'
                    {
                     before(grammarAccess.getColorAccess().getDodgerBlueKeyword_1_44()); 
                    match(input,55,FOLLOW_55_in_rule__Color__Alternatives_11974); 
                     after(grammarAccess.getColorAccess().getDodgerBlueKeyword_1_44()); 

                    }


                    }
                    break;
                case 46 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:839:6: ( 'FireBrick' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:839:6: ( 'FireBrick' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:840:1: 'FireBrick'
                    {
                     before(grammarAccess.getColorAccess().getFireBrickKeyword_1_45()); 
                    match(input,56,FOLLOW_56_in_rule__Color__Alternatives_11994); 
                     after(grammarAccess.getColorAccess().getFireBrickKeyword_1_45()); 

                    }


                    }
                    break;
                case 47 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:847:6: ( 'FloralWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:847:6: ( 'FloralWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:848:1: 'FloralWhite'
                    {
                     before(grammarAccess.getColorAccess().getFloralWhiteKeyword_1_46()); 
                    match(input,57,FOLLOW_57_in_rule__Color__Alternatives_12014); 
                     after(grammarAccess.getColorAccess().getFloralWhiteKeyword_1_46()); 

                    }


                    }
                    break;
                case 48 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:855:6: ( 'ForestGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:855:6: ( 'ForestGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:856:1: 'ForestGreen'
                    {
                     before(grammarAccess.getColorAccess().getForestGreenKeyword_1_47()); 
                    match(input,58,FOLLOW_58_in_rule__Color__Alternatives_12034); 
                     after(grammarAccess.getColorAccess().getForestGreenKeyword_1_47()); 

                    }


                    }
                    break;
                case 49 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:863:6: ( 'Fuchsia' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:863:6: ( 'Fuchsia' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:864:1: 'Fuchsia'
                    {
                     before(grammarAccess.getColorAccess().getFuchsiaKeyword_1_48()); 
                    match(input,59,FOLLOW_59_in_rule__Color__Alternatives_12054); 
                     after(grammarAccess.getColorAccess().getFuchsiaKeyword_1_48()); 

                    }


                    }
                    break;
                case 50 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:871:6: ( 'Gainsboro' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:871:6: ( 'Gainsboro' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:872:1: 'Gainsboro'
                    {
                     before(grammarAccess.getColorAccess().getGainsboroKeyword_1_49()); 
                    match(input,60,FOLLOW_60_in_rule__Color__Alternatives_12074); 
                     after(grammarAccess.getColorAccess().getGainsboroKeyword_1_49()); 

                    }


                    }
                    break;
                case 51 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:879:6: ( 'GhostWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:879:6: ( 'GhostWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:880:1: 'GhostWhite'
                    {
                     before(grammarAccess.getColorAccess().getGhostWhiteKeyword_1_50()); 
                    match(input,61,FOLLOW_61_in_rule__Color__Alternatives_12094); 
                     after(grammarAccess.getColorAccess().getGhostWhiteKeyword_1_50()); 

                    }


                    }
                    break;
                case 52 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:887:6: ( 'Gold' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:887:6: ( 'Gold' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:888:1: 'Gold'
                    {
                     before(grammarAccess.getColorAccess().getGoldKeyword_1_51()); 
                    match(input,62,FOLLOW_62_in_rule__Color__Alternatives_12114); 
                     after(grammarAccess.getColorAccess().getGoldKeyword_1_51()); 

                    }


                    }
                    break;
                case 53 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:895:6: ( 'GoldenRod' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:895:6: ( 'GoldenRod' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:896:1: 'GoldenRod'
                    {
                     before(grammarAccess.getColorAccess().getGoldenRodKeyword_1_52()); 
                    match(input,63,FOLLOW_63_in_rule__Color__Alternatives_12134); 
                     after(grammarAccess.getColorAccess().getGoldenRodKeyword_1_52()); 

                    }


                    }
                    break;
                case 54 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:903:6: ( 'Gray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:903:6: ( 'Gray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:904:1: 'Gray'
                    {
                     before(grammarAccess.getColorAccess().getGrayKeyword_1_53()); 
                    match(input,64,FOLLOW_64_in_rule__Color__Alternatives_12154); 
                     after(grammarAccess.getColorAccess().getGrayKeyword_1_53()); 

                    }


                    }
                    break;
                case 55 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:911:6: ( 'Green' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:911:6: ( 'Green' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:912:1: 'Green'
                    {
                     before(grammarAccess.getColorAccess().getGreenKeyword_1_54()); 
                    match(input,65,FOLLOW_65_in_rule__Color__Alternatives_12174); 
                     after(grammarAccess.getColorAccess().getGreenKeyword_1_54()); 

                    }


                    }
                    break;
                case 56 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:919:6: ( 'GreenYellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:919:6: ( 'GreenYellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:920:1: 'GreenYellow'
                    {
                     before(grammarAccess.getColorAccess().getGreenYellowKeyword_1_55()); 
                    match(input,66,FOLLOW_66_in_rule__Color__Alternatives_12194); 
                     after(grammarAccess.getColorAccess().getGreenYellowKeyword_1_55()); 

                    }


                    }
                    break;
                case 57 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:927:6: ( 'Grey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:927:6: ( 'Grey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:928:1: 'Grey'
                    {
                     before(grammarAccess.getColorAccess().getGreyKeyword_1_56()); 
                    match(input,67,FOLLOW_67_in_rule__Color__Alternatives_12214); 
                     after(grammarAccess.getColorAccess().getGreyKeyword_1_56()); 

                    }


                    }
                    break;
                case 58 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:935:6: ( 'HoneyDew' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:935:6: ( 'HoneyDew' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:936:1: 'HoneyDew'
                    {
                     before(grammarAccess.getColorAccess().getHoneyDewKeyword_1_57()); 
                    match(input,68,FOLLOW_68_in_rule__Color__Alternatives_12234); 
                     after(grammarAccess.getColorAccess().getHoneyDewKeyword_1_57()); 

                    }


                    }
                    break;
                case 59 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:943:6: ( 'HotPink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:943:6: ( 'HotPink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:944:1: 'HotPink'
                    {
                     before(grammarAccess.getColorAccess().getHotPinkKeyword_1_58()); 
                    match(input,69,FOLLOW_69_in_rule__Color__Alternatives_12254); 
                     after(grammarAccess.getColorAccess().getHotPinkKeyword_1_58()); 

                    }


                    }
                    break;
                case 60 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:951:6: ( 'IndianRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:951:6: ( 'IndianRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:952:1: 'IndianRed'
                    {
                     before(grammarAccess.getColorAccess().getIndianRedKeyword_1_59()); 
                    match(input,70,FOLLOW_70_in_rule__Color__Alternatives_12274); 
                     after(grammarAccess.getColorAccess().getIndianRedKeyword_1_59()); 

                    }


                    }
                    break;
                case 61 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:959:6: ( 'Indigo' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:959:6: ( 'Indigo' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:960:1: 'Indigo'
                    {
                     before(grammarAccess.getColorAccess().getIndigoKeyword_1_60()); 
                    match(input,71,FOLLOW_71_in_rule__Color__Alternatives_12294); 
                     after(grammarAccess.getColorAccess().getIndigoKeyword_1_60()); 

                    }


                    }
                    break;
                case 62 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:967:6: ( 'Ivory' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:967:6: ( 'Ivory' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:968:1: 'Ivory'
                    {
                     before(grammarAccess.getColorAccess().getIvoryKeyword_1_61()); 
                    match(input,72,FOLLOW_72_in_rule__Color__Alternatives_12314); 
                     after(grammarAccess.getColorAccess().getIvoryKeyword_1_61()); 

                    }


                    }
                    break;
                case 63 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:975:6: ( 'Khaki' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:975:6: ( 'Khaki' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:976:1: 'Khaki'
                    {
                     before(grammarAccess.getColorAccess().getKhakiKeyword_1_62()); 
                    match(input,73,FOLLOW_73_in_rule__Color__Alternatives_12334); 
                     after(grammarAccess.getColorAccess().getKhakiKeyword_1_62()); 

                    }


                    }
                    break;
                case 64 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:983:6: ( 'Lavender' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:983:6: ( 'Lavender' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:984:1: 'Lavender'
                    {
                     before(grammarAccess.getColorAccess().getLavenderKeyword_1_63()); 
                    match(input,74,FOLLOW_74_in_rule__Color__Alternatives_12354); 
                     after(grammarAccess.getColorAccess().getLavenderKeyword_1_63()); 

                    }


                    }
                    break;
                case 65 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:991:6: ( 'LavenderBlush' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:991:6: ( 'LavenderBlush' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:992:1: 'LavenderBlush'
                    {
                     before(grammarAccess.getColorAccess().getLavenderBlushKeyword_1_64()); 
                    match(input,75,FOLLOW_75_in_rule__Color__Alternatives_12374); 
                     after(grammarAccess.getColorAccess().getLavenderBlushKeyword_1_64()); 

                    }


                    }
                    break;
                case 66 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:999:6: ( 'LawnGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:999:6: ( 'LawnGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1000:1: 'LawnGreen'
                    {
                     before(grammarAccess.getColorAccess().getLawnGreenKeyword_1_65()); 
                    match(input,76,FOLLOW_76_in_rule__Color__Alternatives_12394); 
                     after(grammarAccess.getColorAccess().getLawnGreenKeyword_1_65()); 

                    }


                    }
                    break;
                case 67 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1007:6: ( 'LemonChiffon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1007:6: ( 'LemonChiffon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1008:1: 'LemonChiffon'
                    {
                     before(grammarAccess.getColorAccess().getLemonChiffonKeyword_1_66()); 
                    match(input,77,FOLLOW_77_in_rule__Color__Alternatives_12414); 
                     after(grammarAccess.getColorAccess().getLemonChiffonKeyword_1_66()); 

                    }


                    }
                    break;
                case 68 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1015:6: ( 'LightBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1015:6: ( 'LightBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1016:1: 'LightBlue'
                    {
                     before(grammarAccess.getColorAccess().getLightBlueKeyword_1_67()); 
                    match(input,78,FOLLOW_78_in_rule__Color__Alternatives_12434); 
                     after(grammarAccess.getColorAccess().getLightBlueKeyword_1_67()); 

                    }


                    }
                    break;
                case 69 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1023:6: ( 'LightCoral' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1023:6: ( 'LightCoral' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1024:1: 'LightCoral'
                    {
                     before(grammarAccess.getColorAccess().getLightCoralKeyword_1_68()); 
                    match(input,79,FOLLOW_79_in_rule__Color__Alternatives_12454); 
                     after(grammarAccess.getColorAccess().getLightCoralKeyword_1_68()); 

                    }


                    }
                    break;
                case 70 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1031:6: ( 'LightCyan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1031:6: ( 'LightCyan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1032:1: 'LightCyan'
                    {
                     before(grammarAccess.getColorAccess().getLightCyanKeyword_1_69()); 
                    match(input,80,FOLLOW_80_in_rule__Color__Alternatives_12474); 
                     after(grammarAccess.getColorAccess().getLightCyanKeyword_1_69()); 

                    }


                    }
                    break;
                case 71 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1039:6: ( 'LightGoldenRodYellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1039:6: ( 'LightGoldenRodYellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1040:1: 'LightGoldenRodYellow'
                    {
                     before(grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_1_70()); 
                    match(input,81,FOLLOW_81_in_rule__Color__Alternatives_12494); 
                     after(grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_1_70()); 

                    }


                    }
                    break;
                case 72 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1047:6: ( 'LightGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1047:6: ( 'LightGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1048:1: 'LightGray'
                    {
                     before(grammarAccess.getColorAccess().getLightGrayKeyword_1_71()); 
                    match(input,82,FOLLOW_82_in_rule__Color__Alternatives_12514); 
                     after(grammarAccess.getColorAccess().getLightGrayKeyword_1_71()); 

                    }


                    }
                    break;
                case 73 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1055:6: ( 'LightGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1055:6: ( 'LightGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1056:1: 'LightGreen'
                    {
                     before(grammarAccess.getColorAccess().getLightGreenKeyword_1_72()); 
                    match(input,83,FOLLOW_83_in_rule__Color__Alternatives_12534); 
                     after(grammarAccess.getColorAccess().getLightGreenKeyword_1_72()); 

                    }


                    }
                    break;
                case 74 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1063:6: ( 'LightGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1063:6: ( 'LightGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1064:1: 'LightGrey'
                    {
                     before(grammarAccess.getColorAccess().getLightGreyKeyword_1_73()); 
                    match(input,84,FOLLOW_84_in_rule__Color__Alternatives_12554); 
                     after(grammarAccess.getColorAccess().getLightGreyKeyword_1_73()); 

                    }


                    }
                    break;
                case 75 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1071:6: ( 'LightPink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1071:6: ( 'LightPink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1072:1: 'LightPink'
                    {
                     before(grammarAccess.getColorAccess().getLightPinkKeyword_1_74()); 
                    match(input,85,FOLLOW_85_in_rule__Color__Alternatives_12574); 
                     after(grammarAccess.getColorAccess().getLightPinkKeyword_1_74()); 

                    }


                    }
                    break;
                case 76 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1079:6: ( 'LightSalmon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1079:6: ( 'LightSalmon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1080:1: 'LightSalmon'
                    {
                     before(grammarAccess.getColorAccess().getLightSalmonKeyword_1_75()); 
                    match(input,86,FOLLOW_86_in_rule__Color__Alternatives_12594); 
                     after(grammarAccess.getColorAccess().getLightSalmonKeyword_1_75()); 

                    }


                    }
                    break;
                case 77 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1087:6: ( 'LightSeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1087:6: ( 'LightSeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1088:1: 'LightSeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getLightSeaGreenKeyword_1_76()); 
                    match(input,87,FOLLOW_87_in_rule__Color__Alternatives_12614); 
                     after(grammarAccess.getColorAccess().getLightSeaGreenKeyword_1_76()); 

                    }


                    }
                    break;
                case 78 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1095:6: ( 'LightSkyBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1095:6: ( 'LightSkyBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1096:1: 'LightSkyBlue'
                    {
                     before(grammarAccess.getColorAccess().getLightSkyBlueKeyword_1_77()); 
                    match(input,88,FOLLOW_88_in_rule__Color__Alternatives_12634); 
                     after(grammarAccess.getColorAccess().getLightSkyBlueKeyword_1_77()); 

                    }


                    }
                    break;
                case 79 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1103:6: ( 'LightSlateGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1103:6: ( 'LightSlateGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1104:1: 'LightSlateGray'
                    {
                     before(grammarAccess.getColorAccess().getLightSlateGrayKeyword_1_78()); 
                    match(input,89,FOLLOW_89_in_rule__Color__Alternatives_12654); 
                     after(grammarAccess.getColorAccess().getLightSlateGrayKeyword_1_78()); 

                    }


                    }
                    break;
                case 80 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1111:6: ( 'LightSlateGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1111:6: ( 'LightSlateGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1112:1: 'LightSlateGrey'
                    {
                     before(grammarAccess.getColorAccess().getLightSlateGreyKeyword_1_79()); 
                    match(input,90,FOLLOW_90_in_rule__Color__Alternatives_12674); 
                     after(grammarAccess.getColorAccess().getLightSlateGreyKeyword_1_79()); 

                    }


                    }
                    break;
                case 81 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1119:6: ( 'LightSteelBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1119:6: ( 'LightSteelBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1120:1: 'LightSteelBlue'
                    {
                     before(grammarAccess.getColorAccess().getLightSteelBlueKeyword_1_80()); 
                    match(input,91,FOLLOW_91_in_rule__Color__Alternatives_12694); 
                     after(grammarAccess.getColorAccess().getLightSteelBlueKeyword_1_80()); 

                    }


                    }
                    break;
                case 82 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1127:6: ( 'LightYellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1127:6: ( 'LightYellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1128:1: 'LightYellow'
                    {
                     before(grammarAccess.getColorAccess().getLightYellowKeyword_1_81()); 
                    match(input,92,FOLLOW_92_in_rule__Color__Alternatives_12714); 
                     after(grammarAccess.getColorAccess().getLightYellowKeyword_1_81()); 

                    }


                    }
                    break;
                case 83 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1135:6: ( 'Lime' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1135:6: ( 'Lime' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1136:1: 'Lime'
                    {
                     before(grammarAccess.getColorAccess().getLimeKeyword_1_82()); 
                    match(input,93,FOLLOW_93_in_rule__Color__Alternatives_12734); 
                     after(grammarAccess.getColorAccess().getLimeKeyword_1_82()); 

                    }


                    }
                    break;
                case 84 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1143:6: ( 'LimeGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1143:6: ( 'LimeGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1144:1: 'LimeGreen'
                    {
                     before(grammarAccess.getColorAccess().getLimeGreenKeyword_1_83()); 
                    match(input,94,FOLLOW_94_in_rule__Color__Alternatives_12754); 
                     after(grammarAccess.getColorAccess().getLimeGreenKeyword_1_83()); 

                    }


                    }
                    break;
                case 85 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1151:6: ( 'Linen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1151:6: ( 'Linen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1152:1: 'Linen'
                    {
                     before(grammarAccess.getColorAccess().getLinenKeyword_1_84()); 
                    match(input,95,FOLLOW_95_in_rule__Color__Alternatives_12774); 
                     after(grammarAccess.getColorAccess().getLinenKeyword_1_84()); 

                    }


                    }
                    break;
                case 86 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1159:6: ( 'Magenta' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1159:6: ( 'Magenta' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1160:1: 'Magenta'
                    {
                     before(grammarAccess.getColorAccess().getMagentaKeyword_1_85()); 
                    match(input,96,FOLLOW_96_in_rule__Color__Alternatives_12794); 
                     after(grammarAccess.getColorAccess().getMagentaKeyword_1_85()); 

                    }


                    }
                    break;
                case 87 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1167:6: ( 'Maroon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1167:6: ( 'Maroon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1168:1: 'Maroon'
                    {
                     before(grammarAccess.getColorAccess().getMaroonKeyword_1_86()); 
                    match(input,97,FOLLOW_97_in_rule__Color__Alternatives_12814); 
                     after(grammarAccess.getColorAccess().getMaroonKeyword_1_86()); 

                    }


                    }
                    break;
                case 88 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1175:6: ( 'MediumAquaMarine' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1175:6: ( 'MediumAquaMarine' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1176:1: 'MediumAquaMarine'
                    {
                     before(grammarAccess.getColorAccess().getMediumAquaMarineKeyword_1_87()); 
                    match(input,98,FOLLOW_98_in_rule__Color__Alternatives_12834); 
                     after(grammarAccess.getColorAccess().getMediumAquaMarineKeyword_1_87()); 

                    }


                    }
                    break;
                case 89 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1183:6: ( 'MediumBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1183:6: ( 'MediumBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1184:1: 'MediumBlue'
                    {
                     before(grammarAccess.getColorAccess().getMediumBlueKeyword_1_88()); 
                    match(input,99,FOLLOW_99_in_rule__Color__Alternatives_12854); 
                     after(grammarAccess.getColorAccess().getMediumBlueKeyword_1_88()); 

                    }


                    }
                    break;
                case 90 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1191:6: ( 'MediumOrchid' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1191:6: ( 'MediumOrchid' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1192:1: 'MediumOrchid'
                    {
                     before(grammarAccess.getColorAccess().getMediumOrchidKeyword_1_89()); 
                    match(input,100,FOLLOW_100_in_rule__Color__Alternatives_12874); 
                     after(grammarAccess.getColorAccess().getMediumOrchidKeyword_1_89()); 

                    }


                    }
                    break;
                case 91 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1199:6: ( 'MediumPurple' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1199:6: ( 'MediumPurple' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1200:1: 'MediumPurple'
                    {
                     before(grammarAccess.getColorAccess().getMediumPurpleKeyword_1_90()); 
                    match(input,101,FOLLOW_101_in_rule__Color__Alternatives_12894); 
                     after(grammarAccess.getColorAccess().getMediumPurpleKeyword_1_90()); 

                    }


                    }
                    break;
                case 92 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1207:6: ( 'MediumSeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1207:6: ( 'MediumSeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1208:1: 'MediumSeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getMediumSeaGreenKeyword_1_91()); 
                    match(input,102,FOLLOW_102_in_rule__Color__Alternatives_12914); 
                     after(grammarAccess.getColorAccess().getMediumSeaGreenKeyword_1_91()); 

                    }


                    }
                    break;
                case 93 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1215:6: ( 'MediumSlateBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1215:6: ( 'MediumSlateBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1216:1: 'MediumSlateBlue'
                    {
                     before(grammarAccess.getColorAccess().getMediumSlateBlueKeyword_1_92()); 
                    match(input,103,FOLLOW_103_in_rule__Color__Alternatives_12934); 
                     after(grammarAccess.getColorAccess().getMediumSlateBlueKeyword_1_92()); 

                    }


                    }
                    break;
                case 94 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1223:6: ( 'MediumSpringGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1223:6: ( 'MediumSpringGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1224:1: 'MediumSpringGreen'
                    {
                     before(grammarAccess.getColorAccess().getMediumSpringGreenKeyword_1_93()); 
                    match(input,104,FOLLOW_104_in_rule__Color__Alternatives_12954); 
                     after(grammarAccess.getColorAccess().getMediumSpringGreenKeyword_1_93()); 

                    }


                    }
                    break;
                case 95 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1231:6: ( 'MediumTurquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1231:6: ( 'MediumTurquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1232:1: 'MediumTurquoise'
                    {
                     before(grammarAccess.getColorAccess().getMediumTurquoiseKeyword_1_94()); 
                    match(input,105,FOLLOW_105_in_rule__Color__Alternatives_12974); 
                     after(grammarAccess.getColorAccess().getMediumTurquoiseKeyword_1_94()); 

                    }


                    }
                    break;
                case 96 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1239:6: ( 'MediumVioletRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1239:6: ( 'MediumVioletRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1240:1: 'MediumVioletRed'
                    {
                     before(grammarAccess.getColorAccess().getMediumVioletRedKeyword_1_95()); 
                    match(input,106,FOLLOW_106_in_rule__Color__Alternatives_12994); 
                     after(grammarAccess.getColorAccess().getMediumVioletRedKeyword_1_95()); 

                    }


                    }
                    break;
                case 97 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1247:6: ( 'MidnightBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1247:6: ( 'MidnightBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1248:1: 'MidnightBlue'
                    {
                     before(grammarAccess.getColorAccess().getMidnightBlueKeyword_1_96()); 
                    match(input,107,FOLLOW_107_in_rule__Color__Alternatives_13014); 
                     after(grammarAccess.getColorAccess().getMidnightBlueKeyword_1_96()); 

                    }


                    }
                    break;
                case 98 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1255:6: ( 'MintCream' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1255:6: ( 'MintCream' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1256:1: 'MintCream'
                    {
                     before(grammarAccess.getColorAccess().getMintCreamKeyword_1_97()); 
                    match(input,108,FOLLOW_108_in_rule__Color__Alternatives_13034); 
                     after(grammarAccess.getColorAccess().getMintCreamKeyword_1_97()); 

                    }


                    }
                    break;
                case 99 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1263:6: ( 'MistyRose' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1263:6: ( 'MistyRose' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1264:1: 'MistyRose'
                    {
                     before(grammarAccess.getColorAccess().getMistyRoseKeyword_1_98()); 
                    match(input,109,FOLLOW_109_in_rule__Color__Alternatives_13054); 
                     after(grammarAccess.getColorAccess().getMistyRoseKeyword_1_98()); 

                    }


                    }
                    break;
                case 100 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1271:6: ( 'Moccasin' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1271:6: ( 'Moccasin' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1272:1: 'Moccasin'
                    {
                     before(grammarAccess.getColorAccess().getMoccasinKeyword_1_99()); 
                    match(input,110,FOLLOW_110_in_rule__Color__Alternatives_13074); 
                     after(grammarAccess.getColorAccess().getMoccasinKeyword_1_99()); 

                    }


                    }
                    break;
                case 101 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1279:6: ( 'NavajoWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1279:6: ( 'NavajoWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1280:1: 'NavajoWhite'
                    {
                     before(grammarAccess.getColorAccess().getNavajoWhiteKeyword_1_100()); 
                    match(input,111,FOLLOW_111_in_rule__Color__Alternatives_13094); 
                     after(grammarAccess.getColorAccess().getNavajoWhiteKeyword_1_100()); 

                    }


                    }
                    break;
                case 102 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1287:6: ( 'Navy' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1287:6: ( 'Navy' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1288:1: 'Navy'
                    {
                     before(grammarAccess.getColorAccess().getNavyKeyword_1_101()); 
                    match(input,112,FOLLOW_112_in_rule__Color__Alternatives_13114); 
                     after(grammarAccess.getColorAccess().getNavyKeyword_1_101()); 

                    }


                    }
                    break;
                case 103 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1295:6: ( 'OldLace' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1295:6: ( 'OldLace' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1296:1: 'OldLace'
                    {
                     before(grammarAccess.getColorAccess().getOldLaceKeyword_1_102()); 
                    match(input,113,FOLLOW_113_in_rule__Color__Alternatives_13134); 
                     after(grammarAccess.getColorAccess().getOldLaceKeyword_1_102()); 

                    }


                    }
                    break;
                case 104 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1303:6: ( 'Olive' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1303:6: ( 'Olive' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1304:1: 'Olive'
                    {
                     before(grammarAccess.getColorAccess().getOliveKeyword_1_103()); 
                    match(input,114,FOLLOW_114_in_rule__Color__Alternatives_13154); 
                     after(grammarAccess.getColorAccess().getOliveKeyword_1_103()); 

                    }


                    }
                    break;
                case 105 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1311:6: ( 'OliveDrab' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1311:6: ( 'OliveDrab' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1312:1: 'OliveDrab'
                    {
                     before(grammarAccess.getColorAccess().getOliveDrabKeyword_1_104()); 
                    match(input,115,FOLLOW_115_in_rule__Color__Alternatives_13174); 
                     after(grammarAccess.getColorAccess().getOliveDrabKeyword_1_104()); 

                    }


                    }
                    break;
                case 106 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1319:6: ( 'OrangeRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1319:6: ( 'OrangeRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1320:1: 'OrangeRed'
                    {
                     before(grammarAccess.getColorAccess().getOrangeRedKeyword_1_105()); 
                    match(input,116,FOLLOW_116_in_rule__Color__Alternatives_13194); 
                     after(grammarAccess.getColorAccess().getOrangeRedKeyword_1_105()); 

                    }


                    }
                    break;
                case 107 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1327:6: ( 'Orchid' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1327:6: ( 'Orchid' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1328:1: 'Orchid'
                    {
                     before(grammarAccess.getColorAccess().getOrchidKeyword_1_106()); 
                    match(input,117,FOLLOW_117_in_rule__Color__Alternatives_13214); 
                     after(grammarAccess.getColorAccess().getOrchidKeyword_1_106()); 

                    }


                    }
                    break;
                case 108 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1335:6: ( 'PaleGoldenRod' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1335:6: ( 'PaleGoldenRod' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1336:1: 'PaleGoldenRod'
                    {
                     before(grammarAccess.getColorAccess().getPaleGoldenRodKeyword_1_107()); 
                    match(input,118,FOLLOW_118_in_rule__Color__Alternatives_13234); 
                     after(grammarAccess.getColorAccess().getPaleGoldenRodKeyword_1_107()); 

                    }


                    }
                    break;
                case 109 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1343:6: ( 'PaleGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1343:6: ( 'PaleGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1344:1: 'PaleGreen'
                    {
                     before(grammarAccess.getColorAccess().getPaleGreenKeyword_1_108()); 
                    match(input,119,FOLLOW_119_in_rule__Color__Alternatives_13254); 
                     after(grammarAccess.getColorAccess().getPaleGreenKeyword_1_108()); 

                    }


                    }
                    break;
                case 110 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1351:6: ( 'PaleTurquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1351:6: ( 'PaleTurquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1352:1: 'PaleTurquoise'
                    {
                     before(grammarAccess.getColorAccess().getPaleTurquoiseKeyword_1_109()); 
                    match(input,120,FOLLOW_120_in_rule__Color__Alternatives_13274); 
                     after(grammarAccess.getColorAccess().getPaleTurquoiseKeyword_1_109()); 

                    }


                    }
                    break;
                case 111 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1359:6: ( 'PaleVioletRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1359:6: ( 'PaleVioletRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1360:1: 'PaleVioletRed'
                    {
                     before(grammarAccess.getColorAccess().getPaleVioletRedKeyword_1_110()); 
                    match(input,121,FOLLOW_121_in_rule__Color__Alternatives_13294); 
                     after(grammarAccess.getColorAccess().getPaleVioletRedKeyword_1_110()); 

                    }


                    }
                    break;
                case 112 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1367:6: ( 'PapayaWhip' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1367:6: ( 'PapayaWhip' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1368:1: 'PapayaWhip'
                    {
                     before(grammarAccess.getColorAccess().getPapayaWhipKeyword_1_111()); 
                    match(input,122,FOLLOW_122_in_rule__Color__Alternatives_13314); 
                     after(grammarAccess.getColorAccess().getPapayaWhipKeyword_1_111()); 

                    }


                    }
                    break;
                case 113 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1375:6: ( 'PeachPuff' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1375:6: ( 'PeachPuff' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1376:1: 'PeachPuff'
                    {
                     before(grammarAccess.getColorAccess().getPeachPuffKeyword_1_112()); 
                    match(input,123,FOLLOW_123_in_rule__Color__Alternatives_13334); 
                     after(grammarAccess.getColorAccess().getPeachPuffKeyword_1_112()); 

                    }


                    }
                    break;
                case 114 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1383:6: ( 'Peru' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1383:6: ( 'Peru' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1384:1: 'Peru'
                    {
                     before(grammarAccess.getColorAccess().getPeruKeyword_1_113()); 
                    match(input,124,FOLLOW_124_in_rule__Color__Alternatives_13354); 
                     after(grammarAccess.getColorAccess().getPeruKeyword_1_113()); 

                    }


                    }
                    break;
                case 115 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1391:6: ( 'Pink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1391:6: ( 'Pink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1392:1: 'Pink'
                    {
                     before(grammarAccess.getColorAccess().getPinkKeyword_1_114()); 
                    match(input,125,FOLLOW_125_in_rule__Color__Alternatives_13374); 
                     after(grammarAccess.getColorAccess().getPinkKeyword_1_114()); 

                    }


                    }
                    break;
                case 116 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1399:6: ( 'Plum' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1399:6: ( 'Plum' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1400:1: 'Plum'
                    {
                     before(grammarAccess.getColorAccess().getPlumKeyword_1_115()); 
                    match(input,126,FOLLOW_126_in_rule__Color__Alternatives_13394); 
                     after(grammarAccess.getColorAccess().getPlumKeyword_1_115()); 

                    }


                    }
                    break;
                case 117 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1407:6: ( 'PowderBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1407:6: ( 'PowderBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1408:1: 'PowderBlue'
                    {
                     before(grammarAccess.getColorAccess().getPowderBlueKeyword_1_116()); 
                    match(input,127,FOLLOW_127_in_rule__Color__Alternatives_13414); 
                     after(grammarAccess.getColorAccess().getPowderBlueKeyword_1_116()); 

                    }


                    }
                    break;
                case 118 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1415:6: ( 'Purple' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1415:6: ( 'Purple' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1416:1: 'Purple'
                    {
                     before(grammarAccess.getColorAccess().getPurpleKeyword_1_117()); 
                    match(input,128,FOLLOW_128_in_rule__Color__Alternatives_13434); 
                     after(grammarAccess.getColorAccess().getPurpleKeyword_1_117()); 

                    }


                    }
                    break;
                case 119 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1423:6: ( 'Red' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1423:6: ( 'Red' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1424:1: 'Red'
                    {
                     before(grammarAccess.getColorAccess().getRedKeyword_1_118()); 
                    match(input,129,FOLLOW_129_in_rule__Color__Alternatives_13454); 
                     after(grammarAccess.getColorAccess().getRedKeyword_1_118()); 

                    }


                    }
                    break;
                case 120 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1431:6: ( 'RosyBrown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1431:6: ( 'RosyBrown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1432:1: 'RosyBrown'
                    {
                     before(grammarAccess.getColorAccess().getRosyBrownKeyword_1_119()); 
                    match(input,130,FOLLOW_130_in_rule__Color__Alternatives_13474); 
                     after(grammarAccess.getColorAccess().getRosyBrownKeyword_1_119()); 

                    }


                    }
                    break;
                case 121 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1439:6: ( 'RoyalBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1439:6: ( 'RoyalBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1440:1: 'RoyalBlue'
                    {
                     before(grammarAccess.getColorAccess().getRoyalBlueKeyword_1_120()); 
                    match(input,131,FOLLOW_131_in_rule__Color__Alternatives_13494); 
                     after(grammarAccess.getColorAccess().getRoyalBlueKeyword_1_120()); 

                    }


                    }
                    break;
                case 122 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1447:6: ( 'SaddleBrown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1447:6: ( 'SaddleBrown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1448:1: 'SaddleBrown'
                    {
                     before(grammarAccess.getColorAccess().getSaddleBrownKeyword_1_121()); 
                    match(input,132,FOLLOW_132_in_rule__Color__Alternatives_13514); 
                     after(grammarAccess.getColorAccess().getSaddleBrownKeyword_1_121()); 

                    }


                    }
                    break;
                case 123 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1455:6: ( 'Salmon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1455:6: ( 'Salmon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1456:1: 'Salmon'
                    {
                     before(grammarAccess.getColorAccess().getSalmonKeyword_1_122()); 
                    match(input,133,FOLLOW_133_in_rule__Color__Alternatives_13534); 
                     after(grammarAccess.getColorAccess().getSalmonKeyword_1_122()); 

                    }


                    }
                    break;
                case 124 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1463:6: ( 'SandyBrown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1463:6: ( 'SandyBrown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1464:1: 'SandyBrown'
                    {
                     before(grammarAccess.getColorAccess().getSandyBrownKeyword_1_123()); 
                    match(input,134,FOLLOW_134_in_rule__Color__Alternatives_13554); 
                     after(grammarAccess.getColorAccess().getSandyBrownKeyword_1_123()); 

                    }


                    }
                    break;
                case 125 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1471:6: ( 'SeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1471:6: ( 'SeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1472:1: 'SeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getSeaGreenKeyword_1_124()); 
                    match(input,135,FOLLOW_135_in_rule__Color__Alternatives_13574); 
                     after(grammarAccess.getColorAccess().getSeaGreenKeyword_1_124()); 

                    }


                    }
                    break;
                case 126 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1479:6: ( 'Sienna' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1479:6: ( 'Sienna' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1480:1: 'Sienna'
                    {
                     before(grammarAccess.getColorAccess().getSiennaKeyword_1_125()); 
                    match(input,136,FOLLOW_136_in_rule__Color__Alternatives_13594); 
                     after(grammarAccess.getColorAccess().getSiennaKeyword_1_125()); 

                    }


                    }
                    break;
                case 127 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1487:6: ( 'Silver' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1487:6: ( 'Silver' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1488:1: 'Silver'
                    {
                     before(grammarAccess.getColorAccess().getSilverKeyword_1_126()); 
                    match(input,137,FOLLOW_137_in_rule__Color__Alternatives_13614); 
                     after(grammarAccess.getColorAccess().getSilverKeyword_1_126()); 

                    }


                    }
                    break;
                case 128 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1495:6: ( 'SkyBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1495:6: ( 'SkyBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1496:1: 'SkyBlue'
                    {
                     before(grammarAccess.getColorAccess().getSkyBlueKeyword_1_127()); 
                    match(input,138,FOLLOW_138_in_rule__Color__Alternatives_13634); 
                     after(grammarAccess.getColorAccess().getSkyBlueKeyword_1_127()); 

                    }


                    }
                    break;
                case 129 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1503:6: ( 'SlateBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1503:6: ( 'SlateBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1504:1: 'SlateBlue'
                    {
                     before(grammarAccess.getColorAccess().getSlateBlueKeyword_1_128()); 
                    match(input,139,FOLLOW_139_in_rule__Color__Alternatives_13654); 
                     after(grammarAccess.getColorAccess().getSlateBlueKeyword_1_128()); 

                    }


                    }
                    break;
                case 130 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1511:6: ( 'SlateGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1511:6: ( 'SlateGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1512:1: 'SlateGray'
                    {
                     before(grammarAccess.getColorAccess().getSlateGrayKeyword_1_129()); 
                    match(input,140,FOLLOW_140_in_rule__Color__Alternatives_13674); 
                     after(grammarAccess.getColorAccess().getSlateGrayKeyword_1_129()); 

                    }


                    }
                    break;
                case 131 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1519:6: ( 'SlateGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1519:6: ( 'SlateGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1520:1: 'SlateGrey'
                    {
                     before(grammarAccess.getColorAccess().getSlateGreyKeyword_1_130()); 
                    match(input,141,FOLLOW_141_in_rule__Color__Alternatives_13694); 
                     after(grammarAccess.getColorAccess().getSlateGreyKeyword_1_130()); 

                    }


                    }
                    break;
                case 132 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1527:6: ( 'Snow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1527:6: ( 'Snow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1528:1: 'Snow'
                    {
                     before(grammarAccess.getColorAccess().getSnowKeyword_1_131()); 
                    match(input,142,FOLLOW_142_in_rule__Color__Alternatives_13714); 
                     after(grammarAccess.getColorAccess().getSnowKeyword_1_131()); 

                    }


                    }
                    break;
                case 133 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1535:6: ( 'SpringGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1535:6: ( 'SpringGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1536:1: 'SpringGreen'
                    {
                     before(grammarAccess.getColorAccess().getSpringGreenKeyword_1_132()); 
                    match(input,143,FOLLOW_143_in_rule__Color__Alternatives_13734); 
                     after(grammarAccess.getColorAccess().getSpringGreenKeyword_1_132()); 

                    }


                    }
                    break;
                case 134 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1543:6: ( 'SteelBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1543:6: ( 'SteelBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1544:1: 'SteelBlue'
                    {
                     before(grammarAccess.getColorAccess().getSteelBlueKeyword_1_133()); 
                    match(input,144,FOLLOW_144_in_rule__Color__Alternatives_13754); 
                     after(grammarAccess.getColorAccess().getSteelBlueKeyword_1_133()); 

                    }


                    }
                    break;
                case 135 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1551:6: ( 'Tan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1551:6: ( 'Tan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1552:1: 'Tan'
                    {
                     before(grammarAccess.getColorAccess().getTanKeyword_1_134()); 
                    match(input,145,FOLLOW_145_in_rule__Color__Alternatives_13774); 
                     after(grammarAccess.getColorAccess().getTanKeyword_1_134()); 

                    }


                    }
                    break;
                case 136 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1559:6: ( 'Teal' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1559:6: ( 'Teal' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1560:1: 'Teal'
                    {
                     before(grammarAccess.getColorAccess().getTealKeyword_1_135()); 
                    match(input,146,FOLLOW_146_in_rule__Color__Alternatives_13794); 
                     after(grammarAccess.getColorAccess().getTealKeyword_1_135()); 

                    }


                    }
                    break;
                case 137 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1567:6: ( 'Thistle' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1567:6: ( 'Thistle' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1568:1: 'Thistle'
                    {
                     before(grammarAccess.getColorAccess().getThistleKeyword_1_136()); 
                    match(input,147,FOLLOW_147_in_rule__Color__Alternatives_13814); 
                     after(grammarAccess.getColorAccess().getThistleKeyword_1_136()); 

                    }


                    }
                    break;
                case 138 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1575:6: ( 'Tomato' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1575:6: ( 'Tomato' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1576:1: 'Tomato'
                    {
                     before(grammarAccess.getColorAccess().getTomatoKeyword_1_137()); 
                    match(input,148,FOLLOW_148_in_rule__Color__Alternatives_13834); 
                     after(grammarAccess.getColorAccess().getTomatoKeyword_1_137()); 

                    }


                    }
                    break;
                case 139 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1583:6: ( 'Turquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1583:6: ( 'Turquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1584:1: 'Turquoise'
                    {
                     before(grammarAccess.getColorAccess().getTurquoiseKeyword_1_138()); 
                    match(input,149,FOLLOW_149_in_rule__Color__Alternatives_13854); 
                     after(grammarAccess.getColorAccess().getTurquoiseKeyword_1_138()); 

                    }


                    }
                    break;
                case 140 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1591:6: ( 'Violet' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1591:6: ( 'Violet' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1592:1: 'Violet'
                    {
                     before(grammarAccess.getColorAccess().getVioletKeyword_1_139()); 
                    match(input,150,FOLLOW_150_in_rule__Color__Alternatives_13874); 
                     after(grammarAccess.getColorAccess().getVioletKeyword_1_139()); 

                    }


                    }
                    break;
                case 141 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1599:6: ( 'Wheat' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1599:6: ( 'Wheat' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1600:1: 'Wheat'
                    {
                     before(grammarAccess.getColorAccess().getWheatKeyword_1_140()); 
                    match(input,151,FOLLOW_151_in_rule__Color__Alternatives_13894); 
                     after(grammarAccess.getColorAccess().getWheatKeyword_1_140()); 

                    }


                    }
                    break;
                case 142 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1607:6: ( 'White' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1607:6: ( 'White' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1608:1: 'White'
                    {
                     before(grammarAccess.getColorAccess().getWhiteKeyword_1_141()); 
                    match(input,152,FOLLOW_152_in_rule__Color__Alternatives_13914); 
                     after(grammarAccess.getColorAccess().getWhiteKeyword_1_141()); 

                    }


                    }
                    break;
                case 143 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1615:6: ( 'WhiteSmoke' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1615:6: ( 'WhiteSmoke' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1616:1: 'WhiteSmoke'
                    {
                     before(grammarAccess.getColorAccess().getWhiteSmokeKeyword_1_142()); 
                    match(input,153,FOLLOW_153_in_rule__Color__Alternatives_13934); 
                     after(grammarAccess.getColorAccess().getWhiteSmokeKeyword_1_142()); 

                    }


                    }
                    break;
                case 144 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1623:6: ( 'Yellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1623:6: ( 'Yellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1624:1: 'Yellow'
                    {
                     before(grammarAccess.getColorAccess().getYellowKeyword_1_143()); 
                    match(input,154,FOLLOW_154_in_rule__Color__Alternatives_13954); 
                     after(grammarAccess.getColorAccess().getYellowKeyword_1_143()); 

                    }


                    }
                    break;
                case 145 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1631:6: ( 'YellowGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1631:6: ( 'YellowGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1632:1: 'YellowGreen'
                    {
                     before(grammarAccess.getColorAccess().getYellowGreenKeyword_1_144()); 
                    match(input,155,FOLLOW_155_in_rule__Color__Alternatives_13974); 
                     after(grammarAccess.getColorAccess().getYellowGreenKeyword_1_144()); 

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
    // $ANTLR end "rule__Color__Alternatives_1"


    // $ANTLR start "rule__Diagram__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1646:1: rule__Diagram__Group__0 : rule__Diagram__Group__0__Impl rule__Diagram__Group__1 ;
    public final void rule__Diagram__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1650:1: ( rule__Diagram__Group__0__Impl rule__Diagram__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1651:2: rule__Diagram__Group__0__Impl rule__Diagram__Group__1
            {
            pushFollow(FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__04006);
            rule__Diagram__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__04009);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1658:1: rule__Diagram__Group__0__Impl : ( '@startuml' ) ;
    public final void rule__Diagram__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1662:1: ( ( '@startuml' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1663:1: ( '@startuml' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1663:1: ( '@startuml' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1664:1: '@startuml'
            {
             before(grammarAccess.getDiagramAccess().getStartumlKeyword_0()); 
            match(input,156,FOLLOW_156_in_rule__Diagram__Group__0__Impl4037); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1677:1: rule__Diagram__Group__1 : rule__Diagram__Group__1__Impl rule__Diagram__Group__2 ;
    public final void rule__Diagram__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1681:1: ( rule__Diagram__Group__1__Impl rule__Diagram__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1682:2: rule__Diagram__Group__1__Impl rule__Diagram__Group__2
            {
            pushFollow(FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__14068);
            rule__Diagram__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__14071);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1689:1: rule__Diagram__Group__1__Impl : ( ( rule__Diagram__InstructionsAssignment_1 )* ) ;
    public final void rule__Diagram__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1693:1: ( ( ( rule__Diagram__InstructionsAssignment_1 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1694:1: ( ( rule__Diagram__InstructionsAssignment_1 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1694:1: ( ( rule__Diagram__InstructionsAssignment_1 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1695:1: ( rule__Diagram__InstructionsAssignment_1 )*
            {
             before(grammarAccess.getDiagramAccess().getInstructionsAssignment_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1696:1: ( rule__Diagram__InstructionsAssignment_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=RULE_ML_COMMENT && LA6_0<=RULE_ID)||(LA6_0>=168 && LA6_0<=173)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1696:2: rule__Diagram__InstructionsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Diagram__InstructionsAssignment_1_in_rule__Diagram__Group__1__Impl4098);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1706:1: rule__Diagram__Group__2 : rule__Diagram__Group__2__Impl ;
    public final void rule__Diagram__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1710:1: ( rule__Diagram__Group__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1711:2: rule__Diagram__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__24129);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1717:1: rule__Diagram__Group__2__Impl : ( '@enduml' ) ;
    public final void rule__Diagram__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1721:1: ( ( '@enduml' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1722:1: ( '@enduml' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1722:1: ( '@enduml' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1723:1: '@enduml'
            {
             before(grammarAccess.getDiagramAccess().getEndumlKeyword_2()); 
            match(input,157,FOLLOW_157_in_rule__Diagram__Group__2__Impl4157); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1742:1: rule__Instruction__Group_0__0 : rule__Instruction__Group_0__0__Impl rule__Instruction__Group_0__1 ;
    public final void rule__Instruction__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1746:1: ( rule__Instruction__Group_0__0__Impl rule__Instruction__Group_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1747:2: rule__Instruction__Group_0__0__Impl rule__Instruction__Group_0__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0__0__Impl_in_rule__Instruction__Group_0__04194);
            rule__Instruction__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0__1_in_rule__Instruction__Group_0__04197);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1754:1: rule__Instruction__Group_0__0__Impl : ( ( rule__Instruction__Name1Assignment_0_0 ) ) ;
    public final void rule__Instruction__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1758:1: ( ( ( rule__Instruction__Name1Assignment_0_0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1759:1: ( ( rule__Instruction__Name1Assignment_0_0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1759:1: ( ( rule__Instruction__Name1Assignment_0_0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1760:1: ( rule__Instruction__Name1Assignment_0_0 )
            {
             before(grammarAccess.getInstructionAccess().getName1Assignment_0_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1761:1: ( rule__Instruction__Name1Assignment_0_0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1761:2: rule__Instruction__Name1Assignment_0_0
            {
            pushFollow(FOLLOW_rule__Instruction__Name1Assignment_0_0_in_rule__Instruction__Group_0__0__Impl4224);
            rule__Instruction__Name1Assignment_0_0();

            state._fsp--;


            }

             after(grammarAccess.getInstructionAccess().getName1Assignment_0_0()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1771:1: rule__Instruction__Group_0__1 : rule__Instruction__Group_0__1__Impl rule__Instruction__Group_0__2 ;
    public final void rule__Instruction__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1775:1: ( rule__Instruction__Group_0__1__Impl rule__Instruction__Group_0__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1776:2: rule__Instruction__Group_0__1__Impl rule__Instruction__Group_0__2
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0__1__Impl_in_rule__Instruction__Group_0__14254);
            rule__Instruction__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0__2_in_rule__Instruction__Group_0__14257);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1783:1: rule__Instruction__Group_0__1__Impl : ( ruleSequence ) ;
    public final void rule__Instruction__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1787:1: ( ( ruleSequence ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1788:1: ( ruleSequence )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1788:1: ( ruleSequence )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1789:1: ruleSequence
            {
             before(grammarAccess.getInstructionAccess().getSequenceParserRuleCall_0_1()); 
            pushFollow(FOLLOW_ruleSequence_in_rule__Instruction__Group_0__1__Impl4284);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1800:1: rule__Instruction__Group_0__2 : rule__Instruction__Group_0__2__Impl rule__Instruction__Group_0__3 ;
    public final void rule__Instruction__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1804:1: ( rule__Instruction__Group_0__2__Impl rule__Instruction__Group_0__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1805:2: rule__Instruction__Group_0__2__Impl rule__Instruction__Group_0__3
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0__2__Impl_in_rule__Instruction__Group_0__24313);
            rule__Instruction__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0__3_in_rule__Instruction__Group_0__24316);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1812:1: rule__Instruction__Group_0__2__Impl : ( ( rule__Instruction__Name2Assignment_0_2 ) ) ;
    public final void rule__Instruction__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1816:1: ( ( ( rule__Instruction__Name2Assignment_0_2 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1817:1: ( ( rule__Instruction__Name2Assignment_0_2 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1817:1: ( ( rule__Instruction__Name2Assignment_0_2 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1818:1: ( rule__Instruction__Name2Assignment_0_2 )
            {
             before(grammarAccess.getInstructionAccess().getName2Assignment_0_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1819:1: ( rule__Instruction__Name2Assignment_0_2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1819:2: rule__Instruction__Name2Assignment_0_2
            {
            pushFollow(FOLLOW_rule__Instruction__Name2Assignment_0_2_in_rule__Instruction__Group_0__2__Impl4343);
            rule__Instruction__Name2Assignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getInstructionAccess().getName2Assignment_0_2()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1829:1: rule__Instruction__Group_0__3 : rule__Instruction__Group_0__3__Impl ;
    public final void rule__Instruction__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1833:1: ( rule__Instruction__Group_0__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1834:2: rule__Instruction__Group_0__3__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0__3__Impl_in_rule__Instruction__Group_0__34373);
            rule__Instruction__Group_0__3__Impl();

            state._fsp--;


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1840:1: rule__Instruction__Group_0__3__Impl : ( ( rule__Instruction__Group_0_3__0 )? ) ;
    public final void rule__Instruction__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1844:1: ( ( ( rule__Instruction__Group_0_3__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1845:1: ( ( rule__Instruction__Group_0_3__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1845:1: ( ( rule__Instruction__Group_0_3__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1846:1: ( rule__Instruction__Group_0_3__0 )?
            {
             before(grammarAccess.getInstructionAccess().getGroup_0_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1847:1: ( rule__Instruction__Group_0_3__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==158) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1847:2: rule__Instruction__Group_0_3__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_0_3__0_in_rule__Instruction__Group_0__3__Impl4400);
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


    // $ANTLR start "rule__Instruction__Group_0_3__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1865:1: rule__Instruction__Group_0_3__0 : rule__Instruction__Group_0_3__0__Impl rule__Instruction__Group_0_3__1 ;
    public final void rule__Instruction__Group_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1869:1: ( rule__Instruction__Group_0_3__0__Impl rule__Instruction__Group_0_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1870:2: rule__Instruction__Group_0_3__0__Impl rule__Instruction__Group_0_3__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_3__0__Impl_in_rule__Instruction__Group_0_3__04439);
            rule__Instruction__Group_0_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_3__1_in_rule__Instruction__Group_0_3__04442);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1877:1: rule__Instruction__Group_0_3__0__Impl : ( ':' ) ;
    public final void rule__Instruction__Group_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1881:1: ( ( ':' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1882:1: ( ':' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1882:1: ( ':' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1883:1: ':'
            {
             before(grammarAccess.getInstructionAccess().getColonKeyword_0_3_0()); 
            match(input,158,FOLLOW_158_in_rule__Instruction__Group_0_3__0__Impl4470); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1896:1: rule__Instruction__Group_0_3__1 : rule__Instruction__Group_0_3__1__Impl ;
    public final void rule__Instruction__Group_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1900:1: ( rule__Instruction__Group_0_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1901:2: rule__Instruction__Group_0_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_3__1__Impl_in_rule__Instruction__Group_0_3__14501);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1907:1: rule__Instruction__Group_0_3__1__Impl : ( RULE_ID ) ;
    public final void rule__Instruction__Group_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1911:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1912:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1912:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1913:1: RULE_ID
            {
             before(grammarAccess.getInstructionAccess().getIDTerminalRuleCall_0_3_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Instruction__Group_0_3__1__Impl4528); 
             after(grammarAccess.getInstructionAccess().getIDTerminalRuleCall_0_3_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Instruction__Group_3__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1928:1: rule__Instruction__Group_3__0 : rule__Instruction__Group_3__0__Impl rule__Instruction__Group_3__1 ;
    public final void rule__Instruction__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1932:1: ( rule__Instruction__Group_3__0__Impl rule__Instruction__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1933:2: rule__Instruction__Group_3__0__Impl rule__Instruction__Group_3__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_3__0__Impl_in_rule__Instruction__Group_3__04561);
            rule__Instruction__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_3__1_in_rule__Instruction__Group_3__04564);
            rule__Instruction__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_3__0"


    // $ANTLR start "rule__Instruction__Group_3__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1940:1: rule__Instruction__Group_3__0__Impl : ( ruleDefinition ) ;
    public final void rule__Instruction__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1944:1: ( ( ruleDefinition ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1945:1: ( ruleDefinition )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1945:1: ( ruleDefinition )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1946:1: ruleDefinition
            {
             before(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDefinition_in_rule__Instruction__Group_3__0__Impl4591);
            ruleDefinition();

            state._fsp--;

             after(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_3__0__Impl"


    // $ANTLR start "rule__Instruction__Group_3__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1957:1: rule__Instruction__Group_3__1 : rule__Instruction__Group_3__1__Impl ;
    public final void rule__Instruction__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1961:1: ( rule__Instruction__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1962:2: rule__Instruction__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_3__1__Impl_in_rule__Instruction__Group_3__14620);
            rule__Instruction__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_3__1"


    // $ANTLR start "rule__Instruction__Group_3__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1968:1: rule__Instruction__Group_3__1__Impl : ( ( ruleColor )? ) ;
    public final void rule__Instruction__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1972:1: ( ( ( ruleColor )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1973:1: ( ( ruleColor )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1973:1: ( ( ruleColor )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1974:1: ( ruleColor )?
            {
             before(grammarAccess.getInstructionAccess().getColorParserRuleCall_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1975:1: ( ruleColor )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==174) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1975:3: ruleColor
                    {
                    pushFollow(FOLLOW_ruleColor_in_rule__Instruction__Group_3__1__Impl4648);
                    ruleColor();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getInstructionAccess().getColorParserRuleCall_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_3__1__Impl"


    // $ANTLR start "rule__Sequence__Group_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1989:1: rule__Sequence__Group_0__0 : rule__Sequence__Group_0__0__Impl rule__Sequence__Group_0__1 ;
    public final void rule__Sequence__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1993:1: ( rule__Sequence__Group_0__0__Impl rule__Sequence__Group_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1994:2: rule__Sequence__Group_0__0__Impl rule__Sequence__Group_0__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_0__0__Impl_in_rule__Sequence__Group_0__04683);
            rule__Sequence__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_0__1_in_rule__Sequence__Group_0__04686);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2001:1: rule__Sequence__Group_0__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2005:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2006:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2006:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2007:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_0_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2008:1: ( '-' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==159) ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1==159) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2009:2: '-'
            	    {
            	    match(input,159,FOLLOW_159_in_rule__Sequence__Group_0__0__Impl4715); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2020:1: rule__Sequence__Group_0__1 : rule__Sequence__Group_0__1__Impl rule__Sequence__Group_0__2 ;
    public final void rule__Sequence__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2024:1: ( rule__Sequence__Group_0__1__Impl rule__Sequence__Group_0__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2025:2: rule__Sequence__Group_0__1__Impl rule__Sequence__Group_0__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_0__1__Impl_in_rule__Sequence__Group_0__14748);
            rule__Sequence__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_0__2_in_rule__Sequence__Group_0__14751);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2032:1: rule__Sequence__Group_0__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2036:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2037:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2037:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2038:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_0_1()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_0__1__Impl4779); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2051:1: rule__Sequence__Group_0__2 : rule__Sequence__Group_0__2__Impl ;
    public final void rule__Sequence__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2055:1: ( rule__Sequence__Group_0__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2056:2: rule__Sequence__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_0__2__Impl_in_rule__Sequence__Group_0__24810);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2062:1: rule__Sequence__Group_0__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2066:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2067:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2067:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2068:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_0_2()); 
            match(input,160,FOLLOW_160_in_rule__Sequence__Group_0__2__Impl4838); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2087:1: rule__Sequence__Group_1__0 : rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1 ;
    public final void rule__Sequence__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2091:1: ( rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2092:2: rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_1__0__Impl_in_rule__Sequence__Group_1__04875);
            rule__Sequence__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_1__1_in_rule__Sequence__Group_1__04878);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2099:1: rule__Sequence__Group_1__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2103:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2104:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2104:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2105:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_1_0()); 
            match(input,161,FOLLOW_161_in_rule__Sequence__Group_1__0__Impl4906); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2118:1: rule__Sequence__Group_1__1 : rule__Sequence__Group_1__1__Impl rule__Sequence__Group_1__2 ;
    public final void rule__Sequence__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2122:1: ( rule__Sequence__Group_1__1__Impl rule__Sequence__Group_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2123:2: rule__Sequence__Group_1__1__Impl rule__Sequence__Group_1__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_1__1__Impl_in_rule__Sequence__Group_1__14937);
            rule__Sequence__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_1__2_in_rule__Sequence__Group_1__14940);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2130:1: rule__Sequence__Group_1__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2134:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2135:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2135:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2136:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_1_1()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_1__1__Impl4968); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2149:1: rule__Sequence__Group_1__2 : rule__Sequence__Group_1__2__Impl ;
    public final void rule__Sequence__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2153:1: ( rule__Sequence__Group_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2154:2: rule__Sequence__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_1__2__Impl_in_rule__Sequence__Group_1__24999);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2160:1: rule__Sequence__Group_1__2__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2164:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2165:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2165:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2166:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_1_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2167:1: ( '-' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==159) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2168:2: '-'
            	    {
            	    match(input,159,FOLLOW_159_in_rule__Sequence__Group_1__2__Impl5028); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2185:1: rule__Sequence__Group_2__0 : rule__Sequence__Group_2__0__Impl rule__Sequence__Group_2__1 ;
    public final void rule__Sequence__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2189:1: ( rule__Sequence__Group_2__0__Impl rule__Sequence__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2190:2: rule__Sequence__Group_2__0__Impl rule__Sequence__Group_2__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_2__0__Impl_in_rule__Sequence__Group_2__05067);
            rule__Sequence__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_2__1_in_rule__Sequence__Group_2__05070);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2197:1: rule__Sequence__Group_2__0__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2201:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2202:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2202:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2203:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_2_0()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_2__0__Impl5098); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2216:1: rule__Sequence__Group_2__1 : rule__Sequence__Group_2__1__Impl rule__Sequence__Group_2__2 ;
    public final void rule__Sequence__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2220:1: ( rule__Sequence__Group_2__1__Impl rule__Sequence__Group_2__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2221:2: rule__Sequence__Group_2__1__Impl rule__Sequence__Group_2__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_2__1__Impl_in_rule__Sequence__Group_2__15129);
            rule__Sequence__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_2__2_in_rule__Sequence__Group_2__15132);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2228:1: rule__Sequence__Group_2__1__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2232:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2233:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2233:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2234:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_2_1()); 
            match(input,160,FOLLOW_160_in_rule__Sequence__Group_2__1__Impl5160); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2247:1: rule__Sequence__Group_2__2 : rule__Sequence__Group_2__2__Impl ;
    public final void rule__Sequence__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2251:1: ( rule__Sequence__Group_2__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2252:2: rule__Sequence__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_2__2__Impl_in_rule__Sequence__Group_2__25191);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2258:1: rule__Sequence__Group_2__2__Impl : ( 'x' ) ;
    public final void rule__Sequence__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2262:1: ( ( 'x' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2263:1: ( 'x' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2263:1: ( 'x' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2264:1: 'x'
            {
             before(grammarAccess.getSequenceAccess().getXKeyword_2_2()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_2__2__Impl5219); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2283:1: rule__Sequence__Group_3__0 : rule__Sequence__Group_3__0__Impl rule__Sequence__Group_3__1 ;
    public final void rule__Sequence__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2287:1: ( rule__Sequence__Group_3__0__Impl rule__Sequence__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2288:2: rule__Sequence__Group_3__0__Impl rule__Sequence__Group_3__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_3__0__Impl_in_rule__Sequence__Group_3__05256);
            rule__Sequence__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_3__1_in_rule__Sequence__Group_3__05259);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2295:1: rule__Sequence__Group_3__0__Impl : ( 'x' ) ;
    public final void rule__Sequence__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2299:1: ( ( 'x' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2300:1: ( 'x' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2300:1: ( 'x' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2301:1: 'x'
            {
             before(grammarAccess.getSequenceAccess().getXKeyword_3_0()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_3__0__Impl5287); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2314:1: rule__Sequence__Group_3__1 : rule__Sequence__Group_3__1__Impl rule__Sequence__Group_3__2 ;
    public final void rule__Sequence__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2318:1: ( rule__Sequence__Group_3__1__Impl rule__Sequence__Group_3__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2319:2: rule__Sequence__Group_3__1__Impl rule__Sequence__Group_3__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_3__1__Impl_in_rule__Sequence__Group_3__15318);
            rule__Sequence__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_3__2_in_rule__Sequence__Group_3__15321);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2326:1: rule__Sequence__Group_3__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2330:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2331:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2331:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2332:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_3_1()); 
            match(input,161,FOLLOW_161_in_rule__Sequence__Group_3__1__Impl5349); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2345:1: rule__Sequence__Group_3__2 : rule__Sequence__Group_3__2__Impl ;
    public final void rule__Sequence__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2349:1: ( rule__Sequence__Group_3__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2350:2: rule__Sequence__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_3__2__Impl_in_rule__Sequence__Group_3__25380);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2356:1: rule__Sequence__Group_3__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2360:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2361:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2361:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2362:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_3_2()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_3__2__Impl5408); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2381:1: rule__Sequence__Group_4__0 : rule__Sequence__Group_4__0__Impl rule__Sequence__Group_4__1 ;
    public final void rule__Sequence__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2385:1: ( rule__Sequence__Group_4__0__Impl rule__Sequence__Group_4__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2386:2: rule__Sequence__Group_4__0__Impl rule__Sequence__Group_4__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__0__Impl_in_rule__Sequence__Group_4__05445);
            rule__Sequence__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_4__1_in_rule__Sequence__Group_4__05448);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2393:1: rule__Sequence__Group_4__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2397:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2398:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2398:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2399:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_4_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2400:1: ( '-' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==159) ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1==159) ) {
                        alt11=1;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2401:2: '-'
            	    {
            	    match(input,159,FOLLOW_159_in_rule__Sequence__Group_4__0__Impl5477); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2412:1: rule__Sequence__Group_4__1 : rule__Sequence__Group_4__1__Impl rule__Sequence__Group_4__2 ;
    public final void rule__Sequence__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2416:1: ( rule__Sequence__Group_4__1__Impl rule__Sequence__Group_4__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2417:2: rule__Sequence__Group_4__1__Impl rule__Sequence__Group_4__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__1__Impl_in_rule__Sequence__Group_4__15510);
            rule__Sequence__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_4__2_in_rule__Sequence__Group_4__15513);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2424:1: rule__Sequence__Group_4__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2428:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2429:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2429:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2430:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_4_1()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_4__1__Impl5541); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2443:1: rule__Sequence__Group_4__2 : rule__Sequence__Group_4__2__Impl rule__Sequence__Group_4__3 ;
    public final void rule__Sequence__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2447:1: ( rule__Sequence__Group_4__2__Impl rule__Sequence__Group_4__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2448:2: rule__Sequence__Group_4__2__Impl rule__Sequence__Group_4__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__2__Impl_in_rule__Sequence__Group_4__25572);
            rule__Sequence__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_4__3_in_rule__Sequence__Group_4__25575);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2455:1: rule__Sequence__Group_4__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2459:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2460:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2460:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2461:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4_2()); 
            match(input,160,FOLLOW_160_in_rule__Sequence__Group_4__2__Impl5603); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2474:1: rule__Sequence__Group_4__3 : rule__Sequence__Group_4__3__Impl ;
    public final void rule__Sequence__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2478:1: ( rule__Sequence__Group_4__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2479:2: rule__Sequence__Group_4__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__3__Impl_in_rule__Sequence__Group_4__35634);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2485:1: rule__Sequence__Group_4__3__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2489:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2490:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2490:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2491:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4_3()); 
            match(input,160,FOLLOW_160_in_rule__Sequence__Group_4__3__Impl5662); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2512:1: rule__Sequence__Group_5__0 : rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1 ;
    public final void rule__Sequence__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2516:1: ( rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2517:2: rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__0__Impl_in_rule__Sequence__Group_5__05701);
            rule__Sequence__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_5__1_in_rule__Sequence__Group_5__05704);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2524:1: rule__Sequence__Group_5__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2528:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2529:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2529:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2530:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_5_0()); 
            match(input,161,FOLLOW_161_in_rule__Sequence__Group_5__0__Impl5732); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2543:1: rule__Sequence__Group_5__1 : rule__Sequence__Group_5__1__Impl rule__Sequence__Group_5__2 ;
    public final void rule__Sequence__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2547:1: ( rule__Sequence__Group_5__1__Impl rule__Sequence__Group_5__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2548:2: rule__Sequence__Group_5__1__Impl rule__Sequence__Group_5__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__1__Impl_in_rule__Sequence__Group_5__15763);
            rule__Sequence__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_5__2_in_rule__Sequence__Group_5__15766);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2555:1: rule__Sequence__Group_5__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2559:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2560:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2560:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2561:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_5_1()); 
            match(input,161,FOLLOW_161_in_rule__Sequence__Group_5__1__Impl5794); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2574:1: rule__Sequence__Group_5__2 : rule__Sequence__Group_5__2__Impl rule__Sequence__Group_5__3 ;
    public final void rule__Sequence__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2578:1: ( rule__Sequence__Group_5__2__Impl rule__Sequence__Group_5__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2579:2: rule__Sequence__Group_5__2__Impl rule__Sequence__Group_5__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__2__Impl_in_rule__Sequence__Group_5__25825);
            rule__Sequence__Group_5__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_5__3_in_rule__Sequence__Group_5__25828);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2586:1: rule__Sequence__Group_5__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2590:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2591:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2591:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2592:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_5_2()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_5__2__Impl5856); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2605:1: rule__Sequence__Group_5__3 : rule__Sequence__Group_5__3__Impl ;
    public final void rule__Sequence__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2609:1: ( rule__Sequence__Group_5__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2610:2: rule__Sequence__Group_5__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__3__Impl_in_rule__Sequence__Group_5__35887);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2616:1: rule__Sequence__Group_5__3__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2620:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2621:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2621:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2622:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_5_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2623:1: ( '-' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==159) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2624:2: '-'
            	    {
            	    match(input,159,FOLLOW_159_in_rule__Sequence__Group_5__3__Impl5916); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2643:1: rule__Sequence__Group_6__0 : rule__Sequence__Group_6__0__Impl rule__Sequence__Group_6__1 ;
    public final void rule__Sequence__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2647:1: ( rule__Sequence__Group_6__0__Impl rule__Sequence__Group_6__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2648:2: rule__Sequence__Group_6__0__Impl rule__Sequence__Group_6__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__0__Impl_in_rule__Sequence__Group_6__05957);
            rule__Sequence__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_6__1_in_rule__Sequence__Group_6__05960);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2655:1: rule__Sequence__Group_6__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2659:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2660:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2660:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2661:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_6_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2662:1: ( '-' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==159) ) {
                    int LA13_1 = input.LA(2);

                    if ( (LA13_1==159) ) {
                        alt13=1;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2663:2: '-'
            	    {
            	    match(input,159,FOLLOW_159_in_rule__Sequence__Group_6__0__Impl5989); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2674:1: rule__Sequence__Group_6__1 : rule__Sequence__Group_6__1__Impl rule__Sequence__Group_6__2 ;
    public final void rule__Sequence__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2678:1: ( rule__Sequence__Group_6__1__Impl rule__Sequence__Group_6__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2679:2: rule__Sequence__Group_6__1__Impl rule__Sequence__Group_6__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__1__Impl_in_rule__Sequence__Group_6__16022);
            rule__Sequence__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_6__2_in_rule__Sequence__Group_6__16025);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2686:1: rule__Sequence__Group_6__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2690:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2691:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2691:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2692:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_6_1()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_6__1__Impl6053); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2705:1: rule__Sequence__Group_6__2 : rule__Sequence__Group_6__2__Impl rule__Sequence__Group_6__3 ;
    public final void rule__Sequence__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2709:1: ( rule__Sequence__Group_6__2__Impl rule__Sequence__Group_6__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2710:2: rule__Sequence__Group_6__2__Impl rule__Sequence__Group_6__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__2__Impl_in_rule__Sequence__Group_6__26084);
            rule__Sequence__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_6__3_in_rule__Sequence__Group_6__26087);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2717:1: rule__Sequence__Group_6__2__Impl : ( '\\\\' ) ;
    public final void rule__Sequence__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2721:1: ( ( '\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2722:1: ( '\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2722:1: ( '\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2723:1: '\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusKeyword_6_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_6__2__Impl6115); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2736:1: rule__Sequence__Group_6__3 : rule__Sequence__Group_6__3__Impl ;
    public final void rule__Sequence__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2740:1: ( rule__Sequence__Group_6__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2741:2: rule__Sequence__Group_6__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__3__Impl_in_rule__Sequence__Group_6__36146);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2747:1: rule__Sequence__Group_6__3__Impl : ( '\\\\' ) ;
    public final void rule__Sequence__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2751:1: ( ( '\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2752:1: ( '\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2752:1: ( '\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2753:1: '\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusKeyword_6_3()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_6__3__Impl6174); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2774:1: rule__Sequence__Group_7__0 : rule__Sequence__Group_7__0__Impl rule__Sequence__Group_7__1 ;
    public final void rule__Sequence__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2778:1: ( rule__Sequence__Group_7__0__Impl rule__Sequence__Group_7__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2779:2: rule__Sequence__Group_7__0__Impl rule__Sequence__Group_7__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_7__0__Impl_in_rule__Sequence__Group_7__06213);
            rule__Sequence__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_7__1_in_rule__Sequence__Group_7__06216);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2786:1: rule__Sequence__Group_7__0__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2790:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2791:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2791:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2792:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_7_0()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_7__0__Impl6244); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2805:1: rule__Sequence__Group_7__1 : rule__Sequence__Group_7__1__Impl rule__Sequence__Group_7__2 ;
    public final void rule__Sequence__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2809:1: ( rule__Sequence__Group_7__1__Impl rule__Sequence__Group_7__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2810:2: rule__Sequence__Group_7__1__Impl rule__Sequence__Group_7__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_7__1__Impl_in_rule__Sequence__Group_7__16275);
            rule__Sequence__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_7__2_in_rule__Sequence__Group_7__16278);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2817:1: rule__Sequence__Group_7__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2821:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2822:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2822:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2823:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_7_1()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_7__1__Impl6306); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2836:1: rule__Sequence__Group_7__2 : rule__Sequence__Group_7__2__Impl ;
    public final void rule__Sequence__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2840:1: ( rule__Sequence__Group_7__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2841:2: rule__Sequence__Group_7__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_7__2__Impl_in_rule__Sequence__Group_7__26337);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2847:1: rule__Sequence__Group_7__2__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2851:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2852:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2852:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2853:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_7_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2854:1: ( '-' )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==159) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2855:2: '-'
            	    {
            	    match(input,159,FOLLOW_159_in_rule__Sequence__Group_7__2__Impl6366); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2872:1: rule__Sequence__Group_8__0 : rule__Sequence__Group_8__0__Impl rule__Sequence__Group_8__1 ;
    public final void rule__Sequence__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2876:1: ( rule__Sequence__Group_8__0__Impl rule__Sequence__Group_8__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2877:2: rule__Sequence__Group_8__0__Impl rule__Sequence__Group_8__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_8__0__Impl_in_rule__Sequence__Group_8__06405);
            rule__Sequence__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_8__1_in_rule__Sequence__Group_8__06408);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2884:1: rule__Sequence__Group_8__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2888:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2889:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2889:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2890:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_8_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2891:1: ( '-' )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==159) ) {
                    int LA15_1 = input.LA(2);

                    if ( (LA15_1==159) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2892:2: '-'
            	    {
            	    match(input,159,FOLLOW_159_in_rule__Sequence__Group_8__0__Impl6437); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2903:1: rule__Sequence__Group_8__1 : rule__Sequence__Group_8__1__Impl rule__Sequence__Group_8__2 ;
    public final void rule__Sequence__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2907:1: ( rule__Sequence__Group_8__1__Impl rule__Sequence__Group_8__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2908:2: rule__Sequence__Group_8__1__Impl rule__Sequence__Group_8__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_8__1__Impl_in_rule__Sequence__Group_8__16470);
            rule__Sequence__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_8__2_in_rule__Sequence__Group_8__16473);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2915:1: rule__Sequence__Group_8__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2919:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2920:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2920:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2921:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_8_1()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_8__1__Impl6501); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2934:1: rule__Sequence__Group_8__2 : rule__Sequence__Group_8__2__Impl ;
    public final void rule__Sequence__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2938:1: ( rule__Sequence__Group_8__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2939:2: rule__Sequence__Group_8__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_8__2__Impl_in_rule__Sequence__Group_8__26532);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2945:1: rule__Sequence__Group_8__2__Impl : ( '\\\\\\\\' ) ;
    public final void rule__Sequence__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2949:1: ( ( '\\\\\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2950:1: ( '\\\\\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2950:1: ( '\\\\\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2951:1: '\\\\\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusReverseSolidusKeyword_8_2()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_8__2__Impl6560); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2970:1: rule__Sequence__Group_9__0 : rule__Sequence__Group_9__0__Impl rule__Sequence__Group_9__1 ;
    public final void rule__Sequence__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2974:1: ( rule__Sequence__Group_9__0__Impl rule__Sequence__Group_9__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2975:2: rule__Sequence__Group_9__0__Impl rule__Sequence__Group_9__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__0__Impl_in_rule__Sequence__Group_9__06597);
            rule__Sequence__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_9__1_in_rule__Sequence__Group_9__06600);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2982:1: rule__Sequence__Group_9__0__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2986:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2987:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2987:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2988:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_9_0()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_9__0__Impl6628); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3001:1: rule__Sequence__Group_9__1 : rule__Sequence__Group_9__1__Impl rule__Sequence__Group_9__2 ;
    public final void rule__Sequence__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3005:1: ( rule__Sequence__Group_9__1__Impl rule__Sequence__Group_9__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3006:2: rule__Sequence__Group_9__1__Impl rule__Sequence__Group_9__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__1__Impl_in_rule__Sequence__Group_9__16659);
            rule__Sequence__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_9__2_in_rule__Sequence__Group_9__16662);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3013:1: rule__Sequence__Group_9__1__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3017:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3018:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3018:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3019:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_9_1()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_9__1__Impl6690); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3032:1: rule__Sequence__Group_9__2 : rule__Sequence__Group_9__2__Impl rule__Sequence__Group_9__3 ;
    public final void rule__Sequence__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3036:1: ( rule__Sequence__Group_9__2__Impl rule__Sequence__Group_9__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3037:2: rule__Sequence__Group_9__2__Impl rule__Sequence__Group_9__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__2__Impl_in_rule__Sequence__Group_9__26721);
            rule__Sequence__Group_9__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_9__3_in_rule__Sequence__Group_9__26724);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3044:1: rule__Sequence__Group_9__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3048:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3049:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3049:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3050:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_9_2()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_9__2__Impl6752); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3063:1: rule__Sequence__Group_9__3 : rule__Sequence__Group_9__3__Impl ;
    public final void rule__Sequence__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3067:1: ( rule__Sequence__Group_9__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3068:2: rule__Sequence__Group_9__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__3__Impl_in_rule__Sequence__Group_9__36783);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3074:1: rule__Sequence__Group_9__3__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3078:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3079:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3079:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3080:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_9_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3081:1: ( '-' )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==159) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3082:2: '-'
            	    {
            	    match(input,159,FOLLOW_159_in_rule__Sequence__Group_9__3__Impl6812); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3101:1: rule__Sequence__Group_10__0 : rule__Sequence__Group_10__0__Impl rule__Sequence__Group_10__1 ;
    public final void rule__Sequence__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3105:1: ( rule__Sequence__Group_10__0__Impl rule__Sequence__Group_10__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3106:2: rule__Sequence__Group_10__0__Impl rule__Sequence__Group_10__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__0__Impl_in_rule__Sequence__Group_10__06853);
            rule__Sequence__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_10__1_in_rule__Sequence__Group_10__06856);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3113:1: rule__Sequence__Group_10__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3117:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3118:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3118:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3119:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_10_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3120:1: ( '-' )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==159) ) {
                    int LA17_1 = input.LA(2);

                    if ( (LA17_1==159) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3121:2: '-'
            	    {
            	    match(input,159,FOLLOW_159_in_rule__Sequence__Group_10__0__Impl6885); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3132:1: rule__Sequence__Group_10__1 : rule__Sequence__Group_10__1__Impl rule__Sequence__Group_10__2 ;
    public final void rule__Sequence__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3136:1: ( rule__Sequence__Group_10__1__Impl rule__Sequence__Group_10__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3137:2: rule__Sequence__Group_10__1__Impl rule__Sequence__Group_10__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__1__Impl_in_rule__Sequence__Group_10__16918);
            rule__Sequence__Group_10__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_10__2_in_rule__Sequence__Group_10__16921);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3144:1: rule__Sequence__Group_10__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3148:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3149:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3149:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3150:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_10_1()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_10__1__Impl6949); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3163:1: rule__Sequence__Group_10__2 : rule__Sequence__Group_10__2__Impl rule__Sequence__Group_10__3 ;
    public final void rule__Sequence__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3167:1: ( rule__Sequence__Group_10__2__Impl rule__Sequence__Group_10__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3168:2: rule__Sequence__Group_10__2__Impl rule__Sequence__Group_10__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__2__Impl_in_rule__Sequence__Group_10__26980);
            rule__Sequence__Group_10__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_10__3_in_rule__Sequence__Group_10__26983);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3175:1: rule__Sequence__Group_10__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3179:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3180:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3180:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3181:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_10_2()); 
            match(input,160,FOLLOW_160_in_rule__Sequence__Group_10__2__Impl7011); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3194:1: rule__Sequence__Group_10__3 : rule__Sequence__Group_10__3__Impl ;
    public final void rule__Sequence__Group_10__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3198:1: ( rule__Sequence__Group_10__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3199:2: rule__Sequence__Group_10__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__3__Impl_in_rule__Sequence__Group_10__37042);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3205:1: rule__Sequence__Group_10__3__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_10__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3209:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3210:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3210:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3211:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_10_3()); 
            match(input,166,FOLLOW_166_in_rule__Sequence__Group_10__3__Impl7070); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3232:1: rule__Sequence__Group_11__0 : rule__Sequence__Group_11__0__Impl rule__Sequence__Group_11__1 ;
    public final void rule__Sequence__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3236:1: ( rule__Sequence__Group_11__0__Impl rule__Sequence__Group_11__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3237:2: rule__Sequence__Group_11__0__Impl rule__Sequence__Group_11__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__0__Impl_in_rule__Sequence__Group_11__07109);
            rule__Sequence__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_11__1_in_rule__Sequence__Group_11__07112);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3244:1: rule__Sequence__Group_11__0__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3248:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3249:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3249:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3250:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_11_0()); 
            match(input,166,FOLLOW_166_in_rule__Sequence__Group_11__0__Impl7140); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3263:1: rule__Sequence__Group_11__1 : rule__Sequence__Group_11__1__Impl rule__Sequence__Group_11__2 ;
    public final void rule__Sequence__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3267:1: ( rule__Sequence__Group_11__1__Impl rule__Sequence__Group_11__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3268:2: rule__Sequence__Group_11__1__Impl rule__Sequence__Group_11__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__1__Impl_in_rule__Sequence__Group_11__17171);
            rule__Sequence__Group_11__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_11__2_in_rule__Sequence__Group_11__17174);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3275:1: rule__Sequence__Group_11__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3279:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3280:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3280:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3281:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_11_1()); 
            match(input,161,FOLLOW_161_in_rule__Sequence__Group_11__1__Impl7202); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3294:1: rule__Sequence__Group_11__2 : rule__Sequence__Group_11__2__Impl rule__Sequence__Group_11__3 ;
    public final void rule__Sequence__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3298:1: ( rule__Sequence__Group_11__2__Impl rule__Sequence__Group_11__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3299:2: rule__Sequence__Group_11__2__Impl rule__Sequence__Group_11__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__2__Impl_in_rule__Sequence__Group_11__27233);
            rule__Sequence__Group_11__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_11__3_in_rule__Sequence__Group_11__27236);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3306:1: rule__Sequence__Group_11__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3310:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3311:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3311:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3312:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_11_2()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_11__2__Impl7264); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3325:1: rule__Sequence__Group_11__3 : rule__Sequence__Group_11__3__Impl ;
    public final void rule__Sequence__Group_11__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3329:1: ( rule__Sequence__Group_11__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3330:2: rule__Sequence__Group_11__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__3__Impl_in_rule__Sequence__Group_11__37295);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3336:1: rule__Sequence__Group_11__3__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_11__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3340:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3341:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3341:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3342:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_11_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3343:1: ( '-' )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==159) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3344:2: '-'
            	    {
            	    match(input,159,FOLLOW_159_in_rule__Sequence__Group_11__3__Impl7324); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3363:1: rule__Sequence__Group_12__0 : rule__Sequence__Group_12__0__Impl rule__Sequence__Group_12__1 ;
    public final void rule__Sequence__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3367:1: ( rule__Sequence__Group_12__0__Impl rule__Sequence__Group_12__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3368:2: rule__Sequence__Group_12__0__Impl rule__Sequence__Group_12__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__0__Impl_in_rule__Sequence__Group_12__07365);
            rule__Sequence__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__1_in_rule__Sequence__Group_12__07368);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3375:1: rule__Sequence__Group_12__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3379:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3380:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3380:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3381:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3382:1: ( '-' )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==159) ) {
                    int LA19_1 = input.LA(2);

                    if ( (LA19_1==159) ) {
                        int LA19_2 = input.LA(3);

                        if ( (LA19_2==159) ) {
                            alt19=1;
                        }


                    }


                }


                switch (alt19) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3383:2: '-'
            	    {
            	    match(input,159,FOLLOW_159_in_rule__Sequence__Group_12__0__Impl7397); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3394:1: rule__Sequence__Group_12__1 : rule__Sequence__Group_12__1__Impl rule__Sequence__Group_12__2 ;
    public final void rule__Sequence__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3398:1: ( rule__Sequence__Group_12__1__Impl rule__Sequence__Group_12__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3399:2: rule__Sequence__Group_12__1__Impl rule__Sequence__Group_12__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__1__Impl_in_rule__Sequence__Group_12__17430);
            rule__Sequence__Group_12__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__2_in_rule__Sequence__Group_12__17433);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3406:1: rule__Sequence__Group_12__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3410:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3411:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3411:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3412:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_1()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_12__1__Impl7461); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3425:1: rule__Sequence__Group_12__2 : rule__Sequence__Group_12__2__Impl rule__Sequence__Group_12__3 ;
    public final void rule__Sequence__Group_12__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3429:1: ( rule__Sequence__Group_12__2__Impl rule__Sequence__Group_12__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3430:2: rule__Sequence__Group_12__2__Impl rule__Sequence__Group_12__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__2__Impl_in_rule__Sequence__Group_12__27492);
            rule__Sequence__Group_12__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__3_in_rule__Sequence__Group_12__27495);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3437:1: rule__Sequence__Group_12__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_12__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3441:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3442:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3442:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3443:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_2()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_12__2__Impl7523); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3456:1: rule__Sequence__Group_12__3 : rule__Sequence__Group_12__3__Impl rule__Sequence__Group_12__4 ;
    public final void rule__Sequence__Group_12__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3460:1: ( rule__Sequence__Group_12__3__Impl rule__Sequence__Group_12__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3461:2: rule__Sequence__Group_12__3__Impl rule__Sequence__Group_12__4
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__3__Impl_in_rule__Sequence__Group_12__37554);
            rule__Sequence__Group_12__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__4_in_rule__Sequence__Group_12__37557);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3468:1: rule__Sequence__Group_12__3__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_12__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3472:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3473:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3473:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3474:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_12_3()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_12__3__Impl7585); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3487:1: rule__Sequence__Group_12__4 : rule__Sequence__Group_12__4__Impl rule__Sequence__Group_12__5 ;
    public final void rule__Sequence__Group_12__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3491:1: ( rule__Sequence__Group_12__4__Impl rule__Sequence__Group_12__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3492:2: rule__Sequence__Group_12__4__Impl rule__Sequence__Group_12__5
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__4__Impl_in_rule__Sequence__Group_12__47616);
            rule__Sequence__Group_12__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__5_in_rule__Sequence__Group_12__47619);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3499:1: rule__Sequence__Group_12__4__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_12__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3503:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3504:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3504:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3505:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_12_4()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_12__4__Impl7647); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3518:1: rule__Sequence__Group_12__5 : rule__Sequence__Group_12__5__Impl ;
    public final void rule__Sequence__Group_12__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3522:1: ( rule__Sequence__Group_12__5__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3523:2: rule__Sequence__Group_12__5__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__5__Impl_in_rule__Sequence__Group_12__57678);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3529:1: rule__Sequence__Group_12__5__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_12__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3533:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3534:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3534:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3535:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_12_5()); 
            match(input,166,FOLLOW_166_in_rule__Sequence__Group_12__5__Impl7706); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3560:1: rule__Sequence__Group_13__0 : rule__Sequence__Group_13__0__Impl rule__Sequence__Group_13__1 ;
    public final void rule__Sequence__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3564:1: ( rule__Sequence__Group_13__0__Impl rule__Sequence__Group_13__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3565:2: rule__Sequence__Group_13__0__Impl rule__Sequence__Group_13__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__0__Impl_in_rule__Sequence__Group_13__07749);
            rule__Sequence__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__1_in_rule__Sequence__Group_13__07752);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3572:1: rule__Sequence__Group_13__0__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3576:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3577:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3577:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3578:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_13_0()); 
            match(input,166,FOLLOW_166_in_rule__Sequence__Group_13__0__Impl7780); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3591:1: rule__Sequence__Group_13__1 : rule__Sequence__Group_13__1__Impl rule__Sequence__Group_13__2 ;
    public final void rule__Sequence__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3595:1: ( rule__Sequence__Group_13__1__Impl rule__Sequence__Group_13__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3596:2: rule__Sequence__Group_13__1__Impl rule__Sequence__Group_13__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__1__Impl_in_rule__Sequence__Group_13__17811);
            rule__Sequence__Group_13__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__2_in_rule__Sequence__Group_13__17814);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3603:1: rule__Sequence__Group_13__1__Impl : ( '\\\\\\\\' ) ;
    public final void rule__Sequence__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3607:1: ( ( '\\\\\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3608:1: ( '\\\\\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3608:1: ( '\\\\\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3609:1: '\\\\\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusReverseSolidusKeyword_13_1()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_13__1__Impl7842); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3622:1: rule__Sequence__Group_13__2 : rule__Sequence__Group_13__2__Impl rule__Sequence__Group_13__3 ;
    public final void rule__Sequence__Group_13__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3626:1: ( rule__Sequence__Group_13__2__Impl rule__Sequence__Group_13__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3627:2: rule__Sequence__Group_13__2__Impl rule__Sequence__Group_13__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__2__Impl_in_rule__Sequence__Group_13__27873);
            rule__Sequence__Group_13__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__3_in_rule__Sequence__Group_13__27876);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3634:1: rule__Sequence__Group_13__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_13__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3638:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3639:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3639:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3640:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_2()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_13__2__Impl7904); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3653:1: rule__Sequence__Group_13__3 : rule__Sequence__Group_13__3__Impl rule__Sequence__Group_13__4 ;
    public final void rule__Sequence__Group_13__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3657:1: ( rule__Sequence__Group_13__3__Impl rule__Sequence__Group_13__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3658:2: rule__Sequence__Group_13__3__Impl rule__Sequence__Group_13__4
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__3__Impl_in_rule__Sequence__Group_13__37935);
            rule__Sequence__Group_13__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__4_in_rule__Sequence__Group_13__37938);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3665:1: rule__Sequence__Group_13__3__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_13__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3669:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3670:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3670:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3671:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_3()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_13__3__Impl7966); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3684:1: rule__Sequence__Group_13__4 : rule__Sequence__Group_13__4__Impl ;
    public final void rule__Sequence__Group_13__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3688:1: ( rule__Sequence__Group_13__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3689:2: rule__Sequence__Group_13__4__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__4__Impl_in_rule__Sequence__Group_13__47997);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3695:1: rule__Sequence__Group_13__4__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_13__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3699:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3700:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3700:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3701:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3702:1: ( '-' )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==159) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3703:2: '-'
            	    {
            	    match(input,159,FOLLOW_159_in_rule__Sequence__Group_13__4__Impl8026); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3724:1: rule__Sequence__Group_14__0 : rule__Sequence__Group_14__0__Impl rule__Sequence__Group_14__1 ;
    public final void rule__Sequence__Group_14__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3728:1: ( rule__Sequence__Group_14__0__Impl rule__Sequence__Group_14__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3729:2: rule__Sequence__Group_14__0__Impl rule__Sequence__Group_14__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_14__0__Impl_in_rule__Sequence__Group_14__08069);
            rule__Sequence__Group_14__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_14__1_in_rule__Sequence__Group_14__08072);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3736:1: rule__Sequence__Group_14__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_14__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3740:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3741:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3741:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3742:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_14_0()); 
            match(input,161,FOLLOW_161_in_rule__Sequence__Group_14__0__Impl8100); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3755:1: rule__Sequence__Group_14__1 : rule__Sequence__Group_14__1__Impl rule__Sequence__Group_14__2 ;
    public final void rule__Sequence__Group_14__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3759:1: ( rule__Sequence__Group_14__1__Impl rule__Sequence__Group_14__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3760:2: rule__Sequence__Group_14__1__Impl rule__Sequence__Group_14__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_14__1__Impl_in_rule__Sequence__Group_14__18131);
            rule__Sequence__Group_14__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_14__2_in_rule__Sequence__Group_14__18134);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3767:1: rule__Sequence__Group_14__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_14__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3771:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3772:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3772:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3773:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_14_1()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_14__1__Impl8162); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3786:1: rule__Sequence__Group_14__2 : rule__Sequence__Group_14__2__Impl ;
    public final void rule__Sequence__Group_14__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3790:1: ( rule__Sequence__Group_14__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3791:2: rule__Sequence__Group_14__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_14__2__Impl_in_rule__Sequence__Group_14__28193);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3797:1: rule__Sequence__Group_14__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_14__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3801:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3802:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3802:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3803:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_14_2()); 
            match(input,160,FOLLOW_160_in_rule__Sequence__Group_14__2__Impl8221); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3822:1: rule__Sequence__Group_15__0 : rule__Sequence__Group_15__0__Impl rule__Sequence__Group_15__1 ;
    public final void rule__Sequence__Group_15__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3826:1: ( rule__Sequence__Group_15__0__Impl rule__Sequence__Group_15__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3827:2: rule__Sequence__Group_15__0__Impl rule__Sequence__Group_15__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__0__Impl_in_rule__Sequence__Group_15__08258);
            rule__Sequence__Group_15__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_15__1_in_rule__Sequence__Group_15__08261);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3834:1: rule__Sequence__Group_15__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_15__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3838:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3839:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3839:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3840:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_15_0()); 
            match(input,161,FOLLOW_161_in_rule__Sequence__Group_15__0__Impl8289); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3853:1: rule__Sequence__Group_15__1 : rule__Sequence__Group_15__1__Impl rule__Sequence__Group_15__2 ;
    public final void rule__Sequence__Group_15__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3857:1: ( rule__Sequence__Group_15__1__Impl rule__Sequence__Group_15__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3858:2: rule__Sequence__Group_15__1__Impl rule__Sequence__Group_15__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__1__Impl_in_rule__Sequence__Group_15__18320);
            rule__Sequence__Group_15__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_15__2_in_rule__Sequence__Group_15__18323);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3865:1: rule__Sequence__Group_15__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_15__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3869:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3870:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3870:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3871:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_15_1()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_15__1__Impl8351); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3884:1: rule__Sequence__Group_15__2 : rule__Sequence__Group_15__2__Impl rule__Sequence__Group_15__3 ;
    public final void rule__Sequence__Group_15__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3888:1: ( rule__Sequence__Group_15__2__Impl rule__Sequence__Group_15__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3889:2: rule__Sequence__Group_15__2__Impl rule__Sequence__Group_15__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__2__Impl_in_rule__Sequence__Group_15__28382);
            rule__Sequence__Group_15__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_15__3_in_rule__Sequence__Group_15__28385);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3896:1: rule__Sequence__Group_15__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_15__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3900:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3901:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3901:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3902:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_15_2()); 
            match(input,160,FOLLOW_160_in_rule__Sequence__Group_15__2__Impl8413); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3915:1: rule__Sequence__Group_15__3 : rule__Sequence__Group_15__3__Impl ;
    public final void rule__Sequence__Group_15__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3919:1: ( rule__Sequence__Group_15__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3920:2: rule__Sequence__Group_15__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__3__Impl_in_rule__Sequence__Group_15__38444);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3926:1: rule__Sequence__Group_15__3__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_15__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3930:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3931:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3931:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3932:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_15_3()); 
            match(input,166,FOLLOW_166_in_rule__Sequence__Group_15__3__Impl8472); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3953:1: rule__Sequence__Group_16__0 : rule__Sequence__Group_16__0__Impl rule__Sequence__Group_16__1 ;
    public final void rule__Sequence__Group_16__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3957:1: ( rule__Sequence__Group_16__0__Impl rule__Sequence__Group_16__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3958:2: rule__Sequence__Group_16__0__Impl rule__Sequence__Group_16__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__0__Impl_in_rule__Sequence__Group_16__08511);
            rule__Sequence__Group_16__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_16__1_in_rule__Sequence__Group_16__08514);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3965:1: rule__Sequence__Group_16__0__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_16__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3969:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3970:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3970:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3971:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_16_0()); 
            match(input,166,FOLLOW_166_in_rule__Sequence__Group_16__0__Impl8542); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3984:1: rule__Sequence__Group_16__1 : rule__Sequence__Group_16__1__Impl rule__Sequence__Group_16__2 ;
    public final void rule__Sequence__Group_16__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3988:1: ( rule__Sequence__Group_16__1__Impl rule__Sequence__Group_16__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3989:2: rule__Sequence__Group_16__1__Impl rule__Sequence__Group_16__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__1__Impl_in_rule__Sequence__Group_16__18573);
            rule__Sequence__Group_16__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_16__2_in_rule__Sequence__Group_16__18576);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3996:1: rule__Sequence__Group_16__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_16__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4000:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4001:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4001:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4002:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_16_1()); 
            match(input,161,FOLLOW_161_in_rule__Sequence__Group_16__1__Impl8604); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4015:1: rule__Sequence__Group_16__2 : rule__Sequence__Group_16__2__Impl rule__Sequence__Group_16__3 ;
    public final void rule__Sequence__Group_16__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4019:1: ( rule__Sequence__Group_16__2__Impl rule__Sequence__Group_16__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4020:2: rule__Sequence__Group_16__2__Impl rule__Sequence__Group_16__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__2__Impl_in_rule__Sequence__Group_16__28635);
            rule__Sequence__Group_16__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_16__3_in_rule__Sequence__Group_16__28638);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4027:1: rule__Sequence__Group_16__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_16__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4031:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4032:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4032:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4033:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_16_2()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_16__2__Impl8666); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4046:1: rule__Sequence__Group_16__3 : rule__Sequence__Group_16__3__Impl ;
    public final void rule__Sequence__Group_16__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4050:1: ( rule__Sequence__Group_16__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4051:2: rule__Sequence__Group_16__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__3__Impl_in_rule__Sequence__Group_16__38697);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4057:1: rule__Sequence__Group_16__3__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_16__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4061:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4062:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4062:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4063:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_16_3()); 
            match(input,160,FOLLOW_160_in_rule__Sequence__Group_16__3__Impl8725); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4084:1: rule__Sequence__Group_17__0 : rule__Sequence__Group_17__0__Impl rule__Sequence__Group_17__1 ;
    public final void rule__Sequence__Group_17__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4088:1: ( rule__Sequence__Group_17__0__Impl rule__Sequence__Group_17__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4089:2: rule__Sequence__Group_17__0__Impl rule__Sequence__Group_17__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__0__Impl_in_rule__Sequence__Group_17__08764);
            rule__Sequence__Group_17__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_17__1_in_rule__Sequence__Group_17__08767);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4096:1: rule__Sequence__Group_17__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_17__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4100:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4101:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4101:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4102:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_17_0()); 
            match(input,161,FOLLOW_161_in_rule__Sequence__Group_17__0__Impl8795); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4115:1: rule__Sequence__Group_17__1 : rule__Sequence__Group_17__1__Impl rule__Sequence__Group_17__2 ;
    public final void rule__Sequence__Group_17__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4119:1: ( rule__Sequence__Group_17__1__Impl rule__Sequence__Group_17__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4120:2: rule__Sequence__Group_17__1__Impl rule__Sequence__Group_17__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__1__Impl_in_rule__Sequence__Group_17__18826);
            rule__Sequence__Group_17__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_17__2_in_rule__Sequence__Group_17__18829);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4127:1: rule__Sequence__Group_17__1__Impl : ( '|' ) ;
    public final void rule__Sequence__Group_17__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4131:1: ( ( '|' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4132:1: ( '|' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4132:1: ( '|' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4133:1: '|'
            {
             before(grammarAccess.getSequenceAccess().getVerticalLineKeyword_17_1()); 
            match(input,167,FOLLOW_167_in_rule__Sequence__Group_17__1__Impl8857); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4146:1: rule__Sequence__Group_17__2 : rule__Sequence__Group_17__2__Impl rule__Sequence__Group_17__3 ;
    public final void rule__Sequence__Group_17__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4150:1: ( rule__Sequence__Group_17__2__Impl rule__Sequence__Group_17__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4151:2: rule__Sequence__Group_17__2__Impl rule__Sequence__Group_17__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__2__Impl_in_rule__Sequence__Group_17__28888);
            rule__Sequence__Group_17__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_17__3_in_rule__Sequence__Group_17__28891);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4158:1: rule__Sequence__Group_17__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_17__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4162:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4163:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4163:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4164:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_17_2()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_17__2__Impl8919); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4177:1: rule__Sequence__Group_17__3 : rule__Sequence__Group_17__3__Impl ;
    public final void rule__Sequence__Group_17__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4181:1: ( rule__Sequence__Group_17__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4182:2: rule__Sequence__Group_17__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__3__Impl_in_rule__Sequence__Group_17__38950);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4188:1: rule__Sequence__Group_17__3__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_17__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4192:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4193:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4193:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4194:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_17_3()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_17__3__Impl8978); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4215:1: rule__Sequence__Group_18__0 : rule__Sequence__Group_18__0__Impl rule__Sequence__Group_18__1 ;
    public final void rule__Sequence__Group_18__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4219:1: ( rule__Sequence__Group_18__0__Impl rule__Sequence__Group_18__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4220:2: rule__Sequence__Group_18__0__Impl rule__Sequence__Group_18__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__0__Impl_in_rule__Sequence__Group_18__09017);
            rule__Sequence__Group_18__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_18__1_in_rule__Sequence__Group_18__09020);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4227:1: rule__Sequence__Group_18__0__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_18__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4231:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4232:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4232:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4233:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_18_0()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_18__0__Impl9048); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4246:1: rule__Sequence__Group_18__1 : rule__Sequence__Group_18__1__Impl rule__Sequence__Group_18__2 ;
    public final void rule__Sequence__Group_18__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4250:1: ( rule__Sequence__Group_18__1__Impl rule__Sequence__Group_18__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4251:2: rule__Sequence__Group_18__1__Impl rule__Sequence__Group_18__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__1__Impl_in_rule__Sequence__Group_18__19079);
            rule__Sequence__Group_18__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_18__2_in_rule__Sequence__Group_18__19082);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4258:1: rule__Sequence__Group_18__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_18__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4262:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4263:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4263:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4264:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_18_1()); 
            match(input,159,FOLLOW_159_in_rule__Sequence__Group_18__1__Impl9110); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4277:1: rule__Sequence__Group_18__2 : rule__Sequence__Group_18__2__Impl rule__Sequence__Group_18__3 ;
    public final void rule__Sequence__Group_18__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4281:1: ( rule__Sequence__Group_18__2__Impl rule__Sequence__Group_18__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4282:2: rule__Sequence__Group_18__2__Impl rule__Sequence__Group_18__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__2__Impl_in_rule__Sequence__Group_18__29141);
            rule__Sequence__Group_18__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_18__3_in_rule__Sequence__Group_18__29144);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4289:1: rule__Sequence__Group_18__2__Impl : ( '|' ) ;
    public final void rule__Sequence__Group_18__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4293:1: ( ( '|' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4294:1: ( '|' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4294:1: ( '|' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4295:1: '|'
            {
             before(grammarAccess.getSequenceAccess().getVerticalLineKeyword_18_2()); 
            match(input,167,FOLLOW_167_in_rule__Sequence__Group_18__2__Impl9172); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4308:1: rule__Sequence__Group_18__3 : rule__Sequence__Group_18__3__Impl ;
    public final void rule__Sequence__Group_18__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4312:1: ( rule__Sequence__Group_18__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4313:2: rule__Sequence__Group_18__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__3__Impl_in_rule__Sequence__Group_18__39203);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4319:1: rule__Sequence__Group_18__3__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_18__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4323:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4324:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4324:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4325:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_18_3()); 
            match(input,160,FOLLOW_160_in_rule__Sequence__Group_18__3__Impl9231); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4346:1: rule__Sequence__Group_19__0 : rule__Sequence__Group_19__0__Impl rule__Sequence__Group_19__1 ;
    public final void rule__Sequence__Group_19__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4350:1: ( rule__Sequence__Group_19__0__Impl rule__Sequence__Group_19__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4351:2: rule__Sequence__Group_19__0__Impl rule__Sequence__Group_19__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_19__0__Impl_in_rule__Sequence__Group_19__09270);
            rule__Sequence__Group_19__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_19__1_in_rule__Sequence__Group_19__09273);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4358:1: rule__Sequence__Group_19__0__Impl : ( '.' ) ;
    public final void rule__Sequence__Group_19__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4362:1: ( ( '.' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4363:1: ( '.' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4363:1: ( '.' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4364:1: '.'
            {
             before(grammarAccess.getSequenceAccess().getFullStopKeyword_19_0()); 
            match(input,10,FOLLOW_10_in_rule__Sequence__Group_19__0__Impl9301); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4377:1: rule__Sequence__Group_19__1 : rule__Sequence__Group_19__1__Impl ;
    public final void rule__Sequence__Group_19__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4381:1: ( rule__Sequence__Group_19__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4382:2: rule__Sequence__Group_19__1__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_19__1__Impl_in_rule__Sequence__Group_19__19332);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4388:1: rule__Sequence__Group_19__1__Impl : ( '.' ) ;
    public final void rule__Sequence__Group_19__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4392:1: ( ( '.' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4393:1: ( '.' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4393:1: ( '.' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4394:1: '.'
            {
             before(grammarAccess.getSequenceAccess().getFullStopKeyword_19_1()); 
            match(input,10,FOLLOW_10_in_rule__Sequence__Group_19__1__Impl9360); 
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


    // $ANTLR start "rule__Definition__Group_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4411:1: rule__Definition__Group_0__0 : rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 ;
    public final void rule__Definition__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4415:1: ( rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4416:2: rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__09395);
            rule__Definition__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__09398);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4423:1: rule__Definition__Group_0__0__Impl : ( 'actor' ) ;
    public final void rule__Definition__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4427:1: ( ( 'actor' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4428:1: ( 'actor' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4428:1: ( 'actor' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4429:1: 'actor'
            {
             before(grammarAccess.getDefinitionAccess().getActorKeyword_0_0()); 
            match(input,168,FOLLOW_168_in_rule__Definition__Group_0__0__Impl9426); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4442:1: rule__Definition__Group_0__1 : rule__Definition__Group_0__1__Impl ;
    public final void rule__Definition__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4446:1: ( rule__Definition__Group_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4447:2: rule__Definition__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__19457);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4453:1: rule__Definition__Group_0__1__Impl : ( ( rule__Definition__NameAssignment_0_1 ) ) ;
    public final void rule__Definition__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4457:1: ( ( ( rule__Definition__NameAssignment_0_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4458:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4458:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4459:1: ( rule__Definition__NameAssignment_0_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4460:1: ( rule__Definition__NameAssignment_0_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4460:2: rule__Definition__NameAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl9484);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4474:1: rule__Definition__Group_1__0 : rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 ;
    public final void rule__Definition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4478:1: ( rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4479:2: rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__09518);
            rule__Definition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__09521);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4486:1: rule__Definition__Group_1__0__Impl : ( 'boundary' ) ;
    public final void rule__Definition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4490:1: ( ( 'boundary' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4491:1: ( 'boundary' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4491:1: ( 'boundary' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4492:1: 'boundary'
            {
             before(grammarAccess.getDefinitionAccess().getBoundaryKeyword_1_0()); 
            match(input,169,FOLLOW_169_in_rule__Definition__Group_1__0__Impl9549); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4505:1: rule__Definition__Group_1__1 : rule__Definition__Group_1__1__Impl ;
    public final void rule__Definition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4509:1: ( rule__Definition__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4510:2: rule__Definition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__19580);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4516:1: rule__Definition__Group_1__1__Impl : ( ( rule__Definition__NameAssignment_1_1 ) ) ;
    public final void rule__Definition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4520:1: ( ( ( rule__Definition__NameAssignment_1_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4521:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4521:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4522:1: ( rule__Definition__NameAssignment_1_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4523:1: ( rule__Definition__NameAssignment_1_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4523:2: rule__Definition__NameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl9607);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4537:1: rule__Definition__Group_2__0 : rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 ;
    public final void rule__Definition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4541:1: ( rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4542:2: rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__09641);
            rule__Definition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__09644);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4549:1: rule__Definition__Group_2__0__Impl : ( 'control' ) ;
    public final void rule__Definition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4553:1: ( ( 'control' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4554:1: ( 'control' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4554:1: ( 'control' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4555:1: 'control'
            {
             before(grammarAccess.getDefinitionAccess().getControlKeyword_2_0()); 
            match(input,170,FOLLOW_170_in_rule__Definition__Group_2__0__Impl9672); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4568:1: rule__Definition__Group_2__1 : rule__Definition__Group_2__1__Impl ;
    public final void rule__Definition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4572:1: ( rule__Definition__Group_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4573:2: rule__Definition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__19703);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4579:1: rule__Definition__Group_2__1__Impl : ( ( rule__Definition__NameAssignment_2_1 ) ) ;
    public final void rule__Definition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4583:1: ( ( ( rule__Definition__NameAssignment_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4584:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4584:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4585:1: ( rule__Definition__NameAssignment_2_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4586:1: ( rule__Definition__NameAssignment_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4586:2: rule__Definition__NameAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl9730);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4600:1: rule__Definition__Group_3__0 : rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 ;
    public final void rule__Definition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4604:1: ( rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4605:2: rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__09764);
            rule__Definition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__09767);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4612:1: rule__Definition__Group_3__0__Impl : ( 'entity' ) ;
    public final void rule__Definition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4616:1: ( ( 'entity' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4617:1: ( 'entity' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4617:1: ( 'entity' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4618:1: 'entity'
            {
             before(grammarAccess.getDefinitionAccess().getEntityKeyword_3_0()); 
            match(input,171,FOLLOW_171_in_rule__Definition__Group_3__0__Impl9795); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4631:1: rule__Definition__Group_3__1 : rule__Definition__Group_3__1__Impl ;
    public final void rule__Definition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4635:1: ( rule__Definition__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4636:2: rule__Definition__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__19826);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4642:1: rule__Definition__Group_3__1__Impl : ( ( rule__Definition__NameAssignment_3_1 ) ) ;
    public final void rule__Definition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4646:1: ( ( ( rule__Definition__NameAssignment_3_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4647:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4647:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4648:1: ( rule__Definition__NameAssignment_3_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4649:1: ( rule__Definition__NameAssignment_3_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4649:2: rule__Definition__NameAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl9853);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4663:1: rule__Definition__Group_4__0 : rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 ;
    public final void rule__Definition__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4667:1: ( rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4668:2: rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__09887);
            rule__Definition__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__09890);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4675:1: rule__Definition__Group_4__0__Impl : ( 'database' ) ;
    public final void rule__Definition__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4679:1: ( ( 'database' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4680:1: ( 'database' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4680:1: ( 'database' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4681:1: 'database'
            {
             before(grammarAccess.getDefinitionAccess().getDatabaseKeyword_4_0()); 
            match(input,172,FOLLOW_172_in_rule__Definition__Group_4__0__Impl9918); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4694:1: rule__Definition__Group_4__1 : rule__Definition__Group_4__1__Impl ;
    public final void rule__Definition__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4698:1: ( rule__Definition__Group_4__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4699:2: rule__Definition__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__19949);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4705:1: rule__Definition__Group_4__1__Impl : ( ( rule__Definition__NameAssignment_4_1 ) ) ;
    public final void rule__Definition__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4709:1: ( ( ( rule__Definition__NameAssignment_4_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4710:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4710:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4711:1: ( rule__Definition__NameAssignment_4_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_4_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4712:1: ( rule__Definition__NameAssignment_4_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4712:2: rule__Definition__NameAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl9976);
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


    // $ANTLR start "rule__AutoNumber__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4726:1: rule__AutoNumber__Group__0 : rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1 ;
    public final void rule__AutoNumber__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4730:1: ( rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4731:2: rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__0__Impl_in_rule__AutoNumber__Group__010010);
            rule__AutoNumber__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AutoNumber__Group__1_in_rule__AutoNumber__Group__010013);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4738:1: rule__AutoNumber__Group__0__Impl : ( 'autonumber' ) ;
    public final void rule__AutoNumber__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4742:1: ( ( 'autonumber' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4743:1: ( 'autonumber' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4743:1: ( 'autonumber' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4744:1: 'autonumber'
            {
             before(grammarAccess.getAutoNumberAccess().getAutonumberKeyword_0()); 
            match(input,173,FOLLOW_173_in_rule__AutoNumber__Group__0__Impl10041); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4757:1: rule__AutoNumber__Group__1 : rule__AutoNumber__Group__1__Impl ;
    public final void rule__AutoNumber__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4761:1: ( rule__AutoNumber__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4762:2: rule__AutoNumber__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__1__Impl_in_rule__AutoNumber__Group__110072);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4768:1: rule__AutoNumber__Group__1__Impl : ( ( rule__AutoNumber__Group_1__0 )? ) ;
    public final void rule__AutoNumber__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4772:1: ( ( ( rule__AutoNumber__Group_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4773:1: ( ( rule__AutoNumber__Group_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4773:1: ( ( rule__AutoNumber__Group_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4774:1: ( rule__AutoNumber__Group_1__0 )?
            {
             before(grammarAccess.getAutoNumberAccess().getGroup_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4775:1: ( rule__AutoNumber__Group_1__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_INT) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4775:2: rule__AutoNumber__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__AutoNumber__Group_1__0_in_rule__AutoNumber__Group__1__Impl10099);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4789:1: rule__AutoNumber__Group_1__0 : rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1 ;
    public final void rule__AutoNumber__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4793:1: ( rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4794:2: rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group_1__0__Impl_in_rule__AutoNumber__Group_1__010134);
            rule__AutoNumber__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AutoNumber__Group_1__1_in_rule__AutoNumber__Group_1__010137);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4801:1: rule__AutoNumber__Group_1__0__Impl : ( RULE_INT ) ;
    public final void rule__AutoNumber__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4805:1: ( ( RULE_INT ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4806:1: ( RULE_INT )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4806:1: ( RULE_INT )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4807:1: RULE_INT
            {
             before(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__0__Impl10164); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4818:1: rule__AutoNumber__Group_1__1 : rule__AutoNumber__Group_1__1__Impl ;
    public final void rule__AutoNumber__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4822:1: ( rule__AutoNumber__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4823:2: rule__AutoNumber__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group_1__1__Impl_in_rule__AutoNumber__Group_1__110193);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4829:1: rule__AutoNumber__Group_1__1__Impl : ( ( RULE_INT )? ) ;
    public final void rule__AutoNumber__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4833:1: ( ( ( RULE_INT )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4834:1: ( ( RULE_INT )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4834:1: ( ( RULE_INT )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4835:1: ( RULE_INT )?
            {
             before(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4836:1: ( RULE_INT )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_INT) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4836:3: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__1__Impl10221); 

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


    // $ANTLR start "rule__Color__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4850:1: rule__Color__Group__0 : rule__Color__Group__0__Impl rule__Color__Group__1 ;
    public final void rule__Color__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4854:1: ( rule__Color__Group__0__Impl rule__Color__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4855:2: rule__Color__Group__0__Impl rule__Color__Group__1
            {
            pushFollow(FOLLOW_rule__Color__Group__0__Impl_in_rule__Color__Group__010256);
            rule__Color__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Color__Group__1_in_rule__Color__Group__010259);
            rule__Color__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Color__Group__0"


    // $ANTLR start "rule__Color__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4862:1: rule__Color__Group__0__Impl : ( ( ( '#' ) ) ( ( '#' )* ) ) ;
    public final void rule__Color__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4866:1: ( ( ( ( '#' ) ) ( ( '#' )* ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4867:1: ( ( ( '#' ) ) ( ( '#' )* ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4867:1: ( ( ( '#' ) ) ( ( '#' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4868:1: ( ( '#' ) ) ( ( '#' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4868:1: ( ( '#' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4869:1: ( '#' )
            {
             before(grammarAccess.getColorAccess().getNumberSignKeyword_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4870:1: ( '#' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4871:2: '#'
            {
            match(input,174,FOLLOW_174_in_rule__Color__Group__0__Impl10290); 

            }

             after(grammarAccess.getColorAccess().getNumberSignKeyword_0()); 

            }

            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4875:1: ( ( '#' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4876:1: ( '#' )*
            {
             before(grammarAccess.getColorAccess().getNumberSignKeyword_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4877:1: ( '#' )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==174) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4878:2: '#'
            	    {
            	    match(input,174,FOLLOW_174_in_rule__Color__Group__0__Impl10306); 

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getColorAccess().getNumberSignKeyword_0()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Color__Group__0__Impl"


    // $ANTLR start "rule__Color__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4890:1: rule__Color__Group__1 : rule__Color__Group__1__Impl ;
    public final void rule__Color__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4894:1: ( rule__Color__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4895:2: rule__Color__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Color__Group__1__Impl_in_rule__Color__Group__110341);
            rule__Color__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Color__Group__1"


    // $ANTLR start "rule__Color__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4901:1: rule__Color__Group__1__Impl : ( ( rule__Color__Alternatives_1 ) ) ;
    public final void rule__Color__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4905:1: ( ( ( rule__Color__Alternatives_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4906:1: ( ( rule__Color__Alternatives_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4906:1: ( ( rule__Color__Alternatives_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4907:1: ( rule__Color__Alternatives_1 )
            {
             before(grammarAccess.getColorAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4908:1: ( rule__Color__Alternatives_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4908:2: rule__Color__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Color__Alternatives_1_in_rule__Color__Group__1__Impl10368);
            rule__Color__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getColorAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Color__Group__1__Impl"


    // $ANTLR start "rule__Model__DiagramsAssignment"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4923:1: rule__Model__DiagramsAssignment : ( ruleDiagram ) ;
    public final void rule__Model__DiagramsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4927:1: ( ( ruleDiagram ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4928:1: ( ruleDiagram )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4928:1: ( ruleDiagram )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4929:1: ruleDiagram
            {
             before(grammarAccess.getModelAccess().getDiagramsDiagramParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDiagram_in_rule__Model__DiagramsAssignment10407);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4938:1: rule__Diagram__InstructionsAssignment_1 : ( ruleInstruction ) ;
    public final void rule__Diagram__InstructionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4942:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4943:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4943:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4944:1: ruleInstruction
            {
             before(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_110438);
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


    // $ANTLR start "rule__Instruction__Name1Assignment_0_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4953:1: rule__Instruction__Name1Assignment_0_0 : ( RULE_ID ) ;
    public final void rule__Instruction__Name1Assignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4957:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4958:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4958:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4959:1: RULE_ID
            {
             before(grammarAccess.getInstructionAccess().getName1IDTerminalRuleCall_0_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Instruction__Name1Assignment_0_010469); 
             after(grammarAccess.getInstructionAccess().getName1IDTerminalRuleCall_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Name1Assignment_0_0"


    // $ANTLR start "rule__Instruction__Name2Assignment_0_2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4968:1: rule__Instruction__Name2Assignment_0_2 : ( RULE_ID ) ;
    public final void rule__Instruction__Name2Assignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4972:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4973:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4973:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4974:1: RULE_ID
            {
             before(grammarAccess.getInstructionAccess().getName2IDTerminalRuleCall_0_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Instruction__Name2Assignment_0_210500); 
             after(grammarAccess.getInstructionAccess().getName2IDTerminalRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Name2Assignment_0_2"


    // $ANTLR start "rule__Definition__NameAssignment_0_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4983:1: rule__Definition__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4987:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4988:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4988:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4989:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_0_110531); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4998:1: rule__Definition__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5002:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5003:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5003:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5004:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_1_110562); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5013:1: rule__Definition__NameAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5017:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5018:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5018:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5019:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_2_110593); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5028:1: rule__Definition__NameAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5032:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5033:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5033:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5034:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_3_110624); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5043:1: rule__Definition__NameAssignment_4_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5047:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5048:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5048:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5049:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_4_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_4_110655); 
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
    static final String DFA3_eotS =
        "\43\uffff";
    static final String DFA3_eofS =
        "\6\uffff\1\23\2\uffff\1\30\3\uffff\1\34\10\uffff\1\30\6\uffff\1"+
        "\40\1\42\4\uffff";
    static final String DFA3_minS =
        "\1\12\2\u009f\1\uffff\1\u009f\1\u00a1\1\6\1\u009f\1\uffff\1\6\3"+
        "\uffff\1\6\2\uffff\1\u009f\4\uffff\1\u009f\1\6\6\uffff\2\6\4\uffff";
    static final String DFA3_maxS =
        "\1\u00a6\1\u00a5\1\u00a7\1\uffff\1\u00a4\1\u00a5\1\12\1\u00a7\1"+
        "\uffff\1\u00a6\3\uffff\1\u00a0\2\uffff\1\u009f\4\uffff\1\u00a5\1"+
        "\u00a6\6\uffff\1\u00a6\1\u00a0\4\uffff";
    static final String DFA3_acceptS =
        "\3\uffff\1\4\4\uffff\1\11\1\uffff\1\7\1\6\1\22\1\uffff\1\12\1\10"+
        "\1\uffff\1\16\1\24\1\25\1\23\2\uffff\1\15\1\1\1\13\1\3\1\5\1\2\2"+
        "\uffff\1\20\1\17\1\21\1\14";
    static final String DFA3_specialS =
        "\43\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\6\u0094\uffff\1\1\1\uffff\1\2\1\3\1\uffff\1\4\1\uffff\1"+
            "\5",
            "\1\7\1\11\2\uffff\1\12\1\uffff\1\10",
            "\1\15\1\uffff\1\13\5\uffff\1\14",
            "",
            "\1\17\4\uffff\1\16",
            "\1\20\3\uffff\1\21",
            "\1\23\3\uffff\1\22",
            "\1\25\1\26\2\uffff\1\12\1\27\1\10\1\uffff\1\24",
            "",
            "\1\30\u0099\uffff\1\33\1\uffff\1\32\3\uffff\1\31",
            "",
            "",
            "",
            "\1\34\u0098\uffff\1\34\1\35",
            "",
            "",
            "\1\36",
            "",
            "",
            "",
            "",
            "\1\25\1\26\2\uffff\1\12\1\27\1\10",
            "\1\30\u0099\uffff\1\33\5\uffff\1\31",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\40\u009f\uffff\1\37",
            "\1\42\u0098\uffff\1\42\1\41",
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
            return "296:1: rule__Sequence__Alternatives : ( ( ( rule__Sequence__Group_0__0 ) ) | ( ( rule__Sequence__Group_1__0 ) ) | ( ( rule__Sequence__Group_2__0 ) ) | ( ( rule__Sequence__Group_3__0 ) ) | ( ( rule__Sequence__Group_4__0 ) ) | ( ( rule__Sequence__Group_5__0 ) ) | ( ( rule__Sequence__Group_6__0 ) ) | ( ( rule__Sequence__Group_7__0 ) ) | ( ( rule__Sequence__Group_8__0 ) ) | ( ( rule__Sequence__Group_9__0 ) ) | ( ( rule__Sequence__Group_10__0 ) ) | ( ( rule__Sequence__Group_11__0 ) ) | ( ( rule__Sequence__Group_12__0 ) ) | ( ( rule__Sequence__Group_13__0 ) ) | ( ( rule__Sequence__Group_14__0 ) ) | ( ( rule__Sequence__Group_15__0 ) ) | ( ( rule__Sequence__Group_16__0 ) ) | ( ( rule__Sequence__Group_17__0 ) ) | ( ( rule__Sequence__Group_18__0 ) ) | ( ( rule__Sequence__Group_19__0 ) ) | ( '.' ) );";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DiagramsAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_ruleDiagram_in_entryRuleDiagram122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDiagram129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__0_in_ruleDiagram155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Alternatives_in_ruleInstruction215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequence_in_entryRuleSequence242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequence249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Alternatives_in_ruleSequence275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Alternatives_in_ruleDefinition335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAutoNumber369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__0_in_ruleAutoNumber395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_entryRuleColor422 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColor429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Color__Group__0_in_ruleColor455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__0_in_rule__Instruction__Alternatives491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ML_COMMENT_in_rule__Instruction__Alternatives509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SL_COMMENT_in_rule__Instruction__Alternatives526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_3__0_in_rule__Instruction__Alternatives543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_rule__Instruction__Alternatives561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__0_in_rule__Sequence__Alternatives593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__0_in_rule__Sequence__Alternatives611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__0_in_rule__Sequence__Alternatives629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__0_in_rule__Sequence__Alternatives647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__0_in_rule__Sequence__Alternatives665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__0_in_rule__Sequence__Alternatives683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__0_in_rule__Sequence__Alternatives701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__0_in_rule__Sequence__Alternatives719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__0_in_rule__Sequence__Alternatives737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__0_in_rule__Sequence__Alternatives755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__0_in_rule__Sequence__Alternatives773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__0_in_rule__Sequence__Alternatives791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__0_in_rule__Sequence__Alternatives809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__0_in_rule__Sequence__Alternatives827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__0_in_rule__Sequence__Alternatives845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__0_in_rule__Sequence__Alternatives863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__0_in_rule__Sequence__Alternatives881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__0_in_rule__Sequence__Alternatives899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__0_in_rule__Sequence__Alternatives917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__0_in_rule__Sequence__Alternatives935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__Sequence__Alternatives954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Color__Alternatives_11094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Color__Alternatives_11114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Color__Alternatives_11134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Color__Alternatives_11154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Color__Alternatives_11174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Color__Alternatives_11194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Color__Alternatives_11214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Color__Alternatives_11234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Color__Alternatives_11254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Color__Alternatives_11274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Color__Alternatives_11294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Color__Alternatives_11314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Color__Alternatives_11334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Color__Alternatives_11354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Color__Alternatives_11374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Color__Alternatives_11394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Color__Alternatives_11414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Color__Alternatives_11434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Color__Alternatives_11454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Color__Alternatives_11474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Color__Alternatives_11494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Color__Alternatives_11514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Color__Alternatives_11534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Color__Alternatives_11554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Color__Alternatives_11574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Color__Alternatives_11594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Color__Alternatives_11614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Color__Alternatives_11634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Color__Alternatives_11654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__Color__Alternatives_11674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Color__Alternatives_11694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__Color__Alternatives_11714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__Color__Alternatives_11734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__Color__Alternatives_11754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__Color__Alternatives_11774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__Color__Alternatives_11794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__Color__Alternatives_11814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__Color__Alternatives_11834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__Color__Alternatives_11854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__Color__Alternatives_11874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__Color__Alternatives_11894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__Color__Alternatives_11914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__Color__Alternatives_11934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__Color__Alternatives_11954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_rule__Color__Alternatives_11974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rule__Color__Alternatives_11994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_rule__Color__Alternatives_12014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_rule__Color__Alternatives_12034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_rule__Color__Alternatives_12054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_rule__Color__Alternatives_12074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_rule__Color__Alternatives_12094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_rule__Color__Alternatives_12114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_rule__Color__Alternatives_12134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_rule__Color__Alternatives_12154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_rule__Color__Alternatives_12174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_rule__Color__Alternatives_12194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_rule__Color__Alternatives_12214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_rule__Color__Alternatives_12234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_rule__Color__Alternatives_12254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_rule__Color__Alternatives_12274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_rule__Color__Alternatives_12294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_rule__Color__Alternatives_12314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_rule__Color__Alternatives_12334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_rule__Color__Alternatives_12354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_rule__Color__Alternatives_12374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_rule__Color__Alternatives_12394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_rule__Color__Alternatives_12414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_rule__Color__Alternatives_12434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_rule__Color__Alternatives_12454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_rule__Color__Alternatives_12474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_rule__Color__Alternatives_12494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_rule__Color__Alternatives_12514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_rule__Color__Alternatives_12534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_rule__Color__Alternatives_12554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_rule__Color__Alternatives_12574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_rule__Color__Alternatives_12594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_rule__Color__Alternatives_12614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_rule__Color__Alternatives_12634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_rule__Color__Alternatives_12654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_rule__Color__Alternatives_12674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_rule__Color__Alternatives_12694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_rule__Color__Alternatives_12714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_rule__Color__Alternatives_12734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_rule__Color__Alternatives_12754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_rule__Color__Alternatives_12774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_rule__Color__Alternatives_12794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_rule__Color__Alternatives_12814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_rule__Color__Alternatives_12834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_rule__Color__Alternatives_12854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_rule__Color__Alternatives_12874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_rule__Color__Alternatives_12894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_rule__Color__Alternatives_12914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_rule__Color__Alternatives_12934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_rule__Color__Alternatives_12954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_rule__Color__Alternatives_12974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_rule__Color__Alternatives_12994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_rule__Color__Alternatives_13014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_rule__Color__Alternatives_13034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_rule__Color__Alternatives_13054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_rule__Color__Alternatives_13074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_rule__Color__Alternatives_13094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_rule__Color__Alternatives_13114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_rule__Color__Alternatives_13134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_rule__Color__Alternatives_13154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_rule__Color__Alternatives_13174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_rule__Color__Alternatives_13194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_rule__Color__Alternatives_13214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_rule__Color__Alternatives_13234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_rule__Color__Alternatives_13254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_rule__Color__Alternatives_13274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_rule__Color__Alternatives_13294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_rule__Color__Alternatives_13314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_rule__Color__Alternatives_13334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_rule__Color__Alternatives_13354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_rule__Color__Alternatives_13374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_rule__Color__Alternatives_13394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_rule__Color__Alternatives_13414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_rule__Color__Alternatives_13434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_rule__Color__Alternatives_13454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_rule__Color__Alternatives_13474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_rule__Color__Alternatives_13494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_rule__Color__Alternatives_13514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_rule__Color__Alternatives_13534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_134_in_rule__Color__Alternatives_13554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_135_in_rule__Color__Alternatives_13574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_136_in_rule__Color__Alternatives_13594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_137_in_rule__Color__Alternatives_13614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_138_in_rule__Color__Alternatives_13634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_139_in_rule__Color__Alternatives_13654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_140_in_rule__Color__Alternatives_13674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_141_in_rule__Color__Alternatives_13694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_142_in_rule__Color__Alternatives_13714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_143_in_rule__Color__Alternatives_13734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_144_in_rule__Color__Alternatives_13754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_145_in_rule__Color__Alternatives_13774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_146_in_rule__Color__Alternatives_13794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_147_in_rule__Color__Alternatives_13814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_148_in_rule__Color__Alternatives_13834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_149_in_rule__Color__Alternatives_13854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_150_in_rule__Color__Alternatives_13874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_151_in_rule__Color__Alternatives_13894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_152_in_rule__Color__Alternatives_13914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_153_in_rule__Color__Alternatives_13934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_154_in_rule__Color__Alternatives_13954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_155_in_rule__Color__Alternatives_13974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__04006 = new BitSet(new long[]{0x0000000000000070L,0x0000000000000000L,0x00003F0020000000L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__04009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_156_in_rule__Diagram__Group__0__Impl4037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__14068 = new BitSet(new long[]{0x0000000000000070L,0x0000000000000000L,0x00003F0020000000L});
    public static final BitSet FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__14071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__InstructionsAssignment_1_in_rule__Diagram__Group__1__Impl4098 = new BitSet(new long[]{0x0000000000000072L,0x0000000000000000L,0x00003F0000000000L});
    public static final BitSet FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__24129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_157_in_rule__Diagram__Group__2__Impl4157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__0__Impl_in_rule__Instruction__Group_0__04194 = new BitSet(new long[]{0x0000000000000400L,0x0000000000000000L,0x0000005680000000L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__1_in_rule__Instruction__Group_0__04197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Name1Assignment_0_0_in_rule__Instruction__Group_0__0__Impl4224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__1__Impl_in_rule__Instruction__Group_0__14254 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__2_in_rule__Instruction__Group_0__14257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequence_in_rule__Instruction__Group_0__1__Impl4284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__2__Impl_in_rule__Instruction__Group_0__24313 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__3_in_rule__Instruction__Group_0__24316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Name2Assignment_0_2_in_rule__Instruction__Group_0__2__Impl4343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__3__Impl_in_rule__Instruction__Group_0__34373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_3__0_in_rule__Instruction__Group_0__3__Impl4400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_3__0__Impl_in_rule__Instruction__Group_0_3__04439 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_3__1_in_rule__Instruction__Group_0_3__04442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_rule__Instruction__Group_0_3__0__Impl4470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_3__1__Impl_in_rule__Instruction__Group_0_3__14501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Instruction__Group_0_3__1__Impl4528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_3__0__Impl_in_rule__Instruction__Group_3__04561 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_rule__Instruction__Group_3__1_in_rule__Instruction__Group_3__04564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_rule__Instruction__Group_3__0__Impl4591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_3__1__Impl_in_rule__Instruction__Group_3__14620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__Instruction__Group_3__1__Impl4648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__0__Impl_in_rule__Sequence__Group_0__04683 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__1_in_rule__Sequence__Group_0__04686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_0__0__Impl4715 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__1__Impl_in_rule__Sequence__Group_0__14748 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__2_in_rule__Sequence__Group_0__14751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_0__1__Impl4779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__2__Impl_in_rule__Sequence__Group_0__24810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_rule__Sequence__Group_0__2__Impl4838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__0__Impl_in_rule__Sequence__Group_1__04875 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__1_in_rule__Sequence__Group_1__04878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_rule__Sequence__Group_1__0__Impl4906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__1__Impl_in_rule__Sequence__Group_1__14937 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__2_in_rule__Sequence__Group_1__14940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_1__1__Impl4968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__2__Impl_in_rule__Sequence__Group_1__24999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_1__2__Impl5028 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__0__Impl_in_rule__Sequence__Group_2__05067 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__1_in_rule__Sequence__Group_2__05070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_2__0__Impl5098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__1__Impl_in_rule__Sequence__Group_2__15129 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__2_in_rule__Sequence__Group_2__15132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_rule__Sequence__Group_2__1__Impl5160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__2__Impl_in_rule__Sequence__Group_2__25191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_2__2__Impl5219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__0__Impl_in_rule__Sequence__Group_3__05256 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__1_in_rule__Sequence__Group_3__05259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_3__0__Impl5287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__1__Impl_in_rule__Sequence__Group_3__15318 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__2_in_rule__Sequence__Group_3__15321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_rule__Sequence__Group_3__1__Impl5349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__2__Impl_in_rule__Sequence__Group_3__25380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_3__2__Impl5408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__0__Impl_in_rule__Sequence__Group_4__05445 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__1_in_rule__Sequence__Group_4__05448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_4__0__Impl5477 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__1__Impl_in_rule__Sequence__Group_4__15510 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__2_in_rule__Sequence__Group_4__15513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_4__1__Impl5541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__2__Impl_in_rule__Sequence__Group_4__25572 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__3_in_rule__Sequence__Group_4__25575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_rule__Sequence__Group_4__2__Impl5603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__3__Impl_in_rule__Sequence__Group_4__35634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_rule__Sequence__Group_4__3__Impl5662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__0__Impl_in_rule__Sequence__Group_5__05701 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__1_in_rule__Sequence__Group_5__05704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_rule__Sequence__Group_5__0__Impl5732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__1__Impl_in_rule__Sequence__Group_5__15763 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__2_in_rule__Sequence__Group_5__15766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_rule__Sequence__Group_5__1__Impl5794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__2__Impl_in_rule__Sequence__Group_5__25825 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__3_in_rule__Sequence__Group_5__25828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_5__2__Impl5856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__3__Impl_in_rule__Sequence__Group_5__35887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_5__3__Impl5916 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__0__Impl_in_rule__Sequence__Group_6__05957 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__1_in_rule__Sequence__Group_6__05960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_6__0__Impl5989 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__1__Impl_in_rule__Sequence__Group_6__16022 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__2_in_rule__Sequence__Group_6__16025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_6__1__Impl6053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__2__Impl_in_rule__Sequence__Group_6__26084 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__3_in_rule__Sequence__Group_6__26087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_6__2__Impl6115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__3__Impl_in_rule__Sequence__Group_6__36146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_6__3__Impl6174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__0__Impl_in_rule__Sequence__Group_7__06213 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__1_in_rule__Sequence__Group_7__06216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_7__0__Impl6244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__1__Impl_in_rule__Sequence__Group_7__16275 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__2_in_rule__Sequence__Group_7__16278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_7__1__Impl6306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__2__Impl_in_rule__Sequence__Group_7__26337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_7__2__Impl6366 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__0__Impl_in_rule__Sequence__Group_8__06405 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__1_in_rule__Sequence__Group_8__06408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_8__0__Impl6437 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__1__Impl_in_rule__Sequence__Group_8__16470 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__2_in_rule__Sequence__Group_8__16473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_8__1__Impl6501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__2__Impl_in_rule__Sequence__Group_8__26532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_8__2__Impl6560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__0__Impl_in_rule__Sequence__Group_9__06597 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__1_in_rule__Sequence__Group_9__06600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_9__0__Impl6628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__1__Impl_in_rule__Sequence__Group_9__16659 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__2_in_rule__Sequence__Group_9__16662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_9__1__Impl6690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__2__Impl_in_rule__Sequence__Group_9__26721 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__3_in_rule__Sequence__Group_9__26724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_9__2__Impl6752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__3__Impl_in_rule__Sequence__Group_9__36783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_9__3__Impl6812 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__0__Impl_in_rule__Sequence__Group_10__06853 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__1_in_rule__Sequence__Group_10__06856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_10__0__Impl6885 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__1__Impl_in_rule__Sequence__Group_10__16918 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__2_in_rule__Sequence__Group_10__16921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_10__1__Impl6949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__2__Impl_in_rule__Sequence__Group_10__26980 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__3_in_rule__Sequence__Group_10__26983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_rule__Sequence__Group_10__2__Impl7011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__3__Impl_in_rule__Sequence__Group_10__37042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_166_in_rule__Sequence__Group_10__3__Impl7070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__0__Impl_in_rule__Sequence__Group_11__07109 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__1_in_rule__Sequence__Group_11__07112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_166_in_rule__Sequence__Group_11__0__Impl7140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__1__Impl_in_rule__Sequence__Group_11__17171 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__2_in_rule__Sequence__Group_11__17174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_rule__Sequence__Group_11__1__Impl7202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__2__Impl_in_rule__Sequence__Group_11__27233 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__3_in_rule__Sequence__Group_11__27236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_11__2__Impl7264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__3__Impl_in_rule__Sequence__Group_11__37295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_11__3__Impl7324 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__0__Impl_in_rule__Sequence__Group_12__07365 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__1_in_rule__Sequence__Group_12__07368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_12__0__Impl7397 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__1__Impl_in_rule__Sequence__Group_12__17430 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__2_in_rule__Sequence__Group_12__17433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_12__1__Impl7461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__2__Impl_in_rule__Sequence__Group_12__27492 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__3_in_rule__Sequence__Group_12__27495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_12__2__Impl7523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__3__Impl_in_rule__Sequence__Group_12__37554 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__4_in_rule__Sequence__Group_12__37557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_12__3__Impl7585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__4__Impl_in_rule__Sequence__Group_12__47616 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__5_in_rule__Sequence__Group_12__47619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_12__4__Impl7647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__5__Impl_in_rule__Sequence__Group_12__57678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_166_in_rule__Sequence__Group_12__5__Impl7706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__0__Impl_in_rule__Sequence__Group_13__07749 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__1_in_rule__Sequence__Group_13__07752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_166_in_rule__Sequence__Group_13__0__Impl7780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__1__Impl_in_rule__Sequence__Group_13__17811 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__2_in_rule__Sequence__Group_13__17814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_13__1__Impl7842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__2__Impl_in_rule__Sequence__Group_13__27873 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__3_in_rule__Sequence__Group_13__27876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_13__2__Impl7904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__3__Impl_in_rule__Sequence__Group_13__37935 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__4_in_rule__Sequence__Group_13__37938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_13__3__Impl7966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__4__Impl_in_rule__Sequence__Group_13__47997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_13__4__Impl8026 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__0__Impl_in_rule__Sequence__Group_14__08069 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__1_in_rule__Sequence__Group_14__08072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_rule__Sequence__Group_14__0__Impl8100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__1__Impl_in_rule__Sequence__Group_14__18131 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__2_in_rule__Sequence__Group_14__18134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_14__1__Impl8162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__2__Impl_in_rule__Sequence__Group_14__28193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_rule__Sequence__Group_14__2__Impl8221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__0__Impl_in_rule__Sequence__Group_15__08258 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__1_in_rule__Sequence__Group_15__08261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_rule__Sequence__Group_15__0__Impl8289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__1__Impl_in_rule__Sequence__Group_15__18320 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__2_in_rule__Sequence__Group_15__18323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_15__1__Impl8351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__2__Impl_in_rule__Sequence__Group_15__28382 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__3_in_rule__Sequence__Group_15__28385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_rule__Sequence__Group_15__2__Impl8413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__3__Impl_in_rule__Sequence__Group_15__38444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_166_in_rule__Sequence__Group_15__3__Impl8472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__0__Impl_in_rule__Sequence__Group_16__08511 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__1_in_rule__Sequence__Group_16__08514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_166_in_rule__Sequence__Group_16__0__Impl8542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__1__Impl_in_rule__Sequence__Group_16__18573 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__2_in_rule__Sequence__Group_16__18576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_rule__Sequence__Group_16__1__Impl8604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__2__Impl_in_rule__Sequence__Group_16__28635 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__3_in_rule__Sequence__Group_16__28638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_16__2__Impl8666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__3__Impl_in_rule__Sequence__Group_16__38697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_rule__Sequence__Group_16__3__Impl8725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__0__Impl_in_rule__Sequence__Group_17__08764 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__1_in_rule__Sequence__Group_17__08767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_rule__Sequence__Group_17__0__Impl8795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__1__Impl_in_rule__Sequence__Group_17__18826 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__2_in_rule__Sequence__Group_17__18829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_167_in_rule__Sequence__Group_17__1__Impl8857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__2__Impl_in_rule__Sequence__Group_17__28888 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__3_in_rule__Sequence__Group_17__28891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_17__2__Impl8919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__3__Impl_in_rule__Sequence__Group_17__38950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_17__3__Impl8978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__0__Impl_in_rule__Sequence__Group_18__09017 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__1_in_rule__Sequence__Group_18__09020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_18__0__Impl9048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__1__Impl_in_rule__Sequence__Group_18__19079 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__2_in_rule__Sequence__Group_18__19082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Sequence__Group_18__1__Impl9110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__2__Impl_in_rule__Sequence__Group_18__29141 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__3_in_rule__Sequence__Group_18__29144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_167_in_rule__Sequence__Group_18__2__Impl9172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__3__Impl_in_rule__Sequence__Group_18__39203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_rule__Sequence__Group_18__3__Impl9231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__0__Impl_in_rule__Sequence__Group_19__09270 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__1_in_rule__Sequence__Group_19__09273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__Sequence__Group_19__0__Impl9301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__1__Impl_in_rule__Sequence__Group_19__19332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__Sequence__Group_19__1__Impl9360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__09395 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__09398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_rule__Definition__Group_0__0__Impl9426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__19457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl9484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__09518 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__09521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_169_in_rule__Definition__Group_1__0__Impl9549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__19580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl9607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__09641 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__09644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_170_in_rule__Definition__Group_2__0__Impl9672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__19703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl9730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__09764 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__09767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_171_in_rule__Definition__Group_3__0__Impl9795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__19826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl9853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__09887 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__09890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_172_in_rule__Definition__Group_4__0__Impl9918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__19949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl9976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__0__Impl_in_rule__AutoNumber__Group__010010 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__1_in_rule__AutoNumber__Group__010013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_173_in_rule__AutoNumber__Group__0__Impl10041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__1__Impl_in_rule__AutoNumber__Group__110072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__0_in_rule__AutoNumber__Group__1__Impl10099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__0__Impl_in_rule__AutoNumber__Group_1__010134 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__1_in_rule__AutoNumber__Group_1__010137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__0__Impl10164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__1__Impl_in_rule__AutoNumber__Group_1__110193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__1__Impl10221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Color__Group__0__Impl_in_rule__Color__Group__010256 = new BitSet(new long[]{0xFFFFFFFFFFFFF800L,0xFFFFFFFFFFFFFFFFL,0x000000000FFFFFFFL});
    public static final BitSet FOLLOW_rule__Color__Group__1_in_rule__Color__Group__010259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_174_in_rule__Color__Group__0__Impl10290 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_174_in_rule__Color__Group__0__Impl10306 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_rule__Color__Group__1__Impl_in_rule__Color__Group__110341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Color__Alternatives_1_in_rule__Color__Group__1__Impl10368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_rule__Model__DiagramsAssignment10407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_110438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Instruction__Name1Assignment_0_010469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Instruction__Name2Assignment_0_210500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_0_110531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_1_110562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_2_110593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_3_110624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_4_110655 = new BitSet(new long[]{0x0000000000000002L});

}