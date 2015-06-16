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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NEWLINE", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@startuml'", "'@enduml'", "':'", "'-'", "'>'", "'<'", "'x'", "'\\\\'", "'/'", "'\\\\\\\\'", "'o'", "'|'", "'.'", "'actor'", "'boundary'", "'control'", "'entity'", "'database'", "'autonumber'", "'#'", "'AliceBlue'", "'AntiqueWhite'", "'Aqua'", "'Aquamarine'", "'Azure'", "'Beige'", "'Bisque'", "'Black'", "'BlanchedAlmond'", "'Blue'", "'BlueViolet'", "'Brown'", "'BurlyWood'", "'CadetBlue'", "'Chartreuse'", "'Chocolate'", "'Coral'", "'CornflowerBlue'", "'Cornsilk'", "'Crimson'", "'Cyan'", "'DarkBlue'", "'DarkCyan'", "'DarkGoldenRod'", "'DarkGray'", "'DarkGreen'", "'DarkGrey'", "'DarkKhaki'", "'DarkMagenta'", "'DarkOliveGreen'", "'DarkOrchid'", "'DarkRed'", "'DarkSalmo'", "'DarkSeaGreen'", "'DarkSlateBlue'", "'DarkSlateGray'", "'DarkSlateGrey'", "'DarkTurquoise'", "'DarkViolet'", "'Darkorange'", "'DeepPink'", "'DeepSkyBlue'", "'DimGray'", "'DimGrey'", "'DodgerBlue'", "'FireBrick'", "'FloralWhite'", "'ForestGreen'", "'Fuchsia'", "'Gainsboro'", "'GhostWhite'", "'Gold'", "'GoldenRod'", "'Gray'", "'Green'", "'GreenYellow'", "'Grey'", "'HoneyDew'", "'HotPink'", "'IndianRed'", "'Indigo'", "'Ivory'", "'Khaki'", "'Lavender'", "'LavenderBlush'", "'LawnGreen'", "'LemonChiffon'", "'LightBlue'", "'LightCoral'", "'LightCyan'", "'LightGoldenRodYellow'", "'LightGray'", "'LightGreen'", "'LightGrey'", "'LightPink'", "'LightSalmon'", "'LightSeaGreen'", "'LightSkyBlue'", "'LightSlateGray'", "'LightSlateGrey'", "'LightSteelBlue'", "'LightYellow'", "'Lime'", "'LimeGreen'", "'Linen'", "'Magenta'", "'Maroon'", "'MediumAquaMarine'", "'MediumBlue'", "'MediumOrchid'", "'MediumPurple'", "'MediumSeaGreen'", "'MediumSlateBlue'", "'MediumSpringGreen'", "'MediumTurquoise'", "'MediumVioletRed'", "'MidnightBlue'", "'MintCream'", "'MistyRose'", "'Moccasin'", "'NavajoWhite'", "'Navy'", "'OldLace'", "'Olive'", "'OliveDrab'", "'OrangeRed'", "'Orchid'", "'PaleGoldenRod'", "'PaleGreen'", "'PaleTurquoise'", "'PaleVioletRed'", "'PapayaWhip'", "'PeachPuff'", "'Peru'", "'Pink'", "'Plum'", "'PowderBlue'", "'Purple'", "'Red'", "'RosyBrown'", "'RoyalBlue'", "'SaddleBrown'", "'Salmon'", "'SandyBrown'", "'SeaGreen'", "'Sienna'", "'Silver'", "'SkyBlue'", "'SlateBlue'", "'SlateGray'", "'SlateGrey'", "'Snow'", "'SpringGreen'", "'SteelBlue'", "'Tan'", "'Teal'", "'Thistle'", "'Tomato'", "'Turquoise'", "'Violet'", "'Wheat'", "'White'", "'WhiteSmoke'", "'Yellow'", "'YellowGreen'", "'title'", "'legend'", "'right'", "'left'", "'center'", "'endlegend'", "'newpage'"
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
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleDiagram213); 

                	newLeafNode(otherlv_0, grammarAccess.getDiagramAccess().getStartumlKeyword_0());
                
            this_NEWLINE_1=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleDiagram224); 
             
                newLeafNode(this_NEWLINE_1, grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_1()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:127:1: ( (lv_instructions_2_0= ruleInstruction ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_NEWLINE && LA2_0<=RULE_ID)||(LA2_0>=24 && LA2_0<=29)||(LA2_0>=176 && LA2_0<=177)||LA2_0==182) ) {
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

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleDiagram257); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:166:1: ruleInstruction returns [EObject current=null] : ( ( ( ( (lv_name1_0_0= RULE_ID ) ) ruleSequence ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? ) | (this_Definition_5= ruleDefinition ( ruleColor )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage )? this_NEWLINE_11= RULE_NEWLINE ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_name1_0_0=null;
        Token lv_name2_2_0=null;
        Token otherlv_3=null;
        Token this_ID_4=null;
        Token this_NEWLINE_11=null;
        EObject this_Definition_5 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:169:28: ( ( ( ( ( (lv_name1_0_0= RULE_ID ) ) ruleSequence ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? ) | (this_Definition_5= ruleDefinition ( ruleColor )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage )? this_NEWLINE_11= RULE_NEWLINE ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:170:1: ( ( ( ( (lv_name1_0_0= RULE_ID ) ) ruleSequence ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? ) | (this_Definition_5= ruleDefinition ( ruleColor )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage )? this_NEWLINE_11= RULE_NEWLINE )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:170:1: ( ( ( ( (lv_name1_0_0= RULE_ID ) ) ruleSequence ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? ) | (this_Definition_5= ruleDefinition ( ruleColor )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage )? this_NEWLINE_11= RULE_NEWLINE )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:170:2: ( ( ( (lv_name1_0_0= RULE_ID ) ) ruleSequence ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? ) | (this_Definition_5= ruleDefinition ( ruleColor )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage )? this_NEWLINE_11= RULE_NEWLINE
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:170:2: ( ( ( (lv_name1_0_0= RULE_ID ) ) ruleSequence ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? ) | (this_Definition_5= ruleDefinition ( ruleColor )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage )?
            int alt5=7;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    alt5=1;
                    }
                    break;
                case 24:
                case 25:
                case 26:
                case 27:
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
                case 176:
                    {
                    alt5=4;
                    }
                    break;
                case 177:
                    {
                    alt5=5;
                    }
                    break;
                case 182:
                    {
                    alt5=6;
                    }
                    break;
            }

            switch (alt5) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:170:3: ( ( (lv_name1_0_0= RULE_ID ) ) ruleSequence ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:170:3: ( ( (lv_name1_0_0= RULE_ID ) ) ruleSequence ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:170:4: ( (lv_name1_0_0= RULE_ID ) ) ruleSequence ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )?
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

                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getSequenceParserRuleCall_0_0_1()); 
                        
                    pushFollow(FOLLOW_ruleSequence_in_ruleInstruction368);
                    ruleSequence();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:196:1: ( (lv_name2_2_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:197:1: (lv_name2_2_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:197:1: (lv_name2_2_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:198:3: lv_name2_2_0= RULE_ID
                    {
                    lv_name2_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstruction384); 

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

                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:214:2: (otherlv_3= ':' this_ID_4= RULE_ID )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==13) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:214:4: otherlv_3= ':' this_ID_4= RULE_ID
                            {
                            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleInstruction402); 

                                	newLeafNode(otherlv_3, grammarAccess.getInstructionAccess().getColonKeyword_0_0_3_0());
                                
                            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstruction413); 
                             
                                newLeafNode(this_ID_4, grammarAccess.getInstructionAccess().getIDTerminalRuleCall_0_0_3_1()); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:223:6: (this_Definition_5= ruleDefinition ( ruleColor )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:223:6: (this_Definition_5= ruleDefinition ( ruleColor )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:224:5: this_Definition_5= ruleDefinition ( ruleColor )?
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_0_1_0()); 
                        
                    pushFollow(FOLLOW_ruleDefinition_in_ruleInstruction444);
                    this_Definition_5=ruleDefinition();

                    state._fsp--;

                     
                            current = this_Definition_5; 
                            afterParserOrEnumRuleCall();
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:232:1: ( ruleColor )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==30) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:233:5: ruleColor
                            {
                             
                                    newCompositeNode(grammarAccess.getInstructionAccess().getColorParserRuleCall_0_1_1()); 
                                
                            pushFollow(FOLLOW_ruleColor_in_ruleInstruction460);
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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:242:5: ruleAutoNumber
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 
                        
                    pushFollow(FOLLOW_ruleAutoNumber_in_ruleInstruction484);
                    ruleAutoNumber();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:251:5: ruleTitle
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 
                        
                    pushFollow(FOLLOW_ruleTitle_in_ruleInstruction505);
                    ruleTitle();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:260:5: ruleLegend
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 
                        
                    pushFollow(FOLLOW_ruleLegend_in_ruleInstruction526);
                    ruleLegend();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:269:5: ruleNewpage
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 
                        
                    pushFollow(FOLLOW_ruleNewpage_in_ruleInstruction547);
                    ruleNewpage();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            this_NEWLINE_11=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleInstruction559); 
             
                newLeafNode(this_NEWLINE_11, grammarAccess.getInstructionAccess().getNEWLINETerminalRuleCall_1()); 
                

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:288:1: entryRuleSequence returns [String current=null] : iv_ruleSequence= ruleSequence EOF ;
    public final String entryRuleSequence() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSequence = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:289:2: (iv_ruleSequence= ruleSequence EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:290:2: iv_ruleSequence= ruleSequence EOF
            {
             newCompositeNode(grammarAccess.getSequenceRule()); 
            pushFollow(FOLLOW_ruleSequence_in_entryRuleSequence595);
            iv_ruleSequence=ruleSequence();

            state._fsp--;

             current =iv_ruleSequence.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequence606); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:297:1: ruleSequence returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '-' )* kw= '-' kw= '>' ) | (kw= '<' kw= '-' (kw= '-' )* ) | (kw= '-' kw= '>' kw= 'x' ) | (kw= 'x' kw= '<' kw= '-' ) | ( (kw= '-' )* kw= '-' kw= '>' kw= '>' ) | (kw= '<' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' ) | (kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' ) | (kw= '/' kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' ) | (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* ) | (kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '|' kw= '-' kw= '-' ) | (kw= '-' kw= '-' kw= '|' kw= '>' ) | (kw= '.' kw= '.' ) | kw= '.' ) ;
    public final AntlrDatatypeRuleToken ruleSequence() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:300:28: ( ( ( (kw= '-' )* kw= '-' kw= '>' ) | (kw= '<' kw= '-' (kw= '-' )* ) | (kw= '-' kw= '>' kw= 'x' ) | (kw= 'x' kw= '<' kw= '-' ) | ( (kw= '-' )* kw= '-' kw= '>' kw= '>' ) | (kw= '<' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' ) | (kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' ) | (kw= '/' kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' ) | (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* ) | (kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '|' kw= '-' kw= '-' ) | (kw= '-' kw= '-' kw= '|' kw= '>' ) | (kw= '.' kw= '.' ) | kw= '.' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:301:1: ( ( (kw= '-' )* kw= '-' kw= '>' ) | (kw= '<' kw= '-' (kw= '-' )* ) | (kw= '-' kw= '>' kw= 'x' ) | (kw= 'x' kw= '<' kw= '-' ) | ( (kw= '-' )* kw= '-' kw= '>' kw= '>' ) | (kw= '<' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' ) | (kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' ) | (kw= '/' kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' ) | (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* ) | (kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '|' kw= '-' kw= '-' ) | (kw= '-' kw= '-' kw= '|' kw= '>' ) | (kw= '.' kw= '.' ) | kw= '.' )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:301:1: ( ( (kw= '-' )* kw= '-' kw= '>' ) | (kw= '<' kw= '-' (kw= '-' )* ) | (kw= '-' kw= '>' kw= 'x' ) | (kw= 'x' kw= '<' kw= '-' ) | ( (kw= '-' )* kw= '-' kw= '>' kw= '>' ) | (kw= '<' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' ) | (kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' ) | (kw= '/' kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' ) | (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* ) | (kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '|' kw= '-' kw= '-' ) | (kw= '-' kw= '-' kw= '|' kw= '>' ) | (kw= '.' kw= '.' ) | kw= '.' )
            int alt18=21;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:301:2: ( (kw= '-' )* kw= '-' kw= '>' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:301:2: ( (kw= '-' )* kw= '-' kw= '>' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:301:3: (kw= '-' )* kw= '-' kw= '>'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:301:3: (kw= '-' )*
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
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:302:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence646); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_0_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence661); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_0_1()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence674); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_0_2()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:320:6: (kw= '<' kw= '-' (kw= '-' )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:320:6: (kw= '<' kw= '-' (kw= '-' )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:321:2: kw= '<' kw= '-' (kw= '-' )*
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence695); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_1_0()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence708); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_1_1()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:332:1: (kw= '-' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==14) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:333:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence722); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:339:6: (kw= '-' kw= '>' kw= 'x' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:339:6: (kw= '-' kw= '>' kw= 'x' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:340:2: kw= '-' kw= '>' kw= 'x'
                    {
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence745); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_2_0()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence758); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_2_1()); 
                        
                    kw=(Token)match(input,17,FOLLOW_17_in_ruleSequence771); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getXKeyword_2_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:358:6: (kw= 'x' kw= '<' kw= '-' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:358:6: (kw= 'x' kw= '<' kw= '-' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:359:2: kw= 'x' kw= '<' kw= '-'
                    {
                    kw=(Token)match(input,17,FOLLOW_17_in_ruleSequence792); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getXKeyword_3_0()); 
                        
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence805); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_3_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence818); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_3_2()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:377:6: ( (kw= '-' )* kw= '-' kw= '>' kw= '>' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:377:6: ( (kw= '-' )* kw= '-' kw= '>' kw= '>' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:377:7: (kw= '-' )* kw= '-' kw= '>' kw= '>'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:377:7: (kw= '-' )*
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
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:378:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence840); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_4_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence855); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_4_1()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence868); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4_2()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence881); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4_3()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:402:6: (kw= '<' kw= '<' kw= '-' (kw= '-' )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:402:6: (kw= '<' kw= '<' kw= '-' (kw= '-' )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:403:2: kw= '<' kw= '<' kw= '-' (kw= '-' )*
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence902); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_5_0()); 
                        
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence915); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_5_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence928); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_5_2()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:420:1: (kw= '-' )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==14) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:421:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence942); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:427:6: ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:427:6: ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:427:7: (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:427:7: (kw= '-' )*
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
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:428:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence966); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_6_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence981); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_6_1()); 
                        
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleSequence994); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getReverseSolidusKeyword_6_2()); 
                        
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleSequence1007); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getReverseSolidusKeyword_6_3()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:452:6: (kw= '/' kw= '-' (kw= '-' )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:452:6: (kw= '/' kw= '-' (kw= '-' )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:453:2: kw= '/' kw= '-' (kw= '-' )*
                    {
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleSequence1028); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getSolidusKeyword_7_0()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1041); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_7_1()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:464:1: (kw= '-' )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==14) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:465:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1055); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:471:6: ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:471:6: ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:471:7: (kw= '-' )* kw= '-' kw= '\\\\\\\\'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:471:7: (kw= '-' )*
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
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:472:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1079); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_8_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1094); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_8_1()); 
                        
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleSequence1107); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getReverseSolidusReverseSolidusKeyword_8_2()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:490:6: (kw= '/' kw= '/' kw= '-' (kw= '-' )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:490:6: (kw= '/' kw= '/' kw= '-' (kw= '-' )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:491:2: kw= '/' kw= '/' kw= '-' (kw= '-' )*
                    {
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleSequence1128); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getSolidusKeyword_9_0()); 
                        
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleSequence1141); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getSolidusKeyword_9_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1154); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_9_2()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:508:1: (kw= '-' )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==14) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:509:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1168); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:515:6: ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:515:6: ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:515:7: (kw= '-' )* kw= '-' kw= '>' kw= 'o'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:515:7: (kw= '-' )*
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
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:516:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1192); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_10_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1207); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_10_1()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence1220); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_10_2()); 
                        
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleSequence1233); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getOKeyword_10_3()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:540:6: (kw= 'o' kw= '<' kw= '-' (kw= '-' )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:540:6: (kw= 'o' kw= '<' kw= '-' (kw= '-' )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:541:2: kw= 'o' kw= '<' kw= '-' (kw= '-' )*
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleSequence1254); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getOKeyword_11_0()); 
                        
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence1267); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_11_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1280); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_11_2()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:558:1: (kw= '-' )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==14) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:559:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1294); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:565:6: ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:565:6: ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:565:7: (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:565:7: (kw= '-' )*
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
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:566:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1318); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1333); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1346); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_2()); 
                        
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleSequence1359); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getSolidusKeyword_12_3()); 
                        
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleSequence1372); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getSolidusKeyword_12_4()); 
                        
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleSequence1385); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getOKeyword_12_5()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:602:6: (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:602:6: (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:603:2: kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )*
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleSequence1406); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getOKeyword_13_0()); 
                        
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleSequence1419); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getReverseSolidusReverseSolidusKeyword_13_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1432); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_2()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1445); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_3()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:626:1: (kw= '-' )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==14) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:627:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1459); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:633:6: (kw= '<' kw= '-' kw= '>' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:633:6: (kw= '<' kw= '-' kw= '>' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:634:2: kw= '<' kw= '-' kw= '>'
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence1482); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_14_0()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1495); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_14_1()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence1508); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_14_2()); 
                        

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:652:6: (kw= '<' kw= '-' kw= '>' kw= 'o' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:652:6: (kw= '<' kw= '-' kw= '>' kw= 'o' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:653:2: kw= '<' kw= '-' kw= '>' kw= 'o'
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence1529); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_15_0()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1542); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_15_1()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence1555); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_15_2()); 
                        
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleSequence1568); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getOKeyword_15_3()); 
                        

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:677:6: (kw= 'o' kw= '<' kw= '-' kw= '>' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:677:6: (kw= 'o' kw= '<' kw= '-' kw= '>' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:678:2: kw= 'o' kw= '<' kw= '-' kw= '>'
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleSequence1589); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getOKeyword_16_0()); 
                        
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence1602); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_16_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1615); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_16_2()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence1628); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_16_3()); 
                        

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:702:6: (kw= '<' kw= '|' kw= '-' kw= '-' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:702:6: (kw= '<' kw= '|' kw= '-' kw= '-' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:703:2: kw= '<' kw= '|' kw= '-' kw= '-'
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence1649); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_17_0()); 
                        
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleSequence1662); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getVerticalLineKeyword_17_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1675); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_17_2()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1688); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_17_3()); 
                        

                    }


                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:727:6: (kw= '-' kw= '-' kw= '|' kw= '>' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:727:6: (kw= '-' kw= '-' kw= '|' kw= '>' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:728:2: kw= '-' kw= '-' kw= '|' kw= '>'
                    {
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1709); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_18_0()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1722); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_18_1()); 
                        
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleSequence1735); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getVerticalLineKeyword_18_2()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence1748); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_18_3()); 
                        

                    }


                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:752:6: (kw= '.' kw= '.' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:752:6: (kw= '.' kw= '.' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:753:2: kw= '.' kw= '.'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleSequence1769); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getFullStopKeyword_19_0()); 
                        
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleSequence1782); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getFullStopKeyword_19_1()); 
                        

                    }


                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:766:2: kw= '.'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleSequence1802); 

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


    // $ANTLR start "entryRuleDefinition"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:779:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:780:2: (iv_ruleDefinition= ruleDefinition EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:781:2: iv_ruleDefinition= ruleDefinition EOF
            {
             newCompositeNode(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition1842);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition1852); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:788:1: ruleDefinition returns [EObject current=null] : ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) ) ) ;
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:791:28: ( ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:792:1: ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:792:1: ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) ) )
            int alt19=5;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt19=1;
                }
                break;
            case 25:
                {
                alt19=2;
                }
                break;
            case 26:
                {
                alt19=3;
                }
                break;
            case 27:
                {
                alt19=4;
                }
                break;
            case 28:
                {
                alt19=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:792:2: (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:792:2: (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:792:4: otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleDefinition1890); 

                        	newLeafNode(otherlv_0, grammarAccess.getDefinitionAccess().getActorKeyword_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:796:1: ( (lv_name_1_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:797:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:797:1: (lv_name_1_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:798:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1907); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:815:6: (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:815:6: (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:815:8: otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleDefinition1932); 

                        	newLeafNode(otherlv_2, grammarAccess.getDefinitionAccess().getBoundaryKeyword_1_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:819:1: ( (lv_name_3_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:820:1: (lv_name_3_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:820:1: (lv_name_3_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:821:3: lv_name_3_0= RULE_ID
                    {
                    lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1949); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:838:6: (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:838:6: (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:838:8: otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleDefinition1974); 

                        	newLeafNode(otherlv_4, grammarAccess.getDefinitionAccess().getControlKeyword_2_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:842:1: ( (lv_name_5_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:843:1: (lv_name_5_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:843:1: (lv_name_5_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:844:3: lv_name_5_0= RULE_ID
                    {
                    lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1991); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:861:6: (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:861:6: (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:861:8: otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,27,FOLLOW_27_in_ruleDefinition2016); 

                        	newLeafNode(otherlv_6, grammarAccess.getDefinitionAccess().getEntityKeyword_3_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:865:1: ( (lv_name_7_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:866:1: (lv_name_7_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:866:1: (lv_name_7_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:867:3: lv_name_7_0= RULE_ID
                    {
                    lv_name_7_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition2033); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:884:6: (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:884:6: (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:884:8: otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,28,FOLLOW_28_in_ruleDefinition2058); 

                        	newLeafNode(otherlv_8, grammarAccess.getDefinitionAccess().getDatabaseKeyword_4_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:888:1: ( (lv_name_9_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:889:1: (lv_name_9_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:889:1: (lv_name_9_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:890:3: lv_name_9_0= RULE_ID
                    {
                    lv_name_9_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition2075); 

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


    // $ANTLR start "entryRuleAutoNumber"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:914:1: entryRuleAutoNumber returns [String current=null] : iv_ruleAutoNumber= ruleAutoNumber EOF ;
    public final String entryRuleAutoNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAutoNumber = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:915:2: (iv_ruleAutoNumber= ruleAutoNumber EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:916:2: iv_ruleAutoNumber= ruleAutoNumber EOF
            {
             newCompositeNode(grammarAccess.getAutoNumberRule()); 
            pushFollow(FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber2118);
            iv_ruleAutoNumber=ruleAutoNumber();

            state._fsp--;

             current =iv_ruleAutoNumber.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAutoNumber2129); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:923:1: ruleAutoNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'autonumber' (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? ) ;
    public final AntlrDatatypeRuleToken ruleAutoNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:926:28: ( (kw= 'autonumber' (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:927:1: (kw= 'autonumber' (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:927:1: (kw= 'autonumber' (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:928:2: kw= 'autonumber' (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )?
            {
            kw=(Token)match(input,29,FOLLOW_29_in_ruleAutoNumber2167); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getAutoNumberAccess().getAutonumberKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:933:1: (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_INT) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:933:6: this_INT_1= RULE_INT (this_INT_2= RULE_INT )?
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAutoNumber2183); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_0()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:940:1: (this_INT_2= RULE_INT )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==RULE_INT) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:940:6: this_INT_2= RULE_INT
                            {
                            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAutoNumber2204); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:955:1: entryRuleColor returns [String current=null] : iv_ruleColor= ruleColor EOF ;
    public final String entryRuleColor() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleColor = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:956:2: (iv_ruleColor= ruleColor EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:957:2: iv_ruleColor= ruleColor EOF
            {
             newCompositeNode(grammarAccess.getColorRule()); 
            pushFollow(FOLLOW_ruleColor_in_entryRuleColor2254);
            iv_ruleColor=ruleColor();

            state._fsp--;

             current =iv_ruleColor.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColor2265); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:964:1: ruleColor returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '#' )+ (kw= 'AliceBlue' | kw= 'AntiqueWhite' | kw= 'Aqua' | kw= 'Aquamarine' | kw= 'Azure' | kw= 'Beige' | kw= 'Bisque' | kw= 'Black' | kw= 'BlanchedAlmond' | kw= 'Blue' | kw= 'BlueViolet' | kw= 'Brown' | kw= 'BurlyWood' | kw= 'CadetBlue' | kw= 'Chartreuse' | kw= 'Chocolate' | kw= 'Coral' | kw= 'CornflowerBlue' | kw= 'Cornsilk' | kw= 'Crimson' | kw= 'Cyan' | kw= 'DarkBlue' | kw= 'DarkCyan' | kw= 'DarkGoldenRod' | kw= 'DarkGray' | kw= 'DarkGreen' | kw= 'DarkGrey' | kw= 'DarkKhaki' | kw= 'DarkMagenta' | kw= 'DarkOliveGreen' | kw= 'DarkOrchid' | kw= 'DarkRed' | kw= 'DarkSalmo' | kw= 'DarkSeaGreen' | kw= 'DarkSlateBlue' | kw= 'DarkSlateGray' | kw= 'DarkSlateGrey' | kw= 'DarkTurquoise' | kw= 'DarkViolet' | kw= 'Darkorange' | kw= 'DeepPink' | kw= 'DeepSkyBlue' | kw= 'DimGray' | kw= 'DimGrey' | kw= 'DodgerBlue' | kw= 'FireBrick' | kw= 'FloralWhite' | kw= 'ForestGreen' | kw= 'Fuchsia' | kw= 'Gainsboro' | kw= 'GhostWhite' | kw= 'Gold' | kw= 'GoldenRod' | kw= 'Gray' | kw= 'Green' | kw= 'GreenYellow' | kw= 'Grey' | kw= 'HoneyDew' | kw= 'HotPink' | kw= 'IndianRed' | kw= 'Indigo' | kw= 'Ivory' | kw= 'Khaki' | kw= 'Lavender' | kw= 'LavenderBlush' | kw= 'LawnGreen' | kw= 'LemonChiffon' | kw= 'LightBlue' | kw= 'LightCoral' | kw= 'LightCyan' | kw= 'LightGoldenRodYellow' | kw= 'LightGray' | kw= 'LightGreen' | kw= 'LightGrey' | kw= 'LightPink' | kw= 'LightSalmon' | kw= 'LightSeaGreen' | kw= 'LightSkyBlue' | kw= 'LightSlateGray' | kw= 'LightSlateGrey' | kw= 'LightSteelBlue' | kw= 'LightYellow' | kw= 'Lime' | kw= 'LimeGreen' | kw= 'Linen' | kw= 'Magenta' | kw= 'Maroon' | kw= 'MediumAquaMarine' | kw= 'MediumBlue' | kw= 'MediumOrchid' | kw= 'MediumPurple' | kw= 'MediumSeaGreen' | kw= 'MediumSlateBlue' | kw= 'MediumSpringGreen' | kw= 'MediumTurquoise' | kw= 'MediumVioletRed' | kw= 'MidnightBlue' | kw= 'MintCream' | kw= 'MistyRose' | kw= 'Moccasin' | kw= 'NavajoWhite' | kw= 'Navy' | kw= 'OldLace' | kw= 'Olive' | kw= 'OliveDrab' | kw= 'OrangeRed' | kw= 'Orchid' | kw= 'PaleGoldenRod' | kw= 'PaleGreen' | kw= 'PaleTurquoise' | kw= 'PaleVioletRed' | kw= 'PapayaWhip' | kw= 'PeachPuff' | kw= 'Peru' | kw= 'Pink' | kw= 'Plum' | kw= 'PowderBlue' | kw= 'Purple' | kw= 'Red' | kw= 'RosyBrown' | kw= 'RoyalBlue' | kw= 'SaddleBrown' | kw= 'Salmon' | kw= 'SandyBrown' | kw= 'SeaGreen' | kw= 'Sienna' | kw= 'Silver' | kw= 'SkyBlue' | kw= 'SlateBlue' | kw= 'SlateGray' | kw= 'SlateGrey' | kw= 'Snow' | kw= 'SpringGreen' | kw= 'SteelBlue' | kw= 'Tan' | kw= 'Teal' | kw= 'Thistle' | kw= 'Tomato' | kw= 'Turquoise' | kw= 'Violet' | kw= 'Wheat' | kw= 'White' | kw= 'WhiteSmoke' | kw= 'Yellow' | kw= 'YellowGreen' ) ) ;
    public final AntlrDatatypeRuleToken ruleColor() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:967:28: ( ( (kw= '#' )+ (kw= 'AliceBlue' | kw= 'AntiqueWhite' | kw= 'Aqua' | kw= 'Aquamarine' | kw= 'Azure' | kw= 'Beige' | kw= 'Bisque' | kw= 'Black' | kw= 'BlanchedAlmond' | kw= 'Blue' | kw= 'BlueViolet' | kw= 'Brown' | kw= 'BurlyWood' | kw= 'CadetBlue' | kw= 'Chartreuse' | kw= 'Chocolate' | kw= 'Coral' | kw= 'CornflowerBlue' | kw= 'Cornsilk' | kw= 'Crimson' | kw= 'Cyan' | kw= 'DarkBlue' | kw= 'DarkCyan' | kw= 'DarkGoldenRod' | kw= 'DarkGray' | kw= 'DarkGreen' | kw= 'DarkGrey' | kw= 'DarkKhaki' | kw= 'DarkMagenta' | kw= 'DarkOliveGreen' | kw= 'DarkOrchid' | kw= 'DarkRed' | kw= 'DarkSalmo' | kw= 'DarkSeaGreen' | kw= 'DarkSlateBlue' | kw= 'DarkSlateGray' | kw= 'DarkSlateGrey' | kw= 'DarkTurquoise' | kw= 'DarkViolet' | kw= 'Darkorange' | kw= 'DeepPink' | kw= 'DeepSkyBlue' | kw= 'DimGray' | kw= 'DimGrey' | kw= 'DodgerBlue' | kw= 'FireBrick' | kw= 'FloralWhite' | kw= 'ForestGreen' | kw= 'Fuchsia' | kw= 'Gainsboro' | kw= 'GhostWhite' | kw= 'Gold' | kw= 'GoldenRod' | kw= 'Gray' | kw= 'Green' | kw= 'GreenYellow' | kw= 'Grey' | kw= 'HoneyDew' | kw= 'HotPink' | kw= 'IndianRed' | kw= 'Indigo' | kw= 'Ivory' | kw= 'Khaki' | kw= 'Lavender' | kw= 'LavenderBlush' | kw= 'LawnGreen' | kw= 'LemonChiffon' | kw= 'LightBlue' | kw= 'LightCoral' | kw= 'LightCyan' | kw= 'LightGoldenRodYellow' | kw= 'LightGray' | kw= 'LightGreen' | kw= 'LightGrey' | kw= 'LightPink' | kw= 'LightSalmon' | kw= 'LightSeaGreen' | kw= 'LightSkyBlue' | kw= 'LightSlateGray' | kw= 'LightSlateGrey' | kw= 'LightSteelBlue' | kw= 'LightYellow' | kw= 'Lime' | kw= 'LimeGreen' | kw= 'Linen' | kw= 'Magenta' | kw= 'Maroon' | kw= 'MediumAquaMarine' | kw= 'MediumBlue' | kw= 'MediumOrchid' | kw= 'MediumPurple' | kw= 'MediumSeaGreen' | kw= 'MediumSlateBlue' | kw= 'MediumSpringGreen' | kw= 'MediumTurquoise' | kw= 'MediumVioletRed' | kw= 'MidnightBlue' | kw= 'MintCream' | kw= 'MistyRose' | kw= 'Moccasin' | kw= 'NavajoWhite' | kw= 'Navy' | kw= 'OldLace' | kw= 'Olive' | kw= 'OliveDrab' | kw= 'OrangeRed' | kw= 'Orchid' | kw= 'PaleGoldenRod' | kw= 'PaleGreen' | kw= 'PaleTurquoise' | kw= 'PaleVioletRed' | kw= 'PapayaWhip' | kw= 'PeachPuff' | kw= 'Peru' | kw= 'Pink' | kw= 'Plum' | kw= 'PowderBlue' | kw= 'Purple' | kw= 'Red' | kw= 'RosyBrown' | kw= 'RoyalBlue' | kw= 'SaddleBrown' | kw= 'Salmon' | kw= 'SandyBrown' | kw= 'SeaGreen' | kw= 'Sienna' | kw= 'Silver' | kw= 'SkyBlue' | kw= 'SlateBlue' | kw= 'SlateGray' | kw= 'SlateGrey' | kw= 'Snow' | kw= 'SpringGreen' | kw= 'SteelBlue' | kw= 'Tan' | kw= 'Teal' | kw= 'Thistle' | kw= 'Tomato' | kw= 'Turquoise' | kw= 'Violet' | kw= 'Wheat' | kw= 'White' | kw= 'WhiteSmoke' | kw= 'Yellow' | kw= 'YellowGreen' ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:968:1: ( (kw= '#' )+ (kw= 'AliceBlue' | kw= 'AntiqueWhite' | kw= 'Aqua' | kw= 'Aquamarine' | kw= 'Azure' | kw= 'Beige' | kw= 'Bisque' | kw= 'Black' | kw= 'BlanchedAlmond' | kw= 'Blue' | kw= 'BlueViolet' | kw= 'Brown' | kw= 'BurlyWood' | kw= 'CadetBlue' | kw= 'Chartreuse' | kw= 'Chocolate' | kw= 'Coral' | kw= 'CornflowerBlue' | kw= 'Cornsilk' | kw= 'Crimson' | kw= 'Cyan' | kw= 'DarkBlue' | kw= 'DarkCyan' | kw= 'DarkGoldenRod' | kw= 'DarkGray' | kw= 'DarkGreen' | kw= 'DarkGrey' | kw= 'DarkKhaki' | kw= 'DarkMagenta' | kw= 'DarkOliveGreen' | kw= 'DarkOrchid' | kw= 'DarkRed' | kw= 'DarkSalmo' | kw= 'DarkSeaGreen' | kw= 'DarkSlateBlue' | kw= 'DarkSlateGray' | kw= 'DarkSlateGrey' | kw= 'DarkTurquoise' | kw= 'DarkViolet' | kw= 'Darkorange' | kw= 'DeepPink' | kw= 'DeepSkyBlue' | kw= 'DimGray' | kw= 'DimGrey' | kw= 'DodgerBlue' | kw= 'FireBrick' | kw= 'FloralWhite' | kw= 'ForestGreen' | kw= 'Fuchsia' | kw= 'Gainsboro' | kw= 'GhostWhite' | kw= 'Gold' | kw= 'GoldenRod' | kw= 'Gray' | kw= 'Green' | kw= 'GreenYellow' | kw= 'Grey' | kw= 'HoneyDew' | kw= 'HotPink' | kw= 'IndianRed' | kw= 'Indigo' | kw= 'Ivory' | kw= 'Khaki' | kw= 'Lavender' | kw= 'LavenderBlush' | kw= 'LawnGreen' | kw= 'LemonChiffon' | kw= 'LightBlue' | kw= 'LightCoral' | kw= 'LightCyan' | kw= 'LightGoldenRodYellow' | kw= 'LightGray' | kw= 'LightGreen' | kw= 'LightGrey' | kw= 'LightPink' | kw= 'LightSalmon' | kw= 'LightSeaGreen' | kw= 'LightSkyBlue' | kw= 'LightSlateGray' | kw= 'LightSlateGrey' | kw= 'LightSteelBlue' | kw= 'LightYellow' | kw= 'Lime' | kw= 'LimeGreen' | kw= 'Linen' | kw= 'Magenta' | kw= 'Maroon' | kw= 'MediumAquaMarine' | kw= 'MediumBlue' | kw= 'MediumOrchid' | kw= 'MediumPurple' | kw= 'MediumSeaGreen' | kw= 'MediumSlateBlue' | kw= 'MediumSpringGreen' | kw= 'MediumTurquoise' | kw= 'MediumVioletRed' | kw= 'MidnightBlue' | kw= 'MintCream' | kw= 'MistyRose' | kw= 'Moccasin' | kw= 'NavajoWhite' | kw= 'Navy' | kw= 'OldLace' | kw= 'Olive' | kw= 'OliveDrab' | kw= 'OrangeRed' | kw= 'Orchid' | kw= 'PaleGoldenRod' | kw= 'PaleGreen' | kw= 'PaleTurquoise' | kw= 'PaleVioletRed' | kw= 'PapayaWhip' | kw= 'PeachPuff' | kw= 'Peru' | kw= 'Pink' | kw= 'Plum' | kw= 'PowderBlue' | kw= 'Purple' | kw= 'Red' | kw= 'RosyBrown' | kw= 'RoyalBlue' | kw= 'SaddleBrown' | kw= 'Salmon' | kw= 'SandyBrown' | kw= 'SeaGreen' | kw= 'Sienna' | kw= 'Silver' | kw= 'SkyBlue' | kw= 'SlateBlue' | kw= 'SlateGray' | kw= 'SlateGrey' | kw= 'Snow' | kw= 'SpringGreen' | kw= 'SteelBlue' | kw= 'Tan' | kw= 'Teal' | kw= 'Thistle' | kw= 'Tomato' | kw= 'Turquoise' | kw= 'Violet' | kw= 'Wheat' | kw= 'White' | kw= 'WhiteSmoke' | kw= 'Yellow' | kw= 'YellowGreen' ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:968:1: ( (kw= '#' )+ (kw= 'AliceBlue' | kw= 'AntiqueWhite' | kw= 'Aqua' | kw= 'Aquamarine' | kw= 'Azure' | kw= 'Beige' | kw= 'Bisque' | kw= 'Black' | kw= 'BlanchedAlmond' | kw= 'Blue' | kw= 'BlueViolet' | kw= 'Brown' | kw= 'BurlyWood' | kw= 'CadetBlue' | kw= 'Chartreuse' | kw= 'Chocolate' | kw= 'Coral' | kw= 'CornflowerBlue' | kw= 'Cornsilk' | kw= 'Crimson' | kw= 'Cyan' | kw= 'DarkBlue' | kw= 'DarkCyan' | kw= 'DarkGoldenRod' | kw= 'DarkGray' | kw= 'DarkGreen' | kw= 'DarkGrey' | kw= 'DarkKhaki' | kw= 'DarkMagenta' | kw= 'DarkOliveGreen' | kw= 'DarkOrchid' | kw= 'DarkRed' | kw= 'DarkSalmo' | kw= 'DarkSeaGreen' | kw= 'DarkSlateBlue' | kw= 'DarkSlateGray' | kw= 'DarkSlateGrey' | kw= 'DarkTurquoise' | kw= 'DarkViolet' | kw= 'Darkorange' | kw= 'DeepPink' | kw= 'DeepSkyBlue' | kw= 'DimGray' | kw= 'DimGrey' | kw= 'DodgerBlue' | kw= 'FireBrick' | kw= 'FloralWhite' | kw= 'ForestGreen' | kw= 'Fuchsia' | kw= 'Gainsboro' | kw= 'GhostWhite' | kw= 'Gold' | kw= 'GoldenRod' | kw= 'Gray' | kw= 'Green' | kw= 'GreenYellow' | kw= 'Grey' | kw= 'HoneyDew' | kw= 'HotPink' | kw= 'IndianRed' | kw= 'Indigo' | kw= 'Ivory' | kw= 'Khaki' | kw= 'Lavender' | kw= 'LavenderBlush' | kw= 'LawnGreen' | kw= 'LemonChiffon' | kw= 'LightBlue' | kw= 'LightCoral' | kw= 'LightCyan' | kw= 'LightGoldenRodYellow' | kw= 'LightGray' | kw= 'LightGreen' | kw= 'LightGrey' | kw= 'LightPink' | kw= 'LightSalmon' | kw= 'LightSeaGreen' | kw= 'LightSkyBlue' | kw= 'LightSlateGray' | kw= 'LightSlateGrey' | kw= 'LightSteelBlue' | kw= 'LightYellow' | kw= 'Lime' | kw= 'LimeGreen' | kw= 'Linen' | kw= 'Magenta' | kw= 'Maroon' | kw= 'MediumAquaMarine' | kw= 'MediumBlue' | kw= 'MediumOrchid' | kw= 'MediumPurple' | kw= 'MediumSeaGreen' | kw= 'MediumSlateBlue' | kw= 'MediumSpringGreen' | kw= 'MediumTurquoise' | kw= 'MediumVioletRed' | kw= 'MidnightBlue' | kw= 'MintCream' | kw= 'MistyRose' | kw= 'Moccasin' | kw= 'NavajoWhite' | kw= 'Navy' | kw= 'OldLace' | kw= 'Olive' | kw= 'OliveDrab' | kw= 'OrangeRed' | kw= 'Orchid' | kw= 'PaleGoldenRod' | kw= 'PaleGreen' | kw= 'PaleTurquoise' | kw= 'PaleVioletRed' | kw= 'PapayaWhip' | kw= 'PeachPuff' | kw= 'Peru' | kw= 'Pink' | kw= 'Plum' | kw= 'PowderBlue' | kw= 'Purple' | kw= 'Red' | kw= 'RosyBrown' | kw= 'RoyalBlue' | kw= 'SaddleBrown' | kw= 'Salmon' | kw= 'SandyBrown' | kw= 'SeaGreen' | kw= 'Sienna' | kw= 'Silver' | kw= 'SkyBlue' | kw= 'SlateBlue' | kw= 'SlateGray' | kw= 'SlateGrey' | kw= 'Snow' | kw= 'SpringGreen' | kw= 'SteelBlue' | kw= 'Tan' | kw= 'Teal' | kw= 'Thistle' | kw= 'Tomato' | kw= 'Turquoise' | kw= 'Violet' | kw= 'Wheat' | kw= 'White' | kw= 'WhiteSmoke' | kw= 'Yellow' | kw= 'YellowGreen' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:968:2: (kw= '#' )+ (kw= 'AliceBlue' | kw= 'AntiqueWhite' | kw= 'Aqua' | kw= 'Aquamarine' | kw= 'Azure' | kw= 'Beige' | kw= 'Bisque' | kw= 'Black' | kw= 'BlanchedAlmond' | kw= 'Blue' | kw= 'BlueViolet' | kw= 'Brown' | kw= 'BurlyWood' | kw= 'CadetBlue' | kw= 'Chartreuse' | kw= 'Chocolate' | kw= 'Coral' | kw= 'CornflowerBlue' | kw= 'Cornsilk' | kw= 'Crimson' | kw= 'Cyan' | kw= 'DarkBlue' | kw= 'DarkCyan' | kw= 'DarkGoldenRod' | kw= 'DarkGray' | kw= 'DarkGreen' | kw= 'DarkGrey' | kw= 'DarkKhaki' | kw= 'DarkMagenta' | kw= 'DarkOliveGreen' | kw= 'DarkOrchid' | kw= 'DarkRed' | kw= 'DarkSalmo' | kw= 'DarkSeaGreen' | kw= 'DarkSlateBlue' | kw= 'DarkSlateGray' | kw= 'DarkSlateGrey' | kw= 'DarkTurquoise' | kw= 'DarkViolet' | kw= 'Darkorange' | kw= 'DeepPink' | kw= 'DeepSkyBlue' | kw= 'DimGray' | kw= 'DimGrey' | kw= 'DodgerBlue' | kw= 'FireBrick' | kw= 'FloralWhite' | kw= 'ForestGreen' | kw= 'Fuchsia' | kw= 'Gainsboro' | kw= 'GhostWhite' | kw= 'Gold' | kw= 'GoldenRod' | kw= 'Gray' | kw= 'Green' | kw= 'GreenYellow' | kw= 'Grey' | kw= 'HoneyDew' | kw= 'HotPink' | kw= 'IndianRed' | kw= 'Indigo' | kw= 'Ivory' | kw= 'Khaki' | kw= 'Lavender' | kw= 'LavenderBlush' | kw= 'LawnGreen' | kw= 'LemonChiffon' | kw= 'LightBlue' | kw= 'LightCoral' | kw= 'LightCyan' | kw= 'LightGoldenRodYellow' | kw= 'LightGray' | kw= 'LightGreen' | kw= 'LightGrey' | kw= 'LightPink' | kw= 'LightSalmon' | kw= 'LightSeaGreen' | kw= 'LightSkyBlue' | kw= 'LightSlateGray' | kw= 'LightSlateGrey' | kw= 'LightSteelBlue' | kw= 'LightYellow' | kw= 'Lime' | kw= 'LimeGreen' | kw= 'Linen' | kw= 'Magenta' | kw= 'Maroon' | kw= 'MediumAquaMarine' | kw= 'MediumBlue' | kw= 'MediumOrchid' | kw= 'MediumPurple' | kw= 'MediumSeaGreen' | kw= 'MediumSlateBlue' | kw= 'MediumSpringGreen' | kw= 'MediumTurquoise' | kw= 'MediumVioletRed' | kw= 'MidnightBlue' | kw= 'MintCream' | kw= 'MistyRose' | kw= 'Moccasin' | kw= 'NavajoWhite' | kw= 'Navy' | kw= 'OldLace' | kw= 'Olive' | kw= 'OliveDrab' | kw= 'OrangeRed' | kw= 'Orchid' | kw= 'PaleGoldenRod' | kw= 'PaleGreen' | kw= 'PaleTurquoise' | kw= 'PaleVioletRed' | kw= 'PapayaWhip' | kw= 'PeachPuff' | kw= 'Peru' | kw= 'Pink' | kw= 'Plum' | kw= 'PowderBlue' | kw= 'Purple' | kw= 'Red' | kw= 'RosyBrown' | kw= 'RoyalBlue' | kw= 'SaddleBrown' | kw= 'Salmon' | kw= 'SandyBrown' | kw= 'SeaGreen' | kw= 'Sienna' | kw= 'Silver' | kw= 'SkyBlue' | kw= 'SlateBlue' | kw= 'SlateGray' | kw= 'SlateGrey' | kw= 'Snow' | kw= 'SpringGreen' | kw= 'SteelBlue' | kw= 'Tan' | kw= 'Teal' | kw= 'Thistle' | kw= 'Tomato' | kw= 'Turquoise' | kw= 'Violet' | kw= 'Wheat' | kw= 'White' | kw= 'WhiteSmoke' | kw= 'Yellow' | kw= 'YellowGreen' )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:968:2: (kw= '#' )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==30) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:969:2: kw= '#'
            	    {
            	    kw=(Token)match(input,30,FOLLOW_30_in_ruleColor2304); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getColorAccess().getNumberSignKeyword_0()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:974:3: (kw= 'AliceBlue' | kw= 'AntiqueWhite' | kw= 'Aqua' | kw= 'Aquamarine' | kw= 'Azure' | kw= 'Beige' | kw= 'Bisque' | kw= 'Black' | kw= 'BlanchedAlmond' | kw= 'Blue' | kw= 'BlueViolet' | kw= 'Brown' | kw= 'BurlyWood' | kw= 'CadetBlue' | kw= 'Chartreuse' | kw= 'Chocolate' | kw= 'Coral' | kw= 'CornflowerBlue' | kw= 'Cornsilk' | kw= 'Crimson' | kw= 'Cyan' | kw= 'DarkBlue' | kw= 'DarkCyan' | kw= 'DarkGoldenRod' | kw= 'DarkGray' | kw= 'DarkGreen' | kw= 'DarkGrey' | kw= 'DarkKhaki' | kw= 'DarkMagenta' | kw= 'DarkOliveGreen' | kw= 'DarkOrchid' | kw= 'DarkRed' | kw= 'DarkSalmo' | kw= 'DarkSeaGreen' | kw= 'DarkSlateBlue' | kw= 'DarkSlateGray' | kw= 'DarkSlateGrey' | kw= 'DarkTurquoise' | kw= 'DarkViolet' | kw= 'Darkorange' | kw= 'DeepPink' | kw= 'DeepSkyBlue' | kw= 'DimGray' | kw= 'DimGrey' | kw= 'DodgerBlue' | kw= 'FireBrick' | kw= 'FloralWhite' | kw= 'ForestGreen' | kw= 'Fuchsia' | kw= 'Gainsboro' | kw= 'GhostWhite' | kw= 'Gold' | kw= 'GoldenRod' | kw= 'Gray' | kw= 'Green' | kw= 'GreenYellow' | kw= 'Grey' | kw= 'HoneyDew' | kw= 'HotPink' | kw= 'IndianRed' | kw= 'Indigo' | kw= 'Ivory' | kw= 'Khaki' | kw= 'Lavender' | kw= 'LavenderBlush' | kw= 'LawnGreen' | kw= 'LemonChiffon' | kw= 'LightBlue' | kw= 'LightCoral' | kw= 'LightCyan' | kw= 'LightGoldenRodYellow' | kw= 'LightGray' | kw= 'LightGreen' | kw= 'LightGrey' | kw= 'LightPink' | kw= 'LightSalmon' | kw= 'LightSeaGreen' | kw= 'LightSkyBlue' | kw= 'LightSlateGray' | kw= 'LightSlateGrey' | kw= 'LightSteelBlue' | kw= 'LightYellow' | kw= 'Lime' | kw= 'LimeGreen' | kw= 'Linen' | kw= 'Magenta' | kw= 'Maroon' | kw= 'MediumAquaMarine' | kw= 'MediumBlue' | kw= 'MediumOrchid' | kw= 'MediumPurple' | kw= 'MediumSeaGreen' | kw= 'MediumSlateBlue' | kw= 'MediumSpringGreen' | kw= 'MediumTurquoise' | kw= 'MediumVioletRed' | kw= 'MidnightBlue' | kw= 'MintCream' | kw= 'MistyRose' | kw= 'Moccasin' | kw= 'NavajoWhite' | kw= 'Navy' | kw= 'OldLace' | kw= 'Olive' | kw= 'OliveDrab' | kw= 'OrangeRed' | kw= 'Orchid' | kw= 'PaleGoldenRod' | kw= 'PaleGreen' | kw= 'PaleTurquoise' | kw= 'PaleVioletRed' | kw= 'PapayaWhip' | kw= 'PeachPuff' | kw= 'Peru' | kw= 'Pink' | kw= 'Plum' | kw= 'PowderBlue' | kw= 'Purple' | kw= 'Red' | kw= 'RosyBrown' | kw= 'RoyalBlue' | kw= 'SaddleBrown' | kw= 'Salmon' | kw= 'SandyBrown' | kw= 'SeaGreen' | kw= 'Sienna' | kw= 'Silver' | kw= 'SkyBlue' | kw= 'SlateBlue' | kw= 'SlateGray' | kw= 'SlateGrey' | kw= 'Snow' | kw= 'SpringGreen' | kw= 'SteelBlue' | kw= 'Tan' | kw= 'Teal' | kw= 'Thistle' | kw= 'Tomato' | kw= 'Turquoise' | kw= 'Violet' | kw= 'Wheat' | kw= 'White' | kw= 'WhiteSmoke' | kw= 'Yellow' | kw= 'YellowGreen' )
            int alt23=145;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt23=1;
                }
                break;
            case 32:
                {
                alt23=2;
                }
                break;
            case 33:
                {
                alt23=3;
                }
                break;
            case 34:
                {
                alt23=4;
                }
                break;
            case 35:
                {
                alt23=5;
                }
                break;
            case 36:
                {
                alt23=6;
                }
                break;
            case 37:
                {
                alt23=7;
                }
                break;
            case 38:
                {
                alt23=8;
                }
                break;
            case 39:
                {
                alt23=9;
                }
                break;
            case 40:
                {
                alt23=10;
                }
                break;
            case 41:
                {
                alt23=11;
                }
                break;
            case 42:
                {
                alt23=12;
                }
                break;
            case 43:
                {
                alt23=13;
                }
                break;
            case 44:
                {
                alt23=14;
                }
                break;
            case 45:
                {
                alt23=15;
                }
                break;
            case 46:
                {
                alt23=16;
                }
                break;
            case 47:
                {
                alt23=17;
                }
                break;
            case 48:
                {
                alt23=18;
                }
                break;
            case 49:
                {
                alt23=19;
                }
                break;
            case 50:
                {
                alt23=20;
                }
                break;
            case 51:
                {
                alt23=21;
                }
                break;
            case 52:
                {
                alt23=22;
                }
                break;
            case 53:
                {
                alt23=23;
                }
                break;
            case 54:
                {
                alt23=24;
                }
                break;
            case 55:
                {
                alt23=25;
                }
                break;
            case 56:
                {
                alt23=26;
                }
                break;
            case 57:
                {
                alt23=27;
                }
                break;
            case 58:
                {
                alt23=28;
                }
                break;
            case 59:
                {
                alt23=29;
                }
                break;
            case 60:
                {
                alt23=30;
                }
                break;
            case 61:
                {
                alt23=31;
                }
                break;
            case 62:
                {
                alt23=32;
                }
                break;
            case 63:
                {
                alt23=33;
                }
                break;
            case 64:
                {
                alt23=34;
                }
                break;
            case 65:
                {
                alt23=35;
                }
                break;
            case 66:
                {
                alt23=36;
                }
                break;
            case 67:
                {
                alt23=37;
                }
                break;
            case 68:
                {
                alt23=38;
                }
                break;
            case 69:
                {
                alt23=39;
                }
                break;
            case 70:
                {
                alt23=40;
                }
                break;
            case 71:
                {
                alt23=41;
                }
                break;
            case 72:
                {
                alt23=42;
                }
                break;
            case 73:
                {
                alt23=43;
                }
                break;
            case 74:
                {
                alt23=44;
                }
                break;
            case 75:
                {
                alt23=45;
                }
                break;
            case 76:
                {
                alt23=46;
                }
                break;
            case 77:
                {
                alt23=47;
                }
                break;
            case 78:
                {
                alt23=48;
                }
                break;
            case 79:
                {
                alt23=49;
                }
                break;
            case 80:
                {
                alt23=50;
                }
                break;
            case 81:
                {
                alt23=51;
                }
                break;
            case 82:
                {
                alt23=52;
                }
                break;
            case 83:
                {
                alt23=53;
                }
                break;
            case 84:
                {
                alt23=54;
                }
                break;
            case 85:
                {
                alt23=55;
                }
                break;
            case 86:
                {
                alt23=56;
                }
                break;
            case 87:
                {
                alt23=57;
                }
                break;
            case 88:
                {
                alt23=58;
                }
                break;
            case 89:
                {
                alt23=59;
                }
                break;
            case 90:
                {
                alt23=60;
                }
                break;
            case 91:
                {
                alt23=61;
                }
                break;
            case 92:
                {
                alt23=62;
                }
                break;
            case 93:
                {
                alt23=63;
                }
                break;
            case 94:
                {
                alt23=64;
                }
                break;
            case 95:
                {
                alt23=65;
                }
                break;
            case 96:
                {
                alt23=66;
                }
                break;
            case 97:
                {
                alt23=67;
                }
                break;
            case 98:
                {
                alt23=68;
                }
                break;
            case 99:
                {
                alt23=69;
                }
                break;
            case 100:
                {
                alt23=70;
                }
                break;
            case 101:
                {
                alt23=71;
                }
                break;
            case 102:
                {
                alt23=72;
                }
                break;
            case 103:
                {
                alt23=73;
                }
                break;
            case 104:
                {
                alt23=74;
                }
                break;
            case 105:
                {
                alt23=75;
                }
                break;
            case 106:
                {
                alt23=76;
                }
                break;
            case 107:
                {
                alt23=77;
                }
                break;
            case 108:
                {
                alt23=78;
                }
                break;
            case 109:
                {
                alt23=79;
                }
                break;
            case 110:
                {
                alt23=80;
                }
                break;
            case 111:
                {
                alt23=81;
                }
                break;
            case 112:
                {
                alt23=82;
                }
                break;
            case 113:
                {
                alt23=83;
                }
                break;
            case 114:
                {
                alt23=84;
                }
                break;
            case 115:
                {
                alt23=85;
                }
                break;
            case 116:
                {
                alt23=86;
                }
                break;
            case 117:
                {
                alt23=87;
                }
                break;
            case 118:
                {
                alt23=88;
                }
                break;
            case 119:
                {
                alt23=89;
                }
                break;
            case 120:
                {
                alt23=90;
                }
                break;
            case 121:
                {
                alt23=91;
                }
                break;
            case 122:
                {
                alt23=92;
                }
                break;
            case 123:
                {
                alt23=93;
                }
                break;
            case 124:
                {
                alt23=94;
                }
                break;
            case 125:
                {
                alt23=95;
                }
                break;
            case 126:
                {
                alt23=96;
                }
                break;
            case 127:
                {
                alt23=97;
                }
                break;
            case 128:
                {
                alt23=98;
                }
                break;
            case 129:
                {
                alt23=99;
                }
                break;
            case 130:
                {
                alt23=100;
                }
                break;
            case 131:
                {
                alt23=101;
                }
                break;
            case 132:
                {
                alt23=102;
                }
                break;
            case 133:
                {
                alt23=103;
                }
                break;
            case 134:
                {
                alt23=104;
                }
                break;
            case 135:
                {
                alt23=105;
                }
                break;
            case 136:
                {
                alt23=106;
                }
                break;
            case 137:
                {
                alt23=107;
                }
                break;
            case 138:
                {
                alt23=108;
                }
                break;
            case 139:
                {
                alt23=109;
                }
                break;
            case 140:
                {
                alt23=110;
                }
                break;
            case 141:
                {
                alt23=111;
                }
                break;
            case 142:
                {
                alt23=112;
                }
                break;
            case 143:
                {
                alt23=113;
                }
                break;
            case 144:
                {
                alt23=114;
                }
                break;
            case 145:
                {
                alt23=115;
                }
                break;
            case 146:
                {
                alt23=116;
                }
                break;
            case 147:
                {
                alt23=117;
                }
                break;
            case 148:
                {
                alt23=118;
                }
                break;
            case 149:
                {
                alt23=119;
                }
                break;
            case 150:
                {
                alt23=120;
                }
                break;
            case 151:
                {
                alt23=121;
                }
                break;
            case 152:
                {
                alt23=122;
                }
                break;
            case 153:
                {
                alt23=123;
                }
                break;
            case 154:
                {
                alt23=124;
                }
                break;
            case 155:
                {
                alt23=125;
                }
                break;
            case 156:
                {
                alt23=126;
                }
                break;
            case 157:
                {
                alt23=127;
                }
                break;
            case 158:
                {
                alt23=128;
                }
                break;
            case 159:
                {
                alt23=129;
                }
                break;
            case 160:
                {
                alt23=130;
                }
                break;
            case 161:
                {
                alt23=131;
                }
                break;
            case 162:
                {
                alt23=132;
                }
                break;
            case 163:
                {
                alt23=133;
                }
                break;
            case 164:
                {
                alt23=134;
                }
                break;
            case 165:
                {
                alt23=135;
                }
                break;
            case 166:
                {
                alt23=136;
                }
                break;
            case 167:
                {
                alt23=137;
                }
                break;
            case 168:
                {
                alt23=138;
                }
                break;
            case 169:
                {
                alt23=139;
                }
                break;
            case 170:
                {
                alt23=140;
                }
                break;
            case 171:
                {
                alt23=141;
                }
                break;
            case 172:
                {
                alt23=142;
                }
                break;
            case 173:
                {
                alt23=143;
                }
                break;
            case 174:
                {
                alt23=144;
                }
                break;
            case 175:
                {
                alt23=145;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:975:2: kw= 'AliceBlue'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleColor2320); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAliceBlueKeyword_1_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:982:2: kw= 'AntiqueWhite'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleColor2339); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:989:2: kw= 'Aqua'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleColor2358); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAquaKeyword_1_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:996:2: kw= 'Aquamarine'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleColor2377); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAquamarineKeyword_1_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1003:2: kw= 'Azure'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleColor2396); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAzureKeyword_1_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1010:2: kw= 'Beige'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleColor2415); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBeigeKeyword_1_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1017:2: kw= 'Bisque'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleColor2434); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBisqueKeyword_1_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1024:2: kw= 'Black'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleColor2453); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlackKeyword_1_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1031:2: kw= 'BlanchedAlmond'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleColor2472); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlanchedAlmondKeyword_1_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1038:2: kw= 'Blue'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleColor2491); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlueKeyword_1_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1045:2: kw= 'BlueViolet'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleColor2510); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlueVioletKeyword_1_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1052:2: kw= 'Brown'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleColor2529); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBrownKeyword_1_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1059:2: kw= 'BurlyWood'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleColor2548); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBurlyWoodKeyword_1_12()); 
                        

                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1066:2: kw= 'CadetBlue'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleColor2567); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCadetBlueKeyword_1_13()); 
                        

                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1073:2: kw= 'Chartreuse'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleColor2586); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getChartreuseKeyword_1_14()); 
                        

                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1080:2: kw= 'Chocolate'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleColor2605); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getChocolateKeyword_1_15()); 
                        

                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1087:2: kw= 'Coral'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleColor2624); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCoralKeyword_1_16()); 
                        

                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1094:2: kw= 'CornflowerBlue'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleColor2643); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCornflowerBlueKeyword_1_17()); 
                        

                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1101:2: kw= 'Cornsilk'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleColor2662); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCornsilkKeyword_1_18()); 
                        

                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1108:2: kw= 'Crimson'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleColor2681); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCrimsonKeyword_1_19()); 
                        

                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1115:2: kw= 'Cyan'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleColor2700); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCyanKeyword_1_20()); 
                        

                    }
                    break;
                case 22 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1122:2: kw= 'DarkBlue'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleColor2719); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkBlueKeyword_1_21()); 
                        

                    }
                    break;
                case 23 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1129:2: kw= 'DarkCyan'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleColor2738); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkCyanKeyword_1_22()); 
                        

                    }
                    break;
                case 24 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1136:2: kw= 'DarkGoldenRod'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleColor2757); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGoldenRodKeyword_1_23()); 
                        

                    }
                    break;
                case 25 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1143:2: kw= 'DarkGray'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleColor2776); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGrayKeyword_1_24()); 
                        

                    }
                    break;
                case 26 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1150:2: kw= 'DarkGreen'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleColor2795); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGreenKeyword_1_25()); 
                        

                    }
                    break;
                case 27 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1157:2: kw= 'DarkGrey'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleColor2814); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGreyKeyword_1_26()); 
                        

                    }
                    break;
                case 28 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1164:2: kw= 'DarkKhaki'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleColor2833); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkKhakiKeyword_1_27()); 
                        

                    }
                    break;
                case 29 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1171:2: kw= 'DarkMagenta'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleColor2852); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkMagentaKeyword_1_28()); 
                        

                    }
                    break;
                case 30 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1178:2: kw= 'DarkOliveGreen'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleColor2871); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkOliveGreenKeyword_1_29()); 
                        

                    }
                    break;
                case 31 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1185:2: kw= 'DarkOrchid'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleColor2890); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkOrchidKeyword_1_30()); 
                        

                    }
                    break;
                case 32 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1192:2: kw= 'DarkRed'
                    {
                    kw=(Token)match(input,62,FOLLOW_62_in_ruleColor2909); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkRedKeyword_1_31()); 
                        

                    }
                    break;
                case 33 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1199:2: kw= 'DarkSalmo'
                    {
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleColor2928); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSalmoKeyword_1_32()); 
                        

                    }
                    break;
                case 34 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1206:2: kw= 'DarkSeaGreen'
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleColor2947); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSeaGreenKeyword_1_33()); 
                        

                    }
                    break;
                case 35 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1213:2: kw= 'DarkSlateBlue'
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleColor2966); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSlateBlueKeyword_1_34()); 
                        

                    }
                    break;
                case 36 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1220:2: kw= 'DarkSlateGray'
                    {
                    kw=(Token)match(input,66,FOLLOW_66_in_ruleColor2985); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSlateGrayKeyword_1_35()); 
                        

                    }
                    break;
                case 37 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1227:2: kw= 'DarkSlateGrey'
                    {
                    kw=(Token)match(input,67,FOLLOW_67_in_ruleColor3004); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSlateGreyKeyword_1_36()); 
                        

                    }
                    break;
                case 38 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1234:2: kw= 'DarkTurquoise'
                    {
                    kw=(Token)match(input,68,FOLLOW_68_in_ruleColor3023); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkTurquoiseKeyword_1_37()); 
                        

                    }
                    break;
                case 39 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1241:2: kw= 'DarkViolet'
                    {
                    kw=(Token)match(input,69,FOLLOW_69_in_ruleColor3042); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkVioletKeyword_1_38()); 
                        

                    }
                    break;
                case 40 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1248:2: kw= 'Darkorange'
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleColor3061); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkorangeKeyword_1_39()); 
                        

                    }
                    break;
                case 41 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1255:2: kw= 'DeepPink'
                    {
                    kw=(Token)match(input,71,FOLLOW_71_in_ruleColor3080); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDeepPinkKeyword_1_40()); 
                        

                    }
                    break;
                case 42 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1262:2: kw= 'DeepSkyBlue'
                    {
                    kw=(Token)match(input,72,FOLLOW_72_in_ruleColor3099); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDeepSkyBlueKeyword_1_41()); 
                        

                    }
                    break;
                case 43 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1269:2: kw= 'DimGray'
                    {
                    kw=(Token)match(input,73,FOLLOW_73_in_ruleColor3118); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDimGrayKeyword_1_42()); 
                        

                    }
                    break;
                case 44 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1276:2: kw= 'DimGrey'
                    {
                    kw=(Token)match(input,74,FOLLOW_74_in_ruleColor3137); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDimGreyKeyword_1_43()); 
                        

                    }
                    break;
                case 45 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1283:2: kw= 'DodgerBlue'
                    {
                    kw=(Token)match(input,75,FOLLOW_75_in_ruleColor3156); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDodgerBlueKeyword_1_44()); 
                        

                    }
                    break;
                case 46 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1290:2: kw= 'FireBrick'
                    {
                    kw=(Token)match(input,76,FOLLOW_76_in_ruleColor3175); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getFireBrickKeyword_1_45()); 
                        

                    }
                    break;
                case 47 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1297:2: kw= 'FloralWhite'
                    {
                    kw=(Token)match(input,77,FOLLOW_77_in_ruleColor3194); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getFloralWhiteKeyword_1_46()); 
                        

                    }
                    break;
                case 48 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1304:2: kw= 'ForestGreen'
                    {
                    kw=(Token)match(input,78,FOLLOW_78_in_ruleColor3213); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getForestGreenKeyword_1_47()); 
                        

                    }
                    break;
                case 49 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1311:2: kw= 'Fuchsia'
                    {
                    kw=(Token)match(input,79,FOLLOW_79_in_ruleColor3232); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getFuchsiaKeyword_1_48()); 
                        

                    }
                    break;
                case 50 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1318:2: kw= 'Gainsboro'
                    {
                    kw=(Token)match(input,80,FOLLOW_80_in_ruleColor3251); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGainsboroKeyword_1_49()); 
                        

                    }
                    break;
                case 51 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1325:2: kw= 'GhostWhite'
                    {
                    kw=(Token)match(input,81,FOLLOW_81_in_ruleColor3270); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGhostWhiteKeyword_1_50()); 
                        

                    }
                    break;
                case 52 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1332:2: kw= 'Gold'
                    {
                    kw=(Token)match(input,82,FOLLOW_82_in_ruleColor3289); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGoldKeyword_1_51()); 
                        

                    }
                    break;
                case 53 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1339:2: kw= 'GoldenRod'
                    {
                    kw=(Token)match(input,83,FOLLOW_83_in_ruleColor3308); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGoldenRodKeyword_1_52()); 
                        

                    }
                    break;
                case 54 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1346:2: kw= 'Gray'
                    {
                    kw=(Token)match(input,84,FOLLOW_84_in_ruleColor3327); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGrayKeyword_1_53()); 
                        

                    }
                    break;
                case 55 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1353:2: kw= 'Green'
                    {
                    kw=(Token)match(input,85,FOLLOW_85_in_ruleColor3346); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGreenKeyword_1_54()); 
                        

                    }
                    break;
                case 56 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1360:2: kw= 'GreenYellow'
                    {
                    kw=(Token)match(input,86,FOLLOW_86_in_ruleColor3365); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGreenYellowKeyword_1_55()); 
                        

                    }
                    break;
                case 57 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1367:2: kw= 'Grey'
                    {
                    kw=(Token)match(input,87,FOLLOW_87_in_ruleColor3384); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGreyKeyword_1_56()); 
                        

                    }
                    break;
                case 58 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1374:2: kw= 'HoneyDew'
                    {
                    kw=(Token)match(input,88,FOLLOW_88_in_ruleColor3403); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getHoneyDewKeyword_1_57()); 
                        

                    }
                    break;
                case 59 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1381:2: kw= 'HotPink'
                    {
                    kw=(Token)match(input,89,FOLLOW_89_in_ruleColor3422); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getHotPinkKeyword_1_58()); 
                        

                    }
                    break;
                case 60 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1388:2: kw= 'IndianRed'
                    {
                    kw=(Token)match(input,90,FOLLOW_90_in_ruleColor3441); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getIndianRedKeyword_1_59()); 
                        

                    }
                    break;
                case 61 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1395:2: kw= 'Indigo'
                    {
                    kw=(Token)match(input,91,FOLLOW_91_in_ruleColor3460); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getIndigoKeyword_1_60()); 
                        

                    }
                    break;
                case 62 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1402:2: kw= 'Ivory'
                    {
                    kw=(Token)match(input,92,FOLLOW_92_in_ruleColor3479); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getIvoryKeyword_1_61()); 
                        

                    }
                    break;
                case 63 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1409:2: kw= 'Khaki'
                    {
                    kw=(Token)match(input,93,FOLLOW_93_in_ruleColor3498); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getKhakiKeyword_1_62()); 
                        

                    }
                    break;
                case 64 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1416:2: kw= 'Lavender'
                    {
                    kw=(Token)match(input,94,FOLLOW_94_in_ruleColor3517); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLavenderKeyword_1_63()); 
                        

                    }
                    break;
                case 65 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1423:2: kw= 'LavenderBlush'
                    {
                    kw=(Token)match(input,95,FOLLOW_95_in_ruleColor3536); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLavenderBlushKeyword_1_64()); 
                        

                    }
                    break;
                case 66 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1430:2: kw= 'LawnGreen'
                    {
                    kw=(Token)match(input,96,FOLLOW_96_in_ruleColor3555); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLawnGreenKeyword_1_65()); 
                        

                    }
                    break;
                case 67 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1437:2: kw= 'LemonChiffon'
                    {
                    kw=(Token)match(input,97,FOLLOW_97_in_ruleColor3574); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLemonChiffonKeyword_1_66()); 
                        

                    }
                    break;
                case 68 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1444:2: kw= 'LightBlue'
                    {
                    kw=(Token)match(input,98,FOLLOW_98_in_ruleColor3593); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightBlueKeyword_1_67()); 
                        

                    }
                    break;
                case 69 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1451:2: kw= 'LightCoral'
                    {
                    kw=(Token)match(input,99,FOLLOW_99_in_ruleColor3612); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightCoralKeyword_1_68()); 
                        

                    }
                    break;
                case 70 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1458:2: kw= 'LightCyan'
                    {
                    kw=(Token)match(input,100,FOLLOW_100_in_ruleColor3631); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightCyanKeyword_1_69()); 
                        

                    }
                    break;
                case 71 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1465:2: kw= 'LightGoldenRodYellow'
                    {
                    kw=(Token)match(input,101,FOLLOW_101_in_ruleColor3650); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_1_70()); 
                        

                    }
                    break;
                case 72 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1472:2: kw= 'LightGray'
                    {
                    kw=(Token)match(input,102,FOLLOW_102_in_ruleColor3669); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGrayKeyword_1_71()); 
                        

                    }
                    break;
                case 73 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1479:2: kw= 'LightGreen'
                    {
                    kw=(Token)match(input,103,FOLLOW_103_in_ruleColor3688); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGreenKeyword_1_72()); 
                        

                    }
                    break;
                case 74 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1486:2: kw= 'LightGrey'
                    {
                    kw=(Token)match(input,104,FOLLOW_104_in_ruleColor3707); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGreyKeyword_1_73()); 
                        

                    }
                    break;
                case 75 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1493:2: kw= 'LightPink'
                    {
                    kw=(Token)match(input,105,FOLLOW_105_in_ruleColor3726); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightPinkKeyword_1_74()); 
                        

                    }
                    break;
                case 76 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1500:2: kw= 'LightSalmon'
                    {
                    kw=(Token)match(input,106,FOLLOW_106_in_ruleColor3745); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSalmonKeyword_1_75()); 
                        

                    }
                    break;
                case 77 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1507:2: kw= 'LightSeaGreen'
                    {
                    kw=(Token)match(input,107,FOLLOW_107_in_ruleColor3764); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSeaGreenKeyword_1_76()); 
                        

                    }
                    break;
                case 78 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1514:2: kw= 'LightSkyBlue'
                    {
                    kw=(Token)match(input,108,FOLLOW_108_in_ruleColor3783); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSkyBlueKeyword_1_77()); 
                        

                    }
                    break;
                case 79 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1521:2: kw= 'LightSlateGray'
                    {
                    kw=(Token)match(input,109,FOLLOW_109_in_ruleColor3802); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSlateGrayKeyword_1_78()); 
                        

                    }
                    break;
                case 80 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1528:2: kw= 'LightSlateGrey'
                    {
                    kw=(Token)match(input,110,FOLLOW_110_in_ruleColor3821); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSlateGreyKeyword_1_79()); 
                        

                    }
                    break;
                case 81 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1535:2: kw= 'LightSteelBlue'
                    {
                    kw=(Token)match(input,111,FOLLOW_111_in_ruleColor3840); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSteelBlueKeyword_1_80()); 
                        

                    }
                    break;
                case 82 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1542:2: kw= 'LightYellow'
                    {
                    kw=(Token)match(input,112,FOLLOW_112_in_ruleColor3859); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightYellowKeyword_1_81()); 
                        

                    }
                    break;
                case 83 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1549:2: kw= 'Lime'
                    {
                    kw=(Token)match(input,113,FOLLOW_113_in_ruleColor3878); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLimeKeyword_1_82()); 
                        

                    }
                    break;
                case 84 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1556:2: kw= 'LimeGreen'
                    {
                    kw=(Token)match(input,114,FOLLOW_114_in_ruleColor3897); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLimeGreenKeyword_1_83()); 
                        

                    }
                    break;
                case 85 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1563:2: kw= 'Linen'
                    {
                    kw=(Token)match(input,115,FOLLOW_115_in_ruleColor3916); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLinenKeyword_1_84()); 
                        

                    }
                    break;
                case 86 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1570:2: kw= 'Magenta'
                    {
                    kw=(Token)match(input,116,FOLLOW_116_in_ruleColor3935); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMagentaKeyword_1_85()); 
                        

                    }
                    break;
                case 87 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1577:2: kw= 'Maroon'
                    {
                    kw=(Token)match(input,117,FOLLOW_117_in_ruleColor3954); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMaroonKeyword_1_86()); 
                        

                    }
                    break;
                case 88 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1584:2: kw= 'MediumAquaMarine'
                    {
                    kw=(Token)match(input,118,FOLLOW_118_in_ruleColor3973); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumAquaMarineKeyword_1_87()); 
                        

                    }
                    break;
                case 89 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1591:2: kw= 'MediumBlue'
                    {
                    kw=(Token)match(input,119,FOLLOW_119_in_ruleColor3992); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumBlueKeyword_1_88()); 
                        

                    }
                    break;
                case 90 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1598:2: kw= 'MediumOrchid'
                    {
                    kw=(Token)match(input,120,FOLLOW_120_in_ruleColor4011); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumOrchidKeyword_1_89()); 
                        

                    }
                    break;
                case 91 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1605:2: kw= 'MediumPurple'
                    {
                    kw=(Token)match(input,121,FOLLOW_121_in_ruleColor4030); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumPurpleKeyword_1_90()); 
                        

                    }
                    break;
                case 92 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1612:2: kw= 'MediumSeaGreen'
                    {
                    kw=(Token)match(input,122,FOLLOW_122_in_ruleColor4049); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumSeaGreenKeyword_1_91()); 
                        

                    }
                    break;
                case 93 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1619:2: kw= 'MediumSlateBlue'
                    {
                    kw=(Token)match(input,123,FOLLOW_123_in_ruleColor4068); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumSlateBlueKeyword_1_92()); 
                        

                    }
                    break;
                case 94 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1626:2: kw= 'MediumSpringGreen'
                    {
                    kw=(Token)match(input,124,FOLLOW_124_in_ruleColor4087); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumSpringGreenKeyword_1_93()); 
                        

                    }
                    break;
                case 95 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1633:2: kw= 'MediumTurquoise'
                    {
                    kw=(Token)match(input,125,FOLLOW_125_in_ruleColor4106); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumTurquoiseKeyword_1_94()); 
                        

                    }
                    break;
                case 96 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1640:2: kw= 'MediumVioletRed'
                    {
                    kw=(Token)match(input,126,FOLLOW_126_in_ruleColor4125); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumVioletRedKeyword_1_95()); 
                        

                    }
                    break;
                case 97 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1647:2: kw= 'MidnightBlue'
                    {
                    kw=(Token)match(input,127,FOLLOW_127_in_ruleColor4144); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMidnightBlueKeyword_1_96()); 
                        

                    }
                    break;
                case 98 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1654:2: kw= 'MintCream'
                    {
                    kw=(Token)match(input,128,FOLLOW_128_in_ruleColor4163); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMintCreamKeyword_1_97()); 
                        

                    }
                    break;
                case 99 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1661:2: kw= 'MistyRose'
                    {
                    kw=(Token)match(input,129,FOLLOW_129_in_ruleColor4182); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMistyRoseKeyword_1_98()); 
                        

                    }
                    break;
                case 100 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1668:2: kw= 'Moccasin'
                    {
                    kw=(Token)match(input,130,FOLLOW_130_in_ruleColor4201); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMoccasinKeyword_1_99()); 
                        

                    }
                    break;
                case 101 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1675:2: kw= 'NavajoWhite'
                    {
                    kw=(Token)match(input,131,FOLLOW_131_in_ruleColor4220); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getNavajoWhiteKeyword_1_100()); 
                        

                    }
                    break;
                case 102 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1682:2: kw= 'Navy'
                    {
                    kw=(Token)match(input,132,FOLLOW_132_in_ruleColor4239); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getNavyKeyword_1_101()); 
                        

                    }
                    break;
                case 103 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1689:2: kw= 'OldLace'
                    {
                    kw=(Token)match(input,133,FOLLOW_133_in_ruleColor4258); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOldLaceKeyword_1_102()); 
                        

                    }
                    break;
                case 104 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1696:2: kw= 'Olive'
                    {
                    kw=(Token)match(input,134,FOLLOW_134_in_ruleColor4277); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOliveKeyword_1_103()); 
                        

                    }
                    break;
                case 105 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1703:2: kw= 'OliveDrab'
                    {
                    kw=(Token)match(input,135,FOLLOW_135_in_ruleColor4296); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOliveDrabKeyword_1_104()); 
                        

                    }
                    break;
                case 106 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1710:2: kw= 'OrangeRed'
                    {
                    kw=(Token)match(input,136,FOLLOW_136_in_ruleColor4315); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOrangeRedKeyword_1_105()); 
                        

                    }
                    break;
                case 107 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1717:2: kw= 'Orchid'
                    {
                    kw=(Token)match(input,137,FOLLOW_137_in_ruleColor4334); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOrchidKeyword_1_106()); 
                        

                    }
                    break;
                case 108 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1724:2: kw= 'PaleGoldenRod'
                    {
                    kw=(Token)match(input,138,FOLLOW_138_in_ruleColor4353); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleGoldenRodKeyword_1_107()); 
                        

                    }
                    break;
                case 109 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1731:2: kw= 'PaleGreen'
                    {
                    kw=(Token)match(input,139,FOLLOW_139_in_ruleColor4372); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleGreenKeyword_1_108()); 
                        

                    }
                    break;
                case 110 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1738:2: kw= 'PaleTurquoise'
                    {
                    kw=(Token)match(input,140,FOLLOW_140_in_ruleColor4391); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleTurquoiseKeyword_1_109()); 
                        

                    }
                    break;
                case 111 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1745:2: kw= 'PaleVioletRed'
                    {
                    kw=(Token)match(input,141,FOLLOW_141_in_ruleColor4410); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleVioletRedKeyword_1_110()); 
                        

                    }
                    break;
                case 112 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1752:2: kw= 'PapayaWhip'
                    {
                    kw=(Token)match(input,142,FOLLOW_142_in_ruleColor4429); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPapayaWhipKeyword_1_111()); 
                        

                    }
                    break;
                case 113 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1759:2: kw= 'PeachPuff'
                    {
                    kw=(Token)match(input,143,FOLLOW_143_in_ruleColor4448); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPeachPuffKeyword_1_112()); 
                        

                    }
                    break;
                case 114 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1766:2: kw= 'Peru'
                    {
                    kw=(Token)match(input,144,FOLLOW_144_in_ruleColor4467); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPeruKeyword_1_113()); 
                        

                    }
                    break;
                case 115 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1773:2: kw= 'Pink'
                    {
                    kw=(Token)match(input,145,FOLLOW_145_in_ruleColor4486); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPinkKeyword_1_114()); 
                        

                    }
                    break;
                case 116 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1780:2: kw= 'Plum'
                    {
                    kw=(Token)match(input,146,FOLLOW_146_in_ruleColor4505); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPlumKeyword_1_115()); 
                        

                    }
                    break;
                case 117 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1787:2: kw= 'PowderBlue'
                    {
                    kw=(Token)match(input,147,FOLLOW_147_in_ruleColor4524); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPowderBlueKeyword_1_116()); 
                        

                    }
                    break;
                case 118 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1794:2: kw= 'Purple'
                    {
                    kw=(Token)match(input,148,FOLLOW_148_in_ruleColor4543); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPurpleKeyword_1_117()); 
                        

                    }
                    break;
                case 119 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1801:2: kw= 'Red'
                    {
                    kw=(Token)match(input,149,FOLLOW_149_in_ruleColor4562); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getRedKeyword_1_118()); 
                        

                    }
                    break;
                case 120 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1808:2: kw= 'RosyBrown'
                    {
                    kw=(Token)match(input,150,FOLLOW_150_in_ruleColor4581); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getRosyBrownKeyword_1_119()); 
                        

                    }
                    break;
                case 121 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1815:2: kw= 'RoyalBlue'
                    {
                    kw=(Token)match(input,151,FOLLOW_151_in_ruleColor4600); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getRoyalBlueKeyword_1_120()); 
                        

                    }
                    break;
                case 122 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1822:2: kw= 'SaddleBrown'
                    {
                    kw=(Token)match(input,152,FOLLOW_152_in_ruleColor4619); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSaddleBrownKeyword_1_121()); 
                        

                    }
                    break;
                case 123 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1829:2: kw= 'Salmon'
                    {
                    kw=(Token)match(input,153,FOLLOW_153_in_ruleColor4638); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSalmonKeyword_1_122()); 
                        

                    }
                    break;
                case 124 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1836:2: kw= 'SandyBrown'
                    {
                    kw=(Token)match(input,154,FOLLOW_154_in_ruleColor4657); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSandyBrownKeyword_1_123()); 
                        

                    }
                    break;
                case 125 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1843:2: kw= 'SeaGreen'
                    {
                    kw=(Token)match(input,155,FOLLOW_155_in_ruleColor4676); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSeaGreenKeyword_1_124()); 
                        

                    }
                    break;
                case 126 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1850:2: kw= 'Sienna'
                    {
                    kw=(Token)match(input,156,FOLLOW_156_in_ruleColor4695); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSiennaKeyword_1_125()); 
                        

                    }
                    break;
                case 127 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1857:2: kw= 'Silver'
                    {
                    kw=(Token)match(input,157,FOLLOW_157_in_ruleColor4714); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSilverKeyword_1_126()); 
                        

                    }
                    break;
                case 128 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1864:2: kw= 'SkyBlue'
                    {
                    kw=(Token)match(input,158,FOLLOW_158_in_ruleColor4733); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSkyBlueKeyword_1_127()); 
                        

                    }
                    break;
                case 129 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1871:2: kw= 'SlateBlue'
                    {
                    kw=(Token)match(input,159,FOLLOW_159_in_ruleColor4752); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSlateBlueKeyword_1_128()); 
                        

                    }
                    break;
                case 130 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1878:2: kw= 'SlateGray'
                    {
                    kw=(Token)match(input,160,FOLLOW_160_in_ruleColor4771); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSlateGrayKeyword_1_129()); 
                        

                    }
                    break;
                case 131 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1885:2: kw= 'SlateGrey'
                    {
                    kw=(Token)match(input,161,FOLLOW_161_in_ruleColor4790); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSlateGreyKeyword_1_130()); 
                        

                    }
                    break;
                case 132 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1892:2: kw= 'Snow'
                    {
                    kw=(Token)match(input,162,FOLLOW_162_in_ruleColor4809); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSnowKeyword_1_131()); 
                        

                    }
                    break;
                case 133 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1899:2: kw= 'SpringGreen'
                    {
                    kw=(Token)match(input,163,FOLLOW_163_in_ruleColor4828); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSpringGreenKeyword_1_132()); 
                        

                    }
                    break;
                case 134 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1906:2: kw= 'SteelBlue'
                    {
                    kw=(Token)match(input,164,FOLLOW_164_in_ruleColor4847); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSteelBlueKeyword_1_133()); 
                        

                    }
                    break;
                case 135 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1913:2: kw= 'Tan'
                    {
                    kw=(Token)match(input,165,FOLLOW_165_in_ruleColor4866); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTanKeyword_1_134()); 
                        

                    }
                    break;
                case 136 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1920:2: kw= 'Teal'
                    {
                    kw=(Token)match(input,166,FOLLOW_166_in_ruleColor4885); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTealKeyword_1_135()); 
                        

                    }
                    break;
                case 137 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1927:2: kw= 'Thistle'
                    {
                    kw=(Token)match(input,167,FOLLOW_167_in_ruleColor4904); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getThistleKeyword_1_136()); 
                        

                    }
                    break;
                case 138 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1934:2: kw= 'Tomato'
                    {
                    kw=(Token)match(input,168,FOLLOW_168_in_ruleColor4923); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTomatoKeyword_1_137()); 
                        

                    }
                    break;
                case 139 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1941:2: kw= 'Turquoise'
                    {
                    kw=(Token)match(input,169,FOLLOW_169_in_ruleColor4942); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTurquoiseKeyword_1_138()); 
                        

                    }
                    break;
                case 140 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1948:2: kw= 'Violet'
                    {
                    kw=(Token)match(input,170,FOLLOW_170_in_ruleColor4961); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getVioletKeyword_1_139()); 
                        

                    }
                    break;
                case 141 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1955:2: kw= 'Wheat'
                    {
                    kw=(Token)match(input,171,FOLLOW_171_in_ruleColor4980); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getWheatKeyword_1_140()); 
                        

                    }
                    break;
                case 142 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1962:2: kw= 'White'
                    {
                    kw=(Token)match(input,172,FOLLOW_172_in_ruleColor4999); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getWhiteKeyword_1_141()); 
                        

                    }
                    break;
                case 143 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1969:2: kw= 'WhiteSmoke'
                    {
                    kw=(Token)match(input,173,FOLLOW_173_in_ruleColor5018); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getWhiteSmokeKeyword_1_142()); 
                        

                    }
                    break;
                case 144 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1976:2: kw= 'Yellow'
                    {
                    kw=(Token)match(input,174,FOLLOW_174_in_ruleColor5037); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getYellowKeyword_1_143()); 
                        

                    }
                    break;
                case 145 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1983:2: kw= 'YellowGreen'
                    {
                    kw=(Token)match(input,175,FOLLOW_175_in_ruleColor5056); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1996:1: entryRuleTitle returns [String current=null] : iv_ruleTitle= ruleTitle EOF ;
    public final String entryRuleTitle() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTitle = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1997:2: (iv_ruleTitle= ruleTitle EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1998:2: iv_ruleTitle= ruleTitle EOF
            {
             newCompositeNode(grammarAccess.getTitleRule()); 
            pushFollow(FOLLOW_ruleTitle_in_entryRuleTitle5098);
            iv_ruleTitle=ruleTitle();

            state._fsp--;

             current =iv_ruleTitle.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTitle5109); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2005:1: ruleTitle returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'title' this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleTitle() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2008:28: ( (kw= 'title' this_ID_1= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2009:1: (kw= 'title' this_ID_1= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2009:1: (kw= 'title' this_ID_1= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2010:2: kw= 'title' this_ID_1= RULE_ID
            {
            kw=(Token)match(input,176,FOLLOW_176_in_ruleTitle5147); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTitleAccess().getTitleKeyword_0()); 
                
            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTitle5162); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2030:1: entryRuleLegend returns [String current=null] : iv_ruleLegend= ruleLegend EOF ;
    public final String entryRuleLegend() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLegend = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2031:2: (iv_ruleLegend= ruleLegend EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2032:2: iv_ruleLegend= ruleLegend EOF
            {
             newCompositeNode(grammarAccess.getLegendRule()); 
            pushFollow(FOLLOW_ruleLegend_in_entryRuleLegend5208);
            iv_ruleLegend=ruleLegend();

            state._fsp--;

             current =iv_ruleLegend.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLegend5219); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2039:1: ruleLegend returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'legend' (kw= 'right' | kw= 'left' | kw= 'center' )? ( (this_NEWLINE_4= RULE_NEWLINE this_ID_5= RULE_ID ) | this_NEWLINE_6= RULE_NEWLINE )* this_NEWLINE_7= RULE_NEWLINE kw= 'endlegend' ) ;
    public final AntlrDatatypeRuleToken ruleLegend() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_NEWLINE_4=null;
        Token this_ID_5=null;
        Token this_NEWLINE_6=null;
        Token this_NEWLINE_7=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2042:28: ( (kw= 'legend' (kw= 'right' | kw= 'left' | kw= 'center' )? ( (this_NEWLINE_4= RULE_NEWLINE this_ID_5= RULE_ID ) | this_NEWLINE_6= RULE_NEWLINE )* this_NEWLINE_7= RULE_NEWLINE kw= 'endlegend' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2043:1: (kw= 'legend' (kw= 'right' | kw= 'left' | kw= 'center' )? ( (this_NEWLINE_4= RULE_NEWLINE this_ID_5= RULE_ID ) | this_NEWLINE_6= RULE_NEWLINE )* this_NEWLINE_7= RULE_NEWLINE kw= 'endlegend' )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2043:1: (kw= 'legend' (kw= 'right' | kw= 'left' | kw= 'center' )? ( (this_NEWLINE_4= RULE_NEWLINE this_ID_5= RULE_ID ) | this_NEWLINE_6= RULE_NEWLINE )* this_NEWLINE_7= RULE_NEWLINE kw= 'endlegend' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2044:2: kw= 'legend' (kw= 'right' | kw= 'left' | kw= 'center' )? ( (this_NEWLINE_4= RULE_NEWLINE this_ID_5= RULE_ID ) | this_NEWLINE_6= RULE_NEWLINE )* this_NEWLINE_7= RULE_NEWLINE kw= 'endlegend'
            {
            kw=(Token)match(input,177,FOLLOW_177_in_ruleLegend5257); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getLegendAccess().getLegendKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2049:1: (kw= 'right' | kw= 'left' | kw= 'center' )?
            int alt24=4;
            switch ( input.LA(1) ) {
                case 178:
                    {
                    alt24=1;
                    }
                    break;
                case 179:
                    {
                    alt24=2;
                    }
                    break;
                case 180:
                    {
                    alt24=3;
                    }
                    break;
            }

            switch (alt24) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2050:2: kw= 'right'
                    {
                    kw=(Token)match(input,178,FOLLOW_178_in_ruleLegend5271); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getRightKeyword_1_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2057:2: kw= 'left'
                    {
                    kw=(Token)match(input,179,FOLLOW_179_in_ruleLegend5290); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2064:2: kw= 'center'
                    {
                    kw=(Token)match(input,180,FOLLOW_180_in_ruleLegend5309); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getCenterKeyword_1_2()); 
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2069:3: ( (this_NEWLINE_4= RULE_NEWLINE this_ID_5= RULE_ID ) | this_NEWLINE_6= RULE_NEWLINE )*
            loop25:
            do {
                int alt25=3;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_NEWLINE) ) {
                    int LA25_1 = input.LA(2);

                    if ( (LA25_1==RULE_NEWLINE) ) {
                        alt25=2;
                    }
                    else if ( (LA25_1==RULE_ID) ) {
                        alt25=1;
                    }


                }


                switch (alt25) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2069:4: (this_NEWLINE_4= RULE_NEWLINE this_ID_5= RULE_ID )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2069:4: (this_NEWLINE_4= RULE_NEWLINE this_ID_5= RULE_ID )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2069:9: this_NEWLINE_4= RULE_NEWLINE this_ID_5= RULE_ID
            	    {
            	    this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleLegend5328); 

            	    		current.merge(this_NEWLINE_4);
            	        
            	     
            	        newLeafNode(this_NEWLINE_4, grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_0_0()); 
            	        
            	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLegend5348); 

            	    		current.merge(this_ID_5);
            	        
            	     
            	        newLeafNode(this_ID_5, grammarAccess.getLegendAccess().getIDTerminalRuleCall_2_0_1()); 
            	        

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2084:10: this_NEWLINE_6= RULE_NEWLINE
            	    {
            	    this_NEWLINE_6=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleLegend5375); 

            	    		current.merge(this_NEWLINE_6);
            	        
            	     
            	        newLeafNode(this_NEWLINE_6, grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleLegend5397); 

            		current.merge(this_NEWLINE_7);
                
             
                newLeafNode(this_NEWLINE_7, grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_3()); 
                
            kw=(Token)match(input,181,FOLLOW_181_in_ruleLegend5415); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2112:1: entryRuleNewpage returns [String current=null] : iv_ruleNewpage= ruleNewpage EOF ;
    public final String entryRuleNewpage() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNewpage = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2113:2: (iv_ruleNewpage= ruleNewpage EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2114:2: iv_ruleNewpage= ruleNewpage EOF
            {
             newCompositeNode(grammarAccess.getNewpageRule()); 
            pushFollow(FOLLOW_ruleNewpage_in_entryRuleNewpage5456);
            iv_ruleNewpage=ruleNewpage();

            state._fsp--;

             current =iv_ruleNewpage.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNewpage5467); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2121:1: ruleNewpage returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'newpage' (this_ID_1= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleNewpage() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2124:28: ( (kw= 'newpage' (this_ID_1= RULE_ID )? ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2125:1: (kw= 'newpage' (this_ID_1= RULE_ID )? )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2125:1: (kw= 'newpage' (this_ID_1= RULE_ID )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2126:2: kw= 'newpage' (this_ID_1= RULE_ID )?
            {
            kw=(Token)match(input,182,FOLLOW_182_in_ruleNewpage5505); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getNewpageAccess().getNewpageKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2131:1: (this_ID_1= RULE_ID )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:2131:6: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNewpage5521); 

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

    // Delegated rules


    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA18_eotS =
        "\43\uffff";
    static final String DFA18_eofS =
        "\6\uffff\1\23\3\uffff\1\32\1\35\12\uffff\1\32\5\uffff\1\40\1\uffff"+
        "\1\42\4\uffff";
    static final String DFA18_minS =
        "\3\16\1\uffff\1\16\1\20\1\5\1\uffff\1\16\1\uffff\2\5\4\uffff\1"+
        "\16\3\uffff\1\16\1\uffff\1\5\5\uffff\1\5\1\uffff\1\5\4\uffff";
    static final String DFA18_maxS =
        "\1\27\1\24\1\26\1\uffff\1\23\1\24\1\27\1\uffff\1\26\1\uffff\1\25"+
        "\1\17\4\uffff\1\16\3\uffff\1\24\1\uffff\1\25\5\uffff\1\25\1\uffff"+
        "\1\17\4\uffff";
    static final String DFA18_acceptS =
        "\3\uffff\1\4\3\uffff\1\7\1\uffff\1\11\2\uffff\1\22\1\6\1\10\1\12"+
        "\1\uffff\1\16\1\24\1\25\1\uffff\1\15\1\uffff\1\23\1\3\1\13\1\1\1"+
        "\5\1\uffff\1\2\1\uffff\1\20\1\17\1\21\1\14";
    static final String DFA18_specialS =
        "\43\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\1\1\uffff\1\2\1\3\1\uffff\1\4\1\uffff\1\5\1\uffff\1\6",
            "\1\10\1\12\2\uffff\1\7\1\uffff\1\11",
            "\1\13\1\uffff\1\15\5\uffff\1\14",
            "",
            "\1\16\4\uffff\1\17",
            "\1\20\3\uffff\1\21",
            "\1\23\21\uffff\1\22",
            "",
            "\1\24\1\26\2\uffff\1\7\1\25\1\11\1\uffff\1\27",
            "",
            "\1\32\11\uffff\1\33\1\uffff\1\30\3\uffff\1\31",
            "\1\35\10\uffff\1\35\1\34",
            "",
            "",
            "",
            "",
            "\1\36",
            "",
            "",
            "",
            "\1\24\1\26\2\uffff\1\7\1\25\1\11",
            "",
            "\1\32\11\uffff\1\33\5\uffff\1\31",
            "",
            "",
            "",
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
            return "301:1: ( ( (kw= '-' )* kw= '-' kw= '>' ) | (kw= '<' kw= '-' (kw= '-' )* ) | (kw= '-' kw= '>' kw= 'x' ) | (kw= 'x' kw= '<' kw= '-' ) | ( (kw= '-' )* kw= '-' kw= '>' kw= '>' ) | (kw= '<' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' ) | (kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' ) | (kw= '/' kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' ) | (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* ) | (kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '|' kw= '-' kw= '-' ) | (kw= '-' kw= '-' kw= '|' kw= '>' ) | (kw= '.' kw= '.' ) | kw= '.' )";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_ruleModel130 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleDiagram_in_entryRuleDiagram166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDiagram176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleDiagram213 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleDiagram224 = new BitSet(new long[]{0x000000003F001030L,0x0000000000000000L,0x0043000000000000L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleDiagram244 = new BitSet(new long[]{0x000000003F001030L,0x0000000000000000L,0x0043000000000000L});
    public static final BitSet FOLLOW_12_in_ruleDiagram257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction293 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstruction347 = new BitSet(new long[]{0x0000000000AB4000L});
    public static final BitSet FOLLOW_ruleSequence_in_ruleInstruction368 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstruction384 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_13_in_ruleInstruction402 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstruction413 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleInstruction444 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_ruleColor_in_ruleInstruction460 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_ruleInstruction484 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTitle_in_ruleInstruction505 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleLegend_in_ruleInstruction526 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNewpage_in_ruleInstruction547 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleInstruction559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequence_in_entryRuleSequence595 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequence606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleSequence646 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence661 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleSequence695 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence708 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence722 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence745 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence758 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSequence771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleSequence792 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSequence805 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleSequence840 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence855 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence868 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleSequence902 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSequence915 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence928 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence942 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence966 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence981 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSequence994 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSequence1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleSequence1028 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1041 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence1055 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence1079 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1094 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSequence1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleSequence1128 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleSequence1141 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1154 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence1168 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence1192 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1207 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence1220 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleSequence1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleSequence1254 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSequence1267 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1280 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence1294 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence1318 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1333 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1346 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleSequence1359 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleSequence1372 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleSequence1385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleSequence1406 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSequence1419 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1432 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1445 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence1459 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_16_in_ruleSequence1482 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1495 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleSequence1529 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1542 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence1555 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleSequence1568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleSequence1589 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSequence1602 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1615 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence1628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleSequence1649 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleSequence1662 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1675 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleSequence1709 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1722 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleSequence1735 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence1748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleSequence1769 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleSequence1782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleSequence1802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition1842 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition1852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleDefinition1890 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleDefinition1932 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleDefinition1974 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleDefinition2016 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition2033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleDefinition2058 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition2075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber2118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAutoNumber2129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleAutoNumber2167 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAutoNumber2183 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAutoNumber2204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_entryRuleColor2254 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColor2265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleColor2304 = new BitSet(new long[]{0xFFFFFFFFC0000000L,0xFFFFFFFFFFFFFFFFL,0x0000FFFFFFFFFFFFL});
    public static final BitSet FOLLOW_31_in_ruleColor2320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleColor2339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleColor2358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleColor2377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleColor2396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleColor2415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleColor2434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleColor2453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleColor2472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleColor2491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleColor2510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleColor2529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleColor2548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleColor2567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleColor2586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleColor2605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleColor2624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleColor2643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleColor2662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleColor2681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleColor2700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleColor2719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleColor2738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleColor2757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleColor2776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleColor2795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleColor2814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleColor2833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleColor2852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleColor2871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleColor2890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleColor2909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleColor2928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleColor2947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleColor2966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleColor2985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleColor3004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleColor3023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleColor3042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleColor3061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleColor3080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleColor3099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleColor3118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleColor3137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleColor3156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleColor3175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleColor3194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleColor3213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleColor3232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleColor3251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleColor3270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleColor3289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleColor3308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleColor3327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleColor3346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_ruleColor3365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_ruleColor3384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleColor3403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_ruleColor3422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_ruleColor3441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_ruleColor3460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_ruleColor3479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_ruleColor3498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_ruleColor3517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_ruleColor3536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_ruleColor3555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_ruleColor3574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_ruleColor3593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_ruleColor3612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_ruleColor3631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_ruleColor3650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_ruleColor3669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_ruleColor3688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_ruleColor3707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_ruleColor3726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_ruleColor3745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_ruleColor3764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_ruleColor3783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_ruleColor3802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_ruleColor3821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_ruleColor3840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_ruleColor3859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_ruleColor3878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_ruleColor3897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_ruleColor3916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_ruleColor3935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_ruleColor3954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_ruleColor3973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_ruleColor3992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_ruleColor4011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_ruleColor4030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_ruleColor4049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_ruleColor4068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_ruleColor4087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_ruleColor4106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_ruleColor4125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_ruleColor4144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_ruleColor4163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_ruleColor4182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_ruleColor4201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_ruleColor4220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_ruleColor4239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_ruleColor4258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_134_in_ruleColor4277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_135_in_ruleColor4296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_136_in_ruleColor4315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_137_in_ruleColor4334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_138_in_ruleColor4353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_139_in_ruleColor4372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_140_in_ruleColor4391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_141_in_ruleColor4410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_142_in_ruleColor4429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_143_in_ruleColor4448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_144_in_ruleColor4467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_145_in_ruleColor4486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_146_in_ruleColor4505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_147_in_ruleColor4524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_148_in_ruleColor4543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_149_in_ruleColor4562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_150_in_ruleColor4581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_151_in_ruleColor4600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_152_in_ruleColor4619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_153_in_ruleColor4638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_154_in_ruleColor4657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_155_in_ruleColor4676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_156_in_ruleColor4695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_157_in_ruleColor4714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_ruleColor4733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_ruleColor4752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_ruleColor4771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_ruleColor4790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_ruleColor4809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_ruleColor4828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_ruleColor4847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_ruleColor4866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_166_in_ruleColor4885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_167_in_ruleColor4904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_ruleColor4923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_169_in_ruleColor4942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_170_in_ruleColor4961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_171_in_ruleColor4980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_172_in_ruleColor4999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_173_in_ruleColor5018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_174_in_ruleColor5037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_175_in_ruleColor5056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_entryRuleTitle5098 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTitle5109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_176_in_ruleTitle5147 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTitle5162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLegend_in_entryRuleLegend5208 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLegend5219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_177_in_ruleLegend5257 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x001C000000000000L});
    public static final BitSet FOLLOW_178_in_ruleLegend5271 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_179_in_ruleLegend5290 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_180_in_ruleLegend5309 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleLegend5328 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLegend5348 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleLegend5375 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleLegend5397 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_181_in_ruleLegend5415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_entryRuleNewpage5456 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNewpage5467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_182_in_ruleNewpage5505 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNewpage5521 = new BitSet(new long[]{0x0000000000000002L});

}