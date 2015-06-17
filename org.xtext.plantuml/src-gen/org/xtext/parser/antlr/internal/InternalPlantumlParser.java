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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NEWLINE", "RULE_ID", "RULE_SEQUENCE", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@startuml'", "'@enduml'", "':'", "'actor'", "'boundary'", "'control'", "'entity'", "'database'", "'participant'", "'autonumber'", "'#'", "'AliceBlue'", "'AntiqueWhite'", "'Aqua'", "'Aquamarine'", "'Azure'", "'Beige'", "'Bisque'", "'Black'", "'BlanchedAlmond'", "'Blue'", "'BlueViolet'", "'Brown'", "'BurlyWood'", "'CadetBlue'", "'Chartreuse'", "'Chocolate'", "'Coral'", "'CornflowerBlue'", "'Cornsilk'", "'Crimson'", "'Cyan'", "'DarkBlue'", "'DarkCyan'", "'DarkGoldenRod'", "'DarkGray'", "'DarkGreen'", "'DarkGrey'", "'DarkKhaki'", "'DarkMagenta'", "'DarkOliveGreen'", "'DarkOrchid'", "'DarkRed'", "'DarkSalmo'", "'DarkSeaGreen'", "'DarkSlateBlue'", "'DarkSlateGray'", "'DarkSlateGrey'", "'DarkTurquoise'", "'DarkViolet'", "'Darkorange'", "'DeepPink'", "'DeepSkyBlue'", "'DimGray'", "'DimGrey'", "'DodgerBlue'", "'FireBrick'", "'FloralWhite'", "'ForestGreen'", "'Fuchsia'", "'Gainsboro'", "'GhostWhite'", "'Gold'", "'GoldenRod'", "'Gray'", "'Green'", "'GreenYellow'", "'Grey'", "'HoneyDew'", "'HotPink'", "'IndianRed'", "'Indigo'", "'Ivory'", "'Khaki'", "'Lavender'", "'LavenderBlush'", "'LawnGreen'", "'LemonChiffon'", "'LightBlue'", "'LightCoral'", "'LightCyan'", "'LightGoldenRodYellow'", "'LightGray'", "'LightGreen'", "'LightGrey'", "'LightPink'", "'LightSalmon'", "'LightSeaGreen'", "'LightSkyBlue'", "'LightSlateGray'", "'LightSlateGrey'", "'LightSteelBlue'", "'LightYellow'", "'Lime'", "'LimeGreen'", "'Linen'", "'Magenta'", "'Maroon'", "'MediumAquaMarine'", "'MediumBlue'", "'MediumOrchid'", "'MediumPurple'", "'MediumSeaGreen'", "'MediumSlateBlue'", "'MediumSpringGreen'", "'MediumTurquoise'", "'MediumVioletRed'", "'MidnightBlue'", "'MintCream'", "'MistyRose'", "'Moccasin'", "'NavajoWhite'", "'Navy'", "'OldLace'", "'Olive'", "'OliveDrab'", "'OrangeRed'", "'Orchid'", "'PaleGoldenRod'", "'PaleGreen'", "'PaleTurquoise'", "'PaleVioletRed'", "'PapayaWhip'", "'PeachPuff'", "'Peru'", "'Pink'", "'Plum'", "'PowderBlue'", "'Purple'", "'Red'", "'RosyBrown'", "'RoyalBlue'", "'SaddleBrown'", "'Salmon'", "'SandyBrown'", "'SeaGreen'", "'Sienna'", "'Silver'", "'SkyBlue'", "'SlateBlue'", "'SlateGray'", "'SlateGrey'", "'Snow'", "'SpringGreen'", "'SteelBlue'", "'Tan'", "'Teal'", "'Thistle'", "'Tomato'", "'Turquoise'", "'Violet'", "'Wheat'", "'White'", "'WhiteSmoke'", "'Yellow'", "'YellowGreen'", "'title'", "'legend'", "'right'", "'left'", "'center'", "'endlegend'", "'newpage'", "'alt'", "'end'", "'else'", "'opt'", "'loop'", "'par'", "'break'", "'critical'", "'note'", "'of'", "','", "'over'", "'end note'", "'=='", "'ref over'", "'end ref'", "'...'", "'|||'", "'||'", "'hide footbox'"
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
    public static final int RULE_SEQUENCE=6;
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

                if ( (LA1_0==12) ) {
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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:115:1: ruleDiagram returns [EObject current=null] : (otherlv_0= '@startuml' this_NEWLINE_1= RULE_NEWLINE ( (lv_instructions_2_0= ruleInstruction ) )* otherlv_3= '@enduml' ) ;
    public final EObject ruleDiagram() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_NEWLINE_1=null;
        Token otherlv_3=null;
        EObject lv_instructions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:118:28: ( (otherlv_0= '@startuml' this_NEWLINE_1= RULE_NEWLINE ( (lv_instructions_2_0= ruleInstruction ) )* otherlv_3= '@enduml' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:119:1: (otherlv_0= '@startuml' this_NEWLINE_1= RULE_NEWLINE ( (lv_instructions_2_0= ruleInstruction ) )* otherlv_3= '@enduml' )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:119:1: (otherlv_0= '@startuml' this_NEWLINE_1= RULE_NEWLINE ( (lv_instructions_2_0= ruleInstruction ) )* otherlv_3= '@enduml' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:119:3: otherlv_0= '@startuml' this_NEWLINE_1= RULE_NEWLINE ( (lv_instructions_2_0= ruleInstruction ) )* otherlv_3= '@enduml'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleDiagram213); 

                	newLeafNode(otherlv_0, grammarAccess.getDiagramAccess().getStartumlKeyword_0());
                
            this_NEWLINE_1=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleDiagram224); 
             
                newLeafNode(this_NEWLINE_1, grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_1()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:127:1: ( (lv_instructions_2_0= ruleInstruction ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_NEWLINE && LA2_0<=RULE_ID)||(LA2_0>=15 && LA2_0<=21)||(LA2_0>=168 && LA2_0<=169)||(LA2_0>=174 && LA2_0<=175)||(LA2_0>=178 && LA2_0<=183)||(LA2_0>=188 && LA2_0<=189)||(LA2_0>=191 && LA2_0<=194)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:128:1: (lv_instructions_2_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:128:1: (lv_instructions_2_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:129:3: lv_instructions_2_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleDiagram244);
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

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleDiagram257); 

                	newLeafNode(otherlv_3, grammarAccess.getDiagramAccess().getEndumlKeyword_3());
                

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:157:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:158:2: (iv_ruleInstruction= ruleInstruction EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:159:2: iv_ruleInstruction= ruleInstruction EOF
            {
             newCompositeNode(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_ruleInstruction_in_entryRuleInstruction293);
            iv_ruleInstruction=ruleInstruction();

            state._fsp--;

             current =iv_ruleInstruction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstruction303); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:166:1: ruleInstruction returns [EObject current=null] : ( ( ( ( (lv_name1_0_0= RULE_ID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? ) | (this_Definition_5= ruleDefinition ( ruleColor )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_11= ruleAltElse | this_GroupingMessages_12= ruleGroupingMessages | ruleNote | ruleDivider | ruleReference | ruleDelay | ruleSpace | ruleHidefootbox )? this_NEWLINE_19= RULE_NEWLINE ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_name1_0_0=null;
        Token this_SEQUENCE_1=null;
        Token lv_name2_2_0=null;
        Token otherlv_3=null;
        Token this_ID_4=null;
        Token this_NEWLINE_19=null;
        EObject this_Definition_5 = null;

        EObject this_AltElse_11 = null;

        EObject this_GroupingMessages_12 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:169:28: ( ( ( ( ( (lv_name1_0_0= RULE_ID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? ) | (this_Definition_5= ruleDefinition ( ruleColor )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_11= ruleAltElse | this_GroupingMessages_12= ruleGroupingMessages | ruleNote | ruleDivider | ruleReference | ruleDelay | ruleSpace | ruleHidefootbox )? this_NEWLINE_19= RULE_NEWLINE ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:170:1: ( ( ( ( (lv_name1_0_0= RULE_ID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? ) | (this_Definition_5= ruleDefinition ( ruleColor )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_11= ruleAltElse | this_GroupingMessages_12= ruleGroupingMessages | ruleNote | ruleDivider | ruleReference | ruleDelay | ruleSpace | ruleHidefootbox )? this_NEWLINE_19= RULE_NEWLINE )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:170:1: ( ( ( ( (lv_name1_0_0= RULE_ID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? ) | (this_Definition_5= ruleDefinition ( ruleColor )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_11= ruleAltElse | this_GroupingMessages_12= ruleGroupingMessages | ruleNote | ruleDivider | ruleReference | ruleDelay | ruleSpace | ruleHidefootbox )? this_NEWLINE_19= RULE_NEWLINE )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:170:2: ( ( ( (lv_name1_0_0= RULE_ID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? ) | (this_Definition_5= ruleDefinition ( ruleColor )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_11= ruleAltElse | this_GroupingMessages_12= ruleGroupingMessages | ruleNote | ruleDivider | ruleReference | ruleDelay | ruleSpace | ruleHidefootbox )? this_NEWLINE_19= RULE_NEWLINE
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:170:2: ( ( ( (lv_name1_0_0= RULE_ID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? ) | (this_Definition_5= ruleDefinition ( ruleColor )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_11= ruleAltElse | this_GroupingMessages_12= ruleGroupingMessages | ruleNote | ruleDivider | ruleReference | ruleDelay | ruleSpace | ruleHidefootbox )?
            int alt5=15;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    alt5=1;
                    }
                    break;
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                    {
                    alt5=2;
                    }
                    break;
                case 21:
                    {
                    alt5=3;
                    }
                    break;
                case 168:
                    {
                    alt5=4;
                    }
                    break;
                case 169:
                    {
                    alt5=5;
                    }
                    break;
                case 174:
                    {
                    alt5=6;
                    }
                    break;
                case 175:
                    {
                    alt5=7;
                    }
                    break;
                case 178:
                case 179:
                case 180:
                case 181:
                case 182:
                    {
                    alt5=8;
                    }
                    break;
                case 183:
                    {
                    alt5=9;
                    }
                    break;
                case 188:
                    {
                    alt5=10;
                    }
                    break;
                case 189:
                    {
                    alt5=11;
                    }
                    break;
                case 191:
                    {
                    alt5=12;
                    }
                    break;
                case 192:
                case 193:
                    {
                    alt5=13;
                    }
                    break;
                case 194:
                    {
                    alt5=14;
                    }
                    break;
            }

            switch (alt5) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:170:3: ( ( (lv_name1_0_0= RULE_ID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:170:3: ( ( (lv_name1_0_0= RULE_ID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:170:4: ( (lv_name1_0_0= RULE_ID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )?
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:170:4: ( (lv_name1_0_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:171:1: (lv_name1_0_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:171:1: (lv_name1_0_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:172:3: lv_name1_0_0= RULE_ID
                    {
                    lv_name1_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstruction347); 

                    			newLeafNode(lv_name1_0_0, grammarAccess.getInstructionAccess().getName1IDTerminalRuleCall_0_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInstructionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name1",
                            		lv_name1_0_0, 
                            		"ID");
                    	    

                    }


                    }

                    this_SEQUENCE_1=(Token)match(input,RULE_SEQUENCE,FOLLOW_RULE_SEQUENCE_in_ruleInstruction363); 
                     
                        newLeafNode(this_SEQUENCE_1, grammarAccess.getInstructionAccess().getSEQUENCETerminalRuleCall_0_0_1()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:192:1: ( (lv_name2_2_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:193:1: (lv_name2_2_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:193:1: (lv_name2_2_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:194:3: lv_name2_2_0= RULE_ID
                    {
                    lv_name2_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstruction379); 

                    			newLeafNode(lv_name2_2_0, grammarAccess.getInstructionAccess().getName2IDTerminalRuleCall_0_0_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInstructionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name2",
                            		lv_name2_2_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:210:2: (otherlv_3= ':' this_ID_4= RULE_ID )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==14) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:210:4: otherlv_3= ':' this_ID_4= RULE_ID
                            {
                            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleInstruction397); 

                                	newLeafNode(otherlv_3, grammarAccess.getInstructionAccess().getColonKeyword_0_0_3_0());
                                
                            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstruction408); 
                             
                                newLeafNode(this_ID_4, grammarAccess.getInstructionAccess().getIDTerminalRuleCall_0_0_3_1()); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:219:6: (this_Definition_5= ruleDefinition ( ruleColor )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:219:6: (this_Definition_5= ruleDefinition ( ruleColor )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:220:5: this_Definition_5= ruleDefinition ( ruleColor )?
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_0_1_0()); 
                        
                    pushFollow(FOLLOW_ruleDefinition_in_ruleInstruction439);
                    this_Definition_5=ruleDefinition();

                    state._fsp--;

                     
                            current = this_Definition_5; 
                            afterParserOrEnumRuleCall();
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:228:1: ( ruleColor )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==22) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:229:5: ruleColor
                            {
                             
                                    newCompositeNode(grammarAccess.getInstructionAccess().getColorParserRuleCall_0_1_1()); 
                                
                            pushFollow(FOLLOW_ruleColor_in_ruleInstruction455);
                            ruleColor();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:238:5: ruleAutoNumber
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 
                        
                    pushFollow(FOLLOW_ruleAutoNumber_in_ruleInstruction479);
                    ruleAutoNumber();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:247:5: ruleTitle
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 
                        
                    pushFollow(FOLLOW_ruleTitle_in_ruleInstruction500);
                    ruleTitle();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:256:5: ruleLegend
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 
                        
                    pushFollow(FOLLOW_ruleLegend_in_ruleInstruction521);
                    ruleLegend();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:265:5: ruleNewpage
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 
                        
                    pushFollow(FOLLOW_ruleNewpage_in_ruleInstruction542);
                    ruleNewpage();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:274:5: this_AltElse_11= ruleAltElse
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getAltElseParserRuleCall_0_6()); 
                        
                    pushFollow(FOLLOW_ruleAltElse_in_ruleInstruction569);
                    this_AltElse_11=ruleAltElse();

                    state._fsp--;

                     
                            current = this_AltElse_11; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:284:5: this_GroupingMessages_12= ruleGroupingMessages
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getGroupingMessagesParserRuleCall_0_7()); 
                        
                    pushFollow(FOLLOW_ruleGroupingMessages_in_ruleInstruction596);
                    this_GroupingMessages_12=ruleGroupingMessages();

                    state._fsp--;

                     
                            current = this_GroupingMessages_12; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:294:5: ruleNote
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getNoteParserRuleCall_0_8()); 
                        
                    pushFollow(FOLLOW_ruleNote_in_ruleInstruction617);
                    ruleNote();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:303:5: ruleDivider
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDividerParserRuleCall_0_9()); 
                        
                    pushFollow(FOLLOW_ruleDivider_in_ruleInstruction638);
                    ruleDivider();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:312:5: ruleReference
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getReferenceParserRuleCall_0_10()); 
                        
                    pushFollow(FOLLOW_ruleReference_in_ruleInstruction659);
                    ruleReference();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:321:5: ruleDelay
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDelayParserRuleCall_0_11()); 
                        
                    pushFollow(FOLLOW_ruleDelay_in_ruleInstruction680);
                    ruleDelay();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:330:5: ruleSpace
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getSpaceParserRuleCall_0_12()); 
                        
                    pushFollow(FOLLOW_ruleSpace_in_ruleInstruction701);
                    ruleSpace();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:339:5: ruleHidefootbox
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getHidefootboxParserRuleCall_0_13()); 
                        
                    pushFollow(FOLLOW_ruleHidefootbox_in_ruleInstruction722);
                    ruleHidefootbox();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            this_NEWLINE_19=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleInstruction734); 
             
                newLeafNode(this_NEWLINE_19, grammarAccess.getInstructionAccess().getNEWLINETerminalRuleCall_1()); 
                

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


    // $ANTLR start "entryRuleDefinition"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:358:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:359:2: (iv_ruleDefinition= ruleDefinition EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:360:2: iv_ruleDefinition= ruleDefinition EOF
            {
             newCompositeNode(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition769);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition779); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:367:1: ruleDefinition returns [EObject current=null] : ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) ) | (otherlv_10= 'participant' ( (lv_name_11_0= RULE_ID ) ) ) ) ;
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
        Token otherlv_10=null;
        Token lv_name_11_0=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:370:28: ( ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) ) | (otherlv_10= 'participant' ( (lv_name_11_0= RULE_ID ) ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:371:1: ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) ) | (otherlv_10= 'participant' ( (lv_name_11_0= RULE_ID ) ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:371:1: ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) ) | (otherlv_10= 'participant' ( (lv_name_11_0= RULE_ID ) ) ) )
            int alt6=6;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt6=1;
                }
                break;
            case 16:
                {
                alt6=2;
                }
                break;
            case 17:
                {
                alt6=3;
                }
                break;
            case 18:
                {
                alt6=4;
                }
                break;
            case 19:
                {
                alt6=5;
                }
                break;
            case 20:
                {
                alt6=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:371:2: (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:371:2: (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:371:4: otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleDefinition817); 

                        	newLeafNode(otherlv_0, grammarAccess.getDefinitionAccess().getActorKeyword_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:375:1: ( (lv_name_1_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:376:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:376:1: (lv_name_1_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:377:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition834); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:394:6: (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:394:6: (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:394:8: otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleDefinition859); 

                        	newLeafNode(otherlv_2, grammarAccess.getDefinitionAccess().getBoundaryKeyword_1_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:398:1: ( (lv_name_3_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:399:1: (lv_name_3_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:399:1: (lv_name_3_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:400:3: lv_name_3_0= RULE_ID
                    {
                    lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition876); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:417:6: (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:417:6: (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:417:8: otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleDefinition901); 

                        	newLeafNode(otherlv_4, grammarAccess.getDefinitionAccess().getControlKeyword_2_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:421:1: ( (lv_name_5_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:422:1: (lv_name_5_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:422:1: (lv_name_5_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:423:3: lv_name_5_0= RULE_ID
                    {
                    lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition918); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:440:6: (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:440:6: (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:440:8: otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleDefinition943); 

                        	newLeafNode(otherlv_6, grammarAccess.getDefinitionAccess().getEntityKeyword_3_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:444:1: ( (lv_name_7_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:445:1: (lv_name_7_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:445:1: (lv_name_7_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:446:3: lv_name_7_0= RULE_ID
                    {
                    lv_name_7_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition960); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:463:6: (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:463:6: (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:463:8: otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,19,FOLLOW_19_in_ruleDefinition985); 

                        	newLeafNode(otherlv_8, grammarAccess.getDefinitionAccess().getDatabaseKeyword_4_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:467:1: ( (lv_name_9_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:468:1: (lv_name_9_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:468:1: (lv_name_9_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:469:3: lv_name_9_0= RULE_ID
                    {
                    lv_name_9_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1002); 

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
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:486:6: (otherlv_10= 'participant' ( (lv_name_11_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:486:6: (otherlv_10= 'participant' ( (lv_name_11_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:486:8: otherlv_10= 'participant' ( (lv_name_11_0= RULE_ID ) )
                    {
                    otherlv_10=(Token)match(input,20,FOLLOW_20_in_ruleDefinition1027); 

                        	newLeafNode(otherlv_10, grammarAccess.getDefinitionAccess().getParticipantKeyword_5_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:490:1: ( (lv_name_11_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:491:1: (lv_name_11_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:491:1: (lv_name_11_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:492:3: lv_name_11_0= RULE_ID
                    {
                    lv_name_11_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1044); 

                    			newLeafNode(lv_name_11_0, grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_5_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDefinitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_11_0, 
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


    // $ANTLR start "entryRuleAutoNumber"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:516:1: entryRuleAutoNumber returns [String current=null] : iv_ruleAutoNumber= ruleAutoNumber EOF ;
    public final String entryRuleAutoNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAutoNumber = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:517:2: (iv_ruleAutoNumber= ruleAutoNumber EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:518:2: iv_ruleAutoNumber= ruleAutoNumber EOF
            {
             newCompositeNode(grammarAccess.getAutoNumberRule()); 
            pushFollow(FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber1087);
            iv_ruleAutoNumber=ruleAutoNumber();

            state._fsp--;

             current =iv_ruleAutoNumber.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAutoNumber1098); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:525:1: ruleAutoNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'autonumber' (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? ) ;
    public final AntlrDatatypeRuleToken ruleAutoNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:528:28: ( (kw= 'autonumber' (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:529:1: (kw= 'autonumber' (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:529:1: (kw= 'autonumber' (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:530:2: kw= 'autonumber' (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )?
            {
            kw=(Token)match(input,21,FOLLOW_21_in_ruleAutoNumber1136); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getAutoNumberAccess().getAutonumberKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:535:1: (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_INT) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:535:6: this_INT_1= RULE_INT (this_INT_2= RULE_INT )?
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAutoNumber1152); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_0()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:542:1: (this_INT_2= RULE_INT )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==RULE_INT) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:542:6: this_INT_2= RULE_INT
                            {
                            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAutoNumber1173); 

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


    // $ANTLR start "entryRuleColor"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:557:1: entryRuleColor returns [String current=null] : iv_ruleColor= ruleColor EOF ;
    public final String entryRuleColor() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleColor = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:558:2: (iv_ruleColor= ruleColor EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:559:2: iv_ruleColor= ruleColor EOF
            {
             newCompositeNode(grammarAccess.getColorRule()); 
            pushFollow(FOLLOW_ruleColor_in_entryRuleColor1223);
            iv_ruleColor=ruleColor();

            state._fsp--;

             current =iv_ruleColor.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColor1234); 

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
    // $ANTLR end "entryRuleColor"


    // $ANTLR start "ruleColor"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:566:1: ruleColor returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '#' )+ (kw= 'AliceBlue' | kw= 'AntiqueWhite' | kw= 'Aqua' | kw= 'Aquamarine' | kw= 'Azure' | kw= 'Beige' | kw= 'Bisque' | kw= 'Black' | kw= 'BlanchedAlmond' | kw= 'Blue' | kw= 'BlueViolet' | kw= 'Brown' | kw= 'BurlyWood' | kw= 'CadetBlue' | kw= 'Chartreuse' | kw= 'Chocolate' | kw= 'Coral' | kw= 'CornflowerBlue' | kw= 'Cornsilk' | kw= 'Crimson' | kw= 'Cyan' | kw= 'DarkBlue' | kw= 'DarkCyan' | kw= 'DarkGoldenRod' | kw= 'DarkGray' | kw= 'DarkGreen' | kw= 'DarkGrey' | kw= 'DarkKhaki' | kw= 'DarkMagenta' | kw= 'DarkOliveGreen' | kw= 'DarkOrchid' | kw= 'DarkRed' | kw= 'DarkSalmo' | kw= 'DarkSeaGreen' | kw= 'DarkSlateBlue' | kw= 'DarkSlateGray' | kw= 'DarkSlateGrey' | kw= 'DarkTurquoise' | kw= 'DarkViolet' | kw= 'Darkorange' | kw= 'DeepPink' | kw= 'DeepSkyBlue' | kw= 'DimGray' | kw= 'DimGrey' | kw= 'DodgerBlue' | kw= 'FireBrick' | kw= 'FloralWhite' | kw= 'ForestGreen' | kw= 'Fuchsia' | kw= 'Gainsboro' | kw= 'GhostWhite' | kw= 'Gold' | kw= 'GoldenRod' | kw= 'Gray' | kw= 'Green' | kw= 'GreenYellow' | kw= 'Grey' | kw= 'HoneyDew' | kw= 'HotPink' | kw= 'IndianRed' | kw= 'Indigo' | kw= 'Ivory' | kw= 'Khaki' | kw= 'Lavender' | kw= 'LavenderBlush' | kw= 'LawnGreen' | kw= 'LemonChiffon' | kw= 'LightBlue' | kw= 'LightCoral' | kw= 'LightCyan' | kw= 'LightGoldenRodYellow' | kw= 'LightGray' | kw= 'LightGreen' | kw= 'LightGrey' | kw= 'LightPink' | kw= 'LightSalmon' | kw= 'LightSeaGreen' | kw= 'LightSkyBlue' | kw= 'LightSlateGray' | kw= 'LightSlateGrey' | kw= 'LightSteelBlue' | kw= 'LightYellow' | kw= 'Lime' | kw= 'LimeGreen' | kw= 'Linen' | kw= 'Magenta' | kw= 'Maroon' | kw= 'MediumAquaMarine' | kw= 'MediumBlue' | kw= 'MediumOrchid' | kw= 'MediumPurple' | kw= 'MediumSeaGreen' | kw= 'MediumSlateBlue' | kw= 'MediumSpringGreen' | kw= 'MediumTurquoise' | kw= 'MediumVioletRed' | kw= 'MidnightBlue' | kw= 'MintCream' | kw= 'MistyRose' | kw= 'Moccasin' | kw= 'NavajoWhite' | kw= 'Navy' | kw= 'OldLace' | kw= 'Olive' | kw= 'OliveDrab' | kw= 'OrangeRed' | kw= 'Orchid' | kw= 'PaleGoldenRod' | kw= 'PaleGreen' | kw= 'PaleTurquoise' | kw= 'PaleVioletRed' | kw= 'PapayaWhip' | kw= 'PeachPuff' | kw= 'Peru' | kw= 'Pink' | kw= 'Plum' | kw= 'PowderBlue' | kw= 'Purple' | kw= 'Red' | kw= 'RosyBrown' | kw= 'RoyalBlue' | kw= 'SaddleBrown' | kw= 'Salmon' | kw= 'SandyBrown' | kw= 'SeaGreen' | kw= 'Sienna' | kw= 'Silver' | kw= 'SkyBlue' | kw= 'SlateBlue' | kw= 'SlateGray' | kw= 'SlateGrey' | kw= 'Snow' | kw= 'SpringGreen' | kw= 'SteelBlue' | kw= 'Tan' | kw= 'Teal' | kw= 'Thistle' | kw= 'Tomato' | kw= 'Turquoise' | kw= 'Violet' | kw= 'Wheat' | kw= 'White' | kw= 'WhiteSmoke' | kw= 'Yellow' | kw= 'YellowGreen' ) ) ;
    public final AntlrDatatypeRuleToken ruleColor() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:569:28: ( ( (kw= '#' )+ (kw= 'AliceBlue' | kw= 'AntiqueWhite' | kw= 'Aqua' | kw= 'Aquamarine' | kw= 'Azure' | kw= 'Beige' | kw= 'Bisque' | kw= 'Black' | kw= 'BlanchedAlmond' | kw= 'Blue' | kw= 'BlueViolet' | kw= 'Brown' | kw= 'BurlyWood' | kw= 'CadetBlue' | kw= 'Chartreuse' | kw= 'Chocolate' | kw= 'Coral' | kw= 'CornflowerBlue' | kw= 'Cornsilk' | kw= 'Crimson' | kw= 'Cyan' | kw= 'DarkBlue' | kw= 'DarkCyan' | kw= 'DarkGoldenRod' | kw= 'DarkGray' | kw= 'DarkGreen' | kw= 'DarkGrey' | kw= 'DarkKhaki' | kw= 'DarkMagenta' | kw= 'DarkOliveGreen' | kw= 'DarkOrchid' | kw= 'DarkRed' | kw= 'DarkSalmo' | kw= 'DarkSeaGreen' | kw= 'DarkSlateBlue' | kw= 'DarkSlateGray' | kw= 'DarkSlateGrey' | kw= 'DarkTurquoise' | kw= 'DarkViolet' | kw= 'Darkorange' | kw= 'DeepPink' | kw= 'DeepSkyBlue' | kw= 'DimGray' | kw= 'DimGrey' | kw= 'DodgerBlue' | kw= 'FireBrick' | kw= 'FloralWhite' | kw= 'ForestGreen' | kw= 'Fuchsia' | kw= 'Gainsboro' | kw= 'GhostWhite' | kw= 'Gold' | kw= 'GoldenRod' | kw= 'Gray' | kw= 'Green' | kw= 'GreenYellow' | kw= 'Grey' | kw= 'HoneyDew' | kw= 'HotPink' | kw= 'IndianRed' | kw= 'Indigo' | kw= 'Ivory' | kw= 'Khaki' | kw= 'Lavender' | kw= 'LavenderBlush' | kw= 'LawnGreen' | kw= 'LemonChiffon' | kw= 'LightBlue' | kw= 'LightCoral' | kw= 'LightCyan' | kw= 'LightGoldenRodYellow' | kw= 'LightGray' | kw= 'LightGreen' | kw= 'LightGrey' | kw= 'LightPink' | kw= 'LightSalmon' | kw= 'LightSeaGreen' | kw= 'LightSkyBlue' | kw= 'LightSlateGray' | kw= 'LightSlateGrey' | kw= 'LightSteelBlue' | kw= 'LightYellow' | kw= 'Lime' | kw= 'LimeGreen' | kw= 'Linen' | kw= 'Magenta' | kw= 'Maroon' | kw= 'MediumAquaMarine' | kw= 'MediumBlue' | kw= 'MediumOrchid' | kw= 'MediumPurple' | kw= 'MediumSeaGreen' | kw= 'MediumSlateBlue' | kw= 'MediumSpringGreen' | kw= 'MediumTurquoise' | kw= 'MediumVioletRed' | kw= 'MidnightBlue' | kw= 'MintCream' | kw= 'MistyRose' | kw= 'Moccasin' | kw= 'NavajoWhite' | kw= 'Navy' | kw= 'OldLace' | kw= 'Olive' | kw= 'OliveDrab' | kw= 'OrangeRed' | kw= 'Orchid' | kw= 'PaleGoldenRod' | kw= 'PaleGreen' | kw= 'PaleTurquoise' | kw= 'PaleVioletRed' | kw= 'PapayaWhip' | kw= 'PeachPuff' | kw= 'Peru' | kw= 'Pink' | kw= 'Plum' | kw= 'PowderBlue' | kw= 'Purple' | kw= 'Red' | kw= 'RosyBrown' | kw= 'RoyalBlue' | kw= 'SaddleBrown' | kw= 'Salmon' | kw= 'SandyBrown' | kw= 'SeaGreen' | kw= 'Sienna' | kw= 'Silver' | kw= 'SkyBlue' | kw= 'SlateBlue' | kw= 'SlateGray' | kw= 'SlateGrey' | kw= 'Snow' | kw= 'SpringGreen' | kw= 'SteelBlue' | kw= 'Tan' | kw= 'Teal' | kw= 'Thistle' | kw= 'Tomato' | kw= 'Turquoise' | kw= 'Violet' | kw= 'Wheat' | kw= 'White' | kw= 'WhiteSmoke' | kw= 'Yellow' | kw= 'YellowGreen' ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:570:1: ( (kw= '#' )+ (kw= 'AliceBlue' | kw= 'AntiqueWhite' | kw= 'Aqua' | kw= 'Aquamarine' | kw= 'Azure' | kw= 'Beige' | kw= 'Bisque' | kw= 'Black' | kw= 'BlanchedAlmond' | kw= 'Blue' | kw= 'BlueViolet' | kw= 'Brown' | kw= 'BurlyWood' | kw= 'CadetBlue' | kw= 'Chartreuse' | kw= 'Chocolate' | kw= 'Coral' | kw= 'CornflowerBlue' | kw= 'Cornsilk' | kw= 'Crimson' | kw= 'Cyan' | kw= 'DarkBlue' | kw= 'DarkCyan' | kw= 'DarkGoldenRod' | kw= 'DarkGray' | kw= 'DarkGreen' | kw= 'DarkGrey' | kw= 'DarkKhaki' | kw= 'DarkMagenta' | kw= 'DarkOliveGreen' | kw= 'DarkOrchid' | kw= 'DarkRed' | kw= 'DarkSalmo' | kw= 'DarkSeaGreen' | kw= 'DarkSlateBlue' | kw= 'DarkSlateGray' | kw= 'DarkSlateGrey' | kw= 'DarkTurquoise' | kw= 'DarkViolet' | kw= 'Darkorange' | kw= 'DeepPink' | kw= 'DeepSkyBlue' | kw= 'DimGray' | kw= 'DimGrey' | kw= 'DodgerBlue' | kw= 'FireBrick' | kw= 'FloralWhite' | kw= 'ForestGreen' | kw= 'Fuchsia' | kw= 'Gainsboro' | kw= 'GhostWhite' | kw= 'Gold' | kw= 'GoldenRod' | kw= 'Gray' | kw= 'Green' | kw= 'GreenYellow' | kw= 'Grey' | kw= 'HoneyDew' | kw= 'HotPink' | kw= 'IndianRed' | kw= 'Indigo' | kw= 'Ivory' | kw= 'Khaki' | kw= 'Lavender' | kw= 'LavenderBlush' | kw= 'LawnGreen' | kw= 'LemonChiffon' | kw= 'LightBlue' | kw= 'LightCoral' | kw= 'LightCyan' | kw= 'LightGoldenRodYellow' | kw= 'LightGray' | kw= 'LightGreen' | kw= 'LightGrey' | kw= 'LightPink' | kw= 'LightSalmon' | kw= 'LightSeaGreen' | kw= 'LightSkyBlue' | kw= 'LightSlateGray' | kw= 'LightSlateGrey' | kw= 'LightSteelBlue' | kw= 'LightYellow' | kw= 'Lime' | kw= 'LimeGreen' | kw= 'Linen' | kw= 'Magenta' | kw= 'Maroon' | kw= 'MediumAquaMarine' | kw= 'MediumBlue' | kw= 'MediumOrchid' | kw= 'MediumPurple' | kw= 'MediumSeaGreen' | kw= 'MediumSlateBlue' | kw= 'MediumSpringGreen' | kw= 'MediumTurquoise' | kw= 'MediumVioletRed' | kw= 'MidnightBlue' | kw= 'MintCream' | kw= 'MistyRose' | kw= 'Moccasin' | kw= 'NavajoWhite' | kw= 'Navy' | kw= 'OldLace' | kw= 'Olive' | kw= 'OliveDrab' | kw= 'OrangeRed' | kw= 'Orchid' | kw= 'PaleGoldenRod' | kw= 'PaleGreen' | kw= 'PaleTurquoise' | kw= 'PaleVioletRed' | kw= 'PapayaWhip' | kw= 'PeachPuff' | kw= 'Peru' | kw= 'Pink' | kw= 'Plum' | kw= 'PowderBlue' | kw= 'Purple' | kw= 'Red' | kw= 'RosyBrown' | kw= 'RoyalBlue' | kw= 'SaddleBrown' | kw= 'Salmon' | kw= 'SandyBrown' | kw= 'SeaGreen' | kw= 'Sienna' | kw= 'Silver' | kw= 'SkyBlue' | kw= 'SlateBlue' | kw= 'SlateGray' | kw= 'SlateGrey' | kw= 'Snow' | kw= 'SpringGreen' | kw= 'SteelBlue' | kw= 'Tan' | kw= 'Teal' | kw= 'Thistle' | kw= 'Tomato' | kw= 'Turquoise' | kw= 'Violet' | kw= 'Wheat' | kw= 'White' | kw= 'WhiteSmoke' | kw= 'Yellow' | kw= 'YellowGreen' ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:570:1: ( (kw= '#' )+ (kw= 'AliceBlue' | kw= 'AntiqueWhite' | kw= 'Aqua' | kw= 'Aquamarine' | kw= 'Azure' | kw= 'Beige' | kw= 'Bisque' | kw= 'Black' | kw= 'BlanchedAlmond' | kw= 'Blue' | kw= 'BlueViolet' | kw= 'Brown' | kw= 'BurlyWood' | kw= 'CadetBlue' | kw= 'Chartreuse' | kw= 'Chocolate' | kw= 'Coral' | kw= 'CornflowerBlue' | kw= 'Cornsilk' | kw= 'Crimson' | kw= 'Cyan' | kw= 'DarkBlue' | kw= 'DarkCyan' | kw= 'DarkGoldenRod' | kw= 'DarkGray' | kw= 'DarkGreen' | kw= 'DarkGrey' | kw= 'DarkKhaki' | kw= 'DarkMagenta' | kw= 'DarkOliveGreen' | kw= 'DarkOrchid' | kw= 'DarkRed' | kw= 'DarkSalmo' | kw= 'DarkSeaGreen' | kw= 'DarkSlateBlue' | kw= 'DarkSlateGray' | kw= 'DarkSlateGrey' | kw= 'DarkTurquoise' | kw= 'DarkViolet' | kw= 'Darkorange' | kw= 'DeepPink' | kw= 'DeepSkyBlue' | kw= 'DimGray' | kw= 'DimGrey' | kw= 'DodgerBlue' | kw= 'FireBrick' | kw= 'FloralWhite' | kw= 'ForestGreen' | kw= 'Fuchsia' | kw= 'Gainsboro' | kw= 'GhostWhite' | kw= 'Gold' | kw= 'GoldenRod' | kw= 'Gray' | kw= 'Green' | kw= 'GreenYellow' | kw= 'Grey' | kw= 'HoneyDew' | kw= 'HotPink' | kw= 'IndianRed' | kw= 'Indigo' | kw= 'Ivory' | kw= 'Khaki' | kw= 'Lavender' | kw= 'LavenderBlush' | kw= 'LawnGreen' | kw= 'LemonChiffon' | kw= 'LightBlue' | kw= 'LightCoral' | kw= 'LightCyan' | kw= 'LightGoldenRodYellow' | kw= 'LightGray' | kw= 'LightGreen' | kw= 'LightGrey' | kw= 'LightPink' | kw= 'LightSalmon' | kw= 'LightSeaGreen' | kw= 'LightSkyBlue' | kw= 'LightSlateGray' | kw= 'LightSlateGrey' | kw= 'LightSteelBlue' | kw= 'LightYellow' | kw= 'Lime' | kw= 'LimeGreen' | kw= 'Linen' | kw= 'Magenta' | kw= 'Maroon' | kw= 'MediumAquaMarine' | kw= 'MediumBlue' | kw= 'MediumOrchid' | kw= 'MediumPurple' | kw= 'MediumSeaGreen' | kw= 'MediumSlateBlue' | kw= 'MediumSpringGreen' | kw= 'MediumTurquoise' | kw= 'MediumVioletRed' | kw= 'MidnightBlue' | kw= 'MintCream' | kw= 'MistyRose' | kw= 'Moccasin' | kw= 'NavajoWhite' | kw= 'Navy' | kw= 'OldLace' | kw= 'Olive' | kw= 'OliveDrab' | kw= 'OrangeRed' | kw= 'Orchid' | kw= 'PaleGoldenRod' | kw= 'PaleGreen' | kw= 'PaleTurquoise' | kw= 'PaleVioletRed' | kw= 'PapayaWhip' | kw= 'PeachPuff' | kw= 'Peru' | kw= 'Pink' | kw= 'Plum' | kw= 'PowderBlue' | kw= 'Purple' | kw= 'Red' | kw= 'RosyBrown' | kw= 'RoyalBlue' | kw= 'SaddleBrown' | kw= 'Salmon' | kw= 'SandyBrown' | kw= 'SeaGreen' | kw= 'Sienna' | kw= 'Silver' | kw= 'SkyBlue' | kw= 'SlateBlue' | kw= 'SlateGray' | kw= 'SlateGrey' | kw= 'Snow' | kw= 'SpringGreen' | kw= 'SteelBlue' | kw= 'Tan' | kw= 'Teal' | kw= 'Thistle' | kw= 'Tomato' | kw= 'Turquoise' | kw= 'Violet' | kw= 'Wheat' | kw= 'White' | kw= 'WhiteSmoke' | kw= 'Yellow' | kw= 'YellowGreen' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:570:2: (kw= '#' )+ (kw= 'AliceBlue' | kw= 'AntiqueWhite' | kw= 'Aqua' | kw= 'Aquamarine' | kw= 'Azure' | kw= 'Beige' | kw= 'Bisque' | kw= 'Black' | kw= 'BlanchedAlmond' | kw= 'Blue' | kw= 'BlueViolet' | kw= 'Brown' | kw= 'BurlyWood' | kw= 'CadetBlue' | kw= 'Chartreuse' | kw= 'Chocolate' | kw= 'Coral' | kw= 'CornflowerBlue' | kw= 'Cornsilk' | kw= 'Crimson' | kw= 'Cyan' | kw= 'DarkBlue' | kw= 'DarkCyan' | kw= 'DarkGoldenRod' | kw= 'DarkGray' | kw= 'DarkGreen' | kw= 'DarkGrey' | kw= 'DarkKhaki' | kw= 'DarkMagenta' | kw= 'DarkOliveGreen' | kw= 'DarkOrchid' | kw= 'DarkRed' | kw= 'DarkSalmo' | kw= 'DarkSeaGreen' | kw= 'DarkSlateBlue' | kw= 'DarkSlateGray' | kw= 'DarkSlateGrey' | kw= 'DarkTurquoise' | kw= 'DarkViolet' | kw= 'Darkorange' | kw= 'DeepPink' | kw= 'DeepSkyBlue' | kw= 'DimGray' | kw= 'DimGrey' | kw= 'DodgerBlue' | kw= 'FireBrick' | kw= 'FloralWhite' | kw= 'ForestGreen' | kw= 'Fuchsia' | kw= 'Gainsboro' | kw= 'GhostWhite' | kw= 'Gold' | kw= 'GoldenRod' | kw= 'Gray' | kw= 'Green' | kw= 'GreenYellow' | kw= 'Grey' | kw= 'HoneyDew' | kw= 'HotPink' | kw= 'IndianRed' | kw= 'Indigo' | kw= 'Ivory' | kw= 'Khaki' | kw= 'Lavender' | kw= 'LavenderBlush' | kw= 'LawnGreen' | kw= 'LemonChiffon' | kw= 'LightBlue' | kw= 'LightCoral' | kw= 'LightCyan' | kw= 'LightGoldenRodYellow' | kw= 'LightGray' | kw= 'LightGreen' | kw= 'LightGrey' | kw= 'LightPink' | kw= 'LightSalmon' | kw= 'LightSeaGreen' | kw= 'LightSkyBlue' | kw= 'LightSlateGray' | kw= 'LightSlateGrey' | kw= 'LightSteelBlue' | kw= 'LightYellow' | kw= 'Lime' | kw= 'LimeGreen' | kw= 'Linen' | kw= 'Magenta' | kw= 'Maroon' | kw= 'MediumAquaMarine' | kw= 'MediumBlue' | kw= 'MediumOrchid' | kw= 'MediumPurple' | kw= 'MediumSeaGreen' | kw= 'MediumSlateBlue' | kw= 'MediumSpringGreen' | kw= 'MediumTurquoise' | kw= 'MediumVioletRed' | kw= 'MidnightBlue' | kw= 'MintCream' | kw= 'MistyRose' | kw= 'Moccasin' | kw= 'NavajoWhite' | kw= 'Navy' | kw= 'OldLace' | kw= 'Olive' | kw= 'OliveDrab' | kw= 'OrangeRed' | kw= 'Orchid' | kw= 'PaleGoldenRod' | kw= 'PaleGreen' | kw= 'PaleTurquoise' | kw= 'PaleVioletRed' | kw= 'PapayaWhip' | kw= 'PeachPuff' | kw= 'Peru' | kw= 'Pink' | kw= 'Plum' | kw= 'PowderBlue' | kw= 'Purple' | kw= 'Red' | kw= 'RosyBrown' | kw= 'RoyalBlue' | kw= 'SaddleBrown' | kw= 'Salmon' | kw= 'SandyBrown' | kw= 'SeaGreen' | kw= 'Sienna' | kw= 'Silver' | kw= 'SkyBlue' | kw= 'SlateBlue' | kw= 'SlateGray' | kw= 'SlateGrey' | kw= 'Snow' | kw= 'SpringGreen' | kw= 'SteelBlue' | kw= 'Tan' | kw= 'Teal' | kw= 'Thistle' | kw= 'Tomato' | kw= 'Turquoise' | kw= 'Violet' | kw= 'Wheat' | kw= 'White' | kw= 'WhiteSmoke' | kw= 'Yellow' | kw= 'YellowGreen' )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:570:2: (kw= '#' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==22) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:571:2: kw= '#'
            	    {
            	    kw=(Token)match(input,22,FOLLOW_22_in_ruleColor1273); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getColorAccess().getNumberSignKeyword_0()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:576:3: (kw= 'AliceBlue' | kw= 'AntiqueWhite' | kw= 'Aqua' | kw= 'Aquamarine' | kw= 'Azure' | kw= 'Beige' | kw= 'Bisque' | kw= 'Black' | kw= 'BlanchedAlmond' | kw= 'Blue' | kw= 'BlueViolet' | kw= 'Brown' | kw= 'BurlyWood' | kw= 'CadetBlue' | kw= 'Chartreuse' | kw= 'Chocolate' | kw= 'Coral' | kw= 'CornflowerBlue' | kw= 'Cornsilk' | kw= 'Crimson' | kw= 'Cyan' | kw= 'DarkBlue' | kw= 'DarkCyan' | kw= 'DarkGoldenRod' | kw= 'DarkGray' | kw= 'DarkGreen' | kw= 'DarkGrey' | kw= 'DarkKhaki' | kw= 'DarkMagenta' | kw= 'DarkOliveGreen' | kw= 'DarkOrchid' | kw= 'DarkRed' | kw= 'DarkSalmo' | kw= 'DarkSeaGreen' | kw= 'DarkSlateBlue' | kw= 'DarkSlateGray' | kw= 'DarkSlateGrey' | kw= 'DarkTurquoise' | kw= 'DarkViolet' | kw= 'Darkorange' | kw= 'DeepPink' | kw= 'DeepSkyBlue' | kw= 'DimGray' | kw= 'DimGrey' | kw= 'DodgerBlue' | kw= 'FireBrick' | kw= 'FloralWhite' | kw= 'ForestGreen' | kw= 'Fuchsia' | kw= 'Gainsboro' | kw= 'GhostWhite' | kw= 'Gold' | kw= 'GoldenRod' | kw= 'Gray' | kw= 'Green' | kw= 'GreenYellow' | kw= 'Grey' | kw= 'HoneyDew' | kw= 'HotPink' | kw= 'IndianRed' | kw= 'Indigo' | kw= 'Ivory' | kw= 'Khaki' | kw= 'Lavender' | kw= 'LavenderBlush' | kw= 'LawnGreen' | kw= 'LemonChiffon' | kw= 'LightBlue' | kw= 'LightCoral' | kw= 'LightCyan' | kw= 'LightGoldenRodYellow' | kw= 'LightGray' | kw= 'LightGreen' | kw= 'LightGrey' | kw= 'LightPink' | kw= 'LightSalmon' | kw= 'LightSeaGreen' | kw= 'LightSkyBlue' | kw= 'LightSlateGray' | kw= 'LightSlateGrey' | kw= 'LightSteelBlue' | kw= 'LightYellow' | kw= 'Lime' | kw= 'LimeGreen' | kw= 'Linen' | kw= 'Magenta' | kw= 'Maroon' | kw= 'MediumAquaMarine' | kw= 'MediumBlue' | kw= 'MediumOrchid' | kw= 'MediumPurple' | kw= 'MediumSeaGreen' | kw= 'MediumSlateBlue' | kw= 'MediumSpringGreen' | kw= 'MediumTurquoise' | kw= 'MediumVioletRed' | kw= 'MidnightBlue' | kw= 'MintCream' | kw= 'MistyRose' | kw= 'Moccasin' | kw= 'NavajoWhite' | kw= 'Navy' | kw= 'OldLace' | kw= 'Olive' | kw= 'OliveDrab' | kw= 'OrangeRed' | kw= 'Orchid' | kw= 'PaleGoldenRod' | kw= 'PaleGreen' | kw= 'PaleTurquoise' | kw= 'PaleVioletRed' | kw= 'PapayaWhip' | kw= 'PeachPuff' | kw= 'Peru' | kw= 'Pink' | kw= 'Plum' | kw= 'PowderBlue' | kw= 'Purple' | kw= 'Red' | kw= 'RosyBrown' | kw= 'RoyalBlue' | kw= 'SaddleBrown' | kw= 'Salmon' | kw= 'SandyBrown' | kw= 'SeaGreen' | kw= 'Sienna' | kw= 'Silver' | kw= 'SkyBlue' | kw= 'SlateBlue' | kw= 'SlateGray' | kw= 'SlateGrey' | kw= 'Snow' | kw= 'SpringGreen' | kw= 'SteelBlue' | kw= 'Tan' | kw= 'Teal' | kw= 'Thistle' | kw= 'Tomato' | kw= 'Turquoise' | kw= 'Violet' | kw= 'Wheat' | kw= 'White' | kw= 'WhiteSmoke' | kw= 'Yellow' | kw= 'YellowGreen' )
            int alt10=145;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt10=1;
                }
                break;
            case 24:
                {
                alt10=2;
                }
                break;
            case 25:
                {
                alt10=3;
                }
                break;
            case 26:
                {
                alt10=4;
                }
                break;
            case 27:
                {
                alt10=5;
                }
                break;
            case 28:
                {
                alt10=6;
                }
                break;
            case 29:
                {
                alt10=7;
                }
                break;
            case 30:
                {
                alt10=8;
                }
                break;
            case 31:
                {
                alt10=9;
                }
                break;
            case 32:
                {
                alt10=10;
                }
                break;
            case 33:
                {
                alt10=11;
                }
                break;
            case 34:
                {
                alt10=12;
                }
                break;
            case 35:
                {
                alt10=13;
                }
                break;
            case 36:
                {
                alt10=14;
                }
                break;
            case 37:
                {
                alt10=15;
                }
                break;
            case 38:
                {
                alt10=16;
                }
                break;
            case 39:
                {
                alt10=17;
                }
                break;
            case 40:
                {
                alt10=18;
                }
                break;
            case 41:
                {
                alt10=19;
                }
                break;
            case 42:
                {
                alt10=20;
                }
                break;
            case 43:
                {
                alt10=21;
                }
                break;
            case 44:
                {
                alt10=22;
                }
                break;
            case 45:
                {
                alt10=23;
                }
                break;
            case 46:
                {
                alt10=24;
                }
                break;
            case 47:
                {
                alt10=25;
                }
                break;
            case 48:
                {
                alt10=26;
                }
                break;
            case 49:
                {
                alt10=27;
                }
                break;
            case 50:
                {
                alt10=28;
                }
                break;
            case 51:
                {
                alt10=29;
                }
                break;
            case 52:
                {
                alt10=30;
                }
                break;
            case 53:
                {
                alt10=31;
                }
                break;
            case 54:
                {
                alt10=32;
                }
                break;
            case 55:
                {
                alt10=33;
                }
                break;
            case 56:
                {
                alt10=34;
                }
                break;
            case 57:
                {
                alt10=35;
                }
                break;
            case 58:
                {
                alt10=36;
                }
                break;
            case 59:
                {
                alt10=37;
                }
                break;
            case 60:
                {
                alt10=38;
                }
                break;
            case 61:
                {
                alt10=39;
                }
                break;
            case 62:
                {
                alt10=40;
                }
                break;
            case 63:
                {
                alt10=41;
                }
                break;
            case 64:
                {
                alt10=42;
                }
                break;
            case 65:
                {
                alt10=43;
                }
                break;
            case 66:
                {
                alt10=44;
                }
                break;
            case 67:
                {
                alt10=45;
                }
                break;
            case 68:
                {
                alt10=46;
                }
                break;
            case 69:
                {
                alt10=47;
                }
                break;
            case 70:
                {
                alt10=48;
                }
                break;
            case 71:
                {
                alt10=49;
                }
                break;
            case 72:
                {
                alt10=50;
                }
                break;
            case 73:
                {
                alt10=51;
                }
                break;
            case 74:
                {
                alt10=52;
                }
                break;
            case 75:
                {
                alt10=53;
                }
                break;
            case 76:
                {
                alt10=54;
                }
                break;
            case 77:
                {
                alt10=55;
                }
                break;
            case 78:
                {
                alt10=56;
                }
                break;
            case 79:
                {
                alt10=57;
                }
                break;
            case 80:
                {
                alt10=58;
                }
                break;
            case 81:
                {
                alt10=59;
                }
                break;
            case 82:
                {
                alt10=60;
                }
                break;
            case 83:
                {
                alt10=61;
                }
                break;
            case 84:
                {
                alt10=62;
                }
                break;
            case 85:
                {
                alt10=63;
                }
                break;
            case 86:
                {
                alt10=64;
                }
                break;
            case 87:
                {
                alt10=65;
                }
                break;
            case 88:
                {
                alt10=66;
                }
                break;
            case 89:
                {
                alt10=67;
                }
                break;
            case 90:
                {
                alt10=68;
                }
                break;
            case 91:
                {
                alt10=69;
                }
                break;
            case 92:
                {
                alt10=70;
                }
                break;
            case 93:
                {
                alt10=71;
                }
                break;
            case 94:
                {
                alt10=72;
                }
                break;
            case 95:
                {
                alt10=73;
                }
                break;
            case 96:
                {
                alt10=74;
                }
                break;
            case 97:
                {
                alt10=75;
                }
                break;
            case 98:
                {
                alt10=76;
                }
                break;
            case 99:
                {
                alt10=77;
                }
                break;
            case 100:
                {
                alt10=78;
                }
                break;
            case 101:
                {
                alt10=79;
                }
                break;
            case 102:
                {
                alt10=80;
                }
                break;
            case 103:
                {
                alt10=81;
                }
                break;
            case 104:
                {
                alt10=82;
                }
                break;
            case 105:
                {
                alt10=83;
                }
                break;
            case 106:
                {
                alt10=84;
                }
                break;
            case 107:
                {
                alt10=85;
                }
                break;
            case 108:
                {
                alt10=86;
                }
                break;
            case 109:
                {
                alt10=87;
                }
                break;
            case 110:
                {
                alt10=88;
                }
                break;
            case 111:
                {
                alt10=89;
                }
                break;
            case 112:
                {
                alt10=90;
                }
                break;
            case 113:
                {
                alt10=91;
                }
                break;
            case 114:
                {
                alt10=92;
                }
                break;
            case 115:
                {
                alt10=93;
                }
                break;
            case 116:
                {
                alt10=94;
                }
                break;
            case 117:
                {
                alt10=95;
                }
                break;
            case 118:
                {
                alt10=96;
                }
                break;
            case 119:
                {
                alt10=97;
                }
                break;
            case 120:
                {
                alt10=98;
                }
                break;
            case 121:
                {
                alt10=99;
                }
                break;
            case 122:
                {
                alt10=100;
                }
                break;
            case 123:
                {
                alt10=101;
                }
                break;
            case 124:
                {
                alt10=102;
                }
                break;
            case 125:
                {
                alt10=103;
                }
                break;
            case 126:
                {
                alt10=104;
                }
                break;
            case 127:
                {
                alt10=105;
                }
                break;
            case 128:
                {
                alt10=106;
                }
                break;
            case 129:
                {
                alt10=107;
                }
                break;
            case 130:
                {
                alt10=108;
                }
                break;
            case 131:
                {
                alt10=109;
                }
                break;
            case 132:
                {
                alt10=110;
                }
                break;
            case 133:
                {
                alt10=111;
                }
                break;
            case 134:
                {
                alt10=112;
                }
                break;
            case 135:
                {
                alt10=113;
                }
                break;
            case 136:
                {
                alt10=114;
                }
                break;
            case 137:
                {
                alt10=115;
                }
                break;
            case 138:
                {
                alt10=116;
                }
                break;
            case 139:
                {
                alt10=117;
                }
                break;
            case 140:
                {
                alt10=118;
                }
                break;
            case 141:
                {
                alt10=119;
                }
                break;
            case 142:
                {
                alt10=120;
                }
                break;
            case 143:
                {
                alt10=121;
                }
                break;
            case 144:
                {
                alt10=122;
                }
                break;
            case 145:
                {
                alt10=123;
                }
                break;
            case 146:
                {
                alt10=124;
                }
                break;
            case 147:
                {
                alt10=125;
                }
                break;
            case 148:
                {
                alt10=126;
                }
                break;
            case 149:
                {
                alt10=127;
                }
                break;
            case 150:
                {
                alt10=128;
                }
                break;
            case 151:
                {
                alt10=129;
                }
                break;
            case 152:
                {
                alt10=130;
                }
                break;
            case 153:
                {
                alt10=131;
                }
                break;
            case 154:
                {
                alt10=132;
                }
                break;
            case 155:
                {
                alt10=133;
                }
                break;
            case 156:
                {
                alt10=134;
                }
                break;
            case 157:
                {
                alt10=135;
                }
                break;
            case 158:
                {
                alt10=136;
                }
                break;
            case 159:
                {
                alt10=137;
                }
                break;
            case 160:
                {
                alt10=138;
                }
                break;
            case 161:
                {
                alt10=139;
                }
                break;
            case 162:
                {
                alt10=140;
                }
                break;
            case 163:
                {
                alt10=141;
                }
                break;
            case 164:
                {
                alt10=142;
                }
                break;
            case 165:
                {
                alt10=143;
                }
                break;
            case 166:
                {
                alt10=144;
                }
                break;
            case 167:
                {
                alt10=145;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:577:2: kw= 'AliceBlue'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleColor1289); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAliceBlueKeyword_1_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:584:2: kw= 'AntiqueWhite'
                    {
                    kw=(Token)match(input,24,FOLLOW_24_in_ruleColor1308); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:591:2: kw= 'Aqua'
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleColor1327); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAquaKeyword_1_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:598:2: kw= 'Aquamarine'
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleColor1346); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAquamarineKeyword_1_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:605:2: kw= 'Azure'
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleColor1365); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAzureKeyword_1_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:612:2: kw= 'Beige'
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleColor1384); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBeigeKeyword_1_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:619:2: kw= 'Bisque'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleColor1403); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBisqueKeyword_1_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:626:2: kw= 'Black'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleColor1422); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlackKeyword_1_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:633:2: kw= 'BlanchedAlmond'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleColor1441); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlanchedAlmondKeyword_1_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:640:2: kw= 'Blue'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleColor1460); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlueKeyword_1_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:647:2: kw= 'BlueViolet'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleColor1479); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlueVioletKeyword_1_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:654:2: kw= 'Brown'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleColor1498); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBrownKeyword_1_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:661:2: kw= 'BurlyWood'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleColor1517); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBurlyWoodKeyword_1_12()); 
                        

                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:668:2: kw= 'CadetBlue'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleColor1536); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCadetBlueKeyword_1_13()); 
                        

                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:675:2: kw= 'Chartreuse'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleColor1555); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getChartreuseKeyword_1_14()); 
                        

                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:682:2: kw= 'Chocolate'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleColor1574); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getChocolateKeyword_1_15()); 
                        

                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:689:2: kw= 'Coral'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleColor1593); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCoralKeyword_1_16()); 
                        

                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:696:2: kw= 'CornflowerBlue'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleColor1612); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCornflowerBlueKeyword_1_17()); 
                        

                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:703:2: kw= 'Cornsilk'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleColor1631); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCornsilkKeyword_1_18()); 
                        

                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:710:2: kw= 'Crimson'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleColor1650); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCrimsonKeyword_1_19()); 
                        

                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:717:2: kw= 'Cyan'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleColor1669); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCyanKeyword_1_20()); 
                        

                    }
                    break;
                case 22 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:724:2: kw= 'DarkBlue'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleColor1688); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkBlueKeyword_1_21()); 
                        

                    }
                    break;
                case 23 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:731:2: kw= 'DarkCyan'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleColor1707); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkCyanKeyword_1_22()); 
                        

                    }
                    break;
                case 24 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:738:2: kw= 'DarkGoldenRod'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleColor1726); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGoldenRodKeyword_1_23()); 
                        

                    }
                    break;
                case 25 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:745:2: kw= 'DarkGray'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleColor1745); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGrayKeyword_1_24()); 
                        

                    }
                    break;
                case 26 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:752:2: kw= 'DarkGreen'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleColor1764); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGreenKeyword_1_25()); 
                        

                    }
                    break;
                case 27 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:759:2: kw= 'DarkGrey'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleColor1783); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGreyKeyword_1_26()); 
                        

                    }
                    break;
                case 28 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:766:2: kw= 'DarkKhaki'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleColor1802); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkKhakiKeyword_1_27()); 
                        

                    }
                    break;
                case 29 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:773:2: kw= 'DarkMagenta'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleColor1821); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkMagentaKeyword_1_28()); 
                        

                    }
                    break;
                case 30 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:780:2: kw= 'DarkOliveGreen'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleColor1840); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkOliveGreenKeyword_1_29()); 
                        

                    }
                    break;
                case 31 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:787:2: kw= 'DarkOrchid'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleColor1859); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkOrchidKeyword_1_30()); 
                        

                    }
                    break;
                case 32 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:794:2: kw= 'DarkRed'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleColor1878); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkRedKeyword_1_31()); 
                        

                    }
                    break;
                case 33 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:801:2: kw= 'DarkSalmo'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleColor1897); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSalmoKeyword_1_32()); 
                        

                    }
                    break;
                case 34 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:808:2: kw= 'DarkSeaGreen'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleColor1916); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSeaGreenKeyword_1_33()); 
                        

                    }
                    break;
                case 35 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:815:2: kw= 'DarkSlateBlue'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleColor1935); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSlateBlueKeyword_1_34()); 
                        

                    }
                    break;
                case 36 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:822:2: kw= 'DarkSlateGray'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleColor1954); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSlateGrayKeyword_1_35()); 
                        

                    }
                    break;
                case 37 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:829:2: kw= 'DarkSlateGrey'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleColor1973); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSlateGreyKeyword_1_36()); 
                        

                    }
                    break;
                case 38 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:836:2: kw= 'DarkTurquoise'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleColor1992); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkTurquoiseKeyword_1_37()); 
                        

                    }
                    break;
                case 39 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:843:2: kw= 'DarkViolet'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleColor2011); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkVioletKeyword_1_38()); 
                        

                    }
                    break;
                case 40 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:850:2: kw= 'Darkorange'
                    {
                    kw=(Token)match(input,62,FOLLOW_62_in_ruleColor2030); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkorangeKeyword_1_39()); 
                        

                    }
                    break;
                case 41 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:857:2: kw= 'DeepPink'
                    {
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleColor2049); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDeepPinkKeyword_1_40()); 
                        

                    }
                    break;
                case 42 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:864:2: kw= 'DeepSkyBlue'
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleColor2068); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDeepSkyBlueKeyword_1_41()); 
                        

                    }
                    break;
                case 43 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:871:2: kw= 'DimGray'
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleColor2087); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDimGrayKeyword_1_42()); 
                        

                    }
                    break;
                case 44 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:878:2: kw= 'DimGrey'
                    {
                    kw=(Token)match(input,66,FOLLOW_66_in_ruleColor2106); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDimGreyKeyword_1_43()); 
                        

                    }
                    break;
                case 45 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:885:2: kw= 'DodgerBlue'
                    {
                    kw=(Token)match(input,67,FOLLOW_67_in_ruleColor2125); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDodgerBlueKeyword_1_44()); 
                        

                    }
                    break;
                case 46 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:892:2: kw= 'FireBrick'
                    {
                    kw=(Token)match(input,68,FOLLOW_68_in_ruleColor2144); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getFireBrickKeyword_1_45()); 
                        

                    }
                    break;
                case 47 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:899:2: kw= 'FloralWhite'
                    {
                    kw=(Token)match(input,69,FOLLOW_69_in_ruleColor2163); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getFloralWhiteKeyword_1_46()); 
                        

                    }
                    break;
                case 48 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:906:2: kw= 'ForestGreen'
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleColor2182); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getForestGreenKeyword_1_47()); 
                        

                    }
                    break;
                case 49 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:913:2: kw= 'Fuchsia'
                    {
                    kw=(Token)match(input,71,FOLLOW_71_in_ruleColor2201); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getFuchsiaKeyword_1_48()); 
                        

                    }
                    break;
                case 50 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:920:2: kw= 'Gainsboro'
                    {
                    kw=(Token)match(input,72,FOLLOW_72_in_ruleColor2220); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGainsboroKeyword_1_49()); 
                        

                    }
                    break;
                case 51 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:927:2: kw= 'GhostWhite'
                    {
                    kw=(Token)match(input,73,FOLLOW_73_in_ruleColor2239); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGhostWhiteKeyword_1_50()); 
                        

                    }
                    break;
                case 52 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:934:2: kw= 'Gold'
                    {
                    kw=(Token)match(input,74,FOLLOW_74_in_ruleColor2258); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGoldKeyword_1_51()); 
                        

                    }
                    break;
                case 53 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:941:2: kw= 'GoldenRod'
                    {
                    kw=(Token)match(input,75,FOLLOW_75_in_ruleColor2277); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGoldenRodKeyword_1_52()); 
                        

                    }
                    break;
                case 54 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:948:2: kw= 'Gray'
                    {
                    kw=(Token)match(input,76,FOLLOW_76_in_ruleColor2296); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGrayKeyword_1_53()); 
                        

                    }
                    break;
                case 55 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:955:2: kw= 'Green'
                    {
                    kw=(Token)match(input,77,FOLLOW_77_in_ruleColor2315); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGreenKeyword_1_54()); 
                        

                    }
                    break;
                case 56 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:962:2: kw= 'GreenYellow'
                    {
                    kw=(Token)match(input,78,FOLLOW_78_in_ruleColor2334); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGreenYellowKeyword_1_55()); 
                        

                    }
                    break;
                case 57 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:969:2: kw= 'Grey'
                    {
                    kw=(Token)match(input,79,FOLLOW_79_in_ruleColor2353); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGreyKeyword_1_56()); 
                        

                    }
                    break;
                case 58 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:976:2: kw= 'HoneyDew'
                    {
                    kw=(Token)match(input,80,FOLLOW_80_in_ruleColor2372); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getHoneyDewKeyword_1_57()); 
                        

                    }
                    break;
                case 59 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:983:2: kw= 'HotPink'
                    {
                    kw=(Token)match(input,81,FOLLOW_81_in_ruleColor2391); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getHotPinkKeyword_1_58()); 
                        

                    }
                    break;
                case 60 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:990:2: kw= 'IndianRed'
                    {
                    kw=(Token)match(input,82,FOLLOW_82_in_ruleColor2410); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getIndianRedKeyword_1_59()); 
                        

                    }
                    break;
                case 61 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:997:2: kw= 'Indigo'
                    {
                    kw=(Token)match(input,83,FOLLOW_83_in_ruleColor2429); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getIndigoKeyword_1_60()); 
                        

                    }
                    break;
                case 62 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1004:2: kw= 'Ivory'
                    {
                    kw=(Token)match(input,84,FOLLOW_84_in_ruleColor2448); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getIvoryKeyword_1_61()); 
                        

                    }
                    break;
                case 63 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1011:2: kw= 'Khaki'
                    {
                    kw=(Token)match(input,85,FOLLOW_85_in_ruleColor2467); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getKhakiKeyword_1_62()); 
                        

                    }
                    break;
                case 64 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1018:2: kw= 'Lavender'
                    {
                    kw=(Token)match(input,86,FOLLOW_86_in_ruleColor2486); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLavenderKeyword_1_63()); 
                        

                    }
                    break;
                case 65 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1025:2: kw= 'LavenderBlush'
                    {
                    kw=(Token)match(input,87,FOLLOW_87_in_ruleColor2505); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLavenderBlushKeyword_1_64()); 
                        

                    }
                    break;
                case 66 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1032:2: kw= 'LawnGreen'
                    {
                    kw=(Token)match(input,88,FOLLOW_88_in_ruleColor2524); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLawnGreenKeyword_1_65()); 
                        

                    }
                    break;
                case 67 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1039:2: kw= 'LemonChiffon'
                    {
                    kw=(Token)match(input,89,FOLLOW_89_in_ruleColor2543); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLemonChiffonKeyword_1_66()); 
                        

                    }
                    break;
                case 68 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1046:2: kw= 'LightBlue'
                    {
                    kw=(Token)match(input,90,FOLLOW_90_in_ruleColor2562); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightBlueKeyword_1_67()); 
                        

                    }
                    break;
                case 69 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1053:2: kw= 'LightCoral'
                    {
                    kw=(Token)match(input,91,FOLLOW_91_in_ruleColor2581); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightCoralKeyword_1_68()); 
                        

                    }
                    break;
                case 70 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1060:2: kw= 'LightCyan'
                    {
                    kw=(Token)match(input,92,FOLLOW_92_in_ruleColor2600); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightCyanKeyword_1_69()); 
                        

                    }
                    break;
                case 71 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1067:2: kw= 'LightGoldenRodYellow'
                    {
                    kw=(Token)match(input,93,FOLLOW_93_in_ruleColor2619); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_1_70()); 
                        

                    }
                    break;
                case 72 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1074:2: kw= 'LightGray'
                    {
                    kw=(Token)match(input,94,FOLLOW_94_in_ruleColor2638); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGrayKeyword_1_71()); 
                        

                    }
                    break;
                case 73 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1081:2: kw= 'LightGreen'
                    {
                    kw=(Token)match(input,95,FOLLOW_95_in_ruleColor2657); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGreenKeyword_1_72()); 
                        

                    }
                    break;
                case 74 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1088:2: kw= 'LightGrey'
                    {
                    kw=(Token)match(input,96,FOLLOW_96_in_ruleColor2676); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGreyKeyword_1_73()); 
                        

                    }
                    break;
                case 75 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1095:2: kw= 'LightPink'
                    {
                    kw=(Token)match(input,97,FOLLOW_97_in_ruleColor2695); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightPinkKeyword_1_74()); 
                        

                    }
                    break;
                case 76 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1102:2: kw= 'LightSalmon'
                    {
                    kw=(Token)match(input,98,FOLLOW_98_in_ruleColor2714); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSalmonKeyword_1_75()); 
                        

                    }
                    break;
                case 77 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1109:2: kw= 'LightSeaGreen'
                    {
                    kw=(Token)match(input,99,FOLLOW_99_in_ruleColor2733); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSeaGreenKeyword_1_76()); 
                        

                    }
                    break;
                case 78 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1116:2: kw= 'LightSkyBlue'
                    {
                    kw=(Token)match(input,100,FOLLOW_100_in_ruleColor2752); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSkyBlueKeyword_1_77()); 
                        

                    }
                    break;
                case 79 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1123:2: kw= 'LightSlateGray'
                    {
                    kw=(Token)match(input,101,FOLLOW_101_in_ruleColor2771); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSlateGrayKeyword_1_78()); 
                        

                    }
                    break;
                case 80 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1130:2: kw= 'LightSlateGrey'
                    {
                    kw=(Token)match(input,102,FOLLOW_102_in_ruleColor2790); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSlateGreyKeyword_1_79()); 
                        

                    }
                    break;
                case 81 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1137:2: kw= 'LightSteelBlue'
                    {
                    kw=(Token)match(input,103,FOLLOW_103_in_ruleColor2809); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSteelBlueKeyword_1_80()); 
                        

                    }
                    break;
                case 82 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1144:2: kw= 'LightYellow'
                    {
                    kw=(Token)match(input,104,FOLLOW_104_in_ruleColor2828); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightYellowKeyword_1_81()); 
                        

                    }
                    break;
                case 83 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1151:2: kw= 'Lime'
                    {
                    kw=(Token)match(input,105,FOLLOW_105_in_ruleColor2847); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLimeKeyword_1_82()); 
                        

                    }
                    break;
                case 84 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1158:2: kw= 'LimeGreen'
                    {
                    kw=(Token)match(input,106,FOLLOW_106_in_ruleColor2866); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLimeGreenKeyword_1_83()); 
                        

                    }
                    break;
                case 85 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1165:2: kw= 'Linen'
                    {
                    kw=(Token)match(input,107,FOLLOW_107_in_ruleColor2885); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLinenKeyword_1_84()); 
                        

                    }
                    break;
                case 86 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1172:2: kw= 'Magenta'
                    {
                    kw=(Token)match(input,108,FOLLOW_108_in_ruleColor2904); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMagentaKeyword_1_85()); 
                        

                    }
                    break;
                case 87 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1179:2: kw= 'Maroon'
                    {
                    kw=(Token)match(input,109,FOLLOW_109_in_ruleColor2923); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMaroonKeyword_1_86()); 
                        

                    }
                    break;
                case 88 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1186:2: kw= 'MediumAquaMarine'
                    {
                    kw=(Token)match(input,110,FOLLOW_110_in_ruleColor2942); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumAquaMarineKeyword_1_87()); 
                        

                    }
                    break;
                case 89 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1193:2: kw= 'MediumBlue'
                    {
                    kw=(Token)match(input,111,FOLLOW_111_in_ruleColor2961); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumBlueKeyword_1_88()); 
                        

                    }
                    break;
                case 90 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1200:2: kw= 'MediumOrchid'
                    {
                    kw=(Token)match(input,112,FOLLOW_112_in_ruleColor2980); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumOrchidKeyword_1_89()); 
                        

                    }
                    break;
                case 91 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1207:2: kw= 'MediumPurple'
                    {
                    kw=(Token)match(input,113,FOLLOW_113_in_ruleColor2999); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumPurpleKeyword_1_90()); 
                        

                    }
                    break;
                case 92 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1214:2: kw= 'MediumSeaGreen'
                    {
                    kw=(Token)match(input,114,FOLLOW_114_in_ruleColor3018); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumSeaGreenKeyword_1_91()); 
                        

                    }
                    break;
                case 93 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1221:2: kw= 'MediumSlateBlue'
                    {
                    kw=(Token)match(input,115,FOLLOW_115_in_ruleColor3037); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumSlateBlueKeyword_1_92()); 
                        

                    }
                    break;
                case 94 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1228:2: kw= 'MediumSpringGreen'
                    {
                    kw=(Token)match(input,116,FOLLOW_116_in_ruleColor3056); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumSpringGreenKeyword_1_93()); 
                        

                    }
                    break;
                case 95 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1235:2: kw= 'MediumTurquoise'
                    {
                    kw=(Token)match(input,117,FOLLOW_117_in_ruleColor3075); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumTurquoiseKeyword_1_94()); 
                        

                    }
                    break;
                case 96 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1242:2: kw= 'MediumVioletRed'
                    {
                    kw=(Token)match(input,118,FOLLOW_118_in_ruleColor3094); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumVioletRedKeyword_1_95()); 
                        

                    }
                    break;
                case 97 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1249:2: kw= 'MidnightBlue'
                    {
                    kw=(Token)match(input,119,FOLLOW_119_in_ruleColor3113); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMidnightBlueKeyword_1_96()); 
                        

                    }
                    break;
                case 98 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1256:2: kw= 'MintCream'
                    {
                    kw=(Token)match(input,120,FOLLOW_120_in_ruleColor3132); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMintCreamKeyword_1_97()); 
                        

                    }
                    break;
                case 99 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1263:2: kw= 'MistyRose'
                    {
                    kw=(Token)match(input,121,FOLLOW_121_in_ruleColor3151); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMistyRoseKeyword_1_98()); 
                        

                    }
                    break;
                case 100 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1270:2: kw= 'Moccasin'
                    {
                    kw=(Token)match(input,122,FOLLOW_122_in_ruleColor3170); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMoccasinKeyword_1_99()); 
                        

                    }
                    break;
                case 101 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1277:2: kw= 'NavajoWhite'
                    {
                    kw=(Token)match(input,123,FOLLOW_123_in_ruleColor3189); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getNavajoWhiteKeyword_1_100()); 
                        

                    }
                    break;
                case 102 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1284:2: kw= 'Navy'
                    {
                    kw=(Token)match(input,124,FOLLOW_124_in_ruleColor3208); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getNavyKeyword_1_101()); 
                        

                    }
                    break;
                case 103 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1291:2: kw= 'OldLace'
                    {
                    kw=(Token)match(input,125,FOLLOW_125_in_ruleColor3227); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOldLaceKeyword_1_102()); 
                        

                    }
                    break;
                case 104 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1298:2: kw= 'Olive'
                    {
                    kw=(Token)match(input,126,FOLLOW_126_in_ruleColor3246); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOliveKeyword_1_103()); 
                        

                    }
                    break;
                case 105 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1305:2: kw= 'OliveDrab'
                    {
                    kw=(Token)match(input,127,FOLLOW_127_in_ruleColor3265); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOliveDrabKeyword_1_104()); 
                        

                    }
                    break;
                case 106 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1312:2: kw= 'OrangeRed'
                    {
                    kw=(Token)match(input,128,FOLLOW_128_in_ruleColor3284); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOrangeRedKeyword_1_105()); 
                        

                    }
                    break;
                case 107 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1319:2: kw= 'Orchid'
                    {
                    kw=(Token)match(input,129,FOLLOW_129_in_ruleColor3303); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOrchidKeyword_1_106()); 
                        

                    }
                    break;
                case 108 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1326:2: kw= 'PaleGoldenRod'
                    {
                    kw=(Token)match(input,130,FOLLOW_130_in_ruleColor3322); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleGoldenRodKeyword_1_107()); 
                        

                    }
                    break;
                case 109 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1333:2: kw= 'PaleGreen'
                    {
                    kw=(Token)match(input,131,FOLLOW_131_in_ruleColor3341); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleGreenKeyword_1_108()); 
                        

                    }
                    break;
                case 110 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1340:2: kw= 'PaleTurquoise'
                    {
                    kw=(Token)match(input,132,FOLLOW_132_in_ruleColor3360); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleTurquoiseKeyword_1_109()); 
                        

                    }
                    break;
                case 111 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1347:2: kw= 'PaleVioletRed'
                    {
                    kw=(Token)match(input,133,FOLLOW_133_in_ruleColor3379); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleVioletRedKeyword_1_110()); 
                        

                    }
                    break;
                case 112 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1354:2: kw= 'PapayaWhip'
                    {
                    kw=(Token)match(input,134,FOLLOW_134_in_ruleColor3398); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPapayaWhipKeyword_1_111()); 
                        

                    }
                    break;
                case 113 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1361:2: kw= 'PeachPuff'
                    {
                    kw=(Token)match(input,135,FOLLOW_135_in_ruleColor3417); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPeachPuffKeyword_1_112()); 
                        

                    }
                    break;
                case 114 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1368:2: kw= 'Peru'
                    {
                    kw=(Token)match(input,136,FOLLOW_136_in_ruleColor3436); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPeruKeyword_1_113()); 
                        

                    }
                    break;
                case 115 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1375:2: kw= 'Pink'
                    {
                    kw=(Token)match(input,137,FOLLOW_137_in_ruleColor3455); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPinkKeyword_1_114()); 
                        

                    }
                    break;
                case 116 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1382:2: kw= 'Plum'
                    {
                    kw=(Token)match(input,138,FOLLOW_138_in_ruleColor3474); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPlumKeyword_1_115()); 
                        

                    }
                    break;
                case 117 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1389:2: kw= 'PowderBlue'
                    {
                    kw=(Token)match(input,139,FOLLOW_139_in_ruleColor3493); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPowderBlueKeyword_1_116()); 
                        

                    }
                    break;
                case 118 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1396:2: kw= 'Purple'
                    {
                    kw=(Token)match(input,140,FOLLOW_140_in_ruleColor3512); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPurpleKeyword_1_117()); 
                        

                    }
                    break;
                case 119 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1403:2: kw= 'Red'
                    {
                    kw=(Token)match(input,141,FOLLOW_141_in_ruleColor3531); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getRedKeyword_1_118()); 
                        

                    }
                    break;
                case 120 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1410:2: kw= 'RosyBrown'
                    {
                    kw=(Token)match(input,142,FOLLOW_142_in_ruleColor3550); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getRosyBrownKeyword_1_119()); 
                        

                    }
                    break;
                case 121 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1417:2: kw= 'RoyalBlue'
                    {
                    kw=(Token)match(input,143,FOLLOW_143_in_ruleColor3569); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getRoyalBlueKeyword_1_120()); 
                        

                    }
                    break;
                case 122 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1424:2: kw= 'SaddleBrown'
                    {
                    kw=(Token)match(input,144,FOLLOW_144_in_ruleColor3588); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSaddleBrownKeyword_1_121()); 
                        

                    }
                    break;
                case 123 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1431:2: kw= 'Salmon'
                    {
                    kw=(Token)match(input,145,FOLLOW_145_in_ruleColor3607); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSalmonKeyword_1_122()); 
                        

                    }
                    break;
                case 124 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1438:2: kw= 'SandyBrown'
                    {
                    kw=(Token)match(input,146,FOLLOW_146_in_ruleColor3626); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSandyBrownKeyword_1_123()); 
                        

                    }
                    break;
                case 125 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1445:2: kw= 'SeaGreen'
                    {
                    kw=(Token)match(input,147,FOLLOW_147_in_ruleColor3645); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSeaGreenKeyword_1_124()); 
                        

                    }
                    break;
                case 126 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1452:2: kw= 'Sienna'
                    {
                    kw=(Token)match(input,148,FOLLOW_148_in_ruleColor3664); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSiennaKeyword_1_125()); 
                        

                    }
                    break;
                case 127 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1459:2: kw= 'Silver'
                    {
                    kw=(Token)match(input,149,FOLLOW_149_in_ruleColor3683); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSilverKeyword_1_126()); 
                        

                    }
                    break;
                case 128 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1466:2: kw= 'SkyBlue'
                    {
                    kw=(Token)match(input,150,FOLLOW_150_in_ruleColor3702); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSkyBlueKeyword_1_127()); 
                        

                    }
                    break;
                case 129 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1473:2: kw= 'SlateBlue'
                    {
                    kw=(Token)match(input,151,FOLLOW_151_in_ruleColor3721); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSlateBlueKeyword_1_128()); 
                        

                    }
                    break;
                case 130 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1480:2: kw= 'SlateGray'
                    {
                    kw=(Token)match(input,152,FOLLOW_152_in_ruleColor3740); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSlateGrayKeyword_1_129()); 
                        

                    }
                    break;
                case 131 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1487:2: kw= 'SlateGrey'
                    {
                    kw=(Token)match(input,153,FOLLOW_153_in_ruleColor3759); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSlateGreyKeyword_1_130()); 
                        

                    }
                    break;
                case 132 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1494:2: kw= 'Snow'
                    {
                    kw=(Token)match(input,154,FOLLOW_154_in_ruleColor3778); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSnowKeyword_1_131()); 
                        

                    }
                    break;
                case 133 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1501:2: kw= 'SpringGreen'
                    {
                    kw=(Token)match(input,155,FOLLOW_155_in_ruleColor3797); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSpringGreenKeyword_1_132()); 
                        

                    }
                    break;
                case 134 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1508:2: kw= 'SteelBlue'
                    {
                    kw=(Token)match(input,156,FOLLOW_156_in_ruleColor3816); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSteelBlueKeyword_1_133()); 
                        

                    }
                    break;
                case 135 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1515:2: kw= 'Tan'
                    {
                    kw=(Token)match(input,157,FOLLOW_157_in_ruleColor3835); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTanKeyword_1_134()); 
                        

                    }
                    break;
                case 136 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1522:2: kw= 'Teal'
                    {
                    kw=(Token)match(input,158,FOLLOW_158_in_ruleColor3854); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTealKeyword_1_135()); 
                        

                    }
                    break;
                case 137 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1529:2: kw= 'Thistle'
                    {
                    kw=(Token)match(input,159,FOLLOW_159_in_ruleColor3873); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getThistleKeyword_1_136()); 
                        

                    }
                    break;
                case 138 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1536:2: kw= 'Tomato'
                    {
                    kw=(Token)match(input,160,FOLLOW_160_in_ruleColor3892); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTomatoKeyword_1_137()); 
                        

                    }
                    break;
                case 139 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1543:2: kw= 'Turquoise'
                    {
                    kw=(Token)match(input,161,FOLLOW_161_in_ruleColor3911); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTurquoiseKeyword_1_138()); 
                        

                    }
                    break;
                case 140 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1550:2: kw= 'Violet'
                    {
                    kw=(Token)match(input,162,FOLLOW_162_in_ruleColor3930); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getVioletKeyword_1_139()); 
                        

                    }
                    break;
                case 141 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1557:2: kw= 'Wheat'
                    {
                    kw=(Token)match(input,163,FOLLOW_163_in_ruleColor3949); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getWheatKeyword_1_140()); 
                        

                    }
                    break;
                case 142 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1564:2: kw= 'White'
                    {
                    kw=(Token)match(input,164,FOLLOW_164_in_ruleColor3968); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getWhiteKeyword_1_141()); 
                        

                    }
                    break;
                case 143 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1571:2: kw= 'WhiteSmoke'
                    {
                    kw=(Token)match(input,165,FOLLOW_165_in_ruleColor3987); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getWhiteSmokeKeyword_1_142()); 
                        

                    }
                    break;
                case 144 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1578:2: kw= 'Yellow'
                    {
                    kw=(Token)match(input,166,FOLLOW_166_in_ruleColor4006); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getYellowKeyword_1_143()); 
                        

                    }
                    break;
                case 145 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1585:2: kw= 'YellowGreen'
                    {
                    kw=(Token)match(input,167,FOLLOW_167_in_ruleColor4025); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getYellowGreenKeyword_1_144()); 
                        

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
    // $ANTLR end "ruleColor"


    // $ANTLR start "entryRuleTitle"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1598:1: entryRuleTitle returns [String current=null] : iv_ruleTitle= ruleTitle EOF ;
    public final String entryRuleTitle() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTitle = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1599:2: (iv_ruleTitle= ruleTitle EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1600:2: iv_ruleTitle= ruleTitle EOF
            {
             newCompositeNode(grammarAccess.getTitleRule()); 
            pushFollow(FOLLOW_ruleTitle_in_entryRuleTitle4067);
            iv_ruleTitle=ruleTitle();

            state._fsp--;

             current =iv_ruleTitle.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTitle4078); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1607:1: ruleTitle returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'title' this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleTitle() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1610:28: ( (kw= 'title' this_ID_1= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1611:1: (kw= 'title' this_ID_1= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1611:1: (kw= 'title' this_ID_1= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1612:2: kw= 'title' this_ID_1= RULE_ID
            {
            kw=(Token)match(input,168,FOLLOW_168_in_ruleTitle4116); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTitleAccess().getTitleKeyword_0()); 
                
            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTitle4131); 

            		current.merge(this_ID_1);
                
             
                newLeafNode(this_ID_1, grammarAccess.getTitleAccess().getIDTerminalRuleCall_1()); 
                

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1632:1: entryRuleLegend returns [String current=null] : iv_ruleLegend= ruleLegend EOF ;
    public final String entryRuleLegend() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLegend = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1633:2: (iv_ruleLegend= ruleLegend EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1634:2: iv_ruleLegend= ruleLegend EOF
            {
             newCompositeNode(grammarAccess.getLegendRule()); 
            pushFollow(FOLLOW_ruleLegend_in_entryRuleLegend4177);
            iv_ruleLegend=ruleLegend();

            state._fsp--;

             current =iv_ruleLegend.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLegend4188); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1641:1: ruleLegend returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'legend' (kw= 'right' | kw= 'left' | kw= 'center' )? ( (this_NEWLINE_4= RULE_NEWLINE this_ID_5= RULE_ID ) | this_NEWLINE_6= RULE_NEWLINE )* this_NEWLINE_7= RULE_NEWLINE kw= 'endlegend' ) ;
    public final AntlrDatatypeRuleToken ruleLegend() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_NEWLINE_4=null;
        Token this_ID_5=null;
        Token this_NEWLINE_6=null;
        Token this_NEWLINE_7=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1644:28: ( (kw= 'legend' (kw= 'right' | kw= 'left' | kw= 'center' )? ( (this_NEWLINE_4= RULE_NEWLINE this_ID_5= RULE_ID ) | this_NEWLINE_6= RULE_NEWLINE )* this_NEWLINE_7= RULE_NEWLINE kw= 'endlegend' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1645:1: (kw= 'legend' (kw= 'right' | kw= 'left' | kw= 'center' )? ( (this_NEWLINE_4= RULE_NEWLINE this_ID_5= RULE_ID ) | this_NEWLINE_6= RULE_NEWLINE )* this_NEWLINE_7= RULE_NEWLINE kw= 'endlegend' )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1645:1: (kw= 'legend' (kw= 'right' | kw= 'left' | kw= 'center' )? ( (this_NEWLINE_4= RULE_NEWLINE this_ID_5= RULE_ID ) | this_NEWLINE_6= RULE_NEWLINE )* this_NEWLINE_7= RULE_NEWLINE kw= 'endlegend' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1646:2: kw= 'legend' (kw= 'right' | kw= 'left' | kw= 'center' )? ( (this_NEWLINE_4= RULE_NEWLINE this_ID_5= RULE_ID ) | this_NEWLINE_6= RULE_NEWLINE )* this_NEWLINE_7= RULE_NEWLINE kw= 'endlegend'
            {
            kw=(Token)match(input,169,FOLLOW_169_in_ruleLegend4226); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getLegendAccess().getLegendKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1651:1: (kw= 'right' | kw= 'left' | kw= 'center' )?
            int alt11=4;
            switch ( input.LA(1) ) {
                case 170:
                    {
                    alt11=1;
                    }
                    break;
                case 171:
                    {
                    alt11=2;
                    }
                    break;
                case 172:
                    {
                    alt11=3;
                    }
                    break;
            }

            switch (alt11) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1652:2: kw= 'right'
                    {
                    kw=(Token)match(input,170,FOLLOW_170_in_ruleLegend4240); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getRightKeyword_1_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1659:2: kw= 'left'
                    {
                    kw=(Token)match(input,171,FOLLOW_171_in_ruleLegend4259); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1666:2: kw= 'center'
                    {
                    kw=(Token)match(input,172,FOLLOW_172_in_ruleLegend4278); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getCenterKeyword_1_2()); 
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1671:3: ( (this_NEWLINE_4= RULE_NEWLINE this_ID_5= RULE_ID ) | this_NEWLINE_6= RULE_NEWLINE )*
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_NEWLINE) ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1==RULE_NEWLINE) ) {
                        alt12=2;
                    }
                    else if ( (LA12_1==RULE_ID) ) {
                        alt12=1;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1671:4: (this_NEWLINE_4= RULE_NEWLINE this_ID_5= RULE_ID )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1671:4: (this_NEWLINE_4= RULE_NEWLINE this_ID_5= RULE_ID )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1671:9: this_NEWLINE_4= RULE_NEWLINE this_ID_5= RULE_ID
            	    {
            	    this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleLegend4297); 

            	    		current.merge(this_NEWLINE_4);
            	        
            	     
            	        newLeafNode(this_NEWLINE_4, grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_0_0()); 
            	        
            	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLegend4317); 

            	    		current.merge(this_ID_5);
            	        
            	     
            	        newLeafNode(this_ID_5, grammarAccess.getLegendAccess().getIDTerminalRuleCall_2_0_1()); 
            	        

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1686:10: this_NEWLINE_6= RULE_NEWLINE
            	    {
            	    this_NEWLINE_6=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleLegend4344); 

            	    		current.merge(this_NEWLINE_6);
            	        
            	     
            	        newLeafNode(this_NEWLINE_6, grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleLegend4366); 

            		current.merge(this_NEWLINE_7);
                
             
                newLeafNode(this_NEWLINE_7, grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_3()); 
                
            kw=(Token)match(input,173,FOLLOW_173_in_ruleLegend4384); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getLegendAccess().getEndlegendKeyword_4()); 
                

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1714:1: entryRuleNewpage returns [String current=null] : iv_ruleNewpage= ruleNewpage EOF ;
    public final String entryRuleNewpage() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNewpage = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1715:2: (iv_ruleNewpage= ruleNewpage EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1716:2: iv_ruleNewpage= ruleNewpage EOF
            {
             newCompositeNode(grammarAccess.getNewpageRule()); 
            pushFollow(FOLLOW_ruleNewpage_in_entryRuleNewpage4425);
            iv_ruleNewpage=ruleNewpage();

            state._fsp--;

             current =iv_ruleNewpage.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNewpage4436); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1723:1: ruleNewpage returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'newpage' (this_ID_1= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleNewpage() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1726:28: ( (kw= 'newpage' (this_ID_1= RULE_ID )? ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1727:1: (kw= 'newpage' (this_ID_1= RULE_ID )? )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1727:1: (kw= 'newpage' (this_ID_1= RULE_ID )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1728:2: kw= 'newpage' (this_ID_1= RULE_ID )?
            {
            kw=(Token)match(input,174,FOLLOW_174_in_ruleNewpage4474); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getNewpageAccess().getNewpageKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1733:1: (this_ID_1= RULE_ID )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1733:6: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNewpage4490); 

                    		current.merge(this_ID_1);
                        
                     
                        newLeafNode(this_ID_1, grammarAccess.getNewpageAccess().getIDTerminalRuleCall_1()); 
                        

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
    // $ANTLR end "ruleNewpage"


    // $ANTLR start "entryRuleAltElse"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1748:1: entryRuleAltElse returns [EObject current=null] : iv_ruleAltElse= ruleAltElse EOF ;
    public final EObject entryRuleAltElse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltElse = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1749:2: (iv_ruleAltElse= ruleAltElse EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1750:2: iv_ruleAltElse= ruleAltElse EOF
            {
             newCompositeNode(grammarAccess.getAltElseRule()); 
            pushFollow(FOLLOW_ruleAltElse_in_entryRuleAltElse4537);
            iv_ruleAltElse=ruleAltElse();

            state._fsp--;

             current =iv_ruleAltElse; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAltElse4547); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1757:1: ruleAltElse returns [EObject current=null] : (otherlv_0= 'alt' this_ID_1= RULE_ID this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= 'end' ) ;
    public final EObject ruleAltElse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_ID_1=null;
        Token this_NEWLINE_2=null;
        Token otherlv_5=null;
        EObject lv_instructions_3_0 = null;

        EObject lv_elses_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1760:28: ( (otherlv_0= 'alt' this_ID_1= RULE_ID this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= 'end' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1761:1: (otherlv_0= 'alt' this_ID_1= RULE_ID this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= 'end' )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1761:1: (otherlv_0= 'alt' this_ID_1= RULE_ID this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= 'end' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1761:3: otherlv_0= 'alt' this_ID_1= RULE_ID this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= 'end'
            {
            otherlv_0=(Token)match(input,175,FOLLOW_175_in_ruleAltElse4584); 

                	newLeafNode(otherlv_0, grammarAccess.getAltElseAccess().getAltKeyword_0());
                
            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAltElse4595); 
             
                newLeafNode(this_ID_1, grammarAccess.getAltElseAccess().getIDTerminalRuleCall_1()); 
                
            this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleAltElse4605); 
             
                newLeafNode(this_NEWLINE_2, grammarAccess.getAltElseAccess().getNEWLINETerminalRuleCall_2()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1773:1: ( (lv_instructions_3_0= ruleInstruction ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=RULE_NEWLINE && LA14_0<=RULE_ID)||(LA14_0>=15 && LA14_0<=21)||(LA14_0>=168 && LA14_0<=169)||(LA14_0>=174 && LA14_0<=175)||(LA14_0>=178 && LA14_0<=183)||(LA14_0>=188 && LA14_0<=189)||(LA14_0>=191 && LA14_0<=194)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1774:1: (lv_instructions_3_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1774:1: (lv_instructions_3_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1775:3: lv_instructions_3_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAltElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleAltElse4625);
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
            	    break loop14;
                }
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1791:3: ( (lv_elses_4_0= ruleElse ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==177) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1792:1: (lv_elses_4_0= ruleElse )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1792:1: (lv_elses_4_0= ruleElse )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1793:3: lv_elses_4_0= ruleElse
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAltElseAccess().getElsesElseParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleElse_in_ruleAltElse4647);
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
            	    break loop15;
                }
            } while (true);

            otherlv_5=(Token)match(input,176,FOLLOW_176_in_ruleAltElse4660); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1821:1: entryRuleElse returns [EObject current=null] : iv_ruleElse= ruleElse EOF ;
    public final EObject entryRuleElse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElse = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1822:2: (iv_ruleElse= ruleElse EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1823:2: iv_ruleElse= ruleElse EOF
            {
             newCompositeNode(grammarAccess.getElseRule()); 
            pushFollow(FOLLOW_ruleElse_in_entryRuleElse4696);
            iv_ruleElse=ruleElse();

            state._fsp--;

             current =iv_ruleElse; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElse4706); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1830:1: ruleElse returns [EObject current=null] : (otherlv_0= 'else' this_ID_1= RULE_ID this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ) ;
    public final EObject ruleElse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_ID_1=null;
        Token this_NEWLINE_2=null;
        EObject lv_instructions_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1833:28: ( (otherlv_0= 'else' this_ID_1= RULE_ID this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1834:1: (otherlv_0= 'else' this_ID_1= RULE_ID this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1834:1: (otherlv_0= 'else' this_ID_1= RULE_ID this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1834:3: otherlv_0= 'else' this_ID_1= RULE_ID this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )*
            {
            otherlv_0=(Token)match(input,177,FOLLOW_177_in_ruleElse4743); 

                	newLeafNode(otherlv_0, grammarAccess.getElseAccess().getElseKeyword_0());
                
            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleElse4754); 
             
                newLeafNode(this_ID_1, grammarAccess.getElseAccess().getIDTerminalRuleCall_1()); 
                
            this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleElse4764); 
             
                newLeafNode(this_NEWLINE_2, grammarAccess.getElseAccess().getNEWLINETerminalRuleCall_2()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1846:1: ( (lv_instructions_3_0= ruleInstruction ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=RULE_NEWLINE && LA16_0<=RULE_ID)||(LA16_0>=15 && LA16_0<=21)||(LA16_0>=168 && LA16_0<=169)||(LA16_0>=174 && LA16_0<=175)||(LA16_0>=178 && LA16_0<=183)||(LA16_0>=188 && LA16_0<=189)||(LA16_0>=191 && LA16_0<=194)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1847:1: (lv_instructions_3_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1847:1: (lv_instructions_3_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1848:3: lv_instructions_3_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleElse4784);
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
            	    break loop16;
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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1872:1: entryRuleGroupingMessages returns [EObject current=null] : iv_ruleGroupingMessages= ruleGroupingMessages EOF ;
    public final EObject entryRuleGroupingMessages() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupingMessages = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1873:2: (iv_ruleGroupingMessages= ruleGroupingMessages EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1874:2: iv_ruleGroupingMessages= ruleGroupingMessages EOF
            {
             newCompositeNode(grammarAccess.getGroupingMessagesRule()); 
            pushFollow(FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages4821);
            iv_ruleGroupingMessages=ruleGroupingMessages();

            state._fsp--;

             current =iv_ruleGroupingMessages; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroupingMessages4831); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1881:1: ruleGroupingMessages returns [EObject current=null] : ( (otherlv_0= 'opt' | otherlv_1= 'loop' | otherlv_2= 'par' | otherlv_3= 'break' | otherlv_4= 'critical' ) this_ID_5= RULE_ID this_NEWLINE_6= RULE_NEWLINE ( (lv_instructions_7_0= ruleInstruction ) )* otherlv_8= 'end' ) ;
    public final EObject ruleGroupingMessages() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token this_ID_5=null;
        Token this_NEWLINE_6=null;
        Token otherlv_8=null;
        EObject lv_instructions_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1884:28: ( ( (otherlv_0= 'opt' | otherlv_1= 'loop' | otherlv_2= 'par' | otherlv_3= 'break' | otherlv_4= 'critical' ) this_ID_5= RULE_ID this_NEWLINE_6= RULE_NEWLINE ( (lv_instructions_7_0= ruleInstruction ) )* otherlv_8= 'end' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1885:1: ( (otherlv_0= 'opt' | otherlv_1= 'loop' | otherlv_2= 'par' | otherlv_3= 'break' | otherlv_4= 'critical' ) this_ID_5= RULE_ID this_NEWLINE_6= RULE_NEWLINE ( (lv_instructions_7_0= ruleInstruction ) )* otherlv_8= 'end' )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1885:1: ( (otherlv_0= 'opt' | otherlv_1= 'loop' | otherlv_2= 'par' | otherlv_3= 'break' | otherlv_4= 'critical' ) this_ID_5= RULE_ID this_NEWLINE_6= RULE_NEWLINE ( (lv_instructions_7_0= ruleInstruction ) )* otherlv_8= 'end' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1885:2: (otherlv_0= 'opt' | otherlv_1= 'loop' | otherlv_2= 'par' | otherlv_3= 'break' | otherlv_4= 'critical' ) this_ID_5= RULE_ID this_NEWLINE_6= RULE_NEWLINE ( (lv_instructions_7_0= ruleInstruction ) )* otherlv_8= 'end'
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1885:2: (otherlv_0= 'opt' | otherlv_1= 'loop' | otherlv_2= 'par' | otherlv_3= 'break' | otherlv_4= 'critical' )
            int alt17=5;
            switch ( input.LA(1) ) {
            case 178:
                {
                alt17=1;
                }
                break;
            case 179:
                {
                alt17=2;
                }
                break;
            case 180:
                {
                alt17=3;
                }
                break;
            case 181:
                {
                alt17=4;
                }
                break;
            case 182:
                {
                alt17=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1885:4: otherlv_0= 'opt'
                    {
                    otherlv_0=(Token)match(input,178,FOLLOW_178_in_ruleGroupingMessages4869); 

                        	newLeafNode(otherlv_0, grammarAccess.getGroupingMessagesAccess().getOptKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1890:7: otherlv_1= 'loop'
                    {
                    otherlv_1=(Token)match(input,179,FOLLOW_179_in_ruleGroupingMessages4887); 

                        	newLeafNode(otherlv_1, grammarAccess.getGroupingMessagesAccess().getLoopKeyword_0_1());
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1895:7: otherlv_2= 'par'
                    {
                    otherlv_2=(Token)match(input,180,FOLLOW_180_in_ruleGroupingMessages4905); 

                        	newLeafNode(otherlv_2, grammarAccess.getGroupingMessagesAccess().getParKeyword_0_2());
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1900:7: otherlv_3= 'break'
                    {
                    otherlv_3=(Token)match(input,181,FOLLOW_181_in_ruleGroupingMessages4923); 

                        	newLeafNode(otherlv_3, grammarAccess.getGroupingMessagesAccess().getBreakKeyword_0_3());
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1905:7: otherlv_4= 'critical'
                    {
                    otherlv_4=(Token)match(input,182,FOLLOW_182_in_ruleGroupingMessages4941); 

                        	newLeafNode(otherlv_4, grammarAccess.getGroupingMessagesAccess().getCriticalKeyword_0_4());
                        

                    }
                    break;

            }

            this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGroupingMessages4953); 
             
                newLeafNode(this_ID_5, grammarAccess.getGroupingMessagesAccess().getIDTerminalRuleCall_1()); 
                
            this_NEWLINE_6=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleGroupingMessages4963); 
             
                newLeafNode(this_NEWLINE_6, grammarAccess.getGroupingMessagesAccess().getNEWLINETerminalRuleCall_2()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1917:1: ( (lv_instructions_7_0= ruleInstruction ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=RULE_NEWLINE && LA18_0<=RULE_ID)||(LA18_0>=15 && LA18_0<=21)||(LA18_0>=168 && LA18_0<=169)||(LA18_0>=174 && LA18_0<=175)||(LA18_0>=178 && LA18_0<=183)||(LA18_0>=188 && LA18_0<=189)||(LA18_0>=191 && LA18_0<=194)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1918:1: (lv_instructions_7_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1918:1: (lv_instructions_7_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1919:3: lv_instructions_7_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGroupingMessagesAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleGroupingMessages4983);
            	    lv_instructions_7_0=ruleInstruction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGroupingMessagesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"instructions",
            	            		lv_instructions_7_0, 
            	            		"Instruction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_8=(Token)match(input,176,FOLLOW_176_in_ruleGroupingMessages4996); 

                	newLeafNode(otherlv_8, grammarAccess.getGroupingMessagesAccess().getEndKeyword_4());
                

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1949:1: entryRuleNote returns [String current=null] : iv_ruleNote= ruleNote EOF ;
    public final String entryRuleNote() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNote = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1950:2: (iv_ruleNote= ruleNote EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1951:2: iv_ruleNote= ruleNote EOF
            {
             newCompositeNode(grammarAccess.getNoteRule()); 
            pushFollow(FOLLOW_ruleNote_in_entryRuleNote5035);
            iv_ruleNote=ruleNote();

            state._fsp--;

             current =iv_ruleNote.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNote5046); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1958:1: ruleNote returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'note' ( (kw= 'right' (kw= 'of' this_ID_3= RULE_ID (kw= ',' this_ID_5= RULE_ID )* )? ) | (kw= 'left' (kw= 'of' this_ID_8= RULE_ID (kw= ',' this_ID_10= RULE_ID )* )? ) | (kw= 'over' this_ID_12= RULE_ID (kw= ',' this_ID_14= RULE_ID )* ) ) (this_Color_15= ruleColor )* ( (kw= ':' this_ID_17= RULE_ID ) | ( (this_NEWLINE_18= RULE_NEWLINE this_ID_19= RULE_ID )* this_NEWLINE_20= RULE_NEWLINE kw= 'end note' ) ) ) ;
    public final AntlrDatatypeRuleToken ruleNote() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_3=null;
        Token this_ID_5=null;
        Token this_ID_8=null;
        Token this_ID_10=null;
        Token this_ID_12=null;
        Token this_ID_14=null;
        Token this_ID_17=null;
        Token this_NEWLINE_18=null;
        Token this_ID_19=null;
        Token this_NEWLINE_20=null;
        AntlrDatatypeRuleToken this_Color_15 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1961:28: ( (kw= 'note' ( (kw= 'right' (kw= 'of' this_ID_3= RULE_ID (kw= ',' this_ID_5= RULE_ID )* )? ) | (kw= 'left' (kw= 'of' this_ID_8= RULE_ID (kw= ',' this_ID_10= RULE_ID )* )? ) | (kw= 'over' this_ID_12= RULE_ID (kw= ',' this_ID_14= RULE_ID )* ) ) (this_Color_15= ruleColor )* ( (kw= ':' this_ID_17= RULE_ID ) | ( (this_NEWLINE_18= RULE_NEWLINE this_ID_19= RULE_ID )* this_NEWLINE_20= RULE_NEWLINE kw= 'end note' ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1962:1: (kw= 'note' ( (kw= 'right' (kw= 'of' this_ID_3= RULE_ID (kw= ',' this_ID_5= RULE_ID )* )? ) | (kw= 'left' (kw= 'of' this_ID_8= RULE_ID (kw= ',' this_ID_10= RULE_ID )* )? ) | (kw= 'over' this_ID_12= RULE_ID (kw= ',' this_ID_14= RULE_ID )* ) ) (this_Color_15= ruleColor )* ( (kw= ':' this_ID_17= RULE_ID ) | ( (this_NEWLINE_18= RULE_NEWLINE this_ID_19= RULE_ID )* this_NEWLINE_20= RULE_NEWLINE kw= 'end note' ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1962:1: (kw= 'note' ( (kw= 'right' (kw= 'of' this_ID_3= RULE_ID (kw= ',' this_ID_5= RULE_ID )* )? ) | (kw= 'left' (kw= 'of' this_ID_8= RULE_ID (kw= ',' this_ID_10= RULE_ID )* )? ) | (kw= 'over' this_ID_12= RULE_ID (kw= ',' this_ID_14= RULE_ID )* ) ) (this_Color_15= ruleColor )* ( (kw= ':' this_ID_17= RULE_ID ) | ( (this_NEWLINE_18= RULE_NEWLINE this_ID_19= RULE_ID )* this_NEWLINE_20= RULE_NEWLINE kw= 'end note' ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1963:2: kw= 'note' ( (kw= 'right' (kw= 'of' this_ID_3= RULE_ID (kw= ',' this_ID_5= RULE_ID )* )? ) | (kw= 'left' (kw= 'of' this_ID_8= RULE_ID (kw= ',' this_ID_10= RULE_ID )* )? ) | (kw= 'over' this_ID_12= RULE_ID (kw= ',' this_ID_14= RULE_ID )* ) ) (this_Color_15= ruleColor )* ( (kw= ':' this_ID_17= RULE_ID ) | ( (this_NEWLINE_18= RULE_NEWLINE this_ID_19= RULE_ID )* this_NEWLINE_20= RULE_NEWLINE kw= 'end note' ) )
            {
            kw=(Token)match(input,183,FOLLOW_183_in_ruleNote5084); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getNoteAccess().getNoteKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1968:1: ( (kw= 'right' (kw= 'of' this_ID_3= RULE_ID (kw= ',' this_ID_5= RULE_ID )* )? ) | (kw= 'left' (kw= 'of' this_ID_8= RULE_ID (kw= ',' this_ID_10= RULE_ID )* )? ) | (kw= 'over' this_ID_12= RULE_ID (kw= ',' this_ID_14= RULE_ID )* ) )
            int alt24=3;
            switch ( input.LA(1) ) {
            case 170:
                {
                alt24=1;
                }
                break;
            case 171:
                {
                alt24=2;
                }
                break;
            case 186:
                {
                alt24=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1968:2: (kw= 'right' (kw= 'of' this_ID_3= RULE_ID (kw= ',' this_ID_5= RULE_ID )* )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1968:2: (kw= 'right' (kw= 'of' this_ID_3= RULE_ID (kw= ',' this_ID_5= RULE_ID )* )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1969:2: kw= 'right' (kw= 'of' this_ID_3= RULE_ID (kw= ',' this_ID_5= RULE_ID )* )?
                    {
                    kw=(Token)match(input,170,FOLLOW_170_in_ruleNote5099); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNoteAccess().getRightKeyword_1_0_0()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1974:1: (kw= 'of' this_ID_3= RULE_ID (kw= ',' this_ID_5= RULE_ID )* )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==184) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1975:2: kw= 'of' this_ID_3= RULE_ID (kw= ',' this_ID_5= RULE_ID )*
                            {
                            kw=(Token)match(input,184,FOLLOW_184_in_ruleNote5113); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getNoteAccess().getOfKeyword_1_0_1_0()); 
                                
                            this_ID_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote5128); 

                            		current.merge(this_ID_3);
                                
                             
                                newLeafNode(this_ID_3, grammarAccess.getNoteAccess().getIDTerminalRuleCall_1_0_1_1()); 
                                
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1987:1: (kw= ',' this_ID_5= RULE_ID )*
                            loop19:
                            do {
                                int alt19=2;
                                int LA19_0 = input.LA(1);

                                if ( (LA19_0==185) ) {
                                    alt19=1;
                                }


                                switch (alt19) {
                            	case 1 :
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1988:2: kw= ',' this_ID_5= RULE_ID
                            	    {
                            	    kw=(Token)match(input,185,FOLLOW_185_in_ruleNote5147); 

                            	            current.merge(kw);
                            	            newLeafNode(kw, grammarAccess.getNoteAccess().getCommaKeyword_1_0_1_2_0()); 
                            	        
                            	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote5162); 

                            	    		current.merge(this_ID_5);
                            	        
                            	     
                            	        newLeafNode(this_ID_5, grammarAccess.getNoteAccess().getIDTerminalRuleCall_1_0_1_2_1()); 
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop19;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2001:6: (kw= 'left' (kw= 'of' this_ID_8= RULE_ID (kw= ',' this_ID_10= RULE_ID )* )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2001:6: (kw= 'left' (kw= 'of' this_ID_8= RULE_ID (kw= ',' this_ID_10= RULE_ID )* )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2002:2: kw= 'left' (kw= 'of' this_ID_8= RULE_ID (kw= ',' this_ID_10= RULE_ID )* )?
                    {
                    kw=(Token)match(input,171,FOLLOW_171_in_ruleNote5192); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNoteAccess().getLeftKeyword_1_1_0()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2007:1: (kw= 'of' this_ID_8= RULE_ID (kw= ',' this_ID_10= RULE_ID )* )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==184) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2008:2: kw= 'of' this_ID_8= RULE_ID (kw= ',' this_ID_10= RULE_ID )*
                            {
                            kw=(Token)match(input,184,FOLLOW_184_in_ruleNote5206); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getNoteAccess().getOfKeyword_1_1_1_0()); 
                                
                            this_ID_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote5221); 

                            		current.merge(this_ID_8);
                                
                             
                                newLeafNode(this_ID_8, grammarAccess.getNoteAccess().getIDTerminalRuleCall_1_1_1_1()); 
                                
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2020:1: (kw= ',' this_ID_10= RULE_ID )*
                            loop21:
                            do {
                                int alt21=2;
                                int LA21_0 = input.LA(1);

                                if ( (LA21_0==185) ) {
                                    alt21=1;
                                }


                                switch (alt21) {
                            	case 1 :
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2021:2: kw= ',' this_ID_10= RULE_ID
                            	    {
                            	    kw=(Token)match(input,185,FOLLOW_185_in_ruleNote5240); 

                            	            current.merge(kw);
                            	            newLeafNode(kw, grammarAccess.getNoteAccess().getCommaKeyword_1_1_1_2_0()); 
                            	        
                            	    this_ID_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote5255); 

                            	    		current.merge(this_ID_10);
                            	        
                            	     
                            	        newLeafNode(this_ID_10, grammarAccess.getNoteAccess().getIDTerminalRuleCall_1_1_1_2_1()); 
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop21;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2034:6: (kw= 'over' this_ID_12= RULE_ID (kw= ',' this_ID_14= RULE_ID )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2034:6: (kw= 'over' this_ID_12= RULE_ID (kw= ',' this_ID_14= RULE_ID )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2035:2: kw= 'over' this_ID_12= RULE_ID (kw= ',' this_ID_14= RULE_ID )*
                    {
                    kw=(Token)match(input,186,FOLLOW_186_in_ruleNote5285); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNoteAccess().getOverKeyword_1_2_0()); 
                        
                    this_ID_12=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote5300); 

                    		current.merge(this_ID_12);
                        
                     
                        newLeafNode(this_ID_12, grammarAccess.getNoteAccess().getIDTerminalRuleCall_1_2_1()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2047:1: (kw= ',' this_ID_14= RULE_ID )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==185) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2048:2: kw= ',' this_ID_14= RULE_ID
                    	    {
                    	    kw=(Token)match(input,185,FOLLOW_185_in_ruleNote5319); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getNoteAccess().getCommaKeyword_1_2_2_0()); 
                    	        
                    	    this_ID_14=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote5334); 

                    	    		current.merge(this_ID_14);
                    	        
                    	     
                    	        newLeafNode(this_ID_14, grammarAccess.getNoteAccess().getIDTerminalRuleCall_1_2_2_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2060:5: (this_Color_15= ruleColor )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==22) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2061:5: this_Color_15= ruleColor
            	    {
            	     
            	            newCompositeNode(grammarAccess.getNoteAccess().getColorParserRuleCall_2()); 
            	        
            	    pushFollow(FOLLOW_ruleColor_in_ruleNote5366);
            	    this_Color_15=ruleColor();

            	    state._fsp--;


            	    		current.merge(this_Color_15);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2071:3: ( (kw= ':' this_ID_17= RULE_ID ) | ( (this_NEWLINE_18= RULE_NEWLINE this_ID_19= RULE_ID )* this_NEWLINE_20= RULE_NEWLINE kw= 'end note' ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==14) ) {
                alt27=1;
            }
            else if ( (LA27_0==RULE_NEWLINE) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2071:4: (kw= ':' this_ID_17= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2071:4: (kw= ':' this_ID_17= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2072:2: kw= ':' this_ID_17= RULE_ID
                    {
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleNote5388); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNoteAccess().getColonKeyword_3_0_0()); 
                        
                    this_ID_17=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote5403); 

                    		current.merge(this_ID_17);
                        
                     
                        newLeafNode(this_ID_17, grammarAccess.getNoteAccess().getIDTerminalRuleCall_3_0_1()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2085:6: ( (this_NEWLINE_18= RULE_NEWLINE this_ID_19= RULE_ID )* this_NEWLINE_20= RULE_NEWLINE kw= 'end note' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2085:6: ( (this_NEWLINE_18= RULE_NEWLINE this_ID_19= RULE_ID )* this_NEWLINE_20= RULE_NEWLINE kw= 'end note' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2085:7: (this_NEWLINE_18= RULE_NEWLINE this_ID_19= RULE_ID )* this_NEWLINE_20= RULE_NEWLINE kw= 'end note'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2085:7: (this_NEWLINE_18= RULE_NEWLINE this_ID_19= RULE_ID )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==RULE_NEWLINE) ) {
                            int LA26_1 = input.LA(2);

                            if ( (LA26_1==RULE_ID) ) {
                                alt26=1;
                            }


                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2085:12: this_NEWLINE_18= RULE_NEWLINE this_ID_19= RULE_ID
                    	    {
                    	    this_NEWLINE_18=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleNote5432); 

                    	    		current.merge(this_NEWLINE_18);
                    	        
                    	     
                    	        newLeafNode(this_NEWLINE_18, grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_3_1_0_0()); 
                    	        
                    	    this_ID_19=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote5452); 

                    	    		current.merge(this_ID_19);
                    	        
                    	     
                    	        newLeafNode(this_ID_19, grammarAccess.getNoteAccess().getIDTerminalRuleCall_3_1_0_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    this_NEWLINE_20=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleNote5474); 

                    		current.merge(this_NEWLINE_20);
                        
                     
                        newLeafNode(this_NEWLINE_20, grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_3_1_1()); 
                        
                    kw=(Token)match(input,187,FOLLOW_187_in_ruleNote5492); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNoteAccess().getEndNoteKeyword_3_1_2()); 
                        

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2120:1: entryRuleDivider returns [String current=null] : iv_ruleDivider= ruleDivider EOF ;
    public final String entryRuleDivider() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDivider = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2121:2: (iv_ruleDivider= ruleDivider EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2122:2: iv_ruleDivider= ruleDivider EOF
            {
             newCompositeNode(grammarAccess.getDividerRule()); 
            pushFollow(FOLLOW_ruleDivider_in_entryRuleDivider5535);
            iv_ruleDivider=ruleDivider();

            state._fsp--;

             current =iv_ruleDivider.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDivider5546); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2129:1: ruleDivider returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' this_ID_1= RULE_ID kw= '==' ) ;
    public final AntlrDatatypeRuleToken ruleDivider() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2132:28: ( (kw= '==' this_ID_1= RULE_ID kw= '==' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2133:1: (kw= '==' this_ID_1= RULE_ID kw= '==' )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2133:1: (kw= '==' this_ID_1= RULE_ID kw= '==' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2134:2: kw= '==' this_ID_1= RULE_ID kw= '=='
            {
            kw=(Token)match(input,188,FOLLOW_188_in_ruleDivider5584); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDividerAccess().getEqualsSignEqualsSignKeyword_0()); 
                
            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDivider5599); 

            		current.merge(this_ID_1);
                
             
                newLeafNode(this_ID_1, grammarAccess.getDividerAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,188,FOLLOW_188_in_ruleDivider5617); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2160:1: entryRuleReference returns [String current=null] : iv_ruleReference= ruleReference EOF ;
    public final String entryRuleReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReference = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2161:2: (iv_ruleReference= ruleReference EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2162:2: iv_ruleReference= ruleReference EOF
            {
             newCompositeNode(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference5658);
            iv_ruleReference=ruleReference();

            state._fsp--;

             current =iv_ruleReference.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference5669); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2169:1: ruleReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'ref over' this_ID_1= RULE_ID (kw= ',' this_ID_3= RULE_ID )* ( (kw= ':' this_ID_5= RULE_ID ) | ( (this_NEWLINE_6= RULE_NEWLINE this_ID_7= RULE_ID )* this_NEWLINE_8= RULE_NEWLINE kw= 'end ref' ) ) ) ;
    public final AntlrDatatypeRuleToken ruleReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;
        Token this_ID_3=null;
        Token this_ID_5=null;
        Token this_NEWLINE_6=null;
        Token this_ID_7=null;
        Token this_NEWLINE_8=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2172:28: ( (kw= 'ref over' this_ID_1= RULE_ID (kw= ',' this_ID_3= RULE_ID )* ( (kw= ':' this_ID_5= RULE_ID ) | ( (this_NEWLINE_6= RULE_NEWLINE this_ID_7= RULE_ID )* this_NEWLINE_8= RULE_NEWLINE kw= 'end ref' ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2173:1: (kw= 'ref over' this_ID_1= RULE_ID (kw= ',' this_ID_3= RULE_ID )* ( (kw= ':' this_ID_5= RULE_ID ) | ( (this_NEWLINE_6= RULE_NEWLINE this_ID_7= RULE_ID )* this_NEWLINE_8= RULE_NEWLINE kw= 'end ref' ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2173:1: (kw= 'ref over' this_ID_1= RULE_ID (kw= ',' this_ID_3= RULE_ID )* ( (kw= ':' this_ID_5= RULE_ID ) | ( (this_NEWLINE_6= RULE_NEWLINE this_ID_7= RULE_ID )* this_NEWLINE_8= RULE_NEWLINE kw= 'end ref' ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2174:2: kw= 'ref over' this_ID_1= RULE_ID (kw= ',' this_ID_3= RULE_ID )* ( (kw= ':' this_ID_5= RULE_ID ) | ( (this_NEWLINE_6= RULE_NEWLINE this_ID_7= RULE_ID )* this_NEWLINE_8= RULE_NEWLINE kw= 'end ref' ) )
            {
            kw=(Token)match(input,189,FOLLOW_189_in_ruleReference5707); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getReferenceAccess().getRefOverKeyword_0()); 
                
            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference5722); 

            		current.merge(this_ID_1);
                
             
                newLeafNode(this_ID_1, grammarAccess.getReferenceAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2186:1: (kw= ',' this_ID_3= RULE_ID )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==185) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2187:2: kw= ',' this_ID_3= RULE_ID
            	    {
            	    kw=(Token)match(input,185,FOLLOW_185_in_ruleReference5741); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getReferenceAccess().getCommaKeyword_2_0()); 
            	        
            	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference5756); 

            	    		current.merge(this_ID_3);
            	        
            	     
            	        newLeafNode(this_ID_3, grammarAccess.getReferenceAccess().getIDTerminalRuleCall_2_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2199:3: ( (kw= ':' this_ID_5= RULE_ID ) | ( (this_NEWLINE_6= RULE_NEWLINE this_ID_7= RULE_ID )* this_NEWLINE_8= RULE_NEWLINE kw= 'end ref' ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==14) ) {
                alt30=1;
            }
            else if ( (LA30_0==RULE_NEWLINE) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2199:4: (kw= ':' this_ID_5= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2199:4: (kw= ':' this_ID_5= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2200:2: kw= ':' this_ID_5= RULE_ID
                    {
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleReference5778); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getReferenceAccess().getColonKeyword_3_0_0()); 
                        
                    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference5793); 

                    		current.merge(this_ID_5);
                        
                     
                        newLeafNode(this_ID_5, grammarAccess.getReferenceAccess().getIDTerminalRuleCall_3_0_1()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2213:6: ( (this_NEWLINE_6= RULE_NEWLINE this_ID_7= RULE_ID )* this_NEWLINE_8= RULE_NEWLINE kw= 'end ref' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2213:6: ( (this_NEWLINE_6= RULE_NEWLINE this_ID_7= RULE_ID )* this_NEWLINE_8= RULE_NEWLINE kw= 'end ref' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2213:7: (this_NEWLINE_6= RULE_NEWLINE this_ID_7= RULE_ID )* this_NEWLINE_8= RULE_NEWLINE kw= 'end ref'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2213:7: (this_NEWLINE_6= RULE_NEWLINE this_ID_7= RULE_ID )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==RULE_NEWLINE) ) {
                            int LA29_1 = input.LA(2);

                            if ( (LA29_1==RULE_ID) ) {
                                alt29=1;
                            }


                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2213:12: this_NEWLINE_6= RULE_NEWLINE this_ID_7= RULE_ID
                    	    {
                    	    this_NEWLINE_6=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleReference5822); 

                    	    		current.merge(this_NEWLINE_6);
                    	        
                    	     
                    	        newLeafNode(this_NEWLINE_6, grammarAccess.getReferenceAccess().getNEWLINETerminalRuleCall_3_1_0_0()); 
                    	        
                    	    this_ID_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference5842); 

                    	    		current.merge(this_ID_7);
                    	        
                    	     
                    	        newLeafNode(this_ID_7, grammarAccess.getReferenceAccess().getIDTerminalRuleCall_3_1_0_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    this_NEWLINE_8=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleReference5864); 

                    		current.merge(this_NEWLINE_8);
                        
                     
                        newLeafNode(this_NEWLINE_8, grammarAccess.getReferenceAccess().getNEWLINETerminalRuleCall_3_1_1()); 
                        
                    kw=(Token)match(input,190,FOLLOW_190_in_ruleReference5882); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getReferenceAccess().getEndRefKeyword_3_1_2()); 
                        

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2248:1: entryRuleDelay returns [String current=null] : iv_ruleDelay= ruleDelay EOF ;
    public final String entryRuleDelay() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDelay = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2249:2: (iv_ruleDelay= ruleDelay EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2250:2: iv_ruleDelay= ruleDelay EOF
            {
             newCompositeNode(grammarAccess.getDelayRule()); 
            pushFollow(FOLLOW_ruleDelay_in_entryRuleDelay5925);
            iv_ruleDelay=ruleDelay();

            state._fsp--;

             current =iv_ruleDelay.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDelay5936); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2257:1: ruleDelay returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '...' (this_ID_1= RULE_ID )* kw= '...' ) ;
    public final AntlrDatatypeRuleToken ruleDelay() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2260:28: ( (kw= '...' (this_ID_1= RULE_ID )* kw= '...' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2261:1: (kw= '...' (this_ID_1= RULE_ID )* kw= '...' )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2261:1: (kw= '...' (this_ID_1= RULE_ID )* kw= '...' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2262:2: kw= '...' (this_ID_1= RULE_ID )* kw= '...'
            {
            kw=(Token)match(input,191,FOLLOW_191_in_ruleDelay5974); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2267:1: (this_ID_1= RULE_ID )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_ID) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2267:6: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDelay5990); 

            	    		current.merge(this_ID_1);
            	        
            	     
            	        newLeafNode(this_ID_1, grammarAccess.getDelayAccess().getIDTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            kw=(Token)match(input,191,FOLLOW_191_in_ruleDelay6010); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_2()); 
                

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2288:1: entryRuleSpace returns [String current=null] : iv_ruleSpace= ruleSpace EOF ;
    public final String entryRuleSpace() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSpace = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2289:2: (iv_ruleSpace= ruleSpace EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2290:2: iv_ruleSpace= ruleSpace EOF
            {
             newCompositeNode(grammarAccess.getSpaceRule()); 
            pushFollow(FOLLOW_ruleSpace_in_entryRuleSpace6051);
            iv_ruleSpace=ruleSpace();

            state._fsp--;

             current =iv_ruleSpace.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpace6062); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2297:1: ruleSpace returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '|||' | (kw= '||' this_INT_2= RULE_INT kw= '||' ) ) ;
    public final AntlrDatatypeRuleToken ruleSpace() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2300:28: ( (kw= '|||' | (kw= '||' this_INT_2= RULE_INT kw= '||' ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2301:1: (kw= '|||' | (kw= '||' this_INT_2= RULE_INT kw= '||' ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2301:1: (kw= '|||' | (kw= '||' this_INT_2= RULE_INT kw= '||' ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==192) ) {
                alt32=1;
            }
            else if ( (LA32_0==193) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2302:2: kw= '|||'
                    {
                    kw=(Token)match(input,192,FOLLOW_192_in_ruleSpace6100); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSpaceAccess().getVerticalLineVerticalLineVerticalLineKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2308:6: (kw= '||' this_INT_2= RULE_INT kw= '||' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2308:6: (kw= '||' this_INT_2= RULE_INT kw= '||' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2309:2: kw= '||' this_INT_2= RULE_INT kw= '||'
                    {
                    kw=(Token)match(input,193,FOLLOW_193_in_ruleSpace6120); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSpaceAccess().getVerticalLineVerticalLineKeyword_1_0()); 
                        
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpace6135); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getSpaceAccess().getINTTerminalRuleCall_1_1()); 
                        
                    kw=(Token)match(input,193,FOLLOW_193_in_ruleSpace6153); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2335:1: entryRuleHidefootbox returns [String current=null] : iv_ruleHidefootbox= ruleHidefootbox EOF ;
    public final String entryRuleHidefootbox() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHidefootbox = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2336:2: (iv_ruleHidefootbox= ruleHidefootbox EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2337:2: iv_ruleHidefootbox= ruleHidefootbox EOF
            {
             newCompositeNode(grammarAccess.getHidefootboxRule()); 
            pushFollow(FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox6195);
            iv_ruleHidefootbox=ruleHidefootbox();

            state._fsp--;

             current =iv_ruleHidefootbox.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHidefootbox6206); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2344:1: ruleHidefootbox returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'hide footbox' ;
    public final AntlrDatatypeRuleToken ruleHidefootbox() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2347:28: (kw= 'hide footbox' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2349:2: kw= 'hide footbox'
            {
            kw=(Token)match(input,194,FOLLOW_194_in_ruleHidefootbox6243); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getHidefootboxAccess().getHideFootboxKeyword()); 
                

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

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_ruleModel130 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleDiagram_in_entryRuleDiagram166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDiagram176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleDiagram213 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleDiagram224 = new BitSet(new long[]{0x00000000003FA030L,0x0000000000000000L,0xB0FCC30000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleDiagram244 = new BitSet(new long[]{0x00000000003FA030L,0x0000000000000000L,0xB0FCC30000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_13_in_ruleDiagram257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction293 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstruction347 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_SEQUENCE_in_ruleInstruction363 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstruction379 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleInstruction397 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstruction408 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleInstruction439 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_ruleColor_in_ruleInstruction455 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_ruleInstruction479 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTitle_in_ruleInstruction500 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleLegend_in_ruleInstruction521 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNewpage_in_ruleInstruction542 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAltElse_in_ruleInstruction569 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_ruleInstruction596 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNote_in_ruleInstruction617 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDivider_in_ruleInstruction638 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleReference_in_ruleInstruction659 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDelay_in_ruleInstruction680 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSpace_in_ruleInstruction701 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_ruleInstruction722 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleInstruction734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition769 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleDefinition817 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleDefinition859 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleDefinition901 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleDefinition943 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleDefinition985 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleDefinition1027 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber1087 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAutoNumber1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleAutoNumber1136 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAutoNumber1152 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAutoNumber1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_entryRuleColor1223 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColor1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleColor1273 = new BitSet(new long[]{0xFFFFFFFFFFC00000L,0xFFFFFFFFFFFFFFFFL,0x000000FFFFFFFFFFL});
    public static final BitSet FOLLOW_23_in_ruleColor1289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleColor1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleColor1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleColor1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleColor1365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleColor1384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleColor1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleColor1422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleColor1441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleColor1460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleColor1479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleColor1498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleColor1517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleColor1536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleColor1555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleColor1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleColor1593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleColor1612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleColor1631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleColor1650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleColor1669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleColor1688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleColor1707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleColor1726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleColor1745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleColor1764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleColor1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleColor1802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleColor1821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleColor1840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleColor1859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleColor1878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleColor1897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleColor1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleColor1935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleColor1954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleColor1973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleColor1992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleColor2011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleColor2030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleColor2049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleColor2068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleColor2087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleColor2106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleColor2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleColor2144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleColor2163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleColor2182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleColor2201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleColor2220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleColor2239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleColor2258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleColor2277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleColor2296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleColor2315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleColor2334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleColor2353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleColor2372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleColor2391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleColor2410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleColor2429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleColor2448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleColor2467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_ruleColor2486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_ruleColor2505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleColor2524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_ruleColor2543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_ruleColor2562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_ruleColor2581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_ruleColor2600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_ruleColor2619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_ruleColor2638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_ruleColor2657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_ruleColor2676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_ruleColor2695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_ruleColor2714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_ruleColor2733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_ruleColor2752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_ruleColor2771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_ruleColor2790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_ruleColor2809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_ruleColor2828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_ruleColor2847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_ruleColor2866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_ruleColor2885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_ruleColor2904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_ruleColor2923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_ruleColor2942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_ruleColor2961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_ruleColor2980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_ruleColor2999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_ruleColor3018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_ruleColor3037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_ruleColor3056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_ruleColor3075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_ruleColor3094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_ruleColor3113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_ruleColor3132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_ruleColor3151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_ruleColor3170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_ruleColor3189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_ruleColor3208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_ruleColor3227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_ruleColor3246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_ruleColor3265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_ruleColor3284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_ruleColor3303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_ruleColor3322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_ruleColor3341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_ruleColor3360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_ruleColor3379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_134_in_ruleColor3398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_135_in_ruleColor3417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_136_in_ruleColor3436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_137_in_ruleColor3455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_138_in_ruleColor3474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_139_in_ruleColor3493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_140_in_ruleColor3512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_141_in_ruleColor3531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_142_in_ruleColor3550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_143_in_ruleColor3569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_144_in_ruleColor3588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_145_in_ruleColor3607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_146_in_ruleColor3626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_147_in_ruleColor3645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_148_in_ruleColor3664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_149_in_ruleColor3683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_150_in_ruleColor3702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_151_in_ruleColor3721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_152_in_ruleColor3740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_153_in_ruleColor3759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_154_in_ruleColor3778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_155_in_ruleColor3797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_156_in_ruleColor3816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_157_in_ruleColor3835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_ruleColor3854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_ruleColor3873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_ruleColor3892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_ruleColor3911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_ruleColor3930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_ruleColor3949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_ruleColor3968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_ruleColor3987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_166_in_ruleColor4006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_167_in_ruleColor4025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_entryRuleTitle4067 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTitle4078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_ruleTitle4116 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTitle4131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLegend_in_entryRuleLegend4177 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLegend4188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_169_in_ruleLegend4226 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x00001C0000000000L});
    public static final BitSet FOLLOW_170_in_ruleLegend4240 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_171_in_ruleLegend4259 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_172_in_ruleLegend4278 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleLegend4297 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLegend4317 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleLegend4344 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleLegend4366 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_173_in_ruleLegend4384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_entryRuleNewpage4425 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNewpage4436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_174_in_ruleNewpage4474 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNewpage4490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAltElse_in_entryRuleAltElse4537 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAltElse4547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_175_in_ruleAltElse4584 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAltElse4595 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleAltElse4605 = new BitSet(new long[]{0x00000000003F8030L,0x0000000000000000L,0xB0FFC30000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleAltElse4625 = new BitSet(new long[]{0x00000000003F8030L,0x0000000000000000L,0xB0FFC30000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleElse_in_ruleAltElse4647 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0003000000000000L});
    public static final BitSet FOLLOW_176_in_ruleAltElse4660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElse_in_entryRuleElse4696 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElse4706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_177_in_ruleElse4743 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleElse4754 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleElse4764 = new BitSet(new long[]{0x00000000003F8032L,0x0000000000000000L,0xB0FCC30000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleElse4784 = new BitSet(new long[]{0x00000000003F8032L,0x0000000000000000L,0xB0FCC30000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages4821 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroupingMessages4831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_178_in_ruleGroupingMessages4869 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_179_in_ruleGroupingMessages4887 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_180_in_ruleGroupingMessages4905 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_181_in_ruleGroupingMessages4923 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_182_in_ruleGroupingMessages4941 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGroupingMessages4953 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleGroupingMessages4963 = new BitSet(new long[]{0x00000000003F8030L,0x0000000000000000L,0xB0FDC30000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleGroupingMessages4983 = new BitSet(new long[]{0x00000000003F8030L,0x0000000000000000L,0xB0FDC30000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_176_in_ruleGroupingMessages4996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNote_in_entryRuleNote5035 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNote5046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_183_in_ruleNote5084 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x04000C0000000000L});
    public static final BitSet FOLLOW_170_in_ruleNote5099 = new BitSet(new long[]{0x0000000000404010L,0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_184_in_ruleNote5113 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote5128 = new BitSet(new long[]{0x0000000000404010L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_185_in_ruleNote5147 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote5162 = new BitSet(new long[]{0x0000000000404010L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_171_in_ruleNote5192 = new BitSet(new long[]{0x0000000000404010L,0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_184_in_ruleNote5206 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote5221 = new BitSet(new long[]{0x0000000000404010L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_185_in_ruleNote5240 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote5255 = new BitSet(new long[]{0x0000000000404010L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_186_in_ruleNote5285 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote5300 = new BitSet(new long[]{0x0000000000404010L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_185_in_ruleNote5319 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote5334 = new BitSet(new long[]{0x0000000000404010L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_ruleColor_in_ruleNote5366 = new BitSet(new long[]{0x0000000000404010L});
    public static final BitSet FOLLOW_14_in_ruleNote5388 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote5403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleNote5432 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote5452 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleNote5474 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_187_in_ruleNote5492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDivider_in_entryRuleDivider5535 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDivider5546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_188_in_ruleDivider5584 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDivider5599 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_188_in_ruleDivider5617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference5658 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference5669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_189_in_ruleReference5707 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference5722 = new BitSet(new long[]{0x0000000000004010L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_185_in_ruleReference5741 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference5756 = new BitSet(new long[]{0x0000000000004010L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_14_in_ruleReference5778 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference5793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleReference5822 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference5842 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleReference5864 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_190_in_ruleReference5882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDelay_in_entryRuleDelay5925 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDelay5936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_191_in_ruleDelay5974 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDelay5990 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_191_in_ruleDelay6010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpace_in_entryRuleSpace6051 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpace6062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_192_in_ruleSpace6100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_193_in_ruleSpace6120 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpace6135 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_193_in_ruleSpace6153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox6195 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHidefootbox6206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_194_in_ruleHidefootbox6243 = new BitSet(new long[]{0x0000000000000002L});

}