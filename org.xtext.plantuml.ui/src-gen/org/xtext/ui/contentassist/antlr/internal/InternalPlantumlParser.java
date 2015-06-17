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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NEWLINE", "RULE_SEQUENCE", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'hide footbox'", "'AliceBlue'", "'AntiqueWhite'", "'Aqua'", "'Aquamarine'", "'Azure'", "'Beige'", "'Bisque'", "'Black'", "'BlanchedAlmond'", "'Blue'", "'BlueViolet'", "'Brown'", "'BurlyWood'", "'CadetBlue'", "'Chartreuse'", "'Chocolate'", "'Coral'", "'CornflowerBlue'", "'Cornsilk'", "'Crimson'", "'Cyan'", "'DarkBlue'", "'DarkCyan'", "'DarkGoldenRod'", "'DarkGray'", "'DarkGreen'", "'DarkGrey'", "'DarkKhaki'", "'DarkMagenta'", "'DarkOliveGreen'", "'DarkOrchid'", "'DarkRed'", "'DarkSalmo'", "'DarkSeaGreen'", "'DarkSlateBlue'", "'DarkSlateGray'", "'DarkSlateGrey'", "'DarkTurquoise'", "'DarkViolet'", "'Darkorange'", "'DeepPink'", "'DeepSkyBlue'", "'DimGray'", "'DimGrey'", "'DodgerBlue'", "'FireBrick'", "'FloralWhite'", "'ForestGreen'", "'Fuchsia'", "'Gainsboro'", "'GhostWhite'", "'Gold'", "'GoldenRod'", "'Gray'", "'Green'", "'GreenYellow'", "'Grey'", "'HoneyDew'", "'HotPink'", "'IndianRed'", "'Indigo'", "'Ivory'", "'Khaki'", "'Lavender'", "'LavenderBlush'", "'LawnGreen'", "'LemonChiffon'", "'LightBlue'", "'LightCoral'", "'LightCyan'", "'LightGoldenRodYellow'", "'LightGray'", "'LightGreen'", "'LightGrey'", "'LightPink'", "'LightSalmon'", "'LightSeaGreen'", "'LightSkyBlue'", "'LightSlateGray'", "'LightSlateGrey'", "'LightSteelBlue'", "'LightYellow'", "'Lime'", "'LimeGreen'", "'Linen'", "'Magenta'", "'Maroon'", "'MediumAquaMarine'", "'MediumBlue'", "'MediumOrchid'", "'MediumPurple'", "'MediumSeaGreen'", "'MediumSlateBlue'", "'MediumSpringGreen'", "'MediumTurquoise'", "'MediumVioletRed'", "'MidnightBlue'", "'MintCream'", "'MistyRose'", "'Moccasin'", "'NavajoWhite'", "'Navy'", "'OldLace'", "'Olive'", "'OliveDrab'", "'OrangeRed'", "'Orchid'", "'PaleGoldenRod'", "'PaleGreen'", "'PaleTurquoise'", "'PaleVioletRed'", "'PapayaWhip'", "'PeachPuff'", "'Peru'", "'Pink'", "'Plum'", "'PowderBlue'", "'Purple'", "'Red'", "'RosyBrown'", "'RoyalBlue'", "'SaddleBrown'", "'Salmon'", "'SandyBrown'", "'SeaGreen'", "'Sienna'", "'Silver'", "'SkyBlue'", "'SlateBlue'", "'SlateGray'", "'SlateGrey'", "'Snow'", "'SpringGreen'", "'SteelBlue'", "'Tan'", "'Teal'", "'Thistle'", "'Tomato'", "'Turquoise'", "'Violet'", "'Wheat'", "'White'", "'WhiteSmoke'", "'Yellow'", "'YellowGreen'", "'right'", "'left'", "'center'", "'opt'", "'loop'", "'par'", "'break'", "'critical'", "'|||'", "'@startuml'", "'@enduml'", "':'", "'actor'", "'boundary'", "'control'", "'entity'", "'database'", "'participant'", "'autonumber'", "'#'", "'title'", "'legend'", "'endlegend'", "'newpage'", "'alt'", "'end'", "'else'", "'note'", "'of'", "','", "'over'", "'end note'", "'=='", "'ref over'", "'end ref'", "'...'", "'||'"
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
    public static final int T__100=100;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__119=119;
    public static final int T__118=118;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__114=114;
    public static final int T__117=117;
    public static final int T__116=116;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int T__108=108;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__104=104;
    public static final int T__103=103;
    public static final int T__106=106;
    public static final int T__105=105;
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_NEWLINE=4;
    public static final int T__91=91;
    public static final int T__188=188;
    public static final int T__92=92;
    public static final int T__187=187;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__189=189;
    public static final int T__184=184;
    public static final int RULE_SEQUENCE=5;
    public static final int T__183=183;
    public static final int T__186=186;
    public static final int T__90=90;
    public static final int T__185=185;
    public static final int T__180=180;
    public static final int T__182=182;
    public static final int T__181=181;
    public static final int T__99=99;
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
    public static final int T__169=169;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__194=194;
    public static final int RULE_WS=10;
    public static final int T__191=191;
    public static final int T__190=190;
    public static final int T__193=193;
    public static final int T__192=192;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

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

                if ( (LA1_0==167) ) {
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


    // $ANTLR start "entryRuleDefinition"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:144:1: entryRuleDefinition : ruleDefinition EOF ;
    public final void entryRuleDefinition() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:145:1: ( ruleDefinition EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:146:1: ruleDefinition EOF
            {
             before(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition242);
            ruleDefinition();

            state._fsp--;

             after(grammarAccess.getDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition249); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:153:1: ruleDefinition : ( ( rule__Definition__Alternatives ) ) ;
    public final void ruleDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:157:2: ( ( ( rule__Definition__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:158:1: ( ( rule__Definition__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:158:1: ( ( rule__Definition__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:159:1: ( rule__Definition__Alternatives )
            {
             before(grammarAccess.getDefinitionAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:160:1: ( rule__Definition__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:160:2: rule__Definition__Alternatives
            {
            pushFollow(FOLLOW_rule__Definition__Alternatives_in_ruleDefinition275);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:172:1: entryRuleAutoNumber : ruleAutoNumber EOF ;
    public final void entryRuleAutoNumber() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:173:1: ( ruleAutoNumber EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:174:1: ruleAutoNumber EOF
            {
             before(grammarAccess.getAutoNumberRule()); 
            pushFollow(FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber302);
            ruleAutoNumber();

            state._fsp--;

             after(grammarAccess.getAutoNumberRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAutoNumber309); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:181:1: ruleAutoNumber : ( ( rule__AutoNumber__Group__0 ) ) ;
    public final void ruleAutoNumber() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:185:2: ( ( ( rule__AutoNumber__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:186:1: ( ( rule__AutoNumber__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:186:1: ( ( rule__AutoNumber__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:187:1: ( rule__AutoNumber__Group__0 )
            {
             before(grammarAccess.getAutoNumberAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:188:1: ( rule__AutoNumber__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:188:2: rule__AutoNumber__Group__0
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__0_in_ruleAutoNumber335);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:200:1: entryRuleColor : ruleColor EOF ;
    public final void entryRuleColor() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:201:1: ( ruleColor EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:202:1: ruleColor EOF
            {
             before(grammarAccess.getColorRule()); 
            pushFollow(FOLLOW_ruleColor_in_entryRuleColor362);
            ruleColor();

            state._fsp--;

             after(grammarAccess.getColorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColor369); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:209:1: ruleColor : ( ( rule__Color__Group__0 ) ) ;
    public final void ruleColor() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:213:2: ( ( ( rule__Color__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:214:1: ( ( rule__Color__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:214:1: ( ( rule__Color__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:215:1: ( rule__Color__Group__0 )
            {
             before(grammarAccess.getColorAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:216:1: ( rule__Color__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:216:2: rule__Color__Group__0
            {
            pushFollow(FOLLOW_rule__Color__Group__0_in_ruleColor395);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:228:1: entryRuleTitle : ruleTitle EOF ;
    public final void entryRuleTitle() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:229:1: ( ruleTitle EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:230:1: ruleTitle EOF
            {
             before(grammarAccess.getTitleRule()); 
            pushFollow(FOLLOW_ruleTitle_in_entryRuleTitle422);
            ruleTitle();

            state._fsp--;

             after(grammarAccess.getTitleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTitle429); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:237:1: ruleTitle : ( ( rule__Title__Group__0 ) ) ;
    public final void ruleTitle() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:241:2: ( ( ( rule__Title__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:242:1: ( ( rule__Title__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:242:1: ( ( rule__Title__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:243:1: ( rule__Title__Group__0 )
            {
             before(grammarAccess.getTitleAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:244:1: ( rule__Title__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:244:2: rule__Title__Group__0
            {
            pushFollow(FOLLOW_rule__Title__Group__0_in_ruleTitle455);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:256:1: entryRuleLegend : ruleLegend EOF ;
    public final void entryRuleLegend() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:257:1: ( ruleLegend EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:258:1: ruleLegend EOF
            {
             before(grammarAccess.getLegendRule()); 
            pushFollow(FOLLOW_ruleLegend_in_entryRuleLegend482);
            ruleLegend();

            state._fsp--;

             after(grammarAccess.getLegendRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLegend489); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:265:1: ruleLegend : ( ( rule__Legend__Group__0 ) ) ;
    public final void ruleLegend() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:269:2: ( ( ( rule__Legend__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:270:1: ( ( rule__Legend__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:270:1: ( ( rule__Legend__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:271:1: ( rule__Legend__Group__0 )
            {
             before(grammarAccess.getLegendAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:272:1: ( rule__Legend__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:272:2: rule__Legend__Group__0
            {
            pushFollow(FOLLOW_rule__Legend__Group__0_in_ruleLegend515);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:284:1: entryRuleNewpage : ruleNewpage EOF ;
    public final void entryRuleNewpage() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:285:1: ( ruleNewpage EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:286:1: ruleNewpage EOF
            {
             before(grammarAccess.getNewpageRule()); 
            pushFollow(FOLLOW_ruleNewpage_in_entryRuleNewpage542);
            ruleNewpage();

            state._fsp--;

             after(grammarAccess.getNewpageRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNewpage549); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:293:1: ruleNewpage : ( ( rule__Newpage__Group__0 ) ) ;
    public final void ruleNewpage() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:297:2: ( ( ( rule__Newpage__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:298:1: ( ( rule__Newpage__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:298:1: ( ( rule__Newpage__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:299:1: ( rule__Newpage__Group__0 )
            {
             before(grammarAccess.getNewpageAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:300:1: ( rule__Newpage__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:300:2: rule__Newpage__Group__0
            {
            pushFollow(FOLLOW_rule__Newpage__Group__0_in_ruleNewpage575);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:312:1: entryRuleAltElse : ruleAltElse EOF ;
    public final void entryRuleAltElse() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:313:1: ( ruleAltElse EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:314:1: ruleAltElse EOF
            {
             before(grammarAccess.getAltElseRule()); 
            pushFollow(FOLLOW_ruleAltElse_in_entryRuleAltElse602);
            ruleAltElse();

            state._fsp--;

             after(grammarAccess.getAltElseRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAltElse609); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:321:1: ruleAltElse : ( ( rule__AltElse__Group__0 ) ) ;
    public final void ruleAltElse() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:325:2: ( ( ( rule__AltElse__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:326:1: ( ( rule__AltElse__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:326:1: ( ( rule__AltElse__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:327:1: ( rule__AltElse__Group__0 )
            {
             before(grammarAccess.getAltElseAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:328:1: ( rule__AltElse__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:328:2: rule__AltElse__Group__0
            {
            pushFollow(FOLLOW_rule__AltElse__Group__0_in_ruleAltElse635);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:340:1: entryRuleElse : ruleElse EOF ;
    public final void entryRuleElse() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:341:1: ( ruleElse EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:342:1: ruleElse EOF
            {
             before(grammarAccess.getElseRule()); 
            pushFollow(FOLLOW_ruleElse_in_entryRuleElse662);
            ruleElse();

            state._fsp--;

             after(grammarAccess.getElseRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElse669); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:349:1: ruleElse : ( ( rule__Else__Group__0 ) ) ;
    public final void ruleElse() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:353:2: ( ( ( rule__Else__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:354:1: ( ( rule__Else__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:354:1: ( ( rule__Else__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:355:1: ( rule__Else__Group__0 )
            {
             before(grammarAccess.getElseAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:356:1: ( rule__Else__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:356:2: rule__Else__Group__0
            {
            pushFollow(FOLLOW_rule__Else__Group__0_in_ruleElse695);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:368:1: entryRuleGroupingMessages : ruleGroupingMessages EOF ;
    public final void entryRuleGroupingMessages() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:369:1: ( ruleGroupingMessages EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:370:1: ruleGroupingMessages EOF
            {
             before(grammarAccess.getGroupingMessagesRule()); 
            pushFollow(FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages722);
            ruleGroupingMessages();

            state._fsp--;

             after(grammarAccess.getGroupingMessagesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroupingMessages729); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:377:1: ruleGroupingMessages : ( ( rule__GroupingMessages__Group__0 ) ) ;
    public final void ruleGroupingMessages() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:381:2: ( ( ( rule__GroupingMessages__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:382:1: ( ( rule__GroupingMessages__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:382:1: ( ( rule__GroupingMessages__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:383:1: ( rule__GroupingMessages__Group__0 )
            {
             before(grammarAccess.getGroupingMessagesAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:384:1: ( rule__GroupingMessages__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:384:2: rule__GroupingMessages__Group__0
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__0_in_ruleGroupingMessages755);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:398:1: entryRuleNote : ruleNote EOF ;
    public final void entryRuleNote() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:399:1: ( ruleNote EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:400:1: ruleNote EOF
            {
             before(grammarAccess.getNoteRule()); 
            pushFollow(FOLLOW_ruleNote_in_entryRuleNote784);
            ruleNote();

            state._fsp--;

             after(grammarAccess.getNoteRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNote791); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:407:1: ruleNote : ( ( rule__Note__Group__0 ) ) ;
    public final void ruleNote() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:411:2: ( ( ( rule__Note__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:412:1: ( ( rule__Note__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:412:1: ( ( rule__Note__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:413:1: ( rule__Note__Group__0 )
            {
             before(grammarAccess.getNoteAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:414:1: ( rule__Note__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:414:2: rule__Note__Group__0
            {
            pushFollow(FOLLOW_rule__Note__Group__0_in_ruleNote817);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:426:1: entryRuleDivider : ruleDivider EOF ;
    public final void entryRuleDivider() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:427:1: ( ruleDivider EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:428:1: ruleDivider EOF
            {
             before(grammarAccess.getDividerRule()); 
            pushFollow(FOLLOW_ruleDivider_in_entryRuleDivider844);
            ruleDivider();

            state._fsp--;

             after(grammarAccess.getDividerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDivider851); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:435:1: ruleDivider : ( ( rule__Divider__Group__0 ) ) ;
    public final void ruleDivider() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:439:2: ( ( ( rule__Divider__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:440:1: ( ( rule__Divider__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:440:1: ( ( rule__Divider__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:441:1: ( rule__Divider__Group__0 )
            {
             before(grammarAccess.getDividerAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:442:1: ( rule__Divider__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:442:2: rule__Divider__Group__0
            {
            pushFollow(FOLLOW_rule__Divider__Group__0_in_ruleDivider877);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:454:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:455:1: ( ruleReference EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:456:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference904);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference911); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:463:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:467:2: ( ( ( rule__Reference__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:468:1: ( ( rule__Reference__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:468:1: ( ( rule__Reference__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:469:1: ( rule__Reference__Group__0 )
            {
             before(grammarAccess.getReferenceAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:470:1: ( rule__Reference__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:470:2: rule__Reference__Group__0
            {
            pushFollow(FOLLOW_rule__Reference__Group__0_in_ruleReference937);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:482:1: entryRuleDelay : ruleDelay EOF ;
    public final void entryRuleDelay() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:483:1: ( ruleDelay EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:484:1: ruleDelay EOF
            {
             before(grammarAccess.getDelayRule()); 
            pushFollow(FOLLOW_ruleDelay_in_entryRuleDelay964);
            ruleDelay();

            state._fsp--;

             after(grammarAccess.getDelayRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDelay971); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:491:1: ruleDelay : ( ( rule__Delay__Group__0 ) ) ;
    public final void ruleDelay() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:495:2: ( ( ( rule__Delay__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:496:1: ( ( rule__Delay__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:496:1: ( ( rule__Delay__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:497:1: ( rule__Delay__Group__0 )
            {
             before(grammarAccess.getDelayAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:498:1: ( rule__Delay__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:498:2: rule__Delay__Group__0
            {
            pushFollow(FOLLOW_rule__Delay__Group__0_in_ruleDelay997);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:510:1: entryRuleSpace : ruleSpace EOF ;
    public final void entryRuleSpace() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:511:1: ( ruleSpace EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:512:1: ruleSpace EOF
            {
             before(grammarAccess.getSpaceRule()); 
            pushFollow(FOLLOW_ruleSpace_in_entryRuleSpace1024);
            ruleSpace();

            state._fsp--;

             after(grammarAccess.getSpaceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpace1031); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:519:1: ruleSpace : ( ( rule__Space__Alternatives ) ) ;
    public final void ruleSpace() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:523:2: ( ( ( rule__Space__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:524:1: ( ( rule__Space__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:524:1: ( ( rule__Space__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:525:1: ( rule__Space__Alternatives )
            {
             before(grammarAccess.getSpaceAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:526:1: ( rule__Space__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:526:2: rule__Space__Alternatives
            {
            pushFollow(FOLLOW_rule__Space__Alternatives_in_ruleSpace1057);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:538:1: entryRuleHidefootbox : ruleHidefootbox EOF ;
    public final void entryRuleHidefootbox() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:539:1: ( ruleHidefootbox EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:540:1: ruleHidefootbox EOF
            {
             before(grammarAccess.getHidefootboxRule()); 
            pushFollow(FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox1084);
            ruleHidefootbox();

            state._fsp--;

             after(grammarAccess.getHidefootboxRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHidefootbox1091); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:547:1: ruleHidefootbox : ( 'hide footbox' ) ;
    public final void ruleHidefootbox() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:551:2: ( ( 'hide footbox' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:552:1: ( 'hide footbox' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:552:1: ( 'hide footbox' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:553:1: 'hide footbox'
            {
             before(grammarAccess.getHidefootboxAccess().getHideFootboxKeyword()); 
            match(input,12,FOLLOW_12_in_ruleHidefootbox1118); 
             after(grammarAccess.getHidefootboxAccess().getHideFootboxKeyword()); 

            }


            }

        }
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


    // $ANTLR start "rule__Instruction__Alternatives_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:568:1: rule__Instruction__Alternatives_0 : ( ( ( rule__Instruction__Group_0_0__0 ) ) | ( ( rule__Instruction__Group_0_1__0 ) ) | ( ruleAutoNumber ) | ( ruleTitle ) | ( ruleLegend ) | ( ruleNewpage ) | ( ruleAltElse ) | ( ruleGroupingMessages ) | ( ruleNote ) | ( ruleDivider ) | ( ruleReference ) | ( ruleDelay ) | ( ruleSpace ) | ( ruleHidefootbox ) );
    public final void rule__Instruction__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:572:1: ( ( ( rule__Instruction__Group_0_0__0 ) ) | ( ( rule__Instruction__Group_0_1__0 ) ) | ( ruleAutoNumber ) | ( ruleTitle ) | ( ruleLegend ) | ( ruleNewpage ) | ( ruleAltElse ) | ( ruleGroupingMessages ) | ( ruleNote ) | ( ruleDivider ) | ( ruleReference ) | ( ruleDelay ) | ( ruleSpace ) | ( ruleHidefootbox ) )
            int alt2=14;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt2=1;
                }
                break;
            case 170:
            case 171:
            case 172:
            case 173:
            case 174:
            case 175:
                {
                alt2=2;
                }
                break;
            case 176:
                {
                alt2=3;
                }
                break;
            case 178:
                {
                alt2=4;
                }
                break;
            case 179:
                {
                alt2=5;
                }
                break;
            case 181:
                {
                alt2=6;
                }
                break;
            case 182:
                {
                alt2=7;
                }
                break;
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
                {
                alt2=8;
                }
                break;
            case 185:
                {
                alt2=9;
                }
                break;
            case 190:
                {
                alt2=10;
                }
                break;
            case 191:
                {
                alt2=11;
                }
                break;
            case 193:
                {
                alt2=12;
                }
                break;
            case 166:
            case 194:
                {
                alt2=13;
                }
                break;
            case 12:
                {
                alt2=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:573:1: ( ( rule__Instruction__Group_0_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:573:1: ( ( rule__Instruction__Group_0_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:574:1: ( rule__Instruction__Group_0_0__0 )
                    {
                     before(grammarAccess.getInstructionAccess().getGroup_0_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:575:1: ( rule__Instruction__Group_0_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:575:2: rule__Instruction__Group_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_0_0__0_in_rule__Instruction__Alternatives_01155);
                    rule__Instruction__Group_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInstructionAccess().getGroup_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:579:6: ( ( rule__Instruction__Group_0_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:579:6: ( ( rule__Instruction__Group_0_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:580:1: ( rule__Instruction__Group_0_1__0 )
                    {
                     before(grammarAccess.getInstructionAccess().getGroup_0_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:581:1: ( rule__Instruction__Group_0_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:581:2: rule__Instruction__Group_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_0_1__0_in_rule__Instruction__Alternatives_01173);
                    rule__Instruction__Group_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInstructionAccess().getGroup_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:585:6: ( ruleAutoNumber )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:585:6: ( ruleAutoNumber )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:586:1: ruleAutoNumber
                    {
                     before(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 
                    pushFollow(FOLLOW_ruleAutoNumber_in_rule__Instruction__Alternatives_01191);
                    ruleAutoNumber();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:591:6: ( ruleTitle )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:591:6: ( ruleTitle )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:592:1: ruleTitle
                    {
                     before(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 
                    pushFollow(FOLLOW_ruleTitle_in_rule__Instruction__Alternatives_01208);
                    ruleTitle();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:597:6: ( ruleLegend )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:597:6: ( ruleLegend )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:598:1: ruleLegend
                    {
                     before(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 
                    pushFollow(FOLLOW_ruleLegend_in_rule__Instruction__Alternatives_01225);
                    ruleLegend();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:603:6: ( ruleNewpage )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:603:6: ( ruleNewpage )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:604:1: ruleNewpage
                    {
                     before(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 
                    pushFollow(FOLLOW_ruleNewpage_in_rule__Instruction__Alternatives_01242);
                    ruleNewpage();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:609:6: ( ruleAltElse )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:609:6: ( ruleAltElse )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:610:1: ruleAltElse
                    {
                     before(grammarAccess.getInstructionAccess().getAltElseParserRuleCall_0_6()); 
                    pushFollow(FOLLOW_ruleAltElse_in_rule__Instruction__Alternatives_01259);
                    ruleAltElse();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getAltElseParserRuleCall_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:615:6: ( ruleGroupingMessages )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:615:6: ( ruleGroupingMessages )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:616:1: ruleGroupingMessages
                    {
                     before(grammarAccess.getInstructionAccess().getGroupingMessagesParserRuleCall_0_7()); 
                    pushFollow(FOLLOW_ruleGroupingMessages_in_rule__Instruction__Alternatives_01276);
                    ruleGroupingMessages();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getGroupingMessagesParserRuleCall_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:621:6: ( ruleNote )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:621:6: ( ruleNote )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:622:1: ruleNote
                    {
                     before(grammarAccess.getInstructionAccess().getNoteParserRuleCall_0_8()); 
                    pushFollow(FOLLOW_ruleNote_in_rule__Instruction__Alternatives_01293);
                    ruleNote();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getNoteParserRuleCall_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:627:6: ( ruleDivider )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:627:6: ( ruleDivider )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:628:1: ruleDivider
                    {
                     before(grammarAccess.getInstructionAccess().getDividerParserRuleCall_0_9()); 
                    pushFollow(FOLLOW_ruleDivider_in_rule__Instruction__Alternatives_01310);
                    ruleDivider();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getDividerParserRuleCall_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:633:6: ( ruleReference )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:633:6: ( ruleReference )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:634:1: ruleReference
                    {
                     before(grammarAccess.getInstructionAccess().getReferenceParserRuleCall_0_10()); 
                    pushFollow(FOLLOW_ruleReference_in_rule__Instruction__Alternatives_01327);
                    ruleReference();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getReferenceParserRuleCall_0_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:639:6: ( ruleDelay )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:639:6: ( ruleDelay )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:640:1: ruleDelay
                    {
                     before(grammarAccess.getInstructionAccess().getDelayParserRuleCall_0_11()); 
                    pushFollow(FOLLOW_ruleDelay_in_rule__Instruction__Alternatives_01344);
                    ruleDelay();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getDelayParserRuleCall_0_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:645:6: ( ruleSpace )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:645:6: ( ruleSpace )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:646:1: ruleSpace
                    {
                     before(grammarAccess.getInstructionAccess().getSpaceParserRuleCall_0_12()); 
                    pushFollow(FOLLOW_ruleSpace_in_rule__Instruction__Alternatives_01361);
                    ruleSpace();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getSpaceParserRuleCall_0_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:651:6: ( ruleHidefootbox )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:651:6: ( ruleHidefootbox )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:652:1: ruleHidefootbox
                    {
                     before(grammarAccess.getInstructionAccess().getHidefootboxParserRuleCall_0_13()); 
                    pushFollow(FOLLOW_ruleHidefootbox_in_rule__Instruction__Alternatives_01378);
                    ruleHidefootbox();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getHidefootboxParserRuleCall_0_13()); 

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


    // $ANTLR start "rule__Definition__Alternatives"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:662:1: rule__Definition__Alternatives : ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) | ( ( rule__Definition__Group_5__0 ) ) );
    public final void rule__Definition__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:666:1: ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) | ( ( rule__Definition__Group_5__0 ) ) )
            int alt3=6;
            switch ( input.LA(1) ) {
            case 170:
                {
                alt3=1;
                }
                break;
            case 171:
                {
                alt3=2;
                }
                break;
            case 172:
                {
                alt3=3;
                }
                break;
            case 173:
                {
                alt3=4;
                }
                break;
            case 174:
                {
                alt3=5;
                }
                break;
            case 175:
                {
                alt3=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:667:1: ( ( rule__Definition__Group_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:667:1: ( ( rule__Definition__Group_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:668:1: ( rule__Definition__Group_0__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:669:1: ( rule__Definition__Group_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:669:2: rule__Definition__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives1410);
                    rule__Definition__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:673:6: ( ( rule__Definition__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:673:6: ( ( rule__Definition__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:674:1: ( rule__Definition__Group_1__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:675:1: ( rule__Definition__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:675:2: rule__Definition__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives1428);
                    rule__Definition__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:679:6: ( ( rule__Definition__Group_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:679:6: ( ( rule__Definition__Group_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:680:1: ( rule__Definition__Group_2__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:681:1: ( rule__Definition__Group_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:681:2: rule__Definition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives1446);
                    rule__Definition__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:685:6: ( ( rule__Definition__Group_3__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:685:6: ( ( rule__Definition__Group_3__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:686:1: ( rule__Definition__Group_3__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_3()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:687:1: ( rule__Definition__Group_3__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:687:2: rule__Definition__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives1464);
                    rule__Definition__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:691:6: ( ( rule__Definition__Group_4__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:691:6: ( ( rule__Definition__Group_4__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:692:1: ( rule__Definition__Group_4__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_4()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:693:1: ( rule__Definition__Group_4__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:693:2: rule__Definition__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives1482);
                    rule__Definition__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:697:6: ( ( rule__Definition__Group_5__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:697:6: ( ( rule__Definition__Group_5__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:698:1: ( rule__Definition__Group_5__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_5()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:699:1: ( rule__Definition__Group_5__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:699:2: rule__Definition__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_5__0_in_rule__Definition__Alternatives1500);
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


    // $ANTLR start "rule__Color__Alternatives_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:708:1: rule__Color__Alternatives_1 : ( ( 'AliceBlue' ) | ( 'AntiqueWhite' ) | ( 'Aqua' ) | ( 'Aquamarine' ) | ( 'Azure' ) | ( 'Beige' ) | ( 'Bisque' ) | ( 'Black' ) | ( 'BlanchedAlmond' ) | ( 'Blue' ) | ( 'BlueViolet' ) | ( 'Brown' ) | ( 'BurlyWood' ) | ( 'CadetBlue' ) | ( 'Chartreuse' ) | ( 'Chocolate' ) | ( 'Coral' ) | ( 'CornflowerBlue' ) | ( 'Cornsilk' ) | ( 'Crimson' ) | ( 'Cyan' ) | ( 'DarkBlue' ) | ( 'DarkCyan' ) | ( 'DarkGoldenRod' ) | ( 'DarkGray' ) | ( 'DarkGreen' ) | ( 'DarkGrey' ) | ( 'DarkKhaki' ) | ( 'DarkMagenta' ) | ( 'DarkOliveGreen' ) | ( 'DarkOrchid' ) | ( 'DarkRed' ) | ( 'DarkSalmo' ) | ( 'DarkSeaGreen' ) | ( 'DarkSlateBlue' ) | ( 'DarkSlateGray' ) | ( 'DarkSlateGrey' ) | ( 'DarkTurquoise' ) | ( 'DarkViolet' ) | ( 'Darkorange' ) | ( 'DeepPink' ) | ( 'DeepSkyBlue' ) | ( 'DimGray' ) | ( 'DimGrey' ) | ( 'DodgerBlue' ) | ( 'FireBrick' ) | ( 'FloralWhite' ) | ( 'ForestGreen' ) | ( 'Fuchsia' ) | ( 'Gainsboro' ) | ( 'GhostWhite' ) | ( 'Gold' ) | ( 'GoldenRod' ) | ( 'Gray' ) | ( 'Green' ) | ( 'GreenYellow' ) | ( 'Grey' ) | ( 'HoneyDew' ) | ( 'HotPink' ) | ( 'IndianRed' ) | ( 'Indigo' ) | ( 'Ivory' ) | ( 'Khaki' ) | ( 'Lavender' ) | ( 'LavenderBlush' ) | ( 'LawnGreen' ) | ( 'LemonChiffon' ) | ( 'LightBlue' ) | ( 'LightCoral' ) | ( 'LightCyan' ) | ( 'LightGoldenRodYellow' ) | ( 'LightGray' ) | ( 'LightGreen' ) | ( 'LightGrey' ) | ( 'LightPink' ) | ( 'LightSalmon' ) | ( 'LightSeaGreen' ) | ( 'LightSkyBlue' ) | ( 'LightSlateGray' ) | ( 'LightSlateGrey' ) | ( 'LightSteelBlue' ) | ( 'LightYellow' ) | ( 'Lime' ) | ( 'LimeGreen' ) | ( 'Linen' ) | ( 'Magenta' ) | ( 'Maroon' ) | ( 'MediumAquaMarine' ) | ( 'MediumBlue' ) | ( 'MediumOrchid' ) | ( 'MediumPurple' ) | ( 'MediumSeaGreen' ) | ( 'MediumSlateBlue' ) | ( 'MediumSpringGreen' ) | ( 'MediumTurquoise' ) | ( 'MediumVioletRed' ) | ( 'MidnightBlue' ) | ( 'MintCream' ) | ( 'MistyRose' ) | ( 'Moccasin' ) | ( 'NavajoWhite' ) | ( 'Navy' ) | ( 'OldLace' ) | ( 'Olive' ) | ( 'OliveDrab' ) | ( 'OrangeRed' ) | ( 'Orchid' ) | ( 'PaleGoldenRod' ) | ( 'PaleGreen' ) | ( 'PaleTurquoise' ) | ( 'PaleVioletRed' ) | ( 'PapayaWhip' ) | ( 'PeachPuff' ) | ( 'Peru' ) | ( 'Pink' ) | ( 'Plum' ) | ( 'PowderBlue' ) | ( 'Purple' ) | ( 'Red' ) | ( 'RosyBrown' ) | ( 'RoyalBlue' ) | ( 'SaddleBrown' ) | ( 'Salmon' ) | ( 'SandyBrown' ) | ( 'SeaGreen' ) | ( 'Sienna' ) | ( 'Silver' ) | ( 'SkyBlue' ) | ( 'SlateBlue' ) | ( 'SlateGray' ) | ( 'SlateGrey' ) | ( 'Snow' ) | ( 'SpringGreen' ) | ( 'SteelBlue' ) | ( 'Tan' ) | ( 'Teal' ) | ( 'Thistle' ) | ( 'Tomato' ) | ( 'Turquoise' ) | ( 'Violet' ) | ( 'Wheat' ) | ( 'White' ) | ( 'WhiteSmoke' ) | ( 'Yellow' ) | ( 'YellowGreen' ) );
    public final void rule__Color__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:712:1: ( ( 'AliceBlue' ) | ( 'AntiqueWhite' ) | ( 'Aqua' ) | ( 'Aquamarine' ) | ( 'Azure' ) | ( 'Beige' ) | ( 'Bisque' ) | ( 'Black' ) | ( 'BlanchedAlmond' ) | ( 'Blue' ) | ( 'BlueViolet' ) | ( 'Brown' ) | ( 'BurlyWood' ) | ( 'CadetBlue' ) | ( 'Chartreuse' ) | ( 'Chocolate' ) | ( 'Coral' ) | ( 'CornflowerBlue' ) | ( 'Cornsilk' ) | ( 'Crimson' ) | ( 'Cyan' ) | ( 'DarkBlue' ) | ( 'DarkCyan' ) | ( 'DarkGoldenRod' ) | ( 'DarkGray' ) | ( 'DarkGreen' ) | ( 'DarkGrey' ) | ( 'DarkKhaki' ) | ( 'DarkMagenta' ) | ( 'DarkOliveGreen' ) | ( 'DarkOrchid' ) | ( 'DarkRed' ) | ( 'DarkSalmo' ) | ( 'DarkSeaGreen' ) | ( 'DarkSlateBlue' ) | ( 'DarkSlateGray' ) | ( 'DarkSlateGrey' ) | ( 'DarkTurquoise' ) | ( 'DarkViolet' ) | ( 'Darkorange' ) | ( 'DeepPink' ) | ( 'DeepSkyBlue' ) | ( 'DimGray' ) | ( 'DimGrey' ) | ( 'DodgerBlue' ) | ( 'FireBrick' ) | ( 'FloralWhite' ) | ( 'ForestGreen' ) | ( 'Fuchsia' ) | ( 'Gainsboro' ) | ( 'GhostWhite' ) | ( 'Gold' ) | ( 'GoldenRod' ) | ( 'Gray' ) | ( 'Green' ) | ( 'GreenYellow' ) | ( 'Grey' ) | ( 'HoneyDew' ) | ( 'HotPink' ) | ( 'IndianRed' ) | ( 'Indigo' ) | ( 'Ivory' ) | ( 'Khaki' ) | ( 'Lavender' ) | ( 'LavenderBlush' ) | ( 'LawnGreen' ) | ( 'LemonChiffon' ) | ( 'LightBlue' ) | ( 'LightCoral' ) | ( 'LightCyan' ) | ( 'LightGoldenRodYellow' ) | ( 'LightGray' ) | ( 'LightGreen' ) | ( 'LightGrey' ) | ( 'LightPink' ) | ( 'LightSalmon' ) | ( 'LightSeaGreen' ) | ( 'LightSkyBlue' ) | ( 'LightSlateGray' ) | ( 'LightSlateGrey' ) | ( 'LightSteelBlue' ) | ( 'LightYellow' ) | ( 'Lime' ) | ( 'LimeGreen' ) | ( 'Linen' ) | ( 'Magenta' ) | ( 'Maroon' ) | ( 'MediumAquaMarine' ) | ( 'MediumBlue' ) | ( 'MediumOrchid' ) | ( 'MediumPurple' ) | ( 'MediumSeaGreen' ) | ( 'MediumSlateBlue' ) | ( 'MediumSpringGreen' ) | ( 'MediumTurquoise' ) | ( 'MediumVioletRed' ) | ( 'MidnightBlue' ) | ( 'MintCream' ) | ( 'MistyRose' ) | ( 'Moccasin' ) | ( 'NavajoWhite' ) | ( 'Navy' ) | ( 'OldLace' ) | ( 'Olive' ) | ( 'OliveDrab' ) | ( 'OrangeRed' ) | ( 'Orchid' ) | ( 'PaleGoldenRod' ) | ( 'PaleGreen' ) | ( 'PaleTurquoise' ) | ( 'PaleVioletRed' ) | ( 'PapayaWhip' ) | ( 'PeachPuff' ) | ( 'Peru' ) | ( 'Pink' ) | ( 'Plum' ) | ( 'PowderBlue' ) | ( 'Purple' ) | ( 'Red' ) | ( 'RosyBrown' ) | ( 'RoyalBlue' ) | ( 'SaddleBrown' ) | ( 'Salmon' ) | ( 'SandyBrown' ) | ( 'SeaGreen' ) | ( 'Sienna' ) | ( 'Silver' ) | ( 'SkyBlue' ) | ( 'SlateBlue' ) | ( 'SlateGray' ) | ( 'SlateGrey' ) | ( 'Snow' ) | ( 'SpringGreen' ) | ( 'SteelBlue' ) | ( 'Tan' ) | ( 'Teal' ) | ( 'Thistle' ) | ( 'Tomato' ) | ( 'Turquoise' ) | ( 'Violet' ) | ( 'Wheat' ) | ( 'White' ) | ( 'WhiteSmoke' ) | ( 'Yellow' ) | ( 'YellowGreen' ) )
            int alt4=145;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt4=1;
                }
                break;
            case 14:
                {
                alt4=2;
                }
                break;
            case 15:
                {
                alt4=3;
                }
                break;
            case 16:
                {
                alt4=4;
                }
                break;
            case 17:
                {
                alt4=5;
                }
                break;
            case 18:
                {
                alt4=6;
                }
                break;
            case 19:
                {
                alt4=7;
                }
                break;
            case 20:
                {
                alt4=8;
                }
                break;
            case 21:
                {
                alt4=9;
                }
                break;
            case 22:
                {
                alt4=10;
                }
                break;
            case 23:
                {
                alt4=11;
                }
                break;
            case 24:
                {
                alt4=12;
                }
                break;
            case 25:
                {
                alt4=13;
                }
                break;
            case 26:
                {
                alt4=14;
                }
                break;
            case 27:
                {
                alt4=15;
                }
                break;
            case 28:
                {
                alt4=16;
                }
                break;
            case 29:
                {
                alt4=17;
                }
                break;
            case 30:
                {
                alt4=18;
                }
                break;
            case 31:
                {
                alt4=19;
                }
                break;
            case 32:
                {
                alt4=20;
                }
                break;
            case 33:
                {
                alt4=21;
                }
                break;
            case 34:
                {
                alt4=22;
                }
                break;
            case 35:
                {
                alt4=23;
                }
                break;
            case 36:
                {
                alt4=24;
                }
                break;
            case 37:
                {
                alt4=25;
                }
                break;
            case 38:
                {
                alt4=26;
                }
                break;
            case 39:
                {
                alt4=27;
                }
                break;
            case 40:
                {
                alt4=28;
                }
                break;
            case 41:
                {
                alt4=29;
                }
                break;
            case 42:
                {
                alt4=30;
                }
                break;
            case 43:
                {
                alt4=31;
                }
                break;
            case 44:
                {
                alt4=32;
                }
                break;
            case 45:
                {
                alt4=33;
                }
                break;
            case 46:
                {
                alt4=34;
                }
                break;
            case 47:
                {
                alt4=35;
                }
                break;
            case 48:
                {
                alt4=36;
                }
                break;
            case 49:
                {
                alt4=37;
                }
                break;
            case 50:
                {
                alt4=38;
                }
                break;
            case 51:
                {
                alt4=39;
                }
                break;
            case 52:
                {
                alt4=40;
                }
                break;
            case 53:
                {
                alt4=41;
                }
                break;
            case 54:
                {
                alt4=42;
                }
                break;
            case 55:
                {
                alt4=43;
                }
                break;
            case 56:
                {
                alt4=44;
                }
                break;
            case 57:
                {
                alt4=45;
                }
                break;
            case 58:
                {
                alt4=46;
                }
                break;
            case 59:
                {
                alt4=47;
                }
                break;
            case 60:
                {
                alt4=48;
                }
                break;
            case 61:
                {
                alt4=49;
                }
                break;
            case 62:
                {
                alt4=50;
                }
                break;
            case 63:
                {
                alt4=51;
                }
                break;
            case 64:
                {
                alt4=52;
                }
                break;
            case 65:
                {
                alt4=53;
                }
                break;
            case 66:
                {
                alt4=54;
                }
                break;
            case 67:
                {
                alt4=55;
                }
                break;
            case 68:
                {
                alt4=56;
                }
                break;
            case 69:
                {
                alt4=57;
                }
                break;
            case 70:
                {
                alt4=58;
                }
                break;
            case 71:
                {
                alt4=59;
                }
                break;
            case 72:
                {
                alt4=60;
                }
                break;
            case 73:
                {
                alt4=61;
                }
                break;
            case 74:
                {
                alt4=62;
                }
                break;
            case 75:
                {
                alt4=63;
                }
                break;
            case 76:
                {
                alt4=64;
                }
                break;
            case 77:
                {
                alt4=65;
                }
                break;
            case 78:
                {
                alt4=66;
                }
                break;
            case 79:
                {
                alt4=67;
                }
                break;
            case 80:
                {
                alt4=68;
                }
                break;
            case 81:
                {
                alt4=69;
                }
                break;
            case 82:
                {
                alt4=70;
                }
                break;
            case 83:
                {
                alt4=71;
                }
                break;
            case 84:
                {
                alt4=72;
                }
                break;
            case 85:
                {
                alt4=73;
                }
                break;
            case 86:
                {
                alt4=74;
                }
                break;
            case 87:
                {
                alt4=75;
                }
                break;
            case 88:
                {
                alt4=76;
                }
                break;
            case 89:
                {
                alt4=77;
                }
                break;
            case 90:
                {
                alt4=78;
                }
                break;
            case 91:
                {
                alt4=79;
                }
                break;
            case 92:
                {
                alt4=80;
                }
                break;
            case 93:
                {
                alt4=81;
                }
                break;
            case 94:
                {
                alt4=82;
                }
                break;
            case 95:
                {
                alt4=83;
                }
                break;
            case 96:
                {
                alt4=84;
                }
                break;
            case 97:
                {
                alt4=85;
                }
                break;
            case 98:
                {
                alt4=86;
                }
                break;
            case 99:
                {
                alt4=87;
                }
                break;
            case 100:
                {
                alt4=88;
                }
                break;
            case 101:
                {
                alt4=89;
                }
                break;
            case 102:
                {
                alt4=90;
                }
                break;
            case 103:
                {
                alt4=91;
                }
                break;
            case 104:
                {
                alt4=92;
                }
                break;
            case 105:
                {
                alt4=93;
                }
                break;
            case 106:
                {
                alt4=94;
                }
                break;
            case 107:
                {
                alt4=95;
                }
                break;
            case 108:
                {
                alt4=96;
                }
                break;
            case 109:
                {
                alt4=97;
                }
                break;
            case 110:
                {
                alt4=98;
                }
                break;
            case 111:
                {
                alt4=99;
                }
                break;
            case 112:
                {
                alt4=100;
                }
                break;
            case 113:
                {
                alt4=101;
                }
                break;
            case 114:
                {
                alt4=102;
                }
                break;
            case 115:
                {
                alt4=103;
                }
                break;
            case 116:
                {
                alt4=104;
                }
                break;
            case 117:
                {
                alt4=105;
                }
                break;
            case 118:
                {
                alt4=106;
                }
                break;
            case 119:
                {
                alt4=107;
                }
                break;
            case 120:
                {
                alt4=108;
                }
                break;
            case 121:
                {
                alt4=109;
                }
                break;
            case 122:
                {
                alt4=110;
                }
                break;
            case 123:
                {
                alt4=111;
                }
                break;
            case 124:
                {
                alt4=112;
                }
                break;
            case 125:
                {
                alt4=113;
                }
                break;
            case 126:
                {
                alt4=114;
                }
                break;
            case 127:
                {
                alt4=115;
                }
                break;
            case 128:
                {
                alt4=116;
                }
                break;
            case 129:
                {
                alt4=117;
                }
                break;
            case 130:
                {
                alt4=118;
                }
                break;
            case 131:
                {
                alt4=119;
                }
                break;
            case 132:
                {
                alt4=120;
                }
                break;
            case 133:
                {
                alt4=121;
                }
                break;
            case 134:
                {
                alt4=122;
                }
                break;
            case 135:
                {
                alt4=123;
                }
                break;
            case 136:
                {
                alt4=124;
                }
                break;
            case 137:
                {
                alt4=125;
                }
                break;
            case 138:
                {
                alt4=126;
                }
                break;
            case 139:
                {
                alt4=127;
                }
                break;
            case 140:
                {
                alt4=128;
                }
                break;
            case 141:
                {
                alt4=129;
                }
                break;
            case 142:
                {
                alt4=130;
                }
                break;
            case 143:
                {
                alt4=131;
                }
                break;
            case 144:
                {
                alt4=132;
                }
                break;
            case 145:
                {
                alt4=133;
                }
                break;
            case 146:
                {
                alt4=134;
                }
                break;
            case 147:
                {
                alt4=135;
                }
                break;
            case 148:
                {
                alt4=136;
                }
                break;
            case 149:
                {
                alt4=137;
                }
                break;
            case 150:
                {
                alt4=138;
                }
                break;
            case 151:
                {
                alt4=139;
                }
                break;
            case 152:
                {
                alt4=140;
                }
                break;
            case 153:
                {
                alt4=141;
                }
                break;
            case 154:
                {
                alt4=142;
                }
                break;
            case 155:
                {
                alt4=143;
                }
                break;
            case 156:
                {
                alt4=144;
                }
                break;
            case 157:
                {
                alt4=145;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:713:1: ( 'AliceBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:713:1: ( 'AliceBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:714:1: 'AliceBlue'
                    {
                     before(grammarAccess.getColorAccess().getAliceBlueKeyword_1_0()); 
                    match(input,13,FOLLOW_13_in_rule__Color__Alternatives_11534); 
                     after(grammarAccess.getColorAccess().getAliceBlueKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:721:6: ( 'AntiqueWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:721:6: ( 'AntiqueWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:722:1: 'AntiqueWhite'
                    {
                     before(grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1_1()); 
                    match(input,14,FOLLOW_14_in_rule__Color__Alternatives_11554); 
                     after(grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:729:6: ( 'Aqua' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:729:6: ( 'Aqua' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:730:1: 'Aqua'
                    {
                     before(grammarAccess.getColorAccess().getAquaKeyword_1_2()); 
                    match(input,15,FOLLOW_15_in_rule__Color__Alternatives_11574); 
                     after(grammarAccess.getColorAccess().getAquaKeyword_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:737:6: ( 'Aquamarine' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:737:6: ( 'Aquamarine' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:738:1: 'Aquamarine'
                    {
                     before(grammarAccess.getColorAccess().getAquamarineKeyword_1_3()); 
                    match(input,16,FOLLOW_16_in_rule__Color__Alternatives_11594); 
                     after(grammarAccess.getColorAccess().getAquamarineKeyword_1_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:745:6: ( 'Azure' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:745:6: ( 'Azure' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:746:1: 'Azure'
                    {
                     before(grammarAccess.getColorAccess().getAzureKeyword_1_4()); 
                    match(input,17,FOLLOW_17_in_rule__Color__Alternatives_11614); 
                     after(grammarAccess.getColorAccess().getAzureKeyword_1_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:753:6: ( 'Beige' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:753:6: ( 'Beige' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:754:1: 'Beige'
                    {
                     before(grammarAccess.getColorAccess().getBeigeKeyword_1_5()); 
                    match(input,18,FOLLOW_18_in_rule__Color__Alternatives_11634); 
                     after(grammarAccess.getColorAccess().getBeigeKeyword_1_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:761:6: ( 'Bisque' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:761:6: ( 'Bisque' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:762:1: 'Bisque'
                    {
                     before(grammarAccess.getColorAccess().getBisqueKeyword_1_6()); 
                    match(input,19,FOLLOW_19_in_rule__Color__Alternatives_11654); 
                     after(grammarAccess.getColorAccess().getBisqueKeyword_1_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:769:6: ( 'Black' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:769:6: ( 'Black' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:770:1: 'Black'
                    {
                     before(grammarAccess.getColorAccess().getBlackKeyword_1_7()); 
                    match(input,20,FOLLOW_20_in_rule__Color__Alternatives_11674); 
                     after(grammarAccess.getColorAccess().getBlackKeyword_1_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:777:6: ( 'BlanchedAlmond' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:777:6: ( 'BlanchedAlmond' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:778:1: 'BlanchedAlmond'
                    {
                     before(grammarAccess.getColorAccess().getBlanchedAlmondKeyword_1_8()); 
                    match(input,21,FOLLOW_21_in_rule__Color__Alternatives_11694); 
                     after(grammarAccess.getColorAccess().getBlanchedAlmondKeyword_1_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:785:6: ( 'Blue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:785:6: ( 'Blue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:786:1: 'Blue'
                    {
                     before(grammarAccess.getColorAccess().getBlueKeyword_1_9()); 
                    match(input,22,FOLLOW_22_in_rule__Color__Alternatives_11714); 
                     after(grammarAccess.getColorAccess().getBlueKeyword_1_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:793:6: ( 'BlueViolet' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:793:6: ( 'BlueViolet' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:794:1: 'BlueViolet'
                    {
                     before(grammarAccess.getColorAccess().getBlueVioletKeyword_1_10()); 
                    match(input,23,FOLLOW_23_in_rule__Color__Alternatives_11734); 
                     after(grammarAccess.getColorAccess().getBlueVioletKeyword_1_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:801:6: ( 'Brown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:801:6: ( 'Brown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:802:1: 'Brown'
                    {
                     before(grammarAccess.getColorAccess().getBrownKeyword_1_11()); 
                    match(input,24,FOLLOW_24_in_rule__Color__Alternatives_11754); 
                     after(grammarAccess.getColorAccess().getBrownKeyword_1_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:809:6: ( 'BurlyWood' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:809:6: ( 'BurlyWood' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:810:1: 'BurlyWood'
                    {
                     before(grammarAccess.getColorAccess().getBurlyWoodKeyword_1_12()); 
                    match(input,25,FOLLOW_25_in_rule__Color__Alternatives_11774); 
                     after(grammarAccess.getColorAccess().getBurlyWoodKeyword_1_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:817:6: ( 'CadetBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:817:6: ( 'CadetBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:818:1: 'CadetBlue'
                    {
                     before(grammarAccess.getColorAccess().getCadetBlueKeyword_1_13()); 
                    match(input,26,FOLLOW_26_in_rule__Color__Alternatives_11794); 
                     after(grammarAccess.getColorAccess().getCadetBlueKeyword_1_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:825:6: ( 'Chartreuse' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:825:6: ( 'Chartreuse' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:826:1: 'Chartreuse'
                    {
                     before(grammarAccess.getColorAccess().getChartreuseKeyword_1_14()); 
                    match(input,27,FOLLOW_27_in_rule__Color__Alternatives_11814); 
                     after(grammarAccess.getColorAccess().getChartreuseKeyword_1_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:833:6: ( 'Chocolate' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:833:6: ( 'Chocolate' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:834:1: 'Chocolate'
                    {
                     before(grammarAccess.getColorAccess().getChocolateKeyword_1_15()); 
                    match(input,28,FOLLOW_28_in_rule__Color__Alternatives_11834); 
                     after(grammarAccess.getColorAccess().getChocolateKeyword_1_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:841:6: ( 'Coral' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:841:6: ( 'Coral' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:842:1: 'Coral'
                    {
                     before(grammarAccess.getColorAccess().getCoralKeyword_1_16()); 
                    match(input,29,FOLLOW_29_in_rule__Color__Alternatives_11854); 
                     after(grammarAccess.getColorAccess().getCoralKeyword_1_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:849:6: ( 'CornflowerBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:849:6: ( 'CornflowerBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:850:1: 'CornflowerBlue'
                    {
                     before(grammarAccess.getColorAccess().getCornflowerBlueKeyword_1_17()); 
                    match(input,30,FOLLOW_30_in_rule__Color__Alternatives_11874); 
                     after(grammarAccess.getColorAccess().getCornflowerBlueKeyword_1_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:857:6: ( 'Cornsilk' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:857:6: ( 'Cornsilk' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:858:1: 'Cornsilk'
                    {
                     before(grammarAccess.getColorAccess().getCornsilkKeyword_1_18()); 
                    match(input,31,FOLLOW_31_in_rule__Color__Alternatives_11894); 
                     after(grammarAccess.getColorAccess().getCornsilkKeyword_1_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:865:6: ( 'Crimson' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:865:6: ( 'Crimson' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:866:1: 'Crimson'
                    {
                     before(grammarAccess.getColorAccess().getCrimsonKeyword_1_19()); 
                    match(input,32,FOLLOW_32_in_rule__Color__Alternatives_11914); 
                     after(grammarAccess.getColorAccess().getCrimsonKeyword_1_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:873:6: ( 'Cyan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:873:6: ( 'Cyan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:874:1: 'Cyan'
                    {
                     before(grammarAccess.getColorAccess().getCyanKeyword_1_20()); 
                    match(input,33,FOLLOW_33_in_rule__Color__Alternatives_11934); 
                     after(grammarAccess.getColorAccess().getCyanKeyword_1_20()); 

                    }


                    }
                    break;
                case 22 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:881:6: ( 'DarkBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:881:6: ( 'DarkBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:882:1: 'DarkBlue'
                    {
                     before(grammarAccess.getColorAccess().getDarkBlueKeyword_1_21()); 
                    match(input,34,FOLLOW_34_in_rule__Color__Alternatives_11954); 
                     after(grammarAccess.getColorAccess().getDarkBlueKeyword_1_21()); 

                    }


                    }
                    break;
                case 23 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:889:6: ( 'DarkCyan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:889:6: ( 'DarkCyan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:890:1: 'DarkCyan'
                    {
                     before(grammarAccess.getColorAccess().getDarkCyanKeyword_1_22()); 
                    match(input,35,FOLLOW_35_in_rule__Color__Alternatives_11974); 
                     after(grammarAccess.getColorAccess().getDarkCyanKeyword_1_22()); 

                    }


                    }
                    break;
                case 24 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:897:6: ( 'DarkGoldenRod' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:897:6: ( 'DarkGoldenRod' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:898:1: 'DarkGoldenRod'
                    {
                     before(grammarAccess.getColorAccess().getDarkGoldenRodKeyword_1_23()); 
                    match(input,36,FOLLOW_36_in_rule__Color__Alternatives_11994); 
                     after(grammarAccess.getColorAccess().getDarkGoldenRodKeyword_1_23()); 

                    }


                    }
                    break;
                case 25 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:905:6: ( 'DarkGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:905:6: ( 'DarkGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:906:1: 'DarkGray'
                    {
                     before(grammarAccess.getColorAccess().getDarkGrayKeyword_1_24()); 
                    match(input,37,FOLLOW_37_in_rule__Color__Alternatives_12014); 
                     after(grammarAccess.getColorAccess().getDarkGrayKeyword_1_24()); 

                    }


                    }
                    break;
                case 26 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:913:6: ( 'DarkGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:913:6: ( 'DarkGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:914:1: 'DarkGreen'
                    {
                     before(grammarAccess.getColorAccess().getDarkGreenKeyword_1_25()); 
                    match(input,38,FOLLOW_38_in_rule__Color__Alternatives_12034); 
                     after(grammarAccess.getColorAccess().getDarkGreenKeyword_1_25()); 

                    }


                    }
                    break;
                case 27 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:921:6: ( 'DarkGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:921:6: ( 'DarkGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:922:1: 'DarkGrey'
                    {
                     before(grammarAccess.getColorAccess().getDarkGreyKeyword_1_26()); 
                    match(input,39,FOLLOW_39_in_rule__Color__Alternatives_12054); 
                     after(grammarAccess.getColorAccess().getDarkGreyKeyword_1_26()); 

                    }


                    }
                    break;
                case 28 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:929:6: ( 'DarkKhaki' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:929:6: ( 'DarkKhaki' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:930:1: 'DarkKhaki'
                    {
                     before(grammarAccess.getColorAccess().getDarkKhakiKeyword_1_27()); 
                    match(input,40,FOLLOW_40_in_rule__Color__Alternatives_12074); 
                     after(grammarAccess.getColorAccess().getDarkKhakiKeyword_1_27()); 

                    }


                    }
                    break;
                case 29 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:937:6: ( 'DarkMagenta' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:937:6: ( 'DarkMagenta' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:938:1: 'DarkMagenta'
                    {
                     before(grammarAccess.getColorAccess().getDarkMagentaKeyword_1_28()); 
                    match(input,41,FOLLOW_41_in_rule__Color__Alternatives_12094); 
                     after(grammarAccess.getColorAccess().getDarkMagentaKeyword_1_28()); 

                    }


                    }
                    break;
                case 30 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:945:6: ( 'DarkOliveGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:945:6: ( 'DarkOliveGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:946:1: 'DarkOliveGreen'
                    {
                     before(grammarAccess.getColorAccess().getDarkOliveGreenKeyword_1_29()); 
                    match(input,42,FOLLOW_42_in_rule__Color__Alternatives_12114); 
                     after(grammarAccess.getColorAccess().getDarkOliveGreenKeyword_1_29()); 

                    }


                    }
                    break;
                case 31 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:953:6: ( 'DarkOrchid' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:953:6: ( 'DarkOrchid' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:954:1: 'DarkOrchid'
                    {
                     before(grammarAccess.getColorAccess().getDarkOrchidKeyword_1_30()); 
                    match(input,43,FOLLOW_43_in_rule__Color__Alternatives_12134); 
                     after(grammarAccess.getColorAccess().getDarkOrchidKeyword_1_30()); 

                    }


                    }
                    break;
                case 32 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:961:6: ( 'DarkRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:961:6: ( 'DarkRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:962:1: 'DarkRed'
                    {
                     before(grammarAccess.getColorAccess().getDarkRedKeyword_1_31()); 
                    match(input,44,FOLLOW_44_in_rule__Color__Alternatives_12154); 
                     after(grammarAccess.getColorAccess().getDarkRedKeyword_1_31()); 

                    }


                    }
                    break;
                case 33 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:969:6: ( 'DarkSalmo' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:969:6: ( 'DarkSalmo' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:970:1: 'DarkSalmo'
                    {
                     before(grammarAccess.getColorAccess().getDarkSalmoKeyword_1_32()); 
                    match(input,45,FOLLOW_45_in_rule__Color__Alternatives_12174); 
                     after(grammarAccess.getColorAccess().getDarkSalmoKeyword_1_32()); 

                    }


                    }
                    break;
                case 34 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:977:6: ( 'DarkSeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:977:6: ( 'DarkSeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:978:1: 'DarkSeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getDarkSeaGreenKeyword_1_33()); 
                    match(input,46,FOLLOW_46_in_rule__Color__Alternatives_12194); 
                     after(grammarAccess.getColorAccess().getDarkSeaGreenKeyword_1_33()); 

                    }


                    }
                    break;
                case 35 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:985:6: ( 'DarkSlateBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:985:6: ( 'DarkSlateBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:986:1: 'DarkSlateBlue'
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateBlueKeyword_1_34()); 
                    match(input,47,FOLLOW_47_in_rule__Color__Alternatives_12214); 
                     after(grammarAccess.getColorAccess().getDarkSlateBlueKeyword_1_34()); 

                    }


                    }
                    break;
                case 36 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:993:6: ( 'DarkSlateGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:993:6: ( 'DarkSlateGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:994:1: 'DarkSlateGray'
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateGrayKeyword_1_35()); 
                    match(input,48,FOLLOW_48_in_rule__Color__Alternatives_12234); 
                     after(grammarAccess.getColorAccess().getDarkSlateGrayKeyword_1_35()); 

                    }


                    }
                    break;
                case 37 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1001:6: ( 'DarkSlateGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1001:6: ( 'DarkSlateGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1002:1: 'DarkSlateGrey'
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateGreyKeyword_1_36()); 
                    match(input,49,FOLLOW_49_in_rule__Color__Alternatives_12254); 
                     after(grammarAccess.getColorAccess().getDarkSlateGreyKeyword_1_36()); 

                    }


                    }
                    break;
                case 38 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1009:6: ( 'DarkTurquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1009:6: ( 'DarkTurquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1010:1: 'DarkTurquoise'
                    {
                     before(grammarAccess.getColorAccess().getDarkTurquoiseKeyword_1_37()); 
                    match(input,50,FOLLOW_50_in_rule__Color__Alternatives_12274); 
                     after(grammarAccess.getColorAccess().getDarkTurquoiseKeyword_1_37()); 

                    }


                    }
                    break;
                case 39 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1017:6: ( 'DarkViolet' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1017:6: ( 'DarkViolet' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1018:1: 'DarkViolet'
                    {
                     before(grammarAccess.getColorAccess().getDarkVioletKeyword_1_38()); 
                    match(input,51,FOLLOW_51_in_rule__Color__Alternatives_12294); 
                     after(grammarAccess.getColorAccess().getDarkVioletKeyword_1_38()); 

                    }


                    }
                    break;
                case 40 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1025:6: ( 'Darkorange' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1025:6: ( 'Darkorange' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1026:1: 'Darkorange'
                    {
                     before(grammarAccess.getColorAccess().getDarkorangeKeyword_1_39()); 
                    match(input,52,FOLLOW_52_in_rule__Color__Alternatives_12314); 
                     after(grammarAccess.getColorAccess().getDarkorangeKeyword_1_39()); 

                    }


                    }
                    break;
                case 41 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1033:6: ( 'DeepPink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1033:6: ( 'DeepPink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1034:1: 'DeepPink'
                    {
                     before(grammarAccess.getColorAccess().getDeepPinkKeyword_1_40()); 
                    match(input,53,FOLLOW_53_in_rule__Color__Alternatives_12334); 
                     after(grammarAccess.getColorAccess().getDeepPinkKeyword_1_40()); 

                    }


                    }
                    break;
                case 42 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1041:6: ( 'DeepSkyBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1041:6: ( 'DeepSkyBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1042:1: 'DeepSkyBlue'
                    {
                     before(grammarAccess.getColorAccess().getDeepSkyBlueKeyword_1_41()); 
                    match(input,54,FOLLOW_54_in_rule__Color__Alternatives_12354); 
                     after(grammarAccess.getColorAccess().getDeepSkyBlueKeyword_1_41()); 

                    }


                    }
                    break;
                case 43 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1049:6: ( 'DimGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1049:6: ( 'DimGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1050:1: 'DimGray'
                    {
                     before(grammarAccess.getColorAccess().getDimGrayKeyword_1_42()); 
                    match(input,55,FOLLOW_55_in_rule__Color__Alternatives_12374); 
                     after(grammarAccess.getColorAccess().getDimGrayKeyword_1_42()); 

                    }


                    }
                    break;
                case 44 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1057:6: ( 'DimGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1057:6: ( 'DimGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1058:1: 'DimGrey'
                    {
                     before(grammarAccess.getColorAccess().getDimGreyKeyword_1_43()); 
                    match(input,56,FOLLOW_56_in_rule__Color__Alternatives_12394); 
                     after(grammarAccess.getColorAccess().getDimGreyKeyword_1_43()); 

                    }


                    }
                    break;
                case 45 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1065:6: ( 'DodgerBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1065:6: ( 'DodgerBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1066:1: 'DodgerBlue'
                    {
                     before(grammarAccess.getColorAccess().getDodgerBlueKeyword_1_44()); 
                    match(input,57,FOLLOW_57_in_rule__Color__Alternatives_12414); 
                     after(grammarAccess.getColorAccess().getDodgerBlueKeyword_1_44()); 

                    }


                    }
                    break;
                case 46 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1073:6: ( 'FireBrick' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1073:6: ( 'FireBrick' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1074:1: 'FireBrick'
                    {
                     before(grammarAccess.getColorAccess().getFireBrickKeyword_1_45()); 
                    match(input,58,FOLLOW_58_in_rule__Color__Alternatives_12434); 
                     after(grammarAccess.getColorAccess().getFireBrickKeyword_1_45()); 

                    }


                    }
                    break;
                case 47 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1081:6: ( 'FloralWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1081:6: ( 'FloralWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1082:1: 'FloralWhite'
                    {
                     before(grammarAccess.getColorAccess().getFloralWhiteKeyword_1_46()); 
                    match(input,59,FOLLOW_59_in_rule__Color__Alternatives_12454); 
                     after(grammarAccess.getColorAccess().getFloralWhiteKeyword_1_46()); 

                    }


                    }
                    break;
                case 48 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1089:6: ( 'ForestGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1089:6: ( 'ForestGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1090:1: 'ForestGreen'
                    {
                     before(grammarAccess.getColorAccess().getForestGreenKeyword_1_47()); 
                    match(input,60,FOLLOW_60_in_rule__Color__Alternatives_12474); 
                     after(grammarAccess.getColorAccess().getForestGreenKeyword_1_47()); 

                    }


                    }
                    break;
                case 49 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1097:6: ( 'Fuchsia' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1097:6: ( 'Fuchsia' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1098:1: 'Fuchsia'
                    {
                     before(grammarAccess.getColorAccess().getFuchsiaKeyword_1_48()); 
                    match(input,61,FOLLOW_61_in_rule__Color__Alternatives_12494); 
                     after(grammarAccess.getColorAccess().getFuchsiaKeyword_1_48()); 

                    }


                    }
                    break;
                case 50 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1105:6: ( 'Gainsboro' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1105:6: ( 'Gainsboro' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1106:1: 'Gainsboro'
                    {
                     before(grammarAccess.getColorAccess().getGainsboroKeyword_1_49()); 
                    match(input,62,FOLLOW_62_in_rule__Color__Alternatives_12514); 
                     after(grammarAccess.getColorAccess().getGainsboroKeyword_1_49()); 

                    }


                    }
                    break;
                case 51 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1113:6: ( 'GhostWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1113:6: ( 'GhostWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1114:1: 'GhostWhite'
                    {
                     before(grammarAccess.getColorAccess().getGhostWhiteKeyword_1_50()); 
                    match(input,63,FOLLOW_63_in_rule__Color__Alternatives_12534); 
                     after(grammarAccess.getColorAccess().getGhostWhiteKeyword_1_50()); 

                    }


                    }
                    break;
                case 52 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1121:6: ( 'Gold' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1121:6: ( 'Gold' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1122:1: 'Gold'
                    {
                     before(grammarAccess.getColorAccess().getGoldKeyword_1_51()); 
                    match(input,64,FOLLOW_64_in_rule__Color__Alternatives_12554); 
                     after(grammarAccess.getColorAccess().getGoldKeyword_1_51()); 

                    }


                    }
                    break;
                case 53 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1129:6: ( 'GoldenRod' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1129:6: ( 'GoldenRod' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1130:1: 'GoldenRod'
                    {
                     before(grammarAccess.getColorAccess().getGoldenRodKeyword_1_52()); 
                    match(input,65,FOLLOW_65_in_rule__Color__Alternatives_12574); 
                     after(grammarAccess.getColorAccess().getGoldenRodKeyword_1_52()); 

                    }


                    }
                    break;
                case 54 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1137:6: ( 'Gray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1137:6: ( 'Gray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1138:1: 'Gray'
                    {
                     before(grammarAccess.getColorAccess().getGrayKeyword_1_53()); 
                    match(input,66,FOLLOW_66_in_rule__Color__Alternatives_12594); 
                     after(grammarAccess.getColorAccess().getGrayKeyword_1_53()); 

                    }


                    }
                    break;
                case 55 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1145:6: ( 'Green' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1145:6: ( 'Green' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1146:1: 'Green'
                    {
                     before(grammarAccess.getColorAccess().getGreenKeyword_1_54()); 
                    match(input,67,FOLLOW_67_in_rule__Color__Alternatives_12614); 
                     after(grammarAccess.getColorAccess().getGreenKeyword_1_54()); 

                    }


                    }
                    break;
                case 56 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1153:6: ( 'GreenYellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1153:6: ( 'GreenYellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1154:1: 'GreenYellow'
                    {
                     before(grammarAccess.getColorAccess().getGreenYellowKeyword_1_55()); 
                    match(input,68,FOLLOW_68_in_rule__Color__Alternatives_12634); 
                     after(grammarAccess.getColorAccess().getGreenYellowKeyword_1_55()); 

                    }


                    }
                    break;
                case 57 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1161:6: ( 'Grey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1161:6: ( 'Grey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1162:1: 'Grey'
                    {
                     before(grammarAccess.getColorAccess().getGreyKeyword_1_56()); 
                    match(input,69,FOLLOW_69_in_rule__Color__Alternatives_12654); 
                     after(grammarAccess.getColorAccess().getGreyKeyword_1_56()); 

                    }


                    }
                    break;
                case 58 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1169:6: ( 'HoneyDew' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1169:6: ( 'HoneyDew' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1170:1: 'HoneyDew'
                    {
                     before(grammarAccess.getColorAccess().getHoneyDewKeyword_1_57()); 
                    match(input,70,FOLLOW_70_in_rule__Color__Alternatives_12674); 
                     after(grammarAccess.getColorAccess().getHoneyDewKeyword_1_57()); 

                    }


                    }
                    break;
                case 59 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1177:6: ( 'HotPink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1177:6: ( 'HotPink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1178:1: 'HotPink'
                    {
                     before(grammarAccess.getColorAccess().getHotPinkKeyword_1_58()); 
                    match(input,71,FOLLOW_71_in_rule__Color__Alternatives_12694); 
                     after(grammarAccess.getColorAccess().getHotPinkKeyword_1_58()); 

                    }


                    }
                    break;
                case 60 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1185:6: ( 'IndianRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1185:6: ( 'IndianRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1186:1: 'IndianRed'
                    {
                     before(grammarAccess.getColorAccess().getIndianRedKeyword_1_59()); 
                    match(input,72,FOLLOW_72_in_rule__Color__Alternatives_12714); 
                     after(grammarAccess.getColorAccess().getIndianRedKeyword_1_59()); 

                    }


                    }
                    break;
                case 61 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1193:6: ( 'Indigo' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1193:6: ( 'Indigo' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1194:1: 'Indigo'
                    {
                     before(grammarAccess.getColorAccess().getIndigoKeyword_1_60()); 
                    match(input,73,FOLLOW_73_in_rule__Color__Alternatives_12734); 
                     after(grammarAccess.getColorAccess().getIndigoKeyword_1_60()); 

                    }


                    }
                    break;
                case 62 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1201:6: ( 'Ivory' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1201:6: ( 'Ivory' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1202:1: 'Ivory'
                    {
                     before(grammarAccess.getColorAccess().getIvoryKeyword_1_61()); 
                    match(input,74,FOLLOW_74_in_rule__Color__Alternatives_12754); 
                     after(grammarAccess.getColorAccess().getIvoryKeyword_1_61()); 

                    }


                    }
                    break;
                case 63 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1209:6: ( 'Khaki' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1209:6: ( 'Khaki' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1210:1: 'Khaki'
                    {
                     before(grammarAccess.getColorAccess().getKhakiKeyword_1_62()); 
                    match(input,75,FOLLOW_75_in_rule__Color__Alternatives_12774); 
                     after(grammarAccess.getColorAccess().getKhakiKeyword_1_62()); 

                    }


                    }
                    break;
                case 64 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1217:6: ( 'Lavender' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1217:6: ( 'Lavender' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1218:1: 'Lavender'
                    {
                     before(grammarAccess.getColorAccess().getLavenderKeyword_1_63()); 
                    match(input,76,FOLLOW_76_in_rule__Color__Alternatives_12794); 
                     after(grammarAccess.getColorAccess().getLavenderKeyword_1_63()); 

                    }


                    }
                    break;
                case 65 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1225:6: ( 'LavenderBlush' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1225:6: ( 'LavenderBlush' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1226:1: 'LavenderBlush'
                    {
                     before(grammarAccess.getColorAccess().getLavenderBlushKeyword_1_64()); 
                    match(input,77,FOLLOW_77_in_rule__Color__Alternatives_12814); 
                     after(grammarAccess.getColorAccess().getLavenderBlushKeyword_1_64()); 

                    }


                    }
                    break;
                case 66 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1233:6: ( 'LawnGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1233:6: ( 'LawnGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1234:1: 'LawnGreen'
                    {
                     before(grammarAccess.getColorAccess().getLawnGreenKeyword_1_65()); 
                    match(input,78,FOLLOW_78_in_rule__Color__Alternatives_12834); 
                     after(grammarAccess.getColorAccess().getLawnGreenKeyword_1_65()); 

                    }


                    }
                    break;
                case 67 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1241:6: ( 'LemonChiffon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1241:6: ( 'LemonChiffon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1242:1: 'LemonChiffon'
                    {
                     before(grammarAccess.getColorAccess().getLemonChiffonKeyword_1_66()); 
                    match(input,79,FOLLOW_79_in_rule__Color__Alternatives_12854); 
                     after(grammarAccess.getColorAccess().getLemonChiffonKeyword_1_66()); 

                    }


                    }
                    break;
                case 68 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1249:6: ( 'LightBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1249:6: ( 'LightBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1250:1: 'LightBlue'
                    {
                     before(grammarAccess.getColorAccess().getLightBlueKeyword_1_67()); 
                    match(input,80,FOLLOW_80_in_rule__Color__Alternatives_12874); 
                     after(grammarAccess.getColorAccess().getLightBlueKeyword_1_67()); 

                    }


                    }
                    break;
                case 69 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1257:6: ( 'LightCoral' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1257:6: ( 'LightCoral' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1258:1: 'LightCoral'
                    {
                     before(grammarAccess.getColorAccess().getLightCoralKeyword_1_68()); 
                    match(input,81,FOLLOW_81_in_rule__Color__Alternatives_12894); 
                     after(grammarAccess.getColorAccess().getLightCoralKeyword_1_68()); 

                    }


                    }
                    break;
                case 70 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1265:6: ( 'LightCyan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1265:6: ( 'LightCyan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1266:1: 'LightCyan'
                    {
                     before(grammarAccess.getColorAccess().getLightCyanKeyword_1_69()); 
                    match(input,82,FOLLOW_82_in_rule__Color__Alternatives_12914); 
                     after(grammarAccess.getColorAccess().getLightCyanKeyword_1_69()); 

                    }


                    }
                    break;
                case 71 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1273:6: ( 'LightGoldenRodYellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1273:6: ( 'LightGoldenRodYellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1274:1: 'LightGoldenRodYellow'
                    {
                     before(grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_1_70()); 
                    match(input,83,FOLLOW_83_in_rule__Color__Alternatives_12934); 
                     after(grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_1_70()); 

                    }


                    }
                    break;
                case 72 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1281:6: ( 'LightGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1281:6: ( 'LightGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1282:1: 'LightGray'
                    {
                     before(grammarAccess.getColorAccess().getLightGrayKeyword_1_71()); 
                    match(input,84,FOLLOW_84_in_rule__Color__Alternatives_12954); 
                     after(grammarAccess.getColorAccess().getLightGrayKeyword_1_71()); 

                    }


                    }
                    break;
                case 73 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1289:6: ( 'LightGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1289:6: ( 'LightGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1290:1: 'LightGreen'
                    {
                     before(grammarAccess.getColorAccess().getLightGreenKeyword_1_72()); 
                    match(input,85,FOLLOW_85_in_rule__Color__Alternatives_12974); 
                     after(grammarAccess.getColorAccess().getLightGreenKeyword_1_72()); 

                    }


                    }
                    break;
                case 74 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1297:6: ( 'LightGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1297:6: ( 'LightGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1298:1: 'LightGrey'
                    {
                     before(grammarAccess.getColorAccess().getLightGreyKeyword_1_73()); 
                    match(input,86,FOLLOW_86_in_rule__Color__Alternatives_12994); 
                     after(grammarAccess.getColorAccess().getLightGreyKeyword_1_73()); 

                    }


                    }
                    break;
                case 75 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1305:6: ( 'LightPink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1305:6: ( 'LightPink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1306:1: 'LightPink'
                    {
                     before(grammarAccess.getColorAccess().getLightPinkKeyword_1_74()); 
                    match(input,87,FOLLOW_87_in_rule__Color__Alternatives_13014); 
                     after(grammarAccess.getColorAccess().getLightPinkKeyword_1_74()); 

                    }


                    }
                    break;
                case 76 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1313:6: ( 'LightSalmon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1313:6: ( 'LightSalmon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1314:1: 'LightSalmon'
                    {
                     before(grammarAccess.getColorAccess().getLightSalmonKeyword_1_75()); 
                    match(input,88,FOLLOW_88_in_rule__Color__Alternatives_13034); 
                     after(grammarAccess.getColorAccess().getLightSalmonKeyword_1_75()); 

                    }


                    }
                    break;
                case 77 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1321:6: ( 'LightSeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1321:6: ( 'LightSeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1322:1: 'LightSeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getLightSeaGreenKeyword_1_76()); 
                    match(input,89,FOLLOW_89_in_rule__Color__Alternatives_13054); 
                     after(grammarAccess.getColorAccess().getLightSeaGreenKeyword_1_76()); 

                    }


                    }
                    break;
                case 78 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1329:6: ( 'LightSkyBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1329:6: ( 'LightSkyBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1330:1: 'LightSkyBlue'
                    {
                     before(grammarAccess.getColorAccess().getLightSkyBlueKeyword_1_77()); 
                    match(input,90,FOLLOW_90_in_rule__Color__Alternatives_13074); 
                     after(grammarAccess.getColorAccess().getLightSkyBlueKeyword_1_77()); 

                    }


                    }
                    break;
                case 79 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1337:6: ( 'LightSlateGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1337:6: ( 'LightSlateGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1338:1: 'LightSlateGray'
                    {
                     before(grammarAccess.getColorAccess().getLightSlateGrayKeyword_1_78()); 
                    match(input,91,FOLLOW_91_in_rule__Color__Alternatives_13094); 
                     after(grammarAccess.getColorAccess().getLightSlateGrayKeyword_1_78()); 

                    }


                    }
                    break;
                case 80 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1345:6: ( 'LightSlateGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1345:6: ( 'LightSlateGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1346:1: 'LightSlateGrey'
                    {
                     before(grammarAccess.getColorAccess().getLightSlateGreyKeyword_1_79()); 
                    match(input,92,FOLLOW_92_in_rule__Color__Alternatives_13114); 
                     after(grammarAccess.getColorAccess().getLightSlateGreyKeyword_1_79()); 

                    }


                    }
                    break;
                case 81 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1353:6: ( 'LightSteelBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1353:6: ( 'LightSteelBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1354:1: 'LightSteelBlue'
                    {
                     before(grammarAccess.getColorAccess().getLightSteelBlueKeyword_1_80()); 
                    match(input,93,FOLLOW_93_in_rule__Color__Alternatives_13134); 
                     after(grammarAccess.getColorAccess().getLightSteelBlueKeyword_1_80()); 

                    }


                    }
                    break;
                case 82 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1361:6: ( 'LightYellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1361:6: ( 'LightYellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1362:1: 'LightYellow'
                    {
                     before(grammarAccess.getColorAccess().getLightYellowKeyword_1_81()); 
                    match(input,94,FOLLOW_94_in_rule__Color__Alternatives_13154); 
                     after(grammarAccess.getColorAccess().getLightYellowKeyword_1_81()); 

                    }


                    }
                    break;
                case 83 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1369:6: ( 'Lime' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1369:6: ( 'Lime' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1370:1: 'Lime'
                    {
                     before(grammarAccess.getColorAccess().getLimeKeyword_1_82()); 
                    match(input,95,FOLLOW_95_in_rule__Color__Alternatives_13174); 
                     after(grammarAccess.getColorAccess().getLimeKeyword_1_82()); 

                    }


                    }
                    break;
                case 84 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1377:6: ( 'LimeGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1377:6: ( 'LimeGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1378:1: 'LimeGreen'
                    {
                     before(grammarAccess.getColorAccess().getLimeGreenKeyword_1_83()); 
                    match(input,96,FOLLOW_96_in_rule__Color__Alternatives_13194); 
                     after(grammarAccess.getColorAccess().getLimeGreenKeyword_1_83()); 

                    }


                    }
                    break;
                case 85 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1385:6: ( 'Linen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1385:6: ( 'Linen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1386:1: 'Linen'
                    {
                     before(grammarAccess.getColorAccess().getLinenKeyword_1_84()); 
                    match(input,97,FOLLOW_97_in_rule__Color__Alternatives_13214); 
                     after(grammarAccess.getColorAccess().getLinenKeyword_1_84()); 

                    }


                    }
                    break;
                case 86 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1393:6: ( 'Magenta' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1393:6: ( 'Magenta' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1394:1: 'Magenta'
                    {
                     before(grammarAccess.getColorAccess().getMagentaKeyword_1_85()); 
                    match(input,98,FOLLOW_98_in_rule__Color__Alternatives_13234); 
                     after(grammarAccess.getColorAccess().getMagentaKeyword_1_85()); 

                    }


                    }
                    break;
                case 87 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1401:6: ( 'Maroon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1401:6: ( 'Maroon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1402:1: 'Maroon'
                    {
                     before(grammarAccess.getColorAccess().getMaroonKeyword_1_86()); 
                    match(input,99,FOLLOW_99_in_rule__Color__Alternatives_13254); 
                     after(grammarAccess.getColorAccess().getMaroonKeyword_1_86()); 

                    }


                    }
                    break;
                case 88 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1409:6: ( 'MediumAquaMarine' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1409:6: ( 'MediumAquaMarine' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1410:1: 'MediumAquaMarine'
                    {
                     before(grammarAccess.getColorAccess().getMediumAquaMarineKeyword_1_87()); 
                    match(input,100,FOLLOW_100_in_rule__Color__Alternatives_13274); 
                     after(grammarAccess.getColorAccess().getMediumAquaMarineKeyword_1_87()); 

                    }


                    }
                    break;
                case 89 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1417:6: ( 'MediumBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1417:6: ( 'MediumBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1418:1: 'MediumBlue'
                    {
                     before(grammarAccess.getColorAccess().getMediumBlueKeyword_1_88()); 
                    match(input,101,FOLLOW_101_in_rule__Color__Alternatives_13294); 
                     after(grammarAccess.getColorAccess().getMediumBlueKeyword_1_88()); 

                    }


                    }
                    break;
                case 90 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1425:6: ( 'MediumOrchid' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1425:6: ( 'MediumOrchid' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1426:1: 'MediumOrchid'
                    {
                     before(grammarAccess.getColorAccess().getMediumOrchidKeyword_1_89()); 
                    match(input,102,FOLLOW_102_in_rule__Color__Alternatives_13314); 
                     after(grammarAccess.getColorAccess().getMediumOrchidKeyword_1_89()); 

                    }


                    }
                    break;
                case 91 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1433:6: ( 'MediumPurple' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1433:6: ( 'MediumPurple' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1434:1: 'MediumPurple'
                    {
                     before(grammarAccess.getColorAccess().getMediumPurpleKeyword_1_90()); 
                    match(input,103,FOLLOW_103_in_rule__Color__Alternatives_13334); 
                     after(grammarAccess.getColorAccess().getMediumPurpleKeyword_1_90()); 

                    }


                    }
                    break;
                case 92 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1441:6: ( 'MediumSeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1441:6: ( 'MediumSeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1442:1: 'MediumSeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getMediumSeaGreenKeyword_1_91()); 
                    match(input,104,FOLLOW_104_in_rule__Color__Alternatives_13354); 
                     after(grammarAccess.getColorAccess().getMediumSeaGreenKeyword_1_91()); 

                    }


                    }
                    break;
                case 93 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1449:6: ( 'MediumSlateBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1449:6: ( 'MediumSlateBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1450:1: 'MediumSlateBlue'
                    {
                     before(grammarAccess.getColorAccess().getMediumSlateBlueKeyword_1_92()); 
                    match(input,105,FOLLOW_105_in_rule__Color__Alternatives_13374); 
                     after(grammarAccess.getColorAccess().getMediumSlateBlueKeyword_1_92()); 

                    }


                    }
                    break;
                case 94 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1457:6: ( 'MediumSpringGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1457:6: ( 'MediumSpringGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1458:1: 'MediumSpringGreen'
                    {
                     before(grammarAccess.getColorAccess().getMediumSpringGreenKeyword_1_93()); 
                    match(input,106,FOLLOW_106_in_rule__Color__Alternatives_13394); 
                     after(grammarAccess.getColorAccess().getMediumSpringGreenKeyword_1_93()); 

                    }


                    }
                    break;
                case 95 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1465:6: ( 'MediumTurquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1465:6: ( 'MediumTurquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1466:1: 'MediumTurquoise'
                    {
                     before(grammarAccess.getColorAccess().getMediumTurquoiseKeyword_1_94()); 
                    match(input,107,FOLLOW_107_in_rule__Color__Alternatives_13414); 
                     after(grammarAccess.getColorAccess().getMediumTurquoiseKeyword_1_94()); 

                    }


                    }
                    break;
                case 96 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1473:6: ( 'MediumVioletRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1473:6: ( 'MediumVioletRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1474:1: 'MediumVioletRed'
                    {
                     before(grammarAccess.getColorAccess().getMediumVioletRedKeyword_1_95()); 
                    match(input,108,FOLLOW_108_in_rule__Color__Alternatives_13434); 
                     after(grammarAccess.getColorAccess().getMediumVioletRedKeyword_1_95()); 

                    }


                    }
                    break;
                case 97 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1481:6: ( 'MidnightBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1481:6: ( 'MidnightBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1482:1: 'MidnightBlue'
                    {
                     before(grammarAccess.getColorAccess().getMidnightBlueKeyword_1_96()); 
                    match(input,109,FOLLOW_109_in_rule__Color__Alternatives_13454); 
                     after(grammarAccess.getColorAccess().getMidnightBlueKeyword_1_96()); 

                    }


                    }
                    break;
                case 98 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1489:6: ( 'MintCream' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1489:6: ( 'MintCream' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1490:1: 'MintCream'
                    {
                     before(grammarAccess.getColorAccess().getMintCreamKeyword_1_97()); 
                    match(input,110,FOLLOW_110_in_rule__Color__Alternatives_13474); 
                     after(grammarAccess.getColorAccess().getMintCreamKeyword_1_97()); 

                    }


                    }
                    break;
                case 99 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1497:6: ( 'MistyRose' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1497:6: ( 'MistyRose' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1498:1: 'MistyRose'
                    {
                     before(grammarAccess.getColorAccess().getMistyRoseKeyword_1_98()); 
                    match(input,111,FOLLOW_111_in_rule__Color__Alternatives_13494); 
                     after(grammarAccess.getColorAccess().getMistyRoseKeyword_1_98()); 

                    }


                    }
                    break;
                case 100 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1505:6: ( 'Moccasin' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1505:6: ( 'Moccasin' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1506:1: 'Moccasin'
                    {
                     before(grammarAccess.getColorAccess().getMoccasinKeyword_1_99()); 
                    match(input,112,FOLLOW_112_in_rule__Color__Alternatives_13514); 
                     after(grammarAccess.getColorAccess().getMoccasinKeyword_1_99()); 

                    }


                    }
                    break;
                case 101 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1513:6: ( 'NavajoWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1513:6: ( 'NavajoWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1514:1: 'NavajoWhite'
                    {
                     before(grammarAccess.getColorAccess().getNavajoWhiteKeyword_1_100()); 
                    match(input,113,FOLLOW_113_in_rule__Color__Alternatives_13534); 
                     after(grammarAccess.getColorAccess().getNavajoWhiteKeyword_1_100()); 

                    }


                    }
                    break;
                case 102 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1521:6: ( 'Navy' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1521:6: ( 'Navy' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1522:1: 'Navy'
                    {
                     before(grammarAccess.getColorAccess().getNavyKeyword_1_101()); 
                    match(input,114,FOLLOW_114_in_rule__Color__Alternatives_13554); 
                     after(grammarAccess.getColorAccess().getNavyKeyword_1_101()); 

                    }


                    }
                    break;
                case 103 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1529:6: ( 'OldLace' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1529:6: ( 'OldLace' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1530:1: 'OldLace'
                    {
                     before(grammarAccess.getColorAccess().getOldLaceKeyword_1_102()); 
                    match(input,115,FOLLOW_115_in_rule__Color__Alternatives_13574); 
                     after(grammarAccess.getColorAccess().getOldLaceKeyword_1_102()); 

                    }


                    }
                    break;
                case 104 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1537:6: ( 'Olive' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1537:6: ( 'Olive' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1538:1: 'Olive'
                    {
                     before(grammarAccess.getColorAccess().getOliveKeyword_1_103()); 
                    match(input,116,FOLLOW_116_in_rule__Color__Alternatives_13594); 
                     after(grammarAccess.getColorAccess().getOliveKeyword_1_103()); 

                    }


                    }
                    break;
                case 105 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1545:6: ( 'OliveDrab' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1545:6: ( 'OliveDrab' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1546:1: 'OliveDrab'
                    {
                     before(grammarAccess.getColorAccess().getOliveDrabKeyword_1_104()); 
                    match(input,117,FOLLOW_117_in_rule__Color__Alternatives_13614); 
                     after(grammarAccess.getColorAccess().getOliveDrabKeyword_1_104()); 

                    }


                    }
                    break;
                case 106 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1553:6: ( 'OrangeRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1553:6: ( 'OrangeRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1554:1: 'OrangeRed'
                    {
                     before(grammarAccess.getColorAccess().getOrangeRedKeyword_1_105()); 
                    match(input,118,FOLLOW_118_in_rule__Color__Alternatives_13634); 
                     after(grammarAccess.getColorAccess().getOrangeRedKeyword_1_105()); 

                    }


                    }
                    break;
                case 107 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1561:6: ( 'Orchid' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1561:6: ( 'Orchid' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1562:1: 'Orchid'
                    {
                     before(grammarAccess.getColorAccess().getOrchidKeyword_1_106()); 
                    match(input,119,FOLLOW_119_in_rule__Color__Alternatives_13654); 
                     after(grammarAccess.getColorAccess().getOrchidKeyword_1_106()); 

                    }


                    }
                    break;
                case 108 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1569:6: ( 'PaleGoldenRod' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1569:6: ( 'PaleGoldenRod' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1570:1: 'PaleGoldenRod'
                    {
                     before(grammarAccess.getColorAccess().getPaleGoldenRodKeyword_1_107()); 
                    match(input,120,FOLLOW_120_in_rule__Color__Alternatives_13674); 
                     after(grammarAccess.getColorAccess().getPaleGoldenRodKeyword_1_107()); 

                    }


                    }
                    break;
                case 109 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1577:6: ( 'PaleGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1577:6: ( 'PaleGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1578:1: 'PaleGreen'
                    {
                     before(grammarAccess.getColorAccess().getPaleGreenKeyword_1_108()); 
                    match(input,121,FOLLOW_121_in_rule__Color__Alternatives_13694); 
                     after(grammarAccess.getColorAccess().getPaleGreenKeyword_1_108()); 

                    }


                    }
                    break;
                case 110 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1585:6: ( 'PaleTurquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1585:6: ( 'PaleTurquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1586:1: 'PaleTurquoise'
                    {
                     before(grammarAccess.getColorAccess().getPaleTurquoiseKeyword_1_109()); 
                    match(input,122,FOLLOW_122_in_rule__Color__Alternatives_13714); 
                     after(grammarAccess.getColorAccess().getPaleTurquoiseKeyword_1_109()); 

                    }


                    }
                    break;
                case 111 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1593:6: ( 'PaleVioletRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1593:6: ( 'PaleVioletRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1594:1: 'PaleVioletRed'
                    {
                     before(grammarAccess.getColorAccess().getPaleVioletRedKeyword_1_110()); 
                    match(input,123,FOLLOW_123_in_rule__Color__Alternatives_13734); 
                     after(grammarAccess.getColorAccess().getPaleVioletRedKeyword_1_110()); 

                    }


                    }
                    break;
                case 112 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1601:6: ( 'PapayaWhip' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1601:6: ( 'PapayaWhip' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1602:1: 'PapayaWhip'
                    {
                     before(grammarAccess.getColorAccess().getPapayaWhipKeyword_1_111()); 
                    match(input,124,FOLLOW_124_in_rule__Color__Alternatives_13754); 
                     after(grammarAccess.getColorAccess().getPapayaWhipKeyword_1_111()); 

                    }


                    }
                    break;
                case 113 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1609:6: ( 'PeachPuff' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1609:6: ( 'PeachPuff' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1610:1: 'PeachPuff'
                    {
                     before(grammarAccess.getColorAccess().getPeachPuffKeyword_1_112()); 
                    match(input,125,FOLLOW_125_in_rule__Color__Alternatives_13774); 
                     after(grammarAccess.getColorAccess().getPeachPuffKeyword_1_112()); 

                    }


                    }
                    break;
                case 114 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1617:6: ( 'Peru' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1617:6: ( 'Peru' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1618:1: 'Peru'
                    {
                     before(grammarAccess.getColorAccess().getPeruKeyword_1_113()); 
                    match(input,126,FOLLOW_126_in_rule__Color__Alternatives_13794); 
                     after(grammarAccess.getColorAccess().getPeruKeyword_1_113()); 

                    }


                    }
                    break;
                case 115 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1625:6: ( 'Pink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1625:6: ( 'Pink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1626:1: 'Pink'
                    {
                     before(grammarAccess.getColorAccess().getPinkKeyword_1_114()); 
                    match(input,127,FOLLOW_127_in_rule__Color__Alternatives_13814); 
                     after(grammarAccess.getColorAccess().getPinkKeyword_1_114()); 

                    }


                    }
                    break;
                case 116 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1633:6: ( 'Plum' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1633:6: ( 'Plum' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1634:1: 'Plum'
                    {
                     before(grammarAccess.getColorAccess().getPlumKeyword_1_115()); 
                    match(input,128,FOLLOW_128_in_rule__Color__Alternatives_13834); 
                     after(grammarAccess.getColorAccess().getPlumKeyword_1_115()); 

                    }


                    }
                    break;
                case 117 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1641:6: ( 'PowderBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1641:6: ( 'PowderBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1642:1: 'PowderBlue'
                    {
                     before(grammarAccess.getColorAccess().getPowderBlueKeyword_1_116()); 
                    match(input,129,FOLLOW_129_in_rule__Color__Alternatives_13854); 
                     after(grammarAccess.getColorAccess().getPowderBlueKeyword_1_116()); 

                    }


                    }
                    break;
                case 118 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1649:6: ( 'Purple' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1649:6: ( 'Purple' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1650:1: 'Purple'
                    {
                     before(grammarAccess.getColorAccess().getPurpleKeyword_1_117()); 
                    match(input,130,FOLLOW_130_in_rule__Color__Alternatives_13874); 
                     after(grammarAccess.getColorAccess().getPurpleKeyword_1_117()); 

                    }


                    }
                    break;
                case 119 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1657:6: ( 'Red' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1657:6: ( 'Red' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1658:1: 'Red'
                    {
                     before(grammarAccess.getColorAccess().getRedKeyword_1_118()); 
                    match(input,131,FOLLOW_131_in_rule__Color__Alternatives_13894); 
                     after(grammarAccess.getColorAccess().getRedKeyword_1_118()); 

                    }


                    }
                    break;
                case 120 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1665:6: ( 'RosyBrown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1665:6: ( 'RosyBrown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1666:1: 'RosyBrown'
                    {
                     before(grammarAccess.getColorAccess().getRosyBrownKeyword_1_119()); 
                    match(input,132,FOLLOW_132_in_rule__Color__Alternatives_13914); 
                     after(grammarAccess.getColorAccess().getRosyBrownKeyword_1_119()); 

                    }


                    }
                    break;
                case 121 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1673:6: ( 'RoyalBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1673:6: ( 'RoyalBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1674:1: 'RoyalBlue'
                    {
                     before(grammarAccess.getColorAccess().getRoyalBlueKeyword_1_120()); 
                    match(input,133,FOLLOW_133_in_rule__Color__Alternatives_13934); 
                     after(grammarAccess.getColorAccess().getRoyalBlueKeyword_1_120()); 

                    }


                    }
                    break;
                case 122 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1681:6: ( 'SaddleBrown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1681:6: ( 'SaddleBrown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1682:1: 'SaddleBrown'
                    {
                     before(grammarAccess.getColorAccess().getSaddleBrownKeyword_1_121()); 
                    match(input,134,FOLLOW_134_in_rule__Color__Alternatives_13954); 
                     after(grammarAccess.getColorAccess().getSaddleBrownKeyword_1_121()); 

                    }


                    }
                    break;
                case 123 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1689:6: ( 'Salmon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1689:6: ( 'Salmon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1690:1: 'Salmon'
                    {
                     before(grammarAccess.getColorAccess().getSalmonKeyword_1_122()); 
                    match(input,135,FOLLOW_135_in_rule__Color__Alternatives_13974); 
                     after(grammarAccess.getColorAccess().getSalmonKeyword_1_122()); 

                    }


                    }
                    break;
                case 124 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1697:6: ( 'SandyBrown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1697:6: ( 'SandyBrown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1698:1: 'SandyBrown'
                    {
                     before(grammarAccess.getColorAccess().getSandyBrownKeyword_1_123()); 
                    match(input,136,FOLLOW_136_in_rule__Color__Alternatives_13994); 
                     after(grammarAccess.getColorAccess().getSandyBrownKeyword_1_123()); 

                    }


                    }
                    break;
                case 125 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1705:6: ( 'SeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1705:6: ( 'SeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1706:1: 'SeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getSeaGreenKeyword_1_124()); 
                    match(input,137,FOLLOW_137_in_rule__Color__Alternatives_14014); 
                     after(grammarAccess.getColorAccess().getSeaGreenKeyword_1_124()); 

                    }


                    }
                    break;
                case 126 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1713:6: ( 'Sienna' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1713:6: ( 'Sienna' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1714:1: 'Sienna'
                    {
                     before(grammarAccess.getColorAccess().getSiennaKeyword_1_125()); 
                    match(input,138,FOLLOW_138_in_rule__Color__Alternatives_14034); 
                     after(grammarAccess.getColorAccess().getSiennaKeyword_1_125()); 

                    }


                    }
                    break;
                case 127 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1721:6: ( 'Silver' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1721:6: ( 'Silver' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1722:1: 'Silver'
                    {
                     before(grammarAccess.getColorAccess().getSilverKeyword_1_126()); 
                    match(input,139,FOLLOW_139_in_rule__Color__Alternatives_14054); 
                     after(grammarAccess.getColorAccess().getSilverKeyword_1_126()); 

                    }


                    }
                    break;
                case 128 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1729:6: ( 'SkyBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1729:6: ( 'SkyBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1730:1: 'SkyBlue'
                    {
                     before(grammarAccess.getColorAccess().getSkyBlueKeyword_1_127()); 
                    match(input,140,FOLLOW_140_in_rule__Color__Alternatives_14074); 
                     after(grammarAccess.getColorAccess().getSkyBlueKeyword_1_127()); 

                    }


                    }
                    break;
                case 129 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1737:6: ( 'SlateBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1737:6: ( 'SlateBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1738:1: 'SlateBlue'
                    {
                     before(grammarAccess.getColorAccess().getSlateBlueKeyword_1_128()); 
                    match(input,141,FOLLOW_141_in_rule__Color__Alternatives_14094); 
                     after(grammarAccess.getColorAccess().getSlateBlueKeyword_1_128()); 

                    }


                    }
                    break;
                case 130 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1745:6: ( 'SlateGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1745:6: ( 'SlateGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1746:1: 'SlateGray'
                    {
                     before(grammarAccess.getColorAccess().getSlateGrayKeyword_1_129()); 
                    match(input,142,FOLLOW_142_in_rule__Color__Alternatives_14114); 
                     after(grammarAccess.getColorAccess().getSlateGrayKeyword_1_129()); 

                    }


                    }
                    break;
                case 131 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1753:6: ( 'SlateGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1753:6: ( 'SlateGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1754:1: 'SlateGrey'
                    {
                     before(grammarAccess.getColorAccess().getSlateGreyKeyword_1_130()); 
                    match(input,143,FOLLOW_143_in_rule__Color__Alternatives_14134); 
                     after(grammarAccess.getColorAccess().getSlateGreyKeyword_1_130()); 

                    }


                    }
                    break;
                case 132 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1761:6: ( 'Snow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1761:6: ( 'Snow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1762:1: 'Snow'
                    {
                     before(grammarAccess.getColorAccess().getSnowKeyword_1_131()); 
                    match(input,144,FOLLOW_144_in_rule__Color__Alternatives_14154); 
                     after(grammarAccess.getColorAccess().getSnowKeyword_1_131()); 

                    }


                    }
                    break;
                case 133 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1769:6: ( 'SpringGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1769:6: ( 'SpringGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1770:1: 'SpringGreen'
                    {
                     before(grammarAccess.getColorAccess().getSpringGreenKeyword_1_132()); 
                    match(input,145,FOLLOW_145_in_rule__Color__Alternatives_14174); 
                     after(grammarAccess.getColorAccess().getSpringGreenKeyword_1_132()); 

                    }


                    }
                    break;
                case 134 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1777:6: ( 'SteelBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1777:6: ( 'SteelBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1778:1: 'SteelBlue'
                    {
                     before(grammarAccess.getColorAccess().getSteelBlueKeyword_1_133()); 
                    match(input,146,FOLLOW_146_in_rule__Color__Alternatives_14194); 
                     after(grammarAccess.getColorAccess().getSteelBlueKeyword_1_133()); 

                    }


                    }
                    break;
                case 135 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1785:6: ( 'Tan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1785:6: ( 'Tan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1786:1: 'Tan'
                    {
                     before(grammarAccess.getColorAccess().getTanKeyword_1_134()); 
                    match(input,147,FOLLOW_147_in_rule__Color__Alternatives_14214); 
                     after(grammarAccess.getColorAccess().getTanKeyword_1_134()); 

                    }


                    }
                    break;
                case 136 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1793:6: ( 'Teal' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1793:6: ( 'Teal' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1794:1: 'Teal'
                    {
                     before(grammarAccess.getColorAccess().getTealKeyword_1_135()); 
                    match(input,148,FOLLOW_148_in_rule__Color__Alternatives_14234); 
                     after(grammarAccess.getColorAccess().getTealKeyword_1_135()); 

                    }


                    }
                    break;
                case 137 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1801:6: ( 'Thistle' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1801:6: ( 'Thistle' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1802:1: 'Thistle'
                    {
                     before(grammarAccess.getColorAccess().getThistleKeyword_1_136()); 
                    match(input,149,FOLLOW_149_in_rule__Color__Alternatives_14254); 
                     after(grammarAccess.getColorAccess().getThistleKeyword_1_136()); 

                    }


                    }
                    break;
                case 138 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1809:6: ( 'Tomato' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1809:6: ( 'Tomato' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1810:1: 'Tomato'
                    {
                     before(grammarAccess.getColorAccess().getTomatoKeyword_1_137()); 
                    match(input,150,FOLLOW_150_in_rule__Color__Alternatives_14274); 
                     after(grammarAccess.getColorAccess().getTomatoKeyword_1_137()); 

                    }


                    }
                    break;
                case 139 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1817:6: ( 'Turquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1817:6: ( 'Turquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1818:1: 'Turquoise'
                    {
                     before(grammarAccess.getColorAccess().getTurquoiseKeyword_1_138()); 
                    match(input,151,FOLLOW_151_in_rule__Color__Alternatives_14294); 
                     after(grammarAccess.getColorAccess().getTurquoiseKeyword_1_138()); 

                    }


                    }
                    break;
                case 140 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1825:6: ( 'Violet' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1825:6: ( 'Violet' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1826:1: 'Violet'
                    {
                     before(grammarAccess.getColorAccess().getVioletKeyword_1_139()); 
                    match(input,152,FOLLOW_152_in_rule__Color__Alternatives_14314); 
                     after(grammarAccess.getColorAccess().getVioletKeyword_1_139()); 

                    }


                    }
                    break;
                case 141 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1833:6: ( 'Wheat' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1833:6: ( 'Wheat' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1834:1: 'Wheat'
                    {
                     before(grammarAccess.getColorAccess().getWheatKeyword_1_140()); 
                    match(input,153,FOLLOW_153_in_rule__Color__Alternatives_14334); 
                     after(grammarAccess.getColorAccess().getWheatKeyword_1_140()); 

                    }


                    }
                    break;
                case 142 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1841:6: ( 'White' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1841:6: ( 'White' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1842:1: 'White'
                    {
                     before(grammarAccess.getColorAccess().getWhiteKeyword_1_141()); 
                    match(input,154,FOLLOW_154_in_rule__Color__Alternatives_14354); 
                     after(grammarAccess.getColorAccess().getWhiteKeyword_1_141()); 

                    }


                    }
                    break;
                case 143 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1849:6: ( 'WhiteSmoke' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1849:6: ( 'WhiteSmoke' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1850:1: 'WhiteSmoke'
                    {
                     before(grammarAccess.getColorAccess().getWhiteSmokeKeyword_1_142()); 
                    match(input,155,FOLLOW_155_in_rule__Color__Alternatives_14374); 
                     after(grammarAccess.getColorAccess().getWhiteSmokeKeyword_1_142()); 

                    }


                    }
                    break;
                case 144 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1857:6: ( 'Yellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1857:6: ( 'Yellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1858:1: 'Yellow'
                    {
                     before(grammarAccess.getColorAccess().getYellowKeyword_1_143()); 
                    match(input,156,FOLLOW_156_in_rule__Color__Alternatives_14394); 
                     after(grammarAccess.getColorAccess().getYellowKeyword_1_143()); 

                    }


                    }
                    break;
                case 145 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1865:6: ( 'YellowGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1865:6: ( 'YellowGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1866:1: 'YellowGreen'
                    {
                     before(grammarAccess.getColorAccess().getYellowGreenKeyword_1_144()); 
                    match(input,157,FOLLOW_157_in_rule__Color__Alternatives_14414); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1878:1: rule__Legend__Alternatives_1 : ( ( 'right' ) | ( 'left' ) | ( 'center' ) );
    public final void rule__Legend__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1882:1: ( ( 'right' ) | ( 'left' ) | ( 'center' ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 158:
                {
                alt5=1;
                }
                break;
            case 159:
                {
                alt5=2;
                }
                break;
            case 160:
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1883:1: ( 'right' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1883:1: ( 'right' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1884:1: 'right'
                    {
                     before(grammarAccess.getLegendAccess().getRightKeyword_1_0()); 
                    match(input,158,FOLLOW_158_in_rule__Legend__Alternatives_14449); 
                     after(grammarAccess.getLegendAccess().getRightKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1891:6: ( 'left' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1891:6: ( 'left' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1892:1: 'left'
                    {
                     before(grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 
                    match(input,159,FOLLOW_159_in_rule__Legend__Alternatives_14469); 
                     after(grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1899:6: ( 'center' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1899:6: ( 'center' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1900:1: 'center'
                    {
                     before(grammarAccess.getLegendAccess().getCenterKeyword_1_2()); 
                    match(input,160,FOLLOW_160_in_rule__Legend__Alternatives_14489); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1912:1: rule__Legend__Alternatives_2 : ( ( ( rule__Legend__Group_2_0__0 ) ) | ( RULE_NEWLINE ) );
    public final void rule__Legend__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1916:1: ( ( ( rule__Legend__Group_2_0__0 ) ) | ( RULE_NEWLINE ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_NEWLINE) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==RULE_NEWLINE) ) {
                    alt6=2;
                }
                else if ( (LA6_1==RULE_ID) ) {
                    alt6=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1917:1: ( ( rule__Legend__Group_2_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1917:1: ( ( rule__Legend__Group_2_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1918:1: ( rule__Legend__Group_2_0__0 )
                    {
                     before(grammarAccess.getLegendAccess().getGroup_2_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1919:1: ( rule__Legend__Group_2_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1919:2: rule__Legend__Group_2_0__0
                    {
                    pushFollow(FOLLOW_rule__Legend__Group_2_0__0_in_rule__Legend__Alternatives_24523);
                    rule__Legend__Group_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLegendAccess().getGroup_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1923:6: ( RULE_NEWLINE )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1923:6: ( RULE_NEWLINE )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1924:1: RULE_NEWLINE
                    {
                     before(grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_1()); 
                    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Legend__Alternatives_24541); 
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


    // $ANTLR start "rule__GroupingMessages__Alternatives_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1934:1: rule__GroupingMessages__Alternatives_0 : ( ( 'opt' ) | ( 'loop' ) | ( 'par' ) | ( 'break' ) | ( 'critical' ) );
    public final void rule__GroupingMessages__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1938:1: ( ( 'opt' ) | ( 'loop' ) | ( 'par' ) | ( 'break' ) | ( 'critical' ) )
            int alt7=5;
            switch ( input.LA(1) ) {
            case 161:
                {
                alt7=1;
                }
                break;
            case 162:
                {
                alt7=2;
                }
                break;
            case 163:
                {
                alt7=3;
                }
                break;
            case 164:
                {
                alt7=4;
                }
                break;
            case 165:
                {
                alt7=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1939:1: ( 'opt' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1939:1: ( 'opt' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1940:1: 'opt'
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getOptKeyword_0_0()); 
                    match(input,161,FOLLOW_161_in_rule__GroupingMessages__Alternatives_04574); 
                     after(grammarAccess.getGroupingMessagesAccess().getOptKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1947:6: ( 'loop' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1947:6: ( 'loop' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1948:1: 'loop'
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getLoopKeyword_0_1()); 
                    match(input,162,FOLLOW_162_in_rule__GroupingMessages__Alternatives_04594); 
                     after(grammarAccess.getGroupingMessagesAccess().getLoopKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1955:6: ( 'par' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1955:6: ( 'par' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1956:1: 'par'
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getParKeyword_0_2()); 
                    match(input,163,FOLLOW_163_in_rule__GroupingMessages__Alternatives_04614); 
                     after(grammarAccess.getGroupingMessagesAccess().getParKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1963:6: ( 'break' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1963:6: ( 'break' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1964:1: 'break'
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getBreakKeyword_0_3()); 
                    match(input,164,FOLLOW_164_in_rule__GroupingMessages__Alternatives_04634); 
                     after(grammarAccess.getGroupingMessagesAccess().getBreakKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1971:6: ( 'critical' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1971:6: ( 'critical' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1972:1: 'critical'
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getCriticalKeyword_0_4()); 
                    match(input,165,FOLLOW_165_in_rule__GroupingMessages__Alternatives_04654); 
                     after(grammarAccess.getGroupingMessagesAccess().getCriticalKeyword_0_4()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1984:1: rule__Note__Alternatives_1 : ( ( ( rule__Note__Group_1_0__0 ) ) | ( ( rule__Note__Group_1_1__0 ) ) | ( ( rule__Note__Group_1_2__0 ) ) );
    public final void rule__Note__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1988:1: ( ( ( rule__Note__Group_1_0__0 ) ) | ( ( rule__Note__Group_1_1__0 ) ) | ( ( rule__Note__Group_1_2__0 ) ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 158:
                {
                alt8=1;
                }
                break;
            case 159:
                {
                alt8=2;
                }
                break;
            case 188:
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1989:1: ( ( rule__Note__Group_1_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1989:1: ( ( rule__Note__Group_1_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1990:1: ( rule__Note__Group_1_0__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_1_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1991:1: ( rule__Note__Group_1_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1991:2: rule__Note__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_0__0_in_rule__Note__Alternatives_14688);
                    rule__Note__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNoteAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1995:6: ( ( rule__Note__Group_1_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1995:6: ( ( rule__Note__Group_1_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1996:1: ( rule__Note__Group_1_1__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_1_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1997:1: ( rule__Note__Group_1_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1997:2: rule__Note__Group_1_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_1__0_in_rule__Note__Alternatives_14706);
                    rule__Note__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNoteAccess().getGroup_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2001:6: ( ( rule__Note__Group_1_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2001:6: ( ( rule__Note__Group_1_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2002:1: ( rule__Note__Group_1_2__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_1_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2003:1: ( rule__Note__Group_1_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2003:2: rule__Note__Group_1_2__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_2__0_in_rule__Note__Alternatives_14724);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2012:1: rule__Note__Alternatives_3 : ( ( ( rule__Note__Group_3_0__0 ) ) | ( ( rule__Note__Group_3_1__0 ) ) );
    public final void rule__Note__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2016:1: ( ( ( rule__Note__Group_3_0__0 ) ) | ( ( rule__Note__Group_3_1__0 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==169) ) {
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2017:1: ( ( rule__Note__Group_3_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2017:1: ( ( rule__Note__Group_3_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2018:1: ( rule__Note__Group_3_0__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_3_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2019:1: ( rule__Note__Group_3_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2019:2: rule__Note__Group_3_0__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_3_0__0_in_rule__Note__Alternatives_34757);
                    rule__Note__Group_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNoteAccess().getGroup_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2023:6: ( ( rule__Note__Group_3_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2023:6: ( ( rule__Note__Group_3_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2024:1: ( rule__Note__Group_3_1__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_3_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2025:1: ( rule__Note__Group_3_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2025:2: rule__Note__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_3_1__0_in_rule__Note__Alternatives_34775);
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


    // $ANTLR start "rule__Reference__Alternatives_3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2034:1: rule__Reference__Alternatives_3 : ( ( ( rule__Reference__Group_3_0__0 ) ) | ( ( rule__Reference__Group_3_1__0 ) ) );
    public final void rule__Reference__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2038:1: ( ( ( rule__Reference__Group_3_0__0 ) ) | ( ( rule__Reference__Group_3_1__0 ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==169) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_NEWLINE) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2039:1: ( ( rule__Reference__Group_3_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2039:1: ( ( rule__Reference__Group_3_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2040:1: ( rule__Reference__Group_3_0__0 )
                    {
                     before(grammarAccess.getReferenceAccess().getGroup_3_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2041:1: ( rule__Reference__Group_3_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2041:2: rule__Reference__Group_3_0__0
                    {
                    pushFollow(FOLLOW_rule__Reference__Group_3_0__0_in_rule__Reference__Alternatives_34808);
                    rule__Reference__Group_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getReferenceAccess().getGroup_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2045:6: ( ( rule__Reference__Group_3_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2045:6: ( ( rule__Reference__Group_3_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2046:1: ( rule__Reference__Group_3_1__0 )
                    {
                     before(grammarAccess.getReferenceAccess().getGroup_3_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2047:1: ( rule__Reference__Group_3_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2047:2: rule__Reference__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__Reference__Group_3_1__0_in_rule__Reference__Alternatives_34826);
                    rule__Reference__Group_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getReferenceAccess().getGroup_3_1()); 

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
    // $ANTLR end "rule__Reference__Alternatives_3"


    // $ANTLR start "rule__Space__Alternatives"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2056:1: rule__Space__Alternatives : ( ( '|||' ) | ( ( rule__Space__Group_1__0 ) ) );
    public final void rule__Space__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2060:1: ( ( '|||' ) | ( ( rule__Space__Group_1__0 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==166) ) {
                alt11=1;
            }
            else if ( (LA11_0==194) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2061:1: ( '|||' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2061:1: ( '|||' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2062:1: '|||'
                    {
                     before(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineVerticalLineKeyword_0()); 
                    match(input,166,FOLLOW_166_in_rule__Space__Alternatives4860); 
                     after(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineVerticalLineKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2069:6: ( ( rule__Space__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2069:6: ( ( rule__Space__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2070:1: ( rule__Space__Group_1__0 )
                    {
                     before(grammarAccess.getSpaceAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2071:1: ( rule__Space__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2071:2: rule__Space__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Space__Group_1__0_in_rule__Space__Alternatives4879);
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


    // $ANTLR start "rule__Diagram__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2082:1: rule__Diagram__Group__0 : rule__Diagram__Group__0__Impl rule__Diagram__Group__1 ;
    public final void rule__Diagram__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2086:1: ( rule__Diagram__Group__0__Impl rule__Diagram__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2087:2: rule__Diagram__Group__0__Impl rule__Diagram__Group__1
            {
            pushFollow(FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__04910);
            rule__Diagram__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__04913);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2094:1: rule__Diagram__Group__0__Impl : ( '@startuml' ) ;
    public final void rule__Diagram__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2098:1: ( ( '@startuml' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2099:1: ( '@startuml' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2099:1: ( '@startuml' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2100:1: '@startuml'
            {
             before(grammarAccess.getDiagramAccess().getStartumlKeyword_0()); 
            match(input,167,FOLLOW_167_in_rule__Diagram__Group__0__Impl4941); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2113:1: rule__Diagram__Group__1 : rule__Diagram__Group__1__Impl rule__Diagram__Group__2 ;
    public final void rule__Diagram__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2117:1: ( rule__Diagram__Group__1__Impl rule__Diagram__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2118:2: rule__Diagram__Group__1__Impl rule__Diagram__Group__2
            {
            pushFollow(FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__14972);
            rule__Diagram__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__14975);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2125:1: rule__Diagram__Group__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Diagram__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2129:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2130:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2130:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2131:1: RULE_NEWLINE
            {
             before(grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__1__Impl5002); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2142:1: rule__Diagram__Group__2 : rule__Diagram__Group__2__Impl rule__Diagram__Group__3 ;
    public final void rule__Diagram__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2146:1: ( rule__Diagram__Group__2__Impl rule__Diagram__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2147:2: rule__Diagram__Group__2__Impl rule__Diagram__Group__3
            {
            pushFollow(FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__25031);
            rule__Diagram__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__3_in_rule__Diagram__Group__25034);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2154:1: rule__Diagram__Group__2__Impl : ( ( rule__Diagram__InstructionsAssignment_2 )* ) ;
    public final void rule__Diagram__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2158:1: ( ( ( rule__Diagram__InstructionsAssignment_2 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2159:1: ( ( rule__Diagram__InstructionsAssignment_2 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2159:1: ( ( rule__Diagram__InstructionsAssignment_2 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2160:1: ( rule__Diagram__InstructionsAssignment_2 )*
            {
             before(grammarAccess.getDiagramAccess().getInstructionsAssignment_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2161:1: ( rule__Diagram__InstructionsAssignment_2 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_NEWLINE||LA12_0==RULE_ID||LA12_0==12||(LA12_0>=161 && LA12_0<=166)||(LA12_0>=170 && LA12_0<=176)||(LA12_0>=178 && LA12_0<=179)||(LA12_0>=181 && LA12_0<=182)||LA12_0==185||(LA12_0>=190 && LA12_0<=191)||(LA12_0>=193 && LA12_0<=194)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2161:2: rule__Diagram__InstructionsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Diagram__InstructionsAssignment_2_in_rule__Diagram__Group__2__Impl5061);
            	    rule__Diagram__InstructionsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2171:1: rule__Diagram__Group__3 : rule__Diagram__Group__3__Impl ;
    public final void rule__Diagram__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2175:1: ( rule__Diagram__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2176:2: rule__Diagram__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Diagram__Group__3__Impl_in_rule__Diagram__Group__35092);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2182:1: rule__Diagram__Group__3__Impl : ( '@enduml' ) ;
    public final void rule__Diagram__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2186:1: ( ( '@enduml' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2187:1: ( '@enduml' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2187:1: ( '@enduml' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2188:1: '@enduml'
            {
             before(grammarAccess.getDiagramAccess().getEndumlKeyword_3()); 
            match(input,168,FOLLOW_168_in_rule__Diagram__Group__3__Impl5120); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2209:1: rule__Instruction__Group__0 : rule__Instruction__Group__0__Impl rule__Instruction__Group__1 ;
    public final void rule__Instruction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2213:1: ( rule__Instruction__Group__0__Impl rule__Instruction__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2214:2: rule__Instruction__Group__0__Impl rule__Instruction__Group__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group__0__Impl_in_rule__Instruction__Group__05159);
            rule__Instruction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group__1_in_rule__Instruction__Group__05162);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2221:1: rule__Instruction__Group__0__Impl : ( ( rule__Instruction__Alternatives_0 )? ) ;
    public final void rule__Instruction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2225:1: ( ( ( rule__Instruction__Alternatives_0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2226:1: ( ( rule__Instruction__Alternatives_0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2226:1: ( ( rule__Instruction__Alternatives_0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2227:1: ( rule__Instruction__Alternatives_0 )?
            {
             before(grammarAccess.getInstructionAccess().getAlternatives_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2228:1: ( rule__Instruction__Alternatives_0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID||LA13_0==12||(LA13_0>=161 && LA13_0<=166)||(LA13_0>=170 && LA13_0<=176)||(LA13_0>=178 && LA13_0<=179)||(LA13_0>=181 && LA13_0<=182)||LA13_0==185||(LA13_0>=190 && LA13_0<=191)||(LA13_0>=193 && LA13_0<=194)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2228:2: rule__Instruction__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Alternatives_0_in_rule__Instruction__Group__0__Impl5189);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2238:1: rule__Instruction__Group__1 : rule__Instruction__Group__1__Impl ;
    public final void rule__Instruction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2242:1: ( rule__Instruction__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2243:2: rule__Instruction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group__1__Impl_in_rule__Instruction__Group__15220);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2249:1: rule__Instruction__Group__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Instruction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2253:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2254:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2254:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2255:1: RULE_NEWLINE
            {
             before(grammarAccess.getInstructionAccess().getNEWLINETerminalRuleCall_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Instruction__Group__1__Impl5247); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2270:1: rule__Instruction__Group_0_0__0 : rule__Instruction__Group_0_0__0__Impl rule__Instruction__Group_0_0__1 ;
    public final void rule__Instruction__Group_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2274:1: ( rule__Instruction__Group_0_0__0__Impl rule__Instruction__Group_0_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2275:2: rule__Instruction__Group_0_0__0__Impl rule__Instruction__Group_0_0__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_0__0__Impl_in_rule__Instruction__Group_0_0__05280);
            rule__Instruction__Group_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_0__1_in_rule__Instruction__Group_0_0__05283);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2282:1: rule__Instruction__Group_0_0__0__Impl : ( ( rule__Instruction__Name1Assignment_0_0_0 ) ) ;
    public final void rule__Instruction__Group_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2286:1: ( ( ( rule__Instruction__Name1Assignment_0_0_0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2287:1: ( ( rule__Instruction__Name1Assignment_0_0_0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2287:1: ( ( rule__Instruction__Name1Assignment_0_0_0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2288:1: ( rule__Instruction__Name1Assignment_0_0_0 )
            {
             before(grammarAccess.getInstructionAccess().getName1Assignment_0_0_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2289:1: ( rule__Instruction__Name1Assignment_0_0_0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2289:2: rule__Instruction__Name1Assignment_0_0_0
            {
            pushFollow(FOLLOW_rule__Instruction__Name1Assignment_0_0_0_in_rule__Instruction__Group_0_0__0__Impl5310);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2299:1: rule__Instruction__Group_0_0__1 : rule__Instruction__Group_0_0__1__Impl rule__Instruction__Group_0_0__2 ;
    public final void rule__Instruction__Group_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2303:1: ( rule__Instruction__Group_0_0__1__Impl rule__Instruction__Group_0_0__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2304:2: rule__Instruction__Group_0_0__1__Impl rule__Instruction__Group_0_0__2
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_0__1__Impl_in_rule__Instruction__Group_0_0__15340);
            rule__Instruction__Group_0_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_0__2_in_rule__Instruction__Group_0_0__15343);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2311:1: rule__Instruction__Group_0_0__1__Impl : ( RULE_SEQUENCE ) ;
    public final void rule__Instruction__Group_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2315:1: ( ( RULE_SEQUENCE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2316:1: ( RULE_SEQUENCE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2316:1: ( RULE_SEQUENCE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2317:1: RULE_SEQUENCE
            {
             before(grammarAccess.getInstructionAccess().getSEQUENCETerminalRuleCall_0_0_1()); 
            match(input,RULE_SEQUENCE,FOLLOW_RULE_SEQUENCE_in_rule__Instruction__Group_0_0__1__Impl5370); 
             after(grammarAccess.getInstructionAccess().getSEQUENCETerminalRuleCall_0_0_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2328:1: rule__Instruction__Group_0_0__2 : rule__Instruction__Group_0_0__2__Impl rule__Instruction__Group_0_0__3 ;
    public final void rule__Instruction__Group_0_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2332:1: ( rule__Instruction__Group_0_0__2__Impl rule__Instruction__Group_0_0__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2333:2: rule__Instruction__Group_0_0__2__Impl rule__Instruction__Group_0_0__3
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_0__2__Impl_in_rule__Instruction__Group_0_0__25399);
            rule__Instruction__Group_0_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_0__3_in_rule__Instruction__Group_0_0__25402);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2340:1: rule__Instruction__Group_0_0__2__Impl : ( ( rule__Instruction__Name2Assignment_0_0_2 ) ) ;
    public final void rule__Instruction__Group_0_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2344:1: ( ( ( rule__Instruction__Name2Assignment_0_0_2 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2345:1: ( ( rule__Instruction__Name2Assignment_0_0_2 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2345:1: ( ( rule__Instruction__Name2Assignment_0_0_2 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2346:1: ( rule__Instruction__Name2Assignment_0_0_2 )
            {
             before(grammarAccess.getInstructionAccess().getName2Assignment_0_0_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2347:1: ( rule__Instruction__Name2Assignment_0_0_2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2347:2: rule__Instruction__Name2Assignment_0_0_2
            {
            pushFollow(FOLLOW_rule__Instruction__Name2Assignment_0_0_2_in_rule__Instruction__Group_0_0__2__Impl5429);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2357:1: rule__Instruction__Group_0_0__3 : rule__Instruction__Group_0_0__3__Impl ;
    public final void rule__Instruction__Group_0_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2361:1: ( rule__Instruction__Group_0_0__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2362:2: rule__Instruction__Group_0_0__3__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_0__3__Impl_in_rule__Instruction__Group_0_0__35459);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2368:1: rule__Instruction__Group_0_0__3__Impl : ( ( rule__Instruction__Group_0_0_3__0 )? ) ;
    public final void rule__Instruction__Group_0_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2372:1: ( ( ( rule__Instruction__Group_0_0_3__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2373:1: ( ( rule__Instruction__Group_0_0_3__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2373:1: ( ( rule__Instruction__Group_0_0_3__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2374:1: ( rule__Instruction__Group_0_0_3__0 )?
            {
             before(grammarAccess.getInstructionAccess().getGroup_0_0_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2375:1: ( rule__Instruction__Group_0_0_3__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==169) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2375:2: rule__Instruction__Group_0_0_3__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_0_0_3__0_in_rule__Instruction__Group_0_0__3__Impl5486);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2393:1: rule__Instruction__Group_0_0_3__0 : rule__Instruction__Group_0_0_3__0__Impl rule__Instruction__Group_0_0_3__1 ;
    public final void rule__Instruction__Group_0_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2397:1: ( rule__Instruction__Group_0_0_3__0__Impl rule__Instruction__Group_0_0_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2398:2: rule__Instruction__Group_0_0_3__0__Impl rule__Instruction__Group_0_0_3__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_0_3__0__Impl_in_rule__Instruction__Group_0_0_3__05525);
            rule__Instruction__Group_0_0_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_0_3__1_in_rule__Instruction__Group_0_0_3__05528);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2405:1: rule__Instruction__Group_0_0_3__0__Impl : ( ':' ) ;
    public final void rule__Instruction__Group_0_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2409:1: ( ( ':' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2410:1: ( ':' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2410:1: ( ':' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2411:1: ':'
            {
             before(grammarAccess.getInstructionAccess().getColonKeyword_0_0_3_0()); 
            match(input,169,FOLLOW_169_in_rule__Instruction__Group_0_0_3__0__Impl5556); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2424:1: rule__Instruction__Group_0_0_3__1 : rule__Instruction__Group_0_0_3__1__Impl ;
    public final void rule__Instruction__Group_0_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2428:1: ( rule__Instruction__Group_0_0_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2429:2: rule__Instruction__Group_0_0_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_0_3__1__Impl_in_rule__Instruction__Group_0_0_3__15587);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2435:1: rule__Instruction__Group_0_0_3__1__Impl : ( RULE_ID ) ;
    public final void rule__Instruction__Group_0_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2439:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2440:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2440:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2441:1: RULE_ID
            {
             before(grammarAccess.getInstructionAccess().getIDTerminalRuleCall_0_0_3_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Instruction__Group_0_0_3__1__Impl5614); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2456:1: rule__Instruction__Group_0_1__0 : rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1 ;
    public final void rule__Instruction__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2460:1: ( rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2461:2: rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_1__0__Impl_in_rule__Instruction__Group_0_1__05647);
            rule__Instruction__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_1__1_in_rule__Instruction__Group_0_1__05650);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2468:1: rule__Instruction__Group_0_1__0__Impl : ( ruleDefinition ) ;
    public final void rule__Instruction__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2472:1: ( ( ruleDefinition ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2473:1: ( ruleDefinition )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2473:1: ( ruleDefinition )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2474:1: ruleDefinition
            {
             before(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_ruleDefinition_in_rule__Instruction__Group_0_1__0__Impl5677);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2485:1: rule__Instruction__Group_0_1__1 : rule__Instruction__Group_0_1__1__Impl ;
    public final void rule__Instruction__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2489:1: ( rule__Instruction__Group_0_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2490:2: rule__Instruction__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_1__1__Impl_in_rule__Instruction__Group_0_1__15706);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2496:1: rule__Instruction__Group_0_1__1__Impl : ( ( ruleColor )? ) ;
    public final void rule__Instruction__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2500:1: ( ( ( ruleColor )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2501:1: ( ( ruleColor )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2501:1: ( ( ruleColor )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2502:1: ( ruleColor )?
            {
             before(grammarAccess.getInstructionAccess().getColorParserRuleCall_0_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2503:1: ( ruleColor )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==177) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2503:3: ruleColor
                    {
                    pushFollow(FOLLOW_ruleColor_in_rule__Instruction__Group_0_1__1__Impl5734);
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


    // $ANTLR start "rule__Definition__Group_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2517:1: rule__Definition__Group_0__0 : rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 ;
    public final void rule__Definition__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2521:1: ( rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2522:2: rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__05769);
            rule__Definition__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__05772);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2529:1: rule__Definition__Group_0__0__Impl : ( 'actor' ) ;
    public final void rule__Definition__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2533:1: ( ( 'actor' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2534:1: ( 'actor' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2534:1: ( 'actor' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2535:1: 'actor'
            {
             before(grammarAccess.getDefinitionAccess().getActorKeyword_0_0()); 
            match(input,170,FOLLOW_170_in_rule__Definition__Group_0__0__Impl5800); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2548:1: rule__Definition__Group_0__1 : rule__Definition__Group_0__1__Impl ;
    public final void rule__Definition__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2552:1: ( rule__Definition__Group_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2553:2: rule__Definition__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__15831);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2559:1: rule__Definition__Group_0__1__Impl : ( ( rule__Definition__NameAssignment_0_1 ) ) ;
    public final void rule__Definition__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2563:1: ( ( ( rule__Definition__NameAssignment_0_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2564:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2564:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2565:1: ( rule__Definition__NameAssignment_0_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2566:1: ( rule__Definition__NameAssignment_0_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2566:2: rule__Definition__NameAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl5858);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2580:1: rule__Definition__Group_1__0 : rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 ;
    public final void rule__Definition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2584:1: ( rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2585:2: rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__05892);
            rule__Definition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__05895);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2592:1: rule__Definition__Group_1__0__Impl : ( 'boundary' ) ;
    public final void rule__Definition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2596:1: ( ( 'boundary' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2597:1: ( 'boundary' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2597:1: ( 'boundary' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2598:1: 'boundary'
            {
             before(grammarAccess.getDefinitionAccess().getBoundaryKeyword_1_0()); 
            match(input,171,FOLLOW_171_in_rule__Definition__Group_1__0__Impl5923); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2611:1: rule__Definition__Group_1__1 : rule__Definition__Group_1__1__Impl ;
    public final void rule__Definition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2615:1: ( rule__Definition__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2616:2: rule__Definition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__15954);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2622:1: rule__Definition__Group_1__1__Impl : ( ( rule__Definition__NameAssignment_1_1 ) ) ;
    public final void rule__Definition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2626:1: ( ( ( rule__Definition__NameAssignment_1_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2627:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2627:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2628:1: ( rule__Definition__NameAssignment_1_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2629:1: ( rule__Definition__NameAssignment_1_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2629:2: rule__Definition__NameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl5981);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2643:1: rule__Definition__Group_2__0 : rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 ;
    public final void rule__Definition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2647:1: ( rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2648:2: rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__06015);
            rule__Definition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__06018);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2655:1: rule__Definition__Group_2__0__Impl : ( 'control' ) ;
    public final void rule__Definition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2659:1: ( ( 'control' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2660:1: ( 'control' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2660:1: ( 'control' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2661:1: 'control'
            {
             before(grammarAccess.getDefinitionAccess().getControlKeyword_2_0()); 
            match(input,172,FOLLOW_172_in_rule__Definition__Group_2__0__Impl6046); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2674:1: rule__Definition__Group_2__1 : rule__Definition__Group_2__1__Impl ;
    public final void rule__Definition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2678:1: ( rule__Definition__Group_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2679:2: rule__Definition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__16077);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2685:1: rule__Definition__Group_2__1__Impl : ( ( rule__Definition__NameAssignment_2_1 ) ) ;
    public final void rule__Definition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2689:1: ( ( ( rule__Definition__NameAssignment_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2690:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2690:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2691:1: ( rule__Definition__NameAssignment_2_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2692:1: ( rule__Definition__NameAssignment_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2692:2: rule__Definition__NameAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl6104);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2706:1: rule__Definition__Group_3__0 : rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 ;
    public final void rule__Definition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2710:1: ( rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2711:2: rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__06138);
            rule__Definition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__06141);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2718:1: rule__Definition__Group_3__0__Impl : ( 'entity' ) ;
    public final void rule__Definition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2722:1: ( ( 'entity' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2723:1: ( 'entity' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2723:1: ( 'entity' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2724:1: 'entity'
            {
             before(grammarAccess.getDefinitionAccess().getEntityKeyword_3_0()); 
            match(input,173,FOLLOW_173_in_rule__Definition__Group_3__0__Impl6169); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2737:1: rule__Definition__Group_3__1 : rule__Definition__Group_3__1__Impl ;
    public final void rule__Definition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2741:1: ( rule__Definition__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2742:2: rule__Definition__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__16200);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2748:1: rule__Definition__Group_3__1__Impl : ( ( rule__Definition__NameAssignment_3_1 ) ) ;
    public final void rule__Definition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2752:1: ( ( ( rule__Definition__NameAssignment_3_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2753:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2753:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2754:1: ( rule__Definition__NameAssignment_3_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2755:1: ( rule__Definition__NameAssignment_3_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2755:2: rule__Definition__NameAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl6227);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2769:1: rule__Definition__Group_4__0 : rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 ;
    public final void rule__Definition__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2773:1: ( rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2774:2: rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__06261);
            rule__Definition__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__06264);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2781:1: rule__Definition__Group_4__0__Impl : ( 'database' ) ;
    public final void rule__Definition__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2785:1: ( ( 'database' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2786:1: ( 'database' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2786:1: ( 'database' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2787:1: 'database'
            {
             before(grammarAccess.getDefinitionAccess().getDatabaseKeyword_4_0()); 
            match(input,174,FOLLOW_174_in_rule__Definition__Group_4__0__Impl6292); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2800:1: rule__Definition__Group_4__1 : rule__Definition__Group_4__1__Impl ;
    public final void rule__Definition__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2804:1: ( rule__Definition__Group_4__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2805:2: rule__Definition__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__16323);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2811:1: rule__Definition__Group_4__1__Impl : ( ( rule__Definition__NameAssignment_4_1 ) ) ;
    public final void rule__Definition__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2815:1: ( ( ( rule__Definition__NameAssignment_4_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2816:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2816:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2817:1: ( rule__Definition__NameAssignment_4_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_4_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2818:1: ( rule__Definition__NameAssignment_4_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2818:2: rule__Definition__NameAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl6350);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2832:1: rule__Definition__Group_5__0 : rule__Definition__Group_5__0__Impl rule__Definition__Group_5__1 ;
    public final void rule__Definition__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2836:1: ( rule__Definition__Group_5__0__Impl rule__Definition__Group_5__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2837:2: rule__Definition__Group_5__0__Impl rule__Definition__Group_5__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_5__0__Impl_in_rule__Definition__Group_5__06384);
            rule__Definition__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5__1_in_rule__Definition__Group_5__06387);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2844:1: rule__Definition__Group_5__0__Impl : ( 'participant' ) ;
    public final void rule__Definition__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2848:1: ( ( 'participant' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2849:1: ( 'participant' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2849:1: ( 'participant' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2850:1: 'participant'
            {
             before(grammarAccess.getDefinitionAccess().getParticipantKeyword_5_0()); 
            match(input,175,FOLLOW_175_in_rule__Definition__Group_5__0__Impl6415); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2863:1: rule__Definition__Group_5__1 : rule__Definition__Group_5__1__Impl ;
    public final void rule__Definition__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2867:1: ( rule__Definition__Group_5__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2868:2: rule__Definition__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_5__1__Impl_in_rule__Definition__Group_5__16446);
            rule__Definition__Group_5__1__Impl();

            state._fsp--;


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2874:1: rule__Definition__Group_5__1__Impl : ( ( rule__Definition__NameAssignment_5_1 ) ) ;
    public final void rule__Definition__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2878:1: ( ( ( rule__Definition__NameAssignment_5_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2879:1: ( ( rule__Definition__NameAssignment_5_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2879:1: ( ( rule__Definition__NameAssignment_5_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2880:1: ( rule__Definition__NameAssignment_5_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_5_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2881:1: ( rule__Definition__NameAssignment_5_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2881:2: rule__Definition__NameAssignment_5_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_5_1_in_rule__Definition__Group_5__1__Impl6473);
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


    // $ANTLR start "rule__AutoNumber__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2895:1: rule__AutoNumber__Group__0 : rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1 ;
    public final void rule__AutoNumber__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2899:1: ( rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2900:2: rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__0__Impl_in_rule__AutoNumber__Group__06507);
            rule__AutoNumber__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AutoNumber__Group__1_in_rule__AutoNumber__Group__06510);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2907:1: rule__AutoNumber__Group__0__Impl : ( 'autonumber' ) ;
    public final void rule__AutoNumber__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2911:1: ( ( 'autonumber' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2912:1: ( 'autonumber' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2912:1: ( 'autonumber' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2913:1: 'autonumber'
            {
             before(grammarAccess.getAutoNumberAccess().getAutonumberKeyword_0()); 
            match(input,176,FOLLOW_176_in_rule__AutoNumber__Group__0__Impl6538); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2926:1: rule__AutoNumber__Group__1 : rule__AutoNumber__Group__1__Impl ;
    public final void rule__AutoNumber__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2930:1: ( rule__AutoNumber__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2931:2: rule__AutoNumber__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__1__Impl_in_rule__AutoNumber__Group__16569);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2937:1: rule__AutoNumber__Group__1__Impl : ( ( rule__AutoNumber__Group_1__0 )? ) ;
    public final void rule__AutoNumber__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2941:1: ( ( ( rule__AutoNumber__Group_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2942:1: ( ( rule__AutoNumber__Group_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2942:1: ( ( rule__AutoNumber__Group_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2943:1: ( rule__AutoNumber__Group_1__0 )?
            {
             before(grammarAccess.getAutoNumberAccess().getGroup_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2944:1: ( rule__AutoNumber__Group_1__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_INT) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2944:2: rule__AutoNumber__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__AutoNumber__Group_1__0_in_rule__AutoNumber__Group__1__Impl6596);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2958:1: rule__AutoNumber__Group_1__0 : rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1 ;
    public final void rule__AutoNumber__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2962:1: ( rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2963:2: rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group_1__0__Impl_in_rule__AutoNumber__Group_1__06631);
            rule__AutoNumber__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AutoNumber__Group_1__1_in_rule__AutoNumber__Group_1__06634);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2970:1: rule__AutoNumber__Group_1__0__Impl : ( RULE_INT ) ;
    public final void rule__AutoNumber__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2974:1: ( ( RULE_INT ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2975:1: ( RULE_INT )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2975:1: ( RULE_INT )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2976:1: RULE_INT
            {
             before(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__0__Impl6661); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2987:1: rule__AutoNumber__Group_1__1 : rule__AutoNumber__Group_1__1__Impl ;
    public final void rule__AutoNumber__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2991:1: ( rule__AutoNumber__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2992:2: rule__AutoNumber__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group_1__1__Impl_in_rule__AutoNumber__Group_1__16690);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2998:1: rule__AutoNumber__Group_1__1__Impl : ( ( RULE_INT )? ) ;
    public final void rule__AutoNumber__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3002:1: ( ( ( RULE_INT )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3003:1: ( ( RULE_INT )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3003:1: ( ( RULE_INT )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3004:1: ( RULE_INT )?
            {
             before(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3005:1: ( RULE_INT )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_INT) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3005:3: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__1__Impl6718); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3019:1: rule__Color__Group__0 : rule__Color__Group__0__Impl rule__Color__Group__1 ;
    public final void rule__Color__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3023:1: ( rule__Color__Group__0__Impl rule__Color__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3024:2: rule__Color__Group__0__Impl rule__Color__Group__1
            {
            pushFollow(FOLLOW_rule__Color__Group__0__Impl_in_rule__Color__Group__06753);
            rule__Color__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Color__Group__1_in_rule__Color__Group__06756);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3031:1: rule__Color__Group__0__Impl : ( ( ( '#' ) ) ( ( '#' )* ) ) ;
    public final void rule__Color__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3035:1: ( ( ( ( '#' ) ) ( ( '#' )* ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3036:1: ( ( ( '#' ) ) ( ( '#' )* ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3036:1: ( ( ( '#' ) ) ( ( '#' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3037:1: ( ( '#' ) ) ( ( '#' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3037:1: ( ( '#' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3038:1: ( '#' )
            {
             before(grammarAccess.getColorAccess().getNumberSignKeyword_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3039:1: ( '#' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3040:2: '#'
            {
            match(input,177,FOLLOW_177_in_rule__Color__Group__0__Impl6787); 

            }

             after(grammarAccess.getColorAccess().getNumberSignKeyword_0()); 

            }

            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3044:1: ( ( '#' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3045:1: ( '#' )*
            {
             before(grammarAccess.getColorAccess().getNumberSignKeyword_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3046:1: ( '#' )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==177) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3047:2: '#'
            	    {
            	    match(input,177,FOLLOW_177_in_rule__Color__Group__0__Impl6803); 

            	    }
            	    break;

            	default :
            	    break loop18;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3059:1: rule__Color__Group__1 : rule__Color__Group__1__Impl ;
    public final void rule__Color__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3063:1: ( rule__Color__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3064:2: rule__Color__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Color__Group__1__Impl_in_rule__Color__Group__16838);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3070:1: rule__Color__Group__1__Impl : ( ( rule__Color__Alternatives_1 ) ) ;
    public final void rule__Color__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3074:1: ( ( ( rule__Color__Alternatives_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3075:1: ( ( rule__Color__Alternatives_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3075:1: ( ( rule__Color__Alternatives_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3076:1: ( rule__Color__Alternatives_1 )
            {
             before(grammarAccess.getColorAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3077:1: ( rule__Color__Alternatives_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3077:2: rule__Color__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Color__Alternatives_1_in_rule__Color__Group__1__Impl6865);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3091:1: rule__Title__Group__0 : rule__Title__Group__0__Impl rule__Title__Group__1 ;
    public final void rule__Title__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3095:1: ( rule__Title__Group__0__Impl rule__Title__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3096:2: rule__Title__Group__0__Impl rule__Title__Group__1
            {
            pushFollow(FOLLOW_rule__Title__Group__0__Impl_in_rule__Title__Group__06899);
            rule__Title__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Title__Group__1_in_rule__Title__Group__06902);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3103:1: rule__Title__Group__0__Impl : ( 'title' ) ;
    public final void rule__Title__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3107:1: ( ( 'title' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3108:1: ( 'title' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3108:1: ( 'title' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3109:1: 'title'
            {
             before(grammarAccess.getTitleAccess().getTitleKeyword_0()); 
            match(input,178,FOLLOW_178_in_rule__Title__Group__0__Impl6930); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3122:1: rule__Title__Group__1 : rule__Title__Group__1__Impl ;
    public final void rule__Title__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3126:1: ( rule__Title__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3127:2: rule__Title__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Title__Group__1__Impl_in_rule__Title__Group__16961);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3133:1: rule__Title__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__Title__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3137:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3138:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3138:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3139:1: RULE_ID
            {
             before(grammarAccess.getTitleAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Title__Group__1__Impl6988); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3154:1: rule__Legend__Group__0 : rule__Legend__Group__0__Impl rule__Legend__Group__1 ;
    public final void rule__Legend__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3158:1: ( rule__Legend__Group__0__Impl rule__Legend__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3159:2: rule__Legend__Group__0__Impl rule__Legend__Group__1
            {
            pushFollow(FOLLOW_rule__Legend__Group__0__Impl_in_rule__Legend__Group__07021);
            rule__Legend__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__1_in_rule__Legend__Group__07024);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3166:1: rule__Legend__Group__0__Impl : ( 'legend' ) ;
    public final void rule__Legend__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3170:1: ( ( 'legend' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3171:1: ( 'legend' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3171:1: ( 'legend' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3172:1: 'legend'
            {
             before(grammarAccess.getLegendAccess().getLegendKeyword_0()); 
            match(input,179,FOLLOW_179_in_rule__Legend__Group__0__Impl7052); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3185:1: rule__Legend__Group__1 : rule__Legend__Group__1__Impl rule__Legend__Group__2 ;
    public final void rule__Legend__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3189:1: ( rule__Legend__Group__1__Impl rule__Legend__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3190:2: rule__Legend__Group__1__Impl rule__Legend__Group__2
            {
            pushFollow(FOLLOW_rule__Legend__Group__1__Impl_in_rule__Legend__Group__17083);
            rule__Legend__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__2_in_rule__Legend__Group__17086);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3197:1: rule__Legend__Group__1__Impl : ( ( rule__Legend__Alternatives_1 )? ) ;
    public final void rule__Legend__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3201:1: ( ( ( rule__Legend__Alternatives_1 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3202:1: ( ( rule__Legend__Alternatives_1 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3202:1: ( ( rule__Legend__Alternatives_1 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3203:1: ( rule__Legend__Alternatives_1 )?
            {
             before(grammarAccess.getLegendAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3204:1: ( rule__Legend__Alternatives_1 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=158 && LA19_0<=160)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3204:2: rule__Legend__Alternatives_1
                    {
                    pushFollow(FOLLOW_rule__Legend__Alternatives_1_in_rule__Legend__Group__1__Impl7113);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3214:1: rule__Legend__Group__2 : rule__Legend__Group__2__Impl rule__Legend__Group__3 ;
    public final void rule__Legend__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3218:1: ( rule__Legend__Group__2__Impl rule__Legend__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3219:2: rule__Legend__Group__2__Impl rule__Legend__Group__3
            {
            pushFollow(FOLLOW_rule__Legend__Group__2__Impl_in_rule__Legend__Group__27144);
            rule__Legend__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__3_in_rule__Legend__Group__27147);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3226:1: rule__Legend__Group__2__Impl : ( ( rule__Legend__Alternatives_2 )* ) ;
    public final void rule__Legend__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3230:1: ( ( ( rule__Legend__Alternatives_2 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3231:1: ( ( rule__Legend__Alternatives_2 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3231:1: ( ( rule__Legend__Alternatives_2 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3232:1: ( rule__Legend__Alternatives_2 )*
            {
             before(grammarAccess.getLegendAccess().getAlternatives_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3233:1: ( rule__Legend__Alternatives_2 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_NEWLINE) ) {
                    int LA20_1 = input.LA(2);

                    if ( (LA20_1==RULE_NEWLINE||LA20_1==RULE_ID) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3233:2: rule__Legend__Alternatives_2
            	    {
            	    pushFollow(FOLLOW_rule__Legend__Alternatives_2_in_rule__Legend__Group__2__Impl7174);
            	    rule__Legend__Alternatives_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3243:1: rule__Legend__Group__3 : rule__Legend__Group__3__Impl rule__Legend__Group__4 ;
    public final void rule__Legend__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3247:1: ( rule__Legend__Group__3__Impl rule__Legend__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3248:2: rule__Legend__Group__3__Impl rule__Legend__Group__4
            {
            pushFollow(FOLLOW_rule__Legend__Group__3__Impl_in_rule__Legend__Group__37205);
            rule__Legend__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__4_in_rule__Legend__Group__37208);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3255:1: rule__Legend__Group__3__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Legend__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3259:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3260:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3260:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3261:1: RULE_NEWLINE
            {
             before(grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_3()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Legend__Group__3__Impl7235); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3272:1: rule__Legend__Group__4 : rule__Legend__Group__4__Impl ;
    public final void rule__Legend__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3276:1: ( rule__Legend__Group__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3277:2: rule__Legend__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Legend__Group__4__Impl_in_rule__Legend__Group__47264);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3283:1: rule__Legend__Group__4__Impl : ( 'endlegend' ) ;
    public final void rule__Legend__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3287:1: ( ( 'endlegend' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3288:1: ( 'endlegend' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3288:1: ( 'endlegend' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3289:1: 'endlegend'
            {
             before(grammarAccess.getLegendAccess().getEndlegendKeyword_4()); 
            match(input,180,FOLLOW_180_in_rule__Legend__Group__4__Impl7292); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3312:1: rule__Legend__Group_2_0__0 : rule__Legend__Group_2_0__0__Impl rule__Legend__Group_2_0__1 ;
    public final void rule__Legend__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3316:1: ( rule__Legend__Group_2_0__0__Impl rule__Legend__Group_2_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3317:2: rule__Legend__Group_2_0__0__Impl rule__Legend__Group_2_0__1
            {
            pushFollow(FOLLOW_rule__Legend__Group_2_0__0__Impl_in_rule__Legend__Group_2_0__07333);
            rule__Legend__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group_2_0__1_in_rule__Legend__Group_2_0__07336);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3324:1: rule__Legend__Group_2_0__0__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Legend__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3328:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3329:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3329:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3330:1: RULE_NEWLINE
            {
             before(grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_0_0()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Legend__Group_2_0__0__Impl7363); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3341:1: rule__Legend__Group_2_0__1 : rule__Legend__Group_2_0__1__Impl ;
    public final void rule__Legend__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3345:1: ( rule__Legend__Group_2_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3346:2: rule__Legend__Group_2_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Legend__Group_2_0__1__Impl_in_rule__Legend__Group_2_0__17392);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3352:1: rule__Legend__Group_2_0__1__Impl : ( RULE_ID ) ;
    public final void rule__Legend__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3356:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3357:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3357:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3358:1: RULE_ID
            {
             before(grammarAccess.getLegendAccess().getIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Legend__Group_2_0__1__Impl7419); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3373:1: rule__Newpage__Group__0 : rule__Newpage__Group__0__Impl rule__Newpage__Group__1 ;
    public final void rule__Newpage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3377:1: ( rule__Newpage__Group__0__Impl rule__Newpage__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3378:2: rule__Newpage__Group__0__Impl rule__Newpage__Group__1
            {
            pushFollow(FOLLOW_rule__Newpage__Group__0__Impl_in_rule__Newpage__Group__07452);
            rule__Newpage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Newpage__Group__1_in_rule__Newpage__Group__07455);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3385:1: rule__Newpage__Group__0__Impl : ( 'newpage' ) ;
    public final void rule__Newpage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3389:1: ( ( 'newpage' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3390:1: ( 'newpage' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3390:1: ( 'newpage' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3391:1: 'newpage'
            {
             before(grammarAccess.getNewpageAccess().getNewpageKeyword_0()); 
            match(input,181,FOLLOW_181_in_rule__Newpage__Group__0__Impl7483); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3404:1: rule__Newpage__Group__1 : rule__Newpage__Group__1__Impl ;
    public final void rule__Newpage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3408:1: ( rule__Newpage__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3409:2: rule__Newpage__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Newpage__Group__1__Impl_in_rule__Newpage__Group__17514);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3415:1: rule__Newpage__Group__1__Impl : ( ( RULE_ID )? ) ;
    public final void rule__Newpage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3419:1: ( ( ( RULE_ID )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3420:1: ( ( RULE_ID )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3420:1: ( ( RULE_ID )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3421:1: ( RULE_ID )?
            {
             before(grammarAccess.getNewpageAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3422:1: ( RULE_ID )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3422:3: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Newpage__Group__1__Impl7542); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3436:1: rule__AltElse__Group__0 : rule__AltElse__Group__0__Impl rule__AltElse__Group__1 ;
    public final void rule__AltElse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3440:1: ( rule__AltElse__Group__0__Impl rule__AltElse__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3441:2: rule__AltElse__Group__0__Impl rule__AltElse__Group__1
            {
            pushFollow(FOLLOW_rule__AltElse__Group__0__Impl_in_rule__AltElse__Group__07577);
            rule__AltElse__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__1_in_rule__AltElse__Group__07580);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3448:1: rule__AltElse__Group__0__Impl : ( 'alt' ) ;
    public final void rule__AltElse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3452:1: ( ( 'alt' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3453:1: ( 'alt' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3453:1: ( 'alt' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3454:1: 'alt'
            {
             before(grammarAccess.getAltElseAccess().getAltKeyword_0()); 
            match(input,182,FOLLOW_182_in_rule__AltElse__Group__0__Impl7608); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3467:1: rule__AltElse__Group__1 : rule__AltElse__Group__1__Impl rule__AltElse__Group__2 ;
    public final void rule__AltElse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3471:1: ( rule__AltElse__Group__1__Impl rule__AltElse__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3472:2: rule__AltElse__Group__1__Impl rule__AltElse__Group__2
            {
            pushFollow(FOLLOW_rule__AltElse__Group__1__Impl_in_rule__AltElse__Group__17639);
            rule__AltElse__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__2_in_rule__AltElse__Group__17642);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3479:1: rule__AltElse__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__AltElse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3483:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3484:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3484:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3485:1: RULE_ID
            {
             before(grammarAccess.getAltElseAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AltElse__Group__1__Impl7669); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3496:1: rule__AltElse__Group__2 : rule__AltElse__Group__2__Impl rule__AltElse__Group__3 ;
    public final void rule__AltElse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3500:1: ( rule__AltElse__Group__2__Impl rule__AltElse__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3501:2: rule__AltElse__Group__2__Impl rule__AltElse__Group__3
            {
            pushFollow(FOLLOW_rule__AltElse__Group__2__Impl_in_rule__AltElse__Group__27698);
            rule__AltElse__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__3_in_rule__AltElse__Group__27701);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3508:1: rule__AltElse__Group__2__Impl : ( RULE_NEWLINE ) ;
    public final void rule__AltElse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3512:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3513:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3513:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3514:1: RULE_NEWLINE
            {
             before(grammarAccess.getAltElseAccess().getNEWLINETerminalRuleCall_2()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__AltElse__Group__2__Impl7728); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3525:1: rule__AltElse__Group__3 : rule__AltElse__Group__3__Impl rule__AltElse__Group__4 ;
    public final void rule__AltElse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3529:1: ( rule__AltElse__Group__3__Impl rule__AltElse__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3530:2: rule__AltElse__Group__3__Impl rule__AltElse__Group__4
            {
            pushFollow(FOLLOW_rule__AltElse__Group__3__Impl_in_rule__AltElse__Group__37757);
            rule__AltElse__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__4_in_rule__AltElse__Group__37760);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3537:1: rule__AltElse__Group__3__Impl : ( ( rule__AltElse__InstructionsAssignment_3 )* ) ;
    public final void rule__AltElse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3541:1: ( ( ( rule__AltElse__InstructionsAssignment_3 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3542:1: ( ( rule__AltElse__InstructionsAssignment_3 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3542:1: ( ( rule__AltElse__InstructionsAssignment_3 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3543:1: ( rule__AltElse__InstructionsAssignment_3 )*
            {
             before(grammarAccess.getAltElseAccess().getInstructionsAssignment_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3544:1: ( rule__AltElse__InstructionsAssignment_3 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_NEWLINE||LA22_0==RULE_ID||LA22_0==12||(LA22_0>=161 && LA22_0<=166)||(LA22_0>=170 && LA22_0<=176)||(LA22_0>=178 && LA22_0<=179)||(LA22_0>=181 && LA22_0<=182)||LA22_0==185||(LA22_0>=190 && LA22_0<=191)||(LA22_0>=193 && LA22_0<=194)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3544:2: rule__AltElse__InstructionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__AltElse__InstructionsAssignment_3_in_rule__AltElse__Group__3__Impl7787);
            	    rule__AltElse__InstructionsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3554:1: rule__AltElse__Group__4 : rule__AltElse__Group__4__Impl rule__AltElse__Group__5 ;
    public final void rule__AltElse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3558:1: ( rule__AltElse__Group__4__Impl rule__AltElse__Group__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3559:2: rule__AltElse__Group__4__Impl rule__AltElse__Group__5
            {
            pushFollow(FOLLOW_rule__AltElse__Group__4__Impl_in_rule__AltElse__Group__47818);
            rule__AltElse__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__5_in_rule__AltElse__Group__47821);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3566:1: rule__AltElse__Group__4__Impl : ( ( rule__AltElse__ElsesAssignment_4 )* ) ;
    public final void rule__AltElse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3570:1: ( ( ( rule__AltElse__ElsesAssignment_4 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3571:1: ( ( rule__AltElse__ElsesAssignment_4 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3571:1: ( ( rule__AltElse__ElsesAssignment_4 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3572:1: ( rule__AltElse__ElsesAssignment_4 )*
            {
             before(grammarAccess.getAltElseAccess().getElsesAssignment_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3573:1: ( rule__AltElse__ElsesAssignment_4 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==184) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3573:2: rule__AltElse__ElsesAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__AltElse__ElsesAssignment_4_in_rule__AltElse__Group__4__Impl7848);
            	    rule__AltElse__ElsesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3583:1: rule__AltElse__Group__5 : rule__AltElse__Group__5__Impl ;
    public final void rule__AltElse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3587:1: ( rule__AltElse__Group__5__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3588:2: rule__AltElse__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__AltElse__Group__5__Impl_in_rule__AltElse__Group__57879);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3594:1: rule__AltElse__Group__5__Impl : ( 'end' ) ;
    public final void rule__AltElse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3598:1: ( ( 'end' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3599:1: ( 'end' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3599:1: ( 'end' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3600:1: 'end'
            {
             before(grammarAccess.getAltElseAccess().getEndKeyword_5()); 
            match(input,183,FOLLOW_183_in_rule__AltElse__Group__5__Impl7907); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3625:1: rule__Else__Group__0 : rule__Else__Group__0__Impl rule__Else__Group__1 ;
    public final void rule__Else__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3629:1: ( rule__Else__Group__0__Impl rule__Else__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3630:2: rule__Else__Group__0__Impl rule__Else__Group__1
            {
            pushFollow(FOLLOW_rule__Else__Group__0__Impl_in_rule__Else__Group__07950);
            rule__Else__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Else__Group__1_in_rule__Else__Group__07953);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3637:1: rule__Else__Group__0__Impl : ( 'else' ) ;
    public final void rule__Else__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3641:1: ( ( 'else' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3642:1: ( 'else' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3642:1: ( 'else' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3643:1: 'else'
            {
             before(grammarAccess.getElseAccess().getElseKeyword_0()); 
            match(input,184,FOLLOW_184_in_rule__Else__Group__0__Impl7981); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3656:1: rule__Else__Group__1 : rule__Else__Group__1__Impl rule__Else__Group__2 ;
    public final void rule__Else__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3660:1: ( rule__Else__Group__1__Impl rule__Else__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3661:2: rule__Else__Group__1__Impl rule__Else__Group__2
            {
            pushFollow(FOLLOW_rule__Else__Group__1__Impl_in_rule__Else__Group__18012);
            rule__Else__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Else__Group__2_in_rule__Else__Group__18015);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3668:1: rule__Else__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__Else__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3672:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3673:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3673:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3674:1: RULE_ID
            {
             before(grammarAccess.getElseAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Else__Group__1__Impl8042); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3685:1: rule__Else__Group__2 : rule__Else__Group__2__Impl rule__Else__Group__3 ;
    public final void rule__Else__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3689:1: ( rule__Else__Group__2__Impl rule__Else__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3690:2: rule__Else__Group__2__Impl rule__Else__Group__3
            {
            pushFollow(FOLLOW_rule__Else__Group__2__Impl_in_rule__Else__Group__28071);
            rule__Else__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Else__Group__3_in_rule__Else__Group__28074);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3697:1: rule__Else__Group__2__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Else__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3701:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3702:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3702:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3703:1: RULE_NEWLINE
            {
             before(grammarAccess.getElseAccess().getNEWLINETerminalRuleCall_2()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Else__Group__2__Impl8101); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3714:1: rule__Else__Group__3 : rule__Else__Group__3__Impl ;
    public final void rule__Else__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3718:1: ( rule__Else__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3719:2: rule__Else__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Else__Group__3__Impl_in_rule__Else__Group__38130);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3725:1: rule__Else__Group__3__Impl : ( ( rule__Else__InstructionsAssignment_3 )* ) ;
    public final void rule__Else__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3729:1: ( ( ( rule__Else__InstructionsAssignment_3 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3730:1: ( ( rule__Else__InstructionsAssignment_3 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3730:1: ( ( rule__Else__InstructionsAssignment_3 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3731:1: ( rule__Else__InstructionsAssignment_3 )*
            {
             before(grammarAccess.getElseAccess().getInstructionsAssignment_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3732:1: ( rule__Else__InstructionsAssignment_3 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_NEWLINE||LA24_0==RULE_ID||LA24_0==12||(LA24_0>=161 && LA24_0<=166)||(LA24_0>=170 && LA24_0<=176)||(LA24_0>=178 && LA24_0<=179)||(LA24_0>=181 && LA24_0<=182)||LA24_0==185||(LA24_0>=190 && LA24_0<=191)||(LA24_0>=193 && LA24_0<=194)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3732:2: rule__Else__InstructionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Else__InstructionsAssignment_3_in_rule__Else__Group__3__Impl8157);
            	    rule__Else__InstructionsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3750:1: rule__GroupingMessages__Group__0 : rule__GroupingMessages__Group__0__Impl rule__GroupingMessages__Group__1 ;
    public final void rule__GroupingMessages__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3754:1: ( rule__GroupingMessages__Group__0__Impl rule__GroupingMessages__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3755:2: rule__GroupingMessages__Group__0__Impl rule__GroupingMessages__Group__1
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__0__Impl_in_rule__GroupingMessages__Group__08196);
            rule__GroupingMessages__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__1_in_rule__GroupingMessages__Group__08199);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3762:1: rule__GroupingMessages__Group__0__Impl : ( ( rule__GroupingMessages__Alternatives_0 ) ) ;
    public final void rule__GroupingMessages__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3766:1: ( ( ( rule__GroupingMessages__Alternatives_0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3767:1: ( ( rule__GroupingMessages__Alternatives_0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3767:1: ( ( rule__GroupingMessages__Alternatives_0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3768:1: ( rule__GroupingMessages__Alternatives_0 )
            {
             before(grammarAccess.getGroupingMessagesAccess().getAlternatives_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3769:1: ( rule__GroupingMessages__Alternatives_0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3769:2: rule__GroupingMessages__Alternatives_0
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Alternatives_0_in_rule__GroupingMessages__Group__0__Impl8226);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3779:1: rule__GroupingMessages__Group__1 : rule__GroupingMessages__Group__1__Impl rule__GroupingMessages__Group__2 ;
    public final void rule__GroupingMessages__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3783:1: ( rule__GroupingMessages__Group__1__Impl rule__GroupingMessages__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3784:2: rule__GroupingMessages__Group__1__Impl rule__GroupingMessages__Group__2
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__1__Impl_in_rule__GroupingMessages__Group__18256);
            rule__GroupingMessages__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__2_in_rule__GroupingMessages__Group__18259);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3791:1: rule__GroupingMessages__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__GroupingMessages__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3795:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3796:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3796:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3797:1: RULE_ID
            {
             before(grammarAccess.getGroupingMessagesAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__GroupingMessages__Group__1__Impl8286); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3808:1: rule__GroupingMessages__Group__2 : rule__GroupingMessages__Group__2__Impl rule__GroupingMessages__Group__3 ;
    public final void rule__GroupingMessages__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3812:1: ( rule__GroupingMessages__Group__2__Impl rule__GroupingMessages__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3813:2: rule__GroupingMessages__Group__2__Impl rule__GroupingMessages__Group__3
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__2__Impl_in_rule__GroupingMessages__Group__28315);
            rule__GroupingMessages__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__3_in_rule__GroupingMessages__Group__28318);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3820:1: rule__GroupingMessages__Group__2__Impl : ( RULE_NEWLINE ) ;
    public final void rule__GroupingMessages__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3824:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3825:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3825:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3826:1: RULE_NEWLINE
            {
             before(grammarAccess.getGroupingMessagesAccess().getNEWLINETerminalRuleCall_2()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__GroupingMessages__Group__2__Impl8345); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3837:1: rule__GroupingMessages__Group__3 : rule__GroupingMessages__Group__3__Impl rule__GroupingMessages__Group__4 ;
    public final void rule__GroupingMessages__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3841:1: ( rule__GroupingMessages__Group__3__Impl rule__GroupingMessages__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3842:2: rule__GroupingMessages__Group__3__Impl rule__GroupingMessages__Group__4
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__3__Impl_in_rule__GroupingMessages__Group__38374);
            rule__GroupingMessages__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__4_in_rule__GroupingMessages__Group__38377);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3849:1: rule__GroupingMessages__Group__3__Impl : ( ( rule__GroupingMessages__InstructionsAssignment_3 )* ) ;
    public final void rule__GroupingMessages__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3853:1: ( ( ( rule__GroupingMessages__InstructionsAssignment_3 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3854:1: ( ( rule__GroupingMessages__InstructionsAssignment_3 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3854:1: ( ( rule__GroupingMessages__InstructionsAssignment_3 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3855:1: ( rule__GroupingMessages__InstructionsAssignment_3 )*
            {
             before(grammarAccess.getGroupingMessagesAccess().getInstructionsAssignment_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3856:1: ( rule__GroupingMessages__InstructionsAssignment_3 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_NEWLINE||LA25_0==RULE_ID||LA25_0==12||(LA25_0>=161 && LA25_0<=166)||(LA25_0>=170 && LA25_0<=176)||(LA25_0>=178 && LA25_0<=179)||(LA25_0>=181 && LA25_0<=182)||LA25_0==185||(LA25_0>=190 && LA25_0<=191)||(LA25_0>=193 && LA25_0<=194)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3856:2: rule__GroupingMessages__InstructionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__GroupingMessages__InstructionsAssignment_3_in_rule__GroupingMessages__Group__3__Impl8404);
            	    rule__GroupingMessages__InstructionsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3866:1: rule__GroupingMessages__Group__4 : rule__GroupingMessages__Group__4__Impl ;
    public final void rule__GroupingMessages__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3870:1: ( rule__GroupingMessages__Group__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3871:2: rule__GroupingMessages__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__4__Impl_in_rule__GroupingMessages__Group__48435);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3877:1: rule__GroupingMessages__Group__4__Impl : ( 'end' ) ;
    public final void rule__GroupingMessages__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3881:1: ( ( 'end' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3882:1: ( 'end' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3882:1: ( 'end' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3883:1: 'end'
            {
             before(grammarAccess.getGroupingMessagesAccess().getEndKeyword_4()); 
            match(input,183,FOLLOW_183_in_rule__GroupingMessages__Group__4__Impl8463); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3907:1: rule__Note__Group__0 : rule__Note__Group__0__Impl rule__Note__Group__1 ;
    public final void rule__Note__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3911:1: ( rule__Note__Group__0__Impl rule__Note__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3912:2: rule__Note__Group__0__Impl rule__Note__Group__1
            {
            pushFollow(FOLLOW_rule__Note__Group__0__Impl_in_rule__Note__Group__08505);
            rule__Note__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group__1_in_rule__Note__Group__08508);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3919:1: rule__Note__Group__0__Impl : ( 'note' ) ;
    public final void rule__Note__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3923:1: ( ( 'note' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3924:1: ( 'note' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3924:1: ( 'note' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3925:1: 'note'
            {
             before(grammarAccess.getNoteAccess().getNoteKeyword_0()); 
            match(input,185,FOLLOW_185_in_rule__Note__Group__0__Impl8536); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3938:1: rule__Note__Group__1 : rule__Note__Group__1__Impl rule__Note__Group__2 ;
    public final void rule__Note__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3942:1: ( rule__Note__Group__1__Impl rule__Note__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3943:2: rule__Note__Group__1__Impl rule__Note__Group__2
            {
            pushFollow(FOLLOW_rule__Note__Group__1__Impl_in_rule__Note__Group__18567);
            rule__Note__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group__2_in_rule__Note__Group__18570);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3950:1: rule__Note__Group__1__Impl : ( ( rule__Note__Alternatives_1 ) ) ;
    public final void rule__Note__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3954:1: ( ( ( rule__Note__Alternatives_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3955:1: ( ( rule__Note__Alternatives_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3955:1: ( ( rule__Note__Alternatives_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3956:1: ( rule__Note__Alternatives_1 )
            {
             before(grammarAccess.getNoteAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3957:1: ( rule__Note__Alternatives_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3957:2: rule__Note__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Note__Alternatives_1_in_rule__Note__Group__1__Impl8597);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3967:1: rule__Note__Group__2 : rule__Note__Group__2__Impl rule__Note__Group__3 ;
    public final void rule__Note__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3971:1: ( rule__Note__Group__2__Impl rule__Note__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3972:2: rule__Note__Group__2__Impl rule__Note__Group__3
            {
            pushFollow(FOLLOW_rule__Note__Group__2__Impl_in_rule__Note__Group__28627);
            rule__Note__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group__3_in_rule__Note__Group__28630);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3979:1: rule__Note__Group__2__Impl : ( ( ruleColor )* ) ;
    public final void rule__Note__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3983:1: ( ( ( ruleColor )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3984:1: ( ( ruleColor )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3984:1: ( ( ruleColor )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3985:1: ( ruleColor )*
            {
             before(grammarAccess.getNoteAccess().getColorParserRuleCall_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3986:1: ( ruleColor )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==177) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3986:3: ruleColor
            	    {
            	    pushFollow(FOLLOW_ruleColor_in_rule__Note__Group__2__Impl8658);
            	    ruleColor();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getNoteAccess().getColorParserRuleCall_2()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3996:1: rule__Note__Group__3 : rule__Note__Group__3__Impl ;
    public final void rule__Note__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4000:1: ( rule__Note__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4001:2: rule__Note__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group__3__Impl_in_rule__Note__Group__38689);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4007:1: rule__Note__Group__3__Impl : ( ( rule__Note__Alternatives_3 ) ) ;
    public final void rule__Note__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4011:1: ( ( ( rule__Note__Alternatives_3 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4012:1: ( ( rule__Note__Alternatives_3 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4012:1: ( ( rule__Note__Alternatives_3 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4013:1: ( rule__Note__Alternatives_3 )
            {
             before(grammarAccess.getNoteAccess().getAlternatives_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4014:1: ( rule__Note__Alternatives_3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4014:2: rule__Note__Alternatives_3
            {
            pushFollow(FOLLOW_rule__Note__Alternatives_3_in_rule__Note__Group__3__Impl8716);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4032:1: rule__Note__Group_1_0__0 : rule__Note__Group_1_0__0__Impl rule__Note__Group_1_0__1 ;
    public final void rule__Note__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4036:1: ( rule__Note__Group_1_0__0__Impl rule__Note__Group_1_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4037:2: rule__Note__Group_1_0__0__Impl rule__Note__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0__0__Impl_in_rule__Note__Group_1_0__08754);
            rule__Note__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_0__1_in_rule__Note__Group_1_0__08757);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4044:1: rule__Note__Group_1_0__0__Impl : ( 'right' ) ;
    public final void rule__Note__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4048:1: ( ( 'right' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4049:1: ( 'right' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4049:1: ( 'right' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4050:1: 'right'
            {
             before(grammarAccess.getNoteAccess().getRightKeyword_1_0_0()); 
            match(input,158,FOLLOW_158_in_rule__Note__Group_1_0__0__Impl8785); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4063:1: rule__Note__Group_1_0__1 : rule__Note__Group_1_0__1__Impl ;
    public final void rule__Note__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4067:1: ( rule__Note__Group_1_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4068:2: rule__Note__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0__1__Impl_in_rule__Note__Group_1_0__18816);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4074:1: rule__Note__Group_1_0__1__Impl : ( ( rule__Note__Group_1_0_1__0 )? ) ;
    public final void rule__Note__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4078:1: ( ( ( rule__Note__Group_1_0_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4079:1: ( ( rule__Note__Group_1_0_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4079:1: ( ( rule__Note__Group_1_0_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4080:1: ( rule__Note__Group_1_0_1__0 )?
            {
             before(grammarAccess.getNoteAccess().getGroup_1_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4081:1: ( rule__Note__Group_1_0_1__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==186) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4081:2: rule__Note__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_0_1__0_in_rule__Note__Group_1_0__1__Impl8843);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4095:1: rule__Note__Group_1_0_1__0 : rule__Note__Group_1_0_1__0__Impl rule__Note__Group_1_0_1__1 ;
    public final void rule__Note__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4099:1: ( rule__Note__Group_1_0_1__0__Impl rule__Note__Group_1_0_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4100:2: rule__Note__Group_1_0_1__0__Impl rule__Note__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1__0__Impl_in_rule__Note__Group_1_0_1__08878);
            rule__Note__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_0_1__1_in_rule__Note__Group_1_0_1__08881);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4107:1: rule__Note__Group_1_0_1__0__Impl : ( 'of' ) ;
    public final void rule__Note__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4111:1: ( ( 'of' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4112:1: ( 'of' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4112:1: ( 'of' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4113:1: 'of'
            {
             before(grammarAccess.getNoteAccess().getOfKeyword_1_0_1_0()); 
            match(input,186,FOLLOW_186_in_rule__Note__Group_1_0_1__0__Impl8909); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4126:1: rule__Note__Group_1_0_1__1 : rule__Note__Group_1_0_1__1__Impl rule__Note__Group_1_0_1__2 ;
    public final void rule__Note__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4130:1: ( rule__Note__Group_1_0_1__1__Impl rule__Note__Group_1_0_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4131:2: rule__Note__Group_1_0_1__1__Impl rule__Note__Group_1_0_1__2
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1__1__Impl_in_rule__Note__Group_1_0_1__18940);
            rule__Note__Group_1_0_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_0_1__2_in_rule__Note__Group_1_0_1__18943);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4138:1: rule__Note__Group_1_0_1__1__Impl : ( RULE_ID ) ;
    public final void rule__Note__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4142:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4143:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4143:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4144:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getIDTerminalRuleCall_1_0_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__Group_1_0_1__1__Impl8970); 
             after(grammarAccess.getNoteAccess().getIDTerminalRuleCall_1_0_1_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4155:1: rule__Note__Group_1_0_1__2 : rule__Note__Group_1_0_1__2__Impl ;
    public final void rule__Note__Group_1_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4159:1: ( rule__Note__Group_1_0_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4160:2: rule__Note__Group_1_0_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1__2__Impl_in_rule__Note__Group_1_0_1__28999);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4166:1: rule__Note__Group_1_0_1__2__Impl : ( ( rule__Note__Group_1_0_1_2__0 )* ) ;
    public final void rule__Note__Group_1_0_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4170:1: ( ( ( rule__Note__Group_1_0_1_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4171:1: ( ( rule__Note__Group_1_0_1_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4171:1: ( ( rule__Note__Group_1_0_1_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4172:1: ( rule__Note__Group_1_0_1_2__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_1_0_1_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4173:1: ( rule__Note__Group_1_0_1_2__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==187) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4173:2: rule__Note__Group_1_0_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_1_0_1_2__0_in_rule__Note__Group_1_0_1__2__Impl9026);
            	    rule__Note__Group_1_0_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4189:1: rule__Note__Group_1_0_1_2__0 : rule__Note__Group_1_0_1_2__0__Impl rule__Note__Group_1_0_1_2__1 ;
    public final void rule__Note__Group_1_0_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4193:1: ( rule__Note__Group_1_0_1_2__0__Impl rule__Note__Group_1_0_1_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4194:2: rule__Note__Group_1_0_1_2__0__Impl rule__Note__Group_1_0_1_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1_2__0__Impl_in_rule__Note__Group_1_0_1_2__09063);
            rule__Note__Group_1_0_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_0_1_2__1_in_rule__Note__Group_1_0_1_2__09066);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4201:1: rule__Note__Group_1_0_1_2__0__Impl : ( ',' ) ;
    public final void rule__Note__Group_1_0_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4205:1: ( ( ',' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4206:1: ( ',' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4206:1: ( ',' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4207:1: ','
            {
             before(grammarAccess.getNoteAccess().getCommaKeyword_1_0_1_2_0()); 
            match(input,187,FOLLOW_187_in_rule__Note__Group_1_0_1_2__0__Impl9094); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4220:1: rule__Note__Group_1_0_1_2__1 : rule__Note__Group_1_0_1_2__1__Impl ;
    public final void rule__Note__Group_1_0_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4224:1: ( rule__Note__Group_1_0_1_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4225:2: rule__Note__Group_1_0_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1_2__1__Impl_in_rule__Note__Group_1_0_1_2__19125);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4231:1: rule__Note__Group_1_0_1_2__1__Impl : ( RULE_ID ) ;
    public final void rule__Note__Group_1_0_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4235:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4236:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4236:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4237:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getIDTerminalRuleCall_1_0_1_2_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__Group_1_0_1_2__1__Impl9152); 
             after(grammarAccess.getNoteAccess().getIDTerminalRuleCall_1_0_1_2_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4252:1: rule__Note__Group_1_1__0 : rule__Note__Group_1_1__0__Impl rule__Note__Group_1_1__1 ;
    public final void rule__Note__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4256:1: ( rule__Note__Group_1_1__0__Impl rule__Note__Group_1_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4257:2: rule__Note__Group_1_1__0__Impl rule__Note__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1__0__Impl_in_rule__Note__Group_1_1__09185);
            rule__Note__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_1__1_in_rule__Note__Group_1_1__09188);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4264:1: rule__Note__Group_1_1__0__Impl : ( 'left' ) ;
    public final void rule__Note__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4268:1: ( ( 'left' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4269:1: ( 'left' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4269:1: ( 'left' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4270:1: 'left'
            {
             before(grammarAccess.getNoteAccess().getLeftKeyword_1_1_0()); 
            match(input,159,FOLLOW_159_in_rule__Note__Group_1_1__0__Impl9216); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4283:1: rule__Note__Group_1_1__1 : rule__Note__Group_1_1__1__Impl ;
    public final void rule__Note__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4287:1: ( rule__Note__Group_1_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4288:2: rule__Note__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1__1__Impl_in_rule__Note__Group_1_1__19247);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4294:1: rule__Note__Group_1_1__1__Impl : ( ( rule__Note__Group_1_1_1__0 )? ) ;
    public final void rule__Note__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4298:1: ( ( ( rule__Note__Group_1_1_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4299:1: ( ( rule__Note__Group_1_1_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4299:1: ( ( rule__Note__Group_1_1_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4300:1: ( rule__Note__Group_1_1_1__0 )?
            {
             before(grammarAccess.getNoteAccess().getGroup_1_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4301:1: ( rule__Note__Group_1_1_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==186) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4301:2: rule__Note__Group_1_1_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_1_1__0_in_rule__Note__Group_1_1__1__Impl9274);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4315:1: rule__Note__Group_1_1_1__0 : rule__Note__Group_1_1_1__0__Impl rule__Note__Group_1_1_1__1 ;
    public final void rule__Note__Group_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4319:1: ( rule__Note__Group_1_1_1__0__Impl rule__Note__Group_1_1_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4320:2: rule__Note__Group_1_1_1__0__Impl rule__Note__Group_1_1_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1__0__Impl_in_rule__Note__Group_1_1_1__09309);
            rule__Note__Group_1_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_1_1__1_in_rule__Note__Group_1_1_1__09312);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4327:1: rule__Note__Group_1_1_1__0__Impl : ( 'of' ) ;
    public final void rule__Note__Group_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4331:1: ( ( 'of' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4332:1: ( 'of' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4332:1: ( 'of' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4333:1: 'of'
            {
             before(grammarAccess.getNoteAccess().getOfKeyword_1_1_1_0()); 
            match(input,186,FOLLOW_186_in_rule__Note__Group_1_1_1__0__Impl9340); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4346:1: rule__Note__Group_1_1_1__1 : rule__Note__Group_1_1_1__1__Impl rule__Note__Group_1_1_1__2 ;
    public final void rule__Note__Group_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4350:1: ( rule__Note__Group_1_1_1__1__Impl rule__Note__Group_1_1_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4351:2: rule__Note__Group_1_1_1__1__Impl rule__Note__Group_1_1_1__2
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1__1__Impl_in_rule__Note__Group_1_1_1__19371);
            rule__Note__Group_1_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_1_1__2_in_rule__Note__Group_1_1_1__19374);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4358:1: rule__Note__Group_1_1_1__1__Impl : ( RULE_ID ) ;
    public final void rule__Note__Group_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4362:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4363:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4363:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4364:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getIDTerminalRuleCall_1_1_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__Group_1_1_1__1__Impl9401); 
             after(grammarAccess.getNoteAccess().getIDTerminalRuleCall_1_1_1_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4375:1: rule__Note__Group_1_1_1__2 : rule__Note__Group_1_1_1__2__Impl ;
    public final void rule__Note__Group_1_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4379:1: ( rule__Note__Group_1_1_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4380:2: rule__Note__Group_1_1_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1__2__Impl_in_rule__Note__Group_1_1_1__29430);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4386:1: rule__Note__Group_1_1_1__2__Impl : ( ( rule__Note__Group_1_1_1_2__0 )* ) ;
    public final void rule__Note__Group_1_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4390:1: ( ( ( rule__Note__Group_1_1_1_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4391:1: ( ( rule__Note__Group_1_1_1_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4391:1: ( ( rule__Note__Group_1_1_1_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4392:1: ( rule__Note__Group_1_1_1_2__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_1_1_1_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4393:1: ( rule__Note__Group_1_1_1_2__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==187) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4393:2: rule__Note__Group_1_1_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_1_1_1_2__0_in_rule__Note__Group_1_1_1__2__Impl9457);
            	    rule__Note__Group_1_1_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4409:1: rule__Note__Group_1_1_1_2__0 : rule__Note__Group_1_1_1_2__0__Impl rule__Note__Group_1_1_1_2__1 ;
    public final void rule__Note__Group_1_1_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4413:1: ( rule__Note__Group_1_1_1_2__0__Impl rule__Note__Group_1_1_1_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4414:2: rule__Note__Group_1_1_1_2__0__Impl rule__Note__Group_1_1_1_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1_2__0__Impl_in_rule__Note__Group_1_1_1_2__09494);
            rule__Note__Group_1_1_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_1_1_2__1_in_rule__Note__Group_1_1_1_2__09497);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4421:1: rule__Note__Group_1_1_1_2__0__Impl : ( ',' ) ;
    public final void rule__Note__Group_1_1_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4425:1: ( ( ',' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4426:1: ( ',' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4426:1: ( ',' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4427:1: ','
            {
             before(grammarAccess.getNoteAccess().getCommaKeyword_1_1_1_2_0()); 
            match(input,187,FOLLOW_187_in_rule__Note__Group_1_1_1_2__0__Impl9525); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4440:1: rule__Note__Group_1_1_1_2__1 : rule__Note__Group_1_1_1_2__1__Impl ;
    public final void rule__Note__Group_1_1_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4444:1: ( rule__Note__Group_1_1_1_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4445:2: rule__Note__Group_1_1_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1_2__1__Impl_in_rule__Note__Group_1_1_1_2__19556);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4451:1: rule__Note__Group_1_1_1_2__1__Impl : ( RULE_ID ) ;
    public final void rule__Note__Group_1_1_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4455:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4456:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4456:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4457:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getIDTerminalRuleCall_1_1_1_2_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__Group_1_1_1_2__1__Impl9583); 
             after(grammarAccess.getNoteAccess().getIDTerminalRuleCall_1_1_1_2_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4472:1: rule__Note__Group_1_2__0 : rule__Note__Group_1_2__0__Impl rule__Note__Group_1_2__1 ;
    public final void rule__Note__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4476:1: ( rule__Note__Group_1_2__0__Impl rule__Note__Group_1_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4477:2: rule__Note__Group_1_2__0__Impl rule__Note__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2__0__Impl_in_rule__Note__Group_1_2__09616);
            rule__Note__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_2__1_in_rule__Note__Group_1_2__09619);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4484:1: rule__Note__Group_1_2__0__Impl : ( 'over' ) ;
    public final void rule__Note__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4488:1: ( ( 'over' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4489:1: ( 'over' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4489:1: ( 'over' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4490:1: 'over'
            {
             before(grammarAccess.getNoteAccess().getOverKeyword_1_2_0()); 
            match(input,188,FOLLOW_188_in_rule__Note__Group_1_2__0__Impl9647); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4503:1: rule__Note__Group_1_2__1 : rule__Note__Group_1_2__1__Impl rule__Note__Group_1_2__2 ;
    public final void rule__Note__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4507:1: ( rule__Note__Group_1_2__1__Impl rule__Note__Group_1_2__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4508:2: rule__Note__Group_1_2__1__Impl rule__Note__Group_1_2__2
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2__1__Impl_in_rule__Note__Group_1_2__19678);
            rule__Note__Group_1_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_2__2_in_rule__Note__Group_1_2__19681);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4515:1: rule__Note__Group_1_2__1__Impl : ( RULE_ID ) ;
    public final void rule__Note__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4519:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4520:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4520:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4521:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getIDTerminalRuleCall_1_2_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__Group_1_2__1__Impl9708); 
             after(grammarAccess.getNoteAccess().getIDTerminalRuleCall_1_2_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4532:1: rule__Note__Group_1_2__2 : rule__Note__Group_1_2__2__Impl ;
    public final void rule__Note__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4536:1: ( rule__Note__Group_1_2__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4537:2: rule__Note__Group_1_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2__2__Impl_in_rule__Note__Group_1_2__29737);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4543:1: rule__Note__Group_1_2__2__Impl : ( ( rule__Note__Group_1_2_2__0 )* ) ;
    public final void rule__Note__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4547:1: ( ( ( rule__Note__Group_1_2_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4548:1: ( ( rule__Note__Group_1_2_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4548:1: ( ( rule__Note__Group_1_2_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4549:1: ( rule__Note__Group_1_2_2__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_1_2_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4550:1: ( rule__Note__Group_1_2_2__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==187) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4550:2: rule__Note__Group_1_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_1_2_2__0_in_rule__Note__Group_1_2__2__Impl9764);
            	    rule__Note__Group_1_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4566:1: rule__Note__Group_1_2_2__0 : rule__Note__Group_1_2_2__0__Impl rule__Note__Group_1_2_2__1 ;
    public final void rule__Note__Group_1_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4570:1: ( rule__Note__Group_1_2_2__0__Impl rule__Note__Group_1_2_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4571:2: rule__Note__Group_1_2_2__0__Impl rule__Note__Group_1_2_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2_2__0__Impl_in_rule__Note__Group_1_2_2__09801);
            rule__Note__Group_1_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_2_2__1_in_rule__Note__Group_1_2_2__09804);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4578:1: rule__Note__Group_1_2_2__0__Impl : ( ',' ) ;
    public final void rule__Note__Group_1_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4582:1: ( ( ',' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4583:1: ( ',' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4583:1: ( ',' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4584:1: ','
            {
             before(grammarAccess.getNoteAccess().getCommaKeyword_1_2_2_0()); 
            match(input,187,FOLLOW_187_in_rule__Note__Group_1_2_2__0__Impl9832); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4597:1: rule__Note__Group_1_2_2__1 : rule__Note__Group_1_2_2__1__Impl ;
    public final void rule__Note__Group_1_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4601:1: ( rule__Note__Group_1_2_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4602:2: rule__Note__Group_1_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2_2__1__Impl_in_rule__Note__Group_1_2_2__19863);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4608:1: rule__Note__Group_1_2_2__1__Impl : ( RULE_ID ) ;
    public final void rule__Note__Group_1_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4612:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4613:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4613:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4614:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getIDTerminalRuleCall_1_2_2_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__Group_1_2_2__1__Impl9890); 
             after(grammarAccess.getNoteAccess().getIDTerminalRuleCall_1_2_2_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4629:1: rule__Note__Group_3_0__0 : rule__Note__Group_3_0__0__Impl rule__Note__Group_3_0__1 ;
    public final void rule__Note__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4633:1: ( rule__Note__Group_3_0__0__Impl rule__Note__Group_3_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4634:2: rule__Note__Group_3_0__0__Impl rule__Note__Group_3_0__1
            {
            pushFollow(FOLLOW_rule__Note__Group_3_0__0__Impl_in_rule__Note__Group_3_0__09923);
            rule__Note__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_3_0__1_in_rule__Note__Group_3_0__09926);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4641:1: rule__Note__Group_3_0__0__Impl : ( ':' ) ;
    public final void rule__Note__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4645:1: ( ( ':' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4646:1: ( ':' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4646:1: ( ':' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4647:1: ':'
            {
             before(grammarAccess.getNoteAccess().getColonKeyword_3_0_0()); 
            match(input,169,FOLLOW_169_in_rule__Note__Group_3_0__0__Impl9954); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4660:1: rule__Note__Group_3_0__1 : rule__Note__Group_3_0__1__Impl ;
    public final void rule__Note__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4664:1: ( rule__Note__Group_3_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4665:2: rule__Note__Group_3_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_3_0__1__Impl_in_rule__Note__Group_3_0__19985);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4671:1: rule__Note__Group_3_0__1__Impl : ( RULE_ID ) ;
    public final void rule__Note__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4675:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4676:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4676:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4677:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__Group_3_0__1__Impl10012); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4692:1: rule__Note__Group_3_1__0 : rule__Note__Group_3_1__0__Impl rule__Note__Group_3_1__1 ;
    public final void rule__Note__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4696:1: ( rule__Note__Group_3_1__0__Impl rule__Note__Group_3_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4697:2: rule__Note__Group_3_1__0__Impl rule__Note__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1__0__Impl_in_rule__Note__Group_3_1__010045);
            rule__Note__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_3_1__1_in_rule__Note__Group_3_1__010048);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4704:1: rule__Note__Group_3_1__0__Impl : ( ( rule__Note__Group_3_1_0__0 )* ) ;
    public final void rule__Note__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4708:1: ( ( ( rule__Note__Group_3_1_0__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4709:1: ( ( rule__Note__Group_3_1_0__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4709:1: ( ( rule__Note__Group_3_1_0__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4710:1: ( rule__Note__Group_3_1_0__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_3_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4711:1: ( rule__Note__Group_3_1_0__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_NEWLINE) ) {
                    int LA32_1 = input.LA(2);

                    if ( (LA32_1==RULE_ID) ) {
                        alt32=1;
                    }


                }


                switch (alt32) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4711:2: rule__Note__Group_3_1_0__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_3_1_0__0_in_rule__Note__Group_3_1__0__Impl10075);
            	    rule__Note__Group_3_1_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4721:1: rule__Note__Group_3_1__1 : rule__Note__Group_3_1__1__Impl rule__Note__Group_3_1__2 ;
    public final void rule__Note__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4725:1: ( rule__Note__Group_3_1__1__Impl rule__Note__Group_3_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4726:2: rule__Note__Group_3_1__1__Impl rule__Note__Group_3_1__2
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1__1__Impl_in_rule__Note__Group_3_1__110106);
            rule__Note__Group_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_3_1__2_in_rule__Note__Group_3_1__110109);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4733:1: rule__Note__Group_3_1__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Note__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4737:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4738:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4738:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4739:1: RULE_NEWLINE
            {
             before(grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_3_1_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Note__Group_3_1__1__Impl10136); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4750:1: rule__Note__Group_3_1__2 : rule__Note__Group_3_1__2__Impl ;
    public final void rule__Note__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4754:1: ( rule__Note__Group_3_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4755:2: rule__Note__Group_3_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1__2__Impl_in_rule__Note__Group_3_1__210165);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4761:1: rule__Note__Group_3_1__2__Impl : ( 'end note' ) ;
    public final void rule__Note__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4765:1: ( ( 'end note' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4766:1: ( 'end note' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4766:1: ( 'end note' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4767:1: 'end note'
            {
             before(grammarAccess.getNoteAccess().getEndNoteKeyword_3_1_2()); 
            match(input,189,FOLLOW_189_in_rule__Note__Group_3_1__2__Impl10193); 
             after(grammarAccess.getNoteAccess().getEndNoteKeyword_3_1_2()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4786:1: rule__Note__Group_3_1_0__0 : rule__Note__Group_3_1_0__0__Impl rule__Note__Group_3_1_0__1 ;
    public final void rule__Note__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4790:1: ( rule__Note__Group_3_1_0__0__Impl rule__Note__Group_3_1_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4791:2: rule__Note__Group_3_1_0__0__Impl rule__Note__Group_3_1_0__1
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1_0__0__Impl_in_rule__Note__Group_3_1_0__010230);
            rule__Note__Group_3_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_3_1_0__1_in_rule__Note__Group_3_1_0__010233);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4798:1: rule__Note__Group_3_1_0__0__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Note__Group_3_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4802:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4803:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4803:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4804:1: RULE_NEWLINE
            {
             before(grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_3_1_0_0()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Note__Group_3_1_0__0__Impl10260); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4815:1: rule__Note__Group_3_1_0__1 : rule__Note__Group_3_1_0__1__Impl ;
    public final void rule__Note__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4819:1: ( rule__Note__Group_3_1_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4820:2: rule__Note__Group_3_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1_0__1__Impl_in_rule__Note__Group_3_1_0__110289);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4826:1: rule__Note__Group_3_1_0__1__Impl : ( RULE_ID ) ;
    public final void rule__Note__Group_3_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4830:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4831:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4831:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4832:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__Group_3_1_0__1__Impl10316); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4847:1: rule__Divider__Group__0 : rule__Divider__Group__0__Impl rule__Divider__Group__1 ;
    public final void rule__Divider__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4851:1: ( rule__Divider__Group__0__Impl rule__Divider__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4852:2: rule__Divider__Group__0__Impl rule__Divider__Group__1
            {
            pushFollow(FOLLOW_rule__Divider__Group__0__Impl_in_rule__Divider__Group__010349);
            rule__Divider__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Divider__Group__1_in_rule__Divider__Group__010352);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4859:1: rule__Divider__Group__0__Impl : ( '==' ) ;
    public final void rule__Divider__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4863:1: ( ( '==' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4864:1: ( '==' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4864:1: ( '==' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4865:1: '=='
            {
             before(grammarAccess.getDividerAccess().getEqualsSignEqualsSignKeyword_0()); 
            match(input,190,FOLLOW_190_in_rule__Divider__Group__0__Impl10380); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4878:1: rule__Divider__Group__1 : rule__Divider__Group__1__Impl rule__Divider__Group__2 ;
    public final void rule__Divider__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4882:1: ( rule__Divider__Group__1__Impl rule__Divider__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4883:2: rule__Divider__Group__1__Impl rule__Divider__Group__2
            {
            pushFollow(FOLLOW_rule__Divider__Group__1__Impl_in_rule__Divider__Group__110411);
            rule__Divider__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Divider__Group__2_in_rule__Divider__Group__110414);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4890:1: rule__Divider__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__Divider__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4894:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4895:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4895:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4896:1: RULE_ID
            {
             before(grammarAccess.getDividerAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Divider__Group__1__Impl10441); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4907:1: rule__Divider__Group__2 : rule__Divider__Group__2__Impl ;
    public final void rule__Divider__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4911:1: ( rule__Divider__Group__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4912:2: rule__Divider__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Divider__Group__2__Impl_in_rule__Divider__Group__210470);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4918:1: rule__Divider__Group__2__Impl : ( '==' ) ;
    public final void rule__Divider__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4922:1: ( ( '==' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4923:1: ( '==' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4923:1: ( '==' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4924:1: '=='
            {
             before(grammarAccess.getDividerAccess().getEqualsSignEqualsSignKeyword_2()); 
            match(input,190,FOLLOW_190_in_rule__Divider__Group__2__Impl10498); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4943:1: rule__Reference__Group__0 : rule__Reference__Group__0__Impl rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4947:1: ( rule__Reference__Group__0__Impl rule__Reference__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4948:2: rule__Reference__Group__0__Impl rule__Reference__Group__1
            {
            pushFollow(FOLLOW_rule__Reference__Group__0__Impl_in_rule__Reference__Group__010535);
            rule__Reference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__010538);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4955:1: rule__Reference__Group__0__Impl : ( 'ref over' ) ;
    public final void rule__Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4959:1: ( ( 'ref over' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4960:1: ( 'ref over' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4960:1: ( 'ref over' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4961:1: 'ref over'
            {
             before(grammarAccess.getReferenceAccess().getRefOverKeyword_0()); 
            match(input,191,FOLLOW_191_in_rule__Reference__Group__0__Impl10566); 
             after(grammarAccess.getReferenceAccess().getRefOverKeyword_0()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4974:1: rule__Reference__Group__1 : rule__Reference__Group__1__Impl rule__Reference__Group__2 ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4978:1: ( rule__Reference__Group__1__Impl rule__Reference__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4979:2: rule__Reference__Group__1__Impl rule__Reference__Group__2
            {
            pushFollow(FOLLOW_rule__Reference__Group__1__Impl_in_rule__Reference__Group__110597);
            rule__Reference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__110600);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4986:1: rule__Reference__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4990:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4991:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4991:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4992:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__Group__1__Impl10627); 
             after(grammarAccess.getReferenceAccess().getIDTerminalRuleCall_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5003:1: rule__Reference__Group__2 : rule__Reference__Group__2__Impl rule__Reference__Group__3 ;
    public final void rule__Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5007:1: ( rule__Reference__Group__2__Impl rule__Reference__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5008:2: rule__Reference__Group__2__Impl rule__Reference__Group__3
            {
            pushFollow(FOLLOW_rule__Reference__Group__2__Impl_in_rule__Reference__Group__210656);
            rule__Reference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__210659);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5015:1: rule__Reference__Group__2__Impl : ( ( rule__Reference__Group_2__0 )* ) ;
    public final void rule__Reference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5019:1: ( ( ( rule__Reference__Group_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5020:1: ( ( rule__Reference__Group_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5020:1: ( ( rule__Reference__Group_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5021:1: ( rule__Reference__Group_2__0 )*
            {
             before(grammarAccess.getReferenceAccess().getGroup_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5022:1: ( rule__Reference__Group_2__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==187) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5022:2: rule__Reference__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Reference__Group_2__0_in_rule__Reference__Group__2__Impl10686);
            	    rule__Reference__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getReferenceAccess().getGroup_2()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5032:1: rule__Reference__Group__3 : rule__Reference__Group__3__Impl ;
    public final void rule__Reference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5036:1: ( rule__Reference__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5037:2: rule__Reference__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group__3__Impl_in_rule__Reference__Group__310717);
            rule__Reference__Group__3__Impl();

            state._fsp--;


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5043:1: rule__Reference__Group__3__Impl : ( ( rule__Reference__Alternatives_3 ) ) ;
    public final void rule__Reference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5047:1: ( ( ( rule__Reference__Alternatives_3 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5048:1: ( ( rule__Reference__Alternatives_3 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5048:1: ( ( rule__Reference__Alternatives_3 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5049:1: ( rule__Reference__Alternatives_3 )
            {
             before(grammarAccess.getReferenceAccess().getAlternatives_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5050:1: ( rule__Reference__Alternatives_3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5050:2: rule__Reference__Alternatives_3
            {
            pushFollow(FOLLOW_rule__Reference__Alternatives_3_in_rule__Reference__Group__3__Impl10744);
            rule__Reference__Alternatives_3();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getAlternatives_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__Reference__Group_2__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5068:1: rule__Reference__Group_2__0 : rule__Reference__Group_2__0__Impl rule__Reference__Group_2__1 ;
    public final void rule__Reference__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5072:1: ( rule__Reference__Group_2__0__Impl rule__Reference__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5073:2: rule__Reference__Group_2__0__Impl rule__Reference__Group_2__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_2__0__Impl_in_rule__Reference__Group_2__010782);
            rule__Reference__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_2__1_in_rule__Reference__Group_2__010785);
            rule__Reference__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_2__0"


    // $ANTLR start "rule__Reference__Group_2__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5080:1: rule__Reference__Group_2__0__Impl : ( ',' ) ;
    public final void rule__Reference__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5084:1: ( ( ',' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5085:1: ( ',' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5085:1: ( ',' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5086:1: ','
            {
             before(grammarAccess.getReferenceAccess().getCommaKeyword_2_0()); 
            match(input,187,FOLLOW_187_in_rule__Reference__Group_2__0__Impl10813); 
             after(grammarAccess.getReferenceAccess().getCommaKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_2__0__Impl"


    // $ANTLR start "rule__Reference__Group_2__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5099:1: rule__Reference__Group_2__1 : rule__Reference__Group_2__1__Impl ;
    public final void rule__Reference__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5103:1: ( rule__Reference__Group_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5104:2: rule__Reference__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_2__1__Impl_in_rule__Reference__Group_2__110844);
            rule__Reference__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_2__1"


    // $ANTLR start "rule__Reference__Group_2__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5110:1: rule__Reference__Group_2__1__Impl : ( RULE_ID ) ;
    public final void rule__Reference__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5114:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5115:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5115:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5116:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getIDTerminalRuleCall_2_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__Group_2__1__Impl10871); 
             after(grammarAccess.getReferenceAccess().getIDTerminalRuleCall_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_2__1__Impl"


    // $ANTLR start "rule__Reference__Group_3_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5131:1: rule__Reference__Group_3_0__0 : rule__Reference__Group_3_0__0__Impl rule__Reference__Group_3_0__1 ;
    public final void rule__Reference__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5135:1: ( rule__Reference__Group_3_0__0__Impl rule__Reference__Group_3_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5136:2: rule__Reference__Group_3_0__0__Impl rule__Reference__Group_3_0__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_3_0__0__Impl_in_rule__Reference__Group_3_0__010904);
            rule__Reference__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_3_0__1_in_rule__Reference__Group_3_0__010907);
            rule__Reference__Group_3_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3_0__0"


    // $ANTLR start "rule__Reference__Group_3_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5143:1: rule__Reference__Group_3_0__0__Impl : ( ':' ) ;
    public final void rule__Reference__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5147:1: ( ( ':' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5148:1: ( ':' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5148:1: ( ':' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5149:1: ':'
            {
             before(grammarAccess.getReferenceAccess().getColonKeyword_3_0_0()); 
            match(input,169,FOLLOW_169_in_rule__Reference__Group_3_0__0__Impl10935); 
             after(grammarAccess.getReferenceAccess().getColonKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3_0__0__Impl"


    // $ANTLR start "rule__Reference__Group_3_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5162:1: rule__Reference__Group_3_0__1 : rule__Reference__Group_3_0__1__Impl ;
    public final void rule__Reference__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5166:1: ( rule__Reference__Group_3_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5167:2: rule__Reference__Group_3_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_3_0__1__Impl_in_rule__Reference__Group_3_0__110966);
            rule__Reference__Group_3_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3_0__1"


    // $ANTLR start "rule__Reference__Group_3_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5173:1: rule__Reference__Group_3_0__1__Impl : ( RULE_ID ) ;
    public final void rule__Reference__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5177:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5178:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5178:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5179:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__Group_3_0__1__Impl10993); 
             after(grammarAccess.getReferenceAccess().getIDTerminalRuleCall_3_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3_0__1__Impl"


    // $ANTLR start "rule__Reference__Group_3_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5194:1: rule__Reference__Group_3_1__0 : rule__Reference__Group_3_1__0__Impl rule__Reference__Group_3_1__1 ;
    public final void rule__Reference__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5198:1: ( rule__Reference__Group_3_1__0__Impl rule__Reference__Group_3_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5199:2: rule__Reference__Group_3_1__0__Impl rule__Reference__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_3_1__0__Impl_in_rule__Reference__Group_3_1__011026);
            rule__Reference__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_3_1__1_in_rule__Reference__Group_3_1__011029);
            rule__Reference__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3_1__0"


    // $ANTLR start "rule__Reference__Group_3_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5206:1: rule__Reference__Group_3_1__0__Impl : ( ( rule__Reference__Group_3_1_0__0 )* ) ;
    public final void rule__Reference__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5210:1: ( ( ( rule__Reference__Group_3_1_0__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5211:1: ( ( rule__Reference__Group_3_1_0__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5211:1: ( ( rule__Reference__Group_3_1_0__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5212:1: ( rule__Reference__Group_3_1_0__0 )*
            {
             before(grammarAccess.getReferenceAccess().getGroup_3_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5213:1: ( rule__Reference__Group_3_1_0__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_NEWLINE) ) {
                    int LA34_1 = input.LA(2);

                    if ( (LA34_1==RULE_ID) ) {
                        alt34=1;
                    }


                }


                switch (alt34) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5213:2: rule__Reference__Group_3_1_0__0
            	    {
            	    pushFollow(FOLLOW_rule__Reference__Group_3_1_0__0_in_rule__Reference__Group_3_1__0__Impl11056);
            	    rule__Reference__Group_3_1_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getReferenceAccess().getGroup_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3_1__0__Impl"


    // $ANTLR start "rule__Reference__Group_3_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5223:1: rule__Reference__Group_3_1__1 : rule__Reference__Group_3_1__1__Impl rule__Reference__Group_3_1__2 ;
    public final void rule__Reference__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5227:1: ( rule__Reference__Group_3_1__1__Impl rule__Reference__Group_3_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5228:2: rule__Reference__Group_3_1__1__Impl rule__Reference__Group_3_1__2
            {
            pushFollow(FOLLOW_rule__Reference__Group_3_1__1__Impl_in_rule__Reference__Group_3_1__111087);
            rule__Reference__Group_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_3_1__2_in_rule__Reference__Group_3_1__111090);
            rule__Reference__Group_3_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3_1__1"


    // $ANTLR start "rule__Reference__Group_3_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5235:1: rule__Reference__Group_3_1__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Reference__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5239:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5240:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5240:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5241:1: RULE_NEWLINE
            {
             before(grammarAccess.getReferenceAccess().getNEWLINETerminalRuleCall_3_1_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Reference__Group_3_1__1__Impl11117); 
             after(grammarAccess.getReferenceAccess().getNEWLINETerminalRuleCall_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3_1__1__Impl"


    // $ANTLR start "rule__Reference__Group_3_1__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5252:1: rule__Reference__Group_3_1__2 : rule__Reference__Group_3_1__2__Impl ;
    public final void rule__Reference__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5256:1: ( rule__Reference__Group_3_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5257:2: rule__Reference__Group_3_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_3_1__2__Impl_in_rule__Reference__Group_3_1__211146);
            rule__Reference__Group_3_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3_1__2"


    // $ANTLR start "rule__Reference__Group_3_1__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5263:1: rule__Reference__Group_3_1__2__Impl : ( 'end ref' ) ;
    public final void rule__Reference__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5267:1: ( ( 'end ref' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5268:1: ( 'end ref' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5268:1: ( 'end ref' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5269:1: 'end ref'
            {
             before(grammarAccess.getReferenceAccess().getEndRefKeyword_3_1_2()); 
            match(input,192,FOLLOW_192_in_rule__Reference__Group_3_1__2__Impl11174); 
             after(grammarAccess.getReferenceAccess().getEndRefKeyword_3_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3_1__2__Impl"


    // $ANTLR start "rule__Reference__Group_3_1_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5288:1: rule__Reference__Group_3_1_0__0 : rule__Reference__Group_3_1_0__0__Impl rule__Reference__Group_3_1_0__1 ;
    public final void rule__Reference__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5292:1: ( rule__Reference__Group_3_1_0__0__Impl rule__Reference__Group_3_1_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5293:2: rule__Reference__Group_3_1_0__0__Impl rule__Reference__Group_3_1_0__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_3_1_0__0__Impl_in_rule__Reference__Group_3_1_0__011211);
            rule__Reference__Group_3_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_3_1_0__1_in_rule__Reference__Group_3_1_0__011214);
            rule__Reference__Group_3_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3_1_0__0"


    // $ANTLR start "rule__Reference__Group_3_1_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5300:1: rule__Reference__Group_3_1_0__0__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Reference__Group_3_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5304:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5305:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5305:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5306:1: RULE_NEWLINE
            {
             before(grammarAccess.getReferenceAccess().getNEWLINETerminalRuleCall_3_1_0_0()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Reference__Group_3_1_0__0__Impl11241); 
             after(grammarAccess.getReferenceAccess().getNEWLINETerminalRuleCall_3_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3_1_0__0__Impl"


    // $ANTLR start "rule__Reference__Group_3_1_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5317:1: rule__Reference__Group_3_1_0__1 : rule__Reference__Group_3_1_0__1__Impl ;
    public final void rule__Reference__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5321:1: ( rule__Reference__Group_3_1_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5322:2: rule__Reference__Group_3_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_3_1_0__1__Impl_in_rule__Reference__Group_3_1_0__111270);
            rule__Reference__Group_3_1_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3_1_0__1"


    // $ANTLR start "rule__Reference__Group_3_1_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5328:1: rule__Reference__Group_3_1_0__1__Impl : ( RULE_ID ) ;
    public final void rule__Reference__Group_3_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5332:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5333:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5333:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5334:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__Group_3_1_0__1__Impl11297); 
             after(grammarAccess.getReferenceAccess().getIDTerminalRuleCall_3_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3_1_0__1__Impl"


    // $ANTLR start "rule__Delay__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5349:1: rule__Delay__Group__0 : rule__Delay__Group__0__Impl rule__Delay__Group__1 ;
    public final void rule__Delay__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5353:1: ( rule__Delay__Group__0__Impl rule__Delay__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5354:2: rule__Delay__Group__0__Impl rule__Delay__Group__1
            {
            pushFollow(FOLLOW_rule__Delay__Group__0__Impl_in_rule__Delay__Group__011330);
            rule__Delay__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Delay__Group__1_in_rule__Delay__Group__011333);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5361:1: rule__Delay__Group__0__Impl : ( '...' ) ;
    public final void rule__Delay__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5365:1: ( ( '...' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5366:1: ( '...' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5366:1: ( '...' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5367:1: '...'
            {
             before(grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_0()); 
            match(input,193,FOLLOW_193_in_rule__Delay__Group__0__Impl11361); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5380:1: rule__Delay__Group__1 : rule__Delay__Group__1__Impl rule__Delay__Group__2 ;
    public final void rule__Delay__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5384:1: ( rule__Delay__Group__1__Impl rule__Delay__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5385:2: rule__Delay__Group__1__Impl rule__Delay__Group__2
            {
            pushFollow(FOLLOW_rule__Delay__Group__1__Impl_in_rule__Delay__Group__111392);
            rule__Delay__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Delay__Group__2_in_rule__Delay__Group__111395);
            rule__Delay__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5392:1: rule__Delay__Group__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Delay__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5396:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5397:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5397:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5398:1: ( RULE_ID )*
            {
             before(grammarAccess.getDelayAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5399:1: ( RULE_ID )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_ID) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5399:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Delay__Group__1__Impl11423); 

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getDelayAccess().getIDTerminalRuleCall_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Delay__Group__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5409:1: rule__Delay__Group__2 : rule__Delay__Group__2__Impl ;
    public final void rule__Delay__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5413:1: ( rule__Delay__Group__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5414:2: rule__Delay__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Delay__Group__2__Impl_in_rule__Delay__Group__211454);
            rule__Delay__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Delay__Group__2"


    // $ANTLR start "rule__Delay__Group__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5420:1: rule__Delay__Group__2__Impl : ( '...' ) ;
    public final void rule__Delay__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5424:1: ( ( '...' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5425:1: ( '...' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5425:1: ( '...' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5426:1: '...'
            {
             before(grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_2()); 
            match(input,193,FOLLOW_193_in_rule__Delay__Group__2__Impl11482); 
             after(grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Delay__Group__2__Impl"


    // $ANTLR start "rule__Space__Group_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5445:1: rule__Space__Group_1__0 : rule__Space__Group_1__0__Impl rule__Space__Group_1__1 ;
    public final void rule__Space__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5449:1: ( rule__Space__Group_1__0__Impl rule__Space__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5450:2: rule__Space__Group_1__0__Impl rule__Space__Group_1__1
            {
            pushFollow(FOLLOW_rule__Space__Group_1__0__Impl_in_rule__Space__Group_1__011519);
            rule__Space__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Space__Group_1__1_in_rule__Space__Group_1__011522);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5457:1: rule__Space__Group_1__0__Impl : ( '||' ) ;
    public final void rule__Space__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5461:1: ( ( '||' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5462:1: ( '||' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5462:1: ( '||' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5463:1: '||'
            {
             before(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineKeyword_1_0()); 
            match(input,194,FOLLOW_194_in_rule__Space__Group_1__0__Impl11550); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5476:1: rule__Space__Group_1__1 : rule__Space__Group_1__1__Impl rule__Space__Group_1__2 ;
    public final void rule__Space__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5480:1: ( rule__Space__Group_1__1__Impl rule__Space__Group_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5481:2: rule__Space__Group_1__1__Impl rule__Space__Group_1__2
            {
            pushFollow(FOLLOW_rule__Space__Group_1__1__Impl_in_rule__Space__Group_1__111581);
            rule__Space__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Space__Group_1__2_in_rule__Space__Group_1__111584);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5488:1: rule__Space__Group_1__1__Impl : ( RULE_INT ) ;
    public final void rule__Space__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5492:1: ( ( RULE_INT ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5493:1: ( RULE_INT )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5493:1: ( RULE_INT )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5494:1: RULE_INT
            {
             before(grammarAccess.getSpaceAccess().getINTTerminalRuleCall_1_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Space__Group_1__1__Impl11611); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5505:1: rule__Space__Group_1__2 : rule__Space__Group_1__2__Impl ;
    public final void rule__Space__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5509:1: ( rule__Space__Group_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5510:2: rule__Space__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Space__Group_1__2__Impl_in_rule__Space__Group_1__211640);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5516:1: rule__Space__Group_1__2__Impl : ( '||' ) ;
    public final void rule__Space__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5520:1: ( ( '||' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5521:1: ( '||' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5521:1: ( '||' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5522:1: '||'
            {
             before(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineKeyword_1_2()); 
            match(input,194,FOLLOW_194_in_rule__Space__Group_1__2__Impl11668); 
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


    // $ANTLR start "rule__Model__DiagramsAssignment"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5542:1: rule__Model__DiagramsAssignment : ( ruleDiagram ) ;
    public final void rule__Model__DiagramsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5546:1: ( ( ruleDiagram ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5547:1: ( ruleDiagram )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5547:1: ( ruleDiagram )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5548:1: ruleDiagram
            {
             before(grammarAccess.getModelAccess().getDiagramsDiagramParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDiagram_in_rule__Model__DiagramsAssignment11710);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5557:1: rule__Diagram__InstructionsAssignment_2 : ( ruleInstruction ) ;
    public final void rule__Diagram__InstructionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5561:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5562:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5562:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5563:1: ruleInstruction
            {
             before(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_211741);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5572:1: rule__Instruction__Name1Assignment_0_0_0 : ( RULE_ID ) ;
    public final void rule__Instruction__Name1Assignment_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5576:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5577:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5577:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5578:1: RULE_ID
            {
             before(grammarAccess.getInstructionAccess().getName1IDTerminalRuleCall_0_0_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Instruction__Name1Assignment_0_0_011772); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5587:1: rule__Instruction__Name2Assignment_0_0_2 : ( RULE_ID ) ;
    public final void rule__Instruction__Name2Assignment_0_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5591:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5592:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5592:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5593:1: RULE_ID
            {
             before(grammarAccess.getInstructionAccess().getName2IDTerminalRuleCall_0_0_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Instruction__Name2Assignment_0_0_211803); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5602:1: rule__Definition__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5606:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5607:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5607:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5608:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_0_111834); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5617:1: rule__Definition__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5621:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5622:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5622:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5623:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_1_111865); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5632:1: rule__Definition__NameAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5636:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5637:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5637:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5638:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_2_111896); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5647:1: rule__Definition__NameAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5651:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5652:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5652:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5653:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_3_111927); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5662:1: rule__Definition__NameAssignment_4_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5666:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5667:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5667:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5668:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_4_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_4_111958); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5677:1: rule__Definition__NameAssignment_5_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5681:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5682:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5682:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5683:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_5_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_5_111989); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5692:1: rule__AltElse__InstructionsAssignment_3 : ( ruleInstruction ) ;
    public final void rule__AltElse__InstructionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5696:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5697:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5697:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5698:1: ruleInstruction
            {
             before(grammarAccess.getAltElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__AltElse__InstructionsAssignment_312020);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5707:1: rule__AltElse__ElsesAssignment_4 : ( ruleElse ) ;
    public final void rule__AltElse__ElsesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5711:1: ( ( ruleElse ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5712:1: ( ruleElse )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5712:1: ( ruleElse )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5713:1: ruleElse
            {
             before(grammarAccess.getAltElseAccess().getElsesElseParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleElse_in_rule__AltElse__ElsesAssignment_412051);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5722:1: rule__Else__InstructionsAssignment_3 : ( ruleInstruction ) ;
    public final void rule__Else__InstructionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5726:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5727:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5727:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5728:1: ruleInstruction
            {
             before(grammarAccess.getElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__Else__InstructionsAssignment_312082);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5737:1: rule__GroupingMessages__InstructionsAssignment_3 : ( ruleInstruction ) ;
    public final void rule__GroupingMessages__InstructionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5741:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5742:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5742:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5743:1: ruleInstruction
            {
             before(grammarAccess.getGroupingMessagesAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__GroupingMessages__InstructionsAssignment_312113);
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

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DiagramsAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_ruleDiagram_in_entryRuleDiagram122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDiagram129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__0_in_ruleDiagram155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group__0_in_ruleInstruction215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Alternatives_in_ruleDefinition275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAutoNumber309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__0_in_ruleAutoNumber335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_entryRuleColor362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColor369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Color__Group__0_in_ruleColor395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_entryRuleTitle422 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTitle429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__0_in_ruleTitle455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLegend_in_entryRuleLegend482 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLegend489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__0_in_ruleLegend515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_entryRuleNewpage542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNewpage549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__0_in_ruleNewpage575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAltElse_in_entryRuleAltElse602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAltElse609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__0_in_ruleAltElse635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElse_in_entryRuleElse662 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElse669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__0_in_ruleElse695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages722 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroupingMessages729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__0_in_ruleGroupingMessages755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNote_in_entryRuleNote784 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNote791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__0_in_ruleNote817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDivider_in_entryRuleDivider844 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDivider851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Divider__Group__0_in_ruleDivider877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference904 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__0_in_ruleReference937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDelay_in_entryRuleDelay964 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDelay971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group__0_in_ruleDelay997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpace_in_entryRuleSpace1024 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpace1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Alternatives_in_ruleSpace1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox1084 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHidefootbox1091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleHidefootbox1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__0_in_rule__Instruction__Alternatives_01155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__0_in_rule__Instruction__Alternatives_01173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_rule__Instruction__Alternatives_01191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_rule__Instruction__Alternatives_01208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLegend_in_rule__Instruction__Alternatives_01225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_rule__Instruction__Alternatives_01242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAltElse_in_rule__Instruction__Alternatives_01259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_rule__Instruction__Alternatives_01276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNote_in_rule__Instruction__Alternatives_01293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDivider_in_rule__Instruction__Alternatives_01310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_rule__Instruction__Alternatives_01327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDelay_in_rule__Instruction__Alternatives_01344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpace_in_rule__Instruction__Alternatives_01361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_rule__Instruction__Alternatives_01378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives1410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives1428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives1446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives1464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives1482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__0_in_rule__Definition__Alternatives1500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Color__Alternatives_11534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Color__Alternatives_11554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Color__Alternatives_11574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Color__Alternatives_11594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Color__Alternatives_11614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Color__Alternatives_11634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Color__Alternatives_11654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Color__Alternatives_11674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Color__Alternatives_11694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Color__Alternatives_11714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Color__Alternatives_11734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Color__Alternatives_11754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Color__Alternatives_11774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Color__Alternatives_11794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Color__Alternatives_11814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Color__Alternatives_11834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Color__Alternatives_11854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Color__Alternatives_11874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Color__Alternatives_11894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Color__Alternatives_11914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Color__Alternatives_11934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Color__Alternatives_11954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Color__Alternatives_11974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Color__Alternatives_11994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Color__Alternatives_12014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Color__Alternatives_12034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Color__Alternatives_12054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__Color__Alternatives_12074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Color__Alternatives_12094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__Color__Alternatives_12114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__Color__Alternatives_12134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__Color__Alternatives_12154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__Color__Alternatives_12174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__Color__Alternatives_12194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__Color__Alternatives_12214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__Color__Alternatives_12234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__Color__Alternatives_12254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__Color__Alternatives_12274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__Color__Alternatives_12294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__Color__Alternatives_12314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__Color__Alternatives_12334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__Color__Alternatives_12354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_rule__Color__Alternatives_12374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rule__Color__Alternatives_12394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_rule__Color__Alternatives_12414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_rule__Color__Alternatives_12434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_rule__Color__Alternatives_12454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_rule__Color__Alternatives_12474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_rule__Color__Alternatives_12494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_rule__Color__Alternatives_12514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_rule__Color__Alternatives_12534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_rule__Color__Alternatives_12554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_rule__Color__Alternatives_12574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_rule__Color__Alternatives_12594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_rule__Color__Alternatives_12614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_rule__Color__Alternatives_12634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_rule__Color__Alternatives_12654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_rule__Color__Alternatives_12674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_rule__Color__Alternatives_12694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_rule__Color__Alternatives_12714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_rule__Color__Alternatives_12734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_rule__Color__Alternatives_12754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_rule__Color__Alternatives_12774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_rule__Color__Alternatives_12794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_rule__Color__Alternatives_12814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_rule__Color__Alternatives_12834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_rule__Color__Alternatives_12854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_rule__Color__Alternatives_12874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_rule__Color__Alternatives_12894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_rule__Color__Alternatives_12914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_rule__Color__Alternatives_12934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_rule__Color__Alternatives_12954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_rule__Color__Alternatives_12974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_rule__Color__Alternatives_12994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_rule__Color__Alternatives_13014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_rule__Color__Alternatives_13034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_rule__Color__Alternatives_13054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_rule__Color__Alternatives_13074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_rule__Color__Alternatives_13094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_rule__Color__Alternatives_13114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_rule__Color__Alternatives_13134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_rule__Color__Alternatives_13154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_rule__Color__Alternatives_13174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_rule__Color__Alternatives_13194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_rule__Color__Alternatives_13214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_rule__Color__Alternatives_13234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_rule__Color__Alternatives_13254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_rule__Color__Alternatives_13274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_rule__Color__Alternatives_13294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_rule__Color__Alternatives_13314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_rule__Color__Alternatives_13334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_rule__Color__Alternatives_13354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_rule__Color__Alternatives_13374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_rule__Color__Alternatives_13394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_rule__Color__Alternatives_13414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_rule__Color__Alternatives_13434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_rule__Color__Alternatives_13454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_rule__Color__Alternatives_13474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_rule__Color__Alternatives_13494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_rule__Color__Alternatives_13514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_rule__Color__Alternatives_13534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_rule__Color__Alternatives_13554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_rule__Color__Alternatives_13574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_rule__Color__Alternatives_13594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_rule__Color__Alternatives_13614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_rule__Color__Alternatives_13634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_rule__Color__Alternatives_13654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_rule__Color__Alternatives_13674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_rule__Color__Alternatives_13694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_rule__Color__Alternatives_13714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_rule__Color__Alternatives_13734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_rule__Color__Alternatives_13754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_rule__Color__Alternatives_13774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_rule__Color__Alternatives_13794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_rule__Color__Alternatives_13814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_rule__Color__Alternatives_13834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_rule__Color__Alternatives_13854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_rule__Color__Alternatives_13874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_rule__Color__Alternatives_13894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_rule__Color__Alternatives_13914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_rule__Color__Alternatives_13934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_134_in_rule__Color__Alternatives_13954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_135_in_rule__Color__Alternatives_13974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_136_in_rule__Color__Alternatives_13994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_137_in_rule__Color__Alternatives_14014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_138_in_rule__Color__Alternatives_14034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_139_in_rule__Color__Alternatives_14054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_140_in_rule__Color__Alternatives_14074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_141_in_rule__Color__Alternatives_14094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_142_in_rule__Color__Alternatives_14114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_143_in_rule__Color__Alternatives_14134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_144_in_rule__Color__Alternatives_14154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_145_in_rule__Color__Alternatives_14174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_146_in_rule__Color__Alternatives_14194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_147_in_rule__Color__Alternatives_14214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_148_in_rule__Color__Alternatives_14234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_149_in_rule__Color__Alternatives_14254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_150_in_rule__Color__Alternatives_14274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_151_in_rule__Color__Alternatives_14294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_152_in_rule__Color__Alternatives_14314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_153_in_rule__Color__Alternatives_14334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_154_in_rule__Color__Alternatives_14354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_155_in_rule__Color__Alternatives_14374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_156_in_rule__Color__Alternatives_14394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_157_in_rule__Color__Alternatives_14414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_rule__Legend__Alternatives_14449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Legend__Alternatives_14469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_rule__Legend__Alternatives_14489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2_0__0_in_rule__Legend__Alternatives_24523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Legend__Alternatives_24541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_rule__GroupingMessages__Alternatives_04574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__GroupingMessages__Alternatives_04594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__GroupingMessages__Alternatives_04614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__GroupingMessages__Alternatives_04634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__GroupingMessages__Alternatives_04654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0__0_in_rule__Note__Alternatives_14688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1__0_in_rule__Note__Alternatives_14706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__0_in_rule__Note__Alternatives_14724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_0__0_in_rule__Note__Alternatives_34757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__0_in_rule__Note__Alternatives_34775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3_0__0_in_rule__Reference__Alternatives_34808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3_1__0_in_rule__Reference__Alternatives_34826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_166_in_rule__Space__Alternatives4860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__0_in_rule__Space__Alternatives4879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__04910 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__04913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_167_in_rule__Diagram__Group__0__Impl4941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__14972 = new BitSet(new long[]{0x0000000000001050L,0x0000000000000000L,0xC26DFD7E00000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__14975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__1__Impl5002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__25031 = new BitSet(new long[]{0x0000000000001050L,0x0000000000000000L,0xC26DFD7E00000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_rule__Diagram__Group__3_in_rule__Diagram__Group__25034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__InstructionsAssignment_2_in_rule__Diagram__Group__2__Impl5061 = new BitSet(new long[]{0x0000000000001052L,0x0000000000000000L,0xC26DFC7E00000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_rule__Diagram__Group__3__Impl_in_rule__Diagram__Group__35092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_rule__Diagram__Group__3__Impl5120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group__0__Impl_in_rule__Instruction__Group__05159 = new BitSet(new long[]{0x0000000000001050L,0x0000000000000000L,0xC26DFC7E00000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_rule__Instruction__Group__1_in_rule__Instruction__Group__05162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Alternatives_0_in_rule__Instruction__Group__0__Impl5189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group__1__Impl_in_rule__Instruction__Group__15220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Instruction__Group__1__Impl5247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__0__Impl_in_rule__Instruction__Group_0_0__05280 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__1_in_rule__Instruction__Group_0_0__05283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Name1Assignment_0_0_0_in_rule__Instruction__Group_0_0__0__Impl5310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__1__Impl_in_rule__Instruction__Group_0_0__15340 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__2_in_rule__Instruction__Group_0_0__15343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SEQUENCE_in_rule__Instruction__Group_0_0__1__Impl5370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__2__Impl_in_rule__Instruction__Group_0_0__25399 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__3_in_rule__Instruction__Group_0_0__25402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Name2Assignment_0_0_2_in_rule__Instruction__Group_0_0__2__Impl5429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__3__Impl_in_rule__Instruction__Group_0_0__35459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0_3__0_in_rule__Instruction__Group_0_0__3__Impl5486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0_3__0__Impl_in_rule__Instruction__Group_0_0_3__05525 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0_3__1_in_rule__Instruction__Group_0_0_3__05528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_169_in_rule__Instruction__Group_0_0_3__0__Impl5556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0_3__1__Impl_in_rule__Instruction__Group_0_0_3__15587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Instruction__Group_0_0_3__1__Impl5614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__0__Impl_in_rule__Instruction__Group_0_1__05647 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__1_in_rule__Instruction__Group_0_1__05650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_rule__Instruction__Group_0_1__0__Impl5677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__1__Impl_in_rule__Instruction__Group_0_1__15706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__Instruction__Group_0_1__1__Impl5734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__05769 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__05772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_170_in_rule__Definition__Group_0__0__Impl5800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__15831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl5858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__05892 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__05895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_171_in_rule__Definition__Group_1__0__Impl5923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__15954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl5981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__06015 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__06018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_172_in_rule__Definition__Group_2__0__Impl6046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__16077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl6104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__06138 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__06141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_173_in_rule__Definition__Group_3__0__Impl6169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__16200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl6227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__06261 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__06264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_174_in_rule__Definition__Group_4__0__Impl6292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__16323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl6350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__0__Impl_in_rule__Definition__Group_5__06384 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__1_in_rule__Definition__Group_5__06387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_175_in_rule__Definition__Group_5__0__Impl6415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__1__Impl_in_rule__Definition__Group_5__16446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_5_1_in_rule__Definition__Group_5__1__Impl6473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__0__Impl_in_rule__AutoNumber__Group__06507 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__1_in_rule__AutoNumber__Group__06510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_176_in_rule__AutoNumber__Group__0__Impl6538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__1__Impl_in_rule__AutoNumber__Group__16569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__0_in_rule__AutoNumber__Group__1__Impl6596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__0__Impl_in_rule__AutoNumber__Group_1__06631 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__1_in_rule__AutoNumber__Group_1__06634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__0__Impl6661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__1__Impl_in_rule__AutoNumber__Group_1__16690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__1__Impl6718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Color__Group__0__Impl_in_rule__Color__Group__06753 = new BitSet(new long[]{0xFFFFFFFFFFFFE000L,0xFFFFFFFFFFFFFFFFL,0x000000003FFFFFFFL});
    public static final BitSet FOLLOW_rule__Color__Group__1_in_rule__Color__Group__06756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_177_in_rule__Color__Group__0__Impl6787 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_177_in_rule__Color__Group__0__Impl6803 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_rule__Color__Group__1__Impl_in_rule__Color__Group__16838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Color__Alternatives_1_in_rule__Color__Group__1__Impl6865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__0__Impl_in_rule__Title__Group__06899 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Title__Group__1_in_rule__Title__Group__06902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_178_in_rule__Title__Group__0__Impl6930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__1__Impl_in_rule__Title__Group__16961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Title__Group__1__Impl6988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__0__Impl_in_rule__Legend__Group__07021 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x00000001C0000000L});
    public static final BitSet FOLLOW_rule__Legend__Group__1_in_rule__Legend__Group__07024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_179_in_rule__Legend__Group__0__Impl7052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__1__Impl_in_rule__Legend__Group__17083 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x00000001C0000000L});
    public static final BitSet FOLLOW_rule__Legend__Group__2_in_rule__Legend__Group__17086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Alternatives_1_in_rule__Legend__Group__1__Impl7113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__2__Impl_in_rule__Legend__Group__27144 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x00000001C0000000L});
    public static final BitSet FOLLOW_rule__Legend__Group__3_in_rule__Legend__Group__27147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Alternatives_2_in_rule__Legend__Group__2__Impl7174 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Legend__Group__3__Impl_in_rule__Legend__Group__37205 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_rule__Legend__Group__4_in_rule__Legend__Group__37208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Legend__Group__3__Impl7235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__4__Impl_in_rule__Legend__Group__47264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_180_in_rule__Legend__Group__4__Impl7292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2_0__0__Impl_in_rule__Legend__Group_2_0__07333 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Legend__Group_2_0__1_in_rule__Legend__Group_2_0__07336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Legend__Group_2_0__0__Impl7363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2_0__1__Impl_in_rule__Legend__Group_2_0__17392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Legend__Group_2_0__1__Impl7419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__0__Impl_in_rule__Newpage__Group__07452 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Newpage__Group__1_in_rule__Newpage__Group__07455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_181_in_rule__Newpage__Group__0__Impl7483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__1__Impl_in_rule__Newpage__Group__17514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Newpage__Group__1__Impl7542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__0__Impl_in_rule__AltElse__Group__07577 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__AltElse__Group__1_in_rule__AltElse__Group__07580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_182_in_rule__AltElse__Group__0__Impl7608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__1__Impl_in_rule__AltElse__Group__17639 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__AltElse__Group__2_in_rule__AltElse__Group__17642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AltElse__Group__1__Impl7669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__2__Impl_in_rule__AltElse__Group__27698 = new BitSet(new long[]{0x0000000000001050L,0x0000000000000000L,0xC3EDFC7E00000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_rule__AltElse__Group__3_in_rule__AltElse__Group__27701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__AltElse__Group__2__Impl7728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__3__Impl_in_rule__AltElse__Group__37757 = new BitSet(new long[]{0x0000000000001050L,0x0000000000000000L,0xC3EDFC7E00000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_rule__AltElse__Group__4_in_rule__AltElse__Group__37760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__InstructionsAssignment_3_in_rule__AltElse__Group__3__Impl7787 = new BitSet(new long[]{0x0000000000001052L,0x0000000000000000L,0xC26DFC7E00000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_rule__AltElse__Group__4__Impl_in_rule__AltElse__Group__47818 = new BitSet(new long[]{0x0000000000001050L,0x0000000000000000L,0xC3EDFC7E00000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_rule__AltElse__Group__5_in_rule__AltElse__Group__47821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__ElsesAssignment_4_in_rule__AltElse__Group__4__Impl7848 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_rule__AltElse__Group__5__Impl_in_rule__AltElse__Group__57879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_183_in_rule__AltElse__Group__5__Impl7907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__0__Impl_in_rule__Else__Group__07950 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Else__Group__1_in_rule__Else__Group__07953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_184_in_rule__Else__Group__0__Impl7981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__1__Impl_in_rule__Else__Group__18012 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Else__Group__2_in_rule__Else__Group__18015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Else__Group__1__Impl8042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__2__Impl_in_rule__Else__Group__28071 = new BitSet(new long[]{0x0000000000001050L,0x0000000000000000L,0xC26DFC7E00000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_rule__Else__Group__3_in_rule__Else__Group__28074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Else__Group__2__Impl8101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__3__Impl_in_rule__Else__Group__38130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__InstructionsAssignment_3_in_rule__Else__Group__3__Impl8157 = new BitSet(new long[]{0x0000000000001052L,0x0000000000000000L,0xC26DFC7E00000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__0__Impl_in_rule__GroupingMessages__Group__08196 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__1_in_rule__GroupingMessages__Group__08199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Alternatives_0_in_rule__GroupingMessages__Group__0__Impl8226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__1__Impl_in_rule__GroupingMessages__Group__18256 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__2_in_rule__GroupingMessages__Group__18259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__GroupingMessages__Group__1__Impl8286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__2__Impl_in_rule__GroupingMessages__Group__28315 = new BitSet(new long[]{0x0000000000001050L,0x0000000000000000L,0xC2EDFC7E00000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__3_in_rule__GroupingMessages__Group__28318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__GroupingMessages__Group__2__Impl8345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__3__Impl_in_rule__GroupingMessages__Group__38374 = new BitSet(new long[]{0x0000000000001050L,0x0000000000000000L,0xC2EDFC7E00000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__4_in_rule__GroupingMessages__Group__38377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__InstructionsAssignment_3_in_rule__GroupingMessages__Group__3__Impl8404 = new BitSet(new long[]{0x0000000000001052L,0x0000000000000000L,0xC26DFC7E00000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__4__Impl_in_rule__GroupingMessages__Group__48435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_183_in_rule__GroupingMessages__Group__4__Impl8463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__0__Impl_in_rule__Note__Group__08505 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x10000000C0000000L});
    public static final BitSet FOLLOW_rule__Note__Group__1_in_rule__Note__Group__08508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_185_in_rule__Note__Group__0__Impl8536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__1__Impl_in_rule__Note__Group__18567 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x0002020000000000L});
    public static final BitSet FOLLOW_rule__Note__Group__2_in_rule__Note__Group__18570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Alternatives_1_in_rule__Note__Group__1__Impl8597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__2__Impl_in_rule__Note__Group__28627 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x0002020000000000L});
    public static final BitSet FOLLOW_rule__Note__Group__3_in_rule__Note__Group__28630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__Note__Group__2__Impl8658 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group__3__Impl_in_rule__Note__Group__38689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Alternatives_3_in_rule__Note__Group__3__Impl8716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0__0__Impl_in_rule__Note__Group_1_0__08754 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0__1_in_rule__Note__Group_1_0__08757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_rule__Note__Group_1_0__0__Impl8785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0__1__Impl_in_rule__Note__Group_1_0__18816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__0_in_rule__Note__Group_1_0__1__Impl8843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__0__Impl_in_rule__Note__Group_1_0_1__08878 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__1_in_rule__Note__Group_1_0_1__08881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_186_in_rule__Note__Group_1_0_1__0__Impl8909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__1__Impl_in_rule__Note__Group_1_0_1__18940 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__2_in_rule__Note__Group_1_0_1__18943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__Group_1_0_1__1__Impl8970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__2__Impl_in_rule__Note__Group_1_0_1__28999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1_2__0_in_rule__Note__Group_1_0_1__2__Impl9026 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1_2__0__Impl_in_rule__Note__Group_1_0_1_2__09063 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1_2__1_in_rule__Note__Group_1_0_1_2__09066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_187_in_rule__Note__Group_1_0_1_2__0__Impl9094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1_2__1__Impl_in_rule__Note__Group_1_0_1_2__19125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__Group_1_0_1_2__1__Impl9152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1__0__Impl_in_rule__Note__Group_1_1__09185 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1__1_in_rule__Note__Group_1_1__09188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Note__Group_1_1__0__Impl9216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1__1__Impl_in_rule__Note__Group_1_1__19247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__0_in_rule__Note__Group_1_1__1__Impl9274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__0__Impl_in_rule__Note__Group_1_1_1__09309 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__1_in_rule__Note__Group_1_1_1__09312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_186_in_rule__Note__Group_1_1_1__0__Impl9340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__1__Impl_in_rule__Note__Group_1_1_1__19371 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__2_in_rule__Note__Group_1_1_1__19374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__Group_1_1_1__1__Impl9401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__2__Impl_in_rule__Note__Group_1_1_1__29430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1_2__0_in_rule__Note__Group_1_1_1__2__Impl9457 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1_2__0__Impl_in_rule__Note__Group_1_1_1_2__09494 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1_2__1_in_rule__Note__Group_1_1_1_2__09497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_187_in_rule__Note__Group_1_1_1_2__0__Impl9525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1_2__1__Impl_in_rule__Note__Group_1_1_1_2__19556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__Group_1_1_1_2__1__Impl9583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__0__Impl_in_rule__Note__Group_1_2__09616 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__1_in_rule__Note__Group_1_2__09619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_188_in_rule__Note__Group_1_2__0__Impl9647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__1__Impl_in_rule__Note__Group_1_2__19678 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__2_in_rule__Note__Group_1_2__19681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__Group_1_2__1__Impl9708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__2__Impl_in_rule__Note__Group_1_2__29737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2_2__0_in_rule__Note__Group_1_2__2__Impl9764 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2_2__0__Impl_in_rule__Note__Group_1_2_2__09801 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2_2__1_in_rule__Note__Group_1_2_2__09804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_187_in_rule__Note__Group_1_2_2__0__Impl9832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2_2__1__Impl_in_rule__Note__Group_1_2_2__19863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__Group_1_2_2__1__Impl9890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_0__0__Impl_in_rule__Note__Group_3_0__09923 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Note__Group_3_0__1_in_rule__Note__Group_3_0__09926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_169_in_rule__Note__Group_3_0__0__Impl9954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_0__1__Impl_in_rule__Note__Group_3_0__19985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__Group_3_0__1__Impl10012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__0__Impl_in_rule__Note__Group_3_1__010045 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x0002020000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__1_in_rule__Note__Group_3_1__010048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1_0__0_in_rule__Note__Group_3_1__0__Impl10075 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__1__Impl_in_rule__Note__Group_3_1__110106 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__2_in_rule__Note__Group_3_1__110109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Note__Group_3_1__1__Impl10136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__2__Impl_in_rule__Note__Group_3_1__210165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_189_in_rule__Note__Group_3_1__2__Impl10193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1_0__0__Impl_in_rule__Note__Group_3_1_0__010230 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1_0__1_in_rule__Note__Group_3_1_0__010233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Note__Group_3_1_0__0__Impl10260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1_0__1__Impl_in_rule__Note__Group_3_1_0__110289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__Group_3_1_0__1__Impl10316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Divider__Group__0__Impl_in_rule__Divider__Group__010349 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Divider__Group__1_in_rule__Divider__Group__010352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_190_in_rule__Divider__Group__0__Impl10380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Divider__Group__1__Impl_in_rule__Divider__Group__110411 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_rule__Divider__Group__2_in_rule__Divider__Group__110414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Divider__Group__1__Impl10441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Divider__Group__2__Impl_in_rule__Divider__Group__210470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_190_in_rule__Divider__Group__2__Impl10498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__0__Impl_in_rule__Reference__Group__010535 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__010538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_191_in_rule__Reference__Group__0__Impl10566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__1__Impl_in_rule__Reference__Group__110597 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x0800020000000000L});
    public static final BitSet FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__110600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__Group__1__Impl10627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__2__Impl_in_rule__Reference__Group__210656 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x0800020000000000L});
    public static final BitSet FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__210659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_2__0_in_rule__Reference__Group__2__Impl10686 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Reference__Group__3__Impl_in_rule__Reference__Group__310717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Alternatives_3_in_rule__Reference__Group__3__Impl10744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_2__0__Impl_in_rule__Reference__Group_2__010782 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Reference__Group_2__1_in_rule__Reference__Group_2__010785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_187_in_rule__Reference__Group_2__0__Impl10813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_2__1__Impl_in_rule__Reference__Group_2__110844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__Group_2__1__Impl10871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3_0__0__Impl_in_rule__Reference__Group_3_0__010904 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Reference__Group_3_0__1_in_rule__Reference__Group_3_0__010907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_169_in_rule__Reference__Group_3_0__0__Impl10935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3_0__1__Impl_in_rule__Reference__Group_3_0__110966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__Group_3_0__1__Impl10993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3_1__0__Impl_in_rule__Reference__Group_3_1__011026 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x0800020000000000L});
    public static final BitSet FOLLOW_rule__Reference__Group_3_1__1_in_rule__Reference__Group_3_1__011029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3_1_0__0_in_rule__Reference__Group_3_1__0__Impl11056 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Reference__Group_3_1__1__Impl_in_rule__Reference__Group_3_1__111087 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_rule__Reference__Group_3_1__2_in_rule__Reference__Group_3_1__111090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Reference__Group_3_1__1__Impl11117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3_1__2__Impl_in_rule__Reference__Group_3_1__211146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_192_in_rule__Reference__Group_3_1__2__Impl11174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3_1_0__0__Impl_in_rule__Reference__Group_3_1_0__011211 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Reference__Group_3_1_0__1_in_rule__Reference__Group_3_1_0__011214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Reference__Group_3_1_0__0__Impl11241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3_1_0__1__Impl_in_rule__Reference__Group_3_1_0__111270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__Group_3_1_0__1__Impl11297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group__0__Impl_in_rule__Delay__Group__011330 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group__1_in_rule__Delay__Group__011333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_193_in_rule__Delay__Group__0__Impl11361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group__1__Impl_in_rule__Delay__Group__111392 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group__2_in_rule__Delay__Group__111395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Delay__Group__1__Impl11423 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__Delay__Group__2__Impl_in_rule__Delay__Group__211454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_193_in_rule__Delay__Group__2__Impl11482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__0__Impl_in_rule__Space__Group_1__011519 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Space__Group_1__1_in_rule__Space__Group_1__011522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_194_in_rule__Space__Group_1__0__Impl11550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__1__Impl_in_rule__Space__Group_1__111581 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_rule__Space__Group_1__2_in_rule__Space__Group_1__111584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Space__Group_1__1__Impl11611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__2__Impl_in_rule__Space__Group_1__211640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_194_in_rule__Space__Group_1__2__Impl11668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_rule__Model__DiagramsAssignment11710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_211741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Instruction__Name1Assignment_0_0_011772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Instruction__Name2Assignment_0_0_211803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_0_111834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_1_111865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_2_111896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_3_111927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_4_111958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_5_111989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__AltElse__InstructionsAssignment_312020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElse_in_rule__AltElse__ElsesAssignment_412051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__Else__InstructionsAssignment_312082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__GroupingMessages__InstructionsAssignment_312113 = new BitSet(new long[]{0x0000000000000002L});

}