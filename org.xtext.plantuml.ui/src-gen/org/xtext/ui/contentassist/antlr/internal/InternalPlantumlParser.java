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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ID", "RULE_INT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "'AliceBlue'", "'AntiqueWhite'", "'Aqua'", "'Aquamarine'", "'Azure'", "'Beige'", "'Bisque'", "'Black'", "'BlanchedAlmond'", "'Blue'", "'BlueViolet'", "'Brown'", "'BurlyWood'", "'CadetBlue'", "'Chartreuse'", "'Chocolate'", "'Coral'", "'CornflowerBlue'", "'Cornsilk'", "'Crimson'", "'Cyan'", "'DarkBlue'", "'DarkCyan'", "'DarkGoldenRod'", "'DarkGray'", "'DarkGreen'", "'DarkGrey'", "'DarkKhaki'", "'DarkMagenta'", "'DarkOliveGreen'", "'DarkOrchid'", "'DarkRed'", "'DarkSalmo'", "'DarkSeaGreen'", "'DarkSlateBlue'", "'DarkSlateGray'", "'DarkSlateGrey'", "'DarkTurquoise'", "'DarkViolet'", "'Darkorange'", "'DeepPink'", "'DeepSkyBlue'", "'DimGray'", "'DimGrey'", "'DodgerBlue'", "'FireBrick'", "'FloralWhite'", "'ForestGreen'", "'Fuchsia'", "'Gainsboro'", "'GhostWhite'", "'Gold'", "'GoldenRod'", "'Gray'", "'Green'", "'GreenYellow'", "'Grey'", "'HoneyDew'", "'HotPink'", "'IndianRed'", "'Indigo'", "'Ivory'", "'Khaki'", "'Lavender'", "'LavenderBlush'", "'LawnGreen'", "'LemonChiffon'", "'LightBlue'", "'LightCoral'", "'LightCyan'", "'LightGoldenRodYellow'", "'LightGray'", "'LightGreen'", "'LightGrey'", "'LightPink'", "'LightSalmon'", "'LightSeaGreen'", "'LightSkyBlue'", "'LightSlateGray'", "'LightSlateGrey'", "'LightSteelBlue'", "'LightYellow'", "'Lime'", "'LimeGreen'", "'Linen'", "'Magenta'", "'Maroon'", "'MediumAquaMarine'", "'MediumBlue'", "'MediumOrchid'", "'MediumPurple'", "'MediumSeaGreen'", "'MediumSlateBlue'", "'MediumSpringGreen'", "'MediumTurquoise'", "'MediumVioletRed'", "'MidnightBlue'", "'MintCream'", "'MistyRose'", "'Moccasin'", "'NavajoWhite'", "'Navy'", "'OldLace'", "'Olive'", "'OliveDrab'", "'OrangeRed'", "'Orchid'", "'PaleGoldenRod'", "'PaleGreen'", "'PaleTurquoise'", "'PaleVioletRed'", "'PapayaWhip'", "'PeachPuff'", "'Peru'", "'Pink'", "'Plum'", "'PowderBlue'", "'Purple'", "'Red'", "'RosyBrown'", "'RoyalBlue'", "'SaddleBrown'", "'Salmon'", "'SandyBrown'", "'SeaGreen'", "'Sienna'", "'Silver'", "'SkyBlue'", "'SlateBlue'", "'SlateGray'", "'SlateGrey'", "'Snow'", "'SpringGreen'", "'SteelBlue'", "'Tan'", "'Teal'", "'Thistle'", "'Tomato'", "'Turquoise'", "'Violet'", "'Wheat'", "'White'", "'WhiteSmoke'", "'Yellow'", "'YellowGreen'", "'right'", "'left'", "'center'", "'@startuml'", "'@enduml'", "':'", "'-'", "'>'", "'<'", "'x'", "'\\\\'", "'/'", "'\\\\\\\\'", "'o'", "'|'", "'actor'", "'boundary'", "'control'", "'entity'", "'database'", "'autonumber'", "'#'", "'title'", "'legend'", "'endlegend'", "'newpage'"
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
    public static final int T__180=180;
    public static final int T__181=181;
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
    public static final int T__177=177;
    public static final int T__176=176;
    public static final int T__179=179;
    public static final int T__178=178;
    public static final int T__173=173;
    public static final int T__172=172;
    public static final int T__175=175;
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

                if ( (LA1_0==159) ) {
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


    // $ANTLR start "entryRuleTitle"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:256:1: entryRuleTitle : ruleTitle EOF ;
    public final void entryRuleTitle() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:257:1: ( ruleTitle EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:258:1: ruleTitle EOF
            {
             before(grammarAccess.getTitleRule()); 
            pushFollow(FOLLOW_ruleTitle_in_entryRuleTitle482);
            ruleTitle();

            state._fsp--;

             after(grammarAccess.getTitleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTitle489); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:265:1: ruleTitle : ( ( rule__Title__Group__0 ) ) ;
    public final void ruleTitle() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:269:2: ( ( ( rule__Title__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:270:1: ( ( rule__Title__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:270:1: ( ( rule__Title__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:271:1: ( rule__Title__Group__0 )
            {
             before(grammarAccess.getTitleAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:272:1: ( rule__Title__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:272:2: rule__Title__Group__0
            {
            pushFollow(FOLLOW_rule__Title__Group__0_in_ruleTitle515);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:284:1: entryRuleLegend : ruleLegend EOF ;
    public final void entryRuleLegend() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:285:1: ( ruleLegend EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:286:1: ruleLegend EOF
            {
             before(grammarAccess.getLegendRule()); 
            pushFollow(FOLLOW_ruleLegend_in_entryRuleLegend542);
            ruleLegend();

            state._fsp--;

             after(grammarAccess.getLegendRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLegend549); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:293:1: ruleLegend : ( ( rule__Legend__Group__0 ) ) ;
    public final void ruleLegend() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:297:2: ( ( ( rule__Legend__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:298:1: ( ( rule__Legend__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:298:1: ( ( rule__Legend__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:299:1: ( rule__Legend__Group__0 )
            {
             before(grammarAccess.getLegendAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:300:1: ( rule__Legend__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:300:2: rule__Legend__Group__0
            {
            pushFollow(FOLLOW_rule__Legend__Group__0_in_ruleLegend575);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:312:1: entryRuleNewpage : ruleNewpage EOF ;
    public final void entryRuleNewpage() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:313:1: ( ruleNewpage EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:314:1: ruleNewpage EOF
            {
             before(grammarAccess.getNewpageRule()); 
            pushFollow(FOLLOW_ruleNewpage_in_entryRuleNewpage602);
            ruleNewpage();

            state._fsp--;

             after(grammarAccess.getNewpageRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNewpage609); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:321:1: ruleNewpage : ( ( rule__Newpage__Group__0 ) ) ;
    public final void ruleNewpage() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:325:2: ( ( ( rule__Newpage__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:326:1: ( ( rule__Newpage__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:326:1: ( ( rule__Newpage__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:327:1: ( rule__Newpage__Group__0 )
            {
             before(grammarAccess.getNewpageAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:328:1: ( rule__Newpage__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:328:2: rule__Newpage__Group__0
            {
            pushFollow(FOLLOW_rule__Newpage__Group__0_in_ruleNewpage635);
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


    // $ANTLR start "rule__Instruction__Alternatives"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:340:1: rule__Instruction__Alternatives : ( ( ( rule__Instruction__Group_0__0 ) ) | ( RULE_ML_COMMENT ) | ( RULE_SL_COMMENT ) | ( ( rule__Instruction__Group_3__0 ) ) | ( ruleAutoNumber ) | ( ruleTitle ) | ( ruleLegend ) | ( ruleNewpage ) );
    public final void rule__Instruction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:344:1: ( ( ( rule__Instruction__Group_0__0 ) ) | ( RULE_ML_COMMENT ) | ( RULE_SL_COMMENT ) | ( ( rule__Instruction__Group_3__0 ) ) | ( ruleAutoNumber ) | ( ruleTitle ) | ( ruleLegend ) | ( ruleNewpage ) )
            int alt2=8;
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
            case 171:
            case 172:
            case 173:
            case 174:
            case 175:
                {
                alt2=4;
                }
                break;
            case 176:
                {
                alt2=5;
                }
                break;
            case 178:
                {
                alt2=6;
                }
                break;
            case 179:
                {
                alt2=7;
                }
                break;
            case 181:
                {
                alt2=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:345:1: ( ( rule__Instruction__Group_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:345:1: ( ( rule__Instruction__Group_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:346:1: ( rule__Instruction__Group_0__0 )
                    {
                     before(grammarAccess.getInstructionAccess().getGroup_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:347:1: ( rule__Instruction__Group_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:347:2: rule__Instruction__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_0__0_in_rule__Instruction__Alternatives671);
                    rule__Instruction__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInstructionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:351:6: ( RULE_ML_COMMENT )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:351:6: ( RULE_ML_COMMENT )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:352:1: RULE_ML_COMMENT
                    {
                     before(grammarAccess.getInstructionAccess().getML_COMMENTTerminalRuleCall_1()); 
                    match(input,RULE_ML_COMMENT,FOLLOW_RULE_ML_COMMENT_in_rule__Instruction__Alternatives689); 
                     after(grammarAccess.getInstructionAccess().getML_COMMENTTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:357:6: ( RULE_SL_COMMENT )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:357:6: ( RULE_SL_COMMENT )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:358:1: RULE_SL_COMMENT
                    {
                     before(grammarAccess.getInstructionAccess().getSL_COMMENTTerminalRuleCall_2()); 
                    match(input,RULE_SL_COMMENT,FOLLOW_RULE_SL_COMMENT_in_rule__Instruction__Alternatives706); 
                     after(grammarAccess.getInstructionAccess().getSL_COMMENTTerminalRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:363:6: ( ( rule__Instruction__Group_3__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:363:6: ( ( rule__Instruction__Group_3__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:364:1: ( rule__Instruction__Group_3__0 )
                    {
                     before(grammarAccess.getInstructionAccess().getGroup_3()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:365:1: ( rule__Instruction__Group_3__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:365:2: rule__Instruction__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_3__0_in_rule__Instruction__Alternatives723);
                    rule__Instruction__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInstructionAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:369:6: ( ruleAutoNumber )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:369:6: ( ruleAutoNumber )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:370:1: ruleAutoNumber
                    {
                     before(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleAutoNumber_in_rule__Instruction__Alternatives741);
                    ruleAutoNumber();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:375:6: ( ruleTitle )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:375:6: ( ruleTitle )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:376:1: ruleTitle
                    {
                     before(grammarAccess.getInstructionAccess().getTitleParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleTitle_in_rule__Instruction__Alternatives758);
                    ruleTitle();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTitleParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:381:6: ( ruleLegend )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:381:6: ( ruleLegend )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:382:1: ruleLegend
                    {
                     before(grammarAccess.getInstructionAccess().getLegendParserRuleCall_6()); 
                    pushFollow(FOLLOW_ruleLegend_in_rule__Instruction__Alternatives775);
                    ruleLegend();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getLegendParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:387:6: ( ruleNewpage )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:387:6: ( ruleNewpage )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:388:1: ruleNewpage
                    {
                     before(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_7()); 
                    pushFollow(FOLLOW_ruleNewpage_in_rule__Instruction__Alternatives792);
                    ruleNewpage();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_7()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:398:1: rule__Sequence__Alternatives : ( ( ( rule__Sequence__Group_0__0 ) ) | ( ( rule__Sequence__Group_1__0 ) ) | ( ( rule__Sequence__Group_2__0 ) ) | ( ( rule__Sequence__Group_3__0 ) ) | ( ( rule__Sequence__Group_4__0 ) ) | ( ( rule__Sequence__Group_5__0 ) ) | ( ( rule__Sequence__Group_6__0 ) ) | ( ( rule__Sequence__Group_7__0 ) ) | ( ( rule__Sequence__Group_8__0 ) ) | ( ( rule__Sequence__Group_9__0 ) ) | ( ( rule__Sequence__Group_10__0 ) ) | ( ( rule__Sequence__Group_11__0 ) ) | ( ( rule__Sequence__Group_12__0 ) ) | ( ( rule__Sequence__Group_13__0 ) ) | ( ( rule__Sequence__Group_14__0 ) ) | ( ( rule__Sequence__Group_15__0 ) ) | ( ( rule__Sequence__Group_16__0 ) ) | ( ( rule__Sequence__Group_17__0 ) ) | ( ( rule__Sequence__Group_18__0 ) ) | ( ( rule__Sequence__Group_19__0 ) ) | ( '.' ) );
    public final void rule__Sequence__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:402:1: ( ( ( rule__Sequence__Group_0__0 ) ) | ( ( rule__Sequence__Group_1__0 ) ) | ( ( rule__Sequence__Group_2__0 ) ) | ( ( rule__Sequence__Group_3__0 ) ) | ( ( rule__Sequence__Group_4__0 ) ) | ( ( rule__Sequence__Group_5__0 ) ) | ( ( rule__Sequence__Group_6__0 ) ) | ( ( rule__Sequence__Group_7__0 ) ) | ( ( rule__Sequence__Group_8__0 ) ) | ( ( rule__Sequence__Group_9__0 ) ) | ( ( rule__Sequence__Group_10__0 ) ) | ( ( rule__Sequence__Group_11__0 ) ) | ( ( rule__Sequence__Group_12__0 ) ) | ( ( rule__Sequence__Group_13__0 ) ) | ( ( rule__Sequence__Group_14__0 ) ) | ( ( rule__Sequence__Group_15__0 ) ) | ( ( rule__Sequence__Group_16__0 ) ) | ( ( rule__Sequence__Group_17__0 ) ) | ( ( rule__Sequence__Group_18__0 ) ) | ( ( rule__Sequence__Group_19__0 ) ) | ( '.' ) )
            int alt3=21;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:403:1: ( ( rule__Sequence__Group_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:403:1: ( ( rule__Sequence__Group_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:404:1: ( rule__Sequence__Group_0__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:405:1: ( rule__Sequence__Group_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:405:2: rule__Sequence__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_0__0_in_rule__Sequence__Alternatives824);
                    rule__Sequence__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:409:6: ( ( rule__Sequence__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:409:6: ( ( rule__Sequence__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:410:1: ( rule__Sequence__Group_1__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:411:1: ( rule__Sequence__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:411:2: rule__Sequence__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_1__0_in_rule__Sequence__Alternatives842);
                    rule__Sequence__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:415:6: ( ( rule__Sequence__Group_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:415:6: ( ( rule__Sequence__Group_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:416:1: ( rule__Sequence__Group_2__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:417:1: ( rule__Sequence__Group_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:417:2: rule__Sequence__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_2__0_in_rule__Sequence__Alternatives860);
                    rule__Sequence__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:421:6: ( ( rule__Sequence__Group_3__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:421:6: ( ( rule__Sequence__Group_3__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:422:1: ( rule__Sequence__Group_3__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_3()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:423:1: ( rule__Sequence__Group_3__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:423:2: rule__Sequence__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_3__0_in_rule__Sequence__Alternatives878);
                    rule__Sequence__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:427:6: ( ( rule__Sequence__Group_4__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:427:6: ( ( rule__Sequence__Group_4__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:428:1: ( rule__Sequence__Group_4__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_4()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:429:1: ( rule__Sequence__Group_4__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:429:2: rule__Sequence__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_4__0_in_rule__Sequence__Alternatives896);
                    rule__Sequence__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:433:6: ( ( rule__Sequence__Group_5__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:433:6: ( ( rule__Sequence__Group_5__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:434:1: ( rule__Sequence__Group_5__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_5()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:435:1: ( rule__Sequence__Group_5__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:435:2: rule__Sequence__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_5__0_in_rule__Sequence__Alternatives914);
                    rule__Sequence__Group_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:439:6: ( ( rule__Sequence__Group_6__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:439:6: ( ( rule__Sequence__Group_6__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:440:1: ( rule__Sequence__Group_6__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_6()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:441:1: ( rule__Sequence__Group_6__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:441:2: rule__Sequence__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_6__0_in_rule__Sequence__Alternatives932);
                    rule__Sequence__Group_6__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:445:6: ( ( rule__Sequence__Group_7__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:445:6: ( ( rule__Sequence__Group_7__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:446:1: ( rule__Sequence__Group_7__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_7()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:447:1: ( rule__Sequence__Group_7__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:447:2: rule__Sequence__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_7__0_in_rule__Sequence__Alternatives950);
                    rule__Sequence__Group_7__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:451:6: ( ( rule__Sequence__Group_8__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:451:6: ( ( rule__Sequence__Group_8__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:452:1: ( rule__Sequence__Group_8__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_8()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:453:1: ( rule__Sequence__Group_8__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:453:2: rule__Sequence__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_8__0_in_rule__Sequence__Alternatives968);
                    rule__Sequence__Group_8__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:457:6: ( ( rule__Sequence__Group_9__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:457:6: ( ( rule__Sequence__Group_9__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:458:1: ( rule__Sequence__Group_9__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_9()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:459:1: ( rule__Sequence__Group_9__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:459:2: rule__Sequence__Group_9__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_9__0_in_rule__Sequence__Alternatives986);
                    rule__Sequence__Group_9__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:463:6: ( ( rule__Sequence__Group_10__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:463:6: ( ( rule__Sequence__Group_10__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:464:1: ( rule__Sequence__Group_10__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_10()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:465:1: ( rule__Sequence__Group_10__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:465:2: rule__Sequence__Group_10__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_10__0_in_rule__Sequence__Alternatives1004);
                    rule__Sequence__Group_10__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:469:6: ( ( rule__Sequence__Group_11__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:469:6: ( ( rule__Sequence__Group_11__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:470:1: ( rule__Sequence__Group_11__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_11()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:471:1: ( rule__Sequence__Group_11__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:471:2: rule__Sequence__Group_11__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_11__0_in_rule__Sequence__Alternatives1022);
                    rule__Sequence__Group_11__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:475:6: ( ( rule__Sequence__Group_12__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:475:6: ( ( rule__Sequence__Group_12__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:476:1: ( rule__Sequence__Group_12__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_12()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:477:1: ( rule__Sequence__Group_12__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:477:2: rule__Sequence__Group_12__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_12__0_in_rule__Sequence__Alternatives1040);
                    rule__Sequence__Group_12__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:481:6: ( ( rule__Sequence__Group_13__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:481:6: ( ( rule__Sequence__Group_13__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:482:1: ( rule__Sequence__Group_13__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_13()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:483:1: ( rule__Sequence__Group_13__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:483:2: rule__Sequence__Group_13__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_13__0_in_rule__Sequence__Alternatives1058);
                    rule__Sequence__Group_13__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:487:6: ( ( rule__Sequence__Group_14__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:487:6: ( ( rule__Sequence__Group_14__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:488:1: ( rule__Sequence__Group_14__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_14()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:489:1: ( rule__Sequence__Group_14__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:489:2: rule__Sequence__Group_14__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_14__0_in_rule__Sequence__Alternatives1076);
                    rule__Sequence__Group_14__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:493:6: ( ( rule__Sequence__Group_15__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:493:6: ( ( rule__Sequence__Group_15__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:494:1: ( rule__Sequence__Group_15__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_15()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:495:1: ( rule__Sequence__Group_15__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:495:2: rule__Sequence__Group_15__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_15__0_in_rule__Sequence__Alternatives1094);
                    rule__Sequence__Group_15__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:499:6: ( ( rule__Sequence__Group_16__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:499:6: ( ( rule__Sequence__Group_16__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:500:1: ( rule__Sequence__Group_16__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_16()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:501:1: ( rule__Sequence__Group_16__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:501:2: rule__Sequence__Group_16__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_16__0_in_rule__Sequence__Alternatives1112);
                    rule__Sequence__Group_16__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:505:6: ( ( rule__Sequence__Group_17__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:505:6: ( ( rule__Sequence__Group_17__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:506:1: ( rule__Sequence__Group_17__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_17()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:507:1: ( rule__Sequence__Group_17__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:507:2: rule__Sequence__Group_17__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_17__0_in_rule__Sequence__Alternatives1130);
                    rule__Sequence__Group_17__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:511:6: ( ( rule__Sequence__Group_18__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:511:6: ( ( rule__Sequence__Group_18__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:512:1: ( rule__Sequence__Group_18__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_18()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:513:1: ( rule__Sequence__Group_18__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:513:2: rule__Sequence__Group_18__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_18__0_in_rule__Sequence__Alternatives1148);
                    rule__Sequence__Group_18__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:517:6: ( ( rule__Sequence__Group_19__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:517:6: ( ( rule__Sequence__Group_19__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:518:1: ( rule__Sequence__Group_19__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_19()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:519:1: ( rule__Sequence__Group_19__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:519:2: rule__Sequence__Group_19__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_19__0_in_rule__Sequence__Alternatives1166);
                    rule__Sequence__Group_19__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:523:6: ( '.' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:523:6: ( '.' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:524:1: '.'
                    {
                     before(grammarAccess.getSequenceAccess().getFullStopKeyword_20()); 
                    match(input,10,FOLLOW_10_in_rule__Sequence__Alternatives1185); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:536:1: rule__Definition__Alternatives : ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) );
    public final void rule__Definition__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:540:1: ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 171:
                {
                alt4=1;
                }
                break;
            case 172:
                {
                alt4=2;
                }
                break;
            case 173:
                {
                alt4=3;
                }
                break;
            case 174:
                {
                alt4=4;
                }
                break;
            case 175:
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:541:1: ( ( rule__Definition__Group_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:541:1: ( ( rule__Definition__Group_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:542:1: ( rule__Definition__Group_0__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:543:1: ( rule__Definition__Group_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:543:2: rule__Definition__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives1219);
                    rule__Definition__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:547:6: ( ( rule__Definition__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:547:6: ( ( rule__Definition__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:548:1: ( rule__Definition__Group_1__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:549:1: ( rule__Definition__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:549:2: rule__Definition__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives1237);
                    rule__Definition__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:553:6: ( ( rule__Definition__Group_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:553:6: ( ( rule__Definition__Group_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:554:1: ( rule__Definition__Group_2__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:555:1: ( rule__Definition__Group_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:555:2: rule__Definition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives1255);
                    rule__Definition__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:559:6: ( ( rule__Definition__Group_3__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:559:6: ( ( rule__Definition__Group_3__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:560:1: ( rule__Definition__Group_3__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_3()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:561:1: ( rule__Definition__Group_3__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:561:2: rule__Definition__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives1273);
                    rule__Definition__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:565:6: ( ( rule__Definition__Group_4__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:565:6: ( ( rule__Definition__Group_4__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:566:1: ( rule__Definition__Group_4__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_4()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:567:1: ( rule__Definition__Group_4__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:567:2: rule__Definition__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives1291);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:576:1: rule__Color__Alternatives_1 : ( ( 'AliceBlue' ) | ( 'AntiqueWhite' ) | ( 'Aqua' ) | ( 'Aquamarine' ) | ( 'Azure' ) | ( 'Beige' ) | ( 'Bisque' ) | ( 'Black' ) | ( 'BlanchedAlmond' ) | ( 'Blue' ) | ( 'BlueViolet' ) | ( 'Brown' ) | ( 'BurlyWood' ) | ( 'CadetBlue' ) | ( 'Chartreuse' ) | ( 'Chocolate' ) | ( 'Coral' ) | ( 'CornflowerBlue' ) | ( 'Cornsilk' ) | ( 'Crimson' ) | ( 'Cyan' ) | ( 'DarkBlue' ) | ( 'DarkCyan' ) | ( 'DarkGoldenRod' ) | ( 'DarkGray' ) | ( 'DarkGreen' ) | ( 'DarkGrey' ) | ( 'DarkKhaki' ) | ( 'DarkMagenta' ) | ( 'DarkOliveGreen' ) | ( 'DarkOrchid' ) | ( 'DarkRed' ) | ( 'DarkSalmo' ) | ( 'DarkSeaGreen' ) | ( 'DarkSlateBlue' ) | ( 'DarkSlateGray' ) | ( 'DarkSlateGrey' ) | ( 'DarkTurquoise' ) | ( 'DarkViolet' ) | ( 'Darkorange' ) | ( 'DeepPink' ) | ( 'DeepSkyBlue' ) | ( 'DimGray' ) | ( 'DimGrey' ) | ( 'DodgerBlue' ) | ( 'FireBrick' ) | ( 'FloralWhite' ) | ( 'ForestGreen' ) | ( 'Fuchsia' ) | ( 'Gainsboro' ) | ( 'GhostWhite' ) | ( 'Gold' ) | ( 'GoldenRod' ) | ( 'Gray' ) | ( 'Green' ) | ( 'GreenYellow' ) | ( 'Grey' ) | ( 'HoneyDew' ) | ( 'HotPink' ) | ( 'IndianRed' ) | ( 'Indigo' ) | ( 'Ivory' ) | ( 'Khaki' ) | ( 'Lavender' ) | ( 'LavenderBlush' ) | ( 'LawnGreen' ) | ( 'LemonChiffon' ) | ( 'LightBlue' ) | ( 'LightCoral' ) | ( 'LightCyan' ) | ( 'LightGoldenRodYellow' ) | ( 'LightGray' ) | ( 'LightGreen' ) | ( 'LightGrey' ) | ( 'LightPink' ) | ( 'LightSalmon' ) | ( 'LightSeaGreen' ) | ( 'LightSkyBlue' ) | ( 'LightSlateGray' ) | ( 'LightSlateGrey' ) | ( 'LightSteelBlue' ) | ( 'LightYellow' ) | ( 'Lime' ) | ( 'LimeGreen' ) | ( 'Linen' ) | ( 'Magenta' ) | ( 'Maroon' ) | ( 'MediumAquaMarine' ) | ( 'MediumBlue' ) | ( 'MediumOrchid' ) | ( 'MediumPurple' ) | ( 'MediumSeaGreen' ) | ( 'MediumSlateBlue' ) | ( 'MediumSpringGreen' ) | ( 'MediumTurquoise' ) | ( 'MediumVioletRed' ) | ( 'MidnightBlue' ) | ( 'MintCream' ) | ( 'MistyRose' ) | ( 'Moccasin' ) | ( 'NavajoWhite' ) | ( 'Navy' ) | ( 'OldLace' ) | ( 'Olive' ) | ( 'OliveDrab' ) | ( 'OrangeRed' ) | ( 'Orchid' ) | ( 'PaleGoldenRod' ) | ( 'PaleGreen' ) | ( 'PaleTurquoise' ) | ( 'PaleVioletRed' ) | ( 'PapayaWhip' ) | ( 'PeachPuff' ) | ( 'Peru' ) | ( 'Pink' ) | ( 'Plum' ) | ( 'PowderBlue' ) | ( 'Purple' ) | ( 'Red' ) | ( 'RosyBrown' ) | ( 'RoyalBlue' ) | ( 'SaddleBrown' ) | ( 'Salmon' ) | ( 'SandyBrown' ) | ( 'SeaGreen' ) | ( 'Sienna' ) | ( 'Silver' ) | ( 'SkyBlue' ) | ( 'SlateBlue' ) | ( 'SlateGray' ) | ( 'SlateGrey' ) | ( 'Snow' ) | ( 'SpringGreen' ) | ( 'SteelBlue' ) | ( 'Tan' ) | ( 'Teal' ) | ( 'Thistle' ) | ( 'Tomato' ) | ( 'Turquoise' ) | ( 'Violet' ) | ( 'Wheat' ) | ( 'White' ) | ( 'WhiteSmoke' ) | ( 'Yellow' ) | ( 'YellowGreen' ) );
    public final void rule__Color__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:580:1: ( ( 'AliceBlue' ) | ( 'AntiqueWhite' ) | ( 'Aqua' ) | ( 'Aquamarine' ) | ( 'Azure' ) | ( 'Beige' ) | ( 'Bisque' ) | ( 'Black' ) | ( 'BlanchedAlmond' ) | ( 'Blue' ) | ( 'BlueViolet' ) | ( 'Brown' ) | ( 'BurlyWood' ) | ( 'CadetBlue' ) | ( 'Chartreuse' ) | ( 'Chocolate' ) | ( 'Coral' ) | ( 'CornflowerBlue' ) | ( 'Cornsilk' ) | ( 'Crimson' ) | ( 'Cyan' ) | ( 'DarkBlue' ) | ( 'DarkCyan' ) | ( 'DarkGoldenRod' ) | ( 'DarkGray' ) | ( 'DarkGreen' ) | ( 'DarkGrey' ) | ( 'DarkKhaki' ) | ( 'DarkMagenta' ) | ( 'DarkOliveGreen' ) | ( 'DarkOrchid' ) | ( 'DarkRed' ) | ( 'DarkSalmo' ) | ( 'DarkSeaGreen' ) | ( 'DarkSlateBlue' ) | ( 'DarkSlateGray' ) | ( 'DarkSlateGrey' ) | ( 'DarkTurquoise' ) | ( 'DarkViolet' ) | ( 'Darkorange' ) | ( 'DeepPink' ) | ( 'DeepSkyBlue' ) | ( 'DimGray' ) | ( 'DimGrey' ) | ( 'DodgerBlue' ) | ( 'FireBrick' ) | ( 'FloralWhite' ) | ( 'ForestGreen' ) | ( 'Fuchsia' ) | ( 'Gainsboro' ) | ( 'GhostWhite' ) | ( 'Gold' ) | ( 'GoldenRod' ) | ( 'Gray' ) | ( 'Green' ) | ( 'GreenYellow' ) | ( 'Grey' ) | ( 'HoneyDew' ) | ( 'HotPink' ) | ( 'IndianRed' ) | ( 'Indigo' ) | ( 'Ivory' ) | ( 'Khaki' ) | ( 'Lavender' ) | ( 'LavenderBlush' ) | ( 'LawnGreen' ) | ( 'LemonChiffon' ) | ( 'LightBlue' ) | ( 'LightCoral' ) | ( 'LightCyan' ) | ( 'LightGoldenRodYellow' ) | ( 'LightGray' ) | ( 'LightGreen' ) | ( 'LightGrey' ) | ( 'LightPink' ) | ( 'LightSalmon' ) | ( 'LightSeaGreen' ) | ( 'LightSkyBlue' ) | ( 'LightSlateGray' ) | ( 'LightSlateGrey' ) | ( 'LightSteelBlue' ) | ( 'LightYellow' ) | ( 'Lime' ) | ( 'LimeGreen' ) | ( 'Linen' ) | ( 'Magenta' ) | ( 'Maroon' ) | ( 'MediumAquaMarine' ) | ( 'MediumBlue' ) | ( 'MediumOrchid' ) | ( 'MediumPurple' ) | ( 'MediumSeaGreen' ) | ( 'MediumSlateBlue' ) | ( 'MediumSpringGreen' ) | ( 'MediumTurquoise' ) | ( 'MediumVioletRed' ) | ( 'MidnightBlue' ) | ( 'MintCream' ) | ( 'MistyRose' ) | ( 'Moccasin' ) | ( 'NavajoWhite' ) | ( 'Navy' ) | ( 'OldLace' ) | ( 'Olive' ) | ( 'OliveDrab' ) | ( 'OrangeRed' ) | ( 'Orchid' ) | ( 'PaleGoldenRod' ) | ( 'PaleGreen' ) | ( 'PaleTurquoise' ) | ( 'PaleVioletRed' ) | ( 'PapayaWhip' ) | ( 'PeachPuff' ) | ( 'Peru' ) | ( 'Pink' ) | ( 'Plum' ) | ( 'PowderBlue' ) | ( 'Purple' ) | ( 'Red' ) | ( 'RosyBrown' ) | ( 'RoyalBlue' ) | ( 'SaddleBrown' ) | ( 'Salmon' ) | ( 'SandyBrown' ) | ( 'SeaGreen' ) | ( 'Sienna' ) | ( 'Silver' ) | ( 'SkyBlue' ) | ( 'SlateBlue' ) | ( 'SlateGray' ) | ( 'SlateGrey' ) | ( 'Snow' ) | ( 'SpringGreen' ) | ( 'SteelBlue' ) | ( 'Tan' ) | ( 'Teal' ) | ( 'Thistle' ) | ( 'Tomato' ) | ( 'Turquoise' ) | ( 'Violet' ) | ( 'Wheat' ) | ( 'White' ) | ( 'WhiteSmoke' ) | ( 'Yellow' ) | ( 'YellowGreen' ) )
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:581:1: ( 'AliceBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:581:1: ( 'AliceBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:582:1: 'AliceBlue'
                    {
                     before(grammarAccess.getColorAccess().getAliceBlueKeyword_1_0()); 
                    match(input,11,FOLLOW_11_in_rule__Color__Alternatives_11325); 
                     after(grammarAccess.getColorAccess().getAliceBlueKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:589:6: ( 'AntiqueWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:589:6: ( 'AntiqueWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:590:1: 'AntiqueWhite'
                    {
                     before(grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1_1()); 
                    match(input,12,FOLLOW_12_in_rule__Color__Alternatives_11345); 
                     after(grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:597:6: ( 'Aqua' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:597:6: ( 'Aqua' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:598:1: 'Aqua'
                    {
                     before(grammarAccess.getColorAccess().getAquaKeyword_1_2()); 
                    match(input,13,FOLLOW_13_in_rule__Color__Alternatives_11365); 
                     after(grammarAccess.getColorAccess().getAquaKeyword_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:605:6: ( 'Aquamarine' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:605:6: ( 'Aquamarine' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:606:1: 'Aquamarine'
                    {
                     before(grammarAccess.getColorAccess().getAquamarineKeyword_1_3()); 
                    match(input,14,FOLLOW_14_in_rule__Color__Alternatives_11385); 
                     after(grammarAccess.getColorAccess().getAquamarineKeyword_1_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:613:6: ( 'Azure' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:613:6: ( 'Azure' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:614:1: 'Azure'
                    {
                     before(grammarAccess.getColorAccess().getAzureKeyword_1_4()); 
                    match(input,15,FOLLOW_15_in_rule__Color__Alternatives_11405); 
                     after(grammarAccess.getColorAccess().getAzureKeyword_1_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:621:6: ( 'Beige' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:621:6: ( 'Beige' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:622:1: 'Beige'
                    {
                     before(grammarAccess.getColorAccess().getBeigeKeyword_1_5()); 
                    match(input,16,FOLLOW_16_in_rule__Color__Alternatives_11425); 
                     after(grammarAccess.getColorAccess().getBeigeKeyword_1_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:629:6: ( 'Bisque' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:629:6: ( 'Bisque' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:630:1: 'Bisque'
                    {
                     before(grammarAccess.getColorAccess().getBisqueKeyword_1_6()); 
                    match(input,17,FOLLOW_17_in_rule__Color__Alternatives_11445); 
                     after(grammarAccess.getColorAccess().getBisqueKeyword_1_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:637:6: ( 'Black' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:637:6: ( 'Black' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:638:1: 'Black'
                    {
                     before(grammarAccess.getColorAccess().getBlackKeyword_1_7()); 
                    match(input,18,FOLLOW_18_in_rule__Color__Alternatives_11465); 
                     after(grammarAccess.getColorAccess().getBlackKeyword_1_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:645:6: ( 'BlanchedAlmond' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:645:6: ( 'BlanchedAlmond' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:646:1: 'BlanchedAlmond'
                    {
                     before(grammarAccess.getColorAccess().getBlanchedAlmondKeyword_1_8()); 
                    match(input,19,FOLLOW_19_in_rule__Color__Alternatives_11485); 
                     after(grammarAccess.getColorAccess().getBlanchedAlmondKeyword_1_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:653:6: ( 'Blue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:653:6: ( 'Blue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:654:1: 'Blue'
                    {
                     before(grammarAccess.getColorAccess().getBlueKeyword_1_9()); 
                    match(input,20,FOLLOW_20_in_rule__Color__Alternatives_11505); 
                     after(grammarAccess.getColorAccess().getBlueKeyword_1_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:661:6: ( 'BlueViolet' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:661:6: ( 'BlueViolet' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:662:1: 'BlueViolet'
                    {
                     before(grammarAccess.getColorAccess().getBlueVioletKeyword_1_10()); 
                    match(input,21,FOLLOW_21_in_rule__Color__Alternatives_11525); 
                     after(grammarAccess.getColorAccess().getBlueVioletKeyword_1_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:669:6: ( 'Brown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:669:6: ( 'Brown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:670:1: 'Brown'
                    {
                     before(grammarAccess.getColorAccess().getBrownKeyword_1_11()); 
                    match(input,22,FOLLOW_22_in_rule__Color__Alternatives_11545); 
                     after(grammarAccess.getColorAccess().getBrownKeyword_1_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:677:6: ( 'BurlyWood' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:677:6: ( 'BurlyWood' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:678:1: 'BurlyWood'
                    {
                     before(grammarAccess.getColorAccess().getBurlyWoodKeyword_1_12()); 
                    match(input,23,FOLLOW_23_in_rule__Color__Alternatives_11565); 
                     after(grammarAccess.getColorAccess().getBurlyWoodKeyword_1_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:685:6: ( 'CadetBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:685:6: ( 'CadetBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:686:1: 'CadetBlue'
                    {
                     before(grammarAccess.getColorAccess().getCadetBlueKeyword_1_13()); 
                    match(input,24,FOLLOW_24_in_rule__Color__Alternatives_11585); 
                     after(grammarAccess.getColorAccess().getCadetBlueKeyword_1_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:693:6: ( 'Chartreuse' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:693:6: ( 'Chartreuse' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:694:1: 'Chartreuse'
                    {
                     before(grammarAccess.getColorAccess().getChartreuseKeyword_1_14()); 
                    match(input,25,FOLLOW_25_in_rule__Color__Alternatives_11605); 
                     after(grammarAccess.getColorAccess().getChartreuseKeyword_1_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:701:6: ( 'Chocolate' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:701:6: ( 'Chocolate' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:702:1: 'Chocolate'
                    {
                     before(grammarAccess.getColorAccess().getChocolateKeyword_1_15()); 
                    match(input,26,FOLLOW_26_in_rule__Color__Alternatives_11625); 
                     after(grammarAccess.getColorAccess().getChocolateKeyword_1_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:709:6: ( 'Coral' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:709:6: ( 'Coral' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:710:1: 'Coral'
                    {
                     before(grammarAccess.getColorAccess().getCoralKeyword_1_16()); 
                    match(input,27,FOLLOW_27_in_rule__Color__Alternatives_11645); 
                     after(grammarAccess.getColorAccess().getCoralKeyword_1_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:717:6: ( 'CornflowerBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:717:6: ( 'CornflowerBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:718:1: 'CornflowerBlue'
                    {
                     before(grammarAccess.getColorAccess().getCornflowerBlueKeyword_1_17()); 
                    match(input,28,FOLLOW_28_in_rule__Color__Alternatives_11665); 
                     after(grammarAccess.getColorAccess().getCornflowerBlueKeyword_1_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:725:6: ( 'Cornsilk' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:725:6: ( 'Cornsilk' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:726:1: 'Cornsilk'
                    {
                     before(grammarAccess.getColorAccess().getCornsilkKeyword_1_18()); 
                    match(input,29,FOLLOW_29_in_rule__Color__Alternatives_11685); 
                     after(grammarAccess.getColorAccess().getCornsilkKeyword_1_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:733:6: ( 'Crimson' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:733:6: ( 'Crimson' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:734:1: 'Crimson'
                    {
                     before(grammarAccess.getColorAccess().getCrimsonKeyword_1_19()); 
                    match(input,30,FOLLOW_30_in_rule__Color__Alternatives_11705); 
                     after(grammarAccess.getColorAccess().getCrimsonKeyword_1_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:741:6: ( 'Cyan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:741:6: ( 'Cyan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:742:1: 'Cyan'
                    {
                     before(grammarAccess.getColorAccess().getCyanKeyword_1_20()); 
                    match(input,31,FOLLOW_31_in_rule__Color__Alternatives_11725); 
                     after(grammarAccess.getColorAccess().getCyanKeyword_1_20()); 

                    }


                    }
                    break;
                case 22 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:749:6: ( 'DarkBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:749:6: ( 'DarkBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:750:1: 'DarkBlue'
                    {
                     before(grammarAccess.getColorAccess().getDarkBlueKeyword_1_21()); 
                    match(input,32,FOLLOW_32_in_rule__Color__Alternatives_11745); 
                     after(grammarAccess.getColorAccess().getDarkBlueKeyword_1_21()); 

                    }


                    }
                    break;
                case 23 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:757:6: ( 'DarkCyan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:757:6: ( 'DarkCyan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:758:1: 'DarkCyan'
                    {
                     before(grammarAccess.getColorAccess().getDarkCyanKeyword_1_22()); 
                    match(input,33,FOLLOW_33_in_rule__Color__Alternatives_11765); 
                     after(grammarAccess.getColorAccess().getDarkCyanKeyword_1_22()); 

                    }


                    }
                    break;
                case 24 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:765:6: ( 'DarkGoldenRod' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:765:6: ( 'DarkGoldenRod' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:766:1: 'DarkGoldenRod'
                    {
                     before(grammarAccess.getColorAccess().getDarkGoldenRodKeyword_1_23()); 
                    match(input,34,FOLLOW_34_in_rule__Color__Alternatives_11785); 
                     after(grammarAccess.getColorAccess().getDarkGoldenRodKeyword_1_23()); 

                    }


                    }
                    break;
                case 25 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:773:6: ( 'DarkGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:773:6: ( 'DarkGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:774:1: 'DarkGray'
                    {
                     before(grammarAccess.getColorAccess().getDarkGrayKeyword_1_24()); 
                    match(input,35,FOLLOW_35_in_rule__Color__Alternatives_11805); 
                     after(grammarAccess.getColorAccess().getDarkGrayKeyword_1_24()); 

                    }


                    }
                    break;
                case 26 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:781:6: ( 'DarkGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:781:6: ( 'DarkGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:782:1: 'DarkGreen'
                    {
                     before(grammarAccess.getColorAccess().getDarkGreenKeyword_1_25()); 
                    match(input,36,FOLLOW_36_in_rule__Color__Alternatives_11825); 
                     after(grammarAccess.getColorAccess().getDarkGreenKeyword_1_25()); 

                    }


                    }
                    break;
                case 27 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:789:6: ( 'DarkGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:789:6: ( 'DarkGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:790:1: 'DarkGrey'
                    {
                     before(grammarAccess.getColorAccess().getDarkGreyKeyword_1_26()); 
                    match(input,37,FOLLOW_37_in_rule__Color__Alternatives_11845); 
                     after(grammarAccess.getColorAccess().getDarkGreyKeyword_1_26()); 

                    }


                    }
                    break;
                case 28 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:797:6: ( 'DarkKhaki' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:797:6: ( 'DarkKhaki' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:798:1: 'DarkKhaki'
                    {
                     before(grammarAccess.getColorAccess().getDarkKhakiKeyword_1_27()); 
                    match(input,38,FOLLOW_38_in_rule__Color__Alternatives_11865); 
                     after(grammarAccess.getColorAccess().getDarkKhakiKeyword_1_27()); 

                    }


                    }
                    break;
                case 29 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:805:6: ( 'DarkMagenta' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:805:6: ( 'DarkMagenta' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:806:1: 'DarkMagenta'
                    {
                     before(grammarAccess.getColorAccess().getDarkMagentaKeyword_1_28()); 
                    match(input,39,FOLLOW_39_in_rule__Color__Alternatives_11885); 
                     after(grammarAccess.getColorAccess().getDarkMagentaKeyword_1_28()); 

                    }


                    }
                    break;
                case 30 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:813:6: ( 'DarkOliveGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:813:6: ( 'DarkOliveGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:814:1: 'DarkOliveGreen'
                    {
                     before(grammarAccess.getColorAccess().getDarkOliveGreenKeyword_1_29()); 
                    match(input,40,FOLLOW_40_in_rule__Color__Alternatives_11905); 
                     after(grammarAccess.getColorAccess().getDarkOliveGreenKeyword_1_29()); 

                    }


                    }
                    break;
                case 31 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:821:6: ( 'DarkOrchid' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:821:6: ( 'DarkOrchid' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:822:1: 'DarkOrchid'
                    {
                     before(grammarAccess.getColorAccess().getDarkOrchidKeyword_1_30()); 
                    match(input,41,FOLLOW_41_in_rule__Color__Alternatives_11925); 
                     after(grammarAccess.getColorAccess().getDarkOrchidKeyword_1_30()); 

                    }


                    }
                    break;
                case 32 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:829:6: ( 'DarkRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:829:6: ( 'DarkRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:830:1: 'DarkRed'
                    {
                     before(grammarAccess.getColorAccess().getDarkRedKeyword_1_31()); 
                    match(input,42,FOLLOW_42_in_rule__Color__Alternatives_11945); 
                     after(grammarAccess.getColorAccess().getDarkRedKeyword_1_31()); 

                    }


                    }
                    break;
                case 33 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:837:6: ( 'DarkSalmo' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:837:6: ( 'DarkSalmo' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:838:1: 'DarkSalmo'
                    {
                     before(grammarAccess.getColorAccess().getDarkSalmoKeyword_1_32()); 
                    match(input,43,FOLLOW_43_in_rule__Color__Alternatives_11965); 
                     after(grammarAccess.getColorAccess().getDarkSalmoKeyword_1_32()); 

                    }


                    }
                    break;
                case 34 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:845:6: ( 'DarkSeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:845:6: ( 'DarkSeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:846:1: 'DarkSeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getDarkSeaGreenKeyword_1_33()); 
                    match(input,44,FOLLOW_44_in_rule__Color__Alternatives_11985); 
                     after(grammarAccess.getColorAccess().getDarkSeaGreenKeyword_1_33()); 

                    }


                    }
                    break;
                case 35 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:853:6: ( 'DarkSlateBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:853:6: ( 'DarkSlateBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:854:1: 'DarkSlateBlue'
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateBlueKeyword_1_34()); 
                    match(input,45,FOLLOW_45_in_rule__Color__Alternatives_12005); 
                     after(grammarAccess.getColorAccess().getDarkSlateBlueKeyword_1_34()); 

                    }


                    }
                    break;
                case 36 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:861:6: ( 'DarkSlateGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:861:6: ( 'DarkSlateGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:862:1: 'DarkSlateGray'
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateGrayKeyword_1_35()); 
                    match(input,46,FOLLOW_46_in_rule__Color__Alternatives_12025); 
                     after(grammarAccess.getColorAccess().getDarkSlateGrayKeyword_1_35()); 

                    }


                    }
                    break;
                case 37 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:869:6: ( 'DarkSlateGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:869:6: ( 'DarkSlateGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:870:1: 'DarkSlateGrey'
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateGreyKeyword_1_36()); 
                    match(input,47,FOLLOW_47_in_rule__Color__Alternatives_12045); 
                     after(grammarAccess.getColorAccess().getDarkSlateGreyKeyword_1_36()); 

                    }


                    }
                    break;
                case 38 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:877:6: ( 'DarkTurquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:877:6: ( 'DarkTurquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:878:1: 'DarkTurquoise'
                    {
                     before(grammarAccess.getColorAccess().getDarkTurquoiseKeyword_1_37()); 
                    match(input,48,FOLLOW_48_in_rule__Color__Alternatives_12065); 
                     after(grammarAccess.getColorAccess().getDarkTurquoiseKeyword_1_37()); 

                    }


                    }
                    break;
                case 39 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:885:6: ( 'DarkViolet' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:885:6: ( 'DarkViolet' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:886:1: 'DarkViolet'
                    {
                     before(grammarAccess.getColorAccess().getDarkVioletKeyword_1_38()); 
                    match(input,49,FOLLOW_49_in_rule__Color__Alternatives_12085); 
                     after(grammarAccess.getColorAccess().getDarkVioletKeyword_1_38()); 

                    }


                    }
                    break;
                case 40 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:893:6: ( 'Darkorange' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:893:6: ( 'Darkorange' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:894:1: 'Darkorange'
                    {
                     before(grammarAccess.getColorAccess().getDarkorangeKeyword_1_39()); 
                    match(input,50,FOLLOW_50_in_rule__Color__Alternatives_12105); 
                     after(grammarAccess.getColorAccess().getDarkorangeKeyword_1_39()); 

                    }


                    }
                    break;
                case 41 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:901:6: ( 'DeepPink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:901:6: ( 'DeepPink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:902:1: 'DeepPink'
                    {
                     before(grammarAccess.getColorAccess().getDeepPinkKeyword_1_40()); 
                    match(input,51,FOLLOW_51_in_rule__Color__Alternatives_12125); 
                     after(grammarAccess.getColorAccess().getDeepPinkKeyword_1_40()); 

                    }


                    }
                    break;
                case 42 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:909:6: ( 'DeepSkyBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:909:6: ( 'DeepSkyBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:910:1: 'DeepSkyBlue'
                    {
                     before(grammarAccess.getColorAccess().getDeepSkyBlueKeyword_1_41()); 
                    match(input,52,FOLLOW_52_in_rule__Color__Alternatives_12145); 
                     after(grammarAccess.getColorAccess().getDeepSkyBlueKeyword_1_41()); 

                    }


                    }
                    break;
                case 43 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:917:6: ( 'DimGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:917:6: ( 'DimGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:918:1: 'DimGray'
                    {
                     before(grammarAccess.getColorAccess().getDimGrayKeyword_1_42()); 
                    match(input,53,FOLLOW_53_in_rule__Color__Alternatives_12165); 
                     after(grammarAccess.getColorAccess().getDimGrayKeyword_1_42()); 

                    }


                    }
                    break;
                case 44 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:925:6: ( 'DimGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:925:6: ( 'DimGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:926:1: 'DimGrey'
                    {
                     before(grammarAccess.getColorAccess().getDimGreyKeyword_1_43()); 
                    match(input,54,FOLLOW_54_in_rule__Color__Alternatives_12185); 
                     after(grammarAccess.getColorAccess().getDimGreyKeyword_1_43()); 

                    }


                    }
                    break;
                case 45 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:933:6: ( 'DodgerBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:933:6: ( 'DodgerBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:934:1: 'DodgerBlue'
                    {
                     before(grammarAccess.getColorAccess().getDodgerBlueKeyword_1_44()); 
                    match(input,55,FOLLOW_55_in_rule__Color__Alternatives_12205); 
                     after(grammarAccess.getColorAccess().getDodgerBlueKeyword_1_44()); 

                    }


                    }
                    break;
                case 46 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:941:6: ( 'FireBrick' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:941:6: ( 'FireBrick' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:942:1: 'FireBrick'
                    {
                     before(grammarAccess.getColorAccess().getFireBrickKeyword_1_45()); 
                    match(input,56,FOLLOW_56_in_rule__Color__Alternatives_12225); 
                     after(grammarAccess.getColorAccess().getFireBrickKeyword_1_45()); 

                    }


                    }
                    break;
                case 47 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:949:6: ( 'FloralWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:949:6: ( 'FloralWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:950:1: 'FloralWhite'
                    {
                     before(grammarAccess.getColorAccess().getFloralWhiteKeyword_1_46()); 
                    match(input,57,FOLLOW_57_in_rule__Color__Alternatives_12245); 
                     after(grammarAccess.getColorAccess().getFloralWhiteKeyword_1_46()); 

                    }


                    }
                    break;
                case 48 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:957:6: ( 'ForestGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:957:6: ( 'ForestGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:958:1: 'ForestGreen'
                    {
                     before(grammarAccess.getColorAccess().getForestGreenKeyword_1_47()); 
                    match(input,58,FOLLOW_58_in_rule__Color__Alternatives_12265); 
                     after(grammarAccess.getColorAccess().getForestGreenKeyword_1_47()); 

                    }


                    }
                    break;
                case 49 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:965:6: ( 'Fuchsia' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:965:6: ( 'Fuchsia' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:966:1: 'Fuchsia'
                    {
                     before(grammarAccess.getColorAccess().getFuchsiaKeyword_1_48()); 
                    match(input,59,FOLLOW_59_in_rule__Color__Alternatives_12285); 
                     after(grammarAccess.getColorAccess().getFuchsiaKeyword_1_48()); 

                    }


                    }
                    break;
                case 50 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:973:6: ( 'Gainsboro' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:973:6: ( 'Gainsboro' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:974:1: 'Gainsboro'
                    {
                     before(grammarAccess.getColorAccess().getGainsboroKeyword_1_49()); 
                    match(input,60,FOLLOW_60_in_rule__Color__Alternatives_12305); 
                     after(grammarAccess.getColorAccess().getGainsboroKeyword_1_49()); 

                    }


                    }
                    break;
                case 51 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:981:6: ( 'GhostWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:981:6: ( 'GhostWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:982:1: 'GhostWhite'
                    {
                     before(grammarAccess.getColorAccess().getGhostWhiteKeyword_1_50()); 
                    match(input,61,FOLLOW_61_in_rule__Color__Alternatives_12325); 
                     after(grammarAccess.getColorAccess().getGhostWhiteKeyword_1_50()); 

                    }


                    }
                    break;
                case 52 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:989:6: ( 'Gold' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:989:6: ( 'Gold' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:990:1: 'Gold'
                    {
                     before(grammarAccess.getColorAccess().getGoldKeyword_1_51()); 
                    match(input,62,FOLLOW_62_in_rule__Color__Alternatives_12345); 
                     after(grammarAccess.getColorAccess().getGoldKeyword_1_51()); 

                    }


                    }
                    break;
                case 53 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:997:6: ( 'GoldenRod' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:997:6: ( 'GoldenRod' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:998:1: 'GoldenRod'
                    {
                     before(grammarAccess.getColorAccess().getGoldenRodKeyword_1_52()); 
                    match(input,63,FOLLOW_63_in_rule__Color__Alternatives_12365); 
                     after(grammarAccess.getColorAccess().getGoldenRodKeyword_1_52()); 

                    }


                    }
                    break;
                case 54 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1005:6: ( 'Gray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1005:6: ( 'Gray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1006:1: 'Gray'
                    {
                     before(grammarAccess.getColorAccess().getGrayKeyword_1_53()); 
                    match(input,64,FOLLOW_64_in_rule__Color__Alternatives_12385); 
                     after(grammarAccess.getColorAccess().getGrayKeyword_1_53()); 

                    }


                    }
                    break;
                case 55 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1013:6: ( 'Green' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1013:6: ( 'Green' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1014:1: 'Green'
                    {
                     before(grammarAccess.getColorAccess().getGreenKeyword_1_54()); 
                    match(input,65,FOLLOW_65_in_rule__Color__Alternatives_12405); 
                     after(grammarAccess.getColorAccess().getGreenKeyword_1_54()); 

                    }


                    }
                    break;
                case 56 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1021:6: ( 'GreenYellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1021:6: ( 'GreenYellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1022:1: 'GreenYellow'
                    {
                     before(grammarAccess.getColorAccess().getGreenYellowKeyword_1_55()); 
                    match(input,66,FOLLOW_66_in_rule__Color__Alternatives_12425); 
                     after(grammarAccess.getColorAccess().getGreenYellowKeyword_1_55()); 

                    }


                    }
                    break;
                case 57 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1029:6: ( 'Grey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1029:6: ( 'Grey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1030:1: 'Grey'
                    {
                     before(grammarAccess.getColorAccess().getGreyKeyword_1_56()); 
                    match(input,67,FOLLOW_67_in_rule__Color__Alternatives_12445); 
                     after(grammarAccess.getColorAccess().getGreyKeyword_1_56()); 

                    }


                    }
                    break;
                case 58 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1037:6: ( 'HoneyDew' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1037:6: ( 'HoneyDew' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1038:1: 'HoneyDew'
                    {
                     before(grammarAccess.getColorAccess().getHoneyDewKeyword_1_57()); 
                    match(input,68,FOLLOW_68_in_rule__Color__Alternatives_12465); 
                     after(grammarAccess.getColorAccess().getHoneyDewKeyword_1_57()); 

                    }


                    }
                    break;
                case 59 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1045:6: ( 'HotPink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1045:6: ( 'HotPink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1046:1: 'HotPink'
                    {
                     before(grammarAccess.getColorAccess().getHotPinkKeyword_1_58()); 
                    match(input,69,FOLLOW_69_in_rule__Color__Alternatives_12485); 
                     after(grammarAccess.getColorAccess().getHotPinkKeyword_1_58()); 

                    }


                    }
                    break;
                case 60 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1053:6: ( 'IndianRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1053:6: ( 'IndianRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1054:1: 'IndianRed'
                    {
                     before(grammarAccess.getColorAccess().getIndianRedKeyword_1_59()); 
                    match(input,70,FOLLOW_70_in_rule__Color__Alternatives_12505); 
                     after(grammarAccess.getColorAccess().getIndianRedKeyword_1_59()); 

                    }


                    }
                    break;
                case 61 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1061:6: ( 'Indigo' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1061:6: ( 'Indigo' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1062:1: 'Indigo'
                    {
                     before(grammarAccess.getColorAccess().getIndigoKeyword_1_60()); 
                    match(input,71,FOLLOW_71_in_rule__Color__Alternatives_12525); 
                     after(grammarAccess.getColorAccess().getIndigoKeyword_1_60()); 

                    }


                    }
                    break;
                case 62 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1069:6: ( 'Ivory' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1069:6: ( 'Ivory' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1070:1: 'Ivory'
                    {
                     before(grammarAccess.getColorAccess().getIvoryKeyword_1_61()); 
                    match(input,72,FOLLOW_72_in_rule__Color__Alternatives_12545); 
                     after(grammarAccess.getColorAccess().getIvoryKeyword_1_61()); 

                    }


                    }
                    break;
                case 63 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1077:6: ( 'Khaki' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1077:6: ( 'Khaki' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1078:1: 'Khaki'
                    {
                     before(grammarAccess.getColorAccess().getKhakiKeyword_1_62()); 
                    match(input,73,FOLLOW_73_in_rule__Color__Alternatives_12565); 
                     after(grammarAccess.getColorAccess().getKhakiKeyword_1_62()); 

                    }


                    }
                    break;
                case 64 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1085:6: ( 'Lavender' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1085:6: ( 'Lavender' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1086:1: 'Lavender'
                    {
                     before(grammarAccess.getColorAccess().getLavenderKeyword_1_63()); 
                    match(input,74,FOLLOW_74_in_rule__Color__Alternatives_12585); 
                     after(grammarAccess.getColorAccess().getLavenderKeyword_1_63()); 

                    }


                    }
                    break;
                case 65 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1093:6: ( 'LavenderBlush' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1093:6: ( 'LavenderBlush' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1094:1: 'LavenderBlush'
                    {
                     before(grammarAccess.getColorAccess().getLavenderBlushKeyword_1_64()); 
                    match(input,75,FOLLOW_75_in_rule__Color__Alternatives_12605); 
                     after(grammarAccess.getColorAccess().getLavenderBlushKeyword_1_64()); 

                    }


                    }
                    break;
                case 66 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1101:6: ( 'LawnGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1101:6: ( 'LawnGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1102:1: 'LawnGreen'
                    {
                     before(grammarAccess.getColorAccess().getLawnGreenKeyword_1_65()); 
                    match(input,76,FOLLOW_76_in_rule__Color__Alternatives_12625); 
                     after(grammarAccess.getColorAccess().getLawnGreenKeyword_1_65()); 

                    }


                    }
                    break;
                case 67 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1109:6: ( 'LemonChiffon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1109:6: ( 'LemonChiffon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1110:1: 'LemonChiffon'
                    {
                     before(grammarAccess.getColorAccess().getLemonChiffonKeyword_1_66()); 
                    match(input,77,FOLLOW_77_in_rule__Color__Alternatives_12645); 
                     after(grammarAccess.getColorAccess().getLemonChiffonKeyword_1_66()); 

                    }


                    }
                    break;
                case 68 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1117:6: ( 'LightBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1117:6: ( 'LightBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1118:1: 'LightBlue'
                    {
                     before(grammarAccess.getColorAccess().getLightBlueKeyword_1_67()); 
                    match(input,78,FOLLOW_78_in_rule__Color__Alternatives_12665); 
                     after(grammarAccess.getColorAccess().getLightBlueKeyword_1_67()); 

                    }


                    }
                    break;
                case 69 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1125:6: ( 'LightCoral' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1125:6: ( 'LightCoral' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1126:1: 'LightCoral'
                    {
                     before(grammarAccess.getColorAccess().getLightCoralKeyword_1_68()); 
                    match(input,79,FOLLOW_79_in_rule__Color__Alternatives_12685); 
                     after(grammarAccess.getColorAccess().getLightCoralKeyword_1_68()); 

                    }


                    }
                    break;
                case 70 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1133:6: ( 'LightCyan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1133:6: ( 'LightCyan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1134:1: 'LightCyan'
                    {
                     before(grammarAccess.getColorAccess().getLightCyanKeyword_1_69()); 
                    match(input,80,FOLLOW_80_in_rule__Color__Alternatives_12705); 
                     after(grammarAccess.getColorAccess().getLightCyanKeyword_1_69()); 

                    }


                    }
                    break;
                case 71 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1141:6: ( 'LightGoldenRodYellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1141:6: ( 'LightGoldenRodYellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1142:1: 'LightGoldenRodYellow'
                    {
                     before(grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_1_70()); 
                    match(input,81,FOLLOW_81_in_rule__Color__Alternatives_12725); 
                     after(grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_1_70()); 

                    }


                    }
                    break;
                case 72 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1149:6: ( 'LightGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1149:6: ( 'LightGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1150:1: 'LightGray'
                    {
                     before(grammarAccess.getColorAccess().getLightGrayKeyword_1_71()); 
                    match(input,82,FOLLOW_82_in_rule__Color__Alternatives_12745); 
                     after(grammarAccess.getColorAccess().getLightGrayKeyword_1_71()); 

                    }


                    }
                    break;
                case 73 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1157:6: ( 'LightGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1157:6: ( 'LightGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1158:1: 'LightGreen'
                    {
                     before(grammarAccess.getColorAccess().getLightGreenKeyword_1_72()); 
                    match(input,83,FOLLOW_83_in_rule__Color__Alternatives_12765); 
                     after(grammarAccess.getColorAccess().getLightGreenKeyword_1_72()); 

                    }


                    }
                    break;
                case 74 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1165:6: ( 'LightGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1165:6: ( 'LightGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1166:1: 'LightGrey'
                    {
                     before(grammarAccess.getColorAccess().getLightGreyKeyword_1_73()); 
                    match(input,84,FOLLOW_84_in_rule__Color__Alternatives_12785); 
                     after(grammarAccess.getColorAccess().getLightGreyKeyword_1_73()); 

                    }


                    }
                    break;
                case 75 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1173:6: ( 'LightPink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1173:6: ( 'LightPink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1174:1: 'LightPink'
                    {
                     before(grammarAccess.getColorAccess().getLightPinkKeyword_1_74()); 
                    match(input,85,FOLLOW_85_in_rule__Color__Alternatives_12805); 
                     after(grammarAccess.getColorAccess().getLightPinkKeyword_1_74()); 

                    }


                    }
                    break;
                case 76 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1181:6: ( 'LightSalmon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1181:6: ( 'LightSalmon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1182:1: 'LightSalmon'
                    {
                     before(grammarAccess.getColorAccess().getLightSalmonKeyword_1_75()); 
                    match(input,86,FOLLOW_86_in_rule__Color__Alternatives_12825); 
                     after(grammarAccess.getColorAccess().getLightSalmonKeyword_1_75()); 

                    }


                    }
                    break;
                case 77 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1189:6: ( 'LightSeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1189:6: ( 'LightSeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1190:1: 'LightSeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getLightSeaGreenKeyword_1_76()); 
                    match(input,87,FOLLOW_87_in_rule__Color__Alternatives_12845); 
                     after(grammarAccess.getColorAccess().getLightSeaGreenKeyword_1_76()); 

                    }


                    }
                    break;
                case 78 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1197:6: ( 'LightSkyBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1197:6: ( 'LightSkyBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1198:1: 'LightSkyBlue'
                    {
                     before(grammarAccess.getColorAccess().getLightSkyBlueKeyword_1_77()); 
                    match(input,88,FOLLOW_88_in_rule__Color__Alternatives_12865); 
                     after(grammarAccess.getColorAccess().getLightSkyBlueKeyword_1_77()); 

                    }


                    }
                    break;
                case 79 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1205:6: ( 'LightSlateGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1205:6: ( 'LightSlateGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1206:1: 'LightSlateGray'
                    {
                     before(grammarAccess.getColorAccess().getLightSlateGrayKeyword_1_78()); 
                    match(input,89,FOLLOW_89_in_rule__Color__Alternatives_12885); 
                     after(grammarAccess.getColorAccess().getLightSlateGrayKeyword_1_78()); 

                    }


                    }
                    break;
                case 80 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1213:6: ( 'LightSlateGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1213:6: ( 'LightSlateGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1214:1: 'LightSlateGrey'
                    {
                     before(grammarAccess.getColorAccess().getLightSlateGreyKeyword_1_79()); 
                    match(input,90,FOLLOW_90_in_rule__Color__Alternatives_12905); 
                     after(grammarAccess.getColorAccess().getLightSlateGreyKeyword_1_79()); 

                    }


                    }
                    break;
                case 81 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1221:6: ( 'LightSteelBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1221:6: ( 'LightSteelBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1222:1: 'LightSteelBlue'
                    {
                     before(grammarAccess.getColorAccess().getLightSteelBlueKeyword_1_80()); 
                    match(input,91,FOLLOW_91_in_rule__Color__Alternatives_12925); 
                     after(grammarAccess.getColorAccess().getLightSteelBlueKeyword_1_80()); 

                    }


                    }
                    break;
                case 82 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1229:6: ( 'LightYellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1229:6: ( 'LightYellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1230:1: 'LightYellow'
                    {
                     before(grammarAccess.getColorAccess().getLightYellowKeyword_1_81()); 
                    match(input,92,FOLLOW_92_in_rule__Color__Alternatives_12945); 
                     after(grammarAccess.getColorAccess().getLightYellowKeyword_1_81()); 

                    }


                    }
                    break;
                case 83 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1237:6: ( 'Lime' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1237:6: ( 'Lime' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1238:1: 'Lime'
                    {
                     before(grammarAccess.getColorAccess().getLimeKeyword_1_82()); 
                    match(input,93,FOLLOW_93_in_rule__Color__Alternatives_12965); 
                     after(grammarAccess.getColorAccess().getLimeKeyword_1_82()); 

                    }


                    }
                    break;
                case 84 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1245:6: ( 'LimeGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1245:6: ( 'LimeGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1246:1: 'LimeGreen'
                    {
                     before(grammarAccess.getColorAccess().getLimeGreenKeyword_1_83()); 
                    match(input,94,FOLLOW_94_in_rule__Color__Alternatives_12985); 
                     after(grammarAccess.getColorAccess().getLimeGreenKeyword_1_83()); 

                    }


                    }
                    break;
                case 85 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1253:6: ( 'Linen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1253:6: ( 'Linen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1254:1: 'Linen'
                    {
                     before(grammarAccess.getColorAccess().getLinenKeyword_1_84()); 
                    match(input,95,FOLLOW_95_in_rule__Color__Alternatives_13005); 
                     after(grammarAccess.getColorAccess().getLinenKeyword_1_84()); 

                    }


                    }
                    break;
                case 86 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1261:6: ( 'Magenta' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1261:6: ( 'Magenta' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1262:1: 'Magenta'
                    {
                     before(grammarAccess.getColorAccess().getMagentaKeyword_1_85()); 
                    match(input,96,FOLLOW_96_in_rule__Color__Alternatives_13025); 
                     after(grammarAccess.getColorAccess().getMagentaKeyword_1_85()); 

                    }


                    }
                    break;
                case 87 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1269:6: ( 'Maroon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1269:6: ( 'Maroon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1270:1: 'Maroon'
                    {
                     before(grammarAccess.getColorAccess().getMaroonKeyword_1_86()); 
                    match(input,97,FOLLOW_97_in_rule__Color__Alternatives_13045); 
                     after(grammarAccess.getColorAccess().getMaroonKeyword_1_86()); 

                    }


                    }
                    break;
                case 88 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1277:6: ( 'MediumAquaMarine' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1277:6: ( 'MediumAquaMarine' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1278:1: 'MediumAquaMarine'
                    {
                     before(grammarAccess.getColorAccess().getMediumAquaMarineKeyword_1_87()); 
                    match(input,98,FOLLOW_98_in_rule__Color__Alternatives_13065); 
                     after(grammarAccess.getColorAccess().getMediumAquaMarineKeyword_1_87()); 

                    }


                    }
                    break;
                case 89 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1285:6: ( 'MediumBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1285:6: ( 'MediumBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1286:1: 'MediumBlue'
                    {
                     before(grammarAccess.getColorAccess().getMediumBlueKeyword_1_88()); 
                    match(input,99,FOLLOW_99_in_rule__Color__Alternatives_13085); 
                     after(grammarAccess.getColorAccess().getMediumBlueKeyword_1_88()); 

                    }


                    }
                    break;
                case 90 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1293:6: ( 'MediumOrchid' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1293:6: ( 'MediumOrchid' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1294:1: 'MediumOrchid'
                    {
                     before(grammarAccess.getColorAccess().getMediumOrchidKeyword_1_89()); 
                    match(input,100,FOLLOW_100_in_rule__Color__Alternatives_13105); 
                     after(grammarAccess.getColorAccess().getMediumOrchidKeyword_1_89()); 

                    }


                    }
                    break;
                case 91 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1301:6: ( 'MediumPurple' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1301:6: ( 'MediumPurple' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1302:1: 'MediumPurple'
                    {
                     before(grammarAccess.getColorAccess().getMediumPurpleKeyword_1_90()); 
                    match(input,101,FOLLOW_101_in_rule__Color__Alternatives_13125); 
                     after(grammarAccess.getColorAccess().getMediumPurpleKeyword_1_90()); 

                    }


                    }
                    break;
                case 92 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1309:6: ( 'MediumSeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1309:6: ( 'MediumSeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1310:1: 'MediumSeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getMediumSeaGreenKeyword_1_91()); 
                    match(input,102,FOLLOW_102_in_rule__Color__Alternatives_13145); 
                     after(grammarAccess.getColorAccess().getMediumSeaGreenKeyword_1_91()); 

                    }


                    }
                    break;
                case 93 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1317:6: ( 'MediumSlateBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1317:6: ( 'MediumSlateBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1318:1: 'MediumSlateBlue'
                    {
                     before(grammarAccess.getColorAccess().getMediumSlateBlueKeyword_1_92()); 
                    match(input,103,FOLLOW_103_in_rule__Color__Alternatives_13165); 
                     after(grammarAccess.getColorAccess().getMediumSlateBlueKeyword_1_92()); 

                    }


                    }
                    break;
                case 94 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1325:6: ( 'MediumSpringGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1325:6: ( 'MediumSpringGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1326:1: 'MediumSpringGreen'
                    {
                     before(grammarAccess.getColorAccess().getMediumSpringGreenKeyword_1_93()); 
                    match(input,104,FOLLOW_104_in_rule__Color__Alternatives_13185); 
                     after(grammarAccess.getColorAccess().getMediumSpringGreenKeyword_1_93()); 

                    }


                    }
                    break;
                case 95 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1333:6: ( 'MediumTurquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1333:6: ( 'MediumTurquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1334:1: 'MediumTurquoise'
                    {
                     before(grammarAccess.getColorAccess().getMediumTurquoiseKeyword_1_94()); 
                    match(input,105,FOLLOW_105_in_rule__Color__Alternatives_13205); 
                     after(grammarAccess.getColorAccess().getMediumTurquoiseKeyword_1_94()); 

                    }


                    }
                    break;
                case 96 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1341:6: ( 'MediumVioletRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1341:6: ( 'MediumVioletRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1342:1: 'MediumVioletRed'
                    {
                     before(grammarAccess.getColorAccess().getMediumVioletRedKeyword_1_95()); 
                    match(input,106,FOLLOW_106_in_rule__Color__Alternatives_13225); 
                     after(grammarAccess.getColorAccess().getMediumVioletRedKeyword_1_95()); 

                    }


                    }
                    break;
                case 97 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1349:6: ( 'MidnightBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1349:6: ( 'MidnightBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1350:1: 'MidnightBlue'
                    {
                     before(grammarAccess.getColorAccess().getMidnightBlueKeyword_1_96()); 
                    match(input,107,FOLLOW_107_in_rule__Color__Alternatives_13245); 
                     after(grammarAccess.getColorAccess().getMidnightBlueKeyword_1_96()); 

                    }


                    }
                    break;
                case 98 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1357:6: ( 'MintCream' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1357:6: ( 'MintCream' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1358:1: 'MintCream'
                    {
                     before(grammarAccess.getColorAccess().getMintCreamKeyword_1_97()); 
                    match(input,108,FOLLOW_108_in_rule__Color__Alternatives_13265); 
                     after(grammarAccess.getColorAccess().getMintCreamKeyword_1_97()); 

                    }


                    }
                    break;
                case 99 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1365:6: ( 'MistyRose' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1365:6: ( 'MistyRose' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1366:1: 'MistyRose'
                    {
                     before(grammarAccess.getColorAccess().getMistyRoseKeyword_1_98()); 
                    match(input,109,FOLLOW_109_in_rule__Color__Alternatives_13285); 
                     after(grammarAccess.getColorAccess().getMistyRoseKeyword_1_98()); 

                    }


                    }
                    break;
                case 100 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1373:6: ( 'Moccasin' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1373:6: ( 'Moccasin' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1374:1: 'Moccasin'
                    {
                     before(grammarAccess.getColorAccess().getMoccasinKeyword_1_99()); 
                    match(input,110,FOLLOW_110_in_rule__Color__Alternatives_13305); 
                     after(grammarAccess.getColorAccess().getMoccasinKeyword_1_99()); 

                    }


                    }
                    break;
                case 101 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1381:6: ( 'NavajoWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1381:6: ( 'NavajoWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1382:1: 'NavajoWhite'
                    {
                     before(grammarAccess.getColorAccess().getNavajoWhiteKeyword_1_100()); 
                    match(input,111,FOLLOW_111_in_rule__Color__Alternatives_13325); 
                     after(grammarAccess.getColorAccess().getNavajoWhiteKeyword_1_100()); 

                    }


                    }
                    break;
                case 102 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1389:6: ( 'Navy' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1389:6: ( 'Navy' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1390:1: 'Navy'
                    {
                     before(grammarAccess.getColorAccess().getNavyKeyword_1_101()); 
                    match(input,112,FOLLOW_112_in_rule__Color__Alternatives_13345); 
                     after(grammarAccess.getColorAccess().getNavyKeyword_1_101()); 

                    }


                    }
                    break;
                case 103 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1397:6: ( 'OldLace' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1397:6: ( 'OldLace' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1398:1: 'OldLace'
                    {
                     before(grammarAccess.getColorAccess().getOldLaceKeyword_1_102()); 
                    match(input,113,FOLLOW_113_in_rule__Color__Alternatives_13365); 
                     after(grammarAccess.getColorAccess().getOldLaceKeyword_1_102()); 

                    }


                    }
                    break;
                case 104 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1405:6: ( 'Olive' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1405:6: ( 'Olive' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1406:1: 'Olive'
                    {
                     before(grammarAccess.getColorAccess().getOliveKeyword_1_103()); 
                    match(input,114,FOLLOW_114_in_rule__Color__Alternatives_13385); 
                     after(grammarAccess.getColorAccess().getOliveKeyword_1_103()); 

                    }


                    }
                    break;
                case 105 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1413:6: ( 'OliveDrab' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1413:6: ( 'OliveDrab' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1414:1: 'OliveDrab'
                    {
                     before(grammarAccess.getColorAccess().getOliveDrabKeyword_1_104()); 
                    match(input,115,FOLLOW_115_in_rule__Color__Alternatives_13405); 
                     after(grammarAccess.getColorAccess().getOliveDrabKeyword_1_104()); 

                    }


                    }
                    break;
                case 106 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1421:6: ( 'OrangeRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1421:6: ( 'OrangeRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1422:1: 'OrangeRed'
                    {
                     before(grammarAccess.getColorAccess().getOrangeRedKeyword_1_105()); 
                    match(input,116,FOLLOW_116_in_rule__Color__Alternatives_13425); 
                     after(grammarAccess.getColorAccess().getOrangeRedKeyword_1_105()); 

                    }


                    }
                    break;
                case 107 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1429:6: ( 'Orchid' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1429:6: ( 'Orchid' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1430:1: 'Orchid'
                    {
                     before(grammarAccess.getColorAccess().getOrchidKeyword_1_106()); 
                    match(input,117,FOLLOW_117_in_rule__Color__Alternatives_13445); 
                     after(grammarAccess.getColorAccess().getOrchidKeyword_1_106()); 

                    }


                    }
                    break;
                case 108 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1437:6: ( 'PaleGoldenRod' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1437:6: ( 'PaleGoldenRod' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1438:1: 'PaleGoldenRod'
                    {
                     before(grammarAccess.getColorAccess().getPaleGoldenRodKeyword_1_107()); 
                    match(input,118,FOLLOW_118_in_rule__Color__Alternatives_13465); 
                     after(grammarAccess.getColorAccess().getPaleGoldenRodKeyword_1_107()); 

                    }


                    }
                    break;
                case 109 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1445:6: ( 'PaleGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1445:6: ( 'PaleGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1446:1: 'PaleGreen'
                    {
                     before(grammarAccess.getColorAccess().getPaleGreenKeyword_1_108()); 
                    match(input,119,FOLLOW_119_in_rule__Color__Alternatives_13485); 
                     after(grammarAccess.getColorAccess().getPaleGreenKeyword_1_108()); 

                    }


                    }
                    break;
                case 110 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1453:6: ( 'PaleTurquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1453:6: ( 'PaleTurquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1454:1: 'PaleTurquoise'
                    {
                     before(grammarAccess.getColorAccess().getPaleTurquoiseKeyword_1_109()); 
                    match(input,120,FOLLOW_120_in_rule__Color__Alternatives_13505); 
                     after(grammarAccess.getColorAccess().getPaleTurquoiseKeyword_1_109()); 

                    }


                    }
                    break;
                case 111 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1461:6: ( 'PaleVioletRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1461:6: ( 'PaleVioletRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1462:1: 'PaleVioletRed'
                    {
                     before(grammarAccess.getColorAccess().getPaleVioletRedKeyword_1_110()); 
                    match(input,121,FOLLOW_121_in_rule__Color__Alternatives_13525); 
                     after(grammarAccess.getColorAccess().getPaleVioletRedKeyword_1_110()); 

                    }


                    }
                    break;
                case 112 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1469:6: ( 'PapayaWhip' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1469:6: ( 'PapayaWhip' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1470:1: 'PapayaWhip'
                    {
                     before(grammarAccess.getColorAccess().getPapayaWhipKeyword_1_111()); 
                    match(input,122,FOLLOW_122_in_rule__Color__Alternatives_13545); 
                     after(grammarAccess.getColorAccess().getPapayaWhipKeyword_1_111()); 

                    }


                    }
                    break;
                case 113 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1477:6: ( 'PeachPuff' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1477:6: ( 'PeachPuff' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1478:1: 'PeachPuff'
                    {
                     before(grammarAccess.getColorAccess().getPeachPuffKeyword_1_112()); 
                    match(input,123,FOLLOW_123_in_rule__Color__Alternatives_13565); 
                     after(grammarAccess.getColorAccess().getPeachPuffKeyword_1_112()); 

                    }


                    }
                    break;
                case 114 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1485:6: ( 'Peru' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1485:6: ( 'Peru' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1486:1: 'Peru'
                    {
                     before(grammarAccess.getColorAccess().getPeruKeyword_1_113()); 
                    match(input,124,FOLLOW_124_in_rule__Color__Alternatives_13585); 
                     after(grammarAccess.getColorAccess().getPeruKeyword_1_113()); 

                    }


                    }
                    break;
                case 115 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1493:6: ( 'Pink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1493:6: ( 'Pink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1494:1: 'Pink'
                    {
                     before(grammarAccess.getColorAccess().getPinkKeyword_1_114()); 
                    match(input,125,FOLLOW_125_in_rule__Color__Alternatives_13605); 
                     after(grammarAccess.getColorAccess().getPinkKeyword_1_114()); 

                    }


                    }
                    break;
                case 116 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1501:6: ( 'Plum' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1501:6: ( 'Plum' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1502:1: 'Plum'
                    {
                     before(grammarAccess.getColorAccess().getPlumKeyword_1_115()); 
                    match(input,126,FOLLOW_126_in_rule__Color__Alternatives_13625); 
                     after(grammarAccess.getColorAccess().getPlumKeyword_1_115()); 

                    }


                    }
                    break;
                case 117 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1509:6: ( 'PowderBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1509:6: ( 'PowderBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1510:1: 'PowderBlue'
                    {
                     before(grammarAccess.getColorAccess().getPowderBlueKeyword_1_116()); 
                    match(input,127,FOLLOW_127_in_rule__Color__Alternatives_13645); 
                     after(grammarAccess.getColorAccess().getPowderBlueKeyword_1_116()); 

                    }


                    }
                    break;
                case 118 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1517:6: ( 'Purple' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1517:6: ( 'Purple' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1518:1: 'Purple'
                    {
                     before(grammarAccess.getColorAccess().getPurpleKeyword_1_117()); 
                    match(input,128,FOLLOW_128_in_rule__Color__Alternatives_13665); 
                     after(grammarAccess.getColorAccess().getPurpleKeyword_1_117()); 

                    }


                    }
                    break;
                case 119 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1525:6: ( 'Red' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1525:6: ( 'Red' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1526:1: 'Red'
                    {
                     before(grammarAccess.getColorAccess().getRedKeyword_1_118()); 
                    match(input,129,FOLLOW_129_in_rule__Color__Alternatives_13685); 
                     after(grammarAccess.getColorAccess().getRedKeyword_1_118()); 

                    }


                    }
                    break;
                case 120 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1533:6: ( 'RosyBrown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1533:6: ( 'RosyBrown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1534:1: 'RosyBrown'
                    {
                     before(grammarAccess.getColorAccess().getRosyBrownKeyword_1_119()); 
                    match(input,130,FOLLOW_130_in_rule__Color__Alternatives_13705); 
                     after(grammarAccess.getColorAccess().getRosyBrownKeyword_1_119()); 

                    }


                    }
                    break;
                case 121 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1541:6: ( 'RoyalBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1541:6: ( 'RoyalBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1542:1: 'RoyalBlue'
                    {
                     before(grammarAccess.getColorAccess().getRoyalBlueKeyword_1_120()); 
                    match(input,131,FOLLOW_131_in_rule__Color__Alternatives_13725); 
                     after(grammarAccess.getColorAccess().getRoyalBlueKeyword_1_120()); 

                    }


                    }
                    break;
                case 122 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1549:6: ( 'SaddleBrown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1549:6: ( 'SaddleBrown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1550:1: 'SaddleBrown'
                    {
                     before(grammarAccess.getColorAccess().getSaddleBrownKeyword_1_121()); 
                    match(input,132,FOLLOW_132_in_rule__Color__Alternatives_13745); 
                     after(grammarAccess.getColorAccess().getSaddleBrownKeyword_1_121()); 

                    }


                    }
                    break;
                case 123 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1557:6: ( 'Salmon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1557:6: ( 'Salmon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1558:1: 'Salmon'
                    {
                     before(grammarAccess.getColorAccess().getSalmonKeyword_1_122()); 
                    match(input,133,FOLLOW_133_in_rule__Color__Alternatives_13765); 
                     after(grammarAccess.getColorAccess().getSalmonKeyword_1_122()); 

                    }


                    }
                    break;
                case 124 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1565:6: ( 'SandyBrown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1565:6: ( 'SandyBrown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1566:1: 'SandyBrown'
                    {
                     before(grammarAccess.getColorAccess().getSandyBrownKeyword_1_123()); 
                    match(input,134,FOLLOW_134_in_rule__Color__Alternatives_13785); 
                     after(grammarAccess.getColorAccess().getSandyBrownKeyword_1_123()); 

                    }


                    }
                    break;
                case 125 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1573:6: ( 'SeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1573:6: ( 'SeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1574:1: 'SeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getSeaGreenKeyword_1_124()); 
                    match(input,135,FOLLOW_135_in_rule__Color__Alternatives_13805); 
                     after(grammarAccess.getColorAccess().getSeaGreenKeyword_1_124()); 

                    }


                    }
                    break;
                case 126 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1581:6: ( 'Sienna' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1581:6: ( 'Sienna' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1582:1: 'Sienna'
                    {
                     before(grammarAccess.getColorAccess().getSiennaKeyword_1_125()); 
                    match(input,136,FOLLOW_136_in_rule__Color__Alternatives_13825); 
                     after(grammarAccess.getColorAccess().getSiennaKeyword_1_125()); 

                    }


                    }
                    break;
                case 127 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1589:6: ( 'Silver' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1589:6: ( 'Silver' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1590:1: 'Silver'
                    {
                     before(grammarAccess.getColorAccess().getSilverKeyword_1_126()); 
                    match(input,137,FOLLOW_137_in_rule__Color__Alternatives_13845); 
                     after(grammarAccess.getColorAccess().getSilverKeyword_1_126()); 

                    }


                    }
                    break;
                case 128 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1597:6: ( 'SkyBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1597:6: ( 'SkyBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1598:1: 'SkyBlue'
                    {
                     before(grammarAccess.getColorAccess().getSkyBlueKeyword_1_127()); 
                    match(input,138,FOLLOW_138_in_rule__Color__Alternatives_13865); 
                     after(grammarAccess.getColorAccess().getSkyBlueKeyword_1_127()); 

                    }


                    }
                    break;
                case 129 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1605:6: ( 'SlateBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1605:6: ( 'SlateBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1606:1: 'SlateBlue'
                    {
                     before(grammarAccess.getColorAccess().getSlateBlueKeyword_1_128()); 
                    match(input,139,FOLLOW_139_in_rule__Color__Alternatives_13885); 
                     after(grammarAccess.getColorAccess().getSlateBlueKeyword_1_128()); 

                    }


                    }
                    break;
                case 130 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1613:6: ( 'SlateGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1613:6: ( 'SlateGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1614:1: 'SlateGray'
                    {
                     before(grammarAccess.getColorAccess().getSlateGrayKeyword_1_129()); 
                    match(input,140,FOLLOW_140_in_rule__Color__Alternatives_13905); 
                     after(grammarAccess.getColorAccess().getSlateGrayKeyword_1_129()); 

                    }


                    }
                    break;
                case 131 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1621:6: ( 'SlateGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1621:6: ( 'SlateGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1622:1: 'SlateGrey'
                    {
                     before(grammarAccess.getColorAccess().getSlateGreyKeyword_1_130()); 
                    match(input,141,FOLLOW_141_in_rule__Color__Alternatives_13925); 
                     after(grammarAccess.getColorAccess().getSlateGreyKeyword_1_130()); 

                    }


                    }
                    break;
                case 132 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1629:6: ( 'Snow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1629:6: ( 'Snow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1630:1: 'Snow'
                    {
                     before(grammarAccess.getColorAccess().getSnowKeyword_1_131()); 
                    match(input,142,FOLLOW_142_in_rule__Color__Alternatives_13945); 
                     after(grammarAccess.getColorAccess().getSnowKeyword_1_131()); 

                    }


                    }
                    break;
                case 133 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1637:6: ( 'SpringGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1637:6: ( 'SpringGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1638:1: 'SpringGreen'
                    {
                     before(grammarAccess.getColorAccess().getSpringGreenKeyword_1_132()); 
                    match(input,143,FOLLOW_143_in_rule__Color__Alternatives_13965); 
                     after(grammarAccess.getColorAccess().getSpringGreenKeyword_1_132()); 

                    }


                    }
                    break;
                case 134 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1645:6: ( 'SteelBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1645:6: ( 'SteelBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1646:1: 'SteelBlue'
                    {
                     before(grammarAccess.getColorAccess().getSteelBlueKeyword_1_133()); 
                    match(input,144,FOLLOW_144_in_rule__Color__Alternatives_13985); 
                     after(grammarAccess.getColorAccess().getSteelBlueKeyword_1_133()); 

                    }


                    }
                    break;
                case 135 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1653:6: ( 'Tan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1653:6: ( 'Tan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1654:1: 'Tan'
                    {
                     before(grammarAccess.getColorAccess().getTanKeyword_1_134()); 
                    match(input,145,FOLLOW_145_in_rule__Color__Alternatives_14005); 
                     after(grammarAccess.getColorAccess().getTanKeyword_1_134()); 

                    }


                    }
                    break;
                case 136 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1661:6: ( 'Teal' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1661:6: ( 'Teal' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1662:1: 'Teal'
                    {
                     before(grammarAccess.getColorAccess().getTealKeyword_1_135()); 
                    match(input,146,FOLLOW_146_in_rule__Color__Alternatives_14025); 
                     after(grammarAccess.getColorAccess().getTealKeyword_1_135()); 

                    }


                    }
                    break;
                case 137 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1669:6: ( 'Thistle' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1669:6: ( 'Thistle' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1670:1: 'Thistle'
                    {
                     before(grammarAccess.getColorAccess().getThistleKeyword_1_136()); 
                    match(input,147,FOLLOW_147_in_rule__Color__Alternatives_14045); 
                     after(grammarAccess.getColorAccess().getThistleKeyword_1_136()); 

                    }


                    }
                    break;
                case 138 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1677:6: ( 'Tomato' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1677:6: ( 'Tomato' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1678:1: 'Tomato'
                    {
                     before(grammarAccess.getColorAccess().getTomatoKeyword_1_137()); 
                    match(input,148,FOLLOW_148_in_rule__Color__Alternatives_14065); 
                     after(grammarAccess.getColorAccess().getTomatoKeyword_1_137()); 

                    }


                    }
                    break;
                case 139 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1685:6: ( 'Turquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1685:6: ( 'Turquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1686:1: 'Turquoise'
                    {
                     before(grammarAccess.getColorAccess().getTurquoiseKeyword_1_138()); 
                    match(input,149,FOLLOW_149_in_rule__Color__Alternatives_14085); 
                     after(grammarAccess.getColorAccess().getTurquoiseKeyword_1_138()); 

                    }


                    }
                    break;
                case 140 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1693:6: ( 'Violet' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1693:6: ( 'Violet' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1694:1: 'Violet'
                    {
                     before(grammarAccess.getColorAccess().getVioletKeyword_1_139()); 
                    match(input,150,FOLLOW_150_in_rule__Color__Alternatives_14105); 
                     after(grammarAccess.getColorAccess().getVioletKeyword_1_139()); 

                    }


                    }
                    break;
                case 141 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1701:6: ( 'Wheat' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1701:6: ( 'Wheat' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1702:1: 'Wheat'
                    {
                     before(grammarAccess.getColorAccess().getWheatKeyword_1_140()); 
                    match(input,151,FOLLOW_151_in_rule__Color__Alternatives_14125); 
                     after(grammarAccess.getColorAccess().getWheatKeyword_1_140()); 

                    }


                    }
                    break;
                case 142 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1709:6: ( 'White' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1709:6: ( 'White' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1710:1: 'White'
                    {
                     before(grammarAccess.getColorAccess().getWhiteKeyword_1_141()); 
                    match(input,152,FOLLOW_152_in_rule__Color__Alternatives_14145); 
                     after(grammarAccess.getColorAccess().getWhiteKeyword_1_141()); 

                    }


                    }
                    break;
                case 143 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1717:6: ( 'WhiteSmoke' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1717:6: ( 'WhiteSmoke' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1718:1: 'WhiteSmoke'
                    {
                     before(grammarAccess.getColorAccess().getWhiteSmokeKeyword_1_142()); 
                    match(input,153,FOLLOW_153_in_rule__Color__Alternatives_14165); 
                     after(grammarAccess.getColorAccess().getWhiteSmokeKeyword_1_142()); 

                    }


                    }
                    break;
                case 144 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1725:6: ( 'Yellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1725:6: ( 'Yellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1726:1: 'Yellow'
                    {
                     before(grammarAccess.getColorAccess().getYellowKeyword_1_143()); 
                    match(input,154,FOLLOW_154_in_rule__Color__Alternatives_14185); 
                     after(grammarAccess.getColorAccess().getYellowKeyword_1_143()); 

                    }


                    }
                    break;
                case 145 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1733:6: ( 'YellowGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1733:6: ( 'YellowGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1734:1: 'YellowGreen'
                    {
                     before(grammarAccess.getColorAccess().getYellowGreenKeyword_1_144()); 
                    match(input,155,FOLLOW_155_in_rule__Color__Alternatives_14205); 
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


    // $ANTLR start "rule__Legend__Alternatives_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1746:1: rule__Legend__Alternatives_1 : ( ( 'right' ) | ( 'left' ) | ( 'center' ) );
    public final void rule__Legend__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1750:1: ( ( 'right' ) | ( 'left' ) | ( 'center' ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 156:
                {
                alt6=1;
                }
                break;
            case 157:
                {
                alt6=2;
                }
                break;
            case 158:
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1751:1: ( 'right' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1751:1: ( 'right' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1752:1: 'right'
                    {
                     before(grammarAccess.getLegendAccess().getRightKeyword_1_0()); 
                    match(input,156,FOLLOW_156_in_rule__Legend__Alternatives_14240); 
                     after(grammarAccess.getLegendAccess().getRightKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1759:6: ( 'left' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1759:6: ( 'left' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1760:1: 'left'
                    {
                     before(grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 
                    match(input,157,FOLLOW_157_in_rule__Legend__Alternatives_14260); 
                     after(grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1767:6: ( 'center' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1767:6: ( 'center' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1768:1: 'center'
                    {
                     before(grammarAccess.getLegendAccess().getCenterKeyword_1_2()); 
                    match(input,158,FOLLOW_158_in_rule__Legend__Alternatives_14280); 
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


    // $ANTLR start "rule__Diagram__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1782:1: rule__Diagram__Group__0 : rule__Diagram__Group__0__Impl rule__Diagram__Group__1 ;
    public final void rule__Diagram__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1786:1: ( rule__Diagram__Group__0__Impl rule__Diagram__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1787:2: rule__Diagram__Group__0__Impl rule__Diagram__Group__1
            {
            pushFollow(FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__04312);
            rule__Diagram__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__04315);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1794:1: rule__Diagram__Group__0__Impl : ( '@startuml' ) ;
    public final void rule__Diagram__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1798:1: ( ( '@startuml' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1799:1: ( '@startuml' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1799:1: ( '@startuml' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1800:1: '@startuml'
            {
             before(grammarAccess.getDiagramAccess().getStartumlKeyword_0()); 
            match(input,159,FOLLOW_159_in_rule__Diagram__Group__0__Impl4343); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1813:1: rule__Diagram__Group__1 : rule__Diagram__Group__1__Impl rule__Diagram__Group__2 ;
    public final void rule__Diagram__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1817:1: ( rule__Diagram__Group__1__Impl rule__Diagram__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1818:2: rule__Diagram__Group__1__Impl rule__Diagram__Group__2
            {
            pushFollow(FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__14374);
            rule__Diagram__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__14377);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1825:1: rule__Diagram__Group__1__Impl : ( ( rule__Diagram__InstructionsAssignment_1 )* ) ;
    public final void rule__Diagram__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1829:1: ( ( ( rule__Diagram__InstructionsAssignment_1 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1830:1: ( ( rule__Diagram__InstructionsAssignment_1 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1830:1: ( ( rule__Diagram__InstructionsAssignment_1 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1831:1: ( rule__Diagram__InstructionsAssignment_1 )*
            {
             before(grammarAccess.getDiagramAccess().getInstructionsAssignment_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1832:1: ( rule__Diagram__InstructionsAssignment_1 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=RULE_ML_COMMENT && LA7_0<=RULE_ID)||(LA7_0>=171 && LA7_0<=176)||(LA7_0>=178 && LA7_0<=179)||LA7_0==181) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1832:2: rule__Diagram__InstructionsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Diagram__InstructionsAssignment_1_in_rule__Diagram__Group__1__Impl4404);
            	    rule__Diagram__InstructionsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1842:1: rule__Diagram__Group__2 : rule__Diagram__Group__2__Impl ;
    public final void rule__Diagram__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1846:1: ( rule__Diagram__Group__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1847:2: rule__Diagram__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__24435);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1853:1: rule__Diagram__Group__2__Impl : ( '@enduml' ) ;
    public final void rule__Diagram__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1857:1: ( ( '@enduml' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1858:1: ( '@enduml' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1858:1: ( '@enduml' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1859:1: '@enduml'
            {
             before(grammarAccess.getDiagramAccess().getEndumlKeyword_2()); 
            match(input,160,FOLLOW_160_in_rule__Diagram__Group__2__Impl4463); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1878:1: rule__Instruction__Group_0__0 : rule__Instruction__Group_0__0__Impl rule__Instruction__Group_0__1 ;
    public final void rule__Instruction__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1882:1: ( rule__Instruction__Group_0__0__Impl rule__Instruction__Group_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1883:2: rule__Instruction__Group_0__0__Impl rule__Instruction__Group_0__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0__0__Impl_in_rule__Instruction__Group_0__04500);
            rule__Instruction__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0__1_in_rule__Instruction__Group_0__04503);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1890:1: rule__Instruction__Group_0__0__Impl : ( ( rule__Instruction__Name1Assignment_0_0 ) ) ;
    public final void rule__Instruction__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1894:1: ( ( ( rule__Instruction__Name1Assignment_0_0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1895:1: ( ( rule__Instruction__Name1Assignment_0_0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1895:1: ( ( rule__Instruction__Name1Assignment_0_0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1896:1: ( rule__Instruction__Name1Assignment_0_0 )
            {
             before(grammarAccess.getInstructionAccess().getName1Assignment_0_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1897:1: ( rule__Instruction__Name1Assignment_0_0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1897:2: rule__Instruction__Name1Assignment_0_0
            {
            pushFollow(FOLLOW_rule__Instruction__Name1Assignment_0_0_in_rule__Instruction__Group_0__0__Impl4530);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1907:1: rule__Instruction__Group_0__1 : rule__Instruction__Group_0__1__Impl rule__Instruction__Group_0__2 ;
    public final void rule__Instruction__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1911:1: ( rule__Instruction__Group_0__1__Impl rule__Instruction__Group_0__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1912:2: rule__Instruction__Group_0__1__Impl rule__Instruction__Group_0__2
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0__1__Impl_in_rule__Instruction__Group_0__14560);
            rule__Instruction__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0__2_in_rule__Instruction__Group_0__14563);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1919:1: rule__Instruction__Group_0__1__Impl : ( ruleSequence ) ;
    public final void rule__Instruction__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1923:1: ( ( ruleSequence ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1924:1: ( ruleSequence )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1924:1: ( ruleSequence )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1925:1: ruleSequence
            {
             before(grammarAccess.getInstructionAccess().getSequenceParserRuleCall_0_1()); 
            pushFollow(FOLLOW_ruleSequence_in_rule__Instruction__Group_0__1__Impl4590);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1936:1: rule__Instruction__Group_0__2 : rule__Instruction__Group_0__2__Impl rule__Instruction__Group_0__3 ;
    public final void rule__Instruction__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1940:1: ( rule__Instruction__Group_0__2__Impl rule__Instruction__Group_0__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1941:2: rule__Instruction__Group_0__2__Impl rule__Instruction__Group_0__3
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0__2__Impl_in_rule__Instruction__Group_0__24619);
            rule__Instruction__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0__3_in_rule__Instruction__Group_0__24622);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1948:1: rule__Instruction__Group_0__2__Impl : ( ( rule__Instruction__Name2Assignment_0_2 ) ) ;
    public final void rule__Instruction__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1952:1: ( ( ( rule__Instruction__Name2Assignment_0_2 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1953:1: ( ( rule__Instruction__Name2Assignment_0_2 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1953:1: ( ( rule__Instruction__Name2Assignment_0_2 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1954:1: ( rule__Instruction__Name2Assignment_0_2 )
            {
             before(grammarAccess.getInstructionAccess().getName2Assignment_0_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1955:1: ( rule__Instruction__Name2Assignment_0_2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1955:2: rule__Instruction__Name2Assignment_0_2
            {
            pushFollow(FOLLOW_rule__Instruction__Name2Assignment_0_2_in_rule__Instruction__Group_0__2__Impl4649);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1965:1: rule__Instruction__Group_0__3 : rule__Instruction__Group_0__3__Impl ;
    public final void rule__Instruction__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1969:1: ( rule__Instruction__Group_0__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1970:2: rule__Instruction__Group_0__3__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0__3__Impl_in_rule__Instruction__Group_0__34679);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1976:1: rule__Instruction__Group_0__3__Impl : ( ( rule__Instruction__Group_0_3__0 )? ) ;
    public final void rule__Instruction__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1980:1: ( ( ( rule__Instruction__Group_0_3__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1981:1: ( ( rule__Instruction__Group_0_3__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1981:1: ( ( rule__Instruction__Group_0_3__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1982:1: ( rule__Instruction__Group_0_3__0 )?
            {
             before(grammarAccess.getInstructionAccess().getGroup_0_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1983:1: ( rule__Instruction__Group_0_3__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==161) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1983:2: rule__Instruction__Group_0_3__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_0_3__0_in_rule__Instruction__Group_0__3__Impl4706);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2001:1: rule__Instruction__Group_0_3__0 : rule__Instruction__Group_0_3__0__Impl rule__Instruction__Group_0_3__1 ;
    public final void rule__Instruction__Group_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2005:1: ( rule__Instruction__Group_0_3__0__Impl rule__Instruction__Group_0_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2006:2: rule__Instruction__Group_0_3__0__Impl rule__Instruction__Group_0_3__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_3__0__Impl_in_rule__Instruction__Group_0_3__04745);
            rule__Instruction__Group_0_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_3__1_in_rule__Instruction__Group_0_3__04748);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2013:1: rule__Instruction__Group_0_3__0__Impl : ( ':' ) ;
    public final void rule__Instruction__Group_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2017:1: ( ( ':' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2018:1: ( ':' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2018:1: ( ':' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2019:1: ':'
            {
             before(grammarAccess.getInstructionAccess().getColonKeyword_0_3_0()); 
            match(input,161,FOLLOW_161_in_rule__Instruction__Group_0_3__0__Impl4776); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2032:1: rule__Instruction__Group_0_3__1 : rule__Instruction__Group_0_3__1__Impl ;
    public final void rule__Instruction__Group_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2036:1: ( rule__Instruction__Group_0_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2037:2: rule__Instruction__Group_0_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_3__1__Impl_in_rule__Instruction__Group_0_3__14807);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2043:1: rule__Instruction__Group_0_3__1__Impl : ( RULE_ID ) ;
    public final void rule__Instruction__Group_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2047:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2048:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2048:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2049:1: RULE_ID
            {
             before(grammarAccess.getInstructionAccess().getIDTerminalRuleCall_0_3_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Instruction__Group_0_3__1__Impl4834); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2064:1: rule__Instruction__Group_3__0 : rule__Instruction__Group_3__0__Impl rule__Instruction__Group_3__1 ;
    public final void rule__Instruction__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2068:1: ( rule__Instruction__Group_3__0__Impl rule__Instruction__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2069:2: rule__Instruction__Group_3__0__Impl rule__Instruction__Group_3__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_3__0__Impl_in_rule__Instruction__Group_3__04867);
            rule__Instruction__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_3__1_in_rule__Instruction__Group_3__04870);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2076:1: rule__Instruction__Group_3__0__Impl : ( ruleDefinition ) ;
    public final void rule__Instruction__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2080:1: ( ( ruleDefinition ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2081:1: ( ruleDefinition )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2081:1: ( ruleDefinition )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2082:1: ruleDefinition
            {
             before(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDefinition_in_rule__Instruction__Group_3__0__Impl4897);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2093:1: rule__Instruction__Group_3__1 : rule__Instruction__Group_3__1__Impl ;
    public final void rule__Instruction__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2097:1: ( rule__Instruction__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2098:2: rule__Instruction__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_3__1__Impl_in_rule__Instruction__Group_3__14926);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2104:1: rule__Instruction__Group_3__1__Impl : ( ( ruleColor )? ) ;
    public final void rule__Instruction__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2108:1: ( ( ( ruleColor )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2109:1: ( ( ruleColor )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2109:1: ( ( ruleColor )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2110:1: ( ruleColor )?
            {
             before(grammarAccess.getInstructionAccess().getColorParserRuleCall_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2111:1: ( ruleColor )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==177) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2111:3: ruleColor
                    {
                    pushFollow(FOLLOW_ruleColor_in_rule__Instruction__Group_3__1__Impl4954);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2125:1: rule__Sequence__Group_0__0 : rule__Sequence__Group_0__0__Impl rule__Sequence__Group_0__1 ;
    public final void rule__Sequence__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2129:1: ( rule__Sequence__Group_0__0__Impl rule__Sequence__Group_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2130:2: rule__Sequence__Group_0__0__Impl rule__Sequence__Group_0__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_0__0__Impl_in_rule__Sequence__Group_0__04989);
            rule__Sequence__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_0__1_in_rule__Sequence__Group_0__04992);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2137:1: rule__Sequence__Group_0__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2141:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2142:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2142:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2143:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_0_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2144:1: ( '-' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==162) ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1==162) ) {
                        alt10=1;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2145:2: '-'
            	    {
            	    match(input,162,FOLLOW_162_in_rule__Sequence__Group_0__0__Impl5021); 

            	    }
            	    break;

            	default :
            	    break loop10;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2156:1: rule__Sequence__Group_0__1 : rule__Sequence__Group_0__1__Impl rule__Sequence__Group_0__2 ;
    public final void rule__Sequence__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2160:1: ( rule__Sequence__Group_0__1__Impl rule__Sequence__Group_0__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2161:2: rule__Sequence__Group_0__1__Impl rule__Sequence__Group_0__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_0__1__Impl_in_rule__Sequence__Group_0__15054);
            rule__Sequence__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_0__2_in_rule__Sequence__Group_0__15057);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2168:1: rule__Sequence__Group_0__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2172:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2173:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2173:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2174:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_0_1()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_0__1__Impl5085); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2187:1: rule__Sequence__Group_0__2 : rule__Sequence__Group_0__2__Impl ;
    public final void rule__Sequence__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2191:1: ( rule__Sequence__Group_0__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2192:2: rule__Sequence__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_0__2__Impl_in_rule__Sequence__Group_0__25116);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2198:1: rule__Sequence__Group_0__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2202:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2203:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2203:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2204:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_0_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_0__2__Impl5144); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2223:1: rule__Sequence__Group_1__0 : rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1 ;
    public final void rule__Sequence__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2227:1: ( rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2228:2: rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_1__0__Impl_in_rule__Sequence__Group_1__05181);
            rule__Sequence__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_1__1_in_rule__Sequence__Group_1__05184);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2235:1: rule__Sequence__Group_1__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2239:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2240:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2240:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2241:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_1_0()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_1__0__Impl5212); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2254:1: rule__Sequence__Group_1__1 : rule__Sequence__Group_1__1__Impl rule__Sequence__Group_1__2 ;
    public final void rule__Sequence__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2258:1: ( rule__Sequence__Group_1__1__Impl rule__Sequence__Group_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2259:2: rule__Sequence__Group_1__1__Impl rule__Sequence__Group_1__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_1__1__Impl_in_rule__Sequence__Group_1__15243);
            rule__Sequence__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_1__2_in_rule__Sequence__Group_1__15246);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2266:1: rule__Sequence__Group_1__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2270:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2271:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2271:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2272:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_1_1()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_1__1__Impl5274); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2285:1: rule__Sequence__Group_1__2 : rule__Sequence__Group_1__2__Impl ;
    public final void rule__Sequence__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2289:1: ( rule__Sequence__Group_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2290:2: rule__Sequence__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_1__2__Impl_in_rule__Sequence__Group_1__25305);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2296:1: rule__Sequence__Group_1__2__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2300:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2301:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2301:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2302:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_1_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2303:1: ( '-' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==162) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2304:2: '-'
            	    {
            	    match(input,162,FOLLOW_162_in_rule__Sequence__Group_1__2__Impl5334); 

            	    }
            	    break;

            	default :
            	    break loop11;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2321:1: rule__Sequence__Group_2__0 : rule__Sequence__Group_2__0__Impl rule__Sequence__Group_2__1 ;
    public final void rule__Sequence__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2325:1: ( rule__Sequence__Group_2__0__Impl rule__Sequence__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2326:2: rule__Sequence__Group_2__0__Impl rule__Sequence__Group_2__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_2__0__Impl_in_rule__Sequence__Group_2__05373);
            rule__Sequence__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_2__1_in_rule__Sequence__Group_2__05376);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2333:1: rule__Sequence__Group_2__0__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2337:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2338:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2338:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2339:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_2_0()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_2__0__Impl5404); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2352:1: rule__Sequence__Group_2__1 : rule__Sequence__Group_2__1__Impl rule__Sequence__Group_2__2 ;
    public final void rule__Sequence__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2356:1: ( rule__Sequence__Group_2__1__Impl rule__Sequence__Group_2__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2357:2: rule__Sequence__Group_2__1__Impl rule__Sequence__Group_2__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_2__1__Impl_in_rule__Sequence__Group_2__15435);
            rule__Sequence__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_2__2_in_rule__Sequence__Group_2__15438);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2364:1: rule__Sequence__Group_2__1__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2368:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2369:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2369:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2370:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_2_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_2__1__Impl5466); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2383:1: rule__Sequence__Group_2__2 : rule__Sequence__Group_2__2__Impl ;
    public final void rule__Sequence__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2387:1: ( rule__Sequence__Group_2__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2388:2: rule__Sequence__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_2__2__Impl_in_rule__Sequence__Group_2__25497);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2394:1: rule__Sequence__Group_2__2__Impl : ( 'x' ) ;
    public final void rule__Sequence__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2398:1: ( ( 'x' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2399:1: ( 'x' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2399:1: ( 'x' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2400:1: 'x'
            {
             before(grammarAccess.getSequenceAccess().getXKeyword_2_2()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_2__2__Impl5525); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2419:1: rule__Sequence__Group_3__0 : rule__Sequence__Group_3__0__Impl rule__Sequence__Group_3__1 ;
    public final void rule__Sequence__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2423:1: ( rule__Sequence__Group_3__0__Impl rule__Sequence__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2424:2: rule__Sequence__Group_3__0__Impl rule__Sequence__Group_3__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_3__0__Impl_in_rule__Sequence__Group_3__05562);
            rule__Sequence__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_3__1_in_rule__Sequence__Group_3__05565);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2431:1: rule__Sequence__Group_3__0__Impl : ( 'x' ) ;
    public final void rule__Sequence__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2435:1: ( ( 'x' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2436:1: ( 'x' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2436:1: ( 'x' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2437:1: 'x'
            {
             before(grammarAccess.getSequenceAccess().getXKeyword_3_0()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_3__0__Impl5593); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2450:1: rule__Sequence__Group_3__1 : rule__Sequence__Group_3__1__Impl rule__Sequence__Group_3__2 ;
    public final void rule__Sequence__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2454:1: ( rule__Sequence__Group_3__1__Impl rule__Sequence__Group_3__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2455:2: rule__Sequence__Group_3__1__Impl rule__Sequence__Group_3__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_3__1__Impl_in_rule__Sequence__Group_3__15624);
            rule__Sequence__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_3__2_in_rule__Sequence__Group_3__15627);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2462:1: rule__Sequence__Group_3__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2466:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2467:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2467:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2468:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_3_1()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_3__1__Impl5655); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2481:1: rule__Sequence__Group_3__2 : rule__Sequence__Group_3__2__Impl ;
    public final void rule__Sequence__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2485:1: ( rule__Sequence__Group_3__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2486:2: rule__Sequence__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_3__2__Impl_in_rule__Sequence__Group_3__25686);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2492:1: rule__Sequence__Group_3__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2496:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2497:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2497:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2498:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_3_2()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_3__2__Impl5714); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2517:1: rule__Sequence__Group_4__0 : rule__Sequence__Group_4__0__Impl rule__Sequence__Group_4__1 ;
    public final void rule__Sequence__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2521:1: ( rule__Sequence__Group_4__0__Impl rule__Sequence__Group_4__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2522:2: rule__Sequence__Group_4__0__Impl rule__Sequence__Group_4__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__0__Impl_in_rule__Sequence__Group_4__05751);
            rule__Sequence__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_4__1_in_rule__Sequence__Group_4__05754);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2529:1: rule__Sequence__Group_4__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2533:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2534:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2534:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2535:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_4_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2536:1: ( '-' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==162) ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1==162) ) {
                        alt12=1;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2537:2: '-'
            	    {
            	    match(input,162,FOLLOW_162_in_rule__Sequence__Group_4__0__Impl5783); 

            	    }
            	    break;

            	default :
            	    break loop12;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2548:1: rule__Sequence__Group_4__1 : rule__Sequence__Group_4__1__Impl rule__Sequence__Group_4__2 ;
    public final void rule__Sequence__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2552:1: ( rule__Sequence__Group_4__1__Impl rule__Sequence__Group_4__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2553:2: rule__Sequence__Group_4__1__Impl rule__Sequence__Group_4__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__1__Impl_in_rule__Sequence__Group_4__15816);
            rule__Sequence__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_4__2_in_rule__Sequence__Group_4__15819);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2560:1: rule__Sequence__Group_4__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2564:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2565:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2565:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2566:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_4_1()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_4__1__Impl5847); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2579:1: rule__Sequence__Group_4__2 : rule__Sequence__Group_4__2__Impl rule__Sequence__Group_4__3 ;
    public final void rule__Sequence__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2583:1: ( rule__Sequence__Group_4__2__Impl rule__Sequence__Group_4__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2584:2: rule__Sequence__Group_4__2__Impl rule__Sequence__Group_4__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__2__Impl_in_rule__Sequence__Group_4__25878);
            rule__Sequence__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_4__3_in_rule__Sequence__Group_4__25881);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2591:1: rule__Sequence__Group_4__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2595:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2596:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2596:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2597:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_4__2__Impl5909); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2610:1: rule__Sequence__Group_4__3 : rule__Sequence__Group_4__3__Impl ;
    public final void rule__Sequence__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2614:1: ( rule__Sequence__Group_4__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2615:2: rule__Sequence__Group_4__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__3__Impl_in_rule__Sequence__Group_4__35940);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2621:1: rule__Sequence__Group_4__3__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2625:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2626:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2626:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2627:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4_3()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_4__3__Impl5968); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2648:1: rule__Sequence__Group_5__0 : rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1 ;
    public final void rule__Sequence__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2652:1: ( rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2653:2: rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__0__Impl_in_rule__Sequence__Group_5__06007);
            rule__Sequence__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_5__1_in_rule__Sequence__Group_5__06010);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2660:1: rule__Sequence__Group_5__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2664:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2665:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2665:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2666:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_5_0()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_5__0__Impl6038); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2679:1: rule__Sequence__Group_5__1 : rule__Sequence__Group_5__1__Impl rule__Sequence__Group_5__2 ;
    public final void rule__Sequence__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2683:1: ( rule__Sequence__Group_5__1__Impl rule__Sequence__Group_5__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2684:2: rule__Sequence__Group_5__1__Impl rule__Sequence__Group_5__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__1__Impl_in_rule__Sequence__Group_5__16069);
            rule__Sequence__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_5__2_in_rule__Sequence__Group_5__16072);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2691:1: rule__Sequence__Group_5__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2695:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2696:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2696:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2697:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_5_1()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_5__1__Impl6100); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2710:1: rule__Sequence__Group_5__2 : rule__Sequence__Group_5__2__Impl rule__Sequence__Group_5__3 ;
    public final void rule__Sequence__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2714:1: ( rule__Sequence__Group_5__2__Impl rule__Sequence__Group_5__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2715:2: rule__Sequence__Group_5__2__Impl rule__Sequence__Group_5__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__2__Impl_in_rule__Sequence__Group_5__26131);
            rule__Sequence__Group_5__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_5__3_in_rule__Sequence__Group_5__26134);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2722:1: rule__Sequence__Group_5__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2726:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2727:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2727:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2728:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_5_2()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_5__2__Impl6162); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2741:1: rule__Sequence__Group_5__3 : rule__Sequence__Group_5__3__Impl ;
    public final void rule__Sequence__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2745:1: ( rule__Sequence__Group_5__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2746:2: rule__Sequence__Group_5__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__3__Impl_in_rule__Sequence__Group_5__36193);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2752:1: rule__Sequence__Group_5__3__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2756:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2757:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2757:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2758:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_5_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2759:1: ( '-' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==162) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2760:2: '-'
            	    {
            	    match(input,162,FOLLOW_162_in_rule__Sequence__Group_5__3__Impl6222); 

            	    }
            	    break;

            	default :
            	    break loop13;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2779:1: rule__Sequence__Group_6__0 : rule__Sequence__Group_6__0__Impl rule__Sequence__Group_6__1 ;
    public final void rule__Sequence__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2783:1: ( rule__Sequence__Group_6__0__Impl rule__Sequence__Group_6__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2784:2: rule__Sequence__Group_6__0__Impl rule__Sequence__Group_6__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__0__Impl_in_rule__Sequence__Group_6__06263);
            rule__Sequence__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_6__1_in_rule__Sequence__Group_6__06266);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2791:1: rule__Sequence__Group_6__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2795:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2796:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2796:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2797:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_6_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2798:1: ( '-' )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==162) ) {
                    int LA14_1 = input.LA(2);

                    if ( (LA14_1==162) ) {
                        alt14=1;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2799:2: '-'
            	    {
            	    match(input,162,FOLLOW_162_in_rule__Sequence__Group_6__0__Impl6295); 

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2810:1: rule__Sequence__Group_6__1 : rule__Sequence__Group_6__1__Impl rule__Sequence__Group_6__2 ;
    public final void rule__Sequence__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2814:1: ( rule__Sequence__Group_6__1__Impl rule__Sequence__Group_6__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2815:2: rule__Sequence__Group_6__1__Impl rule__Sequence__Group_6__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__1__Impl_in_rule__Sequence__Group_6__16328);
            rule__Sequence__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_6__2_in_rule__Sequence__Group_6__16331);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2822:1: rule__Sequence__Group_6__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2826:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2827:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2827:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2828:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_6_1()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_6__1__Impl6359); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2841:1: rule__Sequence__Group_6__2 : rule__Sequence__Group_6__2__Impl rule__Sequence__Group_6__3 ;
    public final void rule__Sequence__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2845:1: ( rule__Sequence__Group_6__2__Impl rule__Sequence__Group_6__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2846:2: rule__Sequence__Group_6__2__Impl rule__Sequence__Group_6__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__2__Impl_in_rule__Sequence__Group_6__26390);
            rule__Sequence__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_6__3_in_rule__Sequence__Group_6__26393);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2853:1: rule__Sequence__Group_6__2__Impl : ( '\\\\' ) ;
    public final void rule__Sequence__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2857:1: ( ( '\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2858:1: ( '\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2858:1: ( '\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2859:1: '\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusKeyword_6_2()); 
            match(input,166,FOLLOW_166_in_rule__Sequence__Group_6__2__Impl6421); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2872:1: rule__Sequence__Group_6__3 : rule__Sequence__Group_6__3__Impl ;
    public final void rule__Sequence__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2876:1: ( rule__Sequence__Group_6__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2877:2: rule__Sequence__Group_6__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__3__Impl_in_rule__Sequence__Group_6__36452);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2883:1: rule__Sequence__Group_6__3__Impl : ( '\\\\' ) ;
    public final void rule__Sequence__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2887:1: ( ( '\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2888:1: ( '\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2888:1: ( '\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2889:1: '\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusKeyword_6_3()); 
            match(input,166,FOLLOW_166_in_rule__Sequence__Group_6__3__Impl6480); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2910:1: rule__Sequence__Group_7__0 : rule__Sequence__Group_7__0__Impl rule__Sequence__Group_7__1 ;
    public final void rule__Sequence__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2914:1: ( rule__Sequence__Group_7__0__Impl rule__Sequence__Group_7__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2915:2: rule__Sequence__Group_7__0__Impl rule__Sequence__Group_7__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_7__0__Impl_in_rule__Sequence__Group_7__06519);
            rule__Sequence__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_7__1_in_rule__Sequence__Group_7__06522);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2922:1: rule__Sequence__Group_7__0__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2926:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2927:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2927:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2928:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_7_0()); 
            match(input,167,FOLLOW_167_in_rule__Sequence__Group_7__0__Impl6550); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2941:1: rule__Sequence__Group_7__1 : rule__Sequence__Group_7__1__Impl rule__Sequence__Group_7__2 ;
    public final void rule__Sequence__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2945:1: ( rule__Sequence__Group_7__1__Impl rule__Sequence__Group_7__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2946:2: rule__Sequence__Group_7__1__Impl rule__Sequence__Group_7__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_7__1__Impl_in_rule__Sequence__Group_7__16581);
            rule__Sequence__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_7__2_in_rule__Sequence__Group_7__16584);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2953:1: rule__Sequence__Group_7__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2957:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2958:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2958:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2959:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_7_1()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_7__1__Impl6612); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2972:1: rule__Sequence__Group_7__2 : rule__Sequence__Group_7__2__Impl ;
    public final void rule__Sequence__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2976:1: ( rule__Sequence__Group_7__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2977:2: rule__Sequence__Group_7__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_7__2__Impl_in_rule__Sequence__Group_7__26643);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2983:1: rule__Sequence__Group_7__2__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2987:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2988:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2988:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2989:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_7_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2990:1: ( '-' )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==162) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2991:2: '-'
            	    {
            	    match(input,162,FOLLOW_162_in_rule__Sequence__Group_7__2__Impl6672); 

            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3008:1: rule__Sequence__Group_8__0 : rule__Sequence__Group_8__0__Impl rule__Sequence__Group_8__1 ;
    public final void rule__Sequence__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3012:1: ( rule__Sequence__Group_8__0__Impl rule__Sequence__Group_8__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3013:2: rule__Sequence__Group_8__0__Impl rule__Sequence__Group_8__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_8__0__Impl_in_rule__Sequence__Group_8__06711);
            rule__Sequence__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_8__1_in_rule__Sequence__Group_8__06714);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3020:1: rule__Sequence__Group_8__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3024:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3025:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3025:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3026:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_8_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3027:1: ( '-' )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==162) ) {
                    int LA16_1 = input.LA(2);

                    if ( (LA16_1==162) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3028:2: '-'
            	    {
            	    match(input,162,FOLLOW_162_in_rule__Sequence__Group_8__0__Impl6743); 

            	    }
            	    break;

            	default :
            	    break loop16;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3039:1: rule__Sequence__Group_8__1 : rule__Sequence__Group_8__1__Impl rule__Sequence__Group_8__2 ;
    public final void rule__Sequence__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3043:1: ( rule__Sequence__Group_8__1__Impl rule__Sequence__Group_8__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3044:2: rule__Sequence__Group_8__1__Impl rule__Sequence__Group_8__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_8__1__Impl_in_rule__Sequence__Group_8__16776);
            rule__Sequence__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_8__2_in_rule__Sequence__Group_8__16779);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3051:1: rule__Sequence__Group_8__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3055:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3056:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3056:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3057:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_8_1()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_8__1__Impl6807); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3070:1: rule__Sequence__Group_8__2 : rule__Sequence__Group_8__2__Impl ;
    public final void rule__Sequence__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3074:1: ( rule__Sequence__Group_8__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3075:2: rule__Sequence__Group_8__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_8__2__Impl_in_rule__Sequence__Group_8__26838);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3081:1: rule__Sequence__Group_8__2__Impl : ( '\\\\\\\\' ) ;
    public final void rule__Sequence__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3085:1: ( ( '\\\\\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3086:1: ( '\\\\\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3086:1: ( '\\\\\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3087:1: '\\\\\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusReverseSolidusKeyword_8_2()); 
            match(input,168,FOLLOW_168_in_rule__Sequence__Group_8__2__Impl6866); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3106:1: rule__Sequence__Group_9__0 : rule__Sequence__Group_9__0__Impl rule__Sequence__Group_9__1 ;
    public final void rule__Sequence__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3110:1: ( rule__Sequence__Group_9__0__Impl rule__Sequence__Group_9__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3111:2: rule__Sequence__Group_9__0__Impl rule__Sequence__Group_9__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__0__Impl_in_rule__Sequence__Group_9__06903);
            rule__Sequence__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_9__1_in_rule__Sequence__Group_9__06906);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3118:1: rule__Sequence__Group_9__0__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3122:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3123:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3123:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3124:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_9_0()); 
            match(input,167,FOLLOW_167_in_rule__Sequence__Group_9__0__Impl6934); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3137:1: rule__Sequence__Group_9__1 : rule__Sequence__Group_9__1__Impl rule__Sequence__Group_9__2 ;
    public final void rule__Sequence__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3141:1: ( rule__Sequence__Group_9__1__Impl rule__Sequence__Group_9__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3142:2: rule__Sequence__Group_9__1__Impl rule__Sequence__Group_9__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__1__Impl_in_rule__Sequence__Group_9__16965);
            rule__Sequence__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_9__2_in_rule__Sequence__Group_9__16968);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3149:1: rule__Sequence__Group_9__1__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3153:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3154:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3154:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3155:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_9_1()); 
            match(input,167,FOLLOW_167_in_rule__Sequence__Group_9__1__Impl6996); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3168:1: rule__Sequence__Group_9__2 : rule__Sequence__Group_9__2__Impl rule__Sequence__Group_9__3 ;
    public final void rule__Sequence__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3172:1: ( rule__Sequence__Group_9__2__Impl rule__Sequence__Group_9__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3173:2: rule__Sequence__Group_9__2__Impl rule__Sequence__Group_9__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__2__Impl_in_rule__Sequence__Group_9__27027);
            rule__Sequence__Group_9__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_9__3_in_rule__Sequence__Group_9__27030);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3180:1: rule__Sequence__Group_9__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3184:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3185:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3185:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3186:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_9_2()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_9__2__Impl7058); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3199:1: rule__Sequence__Group_9__3 : rule__Sequence__Group_9__3__Impl ;
    public final void rule__Sequence__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3203:1: ( rule__Sequence__Group_9__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3204:2: rule__Sequence__Group_9__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__3__Impl_in_rule__Sequence__Group_9__37089);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3210:1: rule__Sequence__Group_9__3__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3214:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3215:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3215:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3216:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_9_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3217:1: ( '-' )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==162) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3218:2: '-'
            	    {
            	    match(input,162,FOLLOW_162_in_rule__Sequence__Group_9__3__Impl7118); 

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3237:1: rule__Sequence__Group_10__0 : rule__Sequence__Group_10__0__Impl rule__Sequence__Group_10__1 ;
    public final void rule__Sequence__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3241:1: ( rule__Sequence__Group_10__0__Impl rule__Sequence__Group_10__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3242:2: rule__Sequence__Group_10__0__Impl rule__Sequence__Group_10__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__0__Impl_in_rule__Sequence__Group_10__07159);
            rule__Sequence__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_10__1_in_rule__Sequence__Group_10__07162);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3249:1: rule__Sequence__Group_10__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3253:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3254:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3254:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3255:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_10_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3256:1: ( '-' )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==162) ) {
                    int LA18_1 = input.LA(2);

                    if ( (LA18_1==162) ) {
                        alt18=1;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3257:2: '-'
            	    {
            	    match(input,162,FOLLOW_162_in_rule__Sequence__Group_10__0__Impl7191); 

            	    }
            	    break;

            	default :
            	    break loop18;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3268:1: rule__Sequence__Group_10__1 : rule__Sequence__Group_10__1__Impl rule__Sequence__Group_10__2 ;
    public final void rule__Sequence__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3272:1: ( rule__Sequence__Group_10__1__Impl rule__Sequence__Group_10__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3273:2: rule__Sequence__Group_10__1__Impl rule__Sequence__Group_10__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__1__Impl_in_rule__Sequence__Group_10__17224);
            rule__Sequence__Group_10__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_10__2_in_rule__Sequence__Group_10__17227);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3280:1: rule__Sequence__Group_10__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3284:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3285:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3285:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3286:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_10_1()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_10__1__Impl7255); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3299:1: rule__Sequence__Group_10__2 : rule__Sequence__Group_10__2__Impl rule__Sequence__Group_10__3 ;
    public final void rule__Sequence__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3303:1: ( rule__Sequence__Group_10__2__Impl rule__Sequence__Group_10__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3304:2: rule__Sequence__Group_10__2__Impl rule__Sequence__Group_10__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__2__Impl_in_rule__Sequence__Group_10__27286);
            rule__Sequence__Group_10__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_10__3_in_rule__Sequence__Group_10__27289);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3311:1: rule__Sequence__Group_10__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3315:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3316:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3316:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3317:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_10_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_10__2__Impl7317); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3330:1: rule__Sequence__Group_10__3 : rule__Sequence__Group_10__3__Impl ;
    public final void rule__Sequence__Group_10__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3334:1: ( rule__Sequence__Group_10__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3335:2: rule__Sequence__Group_10__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__3__Impl_in_rule__Sequence__Group_10__37348);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3341:1: rule__Sequence__Group_10__3__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_10__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3345:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3346:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3346:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3347:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_10_3()); 
            match(input,169,FOLLOW_169_in_rule__Sequence__Group_10__3__Impl7376); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3368:1: rule__Sequence__Group_11__0 : rule__Sequence__Group_11__0__Impl rule__Sequence__Group_11__1 ;
    public final void rule__Sequence__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3372:1: ( rule__Sequence__Group_11__0__Impl rule__Sequence__Group_11__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3373:2: rule__Sequence__Group_11__0__Impl rule__Sequence__Group_11__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__0__Impl_in_rule__Sequence__Group_11__07415);
            rule__Sequence__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_11__1_in_rule__Sequence__Group_11__07418);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3380:1: rule__Sequence__Group_11__0__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3384:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3385:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3385:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3386:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_11_0()); 
            match(input,169,FOLLOW_169_in_rule__Sequence__Group_11__0__Impl7446); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3399:1: rule__Sequence__Group_11__1 : rule__Sequence__Group_11__1__Impl rule__Sequence__Group_11__2 ;
    public final void rule__Sequence__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3403:1: ( rule__Sequence__Group_11__1__Impl rule__Sequence__Group_11__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3404:2: rule__Sequence__Group_11__1__Impl rule__Sequence__Group_11__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__1__Impl_in_rule__Sequence__Group_11__17477);
            rule__Sequence__Group_11__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_11__2_in_rule__Sequence__Group_11__17480);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3411:1: rule__Sequence__Group_11__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3415:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3416:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3416:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3417:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_11_1()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_11__1__Impl7508); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3430:1: rule__Sequence__Group_11__2 : rule__Sequence__Group_11__2__Impl rule__Sequence__Group_11__3 ;
    public final void rule__Sequence__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3434:1: ( rule__Sequence__Group_11__2__Impl rule__Sequence__Group_11__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3435:2: rule__Sequence__Group_11__2__Impl rule__Sequence__Group_11__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__2__Impl_in_rule__Sequence__Group_11__27539);
            rule__Sequence__Group_11__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_11__3_in_rule__Sequence__Group_11__27542);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3442:1: rule__Sequence__Group_11__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3446:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3447:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3447:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3448:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_11_2()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_11__2__Impl7570); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3461:1: rule__Sequence__Group_11__3 : rule__Sequence__Group_11__3__Impl ;
    public final void rule__Sequence__Group_11__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3465:1: ( rule__Sequence__Group_11__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3466:2: rule__Sequence__Group_11__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__3__Impl_in_rule__Sequence__Group_11__37601);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3472:1: rule__Sequence__Group_11__3__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_11__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3476:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3477:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3477:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3478:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_11_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3479:1: ( '-' )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==162) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3480:2: '-'
            	    {
            	    match(input,162,FOLLOW_162_in_rule__Sequence__Group_11__3__Impl7630); 

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3499:1: rule__Sequence__Group_12__0 : rule__Sequence__Group_12__0__Impl rule__Sequence__Group_12__1 ;
    public final void rule__Sequence__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3503:1: ( rule__Sequence__Group_12__0__Impl rule__Sequence__Group_12__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3504:2: rule__Sequence__Group_12__0__Impl rule__Sequence__Group_12__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__0__Impl_in_rule__Sequence__Group_12__07671);
            rule__Sequence__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__1_in_rule__Sequence__Group_12__07674);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3511:1: rule__Sequence__Group_12__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3515:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3516:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3516:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3517:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3518:1: ( '-' )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==162) ) {
                    int LA20_1 = input.LA(2);

                    if ( (LA20_1==162) ) {
                        int LA20_2 = input.LA(3);

                        if ( (LA20_2==162) ) {
                            alt20=1;
                        }


                    }


                }


                switch (alt20) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3519:2: '-'
            	    {
            	    match(input,162,FOLLOW_162_in_rule__Sequence__Group_12__0__Impl7703); 

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3530:1: rule__Sequence__Group_12__1 : rule__Sequence__Group_12__1__Impl rule__Sequence__Group_12__2 ;
    public final void rule__Sequence__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3534:1: ( rule__Sequence__Group_12__1__Impl rule__Sequence__Group_12__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3535:2: rule__Sequence__Group_12__1__Impl rule__Sequence__Group_12__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__1__Impl_in_rule__Sequence__Group_12__17736);
            rule__Sequence__Group_12__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__2_in_rule__Sequence__Group_12__17739);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3542:1: rule__Sequence__Group_12__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3546:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3547:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3547:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3548:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_1()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_12__1__Impl7767); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3561:1: rule__Sequence__Group_12__2 : rule__Sequence__Group_12__2__Impl rule__Sequence__Group_12__3 ;
    public final void rule__Sequence__Group_12__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3565:1: ( rule__Sequence__Group_12__2__Impl rule__Sequence__Group_12__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3566:2: rule__Sequence__Group_12__2__Impl rule__Sequence__Group_12__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__2__Impl_in_rule__Sequence__Group_12__27798);
            rule__Sequence__Group_12__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__3_in_rule__Sequence__Group_12__27801);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3573:1: rule__Sequence__Group_12__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_12__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3577:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3578:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3578:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3579:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_2()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_12__2__Impl7829); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3592:1: rule__Sequence__Group_12__3 : rule__Sequence__Group_12__3__Impl rule__Sequence__Group_12__4 ;
    public final void rule__Sequence__Group_12__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3596:1: ( rule__Sequence__Group_12__3__Impl rule__Sequence__Group_12__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3597:2: rule__Sequence__Group_12__3__Impl rule__Sequence__Group_12__4
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__3__Impl_in_rule__Sequence__Group_12__37860);
            rule__Sequence__Group_12__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__4_in_rule__Sequence__Group_12__37863);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3604:1: rule__Sequence__Group_12__3__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_12__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3608:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3609:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3609:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3610:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_12_3()); 
            match(input,167,FOLLOW_167_in_rule__Sequence__Group_12__3__Impl7891); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3623:1: rule__Sequence__Group_12__4 : rule__Sequence__Group_12__4__Impl rule__Sequence__Group_12__5 ;
    public final void rule__Sequence__Group_12__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3627:1: ( rule__Sequence__Group_12__4__Impl rule__Sequence__Group_12__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3628:2: rule__Sequence__Group_12__4__Impl rule__Sequence__Group_12__5
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__4__Impl_in_rule__Sequence__Group_12__47922);
            rule__Sequence__Group_12__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__5_in_rule__Sequence__Group_12__47925);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3635:1: rule__Sequence__Group_12__4__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_12__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3639:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3640:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3640:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3641:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_12_4()); 
            match(input,167,FOLLOW_167_in_rule__Sequence__Group_12__4__Impl7953); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3654:1: rule__Sequence__Group_12__5 : rule__Sequence__Group_12__5__Impl ;
    public final void rule__Sequence__Group_12__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3658:1: ( rule__Sequence__Group_12__5__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3659:2: rule__Sequence__Group_12__5__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__5__Impl_in_rule__Sequence__Group_12__57984);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3665:1: rule__Sequence__Group_12__5__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_12__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3669:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3670:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3670:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3671:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_12_5()); 
            match(input,169,FOLLOW_169_in_rule__Sequence__Group_12__5__Impl8012); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3696:1: rule__Sequence__Group_13__0 : rule__Sequence__Group_13__0__Impl rule__Sequence__Group_13__1 ;
    public final void rule__Sequence__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3700:1: ( rule__Sequence__Group_13__0__Impl rule__Sequence__Group_13__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3701:2: rule__Sequence__Group_13__0__Impl rule__Sequence__Group_13__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__0__Impl_in_rule__Sequence__Group_13__08055);
            rule__Sequence__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__1_in_rule__Sequence__Group_13__08058);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3708:1: rule__Sequence__Group_13__0__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3712:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3713:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3713:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3714:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_13_0()); 
            match(input,169,FOLLOW_169_in_rule__Sequence__Group_13__0__Impl8086); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3727:1: rule__Sequence__Group_13__1 : rule__Sequence__Group_13__1__Impl rule__Sequence__Group_13__2 ;
    public final void rule__Sequence__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3731:1: ( rule__Sequence__Group_13__1__Impl rule__Sequence__Group_13__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3732:2: rule__Sequence__Group_13__1__Impl rule__Sequence__Group_13__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__1__Impl_in_rule__Sequence__Group_13__18117);
            rule__Sequence__Group_13__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__2_in_rule__Sequence__Group_13__18120);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3739:1: rule__Sequence__Group_13__1__Impl : ( '\\\\\\\\' ) ;
    public final void rule__Sequence__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3743:1: ( ( '\\\\\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3744:1: ( '\\\\\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3744:1: ( '\\\\\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3745:1: '\\\\\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusReverseSolidusKeyword_13_1()); 
            match(input,168,FOLLOW_168_in_rule__Sequence__Group_13__1__Impl8148); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3758:1: rule__Sequence__Group_13__2 : rule__Sequence__Group_13__2__Impl rule__Sequence__Group_13__3 ;
    public final void rule__Sequence__Group_13__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3762:1: ( rule__Sequence__Group_13__2__Impl rule__Sequence__Group_13__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3763:2: rule__Sequence__Group_13__2__Impl rule__Sequence__Group_13__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__2__Impl_in_rule__Sequence__Group_13__28179);
            rule__Sequence__Group_13__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__3_in_rule__Sequence__Group_13__28182);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3770:1: rule__Sequence__Group_13__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_13__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3774:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3775:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3775:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3776:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_2()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_13__2__Impl8210); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3789:1: rule__Sequence__Group_13__3 : rule__Sequence__Group_13__3__Impl rule__Sequence__Group_13__4 ;
    public final void rule__Sequence__Group_13__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3793:1: ( rule__Sequence__Group_13__3__Impl rule__Sequence__Group_13__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3794:2: rule__Sequence__Group_13__3__Impl rule__Sequence__Group_13__4
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__3__Impl_in_rule__Sequence__Group_13__38241);
            rule__Sequence__Group_13__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__4_in_rule__Sequence__Group_13__38244);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3801:1: rule__Sequence__Group_13__3__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_13__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3805:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3806:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3806:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3807:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_3()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_13__3__Impl8272); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3820:1: rule__Sequence__Group_13__4 : rule__Sequence__Group_13__4__Impl ;
    public final void rule__Sequence__Group_13__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3824:1: ( rule__Sequence__Group_13__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3825:2: rule__Sequence__Group_13__4__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__4__Impl_in_rule__Sequence__Group_13__48303);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3831:1: rule__Sequence__Group_13__4__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_13__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3835:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3836:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3836:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3837:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3838:1: ( '-' )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==162) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3839:2: '-'
            	    {
            	    match(input,162,FOLLOW_162_in_rule__Sequence__Group_13__4__Impl8332); 

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3860:1: rule__Sequence__Group_14__0 : rule__Sequence__Group_14__0__Impl rule__Sequence__Group_14__1 ;
    public final void rule__Sequence__Group_14__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3864:1: ( rule__Sequence__Group_14__0__Impl rule__Sequence__Group_14__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3865:2: rule__Sequence__Group_14__0__Impl rule__Sequence__Group_14__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_14__0__Impl_in_rule__Sequence__Group_14__08375);
            rule__Sequence__Group_14__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_14__1_in_rule__Sequence__Group_14__08378);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3872:1: rule__Sequence__Group_14__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_14__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3876:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3877:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3877:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3878:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_14_0()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_14__0__Impl8406); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3891:1: rule__Sequence__Group_14__1 : rule__Sequence__Group_14__1__Impl rule__Sequence__Group_14__2 ;
    public final void rule__Sequence__Group_14__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3895:1: ( rule__Sequence__Group_14__1__Impl rule__Sequence__Group_14__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3896:2: rule__Sequence__Group_14__1__Impl rule__Sequence__Group_14__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_14__1__Impl_in_rule__Sequence__Group_14__18437);
            rule__Sequence__Group_14__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_14__2_in_rule__Sequence__Group_14__18440);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3903:1: rule__Sequence__Group_14__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_14__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3907:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3908:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3908:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3909:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_14_1()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_14__1__Impl8468); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3922:1: rule__Sequence__Group_14__2 : rule__Sequence__Group_14__2__Impl ;
    public final void rule__Sequence__Group_14__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3926:1: ( rule__Sequence__Group_14__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3927:2: rule__Sequence__Group_14__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_14__2__Impl_in_rule__Sequence__Group_14__28499);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3933:1: rule__Sequence__Group_14__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_14__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3937:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3938:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3938:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3939:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_14_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_14__2__Impl8527); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3958:1: rule__Sequence__Group_15__0 : rule__Sequence__Group_15__0__Impl rule__Sequence__Group_15__1 ;
    public final void rule__Sequence__Group_15__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3962:1: ( rule__Sequence__Group_15__0__Impl rule__Sequence__Group_15__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3963:2: rule__Sequence__Group_15__0__Impl rule__Sequence__Group_15__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__0__Impl_in_rule__Sequence__Group_15__08564);
            rule__Sequence__Group_15__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_15__1_in_rule__Sequence__Group_15__08567);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3970:1: rule__Sequence__Group_15__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_15__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3974:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3975:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3975:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3976:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_15_0()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_15__0__Impl8595); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3989:1: rule__Sequence__Group_15__1 : rule__Sequence__Group_15__1__Impl rule__Sequence__Group_15__2 ;
    public final void rule__Sequence__Group_15__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3993:1: ( rule__Sequence__Group_15__1__Impl rule__Sequence__Group_15__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3994:2: rule__Sequence__Group_15__1__Impl rule__Sequence__Group_15__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__1__Impl_in_rule__Sequence__Group_15__18626);
            rule__Sequence__Group_15__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_15__2_in_rule__Sequence__Group_15__18629);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4001:1: rule__Sequence__Group_15__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_15__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4005:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4006:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4006:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4007:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_15_1()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_15__1__Impl8657); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4020:1: rule__Sequence__Group_15__2 : rule__Sequence__Group_15__2__Impl rule__Sequence__Group_15__3 ;
    public final void rule__Sequence__Group_15__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4024:1: ( rule__Sequence__Group_15__2__Impl rule__Sequence__Group_15__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4025:2: rule__Sequence__Group_15__2__Impl rule__Sequence__Group_15__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__2__Impl_in_rule__Sequence__Group_15__28688);
            rule__Sequence__Group_15__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_15__3_in_rule__Sequence__Group_15__28691);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4032:1: rule__Sequence__Group_15__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_15__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4036:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4037:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4037:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4038:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_15_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_15__2__Impl8719); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4051:1: rule__Sequence__Group_15__3 : rule__Sequence__Group_15__3__Impl ;
    public final void rule__Sequence__Group_15__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4055:1: ( rule__Sequence__Group_15__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4056:2: rule__Sequence__Group_15__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__3__Impl_in_rule__Sequence__Group_15__38750);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4062:1: rule__Sequence__Group_15__3__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_15__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4066:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4067:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4067:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4068:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_15_3()); 
            match(input,169,FOLLOW_169_in_rule__Sequence__Group_15__3__Impl8778); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4089:1: rule__Sequence__Group_16__0 : rule__Sequence__Group_16__0__Impl rule__Sequence__Group_16__1 ;
    public final void rule__Sequence__Group_16__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4093:1: ( rule__Sequence__Group_16__0__Impl rule__Sequence__Group_16__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4094:2: rule__Sequence__Group_16__0__Impl rule__Sequence__Group_16__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__0__Impl_in_rule__Sequence__Group_16__08817);
            rule__Sequence__Group_16__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_16__1_in_rule__Sequence__Group_16__08820);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4101:1: rule__Sequence__Group_16__0__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_16__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4105:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4106:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4106:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4107:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_16_0()); 
            match(input,169,FOLLOW_169_in_rule__Sequence__Group_16__0__Impl8848); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4120:1: rule__Sequence__Group_16__1 : rule__Sequence__Group_16__1__Impl rule__Sequence__Group_16__2 ;
    public final void rule__Sequence__Group_16__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4124:1: ( rule__Sequence__Group_16__1__Impl rule__Sequence__Group_16__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4125:2: rule__Sequence__Group_16__1__Impl rule__Sequence__Group_16__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__1__Impl_in_rule__Sequence__Group_16__18879);
            rule__Sequence__Group_16__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_16__2_in_rule__Sequence__Group_16__18882);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4132:1: rule__Sequence__Group_16__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_16__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4136:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4137:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4137:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4138:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_16_1()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_16__1__Impl8910); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4151:1: rule__Sequence__Group_16__2 : rule__Sequence__Group_16__2__Impl rule__Sequence__Group_16__3 ;
    public final void rule__Sequence__Group_16__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4155:1: ( rule__Sequence__Group_16__2__Impl rule__Sequence__Group_16__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4156:2: rule__Sequence__Group_16__2__Impl rule__Sequence__Group_16__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__2__Impl_in_rule__Sequence__Group_16__28941);
            rule__Sequence__Group_16__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_16__3_in_rule__Sequence__Group_16__28944);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4163:1: rule__Sequence__Group_16__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_16__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4167:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4168:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4168:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4169:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_16_2()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_16__2__Impl8972); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4182:1: rule__Sequence__Group_16__3 : rule__Sequence__Group_16__3__Impl ;
    public final void rule__Sequence__Group_16__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4186:1: ( rule__Sequence__Group_16__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4187:2: rule__Sequence__Group_16__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__3__Impl_in_rule__Sequence__Group_16__39003);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4193:1: rule__Sequence__Group_16__3__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_16__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4197:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4198:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4198:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4199:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_16_3()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_16__3__Impl9031); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4220:1: rule__Sequence__Group_17__0 : rule__Sequence__Group_17__0__Impl rule__Sequence__Group_17__1 ;
    public final void rule__Sequence__Group_17__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4224:1: ( rule__Sequence__Group_17__0__Impl rule__Sequence__Group_17__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4225:2: rule__Sequence__Group_17__0__Impl rule__Sequence__Group_17__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__0__Impl_in_rule__Sequence__Group_17__09070);
            rule__Sequence__Group_17__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_17__1_in_rule__Sequence__Group_17__09073);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4232:1: rule__Sequence__Group_17__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_17__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4236:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4237:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4237:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4238:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_17_0()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_17__0__Impl9101); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4251:1: rule__Sequence__Group_17__1 : rule__Sequence__Group_17__1__Impl rule__Sequence__Group_17__2 ;
    public final void rule__Sequence__Group_17__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4255:1: ( rule__Sequence__Group_17__1__Impl rule__Sequence__Group_17__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4256:2: rule__Sequence__Group_17__1__Impl rule__Sequence__Group_17__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__1__Impl_in_rule__Sequence__Group_17__19132);
            rule__Sequence__Group_17__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_17__2_in_rule__Sequence__Group_17__19135);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4263:1: rule__Sequence__Group_17__1__Impl : ( '|' ) ;
    public final void rule__Sequence__Group_17__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4267:1: ( ( '|' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4268:1: ( '|' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4268:1: ( '|' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4269:1: '|'
            {
             before(grammarAccess.getSequenceAccess().getVerticalLineKeyword_17_1()); 
            match(input,170,FOLLOW_170_in_rule__Sequence__Group_17__1__Impl9163); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4282:1: rule__Sequence__Group_17__2 : rule__Sequence__Group_17__2__Impl rule__Sequence__Group_17__3 ;
    public final void rule__Sequence__Group_17__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4286:1: ( rule__Sequence__Group_17__2__Impl rule__Sequence__Group_17__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4287:2: rule__Sequence__Group_17__2__Impl rule__Sequence__Group_17__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__2__Impl_in_rule__Sequence__Group_17__29194);
            rule__Sequence__Group_17__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_17__3_in_rule__Sequence__Group_17__29197);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4294:1: rule__Sequence__Group_17__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_17__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4298:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4299:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4299:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4300:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_17_2()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_17__2__Impl9225); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4313:1: rule__Sequence__Group_17__3 : rule__Sequence__Group_17__3__Impl ;
    public final void rule__Sequence__Group_17__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4317:1: ( rule__Sequence__Group_17__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4318:2: rule__Sequence__Group_17__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__3__Impl_in_rule__Sequence__Group_17__39256);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4324:1: rule__Sequence__Group_17__3__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_17__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4328:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4329:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4329:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4330:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_17_3()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_17__3__Impl9284); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4351:1: rule__Sequence__Group_18__0 : rule__Sequence__Group_18__0__Impl rule__Sequence__Group_18__1 ;
    public final void rule__Sequence__Group_18__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4355:1: ( rule__Sequence__Group_18__0__Impl rule__Sequence__Group_18__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4356:2: rule__Sequence__Group_18__0__Impl rule__Sequence__Group_18__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__0__Impl_in_rule__Sequence__Group_18__09323);
            rule__Sequence__Group_18__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_18__1_in_rule__Sequence__Group_18__09326);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4363:1: rule__Sequence__Group_18__0__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_18__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4367:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4368:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4368:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4369:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_18_0()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_18__0__Impl9354); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4382:1: rule__Sequence__Group_18__1 : rule__Sequence__Group_18__1__Impl rule__Sequence__Group_18__2 ;
    public final void rule__Sequence__Group_18__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4386:1: ( rule__Sequence__Group_18__1__Impl rule__Sequence__Group_18__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4387:2: rule__Sequence__Group_18__1__Impl rule__Sequence__Group_18__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__1__Impl_in_rule__Sequence__Group_18__19385);
            rule__Sequence__Group_18__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_18__2_in_rule__Sequence__Group_18__19388);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4394:1: rule__Sequence__Group_18__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_18__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4398:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4399:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4399:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4400:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_18_1()); 
            match(input,162,FOLLOW_162_in_rule__Sequence__Group_18__1__Impl9416); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4413:1: rule__Sequence__Group_18__2 : rule__Sequence__Group_18__2__Impl rule__Sequence__Group_18__3 ;
    public final void rule__Sequence__Group_18__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4417:1: ( rule__Sequence__Group_18__2__Impl rule__Sequence__Group_18__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4418:2: rule__Sequence__Group_18__2__Impl rule__Sequence__Group_18__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__2__Impl_in_rule__Sequence__Group_18__29447);
            rule__Sequence__Group_18__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_18__3_in_rule__Sequence__Group_18__29450);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4425:1: rule__Sequence__Group_18__2__Impl : ( '|' ) ;
    public final void rule__Sequence__Group_18__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4429:1: ( ( '|' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4430:1: ( '|' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4430:1: ( '|' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4431:1: '|'
            {
             before(grammarAccess.getSequenceAccess().getVerticalLineKeyword_18_2()); 
            match(input,170,FOLLOW_170_in_rule__Sequence__Group_18__2__Impl9478); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4444:1: rule__Sequence__Group_18__3 : rule__Sequence__Group_18__3__Impl ;
    public final void rule__Sequence__Group_18__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4448:1: ( rule__Sequence__Group_18__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4449:2: rule__Sequence__Group_18__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__3__Impl_in_rule__Sequence__Group_18__39509);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4455:1: rule__Sequence__Group_18__3__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_18__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4459:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4460:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4460:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4461:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_18_3()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_18__3__Impl9537); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4482:1: rule__Sequence__Group_19__0 : rule__Sequence__Group_19__0__Impl rule__Sequence__Group_19__1 ;
    public final void rule__Sequence__Group_19__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4486:1: ( rule__Sequence__Group_19__0__Impl rule__Sequence__Group_19__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4487:2: rule__Sequence__Group_19__0__Impl rule__Sequence__Group_19__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_19__0__Impl_in_rule__Sequence__Group_19__09576);
            rule__Sequence__Group_19__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_19__1_in_rule__Sequence__Group_19__09579);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4494:1: rule__Sequence__Group_19__0__Impl : ( '.' ) ;
    public final void rule__Sequence__Group_19__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4498:1: ( ( '.' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4499:1: ( '.' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4499:1: ( '.' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4500:1: '.'
            {
             before(grammarAccess.getSequenceAccess().getFullStopKeyword_19_0()); 
            match(input,10,FOLLOW_10_in_rule__Sequence__Group_19__0__Impl9607); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4513:1: rule__Sequence__Group_19__1 : rule__Sequence__Group_19__1__Impl ;
    public final void rule__Sequence__Group_19__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4517:1: ( rule__Sequence__Group_19__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4518:2: rule__Sequence__Group_19__1__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_19__1__Impl_in_rule__Sequence__Group_19__19638);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4524:1: rule__Sequence__Group_19__1__Impl : ( '.' ) ;
    public final void rule__Sequence__Group_19__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4528:1: ( ( '.' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4529:1: ( '.' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4529:1: ( '.' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4530:1: '.'
            {
             before(grammarAccess.getSequenceAccess().getFullStopKeyword_19_1()); 
            match(input,10,FOLLOW_10_in_rule__Sequence__Group_19__1__Impl9666); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4547:1: rule__Definition__Group_0__0 : rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 ;
    public final void rule__Definition__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4551:1: ( rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4552:2: rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__09701);
            rule__Definition__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__09704);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4559:1: rule__Definition__Group_0__0__Impl : ( 'actor' ) ;
    public final void rule__Definition__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4563:1: ( ( 'actor' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4564:1: ( 'actor' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4564:1: ( 'actor' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4565:1: 'actor'
            {
             before(grammarAccess.getDefinitionAccess().getActorKeyword_0_0()); 
            match(input,171,FOLLOW_171_in_rule__Definition__Group_0__0__Impl9732); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4578:1: rule__Definition__Group_0__1 : rule__Definition__Group_0__1__Impl ;
    public final void rule__Definition__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4582:1: ( rule__Definition__Group_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4583:2: rule__Definition__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__19763);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4589:1: rule__Definition__Group_0__1__Impl : ( ( rule__Definition__NameAssignment_0_1 ) ) ;
    public final void rule__Definition__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4593:1: ( ( ( rule__Definition__NameAssignment_0_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4594:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4594:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4595:1: ( rule__Definition__NameAssignment_0_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4596:1: ( rule__Definition__NameAssignment_0_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4596:2: rule__Definition__NameAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl9790);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4610:1: rule__Definition__Group_1__0 : rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 ;
    public final void rule__Definition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4614:1: ( rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4615:2: rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__09824);
            rule__Definition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__09827);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4622:1: rule__Definition__Group_1__0__Impl : ( 'boundary' ) ;
    public final void rule__Definition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4626:1: ( ( 'boundary' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4627:1: ( 'boundary' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4627:1: ( 'boundary' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4628:1: 'boundary'
            {
             before(grammarAccess.getDefinitionAccess().getBoundaryKeyword_1_0()); 
            match(input,172,FOLLOW_172_in_rule__Definition__Group_1__0__Impl9855); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4641:1: rule__Definition__Group_1__1 : rule__Definition__Group_1__1__Impl ;
    public final void rule__Definition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4645:1: ( rule__Definition__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4646:2: rule__Definition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__19886);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4652:1: rule__Definition__Group_1__1__Impl : ( ( rule__Definition__NameAssignment_1_1 ) ) ;
    public final void rule__Definition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4656:1: ( ( ( rule__Definition__NameAssignment_1_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4657:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4657:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4658:1: ( rule__Definition__NameAssignment_1_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4659:1: ( rule__Definition__NameAssignment_1_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4659:2: rule__Definition__NameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl9913);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4673:1: rule__Definition__Group_2__0 : rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 ;
    public final void rule__Definition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4677:1: ( rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4678:2: rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__09947);
            rule__Definition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__09950);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4685:1: rule__Definition__Group_2__0__Impl : ( 'control' ) ;
    public final void rule__Definition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4689:1: ( ( 'control' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4690:1: ( 'control' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4690:1: ( 'control' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4691:1: 'control'
            {
             before(grammarAccess.getDefinitionAccess().getControlKeyword_2_0()); 
            match(input,173,FOLLOW_173_in_rule__Definition__Group_2__0__Impl9978); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4704:1: rule__Definition__Group_2__1 : rule__Definition__Group_2__1__Impl ;
    public final void rule__Definition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4708:1: ( rule__Definition__Group_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4709:2: rule__Definition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__110009);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4715:1: rule__Definition__Group_2__1__Impl : ( ( rule__Definition__NameAssignment_2_1 ) ) ;
    public final void rule__Definition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4719:1: ( ( ( rule__Definition__NameAssignment_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4720:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4720:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4721:1: ( rule__Definition__NameAssignment_2_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4722:1: ( rule__Definition__NameAssignment_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4722:2: rule__Definition__NameAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl10036);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4736:1: rule__Definition__Group_3__0 : rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 ;
    public final void rule__Definition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4740:1: ( rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4741:2: rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__010070);
            rule__Definition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__010073);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4748:1: rule__Definition__Group_3__0__Impl : ( 'entity' ) ;
    public final void rule__Definition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4752:1: ( ( 'entity' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4753:1: ( 'entity' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4753:1: ( 'entity' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4754:1: 'entity'
            {
             before(grammarAccess.getDefinitionAccess().getEntityKeyword_3_0()); 
            match(input,174,FOLLOW_174_in_rule__Definition__Group_3__0__Impl10101); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4767:1: rule__Definition__Group_3__1 : rule__Definition__Group_3__1__Impl ;
    public final void rule__Definition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4771:1: ( rule__Definition__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4772:2: rule__Definition__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__110132);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4778:1: rule__Definition__Group_3__1__Impl : ( ( rule__Definition__NameAssignment_3_1 ) ) ;
    public final void rule__Definition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4782:1: ( ( ( rule__Definition__NameAssignment_3_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4783:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4783:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4784:1: ( rule__Definition__NameAssignment_3_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4785:1: ( rule__Definition__NameAssignment_3_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4785:2: rule__Definition__NameAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl10159);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4799:1: rule__Definition__Group_4__0 : rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 ;
    public final void rule__Definition__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4803:1: ( rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4804:2: rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__010193);
            rule__Definition__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__010196);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4811:1: rule__Definition__Group_4__0__Impl : ( 'database' ) ;
    public final void rule__Definition__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4815:1: ( ( 'database' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4816:1: ( 'database' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4816:1: ( 'database' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4817:1: 'database'
            {
             before(grammarAccess.getDefinitionAccess().getDatabaseKeyword_4_0()); 
            match(input,175,FOLLOW_175_in_rule__Definition__Group_4__0__Impl10224); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4830:1: rule__Definition__Group_4__1 : rule__Definition__Group_4__1__Impl ;
    public final void rule__Definition__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4834:1: ( rule__Definition__Group_4__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4835:2: rule__Definition__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__110255);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4841:1: rule__Definition__Group_4__1__Impl : ( ( rule__Definition__NameAssignment_4_1 ) ) ;
    public final void rule__Definition__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4845:1: ( ( ( rule__Definition__NameAssignment_4_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4846:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4846:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4847:1: ( rule__Definition__NameAssignment_4_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_4_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4848:1: ( rule__Definition__NameAssignment_4_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4848:2: rule__Definition__NameAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl10282);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4862:1: rule__AutoNumber__Group__0 : rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1 ;
    public final void rule__AutoNumber__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4866:1: ( rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4867:2: rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__0__Impl_in_rule__AutoNumber__Group__010316);
            rule__AutoNumber__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AutoNumber__Group__1_in_rule__AutoNumber__Group__010319);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4874:1: rule__AutoNumber__Group__0__Impl : ( 'autonumber' ) ;
    public final void rule__AutoNumber__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4878:1: ( ( 'autonumber' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4879:1: ( 'autonumber' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4879:1: ( 'autonumber' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4880:1: 'autonumber'
            {
             before(grammarAccess.getAutoNumberAccess().getAutonumberKeyword_0()); 
            match(input,176,FOLLOW_176_in_rule__AutoNumber__Group__0__Impl10347); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4893:1: rule__AutoNumber__Group__1 : rule__AutoNumber__Group__1__Impl ;
    public final void rule__AutoNumber__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4897:1: ( rule__AutoNumber__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4898:2: rule__AutoNumber__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__1__Impl_in_rule__AutoNumber__Group__110378);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4904:1: rule__AutoNumber__Group__1__Impl : ( ( rule__AutoNumber__Group_1__0 )? ) ;
    public final void rule__AutoNumber__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4908:1: ( ( ( rule__AutoNumber__Group_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4909:1: ( ( rule__AutoNumber__Group_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4909:1: ( ( rule__AutoNumber__Group_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4910:1: ( rule__AutoNumber__Group_1__0 )?
            {
             before(grammarAccess.getAutoNumberAccess().getGroup_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4911:1: ( rule__AutoNumber__Group_1__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_INT) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4911:2: rule__AutoNumber__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__AutoNumber__Group_1__0_in_rule__AutoNumber__Group__1__Impl10405);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4925:1: rule__AutoNumber__Group_1__0 : rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1 ;
    public final void rule__AutoNumber__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4929:1: ( rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4930:2: rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group_1__0__Impl_in_rule__AutoNumber__Group_1__010440);
            rule__AutoNumber__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AutoNumber__Group_1__1_in_rule__AutoNumber__Group_1__010443);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4937:1: rule__AutoNumber__Group_1__0__Impl : ( RULE_INT ) ;
    public final void rule__AutoNumber__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4941:1: ( ( RULE_INT ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4942:1: ( RULE_INT )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4942:1: ( RULE_INT )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4943:1: RULE_INT
            {
             before(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__0__Impl10470); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4954:1: rule__AutoNumber__Group_1__1 : rule__AutoNumber__Group_1__1__Impl ;
    public final void rule__AutoNumber__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4958:1: ( rule__AutoNumber__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4959:2: rule__AutoNumber__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group_1__1__Impl_in_rule__AutoNumber__Group_1__110499);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4965:1: rule__AutoNumber__Group_1__1__Impl : ( ( RULE_INT )? ) ;
    public final void rule__AutoNumber__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4969:1: ( ( ( RULE_INT )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4970:1: ( ( RULE_INT )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4970:1: ( ( RULE_INT )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4971:1: ( RULE_INT )?
            {
             before(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4972:1: ( RULE_INT )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_INT) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4972:3: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__1__Impl10527); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4986:1: rule__Color__Group__0 : rule__Color__Group__0__Impl rule__Color__Group__1 ;
    public final void rule__Color__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4990:1: ( rule__Color__Group__0__Impl rule__Color__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4991:2: rule__Color__Group__0__Impl rule__Color__Group__1
            {
            pushFollow(FOLLOW_rule__Color__Group__0__Impl_in_rule__Color__Group__010562);
            rule__Color__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Color__Group__1_in_rule__Color__Group__010565);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4998:1: rule__Color__Group__0__Impl : ( ( ( '#' ) ) ( ( '#' )* ) ) ;
    public final void rule__Color__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5002:1: ( ( ( ( '#' ) ) ( ( '#' )* ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5003:1: ( ( ( '#' ) ) ( ( '#' )* ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5003:1: ( ( ( '#' ) ) ( ( '#' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5004:1: ( ( '#' ) ) ( ( '#' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5004:1: ( ( '#' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5005:1: ( '#' )
            {
             before(grammarAccess.getColorAccess().getNumberSignKeyword_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5006:1: ( '#' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5007:2: '#'
            {
            match(input,177,FOLLOW_177_in_rule__Color__Group__0__Impl10596); 

            }

             after(grammarAccess.getColorAccess().getNumberSignKeyword_0()); 

            }

            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5011:1: ( ( '#' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5012:1: ( '#' )*
            {
             before(grammarAccess.getColorAccess().getNumberSignKeyword_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5013:1: ( '#' )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==177) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5014:2: '#'
            	    {
            	    match(input,177,FOLLOW_177_in_rule__Color__Group__0__Impl10612); 

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5026:1: rule__Color__Group__1 : rule__Color__Group__1__Impl ;
    public final void rule__Color__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5030:1: ( rule__Color__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5031:2: rule__Color__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Color__Group__1__Impl_in_rule__Color__Group__110647);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5037:1: rule__Color__Group__1__Impl : ( ( rule__Color__Alternatives_1 ) ) ;
    public final void rule__Color__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5041:1: ( ( ( rule__Color__Alternatives_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5042:1: ( ( rule__Color__Alternatives_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5042:1: ( ( rule__Color__Alternatives_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5043:1: ( rule__Color__Alternatives_1 )
            {
             before(grammarAccess.getColorAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5044:1: ( rule__Color__Alternatives_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5044:2: rule__Color__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Color__Alternatives_1_in_rule__Color__Group__1__Impl10674);
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


    // $ANTLR start "rule__Title__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5058:1: rule__Title__Group__0 : rule__Title__Group__0__Impl rule__Title__Group__1 ;
    public final void rule__Title__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5062:1: ( rule__Title__Group__0__Impl rule__Title__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5063:2: rule__Title__Group__0__Impl rule__Title__Group__1
            {
            pushFollow(FOLLOW_rule__Title__Group__0__Impl_in_rule__Title__Group__010708);
            rule__Title__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Title__Group__1_in_rule__Title__Group__010711);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5070:1: rule__Title__Group__0__Impl : ( 'title' ) ;
    public final void rule__Title__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5074:1: ( ( 'title' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5075:1: ( 'title' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5075:1: ( 'title' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5076:1: 'title'
            {
             before(grammarAccess.getTitleAccess().getTitleKeyword_0()); 
            match(input,178,FOLLOW_178_in_rule__Title__Group__0__Impl10739); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5089:1: rule__Title__Group__1 : rule__Title__Group__1__Impl ;
    public final void rule__Title__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5093:1: ( rule__Title__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5094:2: rule__Title__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Title__Group__1__Impl_in_rule__Title__Group__110770);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5100:1: rule__Title__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__Title__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5104:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5105:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5105:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5106:1: RULE_ID
            {
             before(grammarAccess.getTitleAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Title__Group__1__Impl10797); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5121:1: rule__Legend__Group__0 : rule__Legend__Group__0__Impl rule__Legend__Group__1 ;
    public final void rule__Legend__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5125:1: ( rule__Legend__Group__0__Impl rule__Legend__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5126:2: rule__Legend__Group__0__Impl rule__Legend__Group__1
            {
            pushFollow(FOLLOW_rule__Legend__Group__0__Impl_in_rule__Legend__Group__010830);
            rule__Legend__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__1_in_rule__Legend__Group__010833);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5133:1: rule__Legend__Group__0__Impl : ( 'legend' ) ;
    public final void rule__Legend__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5137:1: ( ( 'legend' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5138:1: ( 'legend' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5138:1: ( 'legend' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5139:1: 'legend'
            {
             before(grammarAccess.getLegendAccess().getLegendKeyword_0()); 
            match(input,179,FOLLOW_179_in_rule__Legend__Group__0__Impl10861); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5152:1: rule__Legend__Group__1 : rule__Legend__Group__1__Impl rule__Legend__Group__2 ;
    public final void rule__Legend__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5156:1: ( rule__Legend__Group__1__Impl rule__Legend__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5157:2: rule__Legend__Group__1__Impl rule__Legend__Group__2
            {
            pushFollow(FOLLOW_rule__Legend__Group__1__Impl_in_rule__Legend__Group__110892);
            rule__Legend__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__2_in_rule__Legend__Group__110895);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5164:1: rule__Legend__Group__1__Impl : ( ( rule__Legend__Alternatives_1 )? ) ;
    public final void rule__Legend__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5168:1: ( ( ( rule__Legend__Alternatives_1 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5169:1: ( ( rule__Legend__Alternatives_1 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5169:1: ( ( rule__Legend__Alternatives_1 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5170:1: ( rule__Legend__Alternatives_1 )?
            {
             before(grammarAccess.getLegendAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5171:1: ( rule__Legend__Alternatives_1 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=156 && LA25_0<=158)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5171:2: rule__Legend__Alternatives_1
                    {
                    pushFollow(FOLLOW_rule__Legend__Alternatives_1_in_rule__Legend__Group__1__Impl10922);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5181:1: rule__Legend__Group__2 : rule__Legend__Group__2__Impl rule__Legend__Group__3 ;
    public final void rule__Legend__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5185:1: ( rule__Legend__Group__2__Impl rule__Legend__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5186:2: rule__Legend__Group__2__Impl rule__Legend__Group__3
            {
            pushFollow(FOLLOW_rule__Legend__Group__2__Impl_in_rule__Legend__Group__210953);
            rule__Legend__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__3_in_rule__Legend__Group__210956);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5193:1: rule__Legend__Group__2__Impl : ( ( rule__Legend__IdsAssignment_2 )* ) ;
    public final void rule__Legend__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5197:1: ( ( ( rule__Legend__IdsAssignment_2 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5198:1: ( ( rule__Legend__IdsAssignment_2 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5198:1: ( ( rule__Legend__IdsAssignment_2 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5199:1: ( rule__Legend__IdsAssignment_2 )*
            {
             before(grammarAccess.getLegendAccess().getIdsAssignment_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5200:1: ( rule__Legend__IdsAssignment_2 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_ID) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5200:2: rule__Legend__IdsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Legend__IdsAssignment_2_in_rule__Legend__Group__2__Impl10983);
            	    rule__Legend__IdsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getLegendAccess().getIdsAssignment_2()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5210:1: rule__Legend__Group__3 : rule__Legend__Group__3__Impl ;
    public final void rule__Legend__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5214:1: ( rule__Legend__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5215:2: rule__Legend__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Legend__Group__3__Impl_in_rule__Legend__Group__311014);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5221:1: rule__Legend__Group__3__Impl : ( 'endlegend' ) ;
    public final void rule__Legend__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5225:1: ( ( 'endlegend' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5226:1: ( 'endlegend' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5226:1: ( 'endlegend' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5227:1: 'endlegend'
            {
             before(grammarAccess.getLegendAccess().getEndlegendKeyword_3()); 
            match(input,180,FOLLOW_180_in_rule__Legend__Group__3__Impl11042); 
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


    // $ANTLR start "rule__Newpage__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5248:1: rule__Newpage__Group__0 : rule__Newpage__Group__0__Impl rule__Newpage__Group__1 ;
    public final void rule__Newpage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5252:1: ( rule__Newpage__Group__0__Impl rule__Newpage__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5253:2: rule__Newpage__Group__0__Impl rule__Newpage__Group__1
            {
            pushFollow(FOLLOW_rule__Newpage__Group__0__Impl_in_rule__Newpage__Group__011081);
            rule__Newpage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Newpage__Group__1_in_rule__Newpage__Group__011084);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5260:1: rule__Newpage__Group__0__Impl : ( 'newpage' ) ;
    public final void rule__Newpage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5264:1: ( ( 'newpage' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5265:1: ( 'newpage' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5265:1: ( 'newpage' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5266:1: 'newpage'
            {
             before(grammarAccess.getNewpageAccess().getNewpageKeyword_0()); 
            match(input,181,FOLLOW_181_in_rule__Newpage__Group__0__Impl11112); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5279:1: rule__Newpage__Group__1 : rule__Newpage__Group__1__Impl ;
    public final void rule__Newpage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5283:1: ( rule__Newpage__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5284:2: rule__Newpage__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Newpage__Group__1__Impl_in_rule__Newpage__Group__111143);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5290:1: rule__Newpage__Group__1__Impl : ( ( RULE_ID )? ) ;
    public final void rule__Newpage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5294:1: ( ( ( RULE_ID )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5295:1: ( ( RULE_ID )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5295:1: ( ( RULE_ID )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5296:1: ( RULE_ID )?
            {
             before(grammarAccess.getNewpageAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5297:1: ( RULE_ID )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ID) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==EOF||(LA27_1>=RULE_ML_COMMENT && LA27_1<=RULE_ID)||LA27_1==160||(LA27_1>=171 && LA27_1<=176)||(LA27_1>=178 && LA27_1<=179)||LA27_1==181) ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5297:3: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Newpage__Group__1__Impl11171); 

                    }
                    break;

            }

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


    // $ANTLR start "rule__Model__DiagramsAssignment"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5312:1: rule__Model__DiagramsAssignment : ( ruleDiagram ) ;
    public final void rule__Model__DiagramsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5316:1: ( ( ruleDiagram ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5317:1: ( ruleDiagram )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5317:1: ( ruleDiagram )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5318:1: ruleDiagram
            {
             before(grammarAccess.getModelAccess().getDiagramsDiagramParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDiagram_in_rule__Model__DiagramsAssignment11211);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5327:1: rule__Diagram__InstructionsAssignment_1 : ( ruleInstruction ) ;
    public final void rule__Diagram__InstructionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5331:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5332:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5332:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5333:1: ruleInstruction
            {
             before(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_111242);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5342:1: rule__Instruction__Name1Assignment_0_0 : ( RULE_ID ) ;
    public final void rule__Instruction__Name1Assignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5346:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5347:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5347:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5348:1: RULE_ID
            {
             before(grammarAccess.getInstructionAccess().getName1IDTerminalRuleCall_0_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Instruction__Name1Assignment_0_011273); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5357:1: rule__Instruction__Name2Assignment_0_2 : ( RULE_ID ) ;
    public final void rule__Instruction__Name2Assignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5361:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5362:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5362:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5363:1: RULE_ID
            {
             before(grammarAccess.getInstructionAccess().getName2IDTerminalRuleCall_0_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Instruction__Name2Assignment_0_211304); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5372:1: rule__Definition__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5376:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5377:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5377:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5378:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_0_111335); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5387:1: rule__Definition__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5391:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5392:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5392:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5393:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_1_111366); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5402:1: rule__Definition__NameAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5406:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5407:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5407:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5408:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_2_111397); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5417:1: rule__Definition__NameAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5421:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5422:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5422:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5423:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_3_111428); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5432:1: rule__Definition__NameAssignment_4_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5436:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5437:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5437:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5438:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_4_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_4_111459); 
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


    // $ANTLR start "rule__Legend__IdsAssignment_2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5447:1: rule__Legend__IdsAssignment_2 : ( RULE_ID ) ;
    public final void rule__Legend__IdsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5451:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5452:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5452:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5453:1: RULE_ID
            {
             before(grammarAccess.getLegendAccess().getIdsIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Legend__IdsAssignment_211490); 
             after(grammarAccess.getLegendAccess().getIdsIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__IdsAssignment_2"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\43\uffff";
    static final String DFA3_eofS =
        "\6\uffff\1\22\1\26\3\uffff\1\34\14\uffff\1\26\4\uffff\1\40\1\42"+
        "\4\uffff";
    static final String DFA3_minS =
        "\1\12\2\u00a2\1\uffff\1\u00a2\1\u00a4\2\6\1\uffff\1\u00a2\1\uffff"+
        "\1\6\4\uffff\1\u00a2\7\uffff\1\6\1\u00a2\3\uffff\2\6\4\uffff";
    static final String DFA3_maxS =
        "\1\u00a9\1\u00a8\1\u00aa\1\uffff\1\u00a7\1\u00a8\1\12\1\u00a9\1"+
        "\uffff\1\u00aa\1\uffff\1\u00a3\4\uffff\1\u00a2\7\uffff\1\u00a9\1"+
        "\u00a8\3\uffff\1\u00a9\1\u00a3\4\uffff";
    static final String DFA3_acceptS =
        "\3\uffff\1\4\4\uffff\1\7\1\uffff\1\11\1\uffff\1\6\1\22\1\10\1\12"+
        "\1\uffff\1\16\1\25\1\24\1\5\1\3\1\1\1\13\2\uffff\1\23\1\15\1\2\2"+
        "\uffff\1\20\1\17\1\21\1\14";
    static final String DFA3_specialS =
        "\43\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\6\u0097\uffff\1\1\1\uffff\1\2\1\3\1\uffff\1\4\1\uffff\1"+
            "\5",
            "\1\11\1\7\2\uffff\1\10\1\uffff\1\12",
            "\1\13\1\uffff\1\14\5\uffff\1\15",
            "",
            "\1\16\4\uffff\1\17",
            "\1\20\3\uffff\1\21",
            "\1\22\3\uffff\1\23",
            "\1\26\u009c\uffff\1\24\1\uffff\1\25\3\uffff\1\27",
            "",
            "\1\31\1\30\2\uffff\1\10\1\33\1\12\1\uffff\1\32",
            "",
            "\1\34\u009b\uffff\1\34\1\35",
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
            "\1\26\u009c\uffff\1\24\5\uffff\1\27",
            "\1\31\1\30\2\uffff\1\10\1\33\1\12",
            "",
            "",
            "",
            "\1\40\u00a2\uffff\1\37",
            "\1\42\u009b\uffff\1\42\1\41",
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
            return "398:1: rule__Sequence__Alternatives : ( ( ( rule__Sequence__Group_0__0 ) ) | ( ( rule__Sequence__Group_1__0 ) ) | ( ( rule__Sequence__Group_2__0 ) ) | ( ( rule__Sequence__Group_3__0 ) ) | ( ( rule__Sequence__Group_4__0 ) ) | ( ( rule__Sequence__Group_5__0 ) ) | ( ( rule__Sequence__Group_6__0 ) ) | ( ( rule__Sequence__Group_7__0 ) ) | ( ( rule__Sequence__Group_8__0 ) ) | ( ( rule__Sequence__Group_9__0 ) ) | ( ( rule__Sequence__Group_10__0 ) ) | ( ( rule__Sequence__Group_11__0 ) ) | ( ( rule__Sequence__Group_12__0 ) ) | ( ( rule__Sequence__Group_13__0 ) ) | ( ( rule__Sequence__Group_14__0 ) ) | ( ( rule__Sequence__Group_15__0 ) ) | ( ( rule__Sequence__Group_16__0 ) ) | ( ( rule__Sequence__Group_17__0 ) ) | ( ( rule__Sequence__Group_18__0 ) ) | ( ( rule__Sequence__Group_19__0 ) ) | ( '.' ) );";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DiagramsAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000080000000L});
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
    public static final BitSet FOLLOW_ruleTitle_in_entryRuleTitle482 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTitle489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__0_in_ruleTitle515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLegend_in_entryRuleLegend542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLegend549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__0_in_ruleLegend575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_entryRuleNewpage602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNewpage609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__0_in_ruleNewpage635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__0_in_rule__Instruction__Alternatives671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ML_COMMENT_in_rule__Instruction__Alternatives689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SL_COMMENT_in_rule__Instruction__Alternatives706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_3__0_in_rule__Instruction__Alternatives723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_rule__Instruction__Alternatives741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_rule__Instruction__Alternatives758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLegend_in_rule__Instruction__Alternatives775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_rule__Instruction__Alternatives792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__0_in_rule__Sequence__Alternatives824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__0_in_rule__Sequence__Alternatives842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__0_in_rule__Sequence__Alternatives860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__0_in_rule__Sequence__Alternatives878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__0_in_rule__Sequence__Alternatives896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__0_in_rule__Sequence__Alternatives914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__0_in_rule__Sequence__Alternatives932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__0_in_rule__Sequence__Alternatives950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__0_in_rule__Sequence__Alternatives968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__0_in_rule__Sequence__Alternatives986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__0_in_rule__Sequence__Alternatives1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__0_in_rule__Sequence__Alternatives1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__0_in_rule__Sequence__Alternatives1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__0_in_rule__Sequence__Alternatives1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__0_in_rule__Sequence__Alternatives1076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__0_in_rule__Sequence__Alternatives1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__0_in_rule__Sequence__Alternatives1112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__0_in_rule__Sequence__Alternatives1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__0_in_rule__Sequence__Alternatives1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__0_in_rule__Sequence__Alternatives1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__Sequence__Alternatives1185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives1219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives1237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives1255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives1273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives1291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Color__Alternatives_11325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Color__Alternatives_11345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Color__Alternatives_11365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Color__Alternatives_11385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Color__Alternatives_11405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Color__Alternatives_11425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Color__Alternatives_11445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Color__Alternatives_11465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Color__Alternatives_11485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Color__Alternatives_11505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Color__Alternatives_11525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Color__Alternatives_11545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Color__Alternatives_11565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Color__Alternatives_11585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Color__Alternatives_11605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Color__Alternatives_11625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Color__Alternatives_11645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Color__Alternatives_11665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Color__Alternatives_11685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Color__Alternatives_11705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Color__Alternatives_11725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Color__Alternatives_11745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Color__Alternatives_11765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Color__Alternatives_11785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Color__Alternatives_11805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Color__Alternatives_11825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Color__Alternatives_11845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Color__Alternatives_11865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Color__Alternatives_11885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__Color__Alternatives_11905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Color__Alternatives_11925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__Color__Alternatives_11945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__Color__Alternatives_11965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__Color__Alternatives_11985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__Color__Alternatives_12005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__Color__Alternatives_12025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__Color__Alternatives_12045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__Color__Alternatives_12065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__Color__Alternatives_12085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__Color__Alternatives_12105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__Color__Alternatives_12125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__Color__Alternatives_12145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__Color__Alternatives_12165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__Color__Alternatives_12185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_rule__Color__Alternatives_12205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rule__Color__Alternatives_12225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_rule__Color__Alternatives_12245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_rule__Color__Alternatives_12265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_rule__Color__Alternatives_12285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_rule__Color__Alternatives_12305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_rule__Color__Alternatives_12325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_rule__Color__Alternatives_12345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_rule__Color__Alternatives_12365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_rule__Color__Alternatives_12385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_rule__Color__Alternatives_12405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_rule__Color__Alternatives_12425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_rule__Color__Alternatives_12445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_rule__Color__Alternatives_12465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_rule__Color__Alternatives_12485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_rule__Color__Alternatives_12505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_rule__Color__Alternatives_12525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_rule__Color__Alternatives_12545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_rule__Color__Alternatives_12565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_rule__Color__Alternatives_12585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_rule__Color__Alternatives_12605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_rule__Color__Alternatives_12625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_rule__Color__Alternatives_12645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_rule__Color__Alternatives_12665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_rule__Color__Alternatives_12685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_rule__Color__Alternatives_12705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_rule__Color__Alternatives_12725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_rule__Color__Alternatives_12745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_rule__Color__Alternatives_12765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_rule__Color__Alternatives_12785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_rule__Color__Alternatives_12805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_rule__Color__Alternatives_12825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_rule__Color__Alternatives_12845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_rule__Color__Alternatives_12865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_rule__Color__Alternatives_12885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_rule__Color__Alternatives_12905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_rule__Color__Alternatives_12925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_rule__Color__Alternatives_12945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_rule__Color__Alternatives_12965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_rule__Color__Alternatives_12985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_rule__Color__Alternatives_13005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_rule__Color__Alternatives_13025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_rule__Color__Alternatives_13045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_rule__Color__Alternatives_13065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_rule__Color__Alternatives_13085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_rule__Color__Alternatives_13105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_rule__Color__Alternatives_13125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_rule__Color__Alternatives_13145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_rule__Color__Alternatives_13165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_rule__Color__Alternatives_13185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_rule__Color__Alternatives_13205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_rule__Color__Alternatives_13225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_rule__Color__Alternatives_13245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_rule__Color__Alternatives_13265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_rule__Color__Alternatives_13285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_rule__Color__Alternatives_13305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_rule__Color__Alternatives_13325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_rule__Color__Alternatives_13345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_rule__Color__Alternatives_13365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_rule__Color__Alternatives_13385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_rule__Color__Alternatives_13405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_rule__Color__Alternatives_13425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_rule__Color__Alternatives_13445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_rule__Color__Alternatives_13465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_rule__Color__Alternatives_13485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_rule__Color__Alternatives_13505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_rule__Color__Alternatives_13525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_rule__Color__Alternatives_13545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_rule__Color__Alternatives_13565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_rule__Color__Alternatives_13585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_rule__Color__Alternatives_13605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_rule__Color__Alternatives_13625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_rule__Color__Alternatives_13645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_rule__Color__Alternatives_13665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_rule__Color__Alternatives_13685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_rule__Color__Alternatives_13705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_rule__Color__Alternatives_13725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_rule__Color__Alternatives_13745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_rule__Color__Alternatives_13765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_134_in_rule__Color__Alternatives_13785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_135_in_rule__Color__Alternatives_13805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_136_in_rule__Color__Alternatives_13825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_137_in_rule__Color__Alternatives_13845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_138_in_rule__Color__Alternatives_13865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_139_in_rule__Color__Alternatives_13885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_140_in_rule__Color__Alternatives_13905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_141_in_rule__Color__Alternatives_13925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_142_in_rule__Color__Alternatives_13945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_143_in_rule__Color__Alternatives_13965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_144_in_rule__Color__Alternatives_13985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_145_in_rule__Color__Alternatives_14005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_146_in_rule__Color__Alternatives_14025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_147_in_rule__Color__Alternatives_14045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_148_in_rule__Color__Alternatives_14065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_149_in_rule__Color__Alternatives_14085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_150_in_rule__Color__Alternatives_14105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_151_in_rule__Color__Alternatives_14125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_152_in_rule__Color__Alternatives_14145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_153_in_rule__Color__Alternatives_14165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_154_in_rule__Color__Alternatives_14185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_155_in_rule__Color__Alternatives_14205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_156_in_rule__Legend__Alternatives_14240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_157_in_rule__Legend__Alternatives_14260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_rule__Legend__Alternatives_14280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__04312 = new BitSet(new long[]{0x0000000000000070L,0x0000000000000000L,0x002DF80100000000L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__04315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Diagram__Group__0__Impl4343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__14374 = new BitSet(new long[]{0x0000000000000070L,0x0000000000000000L,0x002DF80100000000L});
    public static final BitSet FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__14377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__InstructionsAssignment_1_in_rule__Diagram__Group__1__Impl4404 = new BitSet(new long[]{0x0000000000000072L,0x0000000000000000L,0x002DF80000000000L});
    public static final BitSet FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__24435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_rule__Diagram__Group__2__Impl4463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__0__Impl_in_rule__Instruction__Group_0__04500 = new BitSet(new long[]{0x0000000000000400L,0x0000000000000000L,0x000002B400000000L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__1_in_rule__Instruction__Group_0__04503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Name1Assignment_0_0_in_rule__Instruction__Group_0__0__Impl4530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__1__Impl_in_rule__Instruction__Group_0__14560 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__2_in_rule__Instruction__Group_0__14563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequence_in_rule__Instruction__Group_0__1__Impl4590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__2__Impl_in_rule__Instruction__Group_0__24619 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__3_in_rule__Instruction__Group_0__24622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Name2Assignment_0_2_in_rule__Instruction__Group_0__2__Impl4649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0__3__Impl_in_rule__Instruction__Group_0__34679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_3__0_in_rule__Instruction__Group_0__3__Impl4706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_3__0__Impl_in_rule__Instruction__Group_0_3__04745 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_3__1_in_rule__Instruction__Group_0_3__04748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_rule__Instruction__Group_0_3__0__Impl4776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_3__1__Impl_in_rule__Instruction__Group_0_3__14807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Instruction__Group_0_3__1__Impl4834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_3__0__Impl_in_rule__Instruction__Group_3__04867 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_rule__Instruction__Group_3__1_in_rule__Instruction__Group_3__04870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_rule__Instruction__Group_3__0__Impl4897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_3__1__Impl_in_rule__Instruction__Group_3__14926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__Instruction__Group_3__1__Impl4954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__0__Impl_in_rule__Sequence__Group_0__04989 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__1_in_rule__Sequence__Group_0__04992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_0__0__Impl5021 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__1__Impl_in_rule__Sequence__Group_0__15054 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__2_in_rule__Sequence__Group_0__15057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_0__1__Impl5085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__2__Impl_in_rule__Sequence__Group_0__25116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_0__2__Impl5144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__0__Impl_in_rule__Sequence__Group_1__05181 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__1_in_rule__Sequence__Group_1__05184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_1__0__Impl5212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__1__Impl_in_rule__Sequence__Group_1__15243 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__2_in_rule__Sequence__Group_1__15246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_1__1__Impl5274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__2__Impl_in_rule__Sequence__Group_1__25305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_1__2__Impl5334 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__0__Impl_in_rule__Sequence__Group_2__05373 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__1_in_rule__Sequence__Group_2__05376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_2__0__Impl5404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__1__Impl_in_rule__Sequence__Group_2__15435 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__2_in_rule__Sequence__Group_2__15438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_2__1__Impl5466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__2__Impl_in_rule__Sequence__Group_2__25497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_2__2__Impl5525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__0__Impl_in_rule__Sequence__Group_3__05562 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__1_in_rule__Sequence__Group_3__05565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_3__0__Impl5593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__1__Impl_in_rule__Sequence__Group_3__15624 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__2_in_rule__Sequence__Group_3__15627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_3__1__Impl5655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__2__Impl_in_rule__Sequence__Group_3__25686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_3__2__Impl5714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__0__Impl_in_rule__Sequence__Group_4__05751 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__1_in_rule__Sequence__Group_4__05754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_4__0__Impl5783 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__1__Impl_in_rule__Sequence__Group_4__15816 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__2_in_rule__Sequence__Group_4__15819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_4__1__Impl5847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__2__Impl_in_rule__Sequence__Group_4__25878 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__3_in_rule__Sequence__Group_4__25881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_4__2__Impl5909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__3__Impl_in_rule__Sequence__Group_4__35940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_4__3__Impl5968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__0__Impl_in_rule__Sequence__Group_5__06007 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__1_in_rule__Sequence__Group_5__06010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_5__0__Impl6038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__1__Impl_in_rule__Sequence__Group_5__16069 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__2_in_rule__Sequence__Group_5__16072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_5__1__Impl6100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__2__Impl_in_rule__Sequence__Group_5__26131 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__3_in_rule__Sequence__Group_5__26134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_5__2__Impl6162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__3__Impl_in_rule__Sequence__Group_5__36193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_5__3__Impl6222 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__0__Impl_in_rule__Sequence__Group_6__06263 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__1_in_rule__Sequence__Group_6__06266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_6__0__Impl6295 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__1__Impl_in_rule__Sequence__Group_6__16328 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__2_in_rule__Sequence__Group_6__16331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_6__1__Impl6359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__2__Impl_in_rule__Sequence__Group_6__26390 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__3_in_rule__Sequence__Group_6__26393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_166_in_rule__Sequence__Group_6__2__Impl6421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__3__Impl_in_rule__Sequence__Group_6__36452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_166_in_rule__Sequence__Group_6__3__Impl6480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__0__Impl_in_rule__Sequence__Group_7__06519 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__1_in_rule__Sequence__Group_7__06522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_167_in_rule__Sequence__Group_7__0__Impl6550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__1__Impl_in_rule__Sequence__Group_7__16581 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__2_in_rule__Sequence__Group_7__16584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_7__1__Impl6612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__2__Impl_in_rule__Sequence__Group_7__26643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_7__2__Impl6672 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__0__Impl_in_rule__Sequence__Group_8__06711 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__1_in_rule__Sequence__Group_8__06714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_8__0__Impl6743 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__1__Impl_in_rule__Sequence__Group_8__16776 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__2_in_rule__Sequence__Group_8__16779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_8__1__Impl6807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__2__Impl_in_rule__Sequence__Group_8__26838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_rule__Sequence__Group_8__2__Impl6866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__0__Impl_in_rule__Sequence__Group_9__06903 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__1_in_rule__Sequence__Group_9__06906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_167_in_rule__Sequence__Group_9__0__Impl6934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__1__Impl_in_rule__Sequence__Group_9__16965 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__2_in_rule__Sequence__Group_9__16968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_167_in_rule__Sequence__Group_9__1__Impl6996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__2__Impl_in_rule__Sequence__Group_9__27027 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__3_in_rule__Sequence__Group_9__27030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_9__2__Impl7058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__3__Impl_in_rule__Sequence__Group_9__37089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_9__3__Impl7118 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__0__Impl_in_rule__Sequence__Group_10__07159 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__1_in_rule__Sequence__Group_10__07162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_10__0__Impl7191 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__1__Impl_in_rule__Sequence__Group_10__17224 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__2_in_rule__Sequence__Group_10__17227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_10__1__Impl7255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__2__Impl_in_rule__Sequence__Group_10__27286 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__3_in_rule__Sequence__Group_10__27289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_10__2__Impl7317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__3__Impl_in_rule__Sequence__Group_10__37348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_169_in_rule__Sequence__Group_10__3__Impl7376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__0__Impl_in_rule__Sequence__Group_11__07415 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__1_in_rule__Sequence__Group_11__07418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_169_in_rule__Sequence__Group_11__0__Impl7446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__1__Impl_in_rule__Sequence__Group_11__17477 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__2_in_rule__Sequence__Group_11__17480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_11__1__Impl7508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__2__Impl_in_rule__Sequence__Group_11__27539 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__3_in_rule__Sequence__Group_11__27542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_11__2__Impl7570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__3__Impl_in_rule__Sequence__Group_11__37601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_11__3__Impl7630 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__0__Impl_in_rule__Sequence__Group_12__07671 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__1_in_rule__Sequence__Group_12__07674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_12__0__Impl7703 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__1__Impl_in_rule__Sequence__Group_12__17736 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__2_in_rule__Sequence__Group_12__17739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_12__1__Impl7767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__2__Impl_in_rule__Sequence__Group_12__27798 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__3_in_rule__Sequence__Group_12__27801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_12__2__Impl7829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__3__Impl_in_rule__Sequence__Group_12__37860 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__4_in_rule__Sequence__Group_12__37863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_167_in_rule__Sequence__Group_12__3__Impl7891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__4__Impl_in_rule__Sequence__Group_12__47922 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__5_in_rule__Sequence__Group_12__47925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_167_in_rule__Sequence__Group_12__4__Impl7953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__5__Impl_in_rule__Sequence__Group_12__57984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_169_in_rule__Sequence__Group_12__5__Impl8012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__0__Impl_in_rule__Sequence__Group_13__08055 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__1_in_rule__Sequence__Group_13__08058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_169_in_rule__Sequence__Group_13__0__Impl8086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__1__Impl_in_rule__Sequence__Group_13__18117 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__2_in_rule__Sequence__Group_13__18120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_rule__Sequence__Group_13__1__Impl8148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__2__Impl_in_rule__Sequence__Group_13__28179 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__3_in_rule__Sequence__Group_13__28182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_13__2__Impl8210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__3__Impl_in_rule__Sequence__Group_13__38241 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__4_in_rule__Sequence__Group_13__38244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_13__3__Impl8272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__4__Impl_in_rule__Sequence__Group_13__48303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_13__4__Impl8332 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__0__Impl_in_rule__Sequence__Group_14__08375 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__1_in_rule__Sequence__Group_14__08378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_14__0__Impl8406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__1__Impl_in_rule__Sequence__Group_14__18437 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__2_in_rule__Sequence__Group_14__18440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_14__1__Impl8468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__2__Impl_in_rule__Sequence__Group_14__28499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_14__2__Impl8527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__0__Impl_in_rule__Sequence__Group_15__08564 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__1_in_rule__Sequence__Group_15__08567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_15__0__Impl8595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__1__Impl_in_rule__Sequence__Group_15__18626 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__2_in_rule__Sequence__Group_15__18629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_15__1__Impl8657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__2__Impl_in_rule__Sequence__Group_15__28688 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__3_in_rule__Sequence__Group_15__28691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_15__2__Impl8719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__3__Impl_in_rule__Sequence__Group_15__38750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_169_in_rule__Sequence__Group_15__3__Impl8778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__0__Impl_in_rule__Sequence__Group_16__08817 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__1_in_rule__Sequence__Group_16__08820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_169_in_rule__Sequence__Group_16__0__Impl8848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__1__Impl_in_rule__Sequence__Group_16__18879 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__2_in_rule__Sequence__Group_16__18882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_16__1__Impl8910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__2__Impl_in_rule__Sequence__Group_16__28941 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__3_in_rule__Sequence__Group_16__28944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_16__2__Impl8972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__3__Impl_in_rule__Sequence__Group_16__39003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_16__3__Impl9031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__0__Impl_in_rule__Sequence__Group_17__09070 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__1_in_rule__Sequence__Group_17__09073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_17__0__Impl9101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__1__Impl_in_rule__Sequence__Group_17__19132 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__2_in_rule__Sequence__Group_17__19135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_170_in_rule__Sequence__Group_17__1__Impl9163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__2__Impl_in_rule__Sequence__Group_17__29194 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__3_in_rule__Sequence__Group_17__29197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_17__2__Impl9225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__3__Impl_in_rule__Sequence__Group_17__39256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_17__3__Impl9284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__0__Impl_in_rule__Sequence__Group_18__09323 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__1_in_rule__Sequence__Group_18__09326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_18__0__Impl9354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__1__Impl_in_rule__Sequence__Group_18__19385 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__2_in_rule__Sequence__Group_18__19388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Sequence__Group_18__1__Impl9416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__2__Impl_in_rule__Sequence__Group_18__29447 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__3_in_rule__Sequence__Group_18__29450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_170_in_rule__Sequence__Group_18__2__Impl9478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__3__Impl_in_rule__Sequence__Group_18__39509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_18__3__Impl9537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__0__Impl_in_rule__Sequence__Group_19__09576 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__1_in_rule__Sequence__Group_19__09579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__Sequence__Group_19__0__Impl9607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__1__Impl_in_rule__Sequence__Group_19__19638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__Sequence__Group_19__1__Impl9666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__09701 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__09704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_171_in_rule__Definition__Group_0__0__Impl9732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__19763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl9790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__09824 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__09827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_172_in_rule__Definition__Group_1__0__Impl9855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__19886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl9913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__09947 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__09950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_173_in_rule__Definition__Group_2__0__Impl9978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__110009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl10036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__010070 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__010073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_174_in_rule__Definition__Group_3__0__Impl10101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__110132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl10159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__010193 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__010196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_175_in_rule__Definition__Group_4__0__Impl10224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__110255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl10282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__0__Impl_in_rule__AutoNumber__Group__010316 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__1_in_rule__AutoNumber__Group__010319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_176_in_rule__AutoNumber__Group__0__Impl10347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__1__Impl_in_rule__AutoNumber__Group__110378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__0_in_rule__AutoNumber__Group__1__Impl10405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__0__Impl_in_rule__AutoNumber__Group_1__010440 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__1_in_rule__AutoNumber__Group_1__010443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__0__Impl10470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__1__Impl_in_rule__AutoNumber__Group_1__110499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__1__Impl10527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Color__Group__0__Impl_in_rule__Color__Group__010562 = new BitSet(new long[]{0xFFFFFFFFFFFFF800L,0xFFFFFFFFFFFFFFFFL,0x000000000FFFFFFFL});
    public static final BitSet FOLLOW_rule__Color__Group__1_in_rule__Color__Group__010565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_177_in_rule__Color__Group__0__Impl10596 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_177_in_rule__Color__Group__0__Impl10612 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_rule__Color__Group__1__Impl_in_rule__Color__Group__110647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Color__Alternatives_1_in_rule__Color__Group__1__Impl10674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__0__Impl_in_rule__Title__Group__010708 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Title__Group__1_in_rule__Title__Group__010711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_178_in_rule__Title__Group__0__Impl10739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__1__Impl_in_rule__Title__Group__110770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Title__Group__1__Impl10797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__0__Impl_in_rule__Legend__Group__010830 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000000L,0x0010000070000000L});
    public static final BitSet FOLLOW_rule__Legend__Group__1_in_rule__Legend__Group__010833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_179_in_rule__Legend__Group__0__Impl10861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__1__Impl_in_rule__Legend__Group__110892 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000000L,0x0010000070000000L});
    public static final BitSet FOLLOW_rule__Legend__Group__2_in_rule__Legend__Group__110895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Alternatives_1_in_rule__Legend__Group__1__Impl10922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__2__Impl_in_rule__Legend__Group__210953 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000000L,0x0010000070000000L});
    public static final BitSet FOLLOW_rule__Legend__Group__3_in_rule__Legend__Group__210956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__IdsAssignment_2_in_rule__Legend__Group__2__Impl10983 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__Legend__Group__3__Impl_in_rule__Legend__Group__311014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_180_in_rule__Legend__Group__3__Impl11042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__0__Impl_in_rule__Newpage__Group__011081 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Newpage__Group__1_in_rule__Newpage__Group__011084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_181_in_rule__Newpage__Group__0__Impl11112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__1__Impl_in_rule__Newpage__Group__111143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Newpage__Group__1__Impl11171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_rule__Model__DiagramsAssignment11211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_111242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Instruction__Name1Assignment_0_011273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Instruction__Name2Assignment_0_211304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_0_111335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_1_111366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_2_111397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_3_111428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_4_111459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Legend__IdsAssignment_211490 = new BitSet(new long[]{0x0000000000000002L});

}