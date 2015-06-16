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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NEWLINE", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "'AliceBlue'", "'AntiqueWhite'", "'Aqua'", "'Aquamarine'", "'Azure'", "'Beige'", "'Bisque'", "'Black'", "'BlanchedAlmond'", "'Blue'", "'BlueViolet'", "'Brown'", "'BurlyWood'", "'CadetBlue'", "'Chartreuse'", "'Chocolate'", "'Coral'", "'CornflowerBlue'", "'Cornsilk'", "'Crimson'", "'Cyan'", "'DarkBlue'", "'DarkCyan'", "'DarkGoldenRod'", "'DarkGray'", "'DarkGreen'", "'DarkGrey'", "'DarkKhaki'", "'DarkMagenta'", "'DarkOliveGreen'", "'DarkOrchid'", "'DarkRed'", "'DarkSalmo'", "'DarkSeaGreen'", "'DarkSlateBlue'", "'DarkSlateGray'", "'DarkSlateGrey'", "'DarkTurquoise'", "'DarkViolet'", "'Darkorange'", "'DeepPink'", "'DeepSkyBlue'", "'DimGray'", "'DimGrey'", "'DodgerBlue'", "'FireBrick'", "'FloralWhite'", "'ForestGreen'", "'Fuchsia'", "'Gainsboro'", "'GhostWhite'", "'Gold'", "'GoldenRod'", "'Gray'", "'Green'", "'GreenYellow'", "'Grey'", "'HoneyDew'", "'HotPink'", "'IndianRed'", "'Indigo'", "'Ivory'", "'Khaki'", "'Lavender'", "'LavenderBlush'", "'LawnGreen'", "'LemonChiffon'", "'LightBlue'", "'LightCoral'", "'LightCyan'", "'LightGoldenRodYellow'", "'LightGray'", "'LightGreen'", "'LightGrey'", "'LightPink'", "'LightSalmon'", "'LightSeaGreen'", "'LightSkyBlue'", "'LightSlateGray'", "'LightSlateGrey'", "'LightSteelBlue'", "'LightYellow'", "'Lime'", "'LimeGreen'", "'Linen'", "'Magenta'", "'Maroon'", "'MediumAquaMarine'", "'MediumBlue'", "'MediumOrchid'", "'MediumPurple'", "'MediumSeaGreen'", "'MediumSlateBlue'", "'MediumSpringGreen'", "'MediumTurquoise'", "'MediumVioletRed'", "'MidnightBlue'", "'MintCream'", "'MistyRose'", "'Moccasin'", "'NavajoWhite'", "'Navy'", "'OldLace'", "'Olive'", "'OliveDrab'", "'OrangeRed'", "'Orchid'", "'PaleGoldenRod'", "'PaleGreen'", "'PaleTurquoise'", "'PaleVioletRed'", "'PapayaWhip'", "'PeachPuff'", "'Peru'", "'Pink'", "'Plum'", "'PowderBlue'", "'Purple'", "'Red'", "'RosyBrown'", "'RoyalBlue'", "'SaddleBrown'", "'Salmon'", "'SandyBrown'", "'SeaGreen'", "'Sienna'", "'Silver'", "'SkyBlue'", "'SlateBlue'", "'SlateGray'", "'SlateGrey'", "'Snow'", "'SpringGreen'", "'SteelBlue'", "'Tan'", "'Teal'", "'Thistle'", "'Tomato'", "'Turquoise'", "'Violet'", "'Wheat'", "'White'", "'WhiteSmoke'", "'Yellow'", "'YellowGreen'", "'right'", "'left'", "'center'", "'@startuml'", "'@enduml'", "':'", "'-'", "'>'", "'<'", "'x'", "'\\\\'", "'/'", "'\\\\\\\\'", "'o'", "'|'", "'actor'", "'boundary'", "'control'", "'entity'", "'database'", "'autonumber'", "'#'", "'title'", "'legend'", "'endlegend'", "'newpage'", "'alt'", "'end'", "'else'"
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
    public static final int RULE_ID=5;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
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
    public static final int RULE_NEWLINE=4;
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
    public static final int T__184=184;
    public static final int T__183=183;
    public static final int T__90=90;
    public static final int T__185=185;
    public static final int T__180=180;
    public static final int T__182=182;
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
    public static final int RULE_SL_COMMENT=8;
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
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
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

                if ( (LA1_0==160) ) {
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:125:1: ruleInstruction : ( ( rule__Instruction__Group__0 ) ) ;
    public final void ruleInstruction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:129:2: ( ( ( rule__Instruction__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:130:1: ( ( rule__Instruction__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:130:1: ( ( rule__Instruction__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:131:1: ( rule__Instruction__Group__0 )
            {
             before(grammarAccess.getInstructionAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:132:1: ( rule__Instruction__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:132:2: rule__Instruction__Group__0
            {
            pushFollow(FOLLOW_rule__Instruction__Group__0_in_ruleInstruction215);
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


    // $ANTLR start "entryRuleAltElse"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:340:1: entryRuleAltElse : ruleAltElse EOF ;
    public final void entryRuleAltElse() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:341:1: ( ruleAltElse EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:342:1: ruleAltElse EOF
            {
             before(grammarAccess.getAltElseRule()); 
            pushFollow(FOLLOW_ruleAltElse_in_entryRuleAltElse662);
            ruleAltElse();

            state._fsp--;

             after(grammarAccess.getAltElseRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAltElse669); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:349:1: ruleAltElse : ( ( rule__AltElse__Group__0 ) ) ;
    public final void ruleAltElse() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:353:2: ( ( ( rule__AltElse__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:354:1: ( ( rule__AltElse__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:354:1: ( ( rule__AltElse__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:355:1: ( rule__AltElse__Group__0 )
            {
             before(grammarAccess.getAltElseAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:356:1: ( rule__AltElse__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:356:2: rule__AltElse__Group__0
            {
            pushFollow(FOLLOW_rule__AltElse__Group__0_in_ruleAltElse695);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:368:1: entryRuleElse : ruleElse EOF ;
    public final void entryRuleElse() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:369:1: ( ruleElse EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:370:1: ruleElse EOF
            {
             before(grammarAccess.getElseRule()); 
            pushFollow(FOLLOW_ruleElse_in_entryRuleElse722);
            ruleElse();

            state._fsp--;

             after(grammarAccess.getElseRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElse729); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:377:1: ruleElse : ( ( rule__Else__Group__0 ) ) ;
    public final void ruleElse() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:381:2: ( ( ( rule__Else__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:382:1: ( ( rule__Else__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:382:1: ( ( rule__Else__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:383:1: ( rule__Else__Group__0 )
            {
             before(grammarAccess.getElseAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:384:1: ( rule__Else__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:384:2: rule__Else__Group__0
            {
            pushFollow(FOLLOW_rule__Else__Group__0_in_ruleElse755);
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


    // $ANTLR start "rule__Instruction__Alternatives_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:396:1: rule__Instruction__Alternatives_0 : ( ( ( rule__Instruction__Group_0_0__0 ) ) | ( ( rule__Instruction__Group_0_1__0 ) ) | ( ruleAutoNumber ) | ( ruleTitle ) | ( ruleLegend ) | ( ruleNewpage ) | ( ruleAltElse ) );
    public final void rule__Instruction__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:400:1: ( ( ( rule__Instruction__Group_0_0__0 ) ) | ( ( rule__Instruction__Group_0_1__0 ) ) | ( ruleAutoNumber ) | ( ruleTitle ) | ( ruleLegend ) | ( ruleNewpage ) | ( ruleAltElse ) )
            int alt2=7;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt2=1;
                }
                break;
            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
                {
                alt2=2;
                }
                break;
            case 177:
                {
                alt2=3;
                }
                break;
            case 179:
                {
                alt2=4;
                }
                break;
            case 180:
                {
                alt2=5;
                }
                break;
            case 182:
                {
                alt2=6;
                }
                break;
            case 183:
                {
                alt2=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:401:1: ( ( rule__Instruction__Group_0_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:401:1: ( ( rule__Instruction__Group_0_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:402:1: ( rule__Instruction__Group_0_0__0 )
                    {
                     before(grammarAccess.getInstructionAccess().getGroup_0_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:403:1: ( rule__Instruction__Group_0_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:403:2: rule__Instruction__Group_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_0_0__0_in_rule__Instruction__Alternatives_0791);
                    rule__Instruction__Group_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInstructionAccess().getGroup_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:407:6: ( ( rule__Instruction__Group_0_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:407:6: ( ( rule__Instruction__Group_0_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:408:1: ( rule__Instruction__Group_0_1__0 )
                    {
                     before(grammarAccess.getInstructionAccess().getGroup_0_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:409:1: ( rule__Instruction__Group_0_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:409:2: rule__Instruction__Group_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_0_1__0_in_rule__Instruction__Alternatives_0809);
                    rule__Instruction__Group_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInstructionAccess().getGroup_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:413:6: ( ruleAutoNumber )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:413:6: ( ruleAutoNumber )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:414:1: ruleAutoNumber
                    {
                     before(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 
                    pushFollow(FOLLOW_ruleAutoNumber_in_rule__Instruction__Alternatives_0827);
                    ruleAutoNumber();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:419:6: ( ruleTitle )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:419:6: ( ruleTitle )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:420:1: ruleTitle
                    {
                     before(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 
                    pushFollow(FOLLOW_ruleTitle_in_rule__Instruction__Alternatives_0844);
                    ruleTitle();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:425:6: ( ruleLegend )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:425:6: ( ruleLegend )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:426:1: ruleLegend
                    {
                     before(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 
                    pushFollow(FOLLOW_ruleLegend_in_rule__Instruction__Alternatives_0861);
                    ruleLegend();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:431:6: ( ruleNewpage )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:431:6: ( ruleNewpage )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:432:1: ruleNewpage
                    {
                     before(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 
                    pushFollow(FOLLOW_ruleNewpage_in_rule__Instruction__Alternatives_0878);
                    ruleNewpage();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:437:6: ( ruleAltElse )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:437:6: ( ruleAltElse )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:438:1: ruleAltElse
                    {
                     before(grammarAccess.getInstructionAccess().getAltElseParserRuleCall_0_6()); 
                    pushFollow(FOLLOW_ruleAltElse_in_rule__Instruction__Alternatives_0895);
                    ruleAltElse();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getAltElseParserRuleCall_0_6()); 

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


    // $ANTLR start "rule__Sequence__Alternatives"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:448:1: rule__Sequence__Alternatives : ( ( ( rule__Sequence__Group_0__0 ) ) | ( ( rule__Sequence__Group_1__0 ) ) | ( ( rule__Sequence__Group_2__0 ) ) | ( ( rule__Sequence__Group_3__0 ) ) | ( ( rule__Sequence__Group_4__0 ) ) | ( ( rule__Sequence__Group_5__0 ) ) | ( ( rule__Sequence__Group_6__0 ) ) | ( ( rule__Sequence__Group_7__0 ) ) | ( ( rule__Sequence__Group_8__0 ) ) | ( ( rule__Sequence__Group_9__0 ) ) | ( ( rule__Sequence__Group_10__0 ) ) | ( ( rule__Sequence__Group_11__0 ) ) | ( ( rule__Sequence__Group_12__0 ) ) | ( ( rule__Sequence__Group_13__0 ) ) | ( ( rule__Sequence__Group_14__0 ) ) | ( ( rule__Sequence__Group_15__0 ) ) | ( ( rule__Sequence__Group_16__0 ) ) | ( ( rule__Sequence__Group_17__0 ) ) | ( ( rule__Sequence__Group_18__0 ) ) | ( ( rule__Sequence__Group_19__0 ) ) | ( '.' ) );
    public final void rule__Sequence__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:452:1: ( ( ( rule__Sequence__Group_0__0 ) ) | ( ( rule__Sequence__Group_1__0 ) ) | ( ( rule__Sequence__Group_2__0 ) ) | ( ( rule__Sequence__Group_3__0 ) ) | ( ( rule__Sequence__Group_4__0 ) ) | ( ( rule__Sequence__Group_5__0 ) ) | ( ( rule__Sequence__Group_6__0 ) ) | ( ( rule__Sequence__Group_7__0 ) ) | ( ( rule__Sequence__Group_8__0 ) ) | ( ( rule__Sequence__Group_9__0 ) ) | ( ( rule__Sequence__Group_10__0 ) ) | ( ( rule__Sequence__Group_11__0 ) ) | ( ( rule__Sequence__Group_12__0 ) ) | ( ( rule__Sequence__Group_13__0 ) ) | ( ( rule__Sequence__Group_14__0 ) ) | ( ( rule__Sequence__Group_15__0 ) ) | ( ( rule__Sequence__Group_16__0 ) ) | ( ( rule__Sequence__Group_17__0 ) ) | ( ( rule__Sequence__Group_18__0 ) ) | ( ( rule__Sequence__Group_19__0 ) ) | ( '.' ) )
            int alt3=21;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:453:1: ( ( rule__Sequence__Group_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:453:1: ( ( rule__Sequence__Group_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:454:1: ( rule__Sequence__Group_0__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:455:1: ( rule__Sequence__Group_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:455:2: rule__Sequence__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_0__0_in_rule__Sequence__Alternatives927);
                    rule__Sequence__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:459:6: ( ( rule__Sequence__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:459:6: ( ( rule__Sequence__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:460:1: ( rule__Sequence__Group_1__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:461:1: ( rule__Sequence__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:461:2: rule__Sequence__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_1__0_in_rule__Sequence__Alternatives945);
                    rule__Sequence__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:465:6: ( ( rule__Sequence__Group_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:465:6: ( ( rule__Sequence__Group_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:466:1: ( rule__Sequence__Group_2__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:467:1: ( rule__Sequence__Group_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:467:2: rule__Sequence__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_2__0_in_rule__Sequence__Alternatives963);
                    rule__Sequence__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:471:6: ( ( rule__Sequence__Group_3__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:471:6: ( ( rule__Sequence__Group_3__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:472:1: ( rule__Sequence__Group_3__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_3()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:473:1: ( rule__Sequence__Group_3__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:473:2: rule__Sequence__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_3__0_in_rule__Sequence__Alternatives981);
                    rule__Sequence__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:477:6: ( ( rule__Sequence__Group_4__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:477:6: ( ( rule__Sequence__Group_4__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:478:1: ( rule__Sequence__Group_4__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_4()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:479:1: ( rule__Sequence__Group_4__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:479:2: rule__Sequence__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_4__0_in_rule__Sequence__Alternatives999);
                    rule__Sequence__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:483:6: ( ( rule__Sequence__Group_5__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:483:6: ( ( rule__Sequence__Group_5__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:484:1: ( rule__Sequence__Group_5__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_5()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:485:1: ( rule__Sequence__Group_5__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:485:2: rule__Sequence__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_5__0_in_rule__Sequence__Alternatives1017);
                    rule__Sequence__Group_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:489:6: ( ( rule__Sequence__Group_6__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:489:6: ( ( rule__Sequence__Group_6__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:490:1: ( rule__Sequence__Group_6__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_6()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:491:1: ( rule__Sequence__Group_6__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:491:2: rule__Sequence__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_6__0_in_rule__Sequence__Alternatives1035);
                    rule__Sequence__Group_6__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:495:6: ( ( rule__Sequence__Group_7__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:495:6: ( ( rule__Sequence__Group_7__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:496:1: ( rule__Sequence__Group_7__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_7()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:497:1: ( rule__Sequence__Group_7__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:497:2: rule__Sequence__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_7__0_in_rule__Sequence__Alternatives1053);
                    rule__Sequence__Group_7__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:501:6: ( ( rule__Sequence__Group_8__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:501:6: ( ( rule__Sequence__Group_8__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:502:1: ( rule__Sequence__Group_8__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_8()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:503:1: ( rule__Sequence__Group_8__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:503:2: rule__Sequence__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_8__0_in_rule__Sequence__Alternatives1071);
                    rule__Sequence__Group_8__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:507:6: ( ( rule__Sequence__Group_9__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:507:6: ( ( rule__Sequence__Group_9__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:508:1: ( rule__Sequence__Group_9__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_9()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:509:1: ( rule__Sequence__Group_9__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:509:2: rule__Sequence__Group_9__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_9__0_in_rule__Sequence__Alternatives1089);
                    rule__Sequence__Group_9__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:513:6: ( ( rule__Sequence__Group_10__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:513:6: ( ( rule__Sequence__Group_10__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:514:1: ( rule__Sequence__Group_10__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_10()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:515:1: ( rule__Sequence__Group_10__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:515:2: rule__Sequence__Group_10__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_10__0_in_rule__Sequence__Alternatives1107);
                    rule__Sequence__Group_10__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:519:6: ( ( rule__Sequence__Group_11__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:519:6: ( ( rule__Sequence__Group_11__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:520:1: ( rule__Sequence__Group_11__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_11()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:521:1: ( rule__Sequence__Group_11__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:521:2: rule__Sequence__Group_11__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_11__0_in_rule__Sequence__Alternatives1125);
                    rule__Sequence__Group_11__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:525:6: ( ( rule__Sequence__Group_12__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:525:6: ( ( rule__Sequence__Group_12__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:526:1: ( rule__Sequence__Group_12__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_12()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:527:1: ( rule__Sequence__Group_12__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:527:2: rule__Sequence__Group_12__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_12__0_in_rule__Sequence__Alternatives1143);
                    rule__Sequence__Group_12__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:531:6: ( ( rule__Sequence__Group_13__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:531:6: ( ( rule__Sequence__Group_13__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:532:1: ( rule__Sequence__Group_13__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_13()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:533:1: ( rule__Sequence__Group_13__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:533:2: rule__Sequence__Group_13__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_13__0_in_rule__Sequence__Alternatives1161);
                    rule__Sequence__Group_13__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:537:6: ( ( rule__Sequence__Group_14__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:537:6: ( ( rule__Sequence__Group_14__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:538:1: ( rule__Sequence__Group_14__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_14()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:539:1: ( rule__Sequence__Group_14__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:539:2: rule__Sequence__Group_14__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_14__0_in_rule__Sequence__Alternatives1179);
                    rule__Sequence__Group_14__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:543:6: ( ( rule__Sequence__Group_15__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:543:6: ( ( rule__Sequence__Group_15__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:544:1: ( rule__Sequence__Group_15__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_15()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:545:1: ( rule__Sequence__Group_15__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:545:2: rule__Sequence__Group_15__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_15__0_in_rule__Sequence__Alternatives1197);
                    rule__Sequence__Group_15__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:549:6: ( ( rule__Sequence__Group_16__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:549:6: ( ( rule__Sequence__Group_16__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:550:1: ( rule__Sequence__Group_16__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_16()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:551:1: ( rule__Sequence__Group_16__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:551:2: rule__Sequence__Group_16__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_16__0_in_rule__Sequence__Alternatives1215);
                    rule__Sequence__Group_16__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:555:6: ( ( rule__Sequence__Group_17__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:555:6: ( ( rule__Sequence__Group_17__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:556:1: ( rule__Sequence__Group_17__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_17()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:557:1: ( rule__Sequence__Group_17__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:557:2: rule__Sequence__Group_17__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_17__0_in_rule__Sequence__Alternatives1233);
                    rule__Sequence__Group_17__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:561:6: ( ( rule__Sequence__Group_18__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:561:6: ( ( rule__Sequence__Group_18__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:562:1: ( rule__Sequence__Group_18__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_18()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:563:1: ( rule__Sequence__Group_18__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:563:2: rule__Sequence__Group_18__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_18__0_in_rule__Sequence__Alternatives1251);
                    rule__Sequence__Group_18__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:567:6: ( ( rule__Sequence__Group_19__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:567:6: ( ( rule__Sequence__Group_19__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:568:1: ( rule__Sequence__Group_19__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_19()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:569:1: ( rule__Sequence__Group_19__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:569:2: rule__Sequence__Group_19__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_19__0_in_rule__Sequence__Alternatives1269);
                    rule__Sequence__Group_19__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:573:6: ( '.' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:573:6: ( '.' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:574:1: '.'
                    {
                     before(grammarAccess.getSequenceAccess().getFullStopKeyword_20()); 
                    match(input,11,FOLLOW_11_in_rule__Sequence__Alternatives1288); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:586:1: rule__Definition__Alternatives : ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) );
    public final void rule__Definition__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:590:1: ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 172:
                {
                alt4=1;
                }
                break;
            case 173:
                {
                alt4=2;
                }
                break;
            case 174:
                {
                alt4=3;
                }
                break;
            case 175:
                {
                alt4=4;
                }
                break;
            case 176:
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:591:1: ( ( rule__Definition__Group_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:591:1: ( ( rule__Definition__Group_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:592:1: ( rule__Definition__Group_0__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:593:1: ( rule__Definition__Group_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:593:2: rule__Definition__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives1322);
                    rule__Definition__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:597:6: ( ( rule__Definition__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:597:6: ( ( rule__Definition__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:598:1: ( rule__Definition__Group_1__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:599:1: ( rule__Definition__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:599:2: rule__Definition__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives1340);
                    rule__Definition__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:603:6: ( ( rule__Definition__Group_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:603:6: ( ( rule__Definition__Group_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:604:1: ( rule__Definition__Group_2__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:605:1: ( rule__Definition__Group_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:605:2: rule__Definition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives1358);
                    rule__Definition__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:609:6: ( ( rule__Definition__Group_3__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:609:6: ( ( rule__Definition__Group_3__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:610:1: ( rule__Definition__Group_3__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_3()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:611:1: ( rule__Definition__Group_3__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:611:2: rule__Definition__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives1376);
                    rule__Definition__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:615:6: ( ( rule__Definition__Group_4__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:615:6: ( ( rule__Definition__Group_4__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:616:1: ( rule__Definition__Group_4__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_4()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:617:1: ( rule__Definition__Group_4__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:617:2: rule__Definition__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives1394);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:626:1: rule__Color__Alternatives_1 : ( ( 'AliceBlue' ) | ( 'AntiqueWhite' ) | ( 'Aqua' ) | ( 'Aquamarine' ) | ( 'Azure' ) | ( 'Beige' ) | ( 'Bisque' ) | ( 'Black' ) | ( 'BlanchedAlmond' ) | ( 'Blue' ) | ( 'BlueViolet' ) | ( 'Brown' ) | ( 'BurlyWood' ) | ( 'CadetBlue' ) | ( 'Chartreuse' ) | ( 'Chocolate' ) | ( 'Coral' ) | ( 'CornflowerBlue' ) | ( 'Cornsilk' ) | ( 'Crimson' ) | ( 'Cyan' ) | ( 'DarkBlue' ) | ( 'DarkCyan' ) | ( 'DarkGoldenRod' ) | ( 'DarkGray' ) | ( 'DarkGreen' ) | ( 'DarkGrey' ) | ( 'DarkKhaki' ) | ( 'DarkMagenta' ) | ( 'DarkOliveGreen' ) | ( 'DarkOrchid' ) | ( 'DarkRed' ) | ( 'DarkSalmo' ) | ( 'DarkSeaGreen' ) | ( 'DarkSlateBlue' ) | ( 'DarkSlateGray' ) | ( 'DarkSlateGrey' ) | ( 'DarkTurquoise' ) | ( 'DarkViolet' ) | ( 'Darkorange' ) | ( 'DeepPink' ) | ( 'DeepSkyBlue' ) | ( 'DimGray' ) | ( 'DimGrey' ) | ( 'DodgerBlue' ) | ( 'FireBrick' ) | ( 'FloralWhite' ) | ( 'ForestGreen' ) | ( 'Fuchsia' ) | ( 'Gainsboro' ) | ( 'GhostWhite' ) | ( 'Gold' ) | ( 'GoldenRod' ) | ( 'Gray' ) | ( 'Green' ) | ( 'GreenYellow' ) | ( 'Grey' ) | ( 'HoneyDew' ) | ( 'HotPink' ) | ( 'IndianRed' ) | ( 'Indigo' ) | ( 'Ivory' ) | ( 'Khaki' ) | ( 'Lavender' ) | ( 'LavenderBlush' ) | ( 'LawnGreen' ) | ( 'LemonChiffon' ) | ( 'LightBlue' ) | ( 'LightCoral' ) | ( 'LightCyan' ) | ( 'LightGoldenRodYellow' ) | ( 'LightGray' ) | ( 'LightGreen' ) | ( 'LightGrey' ) | ( 'LightPink' ) | ( 'LightSalmon' ) | ( 'LightSeaGreen' ) | ( 'LightSkyBlue' ) | ( 'LightSlateGray' ) | ( 'LightSlateGrey' ) | ( 'LightSteelBlue' ) | ( 'LightYellow' ) | ( 'Lime' ) | ( 'LimeGreen' ) | ( 'Linen' ) | ( 'Magenta' ) | ( 'Maroon' ) | ( 'MediumAquaMarine' ) | ( 'MediumBlue' ) | ( 'MediumOrchid' ) | ( 'MediumPurple' ) | ( 'MediumSeaGreen' ) | ( 'MediumSlateBlue' ) | ( 'MediumSpringGreen' ) | ( 'MediumTurquoise' ) | ( 'MediumVioletRed' ) | ( 'MidnightBlue' ) | ( 'MintCream' ) | ( 'MistyRose' ) | ( 'Moccasin' ) | ( 'NavajoWhite' ) | ( 'Navy' ) | ( 'OldLace' ) | ( 'Olive' ) | ( 'OliveDrab' ) | ( 'OrangeRed' ) | ( 'Orchid' ) | ( 'PaleGoldenRod' ) | ( 'PaleGreen' ) | ( 'PaleTurquoise' ) | ( 'PaleVioletRed' ) | ( 'PapayaWhip' ) | ( 'PeachPuff' ) | ( 'Peru' ) | ( 'Pink' ) | ( 'Plum' ) | ( 'PowderBlue' ) | ( 'Purple' ) | ( 'Red' ) | ( 'RosyBrown' ) | ( 'RoyalBlue' ) | ( 'SaddleBrown' ) | ( 'Salmon' ) | ( 'SandyBrown' ) | ( 'SeaGreen' ) | ( 'Sienna' ) | ( 'Silver' ) | ( 'SkyBlue' ) | ( 'SlateBlue' ) | ( 'SlateGray' ) | ( 'SlateGrey' ) | ( 'Snow' ) | ( 'SpringGreen' ) | ( 'SteelBlue' ) | ( 'Tan' ) | ( 'Teal' ) | ( 'Thistle' ) | ( 'Tomato' ) | ( 'Turquoise' ) | ( 'Violet' ) | ( 'Wheat' ) | ( 'White' ) | ( 'WhiteSmoke' ) | ( 'Yellow' ) | ( 'YellowGreen' ) );
    public final void rule__Color__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:630:1: ( ( 'AliceBlue' ) | ( 'AntiqueWhite' ) | ( 'Aqua' ) | ( 'Aquamarine' ) | ( 'Azure' ) | ( 'Beige' ) | ( 'Bisque' ) | ( 'Black' ) | ( 'BlanchedAlmond' ) | ( 'Blue' ) | ( 'BlueViolet' ) | ( 'Brown' ) | ( 'BurlyWood' ) | ( 'CadetBlue' ) | ( 'Chartreuse' ) | ( 'Chocolate' ) | ( 'Coral' ) | ( 'CornflowerBlue' ) | ( 'Cornsilk' ) | ( 'Crimson' ) | ( 'Cyan' ) | ( 'DarkBlue' ) | ( 'DarkCyan' ) | ( 'DarkGoldenRod' ) | ( 'DarkGray' ) | ( 'DarkGreen' ) | ( 'DarkGrey' ) | ( 'DarkKhaki' ) | ( 'DarkMagenta' ) | ( 'DarkOliveGreen' ) | ( 'DarkOrchid' ) | ( 'DarkRed' ) | ( 'DarkSalmo' ) | ( 'DarkSeaGreen' ) | ( 'DarkSlateBlue' ) | ( 'DarkSlateGray' ) | ( 'DarkSlateGrey' ) | ( 'DarkTurquoise' ) | ( 'DarkViolet' ) | ( 'Darkorange' ) | ( 'DeepPink' ) | ( 'DeepSkyBlue' ) | ( 'DimGray' ) | ( 'DimGrey' ) | ( 'DodgerBlue' ) | ( 'FireBrick' ) | ( 'FloralWhite' ) | ( 'ForestGreen' ) | ( 'Fuchsia' ) | ( 'Gainsboro' ) | ( 'GhostWhite' ) | ( 'Gold' ) | ( 'GoldenRod' ) | ( 'Gray' ) | ( 'Green' ) | ( 'GreenYellow' ) | ( 'Grey' ) | ( 'HoneyDew' ) | ( 'HotPink' ) | ( 'IndianRed' ) | ( 'Indigo' ) | ( 'Ivory' ) | ( 'Khaki' ) | ( 'Lavender' ) | ( 'LavenderBlush' ) | ( 'LawnGreen' ) | ( 'LemonChiffon' ) | ( 'LightBlue' ) | ( 'LightCoral' ) | ( 'LightCyan' ) | ( 'LightGoldenRodYellow' ) | ( 'LightGray' ) | ( 'LightGreen' ) | ( 'LightGrey' ) | ( 'LightPink' ) | ( 'LightSalmon' ) | ( 'LightSeaGreen' ) | ( 'LightSkyBlue' ) | ( 'LightSlateGray' ) | ( 'LightSlateGrey' ) | ( 'LightSteelBlue' ) | ( 'LightYellow' ) | ( 'Lime' ) | ( 'LimeGreen' ) | ( 'Linen' ) | ( 'Magenta' ) | ( 'Maroon' ) | ( 'MediumAquaMarine' ) | ( 'MediumBlue' ) | ( 'MediumOrchid' ) | ( 'MediumPurple' ) | ( 'MediumSeaGreen' ) | ( 'MediumSlateBlue' ) | ( 'MediumSpringGreen' ) | ( 'MediumTurquoise' ) | ( 'MediumVioletRed' ) | ( 'MidnightBlue' ) | ( 'MintCream' ) | ( 'MistyRose' ) | ( 'Moccasin' ) | ( 'NavajoWhite' ) | ( 'Navy' ) | ( 'OldLace' ) | ( 'Olive' ) | ( 'OliveDrab' ) | ( 'OrangeRed' ) | ( 'Orchid' ) | ( 'PaleGoldenRod' ) | ( 'PaleGreen' ) | ( 'PaleTurquoise' ) | ( 'PaleVioletRed' ) | ( 'PapayaWhip' ) | ( 'PeachPuff' ) | ( 'Peru' ) | ( 'Pink' ) | ( 'Plum' ) | ( 'PowderBlue' ) | ( 'Purple' ) | ( 'Red' ) | ( 'RosyBrown' ) | ( 'RoyalBlue' ) | ( 'SaddleBrown' ) | ( 'Salmon' ) | ( 'SandyBrown' ) | ( 'SeaGreen' ) | ( 'Sienna' ) | ( 'Silver' ) | ( 'SkyBlue' ) | ( 'SlateBlue' ) | ( 'SlateGray' ) | ( 'SlateGrey' ) | ( 'Snow' ) | ( 'SpringGreen' ) | ( 'SteelBlue' ) | ( 'Tan' ) | ( 'Teal' ) | ( 'Thistle' ) | ( 'Tomato' ) | ( 'Turquoise' ) | ( 'Violet' ) | ( 'Wheat' ) | ( 'White' ) | ( 'WhiteSmoke' ) | ( 'Yellow' ) | ( 'YellowGreen' ) )
            int alt5=145;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt5=1;
                }
                break;
            case 13:
                {
                alt5=2;
                }
                break;
            case 14:
                {
                alt5=3;
                }
                break;
            case 15:
                {
                alt5=4;
                }
                break;
            case 16:
                {
                alt5=5;
                }
                break;
            case 17:
                {
                alt5=6;
                }
                break;
            case 18:
                {
                alt5=7;
                }
                break;
            case 19:
                {
                alt5=8;
                }
                break;
            case 20:
                {
                alt5=9;
                }
                break;
            case 21:
                {
                alt5=10;
                }
                break;
            case 22:
                {
                alt5=11;
                }
                break;
            case 23:
                {
                alt5=12;
                }
                break;
            case 24:
                {
                alt5=13;
                }
                break;
            case 25:
                {
                alt5=14;
                }
                break;
            case 26:
                {
                alt5=15;
                }
                break;
            case 27:
                {
                alt5=16;
                }
                break;
            case 28:
                {
                alt5=17;
                }
                break;
            case 29:
                {
                alt5=18;
                }
                break;
            case 30:
                {
                alt5=19;
                }
                break;
            case 31:
                {
                alt5=20;
                }
                break;
            case 32:
                {
                alt5=21;
                }
                break;
            case 33:
                {
                alt5=22;
                }
                break;
            case 34:
                {
                alt5=23;
                }
                break;
            case 35:
                {
                alt5=24;
                }
                break;
            case 36:
                {
                alt5=25;
                }
                break;
            case 37:
                {
                alt5=26;
                }
                break;
            case 38:
                {
                alt5=27;
                }
                break;
            case 39:
                {
                alt5=28;
                }
                break;
            case 40:
                {
                alt5=29;
                }
                break;
            case 41:
                {
                alt5=30;
                }
                break;
            case 42:
                {
                alt5=31;
                }
                break;
            case 43:
                {
                alt5=32;
                }
                break;
            case 44:
                {
                alt5=33;
                }
                break;
            case 45:
                {
                alt5=34;
                }
                break;
            case 46:
                {
                alt5=35;
                }
                break;
            case 47:
                {
                alt5=36;
                }
                break;
            case 48:
                {
                alt5=37;
                }
                break;
            case 49:
                {
                alt5=38;
                }
                break;
            case 50:
                {
                alt5=39;
                }
                break;
            case 51:
                {
                alt5=40;
                }
                break;
            case 52:
                {
                alt5=41;
                }
                break;
            case 53:
                {
                alt5=42;
                }
                break;
            case 54:
                {
                alt5=43;
                }
                break;
            case 55:
                {
                alt5=44;
                }
                break;
            case 56:
                {
                alt5=45;
                }
                break;
            case 57:
                {
                alt5=46;
                }
                break;
            case 58:
                {
                alt5=47;
                }
                break;
            case 59:
                {
                alt5=48;
                }
                break;
            case 60:
                {
                alt5=49;
                }
                break;
            case 61:
                {
                alt5=50;
                }
                break;
            case 62:
                {
                alt5=51;
                }
                break;
            case 63:
                {
                alt5=52;
                }
                break;
            case 64:
                {
                alt5=53;
                }
                break;
            case 65:
                {
                alt5=54;
                }
                break;
            case 66:
                {
                alt5=55;
                }
                break;
            case 67:
                {
                alt5=56;
                }
                break;
            case 68:
                {
                alt5=57;
                }
                break;
            case 69:
                {
                alt5=58;
                }
                break;
            case 70:
                {
                alt5=59;
                }
                break;
            case 71:
                {
                alt5=60;
                }
                break;
            case 72:
                {
                alt5=61;
                }
                break;
            case 73:
                {
                alt5=62;
                }
                break;
            case 74:
                {
                alt5=63;
                }
                break;
            case 75:
                {
                alt5=64;
                }
                break;
            case 76:
                {
                alt5=65;
                }
                break;
            case 77:
                {
                alt5=66;
                }
                break;
            case 78:
                {
                alt5=67;
                }
                break;
            case 79:
                {
                alt5=68;
                }
                break;
            case 80:
                {
                alt5=69;
                }
                break;
            case 81:
                {
                alt5=70;
                }
                break;
            case 82:
                {
                alt5=71;
                }
                break;
            case 83:
                {
                alt5=72;
                }
                break;
            case 84:
                {
                alt5=73;
                }
                break;
            case 85:
                {
                alt5=74;
                }
                break;
            case 86:
                {
                alt5=75;
                }
                break;
            case 87:
                {
                alt5=76;
                }
                break;
            case 88:
                {
                alt5=77;
                }
                break;
            case 89:
                {
                alt5=78;
                }
                break;
            case 90:
                {
                alt5=79;
                }
                break;
            case 91:
                {
                alt5=80;
                }
                break;
            case 92:
                {
                alt5=81;
                }
                break;
            case 93:
                {
                alt5=82;
                }
                break;
            case 94:
                {
                alt5=83;
                }
                break;
            case 95:
                {
                alt5=84;
                }
                break;
            case 96:
                {
                alt5=85;
                }
                break;
            case 97:
                {
                alt5=86;
                }
                break;
            case 98:
                {
                alt5=87;
                }
                break;
            case 99:
                {
                alt5=88;
                }
                break;
            case 100:
                {
                alt5=89;
                }
                break;
            case 101:
                {
                alt5=90;
                }
                break;
            case 102:
                {
                alt5=91;
                }
                break;
            case 103:
                {
                alt5=92;
                }
                break;
            case 104:
                {
                alt5=93;
                }
                break;
            case 105:
                {
                alt5=94;
                }
                break;
            case 106:
                {
                alt5=95;
                }
                break;
            case 107:
                {
                alt5=96;
                }
                break;
            case 108:
                {
                alt5=97;
                }
                break;
            case 109:
                {
                alt5=98;
                }
                break;
            case 110:
                {
                alt5=99;
                }
                break;
            case 111:
                {
                alt5=100;
                }
                break;
            case 112:
                {
                alt5=101;
                }
                break;
            case 113:
                {
                alt5=102;
                }
                break;
            case 114:
                {
                alt5=103;
                }
                break;
            case 115:
                {
                alt5=104;
                }
                break;
            case 116:
                {
                alt5=105;
                }
                break;
            case 117:
                {
                alt5=106;
                }
                break;
            case 118:
                {
                alt5=107;
                }
                break;
            case 119:
                {
                alt5=108;
                }
                break;
            case 120:
                {
                alt5=109;
                }
                break;
            case 121:
                {
                alt5=110;
                }
                break;
            case 122:
                {
                alt5=111;
                }
                break;
            case 123:
                {
                alt5=112;
                }
                break;
            case 124:
                {
                alt5=113;
                }
                break;
            case 125:
                {
                alt5=114;
                }
                break;
            case 126:
                {
                alt5=115;
                }
                break;
            case 127:
                {
                alt5=116;
                }
                break;
            case 128:
                {
                alt5=117;
                }
                break;
            case 129:
                {
                alt5=118;
                }
                break;
            case 130:
                {
                alt5=119;
                }
                break;
            case 131:
                {
                alt5=120;
                }
                break;
            case 132:
                {
                alt5=121;
                }
                break;
            case 133:
                {
                alt5=122;
                }
                break;
            case 134:
                {
                alt5=123;
                }
                break;
            case 135:
                {
                alt5=124;
                }
                break;
            case 136:
                {
                alt5=125;
                }
                break;
            case 137:
                {
                alt5=126;
                }
                break;
            case 138:
                {
                alt5=127;
                }
                break;
            case 139:
                {
                alt5=128;
                }
                break;
            case 140:
                {
                alt5=129;
                }
                break;
            case 141:
                {
                alt5=130;
                }
                break;
            case 142:
                {
                alt5=131;
                }
                break;
            case 143:
                {
                alt5=132;
                }
                break;
            case 144:
                {
                alt5=133;
                }
                break;
            case 145:
                {
                alt5=134;
                }
                break;
            case 146:
                {
                alt5=135;
                }
                break;
            case 147:
                {
                alt5=136;
                }
                break;
            case 148:
                {
                alt5=137;
                }
                break;
            case 149:
                {
                alt5=138;
                }
                break;
            case 150:
                {
                alt5=139;
                }
                break;
            case 151:
                {
                alt5=140;
                }
                break;
            case 152:
                {
                alt5=141;
                }
                break;
            case 153:
                {
                alt5=142;
                }
                break;
            case 154:
                {
                alt5=143;
                }
                break;
            case 155:
                {
                alt5=144;
                }
                break;
            case 156:
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:631:1: ( 'AliceBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:631:1: ( 'AliceBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:632:1: 'AliceBlue'
                    {
                     before(grammarAccess.getColorAccess().getAliceBlueKeyword_1_0()); 
                    match(input,12,FOLLOW_12_in_rule__Color__Alternatives_11428); 
                     after(grammarAccess.getColorAccess().getAliceBlueKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:639:6: ( 'AntiqueWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:639:6: ( 'AntiqueWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:640:1: 'AntiqueWhite'
                    {
                     before(grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1_1()); 
                    match(input,13,FOLLOW_13_in_rule__Color__Alternatives_11448); 
                     after(grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:647:6: ( 'Aqua' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:647:6: ( 'Aqua' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:648:1: 'Aqua'
                    {
                     before(grammarAccess.getColorAccess().getAquaKeyword_1_2()); 
                    match(input,14,FOLLOW_14_in_rule__Color__Alternatives_11468); 
                     after(grammarAccess.getColorAccess().getAquaKeyword_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:655:6: ( 'Aquamarine' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:655:6: ( 'Aquamarine' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:656:1: 'Aquamarine'
                    {
                     before(grammarAccess.getColorAccess().getAquamarineKeyword_1_3()); 
                    match(input,15,FOLLOW_15_in_rule__Color__Alternatives_11488); 
                     after(grammarAccess.getColorAccess().getAquamarineKeyword_1_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:663:6: ( 'Azure' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:663:6: ( 'Azure' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:664:1: 'Azure'
                    {
                     before(grammarAccess.getColorAccess().getAzureKeyword_1_4()); 
                    match(input,16,FOLLOW_16_in_rule__Color__Alternatives_11508); 
                     after(grammarAccess.getColorAccess().getAzureKeyword_1_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:671:6: ( 'Beige' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:671:6: ( 'Beige' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:672:1: 'Beige'
                    {
                     before(grammarAccess.getColorAccess().getBeigeKeyword_1_5()); 
                    match(input,17,FOLLOW_17_in_rule__Color__Alternatives_11528); 
                     after(grammarAccess.getColorAccess().getBeigeKeyword_1_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:679:6: ( 'Bisque' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:679:6: ( 'Bisque' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:680:1: 'Bisque'
                    {
                     before(grammarAccess.getColorAccess().getBisqueKeyword_1_6()); 
                    match(input,18,FOLLOW_18_in_rule__Color__Alternatives_11548); 
                     after(grammarAccess.getColorAccess().getBisqueKeyword_1_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:687:6: ( 'Black' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:687:6: ( 'Black' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:688:1: 'Black'
                    {
                     before(grammarAccess.getColorAccess().getBlackKeyword_1_7()); 
                    match(input,19,FOLLOW_19_in_rule__Color__Alternatives_11568); 
                     after(grammarAccess.getColorAccess().getBlackKeyword_1_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:695:6: ( 'BlanchedAlmond' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:695:6: ( 'BlanchedAlmond' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:696:1: 'BlanchedAlmond'
                    {
                     before(grammarAccess.getColorAccess().getBlanchedAlmondKeyword_1_8()); 
                    match(input,20,FOLLOW_20_in_rule__Color__Alternatives_11588); 
                     after(grammarAccess.getColorAccess().getBlanchedAlmondKeyword_1_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:703:6: ( 'Blue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:703:6: ( 'Blue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:704:1: 'Blue'
                    {
                     before(grammarAccess.getColorAccess().getBlueKeyword_1_9()); 
                    match(input,21,FOLLOW_21_in_rule__Color__Alternatives_11608); 
                     after(grammarAccess.getColorAccess().getBlueKeyword_1_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:711:6: ( 'BlueViolet' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:711:6: ( 'BlueViolet' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:712:1: 'BlueViolet'
                    {
                     before(grammarAccess.getColorAccess().getBlueVioletKeyword_1_10()); 
                    match(input,22,FOLLOW_22_in_rule__Color__Alternatives_11628); 
                     after(grammarAccess.getColorAccess().getBlueVioletKeyword_1_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:719:6: ( 'Brown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:719:6: ( 'Brown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:720:1: 'Brown'
                    {
                     before(grammarAccess.getColorAccess().getBrownKeyword_1_11()); 
                    match(input,23,FOLLOW_23_in_rule__Color__Alternatives_11648); 
                     after(grammarAccess.getColorAccess().getBrownKeyword_1_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:727:6: ( 'BurlyWood' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:727:6: ( 'BurlyWood' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:728:1: 'BurlyWood'
                    {
                     before(grammarAccess.getColorAccess().getBurlyWoodKeyword_1_12()); 
                    match(input,24,FOLLOW_24_in_rule__Color__Alternatives_11668); 
                     after(grammarAccess.getColorAccess().getBurlyWoodKeyword_1_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:735:6: ( 'CadetBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:735:6: ( 'CadetBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:736:1: 'CadetBlue'
                    {
                     before(grammarAccess.getColorAccess().getCadetBlueKeyword_1_13()); 
                    match(input,25,FOLLOW_25_in_rule__Color__Alternatives_11688); 
                     after(grammarAccess.getColorAccess().getCadetBlueKeyword_1_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:743:6: ( 'Chartreuse' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:743:6: ( 'Chartreuse' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:744:1: 'Chartreuse'
                    {
                     before(grammarAccess.getColorAccess().getChartreuseKeyword_1_14()); 
                    match(input,26,FOLLOW_26_in_rule__Color__Alternatives_11708); 
                     after(grammarAccess.getColorAccess().getChartreuseKeyword_1_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:751:6: ( 'Chocolate' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:751:6: ( 'Chocolate' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:752:1: 'Chocolate'
                    {
                     before(grammarAccess.getColorAccess().getChocolateKeyword_1_15()); 
                    match(input,27,FOLLOW_27_in_rule__Color__Alternatives_11728); 
                     after(grammarAccess.getColorAccess().getChocolateKeyword_1_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:759:6: ( 'Coral' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:759:6: ( 'Coral' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:760:1: 'Coral'
                    {
                     before(grammarAccess.getColorAccess().getCoralKeyword_1_16()); 
                    match(input,28,FOLLOW_28_in_rule__Color__Alternatives_11748); 
                     after(grammarAccess.getColorAccess().getCoralKeyword_1_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:767:6: ( 'CornflowerBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:767:6: ( 'CornflowerBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:768:1: 'CornflowerBlue'
                    {
                     before(grammarAccess.getColorAccess().getCornflowerBlueKeyword_1_17()); 
                    match(input,29,FOLLOW_29_in_rule__Color__Alternatives_11768); 
                     after(grammarAccess.getColorAccess().getCornflowerBlueKeyword_1_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:775:6: ( 'Cornsilk' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:775:6: ( 'Cornsilk' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:776:1: 'Cornsilk'
                    {
                     before(grammarAccess.getColorAccess().getCornsilkKeyword_1_18()); 
                    match(input,30,FOLLOW_30_in_rule__Color__Alternatives_11788); 
                     after(grammarAccess.getColorAccess().getCornsilkKeyword_1_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:783:6: ( 'Crimson' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:783:6: ( 'Crimson' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:784:1: 'Crimson'
                    {
                     before(grammarAccess.getColorAccess().getCrimsonKeyword_1_19()); 
                    match(input,31,FOLLOW_31_in_rule__Color__Alternatives_11808); 
                     after(grammarAccess.getColorAccess().getCrimsonKeyword_1_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:791:6: ( 'Cyan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:791:6: ( 'Cyan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:792:1: 'Cyan'
                    {
                     before(grammarAccess.getColorAccess().getCyanKeyword_1_20()); 
                    match(input,32,FOLLOW_32_in_rule__Color__Alternatives_11828); 
                     after(grammarAccess.getColorAccess().getCyanKeyword_1_20()); 

                    }


                    }
                    break;
                case 22 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:799:6: ( 'DarkBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:799:6: ( 'DarkBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:800:1: 'DarkBlue'
                    {
                     before(grammarAccess.getColorAccess().getDarkBlueKeyword_1_21()); 
                    match(input,33,FOLLOW_33_in_rule__Color__Alternatives_11848); 
                     after(grammarAccess.getColorAccess().getDarkBlueKeyword_1_21()); 

                    }


                    }
                    break;
                case 23 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:807:6: ( 'DarkCyan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:807:6: ( 'DarkCyan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:808:1: 'DarkCyan'
                    {
                     before(grammarAccess.getColorAccess().getDarkCyanKeyword_1_22()); 
                    match(input,34,FOLLOW_34_in_rule__Color__Alternatives_11868); 
                     after(grammarAccess.getColorAccess().getDarkCyanKeyword_1_22()); 

                    }


                    }
                    break;
                case 24 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:815:6: ( 'DarkGoldenRod' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:815:6: ( 'DarkGoldenRod' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:816:1: 'DarkGoldenRod'
                    {
                     before(grammarAccess.getColorAccess().getDarkGoldenRodKeyword_1_23()); 
                    match(input,35,FOLLOW_35_in_rule__Color__Alternatives_11888); 
                     after(grammarAccess.getColorAccess().getDarkGoldenRodKeyword_1_23()); 

                    }


                    }
                    break;
                case 25 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:823:6: ( 'DarkGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:823:6: ( 'DarkGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:824:1: 'DarkGray'
                    {
                     before(grammarAccess.getColorAccess().getDarkGrayKeyword_1_24()); 
                    match(input,36,FOLLOW_36_in_rule__Color__Alternatives_11908); 
                     after(grammarAccess.getColorAccess().getDarkGrayKeyword_1_24()); 

                    }


                    }
                    break;
                case 26 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:831:6: ( 'DarkGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:831:6: ( 'DarkGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:832:1: 'DarkGreen'
                    {
                     before(grammarAccess.getColorAccess().getDarkGreenKeyword_1_25()); 
                    match(input,37,FOLLOW_37_in_rule__Color__Alternatives_11928); 
                     after(grammarAccess.getColorAccess().getDarkGreenKeyword_1_25()); 

                    }


                    }
                    break;
                case 27 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:839:6: ( 'DarkGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:839:6: ( 'DarkGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:840:1: 'DarkGrey'
                    {
                     before(grammarAccess.getColorAccess().getDarkGreyKeyword_1_26()); 
                    match(input,38,FOLLOW_38_in_rule__Color__Alternatives_11948); 
                     after(grammarAccess.getColorAccess().getDarkGreyKeyword_1_26()); 

                    }


                    }
                    break;
                case 28 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:847:6: ( 'DarkKhaki' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:847:6: ( 'DarkKhaki' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:848:1: 'DarkKhaki'
                    {
                     before(grammarAccess.getColorAccess().getDarkKhakiKeyword_1_27()); 
                    match(input,39,FOLLOW_39_in_rule__Color__Alternatives_11968); 
                     after(grammarAccess.getColorAccess().getDarkKhakiKeyword_1_27()); 

                    }


                    }
                    break;
                case 29 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:855:6: ( 'DarkMagenta' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:855:6: ( 'DarkMagenta' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:856:1: 'DarkMagenta'
                    {
                     before(grammarAccess.getColorAccess().getDarkMagentaKeyword_1_28()); 
                    match(input,40,FOLLOW_40_in_rule__Color__Alternatives_11988); 
                     after(grammarAccess.getColorAccess().getDarkMagentaKeyword_1_28()); 

                    }


                    }
                    break;
                case 30 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:863:6: ( 'DarkOliveGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:863:6: ( 'DarkOliveGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:864:1: 'DarkOliveGreen'
                    {
                     before(grammarAccess.getColorAccess().getDarkOliveGreenKeyword_1_29()); 
                    match(input,41,FOLLOW_41_in_rule__Color__Alternatives_12008); 
                     after(grammarAccess.getColorAccess().getDarkOliveGreenKeyword_1_29()); 

                    }


                    }
                    break;
                case 31 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:871:6: ( 'DarkOrchid' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:871:6: ( 'DarkOrchid' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:872:1: 'DarkOrchid'
                    {
                     before(grammarAccess.getColorAccess().getDarkOrchidKeyword_1_30()); 
                    match(input,42,FOLLOW_42_in_rule__Color__Alternatives_12028); 
                     after(grammarAccess.getColorAccess().getDarkOrchidKeyword_1_30()); 

                    }


                    }
                    break;
                case 32 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:879:6: ( 'DarkRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:879:6: ( 'DarkRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:880:1: 'DarkRed'
                    {
                     before(grammarAccess.getColorAccess().getDarkRedKeyword_1_31()); 
                    match(input,43,FOLLOW_43_in_rule__Color__Alternatives_12048); 
                     after(grammarAccess.getColorAccess().getDarkRedKeyword_1_31()); 

                    }


                    }
                    break;
                case 33 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:887:6: ( 'DarkSalmo' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:887:6: ( 'DarkSalmo' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:888:1: 'DarkSalmo'
                    {
                     before(grammarAccess.getColorAccess().getDarkSalmoKeyword_1_32()); 
                    match(input,44,FOLLOW_44_in_rule__Color__Alternatives_12068); 
                     after(grammarAccess.getColorAccess().getDarkSalmoKeyword_1_32()); 

                    }


                    }
                    break;
                case 34 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:895:6: ( 'DarkSeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:895:6: ( 'DarkSeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:896:1: 'DarkSeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getDarkSeaGreenKeyword_1_33()); 
                    match(input,45,FOLLOW_45_in_rule__Color__Alternatives_12088); 
                     after(grammarAccess.getColorAccess().getDarkSeaGreenKeyword_1_33()); 

                    }


                    }
                    break;
                case 35 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:903:6: ( 'DarkSlateBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:903:6: ( 'DarkSlateBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:904:1: 'DarkSlateBlue'
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateBlueKeyword_1_34()); 
                    match(input,46,FOLLOW_46_in_rule__Color__Alternatives_12108); 
                     after(grammarAccess.getColorAccess().getDarkSlateBlueKeyword_1_34()); 

                    }


                    }
                    break;
                case 36 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:911:6: ( 'DarkSlateGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:911:6: ( 'DarkSlateGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:912:1: 'DarkSlateGray'
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateGrayKeyword_1_35()); 
                    match(input,47,FOLLOW_47_in_rule__Color__Alternatives_12128); 
                     after(grammarAccess.getColorAccess().getDarkSlateGrayKeyword_1_35()); 

                    }


                    }
                    break;
                case 37 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:919:6: ( 'DarkSlateGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:919:6: ( 'DarkSlateGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:920:1: 'DarkSlateGrey'
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateGreyKeyword_1_36()); 
                    match(input,48,FOLLOW_48_in_rule__Color__Alternatives_12148); 
                     after(grammarAccess.getColorAccess().getDarkSlateGreyKeyword_1_36()); 

                    }


                    }
                    break;
                case 38 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:927:6: ( 'DarkTurquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:927:6: ( 'DarkTurquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:928:1: 'DarkTurquoise'
                    {
                     before(grammarAccess.getColorAccess().getDarkTurquoiseKeyword_1_37()); 
                    match(input,49,FOLLOW_49_in_rule__Color__Alternatives_12168); 
                     after(grammarAccess.getColorAccess().getDarkTurquoiseKeyword_1_37()); 

                    }


                    }
                    break;
                case 39 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:935:6: ( 'DarkViolet' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:935:6: ( 'DarkViolet' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:936:1: 'DarkViolet'
                    {
                     before(grammarAccess.getColorAccess().getDarkVioletKeyword_1_38()); 
                    match(input,50,FOLLOW_50_in_rule__Color__Alternatives_12188); 
                     after(grammarAccess.getColorAccess().getDarkVioletKeyword_1_38()); 

                    }


                    }
                    break;
                case 40 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:943:6: ( 'Darkorange' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:943:6: ( 'Darkorange' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:944:1: 'Darkorange'
                    {
                     before(grammarAccess.getColorAccess().getDarkorangeKeyword_1_39()); 
                    match(input,51,FOLLOW_51_in_rule__Color__Alternatives_12208); 
                     after(grammarAccess.getColorAccess().getDarkorangeKeyword_1_39()); 

                    }


                    }
                    break;
                case 41 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:951:6: ( 'DeepPink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:951:6: ( 'DeepPink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:952:1: 'DeepPink'
                    {
                     before(grammarAccess.getColorAccess().getDeepPinkKeyword_1_40()); 
                    match(input,52,FOLLOW_52_in_rule__Color__Alternatives_12228); 
                     after(grammarAccess.getColorAccess().getDeepPinkKeyword_1_40()); 

                    }


                    }
                    break;
                case 42 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:959:6: ( 'DeepSkyBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:959:6: ( 'DeepSkyBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:960:1: 'DeepSkyBlue'
                    {
                     before(grammarAccess.getColorAccess().getDeepSkyBlueKeyword_1_41()); 
                    match(input,53,FOLLOW_53_in_rule__Color__Alternatives_12248); 
                     after(grammarAccess.getColorAccess().getDeepSkyBlueKeyword_1_41()); 

                    }


                    }
                    break;
                case 43 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:967:6: ( 'DimGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:967:6: ( 'DimGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:968:1: 'DimGray'
                    {
                     before(grammarAccess.getColorAccess().getDimGrayKeyword_1_42()); 
                    match(input,54,FOLLOW_54_in_rule__Color__Alternatives_12268); 
                     after(grammarAccess.getColorAccess().getDimGrayKeyword_1_42()); 

                    }


                    }
                    break;
                case 44 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:975:6: ( 'DimGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:975:6: ( 'DimGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:976:1: 'DimGrey'
                    {
                     before(grammarAccess.getColorAccess().getDimGreyKeyword_1_43()); 
                    match(input,55,FOLLOW_55_in_rule__Color__Alternatives_12288); 
                     after(grammarAccess.getColorAccess().getDimGreyKeyword_1_43()); 

                    }


                    }
                    break;
                case 45 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:983:6: ( 'DodgerBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:983:6: ( 'DodgerBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:984:1: 'DodgerBlue'
                    {
                     before(grammarAccess.getColorAccess().getDodgerBlueKeyword_1_44()); 
                    match(input,56,FOLLOW_56_in_rule__Color__Alternatives_12308); 
                     after(grammarAccess.getColorAccess().getDodgerBlueKeyword_1_44()); 

                    }


                    }
                    break;
                case 46 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:991:6: ( 'FireBrick' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:991:6: ( 'FireBrick' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:992:1: 'FireBrick'
                    {
                     before(grammarAccess.getColorAccess().getFireBrickKeyword_1_45()); 
                    match(input,57,FOLLOW_57_in_rule__Color__Alternatives_12328); 
                     after(grammarAccess.getColorAccess().getFireBrickKeyword_1_45()); 

                    }


                    }
                    break;
                case 47 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:999:6: ( 'FloralWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:999:6: ( 'FloralWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1000:1: 'FloralWhite'
                    {
                     before(grammarAccess.getColorAccess().getFloralWhiteKeyword_1_46()); 
                    match(input,58,FOLLOW_58_in_rule__Color__Alternatives_12348); 
                     after(grammarAccess.getColorAccess().getFloralWhiteKeyword_1_46()); 

                    }


                    }
                    break;
                case 48 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1007:6: ( 'ForestGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1007:6: ( 'ForestGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1008:1: 'ForestGreen'
                    {
                     before(grammarAccess.getColorAccess().getForestGreenKeyword_1_47()); 
                    match(input,59,FOLLOW_59_in_rule__Color__Alternatives_12368); 
                     after(grammarAccess.getColorAccess().getForestGreenKeyword_1_47()); 

                    }


                    }
                    break;
                case 49 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1015:6: ( 'Fuchsia' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1015:6: ( 'Fuchsia' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1016:1: 'Fuchsia'
                    {
                     before(grammarAccess.getColorAccess().getFuchsiaKeyword_1_48()); 
                    match(input,60,FOLLOW_60_in_rule__Color__Alternatives_12388); 
                     after(grammarAccess.getColorAccess().getFuchsiaKeyword_1_48()); 

                    }


                    }
                    break;
                case 50 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1023:6: ( 'Gainsboro' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1023:6: ( 'Gainsboro' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1024:1: 'Gainsboro'
                    {
                     before(grammarAccess.getColorAccess().getGainsboroKeyword_1_49()); 
                    match(input,61,FOLLOW_61_in_rule__Color__Alternatives_12408); 
                     after(grammarAccess.getColorAccess().getGainsboroKeyword_1_49()); 

                    }


                    }
                    break;
                case 51 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1031:6: ( 'GhostWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1031:6: ( 'GhostWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1032:1: 'GhostWhite'
                    {
                     before(grammarAccess.getColorAccess().getGhostWhiteKeyword_1_50()); 
                    match(input,62,FOLLOW_62_in_rule__Color__Alternatives_12428); 
                     after(grammarAccess.getColorAccess().getGhostWhiteKeyword_1_50()); 

                    }


                    }
                    break;
                case 52 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1039:6: ( 'Gold' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1039:6: ( 'Gold' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1040:1: 'Gold'
                    {
                     before(grammarAccess.getColorAccess().getGoldKeyword_1_51()); 
                    match(input,63,FOLLOW_63_in_rule__Color__Alternatives_12448); 
                     after(grammarAccess.getColorAccess().getGoldKeyword_1_51()); 

                    }


                    }
                    break;
                case 53 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1047:6: ( 'GoldenRod' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1047:6: ( 'GoldenRod' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1048:1: 'GoldenRod'
                    {
                     before(grammarAccess.getColorAccess().getGoldenRodKeyword_1_52()); 
                    match(input,64,FOLLOW_64_in_rule__Color__Alternatives_12468); 
                     after(grammarAccess.getColorAccess().getGoldenRodKeyword_1_52()); 

                    }


                    }
                    break;
                case 54 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1055:6: ( 'Gray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1055:6: ( 'Gray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1056:1: 'Gray'
                    {
                     before(grammarAccess.getColorAccess().getGrayKeyword_1_53()); 
                    match(input,65,FOLLOW_65_in_rule__Color__Alternatives_12488); 
                     after(grammarAccess.getColorAccess().getGrayKeyword_1_53()); 

                    }


                    }
                    break;
                case 55 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1063:6: ( 'Green' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1063:6: ( 'Green' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1064:1: 'Green'
                    {
                     before(grammarAccess.getColorAccess().getGreenKeyword_1_54()); 
                    match(input,66,FOLLOW_66_in_rule__Color__Alternatives_12508); 
                     after(grammarAccess.getColorAccess().getGreenKeyword_1_54()); 

                    }


                    }
                    break;
                case 56 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1071:6: ( 'GreenYellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1071:6: ( 'GreenYellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1072:1: 'GreenYellow'
                    {
                     before(grammarAccess.getColorAccess().getGreenYellowKeyword_1_55()); 
                    match(input,67,FOLLOW_67_in_rule__Color__Alternatives_12528); 
                     after(grammarAccess.getColorAccess().getGreenYellowKeyword_1_55()); 

                    }


                    }
                    break;
                case 57 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1079:6: ( 'Grey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1079:6: ( 'Grey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1080:1: 'Grey'
                    {
                     before(grammarAccess.getColorAccess().getGreyKeyword_1_56()); 
                    match(input,68,FOLLOW_68_in_rule__Color__Alternatives_12548); 
                     after(grammarAccess.getColorAccess().getGreyKeyword_1_56()); 

                    }


                    }
                    break;
                case 58 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1087:6: ( 'HoneyDew' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1087:6: ( 'HoneyDew' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1088:1: 'HoneyDew'
                    {
                     before(grammarAccess.getColorAccess().getHoneyDewKeyword_1_57()); 
                    match(input,69,FOLLOW_69_in_rule__Color__Alternatives_12568); 
                     after(grammarAccess.getColorAccess().getHoneyDewKeyword_1_57()); 

                    }


                    }
                    break;
                case 59 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1095:6: ( 'HotPink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1095:6: ( 'HotPink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1096:1: 'HotPink'
                    {
                     before(grammarAccess.getColorAccess().getHotPinkKeyword_1_58()); 
                    match(input,70,FOLLOW_70_in_rule__Color__Alternatives_12588); 
                     after(grammarAccess.getColorAccess().getHotPinkKeyword_1_58()); 

                    }


                    }
                    break;
                case 60 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1103:6: ( 'IndianRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1103:6: ( 'IndianRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1104:1: 'IndianRed'
                    {
                     before(grammarAccess.getColorAccess().getIndianRedKeyword_1_59()); 
                    match(input,71,FOLLOW_71_in_rule__Color__Alternatives_12608); 
                     after(grammarAccess.getColorAccess().getIndianRedKeyword_1_59()); 

                    }


                    }
                    break;
                case 61 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1111:6: ( 'Indigo' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1111:6: ( 'Indigo' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1112:1: 'Indigo'
                    {
                     before(grammarAccess.getColorAccess().getIndigoKeyword_1_60()); 
                    match(input,72,FOLLOW_72_in_rule__Color__Alternatives_12628); 
                     after(grammarAccess.getColorAccess().getIndigoKeyword_1_60()); 

                    }


                    }
                    break;
                case 62 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1119:6: ( 'Ivory' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1119:6: ( 'Ivory' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1120:1: 'Ivory'
                    {
                     before(grammarAccess.getColorAccess().getIvoryKeyword_1_61()); 
                    match(input,73,FOLLOW_73_in_rule__Color__Alternatives_12648); 
                     after(grammarAccess.getColorAccess().getIvoryKeyword_1_61()); 

                    }


                    }
                    break;
                case 63 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1127:6: ( 'Khaki' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1127:6: ( 'Khaki' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1128:1: 'Khaki'
                    {
                     before(grammarAccess.getColorAccess().getKhakiKeyword_1_62()); 
                    match(input,74,FOLLOW_74_in_rule__Color__Alternatives_12668); 
                     after(grammarAccess.getColorAccess().getKhakiKeyword_1_62()); 

                    }


                    }
                    break;
                case 64 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1135:6: ( 'Lavender' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1135:6: ( 'Lavender' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1136:1: 'Lavender'
                    {
                     before(grammarAccess.getColorAccess().getLavenderKeyword_1_63()); 
                    match(input,75,FOLLOW_75_in_rule__Color__Alternatives_12688); 
                     after(grammarAccess.getColorAccess().getLavenderKeyword_1_63()); 

                    }


                    }
                    break;
                case 65 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1143:6: ( 'LavenderBlush' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1143:6: ( 'LavenderBlush' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1144:1: 'LavenderBlush'
                    {
                     before(grammarAccess.getColorAccess().getLavenderBlushKeyword_1_64()); 
                    match(input,76,FOLLOW_76_in_rule__Color__Alternatives_12708); 
                     after(grammarAccess.getColorAccess().getLavenderBlushKeyword_1_64()); 

                    }


                    }
                    break;
                case 66 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1151:6: ( 'LawnGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1151:6: ( 'LawnGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1152:1: 'LawnGreen'
                    {
                     before(grammarAccess.getColorAccess().getLawnGreenKeyword_1_65()); 
                    match(input,77,FOLLOW_77_in_rule__Color__Alternatives_12728); 
                     after(grammarAccess.getColorAccess().getLawnGreenKeyword_1_65()); 

                    }


                    }
                    break;
                case 67 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1159:6: ( 'LemonChiffon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1159:6: ( 'LemonChiffon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1160:1: 'LemonChiffon'
                    {
                     before(grammarAccess.getColorAccess().getLemonChiffonKeyword_1_66()); 
                    match(input,78,FOLLOW_78_in_rule__Color__Alternatives_12748); 
                     after(grammarAccess.getColorAccess().getLemonChiffonKeyword_1_66()); 

                    }


                    }
                    break;
                case 68 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1167:6: ( 'LightBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1167:6: ( 'LightBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1168:1: 'LightBlue'
                    {
                     before(grammarAccess.getColorAccess().getLightBlueKeyword_1_67()); 
                    match(input,79,FOLLOW_79_in_rule__Color__Alternatives_12768); 
                     after(grammarAccess.getColorAccess().getLightBlueKeyword_1_67()); 

                    }


                    }
                    break;
                case 69 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1175:6: ( 'LightCoral' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1175:6: ( 'LightCoral' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1176:1: 'LightCoral'
                    {
                     before(grammarAccess.getColorAccess().getLightCoralKeyword_1_68()); 
                    match(input,80,FOLLOW_80_in_rule__Color__Alternatives_12788); 
                     after(grammarAccess.getColorAccess().getLightCoralKeyword_1_68()); 

                    }


                    }
                    break;
                case 70 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1183:6: ( 'LightCyan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1183:6: ( 'LightCyan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1184:1: 'LightCyan'
                    {
                     before(grammarAccess.getColorAccess().getLightCyanKeyword_1_69()); 
                    match(input,81,FOLLOW_81_in_rule__Color__Alternatives_12808); 
                     after(grammarAccess.getColorAccess().getLightCyanKeyword_1_69()); 

                    }


                    }
                    break;
                case 71 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1191:6: ( 'LightGoldenRodYellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1191:6: ( 'LightGoldenRodYellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1192:1: 'LightGoldenRodYellow'
                    {
                     before(grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_1_70()); 
                    match(input,82,FOLLOW_82_in_rule__Color__Alternatives_12828); 
                     after(grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_1_70()); 

                    }


                    }
                    break;
                case 72 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1199:6: ( 'LightGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1199:6: ( 'LightGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1200:1: 'LightGray'
                    {
                     before(grammarAccess.getColorAccess().getLightGrayKeyword_1_71()); 
                    match(input,83,FOLLOW_83_in_rule__Color__Alternatives_12848); 
                     after(grammarAccess.getColorAccess().getLightGrayKeyword_1_71()); 

                    }


                    }
                    break;
                case 73 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1207:6: ( 'LightGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1207:6: ( 'LightGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1208:1: 'LightGreen'
                    {
                     before(grammarAccess.getColorAccess().getLightGreenKeyword_1_72()); 
                    match(input,84,FOLLOW_84_in_rule__Color__Alternatives_12868); 
                     after(grammarAccess.getColorAccess().getLightGreenKeyword_1_72()); 

                    }


                    }
                    break;
                case 74 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1215:6: ( 'LightGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1215:6: ( 'LightGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1216:1: 'LightGrey'
                    {
                     before(grammarAccess.getColorAccess().getLightGreyKeyword_1_73()); 
                    match(input,85,FOLLOW_85_in_rule__Color__Alternatives_12888); 
                     after(grammarAccess.getColorAccess().getLightGreyKeyword_1_73()); 

                    }


                    }
                    break;
                case 75 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1223:6: ( 'LightPink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1223:6: ( 'LightPink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1224:1: 'LightPink'
                    {
                     before(grammarAccess.getColorAccess().getLightPinkKeyword_1_74()); 
                    match(input,86,FOLLOW_86_in_rule__Color__Alternatives_12908); 
                     after(grammarAccess.getColorAccess().getLightPinkKeyword_1_74()); 

                    }


                    }
                    break;
                case 76 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1231:6: ( 'LightSalmon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1231:6: ( 'LightSalmon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1232:1: 'LightSalmon'
                    {
                     before(grammarAccess.getColorAccess().getLightSalmonKeyword_1_75()); 
                    match(input,87,FOLLOW_87_in_rule__Color__Alternatives_12928); 
                     after(grammarAccess.getColorAccess().getLightSalmonKeyword_1_75()); 

                    }


                    }
                    break;
                case 77 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1239:6: ( 'LightSeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1239:6: ( 'LightSeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1240:1: 'LightSeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getLightSeaGreenKeyword_1_76()); 
                    match(input,88,FOLLOW_88_in_rule__Color__Alternatives_12948); 
                     after(grammarAccess.getColorAccess().getLightSeaGreenKeyword_1_76()); 

                    }


                    }
                    break;
                case 78 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1247:6: ( 'LightSkyBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1247:6: ( 'LightSkyBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1248:1: 'LightSkyBlue'
                    {
                     before(grammarAccess.getColorAccess().getLightSkyBlueKeyword_1_77()); 
                    match(input,89,FOLLOW_89_in_rule__Color__Alternatives_12968); 
                     after(grammarAccess.getColorAccess().getLightSkyBlueKeyword_1_77()); 

                    }


                    }
                    break;
                case 79 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1255:6: ( 'LightSlateGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1255:6: ( 'LightSlateGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1256:1: 'LightSlateGray'
                    {
                     before(grammarAccess.getColorAccess().getLightSlateGrayKeyword_1_78()); 
                    match(input,90,FOLLOW_90_in_rule__Color__Alternatives_12988); 
                     after(grammarAccess.getColorAccess().getLightSlateGrayKeyword_1_78()); 

                    }


                    }
                    break;
                case 80 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1263:6: ( 'LightSlateGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1263:6: ( 'LightSlateGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1264:1: 'LightSlateGrey'
                    {
                     before(grammarAccess.getColorAccess().getLightSlateGreyKeyword_1_79()); 
                    match(input,91,FOLLOW_91_in_rule__Color__Alternatives_13008); 
                     after(grammarAccess.getColorAccess().getLightSlateGreyKeyword_1_79()); 

                    }


                    }
                    break;
                case 81 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1271:6: ( 'LightSteelBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1271:6: ( 'LightSteelBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1272:1: 'LightSteelBlue'
                    {
                     before(grammarAccess.getColorAccess().getLightSteelBlueKeyword_1_80()); 
                    match(input,92,FOLLOW_92_in_rule__Color__Alternatives_13028); 
                     after(grammarAccess.getColorAccess().getLightSteelBlueKeyword_1_80()); 

                    }


                    }
                    break;
                case 82 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1279:6: ( 'LightYellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1279:6: ( 'LightYellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1280:1: 'LightYellow'
                    {
                     before(grammarAccess.getColorAccess().getLightYellowKeyword_1_81()); 
                    match(input,93,FOLLOW_93_in_rule__Color__Alternatives_13048); 
                     after(grammarAccess.getColorAccess().getLightYellowKeyword_1_81()); 

                    }


                    }
                    break;
                case 83 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1287:6: ( 'Lime' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1287:6: ( 'Lime' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1288:1: 'Lime'
                    {
                     before(grammarAccess.getColorAccess().getLimeKeyword_1_82()); 
                    match(input,94,FOLLOW_94_in_rule__Color__Alternatives_13068); 
                     after(grammarAccess.getColorAccess().getLimeKeyword_1_82()); 

                    }


                    }
                    break;
                case 84 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1295:6: ( 'LimeGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1295:6: ( 'LimeGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1296:1: 'LimeGreen'
                    {
                     before(grammarAccess.getColorAccess().getLimeGreenKeyword_1_83()); 
                    match(input,95,FOLLOW_95_in_rule__Color__Alternatives_13088); 
                     after(grammarAccess.getColorAccess().getLimeGreenKeyword_1_83()); 

                    }


                    }
                    break;
                case 85 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1303:6: ( 'Linen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1303:6: ( 'Linen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1304:1: 'Linen'
                    {
                     before(grammarAccess.getColorAccess().getLinenKeyword_1_84()); 
                    match(input,96,FOLLOW_96_in_rule__Color__Alternatives_13108); 
                     after(grammarAccess.getColorAccess().getLinenKeyword_1_84()); 

                    }


                    }
                    break;
                case 86 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1311:6: ( 'Magenta' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1311:6: ( 'Magenta' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1312:1: 'Magenta'
                    {
                     before(grammarAccess.getColorAccess().getMagentaKeyword_1_85()); 
                    match(input,97,FOLLOW_97_in_rule__Color__Alternatives_13128); 
                     after(grammarAccess.getColorAccess().getMagentaKeyword_1_85()); 

                    }


                    }
                    break;
                case 87 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1319:6: ( 'Maroon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1319:6: ( 'Maroon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1320:1: 'Maroon'
                    {
                     before(grammarAccess.getColorAccess().getMaroonKeyword_1_86()); 
                    match(input,98,FOLLOW_98_in_rule__Color__Alternatives_13148); 
                     after(grammarAccess.getColorAccess().getMaroonKeyword_1_86()); 

                    }


                    }
                    break;
                case 88 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1327:6: ( 'MediumAquaMarine' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1327:6: ( 'MediumAquaMarine' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1328:1: 'MediumAquaMarine'
                    {
                     before(grammarAccess.getColorAccess().getMediumAquaMarineKeyword_1_87()); 
                    match(input,99,FOLLOW_99_in_rule__Color__Alternatives_13168); 
                     after(grammarAccess.getColorAccess().getMediumAquaMarineKeyword_1_87()); 

                    }


                    }
                    break;
                case 89 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1335:6: ( 'MediumBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1335:6: ( 'MediumBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1336:1: 'MediumBlue'
                    {
                     before(grammarAccess.getColorAccess().getMediumBlueKeyword_1_88()); 
                    match(input,100,FOLLOW_100_in_rule__Color__Alternatives_13188); 
                     after(grammarAccess.getColorAccess().getMediumBlueKeyword_1_88()); 

                    }


                    }
                    break;
                case 90 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1343:6: ( 'MediumOrchid' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1343:6: ( 'MediumOrchid' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1344:1: 'MediumOrchid'
                    {
                     before(grammarAccess.getColorAccess().getMediumOrchidKeyword_1_89()); 
                    match(input,101,FOLLOW_101_in_rule__Color__Alternatives_13208); 
                     after(grammarAccess.getColorAccess().getMediumOrchidKeyword_1_89()); 

                    }


                    }
                    break;
                case 91 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1351:6: ( 'MediumPurple' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1351:6: ( 'MediumPurple' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1352:1: 'MediumPurple'
                    {
                     before(grammarAccess.getColorAccess().getMediumPurpleKeyword_1_90()); 
                    match(input,102,FOLLOW_102_in_rule__Color__Alternatives_13228); 
                     after(grammarAccess.getColorAccess().getMediumPurpleKeyword_1_90()); 

                    }


                    }
                    break;
                case 92 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1359:6: ( 'MediumSeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1359:6: ( 'MediumSeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1360:1: 'MediumSeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getMediumSeaGreenKeyword_1_91()); 
                    match(input,103,FOLLOW_103_in_rule__Color__Alternatives_13248); 
                     after(grammarAccess.getColorAccess().getMediumSeaGreenKeyword_1_91()); 

                    }


                    }
                    break;
                case 93 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1367:6: ( 'MediumSlateBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1367:6: ( 'MediumSlateBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1368:1: 'MediumSlateBlue'
                    {
                     before(grammarAccess.getColorAccess().getMediumSlateBlueKeyword_1_92()); 
                    match(input,104,FOLLOW_104_in_rule__Color__Alternatives_13268); 
                     after(grammarAccess.getColorAccess().getMediumSlateBlueKeyword_1_92()); 

                    }


                    }
                    break;
                case 94 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1375:6: ( 'MediumSpringGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1375:6: ( 'MediumSpringGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1376:1: 'MediumSpringGreen'
                    {
                     before(grammarAccess.getColorAccess().getMediumSpringGreenKeyword_1_93()); 
                    match(input,105,FOLLOW_105_in_rule__Color__Alternatives_13288); 
                     after(grammarAccess.getColorAccess().getMediumSpringGreenKeyword_1_93()); 

                    }


                    }
                    break;
                case 95 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1383:6: ( 'MediumTurquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1383:6: ( 'MediumTurquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1384:1: 'MediumTurquoise'
                    {
                     before(grammarAccess.getColorAccess().getMediumTurquoiseKeyword_1_94()); 
                    match(input,106,FOLLOW_106_in_rule__Color__Alternatives_13308); 
                     after(grammarAccess.getColorAccess().getMediumTurquoiseKeyword_1_94()); 

                    }


                    }
                    break;
                case 96 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1391:6: ( 'MediumVioletRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1391:6: ( 'MediumVioletRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1392:1: 'MediumVioletRed'
                    {
                     before(grammarAccess.getColorAccess().getMediumVioletRedKeyword_1_95()); 
                    match(input,107,FOLLOW_107_in_rule__Color__Alternatives_13328); 
                     after(grammarAccess.getColorAccess().getMediumVioletRedKeyword_1_95()); 

                    }


                    }
                    break;
                case 97 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1399:6: ( 'MidnightBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1399:6: ( 'MidnightBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1400:1: 'MidnightBlue'
                    {
                     before(grammarAccess.getColorAccess().getMidnightBlueKeyword_1_96()); 
                    match(input,108,FOLLOW_108_in_rule__Color__Alternatives_13348); 
                     after(grammarAccess.getColorAccess().getMidnightBlueKeyword_1_96()); 

                    }


                    }
                    break;
                case 98 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1407:6: ( 'MintCream' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1407:6: ( 'MintCream' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1408:1: 'MintCream'
                    {
                     before(grammarAccess.getColorAccess().getMintCreamKeyword_1_97()); 
                    match(input,109,FOLLOW_109_in_rule__Color__Alternatives_13368); 
                     after(grammarAccess.getColorAccess().getMintCreamKeyword_1_97()); 

                    }


                    }
                    break;
                case 99 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1415:6: ( 'MistyRose' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1415:6: ( 'MistyRose' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1416:1: 'MistyRose'
                    {
                     before(grammarAccess.getColorAccess().getMistyRoseKeyword_1_98()); 
                    match(input,110,FOLLOW_110_in_rule__Color__Alternatives_13388); 
                     after(grammarAccess.getColorAccess().getMistyRoseKeyword_1_98()); 

                    }


                    }
                    break;
                case 100 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1423:6: ( 'Moccasin' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1423:6: ( 'Moccasin' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1424:1: 'Moccasin'
                    {
                     before(grammarAccess.getColorAccess().getMoccasinKeyword_1_99()); 
                    match(input,111,FOLLOW_111_in_rule__Color__Alternatives_13408); 
                     after(grammarAccess.getColorAccess().getMoccasinKeyword_1_99()); 

                    }


                    }
                    break;
                case 101 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1431:6: ( 'NavajoWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1431:6: ( 'NavajoWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1432:1: 'NavajoWhite'
                    {
                     before(grammarAccess.getColorAccess().getNavajoWhiteKeyword_1_100()); 
                    match(input,112,FOLLOW_112_in_rule__Color__Alternatives_13428); 
                     after(grammarAccess.getColorAccess().getNavajoWhiteKeyword_1_100()); 

                    }


                    }
                    break;
                case 102 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1439:6: ( 'Navy' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1439:6: ( 'Navy' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1440:1: 'Navy'
                    {
                     before(grammarAccess.getColorAccess().getNavyKeyword_1_101()); 
                    match(input,113,FOLLOW_113_in_rule__Color__Alternatives_13448); 
                     after(grammarAccess.getColorAccess().getNavyKeyword_1_101()); 

                    }


                    }
                    break;
                case 103 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1447:6: ( 'OldLace' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1447:6: ( 'OldLace' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1448:1: 'OldLace'
                    {
                     before(grammarAccess.getColorAccess().getOldLaceKeyword_1_102()); 
                    match(input,114,FOLLOW_114_in_rule__Color__Alternatives_13468); 
                     after(grammarAccess.getColorAccess().getOldLaceKeyword_1_102()); 

                    }


                    }
                    break;
                case 104 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1455:6: ( 'Olive' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1455:6: ( 'Olive' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1456:1: 'Olive'
                    {
                     before(grammarAccess.getColorAccess().getOliveKeyword_1_103()); 
                    match(input,115,FOLLOW_115_in_rule__Color__Alternatives_13488); 
                     after(grammarAccess.getColorAccess().getOliveKeyword_1_103()); 

                    }


                    }
                    break;
                case 105 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1463:6: ( 'OliveDrab' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1463:6: ( 'OliveDrab' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1464:1: 'OliveDrab'
                    {
                     before(grammarAccess.getColorAccess().getOliveDrabKeyword_1_104()); 
                    match(input,116,FOLLOW_116_in_rule__Color__Alternatives_13508); 
                     after(grammarAccess.getColorAccess().getOliveDrabKeyword_1_104()); 

                    }


                    }
                    break;
                case 106 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1471:6: ( 'OrangeRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1471:6: ( 'OrangeRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1472:1: 'OrangeRed'
                    {
                     before(grammarAccess.getColorAccess().getOrangeRedKeyword_1_105()); 
                    match(input,117,FOLLOW_117_in_rule__Color__Alternatives_13528); 
                     after(grammarAccess.getColorAccess().getOrangeRedKeyword_1_105()); 

                    }


                    }
                    break;
                case 107 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1479:6: ( 'Orchid' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1479:6: ( 'Orchid' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1480:1: 'Orchid'
                    {
                     before(grammarAccess.getColorAccess().getOrchidKeyword_1_106()); 
                    match(input,118,FOLLOW_118_in_rule__Color__Alternatives_13548); 
                     after(grammarAccess.getColorAccess().getOrchidKeyword_1_106()); 

                    }


                    }
                    break;
                case 108 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1487:6: ( 'PaleGoldenRod' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1487:6: ( 'PaleGoldenRod' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1488:1: 'PaleGoldenRod'
                    {
                     before(grammarAccess.getColorAccess().getPaleGoldenRodKeyword_1_107()); 
                    match(input,119,FOLLOW_119_in_rule__Color__Alternatives_13568); 
                     after(grammarAccess.getColorAccess().getPaleGoldenRodKeyword_1_107()); 

                    }


                    }
                    break;
                case 109 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1495:6: ( 'PaleGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1495:6: ( 'PaleGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1496:1: 'PaleGreen'
                    {
                     before(grammarAccess.getColorAccess().getPaleGreenKeyword_1_108()); 
                    match(input,120,FOLLOW_120_in_rule__Color__Alternatives_13588); 
                     after(grammarAccess.getColorAccess().getPaleGreenKeyword_1_108()); 

                    }


                    }
                    break;
                case 110 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1503:6: ( 'PaleTurquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1503:6: ( 'PaleTurquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1504:1: 'PaleTurquoise'
                    {
                     before(grammarAccess.getColorAccess().getPaleTurquoiseKeyword_1_109()); 
                    match(input,121,FOLLOW_121_in_rule__Color__Alternatives_13608); 
                     after(grammarAccess.getColorAccess().getPaleTurquoiseKeyword_1_109()); 

                    }


                    }
                    break;
                case 111 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1511:6: ( 'PaleVioletRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1511:6: ( 'PaleVioletRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1512:1: 'PaleVioletRed'
                    {
                     before(grammarAccess.getColorAccess().getPaleVioletRedKeyword_1_110()); 
                    match(input,122,FOLLOW_122_in_rule__Color__Alternatives_13628); 
                     after(grammarAccess.getColorAccess().getPaleVioletRedKeyword_1_110()); 

                    }


                    }
                    break;
                case 112 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1519:6: ( 'PapayaWhip' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1519:6: ( 'PapayaWhip' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1520:1: 'PapayaWhip'
                    {
                     before(grammarAccess.getColorAccess().getPapayaWhipKeyword_1_111()); 
                    match(input,123,FOLLOW_123_in_rule__Color__Alternatives_13648); 
                     after(grammarAccess.getColorAccess().getPapayaWhipKeyword_1_111()); 

                    }


                    }
                    break;
                case 113 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1527:6: ( 'PeachPuff' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1527:6: ( 'PeachPuff' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1528:1: 'PeachPuff'
                    {
                     before(grammarAccess.getColorAccess().getPeachPuffKeyword_1_112()); 
                    match(input,124,FOLLOW_124_in_rule__Color__Alternatives_13668); 
                     after(grammarAccess.getColorAccess().getPeachPuffKeyword_1_112()); 

                    }


                    }
                    break;
                case 114 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1535:6: ( 'Peru' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1535:6: ( 'Peru' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1536:1: 'Peru'
                    {
                     before(grammarAccess.getColorAccess().getPeruKeyword_1_113()); 
                    match(input,125,FOLLOW_125_in_rule__Color__Alternatives_13688); 
                     after(grammarAccess.getColorAccess().getPeruKeyword_1_113()); 

                    }


                    }
                    break;
                case 115 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1543:6: ( 'Pink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1543:6: ( 'Pink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1544:1: 'Pink'
                    {
                     before(grammarAccess.getColorAccess().getPinkKeyword_1_114()); 
                    match(input,126,FOLLOW_126_in_rule__Color__Alternatives_13708); 
                     after(grammarAccess.getColorAccess().getPinkKeyword_1_114()); 

                    }


                    }
                    break;
                case 116 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1551:6: ( 'Plum' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1551:6: ( 'Plum' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1552:1: 'Plum'
                    {
                     before(grammarAccess.getColorAccess().getPlumKeyword_1_115()); 
                    match(input,127,FOLLOW_127_in_rule__Color__Alternatives_13728); 
                     after(grammarAccess.getColorAccess().getPlumKeyword_1_115()); 

                    }


                    }
                    break;
                case 117 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1559:6: ( 'PowderBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1559:6: ( 'PowderBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1560:1: 'PowderBlue'
                    {
                     before(grammarAccess.getColorAccess().getPowderBlueKeyword_1_116()); 
                    match(input,128,FOLLOW_128_in_rule__Color__Alternatives_13748); 
                     after(grammarAccess.getColorAccess().getPowderBlueKeyword_1_116()); 

                    }


                    }
                    break;
                case 118 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1567:6: ( 'Purple' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1567:6: ( 'Purple' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1568:1: 'Purple'
                    {
                     before(grammarAccess.getColorAccess().getPurpleKeyword_1_117()); 
                    match(input,129,FOLLOW_129_in_rule__Color__Alternatives_13768); 
                     after(grammarAccess.getColorAccess().getPurpleKeyword_1_117()); 

                    }


                    }
                    break;
                case 119 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1575:6: ( 'Red' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1575:6: ( 'Red' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1576:1: 'Red'
                    {
                     before(grammarAccess.getColorAccess().getRedKeyword_1_118()); 
                    match(input,130,FOLLOW_130_in_rule__Color__Alternatives_13788); 
                     after(grammarAccess.getColorAccess().getRedKeyword_1_118()); 

                    }


                    }
                    break;
                case 120 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1583:6: ( 'RosyBrown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1583:6: ( 'RosyBrown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1584:1: 'RosyBrown'
                    {
                     before(grammarAccess.getColorAccess().getRosyBrownKeyword_1_119()); 
                    match(input,131,FOLLOW_131_in_rule__Color__Alternatives_13808); 
                     after(grammarAccess.getColorAccess().getRosyBrownKeyword_1_119()); 

                    }


                    }
                    break;
                case 121 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1591:6: ( 'RoyalBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1591:6: ( 'RoyalBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1592:1: 'RoyalBlue'
                    {
                     before(grammarAccess.getColorAccess().getRoyalBlueKeyword_1_120()); 
                    match(input,132,FOLLOW_132_in_rule__Color__Alternatives_13828); 
                     after(grammarAccess.getColorAccess().getRoyalBlueKeyword_1_120()); 

                    }


                    }
                    break;
                case 122 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1599:6: ( 'SaddleBrown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1599:6: ( 'SaddleBrown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1600:1: 'SaddleBrown'
                    {
                     before(grammarAccess.getColorAccess().getSaddleBrownKeyword_1_121()); 
                    match(input,133,FOLLOW_133_in_rule__Color__Alternatives_13848); 
                     after(grammarAccess.getColorAccess().getSaddleBrownKeyword_1_121()); 

                    }


                    }
                    break;
                case 123 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1607:6: ( 'Salmon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1607:6: ( 'Salmon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1608:1: 'Salmon'
                    {
                     before(grammarAccess.getColorAccess().getSalmonKeyword_1_122()); 
                    match(input,134,FOLLOW_134_in_rule__Color__Alternatives_13868); 
                     after(grammarAccess.getColorAccess().getSalmonKeyword_1_122()); 

                    }


                    }
                    break;
                case 124 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1615:6: ( 'SandyBrown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1615:6: ( 'SandyBrown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1616:1: 'SandyBrown'
                    {
                     before(grammarAccess.getColorAccess().getSandyBrownKeyword_1_123()); 
                    match(input,135,FOLLOW_135_in_rule__Color__Alternatives_13888); 
                     after(grammarAccess.getColorAccess().getSandyBrownKeyword_1_123()); 

                    }


                    }
                    break;
                case 125 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1623:6: ( 'SeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1623:6: ( 'SeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1624:1: 'SeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getSeaGreenKeyword_1_124()); 
                    match(input,136,FOLLOW_136_in_rule__Color__Alternatives_13908); 
                     after(grammarAccess.getColorAccess().getSeaGreenKeyword_1_124()); 

                    }


                    }
                    break;
                case 126 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1631:6: ( 'Sienna' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1631:6: ( 'Sienna' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1632:1: 'Sienna'
                    {
                     before(grammarAccess.getColorAccess().getSiennaKeyword_1_125()); 
                    match(input,137,FOLLOW_137_in_rule__Color__Alternatives_13928); 
                     after(grammarAccess.getColorAccess().getSiennaKeyword_1_125()); 

                    }


                    }
                    break;
                case 127 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1639:6: ( 'Silver' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1639:6: ( 'Silver' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1640:1: 'Silver'
                    {
                     before(grammarAccess.getColorAccess().getSilverKeyword_1_126()); 
                    match(input,138,FOLLOW_138_in_rule__Color__Alternatives_13948); 
                     after(grammarAccess.getColorAccess().getSilverKeyword_1_126()); 

                    }


                    }
                    break;
                case 128 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1647:6: ( 'SkyBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1647:6: ( 'SkyBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1648:1: 'SkyBlue'
                    {
                     before(grammarAccess.getColorAccess().getSkyBlueKeyword_1_127()); 
                    match(input,139,FOLLOW_139_in_rule__Color__Alternatives_13968); 
                     after(grammarAccess.getColorAccess().getSkyBlueKeyword_1_127()); 

                    }


                    }
                    break;
                case 129 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1655:6: ( 'SlateBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1655:6: ( 'SlateBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1656:1: 'SlateBlue'
                    {
                     before(grammarAccess.getColorAccess().getSlateBlueKeyword_1_128()); 
                    match(input,140,FOLLOW_140_in_rule__Color__Alternatives_13988); 
                     after(grammarAccess.getColorAccess().getSlateBlueKeyword_1_128()); 

                    }


                    }
                    break;
                case 130 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1663:6: ( 'SlateGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1663:6: ( 'SlateGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1664:1: 'SlateGray'
                    {
                     before(grammarAccess.getColorAccess().getSlateGrayKeyword_1_129()); 
                    match(input,141,FOLLOW_141_in_rule__Color__Alternatives_14008); 
                     after(grammarAccess.getColorAccess().getSlateGrayKeyword_1_129()); 

                    }


                    }
                    break;
                case 131 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1671:6: ( 'SlateGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1671:6: ( 'SlateGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1672:1: 'SlateGrey'
                    {
                     before(grammarAccess.getColorAccess().getSlateGreyKeyword_1_130()); 
                    match(input,142,FOLLOW_142_in_rule__Color__Alternatives_14028); 
                     after(grammarAccess.getColorAccess().getSlateGreyKeyword_1_130()); 

                    }


                    }
                    break;
                case 132 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1679:6: ( 'Snow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1679:6: ( 'Snow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1680:1: 'Snow'
                    {
                     before(grammarAccess.getColorAccess().getSnowKeyword_1_131()); 
                    match(input,143,FOLLOW_143_in_rule__Color__Alternatives_14048); 
                     after(grammarAccess.getColorAccess().getSnowKeyword_1_131()); 

                    }


                    }
                    break;
                case 133 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1687:6: ( 'SpringGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1687:6: ( 'SpringGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1688:1: 'SpringGreen'
                    {
                     before(grammarAccess.getColorAccess().getSpringGreenKeyword_1_132()); 
                    match(input,144,FOLLOW_144_in_rule__Color__Alternatives_14068); 
                     after(grammarAccess.getColorAccess().getSpringGreenKeyword_1_132()); 

                    }


                    }
                    break;
                case 134 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1695:6: ( 'SteelBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1695:6: ( 'SteelBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1696:1: 'SteelBlue'
                    {
                     before(grammarAccess.getColorAccess().getSteelBlueKeyword_1_133()); 
                    match(input,145,FOLLOW_145_in_rule__Color__Alternatives_14088); 
                     after(grammarAccess.getColorAccess().getSteelBlueKeyword_1_133()); 

                    }


                    }
                    break;
                case 135 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1703:6: ( 'Tan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1703:6: ( 'Tan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1704:1: 'Tan'
                    {
                     before(grammarAccess.getColorAccess().getTanKeyword_1_134()); 
                    match(input,146,FOLLOW_146_in_rule__Color__Alternatives_14108); 
                     after(grammarAccess.getColorAccess().getTanKeyword_1_134()); 

                    }


                    }
                    break;
                case 136 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1711:6: ( 'Teal' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1711:6: ( 'Teal' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1712:1: 'Teal'
                    {
                     before(grammarAccess.getColorAccess().getTealKeyword_1_135()); 
                    match(input,147,FOLLOW_147_in_rule__Color__Alternatives_14128); 
                     after(grammarAccess.getColorAccess().getTealKeyword_1_135()); 

                    }


                    }
                    break;
                case 137 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1719:6: ( 'Thistle' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1719:6: ( 'Thistle' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1720:1: 'Thistle'
                    {
                     before(grammarAccess.getColorAccess().getThistleKeyword_1_136()); 
                    match(input,148,FOLLOW_148_in_rule__Color__Alternatives_14148); 
                     after(grammarAccess.getColorAccess().getThistleKeyword_1_136()); 

                    }


                    }
                    break;
                case 138 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1727:6: ( 'Tomato' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1727:6: ( 'Tomato' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1728:1: 'Tomato'
                    {
                     before(grammarAccess.getColorAccess().getTomatoKeyword_1_137()); 
                    match(input,149,FOLLOW_149_in_rule__Color__Alternatives_14168); 
                     after(grammarAccess.getColorAccess().getTomatoKeyword_1_137()); 

                    }


                    }
                    break;
                case 139 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1735:6: ( 'Turquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1735:6: ( 'Turquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1736:1: 'Turquoise'
                    {
                     before(grammarAccess.getColorAccess().getTurquoiseKeyword_1_138()); 
                    match(input,150,FOLLOW_150_in_rule__Color__Alternatives_14188); 
                     after(grammarAccess.getColorAccess().getTurquoiseKeyword_1_138()); 

                    }


                    }
                    break;
                case 140 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1743:6: ( 'Violet' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1743:6: ( 'Violet' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1744:1: 'Violet'
                    {
                     before(grammarAccess.getColorAccess().getVioletKeyword_1_139()); 
                    match(input,151,FOLLOW_151_in_rule__Color__Alternatives_14208); 
                     after(grammarAccess.getColorAccess().getVioletKeyword_1_139()); 

                    }


                    }
                    break;
                case 141 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1751:6: ( 'Wheat' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1751:6: ( 'Wheat' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1752:1: 'Wheat'
                    {
                     before(grammarAccess.getColorAccess().getWheatKeyword_1_140()); 
                    match(input,152,FOLLOW_152_in_rule__Color__Alternatives_14228); 
                     after(grammarAccess.getColorAccess().getWheatKeyword_1_140()); 

                    }


                    }
                    break;
                case 142 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1759:6: ( 'White' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1759:6: ( 'White' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1760:1: 'White'
                    {
                     before(grammarAccess.getColorAccess().getWhiteKeyword_1_141()); 
                    match(input,153,FOLLOW_153_in_rule__Color__Alternatives_14248); 
                     after(grammarAccess.getColorAccess().getWhiteKeyword_1_141()); 

                    }


                    }
                    break;
                case 143 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1767:6: ( 'WhiteSmoke' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1767:6: ( 'WhiteSmoke' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1768:1: 'WhiteSmoke'
                    {
                     before(grammarAccess.getColorAccess().getWhiteSmokeKeyword_1_142()); 
                    match(input,154,FOLLOW_154_in_rule__Color__Alternatives_14268); 
                     after(grammarAccess.getColorAccess().getWhiteSmokeKeyword_1_142()); 

                    }


                    }
                    break;
                case 144 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1775:6: ( 'Yellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1775:6: ( 'Yellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1776:1: 'Yellow'
                    {
                     before(grammarAccess.getColorAccess().getYellowKeyword_1_143()); 
                    match(input,155,FOLLOW_155_in_rule__Color__Alternatives_14288); 
                     after(grammarAccess.getColorAccess().getYellowKeyword_1_143()); 

                    }


                    }
                    break;
                case 145 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1783:6: ( 'YellowGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1783:6: ( 'YellowGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1784:1: 'YellowGreen'
                    {
                     before(grammarAccess.getColorAccess().getYellowGreenKeyword_1_144()); 
                    match(input,156,FOLLOW_156_in_rule__Color__Alternatives_14308); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1796:1: rule__Legend__Alternatives_1 : ( ( 'right' ) | ( 'left' ) | ( 'center' ) );
    public final void rule__Legend__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1800:1: ( ( 'right' ) | ( 'left' ) | ( 'center' ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 157:
                {
                alt6=1;
                }
                break;
            case 158:
                {
                alt6=2;
                }
                break;
            case 159:
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1801:1: ( 'right' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1801:1: ( 'right' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1802:1: 'right'
                    {
                     before(grammarAccess.getLegendAccess().getRightKeyword_1_0()); 
                    match(input,157,FOLLOW_157_in_rule__Legend__Alternatives_14343); 
                     after(grammarAccess.getLegendAccess().getRightKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1809:6: ( 'left' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1809:6: ( 'left' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1810:1: 'left'
                    {
                     before(grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 
                    match(input,158,FOLLOW_158_in_rule__Legend__Alternatives_14363); 
                     after(grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1817:6: ( 'center' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1817:6: ( 'center' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1818:1: 'center'
                    {
                     before(grammarAccess.getLegendAccess().getCenterKeyword_1_2()); 
                    match(input,159,FOLLOW_159_in_rule__Legend__Alternatives_14383); 
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


    // $ANTLR start "rule__Legend__Alternatives_2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1830:1: rule__Legend__Alternatives_2 : ( ( ( rule__Legend__Group_2_0__0 ) ) | ( RULE_NEWLINE ) );
    public final void rule__Legend__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1834:1: ( ( ( rule__Legend__Group_2_0__0 ) ) | ( RULE_NEWLINE ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_NEWLINE) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_ID) ) {
                    alt7=1;
                }
                else if ( (LA7_1==RULE_NEWLINE) ) {
                    alt7=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1835:1: ( ( rule__Legend__Group_2_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1835:1: ( ( rule__Legend__Group_2_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1836:1: ( rule__Legend__Group_2_0__0 )
                    {
                     before(grammarAccess.getLegendAccess().getGroup_2_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1837:1: ( rule__Legend__Group_2_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1837:2: rule__Legend__Group_2_0__0
                    {
                    pushFollow(FOLLOW_rule__Legend__Group_2_0__0_in_rule__Legend__Alternatives_24417);
                    rule__Legend__Group_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLegendAccess().getGroup_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1841:6: ( RULE_NEWLINE )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1841:6: ( RULE_NEWLINE )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1842:1: RULE_NEWLINE
                    {
                     before(grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_1()); 
                    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Legend__Alternatives_24435); 
                     after(grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_1()); 

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
    // $ANTLR end "rule__Legend__Alternatives_2"


    // $ANTLR start "rule__Diagram__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1854:1: rule__Diagram__Group__0 : rule__Diagram__Group__0__Impl rule__Diagram__Group__1 ;
    public final void rule__Diagram__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1858:1: ( rule__Diagram__Group__0__Impl rule__Diagram__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1859:2: rule__Diagram__Group__0__Impl rule__Diagram__Group__1
            {
            pushFollow(FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__04465);
            rule__Diagram__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__04468);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1866:1: rule__Diagram__Group__0__Impl : ( '@startuml' ) ;
    public final void rule__Diagram__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1870:1: ( ( '@startuml' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1871:1: ( '@startuml' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1871:1: ( '@startuml' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1872:1: '@startuml'
            {
             before(grammarAccess.getDiagramAccess().getStartumlKeyword_0()); 
            match(input,160,FOLLOW_160_in_rule__Diagram__Group__0__Impl4496); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1885:1: rule__Diagram__Group__1 : rule__Diagram__Group__1__Impl rule__Diagram__Group__2 ;
    public final void rule__Diagram__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1889:1: ( rule__Diagram__Group__1__Impl rule__Diagram__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1890:2: rule__Diagram__Group__1__Impl rule__Diagram__Group__2
            {
            pushFollow(FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__14527);
            rule__Diagram__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__14530);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1897:1: rule__Diagram__Group__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Diagram__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1901:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1902:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1902:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1903:1: RULE_NEWLINE
            {
             before(grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__1__Impl4557); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1914:1: rule__Diagram__Group__2 : rule__Diagram__Group__2__Impl rule__Diagram__Group__3 ;
    public final void rule__Diagram__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1918:1: ( rule__Diagram__Group__2__Impl rule__Diagram__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1919:2: rule__Diagram__Group__2__Impl rule__Diagram__Group__3
            {
            pushFollow(FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__24586);
            rule__Diagram__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__3_in_rule__Diagram__Group__24589);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1926:1: rule__Diagram__Group__2__Impl : ( ( rule__Diagram__InstructionsAssignment_2 )* ) ;
    public final void rule__Diagram__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1930:1: ( ( ( rule__Diagram__InstructionsAssignment_2 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1931:1: ( ( rule__Diagram__InstructionsAssignment_2 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1931:1: ( ( rule__Diagram__InstructionsAssignment_2 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1932:1: ( rule__Diagram__InstructionsAssignment_2 )*
            {
             before(grammarAccess.getDiagramAccess().getInstructionsAssignment_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1933:1: ( rule__Diagram__InstructionsAssignment_2 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=RULE_NEWLINE && LA8_0<=RULE_ID)||(LA8_0>=172 && LA8_0<=177)||(LA8_0>=179 && LA8_0<=180)||(LA8_0>=182 && LA8_0<=183)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1933:2: rule__Diagram__InstructionsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Diagram__InstructionsAssignment_2_in_rule__Diagram__Group__2__Impl4616);
            	    rule__Diagram__InstructionsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1943:1: rule__Diagram__Group__3 : rule__Diagram__Group__3__Impl ;
    public final void rule__Diagram__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1947:1: ( rule__Diagram__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1948:2: rule__Diagram__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Diagram__Group__3__Impl_in_rule__Diagram__Group__34647);
            rule__Diagram__Group__3__Impl();

            state._fsp--;


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1954:1: rule__Diagram__Group__3__Impl : ( '@enduml' ) ;
    public final void rule__Diagram__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1958:1: ( ( '@enduml' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1959:1: ( '@enduml' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1959:1: ( '@enduml' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1960:1: '@enduml'
            {
             before(grammarAccess.getDiagramAccess().getEndumlKeyword_3()); 
            match(input,161,FOLLOW_161_in_rule__Diagram__Group__3__Impl4675); 
             after(grammarAccess.getDiagramAccess().getEndumlKeyword_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__Instruction__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1981:1: rule__Instruction__Group__0 : rule__Instruction__Group__0__Impl rule__Instruction__Group__1 ;
    public final void rule__Instruction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1985:1: ( rule__Instruction__Group__0__Impl rule__Instruction__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1986:2: rule__Instruction__Group__0__Impl rule__Instruction__Group__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group__0__Impl_in_rule__Instruction__Group__04714);
            rule__Instruction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group__1_in_rule__Instruction__Group__04717);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1993:1: rule__Instruction__Group__0__Impl : ( ( rule__Instruction__Alternatives_0 )? ) ;
    public final void rule__Instruction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1997:1: ( ( ( rule__Instruction__Alternatives_0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1998:1: ( ( rule__Instruction__Alternatives_0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1998:1: ( ( rule__Instruction__Alternatives_0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1999:1: ( rule__Instruction__Alternatives_0 )?
            {
             before(grammarAccess.getInstructionAccess().getAlternatives_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2000:1: ( rule__Instruction__Alternatives_0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID||(LA9_0>=172 && LA9_0<=177)||(LA9_0>=179 && LA9_0<=180)||(LA9_0>=182 && LA9_0<=183)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2000:2: rule__Instruction__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Alternatives_0_in_rule__Instruction__Group__0__Impl4744);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2010:1: rule__Instruction__Group__1 : rule__Instruction__Group__1__Impl ;
    public final void rule__Instruction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2014:1: ( rule__Instruction__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2015:2: rule__Instruction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group__1__Impl_in_rule__Instruction__Group__14775);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2021:1: rule__Instruction__Group__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Instruction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2025:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2026:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2026:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2027:1: RULE_NEWLINE
            {
             before(grammarAccess.getInstructionAccess().getNEWLINETerminalRuleCall_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Instruction__Group__1__Impl4802); 
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


    // $ANTLR start "rule__Instruction__Group_0_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2042:1: rule__Instruction__Group_0_0__0 : rule__Instruction__Group_0_0__0__Impl rule__Instruction__Group_0_0__1 ;
    public final void rule__Instruction__Group_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2046:1: ( rule__Instruction__Group_0_0__0__Impl rule__Instruction__Group_0_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2047:2: rule__Instruction__Group_0_0__0__Impl rule__Instruction__Group_0_0__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_0__0__Impl_in_rule__Instruction__Group_0_0__04835);
            rule__Instruction__Group_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_0__1_in_rule__Instruction__Group_0_0__04838);
            rule__Instruction__Group_0_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_0__0"


    // $ANTLR start "rule__Instruction__Group_0_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2054:1: rule__Instruction__Group_0_0__0__Impl : ( ( rule__Instruction__Name1Assignment_0_0_0 ) ) ;
    public final void rule__Instruction__Group_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2058:1: ( ( ( rule__Instruction__Name1Assignment_0_0_0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2059:1: ( ( rule__Instruction__Name1Assignment_0_0_0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2059:1: ( ( rule__Instruction__Name1Assignment_0_0_0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2060:1: ( rule__Instruction__Name1Assignment_0_0_0 )
            {
             before(grammarAccess.getInstructionAccess().getName1Assignment_0_0_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2061:1: ( rule__Instruction__Name1Assignment_0_0_0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2061:2: rule__Instruction__Name1Assignment_0_0_0
            {
            pushFollow(FOLLOW_rule__Instruction__Name1Assignment_0_0_0_in_rule__Instruction__Group_0_0__0__Impl4865);
            rule__Instruction__Name1Assignment_0_0_0();

            state._fsp--;


            }

             after(grammarAccess.getInstructionAccess().getName1Assignment_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_0__0__Impl"


    // $ANTLR start "rule__Instruction__Group_0_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2071:1: rule__Instruction__Group_0_0__1 : rule__Instruction__Group_0_0__1__Impl rule__Instruction__Group_0_0__2 ;
    public final void rule__Instruction__Group_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2075:1: ( rule__Instruction__Group_0_0__1__Impl rule__Instruction__Group_0_0__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2076:2: rule__Instruction__Group_0_0__1__Impl rule__Instruction__Group_0_0__2
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_0__1__Impl_in_rule__Instruction__Group_0_0__14895);
            rule__Instruction__Group_0_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_0__2_in_rule__Instruction__Group_0_0__14898);
            rule__Instruction__Group_0_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_0__1"


    // $ANTLR start "rule__Instruction__Group_0_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2083:1: rule__Instruction__Group_0_0__1__Impl : ( ruleSequence ) ;
    public final void rule__Instruction__Group_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2087:1: ( ( ruleSequence ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2088:1: ( ruleSequence )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2088:1: ( ruleSequence )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2089:1: ruleSequence
            {
             before(grammarAccess.getInstructionAccess().getSequenceParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_ruleSequence_in_rule__Instruction__Group_0_0__1__Impl4925);
            ruleSequence();

            state._fsp--;

             after(grammarAccess.getInstructionAccess().getSequenceParserRuleCall_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_0__1__Impl"


    // $ANTLR start "rule__Instruction__Group_0_0__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2100:1: rule__Instruction__Group_0_0__2 : rule__Instruction__Group_0_0__2__Impl rule__Instruction__Group_0_0__3 ;
    public final void rule__Instruction__Group_0_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2104:1: ( rule__Instruction__Group_0_0__2__Impl rule__Instruction__Group_0_0__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2105:2: rule__Instruction__Group_0_0__2__Impl rule__Instruction__Group_0_0__3
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_0__2__Impl_in_rule__Instruction__Group_0_0__24954);
            rule__Instruction__Group_0_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_0__3_in_rule__Instruction__Group_0_0__24957);
            rule__Instruction__Group_0_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_0__2"


    // $ANTLR start "rule__Instruction__Group_0_0__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2112:1: rule__Instruction__Group_0_0__2__Impl : ( ( rule__Instruction__Name2Assignment_0_0_2 ) ) ;
    public final void rule__Instruction__Group_0_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2116:1: ( ( ( rule__Instruction__Name2Assignment_0_0_2 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2117:1: ( ( rule__Instruction__Name2Assignment_0_0_2 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2117:1: ( ( rule__Instruction__Name2Assignment_0_0_2 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2118:1: ( rule__Instruction__Name2Assignment_0_0_2 )
            {
             before(grammarAccess.getInstructionAccess().getName2Assignment_0_0_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2119:1: ( rule__Instruction__Name2Assignment_0_0_2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2119:2: rule__Instruction__Name2Assignment_0_0_2
            {
            pushFollow(FOLLOW_rule__Instruction__Name2Assignment_0_0_2_in_rule__Instruction__Group_0_0__2__Impl4984);
            rule__Instruction__Name2Assignment_0_0_2();

            state._fsp--;


            }

             after(grammarAccess.getInstructionAccess().getName2Assignment_0_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_0__2__Impl"


    // $ANTLR start "rule__Instruction__Group_0_0__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2129:1: rule__Instruction__Group_0_0__3 : rule__Instruction__Group_0_0__3__Impl ;
    public final void rule__Instruction__Group_0_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2133:1: ( rule__Instruction__Group_0_0__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2134:2: rule__Instruction__Group_0_0__3__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_0__3__Impl_in_rule__Instruction__Group_0_0__35014);
            rule__Instruction__Group_0_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_0__3"


    // $ANTLR start "rule__Instruction__Group_0_0__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2140:1: rule__Instruction__Group_0_0__3__Impl : ( ( rule__Instruction__Group_0_0_3__0 )? ) ;
    public final void rule__Instruction__Group_0_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2144:1: ( ( ( rule__Instruction__Group_0_0_3__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2145:1: ( ( rule__Instruction__Group_0_0_3__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2145:1: ( ( rule__Instruction__Group_0_0_3__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2146:1: ( rule__Instruction__Group_0_0_3__0 )?
            {
             before(grammarAccess.getInstructionAccess().getGroup_0_0_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2147:1: ( rule__Instruction__Group_0_0_3__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==162) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2147:2: rule__Instruction__Group_0_0_3__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_0_0_3__0_in_rule__Instruction__Group_0_0__3__Impl5041);
                    rule__Instruction__Group_0_0_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getInstructionAccess().getGroup_0_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_0__3__Impl"


    // $ANTLR start "rule__Instruction__Group_0_0_3__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2165:1: rule__Instruction__Group_0_0_3__0 : rule__Instruction__Group_0_0_3__0__Impl rule__Instruction__Group_0_0_3__1 ;
    public final void rule__Instruction__Group_0_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2169:1: ( rule__Instruction__Group_0_0_3__0__Impl rule__Instruction__Group_0_0_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2170:2: rule__Instruction__Group_0_0_3__0__Impl rule__Instruction__Group_0_0_3__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_0_3__0__Impl_in_rule__Instruction__Group_0_0_3__05080);
            rule__Instruction__Group_0_0_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_0_3__1_in_rule__Instruction__Group_0_0_3__05083);
            rule__Instruction__Group_0_0_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_0_3__0"


    // $ANTLR start "rule__Instruction__Group_0_0_3__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2177:1: rule__Instruction__Group_0_0_3__0__Impl : ( ':' ) ;
    public final void rule__Instruction__Group_0_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2181:1: ( ( ':' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2182:1: ( ':' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2182:1: ( ':' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2183:1: ':'
            {
             before(grammarAccess.getInstructionAccess().getColonKeyword_0_0_3_0()); 
            match(input,162,FOLLOW_162_in_rule__Instruction__Group_0_0_3__0__Impl5111); 
             after(grammarAccess.getInstructionAccess().getColonKeyword_0_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_0_3__0__Impl"


    // $ANTLR start "rule__Instruction__Group_0_0_3__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2196:1: rule__Instruction__Group_0_0_3__1 : rule__Instruction__Group_0_0_3__1__Impl ;
    public final void rule__Instruction__Group_0_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2200:1: ( rule__Instruction__Group_0_0_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2201:2: rule__Instruction__Group_0_0_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_0_3__1__Impl_in_rule__Instruction__Group_0_0_3__15142);
            rule__Instruction__Group_0_0_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_0_3__1"


    // $ANTLR start "rule__Instruction__Group_0_0_3__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2207:1: rule__Instruction__Group_0_0_3__1__Impl : ( RULE_ID ) ;
    public final void rule__Instruction__Group_0_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2211:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2212:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2212:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2213:1: RULE_ID
            {
             before(grammarAccess.getInstructionAccess().getIDTerminalRuleCall_0_0_3_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Instruction__Group_0_0_3__1__Impl5169); 
             after(grammarAccess.getInstructionAccess().getIDTerminalRuleCall_0_0_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_0_3__1__Impl"


    // $ANTLR start "rule__Instruction__Group_0_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2228:1: rule__Instruction__Group_0_1__0 : rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1 ;
    public final void rule__Instruction__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2232:1: ( rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2233:2: rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_1__0__Impl_in_rule__Instruction__Group_0_1__05202);
            rule__Instruction__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_1__1_in_rule__Instruction__Group_0_1__05205);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2240:1: rule__Instruction__Group_0_1__0__Impl : ( ruleDefinition ) ;
    public final void rule__Instruction__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2244:1: ( ( ruleDefinition ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2245:1: ( ruleDefinition )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2245:1: ( ruleDefinition )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2246:1: ruleDefinition
            {
             before(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_ruleDefinition_in_rule__Instruction__Group_0_1__0__Impl5232);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2257:1: rule__Instruction__Group_0_1__1 : rule__Instruction__Group_0_1__1__Impl ;
    public final void rule__Instruction__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2261:1: ( rule__Instruction__Group_0_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2262:2: rule__Instruction__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_1__1__Impl_in_rule__Instruction__Group_0_1__15261);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2268:1: rule__Instruction__Group_0_1__1__Impl : ( ( ruleColor )? ) ;
    public final void rule__Instruction__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2272:1: ( ( ( ruleColor )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2273:1: ( ( ruleColor )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2273:1: ( ( ruleColor )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2274:1: ( ruleColor )?
            {
             before(grammarAccess.getInstructionAccess().getColorParserRuleCall_0_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2275:1: ( ruleColor )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==178) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2275:3: ruleColor
                    {
                    pushFollow(FOLLOW_ruleColor_in_rule__Instruction__Group_0_1__1__Impl5289);
                    ruleColor();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getInstructionAccess().getColorParserRuleCall_0_1_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Sequence__Group_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2289:1: rule__Sequence__Group_0__0 : rule__Sequence__Group_0__0__Impl rule__Sequence__Group_0__1 ;
    public final void rule__Sequence__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2293:1: ( rule__Sequence__Group_0__0__Impl rule__Sequence__Group_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2294:2: rule__Sequence__Group_0__0__Impl rule__Sequence__Group_0__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_0__0__Impl_in_rule__Sequence__Group_0__05324);
            rule__Sequence__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_0__1_in_rule__Sequence__Group_0__05327);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2301:1: rule__Sequence__Group_0__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2305:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2306:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2306:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2307:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_0_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2308:1: ( '-' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==163) ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1==163) ) {
                        alt12=1;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2309:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_0__0__Impl5356); 

            	    }
            	    break;

            	default :
            	    break loop12;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2320:1: rule__Sequence__Group_0__1 : rule__Sequence__Group_0__1__Impl rule__Sequence__Group_0__2 ;
    public final void rule__Sequence__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2324:1: ( rule__Sequence__Group_0__1__Impl rule__Sequence__Group_0__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2325:2: rule__Sequence__Group_0__1__Impl rule__Sequence__Group_0__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_0__1__Impl_in_rule__Sequence__Group_0__15389);
            rule__Sequence__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_0__2_in_rule__Sequence__Group_0__15392);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2332:1: rule__Sequence__Group_0__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2336:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2337:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2337:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2338:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_0_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_0__1__Impl5420); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2351:1: rule__Sequence__Group_0__2 : rule__Sequence__Group_0__2__Impl ;
    public final void rule__Sequence__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2355:1: ( rule__Sequence__Group_0__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2356:2: rule__Sequence__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_0__2__Impl_in_rule__Sequence__Group_0__25451);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2362:1: rule__Sequence__Group_0__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2366:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2367:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2367:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2368:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_0_2()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_0__2__Impl5479); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2387:1: rule__Sequence__Group_1__0 : rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1 ;
    public final void rule__Sequence__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2391:1: ( rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2392:2: rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_1__0__Impl_in_rule__Sequence__Group_1__05516);
            rule__Sequence__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_1__1_in_rule__Sequence__Group_1__05519);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2399:1: rule__Sequence__Group_1__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2403:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2404:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2404:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2405:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_1_0()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_1__0__Impl5547); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2418:1: rule__Sequence__Group_1__1 : rule__Sequence__Group_1__1__Impl rule__Sequence__Group_1__2 ;
    public final void rule__Sequence__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2422:1: ( rule__Sequence__Group_1__1__Impl rule__Sequence__Group_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2423:2: rule__Sequence__Group_1__1__Impl rule__Sequence__Group_1__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_1__1__Impl_in_rule__Sequence__Group_1__15578);
            rule__Sequence__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_1__2_in_rule__Sequence__Group_1__15581);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2430:1: rule__Sequence__Group_1__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2434:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2435:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2435:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2436:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_1_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_1__1__Impl5609); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2449:1: rule__Sequence__Group_1__2 : rule__Sequence__Group_1__2__Impl ;
    public final void rule__Sequence__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2453:1: ( rule__Sequence__Group_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2454:2: rule__Sequence__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_1__2__Impl_in_rule__Sequence__Group_1__25640);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2460:1: rule__Sequence__Group_1__2__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2464:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2465:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2465:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2466:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_1_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2467:1: ( '-' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==163) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2468:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_1__2__Impl5669); 

            	    }
            	    break;

            	default :
            	    break loop13;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2485:1: rule__Sequence__Group_2__0 : rule__Sequence__Group_2__0__Impl rule__Sequence__Group_2__1 ;
    public final void rule__Sequence__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2489:1: ( rule__Sequence__Group_2__0__Impl rule__Sequence__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2490:2: rule__Sequence__Group_2__0__Impl rule__Sequence__Group_2__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_2__0__Impl_in_rule__Sequence__Group_2__05708);
            rule__Sequence__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_2__1_in_rule__Sequence__Group_2__05711);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2497:1: rule__Sequence__Group_2__0__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2501:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2502:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2502:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2503:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_2_0()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_2__0__Impl5739); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2516:1: rule__Sequence__Group_2__1 : rule__Sequence__Group_2__1__Impl rule__Sequence__Group_2__2 ;
    public final void rule__Sequence__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2520:1: ( rule__Sequence__Group_2__1__Impl rule__Sequence__Group_2__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2521:2: rule__Sequence__Group_2__1__Impl rule__Sequence__Group_2__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_2__1__Impl_in_rule__Sequence__Group_2__15770);
            rule__Sequence__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_2__2_in_rule__Sequence__Group_2__15773);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2528:1: rule__Sequence__Group_2__1__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2532:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2533:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2533:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2534:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_2_1()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_2__1__Impl5801); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2547:1: rule__Sequence__Group_2__2 : rule__Sequence__Group_2__2__Impl ;
    public final void rule__Sequence__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2551:1: ( rule__Sequence__Group_2__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2552:2: rule__Sequence__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_2__2__Impl_in_rule__Sequence__Group_2__25832);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2558:1: rule__Sequence__Group_2__2__Impl : ( 'x' ) ;
    public final void rule__Sequence__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2562:1: ( ( 'x' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2563:1: ( 'x' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2563:1: ( 'x' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2564:1: 'x'
            {
             before(grammarAccess.getSequenceAccess().getXKeyword_2_2()); 
            match(input,166,FOLLOW_166_in_rule__Sequence__Group_2__2__Impl5860); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2583:1: rule__Sequence__Group_3__0 : rule__Sequence__Group_3__0__Impl rule__Sequence__Group_3__1 ;
    public final void rule__Sequence__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2587:1: ( rule__Sequence__Group_3__0__Impl rule__Sequence__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2588:2: rule__Sequence__Group_3__0__Impl rule__Sequence__Group_3__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_3__0__Impl_in_rule__Sequence__Group_3__05897);
            rule__Sequence__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_3__1_in_rule__Sequence__Group_3__05900);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2595:1: rule__Sequence__Group_3__0__Impl : ( 'x' ) ;
    public final void rule__Sequence__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2599:1: ( ( 'x' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2600:1: ( 'x' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2600:1: ( 'x' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2601:1: 'x'
            {
             before(grammarAccess.getSequenceAccess().getXKeyword_3_0()); 
            match(input,166,FOLLOW_166_in_rule__Sequence__Group_3__0__Impl5928); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2614:1: rule__Sequence__Group_3__1 : rule__Sequence__Group_3__1__Impl rule__Sequence__Group_3__2 ;
    public final void rule__Sequence__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2618:1: ( rule__Sequence__Group_3__1__Impl rule__Sequence__Group_3__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2619:2: rule__Sequence__Group_3__1__Impl rule__Sequence__Group_3__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_3__1__Impl_in_rule__Sequence__Group_3__15959);
            rule__Sequence__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_3__2_in_rule__Sequence__Group_3__15962);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2626:1: rule__Sequence__Group_3__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2630:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2631:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2631:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2632:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_3_1()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_3__1__Impl5990); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2645:1: rule__Sequence__Group_3__2 : rule__Sequence__Group_3__2__Impl ;
    public final void rule__Sequence__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2649:1: ( rule__Sequence__Group_3__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2650:2: rule__Sequence__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_3__2__Impl_in_rule__Sequence__Group_3__26021);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2656:1: rule__Sequence__Group_3__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2660:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2661:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2661:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2662:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_3_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_3__2__Impl6049); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2681:1: rule__Sequence__Group_4__0 : rule__Sequence__Group_4__0__Impl rule__Sequence__Group_4__1 ;
    public final void rule__Sequence__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2685:1: ( rule__Sequence__Group_4__0__Impl rule__Sequence__Group_4__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2686:2: rule__Sequence__Group_4__0__Impl rule__Sequence__Group_4__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__0__Impl_in_rule__Sequence__Group_4__06086);
            rule__Sequence__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_4__1_in_rule__Sequence__Group_4__06089);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2693:1: rule__Sequence__Group_4__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2697:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2698:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2698:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2699:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_4_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2700:1: ( '-' )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==163) ) {
                    int LA14_1 = input.LA(2);

                    if ( (LA14_1==163) ) {
                        alt14=1;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2701:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_4__0__Impl6118); 

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2712:1: rule__Sequence__Group_4__1 : rule__Sequence__Group_4__1__Impl rule__Sequence__Group_4__2 ;
    public final void rule__Sequence__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2716:1: ( rule__Sequence__Group_4__1__Impl rule__Sequence__Group_4__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2717:2: rule__Sequence__Group_4__1__Impl rule__Sequence__Group_4__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__1__Impl_in_rule__Sequence__Group_4__16151);
            rule__Sequence__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_4__2_in_rule__Sequence__Group_4__16154);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2724:1: rule__Sequence__Group_4__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2728:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2729:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2729:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2730:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_4_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_4__1__Impl6182); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2743:1: rule__Sequence__Group_4__2 : rule__Sequence__Group_4__2__Impl rule__Sequence__Group_4__3 ;
    public final void rule__Sequence__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2747:1: ( rule__Sequence__Group_4__2__Impl rule__Sequence__Group_4__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2748:2: rule__Sequence__Group_4__2__Impl rule__Sequence__Group_4__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__2__Impl_in_rule__Sequence__Group_4__26213);
            rule__Sequence__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_4__3_in_rule__Sequence__Group_4__26216);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2755:1: rule__Sequence__Group_4__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2759:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2760:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2760:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2761:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4_2()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_4__2__Impl6244); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2774:1: rule__Sequence__Group_4__3 : rule__Sequence__Group_4__3__Impl ;
    public final void rule__Sequence__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2778:1: ( rule__Sequence__Group_4__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2779:2: rule__Sequence__Group_4__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__3__Impl_in_rule__Sequence__Group_4__36275);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2785:1: rule__Sequence__Group_4__3__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2789:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2790:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2790:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2791:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4_3()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_4__3__Impl6303); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2812:1: rule__Sequence__Group_5__0 : rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1 ;
    public final void rule__Sequence__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2816:1: ( rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2817:2: rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__0__Impl_in_rule__Sequence__Group_5__06342);
            rule__Sequence__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_5__1_in_rule__Sequence__Group_5__06345);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2824:1: rule__Sequence__Group_5__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2828:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2829:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2829:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2830:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_5_0()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_5__0__Impl6373); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2843:1: rule__Sequence__Group_5__1 : rule__Sequence__Group_5__1__Impl rule__Sequence__Group_5__2 ;
    public final void rule__Sequence__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2847:1: ( rule__Sequence__Group_5__1__Impl rule__Sequence__Group_5__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2848:2: rule__Sequence__Group_5__1__Impl rule__Sequence__Group_5__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__1__Impl_in_rule__Sequence__Group_5__16404);
            rule__Sequence__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_5__2_in_rule__Sequence__Group_5__16407);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2855:1: rule__Sequence__Group_5__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2859:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2860:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2860:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2861:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_5_1()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_5__1__Impl6435); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2874:1: rule__Sequence__Group_5__2 : rule__Sequence__Group_5__2__Impl rule__Sequence__Group_5__3 ;
    public final void rule__Sequence__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2878:1: ( rule__Sequence__Group_5__2__Impl rule__Sequence__Group_5__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2879:2: rule__Sequence__Group_5__2__Impl rule__Sequence__Group_5__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__2__Impl_in_rule__Sequence__Group_5__26466);
            rule__Sequence__Group_5__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_5__3_in_rule__Sequence__Group_5__26469);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2886:1: rule__Sequence__Group_5__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2890:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2891:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2891:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2892:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_5_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_5__2__Impl6497); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2905:1: rule__Sequence__Group_5__3 : rule__Sequence__Group_5__3__Impl ;
    public final void rule__Sequence__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2909:1: ( rule__Sequence__Group_5__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2910:2: rule__Sequence__Group_5__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__3__Impl_in_rule__Sequence__Group_5__36528);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2916:1: rule__Sequence__Group_5__3__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2920:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2921:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2921:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2922:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_5_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2923:1: ( '-' )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==163) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2924:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_5__3__Impl6557); 

            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2943:1: rule__Sequence__Group_6__0 : rule__Sequence__Group_6__0__Impl rule__Sequence__Group_6__1 ;
    public final void rule__Sequence__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2947:1: ( rule__Sequence__Group_6__0__Impl rule__Sequence__Group_6__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2948:2: rule__Sequence__Group_6__0__Impl rule__Sequence__Group_6__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__0__Impl_in_rule__Sequence__Group_6__06598);
            rule__Sequence__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_6__1_in_rule__Sequence__Group_6__06601);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2955:1: rule__Sequence__Group_6__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2959:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2960:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2960:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2961:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_6_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2962:1: ( '-' )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==163) ) {
                    int LA16_1 = input.LA(2);

                    if ( (LA16_1==163) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2963:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_6__0__Impl6630); 

            	    }
            	    break;

            	default :
            	    break loop16;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2974:1: rule__Sequence__Group_6__1 : rule__Sequence__Group_6__1__Impl rule__Sequence__Group_6__2 ;
    public final void rule__Sequence__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2978:1: ( rule__Sequence__Group_6__1__Impl rule__Sequence__Group_6__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2979:2: rule__Sequence__Group_6__1__Impl rule__Sequence__Group_6__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__1__Impl_in_rule__Sequence__Group_6__16663);
            rule__Sequence__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_6__2_in_rule__Sequence__Group_6__16666);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2986:1: rule__Sequence__Group_6__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2990:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2991:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2991:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2992:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_6_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_6__1__Impl6694); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3005:1: rule__Sequence__Group_6__2 : rule__Sequence__Group_6__2__Impl rule__Sequence__Group_6__3 ;
    public final void rule__Sequence__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3009:1: ( rule__Sequence__Group_6__2__Impl rule__Sequence__Group_6__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3010:2: rule__Sequence__Group_6__2__Impl rule__Sequence__Group_6__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__2__Impl_in_rule__Sequence__Group_6__26725);
            rule__Sequence__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_6__3_in_rule__Sequence__Group_6__26728);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3017:1: rule__Sequence__Group_6__2__Impl : ( '\\\\' ) ;
    public final void rule__Sequence__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3021:1: ( ( '\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3022:1: ( '\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3022:1: ( '\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3023:1: '\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusKeyword_6_2()); 
            match(input,167,FOLLOW_167_in_rule__Sequence__Group_6__2__Impl6756); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3036:1: rule__Sequence__Group_6__3 : rule__Sequence__Group_6__3__Impl ;
    public final void rule__Sequence__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3040:1: ( rule__Sequence__Group_6__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3041:2: rule__Sequence__Group_6__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__3__Impl_in_rule__Sequence__Group_6__36787);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3047:1: rule__Sequence__Group_6__3__Impl : ( '\\\\' ) ;
    public final void rule__Sequence__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3051:1: ( ( '\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3052:1: ( '\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3052:1: ( '\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3053:1: '\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusKeyword_6_3()); 
            match(input,167,FOLLOW_167_in_rule__Sequence__Group_6__3__Impl6815); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3074:1: rule__Sequence__Group_7__0 : rule__Sequence__Group_7__0__Impl rule__Sequence__Group_7__1 ;
    public final void rule__Sequence__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3078:1: ( rule__Sequence__Group_7__0__Impl rule__Sequence__Group_7__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3079:2: rule__Sequence__Group_7__0__Impl rule__Sequence__Group_7__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_7__0__Impl_in_rule__Sequence__Group_7__06854);
            rule__Sequence__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_7__1_in_rule__Sequence__Group_7__06857);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3086:1: rule__Sequence__Group_7__0__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3090:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3091:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3091:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3092:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_7_0()); 
            match(input,168,FOLLOW_168_in_rule__Sequence__Group_7__0__Impl6885); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3105:1: rule__Sequence__Group_7__1 : rule__Sequence__Group_7__1__Impl rule__Sequence__Group_7__2 ;
    public final void rule__Sequence__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3109:1: ( rule__Sequence__Group_7__1__Impl rule__Sequence__Group_7__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3110:2: rule__Sequence__Group_7__1__Impl rule__Sequence__Group_7__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_7__1__Impl_in_rule__Sequence__Group_7__16916);
            rule__Sequence__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_7__2_in_rule__Sequence__Group_7__16919);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3117:1: rule__Sequence__Group_7__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3121:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3122:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3122:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3123:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_7_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_7__1__Impl6947); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3136:1: rule__Sequence__Group_7__2 : rule__Sequence__Group_7__2__Impl ;
    public final void rule__Sequence__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3140:1: ( rule__Sequence__Group_7__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3141:2: rule__Sequence__Group_7__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_7__2__Impl_in_rule__Sequence__Group_7__26978);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3147:1: rule__Sequence__Group_7__2__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3151:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3152:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3152:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3153:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_7_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3154:1: ( '-' )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==163) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3155:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_7__2__Impl7007); 

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3172:1: rule__Sequence__Group_8__0 : rule__Sequence__Group_8__0__Impl rule__Sequence__Group_8__1 ;
    public final void rule__Sequence__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3176:1: ( rule__Sequence__Group_8__0__Impl rule__Sequence__Group_8__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3177:2: rule__Sequence__Group_8__0__Impl rule__Sequence__Group_8__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_8__0__Impl_in_rule__Sequence__Group_8__07046);
            rule__Sequence__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_8__1_in_rule__Sequence__Group_8__07049);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3184:1: rule__Sequence__Group_8__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3188:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3189:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3189:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3190:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_8_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3191:1: ( '-' )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==163) ) {
                    int LA18_1 = input.LA(2);

                    if ( (LA18_1==163) ) {
                        alt18=1;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3192:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_8__0__Impl7078); 

            	    }
            	    break;

            	default :
            	    break loop18;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3203:1: rule__Sequence__Group_8__1 : rule__Sequence__Group_8__1__Impl rule__Sequence__Group_8__2 ;
    public final void rule__Sequence__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3207:1: ( rule__Sequence__Group_8__1__Impl rule__Sequence__Group_8__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3208:2: rule__Sequence__Group_8__1__Impl rule__Sequence__Group_8__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_8__1__Impl_in_rule__Sequence__Group_8__17111);
            rule__Sequence__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_8__2_in_rule__Sequence__Group_8__17114);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3215:1: rule__Sequence__Group_8__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3219:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3220:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3220:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3221:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_8_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_8__1__Impl7142); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3234:1: rule__Sequence__Group_8__2 : rule__Sequence__Group_8__2__Impl ;
    public final void rule__Sequence__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3238:1: ( rule__Sequence__Group_8__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3239:2: rule__Sequence__Group_8__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_8__2__Impl_in_rule__Sequence__Group_8__27173);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3245:1: rule__Sequence__Group_8__2__Impl : ( '\\\\\\\\' ) ;
    public final void rule__Sequence__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3249:1: ( ( '\\\\\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3250:1: ( '\\\\\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3250:1: ( '\\\\\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3251:1: '\\\\\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusReverseSolidusKeyword_8_2()); 
            match(input,169,FOLLOW_169_in_rule__Sequence__Group_8__2__Impl7201); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3270:1: rule__Sequence__Group_9__0 : rule__Sequence__Group_9__0__Impl rule__Sequence__Group_9__1 ;
    public final void rule__Sequence__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3274:1: ( rule__Sequence__Group_9__0__Impl rule__Sequence__Group_9__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3275:2: rule__Sequence__Group_9__0__Impl rule__Sequence__Group_9__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__0__Impl_in_rule__Sequence__Group_9__07238);
            rule__Sequence__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_9__1_in_rule__Sequence__Group_9__07241);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3282:1: rule__Sequence__Group_9__0__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3286:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3287:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3287:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3288:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_9_0()); 
            match(input,168,FOLLOW_168_in_rule__Sequence__Group_9__0__Impl7269); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3301:1: rule__Sequence__Group_9__1 : rule__Sequence__Group_9__1__Impl rule__Sequence__Group_9__2 ;
    public final void rule__Sequence__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3305:1: ( rule__Sequence__Group_9__1__Impl rule__Sequence__Group_9__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3306:2: rule__Sequence__Group_9__1__Impl rule__Sequence__Group_9__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__1__Impl_in_rule__Sequence__Group_9__17300);
            rule__Sequence__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_9__2_in_rule__Sequence__Group_9__17303);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3313:1: rule__Sequence__Group_9__1__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3317:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3318:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3318:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3319:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_9_1()); 
            match(input,168,FOLLOW_168_in_rule__Sequence__Group_9__1__Impl7331); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3332:1: rule__Sequence__Group_9__2 : rule__Sequence__Group_9__2__Impl rule__Sequence__Group_9__3 ;
    public final void rule__Sequence__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3336:1: ( rule__Sequence__Group_9__2__Impl rule__Sequence__Group_9__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3337:2: rule__Sequence__Group_9__2__Impl rule__Sequence__Group_9__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__2__Impl_in_rule__Sequence__Group_9__27362);
            rule__Sequence__Group_9__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_9__3_in_rule__Sequence__Group_9__27365);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3344:1: rule__Sequence__Group_9__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3348:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3349:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3349:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3350:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_9_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_9__2__Impl7393); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3363:1: rule__Sequence__Group_9__3 : rule__Sequence__Group_9__3__Impl ;
    public final void rule__Sequence__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3367:1: ( rule__Sequence__Group_9__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3368:2: rule__Sequence__Group_9__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__3__Impl_in_rule__Sequence__Group_9__37424);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3374:1: rule__Sequence__Group_9__3__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3378:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3379:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3379:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3380:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_9_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3381:1: ( '-' )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==163) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3382:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_9__3__Impl7453); 

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3401:1: rule__Sequence__Group_10__0 : rule__Sequence__Group_10__0__Impl rule__Sequence__Group_10__1 ;
    public final void rule__Sequence__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3405:1: ( rule__Sequence__Group_10__0__Impl rule__Sequence__Group_10__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3406:2: rule__Sequence__Group_10__0__Impl rule__Sequence__Group_10__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__0__Impl_in_rule__Sequence__Group_10__07494);
            rule__Sequence__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_10__1_in_rule__Sequence__Group_10__07497);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3413:1: rule__Sequence__Group_10__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3417:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3418:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3418:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3419:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_10_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3420:1: ( '-' )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==163) ) {
                    int LA20_1 = input.LA(2);

                    if ( (LA20_1==163) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3421:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_10__0__Impl7526); 

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3432:1: rule__Sequence__Group_10__1 : rule__Sequence__Group_10__1__Impl rule__Sequence__Group_10__2 ;
    public final void rule__Sequence__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3436:1: ( rule__Sequence__Group_10__1__Impl rule__Sequence__Group_10__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3437:2: rule__Sequence__Group_10__1__Impl rule__Sequence__Group_10__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__1__Impl_in_rule__Sequence__Group_10__17559);
            rule__Sequence__Group_10__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_10__2_in_rule__Sequence__Group_10__17562);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3444:1: rule__Sequence__Group_10__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3448:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3449:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3449:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3450:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_10_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_10__1__Impl7590); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3463:1: rule__Sequence__Group_10__2 : rule__Sequence__Group_10__2__Impl rule__Sequence__Group_10__3 ;
    public final void rule__Sequence__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3467:1: ( rule__Sequence__Group_10__2__Impl rule__Sequence__Group_10__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3468:2: rule__Sequence__Group_10__2__Impl rule__Sequence__Group_10__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__2__Impl_in_rule__Sequence__Group_10__27621);
            rule__Sequence__Group_10__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_10__3_in_rule__Sequence__Group_10__27624);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3475:1: rule__Sequence__Group_10__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3479:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3480:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3480:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3481:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_10_2()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_10__2__Impl7652); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3494:1: rule__Sequence__Group_10__3 : rule__Sequence__Group_10__3__Impl ;
    public final void rule__Sequence__Group_10__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3498:1: ( rule__Sequence__Group_10__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3499:2: rule__Sequence__Group_10__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__3__Impl_in_rule__Sequence__Group_10__37683);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3505:1: rule__Sequence__Group_10__3__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_10__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3509:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3510:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3510:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3511:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_10_3()); 
            match(input,170,FOLLOW_170_in_rule__Sequence__Group_10__3__Impl7711); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3532:1: rule__Sequence__Group_11__0 : rule__Sequence__Group_11__0__Impl rule__Sequence__Group_11__1 ;
    public final void rule__Sequence__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3536:1: ( rule__Sequence__Group_11__0__Impl rule__Sequence__Group_11__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3537:2: rule__Sequence__Group_11__0__Impl rule__Sequence__Group_11__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__0__Impl_in_rule__Sequence__Group_11__07750);
            rule__Sequence__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_11__1_in_rule__Sequence__Group_11__07753);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3544:1: rule__Sequence__Group_11__0__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3548:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3549:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3549:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3550:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_11_0()); 
            match(input,170,FOLLOW_170_in_rule__Sequence__Group_11__0__Impl7781); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3563:1: rule__Sequence__Group_11__1 : rule__Sequence__Group_11__1__Impl rule__Sequence__Group_11__2 ;
    public final void rule__Sequence__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3567:1: ( rule__Sequence__Group_11__1__Impl rule__Sequence__Group_11__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3568:2: rule__Sequence__Group_11__1__Impl rule__Sequence__Group_11__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__1__Impl_in_rule__Sequence__Group_11__17812);
            rule__Sequence__Group_11__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_11__2_in_rule__Sequence__Group_11__17815);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3575:1: rule__Sequence__Group_11__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3579:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3580:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3580:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3581:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_11_1()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_11__1__Impl7843); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3594:1: rule__Sequence__Group_11__2 : rule__Sequence__Group_11__2__Impl rule__Sequence__Group_11__3 ;
    public final void rule__Sequence__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3598:1: ( rule__Sequence__Group_11__2__Impl rule__Sequence__Group_11__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3599:2: rule__Sequence__Group_11__2__Impl rule__Sequence__Group_11__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__2__Impl_in_rule__Sequence__Group_11__27874);
            rule__Sequence__Group_11__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_11__3_in_rule__Sequence__Group_11__27877);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3606:1: rule__Sequence__Group_11__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3610:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3611:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3611:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3612:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_11_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_11__2__Impl7905); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3625:1: rule__Sequence__Group_11__3 : rule__Sequence__Group_11__3__Impl ;
    public final void rule__Sequence__Group_11__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3629:1: ( rule__Sequence__Group_11__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3630:2: rule__Sequence__Group_11__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__3__Impl_in_rule__Sequence__Group_11__37936);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3636:1: rule__Sequence__Group_11__3__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_11__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3640:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3641:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3641:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3642:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_11_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3643:1: ( '-' )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==163) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3644:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_11__3__Impl7965); 

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3663:1: rule__Sequence__Group_12__0 : rule__Sequence__Group_12__0__Impl rule__Sequence__Group_12__1 ;
    public final void rule__Sequence__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3667:1: ( rule__Sequence__Group_12__0__Impl rule__Sequence__Group_12__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3668:2: rule__Sequence__Group_12__0__Impl rule__Sequence__Group_12__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__0__Impl_in_rule__Sequence__Group_12__08006);
            rule__Sequence__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__1_in_rule__Sequence__Group_12__08009);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3675:1: rule__Sequence__Group_12__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3679:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3680:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3680:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3681:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3682:1: ( '-' )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==163) ) {
                    int LA22_1 = input.LA(2);

                    if ( (LA22_1==163) ) {
                        int LA22_2 = input.LA(3);

                        if ( (LA22_2==163) ) {
                            alt22=1;
                        }


                    }


                }


                switch (alt22) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3683:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_12__0__Impl8038); 

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3694:1: rule__Sequence__Group_12__1 : rule__Sequence__Group_12__1__Impl rule__Sequence__Group_12__2 ;
    public final void rule__Sequence__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3698:1: ( rule__Sequence__Group_12__1__Impl rule__Sequence__Group_12__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3699:2: rule__Sequence__Group_12__1__Impl rule__Sequence__Group_12__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__1__Impl_in_rule__Sequence__Group_12__18071);
            rule__Sequence__Group_12__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__2_in_rule__Sequence__Group_12__18074);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3706:1: rule__Sequence__Group_12__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3710:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3711:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3711:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3712:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_12__1__Impl8102); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3725:1: rule__Sequence__Group_12__2 : rule__Sequence__Group_12__2__Impl rule__Sequence__Group_12__3 ;
    public final void rule__Sequence__Group_12__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3729:1: ( rule__Sequence__Group_12__2__Impl rule__Sequence__Group_12__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3730:2: rule__Sequence__Group_12__2__Impl rule__Sequence__Group_12__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__2__Impl_in_rule__Sequence__Group_12__28133);
            rule__Sequence__Group_12__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__3_in_rule__Sequence__Group_12__28136);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3737:1: rule__Sequence__Group_12__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_12__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3741:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3742:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3742:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3743:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_12__2__Impl8164); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3756:1: rule__Sequence__Group_12__3 : rule__Sequence__Group_12__3__Impl rule__Sequence__Group_12__4 ;
    public final void rule__Sequence__Group_12__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3760:1: ( rule__Sequence__Group_12__3__Impl rule__Sequence__Group_12__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3761:2: rule__Sequence__Group_12__3__Impl rule__Sequence__Group_12__4
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__3__Impl_in_rule__Sequence__Group_12__38195);
            rule__Sequence__Group_12__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__4_in_rule__Sequence__Group_12__38198);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3768:1: rule__Sequence__Group_12__3__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_12__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3772:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3773:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3773:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3774:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_12_3()); 
            match(input,168,FOLLOW_168_in_rule__Sequence__Group_12__3__Impl8226); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3787:1: rule__Sequence__Group_12__4 : rule__Sequence__Group_12__4__Impl rule__Sequence__Group_12__5 ;
    public final void rule__Sequence__Group_12__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3791:1: ( rule__Sequence__Group_12__4__Impl rule__Sequence__Group_12__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3792:2: rule__Sequence__Group_12__4__Impl rule__Sequence__Group_12__5
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__4__Impl_in_rule__Sequence__Group_12__48257);
            rule__Sequence__Group_12__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__5_in_rule__Sequence__Group_12__48260);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3799:1: rule__Sequence__Group_12__4__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_12__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3803:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3804:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3804:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3805:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_12_4()); 
            match(input,168,FOLLOW_168_in_rule__Sequence__Group_12__4__Impl8288); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3818:1: rule__Sequence__Group_12__5 : rule__Sequence__Group_12__5__Impl ;
    public final void rule__Sequence__Group_12__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3822:1: ( rule__Sequence__Group_12__5__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3823:2: rule__Sequence__Group_12__5__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__5__Impl_in_rule__Sequence__Group_12__58319);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3829:1: rule__Sequence__Group_12__5__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_12__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3833:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3834:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3834:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3835:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_12_5()); 
            match(input,170,FOLLOW_170_in_rule__Sequence__Group_12__5__Impl8347); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3860:1: rule__Sequence__Group_13__0 : rule__Sequence__Group_13__0__Impl rule__Sequence__Group_13__1 ;
    public final void rule__Sequence__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3864:1: ( rule__Sequence__Group_13__0__Impl rule__Sequence__Group_13__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3865:2: rule__Sequence__Group_13__0__Impl rule__Sequence__Group_13__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__0__Impl_in_rule__Sequence__Group_13__08390);
            rule__Sequence__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__1_in_rule__Sequence__Group_13__08393);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3872:1: rule__Sequence__Group_13__0__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3876:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3877:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3877:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3878:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_13_0()); 
            match(input,170,FOLLOW_170_in_rule__Sequence__Group_13__0__Impl8421); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3891:1: rule__Sequence__Group_13__1 : rule__Sequence__Group_13__1__Impl rule__Sequence__Group_13__2 ;
    public final void rule__Sequence__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3895:1: ( rule__Sequence__Group_13__1__Impl rule__Sequence__Group_13__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3896:2: rule__Sequence__Group_13__1__Impl rule__Sequence__Group_13__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__1__Impl_in_rule__Sequence__Group_13__18452);
            rule__Sequence__Group_13__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__2_in_rule__Sequence__Group_13__18455);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3903:1: rule__Sequence__Group_13__1__Impl : ( '\\\\\\\\' ) ;
    public final void rule__Sequence__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3907:1: ( ( '\\\\\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3908:1: ( '\\\\\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3908:1: ( '\\\\\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3909:1: '\\\\\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusReverseSolidusKeyword_13_1()); 
            match(input,169,FOLLOW_169_in_rule__Sequence__Group_13__1__Impl8483); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3922:1: rule__Sequence__Group_13__2 : rule__Sequence__Group_13__2__Impl rule__Sequence__Group_13__3 ;
    public final void rule__Sequence__Group_13__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3926:1: ( rule__Sequence__Group_13__2__Impl rule__Sequence__Group_13__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3927:2: rule__Sequence__Group_13__2__Impl rule__Sequence__Group_13__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__2__Impl_in_rule__Sequence__Group_13__28514);
            rule__Sequence__Group_13__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__3_in_rule__Sequence__Group_13__28517);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3934:1: rule__Sequence__Group_13__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_13__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3938:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3939:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3939:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3940:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_13__2__Impl8545); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3953:1: rule__Sequence__Group_13__3 : rule__Sequence__Group_13__3__Impl rule__Sequence__Group_13__4 ;
    public final void rule__Sequence__Group_13__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3957:1: ( rule__Sequence__Group_13__3__Impl rule__Sequence__Group_13__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3958:2: rule__Sequence__Group_13__3__Impl rule__Sequence__Group_13__4
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__3__Impl_in_rule__Sequence__Group_13__38576);
            rule__Sequence__Group_13__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__4_in_rule__Sequence__Group_13__38579);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3965:1: rule__Sequence__Group_13__3__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_13__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3969:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3970:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3970:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3971:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_3()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_13__3__Impl8607); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3984:1: rule__Sequence__Group_13__4 : rule__Sequence__Group_13__4__Impl ;
    public final void rule__Sequence__Group_13__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3988:1: ( rule__Sequence__Group_13__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3989:2: rule__Sequence__Group_13__4__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__4__Impl_in_rule__Sequence__Group_13__48638);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3995:1: rule__Sequence__Group_13__4__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_13__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3999:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4000:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4000:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4001:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4002:1: ( '-' )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==163) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4003:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_13__4__Impl8667); 

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4024:1: rule__Sequence__Group_14__0 : rule__Sequence__Group_14__0__Impl rule__Sequence__Group_14__1 ;
    public final void rule__Sequence__Group_14__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4028:1: ( rule__Sequence__Group_14__0__Impl rule__Sequence__Group_14__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4029:2: rule__Sequence__Group_14__0__Impl rule__Sequence__Group_14__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_14__0__Impl_in_rule__Sequence__Group_14__08710);
            rule__Sequence__Group_14__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_14__1_in_rule__Sequence__Group_14__08713);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4036:1: rule__Sequence__Group_14__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_14__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4040:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4041:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4041:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4042:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_14_0()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_14__0__Impl8741); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4055:1: rule__Sequence__Group_14__1 : rule__Sequence__Group_14__1__Impl rule__Sequence__Group_14__2 ;
    public final void rule__Sequence__Group_14__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4059:1: ( rule__Sequence__Group_14__1__Impl rule__Sequence__Group_14__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4060:2: rule__Sequence__Group_14__1__Impl rule__Sequence__Group_14__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_14__1__Impl_in_rule__Sequence__Group_14__18772);
            rule__Sequence__Group_14__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_14__2_in_rule__Sequence__Group_14__18775);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4067:1: rule__Sequence__Group_14__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_14__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4071:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4072:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4072:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4073:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_14_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_14__1__Impl8803); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4086:1: rule__Sequence__Group_14__2 : rule__Sequence__Group_14__2__Impl ;
    public final void rule__Sequence__Group_14__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4090:1: ( rule__Sequence__Group_14__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4091:2: rule__Sequence__Group_14__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_14__2__Impl_in_rule__Sequence__Group_14__28834);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4097:1: rule__Sequence__Group_14__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_14__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4101:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4102:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4102:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4103:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_14_2()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_14__2__Impl8862); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4122:1: rule__Sequence__Group_15__0 : rule__Sequence__Group_15__0__Impl rule__Sequence__Group_15__1 ;
    public final void rule__Sequence__Group_15__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4126:1: ( rule__Sequence__Group_15__0__Impl rule__Sequence__Group_15__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4127:2: rule__Sequence__Group_15__0__Impl rule__Sequence__Group_15__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__0__Impl_in_rule__Sequence__Group_15__08899);
            rule__Sequence__Group_15__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_15__1_in_rule__Sequence__Group_15__08902);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4134:1: rule__Sequence__Group_15__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_15__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4138:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4139:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4139:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4140:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_15_0()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_15__0__Impl8930); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4153:1: rule__Sequence__Group_15__1 : rule__Sequence__Group_15__1__Impl rule__Sequence__Group_15__2 ;
    public final void rule__Sequence__Group_15__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4157:1: ( rule__Sequence__Group_15__1__Impl rule__Sequence__Group_15__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4158:2: rule__Sequence__Group_15__1__Impl rule__Sequence__Group_15__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__1__Impl_in_rule__Sequence__Group_15__18961);
            rule__Sequence__Group_15__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_15__2_in_rule__Sequence__Group_15__18964);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4165:1: rule__Sequence__Group_15__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_15__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4169:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4170:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4170:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4171:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_15_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_15__1__Impl8992); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4184:1: rule__Sequence__Group_15__2 : rule__Sequence__Group_15__2__Impl rule__Sequence__Group_15__3 ;
    public final void rule__Sequence__Group_15__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4188:1: ( rule__Sequence__Group_15__2__Impl rule__Sequence__Group_15__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4189:2: rule__Sequence__Group_15__2__Impl rule__Sequence__Group_15__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__2__Impl_in_rule__Sequence__Group_15__29023);
            rule__Sequence__Group_15__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_15__3_in_rule__Sequence__Group_15__29026);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4196:1: rule__Sequence__Group_15__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_15__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4200:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4201:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4201:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4202:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_15_2()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_15__2__Impl9054); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4215:1: rule__Sequence__Group_15__3 : rule__Sequence__Group_15__3__Impl ;
    public final void rule__Sequence__Group_15__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4219:1: ( rule__Sequence__Group_15__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4220:2: rule__Sequence__Group_15__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__3__Impl_in_rule__Sequence__Group_15__39085);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4226:1: rule__Sequence__Group_15__3__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_15__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4230:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4231:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4231:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4232:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_15_3()); 
            match(input,170,FOLLOW_170_in_rule__Sequence__Group_15__3__Impl9113); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4253:1: rule__Sequence__Group_16__0 : rule__Sequence__Group_16__0__Impl rule__Sequence__Group_16__1 ;
    public final void rule__Sequence__Group_16__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4257:1: ( rule__Sequence__Group_16__0__Impl rule__Sequence__Group_16__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4258:2: rule__Sequence__Group_16__0__Impl rule__Sequence__Group_16__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__0__Impl_in_rule__Sequence__Group_16__09152);
            rule__Sequence__Group_16__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_16__1_in_rule__Sequence__Group_16__09155);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4265:1: rule__Sequence__Group_16__0__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_16__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4269:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4270:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4270:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4271:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_16_0()); 
            match(input,170,FOLLOW_170_in_rule__Sequence__Group_16__0__Impl9183); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4284:1: rule__Sequence__Group_16__1 : rule__Sequence__Group_16__1__Impl rule__Sequence__Group_16__2 ;
    public final void rule__Sequence__Group_16__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4288:1: ( rule__Sequence__Group_16__1__Impl rule__Sequence__Group_16__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4289:2: rule__Sequence__Group_16__1__Impl rule__Sequence__Group_16__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__1__Impl_in_rule__Sequence__Group_16__19214);
            rule__Sequence__Group_16__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_16__2_in_rule__Sequence__Group_16__19217);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4296:1: rule__Sequence__Group_16__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_16__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4300:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4301:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4301:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4302:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_16_1()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_16__1__Impl9245); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4315:1: rule__Sequence__Group_16__2 : rule__Sequence__Group_16__2__Impl rule__Sequence__Group_16__3 ;
    public final void rule__Sequence__Group_16__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4319:1: ( rule__Sequence__Group_16__2__Impl rule__Sequence__Group_16__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4320:2: rule__Sequence__Group_16__2__Impl rule__Sequence__Group_16__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__2__Impl_in_rule__Sequence__Group_16__29276);
            rule__Sequence__Group_16__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_16__3_in_rule__Sequence__Group_16__29279);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4327:1: rule__Sequence__Group_16__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_16__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4331:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4332:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4332:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4333:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_16_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_16__2__Impl9307); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4346:1: rule__Sequence__Group_16__3 : rule__Sequence__Group_16__3__Impl ;
    public final void rule__Sequence__Group_16__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4350:1: ( rule__Sequence__Group_16__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4351:2: rule__Sequence__Group_16__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__3__Impl_in_rule__Sequence__Group_16__39338);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4357:1: rule__Sequence__Group_16__3__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_16__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4361:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4362:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4362:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4363:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_16_3()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_16__3__Impl9366); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4384:1: rule__Sequence__Group_17__0 : rule__Sequence__Group_17__0__Impl rule__Sequence__Group_17__1 ;
    public final void rule__Sequence__Group_17__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4388:1: ( rule__Sequence__Group_17__0__Impl rule__Sequence__Group_17__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4389:2: rule__Sequence__Group_17__0__Impl rule__Sequence__Group_17__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__0__Impl_in_rule__Sequence__Group_17__09405);
            rule__Sequence__Group_17__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_17__1_in_rule__Sequence__Group_17__09408);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4396:1: rule__Sequence__Group_17__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_17__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4400:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4401:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4401:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4402:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_17_0()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_17__0__Impl9436); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4415:1: rule__Sequence__Group_17__1 : rule__Sequence__Group_17__1__Impl rule__Sequence__Group_17__2 ;
    public final void rule__Sequence__Group_17__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4419:1: ( rule__Sequence__Group_17__1__Impl rule__Sequence__Group_17__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4420:2: rule__Sequence__Group_17__1__Impl rule__Sequence__Group_17__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__1__Impl_in_rule__Sequence__Group_17__19467);
            rule__Sequence__Group_17__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_17__2_in_rule__Sequence__Group_17__19470);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4427:1: rule__Sequence__Group_17__1__Impl : ( '|' ) ;
    public final void rule__Sequence__Group_17__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4431:1: ( ( '|' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4432:1: ( '|' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4432:1: ( '|' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4433:1: '|'
            {
             before(grammarAccess.getSequenceAccess().getVerticalLineKeyword_17_1()); 
            match(input,171,FOLLOW_171_in_rule__Sequence__Group_17__1__Impl9498); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4446:1: rule__Sequence__Group_17__2 : rule__Sequence__Group_17__2__Impl rule__Sequence__Group_17__3 ;
    public final void rule__Sequence__Group_17__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4450:1: ( rule__Sequence__Group_17__2__Impl rule__Sequence__Group_17__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4451:2: rule__Sequence__Group_17__2__Impl rule__Sequence__Group_17__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__2__Impl_in_rule__Sequence__Group_17__29529);
            rule__Sequence__Group_17__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_17__3_in_rule__Sequence__Group_17__29532);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4458:1: rule__Sequence__Group_17__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_17__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4462:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4463:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4463:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4464:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_17_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_17__2__Impl9560); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4477:1: rule__Sequence__Group_17__3 : rule__Sequence__Group_17__3__Impl ;
    public final void rule__Sequence__Group_17__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4481:1: ( rule__Sequence__Group_17__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4482:2: rule__Sequence__Group_17__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__3__Impl_in_rule__Sequence__Group_17__39591);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4488:1: rule__Sequence__Group_17__3__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_17__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4492:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4493:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4493:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4494:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_17_3()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_17__3__Impl9619); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4515:1: rule__Sequence__Group_18__0 : rule__Sequence__Group_18__0__Impl rule__Sequence__Group_18__1 ;
    public final void rule__Sequence__Group_18__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4519:1: ( rule__Sequence__Group_18__0__Impl rule__Sequence__Group_18__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4520:2: rule__Sequence__Group_18__0__Impl rule__Sequence__Group_18__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__0__Impl_in_rule__Sequence__Group_18__09658);
            rule__Sequence__Group_18__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_18__1_in_rule__Sequence__Group_18__09661);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4527:1: rule__Sequence__Group_18__0__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_18__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4531:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4532:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4532:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4533:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_18_0()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_18__0__Impl9689); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4546:1: rule__Sequence__Group_18__1 : rule__Sequence__Group_18__1__Impl rule__Sequence__Group_18__2 ;
    public final void rule__Sequence__Group_18__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4550:1: ( rule__Sequence__Group_18__1__Impl rule__Sequence__Group_18__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4551:2: rule__Sequence__Group_18__1__Impl rule__Sequence__Group_18__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__1__Impl_in_rule__Sequence__Group_18__19720);
            rule__Sequence__Group_18__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_18__2_in_rule__Sequence__Group_18__19723);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4558:1: rule__Sequence__Group_18__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_18__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4562:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4563:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4563:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4564:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_18_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_18__1__Impl9751); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4577:1: rule__Sequence__Group_18__2 : rule__Sequence__Group_18__2__Impl rule__Sequence__Group_18__3 ;
    public final void rule__Sequence__Group_18__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4581:1: ( rule__Sequence__Group_18__2__Impl rule__Sequence__Group_18__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4582:2: rule__Sequence__Group_18__2__Impl rule__Sequence__Group_18__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__2__Impl_in_rule__Sequence__Group_18__29782);
            rule__Sequence__Group_18__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_18__3_in_rule__Sequence__Group_18__29785);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4589:1: rule__Sequence__Group_18__2__Impl : ( '|' ) ;
    public final void rule__Sequence__Group_18__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4593:1: ( ( '|' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4594:1: ( '|' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4594:1: ( '|' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4595:1: '|'
            {
             before(grammarAccess.getSequenceAccess().getVerticalLineKeyword_18_2()); 
            match(input,171,FOLLOW_171_in_rule__Sequence__Group_18__2__Impl9813); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4608:1: rule__Sequence__Group_18__3 : rule__Sequence__Group_18__3__Impl ;
    public final void rule__Sequence__Group_18__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4612:1: ( rule__Sequence__Group_18__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4613:2: rule__Sequence__Group_18__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__3__Impl_in_rule__Sequence__Group_18__39844);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4619:1: rule__Sequence__Group_18__3__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_18__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4623:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4624:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4624:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4625:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_18_3()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_18__3__Impl9872); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4646:1: rule__Sequence__Group_19__0 : rule__Sequence__Group_19__0__Impl rule__Sequence__Group_19__1 ;
    public final void rule__Sequence__Group_19__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4650:1: ( rule__Sequence__Group_19__0__Impl rule__Sequence__Group_19__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4651:2: rule__Sequence__Group_19__0__Impl rule__Sequence__Group_19__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_19__0__Impl_in_rule__Sequence__Group_19__09911);
            rule__Sequence__Group_19__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_19__1_in_rule__Sequence__Group_19__09914);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4658:1: rule__Sequence__Group_19__0__Impl : ( '.' ) ;
    public final void rule__Sequence__Group_19__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4662:1: ( ( '.' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4663:1: ( '.' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4663:1: ( '.' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4664:1: '.'
            {
             before(grammarAccess.getSequenceAccess().getFullStopKeyword_19_0()); 
            match(input,11,FOLLOW_11_in_rule__Sequence__Group_19__0__Impl9942); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4677:1: rule__Sequence__Group_19__1 : rule__Sequence__Group_19__1__Impl ;
    public final void rule__Sequence__Group_19__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4681:1: ( rule__Sequence__Group_19__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4682:2: rule__Sequence__Group_19__1__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_19__1__Impl_in_rule__Sequence__Group_19__19973);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4688:1: rule__Sequence__Group_19__1__Impl : ( '.' ) ;
    public final void rule__Sequence__Group_19__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4692:1: ( ( '.' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4693:1: ( '.' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4693:1: ( '.' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4694:1: '.'
            {
             before(grammarAccess.getSequenceAccess().getFullStopKeyword_19_1()); 
            match(input,11,FOLLOW_11_in_rule__Sequence__Group_19__1__Impl10001); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4711:1: rule__Definition__Group_0__0 : rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 ;
    public final void rule__Definition__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4715:1: ( rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4716:2: rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__010036);
            rule__Definition__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__010039);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4723:1: rule__Definition__Group_0__0__Impl : ( 'actor' ) ;
    public final void rule__Definition__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4727:1: ( ( 'actor' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4728:1: ( 'actor' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4728:1: ( 'actor' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4729:1: 'actor'
            {
             before(grammarAccess.getDefinitionAccess().getActorKeyword_0_0()); 
            match(input,172,FOLLOW_172_in_rule__Definition__Group_0__0__Impl10067); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4742:1: rule__Definition__Group_0__1 : rule__Definition__Group_0__1__Impl ;
    public final void rule__Definition__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4746:1: ( rule__Definition__Group_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4747:2: rule__Definition__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__110098);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4753:1: rule__Definition__Group_0__1__Impl : ( ( rule__Definition__NameAssignment_0_1 ) ) ;
    public final void rule__Definition__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4757:1: ( ( ( rule__Definition__NameAssignment_0_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4758:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4758:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4759:1: ( rule__Definition__NameAssignment_0_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4760:1: ( rule__Definition__NameAssignment_0_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4760:2: rule__Definition__NameAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl10125);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4774:1: rule__Definition__Group_1__0 : rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 ;
    public final void rule__Definition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4778:1: ( rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4779:2: rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__010159);
            rule__Definition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__010162);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4786:1: rule__Definition__Group_1__0__Impl : ( 'boundary' ) ;
    public final void rule__Definition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4790:1: ( ( 'boundary' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4791:1: ( 'boundary' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4791:1: ( 'boundary' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4792:1: 'boundary'
            {
             before(grammarAccess.getDefinitionAccess().getBoundaryKeyword_1_0()); 
            match(input,173,FOLLOW_173_in_rule__Definition__Group_1__0__Impl10190); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4805:1: rule__Definition__Group_1__1 : rule__Definition__Group_1__1__Impl ;
    public final void rule__Definition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4809:1: ( rule__Definition__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4810:2: rule__Definition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__110221);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4816:1: rule__Definition__Group_1__1__Impl : ( ( rule__Definition__NameAssignment_1_1 ) ) ;
    public final void rule__Definition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4820:1: ( ( ( rule__Definition__NameAssignment_1_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4821:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4821:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4822:1: ( rule__Definition__NameAssignment_1_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4823:1: ( rule__Definition__NameAssignment_1_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4823:2: rule__Definition__NameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl10248);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4837:1: rule__Definition__Group_2__0 : rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 ;
    public final void rule__Definition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4841:1: ( rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4842:2: rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__010282);
            rule__Definition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__010285);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4849:1: rule__Definition__Group_2__0__Impl : ( 'control' ) ;
    public final void rule__Definition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4853:1: ( ( 'control' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4854:1: ( 'control' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4854:1: ( 'control' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4855:1: 'control'
            {
             before(grammarAccess.getDefinitionAccess().getControlKeyword_2_0()); 
            match(input,174,FOLLOW_174_in_rule__Definition__Group_2__0__Impl10313); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4868:1: rule__Definition__Group_2__1 : rule__Definition__Group_2__1__Impl ;
    public final void rule__Definition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4872:1: ( rule__Definition__Group_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4873:2: rule__Definition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__110344);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4879:1: rule__Definition__Group_2__1__Impl : ( ( rule__Definition__NameAssignment_2_1 ) ) ;
    public final void rule__Definition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4883:1: ( ( ( rule__Definition__NameAssignment_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4884:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4884:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4885:1: ( rule__Definition__NameAssignment_2_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4886:1: ( rule__Definition__NameAssignment_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4886:2: rule__Definition__NameAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl10371);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4900:1: rule__Definition__Group_3__0 : rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 ;
    public final void rule__Definition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4904:1: ( rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4905:2: rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__010405);
            rule__Definition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__010408);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4912:1: rule__Definition__Group_3__0__Impl : ( 'entity' ) ;
    public final void rule__Definition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4916:1: ( ( 'entity' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4917:1: ( 'entity' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4917:1: ( 'entity' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4918:1: 'entity'
            {
             before(grammarAccess.getDefinitionAccess().getEntityKeyword_3_0()); 
            match(input,175,FOLLOW_175_in_rule__Definition__Group_3__0__Impl10436); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4931:1: rule__Definition__Group_3__1 : rule__Definition__Group_3__1__Impl ;
    public final void rule__Definition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4935:1: ( rule__Definition__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4936:2: rule__Definition__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__110467);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4942:1: rule__Definition__Group_3__1__Impl : ( ( rule__Definition__NameAssignment_3_1 ) ) ;
    public final void rule__Definition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4946:1: ( ( ( rule__Definition__NameAssignment_3_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4947:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4947:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4948:1: ( rule__Definition__NameAssignment_3_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4949:1: ( rule__Definition__NameAssignment_3_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4949:2: rule__Definition__NameAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl10494);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4963:1: rule__Definition__Group_4__0 : rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 ;
    public final void rule__Definition__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4967:1: ( rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4968:2: rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__010528);
            rule__Definition__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__010531);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4975:1: rule__Definition__Group_4__0__Impl : ( 'database' ) ;
    public final void rule__Definition__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4979:1: ( ( 'database' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4980:1: ( 'database' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4980:1: ( 'database' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4981:1: 'database'
            {
             before(grammarAccess.getDefinitionAccess().getDatabaseKeyword_4_0()); 
            match(input,176,FOLLOW_176_in_rule__Definition__Group_4__0__Impl10559); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4994:1: rule__Definition__Group_4__1 : rule__Definition__Group_4__1__Impl ;
    public final void rule__Definition__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4998:1: ( rule__Definition__Group_4__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4999:2: rule__Definition__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__110590);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5005:1: rule__Definition__Group_4__1__Impl : ( ( rule__Definition__NameAssignment_4_1 ) ) ;
    public final void rule__Definition__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5009:1: ( ( ( rule__Definition__NameAssignment_4_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5010:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5010:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5011:1: ( rule__Definition__NameAssignment_4_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_4_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5012:1: ( rule__Definition__NameAssignment_4_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5012:2: rule__Definition__NameAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl10617);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5026:1: rule__AutoNumber__Group__0 : rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1 ;
    public final void rule__AutoNumber__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5030:1: ( rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5031:2: rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__0__Impl_in_rule__AutoNumber__Group__010651);
            rule__AutoNumber__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AutoNumber__Group__1_in_rule__AutoNumber__Group__010654);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5038:1: rule__AutoNumber__Group__0__Impl : ( 'autonumber' ) ;
    public final void rule__AutoNumber__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5042:1: ( ( 'autonumber' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5043:1: ( 'autonumber' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5043:1: ( 'autonumber' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5044:1: 'autonumber'
            {
             before(grammarAccess.getAutoNumberAccess().getAutonumberKeyword_0()); 
            match(input,177,FOLLOW_177_in_rule__AutoNumber__Group__0__Impl10682); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5057:1: rule__AutoNumber__Group__1 : rule__AutoNumber__Group__1__Impl ;
    public final void rule__AutoNumber__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5061:1: ( rule__AutoNumber__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5062:2: rule__AutoNumber__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__1__Impl_in_rule__AutoNumber__Group__110713);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5068:1: rule__AutoNumber__Group__1__Impl : ( ( rule__AutoNumber__Group_1__0 )? ) ;
    public final void rule__AutoNumber__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5072:1: ( ( ( rule__AutoNumber__Group_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5073:1: ( ( rule__AutoNumber__Group_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5073:1: ( ( rule__AutoNumber__Group_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5074:1: ( rule__AutoNumber__Group_1__0 )?
            {
             before(grammarAccess.getAutoNumberAccess().getGroup_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5075:1: ( rule__AutoNumber__Group_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_INT) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5075:2: rule__AutoNumber__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__AutoNumber__Group_1__0_in_rule__AutoNumber__Group__1__Impl10740);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5089:1: rule__AutoNumber__Group_1__0 : rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1 ;
    public final void rule__AutoNumber__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5093:1: ( rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5094:2: rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group_1__0__Impl_in_rule__AutoNumber__Group_1__010775);
            rule__AutoNumber__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AutoNumber__Group_1__1_in_rule__AutoNumber__Group_1__010778);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5101:1: rule__AutoNumber__Group_1__0__Impl : ( RULE_INT ) ;
    public final void rule__AutoNumber__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5105:1: ( ( RULE_INT ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5106:1: ( RULE_INT )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5106:1: ( RULE_INT )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5107:1: RULE_INT
            {
             before(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__0__Impl10805); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5118:1: rule__AutoNumber__Group_1__1 : rule__AutoNumber__Group_1__1__Impl ;
    public final void rule__AutoNumber__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5122:1: ( rule__AutoNumber__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5123:2: rule__AutoNumber__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group_1__1__Impl_in_rule__AutoNumber__Group_1__110834);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5129:1: rule__AutoNumber__Group_1__1__Impl : ( ( RULE_INT )? ) ;
    public final void rule__AutoNumber__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5133:1: ( ( ( RULE_INT )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5134:1: ( ( RULE_INT )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5134:1: ( ( RULE_INT )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5135:1: ( RULE_INT )?
            {
             before(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5136:1: ( RULE_INT )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_INT) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5136:3: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__1__Impl10862); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5150:1: rule__Color__Group__0 : rule__Color__Group__0__Impl rule__Color__Group__1 ;
    public final void rule__Color__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5154:1: ( rule__Color__Group__0__Impl rule__Color__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5155:2: rule__Color__Group__0__Impl rule__Color__Group__1
            {
            pushFollow(FOLLOW_rule__Color__Group__0__Impl_in_rule__Color__Group__010897);
            rule__Color__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Color__Group__1_in_rule__Color__Group__010900);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5162:1: rule__Color__Group__0__Impl : ( ( ( '#' ) ) ( ( '#' )* ) ) ;
    public final void rule__Color__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5166:1: ( ( ( ( '#' ) ) ( ( '#' )* ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5167:1: ( ( ( '#' ) ) ( ( '#' )* ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5167:1: ( ( ( '#' ) ) ( ( '#' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5168:1: ( ( '#' ) ) ( ( '#' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5168:1: ( ( '#' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5169:1: ( '#' )
            {
             before(grammarAccess.getColorAccess().getNumberSignKeyword_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5170:1: ( '#' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5171:2: '#'
            {
            match(input,178,FOLLOW_178_in_rule__Color__Group__0__Impl10931); 

            }

             after(grammarAccess.getColorAccess().getNumberSignKeyword_0()); 

            }

            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5175:1: ( ( '#' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5176:1: ( '#' )*
            {
             before(grammarAccess.getColorAccess().getNumberSignKeyword_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5177:1: ( '#' )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==178) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5178:2: '#'
            	    {
            	    match(input,178,FOLLOW_178_in_rule__Color__Group__0__Impl10947); 

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5190:1: rule__Color__Group__1 : rule__Color__Group__1__Impl ;
    public final void rule__Color__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5194:1: ( rule__Color__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5195:2: rule__Color__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Color__Group__1__Impl_in_rule__Color__Group__110982);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5201:1: rule__Color__Group__1__Impl : ( ( rule__Color__Alternatives_1 ) ) ;
    public final void rule__Color__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5205:1: ( ( ( rule__Color__Alternatives_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5206:1: ( ( rule__Color__Alternatives_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5206:1: ( ( rule__Color__Alternatives_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5207:1: ( rule__Color__Alternatives_1 )
            {
             before(grammarAccess.getColorAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5208:1: ( rule__Color__Alternatives_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5208:2: rule__Color__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Color__Alternatives_1_in_rule__Color__Group__1__Impl11009);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5222:1: rule__Title__Group__0 : rule__Title__Group__0__Impl rule__Title__Group__1 ;
    public final void rule__Title__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5226:1: ( rule__Title__Group__0__Impl rule__Title__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5227:2: rule__Title__Group__0__Impl rule__Title__Group__1
            {
            pushFollow(FOLLOW_rule__Title__Group__0__Impl_in_rule__Title__Group__011043);
            rule__Title__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Title__Group__1_in_rule__Title__Group__011046);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5234:1: rule__Title__Group__0__Impl : ( 'title' ) ;
    public final void rule__Title__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5238:1: ( ( 'title' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5239:1: ( 'title' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5239:1: ( 'title' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5240:1: 'title'
            {
             before(grammarAccess.getTitleAccess().getTitleKeyword_0()); 
            match(input,179,FOLLOW_179_in_rule__Title__Group__0__Impl11074); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5253:1: rule__Title__Group__1 : rule__Title__Group__1__Impl ;
    public final void rule__Title__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5257:1: ( rule__Title__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5258:2: rule__Title__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Title__Group__1__Impl_in_rule__Title__Group__111105);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5264:1: rule__Title__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__Title__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5268:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5269:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5269:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5270:1: RULE_ID
            {
             before(grammarAccess.getTitleAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Title__Group__1__Impl11132); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5285:1: rule__Legend__Group__0 : rule__Legend__Group__0__Impl rule__Legend__Group__1 ;
    public final void rule__Legend__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5289:1: ( rule__Legend__Group__0__Impl rule__Legend__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5290:2: rule__Legend__Group__0__Impl rule__Legend__Group__1
            {
            pushFollow(FOLLOW_rule__Legend__Group__0__Impl_in_rule__Legend__Group__011165);
            rule__Legend__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__1_in_rule__Legend__Group__011168);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5297:1: rule__Legend__Group__0__Impl : ( 'legend' ) ;
    public final void rule__Legend__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5301:1: ( ( 'legend' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5302:1: ( 'legend' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5302:1: ( 'legend' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5303:1: 'legend'
            {
             before(grammarAccess.getLegendAccess().getLegendKeyword_0()); 
            match(input,180,FOLLOW_180_in_rule__Legend__Group__0__Impl11196); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5316:1: rule__Legend__Group__1 : rule__Legend__Group__1__Impl rule__Legend__Group__2 ;
    public final void rule__Legend__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5320:1: ( rule__Legend__Group__1__Impl rule__Legend__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5321:2: rule__Legend__Group__1__Impl rule__Legend__Group__2
            {
            pushFollow(FOLLOW_rule__Legend__Group__1__Impl_in_rule__Legend__Group__111227);
            rule__Legend__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__2_in_rule__Legend__Group__111230);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5328:1: rule__Legend__Group__1__Impl : ( ( rule__Legend__Alternatives_1 )? ) ;
    public final void rule__Legend__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5332:1: ( ( ( rule__Legend__Alternatives_1 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5333:1: ( ( rule__Legend__Alternatives_1 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5333:1: ( ( rule__Legend__Alternatives_1 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5334:1: ( rule__Legend__Alternatives_1 )?
            {
             before(grammarAccess.getLegendAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5335:1: ( rule__Legend__Alternatives_1 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=157 && LA27_0<=159)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5335:2: rule__Legend__Alternatives_1
                    {
                    pushFollow(FOLLOW_rule__Legend__Alternatives_1_in_rule__Legend__Group__1__Impl11257);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5345:1: rule__Legend__Group__2 : rule__Legend__Group__2__Impl rule__Legend__Group__3 ;
    public final void rule__Legend__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5349:1: ( rule__Legend__Group__2__Impl rule__Legend__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5350:2: rule__Legend__Group__2__Impl rule__Legend__Group__3
            {
            pushFollow(FOLLOW_rule__Legend__Group__2__Impl_in_rule__Legend__Group__211288);
            rule__Legend__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__3_in_rule__Legend__Group__211291);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5357:1: rule__Legend__Group__2__Impl : ( ( rule__Legend__Alternatives_2 )* ) ;
    public final void rule__Legend__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5361:1: ( ( ( rule__Legend__Alternatives_2 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5362:1: ( ( rule__Legend__Alternatives_2 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5362:1: ( ( rule__Legend__Alternatives_2 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5363:1: ( rule__Legend__Alternatives_2 )*
            {
             before(grammarAccess.getLegendAccess().getAlternatives_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5364:1: ( rule__Legend__Alternatives_2 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_NEWLINE) ) {
                    int LA28_1 = input.LA(2);

                    if ( ((LA28_1>=RULE_NEWLINE && LA28_1<=RULE_ID)) ) {
                        alt28=1;
                    }


                }


                switch (alt28) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5364:2: rule__Legend__Alternatives_2
            	    {
            	    pushFollow(FOLLOW_rule__Legend__Alternatives_2_in_rule__Legend__Group__2__Impl11318);
            	    rule__Legend__Alternatives_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getLegendAccess().getAlternatives_2()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5374:1: rule__Legend__Group__3 : rule__Legend__Group__3__Impl rule__Legend__Group__4 ;
    public final void rule__Legend__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5378:1: ( rule__Legend__Group__3__Impl rule__Legend__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5379:2: rule__Legend__Group__3__Impl rule__Legend__Group__4
            {
            pushFollow(FOLLOW_rule__Legend__Group__3__Impl_in_rule__Legend__Group__311349);
            rule__Legend__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__4_in_rule__Legend__Group__311352);
            rule__Legend__Group__4();

            state._fsp--;


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5386:1: rule__Legend__Group__3__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Legend__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5390:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5391:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5391:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5392:1: RULE_NEWLINE
            {
             before(grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_3()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Legend__Group__3__Impl11379); 
             after(grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__Legend__Group__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5403:1: rule__Legend__Group__4 : rule__Legend__Group__4__Impl ;
    public final void rule__Legend__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5407:1: ( rule__Legend__Group__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5408:2: rule__Legend__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Legend__Group__4__Impl_in_rule__Legend__Group__411408);
            rule__Legend__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group__4"


    // $ANTLR start "rule__Legend__Group__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5414:1: rule__Legend__Group__4__Impl : ( 'endlegend' ) ;
    public final void rule__Legend__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5418:1: ( ( 'endlegend' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5419:1: ( 'endlegend' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5419:1: ( 'endlegend' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5420:1: 'endlegend'
            {
             before(grammarAccess.getLegendAccess().getEndlegendKeyword_4()); 
            match(input,181,FOLLOW_181_in_rule__Legend__Group__4__Impl11436); 
             after(grammarAccess.getLegendAccess().getEndlegendKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group__4__Impl"


    // $ANTLR start "rule__Legend__Group_2_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5443:1: rule__Legend__Group_2_0__0 : rule__Legend__Group_2_0__0__Impl rule__Legend__Group_2_0__1 ;
    public final void rule__Legend__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5447:1: ( rule__Legend__Group_2_0__0__Impl rule__Legend__Group_2_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5448:2: rule__Legend__Group_2_0__0__Impl rule__Legend__Group_2_0__1
            {
            pushFollow(FOLLOW_rule__Legend__Group_2_0__0__Impl_in_rule__Legend__Group_2_0__011477);
            rule__Legend__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group_2_0__1_in_rule__Legend__Group_2_0__011480);
            rule__Legend__Group_2_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group_2_0__0"


    // $ANTLR start "rule__Legend__Group_2_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5455:1: rule__Legend__Group_2_0__0__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Legend__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5459:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5460:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5460:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5461:1: RULE_NEWLINE
            {
             before(grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_0_0()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Legend__Group_2_0__0__Impl11507); 
             after(grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group_2_0__0__Impl"


    // $ANTLR start "rule__Legend__Group_2_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5472:1: rule__Legend__Group_2_0__1 : rule__Legend__Group_2_0__1__Impl ;
    public final void rule__Legend__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5476:1: ( rule__Legend__Group_2_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5477:2: rule__Legend__Group_2_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Legend__Group_2_0__1__Impl_in_rule__Legend__Group_2_0__111536);
            rule__Legend__Group_2_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group_2_0__1"


    // $ANTLR start "rule__Legend__Group_2_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5483:1: rule__Legend__Group_2_0__1__Impl : ( RULE_ID ) ;
    public final void rule__Legend__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5487:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5488:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5488:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5489:1: RULE_ID
            {
             before(grammarAccess.getLegendAccess().getIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Legend__Group_2_0__1__Impl11563); 
             after(grammarAccess.getLegendAccess().getIDTerminalRuleCall_2_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group_2_0__1__Impl"


    // $ANTLR start "rule__Newpage__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5504:1: rule__Newpage__Group__0 : rule__Newpage__Group__0__Impl rule__Newpage__Group__1 ;
    public final void rule__Newpage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5508:1: ( rule__Newpage__Group__0__Impl rule__Newpage__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5509:2: rule__Newpage__Group__0__Impl rule__Newpage__Group__1
            {
            pushFollow(FOLLOW_rule__Newpage__Group__0__Impl_in_rule__Newpage__Group__011596);
            rule__Newpage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Newpage__Group__1_in_rule__Newpage__Group__011599);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5516:1: rule__Newpage__Group__0__Impl : ( 'newpage' ) ;
    public final void rule__Newpage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5520:1: ( ( 'newpage' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5521:1: ( 'newpage' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5521:1: ( 'newpage' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5522:1: 'newpage'
            {
             before(grammarAccess.getNewpageAccess().getNewpageKeyword_0()); 
            match(input,182,FOLLOW_182_in_rule__Newpage__Group__0__Impl11627); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5535:1: rule__Newpage__Group__1 : rule__Newpage__Group__1__Impl ;
    public final void rule__Newpage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5539:1: ( rule__Newpage__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5540:2: rule__Newpage__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Newpage__Group__1__Impl_in_rule__Newpage__Group__111658);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5546:1: rule__Newpage__Group__1__Impl : ( ( RULE_ID )? ) ;
    public final void rule__Newpage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5550:1: ( ( ( RULE_ID )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5551:1: ( ( RULE_ID )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5551:1: ( ( RULE_ID )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5552:1: ( RULE_ID )?
            {
             before(grammarAccess.getNewpageAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5553:1: ( RULE_ID )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5553:3: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Newpage__Group__1__Impl11686); 

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


    // $ANTLR start "rule__AltElse__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5567:1: rule__AltElse__Group__0 : rule__AltElse__Group__0__Impl rule__AltElse__Group__1 ;
    public final void rule__AltElse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5571:1: ( rule__AltElse__Group__0__Impl rule__AltElse__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5572:2: rule__AltElse__Group__0__Impl rule__AltElse__Group__1
            {
            pushFollow(FOLLOW_rule__AltElse__Group__0__Impl_in_rule__AltElse__Group__011721);
            rule__AltElse__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__1_in_rule__AltElse__Group__011724);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5579:1: rule__AltElse__Group__0__Impl : ( 'alt' ) ;
    public final void rule__AltElse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5583:1: ( ( 'alt' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5584:1: ( 'alt' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5584:1: ( 'alt' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5585:1: 'alt'
            {
             before(grammarAccess.getAltElseAccess().getAltKeyword_0()); 
            match(input,183,FOLLOW_183_in_rule__AltElse__Group__0__Impl11752); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5598:1: rule__AltElse__Group__1 : rule__AltElse__Group__1__Impl rule__AltElse__Group__2 ;
    public final void rule__AltElse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5602:1: ( rule__AltElse__Group__1__Impl rule__AltElse__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5603:2: rule__AltElse__Group__1__Impl rule__AltElse__Group__2
            {
            pushFollow(FOLLOW_rule__AltElse__Group__1__Impl_in_rule__AltElse__Group__111783);
            rule__AltElse__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__2_in_rule__AltElse__Group__111786);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5610:1: rule__AltElse__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__AltElse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5614:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5615:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5615:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5616:1: RULE_ID
            {
             before(grammarAccess.getAltElseAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AltElse__Group__1__Impl11813); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5627:1: rule__AltElse__Group__2 : rule__AltElse__Group__2__Impl rule__AltElse__Group__3 ;
    public final void rule__AltElse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5631:1: ( rule__AltElse__Group__2__Impl rule__AltElse__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5632:2: rule__AltElse__Group__2__Impl rule__AltElse__Group__3
            {
            pushFollow(FOLLOW_rule__AltElse__Group__2__Impl_in_rule__AltElse__Group__211842);
            rule__AltElse__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__3_in_rule__AltElse__Group__211845);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5639:1: rule__AltElse__Group__2__Impl : ( RULE_NEWLINE ) ;
    public final void rule__AltElse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5643:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5644:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5644:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5645:1: RULE_NEWLINE
            {
             before(grammarAccess.getAltElseAccess().getNEWLINETerminalRuleCall_2()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__AltElse__Group__2__Impl11872); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5656:1: rule__AltElse__Group__3 : rule__AltElse__Group__3__Impl rule__AltElse__Group__4 ;
    public final void rule__AltElse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5660:1: ( rule__AltElse__Group__3__Impl rule__AltElse__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5661:2: rule__AltElse__Group__3__Impl rule__AltElse__Group__4
            {
            pushFollow(FOLLOW_rule__AltElse__Group__3__Impl_in_rule__AltElse__Group__311901);
            rule__AltElse__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__4_in_rule__AltElse__Group__311904);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5668:1: rule__AltElse__Group__3__Impl : ( ( rule__AltElse__InstructionsAssignment_3 )* ) ;
    public final void rule__AltElse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5672:1: ( ( ( rule__AltElse__InstructionsAssignment_3 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5673:1: ( ( rule__AltElse__InstructionsAssignment_3 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5673:1: ( ( rule__AltElse__InstructionsAssignment_3 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5674:1: ( rule__AltElse__InstructionsAssignment_3 )*
            {
             before(grammarAccess.getAltElseAccess().getInstructionsAssignment_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5675:1: ( rule__AltElse__InstructionsAssignment_3 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=RULE_NEWLINE && LA30_0<=RULE_ID)||(LA30_0>=172 && LA30_0<=177)||(LA30_0>=179 && LA30_0<=180)||(LA30_0>=182 && LA30_0<=183)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5675:2: rule__AltElse__InstructionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__AltElse__InstructionsAssignment_3_in_rule__AltElse__Group__3__Impl11931);
            	    rule__AltElse__InstructionsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5685:1: rule__AltElse__Group__4 : rule__AltElse__Group__4__Impl rule__AltElse__Group__5 ;
    public final void rule__AltElse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5689:1: ( rule__AltElse__Group__4__Impl rule__AltElse__Group__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5690:2: rule__AltElse__Group__4__Impl rule__AltElse__Group__5
            {
            pushFollow(FOLLOW_rule__AltElse__Group__4__Impl_in_rule__AltElse__Group__411962);
            rule__AltElse__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__5_in_rule__AltElse__Group__411965);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5697:1: rule__AltElse__Group__4__Impl : ( ( rule__AltElse__ElsesAssignment_4 )* ) ;
    public final void rule__AltElse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5701:1: ( ( ( rule__AltElse__ElsesAssignment_4 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5702:1: ( ( rule__AltElse__ElsesAssignment_4 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5702:1: ( ( rule__AltElse__ElsesAssignment_4 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5703:1: ( rule__AltElse__ElsesAssignment_4 )*
            {
             before(grammarAccess.getAltElseAccess().getElsesAssignment_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5704:1: ( rule__AltElse__ElsesAssignment_4 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==185) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5704:2: rule__AltElse__ElsesAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__AltElse__ElsesAssignment_4_in_rule__AltElse__Group__4__Impl11992);
            	    rule__AltElse__ElsesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5714:1: rule__AltElse__Group__5 : rule__AltElse__Group__5__Impl ;
    public final void rule__AltElse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5718:1: ( rule__AltElse__Group__5__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5719:2: rule__AltElse__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__AltElse__Group__5__Impl_in_rule__AltElse__Group__512023);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5725:1: rule__AltElse__Group__5__Impl : ( 'end' ) ;
    public final void rule__AltElse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5729:1: ( ( 'end' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5730:1: ( 'end' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5730:1: ( 'end' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5731:1: 'end'
            {
             before(grammarAccess.getAltElseAccess().getEndKeyword_5()); 
            match(input,184,FOLLOW_184_in_rule__AltElse__Group__5__Impl12051); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5756:1: rule__Else__Group__0 : rule__Else__Group__0__Impl rule__Else__Group__1 ;
    public final void rule__Else__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5760:1: ( rule__Else__Group__0__Impl rule__Else__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5761:2: rule__Else__Group__0__Impl rule__Else__Group__1
            {
            pushFollow(FOLLOW_rule__Else__Group__0__Impl_in_rule__Else__Group__012094);
            rule__Else__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Else__Group__1_in_rule__Else__Group__012097);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5768:1: rule__Else__Group__0__Impl : ( 'else' ) ;
    public final void rule__Else__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5772:1: ( ( 'else' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5773:1: ( 'else' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5773:1: ( 'else' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5774:1: 'else'
            {
             before(grammarAccess.getElseAccess().getElseKeyword_0()); 
            match(input,185,FOLLOW_185_in_rule__Else__Group__0__Impl12125); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5787:1: rule__Else__Group__1 : rule__Else__Group__1__Impl rule__Else__Group__2 ;
    public final void rule__Else__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5791:1: ( rule__Else__Group__1__Impl rule__Else__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5792:2: rule__Else__Group__1__Impl rule__Else__Group__2
            {
            pushFollow(FOLLOW_rule__Else__Group__1__Impl_in_rule__Else__Group__112156);
            rule__Else__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Else__Group__2_in_rule__Else__Group__112159);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5799:1: rule__Else__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__Else__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5803:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5804:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5804:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5805:1: RULE_ID
            {
             before(grammarAccess.getElseAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Else__Group__1__Impl12186); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5816:1: rule__Else__Group__2 : rule__Else__Group__2__Impl rule__Else__Group__3 ;
    public final void rule__Else__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5820:1: ( rule__Else__Group__2__Impl rule__Else__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5821:2: rule__Else__Group__2__Impl rule__Else__Group__3
            {
            pushFollow(FOLLOW_rule__Else__Group__2__Impl_in_rule__Else__Group__212215);
            rule__Else__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Else__Group__3_in_rule__Else__Group__212218);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5828:1: rule__Else__Group__2__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Else__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5832:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5833:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5833:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5834:1: RULE_NEWLINE
            {
             before(grammarAccess.getElseAccess().getNEWLINETerminalRuleCall_2()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Else__Group__2__Impl12245); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5845:1: rule__Else__Group__3 : rule__Else__Group__3__Impl ;
    public final void rule__Else__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5849:1: ( rule__Else__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5850:2: rule__Else__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Else__Group__3__Impl_in_rule__Else__Group__312274);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5856:1: rule__Else__Group__3__Impl : ( ( rule__Else__InstructionsAssignment_3 )* ) ;
    public final void rule__Else__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5860:1: ( ( ( rule__Else__InstructionsAssignment_3 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5861:1: ( ( rule__Else__InstructionsAssignment_3 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5861:1: ( ( rule__Else__InstructionsAssignment_3 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5862:1: ( rule__Else__InstructionsAssignment_3 )*
            {
             before(grammarAccess.getElseAccess().getInstructionsAssignment_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5863:1: ( rule__Else__InstructionsAssignment_3 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=RULE_NEWLINE && LA32_0<=RULE_ID)||(LA32_0>=172 && LA32_0<=177)||(LA32_0>=179 && LA32_0<=180)||(LA32_0>=182 && LA32_0<=183)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5863:2: rule__Else__InstructionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Else__InstructionsAssignment_3_in_rule__Else__Group__3__Impl12301);
            	    rule__Else__InstructionsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
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


    // $ANTLR start "rule__Model__DiagramsAssignment"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5882:1: rule__Model__DiagramsAssignment : ( ruleDiagram ) ;
    public final void rule__Model__DiagramsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5886:1: ( ( ruleDiagram ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5887:1: ( ruleDiagram )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5887:1: ( ruleDiagram )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5888:1: ruleDiagram
            {
             before(grammarAccess.getModelAccess().getDiagramsDiagramParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDiagram_in_rule__Model__DiagramsAssignment12345);
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


    // $ANTLR start "rule__Diagram__InstructionsAssignment_2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5897:1: rule__Diagram__InstructionsAssignment_2 : ( ruleInstruction ) ;
    public final void rule__Diagram__InstructionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5901:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5902:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5902:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5903:1: ruleInstruction
            {
             before(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_212376);
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


    // $ANTLR start "rule__Instruction__Name1Assignment_0_0_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5912:1: rule__Instruction__Name1Assignment_0_0_0 : ( RULE_ID ) ;
    public final void rule__Instruction__Name1Assignment_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5916:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5917:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5917:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5918:1: RULE_ID
            {
             before(grammarAccess.getInstructionAccess().getName1IDTerminalRuleCall_0_0_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Instruction__Name1Assignment_0_0_012407); 
             after(grammarAccess.getInstructionAccess().getName1IDTerminalRuleCall_0_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Name1Assignment_0_0_0"


    // $ANTLR start "rule__Instruction__Name2Assignment_0_0_2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5927:1: rule__Instruction__Name2Assignment_0_0_2 : ( RULE_ID ) ;
    public final void rule__Instruction__Name2Assignment_0_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5931:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5932:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5932:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5933:1: RULE_ID
            {
             before(grammarAccess.getInstructionAccess().getName2IDTerminalRuleCall_0_0_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Instruction__Name2Assignment_0_0_212438); 
             after(grammarAccess.getInstructionAccess().getName2IDTerminalRuleCall_0_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Name2Assignment_0_0_2"


    // $ANTLR start "rule__Definition__NameAssignment_0_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5942:1: rule__Definition__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5946:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5947:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5947:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5948:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_0_112469); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5957:1: rule__Definition__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5961:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5962:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5962:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5963:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_1_112500); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5972:1: rule__Definition__NameAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5976:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5977:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5977:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5978:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_2_112531); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5987:1: rule__Definition__NameAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5991:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5992:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5992:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5993:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_3_112562); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6002:1: rule__Definition__NameAssignment_4_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6006:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6007:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6007:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6008:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_4_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_4_112593); 
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


    // $ANTLR start "rule__AltElse__InstructionsAssignment_3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6017:1: rule__AltElse__InstructionsAssignment_3 : ( ruleInstruction ) ;
    public final void rule__AltElse__InstructionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6021:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6022:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6022:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6023:1: ruleInstruction
            {
             before(grammarAccess.getAltElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__AltElse__InstructionsAssignment_312624);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6032:1: rule__AltElse__ElsesAssignment_4 : ( ruleElse ) ;
    public final void rule__AltElse__ElsesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6036:1: ( ( ruleElse ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6037:1: ( ruleElse )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6037:1: ( ruleElse )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6038:1: ruleElse
            {
             before(grammarAccess.getAltElseAccess().getElsesElseParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleElse_in_rule__AltElse__ElsesAssignment_412655);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6047:1: rule__Else__InstructionsAssignment_3 : ( ruleInstruction ) ;
    public final void rule__Else__InstructionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6051:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6052:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6052:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:6053:1: ruleInstruction
            {
             before(grammarAccess.getElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__Else__InstructionsAssignment_312686);
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

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\43\uffff";
    static final String DFA3_eofS =
        "\6\uffff\1\22\1\26\4\uffff\1\35\14\uffff\1\26\2\uffff\1\37\1\uffff"+
        "\1\42\4\uffff";
    static final String DFA3_minS =
        "\1\13\2\u00a3\1\uffff\1\u00a3\1\u00a5\2\5\1\u00a3\3\uffff\1\5\3"+
        "\uffff\1\u00a3\7\uffff\1\u00a3\1\5\2\uffff\1\5\1\uffff\1\5\4\uffff";
    static final String DFA3_maxS =
        "\1\u00aa\1\u00a9\1\u00ab\1\uffff\1\u00a8\1\u00a9\1\13\1\u00aa\1"+
        "\u00ab\3\uffff\1\u00a4\3\uffff\1\u00a3\7\uffff\1\u00a9\1\u00aa\2"+
        "\uffff\1\u00aa\1\uffff\1\u00a4\4\uffff";
    static final String DFA3_acceptS =
        "\3\uffff\1\4\5\uffff\1\11\1\7\1\22\1\uffff\1\6\1\10\1\12\1\uffff"+
        "\1\16\1\25\1\24\1\3\1\5\1\1\1\13\2\uffff\1\23\1\15\1\uffff\1\2\1"+
        "\uffff\1\17\1\20\1\21\1\14";
    static final String DFA3_specialS =
        "\43\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\6\u0097\uffff\1\1\1\uffff\1\2\1\3\1\uffff\1\4\1\uffff\1"+
            "\5",
            "\1\10\1\7\2\uffff\1\12\1\uffff\1\11",
            "\1\14\1\uffff\1\15\5\uffff\1\13",
            "",
            "\1\16\4\uffff\1\17",
            "\1\20\3\uffff\1\21",
            "\1\22\5\uffff\1\23",
            "\1\26\u009e\uffff\1\25\1\uffff\1\24\3\uffff\1\27",
            "\1\30\1\31\2\uffff\1\12\1\33\1\11\1\uffff\1\32",
            "",
            "",
            "",
            "\1\35\u009d\uffff\1\35\1\34",
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
            "\1\30\1\31\2\uffff\1\12\1\33\1\11",
            "\1\26\u009e\uffff\1\25\5\uffff\1\27",
            "",
            "",
            "\1\37\u00a4\uffff\1\40",
            "",
            "\1\42\u009d\uffff\1\42\1\41",
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
            return "448:1: rule__Sequence__Alternatives : ( ( ( rule__Sequence__Group_0__0 ) ) | ( ( rule__Sequence__Group_1__0 ) ) | ( ( rule__Sequence__Group_2__0 ) ) | ( ( rule__Sequence__Group_3__0 ) ) | ( ( rule__Sequence__Group_4__0 ) ) | ( ( rule__Sequence__Group_5__0 ) ) | ( ( rule__Sequence__Group_6__0 ) ) | ( ( rule__Sequence__Group_7__0 ) ) | ( ( rule__Sequence__Group_8__0 ) ) | ( ( rule__Sequence__Group_9__0 ) ) | ( ( rule__Sequence__Group_10__0 ) ) | ( ( rule__Sequence__Group_11__0 ) ) | ( ( rule__Sequence__Group_12__0 ) ) | ( ( rule__Sequence__Group_13__0 ) ) | ( ( rule__Sequence__Group_14__0 ) ) | ( ( rule__Sequence__Group_15__0 ) ) | ( ( rule__Sequence__Group_16__0 ) ) | ( ( rule__Sequence__Group_17__0 ) ) | ( ( rule__Sequence__Group_18__0 ) ) | ( ( rule__Sequence__Group_19__0 ) ) | ( '.' ) );";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DiagramsAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_ruleDiagram_in_entryRuleDiagram122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDiagram129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__0_in_ruleDiagram155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group__0_in_ruleInstruction215 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_ruleAltElse_in_entryRuleAltElse662 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAltElse669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__0_in_ruleAltElse695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElse_in_entryRuleElse722 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElse729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__0_in_ruleElse755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__0_in_rule__Instruction__Alternatives_0791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__0_in_rule__Instruction__Alternatives_0809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_rule__Instruction__Alternatives_0827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_rule__Instruction__Alternatives_0844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLegend_in_rule__Instruction__Alternatives_0861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_rule__Instruction__Alternatives_0878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAltElse_in_rule__Instruction__Alternatives_0895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__0_in_rule__Sequence__Alternatives927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__0_in_rule__Sequence__Alternatives945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__0_in_rule__Sequence__Alternatives963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__0_in_rule__Sequence__Alternatives981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__0_in_rule__Sequence__Alternatives999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__0_in_rule__Sequence__Alternatives1017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__0_in_rule__Sequence__Alternatives1035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__0_in_rule__Sequence__Alternatives1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__0_in_rule__Sequence__Alternatives1071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__0_in_rule__Sequence__Alternatives1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__0_in_rule__Sequence__Alternatives1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__0_in_rule__Sequence__Alternatives1125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__0_in_rule__Sequence__Alternatives1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__0_in_rule__Sequence__Alternatives1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__0_in_rule__Sequence__Alternatives1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__0_in_rule__Sequence__Alternatives1197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__0_in_rule__Sequence__Alternatives1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__0_in_rule__Sequence__Alternatives1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__0_in_rule__Sequence__Alternatives1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__0_in_rule__Sequence__Alternatives1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Sequence__Alternatives1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives1322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives1340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives1358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives1394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Color__Alternatives_11428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Color__Alternatives_11448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Color__Alternatives_11468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Color__Alternatives_11488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Color__Alternatives_11508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Color__Alternatives_11528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Color__Alternatives_11548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Color__Alternatives_11568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Color__Alternatives_11588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Color__Alternatives_11608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Color__Alternatives_11628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Color__Alternatives_11648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Color__Alternatives_11668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Color__Alternatives_11688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Color__Alternatives_11708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Color__Alternatives_11728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Color__Alternatives_11748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Color__Alternatives_11768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Color__Alternatives_11788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Color__Alternatives_11808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Color__Alternatives_11828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Color__Alternatives_11848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Color__Alternatives_11868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Color__Alternatives_11888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Color__Alternatives_11908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Color__Alternatives_11928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Color__Alternatives_11948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Color__Alternatives_11968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__Color__Alternatives_11988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Color__Alternatives_12008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__Color__Alternatives_12028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__Color__Alternatives_12048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__Color__Alternatives_12068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__Color__Alternatives_12088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__Color__Alternatives_12108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__Color__Alternatives_12128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__Color__Alternatives_12148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__Color__Alternatives_12168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__Color__Alternatives_12188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__Color__Alternatives_12208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__Color__Alternatives_12228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__Color__Alternatives_12248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__Color__Alternatives_12268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_rule__Color__Alternatives_12288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rule__Color__Alternatives_12308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_rule__Color__Alternatives_12328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_rule__Color__Alternatives_12348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_rule__Color__Alternatives_12368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_rule__Color__Alternatives_12388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_rule__Color__Alternatives_12408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_rule__Color__Alternatives_12428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_rule__Color__Alternatives_12448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_rule__Color__Alternatives_12468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_rule__Color__Alternatives_12488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_rule__Color__Alternatives_12508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_rule__Color__Alternatives_12528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_rule__Color__Alternatives_12548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_rule__Color__Alternatives_12568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_rule__Color__Alternatives_12588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_rule__Color__Alternatives_12608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_rule__Color__Alternatives_12628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_rule__Color__Alternatives_12648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_rule__Color__Alternatives_12668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_rule__Color__Alternatives_12688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_rule__Color__Alternatives_12708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_rule__Color__Alternatives_12728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_rule__Color__Alternatives_12748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_rule__Color__Alternatives_12768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_rule__Color__Alternatives_12788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_rule__Color__Alternatives_12808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_rule__Color__Alternatives_12828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_rule__Color__Alternatives_12848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_rule__Color__Alternatives_12868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_rule__Color__Alternatives_12888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_rule__Color__Alternatives_12908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_rule__Color__Alternatives_12928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_rule__Color__Alternatives_12948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_rule__Color__Alternatives_12968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_rule__Color__Alternatives_12988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_rule__Color__Alternatives_13008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_rule__Color__Alternatives_13028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_rule__Color__Alternatives_13048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_rule__Color__Alternatives_13068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_rule__Color__Alternatives_13088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_rule__Color__Alternatives_13108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_rule__Color__Alternatives_13128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_rule__Color__Alternatives_13148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_rule__Color__Alternatives_13168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_rule__Color__Alternatives_13188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_rule__Color__Alternatives_13208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_rule__Color__Alternatives_13228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_rule__Color__Alternatives_13248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_rule__Color__Alternatives_13268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_rule__Color__Alternatives_13288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_rule__Color__Alternatives_13308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_rule__Color__Alternatives_13328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_rule__Color__Alternatives_13348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_rule__Color__Alternatives_13368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_rule__Color__Alternatives_13388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_rule__Color__Alternatives_13408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_rule__Color__Alternatives_13428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_rule__Color__Alternatives_13448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_rule__Color__Alternatives_13468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_rule__Color__Alternatives_13488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_rule__Color__Alternatives_13508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_rule__Color__Alternatives_13528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_rule__Color__Alternatives_13548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_rule__Color__Alternatives_13568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_rule__Color__Alternatives_13588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_rule__Color__Alternatives_13608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_rule__Color__Alternatives_13628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_rule__Color__Alternatives_13648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_rule__Color__Alternatives_13668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_rule__Color__Alternatives_13688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_rule__Color__Alternatives_13708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_rule__Color__Alternatives_13728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_rule__Color__Alternatives_13748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_rule__Color__Alternatives_13768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_rule__Color__Alternatives_13788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_rule__Color__Alternatives_13808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_rule__Color__Alternatives_13828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_rule__Color__Alternatives_13848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_134_in_rule__Color__Alternatives_13868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_135_in_rule__Color__Alternatives_13888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_136_in_rule__Color__Alternatives_13908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_137_in_rule__Color__Alternatives_13928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_138_in_rule__Color__Alternatives_13948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_139_in_rule__Color__Alternatives_13968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_140_in_rule__Color__Alternatives_13988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_141_in_rule__Color__Alternatives_14008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_142_in_rule__Color__Alternatives_14028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_143_in_rule__Color__Alternatives_14048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_144_in_rule__Color__Alternatives_14068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_145_in_rule__Color__Alternatives_14088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_146_in_rule__Color__Alternatives_14108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_147_in_rule__Color__Alternatives_14128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_148_in_rule__Color__Alternatives_14148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_149_in_rule__Color__Alternatives_14168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_150_in_rule__Color__Alternatives_14188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_151_in_rule__Color__Alternatives_14208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_152_in_rule__Color__Alternatives_14228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_153_in_rule__Color__Alternatives_14248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_154_in_rule__Color__Alternatives_14268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_155_in_rule__Color__Alternatives_14288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_156_in_rule__Color__Alternatives_14308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_157_in_rule__Legend__Alternatives_14343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_rule__Legend__Alternatives_14363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Legend__Alternatives_14383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2_0__0_in_rule__Legend__Alternatives_24417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Legend__Alternatives_24435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__04465 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__04468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_rule__Diagram__Group__0__Impl4496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__14527 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000000L,0x00DBF00200000000L});
    public static final BitSet FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__14530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__1__Impl4557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__24586 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000000L,0x00DBF00200000000L});
    public static final BitSet FOLLOW_rule__Diagram__Group__3_in_rule__Diagram__Group__24589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__InstructionsAssignment_2_in_rule__Diagram__Group__2__Impl4616 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000000L,0x00DBF00000000000L});
    public static final BitSet FOLLOW_rule__Diagram__Group__3__Impl_in_rule__Diagram__Group__34647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_rule__Diagram__Group__3__Impl4675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group__0__Impl_in_rule__Instruction__Group__04714 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000000L,0x00DBF00000000000L});
    public static final BitSet FOLLOW_rule__Instruction__Group__1_in_rule__Instruction__Group__04717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Alternatives_0_in_rule__Instruction__Group__0__Impl4744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group__1__Impl_in_rule__Instruction__Group__14775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Instruction__Group__1__Impl4802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__0__Impl_in_rule__Instruction__Group_0_0__04835 = new BitSet(new long[]{0x0000000000000800L,0x0000000000000000L,0x0000056800000000L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__1_in_rule__Instruction__Group_0_0__04838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Name1Assignment_0_0_0_in_rule__Instruction__Group_0_0__0__Impl4865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__1__Impl_in_rule__Instruction__Group_0_0__14895 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__2_in_rule__Instruction__Group_0_0__14898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequence_in_rule__Instruction__Group_0_0__1__Impl4925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__2__Impl_in_rule__Instruction__Group_0_0__24954 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__3_in_rule__Instruction__Group_0_0__24957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Name2Assignment_0_0_2_in_rule__Instruction__Group_0_0__2__Impl4984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__3__Impl_in_rule__Instruction__Group_0_0__35014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0_3__0_in_rule__Instruction__Group_0_0__3__Impl5041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0_3__0__Impl_in_rule__Instruction__Group_0_0_3__05080 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0_3__1_in_rule__Instruction__Group_0_0_3__05083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Instruction__Group_0_0_3__0__Impl5111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0_3__1__Impl_in_rule__Instruction__Group_0_0_3__15142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Instruction__Group_0_0_3__1__Impl5169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__0__Impl_in_rule__Instruction__Group_0_1__05202 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__1_in_rule__Instruction__Group_0_1__05205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_rule__Instruction__Group_0_1__0__Impl5232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__1__Impl_in_rule__Instruction__Group_0_1__15261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__Instruction__Group_0_1__1__Impl5289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__0__Impl_in_rule__Sequence__Group_0__05324 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__1_in_rule__Sequence__Group_0__05327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_0__0__Impl5356 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__1__Impl_in_rule__Sequence__Group_0__15389 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__2_in_rule__Sequence__Group_0__15392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_0__1__Impl5420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__2__Impl_in_rule__Sequence__Group_0__25451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_0__2__Impl5479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__0__Impl_in_rule__Sequence__Group_1__05516 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__1_in_rule__Sequence__Group_1__05519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_1__0__Impl5547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__1__Impl_in_rule__Sequence__Group_1__15578 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__2_in_rule__Sequence__Group_1__15581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_1__1__Impl5609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__2__Impl_in_rule__Sequence__Group_1__25640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_1__2__Impl5669 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__0__Impl_in_rule__Sequence__Group_2__05708 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__1_in_rule__Sequence__Group_2__05711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_2__0__Impl5739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__1__Impl_in_rule__Sequence__Group_2__15770 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__2_in_rule__Sequence__Group_2__15773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_2__1__Impl5801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__2__Impl_in_rule__Sequence__Group_2__25832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_166_in_rule__Sequence__Group_2__2__Impl5860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__0__Impl_in_rule__Sequence__Group_3__05897 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__1_in_rule__Sequence__Group_3__05900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_166_in_rule__Sequence__Group_3__0__Impl5928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__1__Impl_in_rule__Sequence__Group_3__15959 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__2_in_rule__Sequence__Group_3__15962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_3__1__Impl5990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__2__Impl_in_rule__Sequence__Group_3__26021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_3__2__Impl6049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__0__Impl_in_rule__Sequence__Group_4__06086 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__1_in_rule__Sequence__Group_4__06089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_4__0__Impl6118 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__1__Impl_in_rule__Sequence__Group_4__16151 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__2_in_rule__Sequence__Group_4__16154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_4__1__Impl6182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__2__Impl_in_rule__Sequence__Group_4__26213 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__3_in_rule__Sequence__Group_4__26216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_4__2__Impl6244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__3__Impl_in_rule__Sequence__Group_4__36275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_4__3__Impl6303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__0__Impl_in_rule__Sequence__Group_5__06342 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__1_in_rule__Sequence__Group_5__06345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_5__0__Impl6373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__1__Impl_in_rule__Sequence__Group_5__16404 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__2_in_rule__Sequence__Group_5__16407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_5__1__Impl6435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__2__Impl_in_rule__Sequence__Group_5__26466 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__3_in_rule__Sequence__Group_5__26469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_5__2__Impl6497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__3__Impl_in_rule__Sequence__Group_5__36528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_5__3__Impl6557 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__0__Impl_in_rule__Sequence__Group_6__06598 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__1_in_rule__Sequence__Group_6__06601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_6__0__Impl6630 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__1__Impl_in_rule__Sequence__Group_6__16663 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__2_in_rule__Sequence__Group_6__16666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_6__1__Impl6694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__2__Impl_in_rule__Sequence__Group_6__26725 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__3_in_rule__Sequence__Group_6__26728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_167_in_rule__Sequence__Group_6__2__Impl6756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__3__Impl_in_rule__Sequence__Group_6__36787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_167_in_rule__Sequence__Group_6__3__Impl6815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__0__Impl_in_rule__Sequence__Group_7__06854 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__1_in_rule__Sequence__Group_7__06857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_rule__Sequence__Group_7__0__Impl6885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__1__Impl_in_rule__Sequence__Group_7__16916 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__2_in_rule__Sequence__Group_7__16919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_7__1__Impl6947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__2__Impl_in_rule__Sequence__Group_7__26978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_7__2__Impl7007 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__0__Impl_in_rule__Sequence__Group_8__07046 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__1_in_rule__Sequence__Group_8__07049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_8__0__Impl7078 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__1__Impl_in_rule__Sequence__Group_8__17111 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__2_in_rule__Sequence__Group_8__17114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_8__1__Impl7142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__2__Impl_in_rule__Sequence__Group_8__27173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_169_in_rule__Sequence__Group_8__2__Impl7201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__0__Impl_in_rule__Sequence__Group_9__07238 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__1_in_rule__Sequence__Group_9__07241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_rule__Sequence__Group_9__0__Impl7269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__1__Impl_in_rule__Sequence__Group_9__17300 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__2_in_rule__Sequence__Group_9__17303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_rule__Sequence__Group_9__1__Impl7331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__2__Impl_in_rule__Sequence__Group_9__27362 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__3_in_rule__Sequence__Group_9__27365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_9__2__Impl7393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__3__Impl_in_rule__Sequence__Group_9__37424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_9__3__Impl7453 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__0__Impl_in_rule__Sequence__Group_10__07494 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__1_in_rule__Sequence__Group_10__07497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_10__0__Impl7526 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__1__Impl_in_rule__Sequence__Group_10__17559 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__2_in_rule__Sequence__Group_10__17562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_10__1__Impl7590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__2__Impl_in_rule__Sequence__Group_10__27621 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__3_in_rule__Sequence__Group_10__27624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_10__2__Impl7652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__3__Impl_in_rule__Sequence__Group_10__37683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_170_in_rule__Sequence__Group_10__3__Impl7711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__0__Impl_in_rule__Sequence__Group_11__07750 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__1_in_rule__Sequence__Group_11__07753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_170_in_rule__Sequence__Group_11__0__Impl7781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__1__Impl_in_rule__Sequence__Group_11__17812 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__2_in_rule__Sequence__Group_11__17815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_11__1__Impl7843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__2__Impl_in_rule__Sequence__Group_11__27874 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__3_in_rule__Sequence__Group_11__27877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_11__2__Impl7905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__3__Impl_in_rule__Sequence__Group_11__37936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_11__3__Impl7965 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__0__Impl_in_rule__Sequence__Group_12__08006 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__1_in_rule__Sequence__Group_12__08009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_12__0__Impl8038 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__1__Impl_in_rule__Sequence__Group_12__18071 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__2_in_rule__Sequence__Group_12__18074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_12__1__Impl8102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__2__Impl_in_rule__Sequence__Group_12__28133 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__3_in_rule__Sequence__Group_12__28136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_12__2__Impl8164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__3__Impl_in_rule__Sequence__Group_12__38195 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__4_in_rule__Sequence__Group_12__38198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_rule__Sequence__Group_12__3__Impl8226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__4__Impl_in_rule__Sequence__Group_12__48257 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__5_in_rule__Sequence__Group_12__48260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_rule__Sequence__Group_12__4__Impl8288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__5__Impl_in_rule__Sequence__Group_12__58319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_170_in_rule__Sequence__Group_12__5__Impl8347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__0__Impl_in_rule__Sequence__Group_13__08390 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__1_in_rule__Sequence__Group_13__08393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_170_in_rule__Sequence__Group_13__0__Impl8421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__1__Impl_in_rule__Sequence__Group_13__18452 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__2_in_rule__Sequence__Group_13__18455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_169_in_rule__Sequence__Group_13__1__Impl8483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__2__Impl_in_rule__Sequence__Group_13__28514 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__3_in_rule__Sequence__Group_13__28517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_13__2__Impl8545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__3__Impl_in_rule__Sequence__Group_13__38576 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__4_in_rule__Sequence__Group_13__38579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_13__3__Impl8607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__4__Impl_in_rule__Sequence__Group_13__48638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_13__4__Impl8667 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__0__Impl_in_rule__Sequence__Group_14__08710 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__1_in_rule__Sequence__Group_14__08713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_14__0__Impl8741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__1__Impl_in_rule__Sequence__Group_14__18772 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__2_in_rule__Sequence__Group_14__18775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_14__1__Impl8803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__2__Impl_in_rule__Sequence__Group_14__28834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_14__2__Impl8862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__0__Impl_in_rule__Sequence__Group_15__08899 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__1_in_rule__Sequence__Group_15__08902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_15__0__Impl8930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__1__Impl_in_rule__Sequence__Group_15__18961 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__2_in_rule__Sequence__Group_15__18964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_15__1__Impl8992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__2__Impl_in_rule__Sequence__Group_15__29023 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__3_in_rule__Sequence__Group_15__29026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_15__2__Impl9054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__3__Impl_in_rule__Sequence__Group_15__39085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_170_in_rule__Sequence__Group_15__3__Impl9113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__0__Impl_in_rule__Sequence__Group_16__09152 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__1_in_rule__Sequence__Group_16__09155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_170_in_rule__Sequence__Group_16__0__Impl9183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__1__Impl_in_rule__Sequence__Group_16__19214 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__2_in_rule__Sequence__Group_16__19217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_16__1__Impl9245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__2__Impl_in_rule__Sequence__Group_16__29276 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__3_in_rule__Sequence__Group_16__29279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_16__2__Impl9307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__3__Impl_in_rule__Sequence__Group_16__39338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_16__3__Impl9366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__0__Impl_in_rule__Sequence__Group_17__09405 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__1_in_rule__Sequence__Group_17__09408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_17__0__Impl9436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__1__Impl_in_rule__Sequence__Group_17__19467 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__2_in_rule__Sequence__Group_17__19470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_171_in_rule__Sequence__Group_17__1__Impl9498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__2__Impl_in_rule__Sequence__Group_17__29529 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__3_in_rule__Sequence__Group_17__29532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_17__2__Impl9560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__3__Impl_in_rule__Sequence__Group_17__39591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_17__3__Impl9619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__0__Impl_in_rule__Sequence__Group_18__09658 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__1_in_rule__Sequence__Group_18__09661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_18__0__Impl9689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__1__Impl_in_rule__Sequence__Group_18__19720 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__2_in_rule__Sequence__Group_18__19723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_18__1__Impl9751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__2__Impl_in_rule__Sequence__Group_18__29782 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__3_in_rule__Sequence__Group_18__29785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_171_in_rule__Sequence__Group_18__2__Impl9813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__3__Impl_in_rule__Sequence__Group_18__39844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_18__3__Impl9872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__0__Impl_in_rule__Sequence__Group_19__09911 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__1_in_rule__Sequence__Group_19__09914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Sequence__Group_19__0__Impl9942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__1__Impl_in_rule__Sequence__Group_19__19973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Sequence__Group_19__1__Impl10001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__010036 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__010039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_172_in_rule__Definition__Group_0__0__Impl10067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__110098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl10125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__010159 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__010162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_173_in_rule__Definition__Group_1__0__Impl10190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__110221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl10248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__010282 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__010285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_174_in_rule__Definition__Group_2__0__Impl10313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__110344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl10371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__010405 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__010408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_175_in_rule__Definition__Group_3__0__Impl10436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__110467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl10494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__010528 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__010531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_176_in_rule__Definition__Group_4__0__Impl10559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__110590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl10617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__0__Impl_in_rule__AutoNumber__Group__010651 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__1_in_rule__AutoNumber__Group__010654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_177_in_rule__AutoNumber__Group__0__Impl10682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__1__Impl_in_rule__AutoNumber__Group__110713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__0_in_rule__AutoNumber__Group__1__Impl10740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__0__Impl_in_rule__AutoNumber__Group_1__010775 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__1_in_rule__AutoNumber__Group_1__010778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__0__Impl10805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__1__Impl_in_rule__AutoNumber__Group_1__110834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__1__Impl10862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Color__Group__0__Impl_in_rule__Color__Group__010897 = new BitSet(new long[]{0xFFFFFFFFFFFFF000L,0xFFFFFFFFFFFFFFFFL,0x000000001FFFFFFFL});
    public static final BitSet FOLLOW_rule__Color__Group__1_in_rule__Color__Group__010900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_178_in_rule__Color__Group__0__Impl10931 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_178_in_rule__Color__Group__0__Impl10947 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_rule__Color__Group__1__Impl_in_rule__Color__Group__110982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Color__Alternatives_1_in_rule__Color__Group__1__Impl11009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__0__Impl_in_rule__Title__Group__011043 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Title__Group__1_in_rule__Title__Group__011046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_179_in_rule__Title__Group__0__Impl11074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__1__Impl_in_rule__Title__Group__111105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Title__Group__1__Impl11132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__0__Impl_in_rule__Legend__Group__011165 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x00000000E0000000L});
    public static final BitSet FOLLOW_rule__Legend__Group__1_in_rule__Legend__Group__011168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_180_in_rule__Legend__Group__0__Impl11196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__1__Impl_in_rule__Legend__Group__111227 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x00000000E0000000L});
    public static final BitSet FOLLOW_rule__Legend__Group__2_in_rule__Legend__Group__111230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Alternatives_1_in_rule__Legend__Group__1__Impl11257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__2__Impl_in_rule__Legend__Group__211288 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x00000000E0000000L});
    public static final BitSet FOLLOW_rule__Legend__Group__3_in_rule__Legend__Group__211291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Alternatives_2_in_rule__Legend__Group__2__Impl11318 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Legend__Group__3__Impl_in_rule__Legend__Group__311349 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Legend__Group__4_in_rule__Legend__Group__311352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Legend__Group__3__Impl11379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__4__Impl_in_rule__Legend__Group__411408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_181_in_rule__Legend__Group__4__Impl11436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2_0__0__Impl_in_rule__Legend__Group_2_0__011477 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Legend__Group_2_0__1_in_rule__Legend__Group_2_0__011480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Legend__Group_2_0__0__Impl11507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2_0__1__Impl_in_rule__Legend__Group_2_0__111536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Legend__Group_2_0__1__Impl11563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__0__Impl_in_rule__Newpage__Group__011596 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Newpage__Group__1_in_rule__Newpage__Group__011599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_182_in_rule__Newpage__Group__0__Impl11627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__1__Impl_in_rule__Newpage__Group__111658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Newpage__Group__1__Impl11686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__0__Impl_in_rule__AltElse__Group__011721 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AltElse__Group__1_in_rule__AltElse__Group__011724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_183_in_rule__AltElse__Group__0__Impl11752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__1__Impl_in_rule__AltElse__Group__111783 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__AltElse__Group__2_in_rule__AltElse__Group__111786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AltElse__Group__1__Impl11813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__2__Impl_in_rule__AltElse__Group__211842 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000000L,0x03DBF00000000000L});
    public static final BitSet FOLLOW_rule__AltElse__Group__3_in_rule__AltElse__Group__211845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__AltElse__Group__2__Impl11872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__3__Impl_in_rule__AltElse__Group__311901 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000000L,0x03DBF00000000000L});
    public static final BitSet FOLLOW_rule__AltElse__Group__4_in_rule__AltElse__Group__311904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__InstructionsAssignment_3_in_rule__AltElse__Group__3__Impl11931 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000000L,0x00DBF00000000000L});
    public static final BitSet FOLLOW_rule__AltElse__Group__4__Impl_in_rule__AltElse__Group__411962 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000000L,0x03DBF00000000000L});
    public static final BitSet FOLLOW_rule__AltElse__Group__5_in_rule__AltElse__Group__411965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__ElsesAssignment_4_in_rule__AltElse__Group__4__Impl11992 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_rule__AltElse__Group__5__Impl_in_rule__AltElse__Group__512023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_184_in_rule__AltElse__Group__5__Impl12051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__0__Impl_in_rule__Else__Group__012094 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Else__Group__1_in_rule__Else__Group__012097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_185_in_rule__Else__Group__0__Impl12125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__1__Impl_in_rule__Else__Group__112156 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Else__Group__2_in_rule__Else__Group__112159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Else__Group__1__Impl12186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__2__Impl_in_rule__Else__Group__212215 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000000L,0x00DBF00000000000L});
    public static final BitSet FOLLOW_rule__Else__Group__3_in_rule__Else__Group__212218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Else__Group__2__Impl12245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__3__Impl_in_rule__Else__Group__312274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__InstructionsAssignment_3_in_rule__Else__Group__3__Impl12301 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000000L,0x00DBF00000000000L});
    public static final BitSet FOLLOW_ruleDiagram_in_rule__Model__DiagramsAssignment12345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_212376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Instruction__Name1Assignment_0_0_012407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Instruction__Name2Assignment_0_0_212438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_0_112469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_1_112500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_2_112531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_3_112562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_4_112593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__AltElse__InstructionsAssignment_312624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElse_in_rule__AltElse__ElsesAssignment_412655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__Else__InstructionsAssignment_312686 = new BitSet(new long[]{0x0000000000000002L});

}