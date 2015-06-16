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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NEWLINE", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "'AliceBlue'", "'AntiqueWhite'", "'Aqua'", "'Aquamarine'", "'Azure'", "'Beige'", "'Bisque'", "'Black'", "'BlanchedAlmond'", "'Blue'", "'BlueViolet'", "'Brown'", "'BurlyWood'", "'CadetBlue'", "'Chartreuse'", "'Chocolate'", "'Coral'", "'CornflowerBlue'", "'Cornsilk'", "'Crimson'", "'Cyan'", "'DarkBlue'", "'DarkCyan'", "'DarkGoldenRod'", "'DarkGray'", "'DarkGreen'", "'DarkGrey'", "'DarkKhaki'", "'DarkMagenta'", "'DarkOliveGreen'", "'DarkOrchid'", "'DarkRed'", "'DarkSalmo'", "'DarkSeaGreen'", "'DarkSlateBlue'", "'DarkSlateGray'", "'DarkSlateGrey'", "'DarkTurquoise'", "'DarkViolet'", "'Darkorange'", "'DeepPink'", "'DeepSkyBlue'", "'DimGray'", "'DimGrey'", "'DodgerBlue'", "'FireBrick'", "'FloralWhite'", "'ForestGreen'", "'Fuchsia'", "'Gainsboro'", "'GhostWhite'", "'Gold'", "'GoldenRod'", "'Gray'", "'Green'", "'GreenYellow'", "'Grey'", "'HoneyDew'", "'HotPink'", "'IndianRed'", "'Indigo'", "'Ivory'", "'Khaki'", "'Lavender'", "'LavenderBlush'", "'LawnGreen'", "'LemonChiffon'", "'LightBlue'", "'LightCoral'", "'LightCyan'", "'LightGoldenRodYellow'", "'LightGray'", "'LightGreen'", "'LightGrey'", "'LightPink'", "'LightSalmon'", "'LightSeaGreen'", "'LightSkyBlue'", "'LightSlateGray'", "'LightSlateGrey'", "'LightSteelBlue'", "'LightYellow'", "'Lime'", "'LimeGreen'", "'Linen'", "'Magenta'", "'Maroon'", "'MediumAquaMarine'", "'MediumBlue'", "'MediumOrchid'", "'MediumPurple'", "'MediumSeaGreen'", "'MediumSlateBlue'", "'MediumSpringGreen'", "'MediumTurquoise'", "'MediumVioletRed'", "'MidnightBlue'", "'MintCream'", "'MistyRose'", "'Moccasin'", "'NavajoWhite'", "'Navy'", "'OldLace'", "'Olive'", "'OliveDrab'", "'OrangeRed'", "'Orchid'", "'PaleGoldenRod'", "'PaleGreen'", "'PaleTurquoise'", "'PaleVioletRed'", "'PapayaWhip'", "'PeachPuff'", "'Peru'", "'Pink'", "'Plum'", "'PowderBlue'", "'Purple'", "'Red'", "'RosyBrown'", "'RoyalBlue'", "'SaddleBrown'", "'Salmon'", "'SandyBrown'", "'SeaGreen'", "'Sienna'", "'Silver'", "'SkyBlue'", "'SlateBlue'", "'SlateGray'", "'SlateGrey'", "'Snow'", "'SpringGreen'", "'SteelBlue'", "'Tan'", "'Teal'", "'Thistle'", "'Tomato'", "'Turquoise'", "'Violet'", "'Wheat'", "'White'", "'WhiteSmoke'", "'Yellow'", "'YellowGreen'", "'right'", "'left'", "'center'", "'@startuml'", "'@enduml'", "':'", "'-'", "'>'", "'<'", "'x'", "'\\\\'", "'/'", "'\\\\\\\\'", "'o'", "'|'", "'actor'", "'boundary'", "'control'", "'entity'", "'database'", "'autonumber'", "'#'", "'title'", "'legend'", "'endlegend'", "'newpage'"
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
    public static final int T__90=90;
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


    // $ANTLR start "rule__Instruction__Alternatives_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:340:1: rule__Instruction__Alternatives_0 : ( ( ( rule__Instruction__Group_0_0__0 ) ) | ( ( rule__Instruction__Group_0_1__0 ) ) | ( ruleAutoNumber ) | ( ruleTitle ) | ( ruleLegend ) | ( ruleNewpage ) );
    public final void rule__Instruction__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:344:1: ( ( ( rule__Instruction__Group_0_0__0 ) ) | ( ( rule__Instruction__Group_0_1__0 ) ) | ( ruleAutoNumber ) | ( ruleTitle ) | ( ruleLegend ) | ( ruleNewpage ) )
            int alt2=6;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:345:1: ( ( rule__Instruction__Group_0_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:345:1: ( ( rule__Instruction__Group_0_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:346:1: ( rule__Instruction__Group_0_0__0 )
                    {
                     before(grammarAccess.getInstructionAccess().getGroup_0_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:347:1: ( rule__Instruction__Group_0_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:347:2: rule__Instruction__Group_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_0_0__0_in_rule__Instruction__Alternatives_0671);
                    rule__Instruction__Group_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInstructionAccess().getGroup_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:351:6: ( ( rule__Instruction__Group_0_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:351:6: ( ( rule__Instruction__Group_0_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:352:1: ( rule__Instruction__Group_0_1__0 )
                    {
                     before(grammarAccess.getInstructionAccess().getGroup_0_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:353:1: ( rule__Instruction__Group_0_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:353:2: rule__Instruction__Group_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_0_1__0_in_rule__Instruction__Alternatives_0689);
                    rule__Instruction__Group_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInstructionAccess().getGroup_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:357:6: ( ruleAutoNumber )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:357:6: ( ruleAutoNumber )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:358:1: ruleAutoNumber
                    {
                     before(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 
                    pushFollow(FOLLOW_ruleAutoNumber_in_rule__Instruction__Alternatives_0707);
                    ruleAutoNumber();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:363:6: ( ruleTitle )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:363:6: ( ruleTitle )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:364:1: ruleTitle
                    {
                     before(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 
                    pushFollow(FOLLOW_ruleTitle_in_rule__Instruction__Alternatives_0724);
                    ruleTitle();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:369:6: ( ruleLegend )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:369:6: ( ruleLegend )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:370:1: ruleLegend
                    {
                     before(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 
                    pushFollow(FOLLOW_ruleLegend_in_rule__Instruction__Alternatives_0741);
                    ruleLegend();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:375:6: ( ruleNewpage )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:375:6: ( ruleNewpage )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:376:1: ruleNewpage
                    {
                     before(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 
                    pushFollow(FOLLOW_ruleNewpage_in_rule__Instruction__Alternatives_0758);
                    ruleNewpage();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:386:1: rule__Sequence__Alternatives : ( ( ( rule__Sequence__Group_0__0 ) ) | ( ( rule__Sequence__Group_1__0 ) ) | ( ( rule__Sequence__Group_2__0 ) ) | ( ( rule__Sequence__Group_3__0 ) ) | ( ( rule__Sequence__Group_4__0 ) ) | ( ( rule__Sequence__Group_5__0 ) ) | ( ( rule__Sequence__Group_6__0 ) ) | ( ( rule__Sequence__Group_7__0 ) ) | ( ( rule__Sequence__Group_8__0 ) ) | ( ( rule__Sequence__Group_9__0 ) ) | ( ( rule__Sequence__Group_10__0 ) ) | ( ( rule__Sequence__Group_11__0 ) ) | ( ( rule__Sequence__Group_12__0 ) ) | ( ( rule__Sequence__Group_13__0 ) ) | ( ( rule__Sequence__Group_14__0 ) ) | ( ( rule__Sequence__Group_15__0 ) ) | ( ( rule__Sequence__Group_16__0 ) ) | ( ( rule__Sequence__Group_17__0 ) ) | ( ( rule__Sequence__Group_18__0 ) ) | ( ( rule__Sequence__Group_19__0 ) ) | ( '.' ) );
    public final void rule__Sequence__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:390:1: ( ( ( rule__Sequence__Group_0__0 ) ) | ( ( rule__Sequence__Group_1__0 ) ) | ( ( rule__Sequence__Group_2__0 ) ) | ( ( rule__Sequence__Group_3__0 ) ) | ( ( rule__Sequence__Group_4__0 ) ) | ( ( rule__Sequence__Group_5__0 ) ) | ( ( rule__Sequence__Group_6__0 ) ) | ( ( rule__Sequence__Group_7__0 ) ) | ( ( rule__Sequence__Group_8__0 ) ) | ( ( rule__Sequence__Group_9__0 ) ) | ( ( rule__Sequence__Group_10__0 ) ) | ( ( rule__Sequence__Group_11__0 ) ) | ( ( rule__Sequence__Group_12__0 ) ) | ( ( rule__Sequence__Group_13__0 ) ) | ( ( rule__Sequence__Group_14__0 ) ) | ( ( rule__Sequence__Group_15__0 ) ) | ( ( rule__Sequence__Group_16__0 ) ) | ( ( rule__Sequence__Group_17__0 ) ) | ( ( rule__Sequence__Group_18__0 ) ) | ( ( rule__Sequence__Group_19__0 ) ) | ( '.' ) )
            int alt3=21;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:391:1: ( ( rule__Sequence__Group_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:391:1: ( ( rule__Sequence__Group_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:392:1: ( rule__Sequence__Group_0__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:393:1: ( rule__Sequence__Group_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:393:2: rule__Sequence__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_0__0_in_rule__Sequence__Alternatives790);
                    rule__Sequence__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:397:6: ( ( rule__Sequence__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:397:6: ( ( rule__Sequence__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:398:1: ( rule__Sequence__Group_1__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:399:1: ( rule__Sequence__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:399:2: rule__Sequence__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_1__0_in_rule__Sequence__Alternatives808);
                    rule__Sequence__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:403:6: ( ( rule__Sequence__Group_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:403:6: ( ( rule__Sequence__Group_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:404:1: ( rule__Sequence__Group_2__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:405:1: ( rule__Sequence__Group_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:405:2: rule__Sequence__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_2__0_in_rule__Sequence__Alternatives826);
                    rule__Sequence__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:409:6: ( ( rule__Sequence__Group_3__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:409:6: ( ( rule__Sequence__Group_3__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:410:1: ( rule__Sequence__Group_3__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_3()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:411:1: ( rule__Sequence__Group_3__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:411:2: rule__Sequence__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_3__0_in_rule__Sequence__Alternatives844);
                    rule__Sequence__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:415:6: ( ( rule__Sequence__Group_4__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:415:6: ( ( rule__Sequence__Group_4__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:416:1: ( rule__Sequence__Group_4__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_4()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:417:1: ( rule__Sequence__Group_4__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:417:2: rule__Sequence__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_4__0_in_rule__Sequence__Alternatives862);
                    rule__Sequence__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:421:6: ( ( rule__Sequence__Group_5__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:421:6: ( ( rule__Sequence__Group_5__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:422:1: ( rule__Sequence__Group_5__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_5()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:423:1: ( rule__Sequence__Group_5__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:423:2: rule__Sequence__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_5__0_in_rule__Sequence__Alternatives880);
                    rule__Sequence__Group_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:427:6: ( ( rule__Sequence__Group_6__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:427:6: ( ( rule__Sequence__Group_6__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:428:1: ( rule__Sequence__Group_6__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_6()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:429:1: ( rule__Sequence__Group_6__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:429:2: rule__Sequence__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_6__0_in_rule__Sequence__Alternatives898);
                    rule__Sequence__Group_6__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:433:6: ( ( rule__Sequence__Group_7__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:433:6: ( ( rule__Sequence__Group_7__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:434:1: ( rule__Sequence__Group_7__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_7()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:435:1: ( rule__Sequence__Group_7__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:435:2: rule__Sequence__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_7__0_in_rule__Sequence__Alternatives916);
                    rule__Sequence__Group_7__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:439:6: ( ( rule__Sequence__Group_8__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:439:6: ( ( rule__Sequence__Group_8__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:440:1: ( rule__Sequence__Group_8__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_8()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:441:1: ( rule__Sequence__Group_8__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:441:2: rule__Sequence__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_8__0_in_rule__Sequence__Alternatives934);
                    rule__Sequence__Group_8__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:445:6: ( ( rule__Sequence__Group_9__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:445:6: ( ( rule__Sequence__Group_9__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:446:1: ( rule__Sequence__Group_9__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_9()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:447:1: ( rule__Sequence__Group_9__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:447:2: rule__Sequence__Group_9__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_9__0_in_rule__Sequence__Alternatives952);
                    rule__Sequence__Group_9__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:451:6: ( ( rule__Sequence__Group_10__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:451:6: ( ( rule__Sequence__Group_10__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:452:1: ( rule__Sequence__Group_10__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_10()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:453:1: ( rule__Sequence__Group_10__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:453:2: rule__Sequence__Group_10__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_10__0_in_rule__Sequence__Alternatives970);
                    rule__Sequence__Group_10__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:457:6: ( ( rule__Sequence__Group_11__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:457:6: ( ( rule__Sequence__Group_11__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:458:1: ( rule__Sequence__Group_11__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_11()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:459:1: ( rule__Sequence__Group_11__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:459:2: rule__Sequence__Group_11__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_11__0_in_rule__Sequence__Alternatives988);
                    rule__Sequence__Group_11__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:463:6: ( ( rule__Sequence__Group_12__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:463:6: ( ( rule__Sequence__Group_12__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:464:1: ( rule__Sequence__Group_12__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_12()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:465:1: ( rule__Sequence__Group_12__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:465:2: rule__Sequence__Group_12__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_12__0_in_rule__Sequence__Alternatives1006);
                    rule__Sequence__Group_12__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:469:6: ( ( rule__Sequence__Group_13__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:469:6: ( ( rule__Sequence__Group_13__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:470:1: ( rule__Sequence__Group_13__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_13()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:471:1: ( rule__Sequence__Group_13__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:471:2: rule__Sequence__Group_13__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_13__0_in_rule__Sequence__Alternatives1024);
                    rule__Sequence__Group_13__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:475:6: ( ( rule__Sequence__Group_14__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:475:6: ( ( rule__Sequence__Group_14__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:476:1: ( rule__Sequence__Group_14__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_14()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:477:1: ( rule__Sequence__Group_14__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:477:2: rule__Sequence__Group_14__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_14__0_in_rule__Sequence__Alternatives1042);
                    rule__Sequence__Group_14__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:481:6: ( ( rule__Sequence__Group_15__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:481:6: ( ( rule__Sequence__Group_15__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:482:1: ( rule__Sequence__Group_15__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_15()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:483:1: ( rule__Sequence__Group_15__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:483:2: rule__Sequence__Group_15__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_15__0_in_rule__Sequence__Alternatives1060);
                    rule__Sequence__Group_15__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:487:6: ( ( rule__Sequence__Group_16__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:487:6: ( ( rule__Sequence__Group_16__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:488:1: ( rule__Sequence__Group_16__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_16()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:489:1: ( rule__Sequence__Group_16__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:489:2: rule__Sequence__Group_16__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_16__0_in_rule__Sequence__Alternatives1078);
                    rule__Sequence__Group_16__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:493:6: ( ( rule__Sequence__Group_17__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:493:6: ( ( rule__Sequence__Group_17__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:494:1: ( rule__Sequence__Group_17__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_17()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:495:1: ( rule__Sequence__Group_17__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:495:2: rule__Sequence__Group_17__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_17__0_in_rule__Sequence__Alternatives1096);
                    rule__Sequence__Group_17__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:499:6: ( ( rule__Sequence__Group_18__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:499:6: ( ( rule__Sequence__Group_18__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:500:1: ( rule__Sequence__Group_18__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_18()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:501:1: ( rule__Sequence__Group_18__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:501:2: rule__Sequence__Group_18__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_18__0_in_rule__Sequence__Alternatives1114);
                    rule__Sequence__Group_18__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:505:6: ( ( rule__Sequence__Group_19__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:505:6: ( ( rule__Sequence__Group_19__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:506:1: ( rule__Sequence__Group_19__0 )
                    {
                     before(grammarAccess.getSequenceAccess().getGroup_19()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:507:1: ( rule__Sequence__Group_19__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:507:2: rule__Sequence__Group_19__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_19__0_in_rule__Sequence__Alternatives1132);
                    rule__Sequence__Group_19__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSequenceAccess().getGroup_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:511:6: ( '.' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:511:6: ( '.' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:512:1: '.'
                    {
                     before(grammarAccess.getSequenceAccess().getFullStopKeyword_20()); 
                    match(input,11,FOLLOW_11_in_rule__Sequence__Alternatives1151); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:524:1: rule__Definition__Alternatives : ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) );
    public final void rule__Definition__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:528:1: ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) )
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:529:1: ( ( rule__Definition__Group_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:529:1: ( ( rule__Definition__Group_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:530:1: ( rule__Definition__Group_0__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:531:1: ( rule__Definition__Group_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:531:2: rule__Definition__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives1185);
                    rule__Definition__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:535:6: ( ( rule__Definition__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:535:6: ( ( rule__Definition__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:536:1: ( rule__Definition__Group_1__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:537:1: ( rule__Definition__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:537:2: rule__Definition__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives1203);
                    rule__Definition__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:541:6: ( ( rule__Definition__Group_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:541:6: ( ( rule__Definition__Group_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:542:1: ( rule__Definition__Group_2__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:543:1: ( rule__Definition__Group_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:543:2: rule__Definition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives1221);
                    rule__Definition__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:547:6: ( ( rule__Definition__Group_3__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:547:6: ( ( rule__Definition__Group_3__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:548:1: ( rule__Definition__Group_3__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_3()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:549:1: ( rule__Definition__Group_3__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:549:2: rule__Definition__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives1239);
                    rule__Definition__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:553:6: ( ( rule__Definition__Group_4__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:553:6: ( ( rule__Definition__Group_4__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:554:1: ( rule__Definition__Group_4__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_4()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:555:1: ( rule__Definition__Group_4__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:555:2: rule__Definition__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives1257);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:564:1: rule__Color__Alternatives_1 : ( ( 'AliceBlue' ) | ( 'AntiqueWhite' ) | ( 'Aqua' ) | ( 'Aquamarine' ) | ( 'Azure' ) | ( 'Beige' ) | ( 'Bisque' ) | ( 'Black' ) | ( 'BlanchedAlmond' ) | ( 'Blue' ) | ( 'BlueViolet' ) | ( 'Brown' ) | ( 'BurlyWood' ) | ( 'CadetBlue' ) | ( 'Chartreuse' ) | ( 'Chocolate' ) | ( 'Coral' ) | ( 'CornflowerBlue' ) | ( 'Cornsilk' ) | ( 'Crimson' ) | ( 'Cyan' ) | ( 'DarkBlue' ) | ( 'DarkCyan' ) | ( 'DarkGoldenRod' ) | ( 'DarkGray' ) | ( 'DarkGreen' ) | ( 'DarkGrey' ) | ( 'DarkKhaki' ) | ( 'DarkMagenta' ) | ( 'DarkOliveGreen' ) | ( 'DarkOrchid' ) | ( 'DarkRed' ) | ( 'DarkSalmo' ) | ( 'DarkSeaGreen' ) | ( 'DarkSlateBlue' ) | ( 'DarkSlateGray' ) | ( 'DarkSlateGrey' ) | ( 'DarkTurquoise' ) | ( 'DarkViolet' ) | ( 'Darkorange' ) | ( 'DeepPink' ) | ( 'DeepSkyBlue' ) | ( 'DimGray' ) | ( 'DimGrey' ) | ( 'DodgerBlue' ) | ( 'FireBrick' ) | ( 'FloralWhite' ) | ( 'ForestGreen' ) | ( 'Fuchsia' ) | ( 'Gainsboro' ) | ( 'GhostWhite' ) | ( 'Gold' ) | ( 'GoldenRod' ) | ( 'Gray' ) | ( 'Green' ) | ( 'GreenYellow' ) | ( 'Grey' ) | ( 'HoneyDew' ) | ( 'HotPink' ) | ( 'IndianRed' ) | ( 'Indigo' ) | ( 'Ivory' ) | ( 'Khaki' ) | ( 'Lavender' ) | ( 'LavenderBlush' ) | ( 'LawnGreen' ) | ( 'LemonChiffon' ) | ( 'LightBlue' ) | ( 'LightCoral' ) | ( 'LightCyan' ) | ( 'LightGoldenRodYellow' ) | ( 'LightGray' ) | ( 'LightGreen' ) | ( 'LightGrey' ) | ( 'LightPink' ) | ( 'LightSalmon' ) | ( 'LightSeaGreen' ) | ( 'LightSkyBlue' ) | ( 'LightSlateGray' ) | ( 'LightSlateGrey' ) | ( 'LightSteelBlue' ) | ( 'LightYellow' ) | ( 'Lime' ) | ( 'LimeGreen' ) | ( 'Linen' ) | ( 'Magenta' ) | ( 'Maroon' ) | ( 'MediumAquaMarine' ) | ( 'MediumBlue' ) | ( 'MediumOrchid' ) | ( 'MediumPurple' ) | ( 'MediumSeaGreen' ) | ( 'MediumSlateBlue' ) | ( 'MediumSpringGreen' ) | ( 'MediumTurquoise' ) | ( 'MediumVioletRed' ) | ( 'MidnightBlue' ) | ( 'MintCream' ) | ( 'MistyRose' ) | ( 'Moccasin' ) | ( 'NavajoWhite' ) | ( 'Navy' ) | ( 'OldLace' ) | ( 'Olive' ) | ( 'OliveDrab' ) | ( 'OrangeRed' ) | ( 'Orchid' ) | ( 'PaleGoldenRod' ) | ( 'PaleGreen' ) | ( 'PaleTurquoise' ) | ( 'PaleVioletRed' ) | ( 'PapayaWhip' ) | ( 'PeachPuff' ) | ( 'Peru' ) | ( 'Pink' ) | ( 'Plum' ) | ( 'PowderBlue' ) | ( 'Purple' ) | ( 'Red' ) | ( 'RosyBrown' ) | ( 'RoyalBlue' ) | ( 'SaddleBrown' ) | ( 'Salmon' ) | ( 'SandyBrown' ) | ( 'SeaGreen' ) | ( 'Sienna' ) | ( 'Silver' ) | ( 'SkyBlue' ) | ( 'SlateBlue' ) | ( 'SlateGray' ) | ( 'SlateGrey' ) | ( 'Snow' ) | ( 'SpringGreen' ) | ( 'SteelBlue' ) | ( 'Tan' ) | ( 'Teal' ) | ( 'Thistle' ) | ( 'Tomato' ) | ( 'Turquoise' ) | ( 'Violet' ) | ( 'Wheat' ) | ( 'White' ) | ( 'WhiteSmoke' ) | ( 'Yellow' ) | ( 'YellowGreen' ) );
    public final void rule__Color__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:568:1: ( ( 'AliceBlue' ) | ( 'AntiqueWhite' ) | ( 'Aqua' ) | ( 'Aquamarine' ) | ( 'Azure' ) | ( 'Beige' ) | ( 'Bisque' ) | ( 'Black' ) | ( 'BlanchedAlmond' ) | ( 'Blue' ) | ( 'BlueViolet' ) | ( 'Brown' ) | ( 'BurlyWood' ) | ( 'CadetBlue' ) | ( 'Chartreuse' ) | ( 'Chocolate' ) | ( 'Coral' ) | ( 'CornflowerBlue' ) | ( 'Cornsilk' ) | ( 'Crimson' ) | ( 'Cyan' ) | ( 'DarkBlue' ) | ( 'DarkCyan' ) | ( 'DarkGoldenRod' ) | ( 'DarkGray' ) | ( 'DarkGreen' ) | ( 'DarkGrey' ) | ( 'DarkKhaki' ) | ( 'DarkMagenta' ) | ( 'DarkOliveGreen' ) | ( 'DarkOrchid' ) | ( 'DarkRed' ) | ( 'DarkSalmo' ) | ( 'DarkSeaGreen' ) | ( 'DarkSlateBlue' ) | ( 'DarkSlateGray' ) | ( 'DarkSlateGrey' ) | ( 'DarkTurquoise' ) | ( 'DarkViolet' ) | ( 'Darkorange' ) | ( 'DeepPink' ) | ( 'DeepSkyBlue' ) | ( 'DimGray' ) | ( 'DimGrey' ) | ( 'DodgerBlue' ) | ( 'FireBrick' ) | ( 'FloralWhite' ) | ( 'ForestGreen' ) | ( 'Fuchsia' ) | ( 'Gainsboro' ) | ( 'GhostWhite' ) | ( 'Gold' ) | ( 'GoldenRod' ) | ( 'Gray' ) | ( 'Green' ) | ( 'GreenYellow' ) | ( 'Grey' ) | ( 'HoneyDew' ) | ( 'HotPink' ) | ( 'IndianRed' ) | ( 'Indigo' ) | ( 'Ivory' ) | ( 'Khaki' ) | ( 'Lavender' ) | ( 'LavenderBlush' ) | ( 'LawnGreen' ) | ( 'LemonChiffon' ) | ( 'LightBlue' ) | ( 'LightCoral' ) | ( 'LightCyan' ) | ( 'LightGoldenRodYellow' ) | ( 'LightGray' ) | ( 'LightGreen' ) | ( 'LightGrey' ) | ( 'LightPink' ) | ( 'LightSalmon' ) | ( 'LightSeaGreen' ) | ( 'LightSkyBlue' ) | ( 'LightSlateGray' ) | ( 'LightSlateGrey' ) | ( 'LightSteelBlue' ) | ( 'LightYellow' ) | ( 'Lime' ) | ( 'LimeGreen' ) | ( 'Linen' ) | ( 'Magenta' ) | ( 'Maroon' ) | ( 'MediumAquaMarine' ) | ( 'MediumBlue' ) | ( 'MediumOrchid' ) | ( 'MediumPurple' ) | ( 'MediumSeaGreen' ) | ( 'MediumSlateBlue' ) | ( 'MediumSpringGreen' ) | ( 'MediumTurquoise' ) | ( 'MediumVioletRed' ) | ( 'MidnightBlue' ) | ( 'MintCream' ) | ( 'MistyRose' ) | ( 'Moccasin' ) | ( 'NavajoWhite' ) | ( 'Navy' ) | ( 'OldLace' ) | ( 'Olive' ) | ( 'OliveDrab' ) | ( 'OrangeRed' ) | ( 'Orchid' ) | ( 'PaleGoldenRod' ) | ( 'PaleGreen' ) | ( 'PaleTurquoise' ) | ( 'PaleVioletRed' ) | ( 'PapayaWhip' ) | ( 'PeachPuff' ) | ( 'Peru' ) | ( 'Pink' ) | ( 'Plum' ) | ( 'PowderBlue' ) | ( 'Purple' ) | ( 'Red' ) | ( 'RosyBrown' ) | ( 'RoyalBlue' ) | ( 'SaddleBrown' ) | ( 'Salmon' ) | ( 'SandyBrown' ) | ( 'SeaGreen' ) | ( 'Sienna' ) | ( 'Silver' ) | ( 'SkyBlue' ) | ( 'SlateBlue' ) | ( 'SlateGray' ) | ( 'SlateGrey' ) | ( 'Snow' ) | ( 'SpringGreen' ) | ( 'SteelBlue' ) | ( 'Tan' ) | ( 'Teal' ) | ( 'Thistle' ) | ( 'Tomato' ) | ( 'Turquoise' ) | ( 'Violet' ) | ( 'Wheat' ) | ( 'White' ) | ( 'WhiteSmoke' ) | ( 'Yellow' ) | ( 'YellowGreen' ) )
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:569:1: ( 'AliceBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:569:1: ( 'AliceBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:570:1: 'AliceBlue'
                    {
                     before(grammarAccess.getColorAccess().getAliceBlueKeyword_1_0()); 
                    match(input,12,FOLLOW_12_in_rule__Color__Alternatives_11291); 
                     after(grammarAccess.getColorAccess().getAliceBlueKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:577:6: ( 'AntiqueWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:577:6: ( 'AntiqueWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:578:1: 'AntiqueWhite'
                    {
                     before(grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1_1()); 
                    match(input,13,FOLLOW_13_in_rule__Color__Alternatives_11311); 
                     after(grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:585:6: ( 'Aqua' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:585:6: ( 'Aqua' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:586:1: 'Aqua'
                    {
                     before(grammarAccess.getColorAccess().getAquaKeyword_1_2()); 
                    match(input,14,FOLLOW_14_in_rule__Color__Alternatives_11331); 
                     after(grammarAccess.getColorAccess().getAquaKeyword_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:593:6: ( 'Aquamarine' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:593:6: ( 'Aquamarine' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:594:1: 'Aquamarine'
                    {
                     before(grammarAccess.getColorAccess().getAquamarineKeyword_1_3()); 
                    match(input,15,FOLLOW_15_in_rule__Color__Alternatives_11351); 
                     after(grammarAccess.getColorAccess().getAquamarineKeyword_1_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:601:6: ( 'Azure' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:601:6: ( 'Azure' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:602:1: 'Azure'
                    {
                     before(grammarAccess.getColorAccess().getAzureKeyword_1_4()); 
                    match(input,16,FOLLOW_16_in_rule__Color__Alternatives_11371); 
                     after(grammarAccess.getColorAccess().getAzureKeyword_1_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:609:6: ( 'Beige' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:609:6: ( 'Beige' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:610:1: 'Beige'
                    {
                     before(grammarAccess.getColorAccess().getBeigeKeyword_1_5()); 
                    match(input,17,FOLLOW_17_in_rule__Color__Alternatives_11391); 
                     after(grammarAccess.getColorAccess().getBeigeKeyword_1_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:617:6: ( 'Bisque' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:617:6: ( 'Bisque' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:618:1: 'Bisque'
                    {
                     before(grammarAccess.getColorAccess().getBisqueKeyword_1_6()); 
                    match(input,18,FOLLOW_18_in_rule__Color__Alternatives_11411); 
                     after(grammarAccess.getColorAccess().getBisqueKeyword_1_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:625:6: ( 'Black' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:625:6: ( 'Black' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:626:1: 'Black'
                    {
                     before(grammarAccess.getColorAccess().getBlackKeyword_1_7()); 
                    match(input,19,FOLLOW_19_in_rule__Color__Alternatives_11431); 
                     after(grammarAccess.getColorAccess().getBlackKeyword_1_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:633:6: ( 'BlanchedAlmond' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:633:6: ( 'BlanchedAlmond' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:634:1: 'BlanchedAlmond'
                    {
                     before(grammarAccess.getColorAccess().getBlanchedAlmondKeyword_1_8()); 
                    match(input,20,FOLLOW_20_in_rule__Color__Alternatives_11451); 
                     after(grammarAccess.getColorAccess().getBlanchedAlmondKeyword_1_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:641:6: ( 'Blue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:641:6: ( 'Blue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:642:1: 'Blue'
                    {
                     before(grammarAccess.getColorAccess().getBlueKeyword_1_9()); 
                    match(input,21,FOLLOW_21_in_rule__Color__Alternatives_11471); 
                     after(grammarAccess.getColorAccess().getBlueKeyword_1_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:649:6: ( 'BlueViolet' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:649:6: ( 'BlueViolet' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:650:1: 'BlueViolet'
                    {
                     before(grammarAccess.getColorAccess().getBlueVioletKeyword_1_10()); 
                    match(input,22,FOLLOW_22_in_rule__Color__Alternatives_11491); 
                     after(grammarAccess.getColorAccess().getBlueVioletKeyword_1_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:657:6: ( 'Brown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:657:6: ( 'Brown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:658:1: 'Brown'
                    {
                     before(grammarAccess.getColorAccess().getBrownKeyword_1_11()); 
                    match(input,23,FOLLOW_23_in_rule__Color__Alternatives_11511); 
                     after(grammarAccess.getColorAccess().getBrownKeyword_1_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:665:6: ( 'BurlyWood' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:665:6: ( 'BurlyWood' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:666:1: 'BurlyWood'
                    {
                     before(grammarAccess.getColorAccess().getBurlyWoodKeyword_1_12()); 
                    match(input,24,FOLLOW_24_in_rule__Color__Alternatives_11531); 
                     after(grammarAccess.getColorAccess().getBurlyWoodKeyword_1_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:673:6: ( 'CadetBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:673:6: ( 'CadetBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:674:1: 'CadetBlue'
                    {
                     before(grammarAccess.getColorAccess().getCadetBlueKeyword_1_13()); 
                    match(input,25,FOLLOW_25_in_rule__Color__Alternatives_11551); 
                     after(grammarAccess.getColorAccess().getCadetBlueKeyword_1_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:681:6: ( 'Chartreuse' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:681:6: ( 'Chartreuse' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:682:1: 'Chartreuse'
                    {
                     before(grammarAccess.getColorAccess().getChartreuseKeyword_1_14()); 
                    match(input,26,FOLLOW_26_in_rule__Color__Alternatives_11571); 
                     after(grammarAccess.getColorAccess().getChartreuseKeyword_1_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:689:6: ( 'Chocolate' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:689:6: ( 'Chocolate' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:690:1: 'Chocolate'
                    {
                     before(grammarAccess.getColorAccess().getChocolateKeyword_1_15()); 
                    match(input,27,FOLLOW_27_in_rule__Color__Alternatives_11591); 
                     after(grammarAccess.getColorAccess().getChocolateKeyword_1_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:697:6: ( 'Coral' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:697:6: ( 'Coral' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:698:1: 'Coral'
                    {
                     before(grammarAccess.getColorAccess().getCoralKeyword_1_16()); 
                    match(input,28,FOLLOW_28_in_rule__Color__Alternatives_11611); 
                     after(grammarAccess.getColorAccess().getCoralKeyword_1_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:705:6: ( 'CornflowerBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:705:6: ( 'CornflowerBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:706:1: 'CornflowerBlue'
                    {
                     before(grammarAccess.getColorAccess().getCornflowerBlueKeyword_1_17()); 
                    match(input,29,FOLLOW_29_in_rule__Color__Alternatives_11631); 
                     after(grammarAccess.getColorAccess().getCornflowerBlueKeyword_1_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:713:6: ( 'Cornsilk' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:713:6: ( 'Cornsilk' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:714:1: 'Cornsilk'
                    {
                     before(grammarAccess.getColorAccess().getCornsilkKeyword_1_18()); 
                    match(input,30,FOLLOW_30_in_rule__Color__Alternatives_11651); 
                     after(grammarAccess.getColorAccess().getCornsilkKeyword_1_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:721:6: ( 'Crimson' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:721:6: ( 'Crimson' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:722:1: 'Crimson'
                    {
                     before(grammarAccess.getColorAccess().getCrimsonKeyword_1_19()); 
                    match(input,31,FOLLOW_31_in_rule__Color__Alternatives_11671); 
                     after(grammarAccess.getColorAccess().getCrimsonKeyword_1_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:729:6: ( 'Cyan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:729:6: ( 'Cyan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:730:1: 'Cyan'
                    {
                     before(grammarAccess.getColorAccess().getCyanKeyword_1_20()); 
                    match(input,32,FOLLOW_32_in_rule__Color__Alternatives_11691); 
                     after(grammarAccess.getColorAccess().getCyanKeyword_1_20()); 

                    }


                    }
                    break;
                case 22 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:737:6: ( 'DarkBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:737:6: ( 'DarkBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:738:1: 'DarkBlue'
                    {
                     before(grammarAccess.getColorAccess().getDarkBlueKeyword_1_21()); 
                    match(input,33,FOLLOW_33_in_rule__Color__Alternatives_11711); 
                     after(grammarAccess.getColorAccess().getDarkBlueKeyword_1_21()); 

                    }


                    }
                    break;
                case 23 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:745:6: ( 'DarkCyan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:745:6: ( 'DarkCyan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:746:1: 'DarkCyan'
                    {
                     before(grammarAccess.getColorAccess().getDarkCyanKeyword_1_22()); 
                    match(input,34,FOLLOW_34_in_rule__Color__Alternatives_11731); 
                     after(grammarAccess.getColorAccess().getDarkCyanKeyword_1_22()); 

                    }


                    }
                    break;
                case 24 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:753:6: ( 'DarkGoldenRod' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:753:6: ( 'DarkGoldenRod' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:754:1: 'DarkGoldenRod'
                    {
                     before(grammarAccess.getColorAccess().getDarkGoldenRodKeyword_1_23()); 
                    match(input,35,FOLLOW_35_in_rule__Color__Alternatives_11751); 
                     after(grammarAccess.getColorAccess().getDarkGoldenRodKeyword_1_23()); 

                    }


                    }
                    break;
                case 25 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:761:6: ( 'DarkGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:761:6: ( 'DarkGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:762:1: 'DarkGray'
                    {
                     before(grammarAccess.getColorAccess().getDarkGrayKeyword_1_24()); 
                    match(input,36,FOLLOW_36_in_rule__Color__Alternatives_11771); 
                     after(grammarAccess.getColorAccess().getDarkGrayKeyword_1_24()); 

                    }


                    }
                    break;
                case 26 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:769:6: ( 'DarkGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:769:6: ( 'DarkGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:770:1: 'DarkGreen'
                    {
                     before(grammarAccess.getColorAccess().getDarkGreenKeyword_1_25()); 
                    match(input,37,FOLLOW_37_in_rule__Color__Alternatives_11791); 
                     after(grammarAccess.getColorAccess().getDarkGreenKeyword_1_25()); 

                    }


                    }
                    break;
                case 27 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:777:6: ( 'DarkGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:777:6: ( 'DarkGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:778:1: 'DarkGrey'
                    {
                     before(grammarAccess.getColorAccess().getDarkGreyKeyword_1_26()); 
                    match(input,38,FOLLOW_38_in_rule__Color__Alternatives_11811); 
                     after(grammarAccess.getColorAccess().getDarkGreyKeyword_1_26()); 

                    }


                    }
                    break;
                case 28 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:785:6: ( 'DarkKhaki' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:785:6: ( 'DarkKhaki' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:786:1: 'DarkKhaki'
                    {
                     before(grammarAccess.getColorAccess().getDarkKhakiKeyword_1_27()); 
                    match(input,39,FOLLOW_39_in_rule__Color__Alternatives_11831); 
                     after(grammarAccess.getColorAccess().getDarkKhakiKeyword_1_27()); 

                    }


                    }
                    break;
                case 29 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:793:6: ( 'DarkMagenta' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:793:6: ( 'DarkMagenta' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:794:1: 'DarkMagenta'
                    {
                     before(grammarAccess.getColorAccess().getDarkMagentaKeyword_1_28()); 
                    match(input,40,FOLLOW_40_in_rule__Color__Alternatives_11851); 
                     after(grammarAccess.getColorAccess().getDarkMagentaKeyword_1_28()); 

                    }


                    }
                    break;
                case 30 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:801:6: ( 'DarkOliveGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:801:6: ( 'DarkOliveGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:802:1: 'DarkOliveGreen'
                    {
                     before(grammarAccess.getColorAccess().getDarkOliveGreenKeyword_1_29()); 
                    match(input,41,FOLLOW_41_in_rule__Color__Alternatives_11871); 
                     after(grammarAccess.getColorAccess().getDarkOliveGreenKeyword_1_29()); 

                    }


                    }
                    break;
                case 31 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:809:6: ( 'DarkOrchid' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:809:6: ( 'DarkOrchid' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:810:1: 'DarkOrchid'
                    {
                     before(grammarAccess.getColorAccess().getDarkOrchidKeyword_1_30()); 
                    match(input,42,FOLLOW_42_in_rule__Color__Alternatives_11891); 
                     after(grammarAccess.getColorAccess().getDarkOrchidKeyword_1_30()); 

                    }


                    }
                    break;
                case 32 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:817:6: ( 'DarkRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:817:6: ( 'DarkRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:818:1: 'DarkRed'
                    {
                     before(grammarAccess.getColorAccess().getDarkRedKeyword_1_31()); 
                    match(input,43,FOLLOW_43_in_rule__Color__Alternatives_11911); 
                     after(grammarAccess.getColorAccess().getDarkRedKeyword_1_31()); 

                    }


                    }
                    break;
                case 33 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:825:6: ( 'DarkSalmo' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:825:6: ( 'DarkSalmo' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:826:1: 'DarkSalmo'
                    {
                     before(grammarAccess.getColorAccess().getDarkSalmoKeyword_1_32()); 
                    match(input,44,FOLLOW_44_in_rule__Color__Alternatives_11931); 
                     after(grammarAccess.getColorAccess().getDarkSalmoKeyword_1_32()); 

                    }


                    }
                    break;
                case 34 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:833:6: ( 'DarkSeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:833:6: ( 'DarkSeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:834:1: 'DarkSeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getDarkSeaGreenKeyword_1_33()); 
                    match(input,45,FOLLOW_45_in_rule__Color__Alternatives_11951); 
                     after(grammarAccess.getColorAccess().getDarkSeaGreenKeyword_1_33()); 

                    }


                    }
                    break;
                case 35 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:841:6: ( 'DarkSlateBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:841:6: ( 'DarkSlateBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:842:1: 'DarkSlateBlue'
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateBlueKeyword_1_34()); 
                    match(input,46,FOLLOW_46_in_rule__Color__Alternatives_11971); 
                     after(grammarAccess.getColorAccess().getDarkSlateBlueKeyword_1_34()); 

                    }


                    }
                    break;
                case 36 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:849:6: ( 'DarkSlateGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:849:6: ( 'DarkSlateGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:850:1: 'DarkSlateGray'
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateGrayKeyword_1_35()); 
                    match(input,47,FOLLOW_47_in_rule__Color__Alternatives_11991); 
                     after(grammarAccess.getColorAccess().getDarkSlateGrayKeyword_1_35()); 

                    }


                    }
                    break;
                case 37 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:857:6: ( 'DarkSlateGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:857:6: ( 'DarkSlateGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:858:1: 'DarkSlateGrey'
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateGreyKeyword_1_36()); 
                    match(input,48,FOLLOW_48_in_rule__Color__Alternatives_12011); 
                     after(grammarAccess.getColorAccess().getDarkSlateGreyKeyword_1_36()); 

                    }


                    }
                    break;
                case 38 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:865:6: ( 'DarkTurquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:865:6: ( 'DarkTurquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:866:1: 'DarkTurquoise'
                    {
                     before(grammarAccess.getColorAccess().getDarkTurquoiseKeyword_1_37()); 
                    match(input,49,FOLLOW_49_in_rule__Color__Alternatives_12031); 
                     after(grammarAccess.getColorAccess().getDarkTurquoiseKeyword_1_37()); 

                    }


                    }
                    break;
                case 39 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:873:6: ( 'DarkViolet' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:873:6: ( 'DarkViolet' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:874:1: 'DarkViolet'
                    {
                     before(grammarAccess.getColorAccess().getDarkVioletKeyword_1_38()); 
                    match(input,50,FOLLOW_50_in_rule__Color__Alternatives_12051); 
                     after(grammarAccess.getColorAccess().getDarkVioletKeyword_1_38()); 

                    }


                    }
                    break;
                case 40 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:881:6: ( 'Darkorange' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:881:6: ( 'Darkorange' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:882:1: 'Darkorange'
                    {
                     before(grammarAccess.getColorAccess().getDarkorangeKeyword_1_39()); 
                    match(input,51,FOLLOW_51_in_rule__Color__Alternatives_12071); 
                     after(grammarAccess.getColorAccess().getDarkorangeKeyword_1_39()); 

                    }


                    }
                    break;
                case 41 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:889:6: ( 'DeepPink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:889:6: ( 'DeepPink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:890:1: 'DeepPink'
                    {
                     before(grammarAccess.getColorAccess().getDeepPinkKeyword_1_40()); 
                    match(input,52,FOLLOW_52_in_rule__Color__Alternatives_12091); 
                     after(grammarAccess.getColorAccess().getDeepPinkKeyword_1_40()); 

                    }


                    }
                    break;
                case 42 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:897:6: ( 'DeepSkyBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:897:6: ( 'DeepSkyBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:898:1: 'DeepSkyBlue'
                    {
                     before(grammarAccess.getColorAccess().getDeepSkyBlueKeyword_1_41()); 
                    match(input,53,FOLLOW_53_in_rule__Color__Alternatives_12111); 
                     after(grammarAccess.getColorAccess().getDeepSkyBlueKeyword_1_41()); 

                    }


                    }
                    break;
                case 43 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:905:6: ( 'DimGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:905:6: ( 'DimGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:906:1: 'DimGray'
                    {
                     before(grammarAccess.getColorAccess().getDimGrayKeyword_1_42()); 
                    match(input,54,FOLLOW_54_in_rule__Color__Alternatives_12131); 
                     after(grammarAccess.getColorAccess().getDimGrayKeyword_1_42()); 

                    }


                    }
                    break;
                case 44 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:913:6: ( 'DimGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:913:6: ( 'DimGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:914:1: 'DimGrey'
                    {
                     before(grammarAccess.getColorAccess().getDimGreyKeyword_1_43()); 
                    match(input,55,FOLLOW_55_in_rule__Color__Alternatives_12151); 
                     after(grammarAccess.getColorAccess().getDimGreyKeyword_1_43()); 

                    }


                    }
                    break;
                case 45 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:921:6: ( 'DodgerBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:921:6: ( 'DodgerBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:922:1: 'DodgerBlue'
                    {
                     before(grammarAccess.getColorAccess().getDodgerBlueKeyword_1_44()); 
                    match(input,56,FOLLOW_56_in_rule__Color__Alternatives_12171); 
                     after(grammarAccess.getColorAccess().getDodgerBlueKeyword_1_44()); 

                    }


                    }
                    break;
                case 46 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:929:6: ( 'FireBrick' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:929:6: ( 'FireBrick' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:930:1: 'FireBrick'
                    {
                     before(grammarAccess.getColorAccess().getFireBrickKeyword_1_45()); 
                    match(input,57,FOLLOW_57_in_rule__Color__Alternatives_12191); 
                     after(grammarAccess.getColorAccess().getFireBrickKeyword_1_45()); 

                    }


                    }
                    break;
                case 47 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:937:6: ( 'FloralWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:937:6: ( 'FloralWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:938:1: 'FloralWhite'
                    {
                     before(grammarAccess.getColorAccess().getFloralWhiteKeyword_1_46()); 
                    match(input,58,FOLLOW_58_in_rule__Color__Alternatives_12211); 
                     after(grammarAccess.getColorAccess().getFloralWhiteKeyword_1_46()); 

                    }


                    }
                    break;
                case 48 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:945:6: ( 'ForestGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:945:6: ( 'ForestGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:946:1: 'ForestGreen'
                    {
                     before(grammarAccess.getColorAccess().getForestGreenKeyword_1_47()); 
                    match(input,59,FOLLOW_59_in_rule__Color__Alternatives_12231); 
                     after(grammarAccess.getColorAccess().getForestGreenKeyword_1_47()); 

                    }


                    }
                    break;
                case 49 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:953:6: ( 'Fuchsia' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:953:6: ( 'Fuchsia' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:954:1: 'Fuchsia'
                    {
                     before(grammarAccess.getColorAccess().getFuchsiaKeyword_1_48()); 
                    match(input,60,FOLLOW_60_in_rule__Color__Alternatives_12251); 
                     after(grammarAccess.getColorAccess().getFuchsiaKeyword_1_48()); 

                    }


                    }
                    break;
                case 50 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:961:6: ( 'Gainsboro' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:961:6: ( 'Gainsboro' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:962:1: 'Gainsboro'
                    {
                     before(grammarAccess.getColorAccess().getGainsboroKeyword_1_49()); 
                    match(input,61,FOLLOW_61_in_rule__Color__Alternatives_12271); 
                     after(grammarAccess.getColorAccess().getGainsboroKeyword_1_49()); 

                    }


                    }
                    break;
                case 51 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:969:6: ( 'GhostWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:969:6: ( 'GhostWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:970:1: 'GhostWhite'
                    {
                     before(grammarAccess.getColorAccess().getGhostWhiteKeyword_1_50()); 
                    match(input,62,FOLLOW_62_in_rule__Color__Alternatives_12291); 
                     after(grammarAccess.getColorAccess().getGhostWhiteKeyword_1_50()); 

                    }


                    }
                    break;
                case 52 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:977:6: ( 'Gold' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:977:6: ( 'Gold' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:978:1: 'Gold'
                    {
                     before(grammarAccess.getColorAccess().getGoldKeyword_1_51()); 
                    match(input,63,FOLLOW_63_in_rule__Color__Alternatives_12311); 
                     after(grammarAccess.getColorAccess().getGoldKeyword_1_51()); 

                    }


                    }
                    break;
                case 53 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:985:6: ( 'GoldenRod' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:985:6: ( 'GoldenRod' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:986:1: 'GoldenRod'
                    {
                     before(grammarAccess.getColorAccess().getGoldenRodKeyword_1_52()); 
                    match(input,64,FOLLOW_64_in_rule__Color__Alternatives_12331); 
                     after(grammarAccess.getColorAccess().getGoldenRodKeyword_1_52()); 

                    }


                    }
                    break;
                case 54 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:993:6: ( 'Gray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:993:6: ( 'Gray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:994:1: 'Gray'
                    {
                     before(grammarAccess.getColorAccess().getGrayKeyword_1_53()); 
                    match(input,65,FOLLOW_65_in_rule__Color__Alternatives_12351); 
                     after(grammarAccess.getColorAccess().getGrayKeyword_1_53()); 

                    }


                    }
                    break;
                case 55 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1001:6: ( 'Green' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1001:6: ( 'Green' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1002:1: 'Green'
                    {
                     before(grammarAccess.getColorAccess().getGreenKeyword_1_54()); 
                    match(input,66,FOLLOW_66_in_rule__Color__Alternatives_12371); 
                     after(grammarAccess.getColorAccess().getGreenKeyword_1_54()); 

                    }


                    }
                    break;
                case 56 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1009:6: ( 'GreenYellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1009:6: ( 'GreenYellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1010:1: 'GreenYellow'
                    {
                     before(grammarAccess.getColorAccess().getGreenYellowKeyword_1_55()); 
                    match(input,67,FOLLOW_67_in_rule__Color__Alternatives_12391); 
                     after(grammarAccess.getColorAccess().getGreenYellowKeyword_1_55()); 

                    }


                    }
                    break;
                case 57 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1017:6: ( 'Grey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1017:6: ( 'Grey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1018:1: 'Grey'
                    {
                     before(grammarAccess.getColorAccess().getGreyKeyword_1_56()); 
                    match(input,68,FOLLOW_68_in_rule__Color__Alternatives_12411); 
                     after(grammarAccess.getColorAccess().getGreyKeyword_1_56()); 

                    }


                    }
                    break;
                case 58 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1025:6: ( 'HoneyDew' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1025:6: ( 'HoneyDew' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1026:1: 'HoneyDew'
                    {
                     before(grammarAccess.getColorAccess().getHoneyDewKeyword_1_57()); 
                    match(input,69,FOLLOW_69_in_rule__Color__Alternatives_12431); 
                     after(grammarAccess.getColorAccess().getHoneyDewKeyword_1_57()); 

                    }


                    }
                    break;
                case 59 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1033:6: ( 'HotPink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1033:6: ( 'HotPink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1034:1: 'HotPink'
                    {
                     before(grammarAccess.getColorAccess().getHotPinkKeyword_1_58()); 
                    match(input,70,FOLLOW_70_in_rule__Color__Alternatives_12451); 
                     after(grammarAccess.getColorAccess().getHotPinkKeyword_1_58()); 

                    }


                    }
                    break;
                case 60 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1041:6: ( 'IndianRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1041:6: ( 'IndianRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1042:1: 'IndianRed'
                    {
                     before(grammarAccess.getColorAccess().getIndianRedKeyword_1_59()); 
                    match(input,71,FOLLOW_71_in_rule__Color__Alternatives_12471); 
                     after(grammarAccess.getColorAccess().getIndianRedKeyword_1_59()); 

                    }


                    }
                    break;
                case 61 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1049:6: ( 'Indigo' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1049:6: ( 'Indigo' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1050:1: 'Indigo'
                    {
                     before(grammarAccess.getColorAccess().getIndigoKeyword_1_60()); 
                    match(input,72,FOLLOW_72_in_rule__Color__Alternatives_12491); 
                     after(grammarAccess.getColorAccess().getIndigoKeyword_1_60()); 

                    }


                    }
                    break;
                case 62 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1057:6: ( 'Ivory' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1057:6: ( 'Ivory' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1058:1: 'Ivory'
                    {
                     before(grammarAccess.getColorAccess().getIvoryKeyword_1_61()); 
                    match(input,73,FOLLOW_73_in_rule__Color__Alternatives_12511); 
                     after(grammarAccess.getColorAccess().getIvoryKeyword_1_61()); 

                    }


                    }
                    break;
                case 63 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1065:6: ( 'Khaki' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1065:6: ( 'Khaki' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1066:1: 'Khaki'
                    {
                     before(grammarAccess.getColorAccess().getKhakiKeyword_1_62()); 
                    match(input,74,FOLLOW_74_in_rule__Color__Alternatives_12531); 
                     after(grammarAccess.getColorAccess().getKhakiKeyword_1_62()); 

                    }


                    }
                    break;
                case 64 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1073:6: ( 'Lavender' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1073:6: ( 'Lavender' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1074:1: 'Lavender'
                    {
                     before(grammarAccess.getColorAccess().getLavenderKeyword_1_63()); 
                    match(input,75,FOLLOW_75_in_rule__Color__Alternatives_12551); 
                     after(grammarAccess.getColorAccess().getLavenderKeyword_1_63()); 

                    }


                    }
                    break;
                case 65 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1081:6: ( 'LavenderBlush' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1081:6: ( 'LavenderBlush' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1082:1: 'LavenderBlush'
                    {
                     before(grammarAccess.getColorAccess().getLavenderBlushKeyword_1_64()); 
                    match(input,76,FOLLOW_76_in_rule__Color__Alternatives_12571); 
                     after(grammarAccess.getColorAccess().getLavenderBlushKeyword_1_64()); 

                    }


                    }
                    break;
                case 66 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1089:6: ( 'LawnGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1089:6: ( 'LawnGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1090:1: 'LawnGreen'
                    {
                     before(grammarAccess.getColorAccess().getLawnGreenKeyword_1_65()); 
                    match(input,77,FOLLOW_77_in_rule__Color__Alternatives_12591); 
                     after(grammarAccess.getColorAccess().getLawnGreenKeyword_1_65()); 

                    }


                    }
                    break;
                case 67 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1097:6: ( 'LemonChiffon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1097:6: ( 'LemonChiffon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1098:1: 'LemonChiffon'
                    {
                     before(grammarAccess.getColorAccess().getLemonChiffonKeyword_1_66()); 
                    match(input,78,FOLLOW_78_in_rule__Color__Alternatives_12611); 
                     after(grammarAccess.getColorAccess().getLemonChiffonKeyword_1_66()); 

                    }


                    }
                    break;
                case 68 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1105:6: ( 'LightBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1105:6: ( 'LightBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1106:1: 'LightBlue'
                    {
                     before(grammarAccess.getColorAccess().getLightBlueKeyword_1_67()); 
                    match(input,79,FOLLOW_79_in_rule__Color__Alternatives_12631); 
                     after(grammarAccess.getColorAccess().getLightBlueKeyword_1_67()); 

                    }


                    }
                    break;
                case 69 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1113:6: ( 'LightCoral' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1113:6: ( 'LightCoral' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1114:1: 'LightCoral'
                    {
                     before(grammarAccess.getColorAccess().getLightCoralKeyword_1_68()); 
                    match(input,80,FOLLOW_80_in_rule__Color__Alternatives_12651); 
                     after(grammarAccess.getColorAccess().getLightCoralKeyword_1_68()); 

                    }


                    }
                    break;
                case 70 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1121:6: ( 'LightCyan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1121:6: ( 'LightCyan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1122:1: 'LightCyan'
                    {
                     before(grammarAccess.getColorAccess().getLightCyanKeyword_1_69()); 
                    match(input,81,FOLLOW_81_in_rule__Color__Alternatives_12671); 
                     after(grammarAccess.getColorAccess().getLightCyanKeyword_1_69()); 

                    }


                    }
                    break;
                case 71 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1129:6: ( 'LightGoldenRodYellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1129:6: ( 'LightGoldenRodYellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1130:1: 'LightGoldenRodYellow'
                    {
                     before(grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_1_70()); 
                    match(input,82,FOLLOW_82_in_rule__Color__Alternatives_12691); 
                     after(grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_1_70()); 

                    }


                    }
                    break;
                case 72 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1137:6: ( 'LightGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1137:6: ( 'LightGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1138:1: 'LightGray'
                    {
                     before(grammarAccess.getColorAccess().getLightGrayKeyword_1_71()); 
                    match(input,83,FOLLOW_83_in_rule__Color__Alternatives_12711); 
                     after(grammarAccess.getColorAccess().getLightGrayKeyword_1_71()); 

                    }


                    }
                    break;
                case 73 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1145:6: ( 'LightGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1145:6: ( 'LightGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1146:1: 'LightGreen'
                    {
                     before(grammarAccess.getColorAccess().getLightGreenKeyword_1_72()); 
                    match(input,84,FOLLOW_84_in_rule__Color__Alternatives_12731); 
                     after(grammarAccess.getColorAccess().getLightGreenKeyword_1_72()); 

                    }


                    }
                    break;
                case 74 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1153:6: ( 'LightGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1153:6: ( 'LightGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1154:1: 'LightGrey'
                    {
                     before(grammarAccess.getColorAccess().getLightGreyKeyword_1_73()); 
                    match(input,85,FOLLOW_85_in_rule__Color__Alternatives_12751); 
                     after(grammarAccess.getColorAccess().getLightGreyKeyword_1_73()); 

                    }


                    }
                    break;
                case 75 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1161:6: ( 'LightPink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1161:6: ( 'LightPink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1162:1: 'LightPink'
                    {
                     before(grammarAccess.getColorAccess().getLightPinkKeyword_1_74()); 
                    match(input,86,FOLLOW_86_in_rule__Color__Alternatives_12771); 
                     after(grammarAccess.getColorAccess().getLightPinkKeyword_1_74()); 

                    }


                    }
                    break;
                case 76 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1169:6: ( 'LightSalmon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1169:6: ( 'LightSalmon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1170:1: 'LightSalmon'
                    {
                     before(grammarAccess.getColorAccess().getLightSalmonKeyword_1_75()); 
                    match(input,87,FOLLOW_87_in_rule__Color__Alternatives_12791); 
                     after(grammarAccess.getColorAccess().getLightSalmonKeyword_1_75()); 

                    }


                    }
                    break;
                case 77 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1177:6: ( 'LightSeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1177:6: ( 'LightSeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1178:1: 'LightSeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getLightSeaGreenKeyword_1_76()); 
                    match(input,88,FOLLOW_88_in_rule__Color__Alternatives_12811); 
                     after(grammarAccess.getColorAccess().getLightSeaGreenKeyword_1_76()); 

                    }


                    }
                    break;
                case 78 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1185:6: ( 'LightSkyBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1185:6: ( 'LightSkyBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1186:1: 'LightSkyBlue'
                    {
                     before(grammarAccess.getColorAccess().getLightSkyBlueKeyword_1_77()); 
                    match(input,89,FOLLOW_89_in_rule__Color__Alternatives_12831); 
                     after(grammarAccess.getColorAccess().getLightSkyBlueKeyword_1_77()); 

                    }


                    }
                    break;
                case 79 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1193:6: ( 'LightSlateGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1193:6: ( 'LightSlateGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1194:1: 'LightSlateGray'
                    {
                     before(grammarAccess.getColorAccess().getLightSlateGrayKeyword_1_78()); 
                    match(input,90,FOLLOW_90_in_rule__Color__Alternatives_12851); 
                     after(grammarAccess.getColorAccess().getLightSlateGrayKeyword_1_78()); 

                    }


                    }
                    break;
                case 80 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1201:6: ( 'LightSlateGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1201:6: ( 'LightSlateGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1202:1: 'LightSlateGrey'
                    {
                     before(grammarAccess.getColorAccess().getLightSlateGreyKeyword_1_79()); 
                    match(input,91,FOLLOW_91_in_rule__Color__Alternatives_12871); 
                     after(grammarAccess.getColorAccess().getLightSlateGreyKeyword_1_79()); 

                    }


                    }
                    break;
                case 81 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1209:6: ( 'LightSteelBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1209:6: ( 'LightSteelBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1210:1: 'LightSteelBlue'
                    {
                     before(grammarAccess.getColorAccess().getLightSteelBlueKeyword_1_80()); 
                    match(input,92,FOLLOW_92_in_rule__Color__Alternatives_12891); 
                     after(grammarAccess.getColorAccess().getLightSteelBlueKeyword_1_80()); 

                    }


                    }
                    break;
                case 82 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1217:6: ( 'LightYellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1217:6: ( 'LightYellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1218:1: 'LightYellow'
                    {
                     before(grammarAccess.getColorAccess().getLightYellowKeyword_1_81()); 
                    match(input,93,FOLLOW_93_in_rule__Color__Alternatives_12911); 
                     after(grammarAccess.getColorAccess().getLightYellowKeyword_1_81()); 

                    }


                    }
                    break;
                case 83 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1225:6: ( 'Lime' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1225:6: ( 'Lime' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1226:1: 'Lime'
                    {
                     before(grammarAccess.getColorAccess().getLimeKeyword_1_82()); 
                    match(input,94,FOLLOW_94_in_rule__Color__Alternatives_12931); 
                     after(grammarAccess.getColorAccess().getLimeKeyword_1_82()); 

                    }


                    }
                    break;
                case 84 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1233:6: ( 'LimeGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1233:6: ( 'LimeGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1234:1: 'LimeGreen'
                    {
                     before(grammarAccess.getColorAccess().getLimeGreenKeyword_1_83()); 
                    match(input,95,FOLLOW_95_in_rule__Color__Alternatives_12951); 
                     after(grammarAccess.getColorAccess().getLimeGreenKeyword_1_83()); 

                    }


                    }
                    break;
                case 85 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1241:6: ( 'Linen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1241:6: ( 'Linen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1242:1: 'Linen'
                    {
                     before(grammarAccess.getColorAccess().getLinenKeyword_1_84()); 
                    match(input,96,FOLLOW_96_in_rule__Color__Alternatives_12971); 
                     after(grammarAccess.getColorAccess().getLinenKeyword_1_84()); 

                    }


                    }
                    break;
                case 86 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1249:6: ( 'Magenta' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1249:6: ( 'Magenta' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1250:1: 'Magenta'
                    {
                     before(grammarAccess.getColorAccess().getMagentaKeyword_1_85()); 
                    match(input,97,FOLLOW_97_in_rule__Color__Alternatives_12991); 
                     after(grammarAccess.getColorAccess().getMagentaKeyword_1_85()); 

                    }


                    }
                    break;
                case 87 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1257:6: ( 'Maroon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1257:6: ( 'Maroon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1258:1: 'Maroon'
                    {
                     before(grammarAccess.getColorAccess().getMaroonKeyword_1_86()); 
                    match(input,98,FOLLOW_98_in_rule__Color__Alternatives_13011); 
                     after(grammarAccess.getColorAccess().getMaroonKeyword_1_86()); 

                    }


                    }
                    break;
                case 88 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1265:6: ( 'MediumAquaMarine' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1265:6: ( 'MediumAquaMarine' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1266:1: 'MediumAquaMarine'
                    {
                     before(grammarAccess.getColorAccess().getMediumAquaMarineKeyword_1_87()); 
                    match(input,99,FOLLOW_99_in_rule__Color__Alternatives_13031); 
                     after(grammarAccess.getColorAccess().getMediumAquaMarineKeyword_1_87()); 

                    }


                    }
                    break;
                case 89 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1273:6: ( 'MediumBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1273:6: ( 'MediumBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1274:1: 'MediumBlue'
                    {
                     before(grammarAccess.getColorAccess().getMediumBlueKeyword_1_88()); 
                    match(input,100,FOLLOW_100_in_rule__Color__Alternatives_13051); 
                     after(grammarAccess.getColorAccess().getMediumBlueKeyword_1_88()); 

                    }


                    }
                    break;
                case 90 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1281:6: ( 'MediumOrchid' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1281:6: ( 'MediumOrchid' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1282:1: 'MediumOrchid'
                    {
                     before(grammarAccess.getColorAccess().getMediumOrchidKeyword_1_89()); 
                    match(input,101,FOLLOW_101_in_rule__Color__Alternatives_13071); 
                     after(grammarAccess.getColorAccess().getMediumOrchidKeyword_1_89()); 

                    }


                    }
                    break;
                case 91 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1289:6: ( 'MediumPurple' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1289:6: ( 'MediumPurple' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1290:1: 'MediumPurple'
                    {
                     before(grammarAccess.getColorAccess().getMediumPurpleKeyword_1_90()); 
                    match(input,102,FOLLOW_102_in_rule__Color__Alternatives_13091); 
                     after(grammarAccess.getColorAccess().getMediumPurpleKeyword_1_90()); 

                    }


                    }
                    break;
                case 92 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1297:6: ( 'MediumSeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1297:6: ( 'MediumSeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1298:1: 'MediumSeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getMediumSeaGreenKeyword_1_91()); 
                    match(input,103,FOLLOW_103_in_rule__Color__Alternatives_13111); 
                     after(grammarAccess.getColorAccess().getMediumSeaGreenKeyword_1_91()); 

                    }


                    }
                    break;
                case 93 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1305:6: ( 'MediumSlateBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1305:6: ( 'MediumSlateBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1306:1: 'MediumSlateBlue'
                    {
                     before(grammarAccess.getColorAccess().getMediumSlateBlueKeyword_1_92()); 
                    match(input,104,FOLLOW_104_in_rule__Color__Alternatives_13131); 
                     after(grammarAccess.getColorAccess().getMediumSlateBlueKeyword_1_92()); 

                    }


                    }
                    break;
                case 94 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1313:6: ( 'MediumSpringGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1313:6: ( 'MediumSpringGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1314:1: 'MediumSpringGreen'
                    {
                     before(grammarAccess.getColorAccess().getMediumSpringGreenKeyword_1_93()); 
                    match(input,105,FOLLOW_105_in_rule__Color__Alternatives_13151); 
                     after(grammarAccess.getColorAccess().getMediumSpringGreenKeyword_1_93()); 

                    }


                    }
                    break;
                case 95 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1321:6: ( 'MediumTurquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1321:6: ( 'MediumTurquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1322:1: 'MediumTurquoise'
                    {
                     before(grammarAccess.getColorAccess().getMediumTurquoiseKeyword_1_94()); 
                    match(input,106,FOLLOW_106_in_rule__Color__Alternatives_13171); 
                     after(grammarAccess.getColorAccess().getMediumTurquoiseKeyword_1_94()); 

                    }


                    }
                    break;
                case 96 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1329:6: ( 'MediumVioletRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1329:6: ( 'MediumVioletRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1330:1: 'MediumVioletRed'
                    {
                     before(grammarAccess.getColorAccess().getMediumVioletRedKeyword_1_95()); 
                    match(input,107,FOLLOW_107_in_rule__Color__Alternatives_13191); 
                     after(grammarAccess.getColorAccess().getMediumVioletRedKeyword_1_95()); 

                    }


                    }
                    break;
                case 97 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1337:6: ( 'MidnightBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1337:6: ( 'MidnightBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1338:1: 'MidnightBlue'
                    {
                     before(grammarAccess.getColorAccess().getMidnightBlueKeyword_1_96()); 
                    match(input,108,FOLLOW_108_in_rule__Color__Alternatives_13211); 
                     after(grammarAccess.getColorAccess().getMidnightBlueKeyword_1_96()); 

                    }


                    }
                    break;
                case 98 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1345:6: ( 'MintCream' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1345:6: ( 'MintCream' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1346:1: 'MintCream'
                    {
                     before(grammarAccess.getColorAccess().getMintCreamKeyword_1_97()); 
                    match(input,109,FOLLOW_109_in_rule__Color__Alternatives_13231); 
                     after(grammarAccess.getColorAccess().getMintCreamKeyword_1_97()); 

                    }


                    }
                    break;
                case 99 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1353:6: ( 'MistyRose' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1353:6: ( 'MistyRose' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1354:1: 'MistyRose'
                    {
                     before(grammarAccess.getColorAccess().getMistyRoseKeyword_1_98()); 
                    match(input,110,FOLLOW_110_in_rule__Color__Alternatives_13251); 
                     after(grammarAccess.getColorAccess().getMistyRoseKeyword_1_98()); 

                    }


                    }
                    break;
                case 100 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1361:6: ( 'Moccasin' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1361:6: ( 'Moccasin' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1362:1: 'Moccasin'
                    {
                     before(grammarAccess.getColorAccess().getMoccasinKeyword_1_99()); 
                    match(input,111,FOLLOW_111_in_rule__Color__Alternatives_13271); 
                     after(grammarAccess.getColorAccess().getMoccasinKeyword_1_99()); 

                    }


                    }
                    break;
                case 101 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1369:6: ( 'NavajoWhite' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1369:6: ( 'NavajoWhite' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1370:1: 'NavajoWhite'
                    {
                     before(grammarAccess.getColorAccess().getNavajoWhiteKeyword_1_100()); 
                    match(input,112,FOLLOW_112_in_rule__Color__Alternatives_13291); 
                     after(grammarAccess.getColorAccess().getNavajoWhiteKeyword_1_100()); 

                    }


                    }
                    break;
                case 102 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1377:6: ( 'Navy' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1377:6: ( 'Navy' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1378:1: 'Navy'
                    {
                     before(grammarAccess.getColorAccess().getNavyKeyword_1_101()); 
                    match(input,113,FOLLOW_113_in_rule__Color__Alternatives_13311); 
                     after(grammarAccess.getColorAccess().getNavyKeyword_1_101()); 

                    }


                    }
                    break;
                case 103 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1385:6: ( 'OldLace' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1385:6: ( 'OldLace' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1386:1: 'OldLace'
                    {
                     before(grammarAccess.getColorAccess().getOldLaceKeyword_1_102()); 
                    match(input,114,FOLLOW_114_in_rule__Color__Alternatives_13331); 
                     after(grammarAccess.getColorAccess().getOldLaceKeyword_1_102()); 

                    }


                    }
                    break;
                case 104 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1393:6: ( 'Olive' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1393:6: ( 'Olive' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1394:1: 'Olive'
                    {
                     before(grammarAccess.getColorAccess().getOliveKeyword_1_103()); 
                    match(input,115,FOLLOW_115_in_rule__Color__Alternatives_13351); 
                     after(grammarAccess.getColorAccess().getOliveKeyword_1_103()); 

                    }


                    }
                    break;
                case 105 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1401:6: ( 'OliveDrab' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1401:6: ( 'OliveDrab' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1402:1: 'OliveDrab'
                    {
                     before(grammarAccess.getColorAccess().getOliveDrabKeyword_1_104()); 
                    match(input,116,FOLLOW_116_in_rule__Color__Alternatives_13371); 
                     after(grammarAccess.getColorAccess().getOliveDrabKeyword_1_104()); 

                    }


                    }
                    break;
                case 106 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1409:6: ( 'OrangeRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1409:6: ( 'OrangeRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1410:1: 'OrangeRed'
                    {
                     before(grammarAccess.getColorAccess().getOrangeRedKeyword_1_105()); 
                    match(input,117,FOLLOW_117_in_rule__Color__Alternatives_13391); 
                     after(grammarAccess.getColorAccess().getOrangeRedKeyword_1_105()); 

                    }


                    }
                    break;
                case 107 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1417:6: ( 'Orchid' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1417:6: ( 'Orchid' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1418:1: 'Orchid'
                    {
                     before(grammarAccess.getColorAccess().getOrchidKeyword_1_106()); 
                    match(input,118,FOLLOW_118_in_rule__Color__Alternatives_13411); 
                     after(grammarAccess.getColorAccess().getOrchidKeyword_1_106()); 

                    }


                    }
                    break;
                case 108 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1425:6: ( 'PaleGoldenRod' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1425:6: ( 'PaleGoldenRod' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1426:1: 'PaleGoldenRod'
                    {
                     before(grammarAccess.getColorAccess().getPaleGoldenRodKeyword_1_107()); 
                    match(input,119,FOLLOW_119_in_rule__Color__Alternatives_13431); 
                     after(grammarAccess.getColorAccess().getPaleGoldenRodKeyword_1_107()); 

                    }


                    }
                    break;
                case 109 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1433:6: ( 'PaleGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1433:6: ( 'PaleGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1434:1: 'PaleGreen'
                    {
                     before(grammarAccess.getColorAccess().getPaleGreenKeyword_1_108()); 
                    match(input,120,FOLLOW_120_in_rule__Color__Alternatives_13451); 
                     after(grammarAccess.getColorAccess().getPaleGreenKeyword_1_108()); 

                    }


                    }
                    break;
                case 110 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1441:6: ( 'PaleTurquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1441:6: ( 'PaleTurquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1442:1: 'PaleTurquoise'
                    {
                     before(grammarAccess.getColorAccess().getPaleTurquoiseKeyword_1_109()); 
                    match(input,121,FOLLOW_121_in_rule__Color__Alternatives_13471); 
                     after(grammarAccess.getColorAccess().getPaleTurquoiseKeyword_1_109()); 

                    }


                    }
                    break;
                case 111 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1449:6: ( 'PaleVioletRed' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1449:6: ( 'PaleVioletRed' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1450:1: 'PaleVioletRed'
                    {
                     before(grammarAccess.getColorAccess().getPaleVioletRedKeyword_1_110()); 
                    match(input,122,FOLLOW_122_in_rule__Color__Alternatives_13491); 
                     after(grammarAccess.getColorAccess().getPaleVioletRedKeyword_1_110()); 

                    }


                    }
                    break;
                case 112 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1457:6: ( 'PapayaWhip' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1457:6: ( 'PapayaWhip' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1458:1: 'PapayaWhip'
                    {
                     before(grammarAccess.getColorAccess().getPapayaWhipKeyword_1_111()); 
                    match(input,123,FOLLOW_123_in_rule__Color__Alternatives_13511); 
                     after(grammarAccess.getColorAccess().getPapayaWhipKeyword_1_111()); 

                    }


                    }
                    break;
                case 113 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1465:6: ( 'PeachPuff' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1465:6: ( 'PeachPuff' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1466:1: 'PeachPuff'
                    {
                     before(grammarAccess.getColorAccess().getPeachPuffKeyword_1_112()); 
                    match(input,124,FOLLOW_124_in_rule__Color__Alternatives_13531); 
                     after(grammarAccess.getColorAccess().getPeachPuffKeyword_1_112()); 

                    }


                    }
                    break;
                case 114 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1473:6: ( 'Peru' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1473:6: ( 'Peru' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1474:1: 'Peru'
                    {
                     before(grammarAccess.getColorAccess().getPeruKeyword_1_113()); 
                    match(input,125,FOLLOW_125_in_rule__Color__Alternatives_13551); 
                     after(grammarAccess.getColorAccess().getPeruKeyword_1_113()); 

                    }


                    }
                    break;
                case 115 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1481:6: ( 'Pink' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1481:6: ( 'Pink' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1482:1: 'Pink'
                    {
                     before(grammarAccess.getColorAccess().getPinkKeyword_1_114()); 
                    match(input,126,FOLLOW_126_in_rule__Color__Alternatives_13571); 
                     after(grammarAccess.getColorAccess().getPinkKeyword_1_114()); 

                    }


                    }
                    break;
                case 116 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1489:6: ( 'Plum' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1489:6: ( 'Plum' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1490:1: 'Plum'
                    {
                     before(grammarAccess.getColorAccess().getPlumKeyword_1_115()); 
                    match(input,127,FOLLOW_127_in_rule__Color__Alternatives_13591); 
                     after(grammarAccess.getColorAccess().getPlumKeyword_1_115()); 

                    }


                    }
                    break;
                case 117 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1497:6: ( 'PowderBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1497:6: ( 'PowderBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1498:1: 'PowderBlue'
                    {
                     before(grammarAccess.getColorAccess().getPowderBlueKeyword_1_116()); 
                    match(input,128,FOLLOW_128_in_rule__Color__Alternatives_13611); 
                     after(grammarAccess.getColorAccess().getPowderBlueKeyword_1_116()); 

                    }


                    }
                    break;
                case 118 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1505:6: ( 'Purple' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1505:6: ( 'Purple' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1506:1: 'Purple'
                    {
                     before(grammarAccess.getColorAccess().getPurpleKeyword_1_117()); 
                    match(input,129,FOLLOW_129_in_rule__Color__Alternatives_13631); 
                     after(grammarAccess.getColorAccess().getPurpleKeyword_1_117()); 

                    }


                    }
                    break;
                case 119 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1513:6: ( 'Red' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1513:6: ( 'Red' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1514:1: 'Red'
                    {
                     before(grammarAccess.getColorAccess().getRedKeyword_1_118()); 
                    match(input,130,FOLLOW_130_in_rule__Color__Alternatives_13651); 
                     after(grammarAccess.getColorAccess().getRedKeyword_1_118()); 

                    }


                    }
                    break;
                case 120 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1521:6: ( 'RosyBrown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1521:6: ( 'RosyBrown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1522:1: 'RosyBrown'
                    {
                     before(grammarAccess.getColorAccess().getRosyBrownKeyword_1_119()); 
                    match(input,131,FOLLOW_131_in_rule__Color__Alternatives_13671); 
                     after(grammarAccess.getColorAccess().getRosyBrownKeyword_1_119()); 

                    }


                    }
                    break;
                case 121 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1529:6: ( 'RoyalBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1529:6: ( 'RoyalBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1530:1: 'RoyalBlue'
                    {
                     before(grammarAccess.getColorAccess().getRoyalBlueKeyword_1_120()); 
                    match(input,132,FOLLOW_132_in_rule__Color__Alternatives_13691); 
                     after(grammarAccess.getColorAccess().getRoyalBlueKeyword_1_120()); 

                    }


                    }
                    break;
                case 122 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1537:6: ( 'SaddleBrown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1537:6: ( 'SaddleBrown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1538:1: 'SaddleBrown'
                    {
                     before(grammarAccess.getColorAccess().getSaddleBrownKeyword_1_121()); 
                    match(input,133,FOLLOW_133_in_rule__Color__Alternatives_13711); 
                     after(grammarAccess.getColorAccess().getSaddleBrownKeyword_1_121()); 

                    }


                    }
                    break;
                case 123 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1545:6: ( 'Salmon' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1545:6: ( 'Salmon' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1546:1: 'Salmon'
                    {
                     before(grammarAccess.getColorAccess().getSalmonKeyword_1_122()); 
                    match(input,134,FOLLOW_134_in_rule__Color__Alternatives_13731); 
                     after(grammarAccess.getColorAccess().getSalmonKeyword_1_122()); 

                    }


                    }
                    break;
                case 124 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1553:6: ( 'SandyBrown' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1553:6: ( 'SandyBrown' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1554:1: 'SandyBrown'
                    {
                     before(grammarAccess.getColorAccess().getSandyBrownKeyword_1_123()); 
                    match(input,135,FOLLOW_135_in_rule__Color__Alternatives_13751); 
                     after(grammarAccess.getColorAccess().getSandyBrownKeyword_1_123()); 

                    }


                    }
                    break;
                case 125 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1561:6: ( 'SeaGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1561:6: ( 'SeaGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1562:1: 'SeaGreen'
                    {
                     before(grammarAccess.getColorAccess().getSeaGreenKeyword_1_124()); 
                    match(input,136,FOLLOW_136_in_rule__Color__Alternatives_13771); 
                     after(grammarAccess.getColorAccess().getSeaGreenKeyword_1_124()); 

                    }


                    }
                    break;
                case 126 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1569:6: ( 'Sienna' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1569:6: ( 'Sienna' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1570:1: 'Sienna'
                    {
                     before(grammarAccess.getColorAccess().getSiennaKeyword_1_125()); 
                    match(input,137,FOLLOW_137_in_rule__Color__Alternatives_13791); 
                     after(grammarAccess.getColorAccess().getSiennaKeyword_1_125()); 

                    }


                    }
                    break;
                case 127 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1577:6: ( 'Silver' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1577:6: ( 'Silver' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1578:1: 'Silver'
                    {
                     before(grammarAccess.getColorAccess().getSilverKeyword_1_126()); 
                    match(input,138,FOLLOW_138_in_rule__Color__Alternatives_13811); 
                     after(grammarAccess.getColorAccess().getSilverKeyword_1_126()); 

                    }


                    }
                    break;
                case 128 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1585:6: ( 'SkyBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1585:6: ( 'SkyBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1586:1: 'SkyBlue'
                    {
                     before(grammarAccess.getColorAccess().getSkyBlueKeyword_1_127()); 
                    match(input,139,FOLLOW_139_in_rule__Color__Alternatives_13831); 
                     after(grammarAccess.getColorAccess().getSkyBlueKeyword_1_127()); 

                    }


                    }
                    break;
                case 129 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1593:6: ( 'SlateBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1593:6: ( 'SlateBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1594:1: 'SlateBlue'
                    {
                     before(grammarAccess.getColorAccess().getSlateBlueKeyword_1_128()); 
                    match(input,140,FOLLOW_140_in_rule__Color__Alternatives_13851); 
                     after(grammarAccess.getColorAccess().getSlateBlueKeyword_1_128()); 

                    }


                    }
                    break;
                case 130 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1601:6: ( 'SlateGray' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1601:6: ( 'SlateGray' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1602:1: 'SlateGray'
                    {
                     before(grammarAccess.getColorAccess().getSlateGrayKeyword_1_129()); 
                    match(input,141,FOLLOW_141_in_rule__Color__Alternatives_13871); 
                     after(grammarAccess.getColorAccess().getSlateGrayKeyword_1_129()); 

                    }


                    }
                    break;
                case 131 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1609:6: ( 'SlateGrey' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1609:6: ( 'SlateGrey' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1610:1: 'SlateGrey'
                    {
                     before(grammarAccess.getColorAccess().getSlateGreyKeyword_1_130()); 
                    match(input,142,FOLLOW_142_in_rule__Color__Alternatives_13891); 
                     after(grammarAccess.getColorAccess().getSlateGreyKeyword_1_130()); 

                    }


                    }
                    break;
                case 132 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1617:6: ( 'Snow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1617:6: ( 'Snow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1618:1: 'Snow'
                    {
                     before(grammarAccess.getColorAccess().getSnowKeyword_1_131()); 
                    match(input,143,FOLLOW_143_in_rule__Color__Alternatives_13911); 
                     after(grammarAccess.getColorAccess().getSnowKeyword_1_131()); 

                    }


                    }
                    break;
                case 133 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1625:6: ( 'SpringGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1625:6: ( 'SpringGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1626:1: 'SpringGreen'
                    {
                     before(grammarAccess.getColorAccess().getSpringGreenKeyword_1_132()); 
                    match(input,144,FOLLOW_144_in_rule__Color__Alternatives_13931); 
                     after(grammarAccess.getColorAccess().getSpringGreenKeyword_1_132()); 

                    }


                    }
                    break;
                case 134 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1633:6: ( 'SteelBlue' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1633:6: ( 'SteelBlue' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1634:1: 'SteelBlue'
                    {
                     before(grammarAccess.getColorAccess().getSteelBlueKeyword_1_133()); 
                    match(input,145,FOLLOW_145_in_rule__Color__Alternatives_13951); 
                     after(grammarAccess.getColorAccess().getSteelBlueKeyword_1_133()); 

                    }


                    }
                    break;
                case 135 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1641:6: ( 'Tan' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1641:6: ( 'Tan' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1642:1: 'Tan'
                    {
                     before(grammarAccess.getColorAccess().getTanKeyword_1_134()); 
                    match(input,146,FOLLOW_146_in_rule__Color__Alternatives_13971); 
                     after(grammarAccess.getColorAccess().getTanKeyword_1_134()); 

                    }


                    }
                    break;
                case 136 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1649:6: ( 'Teal' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1649:6: ( 'Teal' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1650:1: 'Teal'
                    {
                     before(grammarAccess.getColorAccess().getTealKeyword_1_135()); 
                    match(input,147,FOLLOW_147_in_rule__Color__Alternatives_13991); 
                     after(grammarAccess.getColorAccess().getTealKeyword_1_135()); 

                    }


                    }
                    break;
                case 137 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1657:6: ( 'Thistle' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1657:6: ( 'Thistle' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1658:1: 'Thistle'
                    {
                     before(grammarAccess.getColorAccess().getThistleKeyword_1_136()); 
                    match(input,148,FOLLOW_148_in_rule__Color__Alternatives_14011); 
                     after(grammarAccess.getColorAccess().getThistleKeyword_1_136()); 

                    }


                    }
                    break;
                case 138 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1665:6: ( 'Tomato' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1665:6: ( 'Tomato' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1666:1: 'Tomato'
                    {
                     before(grammarAccess.getColorAccess().getTomatoKeyword_1_137()); 
                    match(input,149,FOLLOW_149_in_rule__Color__Alternatives_14031); 
                     after(grammarAccess.getColorAccess().getTomatoKeyword_1_137()); 

                    }


                    }
                    break;
                case 139 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1673:6: ( 'Turquoise' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1673:6: ( 'Turquoise' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1674:1: 'Turquoise'
                    {
                     before(grammarAccess.getColorAccess().getTurquoiseKeyword_1_138()); 
                    match(input,150,FOLLOW_150_in_rule__Color__Alternatives_14051); 
                     after(grammarAccess.getColorAccess().getTurquoiseKeyword_1_138()); 

                    }


                    }
                    break;
                case 140 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1681:6: ( 'Violet' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1681:6: ( 'Violet' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1682:1: 'Violet'
                    {
                     before(grammarAccess.getColorAccess().getVioletKeyword_1_139()); 
                    match(input,151,FOLLOW_151_in_rule__Color__Alternatives_14071); 
                     after(grammarAccess.getColorAccess().getVioletKeyword_1_139()); 

                    }


                    }
                    break;
                case 141 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1689:6: ( 'Wheat' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1689:6: ( 'Wheat' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1690:1: 'Wheat'
                    {
                     before(grammarAccess.getColorAccess().getWheatKeyword_1_140()); 
                    match(input,152,FOLLOW_152_in_rule__Color__Alternatives_14091); 
                     after(grammarAccess.getColorAccess().getWheatKeyword_1_140()); 

                    }


                    }
                    break;
                case 142 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1697:6: ( 'White' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1697:6: ( 'White' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1698:1: 'White'
                    {
                     before(grammarAccess.getColorAccess().getWhiteKeyword_1_141()); 
                    match(input,153,FOLLOW_153_in_rule__Color__Alternatives_14111); 
                     after(grammarAccess.getColorAccess().getWhiteKeyword_1_141()); 

                    }


                    }
                    break;
                case 143 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1705:6: ( 'WhiteSmoke' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1705:6: ( 'WhiteSmoke' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1706:1: 'WhiteSmoke'
                    {
                     before(grammarAccess.getColorAccess().getWhiteSmokeKeyword_1_142()); 
                    match(input,154,FOLLOW_154_in_rule__Color__Alternatives_14131); 
                     after(grammarAccess.getColorAccess().getWhiteSmokeKeyword_1_142()); 

                    }


                    }
                    break;
                case 144 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1713:6: ( 'Yellow' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1713:6: ( 'Yellow' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1714:1: 'Yellow'
                    {
                     before(grammarAccess.getColorAccess().getYellowKeyword_1_143()); 
                    match(input,155,FOLLOW_155_in_rule__Color__Alternatives_14151); 
                     after(grammarAccess.getColorAccess().getYellowKeyword_1_143()); 

                    }


                    }
                    break;
                case 145 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1721:6: ( 'YellowGreen' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1721:6: ( 'YellowGreen' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1722:1: 'YellowGreen'
                    {
                     before(grammarAccess.getColorAccess().getYellowGreenKeyword_1_144()); 
                    match(input,156,FOLLOW_156_in_rule__Color__Alternatives_14171); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1734:1: rule__Legend__Alternatives_1 : ( ( 'right' ) | ( 'left' ) | ( 'center' ) );
    public final void rule__Legend__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1738:1: ( ( 'right' ) | ( 'left' ) | ( 'center' ) )
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1739:1: ( 'right' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1739:1: ( 'right' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1740:1: 'right'
                    {
                     before(grammarAccess.getLegendAccess().getRightKeyword_1_0()); 
                    match(input,157,FOLLOW_157_in_rule__Legend__Alternatives_14206); 
                     after(grammarAccess.getLegendAccess().getRightKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1747:6: ( 'left' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1747:6: ( 'left' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1748:1: 'left'
                    {
                     before(grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 
                    match(input,158,FOLLOW_158_in_rule__Legend__Alternatives_14226); 
                     after(grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1755:6: ( 'center' )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1755:6: ( 'center' )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1756:1: 'center'
                    {
                     before(grammarAccess.getLegendAccess().getCenterKeyword_1_2()); 
                    match(input,159,FOLLOW_159_in_rule__Legend__Alternatives_14246); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1768:1: rule__Legend__Alternatives_2 : ( ( ( rule__Legend__Group_2_0__0 ) ) | ( RULE_NEWLINE ) );
    public final void rule__Legend__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1772:1: ( ( ( rule__Legend__Group_2_0__0 ) ) | ( RULE_NEWLINE ) )
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1773:1: ( ( rule__Legend__Group_2_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1773:1: ( ( rule__Legend__Group_2_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1774:1: ( rule__Legend__Group_2_0__0 )
                    {
                     before(grammarAccess.getLegendAccess().getGroup_2_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1775:1: ( rule__Legend__Group_2_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1775:2: rule__Legend__Group_2_0__0
                    {
                    pushFollow(FOLLOW_rule__Legend__Group_2_0__0_in_rule__Legend__Alternatives_24280);
                    rule__Legend__Group_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLegendAccess().getGroup_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1779:6: ( RULE_NEWLINE )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1779:6: ( RULE_NEWLINE )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1780:1: RULE_NEWLINE
                    {
                     before(grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_1()); 
                    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Legend__Alternatives_24298); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1792:1: rule__Diagram__Group__0 : rule__Diagram__Group__0__Impl rule__Diagram__Group__1 ;
    public final void rule__Diagram__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1796:1: ( rule__Diagram__Group__0__Impl rule__Diagram__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1797:2: rule__Diagram__Group__0__Impl rule__Diagram__Group__1
            {
            pushFollow(FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__04328);
            rule__Diagram__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__04331);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1804:1: rule__Diagram__Group__0__Impl : ( '@startuml' ) ;
    public final void rule__Diagram__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1808:1: ( ( '@startuml' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1809:1: ( '@startuml' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1809:1: ( '@startuml' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1810:1: '@startuml'
            {
             before(grammarAccess.getDiagramAccess().getStartumlKeyword_0()); 
            match(input,160,FOLLOW_160_in_rule__Diagram__Group__0__Impl4359); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1823:1: rule__Diagram__Group__1 : rule__Diagram__Group__1__Impl rule__Diagram__Group__2 ;
    public final void rule__Diagram__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1827:1: ( rule__Diagram__Group__1__Impl rule__Diagram__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1828:2: rule__Diagram__Group__1__Impl rule__Diagram__Group__2
            {
            pushFollow(FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__14390);
            rule__Diagram__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__14393);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1835:1: rule__Diagram__Group__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Diagram__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1839:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1840:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1840:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1841:1: RULE_NEWLINE
            {
             before(grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__1__Impl4420); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1852:1: rule__Diagram__Group__2 : rule__Diagram__Group__2__Impl rule__Diagram__Group__3 ;
    public final void rule__Diagram__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1856:1: ( rule__Diagram__Group__2__Impl rule__Diagram__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1857:2: rule__Diagram__Group__2__Impl rule__Diagram__Group__3
            {
            pushFollow(FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__24449);
            rule__Diagram__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__3_in_rule__Diagram__Group__24452);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1864:1: rule__Diagram__Group__2__Impl : ( ( rule__Diagram__InstructionsAssignment_2 )* ) ;
    public final void rule__Diagram__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1868:1: ( ( ( rule__Diagram__InstructionsAssignment_2 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1869:1: ( ( rule__Diagram__InstructionsAssignment_2 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1869:1: ( ( rule__Diagram__InstructionsAssignment_2 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1870:1: ( rule__Diagram__InstructionsAssignment_2 )*
            {
             before(grammarAccess.getDiagramAccess().getInstructionsAssignment_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1871:1: ( rule__Diagram__InstructionsAssignment_2 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=RULE_NEWLINE && LA8_0<=RULE_ID)||(LA8_0>=172 && LA8_0<=177)||(LA8_0>=179 && LA8_0<=180)||LA8_0==182) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1871:2: rule__Diagram__InstructionsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Diagram__InstructionsAssignment_2_in_rule__Diagram__Group__2__Impl4479);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1881:1: rule__Diagram__Group__3 : rule__Diagram__Group__3__Impl ;
    public final void rule__Diagram__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1885:1: ( rule__Diagram__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1886:2: rule__Diagram__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Diagram__Group__3__Impl_in_rule__Diagram__Group__34510);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1892:1: rule__Diagram__Group__3__Impl : ( '@enduml' ) ;
    public final void rule__Diagram__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1896:1: ( ( '@enduml' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1897:1: ( '@enduml' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1897:1: ( '@enduml' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1898:1: '@enduml'
            {
             before(grammarAccess.getDiagramAccess().getEndumlKeyword_3()); 
            match(input,161,FOLLOW_161_in_rule__Diagram__Group__3__Impl4538); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1919:1: rule__Instruction__Group__0 : rule__Instruction__Group__0__Impl rule__Instruction__Group__1 ;
    public final void rule__Instruction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1923:1: ( rule__Instruction__Group__0__Impl rule__Instruction__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1924:2: rule__Instruction__Group__0__Impl rule__Instruction__Group__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group__0__Impl_in_rule__Instruction__Group__04577);
            rule__Instruction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group__1_in_rule__Instruction__Group__04580);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1931:1: rule__Instruction__Group__0__Impl : ( ( rule__Instruction__Alternatives_0 )? ) ;
    public final void rule__Instruction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1935:1: ( ( ( rule__Instruction__Alternatives_0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1936:1: ( ( rule__Instruction__Alternatives_0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1936:1: ( ( rule__Instruction__Alternatives_0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1937:1: ( rule__Instruction__Alternatives_0 )?
            {
             before(grammarAccess.getInstructionAccess().getAlternatives_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1938:1: ( rule__Instruction__Alternatives_0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID||(LA9_0>=172 && LA9_0<=177)||(LA9_0>=179 && LA9_0<=180)||LA9_0==182) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1938:2: rule__Instruction__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Alternatives_0_in_rule__Instruction__Group__0__Impl4607);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1948:1: rule__Instruction__Group__1 : rule__Instruction__Group__1__Impl ;
    public final void rule__Instruction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1952:1: ( rule__Instruction__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1953:2: rule__Instruction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group__1__Impl_in_rule__Instruction__Group__14638);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1959:1: rule__Instruction__Group__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Instruction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1963:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1964:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1964:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1965:1: RULE_NEWLINE
            {
             before(grammarAccess.getInstructionAccess().getNEWLINETerminalRuleCall_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Instruction__Group__1__Impl4665); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1980:1: rule__Instruction__Group_0_0__0 : rule__Instruction__Group_0_0__0__Impl rule__Instruction__Group_0_0__1 ;
    public final void rule__Instruction__Group_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1984:1: ( rule__Instruction__Group_0_0__0__Impl rule__Instruction__Group_0_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1985:2: rule__Instruction__Group_0_0__0__Impl rule__Instruction__Group_0_0__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_0__0__Impl_in_rule__Instruction__Group_0_0__04698);
            rule__Instruction__Group_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_0__1_in_rule__Instruction__Group_0_0__04701);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1992:1: rule__Instruction__Group_0_0__0__Impl : ( ( rule__Instruction__Name1Assignment_0_0_0 ) ) ;
    public final void rule__Instruction__Group_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1996:1: ( ( ( rule__Instruction__Name1Assignment_0_0_0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1997:1: ( ( rule__Instruction__Name1Assignment_0_0_0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1997:1: ( ( rule__Instruction__Name1Assignment_0_0_0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1998:1: ( rule__Instruction__Name1Assignment_0_0_0 )
            {
             before(grammarAccess.getInstructionAccess().getName1Assignment_0_0_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1999:1: ( rule__Instruction__Name1Assignment_0_0_0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:1999:2: rule__Instruction__Name1Assignment_0_0_0
            {
            pushFollow(FOLLOW_rule__Instruction__Name1Assignment_0_0_0_in_rule__Instruction__Group_0_0__0__Impl4728);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2009:1: rule__Instruction__Group_0_0__1 : rule__Instruction__Group_0_0__1__Impl rule__Instruction__Group_0_0__2 ;
    public final void rule__Instruction__Group_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2013:1: ( rule__Instruction__Group_0_0__1__Impl rule__Instruction__Group_0_0__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2014:2: rule__Instruction__Group_0_0__1__Impl rule__Instruction__Group_0_0__2
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_0__1__Impl_in_rule__Instruction__Group_0_0__14758);
            rule__Instruction__Group_0_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_0__2_in_rule__Instruction__Group_0_0__14761);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2021:1: rule__Instruction__Group_0_0__1__Impl : ( ruleSequence ) ;
    public final void rule__Instruction__Group_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2025:1: ( ( ruleSequence ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2026:1: ( ruleSequence )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2026:1: ( ruleSequence )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2027:1: ruleSequence
            {
             before(grammarAccess.getInstructionAccess().getSequenceParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_ruleSequence_in_rule__Instruction__Group_0_0__1__Impl4788);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2038:1: rule__Instruction__Group_0_0__2 : rule__Instruction__Group_0_0__2__Impl rule__Instruction__Group_0_0__3 ;
    public final void rule__Instruction__Group_0_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2042:1: ( rule__Instruction__Group_0_0__2__Impl rule__Instruction__Group_0_0__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2043:2: rule__Instruction__Group_0_0__2__Impl rule__Instruction__Group_0_0__3
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_0__2__Impl_in_rule__Instruction__Group_0_0__24817);
            rule__Instruction__Group_0_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_0__3_in_rule__Instruction__Group_0_0__24820);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2050:1: rule__Instruction__Group_0_0__2__Impl : ( ( rule__Instruction__Name2Assignment_0_0_2 ) ) ;
    public final void rule__Instruction__Group_0_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2054:1: ( ( ( rule__Instruction__Name2Assignment_0_0_2 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2055:1: ( ( rule__Instruction__Name2Assignment_0_0_2 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2055:1: ( ( rule__Instruction__Name2Assignment_0_0_2 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2056:1: ( rule__Instruction__Name2Assignment_0_0_2 )
            {
             before(grammarAccess.getInstructionAccess().getName2Assignment_0_0_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2057:1: ( rule__Instruction__Name2Assignment_0_0_2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2057:2: rule__Instruction__Name2Assignment_0_0_2
            {
            pushFollow(FOLLOW_rule__Instruction__Name2Assignment_0_0_2_in_rule__Instruction__Group_0_0__2__Impl4847);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2067:1: rule__Instruction__Group_0_0__3 : rule__Instruction__Group_0_0__3__Impl ;
    public final void rule__Instruction__Group_0_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2071:1: ( rule__Instruction__Group_0_0__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2072:2: rule__Instruction__Group_0_0__3__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_0__3__Impl_in_rule__Instruction__Group_0_0__34877);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2078:1: rule__Instruction__Group_0_0__3__Impl : ( ( rule__Instruction__Group_0_0_3__0 )? ) ;
    public final void rule__Instruction__Group_0_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2082:1: ( ( ( rule__Instruction__Group_0_0_3__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2083:1: ( ( rule__Instruction__Group_0_0_3__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2083:1: ( ( rule__Instruction__Group_0_0_3__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2084:1: ( rule__Instruction__Group_0_0_3__0 )?
            {
             before(grammarAccess.getInstructionAccess().getGroup_0_0_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2085:1: ( rule__Instruction__Group_0_0_3__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==162) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2085:2: rule__Instruction__Group_0_0_3__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_0_0_3__0_in_rule__Instruction__Group_0_0__3__Impl4904);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2103:1: rule__Instruction__Group_0_0_3__0 : rule__Instruction__Group_0_0_3__0__Impl rule__Instruction__Group_0_0_3__1 ;
    public final void rule__Instruction__Group_0_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2107:1: ( rule__Instruction__Group_0_0_3__0__Impl rule__Instruction__Group_0_0_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2108:2: rule__Instruction__Group_0_0_3__0__Impl rule__Instruction__Group_0_0_3__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_0_3__0__Impl_in_rule__Instruction__Group_0_0_3__04943);
            rule__Instruction__Group_0_0_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_0_3__1_in_rule__Instruction__Group_0_0_3__04946);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2115:1: rule__Instruction__Group_0_0_3__0__Impl : ( ':' ) ;
    public final void rule__Instruction__Group_0_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2119:1: ( ( ':' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2120:1: ( ':' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2120:1: ( ':' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2121:1: ':'
            {
             before(grammarAccess.getInstructionAccess().getColonKeyword_0_0_3_0()); 
            match(input,162,FOLLOW_162_in_rule__Instruction__Group_0_0_3__0__Impl4974); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2134:1: rule__Instruction__Group_0_0_3__1 : rule__Instruction__Group_0_0_3__1__Impl ;
    public final void rule__Instruction__Group_0_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2138:1: ( rule__Instruction__Group_0_0_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2139:2: rule__Instruction__Group_0_0_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_0_3__1__Impl_in_rule__Instruction__Group_0_0_3__15005);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2145:1: rule__Instruction__Group_0_0_3__1__Impl : ( RULE_ID ) ;
    public final void rule__Instruction__Group_0_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2149:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2150:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2150:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2151:1: RULE_ID
            {
             before(grammarAccess.getInstructionAccess().getIDTerminalRuleCall_0_0_3_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Instruction__Group_0_0_3__1__Impl5032); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2166:1: rule__Instruction__Group_0_1__0 : rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1 ;
    public final void rule__Instruction__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2170:1: ( rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2171:2: rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_1__0__Impl_in_rule__Instruction__Group_0_1__05065);
            rule__Instruction__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_1__1_in_rule__Instruction__Group_0_1__05068);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2178:1: rule__Instruction__Group_0_1__0__Impl : ( ruleDefinition ) ;
    public final void rule__Instruction__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2182:1: ( ( ruleDefinition ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2183:1: ( ruleDefinition )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2183:1: ( ruleDefinition )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2184:1: ruleDefinition
            {
             before(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_ruleDefinition_in_rule__Instruction__Group_0_1__0__Impl5095);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2195:1: rule__Instruction__Group_0_1__1 : rule__Instruction__Group_0_1__1__Impl ;
    public final void rule__Instruction__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2199:1: ( rule__Instruction__Group_0_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2200:2: rule__Instruction__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_1__1__Impl_in_rule__Instruction__Group_0_1__15124);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2206:1: rule__Instruction__Group_0_1__1__Impl : ( ( ruleColor )? ) ;
    public final void rule__Instruction__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2210:1: ( ( ( ruleColor )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2211:1: ( ( ruleColor )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2211:1: ( ( ruleColor )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2212:1: ( ruleColor )?
            {
             before(grammarAccess.getInstructionAccess().getColorParserRuleCall_0_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2213:1: ( ruleColor )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==178) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2213:3: ruleColor
                    {
                    pushFollow(FOLLOW_ruleColor_in_rule__Instruction__Group_0_1__1__Impl5152);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2227:1: rule__Sequence__Group_0__0 : rule__Sequence__Group_0__0__Impl rule__Sequence__Group_0__1 ;
    public final void rule__Sequence__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2231:1: ( rule__Sequence__Group_0__0__Impl rule__Sequence__Group_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2232:2: rule__Sequence__Group_0__0__Impl rule__Sequence__Group_0__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_0__0__Impl_in_rule__Sequence__Group_0__05187);
            rule__Sequence__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_0__1_in_rule__Sequence__Group_0__05190);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2239:1: rule__Sequence__Group_0__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2243:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2244:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2244:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2245:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_0_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2246:1: ( '-' )*
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
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2247:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_0__0__Impl5219); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2258:1: rule__Sequence__Group_0__1 : rule__Sequence__Group_0__1__Impl rule__Sequence__Group_0__2 ;
    public final void rule__Sequence__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2262:1: ( rule__Sequence__Group_0__1__Impl rule__Sequence__Group_0__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2263:2: rule__Sequence__Group_0__1__Impl rule__Sequence__Group_0__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_0__1__Impl_in_rule__Sequence__Group_0__15252);
            rule__Sequence__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_0__2_in_rule__Sequence__Group_0__15255);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2270:1: rule__Sequence__Group_0__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2274:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2275:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2275:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2276:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_0_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_0__1__Impl5283); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2289:1: rule__Sequence__Group_0__2 : rule__Sequence__Group_0__2__Impl ;
    public final void rule__Sequence__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2293:1: ( rule__Sequence__Group_0__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2294:2: rule__Sequence__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_0__2__Impl_in_rule__Sequence__Group_0__25314);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2300:1: rule__Sequence__Group_0__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2304:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2305:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2305:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2306:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_0_2()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_0__2__Impl5342); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2325:1: rule__Sequence__Group_1__0 : rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1 ;
    public final void rule__Sequence__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2329:1: ( rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2330:2: rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_1__0__Impl_in_rule__Sequence__Group_1__05379);
            rule__Sequence__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_1__1_in_rule__Sequence__Group_1__05382);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2337:1: rule__Sequence__Group_1__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2341:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2342:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2342:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2343:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_1_0()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_1__0__Impl5410); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2356:1: rule__Sequence__Group_1__1 : rule__Sequence__Group_1__1__Impl rule__Sequence__Group_1__2 ;
    public final void rule__Sequence__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2360:1: ( rule__Sequence__Group_1__1__Impl rule__Sequence__Group_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2361:2: rule__Sequence__Group_1__1__Impl rule__Sequence__Group_1__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_1__1__Impl_in_rule__Sequence__Group_1__15441);
            rule__Sequence__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_1__2_in_rule__Sequence__Group_1__15444);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2368:1: rule__Sequence__Group_1__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2372:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2373:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2373:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2374:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_1_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_1__1__Impl5472); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2387:1: rule__Sequence__Group_1__2 : rule__Sequence__Group_1__2__Impl ;
    public final void rule__Sequence__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2391:1: ( rule__Sequence__Group_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2392:2: rule__Sequence__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_1__2__Impl_in_rule__Sequence__Group_1__25503);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2398:1: rule__Sequence__Group_1__2__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2402:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2403:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2403:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2404:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_1_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2405:1: ( '-' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==163) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2406:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_1__2__Impl5532); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2423:1: rule__Sequence__Group_2__0 : rule__Sequence__Group_2__0__Impl rule__Sequence__Group_2__1 ;
    public final void rule__Sequence__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2427:1: ( rule__Sequence__Group_2__0__Impl rule__Sequence__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2428:2: rule__Sequence__Group_2__0__Impl rule__Sequence__Group_2__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_2__0__Impl_in_rule__Sequence__Group_2__05571);
            rule__Sequence__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_2__1_in_rule__Sequence__Group_2__05574);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2435:1: rule__Sequence__Group_2__0__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2439:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2440:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2440:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2441:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_2_0()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_2__0__Impl5602); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2454:1: rule__Sequence__Group_2__1 : rule__Sequence__Group_2__1__Impl rule__Sequence__Group_2__2 ;
    public final void rule__Sequence__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2458:1: ( rule__Sequence__Group_2__1__Impl rule__Sequence__Group_2__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2459:2: rule__Sequence__Group_2__1__Impl rule__Sequence__Group_2__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_2__1__Impl_in_rule__Sequence__Group_2__15633);
            rule__Sequence__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_2__2_in_rule__Sequence__Group_2__15636);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2466:1: rule__Sequence__Group_2__1__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2470:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2471:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2471:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2472:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_2_1()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_2__1__Impl5664); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2485:1: rule__Sequence__Group_2__2 : rule__Sequence__Group_2__2__Impl ;
    public final void rule__Sequence__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2489:1: ( rule__Sequence__Group_2__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2490:2: rule__Sequence__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_2__2__Impl_in_rule__Sequence__Group_2__25695);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2496:1: rule__Sequence__Group_2__2__Impl : ( 'x' ) ;
    public final void rule__Sequence__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2500:1: ( ( 'x' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2501:1: ( 'x' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2501:1: ( 'x' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2502:1: 'x'
            {
             before(grammarAccess.getSequenceAccess().getXKeyword_2_2()); 
            match(input,166,FOLLOW_166_in_rule__Sequence__Group_2__2__Impl5723); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2521:1: rule__Sequence__Group_3__0 : rule__Sequence__Group_3__0__Impl rule__Sequence__Group_3__1 ;
    public final void rule__Sequence__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2525:1: ( rule__Sequence__Group_3__0__Impl rule__Sequence__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2526:2: rule__Sequence__Group_3__0__Impl rule__Sequence__Group_3__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_3__0__Impl_in_rule__Sequence__Group_3__05760);
            rule__Sequence__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_3__1_in_rule__Sequence__Group_3__05763);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2533:1: rule__Sequence__Group_3__0__Impl : ( 'x' ) ;
    public final void rule__Sequence__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2537:1: ( ( 'x' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2538:1: ( 'x' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2538:1: ( 'x' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2539:1: 'x'
            {
             before(grammarAccess.getSequenceAccess().getXKeyword_3_0()); 
            match(input,166,FOLLOW_166_in_rule__Sequence__Group_3__0__Impl5791); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2552:1: rule__Sequence__Group_3__1 : rule__Sequence__Group_3__1__Impl rule__Sequence__Group_3__2 ;
    public final void rule__Sequence__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2556:1: ( rule__Sequence__Group_3__1__Impl rule__Sequence__Group_3__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2557:2: rule__Sequence__Group_3__1__Impl rule__Sequence__Group_3__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_3__1__Impl_in_rule__Sequence__Group_3__15822);
            rule__Sequence__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_3__2_in_rule__Sequence__Group_3__15825);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2564:1: rule__Sequence__Group_3__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2568:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2569:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2569:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2570:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_3_1()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_3__1__Impl5853); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2583:1: rule__Sequence__Group_3__2 : rule__Sequence__Group_3__2__Impl ;
    public final void rule__Sequence__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2587:1: ( rule__Sequence__Group_3__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2588:2: rule__Sequence__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_3__2__Impl_in_rule__Sequence__Group_3__25884);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2594:1: rule__Sequence__Group_3__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2598:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2599:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2599:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2600:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_3_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_3__2__Impl5912); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2619:1: rule__Sequence__Group_4__0 : rule__Sequence__Group_4__0__Impl rule__Sequence__Group_4__1 ;
    public final void rule__Sequence__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2623:1: ( rule__Sequence__Group_4__0__Impl rule__Sequence__Group_4__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2624:2: rule__Sequence__Group_4__0__Impl rule__Sequence__Group_4__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__0__Impl_in_rule__Sequence__Group_4__05949);
            rule__Sequence__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_4__1_in_rule__Sequence__Group_4__05952);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2631:1: rule__Sequence__Group_4__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2635:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2636:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2636:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2637:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_4_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2638:1: ( '-' )*
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
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2639:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_4__0__Impl5981); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2650:1: rule__Sequence__Group_4__1 : rule__Sequence__Group_4__1__Impl rule__Sequence__Group_4__2 ;
    public final void rule__Sequence__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2654:1: ( rule__Sequence__Group_4__1__Impl rule__Sequence__Group_4__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2655:2: rule__Sequence__Group_4__1__Impl rule__Sequence__Group_4__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__1__Impl_in_rule__Sequence__Group_4__16014);
            rule__Sequence__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_4__2_in_rule__Sequence__Group_4__16017);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2662:1: rule__Sequence__Group_4__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2666:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2667:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2667:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2668:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_4_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_4__1__Impl6045); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2681:1: rule__Sequence__Group_4__2 : rule__Sequence__Group_4__2__Impl rule__Sequence__Group_4__3 ;
    public final void rule__Sequence__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2685:1: ( rule__Sequence__Group_4__2__Impl rule__Sequence__Group_4__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2686:2: rule__Sequence__Group_4__2__Impl rule__Sequence__Group_4__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__2__Impl_in_rule__Sequence__Group_4__26076);
            rule__Sequence__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_4__3_in_rule__Sequence__Group_4__26079);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2693:1: rule__Sequence__Group_4__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2697:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2698:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2698:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2699:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4_2()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_4__2__Impl6107); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2712:1: rule__Sequence__Group_4__3 : rule__Sequence__Group_4__3__Impl ;
    public final void rule__Sequence__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2716:1: ( rule__Sequence__Group_4__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2717:2: rule__Sequence__Group_4__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_4__3__Impl_in_rule__Sequence__Group_4__36138);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2723:1: rule__Sequence__Group_4__3__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2727:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2728:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2728:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2729:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4_3()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_4__3__Impl6166); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2750:1: rule__Sequence__Group_5__0 : rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1 ;
    public final void rule__Sequence__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2754:1: ( rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2755:2: rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__0__Impl_in_rule__Sequence__Group_5__06205);
            rule__Sequence__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_5__1_in_rule__Sequence__Group_5__06208);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2762:1: rule__Sequence__Group_5__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2766:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2767:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2767:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2768:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_5_0()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_5__0__Impl6236); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2781:1: rule__Sequence__Group_5__1 : rule__Sequence__Group_5__1__Impl rule__Sequence__Group_5__2 ;
    public final void rule__Sequence__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2785:1: ( rule__Sequence__Group_5__1__Impl rule__Sequence__Group_5__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2786:2: rule__Sequence__Group_5__1__Impl rule__Sequence__Group_5__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__1__Impl_in_rule__Sequence__Group_5__16267);
            rule__Sequence__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_5__2_in_rule__Sequence__Group_5__16270);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2793:1: rule__Sequence__Group_5__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2797:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2798:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2798:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2799:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_5_1()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_5__1__Impl6298); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2812:1: rule__Sequence__Group_5__2 : rule__Sequence__Group_5__2__Impl rule__Sequence__Group_5__3 ;
    public final void rule__Sequence__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2816:1: ( rule__Sequence__Group_5__2__Impl rule__Sequence__Group_5__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2817:2: rule__Sequence__Group_5__2__Impl rule__Sequence__Group_5__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__2__Impl_in_rule__Sequence__Group_5__26329);
            rule__Sequence__Group_5__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_5__3_in_rule__Sequence__Group_5__26332);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2824:1: rule__Sequence__Group_5__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2828:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2829:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2829:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2830:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_5_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_5__2__Impl6360); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2843:1: rule__Sequence__Group_5__3 : rule__Sequence__Group_5__3__Impl ;
    public final void rule__Sequence__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2847:1: ( rule__Sequence__Group_5__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2848:2: rule__Sequence__Group_5__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_5__3__Impl_in_rule__Sequence__Group_5__36391);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2854:1: rule__Sequence__Group_5__3__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2858:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2859:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2859:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2860:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_5_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2861:1: ( '-' )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==163) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2862:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_5__3__Impl6420); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2881:1: rule__Sequence__Group_6__0 : rule__Sequence__Group_6__0__Impl rule__Sequence__Group_6__1 ;
    public final void rule__Sequence__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2885:1: ( rule__Sequence__Group_6__0__Impl rule__Sequence__Group_6__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2886:2: rule__Sequence__Group_6__0__Impl rule__Sequence__Group_6__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__0__Impl_in_rule__Sequence__Group_6__06461);
            rule__Sequence__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_6__1_in_rule__Sequence__Group_6__06464);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2893:1: rule__Sequence__Group_6__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2897:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2898:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2898:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2899:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_6_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2900:1: ( '-' )*
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
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2901:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_6__0__Impl6493); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2912:1: rule__Sequence__Group_6__1 : rule__Sequence__Group_6__1__Impl rule__Sequence__Group_6__2 ;
    public final void rule__Sequence__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2916:1: ( rule__Sequence__Group_6__1__Impl rule__Sequence__Group_6__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2917:2: rule__Sequence__Group_6__1__Impl rule__Sequence__Group_6__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__1__Impl_in_rule__Sequence__Group_6__16526);
            rule__Sequence__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_6__2_in_rule__Sequence__Group_6__16529);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2924:1: rule__Sequence__Group_6__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2928:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2929:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2929:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2930:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_6_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_6__1__Impl6557); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2943:1: rule__Sequence__Group_6__2 : rule__Sequence__Group_6__2__Impl rule__Sequence__Group_6__3 ;
    public final void rule__Sequence__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2947:1: ( rule__Sequence__Group_6__2__Impl rule__Sequence__Group_6__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2948:2: rule__Sequence__Group_6__2__Impl rule__Sequence__Group_6__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__2__Impl_in_rule__Sequence__Group_6__26588);
            rule__Sequence__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_6__3_in_rule__Sequence__Group_6__26591);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2955:1: rule__Sequence__Group_6__2__Impl : ( '\\\\' ) ;
    public final void rule__Sequence__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2959:1: ( ( '\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2960:1: ( '\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2960:1: ( '\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2961:1: '\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusKeyword_6_2()); 
            match(input,167,FOLLOW_167_in_rule__Sequence__Group_6__2__Impl6619); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2974:1: rule__Sequence__Group_6__3 : rule__Sequence__Group_6__3__Impl ;
    public final void rule__Sequence__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2978:1: ( rule__Sequence__Group_6__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2979:2: rule__Sequence__Group_6__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_6__3__Impl_in_rule__Sequence__Group_6__36650);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2985:1: rule__Sequence__Group_6__3__Impl : ( '\\\\' ) ;
    public final void rule__Sequence__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2989:1: ( ( '\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2990:1: ( '\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2990:1: ( '\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:2991:1: '\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusKeyword_6_3()); 
            match(input,167,FOLLOW_167_in_rule__Sequence__Group_6__3__Impl6678); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3012:1: rule__Sequence__Group_7__0 : rule__Sequence__Group_7__0__Impl rule__Sequence__Group_7__1 ;
    public final void rule__Sequence__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3016:1: ( rule__Sequence__Group_7__0__Impl rule__Sequence__Group_7__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3017:2: rule__Sequence__Group_7__0__Impl rule__Sequence__Group_7__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_7__0__Impl_in_rule__Sequence__Group_7__06717);
            rule__Sequence__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_7__1_in_rule__Sequence__Group_7__06720);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3024:1: rule__Sequence__Group_7__0__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3028:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3029:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3029:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3030:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_7_0()); 
            match(input,168,FOLLOW_168_in_rule__Sequence__Group_7__0__Impl6748); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3043:1: rule__Sequence__Group_7__1 : rule__Sequence__Group_7__1__Impl rule__Sequence__Group_7__2 ;
    public final void rule__Sequence__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3047:1: ( rule__Sequence__Group_7__1__Impl rule__Sequence__Group_7__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3048:2: rule__Sequence__Group_7__1__Impl rule__Sequence__Group_7__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_7__1__Impl_in_rule__Sequence__Group_7__16779);
            rule__Sequence__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_7__2_in_rule__Sequence__Group_7__16782);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3055:1: rule__Sequence__Group_7__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3059:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3060:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3060:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3061:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_7_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_7__1__Impl6810); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3074:1: rule__Sequence__Group_7__2 : rule__Sequence__Group_7__2__Impl ;
    public final void rule__Sequence__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3078:1: ( rule__Sequence__Group_7__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3079:2: rule__Sequence__Group_7__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_7__2__Impl_in_rule__Sequence__Group_7__26841);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3085:1: rule__Sequence__Group_7__2__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3089:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3090:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3090:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3091:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_7_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3092:1: ( '-' )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==163) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3093:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_7__2__Impl6870); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3110:1: rule__Sequence__Group_8__0 : rule__Sequence__Group_8__0__Impl rule__Sequence__Group_8__1 ;
    public final void rule__Sequence__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3114:1: ( rule__Sequence__Group_8__0__Impl rule__Sequence__Group_8__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3115:2: rule__Sequence__Group_8__0__Impl rule__Sequence__Group_8__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_8__0__Impl_in_rule__Sequence__Group_8__06909);
            rule__Sequence__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_8__1_in_rule__Sequence__Group_8__06912);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3122:1: rule__Sequence__Group_8__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3126:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3127:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3127:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3128:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_8_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3129:1: ( '-' )*
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
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3130:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_8__0__Impl6941); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3141:1: rule__Sequence__Group_8__1 : rule__Sequence__Group_8__1__Impl rule__Sequence__Group_8__2 ;
    public final void rule__Sequence__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3145:1: ( rule__Sequence__Group_8__1__Impl rule__Sequence__Group_8__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3146:2: rule__Sequence__Group_8__1__Impl rule__Sequence__Group_8__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_8__1__Impl_in_rule__Sequence__Group_8__16974);
            rule__Sequence__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_8__2_in_rule__Sequence__Group_8__16977);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3153:1: rule__Sequence__Group_8__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3157:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3158:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3158:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3159:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_8_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_8__1__Impl7005); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3172:1: rule__Sequence__Group_8__2 : rule__Sequence__Group_8__2__Impl ;
    public final void rule__Sequence__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3176:1: ( rule__Sequence__Group_8__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3177:2: rule__Sequence__Group_8__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_8__2__Impl_in_rule__Sequence__Group_8__27036);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3183:1: rule__Sequence__Group_8__2__Impl : ( '\\\\\\\\' ) ;
    public final void rule__Sequence__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3187:1: ( ( '\\\\\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3188:1: ( '\\\\\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3188:1: ( '\\\\\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3189:1: '\\\\\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusReverseSolidusKeyword_8_2()); 
            match(input,169,FOLLOW_169_in_rule__Sequence__Group_8__2__Impl7064); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3208:1: rule__Sequence__Group_9__0 : rule__Sequence__Group_9__0__Impl rule__Sequence__Group_9__1 ;
    public final void rule__Sequence__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3212:1: ( rule__Sequence__Group_9__0__Impl rule__Sequence__Group_9__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3213:2: rule__Sequence__Group_9__0__Impl rule__Sequence__Group_9__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__0__Impl_in_rule__Sequence__Group_9__07101);
            rule__Sequence__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_9__1_in_rule__Sequence__Group_9__07104);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3220:1: rule__Sequence__Group_9__0__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3224:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3225:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3225:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3226:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_9_0()); 
            match(input,168,FOLLOW_168_in_rule__Sequence__Group_9__0__Impl7132); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3239:1: rule__Sequence__Group_9__1 : rule__Sequence__Group_9__1__Impl rule__Sequence__Group_9__2 ;
    public final void rule__Sequence__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3243:1: ( rule__Sequence__Group_9__1__Impl rule__Sequence__Group_9__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3244:2: rule__Sequence__Group_9__1__Impl rule__Sequence__Group_9__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__1__Impl_in_rule__Sequence__Group_9__17163);
            rule__Sequence__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_9__2_in_rule__Sequence__Group_9__17166);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3251:1: rule__Sequence__Group_9__1__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3255:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3256:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3256:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3257:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_9_1()); 
            match(input,168,FOLLOW_168_in_rule__Sequence__Group_9__1__Impl7194); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3270:1: rule__Sequence__Group_9__2 : rule__Sequence__Group_9__2__Impl rule__Sequence__Group_9__3 ;
    public final void rule__Sequence__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3274:1: ( rule__Sequence__Group_9__2__Impl rule__Sequence__Group_9__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3275:2: rule__Sequence__Group_9__2__Impl rule__Sequence__Group_9__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__2__Impl_in_rule__Sequence__Group_9__27225);
            rule__Sequence__Group_9__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_9__3_in_rule__Sequence__Group_9__27228);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3282:1: rule__Sequence__Group_9__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3286:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3287:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3287:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3288:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_9_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_9__2__Impl7256); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3301:1: rule__Sequence__Group_9__3 : rule__Sequence__Group_9__3__Impl ;
    public final void rule__Sequence__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3305:1: ( rule__Sequence__Group_9__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3306:2: rule__Sequence__Group_9__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_9__3__Impl_in_rule__Sequence__Group_9__37287);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3312:1: rule__Sequence__Group_9__3__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3316:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3317:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3317:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3318:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_9_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3319:1: ( '-' )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==163) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3320:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_9__3__Impl7316); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3339:1: rule__Sequence__Group_10__0 : rule__Sequence__Group_10__0__Impl rule__Sequence__Group_10__1 ;
    public final void rule__Sequence__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3343:1: ( rule__Sequence__Group_10__0__Impl rule__Sequence__Group_10__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3344:2: rule__Sequence__Group_10__0__Impl rule__Sequence__Group_10__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__0__Impl_in_rule__Sequence__Group_10__07357);
            rule__Sequence__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_10__1_in_rule__Sequence__Group_10__07360);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3351:1: rule__Sequence__Group_10__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3355:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3356:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3356:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3357:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_10_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3358:1: ( '-' )*
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
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3359:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_10__0__Impl7389); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3370:1: rule__Sequence__Group_10__1 : rule__Sequence__Group_10__1__Impl rule__Sequence__Group_10__2 ;
    public final void rule__Sequence__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3374:1: ( rule__Sequence__Group_10__1__Impl rule__Sequence__Group_10__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3375:2: rule__Sequence__Group_10__1__Impl rule__Sequence__Group_10__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__1__Impl_in_rule__Sequence__Group_10__17422);
            rule__Sequence__Group_10__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_10__2_in_rule__Sequence__Group_10__17425);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3382:1: rule__Sequence__Group_10__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3386:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3387:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3387:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3388:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_10_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_10__1__Impl7453); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3401:1: rule__Sequence__Group_10__2 : rule__Sequence__Group_10__2__Impl rule__Sequence__Group_10__3 ;
    public final void rule__Sequence__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3405:1: ( rule__Sequence__Group_10__2__Impl rule__Sequence__Group_10__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3406:2: rule__Sequence__Group_10__2__Impl rule__Sequence__Group_10__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__2__Impl_in_rule__Sequence__Group_10__27484);
            rule__Sequence__Group_10__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_10__3_in_rule__Sequence__Group_10__27487);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3413:1: rule__Sequence__Group_10__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3417:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3418:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3418:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3419:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_10_2()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_10__2__Impl7515); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3432:1: rule__Sequence__Group_10__3 : rule__Sequence__Group_10__3__Impl ;
    public final void rule__Sequence__Group_10__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3436:1: ( rule__Sequence__Group_10__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3437:2: rule__Sequence__Group_10__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_10__3__Impl_in_rule__Sequence__Group_10__37546);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3443:1: rule__Sequence__Group_10__3__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_10__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3447:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3448:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3448:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3449:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_10_3()); 
            match(input,170,FOLLOW_170_in_rule__Sequence__Group_10__3__Impl7574); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3470:1: rule__Sequence__Group_11__0 : rule__Sequence__Group_11__0__Impl rule__Sequence__Group_11__1 ;
    public final void rule__Sequence__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3474:1: ( rule__Sequence__Group_11__0__Impl rule__Sequence__Group_11__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3475:2: rule__Sequence__Group_11__0__Impl rule__Sequence__Group_11__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__0__Impl_in_rule__Sequence__Group_11__07613);
            rule__Sequence__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_11__1_in_rule__Sequence__Group_11__07616);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3482:1: rule__Sequence__Group_11__0__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3486:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3487:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3487:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3488:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_11_0()); 
            match(input,170,FOLLOW_170_in_rule__Sequence__Group_11__0__Impl7644); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3501:1: rule__Sequence__Group_11__1 : rule__Sequence__Group_11__1__Impl rule__Sequence__Group_11__2 ;
    public final void rule__Sequence__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3505:1: ( rule__Sequence__Group_11__1__Impl rule__Sequence__Group_11__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3506:2: rule__Sequence__Group_11__1__Impl rule__Sequence__Group_11__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__1__Impl_in_rule__Sequence__Group_11__17675);
            rule__Sequence__Group_11__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_11__2_in_rule__Sequence__Group_11__17678);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3513:1: rule__Sequence__Group_11__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3517:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3518:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3518:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3519:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_11_1()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_11__1__Impl7706); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3532:1: rule__Sequence__Group_11__2 : rule__Sequence__Group_11__2__Impl rule__Sequence__Group_11__3 ;
    public final void rule__Sequence__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3536:1: ( rule__Sequence__Group_11__2__Impl rule__Sequence__Group_11__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3537:2: rule__Sequence__Group_11__2__Impl rule__Sequence__Group_11__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__2__Impl_in_rule__Sequence__Group_11__27737);
            rule__Sequence__Group_11__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_11__3_in_rule__Sequence__Group_11__27740);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3544:1: rule__Sequence__Group_11__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3548:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3549:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3549:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3550:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_11_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_11__2__Impl7768); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3563:1: rule__Sequence__Group_11__3 : rule__Sequence__Group_11__3__Impl ;
    public final void rule__Sequence__Group_11__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3567:1: ( rule__Sequence__Group_11__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3568:2: rule__Sequence__Group_11__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_11__3__Impl_in_rule__Sequence__Group_11__37799);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3574:1: rule__Sequence__Group_11__3__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_11__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3578:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3579:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3579:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3580:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_11_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3581:1: ( '-' )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==163) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3582:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_11__3__Impl7828); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3601:1: rule__Sequence__Group_12__0 : rule__Sequence__Group_12__0__Impl rule__Sequence__Group_12__1 ;
    public final void rule__Sequence__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3605:1: ( rule__Sequence__Group_12__0__Impl rule__Sequence__Group_12__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3606:2: rule__Sequence__Group_12__0__Impl rule__Sequence__Group_12__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__0__Impl_in_rule__Sequence__Group_12__07869);
            rule__Sequence__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__1_in_rule__Sequence__Group_12__07872);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3613:1: rule__Sequence__Group_12__0__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3617:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3618:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3618:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3619:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3620:1: ( '-' )*
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
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3621:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_12__0__Impl7901); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3632:1: rule__Sequence__Group_12__1 : rule__Sequence__Group_12__1__Impl rule__Sequence__Group_12__2 ;
    public final void rule__Sequence__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3636:1: ( rule__Sequence__Group_12__1__Impl rule__Sequence__Group_12__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3637:2: rule__Sequence__Group_12__1__Impl rule__Sequence__Group_12__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__1__Impl_in_rule__Sequence__Group_12__17934);
            rule__Sequence__Group_12__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__2_in_rule__Sequence__Group_12__17937);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3644:1: rule__Sequence__Group_12__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3648:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3649:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3649:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3650:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_12__1__Impl7965); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3663:1: rule__Sequence__Group_12__2 : rule__Sequence__Group_12__2__Impl rule__Sequence__Group_12__3 ;
    public final void rule__Sequence__Group_12__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3667:1: ( rule__Sequence__Group_12__2__Impl rule__Sequence__Group_12__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3668:2: rule__Sequence__Group_12__2__Impl rule__Sequence__Group_12__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__2__Impl_in_rule__Sequence__Group_12__27996);
            rule__Sequence__Group_12__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__3_in_rule__Sequence__Group_12__27999);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3675:1: rule__Sequence__Group_12__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_12__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3679:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3680:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3680:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3681:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_12__2__Impl8027); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3694:1: rule__Sequence__Group_12__3 : rule__Sequence__Group_12__3__Impl rule__Sequence__Group_12__4 ;
    public final void rule__Sequence__Group_12__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3698:1: ( rule__Sequence__Group_12__3__Impl rule__Sequence__Group_12__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3699:2: rule__Sequence__Group_12__3__Impl rule__Sequence__Group_12__4
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__3__Impl_in_rule__Sequence__Group_12__38058);
            rule__Sequence__Group_12__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__4_in_rule__Sequence__Group_12__38061);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3706:1: rule__Sequence__Group_12__3__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_12__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3710:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3711:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3711:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3712:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_12_3()); 
            match(input,168,FOLLOW_168_in_rule__Sequence__Group_12__3__Impl8089); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3725:1: rule__Sequence__Group_12__4 : rule__Sequence__Group_12__4__Impl rule__Sequence__Group_12__5 ;
    public final void rule__Sequence__Group_12__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3729:1: ( rule__Sequence__Group_12__4__Impl rule__Sequence__Group_12__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3730:2: rule__Sequence__Group_12__4__Impl rule__Sequence__Group_12__5
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__4__Impl_in_rule__Sequence__Group_12__48120);
            rule__Sequence__Group_12__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_12__5_in_rule__Sequence__Group_12__48123);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3737:1: rule__Sequence__Group_12__4__Impl : ( '/' ) ;
    public final void rule__Sequence__Group_12__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3741:1: ( ( '/' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3742:1: ( '/' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3742:1: ( '/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3743:1: '/'
            {
             before(grammarAccess.getSequenceAccess().getSolidusKeyword_12_4()); 
            match(input,168,FOLLOW_168_in_rule__Sequence__Group_12__4__Impl8151); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3756:1: rule__Sequence__Group_12__5 : rule__Sequence__Group_12__5__Impl ;
    public final void rule__Sequence__Group_12__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3760:1: ( rule__Sequence__Group_12__5__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3761:2: rule__Sequence__Group_12__5__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_12__5__Impl_in_rule__Sequence__Group_12__58182);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3767:1: rule__Sequence__Group_12__5__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_12__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3771:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3772:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3772:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3773:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_12_5()); 
            match(input,170,FOLLOW_170_in_rule__Sequence__Group_12__5__Impl8210); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3798:1: rule__Sequence__Group_13__0 : rule__Sequence__Group_13__0__Impl rule__Sequence__Group_13__1 ;
    public final void rule__Sequence__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3802:1: ( rule__Sequence__Group_13__0__Impl rule__Sequence__Group_13__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3803:2: rule__Sequence__Group_13__0__Impl rule__Sequence__Group_13__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__0__Impl_in_rule__Sequence__Group_13__08253);
            rule__Sequence__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__1_in_rule__Sequence__Group_13__08256);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3810:1: rule__Sequence__Group_13__0__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3814:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3815:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3815:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3816:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_13_0()); 
            match(input,170,FOLLOW_170_in_rule__Sequence__Group_13__0__Impl8284); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3829:1: rule__Sequence__Group_13__1 : rule__Sequence__Group_13__1__Impl rule__Sequence__Group_13__2 ;
    public final void rule__Sequence__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3833:1: ( rule__Sequence__Group_13__1__Impl rule__Sequence__Group_13__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3834:2: rule__Sequence__Group_13__1__Impl rule__Sequence__Group_13__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__1__Impl_in_rule__Sequence__Group_13__18315);
            rule__Sequence__Group_13__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__2_in_rule__Sequence__Group_13__18318);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3841:1: rule__Sequence__Group_13__1__Impl : ( '\\\\\\\\' ) ;
    public final void rule__Sequence__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3845:1: ( ( '\\\\\\\\' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3846:1: ( '\\\\\\\\' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3846:1: ( '\\\\\\\\' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3847:1: '\\\\\\\\'
            {
             before(grammarAccess.getSequenceAccess().getReverseSolidusReverseSolidusKeyword_13_1()); 
            match(input,169,FOLLOW_169_in_rule__Sequence__Group_13__1__Impl8346); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3860:1: rule__Sequence__Group_13__2 : rule__Sequence__Group_13__2__Impl rule__Sequence__Group_13__3 ;
    public final void rule__Sequence__Group_13__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3864:1: ( rule__Sequence__Group_13__2__Impl rule__Sequence__Group_13__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3865:2: rule__Sequence__Group_13__2__Impl rule__Sequence__Group_13__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__2__Impl_in_rule__Sequence__Group_13__28377);
            rule__Sequence__Group_13__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__3_in_rule__Sequence__Group_13__28380);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3872:1: rule__Sequence__Group_13__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_13__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3876:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3877:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3877:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3878:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_13__2__Impl8408); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3891:1: rule__Sequence__Group_13__3 : rule__Sequence__Group_13__3__Impl rule__Sequence__Group_13__4 ;
    public final void rule__Sequence__Group_13__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3895:1: ( rule__Sequence__Group_13__3__Impl rule__Sequence__Group_13__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3896:2: rule__Sequence__Group_13__3__Impl rule__Sequence__Group_13__4
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__3__Impl_in_rule__Sequence__Group_13__38439);
            rule__Sequence__Group_13__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_13__4_in_rule__Sequence__Group_13__38442);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3903:1: rule__Sequence__Group_13__3__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_13__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3907:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3908:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3908:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3909:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_3()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_13__3__Impl8470); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3922:1: rule__Sequence__Group_13__4 : rule__Sequence__Group_13__4__Impl ;
    public final void rule__Sequence__Group_13__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3926:1: ( rule__Sequence__Group_13__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3927:2: rule__Sequence__Group_13__4__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_13__4__Impl_in_rule__Sequence__Group_13__48501);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3933:1: rule__Sequence__Group_13__4__Impl : ( ( '-' )* ) ;
    public final void rule__Sequence__Group_13__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3937:1: ( ( ( '-' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3938:1: ( ( '-' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3938:1: ( ( '-' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3939:1: ( '-' )*
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3940:1: ( '-' )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==163) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3941:2: '-'
            	    {
            	    match(input,163,FOLLOW_163_in_rule__Sequence__Group_13__4__Impl8530); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3962:1: rule__Sequence__Group_14__0 : rule__Sequence__Group_14__0__Impl rule__Sequence__Group_14__1 ;
    public final void rule__Sequence__Group_14__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3966:1: ( rule__Sequence__Group_14__0__Impl rule__Sequence__Group_14__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3967:2: rule__Sequence__Group_14__0__Impl rule__Sequence__Group_14__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_14__0__Impl_in_rule__Sequence__Group_14__08573);
            rule__Sequence__Group_14__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_14__1_in_rule__Sequence__Group_14__08576);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3974:1: rule__Sequence__Group_14__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_14__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3978:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3979:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3979:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3980:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_14_0()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_14__0__Impl8604); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3993:1: rule__Sequence__Group_14__1 : rule__Sequence__Group_14__1__Impl rule__Sequence__Group_14__2 ;
    public final void rule__Sequence__Group_14__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3997:1: ( rule__Sequence__Group_14__1__Impl rule__Sequence__Group_14__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:3998:2: rule__Sequence__Group_14__1__Impl rule__Sequence__Group_14__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_14__1__Impl_in_rule__Sequence__Group_14__18635);
            rule__Sequence__Group_14__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_14__2_in_rule__Sequence__Group_14__18638);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4005:1: rule__Sequence__Group_14__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_14__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4009:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4010:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4010:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4011:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_14_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_14__1__Impl8666); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4024:1: rule__Sequence__Group_14__2 : rule__Sequence__Group_14__2__Impl ;
    public final void rule__Sequence__Group_14__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4028:1: ( rule__Sequence__Group_14__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4029:2: rule__Sequence__Group_14__2__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_14__2__Impl_in_rule__Sequence__Group_14__28697);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4035:1: rule__Sequence__Group_14__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_14__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4039:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4040:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4040:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4041:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_14_2()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_14__2__Impl8725); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4060:1: rule__Sequence__Group_15__0 : rule__Sequence__Group_15__0__Impl rule__Sequence__Group_15__1 ;
    public final void rule__Sequence__Group_15__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4064:1: ( rule__Sequence__Group_15__0__Impl rule__Sequence__Group_15__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4065:2: rule__Sequence__Group_15__0__Impl rule__Sequence__Group_15__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__0__Impl_in_rule__Sequence__Group_15__08762);
            rule__Sequence__Group_15__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_15__1_in_rule__Sequence__Group_15__08765);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4072:1: rule__Sequence__Group_15__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_15__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4076:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4077:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4077:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4078:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_15_0()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_15__0__Impl8793); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4091:1: rule__Sequence__Group_15__1 : rule__Sequence__Group_15__1__Impl rule__Sequence__Group_15__2 ;
    public final void rule__Sequence__Group_15__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4095:1: ( rule__Sequence__Group_15__1__Impl rule__Sequence__Group_15__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4096:2: rule__Sequence__Group_15__1__Impl rule__Sequence__Group_15__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__1__Impl_in_rule__Sequence__Group_15__18824);
            rule__Sequence__Group_15__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_15__2_in_rule__Sequence__Group_15__18827);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4103:1: rule__Sequence__Group_15__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_15__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4107:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4108:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4108:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4109:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_15_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_15__1__Impl8855); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4122:1: rule__Sequence__Group_15__2 : rule__Sequence__Group_15__2__Impl rule__Sequence__Group_15__3 ;
    public final void rule__Sequence__Group_15__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4126:1: ( rule__Sequence__Group_15__2__Impl rule__Sequence__Group_15__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4127:2: rule__Sequence__Group_15__2__Impl rule__Sequence__Group_15__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__2__Impl_in_rule__Sequence__Group_15__28886);
            rule__Sequence__Group_15__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_15__3_in_rule__Sequence__Group_15__28889);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4134:1: rule__Sequence__Group_15__2__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_15__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4138:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4139:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4139:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4140:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_15_2()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_15__2__Impl8917); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4153:1: rule__Sequence__Group_15__3 : rule__Sequence__Group_15__3__Impl ;
    public final void rule__Sequence__Group_15__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4157:1: ( rule__Sequence__Group_15__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4158:2: rule__Sequence__Group_15__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_15__3__Impl_in_rule__Sequence__Group_15__38948);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4164:1: rule__Sequence__Group_15__3__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_15__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4168:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4169:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4169:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4170:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_15_3()); 
            match(input,170,FOLLOW_170_in_rule__Sequence__Group_15__3__Impl8976); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4191:1: rule__Sequence__Group_16__0 : rule__Sequence__Group_16__0__Impl rule__Sequence__Group_16__1 ;
    public final void rule__Sequence__Group_16__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4195:1: ( rule__Sequence__Group_16__0__Impl rule__Sequence__Group_16__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4196:2: rule__Sequence__Group_16__0__Impl rule__Sequence__Group_16__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__0__Impl_in_rule__Sequence__Group_16__09015);
            rule__Sequence__Group_16__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_16__1_in_rule__Sequence__Group_16__09018);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4203:1: rule__Sequence__Group_16__0__Impl : ( 'o' ) ;
    public final void rule__Sequence__Group_16__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4207:1: ( ( 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4208:1: ( 'o' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4208:1: ( 'o' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4209:1: 'o'
            {
             before(grammarAccess.getSequenceAccess().getOKeyword_16_0()); 
            match(input,170,FOLLOW_170_in_rule__Sequence__Group_16__0__Impl9046); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4222:1: rule__Sequence__Group_16__1 : rule__Sequence__Group_16__1__Impl rule__Sequence__Group_16__2 ;
    public final void rule__Sequence__Group_16__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4226:1: ( rule__Sequence__Group_16__1__Impl rule__Sequence__Group_16__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4227:2: rule__Sequence__Group_16__1__Impl rule__Sequence__Group_16__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__1__Impl_in_rule__Sequence__Group_16__19077);
            rule__Sequence__Group_16__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_16__2_in_rule__Sequence__Group_16__19080);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4234:1: rule__Sequence__Group_16__1__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_16__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4238:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4239:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4239:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4240:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_16_1()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_16__1__Impl9108); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4253:1: rule__Sequence__Group_16__2 : rule__Sequence__Group_16__2__Impl rule__Sequence__Group_16__3 ;
    public final void rule__Sequence__Group_16__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4257:1: ( rule__Sequence__Group_16__2__Impl rule__Sequence__Group_16__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4258:2: rule__Sequence__Group_16__2__Impl rule__Sequence__Group_16__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__2__Impl_in_rule__Sequence__Group_16__29139);
            rule__Sequence__Group_16__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_16__3_in_rule__Sequence__Group_16__29142);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4265:1: rule__Sequence__Group_16__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_16__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4269:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4270:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4270:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4271:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_16_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_16__2__Impl9170); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4284:1: rule__Sequence__Group_16__3 : rule__Sequence__Group_16__3__Impl ;
    public final void rule__Sequence__Group_16__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4288:1: ( rule__Sequence__Group_16__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4289:2: rule__Sequence__Group_16__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_16__3__Impl_in_rule__Sequence__Group_16__39201);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4295:1: rule__Sequence__Group_16__3__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_16__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4299:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4300:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4300:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4301:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_16_3()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_16__3__Impl9229); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4322:1: rule__Sequence__Group_17__0 : rule__Sequence__Group_17__0__Impl rule__Sequence__Group_17__1 ;
    public final void rule__Sequence__Group_17__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4326:1: ( rule__Sequence__Group_17__0__Impl rule__Sequence__Group_17__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4327:2: rule__Sequence__Group_17__0__Impl rule__Sequence__Group_17__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__0__Impl_in_rule__Sequence__Group_17__09268);
            rule__Sequence__Group_17__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_17__1_in_rule__Sequence__Group_17__09271);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4334:1: rule__Sequence__Group_17__0__Impl : ( '<' ) ;
    public final void rule__Sequence__Group_17__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4338:1: ( ( '<' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4339:1: ( '<' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4339:1: ( '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4340:1: '<'
            {
             before(grammarAccess.getSequenceAccess().getLessThanSignKeyword_17_0()); 
            match(input,165,FOLLOW_165_in_rule__Sequence__Group_17__0__Impl9299); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4353:1: rule__Sequence__Group_17__1 : rule__Sequence__Group_17__1__Impl rule__Sequence__Group_17__2 ;
    public final void rule__Sequence__Group_17__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4357:1: ( rule__Sequence__Group_17__1__Impl rule__Sequence__Group_17__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4358:2: rule__Sequence__Group_17__1__Impl rule__Sequence__Group_17__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__1__Impl_in_rule__Sequence__Group_17__19330);
            rule__Sequence__Group_17__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_17__2_in_rule__Sequence__Group_17__19333);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4365:1: rule__Sequence__Group_17__1__Impl : ( '|' ) ;
    public final void rule__Sequence__Group_17__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4369:1: ( ( '|' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4370:1: ( '|' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4370:1: ( '|' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4371:1: '|'
            {
             before(grammarAccess.getSequenceAccess().getVerticalLineKeyword_17_1()); 
            match(input,171,FOLLOW_171_in_rule__Sequence__Group_17__1__Impl9361); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4384:1: rule__Sequence__Group_17__2 : rule__Sequence__Group_17__2__Impl rule__Sequence__Group_17__3 ;
    public final void rule__Sequence__Group_17__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4388:1: ( rule__Sequence__Group_17__2__Impl rule__Sequence__Group_17__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4389:2: rule__Sequence__Group_17__2__Impl rule__Sequence__Group_17__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__2__Impl_in_rule__Sequence__Group_17__29392);
            rule__Sequence__Group_17__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_17__3_in_rule__Sequence__Group_17__29395);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4396:1: rule__Sequence__Group_17__2__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_17__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4400:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4401:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4401:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4402:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_17_2()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_17__2__Impl9423); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4415:1: rule__Sequence__Group_17__3 : rule__Sequence__Group_17__3__Impl ;
    public final void rule__Sequence__Group_17__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4419:1: ( rule__Sequence__Group_17__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4420:2: rule__Sequence__Group_17__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_17__3__Impl_in_rule__Sequence__Group_17__39454);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4426:1: rule__Sequence__Group_17__3__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_17__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4430:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4431:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4431:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4432:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_17_3()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_17__3__Impl9482); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4453:1: rule__Sequence__Group_18__0 : rule__Sequence__Group_18__0__Impl rule__Sequence__Group_18__1 ;
    public final void rule__Sequence__Group_18__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4457:1: ( rule__Sequence__Group_18__0__Impl rule__Sequence__Group_18__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4458:2: rule__Sequence__Group_18__0__Impl rule__Sequence__Group_18__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__0__Impl_in_rule__Sequence__Group_18__09521);
            rule__Sequence__Group_18__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_18__1_in_rule__Sequence__Group_18__09524);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4465:1: rule__Sequence__Group_18__0__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_18__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4469:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4470:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4470:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4471:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_18_0()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_18__0__Impl9552); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4484:1: rule__Sequence__Group_18__1 : rule__Sequence__Group_18__1__Impl rule__Sequence__Group_18__2 ;
    public final void rule__Sequence__Group_18__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4488:1: ( rule__Sequence__Group_18__1__Impl rule__Sequence__Group_18__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4489:2: rule__Sequence__Group_18__1__Impl rule__Sequence__Group_18__2
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__1__Impl_in_rule__Sequence__Group_18__19583);
            rule__Sequence__Group_18__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_18__2_in_rule__Sequence__Group_18__19586);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4496:1: rule__Sequence__Group_18__1__Impl : ( '-' ) ;
    public final void rule__Sequence__Group_18__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4500:1: ( ( '-' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4501:1: ( '-' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4501:1: ( '-' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4502:1: '-'
            {
             before(grammarAccess.getSequenceAccess().getHyphenMinusKeyword_18_1()); 
            match(input,163,FOLLOW_163_in_rule__Sequence__Group_18__1__Impl9614); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4515:1: rule__Sequence__Group_18__2 : rule__Sequence__Group_18__2__Impl rule__Sequence__Group_18__3 ;
    public final void rule__Sequence__Group_18__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4519:1: ( rule__Sequence__Group_18__2__Impl rule__Sequence__Group_18__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4520:2: rule__Sequence__Group_18__2__Impl rule__Sequence__Group_18__3
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__2__Impl_in_rule__Sequence__Group_18__29645);
            rule__Sequence__Group_18__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_18__3_in_rule__Sequence__Group_18__29648);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4527:1: rule__Sequence__Group_18__2__Impl : ( '|' ) ;
    public final void rule__Sequence__Group_18__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4531:1: ( ( '|' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4532:1: ( '|' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4532:1: ( '|' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4533:1: '|'
            {
             before(grammarAccess.getSequenceAccess().getVerticalLineKeyword_18_2()); 
            match(input,171,FOLLOW_171_in_rule__Sequence__Group_18__2__Impl9676); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4546:1: rule__Sequence__Group_18__3 : rule__Sequence__Group_18__3__Impl ;
    public final void rule__Sequence__Group_18__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4550:1: ( rule__Sequence__Group_18__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4551:2: rule__Sequence__Group_18__3__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_18__3__Impl_in_rule__Sequence__Group_18__39707);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4557:1: rule__Sequence__Group_18__3__Impl : ( '>' ) ;
    public final void rule__Sequence__Group_18__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4561:1: ( ( '>' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4562:1: ( '>' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4562:1: ( '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4563:1: '>'
            {
             before(grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_18_3()); 
            match(input,164,FOLLOW_164_in_rule__Sequence__Group_18__3__Impl9735); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4584:1: rule__Sequence__Group_19__0 : rule__Sequence__Group_19__0__Impl rule__Sequence__Group_19__1 ;
    public final void rule__Sequence__Group_19__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4588:1: ( rule__Sequence__Group_19__0__Impl rule__Sequence__Group_19__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4589:2: rule__Sequence__Group_19__0__Impl rule__Sequence__Group_19__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_19__0__Impl_in_rule__Sequence__Group_19__09774);
            rule__Sequence__Group_19__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_19__1_in_rule__Sequence__Group_19__09777);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4596:1: rule__Sequence__Group_19__0__Impl : ( '.' ) ;
    public final void rule__Sequence__Group_19__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4600:1: ( ( '.' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4601:1: ( '.' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4601:1: ( '.' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4602:1: '.'
            {
             before(grammarAccess.getSequenceAccess().getFullStopKeyword_19_0()); 
            match(input,11,FOLLOW_11_in_rule__Sequence__Group_19__0__Impl9805); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4615:1: rule__Sequence__Group_19__1 : rule__Sequence__Group_19__1__Impl ;
    public final void rule__Sequence__Group_19__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4619:1: ( rule__Sequence__Group_19__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4620:2: rule__Sequence__Group_19__1__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_19__1__Impl_in_rule__Sequence__Group_19__19836);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4626:1: rule__Sequence__Group_19__1__Impl : ( '.' ) ;
    public final void rule__Sequence__Group_19__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4630:1: ( ( '.' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4631:1: ( '.' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4631:1: ( '.' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4632:1: '.'
            {
             before(grammarAccess.getSequenceAccess().getFullStopKeyword_19_1()); 
            match(input,11,FOLLOW_11_in_rule__Sequence__Group_19__1__Impl9864); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4649:1: rule__Definition__Group_0__0 : rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 ;
    public final void rule__Definition__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4653:1: ( rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4654:2: rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__09899);
            rule__Definition__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__09902);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4661:1: rule__Definition__Group_0__0__Impl : ( 'actor' ) ;
    public final void rule__Definition__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4665:1: ( ( 'actor' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4666:1: ( 'actor' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4666:1: ( 'actor' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4667:1: 'actor'
            {
             before(grammarAccess.getDefinitionAccess().getActorKeyword_0_0()); 
            match(input,172,FOLLOW_172_in_rule__Definition__Group_0__0__Impl9930); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4680:1: rule__Definition__Group_0__1 : rule__Definition__Group_0__1__Impl ;
    public final void rule__Definition__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4684:1: ( rule__Definition__Group_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4685:2: rule__Definition__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__19961);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4691:1: rule__Definition__Group_0__1__Impl : ( ( rule__Definition__NameAssignment_0_1 ) ) ;
    public final void rule__Definition__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4695:1: ( ( ( rule__Definition__NameAssignment_0_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4696:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4696:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4697:1: ( rule__Definition__NameAssignment_0_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4698:1: ( rule__Definition__NameAssignment_0_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4698:2: rule__Definition__NameAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl9988);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4712:1: rule__Definition__Group_1__0 : rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 ;
    public final void rule__Definition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4716:1: ( rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4717:2: rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__010022);
            rule__Definition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__010025);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4724:1: rule__Definition__Group_1__0__Impl : ( 'boundary' ) ;
    public final void rule__Definition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4728:1: ( ( 'boundary' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4729:1: ( 'boundary' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4729:1: ( 'boundary' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4730:1: 'boundary'
            {
             before(grammarAccess.getDefinitionAccess().getBoundaryKeyword_1_0()); 
            match(input,173,FOLLOW_173_in_rule__Definition__Group_1__0__Impl10053); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4743:1: rule__Definition__Group_1__1 : rule__Definition__Group_1__1__Impl ;
    public final void rule__Definition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4747:1: ( rule__Definition__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4748:2: rule__Definition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__110084);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4754:1: rule__Definition__Group_1__1__Impl : ( ( rule__Definition__NameAssignment_1_1 ) ) ;
    public final void rule__Definition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4758:1: ( ( ( rule__Definition__NameAssignment_1_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4759:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4759:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4760:1: ( rule__Definition__NameAssignment_1_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4761:1: ( rule__Definition__NameAssignment_1_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4761:2: rule__Definition__NameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl10111);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4775:1: rule__Definition__Group_2__0 : rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 ;
    public final void rule__Definition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4779:1: ( rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4780:2: rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__010145);
            rule__Definition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__010148);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4787:1: rule__Definition__Group_2__0__Impl : ( 'control' ) ;
    public final void rule__Definition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4791:1: ( ( 'control' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4792:1: ( 'control' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4792:1: ( 'control' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4793:1: 'control'
            {
             before(grammarAccess.getDefinitionAccess().getControlKeyword_2_0()); 
            match(input,174,FOLLOW_174_in_rule__Definition__Group_2__0__Impl10176); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4806:1: rule__Definition__Group_2__1 : rule__Definition__Group_2__1__Impl ;
    public final void rule__Definition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4810:1: ( rule__Definition__Group_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4811:2: rule__Definition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__110207);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4817:1: rule__Definition__Group_2__1__Impl : ( ( rule__Definition__NameAssignment_2_1 ) ) ;
    public final void rule__Definition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4821:1: ( ( ( rule__Definition__NameAssignment_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4822:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4822:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4823:1: ( rule__Definition__NameAssignment_2_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4824:1: ( rule__Definition__NameAssignment_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4824:2: rule__Definition__NameAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl10234);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4838:1: rule__Definition__Group_3__0 : rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 ;
    public final void rule__Definition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4842:1: ( rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4843:2: rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__010268);
            rule__Definition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__010271);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4850:1: rule__Definition__Group_3__0__Impl : ( 'entity' ) ;
    public final void rule__Definition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4854:1: ( ( 'entity' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4855:1: ( 'entity' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4855:1: ( 'entity' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4856:1: 'entity'
            {
             before(grammarAccess.getDefinitionAccess().getEntityKeyword_3_0()); 
            match(input,175,FOLLOW_175_in_rule__Definition__Group_3__0__Impl10299); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4869:1: rule__Definition__Group_3__1 : rule__Definition__Group_3__1__Impl ;
    public final void rule__Definition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4873:1: ( rule__Definition__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4874:2: rule__Definition__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__110330);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4880:1: rule__Definition__Group_3__1__Impl : ( ( rule__Definition__NameAssignment_3_1 ) ) ;
    public final void rule__Definition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4884:1: ( ( ( rule__Definition__NameAssignment_3_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4885:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4885:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4886:1: ( rule__Definition__NameAssignment_3_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4887:1: ( rule__Definition__NameAssignment_3_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4887:2: rule__Definition__NameAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl10357);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4901:1: rule__Definition__Group_4__0 : rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 ;
    public final void rule__Definition__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4905:1: ( rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4906:2: rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__010391);
            rule__Definition__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__010394);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4913:1: rule__Definition__Group_4__0__Impl : ( 'database' ) ;
    public final void rule__Definition__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4917:1: ( ( 'database' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4918:1: ( 'database' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4918:1: ( 'database' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4919:1: 'database'
            {
             before(grammarAccess.getDefinitionAccess().getDatabaseKeyword_4_0()); 
            match(input,176,FOLLOW_176_in_rule__Definition__Group_4__0__Impl10422); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4932:1: rule__Definition__Group_4__1 : rule__Definition__Group_4__1__Impl ;
    public final void rule__Definition__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4936:1: ( rule__Definition__Group_4__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4937:2: rule__Definition__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__110453);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4943:1: rule__Definition__Group_4__1__Impl : ( ( rule__Definition__NameAssignment_4_1 ) ) ;
    public final void rule__Definition__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4947:1: ( ( ( rule__Definition__NameAssignment_4_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4948:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4948:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4949:1: ( rule__Definition__NameAssignment_4_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_4_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4950:1: ( rule__Definition__NameAssignment_4_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4950:2: rule__Definition__NameAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl10480);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4964:1: rule__AutoNumber__Group__0 : rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1 ;
    public final void rule__AutoNumber__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4968:1: ( rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4969:2: rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__0__Impl_in_rule__AutoNumber__Group__010514);
            rule__AutoNumber__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AutoNumber__Group__1_in_rule__AutoNumber__Group__010517);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4976:1: rule__AutoNumber__Group__0__Impl : ( 'autonumber' ) ;
    public final void rule__AutoNumber__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4980:1: ( ( 'autonumber' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4981:1: ( 'autonumber' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4981:1: ( 'autonumber' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4982:1: 'autonumber'
            {
             before(grammarAccess.getAutoNumberAccess().getAutonumberKeyword_0()); 
            match(input,177,FOLLOW_177_in_rule__AutoNumber__Group__0__Impl10545); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4995:1: rule__AutoNumber__Group__1 : rule__AutoNumber__Group__1__Impl ;
    public final void rule__AutoNumber__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:4999:1: ( rule__AutoNumber__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5000:2: rule__AutoNumber__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__1__Impl_in_rule__AutoNumber__Group__110576);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5006:1: rule__AutoNumber__Group__1__Impl : ( ( rule__AutoNumber__Group_1__0 )? ) ;
    public final void rule__AutoNumber__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5010:1: ( ( ( rule__AutoNumber__Group_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5011:1: ( ( rule__AutoNumber__Group_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5011:1: ( ( rule__AutoNumber__Group_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5012:1: ( rule__AutoNumber__Group_1__0 )?
            {
             before(grammarAccess.getAutoNumberAccess().getGroup_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5013:1: ( rule__AutoNumber__Group_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_INT) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5013:2: rule__AutoNumber__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__AutoNumber__Group_1__0_in_rule__AutoNumber__Group__1__Impl10603);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5027:1: rule__AutoNumber__Group_1__0 : rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1 ;
    public final void rule__AutoNumber__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5031:1: ( rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5032:2: rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group_1__0__Impl_in_rule__AutoNumber__Group_1__010638);
            rule__AutoNumber__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AutoNumber__Group_1__1_in_rule__AutoNumber__Group_1__010641);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5039:1: rule__AutoNumber__Group_1__0__Impl : ( RULE_INT ) ;
    public final void rule__AutoNumber__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5043:1: ( ( RULE_INT ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5044:1: ( RULE_INT )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5044:1: ( RULE_INT )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5045:1: RULE_INT
            {
             before(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__0__Impl10668); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5056:1: rule__AutoNumber__Group_1__1 : rule__AutoNumber__Group_1__1__Impl ;
    public final void rule__AutoNumber__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5060:1: ( rule__AutoNumber__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5061:2: rule__AutoNumber__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group_1__1__Impl_in_rule__AutoNumber__Group_1__110697);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5067:1: rule__AutoNumber__Group_1__1__Impl : ( ( RULE_INT )? ) ;
    public final void rule__AutoNumber__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5071:1: ( ( ( RULE_INT )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5072:1: ( ( RULE_INT )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5072:1: ( ( RULE_INT )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5073:1: ( RULE_INT )?
            {
             before(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5074:1: ( RULE_INT )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_INT) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5074:3: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__1__Impl10725); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5088:1: rule__Color__Group__0 : rule__Color__Group__0__Impl rule__Color__Group__1 ;
    public final void rule__Color__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5092:1: ( rule__Color__Group__0__Impl rule__Color__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5093:2: rule__Color__Group__0__Impl rule__Color__Group__1
            {
            pushFollow(FOLLOW_rule__Color__Group__0__Impl_in_rule__Color__Group__010760);
            rule__Color__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Color__Group__1_in_rule__Color__Group__010763);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5100:1: rule__Color__Group__0__Impl : ( ( ( '#' ) ) ( ( '#' )* ) ) ;
    public final void rule__Color__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5104:1: ( ( ( ( '#' ) ) ( ( '#' )* ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5105:1: ( ( ( '#' ) ) ( ( '#' )* ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5105:1: ( ( ( '#' ) ) ( ( '#' )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5106:1: ( ( '#' ) ) ( ( '#' )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5106:1: ( ( '#' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5107:1: ( '#' )
            {
             before(grammarAccess.getColorAccess().getNumberSignKeyword_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5108:1: ( '#' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5109:2: '#'
            {
            match(input,178,FOLLOW_178_in_rule__Color__Group__0__Impl10794); 

            }

             after(grammarAccess.getColorAccess().getNumberSignKeyword_0()); 

            }

            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5113:1: ( ( '#' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5114:1: ( '#' )*
            {
             before(grammarAccess.getColorAccess().getNumberSignKeyword_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5115:1: ( '#' )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==178) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5116:2: '#'
            	    {
            	    match(input,178,FOLLOW_178_in_rule__Color__Group__0__Impl10810); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5128:1: rule__Color__Group__1 : rule__Color__Group__1__Impl ;
    public final void rule__Color__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5132:1: ( rule__Color__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5133:2: rule__Color__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Color__Group__1__Impl_in_rule__Color__Group__110845);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5139:1: rule__Color__Group__1__Impl : ( ( rule__Color__Alternatives_1 ) ) ;
    public final void rule__Color__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5143:1: ( ( ( rule__Color__Alternatives_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5144:1: ( ( rule__Color__Alternatives_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5144:1: ( ( rule__Color__Alternatives_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5145:1: ( rule__Color__Alternatives_1 )
            {
             before(grammarAccess.getColorAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5146:1: ( rule__Color__Alternatives_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5146:2: rule__Color__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Color__Alternatives_1_in_rule__Color__Group__1__Impl10872);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5160:1: rule__Title__Group__0 : rule__Title__Group__0__Impl rule__Title__Group__1 ;
    public final void rule__Title__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5164:1: ( rule__Title__Group__0__Impl rule__Title__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5165:2: rule__Title__Group__0__Impl rule__Title__Group__1
            {
            pushFollow(FOLLOW_rule__Title__Group__0__Impl_in_rule__Title__Group__010906);
            rule__Title__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Title__Group__1_in_rule__Title__Group__010909);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5172:1: rule__Title__Group__0__Impl : ( 'title' ) ;
    public final void rule__Title__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5176:1: ( ( 'title' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5177:1: ( 'title' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5177:1: ( 'title' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5178:1: 'title'
            {
             before(grammarAccess.getTitleAccess().getTitleKeyword_0()); 
            match(input,179,FOLLOW_179_in_rule__Title__Group__0__Impl10937); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5191:1: rule__Title__Group__1 : rule__Title__Group__1__Impl ;
    public final void rule__Title__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5195:1: ( rule__Title__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5196:2: rule__Title__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Title__Group__1__Impl_in_rule__Title__Group__110968);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5202:1: rule__Title__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__Title__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5206:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5207:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5207:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5208:1: RULE_ID
            {
             before(grammarAccess.getTitleAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Title__Group__1__Impl10995); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5223:1: rule__Legend__Group__0 : rule__Legend__Group__0__Impl rule__Legend__Group__1 ;
    public final void rule__Legend__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5227:1: ( rule__Legend__Group__0__Impl rule__Legend__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5228:2: rule__Legend__Group__0__Impl rule__Legend__Group__1
            {
            pushFollow(FOLLOW_rule__Legend__Group__0__Impl_in_rule__Legend__Group__011028);
            rule__Legend__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__1_in_rule__Legend__Group__011031);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5235:1: rule__Legend__Group__0__Impl : ( 'legend' ) ;
    public final void rule__Legend__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5239:1: ( ( 'legend' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5240:1: ( 'legend' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5240:1: ( 'legend' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5241:1: 'legend'
            {
             before(grammarAccess.getLegendAccess().getLegendKeyword_0()); 
            match(input,180,FOLLOW_180_in_rule__Legend__Group__0__Impl11059); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5254:1: rule__Legend__Group__1 : rule__Legend__Group__1__Impl rule__Legend__Group__2 ;
    public final void rule__Legend__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5258:1: ( rule__Legend__Group__1__Impl rule__Legend__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5259:2: rule__Legend__Group__1__Impl rule__Legend__Group__2
            {
            pushFollow(FOLLOW_rule__Legend__Group__1__Impl_in_rule__Legend__Group__111090);
            rule__Legend__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__2_in_rule__Legend__Group__111093);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5266:1: rule__Legend__Group__1__Impl : ( ( rule__Legend__Alternatives_1 )? ) ;
    public final void rule__Legend__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5270:1: ( ( ( rule__Legend__Alternatives_1 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5271:1: ( ( rule__Legend__Alternatives_1 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5271:1: ( ( rule__Legend__Alternatives_1 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5272:1: ( rule__Legend__Alternatives_1 )?
            {
             before(grammarAccess.getLegendAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5273:1: ( rule__Legend__Alternatives_1 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=157 && LA27_0<=159)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5273:2: rule__Legend__Alternatives_1
                    {
                    pushFollow(FOLLOW_rule__Legend__Alternatives_1_in_rule__Legend__Group__1__Impl11120);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5283:1: rule__Legend__Group__2 : rule__Legend__Group__2__Impl rule__Legend__Group__3 ;
    public final void rule__Legend__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5287:1: ( rule__Legend__Group__2__Impl rule__Legend__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5288:2: rule__Legend__Group__2__Impl rule__Legend__Group__3
            {
            pushFollow(FOLLOW_rule__Legend__Group__2__Impl_in_rule__Legend__Group__211151);
            rule__Legend__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__3_in_rule__Legend__Group__211154);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5295:1: rule__Legend__Group__2__Impl : ( ( rule__Legend__Alternatives_2 )* ) ;
    public final void rule__Legend__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5299:1: ( ( ( rule__Legend__Alternatives_2 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5300:1: ( ( rule__Legend__Alternatives_2 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5300:1: ( ( rule__Legend__Alternatives_2 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5301:1: ( rule__Legend__Alternatives_2 )*
            {
             before(grammarAccess.getLegendAccess().getAlternatives_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5302:1: ( rule__Legend__Alternatives_2 )*
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
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5302:2: rule__Legend__Alternatives_2
            	    {
            	    pushFollow(FOLLOW_rule__Legend__Alternatives_2_in_rule__Legend__Group__2__Impl11181);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5312:1: rule__Legend__Group__3 : rule__Legend__Group__3__Impl rule__Legend__Group__4 ;
    public final void rule__Legend__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5316:1: ( rule__Legend__Group__3__Impl rule__Legend__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5317:2: rule__Legend__Group__3__Impl rule__Legend__Group__4
            {
            pushFollow(FOLLOW_rule__Legend__Group__3__Impl_in_rule__Legend__Group__311212);
            rule__Legend__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__4_in_rule__Legend__Group__311215);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5324:1: rule__Legend__Group__3__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Legend__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5328:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5329:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5329:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5330:1: RULE_NEWLINE
            {
             before(grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_3()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Legend__Group__3__Impl11242); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5341:1: rule__Legend__Group__4 : rule__Legend__Group__4__Impl ;
    public final void rule__Legend__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5345:1: ( rule__Legend__Group__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5346:2: rule__Legend__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Legend__Group__4__Impl_in_rule__Legend__Group__411271);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5352:1: rule__Legend__Group__4__Impl : ( 'endlegend' ) ;
    public final void rule__Legend__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5356:1: ( ( 'endlegend' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5357:1: ( 'endlegend' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5357:1: ( 'endlegend' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5358:1: 'endlegend'
            {
             before(grammarAccess.getLegendAccess().getEndlegendKeyword_4()); 
            match(input,181,FOLLOW_181_in_rule__Legend__Group__4__Impl11299); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5381:1: rule__Legend__Group_2_0__0 : rule__Legend__Group_2_0__0__Impl rule__Legend__Group_2_0__1 ;
    public final void rule__Legend__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5385:1: ( rule__Legend__Group_2_0__0__Impl rule__Legend__Group_2_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5386:2: rule__Legend__Group_2_0__0__Impl rule__Legend__Group_2_0__1
            {
            pushFollow(FOLLOW_rule__Legend__Group_2_0__0__Impl_in_rule__Legend__Group_2_0__011340);
            rule__Legend__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group_2_0__1_in_rule__Legend__Group_2_0__011343);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5393:1: rule__Legend__Group_2_0__0__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Legend__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5397:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5398:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5398:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5399:1: RULE_NEWLINE
            {
             before(grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_0_0()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Legend__Group_2_0__0__Impl11370); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5410:1: rule__Legend__Group_2_0__1 : rule__Legend__Group_2_0__1__Impl ;
    public final void rule__Legend__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5414:1: ( rule__Legend__Group_2_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5415:2: rule__Legend__Group_2_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Legend__Group_2_0__1__Impl_in_rule__Legend__Group_2_0__111399);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5421:1: rule__Legend__Group_2_0__1__Impl : ( RULE_ID ) ;
    public final void rule__Legend__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5425:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5426:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5426:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5427:1: RULE_ID
            {
             before(grammarAccess.getLegendAccess().getIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Legend__Group_2_0__1__Impl11426); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5442:1: rule__Newpage__Group__0 : rule__Newpage__Group__0__Impl rule__Newpage__Group__1 ;
    public final void rule__Newpage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5446:1: ( rule__Newpage__Group__0__Impl rule__Newpage__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5447:2: rule__Newpage__Group__0__Impl rule__Newpage__Group__1
            {
            pushFollow(FOLLOW_rule__Newpage__Group__0__Impl_in_rule__Newpage__Group__011459);
            rule__Newpage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Newpage__Group__1_in_rule__Newpage__Group__011462);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5454:1: rule__Newpage__Group__0__Impl : ( 'newpage' ) ;
    public final void rule__Newpage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5458:1: ( ( 'newpage' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5459:1: ( 'newpage' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5459:1: ( 'newpage' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5460:1: 'newpage'
            {
             before(grammarAccess.getNewpageAccess().getNewpageKeyword_0()); 
            match(input,182,FOLLOW_182_in_rule__Newpage__Group__0__Impl11490); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5473:1: rule__Newpage__Group__1 : rule__Newpage__Group__1__Impl ;
    public final void rule__Newpage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5477:1: ( rule__Newpage__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5478:2: rule__Newpage__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Newpage__Group__1__Impl_in_rule__Newpage__Group__111521);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5484:1: rule__Newpage__Group__1__Impl : ( ( RULE_ID )? ) ;
    public final void rule__Newpage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5488:1: ( ( ( RULE_ID )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5489:1: ( ( RULE_ID )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5489:1: ( ( RULE_ID )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5490:1: ( RULE_ID )?
            {
             before(grammarAccess.getNewpageAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5491:1: ( RULE_ID )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5491:3: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Newpage__Group__1__Impl11549); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5506:1: rule__Model__DiagramsAssignment : ( ruleDiagram ) ;
    public final void rule__Model__DiagramsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5510:1: ( ( ruleDiagram ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5511:1: ( ruleDiagram )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5511:1: ( ruleDiagram )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5512:1: ruleDiagram
            {
             before(grammarAccess.getModelAccess().getDiagramsDiagramParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDiagram_in_rule__Model__DiagramsAssignment11589);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5521:1: rule__Diagram__InstructionsAssignment_2 : ( ruleInstruction ) ;
    public final void rule__Diagram__InstructionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5525:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5526:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5526:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5527:1: ruleInstruction
            {
             before(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_211620);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5536:1: rule__Instruction__Name1Assignment_0_0_0 : ( RULE_ID ) ;
    public final void rule__Instruction__Name1Assignment_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5540:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5541:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5541:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5542:1: RULE_ID
            {
             before(grammarAccess.getInstructionAccess().getName1IDTerminalRuleCall_0_0_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Instruction__Name1Assignment_0_0_011651); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5551:1: rule__Instruction__Name2Assignment_0_0_2 : ( RULE_ID ) ;
    public final void rule__Instruction__Name2Assignment_0_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5555:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5556:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5556:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5557:1: RULE_ID
            {
             before(grammarAccess.getInstructionAccess().getName2IDTerminalRuleCall_0_0_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Instruction__Name2Assignment_0_0_211682); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5566:1: rule__Definition__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5570:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5571:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5571:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5572:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_0_111713); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5581:1: rule__Definition__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5585:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5586:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5586:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5587:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_1_111744); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5596:1: rule__Definition__NameAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5600:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5601:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5601:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5602:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_2_111775); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5611:1: rule__Definition__NameAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5615:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5616:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5616:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5617:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_3_111806); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5626:1: rule__Definition__NameAssignment_4_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5630:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5631:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5631:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantuml.g:5632:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_4_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_4_111837); 
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
        "\6\uffff\1\23\2\uffff\1\32\3\uffff\1\34\10\uffff\1\32\6\uffff\1"+
        "\40\1\42\4\uffff";
    static final String DFA3_minS =
        "\1\13\2\u00a3\1\uffff\1\u00a3\1\u00a5\1\5\1\u00a3\1\uffff\1\5\3"+
        "\uffff\1\5\2\uffff\1\u00a3\3\uffff\1\u00a3\1\uffff\1\5\6\uffff\2"+
        "\5\4\uffff";
    static final String DFA3_maxS =
        "\1\u00aa\1\u00a9\1\u00ab\1\uffff\1\u00a8\1\u00a9\1\13\1\u00ab\1"+
        "\uffff\1\u00aa\3\uffff\1\u00a4\2\uffff\1\u00a3\3\uffff\1\u00a9\1"+
        "\uffff\1\u00aa\6\uffff\1\u00aa\1\u00a4\4\uffff";
    static final String DFA3_acceptS =
        "\3\uffff\1\4\4\uffff\1\11\1\uffff\1\7\1\6\1\22\1\uffff\1\12\1\10"+
        "\1\uffff\1\16\1\24\1\25\1\uffff\1\15\1\uffff\1\23\1\5\1\3\1\1\1"+
        "\13\1\2\2\uffff\1\20\1\17\1\21\1\14";
    static final String DFA3_specialS =
        "\43\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\6\u0097\uffff\1\1\1\uffff\1\2\1\3\1\uffff\1\4\1\uffff\1"+
            "\5",
            "\1\7\1\11\2\uffff\1\12\1\uffff\1\10",
            "\1\15\1\uffff\1\13\5\uffff\1\14",
            "",
            "\1\17\4\uffff\1\16",
            "\1\20\3\uffff\1\21",
            "\1\23\5\uffff\1\22",
            "\1\24\1\26\2\uffff\1\12\1\25\1\10\1\uffff\1\27",
            "",
            "\1\32\u009e\uffff\1\30\1\uffff\1\31\3\uffff\1\33",
            "",
            "",
            "",
            "\1\34\u009d\uffff\1\34\1\35",
            "",
            "",
            "\1\36",
            "",
            "",
            "",
            "\1\24\1\26\2\uffff\1\12\1\25\1\10",
            "",
            "\1\32\u009e\uffff\1\30\5\uffff\1\33",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\40\u00a4\uffff\1\37",
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
            return "386:1: rule__Sequence__Alternatives : ( ( ( rule__Sequence__Group_0__0 ) ) | ( ( rule__Sequence__Group_1__0 ) ) | ( ( rule__Sequence__Group_2__0 ) ) | ( ( rule__Sequence__Group_3__0 ) ) | ( ( rule__Sequence__Group_4__0 ) ) | ( ( rule__Sequence__Group_5__0 ) ) | ( ( rule__Sequence__Group_6__0 ) ) | ( ( rule__Sequence__Group_7__0 ) ) | ( ( rule__Sequence__Group_8__0 ) ) | ( ( rule__Sequence__Group_9__0 ) ) | ( ( rule__Sequence__Group_10__0 ) ) | ( ( rule__Sequence__Group_11__0 ) ) | ( ( rule__Sequence__Group_12__0 ) ) | ( ( rule__Sequence__Group_13__0 ) ) | ( ( rule__Sequence__Group_14__0 ) ) | ( ( rule__Sequence__Group_15__0 ) ) | ( ( rule__Sequence__Group_16__0 ) ) | ( ( rule__Sequence__Group_17__0 ) ) | ( ( rule__Sequence__Group_18__0 ) ) | ( ( rule__Sequence__Group_19__0 ) ) | ( '.' ) );";
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
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__0_in_rule__Instruction__Alternatives_0671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__0_in_rule__Instruction__Alternatives_0689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_rule__Instruction__Alternatives_0707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_rule__Instruction__Alternatives_0724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLegend_in_rule__Instruction__Alternatives_0741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_rule__Instruction__Alternatives_0758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__0_in_rule__Sequence__Alternatives790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__0_in_rule__Sequence__Alternatives808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__0_in_rule__Sequence__Alternatives826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__0_in_rule__Sequence__Alternatives844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__0_in_rule__Sequence__Alternatives862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__0_in_rule__Sequence__Alternatives880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__0_in_rule__Sequence__Alternatives898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__0_in_rule__Sequence__Alternatives916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__0_in_rule__Sequence__Alternatives934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__0_in_rule__Sequence__Alternatives952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__0_in_rule__Sequence__Alternatives970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__0_in_rule__Sequence__Alternatives988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__0_in_rule__Sequence__Alternatives1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__0_in_rule__Sequence__Alternatives1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__0_in_rule__Sequence__Alternatives1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__0_in_rule__Sequence__Alternatives1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__0_in_rule__Sequence__Alternatives1078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__0_in_rule__Sequence__Alternatives1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__0_in_rule__Sequence__Alternatives1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__0_in_rule__Sequence__Alternatives1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Sequence__Alternatives1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives1185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives1203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives1221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives1239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives1257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Color__Alternatives_11291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Color__Alternatives_11311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Color__Alternatives_11331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Color__Alternatives_11351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Color__Alternatives_11371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Color__Alternatives_11391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Color__Alternatives_11411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Color__Alternatives_11431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Color__Alternatives_11451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Color__Alternatives_11471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Color__Alternatives_11491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Color__Alternatives_11511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Color__Alternatives_11531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Color__Alternatives_11551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Color__Alternatives_11571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Color__Alternatives_11591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Color__Alternatives_11611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Color__Alternatives_11631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Color__Alternatives_11651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Color__Alternatives_11671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Color__Alternatives_11691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Color__Alternatives_11711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Color__Alternatives_11731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Color__Alternatives_11751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Color__Alternatives_11771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Color__Alternatives_11791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Color__Alternatives_11811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Color__Alternatives_11831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__Color__Alternatives_11851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Color__Alternatives_11871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__Color__Alternatives_11891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__Color__Alternatives_11911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__Color__Alternatives_11931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__Color__Alternatives_11951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__Color__Alternatives_11971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__Color__Alternatives_11991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__Color__Alternatives_12011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__Color__Alternatives_12031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__Color__Alternatives_12051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__Color__Alternatives_12071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__Color__Alternatives_12091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__Color__Alternatives_12111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__Color__Alternatives_12131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_rule__Color__Alternatives_12151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rule__Color__Alternatives_12171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_rule__Color__Alternatives_12191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_rule__Color__Alternatives_12211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_rule__Color__Alternatives_12231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_rule__Color__Alternatives_12251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_rule__Color__Alternatives_12271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_rule__Color__Alternatives_12291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_rule__Color__Alternatives_12311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_rule__Color__Alternatives_12331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_rule__Color__Alternatives_12351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_rule__Color__Alternatives_12371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_rule__Color__Alternatives_12391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_rule__Color__Alternatives_12411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_rule__Color__Alternatives_12431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_rule__Color__Alternatives_12451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_rule__Color__Alternatives_12471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_rule__Color__Alternatives_12491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_rule__Color__Alternatives_12511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_rule__Color__Alternatives_12531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_rule__Color__Alternatives_12551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_rule__Color__Alternatives_12571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_rule__Color__Alternatives_12591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_rule__Color__Alternatives_12611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_rule__Color__Alternatives_12631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_rule__Color__Alternatives_12651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_rule__Color__Alternatives_12671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_rule__Color__Alternatives_12691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_rule__Color__Alternatives_12711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_rule__Color__Alternatives_12731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_rule__Color__Alternatives_12751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_rule__Color__Alternatives_12771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_rule__Color__Alternatives_12791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_rule__Color__Alternatives_12811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_rule__Color__Alternatives_12831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_rule__Color__Alternatives_12851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_rule__Color__Alternatives_12871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_rule__Color__Alternatives_12891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_rule__Color__Alternatives_12911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_rule__Color__Alternatives_12931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_rule__Color__Alternatives_12951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_rule__Color__Alternatives_12971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_rule__Color__Alternatives_12991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_rule__Color__Alternatives_13011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_rule__Color__Alternatives_13031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_rule__Color__Alternatives_13051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_rule__Color__Alternatives_13071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_rule__Color__Alternatives_13091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_rule__Color__Alternatives_13111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_rule__Color__Alternatives_13131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_rule__Color__Alternatives_13151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_rule__Color__Alternatives_13171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_rule__Color__Alternatives_13191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_rule__Color__Alternatives_13211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_rule__Color__Alternatives_13231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_rule__Color__Alternatives_13251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_rule__Color__Alternatives_13271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_rule__Color__Alternatives_13291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_rule__Color__Alternatives_13311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_rule__Color__Alternatives_13331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_rule__Color__Alternatives_13351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_rule__Color__Alternatives_13371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_rule__Color__Alternatives_13391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_rule__Color__Alternatives_13411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_rule__Color__Alternatives_13431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_rule__Color__Alternatives_13451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_rule__Color__Alternatives_13471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_rule__Color__Alternatives_13491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_rule__Color__Alternatives_13511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_rule__Color__Alternatives_13531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_rule__Color__Alternatives_13551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_rule__Color__Alternatives_13571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_rule__Color__Alternatives_13591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_rule__Color__Alternatives_13611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_rule__Color__Alternatives_13631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_rule__Color__Alternatives_13651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_rule__Color__Alternatives_13671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_rule__Color__Alternatives_13691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_rule__Color__Alternatives_13711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_134_in_rule__Color__Alternatives_13731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_135_in_rule__Color__Alternatives_13751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_136_in_rule__Color__Alternatives_13771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_137_in_rule__Color__Alternatives_13791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_138_in_rule__Color__Alternatives_13811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_139_in_rule__Color__Alternatives_13831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_140_in_rule__Color__Alternatives_13851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_141_in_rule__Color__Alternatives_13871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_142_in_rule__Color__Alternatives_13891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_143_in_rule__Color__Alternatives_13911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_144_in_rule__Color__Alternatives_13931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_145_in_rule__Color__Alternatives_13951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_146_in_rule__Color__Alternatives_13971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_147_in_rule__Color__Alternatives_13991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_148_in_rule__Color__Alternatives_14011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_149_in_rule__Color__Alternatives_14031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_150_in_rule__Color__Alternatives_14051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_151_in_rule__Color__Alternatives_14071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_152_in_rule__Color__Alternatives_14091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_153_in_rule__Color__Alternatives_14111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_154_in_rule__Color__Alternatives_14131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_155_in_rule__Color__Alternatives_14151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_156_in_rule__Color__Alternatives_14171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_157_in_rule__Legend__Alternatives_14206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_rule__Legend__Alternatives_14226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_rule__Legend__Alternatives_14246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2_0__0_in_rule__Legend__Alternatives_24280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Legend__Alternatives_24298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__04328 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__04331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_rule__Diagram__Group__0__Impl4359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__14390 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000000L,0x005BF00200000000L});
    public static final BitSet FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__14393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__1__Impl4420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__24449 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000000L,0x005BF00200000000L});
    public static final BitSet FOLLOW_rule__Diagram__Group__3_in_rule__Diagram__Group__24452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__InstructionsAssignment_2_in_rule__Diagram__Group__2__Impl4479 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000000L,0x005BF00000000000L});
    public static final BitSet FOLLOW_rule__Diagram__Group__3__Impl_in_rule__Diagram__Group__34510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_rule__Diagram__Group__3__Impl4538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group__0__Impl_in_rule__Instruction__Group__04577 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000000L,0x005BF00000000000L});
    public static final BitSet FOLLOW_rule__Instruction__Group__1_in_rule__Instruction__Group__04580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Alternatives_0_in_rule__Instruction__Group__0__Impl4607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group__1__Impl_in_rule__Instruction__Group__14638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Instruction__Group__1__Impl4665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__0__Impl_in_rule__Instruction__Group_0_0__04698 = new BitSet(new long[]{0x0000000000000800L,0x0000000000000000L,0x0000056800000000L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__1_in_rule__Instruction__Group_0_0__04701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Name1Assignment_0_0_0_in_rule__Instruction__Group_0_0__0__Impl4728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__1__Impl_in_rule__Instruction__Group_0_0__14758 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__2_in_rule__Instruction__Group_0_0__14761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequence_in_rule__Instruction__Group_0_0__1__Impl4788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__2__Impl_in_rule__Instruction__Group_0_0__24817 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__3_in_rule__Instruction__Group_0_0__24820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Name2Assignment_0_0_2_in_rule__Instruction__Group_0_0__2__Impl4847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0__3__Impl_in_rule__Instruction__Group_0_0__34877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0_3__0_in_rule__Instruction__Group_0_0__3__Impl4904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0_3__0__Impl_in_rule__Instruction__Group_0_0_3__04943 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0_3__1_in_rule__Instruction__Group_0_0_3__04946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_rule__Instruction__Group_0_0_3__0__Impl4974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_0_3__1__Impl_in_rule__Instruction__Group_0_0_3__15005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Instruction__Group_0_0_3__1__Impl5032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__0__Impl_in_rule__Instruction__Group_0_1__05065 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__1_in_rule__Instruction__Group_0_1__05068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_rule__Instruction__Group_0_1__0__Impl5095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__1__Impl_in_rule__Instruction__Group_0_1__15124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__Instruction__Group_0_1__1__Impl5152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__0__Impl_in_rule__Sequence__Group_0__05187 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__1_in_rule__Sequence__Group_0__05190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_0__0__Impl5219 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__1__Impl_in_rule__Sequence__Group_0__15252 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__2_in_rule__Sequence__Group_0__15255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_0__1__Impl5283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_0__2__Impl_in_rule__Sequence__Group_0__25314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_0__2__Impl5342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__0__Impl_in_rule__Sequence__Group_1__05379 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__1_in_rule__Sequence__Group_1__05382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_1__0__Impl5410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__1__Impl_in_rule__Sequence__Group_1__15441 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__2_in_rule__Sequence__Group_1__15444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_1__1__Impl5472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__2__Impl_in_rule__Sequence__Group_1__25503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_1__2__Impl5532 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__0__Impl_in_rule__Sequence__Group_2__05571 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__1_in_rule__Sequence__Group_2__05574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_2__0__Impl5602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__1__Impl_in_rule__Sequence__Group_2__15633 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__2_in_rule__Sequence__Group_2__15636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_2__1__Impl5664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_2__2__Impl_in_rule__Sequence__Group_2__25695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_166_in_rule__Sequence__Group_2__2__Impl5723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__0__Impl_in_rule__Sequence__Group_3__05760 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__1_in_rule__Sequence__Group_3__05763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_166_in_rule__Sequence__Group_3__0__Impl5791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__1__Impl_in_rule__Sequence__Group_3__15822 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__2_in_rule__Sequence__Group_3__15825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_3__1__Impl5853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_3__2__Impl_in_rule__Sequence__Group_3__25884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_3__2__Impl5912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__0__Impl_in_rule__Sequence__Group_4__05949 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__1_in_rule__Sequence__Group_4__05952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_4__0__Impl5981 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__1__Impl_in_rule__Sequence__Group_4__16014 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__2_in_rule__Sequence__Group_4__16017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_4__1__Impl6045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__2__Impl_in_rule__Sequence__Group_4__26076 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__3_in_rule__Sequence__Group_4__26079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_4__2__Impl6107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_4__3__Impl_in_rule__Sequence__Group_4__36138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_4__3__Impl6166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__0__Impl_in_rule__Sequence__Group_5__06205 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__1_in_rule__Sequence__Group_5__06208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_5__0__Impl6236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__1__Impl_in_rule__Sequence__Group_5__16267 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__2_in_rule__Sequence__Group_5__16270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_5__1__Impl6298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__2__Impl_in_rule__Sequence__Group_5__26329 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__3_in_rule__Sequence__Group_5__26332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_5__2__Impl6360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_5__3__Impl_in_rule__Sequence__Group_5__36391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_5__3__Impl6420 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__0__Impl_in_rule__Sequence__Group_6__06461 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__1_in_rule__Sequence__Group_6__06464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_6__0__Impl6493 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__1__Impl_in_rule__Sequence__Group_6__16526 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__2_in_rule__Sequence__Group_6__16529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_6__1__Impl6557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__2__Impl_in_rule__Sequence__Group_6__26588 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__3_in_rule__Sequence__Group_6__26591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_167_in_rule__Sequence__Group_6__2__Impl6619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_6__3__Impl_in_rule__Sequence__Group_6__36650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_167_in_rule__Sequence__Group_6__3__Impl6678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__0__Impl_in_rule__Sequence__Group_7__06717 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__1_in_rule__Sequence__Group_7__06720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_rule__Sequence__Group_7__0__Impl6748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__1__Impl_in_rule__Sequence__Group_7__16779 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__2_in_rule__Sequence__Group_7__16782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_7__1__Impl6810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_7__2__Impl_in_rule__Sequence__Group_7__26841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_7__2__Impl6870 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__0__Impl_in_rule__Sequence__Group_8__06909 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__1_in_rule__Sequence__Group_8__06912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_8__0__Impl6941 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__1__Impl_in_rule__Sequence__Group_8__16974 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__2_in_rule__Sequence__Group_8__16977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_8__1__Impl7005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_8__2__Impl_in_rule__Sequence__Group_8__27036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_169_in_rule__Sequence__Group_8__2__Impl7064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__0__Impl_in_rule__Sequence__Group_9__07101 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__1_in_rule__Sequence__Group_9__07104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_rule__Sequence__Group_9__0__Impl7132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__1__Impl_in_rule__Sequence__Group_9__17163 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__2_in_rule__Sequence__Group_9__17166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_rule__Sequence__Group_9__1__Impl7194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__2__Impl_in_rule__Sequence__Group_9__27225 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__3_in_rule__Sequence__Group_9__27228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_9__2__Impl7256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_9__3__Impl_in_rule__Sequence__Group_9__37287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_9__3__Impl7316 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__0__Impl_in_rule__Sequence__Group_10__07357 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__1_in_rule__Sequence__Group_10__07360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_10__0__Impl7389 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__1__Impl_in_rule__Sequence__Group_10__17422 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__2_in_rule__Sequence__Group_10__17425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_10__1__Impl7453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__2__Impl_in_rule__Sequence__Group_10__27484 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__3_in_rule__Sequence__Group_10__27487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_10__2__Impl7515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_10__3__Impl_in_rule__Sequence__Group_10__37546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_170_in_rule__Sequence__Group_10__3__Impl7574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__0__Impl_in_rule__Sequence__Group_11__07613 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__1_in_rule__Sequence__Group_11__07616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_170_in_rule__Sequence__Group_11__0__Impl7644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__1__Impl_in_rule__Sequence__Group_11__17675 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__2_in_rule__Sequence__Group_11__17678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_11__1__Impl7706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__2__Impl_in_rule__Sequence__Group_11__27737 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__3_in_rule__Sequence__Group_11__27740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_11__2__Impl7768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_11__3__Impl_in_rule__Sequence__Group_11__37799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_11__3__Impl7828 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__0__Impl_in_rule__Sequence__Group_12__07869 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__1_in_rule__Sequence__Group_12__07872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_12__0__Impl7901 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__1__Impl_in_rule__Sequence__Group_12__17934 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__2_in_rule__Sequence__Group_12__17937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_12__1__Impl7965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__2__Impl_in_rule__Sequence__Group_12__27996 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__3_in_rule__Sequence__Group_12__27999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_12__2__Impl8027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__3__Impl_in_rule__Sequence__Group_12__38058 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__4_in_rule__Sequence__Group_12__38061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_rule__Sequence__Group_12__3__Impl8089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__4__Impl_in_rule__Sequence__Group_12__48120 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__5_in_rule__Sequence__Group_12__48123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_rule__Sequence__Group_12__4__Impl8151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_12__5__Impl_in_rule__Sequence__Group_12__58182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_170_in_rule__Sequence__Group_12__5__Impl8210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__0__Impl_in_rule__Sequence__Group_13__08253 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__1_in_rule__Sequence__Group_13__08256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_170_in_rule__Sequence__Group_13__0__Impl8284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__1__Impl_in_rule__Sequence__Group_13__18315 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__2_in_rule__Sequence__Group_13__18318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_169_in_rule__Sequence__Group_13__1__Impl8346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__2__Impl_in_rule__Sequence__Group_13__28377 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__3_in_rule__Sequence__Group_13__28380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_13__2__Impl8408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__3__Impl_in_rule__Sequence__Group_13__38439 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__4_in_rule__Sequence__Group_13__38442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_13__3__Impl8470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_13__4__Impl_in_rule__Sequence__Group_13__48501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_13__4__Impl8530 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__0__Impl_in_rule__Sequence__Group_14__08573 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__1_in_rule__Sequence__Group_14__08576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_14__0__Impl8604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__1__Impl_in_rule__Sequence__Group_14__18635 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__2_in_rule__Sequence__Group_14__18638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_14__1__Impl8666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_14__2__Impl_in_rule__Sequence__Group_14__28697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_14__2__Impl8725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__0__Impl_in_rule__Sequence__Group_15__08762 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__1_in_rule__Sequence__Group_15__08765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_15__0__Impl8793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__1__Impl_in_rule__Sequence__Group_15__18824 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__2_in_rule__Sequence__Group_15__18827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_15__1__Impl8855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__2__Impl_in_rule__Sequence__Group_15__28886 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__3_in_rule__Sequence__Group_15__28889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_15__2__Impl8917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_15__3__Impl_in_rule__Sequence__Group_15__38948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_170_in_rule__Sequence__Group_15__3__Impl8976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__0__Impl_in_rule__Sequence__Group_16__09015 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__1_in_rule__Sequence__Group_16__09018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_170_in_rule__Sequence__Group_16__0__Impl9046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__1__Impl_in_rule__Sequence__Group_16__19077 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__2_in_rule__Sequence__Group_16__19080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_16__1__Impl9108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__2__Impl_in_rule__Sequence__Group_16__29139 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__3_in_rule__Sequence__Group_16__29142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_16__2__Impl9170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_16__3__Impl_in_rule__Sequence__Group_16__39201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_16__3__Impl9229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__0__Impl_in_rule__Sequence__Group_17__09268 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__1_in_rule__Sequence__Group_17__09271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_rule__Sequence__Group_17__0__Impl9299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__1__Impl_in_rule__Sequence__Group_17__19330 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__2_in_rule__Sequence__Group_17__19333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_171_in_rule__Sequence__Group_17__1__Impl9361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__2__Impl_in_rule__Sequence__Group_17__29392 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__3_in_rule__Sequence__Group_17__29395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_17__2__Impl9423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_17__3__Impl_in_rule__Sequence__Group_17__39454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_17__3__Impl9482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__0__Impl_in_rule__Sequence__Group_18__09521 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__1_in_rule__Sequence__Group_18__09524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_18__0__Impl9552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__1__Impl_in_rule__Sequence__Group_18__19583 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__2_in_rule__Sequence__Group_18__19586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_rule__Sequence__Group_18__1__Impl9614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__2__Impl_in_rule__Sequence__Group_18__29645 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__3_in_rule__Sequence__Group_18__29648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_171_in_rule__Sequence__Group_18__2__Impl9676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_18__3__Impl_in_rule__Sequence__Group_18__39707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_rule__Sequence__Group_18__3__Impl9735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__0__Impl_in_rule__Sequence__Group_19__09774 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__1_in_rule__Sequence__Group_19__09777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Sequence__Group_19__0__Impl9805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_19__1__Impl_in_rule__Sequence__Group_19__19836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Sequence__Group_19__1__Impl9864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__09899 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__09902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_172_in_rule__Definition__Group_0__0__Impl9930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__19961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl9988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__010022 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__010025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_173_in_rule__Definition__Group_1__0__Impl10053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__110084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl10111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__010145 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__010148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_174_in_rule__Definition__Group_2__0__Impl10176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__110207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl10234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__010268 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__010271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_175_in_rule__Definition__Group_3__0__Impl10299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__110330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl10357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__010391 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__010394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_176_in_rule__Definition__Group_4__0__Impl10422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__110453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl10480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__0__Impl_in_rule__AutoNumber__Group__010514 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__1_in_rule__AutoNumber__Group__010517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_177_in_rule__AutoNumber__Group__0__Impl10545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__1__Impl_in_rule__AutoNumber__Group__110576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__0_in_rule__AutoNumber__Group__1__Impl10603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__0__Impl_in_rule__AutoNumber__Group_1__010638 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__1_in_rule__AutoNumber__Group_1__010641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__0__Impl10668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__1__Impl_in_rule__AutoNumber__Group_1__110697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__1__Impl10725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Color__Group__0__Impl_in_rule__Color__Group__010760 = new BitSet(new long[]{0xFFFFFFFFFFFFF000L,0xFFFFFFFFFFFFFFFFL,0x000000001FFFFFFFL});
    public static final BitSet FOLLOW_rule__Color__Group__1_in_rule__Color__Group__010763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_178_in_rule__Color__Group__0__Impl10794 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_178_in_rule__Color__Group__0__Impl10810 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_rule__Color__Group__1__Impl_in_rule__Color__Group__110845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Color__Alternatives_1_in_rule__Color__Group__1__Impl10872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__0__Impl_in_rule__Title__Group__010906 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Title__Group__1_in_rule__Title__Group__010909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_179_in_rule__Title__Group__0__Impl10937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__1__Impl_in_rule__Title__Group__110968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Title__Group__1__Impl10995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__0__Impl_in_rule__Legend__Group__011028 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x00000000E0000000L});
    public static final BitSet FOLLOW_rule__Legend__Group__1_in_rule__Legend__Group__011031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_180_in_rule__Legend__Group__0__Impl11059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__1__Impl_in_rule__Legend__Group__111090 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x00000000E0000000L});
    public static final BitSet FOLLOW_rule__Legend__Group__2_in_rule__Legend__Group__111093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Alternatives_1_in_rule__Legend__Group__1__Impl11120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__2__Impl_in_rule__Legend__Group__211151 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x00000000E0000000L});
    public static final BitSet FOLLOW_rule__Legend__Group__3_in_rule__Legend__Group__211154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Alternatives_2_in_rule__Legend__Group__2__Impl11181 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Legend__Group__3__Impl_in_rule__Legend__Group__311212 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Legend__Group__4_in_rule__Legend__Group__311215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Legend__Group__3__Impl11242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__4__Impl_in_rule__Legend__Group__411271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_181_in_rule__Legend__Group__4__Impl11299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2_0__0__Impl_in_rule__Legend__Group_2_0__011340 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Legend__Group_2_0__1_in_rule__Legend__Group_2_0__011343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Legend__Group_2_0__0__Impl11370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2_0__1__Impl_in_rule__Legend__Group_2_0__111399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Legend__Group_2_0__1__Impl11426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__0__Impl_in_rule__Newpage__Group__011459 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Newpage__Group__1_in_rule__Newpage__Group__011462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_182_in_rule__Newpage__Group__0__Impl11490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__1__Impl_in_rule__Newpage__Group__111521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Newpage__Group__1__Impl11549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_rule__Model__DiagramsAssignment11589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_211620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Instruction__Name1Assignment_0_0_011651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Instruction__Name2Assignment_0_0_211682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_0_111713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_1_111744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_2_111775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_3_111806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_4_111837 = new BitSet(new long[]{0x0000000000000002L});

}