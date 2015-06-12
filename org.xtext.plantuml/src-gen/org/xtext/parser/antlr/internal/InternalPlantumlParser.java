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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_INT", "RULE_WS", "RULE_ANY_OTHER", "'@startuml'", "'@enduml'", "':'", "'-'", "'>'", "'<'", "'x'", "'\\\\'", "'/'", "'\\\\\\\\'", "'o'", "'|'", "'.'", "'actor'", "'boundary'", "'control'", "'entity'", "'database'", "'autonumber'", "'#'", "'AliceBlue'", "'AntiqueWhite'", "'Aqua'", "'Aquamarine'", "'Azure'", "'Beige'", "'Bisque'", "'Black'", "'BlanchedAlmond'", "'Blue'", "'BlueViolet'", "'Brown'", "'BurlyWood'", "'CadetBlue'", "'Chartreuse'", "'Chocolate'", "'Coral'", "'CornflowerBlue'", "'Cornsilk'", "'Crimson'", "'Cyan'", "'DarkBlue'", "'DarkCyan'", "'DarkGoldenRod'", "'DarkGray'", "'DarkGreen'", "'DarkGrey'", "'DarkKhaki'", "'DarkMagenta'", "'DarkOliveGreen'", "'DarkOrchid'", "'DarkRed'", "'DarkSalmo'", "'DarkSeaGreen'", "'DarkSlateBlue'", "'DarkSlateGray'", "'DarkSlateGrey'", "'DarkTurquoise'", "'DarkViolet'", "'Darkorange'", "'DeepPink'", "'DeepSkyBlue'", "'DimGray'", "'DimGrey'", "'DodgerBlue'", "'FireBrick'", "'FloralWhite'", "'ForestGreen'", "'Fuchsia'", "'Gainsboro'", "'GhostWhite'", "'Gold'", "'GoldenRod'", "'Gray'", "'Green'", "'GreenYellow'", "'Grey'", "'HoneyDew'", "'HotPink'", "'IndianRed'", "'Indigo'", "'Ivory'", "'Khaki'", "'Lavender'", "'LavenderBlush'", "'LawnGreen'", "'LemonChiffon'", "'LightBlue'", "'LightCoral'", "'LightCyan'", "'LightGoldenRodYellow'", "'LightGray'", "'LightGreen'", "'LightGrey'", "'LightPink'", "'LightSalmon'", "'LightSeaGreen'", "'LightSkyBlue'", "'LightSlateGray'", "'LightSlateGrey'", "'LightSteelBlue'", "'LightYellow'", "'Lime'", "'LimeGreen'", "'Linen'", "'Magenta'", "'Maroon'", "'MediumAquaMarine'", "'MediumBlue'", "'MediumOrchid'", "'MediumPurple'", "'MediumSeaGreen'", "'MediumSlateBlue'", "'MediumSpringGreen'", "'MediumTurquoise'", "'MediumVioletRed'", "'MidnightBlue'", "'MintCream'", "'MistyRose'", "'Moccasin'", "'NavajoWhite'", "'Navy'", "'OldLace'", "'Olive'", "'OliveDrab'", "'OrangeRed'", "'Orchid'", "'PaleGoldenRod'", "'PaleGreen'", "'PaleTurquoise'", "'PaleVioletRed'", "'PapayaWhip'", "'PeachPuff'", "'Peru'", "'Pink'", "'Plum'", "'PowderBlue'", "'Purple'", "'Red'", "'RosyBrown'", "'RoyalBlue'", "'SaddleBrown'", "'Salmon'", "'SandyBrown'", "'SeaGreen'", "'Sienna'", "'Silver'", "'SkyBlue'", "'SlateBlue'", "'SlateGray'", "'SlateGrey'", "'Snow'", "'SpringGreen'", "'SteelBlue'", "'Tan'", "'Teal'", "'Thistle'", "'Tomato'", "'Turquoise'", "'Violet'", "'Wheat'", "'White'", "'WhiteSmoke'", "'Yellow'", "'YellowGreen'"
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
    public static final int RULE_ID=4;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=7;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=5;
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
    public static final int RULE_SL_COMMENT=6;
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

                if ( (LA1_0==10) ) {
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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:115:1: ruleDiagram returns [EObject current=null] : (otherlv_0= '@startuml' ( (lv_instructions_1_0= ruleInstruction ) )* otherlv_2= '@enduml' ) ;
    public final EObject ruleDiagram() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_instructions_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:118:28: ( (otherlv_0= '@startuml' ( (lv_instructions_1_0= ruleInstruction ) )* otherlv_2= '@enduml' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:119:1: (otherlv_0= '@startuml' ( (lv_instructions_1_0= ruleInstruction ) )* otherlv_2= '@enduml' )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:119:1: (otherlv_0= '@startuml' ( (lv_instructions_1_0= ruleInstruction ) )* otherlv_2= '@enduml' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:119:3: otherlv_0= '@startuml' ( (lv_instructions_1_0= ruleInstruction ) )* otherlv_2= '@enduml'
            {
            otherlv_0=(Token)match(input,10,FOLLOW_10_in_ruleDiagram213); 

                	newLeafNode(otherlv_0, grammarAccess.getDiagramAccess().getStartumlKeyword_0());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:123:1: ( (lv_instructions_1_0= ruleInstruction ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_ID && LA2_0<=RULE_SL_COMMENT)||(LA2_0>=23 && LA2_0<=28)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:124:1: (lv_instructions_1_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:124:1: (lv_instructions_1_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:125:3: lv_instructions_1_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleDiagram234);
            	    lv_instructions_1_0=ruleInstruction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDiagramRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"instructions",
            	            		lv_instructions_1_0, 
            	            		"Instruction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_2=(Token)match(input,11,FOLLOW_11_in_ruleDiagram247); 

                	newLeafNode(otherlv_2, grammarAccess.getDiagramAccess().getEndumlKeyword_2());
                

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:153:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:154:2: (iv_ruleInstruction= ruleInstruction EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:155:2: iv_ruleInstruction= ruleInstruction EOF
            {
             newCompositeNode(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_ruleInstruction_in_entryRuleInstruction283);
            iv_ruleInstruction=ruleInstruction();

            state._fsp--;

             current =iv_ruleInstruction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstruction293); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:162:1: ruleInstruction returns [EObject current=null] : ( ( ( (lv_name1_0_0= RULE_ID ) ) ruleSequence ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? ) | this_ML_COMMENT_5= RULE_ML_COMMENT | this_SL_COMMENT_6= RULE_SL_COMMENT | (this_Definition_7= ruleDefinition ( ruleColor )? ) | ruleAutoNumber ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_name1_0_0=null;
        Token lv_name2_2_0=null;
        Token otherlv_3=null;
        Token this_ID_4=null;
        Token this_ML_COMMENT_5=null;
        Token this_SL_COMMENT_6=null;
        EObject this_Definition_7 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:165:28: ( ( ( ( (lv_name1_0_0= RULE_ID ) ) ruleSequence ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? ) | this_ML_COMMENT_5= RULE_ML_COMMENT | this_SL_COMMENT_6= RULE_SL_COMMENT | (this_Definition_7= ruleDefinition ( ruleColor )? ) | ruleAutoNumber ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:166:1: ( ( ( (lv_name1_0_0= RULE_ID ) ) ruleSequence ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? ) | this_ML_COMMENT_5= RULE_ML_COMMENT | this_SL_COMMENT_6= RULE_SL_COMMENT | (this_Definition_7= ruleDefinition ( ruleColor )? ) | ruleAutoNumber )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:166:1: ( ( ( (lv_name1_0_0= RULE_ID ) ) ruleSequence ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? ) | this_ML_COMMENT_5= RULE_ML_COMMENT | this_SL_COMMENT_6= RULE_SL_COMMENT | (this_Definition_7= ruleDefinition ( ruleColor )? ) | ruleAutoNumber )
            int alt5=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt5=1;
                }
                break;
            case RULE_ML_COMMENT:
                {
                alt5=2;
                }
                break;
            case RULE_SL_COMMENT:
                {
                alt5=3;
                }
                break;
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
                {
                alt5=4;
                }
                break;
            case 28:
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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:166:2: ( ( (lv_name1_0_0= RULE_ID ) ) ruleSequence ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:166:2: ( ( (lv_name1_0_0= RULE_ID ) ) ruleSequence ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:166:3: ( (lv_name1_0_0= RULE_ID ) ) ruleSequence ( (lv_name2_2_0= RULE_ID ) ) (otherlv_3= ':' this_ID_4= RULE_ID )?
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:166:3: ( (lv_name1_0_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:167:1: (lv_name1_0_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:167:1: (lv_name1_0_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:168:3: lv_name1_0_0= RULE_ID
                    {
                    lv_name1_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstruction336); 

                    			newLeafNode(lv_name1_0_0, grammarAccess.getInstructionAccess().getName1IDTerminalRuleCall_0_0_0()); 
                    		

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

                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getSequenceParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_ruleSequence_in_ruleInstruction357);
                    ruleSequence();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:192:1: ( (lv_name2_2_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:193:1: (lv_name2_2_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:193:1: (lv_name2_2_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:194:3: lv_name2_2_0= RULE_ID
                    {
                    lv_name2_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstruction373); 

                    			newLeafNode(lv_name2_2_0, grammarAccess.getInstructionAccess().getName2IDTerminalRuleCall_0_2_0()); 
                    		

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

                    if ( (LA3_0==12) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:210:4: otherlv_3= ':' this_ID_4= RULE_ID
                            {
                            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleInstruction391); 

                                	newLeafNode(otherlv_3, grammarAccess.getInstructionAccess().getColonKeyword_0_3_0());
                                
                            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstruction402); 
                             
                                newLeafNode(this_ID_4, grammarAccess.getInstructionAccess().getIDTerminalRuleCall_0_3_1()); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:219:6: this_ML_COMMENT_5= RULE_ML_COMMENT
                    {
                    this_ML_COMMENT_5=(Token)match(input,RULE_ML_COMMENT,FOLLOW_RULE_ML_COMMENT_in_ruleInstruction421); 
                     
                        newLeafNode(this_ML_COMMENT_5, grammarAccess.getInstructionAccess().getML_COMMENTTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:224:6: this_SL_COMMENT_6= RULE_SL_COMMENT
                    {
                    this_SL_COMMENT_6=(Token)match(input,RULE_SL_COMMENT,FOLLOW_RULE_SL_COMMENT_in_ruleInstruction437); 
                     
                        newLeafNode(this_SL_COMMENT_6, grammarAccess.getInstructionAccess().getSL_COMMENTTerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:229:6: (this_Definition_7= ruleDefinition ( ruleColor )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:229:6: (this_Definition_7= ruleDefinition ( ruleColor )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:230:5: this_Definition_7= ruleDefinition ( ruleColor )?
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_3_0()); 
                        
                    pushFollow(FOLLOW_ruleDefinition_in_ruleInstruction465);
                    this_Definition_7=ruleDefinition();

                    state._fsp--;

                     
                            current = this_Definition_7; 
                            afterParserOrEnumRuleCall();
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:238:1: ( ruleColor )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==29) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:239:5: ruleColor
                            {
                             
                                    newCompositeNode(grammarAccess.getInstructionAccess().getColorParserRuleCall_3_1()); 
                                
                            pushFollow(FOLLOW_ruleColor_in_ruleInstruction481);
                            ruleColor();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:248:5: ruleAutoNumber
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleAutoNumber_in_ruleInstruction505);
                    ruleAutoNumber();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleSequence"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:263:1: entryRuleSequence returns [String current=null] : iv_ruleSequence= ruleSequence EOF ;
    public final String entryRuleSequence() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSequence = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:264:2: (iv_ruleSequence= ruleSequence EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:265:2: iv_ruleSequence= ruleSequence EOF
            {
             newCompositeNode(grammarAccess.getSequenceRule()); 
            pushFollow(FOLLOW_ruleSequence_in_entryRuleSequence541);
            iv_ruleSequence=ruleSequence();

            state._fsp--;

             current =iv_ruleSequence.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequence552); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:272:1: ruleSequence returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '-' )* kw= '-' kw= '>' ) | (kw= '<' kw= '-' (kw= '-' )* ) | (kw= '-' kw= '>' kw= 'x' ) | (kw= 'x' kw= '<' kw= '-' ) | ( (kw= '-' )* kw= '-' kw= '>' kw= '>' ) | (kw= '<' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' ) | (kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' ) | (kw= '/' kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' ) | (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* ) | (kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '|' kw= '-' kw= '-' ) | (kw= '-' kw= '-' kw= '|' kw= '>' ) | (kw= '.' kw= '.' ) | kw= '.' ) ;
    public final AntlrDatatypeRuleToken ruleSequence() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:275:28: ( ( ( (kw= '-' )* kw= '-' kw= '>' ) | (kw= '<' kw= '-' (kw= '-' )* ) | (kw= '-' kw= '>' kw= 'x' ) | (kw= 'x' kw= '<' kw= '-' ) | ( (kw= '-' )* kw= '-' kw= '>' kw= '>' ) | (kw= '<' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' ) | (kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' ) | (kw= '/' kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' ) | (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* ) | (kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '|' kw= '-' kw= '-' ) | (kw= '-' kw= '-' kw= '|' kw= '>' ) | (kw= '.' kw= '.' ) | kw= '.' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:276:1: ( ( (kw= '-' )* kw= '-' kw= '>' ) | (kw= '<' kw= '-' (kw= '-' )* ) | (kw= '-' kw= '>' kw= 'x' ) | (kw= 'x' kw= '<' kw= '-' ) | ( (kw= '-' )* kw= '-' kw= '>' kw= '>' ) | (kw= '<' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' ) | (kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' ) | (kw= '/' kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' ) | (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* ) | (kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '|' kw= '-' kw= '-' ) | (kw= '-' kw= '-' kw= '|' kw= '>' ) | (kw= '.' kw= '.' ) | kw= '.' )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:276:1: ( ( (kw= '-' )* kw= '-' kw= '>' ) | (kw= '<' kw= '-' (kw= '-' )* ) | (kw= '-' kw= '>' kw= 'x' ) | (kw= 'x' kw= '<' kw= '-' ) | ( (kw= '-' )* kw= '-' kw= '>' kw= '>' ) | (kw= '<' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' ) | (kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' ) | (kw= '/' kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' ) | (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* ) | (kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '|' kw= '-' kw= '-' ) | (kw= '-' kw= '-' kw= '|' kw= '>' ) | (kw= '.' kw= '.' ) | kw= '.' )
            int alt18=21;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:276:2: ( (kw= '-' )* kw= '-' kw= '>' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:276:2: ( (kw= '-' )* kw= '-' kw= '>' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:276:3: (kw= '-' )* kw= '-' kw= '>'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:276:3: (kw= '-' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==13) ) {
                            int LA6_1 = input.LA(2);

                            if ( (LA6_1==13) ) {
                                alt6=1;
                            }


                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:277:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence592); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_0_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence607); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_0_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence620); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_0_2()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:295:6: (kw= '<' kw= '-' (kw= '-' )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:295:6: (kw= '<' kw= '-' (kw= '-' )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:296:2: kw= '<' kw= '-' (kw= '-' )*
                    {
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence641); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_1_0()); 
                        
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence654); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_1_1()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:307:1: (kw= '-' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==13) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:308:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence668); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:314:6: (kw= '-' kw= '>' kw= 'x' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:314:6: (kw= '-' kw= '>' kw= 'x' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:315:2: kw= '-' kw= '>' kw= 'x'
                    {
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence691); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_2_0()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence704); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_2_1()); 
                        
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence717); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getXKeyword_2_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:333:6: (kw= 'x' kw= '<' kw= '-' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:333:6: (kw= 'x' kw= '<' kw= '-' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:334:2: kw= 'x' kw= '<' kw= '-'
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence738); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getXKeyword_3_0()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence751); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_3_1()); 
                        
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence764); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_3_2()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:352:6: ( (kw= '-' )* kw= '-' kw= '>' kw= '>' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:352:6: ( (kw= '-' )* kw= '-' kw= '>' kw= '>' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:352:7: (kw= '-' )* kw= '-' kw= '>' kw= '>'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:352:7: (kw= '-' )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==13) ) {
                            int LA8_1 = input.LA(2);

                            if ( (LA8_1==13) ) {
                                alt8=1;
                            }


                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:353:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence786); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_4_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence801); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_4_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence814); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4_2()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence827); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4_3()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:377:6: (kw= '<' kw= '<' kw= '-' (kw= '-' )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:377:6: (kw= '<' kw= '<' kw= '-' (kw= '-' )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:378:2: kw= '<' kw= '<' kw= '-' (kw= '-' )*
                    {
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence848); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_5_0()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence861); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_5_1()); 
                        
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence874); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_5_2()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:395:1: (kw= '-' )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==13) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:396:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence888); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:402:6: ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:402:6: ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:402:7: (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:402:7: (kw= '-' )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==13) ) {
                            int LA10_1 = input.LA(2);

                            if ( (LA10_1==13) ) {
                                alt10=1;
                            }


                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:403:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence912); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_6_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence927); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_6_1()); 
                        
                    kw=(Token)match(input,17,FOLLOW_17_in_ruleSequence940); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getReverseSolidusKeyword_6_2()); 
                        
                    kw=(Token)match(input,17,FOLLOW_17_in_ruleSequence953); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getReverseSolidusKeyword_6_3()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:427:6: (kw= '/' kw= '-' (kw= '-' )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:427:6: (kw= '/' kw= '-' (kw= '-' )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:428:2: kw= '/' kw= '-' (kw= '-' )*
                    {
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleSequence974); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getSolidusKeyword_7_0()); 
                        
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence987); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_7_1()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:439:1: (kw= '-' )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==13) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:440:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1001); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:446:6: ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:446:6: ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:446:7: (kw= '-' )* kw= '-' kw= '\\\\\\\\'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:446:7: (kw= '-' )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==13) ) {
                            int LA12_1 = input.LA(2);

                            if ( (LA12_1==13) ) {
                                alt12=1;
                            }


                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:447:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1025); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_8_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1040); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_8_1()); 
                        
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleSequence1053); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getReverseSolidusReverseSolidusKeyword_8_2()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:465:6: (kw= '/' kw= '/' kw= '-' (kw= '-' )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:465:6: (kw= '/' kw= '/' kw= '-' (kw= '-' )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:466:2: kw= '/' kw= '/' kw= '-' (kw= '-' )*
                    {
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleSequence1074); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getSolidusKeyword_9_0()); 
                        
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleSequence1087); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getSolidusKeyword_9_1()); 
                        
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1100); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_9_2()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:483:1: (kw= '-' )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==13) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:484:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1114); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:490:6: ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:490:6: ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:490:7: (kw= '-' )* kw= '-' kw= '>' kw= 'o'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:490:7: (kw= '-' )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==13) ) {
                            int LA14_1 = input.LA(2);

                            if ( (LA14_1==13) ) {
                                alt14=1;
                            }


                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:491:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1138); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_10_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1153); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_10_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1166); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_10_2()); 
                        
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleSequence1179); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getOKeyword_10_3()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:515:6: (kw= 'o' kw= '<' kw= '-' (kw= '-' )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:515:6: (kw= 'o' kw= '<' kw= '-' (kw= '-' )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:516:2: kw= 'o' kw= '<' kw= '-' (kw= '-' )*
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleSequence1200); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getOKeyword_11_0()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence1213); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_11_1()); 
                        
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1226); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_11_2()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:533:1: (kw= '-' )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==13) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:534:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1240); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:540:6: ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:540:6: ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:540:7: (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:540:7: (kw= '-' )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==13) ) {
                            int LA16_1 = input.LA(2);

                            if ( (LA16_1==13) ) {
                                int LA16_2 = input.LA(3);

                                if ( (LA16_2==13) ) {
                                    alt16=1;
                                }


                            }


                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:541:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1264); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1279); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_1()); 
                        
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1292); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_2()); 
                        
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleSequence1305); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getSolidusKeyword_12_3()); 
                        
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleSequence1318); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getSolidusKeyword_12_4()); 
                        
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleSequence1331); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getOKeyword_12_5()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:577:6: (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:577:6: (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:578:2: kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )*
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleSequence1352); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getOKeyword_13_0()); 
                        
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleSequence1365); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getReverseSolidusReverseSolidusKeyword_13_1()); 
                        
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1378); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_2()); 
                        
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1391); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_3()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:601:1: (kw= '-' )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==13) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:602:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1405); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:608:6: (kw= '<' kw= '-' kw= '>' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:608:6: (kw= '<' kw= '-' kw= '>' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:609:2: kw= '<' kw= '-' kw= '>'
                    {
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence1428); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_14_0()); 
                        
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1441); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_14_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1454); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_14_2()); 
                        

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:627:6: (kw= '<' kw= '-' kw= '>' kw= 'o' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:627:6: (kw= '<' kw= '-' kw= '>' kw= 'o' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:628:2: kw= '<' kw= '-' kw= '>' kw= 'o'
                    {
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence1475); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_15_0()); 
                        
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1488); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_15_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1501); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_15_2()); 
                        
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleSequence1514); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getOKeyword_15_3()); 
                        

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:652:6: (kw= 'o' kw= '<' kw= '-' kw= '>' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:652:6: (kw= 'o' kw= '<' kw= '-' kw= '>' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:653:2: kw= 'o' kw= '<' kw= '-' kw= '>'
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleSequence1535); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getOKeyword_16_0()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence1548); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_16_1()); 
                        
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1561); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_16_2()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1574); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_16_3()); 
                        

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:677:6: (kw= '<' kw= '|' kw= '-' kw= '-' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:677:6: (kw= '<' kw= '|' kw= '-' kw= '-' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:678:2: kw= '<' kw= '|' kw= '-' kw= '-'
                    {
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence1595); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_17_0()); 
                        
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleSequence1608); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getVerticalLineKeyword_17_1()); 
                        
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1621); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_17_2()); 
                        
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1634); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_17_3()); 
                        

                    }


                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:702:6: (kw= '-' kw= '-' kw= '|' kw= '>' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:702:6: (kw= '-' kw= '-' kw= '|' kw= '>' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:703:2: kw= '-' kw= '-' kw= '|' kw= '>'
                    {
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1655); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_18_0()); 
                        
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSequence1668); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_18_1()); 
                        
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleSequence1681); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getVerticalLineKeyword_18_2()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1694); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_18_3()); 
                        

                    }


                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:727:6: (kw= '.' kw= '.' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:727:6: (kw= '.' kw= '.' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:728:2: kw= '.' kw= '.'
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleSequence1715); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getFullStopKeyword_19_0()); 
                        
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleSequence1728); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getFullStopKeyword_19_1()); 
                        

                    }


                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:741:2: kw= '.'
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleSequence1748); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:754:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:755:2: (iv_ruleDefinition= ruleDefinition EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:756:2: iv_ruleDefinition= ruleDefinition EOF
            {
             newCompositeNode(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition1788);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition1798); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:763:1: ruleDefinition returns [EObject current=null] : ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) ) ) ;
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:766:28: ( ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:767:1: ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:767:1: ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) ) )
            int alt19=5;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt19=1;
                }
                break;
            case 24:
                {
                alt19=2;
                }
                break;
            case 25:
                {
                alt19=3;
                }
                break;
            case 26:
                {
                alt19=4;
                }
                break;
            case 27:
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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:767:2: (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:767:2: (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:767:4: otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleDefinition1836); 

                        	newLeafNode(otherlv_0, grammarAccess.getDefinitionAccess().getActorKeyword_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:771:1: ( (lv_name_1_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:772:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:772:1: (lv_name_1_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:773:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1853); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:790:6: (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:790:6: (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:790:8: otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleDefinition1878); 

                        	newLeafNode(otherlv_2, grammarAccess.getDefinitionAccess().getBoundaryKeyword_1_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:794:1: ( (lv_name_3_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:795:1: (lv_name_3_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:795:1: (lv_name_3_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:796:3: lv_name_3_0= RULE_ID
                    {
                    lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1895); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:813:6: (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:813:6: (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:813:8: otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleDefinition1920); 

                        	newLeafNode(otherlv_4, grammarAccess.getDefinitionAccess().getControlKeyword_2_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:817:1: ( (lv_name_5_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:818:1: (lv_name_5_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:818:1: (lv_name_5_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:819:3: lv_name_5_0= RULE_ID
                    {
                    lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1937); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:836:6: (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:836:6: (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:836:8: otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,26,FOLLOW_26_in_ruleDefinition1962); 

                        	newLeafNode(otherlv_6, grammarAccess.getDefinitionAccess().getEntityKeyword_3_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:840:1: ( (lv_name_7_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:841:1: (lv_name_7_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:841:1: (lv_name_7_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:842:3: lv_name_7_0= RULE_ID
                    {
                    lv_name_7_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1979); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:859:6: (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:859:6: (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:859:8: otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,27,FOLLOW_27_in_ruleDefinition2004); 

                        	newLeafNode(otherlv_8, grammarAccess.getDefinitionAccess().getDatabaseKeyword_4_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:863:1: ( (lv_name_9_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:864:1: (lv_name_9_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:864:1: (lv_name_9_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:865:3: lv_name_9_0= RULE_ID
                    {
                    lv_name_9_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition2021); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:889:1: entryRuleAutoNumber returns [String current=null] : iv_ruleAutoNumber= ruleAutoNumber EOF ;
    public final String entryRuleAutoNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAutoNumber = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:890:2: (iv_ruleAutoNumber= ruleAutoNumber EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:891:2: iv_ruleAutoNumber= ruleAutoNumber EOF
            {
             newCompositeNode(grammarAccess.getAutoNumberRule()); 
            pushFollow(FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber2064);
            iv_ruleAutoNumber=ruleAutoNumber();

            state._fsp--;

             current =iv_ruleAutoNumber.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAutoNumber2075); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:898:1: ruleAutoNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'autonumber' (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? ) ;
    public final AntlrDatatypeRuleToken ruleAutoNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:901:28: ( (kw= 'autonumber' (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:902:1: (kw= 'autonumber' (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:902:1: (kw= 'autonumber' (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:903:2: kw= 'autonumber' (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )?
            {
            kw=(Token)match(input,28,FOLLOW_28_in_ruleAutoNumber2113); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getAutoNumberAccess().getAutonumberKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:908:1: (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_INT) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:908:6: this_INT_1= RULE_INT (this_INT_2= RULE_INT )?
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAutoNumber2129); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_0()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:915:1: (this_INT_2= RULE_INT )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==RULE_INT) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:915:6: this_INT_2= RULE_INT
                            {
                            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAutoNumber2150); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:930:1: entryRuleColor returns [String current=null] : iv_ruleColor= ruleColor EOF ;
    public final String entryRuleColor() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleColor = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:931:2: (iv_ruleColor= ruleColor EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:932:2: iv_ruleColor= ruleColor EOF
            {
             newCompositeNode(grammarAccess.getColorRule()); 
            pushFollow(FOLLOW_ruleColor_in_entryRuleColor2200);
            iv_ruleColor=ruleColor();

            state._fsp--;

             current =iv_ruleColor.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColor2211); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:939:1: ruleColor returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '#' )+ (kw= 'AliceBlue' | kw= 'AntiqueWhite' | kw= 'Aqua' | kw= 'Aquamarine' | kw= 'Azure' | kw= 'Beige' | kw= 'Bisque' | kw= 'Black' | kw= 'BlanchedAlmond' | kw= 'Blue' | kw= 'BlueViolet' | kw= 'Brown' | kw= 'BurlyWood' | kw= 'CadetBlue' | kw= 'Chartreuse' | kw= 'Chocolate' | kw= 'Coral' | kw= 'CornflowerBlue' | kw= 'Cornsilk' | kw= 'Crimson' | kw= 'Cyan' | kw= 'DarkBlue' | kw= 'DarkCyan' | kw= 'DarkGoldenRod' | kw= 'DarkGray' | kw= 'DarkGreen' | kw= 'DarkGrey' | kw= 'DarkKhaki' | kw= 'DarkMagenta' | kw= 'DarkOliveGreen' | kw= 'DarkOrchid' | kw= 'DarkRed' | kw= 'DarkSalmo' | kw= 'DarkSeaGreen' | kw= 'DarkSlateBlue' | kw= 'DarkSlateGray' | kw= 'DarkSlateGrey' | kw= 'DarkTurquoise' | kw= 'DarkViolet' | kw= 'Darkorange' | kw= 'DeepPink' | kw= 'DeepSkyBlue' | kw= 'DimGray' | kw= 'DimGrey' | kw= 'DodgerBlue' | kw= 'FireBrick' | kw= 'FloralWhite' | kw= 'ForestGreen' | kw= 'Fuchsia' | kw= 'Gainsboro' | kw= 'GhostWhite' | kw= 'Gold' | kw= 'GoldenRod' | kw= 'Gray' | kw= 'Green' | kw= 'GreenYellow' | kw= 'Grey' | kw= 'HoneyDew' | kw= 'HotPink' | kw= 'IndianRed' | kw= 'Indigo' | kw= 'Ivory' | kw= 'Khaki' | kw= 'Lavender' | kw= 'LavenderBlush' | kw= 'LawnGreen' | kw= 'LemonChiffon' | kw= 'LightBlue' | kw= 'LightCoral' | kw= 'LightCyan' | kw= 'LightGoldenRodYellow' | kw= 'LightGray' | kw= 'LightGreen' | kw= 'LightGrey' | kw= 'LightPink' | kw= 'LightSalmon' | kw= 'LightSeaGreen' | kw= 'LightSkyBlue' | kw= 'LightSlateGray' | kw= 'LightSlateGrey' | kw= 'LightSteelBlue' | kw= 'LightYellow' | kw= 'Lime' | kw= 'LimeGreen' | kw= 'Linen' | kw= 'Magenta' | kw= 'Maroon' | kw= 'MediumAquaMarine' | kw= 'MediumBlue' | kw= 'MediumOrchid' | kw= 'MediumPurple' | kw= 'MediumSeaGreen' | kw= 'MediumSlateBlue' | kw= 'MediumSpringGreen' | kw= 'MediumTurquoise' | kw= 'MediumVioletRed' | kw= 'MidnightBlue' | kw= 'MintCream' | kw= 'MistyRose' | kw= 'Moccasin' | kw= 'NavajoWhite' | kw= 'Navy' | kw= 'OldLace' | kw= 'Olive' | kw= 'OliveDrab' | kw= 'OrangeRed' | kw= 'Orchid' | kw= 'PaleGoldenRod' | kw= 'PaleGreen' | kw= 'PaleTurquoise' | kw= 'PaleVioletRed' | kw= 'PapayaWhip' | kw= 'PeachPuff' | kw= 'Peru' | kw= 'Pink' | kw= 'Plum' | kw= 'PowderBlue' | kw= 'Purple' | kw= 'Red' | kw= 'RosyBrown' | kw= 'RoyalBlue' | kw= 'SaddleBrown' | kw= 'Salmon' | kw= 'SandyBrown' | kw= 'SeaGreen' | kw= 'Sienna' | kw= 'Silver' | kw= 'SkyBlue' | kw= 'SlateBlue' | kw= 'SlateGray' | kw= 'SlateGrey' | kw= 'Snow' | kw= 'SpringGreen' | kw= 'SteelBlue' | kw= 'Tan' | kw= 'Teal' | kw= 'Thistle' | kw= 'Tomato' | kw= 'Turquoise' | kw= 'Violet' | kw= 'Wheat' | kw= 'White' | kw= 'WhiteSmoke' | kw= 'Yellow' | kw= 'YellowGreen' ) ) ;
    public final AntlrDatatypeRuleToken ruleColor() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:942:28: ( ( (kw= '#' )+ (kw= 'AliceBlue' | kw= 'AntiqueWhite' | kw= 'Aqua' | kw= 'Aquamarine' | kw= 'Azure' | kw= 'Beige' | kw= 'Bisque' | kw= 'Black' | kw= 'BlanchedAlmond' | kw= 'Blue' | kw= 'BlueViolet' | kw= 'Brown' | kw= 'BurlyWood' | kw= 'CadetBlue' | kw= 'Chartreuse' | kw= 'Chocolate' | kw= 'Coral' | kw= 'CornflowerBlue' | kw= 'Cornsilk' | kw= 'Crimson' | kw= 'Cyan' | kw= 'DarkBlue' | kw= 'DarkCyan' | kw= 'DarkGoldenRod' | kw= 'DarkGray' | kw= 'DarkGreen' | kw= 'DarkGrey' | kw= 'DarkKhaki' | kw= 'DarkMagenta' | kw= 'DarkOliveGreen' | kw= 'DarkOrchid' | kw= 'DarkRed' | kw= 'DarkSalmo' | kw= 'DarkSeaGreen' | kw= 'DarkSlateBlue' | kw= 'DarkSlateGray' | kw= 'DarkSlateGrey' | kw= 'DarkTurquoise' | kw= 'DarkViolet' | kw= 'Darkorange' | kw= 'DeepPink' | kw= 'DeepSkyBlue' | kw= 'DimGray' | kw= 'DimGrey' | kw= 'DodgerBlue' | kw= 'FireBrick' | kw= 'FloralWhite' | kw= 'ForestGreen' | kw= 'Fuchsia' | kw= 'Gainsboro' | kw= 'GhostWhite' | kw= 'Gold' | kw= 'GoldenRod' | kw= 'Gray' | kw= 'Green' | kw= 'GreenYellow' | kw= 'Grey' | kw= 'HoneyDew' | kw= 'HotPink' | kw= 'IndianRed' | kw= 'Indigo' | kw= 'Ivory' | kw= 'Khaki' | kw= 'Lavender' | kw= 'LavenderBlush' | kw= 'LawnGreen' | kw= 'LemonChiffon' | kw= 'LightBlue' | kw= 'LightCoral' | kw= 'LightCyan' | kw= 'LightGoldenRodYellow' | kw= 'LightGray' | kw= 'LightGreen' | kw= 'LightGrey' | kw= 'LightPink' | kw= 'LightSalmon' | kw= 'LightSeaGreen' | kw= 'LightSkyBlue' | kw= 'LightSlateGray' | kw= 'LightSlateGrey' | kw= 'LightSteelBlue' | kw= 'LightYellow' | kw= 'Lime' | kw= 'LimeGreen' | kw= 'Linen' | kw= 'Magenta' | kw= 'Maroon' | kw= 'MediumAquaMarine' | kw= 'MediumBlue' | kw= 'MediumOrchid' | kw= 'MediumPurple' | kw= 'MediumSeaGreen' | kw= 'MediumSlateBlue' | kw= 'MediumSpringGreen' | kw= 'MediumTurquoise' | kw= 'MediumVioletRed' | kw= 'MidnightBlue' | kw= 'MintCream' | kw= 'MistyRose' | kw= 'Moccasin' | kw= 'NavajoWhite' | kw= 'Navy' | kw= 'OldLace' | kw= 'Olive' | kw= 'OliveDrab' | kw= 'OrangeRed' | kw= 'Orchid' | kw= 'PaleGoldenRod' | kw= 'PaleGreen' | kw= 'PaleTurquoise' | kw= 'PaleVioletRed' | kw= 'PapayaWhip' | kw= 'PeachPuff' | kw= 'Peru' | kw= 'Pink' | kw= 'Plum' | kw= 'PowderBlue' | kw= 'Purple' | kw= 'Red' | kw= 'RosyBrown' | kw= 'RoyalBlue' | kw= 'SaddleBrown' | kw= 'Salmon' | kw= 'SandyBrown' | kw= 'SeaGreen' | kw= 'Sienna' | kw= 'Silver' | kw= 'SkyBlue' | kw= 'SlateBlue' | kw= 'SlateGray' | kw= 'SlateGrey' | kw= 'Snow' | kw= 'SpringGreen' | kw= 'SteelBlue' | kw= 'Tan' | kw= 'Teal' | kw= 'Thistle' | kw= 'Tomato' | kw= 'Turquoise' | kw= 'Violet' | kw= 'Wheat' | kw= 'White' | kw= 'WhiteSmoke' | kw= 'Yellow' | kw= 'YellowGreen' ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:943:1: ( (kw= '#' )+ (kw= 'AliceBlue' | kw= 'AntiqueWhite' | kw= 'Aqua' | kw= 'Aquamarine' | kw= 'Azure' | kw= 'Beige' | kw= 'Bisque' | kw= 'Black' | kw= 'BlanchedAlmond' | kw= 'Blue' | kw= 'BlueViolet' | kw= 'Brown' | kw= 'BurlyWood' | kw= 'CadetBlue' | kw= 'Chartreuse' | kw= 'Chocolate' | kw= 'Coral' | kw= 'CornflowerBlue' | kw= 'Cornsilk' | kw= 'Crimson' | kw= 'Cyan' | kw= 'DarkBlue' | kw= 'DarkCyan' | kw= 'DarkGoldenRod' | kw= 'DarkGray' | kw= 'DarkGreen' | kw= 'DarkGrey' | kw= 'DarkKhaki' | kw= 'DarkMagenta' | kw= 'DarkOliveGreen' | kw= 'DarkOrchid' | kw= 'DarkRed' | kw= 'DarkSalmo' | kw= 'DarkSeaGreen' | kw= 'DarkSlateBlue' | kw= 'DarkSlateGray' | kw= 'DarkSlateGrey' | kw= 'DarkTurquoise' | kw= 'DarkViolet' | kw= 'Darkorange' | kw= 'DeepPink' | kw= 'DeepSkyBlue' | kw= 'DimGray' | kw= 'DimGrey' | kw= 'DodgerBlue' | kw= 'FireBrick' | kw= 'FloralWhite' | kw= 'ForestGreen' | kw= 'Fuchsia' | kw= 'Gainsboro' | kw= 'GhostWhite' | kw= 'Gold' | kw= 'GoldenRod' | kw= 'Gray' | kw= 'Green' | kw= 'GreenYellow' | kw= 'Grey' | kw= 'HoneyDew' | kw= 'HotPink' | kw= 'IndianRed' | kw= 'Indigo' | kw= 'Ivory' | kw= 'Khaki' | kw= 'Lavender' | kw= 'LavenderBlush' | kw= 'LawnGreen' | kw= 'LemonChiffon' | kw= 'LightBlue' | kw= 'LightCoral' | kw= 'LightCyan' | kw= 'LightGoldenRodYellow' | kw= 'LightGray' | kw= 'LightGreen' | kw= 'LightGrey' | kw= 'LightPink' | kw= 'LightSalmon' | kw= 'LightSeaGreen' | kw= 'LightSkyBlue' | kw= 'LightSlateGray' | kw= 'LightSlateGrey' | kw= 'LightSteelBlue' | kw= 'LightYellow' | kw= 'Lime' | kw= 'LimeGreen' | kw= 'Linen' | kw= 'Magenta' | kw= 'Maroon' | kw= 'MediumAquaMarine' | kw= 'MediumBlue' | kw= 'MediumOrchid' | kw= 'MediumPurple' | kw= 'MediumSeaGreen' | kw= 'MediumSlateBlue' | kw= 'MediumSpringGreen' | kw= 'MediumTurquoise' | kw= 'MediumVioletRed' | kw= 'MidnightBlue' | kw= 'MintCream' | kw= 'MistyRose' | kw= 'Moccasin' | kw= 'NavajoWhite' | kw= 'Navy' | kw= 'OldLace' | kw= 'Olive' | kw= 'OliveDrab' | kw= 'OrangeRed' | kw= 'Orchid' | kw= 'PaleGoldenRod' | kw= 'PaleGreen' | kw= 'PaleTurquoise' | kw= 'PaleVioletRed' | kw= 'PapayaWhip' | kw= 'PeachPuff' | kw= 'Peru' | kw= 'Pink' | kw= 'Plum' | kw= 'PowderBlue' | kw= 'Purple' | kw= 'Red' | kw= 'RosyBrown' | kw= 'RoyalBlue' | kw= 'SaddleBrown' | kw= 'Salmon' | kw= 'SandyBrown' | kw= 'SeaGreen' | kw= 'Sienna' | kw= 'Silver' | kw= 'SkyBlue' | kw= 'SlateBlue' | kw= 'SlateGray' | kw= 'SlateGrey' | kw= 'Snow' | kw= 'SpringGreen' | kw= 'SteelBlue' | kw= 'Tan' | kw= 'Teal' | kw= 'Thistle' | kw= 'Tomato' | kw= 'Turquoise' | kw= 'Violet' | kw= 'Wheat' | kw= 'White' | kw= 'WhiteSmoke' | kw= 'Yellow' | kw= 'YellowGreen' ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:943:1: ( (kw= '#' )+ (kw= 'AliceBlue' | kw= 'AntiqueWhite' | kw= 'Aqua' | kw= 'Aquamarine' | kw= 'Azure' | kw= 'Beige' | kw= 'Bisque' | kw= 'Black' | kw= 'BlanchedAlmond' | kw= 'Blue' | kw= 'BlueViolet' | kw= 'Brown' | kw= 'BurlyWood' | kw= 'CadetBlue' | kw= 'Chartreuse' | kw= 'Chocolate' | kw= 'Coral' | kw= 'CornflowerBlue' | kw= 'Cornsilk' | kw= 'Crimson' | kw= 'Cyan' | kw= 'DarkBlue' | kw= 'DarkCyan' | kw= 'DarkGoldenRod' | kw= 'DarkGray' | kw= 'DarkGreen' | kw= 'DarkGrey' | kw= 'DarkKhaki' | kw= 'DarkMagenta' | kw= 'DarkOliveGreen' | kw= 'DarkOrchid' | kw= 'DarkRed' | kw= 'DarkSalmo' | kw= 'DarkSeaGreen' | kw= 'DarkSlateBlue' | kw= 'DarkSlateGray' | kw= 'DarkSlateGrey' | kw= 'DarkTurquoise' | kw= 'DarkViolet' | kw= 'Darkorange' | kw= 'DeepPink' | kw= 'DeepSkyBlue' | kw= 'DimGray' | kw= 'DimGrey' | kw= 'DodgerBlue' | kw= 'FireBrick' | kw= 'FloralWhite' | kw= 'ForestGreen' | kw= 'Fuchsia' | kw= 'Gainsboro' | kw= 'GhostWhite' | kw= 'Gold' | kw= 'GoldenRod' | kw= 'Gray' | kw= 'Green' | kw= 'GreenYellow' | kw= 'Grey' | kw= 'HoneyDew' | kw= 'HotPink' | kw= 'IndianRed' | kw= 'Indigo' | kw= 'Ivory' | kw= 'Khaki' | kw= 'Lavender' | kw= 'LavenderBlush' | kw= 'LawnGreen' | kw= 'LemonChiffon' | kw= 'LightBlue' | kw= 'LightCoral' | kw= 'LightCyan' | kw= 'LightGoldenRodYellow' | kw= 'LightGray' | kw= 'LightGreen' | kw= 'LightGrey' | kw= 'LightPink' | kw= 'LightSalmon' | kw= 'LightSeaGreen' | kw= 'LightSkyBlue' | kw= 'LightSlateGray' | kw= 'LightSlateGrey' | kw= 'LightSteelBlue' | kw= 'LightYellow' | kw= 'Lime' | kw= 'LimeGreen' | kw= 'Linen' | kw= 'Magenta' | kw= 'Maroon' | kw= 'MediumAquaMarine' | kw= 'MediumBlue' | kw= 'MediumOrchid' | kw= 'MediumPurple' | kw= 'MediumSeaGreen' | kw= 'MediumSlateBlue' | kw= 'MediumSpringGreen' | kw= 'MediumTurquoise' | kw= 'MediumVioletRed' | kw= 'MidnightBlue' | kw= 'MintCream' | kw= 'MistyRose' | kw= 'Moccasin' | kw= 'NavajoWhite' | kw= 'Navy' | kw= 'OldLace' | kw= 'Olive' | kw= 'OliveDrab' | kw= 'OrangeRed' | kw= 'Orchid' | kw= 'PaleGoldenRod' | kw= 'PaleGreen' | kw= 'PaleTurquoise' | kw= 'PaleVioletRed' | kw= 'PapayaWhip' | kw= 'PeachPuff' | kw= 'Peru' | kw= 'Pink' | kw= 'Plum' | kw= 'PowderBlue' | kw= 'Purple' | kw= 'Red' | kw= 'RosyBrown' | kw= 'RoyalBlue' | kw= 'SaddleBrown' | kw= 'Salmon' | kw= 'SandyBrown' | kw= 'SeaGreen' | kw= 'Sienna' | kw= 'Silver' | kw= 'SkyBlue' | kw= 'SlateBlue' | kw= 'SlateGray' | kw= 'SlateGrey' | kw= 'Snow' | kw= 'SpringGreen' | kw= 'SteelBlue' | kw= 'Tan' | kw= 'Teal' | kw= 'Thistle' | kw= 'Tomato' | kw= 'Turquoise' | kw= 'Violet' | kw= 'Wheat' | kw= 'White' | kw= 'WhiteSmoke' | kw= 'Yellow' | kw= 'YellowGreen' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:943:2: (kw= '#' )+ (kw= 'AliceBlue' | kw= 'AntiqueWhite' | kw= 'Aqua' | kw= 'Aquamarine' | kw= 'Azure' | kw= 'Beige' | kw= 'Bisque' | kw= 'Black' | kw= 'BlanchedAlmond' | kw= 'Blue' | kw= 'BlueViolet' | kw= 'Brown' | kw= 'BurlyWood' | kw= 'CadetBlue' | kw= 'Chartreuse' | kw= 'Chocolate' | kw= 'Coral' | kw= 'CornflowerBlue' | kw= 'Cornsilk' | kw= 'Crimson' | kw= 'Cyan' | kw= 'DarkBlue' | kw= 'DarkCyan' | kw= 'DarkGoldenRod' | kw= 'DarkGray' | kw= 'DarkGreen' | kw= 'DarkGrey' | kw= 'DarkKhaki' | kw= 'DarkMagenta' | kw= 'DarkOliveGreen' | kw= 'DarkOrchid' | kw= 'DarkRed' | kw= 'DarkSalmo' | kw= 'DarkSeaGreen' | kw= 'DarkSlateBlue' | kw= 'DarkSlateGray' | kw= 'DarkSlateGrey' | kw= 'DarkTurquoise' | kw= 'DarkViolet' | kw= 'Darkorange' | kw= 'DeepPink' | kw= 'DeepSkyBlue' | kw= 'DimGray' | kw= 'DimGrey' | kw= 'DodgerBlue' | kw= 'FireBrick' | kw= 'FloralWhite' | kw= 'ForestGreen' | kw= 'Fuchsia' | kw= 'Gainsboro' | kw= 'GhostWhite' | kw= 'Gold' | kw= 'GoldenRod' | kw= 'Gray' | kw= 'Green' | kw= 'GreenYellow' | kw= 'Grey' | kw= 'HoneyDew' | kw= 'HotPink' | kw= 'IndianRed' | kw= 'Indigo' | kw= 'Ivory' | kw= 'Khaki' | kw= 'Lavender' | kw= 'LavenderBlush' | kw= 'LawnGreen' | kw= 'LemonChiffon' | kw= 'LightBlue' | kw= 'LightCoral' | kw= 'LightCyan' | kw= 'LightGoldenRodYellow' | kw= 'LightGray' | kw= 'LightGreen' | kw= 'LightGrey' | kw= 'LightPink' | kw= 'LightSalmon' | kw= 'LightSeaGreen' | kw= 'LightSkyBlue' | kw= 'LightSlateGray' | kw= 'LightSlateGrey' | kw= 'LightSteelBlue' | kw= 'LightYellow' | kw= 'Lime' | kw= 'LimeGreen' | kw= 'Linen' | kw= 'Magenta' | kw= 'Maroon' | kw= 'MediumAquaMarine' | kw= 'MediumBlue' | kw= 'MediumOrchid' | kw= 'MediumPurple' | kw= 'MediumSeaGreen' | kw= 'MediumSlateBlue' | kw= 'MediumSpringGreen' | kw= 'MediumTurquoise' | kw= 'MediumVioletRed' | kw= 'MidnightBlue' | kw= 'MintCream' | kw= 'MistyRose' | kw= 'Moccasin' | kw= 'NavajoWhite' | kw= 'Navy' | kw= 'OldLace' | kw= 'Olive' | kw= 'OliveDrab' | kw= 'OrangeRed' | kw= 'Orchid' | kw= 'PaleGoldenRod' | kw= 'PaleGreen' | kw= 'PaleTurquoise' | kw= 'PaleVioletRed' | kw= 'PapayaWhip' | kw= 'PeachPuff' | kw= 'Peru' | kw= 'Pink' | kw= 'Plum' | kw= 'PowderBlue' | kw= 'Purple' | kw= 'Red' | kw= 'RosyBrown' | kw= 'RoyalBlue' | kw= 'SaddleBrown' | kw= 'Salmon' | kw= 'SandyBrown' | kw= 'SeaGreen' | kw= 'Sienna' | kw= 'Silver' | kw= 'SkyBlue' | kw= 'SlateBlue' | kw= 'SlateGray' | kw= 'SlateGrey' | kw= 'Snow' | kw= 'SpringGreen' | kw= 'SteelBlue' | kw= 'Tan' | kw= 'Teal' | kw= 'Thistle' | kw= 'Tomato' | kw= 'Turquoise' | kw= 'Violet' | kw= 'Wheat' | kw= 'White' | kw= 'WhiteSmoke' | kw= 'Yellow' | kw= 'YellowGreen' )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:943:2: (kw= '#' )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==29) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:944:2: kw= '#'
            	    {
            	    kw=(Token)match(input,29,FOLLOW_29_in_ruleColor2250); 

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

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:949:3: (kw= 'AliceBlue' | kw= 'AntiqueWhite' | kw= 'Aqua' | kw= 'Aquamarine' | kw= 'Azure' | kw= 'Beige' | kw= 'Bisque' | kw= 'Black' | kw= 'BlanchedAlmond' | kw= 'Blue' | kw= 'BlueViolet' | kw= 'Brown' | kw= 'BurlyWood' | kw= 'CadetBlue' | kw= 'Chartreuse' | kw= 'Chocolate' | kw= 'Coral' | kw= 'CornflowerBlue' | kw= 'Cornsilk' | kw= 'Crimson' | kw= 'Cyan' | kw= 'DarkBlue' | kw= 'DarkCyan' | kw= 'DarkGoldenRod' | kw= 'DarkGray' | kw= 'DarkGreen' | kw= 'DarkGrey' | kw= 'DarkKhaki' | kw= 'DarkMagenta' | kw= 'DarkOliveGreen' | kw= 'DarkOrchid' | kw= 'DarkRed' | kw= 'DarkSalmo' | kw= 'DarkSeaGreen' | kw= 'DarkSlateBlue' | kw= 'DarkSlateGray' | kw= 'DarkSlateGrey' | kw= 'DarkTurquoise' | kw= 'DarkViolet' | kw= 'Darkorange' | kw= 'DeepPink' | kw= 'DeepSkyBlue' | kw= 'DimGray' | kw= 'DimGrey' | kw= 'DodgerBlue' | kw= 'FireBrick' | kw= 'FloralWhite' | kw= 'ForestGreen' | kw= 'Fuchsia' | kw= 'Gainsboro' | kw= 'GhostWhite' | kw= 'Gold' | kw= 'GoldenRod' | kw= 'Gray' | kw= 'Green' | kw= 'GreenYellow' | kw= 'Grey' | kw= 'HoneyDew' | kw= 'HotPink' | kw= 'IndianRed' | kw= 'Indigo' | kw= 'Ivory' | kw= 'Khaki' | kw= 'Lavender' | kw= 'LavenderBlush' | kw= 'LawnGreen' | kw= 'LemonChiffon' | kw= 'LightBlue' | kw= 'LightCoral' | kw= 'LightCyan' | kw= 'LightGoldenRodYellow' | kw= 'LightGray' | kw= 'LightGreen' | kw= 'LightGrey' | kw= 'LightPink' | kw= 'LightSalmon' | kw= 'LightSeaGreen' | kw= 'LightSkyBlue' | kw= 'LightSlateGray' | kw= 'LightSlateGrey' | kw= 'LightSteelBlue' | kw= 'LightYellow' | kw= 'Lime' | kw= 'LimeGreen' | kw= 'Linen' | kw= 'Magenta' | kw= 'Maroon' | kw= 'MediumAquaMarine' | kw= 'MediumBlue' | kw= 'MediumOrchid' | kw= 'MediumPurple' | kw= 'MediumSeaGreen' | kw= 'MediumSlateBlue' | kw= 'MediumSpringGreen' | kw= 'MediumTurquoise' | kw= 'MediumVioletRed' | kw= 'MidnightBlue' | kw= 'MintCream' | kw= 'MistyRose' | kw= 'Moccasin' | kw= 'NavajoWhite' | kw= 'Navy' | kw= 'OldLace' | kw= 'Olive' | kw= 'OliveDrab' | kw= 'OrangeRed' | kw= 'Orchid' | kw= 'PaleGoldenRod' | kw= 'PaleGreen' | kw= 'PaleTurquoise' | kw= 'PaleVioletRed' | kw= 'PapayaWhip' | kw= 'PeachPuff' | kw= 'Peru' | kw= 'Pink' | kw= 'Plum' | kw= 'PowderBlue' | kw= 'Purple' | kw= 'Red' | kw= 'RosyBrown' | kw= 'RoyalBlue' | kw= 'SaddleBrown' | kw= 'Salmon' | kw= 'SandyBrown' | kw= 'SeaGreen' | kw= 'Sienna' | kw= 'Silver' | kw= 'SkyBlue' | kw= 'SlateBlue' | kw= 'SlateGray' | kw= 'SlateGrey' | kw= 'Snow' | kw= 'SpringGreen' | kw= 'SteelBlue' | kw= 'Tan' | kw= 'Teal' | kw= 'Thistle' | kw= 'Tomato' | kw= 'Turquoise' | kw= 'Violet' | kw= 'Wheat' | kw= 'White' | kw= 'WhiteSmoke' | kw= 'Yellow' | kw= 'YellowGreen' )
            int alt23=145;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt23=1;
                }
                break;
            case 31:
                {
                alt23=2;
                }
                break;
            case 32:
                {
                alt23=3;
                }
                break;
            case 33:
                {
                alt23=4;
                }
                break;
            case 34:
                {
                alt23=5;
                }
                break;
            case 35:
                {
                alt23=6;
                }
                break;
            case 36:
                {
                alt23=7;
                }
                break;
            case 37:
                {
                alt23=8;
                }
                break;
            case 38:
                {
                alt23=9;
                }
                break;
            case 39:
                {
                alt23=10;
                }
                break;
            case 40:
                {
                alt23=11;
                }
                break;
            case 41:
                {
                alt23=12;
                }
                break;
            case 42:
                {
                alt23=13;
                }
                break;
            case 43:
                {
                alt23=14;
                }
                break;
            case 44:
                {
                alt23=15;
                }
                break;
            case 45:
                {
                alt23=16;
                }
                break;
            case 46:
                {
                alt23=17;
                }
                break;
            case 47:
                {
                alt23=18;
                }
                break;
            case 48:
                {
                alt23=19;
                }
                break;
            case 49:
                {
                alt23=20;
                }
                break;
            case 50:
                {
                alt23=21;
                }
                break;
            case 51:
                {
                alt23=22;
                }
                break;
            case 52:
                {
                alt23=23;
                }
                break;
            case 53:
                {
                alt23=24;
                }
                break;
            case 54:
                {
                alt23=25;
                }
                break;
            case 55:
                {
                alt23=26;
                }
                break;
            case 56:
                {
                alt23=27;
                }
                break;
            case 57:
                {
                alt23=28;
                }
                break;
            case 58:
                {
                alt23=29;
                }
                break;
            case 59:
                {
                alt23=30;
                }
                break;
            case 60:
                {
                alt23=31;
                }
                break;
            case 61:
                {
                alt23=32;
                }
                break;
            case 62:
                {
                alt23=33;
                }
                break;
            case 63:
                {
                alt23=34;
                }
                break;
            case 64:
                {
                alt23=35;
                }
                break;
            case 65:
                {
                alt23=36;
                }
                break;
            case 66:
                {
                alt23=37;
                }
                break;
            case 67:
                {
                alt23=38;
                }
                break;
            case 68:
                {
                alt23=39;
                }
                break;
            case 69:
                {
                alt23=40;
                }
                break;
            case 70:
                {
                alt23=41;
                }
                break;
            case 71:
                {
                alt23=42;
                }
                break;
            case 72:
                {
                alt23=43;
                }
                break;
            case 73:
                {
                alt23=44;
                }
                break;
            case 74:
                {
                alt23=45;
                }
                break;
            case 75:
                {
                alt23=46;
                }
                break;
            case 76:
                {
                alt23=47;
                }
                break;
            case 77:
                {
                alt23=48;
                }
                break;
            case 78:
                {
                alt23=49;
                }
                break;
            case 79:
                {
                alt23=50;
                }
                break;
            case 80:
                {
                alt23=51;
                }
                break;
            case 81:
                {
                alt23=52;
                }
                break;
            case 82:
                {
                alt23=53;
                }
                break;
            case 83:
                {
                alt23=54;
                }
                break;
            case 84:
                {
                alt23=55;
                }
                break;
            case 85:
                {
                alt23=56;
                }
                break;
            case 86:
                {
                alt23=57;
                }
                break;
            case 87:
                {
                alt23=58;
                }
                break;
            case 88:
                {
                alt23=59;
                }
                break;
            case 89:
                {
                alt23=60;
                }
                break;
            case 90:
                {
                alt23=61;
                }
                break;
            case 91:
                {
                alt23=62;
                }
                break;
            case 92:
                {
                alt23=63;
                }
                break;
            case 93:
                {
                alt23=64;
                }
                break;
            case 94:
                {
                alt23=65;
                }
                break;
            case 95:
                {
                alt23=66;
                }
                break;
            case 96:
                {
                alt23=67;
                }
                break;
            case 97:
                {
                alt23=68;
                }
                break;
            case 98:
                {
                alt23=69;
                }
                break;
            case 99:
                {
                alt23=70;
                }
                break;
            case 100:
                {
                alt23=71;
                }
                break;
            case 101:
                {
                alt23=72;
                }
                break;
            case 102:
                {
                alt23=73;
                }
                break;
            case 103:
                {
                alt23=74;
                }
                break;
            case 104:
                {
                alt23=75;
                }
                break;
            case 105:
                {
                alt23=76;
                }
                break;
            case 106:
                {
                alt23=77;
                }
                break;
            case 107:
                {
                alt23=78;
                }
                break;
            case 108:
                {
                alt23=79;
                }
                break;
            case 109:
                {
                alt23=80;
                }
                break;
            case 110:
                {
                alt23=81;
                }
                break;
            case 111:
                {
                alt23=82;
                }
                break;
            case 112:
                {
                alt23=83;
                }
                break;
            case 113:
                {
                alt23=84;
                }
                break;
            case 114:
                {
                alt23=85;
                }
                break;
            case 115:
                {
                alt23=86;
                }
                break;
            case 116:
                {
                alt23=87;
                }
                break;
            case 117:
                {
                alt23=88;
                }
                break;
            case 118:
                {
                alt23=89;
                }
                break;
            case 119:
                {
                alt23=90;
                }
                break;
            case 120:
                {
                alt23=91;
                }
                break;
            case 121:
                {
                alt23=92;
                }
                break;
            case 122:
                {
                alt23=93;
                }
                break;
            case 123:
                {
                alt23=94;
                }
                break;
            case 124:
                {
                alt23=95;
                }
                break;
            case 125:
                {
                alt23=96;
                }
                break;
            case 126:
                {
                alt23=97;
                }
                break;
            case 127:
                {
                alt23=98;
                }
                break;
            case 128:
                {
                alt23=99;
                }
                break;
            case 129:
                {
                alt23=100;
                }
                break;
            case 130:
                {
                alt23=101;
                }
                break;
            case 131:
                {
                alt23=102;
                }
                break;
            case 132:
                {
                alt23=103;
                }
                break;
            case 133:
                {
                alt23=104;
                }
                break;
            case 134:
                {
                alt23=105;
                }
                break;
            case 135:
                {
                alt23=106;
                }
                break;
            case 136:
                {
                alt23=107;
                }
                break;
            case 137:
                {
                alt23=108;
                }
                break;
            case 138:
                {
                alt23=109;
                }
                break;
            case 139:
                {
                alt23=110;
                }
                break;
            case 140:
                {
                alt23=111;
                }
                break;
            case 141:
                {
                alt23=112;
                }
                break;
            case 142:
                {
                alt23=113;
                }
                break;
            case 143:
                {
                alt23=114;
                }
                break;
            case 144:
                {
                alt23=115;
                }
                break;
            case 145:
                {
                alt23=116;
                }
                break;
            case 146:
                {
                alt23=117;
                }
                break;
            case 147:
                {
                alt23=118;
                }
                break;
            case 148:
                {
                alt23=119;
                }
                break;
            case 149:
                {
                alt23=120;
                }
                break;
            case 150:
                {
                alt23=121;
                }
                break;
            case 151:
                {
                alt23=122;
                }
                break;
            case 152:
                {
                alt23=123;
                }
                break;
            case 153:
                {
                alt23=124;
                }
                break;
            case 154:
                {
                alt23=125;
                }
                break;
            case 155:
                {
                alt23=126;
                }
                break;
            case 156:
                {
                alt23=127;
                }
                break;
            case 157:
                {
                alt23=128;
                }
                break;
            case 158:
                {
                alt23=129;
                }
                break;
            case 159:
                {
                alt23=130;
                }
                break;
            case 160:
                {
                alt23=131;
                }
                break;
            case 161:
                {
                alt23=132;
                }
                break;
            case 162:
                {
                alt23=133;
                }
                break;
            case 163:
                {
                alt23=134;
                }
                break;
            case 164:
                {
                alt23=135;
                }
                break;
            case 165:
                {
                alt23=136;
                }
                break;
            case 166:
                {
                alt23=137;
                }
                break;
            case 167:
                {
                alt23=138;
                }
                break;
            case 168:
                {
                alt23=139;
                }
                break;
            case 169:
                {
                alt23=140;
                }
                break;
            case 170:
                {
                alt23=141;
                }
                break;
            case 171:
                {
                alt23=142;
                }
                break;
            case 172:
                {
                alt23=143;
                }
                break;
            case 173:
                {
                alt23=144;
                }
                break;
            case 174:
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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:950:2: kw= 'AliceBlue'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleColor2266); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAliceBlueKeyword_1_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:957:2: kw= 'AntiqueWhite'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleColor2285); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:964:2: kw= 'Aqua'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleColor2304); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAquaKeyword_1_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:971:2: kw= 'Aquamarine'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleColor2323); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAquamarineKeyword_1_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:978:2: kw= 'Azure'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleColor2342); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAzureKeyword_1_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:985:2: kw= 'Beige'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleColor2361); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBeigeKeyword_1_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:992:2: kw= 'Bisque'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleColor2380); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBisqueKeyword_1_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:999:2: kw= 'Black'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleColor2399); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlackKeyword_1_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1006:2: kw= 'BlanchedAlmond'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleColor2418); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlanchedAlmondKeyword_1_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1013:2: kw= 'Blue'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleColor2437); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlueKeyword_1_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1020:2: kw= 'BlueViolet'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleColor2456); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlueVioletKeyword_1_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1027:2: kw= 'Brown'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleColor2475); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBrownKeyword_1_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1034:2: kw= 'BurlyWood'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleColor2494); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBurlyWoodKeyword_1_12()); 
                        

                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1041:2: kw= 'CadetBlue'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleColor2513); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCadetBlueKeyword_1_13()); 
                        

                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1048:2: kw= 'Chartreuse'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleColor2532); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getChartreuseKeyword_1_14()); 
                        

                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1055:2: kw= 'Chocolate'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleColor2551); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getChocolateKeyword_1_15()); 
                        

                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1062:2: kw= 'Coral'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleColor2570); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCoralKeyword_1_16()); 
                        

                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1069:2: kw= 'CornflowerBlue'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleColor2589); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCornflowerBlueKeyword_1_17()); 
                        

                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1076:2: kw= 'Cornsilk'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleColor2608); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCornsilkKeyword_1_18()); 
                        

                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1083:2: kw= 'Crimson'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleColor2627); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCrimsonKeyword_1_19()); 
                        

                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1090:2: kw= 'Cyan'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleColor2646); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCyanKeyword_1_20()); 
                        

                    }
                    break;
                case 22 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1097:2: kw= 'DarkBlue'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleColor2665); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkBlueKeyword_1_21()); 
                        

                    }
                    break;
                case 23 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1104:2: kw= 'DarkCyan'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleColor2684); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkCyanKeyword_1_22()); 
                        

                    }
                    break;
                case 24 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1111:2: kw= 'DarkGoldenRod'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleColor2703); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGoldenRodKeyword_1_23()); 
                        

                    }
                    break;
                case 25 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1118:2: kw= 'DarkGray'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleColor2722); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGrayKeyword_1_24()); 
                        

                    }
                    break;
                case 26 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1125:2: kw= 'DarkGreen'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleColor2741); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGreenKeyword_1_25()); 
                        

                    }
                    break;
                case 27 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1132:2: kw= 'DarkGrey'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleColor2760); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGreyKeyword_1_26()); 
                        

                    }
                    break;
                case 28 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1139:2: kw= 'DarkKhaki'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleColor2779); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkKhakiKeyword_1_27()); 
                        

                    }
                    break;
                case 29 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1146:2: kw= 'DarkMagenta'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleColor2798); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkMagentaKeyword_1_28()); 
                        

                    }
                    break;
                case 30 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1153:2: kw= 'DarkOliveGreen'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleColor2817); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkOliveGreenKeyword_1_29()); 
                        

                    }
                    break;
                case 31 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1160:2: kw= 'DarkOrchid'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleColor2836); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkOrchidKeyword_1_30()); 
                        

                    }
                    break;
                case 32 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1167:2: kw= 'DarkRed'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleColor2855); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkRedKeyword_1_31()); 
                        

                    }
                    break;
                case 33 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1174:2: kw= 'DarkSalmo'
                    {
                    kw=(Token)match(input,62,FOLLOW_62_in_ruleColor2874); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSalmoKeyword_1_32()); 
                        

                    }
                    break;
                case 34 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1181:2: kw= 'DarkSeaGreen'
                    {
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleColor2893); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSeaGreenKeyword_1_33()); 
                        

                    }
                    break;
                case 35 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1188:2: kw= 'DarkSlateBlue'
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleColor2912); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSlateBlueKeyword_1_34()); 
                        

                    }
                    break;
                case 36 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1195:2: kw= 'DarkSlateGray'
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleColor2931); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSlateGrayKeyword_1_35()); 
                        

                    }
                    break;
                case 37 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1202:2: kw= 'DarkSlateGrey'
                    {
                    kw=(Token)match(input,66,FOLLOW_66_in_ruleColor2950); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSlateGreyKeyword_1_36()); 
                        

                    }
                    break;
                case 38 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1209:2: kw= 'DarkTurquoise'
                    {
                    kw=(Token)match(input,67,FOLLOW_67_in_ruleColor2969); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkTurquoiseKeyword_1_37()); 
                        

                    }
                    break;
                case 39 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1216:2: kw= 'DarkViolet'
                    {
                    kw=(Token)match(input,68,FOLLOW_68_in_ruleColor2988); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkVioletKeyword_1_38()); 
                        

                    }
                    break;
                case 40 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1223:2: kw= 'Darkorange'
                    {
                    kw=(Token)match(input,69,FOLLOW_69_in_ruleColor3007); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkorangeKeyword_1_39()); 
                        

                    }
                    break;
                case 41 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1230:2: kw= 'DeepPink'
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleColor3026); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDeepPinkKeyword_1_40()); 
                        

                    }
                    break;
                case 42 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1237:2: kw= 'DeepSkyBlue'
                    {
                    kw=(Token)match(input,71,FOLLOW_71_in_ruleColor3045); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDeepSkyBlueKeyword_1_41()); 
                        

                    }
                    break;
                case 43 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1244:2: kw= 'DimGray'
                    {
                    kw=(Token)match(input,72,FOLLOW_72_in_ruleColor3064); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDimGrayKeyword_1_42()); 
                        

                    }
                    break;
                case 44 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1251:2: kw= 'DimGrey'
                    {
                    kw=(Token)match(input,73,FOLLOW_73_in_ruleColor3083); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDimGreyKeyword_1_43()); 
                        

                    }
                    break;
                case 45 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1258:2: kw= 'DodgerBlue'
                    {
                    kw=(Token)match(input,74,FOLLOW_74_in_ruleColor3102); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDodgerBlueKeyword_1_44()); 
                        

                    }
                    break;
                case 46 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1265:2: kw= 'FireBrick'
                    {
                    kw=(Token)match(input,75,FOLLOW_75_in_ruleColor3121); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getFireBrickKeyword_1_45()); 
                        

                    }
                    break;
                case 47 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1272:2: kw= 'FloralWhite'
                    {
                    kw=(Token)match(input,76,FOLLOW_76_in_ruleColor3140); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getFloralWhiteKeyword_1_46()); 
                        

                    }
                    break;
                case 48 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1279:2: kw= 'ForestGreen'
                    {
                    kw=(Token)match(input,77,FOLLOW_77_in_ruleColor3159); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getForestGreenKeyword_1_47()); 
                        

                    }
                    break;
                case 49 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1286:2: kw= 'Fuchsia'
                    {
                    kw=(Token)match(input,78,FOLLOW_78_in_ruleColor3178); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getFuchsiaKeyword_1_48()); 
                        

                    }
                    break;
                case 50 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1293:2: kw= 'Gainsboro'
                    {
                    kw=(Token)match(input,79,FOLLOW_79_in_ruleColor3197); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGainsboroKeyword_1_49()); 
                        

                    }
                    break;
                case 51 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1300:2: kw= 'GhostWhite'
                    {
                    kw=(Token)match(input,80,FOLLOW_80_in_ruleColor3216); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGhostWhiteKeyword_1_50()); 
                        

                    }
                    break;
                case 52 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1307:2: kw= 'Gold'
                    {
                    kw=(Token)match(input,81,FOLLOW_81_in_ruleColor3235); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGoldKeyword_1_51()); 
                        

                    }
                    break;
                case 53 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1314:2: kw= 'GoldenRod'
                    {
                    kw=(Token)match(input,82,FOLLOW_82_in_ruleColor3254); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGoldenRodKeyword_1_52()); 
                        

                    }
                    break;
                case 54 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1321:2: kw= 'Gray'
                    {
                    kw=(Token)match(input,83,FOLLOW_83_in_ruleColor3273); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGrayKeyword_1_53()); 
                        

                    }
                    break;
                case 55 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1328:2: kw= 'Green'
                    {
                    kw=(Token)match(input,84,FOLLOW_84_in_ruleColor3292); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGreenKeyword_1_54()); 
                        

                    }
                    break;
                case 56 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1335:2: kw= 'GreenYellow'
                    {
                    kw=(Token)match(input,85,FOLLOW_85_in_ruleColor3311); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGreenYellowKeyword_1_55()); 
                        

                    }
                    break;
                case 57 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1342:2: kw= 'Grey'
                    {
                    kw=(Token)match(input,86,FOLLOW_86_in_ruleColor3330); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGreyKeyword_1_56()); 
                        

                    }
                    break;
                case 58 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1349:2: kw= 'HoneyDew'
                    {
                    kw=(Token)match(input,87,FOLLOW_87_in_ruleColor3349); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getHoneyDewKeyword_1_57()); 
                        

                    }
                    break;
                case 59 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1356:2: kw= 'HotPink'
                    {
                    kw=(Token)match(input,88,FOLLOW_88_in_ruleColor3368); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getHotPinkKeyword_1_58()); 
                        

                    }
                    break;
                case 60 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1363:2: kw= 'IndianRed'
                    {
                    kw=(Token)match(input,89,FOLLOW_89_in_ruleColor3387); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getIndianRedKeyword_1_59()); 
                        

                    }
                    break;
                case 61 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1370:2: kw= 'Indigo'
                    {
                    kw=(Token)match(input,90,FOLLOW_90_in_ruleColor3406); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getIndigoKeyword_1_60()); 
                        

                    }
                    break;
                case 62 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1377:2: kw= 'Ivory'
                    {
                    kw=(Token)match(input,91,FOLLOW_91_in_ruleColor3425); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getIvoryKeyword_1_61()); 
                        

                    }
                    break;
                case 63 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1384:2: kw= 'Khaki'
                    {
                    kw=(Token)match(input,92,FOLLOW_92_in_ruleColor3444); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getKhakiKeyword_1_62()); 
                        

                    }
                    break;
                case 64 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1391:2: kw= 'Lavender'
                    {
                    kw=(Token)match(input,93,FOLLOW_93_in_ruleColor3463); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLavenderKeyword_1_63()); 
                        

                    }
                    break;
                case 65 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1398:2: kw= 'LavenderBlush'
                    {
                    kw=(Token)match(input,94,FOLLOW_94_in_ruleColor3482); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLavenderBlushKeyword_1_64()); 
                        

                    }
                    break;
                case 66 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1405:2: kw= 'LawnGreen'
                    {
                    kw=(Token)match(input,95,FOLLOW_95_in_ruleColor3501); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLawnGreenKeyword_1_65()); 
                        

                    }
                    break;
                case 67 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1412:2: kw= 'LemonChiffon'
                    {
                    kw=(Token)match(input,96,FOLLOW_96_in_ruleColor3520); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLemonChiffonKeyword_1_66()); 
                        

                    }
                    break;
                case 68 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1419:2: kw= 'LightBlue'
                    {
                    kw=(Token)match(input,97,FOLLOW_97_in_ruleColor3539); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightBlueKeyword_1_67()); 
                        

                    }
                    break;
                case 69 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1426:2: kw= 'LightCoral'
                    {
                    kw=(Token)match(input,98,FOLLOW_98_in_ruleColor3558); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightCoralKeyword_1_68()); 
                        

                    }
                    break;
                case 70 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1433:2: kw= 'LightCyan'
                    {
                    kw=(Token)match(input,99,FOLLOW_99_in_ruleColor3577); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightCyanKeyword_1_69()); 
                        

                    }
                    break;
                case 71 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1440:2: kw= 'LightGoldenRodYellow'
                    {
                    kw=(Token)match(input,100,FOLLOW_100_in_ruleColor3596); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_1_70()); 
                        

                    }
                    break;
                case 72 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1447:2: kw= 'LightGray'
                    {
                    kw=(Token)match(input,101,FOLLOW_101_in_ruleColor3615); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGrayKeyword_1_71()); 
                        

                    }
                    break;
                case 73 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1454:2: kw= 'LightGreen'
                    {
                    kw=(Token)match(input,102,FOLLOW_102_in_ruleColor3634); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGreenKeyword_1_72()); 
                        

                    }
                    break;
                case 74 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1461:2: kw= 'LightGrey'
                    {
                    kw=(Token)match(input,103,FOLLOW_103_in_ruleColor3653); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGreyKeyword_1_73()); 
                        

                    }
                    break;
                case 75 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1468:2: kw= 'LightPink'
                    {
                    kw=(Token)match(input,104,FOLLOW_104_in_ruleColor3672); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightPinkKeyword_1_74()); 
                        

                    }
                    break;
                case 76 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1475:2: kw= 'LightSalmon'
                    {
                    kw=(Token)match(input,105,FOLLOW_105_in_ruleColor3691); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSalmonKeyword_1_75()); 
                        

                    }
                    break;
                case 77 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1482:2: kw= 'LightSeaGreen'
                    {
                    kw=(Token)match(input,106,FOLLOW_106_in_ruleColor3710); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSeaGreenKeyword_1_76()); 
                        

                    }
                    break;
                case 78 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1489:2: kw= 'LightSkyBlue'
                    {
                    kw=(Token)match(input,107,FOLLOW_107_in_ruleColor3729); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSkyBlueKeyword_1_77()); 
                        

                    }
                    break;
                case 79 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1496:2: kw= 'LightSlateGray'
                    {
                    kw=(Token)match(input,108,FOLLOW_108_in_ruleColor3748); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSlateGrayKeyword_1_78()); 
                        

                    }
                    break;
                case 80 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1503:2: kw= 'LightSlateGrey'
                    {
                    kw=(Token)match(input,109,FOLLOW_109_in_ruleColor3767); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSlateGreyKeyword_1_79()); 
                        

                    }
                    break;
                case 81 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1510:2: kw= 'LightSteelBlue'
                    {
                    kw=(Token)match(input,110,FOLLOW_110_in_ruleColor3786); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSteelBlueKeyword_1_80()); 
                        

                    }
                    break;
                case 82 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1517:2: kw= 'LightYellow'
                    {
                    kw=(Token)match(input,111,FOLLOW_111_in_ruleColor3805); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightYellowKeyword_1_81()); 
                        

                    }
                    break;
                case 83 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1524:2: kw= 'Lime'
                    {
                    kw=(Token)match(input,112,FOLLOW_112_in_ruleColor3824); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLimeKeyword_1_82()); 
                        

                    }
                    break;
                case 84 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1531:2: kw= 'LimeGreen'
                    {
                    kw=(Token)match(input,113,FOLLOW_113_in_ruleColor3843); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLimeGreenKeyword_1_83()); 
                        

                    }
                    break;
                case 85 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1538:2: kw= 'Linen'
                    {
                    kw=(Token)match(input,114,FOLLOW_114_in_ruleColor3862); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLinenKeyword_1_84()); 
                        

                    }
                    break;
                case 86 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1545:2: kw= 'Magenta'
                    {
                    kw=(Token)match(input,115,FOLLOW_115_in_ruleColor3881); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMagentaKeyword_1_85()); 
                        

                    }
                    break;
                case 87 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1552:2: kw= 'Maroon'
                    {
                    kw=(Token)match(input,116,FOLLOW_116_in_ruleColor3900); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMaroonKeyword_1_86()); 
                        

                    }
                    break;
                case 88 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1559:2: kw= 'MediumAquaMarine'
                    {
                    kw=(Token)match(input,117,FOLLOW_117_in_ruleColor3919); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumAquaMarineKeyword_1_87()); 
                        

                    }
                    break;
                case 89 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1566:2: kw= 'MediumBlue'
                    {
                    kw=(Token)match(input,118,FOLLOW_118_in_ruleColor3938); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumBlueKeyword_1_88()); 
                        

                    }
                    break;
                case 90 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1573:2: kw= 'MediumOrchid'
                    {
                    kw=(Token)match(input,119,FOLLOW_119_in_ruleColor3957); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumOrchidKeyword_1_89()); 
                        

                    }
                    break;
                case 91 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1580:2: kw= 'MediumPurple'
                    {
                    kw=(Token)match(input,120,FOLLOW_120_in_ruleColor3976); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumPurpleKeyword_1_90()); 
                        

                    }
                    break;
                case 92 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1587:2: kw= 'MediumSeaGreen'
                    {
                    kw=(Token)match(input,121,FOLLOW_121_in_ruleColor3995); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumSeaGreenKeyword_1_91()); 
                        

                    }
                    break;
                case 93 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1594:2: kw= 'MediumSlateBlue'
                    {
                    kw=(Token)match(input,122,FOLLOW_122_in_ruleColor4014); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumSlateBlueKeyword_1_92()); 
                        

                    }
                    break;
                case 94 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1601:2: kw= 'MediumSpringGreen'
                    {
                    kw=(Token)match(input,123,FOLLOW_123_in_ruleColor4033); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumSpringGreenKeyword_1_93()); 
                        

                    }
                    break;
                case 95 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1608:2: kw= 'MediumTurquoise'
                    {
                    kw=(Token)match(input,124,FOLLOW_124_in_ruleColor4052); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumTurquoiseKeyword_1_94()); 
                        

                    }
                    break;
                case 96 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1615:2: kw= 'MediumVioletRed'
                    {
                    kw=(Token)match(input,125,FOLLOW_125_in_ruleColor4071); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumVioletRedKeyword_1_95()); 
                        

                    }
                    break;
                case 97 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1622:2: kw= 'MidnightBlue'
                    {
                    kw=(Token)match(input,126,FOLLOW_126_in_ruleColor4090); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMidnightBlueKeyword_1_96()); 
                        

                    }
                    break;
                case 98 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1629:2: kw= 'MintCream'
                    {
                    kw=(Token)match(input,127,FOLLOW_127_in_ruleColor4109); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMintCreamKeyword_1_97()); 
                        

                    }
                    break;
                case 99 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1636:2: kw= 'MistyRose'
                    {
                    kw=(Token)match(input,128,FOLLOW_128_in_ruleColor4128); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMistyRoseKeyword_1_98()); 
                        

                    }
                    break;
                case 100 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1643:2: kw= 'Moccasin'
                    {
                    kw=(Token)match(input,129,FOLLOW_129_in_ruleColor4147); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMoccasinKeyword_1_99()); 
                        

                    }
                    break;
                case 101 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1650:2: kw= 'NavajoWhite'
                    {
                    kw=(Token)match(input,130,FOLLOW_130_in_ruleColor4166); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getNavajoWhiteKeyword_1_100()); 
                        

                    }
                    break;
                case 102 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1657:2: kw= 'Navy'
                    {
                    kw=(Token)match(input,131,FOLLOW_131_in_ruleColor4185); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getNavyKeyword_1_101()); 
                        

                    }
                    break;
                case 103 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1664:2: kw= 'OldLace'
                    {
                    kw=(Token)match(input,132,FOLLOW_132_in_ruleColor4204); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOldLaceKeyword_1_102()); 
                        

                    }
                    break;
                case 104 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1671:2: kw= 'Olive'
                    {
                    kw=(Token)match(input,133,FOLLOW_133_in_ruleColor4223); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOliveKeyword_1_103()); 
                        

                    }
                    break;
                case 105 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1678:2: kw= 'OliveDrab'
                    {
                    kw=(Token)match(input,134,FOLLOW_134_in_ruleColor4242); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOliveDrabKeyword_1_104()); 
                        

                    }
                    break;
                case 106 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1685:2: kw= 'OrangeRed'
                    {
                    kw=(Token)match(input,135,FOLLOW_135_in_ruleColor4261); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOrangeRedKeyword_1_105()); 
                        

                    }
                    break;
                case 107 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1692:2: kw= 'Orchid'
                    {
                    kw=(Token)match(input,136,FOLLOW_136_in_ruleColor4280); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOrchidKeyword_1_106()); 
                        

                    }
                    break;
                case 108 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1699:2: kw= 'PaleGoldenRod'
                    {
                    kw=(Token)match(input,137,FOLLOW_137_in_ruleColor4299); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleGoldenRodKeyword_1_107()); 
                        

                    }
                    break;
                case 109 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1706:2: kw= 'PaleGreen'
                    {
                    kw=(Token)match(input,138,FOLLOW_138_in_ruleColor4318); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleGreenKeyword_1_108()); 
                        

                    }
                    break;
                case 110 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1713:2: kw= 'PaleTurquoise'
                    {
                    kw=(Token)match(input,139,FOLLOW_139_in_ruleColor4337); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleTurquoiseKeyword_1_109()); 
                        

                    }
                    break;
                case 111 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1720:2: kw= 'PaleVioletRed'
                    {
                    kw=(Token)match(input,140,FOLLOW_140_in_ruleColor4356); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleVioletRedKeyword_1_110()); 
                        

                    }
                    break;
                case 112 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1727:2: kw= 'PapayaWhip'
                    {
                    kw=(Token)match(input,141,FOLLOW_141_in_ruleColor4375); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPapayaWhipKeyword_1_111()); 
                        

                    }
                    break;
                case 113 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1734:2: kw= 'PeachPuff'
                    {
                    kw=(Token)match(input,142,FOLLOW_142_in_ruleColor4394); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPeachPuffKeyword_1_112()); 
                        

                    }
                    break;
                case 114 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1741:2: kw= 'Peru'
                    {
                    kw=(Token)match(input,143,FOLLOW_143_in_ruleColor4413); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPeruKeyword_1_113()); 
                        

                    }
                    break;
                case 115 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1748:2: kw= 'Pink'
                    {
                    kw=(Token)match(input,144,FOLLOW_144_in_ruleColor4432); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPinkKeyword_1_114()); 
                        

                    }
                    break;
                case 116 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1755:2: kw= 'Plum'
                    {
                    kw=(Token)match(input,145,FOLLOW_145_in_ruleColor4451); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPlumKeyword_1_115()); 
                        

                    }
                    break;
                case 117 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1762:2: kw= 'PowderBlue'
                    {
                    kw=(Token)match(input,146,FOLLOW_146_in_ruleColor4470); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPowderBlueKeyword_1_116()); 
                        

                    }
                    break;
                case 118 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1769:2: kw= 'Purple'
                    {
                    kw=(Token)match(input,147,FOLLOW_147_in_ruleColor4489); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPurpleKeyword_1_117()); 
                        

                    }
                    break;
                case 119 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1776:2: kw= 'Red'
                    {
                    kw=(Token)match(input,148,FOLLOW_148_in_ruleColor4508); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getRedKeyword_1_118()); 
                        

                    }
                    break;
                case 120 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1783:2: kw= 'RosyBrown'
                    {
                    kw=(Token)match(input,149,FOLLOW_149_in_ruleColor4527); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getRosyBrownKeyword_1_119()); 
                        

                    }
                    break;
                case 121 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1790:2: kw= 'RoyalBlue'
                    {
                    kw=(Token)match(input,150,FOLLOW_150_in_ruleColor4546); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getRoyalBlueKeyword_1_120()); 
                        

                    }
                    break;
                case 122 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1797:2: kw= 'SaddleBrown'
                    {
                    kw=(Token)match(input,151,FOLLOW_151_in_ruleColor4565); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSaddleBrownKeyword_1_121()); 
                        

                    }
                    break;
                case 123 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1804:2: kw= 'Salmon'
                    {
                    kw=(Token)match(input,152,FOLLOW_152_in_ruleColor4584); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSalmonKeyword_1_122()); 
                        

                    }
                    break;
                case 124 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1811:2: kw= 'SandyBrown'
                    {
                    kw=(Token)match(input,153,FOLLOW_153_in_ruleColor4603); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSandyBrownKeyword_1_123()); 
                        

                    }
                    break;
                case 125 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1818:2: kw= 'SeaGreen'
                    {
                    kw=(Token)match(input,154,FOLLOW_154_in_ruleColor4622); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSeaGreenKeyword_1_124()); 
                        

                    }
                    break;
                case 126 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1825:2: kw= 'Sienna'
                    {
                    kw=(Token)match(input,155,FOLLOW_155_in_ruleColor4641); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSiennaKeyword_1_125()); 
                        

                    }
                    break;
                case 127 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1832:2: kw= 'Silver'
                    {
                    kw=(Token)match(input,156,FOLLOW_156_in_ruleColor4660); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSilverKeyword_1_126()); 
                        

                    }
                    break;
                case 128 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1839:2: kw= 'SkyBlue'
                    {
                    kw=(Token)match(input,157,FOLLOW_157_in_ruleColor4679); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSkyBlueKeyword_1_127()); 
                        

                    }
                    break;
                case 129 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1846:2: kw= 'SlateBlue'
                    {
                    kw=(Token)match(input,158,FOLLOW_158_in_ruleColor4698); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSlateBlueKeyword_1_128()); 
                        

                    }
                    break;
                case 130 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1853:2: kw= 'SlateGray'
                    {
                    kw=(Token)match(input,159,FOLLOW_159_in_ruleColor4717); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSlateGrayKeyword_1_129()); 
                        

                    }
                    break;
                case 131 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1860:2: kw= 'SlateGrey'
                    {
                    kw=(Token)match(input,160,FOLLOW_160_in_ruleColor4736); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSlateGreyKeyword_1_130()); 
                        

                    }
                    break;
                case 132 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1867:2: kw= 'Snow'
                    {
                    kw=(Token)match(input,161,FOLLOW_161_in_ruleColor4755); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSnowKeyword_1_131()); 
                        

                    }
                    break;
                case 133 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1874:2: kw= 'SpringGreen'
                    {
                    kw=(Token)match(input,162,FOLLOW_162_in_ruleColor4774); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSpringGreenKeyword_1_132()); 
                        

                    }
                    break;
                case 134 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1881:2: kw= 'SteelBlue'
                    {
                    kw=(Token)match(input,163,FOLLOW_163_in_ruleColor4793); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSteelBlueKeyword_1_133()); 
                        

                    }
                    break;
                case 135 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1888:2: kw= 'Tan'
                    {
                    kw=(Token)match(input,164,FOLLOW_164_in_ruleColor4812); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTanKeyword_1_134()); 
                        

                    }
                    break;
                case 136 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1895:2: kw= 'Teal'
                    {
                    kw=(Token)match(input,165,FOLLOW_165_in_ruleColor4831); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTealKeyword_1_135()); 
                        

                    }
                    break;
                case 137 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1902:2: kw= 'Thistle'
                    {
                    kw=(Token)match(input,166,FOLLOW_166_in_ruleColor4850); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getThistleKeyword_1_136()); 
                        

                    }
                    break;
                case 138 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1909:2: kw= 'Tomato'
                    {
                    kw=(Token)match(input,167,FOLLOW_167_in_ruleColor4869); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTomatoKeyword_1_137()); 
                        

                    }
                    break;
                case 139 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1916:2: kw= 'Turquoise'
                    {
                    kw=(Token)match(input,168,FOLLOW_168_in_ruleColor4888); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTurquoiseKeyword_1_138()); 
                        

                    }
                    break;
                case 140 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1923:2: kw= 'Violet'
                    {
                    kw=(Token)match(input,169,FOLLOW_169_in_ruleColor4907); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getVioletKeyword_1_139()); 
                        

                    }
                    break;
                case 141 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1930:2: kw= 'Wheat'
                    {
                    kw=(Token)match(input,170,FOLLOW_170_in_ruleColor4926); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getWheatKeyword_1_140()); 
                        

                    }
                    break;
                case 142 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1937:2: kw= 'White'
                    {
                    kw=(Token)match(input,171,FOLLOW_171_in_ruleColor4945); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getWhiteKeyword_1_141()); 
                        

                    }
                    break;
                case 143 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1944:2: kw= 'WhiteSmoke'
                    {
                    kw=(Token)match(input,172,FOLLOW_172_in_ruleColor4964); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getWhiteSmokeKeyword_1_142()); 
                        

                    }
                    break;
                case 144 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1951:2: kw= 'Yellow'
                    {
                    kw=(Token)match(input,173,FOLLOW_173_in_ruleColor4983); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getYellowKeyword_1_143()); 
                        

                    }
                    break;
                case 145 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:1958:2: kw= 'YellowGreen'
                    {
                    kw=(Token)match(input,174,FOLLOW_174_in_ruleColor5002); 

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

    // Delegated rules


    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA18_eotS =
        "\43\uffff";
    static final String DFA18_eofS =
        "\6\uffff\1\23\3\uffff\1\32\1\uffff\1\35\11\uffff\1\32\5\uffff\1"+
        "\40\1\uffff\1\42\4\uffff";
    static final String DFA18_minS =
        "\3\15\1\uffff\1\15\1\17\1\4\1\uffff\1\15\1\uffff\1\4\1\uffff\1"+
        "\4\4\uffff\1\15\2\uffff\1\15\1\uffff\1\4\5\uffff\1\4\1\uffff\1\4"+
        "\4\uffff";
    static final String DFA18_maxS =
        "\1\26\1\23\1\25\1\uffff\1\22\1\23\1\26\1\uffff\1\25\1\uffff\1\24"+
        "\1\uffff\1\16\4\uffff\1\15\2\uffff\1\23\1\uffff\1\24\5\uffff\1\24"+
        "\1\uffff\1\16\4\uffff";
    static final String DFA18_acceptS =
        "\3\uffff\1\4\3\uffff\1\7\1\uffff\1\11\1\uffff\1\6\1\uffff\1\22"+
        "\1\12\1\10\1\16\1\uffff\1\24\1\25\1\uffff\1\15\1\uffff\1\23\1\3"+
        "\1\13\1\1\1\5\1\uffff\1\2\1\uffff\1\20\1\17\1\21\1\14";
    static final String DFA18_specialS =
        "\43\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\1\1\uffff\1\2\1\3\1\uffff\1\4\1\uffff\1\5\1\uffff\1\6",
            "\1\10\1\12\2\uffff\1\7\1\uffff\1\11",
            "\1\14\1\uffff\1\13\5\uffff\1\15",
            "",
            "\1\17\4\uffff\1\16",
            "\1\21\3\uffff\1\20",
            "\1\23\21\uffff\1\22",
            "",
            "\1\24\1\26\2\uffff\1\7\1\25\1\11\1\uffff\1\27",
            "",
            "\1\32\11\uffff\1\33\1\uffff\1\30\3\uffff\1\31",
            "",
            "\1\35\10\uffff\1\35\1\34",
            "",
            "",
            "",
            "",
            "\1\36",
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
            return "276:1: ( ( (kw= '-' )* kw= '-' kw= '>' ) | (kw= '<' kw= '-' (kw= '-' )* ) | (kw= '-' kw= '>' kw= 'x' ) | (kw= 'x' kw= '<' kw= '-' ) | ( (kw= '-' )* kw= '-' kw= '>' kw= '>' ) | (kw= '<' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' ) | (kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' ) | (kw= '/' kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' ) | (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* ) | (kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '|' kw= '-' kw= '-' ) | (kw= '-' kw= '-' kw= '|' kw= '>' ) | (kw= '.' kw= '.' ) | kw= '.' )";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_ruleModel130 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_ruleDiagram_in_entryRuleDiagram166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDiagram176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_ruleDiagram213 = new BitSet(new long[]{0x000000001F800870L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleDiagram234 = new BitSet(new long[]{0x000000001F800870L});
    public static final BitSet FOLLOW_11_in_ruleDiagram247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction283 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstruction336 = new BitSet(new long[]{0x000000000055A000L});
    public static final BitSet FOLLOW_ruleSequence_in_ruleInstruction357 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstruction373 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleInstruction391 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstruction402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ML_COMMENT_in_ruleInstruction421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SL_COMMENT_in_ruleInstruction437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleInstruction465 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleColor_in_ruleInstruction481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_ruleInstruction505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequence_in_entryRuleSequence541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequence552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleSequence592 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence607 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleSequence641 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence654 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleSequence668 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleSequence691 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence704 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSequence717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleSequence738 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence751 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleSequence786 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence801 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence814 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleSequence848 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence861 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence874 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleSequence888 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleSequence912 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence927 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSequence940 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSequence953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleSequence974 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence987 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleSequence1001 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleSequence1025 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence1040 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleSequence1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleSequence1074 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSequence1087 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence1100 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleSequence1114 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleSequence1138 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence1153 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1166 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSequence1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleSequence1200 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence1213 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence1226 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleSequence1240 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleSequence1264 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence1279 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence1292 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSequence1305 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSequence1318 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSequence1331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleSequence1352 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleSequence1365 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence1378 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence1391 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleSequence1405 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_15_in_ruleSequence1428 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence1441 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleSequence1475 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence1488 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1501 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSequence1514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleSequence1535 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence1548 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence1561 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleSequence1595 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleSequence1608 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence1621 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence1634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleSequence1655 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSequence1668 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleSequence1681 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleSequence1715 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleSequence1728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleSequence1748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition1788 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition1798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleDefinition1836 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleDefinition1878 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleDefinition1920 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleDefinition1962 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleDefinition2004 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition2021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber2064 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAutoNumber2075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleAutoNumber2113 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAutoNumber2129 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAutoNumber2150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_entryRuleColor2200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColor2211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleColor2250 = new BitSet(new long[]{0xFFFFFFFFE0000000L,0xFFFFFFFFFFFFFFFFL,0x00007FFFFFFFFFFFL});
    public static final BitSet FOLLOW_30_in_ruleColor2266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleColor2285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleColor2304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleColor2323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleColor2342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleColor2361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleColor2380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleColor2399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleColor2418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleColor2437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleColor2456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleColor2475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleColor2494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleColor2513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleColor2532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleColor2551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleColor2570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleColor2589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleColor2608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleColor2627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleColor2646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleColor2665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleColor2684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleColor2703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleColor2722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleColor2741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleColor2760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleColor2779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleColor2798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleColor2817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleColor2836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleColor2855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleColor2874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleColor2893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleColor2912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleColor2931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleColor2950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleColor2969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleColor2988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleColor3007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleColor3026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleColor3045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleColor3064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleColor3083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleColor3102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleColor3121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleColor3140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleColor3159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleColor3178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleColor3197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleColor3216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleColor3235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleColor3254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleColor3273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleColor3292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleColor3311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_ruleColor3330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_ruleColor3349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleColor3368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_ruleColor3387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_ruleColor3406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_ruleColor3425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_ruleColor3444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_ruleColor3463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_ruleColor3482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_ruleColor3501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_ruleColor3520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_ruleColor3539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_ruleColor3558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_ruleColor3577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_ruleColor3596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_ruleColor3615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_ruleColor3634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_ruleColor3653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_ruleColor3672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_ruleColor3691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_ruleColor3710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_ruleColor3729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_ruleColor3748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_ruleColor3767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_ruleColor3786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_ruleColor3805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_ruleColor3824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_ruleColor3843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_ruleColor3862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_ruleColor3881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_ruleColor3900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_ruleColor3919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_ruleColor3938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_ruleColor3957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_ruleColor3976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_ruleColor3995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_ruleColor4014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_ruleColor4033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_ruleColor4052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_ruleColor4071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_ruleColor4090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_ruleColor4109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_ruleColor4128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_ruleColor4147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_ruleColor4166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_ruleColor4185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_ruleColor4204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_ruleColor4223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_134_in_ruleColor4242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_135_in_ruleColor4261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_136_in_ruleColor4280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_137_in_ruleColor4299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_138_in_ruleColor4318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_139_in_ruleColor4337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_140_in_ruleColor4356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_141_in_ruleColor4375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_142_in_ruleColor4394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_143_in_ruleColor4413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_144_in_ruleColor4432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_145_in_ruleColor4451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_146_in_ruleColor4470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_147_in_ruleColor4489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_148_in_ruleColor4508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_149_in_ruleColor4527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_150_in_ruleColor4546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_151_in_ruleColor4565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_152_in_ruleColor4584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_153_in_ruleColor4603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_154_in_ruleColor4622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_155_in_ruleColor4641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_156_in_ruleColor4660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_157_in_ruleColor4679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_ruleColor4698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_ruleColor4717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_ruleColor4736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_ruleColor4755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_ruleColor4774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_ruleColor4793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_ruleColor4812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_ruleColor4831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_166_in_ruleColor4850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_167_in_ruleColor4869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_ruleColor4888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_169_in_ruleColor4907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_170_in_ruleColor4926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_171_in_ruleColor4945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_172_in_ruleColor4964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_173_in_ruleColor4983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_174_in_ruleColor5002 = new BitSet(new long[]{0x0000000000000002L});

}