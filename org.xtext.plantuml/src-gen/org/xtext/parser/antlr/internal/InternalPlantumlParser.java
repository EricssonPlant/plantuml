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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LightGoldenRodYellow", "MediumSpringGreen", "MediumAquaMarine", "MediumSlateBlue", "MediumTurquoise", "MediumVioletRed", "BlanchedAlmond", "CornflowerBlue", "DarkOliveGreen", "LightSlateGray", "LightSlateGrey", "LightSteelBlue", "MediumSeaGreen", "DarkGoldenRod", "DarkSlateBlue", "DarkSlateGray", "DarkSlateGrey", "DarkTurquoise", "LavenderBlush", "LightSeaGreen", "PaleGoldenRod", "PaleTurquoise", "PaleVioletRed", "AntiqueWhite", "DarkSeaGreen", "LemonChiffon", "LightSkyBlue", "MediumOrchid", "MediumPurple", "MidnightBlue", "DarkMagenta", "DeepSkyBlue", "FloralWhite", "ForestGreen", "GreenYellow", "LightSalmon", "LightYellow", "NavajoWhite", "SaddleBrown", "SpringGreen", "YellowGreen", "Participant", "Aquamarine", "BlueViolet", "Chartreuse", "DarkOrchid", "DarkViolet", "Darkorange", "DodgerBlue", "GhostWhite", "LightCoral", "LightGreen", "MediumBlue", "PapayaWhip", "PowderBlue", "SandyBrown", "WhiteSmoke", "Autonumber", "Deactivate", "AliceBlue", "BurlyWood", "CadetBlue", "Chocolate", "DarkGreen", "DarkKhaki", "DarkSalmo", "FireBrick", "Gainsboro", "GoldenRod", "IndianRed", "LawnGreen", "LightBlue", "LightCyan", "LightGray", "LightGrey", "LightPink", "LimeGreen", "MintCream", "MistyRose", "OliveDrab", "OrangeRed", "PaleGreen", "PeachPuff", "RosyBrown", "RoyalBlue", "SlateBlue", "SlateGray", "SlateGrey", "SteelBlue", "Turquoise", "Endlegend", "Cornsilk", "DarkBlue", "DarkCyan", "DarkGray", "DarkGrey", "DeepPink", "HoneyDew", "Lavender", "Moccasin", "SeaGreen", "Activate", "Boundary", "Critical", "Database", "Crimson", "DarkRed", "DimGray", "DimGrey", "Fuchsia", "HotPink", "Magenta", "OldLace", "SkyBlue", "Thistle", "Control", "Destroy", "Footbox", "Newpage", "Bisque", "Indigo", "Maroon", "Orchid", "Purple", "Salmon", "Sienna", "Silver", "Tomato", "Violet", "Yellow", "Center", "Create", "Entity", "Legend", "Azure", "Beige", "Black", "Brown", "Coral", "Green", "Ivory", "Khaki", "Linen", "Olive", "Wheat", "White", "Actor", "Break", "Group", "Right", "Title", "Aqua", "Blue", "Cyan", "Gold", "Gray", "Grey", "Lime", "Navy", "Peru", "Pink", "Plum", "Snow", "Teal", "Else", "Hide", "Left", "Loop", "Note", "Over", "FullStopFullStopFullStop", "Red", "Tan", "Alt", "Box", "End", "Opt", "Par", "Ref", "VerticalLineVerticalLineVerticalLine", "LessThanSignLessThanSign", "EqualsSignEqualsSign", "GreaterThanSignGreaterThanSign", "Of", "VerticalLineVerticalLine", "QuotationMark", "NumberSign", "LeftParenthesis", "RightParenthesis", "Comma", "Colon", "RULE_NEWLINE", "RULE_START", "RULE_END", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_INT", "RULE_SEQUENCE", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Entity=136;
    public static final int Left=170;
    public static final int MediumOrchid=31;
    public static final int PaleGoldenRod=24;
    public static final int DarkSeaGreen=28;
    public static final int Sienna=129;
    public static final int Black=140;
    public static final int Gainsboro=71;
    public static final int LightCoral=54;
    public static final int DarkGrey=99;
    public static final int DodgerBlue=52;
    public static final int Aquamarine=46;
    public static final int Beige=139;
    public static final int Actor=150;
    public static final int OliveDrab=83;
    public static final int Violet=132;
    public static final int LimeGreen=80;
    public static final int RULE_ID=198;
    public static final int PowderBlue=58;
    public static final int Magenta=115;
    public static final int DarkTurquoise=21;
    public static final int IndianRed=73;
    public static final int LightGray=77;
    public static final int PeachPuff=86;
    public static final int Participant=45;
    public static final int Activate=105;
    public static final int RULE_INT=201;
    public static final int Note=172;
    public static final int LightBlue=75;
    public static final int SpringGreen=43;
    public static final int Indigo=124;
    public static final int DarkRed=110;
    public static final int Wheat=148;
    public static final int LessThanSignLessThanSign=184;
    public static final int MediumAquaMarine=6;
    public static final int DarkCyan=97;
    public static final int Group=152;
    public static final int LawnGreen=74;
    public static final int QuotationMark=189;
    public static final int DarkSalmo=69;
    public static final int Teal=167;
    public static final int HoneyDew=101;
    public static final int Maroon=125;
    public static final int Center=134;
    public static final int Blue=156;
    public static final int Moccasin=103;
    public static final int Chocolate=66;
    public static final int LightGoldenRodYellow=4;
    public static final int SeaGreen=104;
    public static final int Thistle=118;
    public static final int Red=175;
    public static final int Ref=182;
    public static final int MistyRose=82;
    public static final int Crimson=109;
    public static final int Par=181;
    public static final int DarkGray=98;
    public static final int DarkBlue=96;
    public static final int Fuchsia=113;
    public static final int Darkorange=51;
    public static final int Opt=180;
    public static final int Cornsilk=95;
    public static final int DarkSlateGrey=20;
    public static final int PaleGreen=85;
    public static final int DimGray=111;
    public static final int Gold=158;
    public static final int DarkOliveGreen=12;
    public static final int Gray=159;
    public static final int RightParenthesis=192;
    public static final int LemonChiffon=29;
    public static final int FloralWhite=36;
    public static final int GreenYellow=38;
    public static final int Silver=130;
    public static final int Khaki=145;
    public static final int LightSkyBlue=30;
    public static final int Ivory=144;
    public static final int DarkGreen=67;
    public static final int Linen=146;
    public static final int End=179;
    public static final int LightGreen=55;
    public static final int LightGrey=78;
    public static final int Brown=141;
    public static final int RULE_END=197;
    public static final int Aqua=155;
    public static final int RULE_START=196;
    public static final int Bisque=123;
    public static final int Footbox=121;
    public static final int MediumBlue=56;
    public static final int RULE_SL_COMMENT=200;
    public static final int BlueViolet=47;
    public static final int Over=173;
    public static final int Control=119;
    public static final int Lavender=102;
    public static final int CornflowerBlue=11;
    public static final int Colon=194;
    public static final int EOF=-1;
    public static final int Grey=160;
    public static final int MediumSpringGreen=5;
    public static final int Loop=171;
    public static final int DarkKhaki=68;
    public static final int Title=154;
    public static final int ForestGreen=37;
    public static final int GreaterThanSignGreaterThanSign=186;
    public static final int DarkOrchid=49;
    public static final int White=149;
    public static final int Purple=127;
    public static final int DarkMagenta=34;
    public static final int GoldenRod=72;
    public static final int Green=143;
    public static final int SkyBlue=117;
    public static final int Break=151;
    public static final int LightSlateGray=13;
    public static final int DarkSlateGray=19;
    public static final int DimGrey=112;
    public static final int LightSeaGreen=23;
    public static final int LeftParenthesis=191;
    public static final int RoyalBlue=88;
    public static final int DarkViolet=50;
    public static final int Database=108;
    public static final int MediumSlateBlue=7;
    public static final int MidnightBlue=33;
    public static final int SandyBrown=59;
    public static final int DarkSlateBlue=18;
    public static final int DeepSkyBlue=35;
    public static final int Chartreuse=48;
    public static final int Olive=147;
    public static final int EqualsSignEqualsSign=185;
    public static final int MediumPurple=32;
    public static final int Yellow=133;
    public static final int RULE_ML_COMMENT=199;
    public static final int Peru=163;
    public static final int RosyBrown=87;
    public static final int Hide=169;
    public static final int FireBrick=70;
    public static final int Legend=137;
    public static final int VerticalLineVerticalLine=188;
    public static final int RULE_NEWLINE=195;
    public static final int Right=153;
    public static final int Newpage=122;
    public static final int Comma=193;
    public static final int OrangeRed=84;
    public static final int Deactivate=62;
    public static final int Turquoise=93;
    public static final int Cyan=157;
    public static final int WhiteSmoke=60;
    public static final int MediumSeaGreen=16;
    public static final int LavenderBlush=22;
    public static final int LightCyan=76;
    public static final int SlateGray=90;
    public static final int Else=168;
    public static final int NavajoWhite=41;
    public static final int SlateBlue=89;
    public static final int Orchid=126;
    public static final int Tan=176;
    public static final int LightSalmon=39;
    public static final int Snow=166;
    public static final int RULE_SEQUENCE=202;
    public static final int Alt=177;
    public static final int Critical=107;
    public static final int Tomato=131;
    public static final int FullStopFullStopFullStop=174;
    public static final int LightSlateGrey=14;
    public static final int Boundary=106;
    public static final int Plum=165;
    public static final int YellowGreen=44;
    public static final int MintCream=81;
    public static final int VerticalLineVerticalLineVerticalLine=183;
    public static final int PaleVioletRed=26;
    public static final int Azure=138;
    public static final int Endlegend=94;
    public static final int Salmon=128;
    public static final int Box=178;
    public static final int BlanchedAlmond=10;
    public static final int Pink=164;
    public static final int AliceBlue=63;
    public static final int NumberSign=190;
    public static final int PapayaWhip=57;
    public static final int MediumTurquoise=8;
    public static final int AntiqueWhite=27;
    public static final int LightPink=79;
    public static final int OldLace=116;
    public static final int DarkGoldenRod=17;
    public static final int CadetBlue=65;
    public static final int BurlyWood=64;
    public static final int Lime=161;
    public static final int Destroy=120;
    public static final int Create=135;
    public static final int LightSteelBlue=15;
    public static final int GhostWhite=53;
    public static final int SteelBlue=92;
    public static final int PaleTurquoise=25;
    public static final int RULE_WS=203;
    public static final int RULE_ANY_OTHER=204;
    public static final int DeepPink=100;
    public static final int MediumVioletRed=9;
    public static final int HotPink=114;
    public static final int LightYellow=40;
    public static final int Navy=162;
    public static final int SaddleBrown=42;
    public static final int Coral=142;
    public static final int SlateGrey=91;
    public static final int Of=187;
    public static final int Autonumber=61;

    // delegates
    // delegators


        public InternalPlantumlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPlantumlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPlantumlParser.tokenNames; }
    public String getGrammarFileName() { return "../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g"; }




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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:61:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:62:2: (iv_ruleModel= ruleModel EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:63:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel67);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel77); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:70:1: ruleModel returns [EObject current=null] : ( (lv_diagrams_0_0= ruleDiagram ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_diagrams_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:73:28: ( ( (lv_diagrams_0_0= ruleDiagram ) )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:74:1: ( (lv_diagrams_0_0= ruleDiagram ) )*
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:74:1: ( (lv_diagrams_0_0= ruleDiagram ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_START) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:75:1: (lv_diagrams_0_0= ruleDiagram )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:75:1: (lv_diagrams_0_0= ruleDiagram )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:76:3: lv_diagrams_0_0= ruleDiagram
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getDiagramsDiagramParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDiagram_in_ruleModel122);
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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:100:1: entryRuleDiagram returns [EObject current=null] : iv_ruleDiagram= ruleDiagram EOF ;
    public final EObject entryRuleDiagram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDiagram = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:101:2: (iv_ruleDiagram= ruleDiagram EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:102:2: iv_ruleDiagram= ruleDiagram EOF
            {
             newCompositeNode(grammarAccess.getDiagramRule()); 
            pushFollow(FOLLOW_ruleDiagram_in_entryRuleDiagram157);
            iv_ruleDiagram=ruleDiagram();

            state._fsp--;

             current =iv_ruleDiagram; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDiagram167); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:109:1: ruleDiagram returns [EObject current=null] : ( () this_START_1= RULE_START this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* this_END_4= RULE_END (this_NEWLINE_5= RULE_NEWLINE )* ) ;
    public final EObject ruleDiagram() throws RecognitionException {
        EObject current = null;

        Token this_START_1=null;
        Token this_NEWLINE_2=null;
        Token this_END_4=null;
        Token this_NEWLINE_5=null;
        EObject lv_instructions_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:112:28: ( ( () this_START_1= RULE_START this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* this_END_4= RULE_END (this_NEWLINE_5= RULE_NEWLINE )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:113:1: ( () this_START_1= RULE_START this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* this_END_4= RULE_END (this_NEWLINE_5= RULE_NEWLINE )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:113:1: ( () this_START_1= RULE_START this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* this_END_4= RULE_END (this_NEWLINE_5= RULE_NEWLINE )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:113:2: () this_START_1= RULE_START this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* this_END_4= RULE_END (this_NEWLINE_5= RULE_NEWLINE )*
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:113:2: ()
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:114:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDiagramAccess().getDiagramAction_0(),
                        current);
                

            }

            this_START_1=(Token)match(input,RULE_START,FOLLOW_RULE_START_in_ruleDiagram212); 
             
                newLeafNode(this_START_1, grammarAccess.getDiagramAccess().getSTARTTerminalRuleCall_1()); 
                
            this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleDiagram222); 
             
                newLeafNode(this_NEWLINE_2, grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_2()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:127:1: ( (lv_instructions_3_0= ruleInstruction ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Participant||(LA2_0>=Autonumber && LA2_0<=Deactivate)||(LA2_0>=Activate && LA2_0<=Database)||(LA2_0>=Control && LA2_0<=Destroy)||LA2_0==Newpage||(LA2_0>=Create && LA2_0<=Legend)||(LA2_0>=Actor && LA2_0<=Group)||LA2_0==Title||LA2_0==Hide||(LA2_0>=Loop && LA2_0<=Note)||LA2_0==FullStopFullStopFullStop||(LA2_0>=Alt && LA2_0<=Box)||(LA2_0>=Opt && LA2_0<=VerticalLineVerticalLineVerticalLine)||LA2_0==EqualsSignEqualsSign||LA2_0==VerticalLineVerticalLine||LA2_0==RULE_NEWLINE||LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:128:1: (lv_instructions_3_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:128:1: (lv_instructions_3_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:129:3: lv_instructions_3_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleDiagram242);
            	    lv_instructions_3_0=ruleInstruction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDiagramRule());
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
            	    break loop2;
                }
            } while (true);

            this_END_4=(Token)match(input,RULE_END,FOLLOW_RULE_END_in_ruleDiagram254); 
             
                newLeafNode(this_END_4, grammarAccess.getDiagramAccess().getENDTerminalRuleCall_4()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:149:1: (this_NEWLINE_5= RULE_NEWLINE )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_NEWLINE) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:149:2: this_NEWLINE_5= RULE_NEWLINE
            	    {
            	    this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleDiagram265); 
            	     
            	        newLeafNode(this_NEWLINE_5, grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_5()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop3;
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
    // $ANTLR end "ruleDiagram"


    // $ANTLR start "entryRuleInstruction"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:161:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:162:2: (iv_ruleInstruction= ruleInstruction EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:163:2: iv_ruleInstruction= ruleInstruction EOF
            {
             newCompositeNode(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_ruleInstruction_in_entryRuleInstruction301);
            iv_ruleInstruction=ruleInstruction();

            state._fsp--;

             current =iv_ruleInstruction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstruction311); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:170:1: ruleInstruction returns [EObject current=null] : ( (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition ( ruleColor )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_7= ruleAltElse | this_GroupingMessages_8= ruleGroupingMessages | this_Note_9= ruleNote | ruleDivider | this_Reference_11= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_15= ruleActivate | this_Deactivate_16= ruleDeactivate | ruleParticipantCreation | this_Box_18= ruleBox )? this_NEWLINE_19= RULE_NEWLINE ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_19=null;
        EObject this_Arrow_0 = null;

        EObject this_Definition_1 = null;

        EObject this_AltElse_7 = null;

        EObject this_GroupingMessages_8 = null;

        EObject this_Note_9 = null;

        EObject this_Reference_11 = null;

        EObject this_Activate_15 = null;

        EObject this_Deactivate_16 = null;

        EObject this_Box_18 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:173:28: ( ( (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition ( ruleColor )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_7= ruleAltElse | this_GroupingMessages_8= ruleGroupingMessages | this_Note_9= ruleNote | ruleDivider | this_Reference_11= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_15= ruleActivate | this_Deactivate_16= ruleDeactivate | ruleParticipantCreation | this_Box_18= ruleBox )? this_NEWLINE_19= RULE_NEWLINE ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:174:1: ( (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition ( ruleColor )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_7= ruleAltElse | this_GroupingMessages_8= ruleGroupingMessages | this_Note_9= ruleNote | ruleDivider | this_Reference_11= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_15= ruleActivate | this_Deactivate_16= ruleDeactivate | ruleParticipantCreation | this_Box_18= ruleBox )? this_NEWLINE_19= RULE_NEWLINE )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:174:1: ( (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition ( ruleColor )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_7= ruleAltElse | this_GroupingMessages_8= ruleGroupingMessages | this_Note_9= ruleNote | ruleDivider | this_Reference_11= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_15= ruleActivate | this_Deactivate_16= ruleDeactivate | ruleParticipantCreation | this_Box_18= ruleBox )? this_NEWLINE_19= RULE_NEWLINE )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:174:2: (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition ( ruleColor )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_7= ruleAltElse | this_GroupingMessages_8= ruleGroupingMessages | this_Note_9= ruleNote | ruleDivider | this_Reference_11= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_15= ruleActivate | this_Deactivate_16= ruleDeactivate | ruleParticipantCreation | this_Box_18= ruleBox )? this_NEWLINE_19= RULE_NEWLINE
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:174:2: (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition ( ruleColor )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_7= ruleAltElse | this_GroupingMessages_8= ruleGroupingMessages | this_Note_9= ruleNote | ruleDivider | this_Reference_11= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_15= ruleActivate | this_Deactivate_16= ruleDeactivate | ruleParticipantCreation | this_Box_18= ruleBox )?
            int alt5=19;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    alt5=1;
                    }
                    break;
                case Participant:
                case Boundary:
                case Database:
                case Control:
                case Entity:
                case Actor:
                    {
                    alt5=2;
                    }
                    break;
                case Autonumber:
                    {
                    alt5=3;
                    }
                    break;
                case Title:
                    {
                    alt5=4;
                    }
                    break;
                case Legend:
                    {
                    alt5=5;
                    }
                    break;
                case Newpage:
                    {
                    alt5=6;
                    }
                    break;
                case Alt:
                    {
                    alt5=7;
                    }
                    break;
                case Critical:
                case Break:
                case Group:
                case Loop:
                case Opt:
                case Par:
                    {
                    alt5=8;
                    }
                    break;
                case Note:
                    {
                    alt5=9;
                    }
                    break;
                case EqualsSignEqualsSign:
                    {
                    alt5=10;
                    }
                    break;
                case Ref:
                    {
                    alt5=11;
                    }
                    break;
                case FullStopFullStopFullStop:
                    {
                    alt5=12;
                    }
                    break;
                case VerticalLineVerticalLineVerticalLine:
                case VerticalLineVerticalLine:
                    {
                    alt5=13;
                    }
                    break;
                case Hide:
                    {
                    alt5=14;
                    }
                    break;
                case Activate:
                    {
                    alt5=15;
                    }
                    break;
                case Deactivate:
                case Destroy:
                    {
                    alt5=16;
                    }
                    break;
                case Create:
                    {
                    alt5=17;
                    }
                    break;
                case Box:
                    {
                    alt5=18;
                    }
                    break;
            }

            switch (alt5) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:175:5: this_Arrow_0= ruleArrow
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getArrowParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_ruleArrow_in_ruleInstruction359);
                    this_Arrow_0=ruleArrow();

                    state._fsp--;


                            current = this_Arrow_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:184:6: (this_Definition_1= ruleDefinition ( ruleColor )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:184:6: (this_Definition_1= ruleDefinition ( ruleColor )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:185:5: this_Definition_1= ruleDefinition ( ruleColor )?
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_0_1_0()); 
                        
                    pushFollow(FOLLOW_ruleDefinition_in_ruleInstruction387);
                    this_Definition_1=ruleDefinition();

                    state._fsp--;


                            current = this_Definition_1;
                            afterParserOrEnumRuleCall();
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:193:1: ( ruleColor )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==NumberSign) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:194:5: ruleColor
                            {
                             
                                    newCompositeNode(grammarAccess.getInstructionAccess().getColorParserRuleCall_0_1_1()); 
                                
                            pushFollow(FOLLOW_ruleColor_in_ruleInstruction403);
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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:203:5: ruleAutoNumber
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 
                        
                    pushFollow(FOLLOW_ruleAutoNumber_in_ruleInstruction427);
                    ruleAutoNumber();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:212:5: ruleTitle
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 
                        
                    pushFollow(FOLLOW_ruleTitle_in_ruleInstruction448);
                    ruleTitle();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:221:5: ruleLegend
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 
                        
                    pushFollow(FOLLOW_ruleLegend_in_ruleInstruction469);
                    ruleLegend();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:230:5: ruleNewpage
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 
                        
                    pushFollow(FOLLOW_ruleNewpage_in_ruleInstruction490);
                    ruleNewpage();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:239:5: this_AltElse_7= ruleAltElse
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getAltElseParserRuleCall_0_6()); 
                        
                    pushFollow(FOLLOW_ruleAltElse_in_ruleInstruction517);
                    this_AltElse_7=ruleAltElse();

                    state._fsp--;


                            current = this_AltElse_7;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:249:5: this_GroupingMessages_8= ruleGroupingMessages
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getGroupingMessagesParserRuleCall_0_7()); 
                        
                    pushFollow(FOLLOW_ruleGroupingMessages_in_ruleInstruction544);
                    this_GroupingMessages_8=ruleGroupingMessages();

                    state._fsp--;


                            current = this_GroupingMessages_8;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:259:5: this_Note_9= ruleNote
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getNoteParserRuleCall_0_8()); 
                        
                    pushFollow(FOLLOW_ruleNote_in_ruleInstruction571);
                    this_Note_9=ruleNote();

                    state._fsp--;


                            current = this_Note_9;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:269:5: ruleDivider
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDividerParserRuleCall_0_9()); 
                        
                    pushFollow(FOLLOW_ruleDivider_in_ruleInstruction592);
                    ruleDivider();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:278:5: this_Reference_11= ruleReference
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getReferenceParserRuleCall_0_10()); 
                        
                    pushFollow(FOLLOW_ruleReference_in_ruleInstruction619);
                    this_Reference_11=ruleReference();

                    state._fsp--;


                            current = this_Reference_11;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:288:5: ruleDelay
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDelayParserRuleCall_0_11()); 
                        
                    pushFollow(FOLLOW_ruleDelay_in_ruleInstruction640);
                    ruleDelay();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:297:5: ruleSpace
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getSpaceParserRuleCall_0_12()); 
                        
                    pushFollow(FOLLOW_ruleSpace_in_ruleInstruction661);
                    ruleSpace();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:306:5: ruleHidefootbox
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getHidefootboxParserRuleCall_0_13()); 
                        
                    pushFollow(FOLLOW_ruleHidefootbox_in_ruleInstruction682);
                    ruleHidefootbox();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:315:5: this_Activate_15= ruleActivate
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getActivateParserRuleCall_0_14()); 
                        
                    pushFollow(FOLLOW_ruleActivate_in_ruleInstruction709);
                    this_Activate_15=ruleActivate();

                    state._fsp--;


                            current = this_Activate_15;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:325:5: this_Deactivate_16= ruleDeactivate
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDeactivateParserRuleCall_0_15()); 
                        
                    pushFollow(FOLLOW_ruleDeactivate_in_ruleInstruction736);
                    this_Deactivate_16=ruleDeactivate();

                    state._fsp--;


                            current = this_Deactivate_16;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:335:5: ruleParticipantCreation
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getParticipantCreationParserRuleCall_0_16()); 
                        
                    pushFollow(FOLLOW_ruleParticipantCreation_in_ruleInstruction757);
                    ruleParticipantCreation();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:344:5: this_Box_18= ruleBox
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getBoxParserRuleCall_0_17()); 
                        
                    pushFollow(FOLLOW_ruleBox_in_ruleInstruction784);
                    this_Box_18=ruleBox();

                    state._fsp--;


                            current = this_Box_18;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            this_NEWLINE_19=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleInstruction796); 
             
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


    // $ANTLR start "entryRuleArrow"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:364:1: entryRuleArrow returns [EObject current=null] : iv_ruleArrow= ruleArrow EOF ;
    public final EObject entryRuleArrow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrow = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:365:2: (iv_ruleArrow= ruleArrow EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:366:2: iv_ruleArrow= ruleArrow EOF
            {
             newCompositeNode(grammarAccess.getArrowRule()); 
            pushFollow(FOLLOW_ruleArrow_in_entryRuleArrow830);
            iv_ruleArrow=ruleArrow();

            state._fsp--;

             current =iv_ruleArrow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrow840); 

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
    // $ANTLR end "entryRuleArrow"


    // $ANTLR start "ruleArrow"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:373:1: ruleArrow returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon (this_ID_4= RULE_ID )* )? ) ;
    public final EObject ruleArrow() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_SEQUENCE_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:376:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon (this_ID_4= RULE_ID )* )? ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:377:1: ( ( (lv_name_0_0= RULE_ID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon (this_ID_4= RULE_ID )* )? )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:377:1: ( ( (lv_name_0_0= RULE_ID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon (this_ID_4= RULE_ID )* )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:377:2: ( (lv_name_0_0= RULE_ID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon (this_ID_4= RULE_ID )* )?
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:377:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:378:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:378:1: (lv_name_0_0= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:379:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArrow882); 

            			newLeafNode(lv_name_0_0, grammarAccess.getArrowAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getArrowRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            this_SEQUENCE_1=(Token)match(input,RULE_SEQUENCE,FOLLOW_RULE_SEQUENCE_in_ruleArrow898); 
             
                newLeafNode(this_SEQUENCE_1, grammarAccess.getArrowAccess().getSEQUENCETerminalRuleCall_1()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:399:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:400:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:400:1: (lv_name_2_0= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:401:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArrow914); 

            			newLeafNode(lv_name_2_0, grammarAccess.getArrowAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getArrowRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:417:2: (otherlv_3= Colon (this_ID_4= RULE_ID )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Colon) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:418:2: otherlv_3= Colon (this_ID_4= RULE_ID )*
                    {
                    otherlv_3=(Token)match(input,Colon,FOLLOW_Colon_in_ruleArrow933); 

                        	newLeafNode(otherlv_3, grammarAccess.getArrowAccess().getColonKeyword_3_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:422:1: (this_ID_4= RULE_ID )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==RULE_ID) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:422:2: this_ID_4= RULE_ID
                    	    {
                    	    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArrow944); 
                    	     
                    	        newLeafNode(this_ID_4, grammarAccess.getArrowAccess().getIDTerminalRuleCall_3_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


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
    // $ANTLR end "ruleArrow"


    // $ANTLR start "entryRuleDefinition"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:434:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:435:2: (iv_ruleDefinition= ruleDefinition EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:436:2: iv_ruleDefinition= ruleDefinition EOF
            {
             newCompositeNode(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition982);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition992); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:443:1: ruleDefinition returns [EObject current=null] : ( (otherlv_0= Actor ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= RULE_ID ) ) ) | (otherlv_10= Participant ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= LessThanSignLessThanSign ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma ruleColor otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma ruleColor otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID ) otherlv_25= GreaterThanSignGreaterThanSign )? ) ) ;
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
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token this_ID_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token this_ID_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token this_ID_23=null;
        Token this_ID_24=null;
        Token otherlv_25=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:446:28: ( ( (otherlv_0= Actor ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= RULE_ID ) ) ) | (otherlv_10= Participant ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= LessThanSignLessThanSign ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma ruleColor otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma ruleColor otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID ) otherlv_25= GreaterThanSignGreaterThanSign )? ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:447:1: ( (otherlv_0= Actor ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= RULE_ID ) ) ) | (otherlv_10= Participant ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= LessThanSignLessThanSign ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma ruleColor otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma ruleColor otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID ) otherlv_25= GreaterThanSignGreaterThanSign )? ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:447:1: ( (otherlv_0= Actor ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= RULE_ID ) ) ) | (otherlv_10= Participant ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= LessThanSignLessThanSign ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma ruleColor otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma ruleColor otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID ) otherlv_25= GreaterThanSignGreaterThanSign )? ) )
            int alt10=6;
            switch ( input.LA(1) ) {
            case Actor:
                {
                alt10=1;
                }
                break;
            case Boundary:
                {
                alt10=2;
                }
                break;
            case Control:
                {
                alt10=3;
                }
                break;
            case Entity:
                {
                alt10=4;
                }
                break;
            case Database:
                {
                alt10=5;
                }
                break;
            case Participant:
                {
                alt10=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:447:2: (otherlv_0= Actor ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:447:2: (otherlv_0= Actor ( (lv_name_1_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:448:2: otherlv_0= Actor ( (lv_name_1_0= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,Actor,FOLLOW_Actor_in_ruleDefinition1031); 

                        	newLeafNode(otherlv_0, grammarAccess.getDefinitionAccess().getActorKeyword_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:452:1: ( (lv_name_1_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:453:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:453:1: (lv_name_1_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:454:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1047); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:471:6: (otherlv_2= Boundary ( (lv_name_3_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:471:6: (otherlv_2= Boundary ( (lv_name_3_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:472:2: otherlv_2= Boundary ( (lv_name_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,Boundary,FOLLOW_Boundary_in_ruleDefinition1073); 

                        	newLeafNode(otherlv_2, grammarAccess.getDefinitionAccess().getBoundaryKeyword_1_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:476:1: ( (lv_name_3_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:477:1: (lv_name_3_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:477:1: (lv_name_3_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:478:3: lv_name_3_0= RULE_ID
                    {
                    lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1089); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:495:6: (otherlv_4= Control ( (lv_name_5_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:495:6: (otherlv_4= Control ( (lv_name_5_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:496:2: otherlv_4= Control ( (lv_name_5_0= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,Control,FOLLOW_Control_in_ruleDefinition1115); 

                        	newLeafNode(otherlv_4, grammarAccess.getDefinitionAccess().getControlKeyword_2_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:500:1: ( (lv_name_5_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:501:1: (lv_name_5_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:501:1: (lv_name_5_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:502:3: lv_name_5_0= RULE_ID
                    {
                    lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1131); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:519:6: (otherlv_6= Entity ( (lv_name_7_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:519:6: (otherlv_6= Entity ( (lv_name_7_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:520:2: otherlv_6= Entity ( (lv_name_7_0= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,Entity,FOLLOW_Entity_in_ruleDefinition1157); 

                        	newLeafNode(otherlv_6, grammarAccess.getDefinitionAccess().getEntityKeyword_3_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:524:1: ( (lv_name_7_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:525:1: (lv_name_7_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:525:1: (lv_name_7_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:526:3: lv_name_7_0= RULE_ID
                    {
                    lv_name_7_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1173); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:543:6: (otherlv_8= Database ( (lv_name_9_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:543:6: (otherlv_8= Database ( (lv_name_9_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:544:2: otherlv_8= Database ( (lv_name_9_0= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,Database,FOLLOW_Database_in_ruleDefinition1199); 

                        	newLeafNode(otherlv_8, grammarAccess.getDefinitionAccess().getDatabaseKeyword_4_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:548:1: ( (lv_name_9_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:549:1: (lv_name_9_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:549:1: (lv_name_9_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:550:3: lv_name_9_0= RULE_ID
                    {
                    lv_name_9_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1215); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:567:6: (otherlv_10= Participant ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= LessThanSignLessThanSign ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma ruleColor otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma ruleColor otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID ) otherlv_25= GreaterThanSignGreaterThanSign )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:567:6: (otherlv_10= Participant ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= LessThanSignLessThanSign ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma ruleColor otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma ruleColor otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID ) otherlv_25= GreaterThanSignGreaterThanSign )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:568:2: otherlv_10= Participant ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= LessThanSignLessThanSign ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma ruleColor otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma ruleColor otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID ) otherlv_25= GreaterThanSignGreaterThanSign )?
                    {
                    otherlv_10=(Token)match(input,Participant,FOLLOW_Participant_in_ruleDefinition1241); 

                        	newLeafNode(otherlv_10, grammarAccess.getDefinitionAccess().getParticipantKeyword_5_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:572:1: ( (lv_name_11_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:573:1: (lv_name_11_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:573:1: (lv_name_11_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:574:3: lv_name_11_0= RULE_ID
                    {
                    lv_name_11_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1257); 

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

                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:590:2: (otherlv_12= LessThanSignLessThanSign ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma ruleColor otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma ruleColor otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID ) otherlv_25= GreaterThanSignGreaterThanSign )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==LessThanSignLessThanSign) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:591:2: otherlv_12= LessThanSignLessThanSign ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma ruleColor otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma ruleColor otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID ) otherlv_25= GreaterThanSignGreaterThanSign
                            {
                            otherlv_12=(Token)match(input,LessThanSignLessThanSign,FOLLOW_LessThanSignLessThanSign_in_ruleDefinition1276); 

                                	newLeafNode(otherlv_12, grammarAccess.getDefinitionAccess().getLessThanSignLessThanSignKeyword_5_2_0());
                                
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:595:1: ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma ruleColor otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma ruleColor otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID )
                            int alt8=3;
                            alt8 = dfa8.predict(input);
                            switch (alt8) {
                                case 1 :
                                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:595:2: (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma ruleColor otherlv_17= RightParenthesis )
                                    {
                                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:595:2: (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma ruleColor otherlv_17= RightParenthesis )
                                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:596:2: otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma ruleColor otherlv_17= RightParenthesis
                                    {
                                    otherlv_13=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_ruleDefinition1290); 

                                        	newLeafNode(otherlv_13, grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_0_0());
                                        
                                    this_ID_14=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1300); 
                                     
                                        newLeafNode(this_ID_14, grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_0_1()); 
                                        
                                    otherlv_15=(Token)match(input,Comma,FOLLOW_Comma_in_ruleDefinition1312); 

                                        	newLeafNode(otherlv_15, grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_0_2());
                                        
                                     
                                            newCompositeNode(grammarAccess.getDefinitionAccess().getColorParserRuleCall_5_2_1_0_3()); 
                                        
                                    pushFollow(FOLLOW_ruleColor_in_ruleDefinition1327);
                                    ruleColor();

                                    state._fsp--;


                                            afterParserOrEnumRuleCall();
                                        
                                    otherlv_17=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_ruleDefinition1339); 

                                        	newLeafNode(otherlv_17, grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_0_4());
                                        

                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:623:6: (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma ruleColor otherlv_22= RightParenthesis this_ID_23= RULE_ID )
                                    {
                                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:623:6: (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma ruleColor otherlv_22= RightParenthesis this_ID_23= RULE_ID )
                                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:624:2: otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma ruleColor otherlv_22= RightParenthesis this_ID_23= RULE_ID
                                    {
                                    otherlv_18=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_ruleDefinition1359); 

                                        	newLeafNode(otherlv_18, grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_1_0());
                                        
                                    this_ID_19=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1369); 
                                     
                                        newLeafNode(this_ID_19, grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_1_1()); 
                                        
                                    otherlv_20=(Token)match(input,Comma,FOLLOW_Comma_in_ruleDefinition1381); 

                                        	newLeafNode(otherlv_20, grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_1_2());
                                        
                                     
                                            newCompositeNode(grammarAccess.getDefinitionAccess().getColorParserRuleCall_5_2_1_1_3()); 
                                        
                                    pushFollow(FOLLOW_ruleColor_in_ruleDefinition1396);
                                    ruleColor();

                                    state._fsp--;


                                            afterParserOrEnumRuleCall();
                                        
                                    otherlv_22=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_ruleDefinition1408); 

                                        	newLeafNode(otherlv_22, grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_1_4());
                                        
                                    this_ID_23=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1418); 
                                     
                                        newLeafNode(this_ID_23, grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_1_5()); 
                                        

                                    }


                                    }
                                    break;
                                case 3 :
                                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:655:6: this_ID_24= RULE_ID
                                    {
                                    this_ID_24=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1435); 
                                     
                                        newLeafNode(this_ID_24, grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_2()); 
                                        

                                    }
                                    break;

                            }

                            otherlv_25=(Token)match(input,GreaterThanSignGreaterThanSign,FOLLOW_GreaterThanSignGreaterThanSign_in_ruleDefinition1448); 

                                	newLeafNode(otherlv_25, grammarAccess.getDefinitionAccess().getGreaterThanSignGreaterThanSignKeyword_5_2_2());
                                

                            }
                            break;

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:672:1: entryRuleAutoNumber returns [String current=null] : iv_ruleAutoNumber= ruleAutoNumber EOF ;
    public final String entryRuleAutoNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAutoNumber = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:673:1: (iv_ruleAutoNumber= ruleAutoNumber EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:674:2: iv_ruleAutoNumber= ruleAutoNumber EOF
            {
             newCompositeNode(grammarAccess.getAutoNumberRule()); 
            pushFollow(FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber1486);
            iv_ruleAutoNumber=ruleAutoNumber();

            state._fsp--;

             current =iv_ruleAutoNumber.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAutoNumber1497); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:681:1: ruleAutoNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? ) ;
    public final AntlrDatatypeRuleToken ruleAutoNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:685:6: ( (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:686:1: (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:686:1: (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:687:2: kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )?
            {
            kw=(Token)match(input,Autonumber,FOLLOW_Autonumber_in_ruleAutoNumber1535); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getAutoNumberAccess().getAutonumberKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:692:1: (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_INT) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:692:6: this_INT_1= RULE_INT (this_INT_2= RULE_INT )?
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAutoNumber1551); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_0()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:699:1: (this_INT_2= RULE_INT )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==RULE_INT) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:699:6: this_INT_2= RULE_INT
                            {
                            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAutoNumber1572); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:714:1: entryRuleColor returns [String current=null] : iv_ruleColor= ruleColor EOF ;
    public final String entryRuleColor() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleColor = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:715:1: (iv_ruleColor= ruleColor EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:716:2: iv_ruleColor= ruleColor EOF
            {
             newCompositeNode(grammarAccess.getColorRule()); 
            pushFollow(FOLLOW_ruleColor_in_entryRuleColor1621);
            iv_ruleColor=ruleColor();

            state._fsp--;

             current =iv_ruleColor.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColor1632); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:723:1: ruleColor returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= NumberSign (kw= AliceBlue | kw= AntiqueWhite | kw= Aqua | kw= Aquamarine | kw= Azure | kw= Beige | kw= Bisque | kw= Black | kw= BlanchedAlmond | kw= Blue | kw= BlueViolet | kw= Brown | kw= BurlyWood | kw= CadetBlue | kw= Chartreuse | kw= Chocolate | kw= Coral | kw= CornflowerBlue | kw= Cornsilk | kw= Crimson | kw= Cyan | kw= DarkBlue | kw= DarkCyan | kw= DarkGoldenRod | kw= DarkGray | kw= DarkGreen | kw= DarkGrey | kw= DarkKhaki | kw= DarkMagenta | kw= DarkOliveGreen | kw= DarkOrchid | kw= DarkRed | kw= DarkSalmo | kw= DarkSeaGreen | kw= DarkSlateBlue | kw= DarkSlateGray | kw= DarkSlateGrey | kw= DarkTurquoise | kw= DarkViolet | kw= Darkorange | kw= DeepPink | kw= DeepSkyBlue | kw= DimGray | kw= DimGrey | kw= DodgerBlue | kw= FireBrick | kw= FloralWhite | kw= ForestGreen | kw= Fuchsia | kw= Gainsboro | kw= GhostWhite | kw= Gold | kw= GoldenRod | kw= Gray | kw= Green | kw= GreenYellow | kw= Grey | kw= HoneyDew | kw= HotPink | kw= IndianRed | kw= Indigo | kw= Ivory | kw= Khaki | kw= Lavender | kw= LavenderBlush | kw= LawnGreen | kw= LemonChiffon | kw= LightBlue | kw= LightCoral | kw= LightCyan | kw= LightGoldenRodYellow | kw= LightGray | kw= LightGreen | kw= LightGrey | kw= LightPink | kw= LightSalmon | kw= LightSeaGreen | kw= LightSkyBlue | kw= LightSlateGray | kw= LightSlateGrey | kw= LightSteelBlue | kw= LightYellow | kw= Lime | kw= LimeGreen | kw= Linen | kw= Magenta | kw= Maroon | kw= MediumAquaMarine | kw= MediumBlue | kw= MediumOrchid | kw= MediumPurple | kw= MediumSeaGreen | kw= MediumSlateBlue | kw= MediumSpringGreen | kw= MediumTurquoise | kw= MediumVioletRed | kw= MidnightBlue | kw= MintCream | kw= MistyRose | kw= Moccasin | kw= NavajoWhite | kw= Navy | kw= OldLace | kw= Olive | kw= OliveDrab | kw= OrangeRed | kw= Orchid | kw= PaleGoldenRod | kw= PaleGreen | kw= PaleTurquoise | kw= PaleVioletRed | kw= PapayaWhip | kw= PeachPuff | kw= Peru | kw= Pink | kw= Plum | kw= PowderBlue | kw= Purple | kw= Red | kw= RosyBrown | kw= RoyalBlue | kw= SaddleBrown | kw= Salmon | kw= SandyBrown | kw= SeaGreen | kw= Sienna | kw= Silver | kw= SkyBlue | kw= SlateBlue | kw= SlateGray | kw= SlateGrey | kw= Snow | kw= SpringGreen | kw= SteelBlue | kw= Tan | kw= Teal | kw= Thistle | kw= Tomato | kw= Turquoise | kw= Violet | kw= Wheat | kw= White | kw= WhiteSmoke | kw= Yellow | kw= YellowGreen ) ) ;
    public final AntlrDatatypeRuleToken ruleColor() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:727:6: ( (kw= NumberSign (kw= AliceBlue | kw= AntiqueWhite | kw= Aqua | kw= Aquamarine | kw= Azure | kw= Beige | kw= Bisque | kw= Black | kw= BlanchedAlmond | kw= Blue | kw= BlueViolet | kw= Brown | kw= BurlyWood | kw= CadetBlue | kw= Chartreuse | kw= Chocolate | kw= Coral | kw= CornflowerBlue | kw= Cornsilk | kw= Crimson | kw= Cyan | kw= DarkBlue | kw= DarkCyan | kw= DarkGoldenRod | kw= DarkGray | kw= DarkGreen | kw= DarkGrey | kw= DarkKhaki | kw= DarkMagenta | kw= DarkOliveGreen | kw= DarkOrchid | kw= DarkRed | kw= DarkSalmo | kw= DarkSeaGreen | kw= DarkSlateBlue | kw= DarkSlateGray | kw= DarkSlateGrey | kw= DarkTurquoise | kw= DarkViolet | kw= Darkorange | kw= DeepPink | kw= DeepSkyBlue | kw= DimGray | kw= DimGrey | kw= DodgerBlue | kw= FireBrick | kw= FloralWhite | kw= ForestGreen | kw= Fuchsia | kw= Gainsboro | kw= GhostWhite | kw= Gold | kw= GoldenRod | kw= Gray | kw= Green | kw= GreenYellow | kw= Grey | kw= HoneyDew | kw= HotPink | kw= IndianRed | kw= Indigo | kw= Ivory | kw= Khaki | kw= Lavender | kw= LavenderBlush | kw= LawnGreen | kw= LemonChiffon | kw= LightBlue | kw= LightCoral | kw= LightCyan | kw= LightGoldenRodYellow | kw= LightGray | kw= LightGreen | kw= LightGrey | kw= LightPink | kw= LightSalmon | kw= LightSeaGreen | kw= LightSkyBlue | kw= LightSlateGray | kw= LightSlateGrey | kw= LightSteelBlue | kw= LightYellow | kw= Lime | kw= LimeGreen | kw= Linen | kw= Magenta | kw= Maroon | kw= MediumAquaMarine | kw= MediumBlue | kw= MediumOrchid | kw= MediumPurple | kw= MediumSeaGreen | kw= MediumSlateBlue | kw= MediumSpringGreen | kw= MediumTurquoise | kw= MediumVioletRed | kw= MidnightBlue | kw= MintCream | kw= MistyRose | kw= Moccasin | kw= NavajoWhite | kw= Navy | kw= OldLace | kw= Olive | kw= OliveDrab | kw= OrangeRed | kw= Orchid | kw= PaleGoldenRod | kw= PaleGreen | kw= PaleTurquoise | kw= PaleVioletRed | kw= PapayaWhip | kw= PeachPuff | kw= Peru | kw= Pink | kw= Plum | kw= PowderBlue | kw= Purple | kw= Red | kw= RosyBrown | kw= RoyalBlue | kw= SaddleBrown | kw= Salmon | kw= SandyBrown | kw= SeaGreen | kw= Sienna | kw= Silver | kw= SkyBlue | kw= SlateBlue | kw= SlateGray | kw= SlateGrey | kw= Snow | kw= SpringGreen | kw= SteelBlue | kw= Tan | kw= Teal | kw= Thistle | kw= Tomato | kw= Turquoise | kw= Violet | kw= Wheat | kw= White | kw= WhiteSmoke | kw= Yellow | kw= YellowGreen ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:728:1: (kw= NumberSign (kw= AliceBlue | kw= AntiqueWhite | kw= Aqua | kw= Aquamarine | kw= Azure | kw= Beige | kw= Bisque | kw= Black | kw= BlanchedAlmond | kw= Blue | kw= BlueViolet | kw= Brown | kw= BurlyWood | kw= CadetBlue | kw= Chartreuse | kw= Chocolate | kw= Coral | kw= CornflowerBlue | kw= Cornsilk | kw= Crimson | kw= Cyan | kw= DarkBlue | kw= DarkCyan | kw= DarkGoldenRod | kw= DarkGray | kw= DarkGreen | kw= DarkGrey | kw= DarkKhaki | kw= DarkMagenta | kw= DarkOliveGreen | kw= DarkOrchid | kw= DarkRed | kw= DarkSalmo | kw= DarkSeaGreen | kw= DarkSlateBlue | kw= DarkSlateGray | kw= DarkSlateGrey | kw= DarkTurquoise | kw= DarkViolet | kw= Darkorange | kw= DeepPink | kw= DeepSkyBlue | kw= DimGray | kw= DimGrey | kw= DodgerBlue | kw= FireBrick | kw= FloralWhite | kw= ForestGreen | kw= Fuchsia | kw= Gainsboro | kw= GhostWhite | kw= Gold | kw= GoldenRod | kw= Gray | kw= Green | kw= GreenYellow | kw= Grey | kw= HoneyDew | kw= HotPink | kw= IndianRed | kw= Indigo | kw= Ivory | kw= Khaki | kw= Lavender | kw= LavenderBlush | kw= LawnGreen | kw= LemonChiffon | kw= LightBlue | kw= LightCoral | kw= LightCyan | kw= LightGoldenRodYellow | kw= LightGray | kw= LightGreen | kw= LightGrey | kw= LightPink | kw= LightSalmon | kw= LightSeaGreen | kw= LightSkyBlue | kw= LightSlateGray | kw= LightSlateGrey | kw= LightSteelBlue | kw= LightYellow | kw= Lime | kw= LimeGreen | kw= Linen | kw= Magenta | kw= Maroon | kw= MediumAquaMarine | kw= MediumBlue | kw= MediumOrchid | kw= MediumPurple | kw= MediumSeaGreen | kw= MediumSlateBlue | kw= MediumSpringGreen | kw= MediumTurquoise | kw= MediumVioletRed | kw= MidnightBlue | kw= MintCream | kw= MistyRose | kw= Moccasin | kw= NavajoWhite | kw= Navy | kw= OldLace | kw= Olive | kw= OliveDrab | kw= OrangeRed | kw= Orchid | kw= PaleGoldenRod | kw= PaleGreen | kw= PaleTurquoise | kw= PaleVioletRed | kw= PapayaWhip | kw= PeachPuff | kw= Peru | kw= Pink | kw= Plum | kw= PowderBlue | kw= Purple | kw= Red | kw= RosyBrown | kw= RoyalBlue | kw= SaddleBrown | kw= Salmon | kw= SandyBrown | kw= SeaGreen | kw= Sienna | kw= Silver | kw= SkyBlue | kw= SlateBlue | kw= SlateGray | kw= SlateGrey | kw= Snow | kw= SpringGreen | kw= SteelBlue | kw= Tan | kw= Teal | kw= Thistle | kw= Tomato | kw= Turquoise | kw= Violet | kw= Wheat | kw= White | kw= WhiteSmoke | kw= Yellow | kw= YellowGreen ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:728:1: (kw= NumberSign (kw= AliceBlue | kw= AntiqueWhite | kw= Aqua | kw= Aquamarine | kw= Azure | kw= Beige | kw= Bisque | kw= Black | kw= BlanchedAlmond | kw= Blue | kw= BlueViolet | kw= Brown | kw= BurlyWood | kw= CadetBlue | kw= Chartreuse | kw= Chocolate | kw= Coral | kw= CornflowerBlue | kw= Cornsilk | kw= Crimson | kw= Cyan | kw= DarkBlue | kw= DarkCyan | kw= DarkGoldenRod | kw= DarkGray | kw= DarkGreen | kw= DarkGrey | kw= DarkKhaki | kw= DarkMagenta | kw= DarkOliveGreen | kw= DarkOrchid | kw= DarkRed | kw= DarkSalmo | kw= DarkSeaGreen | kw= DarkSlateBlue | kw= DarkSlateGray | kw= DarkSlateGrey | kw= DarkTurquoise | kw= DarkViolet | kw= Darkorange | kw= DeepPink | kw= DeepSkyBlue | kw= DimGray | kw= DimGrey | kw= DodgerBlue | kw= FireBrick | kw= FloralWhite | kw= ForestGreen | kw= Fuchsia | kw= Gainsboro | kw= GhostWhite | kw= Gold | kw= GoldenRod | kw= Gray | kw= Green | kw= GreenYellow | kw= Grey | kw= HoneyDew | kw= HotPink | kw= IndianRed | kw= Indigo | kw= Ivory | kw= Khaki | kw= Lavender | kw= LavenderBlush | kw= LawnGreen | kw= LemonChiffon | kw= LightBlue | kw= LightCoral | kw= LightCyan | kw= LightGoldenRodYellow | kw= LightGray | kw= LightGreen | kw= LightGrey | kw= LightPink | kw= LightSalmon | kw= LightSeaGreen | kw= LightSkyBlue | kw= LightSlateGray | kw= LightSlateGrey | kw= LightSteelBlue | kw= LightYellow | kw= Lime | kw= LimeGreen | kw= Linen | kw= Magenta | kw= Maroon | kw= MediumAquaMarine | kw= MediumBlue | kw= MediumOrchid | kw= MediumPurple | kw= MediumSeaGreen | kw= MediumSlateBlue | kw= MediumSpringGreen | kw= MediumTurquoise | kw= MediumVioletRed | kw= MidnightBlue | kw= MintCream | kw= MistyRose | kw= Moccasin | kw= NavajoWhite | kw= Navy | kw= OldLace | kw= Olive | kw= OliveDrab | kw= OrangeRed | kw= Orchid | kw= PaleGoldenRod | kw= PaleGreen | kw= PaleTurquoise | kw= PaleVioletRed | kw= PapayaWhip | kw= PeachPuff | kw= Peru | kw= Pink | kw= Plum | kw= PowderBlue | kw= Purple | kw= Red | kw= RosyBrown | kw= RoyalBlue | kw= SaddleBrown | kw= Salmon | kw= SandyBrown | kw= SeaGreen | kw= Sienna | kw= Silver | kw= SkyBlue | kw= SlateBlue | kw= SlateGray | kw= SlateGrey | kw= Snow | kw= SpringGreen | kw= SteelBlue | kw= Tan | kw= Teal | kw= Thistle | kw= Tomato | kw= Turquoise | kw= Violet | kw= Wheat | kw= White | kw= WhiteSmoke | kw= Yellow | kw= YellowGreen ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:729:2: kw= NumberSign (kw= AliceBlue | kw= AntiqueWhite | kw= Aqua | kw= Aquamarine | kw= Azure | kw= Beige | kw= Bisque | kw= Black | kw= BlanchedAlmond | kw= Blue | kw= BlueViolet | kw= Brown | kw= BurlyWood | kw= CadetBlue | kw= Chartreuse | kw= Chocolate | kw= Coral | kw= CornflowerBlue | kw= Cornsilk | kw= Crimson | kw= Cyan | kw= DarkBlue | kw= DarkCyan | kw= DarkGoldenRod | kw= DarkGray | kw= DarkGreen | kw= DarkGrey | kw= DarkKhaki | kw= DarkMagenta | kw= DarkOliveGreen | kw= DarkOrchid | kw= DarkRed | kw= DarkSalmo | kw= DarkSeaGreen | kw= DarkSlateBlue | kw= DarkSlateGray | kw= DarkSlateGrey | kw= DarkTurquoise | kw= DarkViolet | kw= Darkorange | kw= DeepPink | kw= DeepSkyBlue | kw= DimGray | kw= DimGrey | kw= DodgerBlue | kw= FireBrick | kw= FloralWhite | kw= ForestGreen | kw= Fuchsia | kw= Gainsboro | kw= GhostWhite | kw= Gold | kw= GoldenRod | kw= Gray | kw= Green | kw= GreenYellow | kw= Grey | kw= HoneyDew | kw= HotPink | kw= IndianRed | kw= Indigo | kw= Ivory | kw= Khaki | kw= Lavender | kw= LavenderBlush | kw= LawnGreen | kw= LemonChiffon | kw= LightBlue | kw= LightCoral | kw= LightCyan | kw= LightGoldenRodYellow | kw= LightGray | kw= LightGreen | kw= LightGrey | kw= LightPink | kw= LightSalmon | kw= LightSeaGreen | kw= LightSkyBlue | kw= LightSlateGray | kw= LightSlateGrey | kw= LightSteelBlue | kw= LightYellow | kw= Lime | kw= LimeGreen | kw= Linen | kw= Magenta | kw= Maroon | kw= MediumAquaMarine | kw= MediumBlue | kw= MediumOrchid | kw= MediumPurple | kw= MediumSeaGreen | kw= MediumSlateBlue | kw= MediumSpringGreen | kw= MediumTurquoise | kw= MediumVioletRed | kw= MidnightBlue | kw= MintCream | kw= MistyRose | kw= Moccasin | kw= NavajoWhite | kw= Navy | kw= OldLace | kw= Olive | kw= OliveDrab | kw= OrangeRed | kw= Orchid | kw= PaleGoldenRod | kw= PaleGreen | kw= PaleTurquoise | kw= PaleVioletRed | kw= PapayaWhip | kw= PeachPuff | kw= Peru | kw= Pink | kw= Plum | kw= PowderBlue | kw= Purple | kw= Red | kw= RosyBrown | kw= RoyalBlue | kw= SaddleBrown | kw= Salmon | kw= SandyBrown | kw= SeaGreen | kw= Sienna | kw= Silver | kw= SkyBlue | kw= SlateBlue | kw= SlateGray | kw= SlateGrey | kw= Snow | kw= SpringGreen | kw= SteelBlue | kw= Tan | kw= Teal | kw= Thistle | kw= Tomato | kw= Turquoise | kw= Violet | kw= Wheat | kw= White | kw= WhiteSmoke | kw= Yellow | kw= YellowGreen )
            {
            kw=(Token)match(input,NumberSign,FOLLOW_NumberSign_in_ruleColor1670); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getColorAccess().getNumberSignKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:734:1: (kw= AliceBlue | kw= AntiqueWhite | kw= Aqua | kw= Aquamarine | kw= Azure | kw= Beige | kw= Bisque | kw= Black | kw= BlanchedAlmond | kw= Blue | kw= BlueViolet | kw= Brown | kw= BurlyWood | kw= CadetBlue | kw= Chartreuse | kw= Chocolate | kw= Coral | kw= CornflowerBlue | kw= Cornsilk | kw= Crimson | kw= Cyan | kw= DarkBlue | kw= DarkCyan | kw= DarkGoldenRod | kw= DarkGray | kw= DarkGreen | kw= DarkGrey | kw= DarkKhaki | kw= DarkMagenta | kw= DarkOliveGreen | kw= DarkOrchid | kw= DarkRed | kw= DarkSalmo | kw= DarkSeaGreen | kw= DarkSlateBlue | kw= DarkSlateGray | kw= DarkSlateGrey | kw= DarkTurquoise | kw= DarkViolet | kw= Darkorange | kw= DeepPink | kw= DeepSkyBlue | kw= DimGray | kw= DimGrey | kw= DodgerBlue | kw= FireBrick | kw= FloralWhite | kw= ForestGreen | kw= Fuchsia | kw= Gainsboro | kw= GhostWhite | kw= Gold | kw= GoldenRod | kw= Gray | kw= Green | kw= GreenYellow | kw= Grey | kw= HoneyDew | kw= HotPink | kw= IndianRed | kw= Indigo | kw= Ivory | kw= Khaki | kw= Lavender | kw= LavenderBlush | kw= LawnGreen | kw= LemonChiffon | kw= LightBlue | kw= LightCoral | kw= LightCyan | kw= LightGoldenRodYellow | kw= LightGray | kw= LightGreen | kw= LightGrey | kw= LightPink | kw= LightSalmon | kw= LightSeaGreen | kw= LightSkyBlue | kw= LightSlateGray | kw= LightSlateGrey | kw= LightSteelBlue | kw= LightYellow | kw= Lime | kw= LimeGreen | kw= Linen | kw= Magenta | kw= Maroon | kw= MediumAquaMarine | kw= MediumBlue | kw= MediumOrchid | kw= MediumPurple | kw= MediumSeaGreen | kw= MediumSlateBlue | kw= MediumSpringGreen | kw= MediumTurquoise | kw= MediumVioletRed | kw= MidnightBlue | kw= MintCream | kw= MistyRose | kw= Moccasin | kw= NavajoWhite | kw= Navy | kw= OldLace | kw= Olive | kw= OliveDrab | kw= OrangeRed | kw= Orchid | kw= PaleGoldenRod | kw= PaleGreen | kw= PaleTurquoise | kw= PaleVioletRed | kw= PapayaWhip | kw= PeachPuff | kw= Peru | kw= Pink | kw= Plum | kw= PowderBlue | kw= Purple | kw= Red | kw= RosyBrown | kw= RoyalBlue | kw= SaddleBrown | kw= Salmon | kw= SandyBrown | kw= SeaGreen | kw= Sienna | kw= Silver | kw= SkyBlue | kw= SlateBlue | kw= SlateGray | kw= SlateGrey | kw= Snow | kw= SpringGreen | kw= SteelBlue | kw= Tan | kw= Teal | kw= Thistle | kw= Tomato | kw= Turquoise | kw= Violet | kw= Wheat | kw= White | kw= WhiteSmoke | kw= Yellow | kw= YellowGreen )
            int alt13=145;
            switch ( input.LA(1) ) {
            case AliceBlue:
                {
                alt13=1;
                }
                break;
            case AntiqueWhite:
                {
                alt13=2;
                }
                break;
            case Aqua:
                {
                alt13=3;
                }
                break;
            case Aquamarine:
                {
                alt13=4;
                }
                break;
            case Azure:
                {
                alt13=5;
                }
                break;
            case Beige:
                {
                alt13=6;
                }
                break;
            case Bisque:
                {
                alt13=7;
                }
                break;
            case Black:
                {
                alt13=8;
                }
                break;
            case BlanchedAlmond:
                {
                alt13=9;
                }
                break;
            case Blue:
                {
                alt13=10;
                }
                break;
            case BlueViolet:
                {
                alt13=11;
                }
                break;
            case Brown:
                {
                alt13=12;
                }
                break;
            case BurlyWood:
                {
                alt13=13;
                }
                break;
            case CadetBlue:
                {
                alt13=14;
                }
                break;
            case Chartreuse:
                {
                alt13=15;
                }
                break;
            case Chocolate:
                {
                alt13=16;
                }
                break;
            case Coral:
                {
                alt13=17;
                }
                break;
            case CornflowerBlue:
                {
                alt13=18;
                }
                break;
            case Cornsilk:
                {
                alt13=19;
                }
                break;
            case Crimson:
                {
                alt13=20;
                }
                break;
            case Cyan:
                {
                alt13=21;
                }
                break;
            case DarkBlue:
                {
                alt13=22;
                }
                break;
            case DarkCyan:
                {
                alt13=23;
                }
                break;
            case DarkGoldenRod:
                {
                alt13=24;
                }
                break;
            case DarkGray:
                {
                alt13=25;
                }
                break;
            case DarkGreen:
                {
                alt13=26;
                }
                break;
            case DarkGrey:
                {
                alt13=27;
                }
                break;
            case DarkKhaki:
                {
                alt13=28;
                }
                break;
            case DarkMagenta:
                {
                alt13=29;
                }
                break;
            case DarkOliveGreen:
                {
                alt13=30;
                }
                break;
            case DarkOrchid:
                {
                alt13=31;
                }
                break;
            case DarkRed:
                {
                alt13=32;
                }
                break;
            case DarkSalmo:
                {
                alt13=33;
                }
                break;
            case DarkSeaGreen:
                {
                alt13=34;
                }
                break;
            case DarkSlateBlue:
                {
                alt13=35;
                }
                break;
            case DarkSlateGray:
                {
                alt13=36;
                }
                break;
            case DarkSlateGrey:
                {
                alt13=37;
                }
                break;
            case DarkTurquoise:
                {
                alt13=38;
                }
                break;
            case DarkViolet:
                {
                alt13=39;
                }
                break;
            case Darkorange:
                {
                alt13=40;
                }
                break;
            case DeepPink:
                {
                alt13=41;
                }
                break;
            case DeepSkyBlue:
                {
                alt13=42;
                }
                break;
            case DimGray:
                {
                alt13=43;
                }
                break;
            case DimGrey:
                {
                alt13=44;
                }
                break;
            case DodgerBlue:
                {
                alt13=45;
                }
                break;
            case FireBrick:
                {
                alt13=46;
                }
                break;
            case FloralWhite:
                {
                alt13=47;
                }
                break;
            case ForestGreen:
                {
                alt13=48;
                }
                break;
            case Fuchsia:
                {
                alt13=49;
                }
                break;
            case Gainsboro:
                {
                alt13=50;
                }
                break;
            case GhostWhite:
                {
                alt13=51;
                }
                break;
            case Gold:
                {
                alt13=52;
                }
                break;
            case GoldenRod:
                {
                alt13=53;
                }
                break;
            case Gray:
                {
                alt13=54;
                }
                break;
            case Green:
                {
                alt13=55;
                }
                break;
            case GreenYellow:
                {
                alt13=56;
                }
                break;
            case Grey:
                {
                alt13=57;
                }
                break;
            case HoneyDew:
                {
                alt13=58;
                }
                break;
            case HotPink:
                {
                alt13=59;
                }
                break;
            case IndianRed:
                {
                alt13=60;
                }
                break;
            case Indigo:
                {
                alt13=61;
                }
                break;
            case Ivory:
                {
                alt13=62;
                }
                break;
            case Khaki:
                {
                alt13=63;
                }
                break;
            case Lavender:
                {
                alt13=64;
                }
                break;
            case LavenderBlush:
                {
                alt13=65;
                }
                break;
            case LawnGreen:
                {
                alt13=66;
                }
                break;
            case LemonChiffon:
                {
                alt13=67;
                }
                break;
            case LightBlue:
                {
                alt13=68;
                }
                break;
            case LightCoral:
                {
                alt13=69;
                }
                break;
            case LightCyan:
                {
                alt13=70;
                }
                break;
            case LightGoldenRodYellow:
                {
                alt13=71;
                }
                break;
            case LightGray:
                {
                alt13=72;
                }
                break;
            case LightGreen:
                {
                alt13=73;
                }
                break;
            case LightGrey:
                {
                alt13=74;
                }
                break;
            case LightPink:
                {
                alt13=75;
                }
                break;
            case LightSalmon:
                {
                alt13=76;
                }
                break;
            case LightSeaGreen:
                {
                alt13=77;
                }
                break;
            case LightSkyBlue:
                {
                alt13=78;
                }
                break;
            case LightSlateGray:
                {
                alt13=79;
                }
                break;
            case LightSlateGrey:
                {
                alt13=80;
                }
                break;
            case LightSteelBlue:
                {
                alt13=81;
                }
                break;
            case LightYellow:
                {
                alt13=82;
                }
                break;
            case Lime:
                {
                alt13=83;
                }
                break;
            case LimeGreen:
                {
                alt13=84;
                }
                break;
            case Linen:
                {
                alt13=85;
                }
                break;
            case Magenta:
                {
                alt13=86;
                }
                break;
            case Maroon:
                {
                alt13=87;
                }
                break;
            case MediumAquaMarine:
                {
                alt13=88;
                }
                break;
            case MediumBlue:
                {
                alt13=89;
                }
                break;
            case MediumOrchid:
                {
                alt13=90;
                }
                break;
            case MediumPurple:
                {
                alt13=91;
                }
                break;
            case MediumSeaGreen:
                {
                alt13=92;
                }
                break;
            case MediumSlateBlue:
                {
                alt13=93;
                }
                break;
            case MediumSpringGreen:
                {
                alt13=94;
                }
                break;
            case MediumTurquoise:
                {
                alt13=95;
                }
                break;
            case MediumVioletRed:
                {
                alt13=96;
                }
                break;
            case MidnightBlue:
                {
                alt13=97;
                }
                break;
            case MintCream:
                {
                alt13=98;
                }
                break;
            case MistyRose:
                {
                alt13=99;
                }
                break;
            case Moccasin:
                {
                alt13=100;
                }
                break;
            case NavajoWhite:
                {
                alt13=101;
                }
                break;
            case Navy:
                {
                alt13=102;
                }
                break;
            case OldLace:
                {
                alt13=103;
                }
                break;
            case Olive:
                {
                alt13=104;
                }
                break;
            case OliveDrab:
                {
                alt13=105;
                }
                break;
            case OrangeRed:
                {
                alt13=106;
                }
                break;
            case Orchid:
                {
                alt13=107;
                }
                break;
            case PaleGoldenRod:
                {
                alt13=108;
                }
                break;
            case PaleGreen:
                {
                alt13=109;
                }
                break;
            case PaleTurquoise:
                {
                alt13=110;
                }
                break;
            case PaleVioletRed:
                {
                alt13=111;
                }
                break;
            case PapayaWhip:
                {
                alt13=112;
                }
                break;
            case PeachPuff:
                {
                alt13=113;
                }
                break;
            case Peru:
                {
                alt13=114;
                }
                break;
            case Pink:
                {
                alt13=115;
                }
                break;
            case Plum:
                {
                alt13=116;
                }
                break;
            case PowderBlue:
                {
                alt13=117;
                }
                break;
            case Purple:
                {
                alt13=118;
                }
                break;
            case Red:
                {
                alt13=119;
                }
                break;
            case RosyBrown:
                {
                alt13=120;
                }
                break;
            case RoyalBlue:
                {
                alt13=121;
                }
                break;
            case SaddleBrown:
                {
                alt13=122;
                }
                break;
            case Salmon:
                {
                alt13=123;
                }
                break;
            case SandyBrown:
                {
                alt13=124;
                }
                break;
            case SeaGreen:
                {
                alt13=125;
                }
                break;
            case Sienna:
                {
                alt13=126;
                }
                break;
            case Silver:
                {
                alt13=127;
                }
                break;
            case SkyBlue:
                {
                alt13=128;
                }
                break;
            case SlateBlue:
                {
                alt13=129;
                }
                break;
            case SlateGray:
                {
                alt13=130;
                }
                break;
            case SlateGrey:
                {
                alt13=131;
                }
                break;
            case Snow:
                {
                alt13=132;
                }
                break;
            case SpringGreen:
                {
                alt13=133;
                }
                break;
            case SteelBlue:
                {
                alt13=134;
                }
                break;
            case Tan:
                {
                alt13=135;
                }
                break;
            case Teal:
                {
                alt13=136;
                }
                break;
            case Thistle:
                {
                alt13=137;
                }
                break;
            case Tomato:
                {
                alt13=138;
                }
                break;
            case Turquoise:
                {
                alt13=139;
                }
                break;
            case Violet:
                {
                alt13=140;
                }
                break;
            case Wheat:
                {
                alt13=141;
                }
                break;
            case White:
                {
                alt13=142;
                }
                break;
            case WhiteSmoke:
                {
                alt13=143;
                }
                break;
            case Yellow:
                {
                alt13=144;
                }
                break;
            case YellowGreen:
                {
                alt13=145;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:735:2: kw= AliceBlue
                    {
                    kw=(Token)match(input,AliceBlue,FOLLOW_AliceBlue_in_ruleColor1684); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAliceBlueKeyword_1_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:742:2: kw= AntiqueWhite
                    {
                    kw=(Token)match(input,AntiqueWhite,FOLLOW_AntiqueWhite_in_ruleColor1703); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:749:2: kw= Aqua
                    {
                    kw=(Token)match(input,Aqua,FOLLOW_Aqua_in_ruleColor1722); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAquaKeyword_1_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:756:2: kw= Aquamarine
                    {
                    kw=(Token)match(input,Aquamarine,FOLLOW_Aquamarine_in_ruleColor1741); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAquamarineKeyword_1_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:763:2: kw= Azure
                    {
                    kw=(Token)match(input,Azure,FOLLOW_Azure_in_ruleColor1760); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAzureKeyword_1_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:770:2: kw= Beige
                    {
                    kw=(Token)match(input,Beige,FOLLOW_Beige_in_ruleColor1779); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBeigeKeyword_1_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:777:2: kw= Bisque
                    {
                    kw=(Token)match(input,Bisque,FOLLOW_Bisque_in_ruleColor1798); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBisqueKeyword_1_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:784:2: kw= Black
                    {
                    kw=(Token)match(input,Black,FOLLOW_Black_in_ruleColor1817); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlackKeyword_1_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:791:2: kw= BlanchedAlmond
                    {
                    kw=(Token)match(input,BlanchedAlmond,FOLLOW_BlanchedAlmond_in_ruleColor1836); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlanchedAlmondKeyword_1_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:798:2: kw= Blue
                    {
                    kw=(Token)match(input,Blue,FOLLOW_Blue_in_ruleColor1855); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlueKeyword_1_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:805:2: kw= BlueViolet
                    {
                    kw=(Token)match(input,BlueViolet,FOLLOW_BlueViolet_in_ruleColor1874); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlueVioletKeyword_1_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:812:2: kw= Brown
                    {
                    kw=(Token)match(input,Brown,FOLLOW_Brown_in_ruleColor1893); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBrownKeyword_1_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:819:2: kw= BurlyWood
                    {
                    kw=(Token)match(input,BurlyWood,FOLLOW_BurlyWood_in_ruleColor1912); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBurlyWoodKeyword_1_12()); 
                        

                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:826:2: kw= CadetBlue
                    {
                    kw=(Token)match(input,CadetBlue,FOLLOW_CadetBlue_in_ruleColor1931); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCadetBlueKeyword_1_13()); 
                        

                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:833:2: kw= Chartreuse
                    {
                    kw=(Token)match(input,Chartreuse,FOLLOW_Chartreuse_in_ruleColor1950); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getChartreuseKeyword_1_14()); 
                        

                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:840:2: kw= Chocolate
                    {
                    kw=(Token)match(input,Chocolate,FOLLOW_Chocolate_in_ruleColor1969); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getChocolateKeyword_1_15()); 
                        

                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:847:2: kw= Coral
                    {
                    kw=(Token)match(input,Coral,FOLLOW_Coral_in_ruleColor1988); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCoralKeyword_1_16()); 
                        

                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:854:2: kw= CornflowerBlue
                    {
                    kw=(Token)match(input,CornflowerBlue,FOLLOW_CornflowerBlue_in_ruleColor2007); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCornflowerBlueKeyword_1_17()); 
                        

                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:861:2: kw= Cornsilk
                    {
                    kw=(Token)match(input,Cornsilk,FOLLOW_Cornsilk_in_ruleColor2026); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCornsilkKeyword_1_18()); 
                        

                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:868:2: kw= Crimson
                    {
                    kw=(Token)match(input,Crimson,FOLLOW_Crimson_in_ruleColor2045); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCrimsonKeyword_1_19()); 
                        

                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:875:2: kw= Cyan
                    {
                    kw=(Token)match(input,Cyan,FOLLOW_Cyan_in_ruleColor2064); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCyanKeyword_1_20()); 
                        

                    }
                    break;
                case 22 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:882:2: kw= DarkBlue
                    {
                    kw=(Token)match(input,DarkBlue,FOLLOW_DarkBlue_in_ruleColor2083); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkBlueKeyword_1_21()); 
                        

                    }
                    break;
                case 23 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:889:2: kw= DarkCyan
                    {
                    kw=(Token)match(input,DarkCyan,FOLLOW_DarkCyan_in_ruleColor2102); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkCyanKeyword_1_22()); 
                        

                    }
                    break;
                case 24 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:896:2: kw= DarkGoldenRod
                    {
                    kw=(Token)match(input,DarkGoldenRod,FOLLOW_DarkGoldenRod_in_ruleColor2121); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGoldenRodKeyword_1_23()); 
                        

                    }
                    break;
                case 25 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:903:2: kw= DarkGray
                    {
                    kw=(Token)match(input,DarkGray,FOLLOW_DarkGray_in_ruleColor2140); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGrayKeyword_1_24()); 
                        

                    }
                    break;
                case 26 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:910:2: kw= DarkGreen
                    {
                    kw=(Token)match(input,DarkGreen,FOLLOW_DarkGreen_in_ruleColor2159); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGreenKeyword_1_25()); 
                        

                    }
                    break;
                case 27 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:917:2: kw= DarkGrey
                    {
                    kw=(Token)match(input,DarkGrey,FOLLOW_DarkGrey_in_ruleColor2178); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGreyKeyword_1_26()); 
                        

                    }
                    break;
                case 28 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:924:2: kw= DarkKhaki
                    {
                    kw=(Token)match(input,DarkKhaki,FOLLOW_DarkKhaki_in_ruleColor2197); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkKhakiKeyword_1_27()); 
                        

                    }
                    break;
                case 29 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:931:2: kw= DarkMagenta
                    {
                    kw=(Token)match(input,DarkMagenta,FOLLOW_DarkMagenta_in_ruleColor2216); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkMagentaKeyword_1_28()); 
                        

                    }
                    break;
                case 30 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:938:2: kw= DarkOliveGreen
                    {
                    kw=(Token)match(input,DarkOliveGreen,FOLLOW_DarkOliveGreen_in_ruleColor2235); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkOliveGreenKeyword_1_29()); 
                        

                    }
                    break;
                case 31 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:945:2: kw= DarkOrchid
                    {
                    kw=(Token)match(input,DarkOrchid,FOLLOW_DarkOrchid_in_ruleColor2254); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkOrchidKeyword_1_30()); 
                        

                    }
                    break;
                case 32 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:952:2: kw= DarkRed
                    {
                    kw=(Token)match(input,DarkRed,FOLLOW_DarkRed_in_ruleColor2273); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkRedKeyword_1_31()); 
                        

                    }
                    break;
                case 33 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:959:2: kw= DarkSalmo
                    {
                    kw=(Token)match(input,DarkSalmo,FOLLOW_DarkSalmo_in_ruleColor2292); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSalmoKeyword_1_32()); 
                        

                    }
                    break;
                case 34 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:966:2: kw= DarkSeaGreen
                    {
                    kw=(Token)match(input,DarkSeaGreen,FOLLOW_DarkSeaGreen_in_ruleColor2311); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSeaGreenKeyword_1_33()); 
                        

                    }
                    break;
                case 35 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:973:2: kw= DarkSlateBlue
                    {
                    kw=(Token)match(input,DarkSlateBlue,FOLLOW_DarkSlateBlue_in_ruleColor2330); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSlateBlueKeyword_1_34()); 
                        

                    }
                    break;
                case 36 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:980:2: kw= DarkSlateGray
                    {
                    kw=(Token)match(input,DarkSlateGray,FOLLOW_DarkSlateGray_in_ruleColor2349); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSlateGrayKeyword_1_35()); 
                        

                    }
                    break;
                case 37 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:987:2: kw= DarkSlateGrey
                    {
                    kw=(Token)match(input,DarkSlateGrey,FOLLOW_DarkSlateGrey_in_ruleColor2368); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSlateGreyKeyword_1_36()); 
                        

                    }
                    break;
                case 38 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:994:2: kw= DarkTurquoise
                    {
                    kw=(Token)match(input,DarkTurquoise,FOLLOW_DarkTurquoise_in_ruleColor2387); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkTurquoiseKeyword_1_37()); 
                        

                    }
                    break;
                case 39 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1001:2: kw= DarkViolet
                    {
                    kw=(Token)match(input,DarkViolet,FOLLOW_DarkViolet_in_ruleColor2406); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkVioletKeyword_1_38()); 
                        

                    }
                    break;
                case 40 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1008:2: kw= Darkorange
                    {
                    kw=(Token)match(input,Darkorange,FOLLOW_Darkorange_in_ruleColor2425); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkorangeKeyword_1_39()); 
                        

                    }
                    break;
                case 41 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1015:2: kw= DeepPink
                    {
                    kw=(Token)match(input,DeepPink,FOLLOW_DeepPink_in_ruleColor2444); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDeepPinkKeyword_1_40()); 
                        

                    }
                    break;
                case 42 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1022:2: kw= DeepSkyBlue
                    {
                    kw=(Token)match(input,DeepSkyBlue,FOLLOW_DeepSkyBlue_in_ruleColor2463); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDeepSkyBlueKeyword_1_41()); 
                        

                    }
                    break;
                case 43 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1029:2: kw= DimGray
                    {
                    kw=(Token)match(input,DimGray,FOLLOW_DimGray_in_ruleColor2482); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDimGrayKeyword_1_42()); 
                        

                    }
                    break;
                case 44 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1036:2: kw= DimGrey
                    {
                    kw=(Token)match(input,DimGrey,FOLLOW_DimGrey_in_ruleColor2501); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDimGreyKeyword_1_43()); 
                        

                    }
                    break;
                case 45 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1043:2: kw= DodgerBlue
                    {
                    kw=(Token)match(input,DodgerBlue,FOLLOW_DodgerBlue_in_ruleColor2520); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDodgerBlueKeyword_1_44()); 
                        

                    }
                    break;
                case 46 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1050:2: kw= FireBrick
                    {
                    kw=(Token)match(input,FireBrick,FOLLOW_FireBrick_in_ruleColor2539); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getFireBrickKeyword_1_45()); 
                        

                    }
                    break;
                case 47 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1057:2: kw= FloralWhite
                    {
                    kw=(Token)match(input,FloralWhite,FOLLOW_FloralWhite_in_ruleColor2558); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getFloralWhiteKeyword_1_46()); 
                        

                    }
                    break;
                case 48 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1064:2: kw= ForestGreen
                    {
                    kw=(Token)match(input,ForestGreen,FOLLOW_ForestGreen_in_ruleColor2577); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getForestGreenKeyword_1_47()); 
                        

                    }
                    break;
                case 49 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1071:2: kw= Fuchsia
                    {
                    kw=(Token)match(input,Fuchsia,FOLLOW_Fuchsia_in_ruleColor2596); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getFuchsiaKeyword_1_48()); 
                        

                    }
                    break;
                case 50 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1078:2: kw= Gainsboro
                    {
                    kw=(Token)match(input,Gainsboro,FOLLOW_Gainsboro_in_ruleColor2615); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGainsboroKeyword_1_49()); 
                        

                    }
                    break;
                case 51 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1085:2: kw= GhostWhite
                    {
                    kw=(Token)match(input,GhostWhite,FOLLOW_GhostWhite_in_ruleColor2634); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGhostWhiteKeyword_1_50()); 
                        

                    }
                    break;
                case 52 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1092:2: kw= Gold
                    {
                    kw=(Token)match(input,Gold,FOLLOW_Gold_in_ruleColor2653); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGoldKeyword_1_51()); 
                        

                    }
                    break;
                case 53 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1099:2: kw= GoldenRod
                    {
                    kw=(Token)match(input,GoldenRod,FOLLOW_GoldenRod_in_ruleColor2672); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGoldenRodKeyword_1_52()); 
                        

                    }
                    break;
                case 54 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1106:2: kw= Gray
                    {
                    kw=(Token)match(input,Gray,FOLLOW_Gray_in_ruleColor2691); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGrayKeyword_1_53()); 
                        

                    }
                    break;
                case 55 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1113:2: kw= Green
                    {
                    kw=(Token)match(input,Green,FOLLOW_Green_in_ruleColor2710); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGreenKeyword_1_54()); 
                        

                    }
                    break;
                case 56 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1120:2: kw= GreenYellow
                    {
                    kw=(Token)match(input,GreenYellow,FOLLOW_GreenYellow_in_ruleColor2729); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGreenYellowKeyword_1_55()); 
                        

                    }
                    break;
                case 57 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1127:2: kw= Grey
                    {
                    kw=(Token)match(input,Grey,FOLLOW_Grey_in_ruleColor2748); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGreyKeyword_1_56()); 
                        

                    }
                    break;
                case 58 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1134:2: kw= HoneyDew
                    {
                    kw=(Token)match(input,HoneyDew,FOLLOW_HoneyDew_in_ruleColor2767); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getHoneyDewKeyword_1_57()); 
                        

                    }
                    break;
                case 59 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1141:2: kw= HotPink
                    {
                    kw=(Token)match(input,HotPink,FOLLOW_HotPink_in_ruleColor2786); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getHotPinkKeyword_1_58()); 
                        

                    }
                    break;
                case 60 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1148:2: kw= IndianRed
                    {
                    kw=(Token)match(input,IndianRed,FOLLOW_IndianRed_in_ruleColor2805); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getIndianRedKeyword_1_59()); 
                        

                    }
                    break;
                case 61 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1155:2: kw= Indigo
                    {
                    kw=(Token)match(input,Indigo,FOLLOW_Indigo_in_ruleColor2824); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getIndigoKeyword_1_60()); 
                        

                    }
                    break;
                case 62 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1162:2: kw= Ivory
                    {
                    kw=(Token)match(input,Ivory,FOLLOW_Ivory_in_ruleColor2843); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getIvoryKeyword_1_61()); 
                        

                    }
                    break;
                case 63 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1169:2: kw= Khaki
                    {
                    kw=(Token)match(input,Khaki,FOLLOW_Khaki_in_ruleColor2862); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getKhakiKeyword_1_62()); 
                        

                    }
                    break;
                case 64 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1176:2: kw= Lavender
                    {
                    kw=(Token)match(input,Lavender,FOLLOW_Lavender_in_ruleColor2881); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLavenderKeyword_1_63()); 
                        

                    }
                    break;
                case 65 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1183:2: kw= LavenderBlush
                    {
                    kw=(Token)match(input,LavenderBlush,FOLLOW_LavenderBlush_in_ruleColor2900); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLavenderBlushKeyword_1_64()); 
                        

                    }
                    break;
                case 66 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1190:2: kw= LawnGreen
                    {
                    kw=(Token)match(input,LawnGreen,FOLLOW_LawnGreen_in_ruleColor2919); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLawnGreenKeyword_1_65()); 
                        

                    }
                    break;
                case 67 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1197:2: kw= LemonChiffon
                    {
                    kw=(Token)match(input,LemonChiffon,FOLLOW_LemonChiffon_in_ruleColor2938); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLemonChiffonKeyword_1_66()); 
                        

                    }
                    break;
                case 68 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1204:2: kw= LightBlue
                    {
                    kw=(Token)match(input,LightBlue,FOLLOW_LightBlue_in_ruleColor2957); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightBlueKeyword_1_67()); 
                        

                    }
                    break;
                case 69 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1211:2: kw= LightCoral
                    {
                    kw=(Token)match(input,LightCoral,FOLLOW_LightCoral_in_ruleColor2976); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightCoralKeyword_1_68()); 
                        

                    }
                    break;
                case 70 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1218:2: kw= LightCyan
                    {
                    kw=(Token)match(input,LightCyan,FOLLOW_LightCyan_in_ruleColor2995); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightCyanKeyword_1_69()); 
                        

                    }
                    break;
                case 71 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1225:2: kw= LightGoldenRodYellow
                    {
                    kw=(Token)match(input,LightGoldenRodYellow,FOLLOW_LightGoldenRodYellow_in_ruleColor3014); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_1_70()); 
                        

                    }
                    break;
                case 72 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1232:2: kw= LightGray
                    {
                    kw=(Token)match(input,LightGray,FOLLOW_LightGray_in_ruleColor3033); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGrayKeyword_1_71()); 
                        

                    }
                    break;
                case 73 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1239:2: kw= LightGreen
                    {
                    kw=(Token)match(input,LightGreen,FOLLOW_LightGreen_in_ruleColor3052); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGreenKeyword_1_72()); 
                        

                    }
                    break;
                case 74 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1246:2: kw= LightGrey
                    {
                    kw=(Token)match(input,LightGrey,FOLLOW_LightGrey_in_ruleColor3071); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGreyKeyword_1_73()); 
                        

                    }
                    break;
                case 75 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1253:2: kw= LightPink
                    {
                    kw=(Token)match(input,LightPink,FOLLOW_LightPink_in_ruleColor3090); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightPinkKeyword_1_74()); 
                        

                    }
                    break;
                case 76 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1260:2: kw= LightSalmon
                    {
                    kw=(Token)match(input,LightSalmon,FOLLOW_LightSalmon_in_ruleColor3109); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSalmonKeyword_1_75()); 
                        

                    }
                    break;
                case 77 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1267:2: kw= LightSeaGreen
                    {
                    kw=(Token)match(input,LightSeaGreen,FOLLOW_LightSeaGreen_in_ruleColor3128); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSeaGreenKeyword_1_76()); 
                        

                    }
                    break;
                case 78 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1274:2: kw= LightSkyBlue
                    {
                    kw=(Token)match(input,LightSkyBlue,FOLLOW_LightSkyBlue_in_ruleColor3147); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSkyBlueKeyword_1_77()); 
                        

                    }
                    break;
                case 79 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1281:2: kw= LightSlateGray
                    {
                    kw=(Token)match(input,LightSlateGray,FOLLOW_LightSlateGray_in_ruleColor3166); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSlateGrayKeyword_1_78()); 
                        

                    }
                    break;
                case 80 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1288:2: kw= LightSlateGrey
                    {
                    kw=(Token)match(input,LightSlateGrey,FOLLOW_LightSlateGrey_in_ruleColor3185); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSlateGreyKeyword_1_79()); 
                        

                    }
                    break;
                case 81 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1295:2: kw= LightSteelBlue
                    {
                    kw=(Token)match(input,LightSteelBlue,FOLLOW_LightSteelBlue_in_ruleColor3204); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSteelBlueKeyword_1_80()); 
                        

                    }
                    break;
                case 82 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1302:2: kw= LightYellow
                    {
                    kw=(Token)match(input,LightYellow,FOLLOW_LightYellow_in_ruleColor3223); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightYellowKeyword_1_81()); 
                        

                    }
                    break;
                case 83 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1309:2: kw= Lime
                    {
                    kw=(Token)match(input,Lime,FOLLOW_Lime_in_ruleColor3242); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLimeKeyword_1_82()); 
                        

                    }
                    break;
                case 84 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1316:2: kw= LimeGreen
                    {
                    kw=(Token)match(input,LimeGreen,FOLLOW_LimeGreen_in_ruleColor3261); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLimeGreenKeyword_1_83()); 
                        

                    }
                    break;
                case 85 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1323:2: kw= Linen
                    {
                    kw=(Token)match(input,Linen,FOLLOW_Linen_in_ruleColor3280); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLinenKeyword_1_84()); 
                        

                    }
                    break;
                case 86 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1330:2: kw= Magenta
                    {
                    kw=(Token)match(input,Magenta,FOLLOW_Magenta_in_ruleColor3299); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMagentaKeyword_1_85()); 
                        

                    }
                    break;
                case 87 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1337:2: kw= Maroon
                    {
                    kw=(Token)match(input,Maroon,FOLLOW_Maroon_in_ruleColor3318); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMaroonKeyword_1_86()); 
                        

                    }
                    break;
                case 88 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1344:2: kw= MediumAquaMarine
                    {
                    kw=(Token)match(input,MediumAquaMarine,FOLLOW_MediumAquaMarine_in_ruleColor3337); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumAquaMarineKeyword_1_87()); 
                        

                    }
                    break;
                case 89 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1351:2: kw= MediumBlue
                    {
                    kw=(Token)match(input,MediumBlue,FOLLOW_MediumBlue_in_ruleColor3356); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumBlueKeyword_1_88()); 
                        

                    }
                    break;
                case 90 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1358:2: kw= MediumOrchid
                    {
                    kw=(Token)match(input,MediumOrchid,FOLLOW_MediumOrchid_in_ruleColor3375); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumOrchidKeyword_1_89()); 
                        

                    }
                    break;
                case 91 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1365:2: kw= MediumPurple
                    {
                    kw=(Token)match(input,MediumPurple,FOLLOW_MediumPurple_in_ruleColor3394); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumPurpleKeyword_1_90()); 
                        

                    }
                    break;
                case 92 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1372:2: kw= MediumSeaGreen
                    {
                    kw=(Token)match(input,MediumSeaGreen,FOLLOW_MediumSeaGreen_in_ruleColor3413); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumSeaGreenKeyword_1_91()); 
                        

                    }
                    break;
                case 93 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1379:2: kw= MediumSlateBlue
                    {
                    kw=(Token)match(input,MediumSlateBlue,FOLLOW_MediumSlateBlue_in_ruleColor3432); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumSlateBlueKeyword_1_92()); 
                        

                    }
                    break;
                case 94 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1386:2: kw= MediumSpringGreen
                    {
                    kw=(Token)match(input,MediumSpringGreen,FOLLOW_MediumSpringGreen_in_ruleColor3451); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumSpringGreenKeyword_1_93()); 
                        

                    }
                    break;
                case 95 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1393:2: kw= MediumTurquoise
                    {
                    kw=(Token)match(input,MediumTurquoise,FOLLOW_MediumTurquoise_in_ruleColor3470); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumTurquoiseKeyword_1_94()); 
                        

                    }
                    break;
                case 96 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1400:2: kw= MediumVioletRed
                    {
                    kw=(Token)match(input,MediumVioletRed,FOLLOW_MediumVioletRed_in_ruleColor3489); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumVioletRedKeyword_1_95()); 
                        

                    }
                    break;
                case 97 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1407:2: kw= MidnightBlue
                    {
                    kw=(Token)match(input,MidnightBlue,FOLLOW_MidnightBlue_in_ruleColor3508); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMidnightBlueKeyword_1_96()); 
                        

                    }
                    break;
                case 98 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1414:2: kw= MintCream
                    {
                    kw=(Token)match(input,MintCream,FOLLOW_MintCream_in_ruleColor3527); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMintCreamKeyword_1_97()); 
                        

                    }
                    break;
                case 99 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1421:2: kw= MistyRose
                    {
                    kw=(Token)match(input,MistyRose,FOLLOW_MistyRose_in_ruleColor3546); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMistyRoseKeyword_1_98()); 
                        

                    }
                    break;
                case 100 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1428:2: kw= Moccasin
                    {
                    kw=(Token)match(input,Moccasin,FOLLOW_Moccasin_in_ruleColor3565); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMoccasinKeyword_1_99()); 
                        

                    }
                    break;
                case 101 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1435:2: kw= NavajoWhite
                    {
                    kw=(Token)match(input,NavajoWhite,FOLLOW_NavajoWhite_in_ruleColor3584); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getNavajoWhiteKeyword_1_100()); 
                        

                    }
                    break;
                case 102 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1442:2: kw= Navy
                    {
                    kw=(Token)match(input,Navy,FOLLOW_Navy_in_ruleColor3603); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getNavyKeyword_1_101()); 
                        

                    }
                    break;
                case 103 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1449:2: kw= OldLace
                    {
                    kw=(Token)match(input,OldLace,FOLLOW_OldLace_in_ruleColor3622); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOldLaceKeyword_1_102()); 
                        

                    }
                    break;
                case 104 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1456:2: kw= Olive
                    {
                    kw=(Token)match(input,Olive,FOLLOW_Olive_in_ruleColor3641); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOliveKeyword_1_103()); 
                        

                    }
                    break;
                case 105 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1463:2: kw= OliveDrab
                    {
                    kw=(Token)match(input,OliveDrab,FOLLOW_OliveDrab_in_ruleColor3660); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOliveDrabKeyword_1_104()); 
                        

                    }
                    break;
                case 106 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1470:2: kw= OrangeRed
                    {
                    kw=(Token)match(input,OrangeRed,FOLLOW_OrangeRed_in_ruleColor3679); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOrangeRedKeyword_1_105()); 
                        

                    }
                    break;
                case 107 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1477:2: kw= Orchid
                    {
                    kw=(Token)match(input,Orchid,FOLLOW_Orchid_in_ruleColor3698); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOrchidKeyword_1_106()); 
                        

                    }
                    break;
                case 108 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1484:2: kw= PaleGoldenRod
                    {
                    kw=(Token)match(input,PaleGoldenRod,FOLLOW_PaleGoldenRod_in_ruleColor3717); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleGoldenRodKeyword_1_107()); 
                        

                    }
                    break;
                case 109 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1491:2: kw= PaleGreen
                    {
                    kw=(Token)match(input,PaleGreen,FOLLOW_PaleGreen_in_ruleColor3736); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleGreenKeyword_1_108()); 
                        

                    }
                    break;
                case 110 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1498:2: kw= PaleTurquoise
                    {
                    kw=(Token)match(input,PaleTurquoise,FOLLOW_PaleTurquoise_in_ruleColor3755); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleTurquoiseKeyword_1_109()); 
                        

                    }
                    break;
                case 111 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1505:2: kw= PaleVioletRed
                    {
                    kw=(Token)match(input,PaleVioletRed,FOLLOW_PaleVioletRed_in_ruleColor3774); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleVioletRedKeyword_1_110()); 
                        

                    }
                    break;
                case 112 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1512:2: kw= PapayaWhip
                    {
                    kw=(Token)match(input,PapayaWhip,FOLLOW_PapayaWhip_in_ruleColor3793); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPapayaWhipKeyword_1_111()); 
                        

                    }
                    break;
                case 113 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1519:2: kw= PeachPuff
                    {
                    kw=(Token)match(input,PeachPuff,FOLLOW_PeachPuff_in_ruleColor3812); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPeachPuffKeyword_1_112()); 
                        

                    }
                    break;
                case 114 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1526:2: kw= Peru
                    {
                    kw=(Token)match(input,Peru,FOLLOW_Peru_in_ruleColor3831); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPeruKeyword_1_113()); 
                        

                    }
                    break;
                case 115 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1533:2: kw= Pink
                    {
                    kw=(Token)match(input,Pink,FOLLOW_Pink_in_ruleColor3850); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPinkKeyword_1_114()); 
                        

                    }
                    break;
                case 116 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1540:2: kw= Plum
                    {
                    kw=(Token)match(input,Plum,FOLLOW_Plum_in_ruleColor3869); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPlumKeyword_1_115()); 
                        

                    }
                    break;
                case 117 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1547:2: kw= PowderBlue
                    {
                    kw=(Token)match(input,PowderBlue,FOLLOW_PowderBlue_in_ruleColor3888); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPowderBlueKeyword_1_116()); 
                        

                    }
                    break;
                case 118 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1554:2: kw= Purple
                    {
                    kw=(Token)match(input,Purple,FOLLOW_Purple_in_ruleColor3907); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPurpleKeyword_1_117()); 
                        

                    }
                    break;
                case 119 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1561:2: kw= Red
                    {
                    kw=(Token)match(input,Red,FOLLOW_Red_in_ruleColor3926); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getRedKeyword_1_118()); 
                        

                    }
                    break;
                case 120 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1568:2: kw= RosyBrown
                    {
                    kw=(Token)match(input,RosyBrown,FOLLOW_RosyBrown_in_ruleColor3945); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getRosyBrownKeyword_1_119()); 
                        

                    }
                    break;
                case 121 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1575:2: kw= RoyalBlue
                    {
                    kw=(Token)match(input,RoyalBlue,FOLLOW_RoyalBlue_in_ruleColor3964); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getRoyalBlueKeyword_1_120()); 
                        

                    }
                    break;
                case 122 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1582:2: kw= SaddleBrown
                    {
                    kw=(Token)match(input,SaddleBrown,FOLLOW_SaddleBrown_in_ruleColor3983); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSaddleBrownKeyword_1_121()); 
                        

                    }
                    break;
                case 123 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1589:2: kw= Salmon
                    {
                    kw=(Token)match(input,Salmon,FOLLOW_Salmon_in_ruleColor4002); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSalmonKeyword_1_122()); 
                        

                    }
                    break;
                case 124 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1596:2: kw= SandyBrown
                    {
                    kw=(Token)match(input,SandyBrown,FOLLOW_SandyBrown_in_ruleColor4021); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSandyBrownKeyword_1_123()); 
                        

                    }
                    break;
                case 125 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1603:2: kw= SeaGreen
                    {
                    kw=(Token)match(input,SeaGreen,FOLLOW_SeaGreen_in_ruleColor4040); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSeaGreenKeyword_1_124()); 
                        

                    }
                    break;
                case 126 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1610:2: kw= Sienna
                    {
                    kw=(Token)match(input,Sienna,FOLLOW_Sienna_in_ruleColor4059); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSiennaKeyword_1_125()); 
                        

                    }
                    break;
                case 127 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1617:2: kw= Silver
                    {
                    kw=(Token)match(input,Silver,FOLLOW_Silver_in_ruleColor4078); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSilverKeyword_1_126()); 
                        

                    }
                    break;
                case 128 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1624:2: kw= SkyBlue
                    {
                    kw=(Token)match(input,SkyBlue,FOLLOW_SkyBlue_in_ruleColor4097); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSkyBlueKeyword_1_127()); 
                        

                    }
                    break;
                case 129 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1631:2: kw= SlateBlue
                    {
                    kw=(Token)match(input,SlateBlue,FOLLOW_SlateBlue_in_ruleColor4116); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSlateBlueKeyword_1_128()); 
                        

                    }
                    break;
                case 130 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1638:2: kw= SlateGray
                    {
                    kw=(Token)match(input,SlateGray,FOLLOW_SlateGray_in_ruleColor4135); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSlateGrayKeyword_1_129()); 
                        

                    }
                    break;
                case 131 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1645:2: kw= SlateGrey
                    {
                    kw=(Token)match(input,SlateGrey,FOLLOW_SlateGrey_in_ruleColor4154); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSlateGreyKeyword_1_130()); 
                        

                    }
                    break;
                case 132 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1652:2: kw= Snow
                    {
                    kw=(Token)match(input,Snow,FOLLOW_Snow_in_ruleColor4173); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSnowKeyword_1_131()); 
                        

                    }
                    break;
                case 133 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1659:2: kw= SpringGreen
                    {
                    kw=(Token)match(input,SpringGreen,FOLLOW_SpringGreen_in_ruleColor4192); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSpringGreenKeyword_1_132()); 
                        

                    }
                    break;
                case 134 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1666:2: kw= SteelBlue
                    {
                    kw=(Token)match(input,SteelBlue,FOLLOW_SteelBlue_in_ruleColor4211); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSteelBlueKeyword_1_133()); 
                        

                    }
                    break;
                case 135 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1673:2: kw= Tan
                    {
                    kw=(Token)match(input,Tan,FOLLOW_Tan_in_ruleColor4230); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTanKeyword_1_134()); 
                        

                    }
                    break;
                case 136 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1680:2: kw= Teal
                    {
                    kw=(Token)match(input,Teal,FOLLOW_Teal_in_ruleColor4249); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTealKeyword_1_135()); 
                        

                    }
                    break;
                case 137 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1687:2: kw= Thistle
                    {
                    kw=(Token)match(input,Thistle,FOLLOW_Thistle_in_ruleColor4268); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getThistleKeyword_1_136()); 
                        

                    }
                    break;
                case 138 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1694:2: kw= Tomato
                    {
                    kw=(Token)match(input,Tomato,FOLLOW_Tomato_in_ruleColor4287); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTomatoKeyword_1_137()); 
                        

                    }
                    break;
                case 139 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1701:2: kw= Turquoise
                    {
                    kw=(Token)match(input,Turquoise,FOLLOW_Turquoise_in_ruleColor4306); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTurquoiseKeyword_1_138()); 
                        

                    }
                    break;
                case 140 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1708:2: kw= Violet
                    {
                    kw=(Token)match(input,Violet,FOLLOW_Violet_in_ruleColor4325); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getVioletKeyword_1_139()); 
                        

                    }
                    break;
                case 141 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1715:2: kw= Wheat
                    {
                    kw=(Token)match(input,Wheat,FOLLOW_Wheat_in_ruleColor4344); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getWheatKeyword_1_140()); 
                        

                    }
                    break;
                case 142 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1722:2: kw= White
                    {
                    kw=(Token)match(input,White,FOLLOW_White_in_ruleColor4363); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getWhiteKeyword_1_141()); 
                        

                    }
                    break;
                case 143 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1729:2: kw= WhiteSmoke
                    {
                    kw=(Token)match(input,WhiteSmoke,FOLLOW_WhiteSmoke_in_ruleColor4382); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getWhiteSmokeKeyword_1_142()); 
                        

                    }
                    break;
                case 144 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1736:2: kw= Yellow
                    {
                    kw=(Token)match(input,Yellow,FOLLOW_Yellow_in_ruleColor4401); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getYellowKeyword_1_143()); 
                        

                    }
                    break;
                case 145 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1743:2: kw= YellowGreen
                    {
                    kw=(Token)match(input,YellowGreen,FOLLOW_YellowGreen_in_ruleColor4420); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1756:1: entryRuleTitle returns [String current=null] : iv_ruleTitle= ruleTitle EOF ;
    public final String entryRuleTitle() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTitle = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1757:1: (iv_ruleTitle= ruleTitle EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1758:2: iv_ruleTitle= ruleTitle EOF
            {
             newCompositeNode(grammarAccess.getTitleRule()); 
            pushFollow(FOLLOW_ruleTitle_in_entryRuleTitle4461);
            iv_ruleTitle=ruleTitle();

            state._fsp--;

             current =iv_ruleTitle.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTitle4472); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1765:1: ruleTitle returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Title (this_ID_1= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleTitle() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1769:6: ( (kw= Title (this_ID_1= RULE_ID )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1770:1: (kw= Title (this_ID_1= RULE_ID )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1770:1: (kw= Title (this_ID_1= RULE_ID )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1771:2: kw= Title (this_ID_1= RULE_ID )*
            {
            kw=(Token)match(input,Title,FOLLOW_Title_in_ruleTitle4510); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTitleAccess().getTitleKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1776:1: (this_ID_1= RULE_ID )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1776:6: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTitle4526); 

            	    		current.merge(this_ID_1);
            	        
            	     
            	        newLeafNode(this_ID_1, grammarAccess.getTitleAccess().getIDTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // $ANTLR end "ruleTitle"


    // $ANTLR start "entryRuleLegend"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1791:1: entryRuleLegend returns [String current=null] : iv_ruleLegend= ruleLegend EOF ;
    public final String entryRuleLegend() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLegend = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1792:1: (iv_ruleLegend= ruleLegend EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1793:2: iv_ruleLegend= ruleLegend EOF
            {
             newCompositeNode(grammarAccess.getLegendRule()); 
            pushFollow(FOLLOW_ruleLegend_in_entryRuleLegend4573);
            iv_ruleLegend=ruleLegend();

            state._fsp--;

             current =iv_ruleLegend.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLegend4584); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1800:1: ruleLegend returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend ) ;
    public final AntlrDatatypeRuleToken ruleLegend() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_NEWLINE_4=null;
        Token this_ID_5=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1804:6: ( (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1805:1: (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1805:1: (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1806:2: kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend
            {
            kw=(Token)match(input,Legend,FOLLOW_Legend_in_ruleLegend4622); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getLegendAccess().getLegendKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1811:1: (kw= Right | kw= Left | kw= Center )?
            int alt15=4;
            switch ( input.LA(1) ) {
                case Right:
                    {
                    alt15=1;
                    }
                    break;
                case Left:
                    {
                    alt15=2;
                    }
                    break;
                case Center:
                    {
                    alt15=3;
                    }
                    break;
            }

            switch (alt15) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1812:2: kw= Right
                    {
                    kw=(Token)match(input,Right,FOLLOW_Right_in_ruleLegend4636); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getRightKeyword_1_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1819:2: kw= Left
                    {
                    kw=(Token)match(input,Left,FOLLOW_Left_in_ruleLegend4655); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1826:2: kw= Center
                    {
                    kw=(Token)match(input,Center,FOLLOW_Center_in_ruleLegend4674); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getCenterKeyword_1_2()); 
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1831:3: (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_NEWLINE) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1831:8: this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )*
            	    {
            	    this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleLegend4692); 

            	    		current.merge(this_NEWLINE_4);
            	        
            	     
            	        newLeafNode(this_NEWLINE_4, grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_0()); 
            	        
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1838:1: (this_ID_5= RULE_ID )*
            	    loop16:
            	    do {
            	        int alt16=2;
            	        int LA16_0 = input.LA(1);

            	        if ( (LA16_0==RULE_ID) ) {
            	            alt16=1;
            	        }


            	        switch (alt16) {
            	    	case 1 :
            	    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1838:6: this_ID_5= RULE_ID
            	    	    {
            	    	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLegend4713); 

            	    	    		current.merge(this_ID_5);
            	    	        
            	    	     
            	    	        newLeafNode(this_ID_5, grammarAccess.getLegendAccess().getIDTerminalRuleCall_2_1()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop16;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            kw=(Token)match(input,Endlegend,FOLLOW_Endlegend_in_ruleLegend4735); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getLegendAccess().getEndlegendKeyword_3()); 
                

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1859:1: entryRuleNewpage returns [String current=null] : iv_ruleNewpage= ruleNewpage EOF ;
    public final String entryRuleNewpage() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNewpage = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1860:1: (iv_ruleNewpage= ruleNewpage EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1861:2: iv_ruleNewpage= ruleNewpage EOF
            {
             newCompositeNode(grammarAccess.getNewpageRule()); 
            pushFollow(FOLLOW_ruleNewpage_in_entryRuleNewpage4775);
            iv_ruleNewpage=ruleNewpage();

            state._fsp--;

             current =iv_ruleNewpage.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNewpage4786); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1868:1: ruleNewpage returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Newpage (this_ID_1= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleNewpage() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1872:6: ( (kw= Newpage (this_ID_1= RULE_ID )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1873:1: (kw= Newpage (this_ID_1= RULE_ID )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1873:1: (kw= Newpage (this_ID_1= RULE_ID )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1874:2: kw= Newpage (this_ID_1= RULE_ID )*
            {
            kw=(Token)match(input,Newpage,FOLLOW_Newpage_in_ruleNewpage4824); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getNewpageAccess().getNewpageKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1879:1: (this_ID_1= RULE_ID )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1879:6: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNewpage4840); 

            	    		current.merge(this_ID_1);
            	        
            	     
            	        newLeafNode(this_ID_1, grammarAccess.getNewpageAccess().getIDTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop18;
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
    // $ANTLR end "ruleNewpage"


    // $ANTLR start "entryRuleAltElse"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1894:1: entryRuleAltElse returns [EObject current=null] : iv_ruleAltElse= ruleAltElse EOF ;
    public final EObject entryRuleAltElse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltElse = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1895:2: (iv_ruleAltElse= ruleAltElse EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1896:2: iv_ruleAltElse= ruleAltElse EOF
            {
             newCompositeNode(grammarAccess.getAltElseRule()); 
            pushFollow(FOLLOW_ruleAltElse_in_entryRuleAltElse4886);
            iv_ruleAltElse=ruleAltElse();

            state._fsp--;

             current =iv_ruleAltElse; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAltElse4896); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1903:1: ruleAltElse returns [EObject current=null] : ( () otherlv_1= Alt (this_ID_2= RULE_ID )* this_NEWLINE_3= RULE_NEWLINE ( (lv_instructions_4_0= ruleInstruction ) )* ( (lv_elses_5_0= ruleElse ) )* otherlv_6= End ) ;
    public final EObject ruleAltElse() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_ID_2=null;
        Token this_NEWLINE_3=null;
        Token otherlv_6=null;
        EObject lv_instructions_4_0 = null;

        EObject lv_elses_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1906:28: ( ( () otherlv_1= Alt (this_ID_2= RULE_ID )* this_NEWLINE_3= RULE_NEWLINE ( (lv_instructions_4_0= ruleInstruction ) )* ( (lv_elses_5_0= ruleElse ) )* otherlv_6= End ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1907:1: ( () otherlv_1= Alt (this_ID_2= RULE_ID )* this_NEWLINE_3= RULE_NEWLINE ( (lv_instructions_4_0= ruleInstruction ) )* ( (lv_elses_5_0= ruleElse ) )* otherlv_6= End )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1907:1: ( () otherlv_1= Alt (this_ID_2= RULE_ID )* this_NEWLINE_3= RULE_NEWLINE ( (lv_instructions_4_0= ruleInstruction ) )* ( (lv_elses_5_0= ruleElse ) )* otherlv_6= End )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1907:2: () otherlv_1= Alt (this_ID_2= RULE_ID )* this_NEWLINE_3= RULE_NEWLINE ( (lv_instructions_4_0= ruleInstruction ) )* ( (lv_elses_5_0= ruleElse ) )* otherlv_6= End
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1907:2: ()
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1908:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAltElseAccess().getAltElseAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,Alt,FOLLOW_Alt_in_ruleAltElse4943); 

                	newLeafNode(otherlv_1, grammarAccess.getAltElseAccess().getAltKeyword_1());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1918:1: (this_ID_2= RULE_ID )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1918:2: this_ID_2= RULE_ID
            	    {
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAltElse4954); 
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getAltElseAccess().getIDTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            this_NEWLINE_3=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleAltElse4966); 
             
                newLeafNode(this_NEWLINE_3, grammarAccess.getAltElseAccess().getNEWLINETerminalRuleCall_3()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1926:1: ( (lv_instructions_4_0= ruleInstruction ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==Participant||(LA20_0>=Autonumber && LA20_0<=Deactivate)||(LA20_0>=Activate && LA20_0<=Database)||(LA20_0>=Control && LA20_0<=Destroy)||LA20_0==Newpage||(LA20_0>=Create && LA20_0<=Legend)||(LA20_0>=Actor && LA20_0<=Group)||LA20_0==Title||LA20_0==Hide||(LA20_0>=Loop && LA20_0<=Note)||LA20_0==FullStopFullStopFullStop||(LA20_0>=Alt && LA20_0<=Box)||(LA20_0>=Opt && LA20_0<=VerticalLineVerticalLineVerticalLine)||LA20_0==EqualsSignEqualsSign||LA20_0==VerticalLineVerticalLine||LA20_0==RULE_NEWLINE||LA20_0==RULE_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1927:1: (lv_instructions_4_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1927:1: (lv_instructions_4_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1928:3: lv_instructions_4_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAltElseAccess().getInstructionsInstructionParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleAltElse4986);
            	    lv_instructions_4_0=ruleInstruction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAltElseRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"instructions",
            	            		lv_instructions_4_0, 
            	            		"Instruction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1944:3: ( (lv_elses_5_0= ruleElse ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==Else) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1945:1: (lv_elses_5_0= ruleElse )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1945:1: (lv_elses_5_0= ruleElse )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1946:3: lv_elses_5_0= ruleElse
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAltElseAccess().getElsesElseParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleElse_in_ruleAltElse5008);
            	    lv_elses_5_0=ruleElse();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAltElseRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elses",
            	            		lv_elses_5_0, 
            	            		"Else");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_6=(Token)match(input,End,FOLLOW_End_in_ruleAltElse5022); 

                	newLeafNode(otherlv_6, grammarAccess.getAltElseAccess().getEndKeyword_6());
                

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1975:1: entryRuleElse returns [EObject current=null] : iv_ruleElse= ruleElse EOF ;
    public final EObject entryRuleElse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElse = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1976:2: (iv_ruleElse= ruleElse EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1977:2: iv_ruleElse= ruleElse EOF
            {
             newCompositeNode(grammarAccess.getElseRule()); 
            pushFollow(FOLLOW_ruleElse_in_entryRuleElse5056);
            iv_ruleElse=ruleElse();

            state._fsp--;

             current =iv_ruleElse; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElse5066); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1984:1: ruleElse returns [EObject current=null] : ( () otherlv_1= Else (this_ID_2= RULE_ID )* this_NEWLINE_3= RULE_NEWLINE ( (lv_instructions_4_0= ruleInstruction ) )* ) ;
    public final EObject ruleElse() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_ID_2=null;
        Token this_NEWLINE_3=null;
        EObject lv_instructions_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1987:28: ( ( () otherlv_1= Else (this_ID_2= RULE_ID )* this_NEWLINE_3= RULE_NEWLINE ( (lv_instructions_4_0= ruleInstruction ) )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1988:1: ( () otherlv_1= Else (this_ID_2= RULE_ID )* this_NEWLINE_3= RULE_NEWLINE ( (lv_instructions_4_0= ruleInstruction ) )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1988:1: ( () otherlv_1= Else (this_ID_2= RULE_ID )* this_NEWLINE_3= RULE_NEWLINE ( (lv_instructions_4_0= ruleInstruction ) )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1988:2: () otherlv_1= Else (this_ID_2= RULE_ID )* this_NEWLINE_3= RULE_NEWLINE ( (lv_instructions_4_0= ruleInstruction ) )*
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1988:2: ()
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1989:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getElseAccess().getElseAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,Else,FOLLOW_Else_in_ruleElse5113); 

                	newLeafNode(otherlv_1, grammarAccess.getElseAccess().getElseKeyword_1());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1999:1: (this_ID_2= RULE_ID )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1999:2: this_ID_2= RULE_ID
            	    {
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleElse5124); 
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getElseAccess().getIDTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            this_NEWLINE_3=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleElse5136); 
             
                newLeafNode(this_NEWLINE_3, grammarAccess.getElseAccess().getNEWLINETerminalRuleCall_3()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2007:1: ( (lv_instructions_4_0= ruleInstruction ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==Participant||(LA23_0>=Autonumber && LA23_0<=Deactivate)||(LA23_0>=Activate && LA23_0<=Database)||(LA23_0>=Control && LA23_0<=Destroy)||LA23_0==Newpage||(LA23_0>=Create && LA23_0<=Legend)||(LA23_0>=Actor && LA23_0<=Group)||LA23_0==Title||LA23_0==Hide||(LA23_0>=Loop && LA23_0<=Note)||LA23_0==FullStopFullStopFullStop||(LA23_0>=Alt && LA23_0<=Box)||(LA23_0>=Opt && LA23_0<=VerticalLineVerticalLineVerticalLine)||LA23_0==EqualsSignEqualsSign||LA23_0==VerticalLineVerticalLine||LA23_0==RULE_NEWLINE||LA23_0==RULE_ID) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2008:1: (lv_instructions_4_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2008:1: (lv_instructions_4_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2009:3: lv_instructions_4_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getElseAccess().getInstructionsInstructionParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleElse5156);
            	    lv_instructions_4_0=ruleInstruction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getElseRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"instructions",
            	            		lv_instructions_4_0, 
            	            		"Instruction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2033:1: entryRuleGroupingMessages returns [EObject current=null] : iv_ruleGroupingMessages= ruleGroupingMessages EOF ;
    public final EObject entryRuleGroupingMessages() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupingMessages = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2034:2: (iv_ruleGroupingMessages= ruleGroupingMessages EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2035:2: iv_ruleGroupingMessages= ruleGroupingMessages EOF
            {
             newCompositeNode(grammarAccess.getGroupingMessagesRule()); 
            pushFollow(FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages5192);
            iv_ruleGroupingMessages=ruleGroupingMessages();

            state._fsp--;

             current =iv_ruleGroupingMessages; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroupingMessages5202); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2042:1: ruleGroupingMessages returns [EObject current=null] : ( () (otherlv_1= Opt | otherlv_2= Loop | otherlv_3= Par | otherlv_4= Break | otherlv_5= Critical | otherlv_6= Group ) (this_ID_7= RULE_ID )* this_NEWLINE_8= RULE_NEWLINE ( (lv_instructions_9_0= ruleInstruction ) )* otherlv_10= End ) ;
    public final EObject ruleGroupingMessages() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token this_ID_7=null;
        Token this_NEWLINE_8=null;
        Token otherlv_10=null;
        EObject lv_instructions_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2045:28: ( ( () (otherlv_1= Opt | otherlv_2= Loop | otherlv_3= Par | otherlv_4= Break | otherlv_5= Critical | otherlv_6= Group ) (this_ID_7= RULE_ID )* this_NEWLINE_8= RULE_NEWLINE ( (lv_instructions_9_0= ruleInstruction ) )* otherlv_10= End ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2046:1: ( () (otherlv_1= Opt | otherlv_2= Loop | otherlv_3= Par | otherlv_4= Break | otherlv_5= Critical | otherlv_6= Group ) (this_ID_7= RULE_ID )* this_NEWLINE_8= RULE_NEWLINE ( (lv_instructions_9_0= ruleInstruction ) )* otherlv_10= End )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2046:1: ( () (otherlv_1= Opt | otherlv_2= Loop | otherlv_3= Par | otherlv_4= Break | otherlv_5= Critical | otherlv_6= Group ) (this_ID_7= RULE_ID )* this_NEWLINE_8= RULE_NEWLINE ( (lv_instructions_9_0= ruleInstruction ) )* otherlv_10= End )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2046:2: () (otherlv_1= Opt | otherlv_2= Loop | otherlv_3= Par | otherlv_4= Break | otherlv_5= Critical | otherlv_6= Group ) (this_ID_7= RULE_ID )* this_NEWLINE_8= RULE_NEWLINE ( (lv_instructions_9_0= ruleInstruction ) )* otherlv_10= End
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2046:2: ()
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2047:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getGroupingMessagesAccess().getGroupingMessageAction_0(),
                        current);
                

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2052:2: (otherlv_1= Opt | otherlv_2= Loop | otherlv_3= Par | otherlv_4= Break | otherlv_5= Critical | otherlv_6= Group )
            int alt24=6;
            switch ( input.LA(1) ) {
            case Opt:
                {
                alt24=1;
                }
                break;
            case Loop:
                {
                alt24=2;
                }
                break;
            case Par:
                {
                alt24=3;
                }
                break;
            case Break:
                {
                alt24=4;
                }
                break;
            case Critical:
                {
                alt24=5;
                }
                break;
            case Group:
                {
                alt24=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2053:2: otherlv_1= Opt
                    {
                    otherlv_1=(Token)match(input,Opt,FOLLOW_Opt_in_ruleGroupingMessages5250); 

                        	newLeafNode(otherlv_1, grammarAccess.getGroupingMessagesAccess().getOptKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2059:2: otherlv_2= Loop
                    {
                    otherlv_2=(Token)match(input,Loop,FOLLOW_Loop_in_ruleGroupingMessages5268); 

                        	newLeafNode(otherlv_2, grammarAccess.getGroupingMessagesAccess().getLoopKeyword_1_1());
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2065:2: otherlv_3= Par
                    {
                    otherlv_3=(Token)match(input,Par,FOLLOW_Par_in_ruleGroupingMessages5286); 

                        	newLeafNode(otherlv_3, grammarAccess.getGroupingMessagesAccess().getParKeyword_1_2());
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2071:2: otherlv_4= Break
                    {
                    otherlv_4=(Token)match(input,Break,FOLLOW_Break_in_ruleGroupingMessages5304); 

                        	newLeafNode(otherlv_4, grammarAccess.getGroupingMessagesAccess().getBreakKeyword_1_3());
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2077:2: otherlv_5= Critical
                    {
                    otherlv_5=(Token)match(input,Critical,FOLLOW_Critical_in_ruleGroupingMessages5322); 

                        	newLeafNode(otherlv_5, grammarAccess.getGroupingMessagesAccess().getCriticalKeyword_1_4());
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2083:2: otherlv_6= Group
                    {
                    otherlv_6=(Token)match(input,Group,FOLLOW_Group_in_ruleGroupingMessages5340); 

                        	newLeafNode(otherlv_6, grammarAccess.getGroupingMessagesAccess().getGroupKeyword_1_5());
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2087:2: (this_ID_7= RULE_ID )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2087:3: this_ID_7= RULE_ID
            	    {
            	    this_ID_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGroupingMessages5352); 
            	     
            	        newLeafNode(this_ID_7, grammarAccess.getGroupingMessagesAccess().getIDTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            this_NEWLINE_8=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleGroupingMessages5364); 
             
                newLeafNode(this_NEWLINE_8, grammarAccess.getGroupingMessagesAccess().getNEWLINETerminalRuleCall_3()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2095:1: ( (lv_instructions_9_0= ruleInstruction ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==Participant||(LA26_0>=Autonumber && LA26_0<=Deactivate)||(LA26_0>=Activate && LA26_0<=Database)||(LA26_0>=Control && LA26_0<=Destroy)||LA26_0==Newpage||(LA26_0>=Create && LA26_0<=Legend)||(LA26_0>=Actor && LA26_0<=Group)||LA26_0==Title||LA26_0==Hide||(LA26_0>=Loop && LA26_0<=Note)||LA26_0==FullStopFullStopFullStop||(LA26_0>=Alt && LA26_0<=Box)||(LA26_0>=Opt && LA26_0<=VerticalLineVerticalLineVerticalLine)||LA26_0==EqualsSignEqualsSign||LA26_0==VerticalLineVerticalLine||LA26_0==RULE_NEWLINE||LA26_0==RULE_ID) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2096:1: (lv_instructions_9_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2096:1: (lv_instructions_9_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2097:3: lv_instructions_9_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGroupingMessagesAccess().getInstructionsInstructionParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleGroupingMessages5384);
            	    lv_instructions_9_0=ruleInstruction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGroupingMessagesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"instructions",
            	            		lv_instructions_9_0, 
            	            		"Instruction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            otherlv_10=(Token)match(input,End,FOLLOW_End_in_ruleGroupingMessages5398); 

                	newLeafNode(otherlv_10, grammarAccess.getGroupingMessagesAccess().getEndKeyword_5());
                

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2126:1: entryRuleNote returns [EObject current=null] : iv_ruleNote= ruleNote EOF ;
    public final EObject entryRuleNote() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNote = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2127:2: (iv_ruleNote= ruleNote EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2128:2: iv_ruleNote= ruleNote EOF
            {
             newCompositeNode(grammarAccess.getNoteRule()); 
            pushFollow(FOLLOW_ruleNote_in_entryRuleNote5432);
            iv_ruleNote=ruleNote();

            state._fsp--;

             current =iv_ruleNote; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNote5442); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2135:1: ruleNote returns [EObject current=null] : ( () otherlv_1= Note ( (otherlv_2= Right (otherlv_3= Of ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* )? ) | (otherlv_7= Left (otherlv_8= Of ( (otherlv_9= RULE_ID ) ) (otherlv_10= Comma ( (otherlv_11= RULE_ID ) ) )* )? ) | (otherlv_12= Over ( (otherlv_13= RULE_ID ) ) (otherlv_14= Comma ( (otherlv_15= RULE_ID ) ) )* ) ) ( ruleColor )* ( (otherlv_17= Colon this_ID_18= RULE_ID ) | ( (this_NEWLINE_19= RULE_NEWLINE (this_ID_20= RULE_ID )* )* this_NEWLINE_21= RULE_NEWLINE otherlv_22= End otherlv_23= Note ) ) ) ;
    public final EObject ruleNote() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token this_ID_18=null;
        Token this_NEWLINE_19=null;
        Token this_ID_20=null;
        Token this_NEWLINE_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2138:28: ( ( () otherlv_1= Note ( (otherlv_2= Right (otherlv_3= Of ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* )? ) | (otherlv_7= Left (otherlv_8= Of ( (otherlv_9= RULE_ID ) ) (otherlv_10= Comma ( (otherlv_11= RULE_ID ) ) )* )? ) | (otherlv_12= Over ( (otherlv_13= RULE_ID ) ) (otherlv_14= Comma ( (otherlv_15= RULE_ID ) ) )* ) ) ( ruleColor )* ( (otherlv_17= Colon this_ID_18= RULE_ID ) | ( (this_NEWLINE_19= RULE_NEWLINE (this_ID_20= RULE_ID )* )* this_NEWLINE_21= RULE_NEWLINE otherlv_22= End otherlv_23= Note ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2139:1: ( () otherlv_1= Note ( (otherlv_2= Right (otherlv_3= Of ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* )? ) | (otherlv_7= Left (otherlv_8= Of ( (otherlv_9= RULE_ID ) ) (otherlv_10= Comma ( (otherlv_11= RULE_ID ) ) )* )? ) | (otherlv_12= Over ( (otherlv_13= RULE_ID ) ) (otherlv_14= Comma ( (otherlv_15= RULE_ID ) ) )* ) ) ( ruleColor )* ( (otherlv_17= Colon this_ID_18= RULE_ID ) | ( (this_NEWLINE_19= RULE_NEWLINE (this_ID_20= RULE_ID )* )* this_NEWLINE_21= RULE_NEWLINE otherlv_22= End otherlv_23= Note ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2139:1: ( () otherlv_1= Note ( (otherlv_2= Right (otherlv_3= Of ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* )? ) | (otherlv_7= Left (otherlv_8= Of ( (otherlv_9= RULE_ID ) ) (otherlv_10= Comma ( (otherlv_11= RULE_ID ) ) )* )? ) | (otherlv_12= Over ( (otherlv_13= RULE_ID ) ) (otherlv_14= Comma ( (otherlv_15= RULE_ID ) ) )* ) ) ( ruleColor )* ( (otherlv_17= Colon this_ID_18= RULE_ID ) | ( (this_NEWLINE_19= RULE_NEWLINE (this_ID_20= RULE_ID )* )* this_NEWLINE_21= RULE_NEWLINE otherlv_22= End otherlv_23= Note ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2139:2: () otherlv_1= Note ( (otherlv_2= Right (otherlv_3= Of ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* )? ) | (otherlv_7= Left (otherlv_8= Of ( (otherlv_9= RULE_ID ) ) (otherlv_10= Comma ( (otherlv_11= RULE_ID ) ) )* )? ) | (otherlv_12= Over ( (otherlv_13= RULE_ID ) ) (otherlv_14= Comma ( (otherlv_15= RULE_ID ) ) )* ) ) ( ruleColor )* ( (otherlv_17= Colon this_ID_18= RULE_ID ) | ( (this_NEWLINE_19= RULE_NEWLINE (this_ID_20= RULE_ID )* )* this_NEWLINE_21= RULE_NEWLINE otherlv_22= End otherlv_23= Note ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2139:2: ()
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2140:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNoteAccess().getNoteAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,Note,FOLLOW_Note_in_ruleNote5489); 

                	newLeafNode(otherlv_1, grammarAccess.getNoteAccess().getNoteKeyword_1());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2150:1: ( (otherlv_2= Right (otherlv_3= Of ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* )? ) | (otherlv_7= Left (otherlv_8= Of ( (otherlv_9= RULE_ID ) ) (otherlv_10= Comma ( (otherlv_11= RULE_ID ) ) )* )? ) | (otherlv_12= Over ( (otherlv_13= RULE_ID ) ) (otherlv_14= Comma ( (otherlv_15= RULE_ID ) ) )* ) )
            int alt32=3;
            switch ( input.LA(1) ) {
            case Right:
                {
                alt32=1;
                }
                break;
            case Left:
                {
                alt32=2;
                }
                break;
            case Over:
                {
                alt32=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2150:2: (otherlv_2= Right (otherlv_3= Of ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2150:2: (otherlv_2= Right (otherlv_3= Of ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2151:2: otherlv_2= Right (otherlv_3= Of ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* )?
                    {
                    otherlv_2=(Token)match(input,Right,FOLLOW_Right_in_ruleNote5503); 

                        	newLeafNode(otherlv_2, grammarAccess.getNoteAccess().getRightKeyword_2_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2155:1: (otherlv_3= Of ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==Of) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2156:2: otherlv_3= Of ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )*
                            {
                            otherlv_3=(Token)match(input,Of,FOLLOW_Of_in_ruleNote5516); 

                                	newLeafNode(otherlv_3, grammarAccess.getNoteAccess().getOfKeyword_2_0_1_0());
                                
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2160:1: ( (otherlv_4= RULE_ID ) )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2161:1: (otherlv_4= RULE_ID )
                            {
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2161:1: (otherlv_4= RULE_ID )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2162:3: otherlv_4= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getNoteRule());
                            	        }
                                    
                            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote5535); 

                            		newLeafNode(otherlv_4, grammarAccess.getNoteAccess().getRidDefinitionCrossReference_2_0_1_1_0()); 
                            	

                            }


                            }

                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2173:2: (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )*
                            loop27:
                            do {
                                int alt27=2;
                                int LA27_0 = input.LA(1);

                                if ( (LA27_0==Comma) ) {
                                    alt27=1;
                                }


                                switch (alt27) {
                            	case 1 :
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2174:2: otherlv_5= Comma ( (otherlv_6= RULE_ID ) )
                            	    {
                            	    otherlv_5=(Token)match(input,Comma,FOLLOW_Comma_in_ruleNote5549); 

                            	        	newLeafNode(otherlv_5, grammarAccess.getNoteAccess().getCommaKeyword_2_0_1_2_0());
                            	        
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2178:1: ( (otherlv_6= RULE_ID ) )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2179:1: (otherlv_6= RULE_ID )
                            	    {
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2179:1: (otherlv_6= RULE_ID )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2180:3: otherlv_6= RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = createModelElement(grammarAccess.getNoteRule());
                            	    	        }
                            	            
                            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote5568); 

                            	    		newLeafNode(otherlv_6, grammarAccess.getNoteAccess().getRidsDefinitionCrossReference_2_0_1_2_1_0()); 
                            	    	

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop27;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2192:6: (otherlv_7= Left (otherlv_8= Of ( (otherlv_9= RULE_ID ) ) (otherlv_10= Comma ( (otherlv_11= RULE_ID ) ) )* )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2192:6: (otherlv_7= Left (otherlv_8= Of ( (otherlv_9= RULE_ID ) ) (otherlv_10= Comma ( (otherlv_11= RULE_ID ) ) )* )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2193:2: otherlv_7= Left (otherlv_8= Of ( (otherlv_9= RULE_ID ) ) (otherlv_10= Comma ( (otherlv_11= RULE_ID ) ) )* )?
                    {
                    otherlv_7=(Token)match(input,Left,FOLLOW_Left_in_ruleNote5593); 

                        	newLeafNode(otherlv_7, grammarAccess.getNoteAccess().getLeftKeyword_2_1_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2197:1: (otherlv_8= Of ( (otherlv_9= RULE_ID ) ) (otherlv_10= Comma ( (otherlv_11= RULE_ID ) ) )* )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==Of) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2198:2: otherlv_8= Of ( (otherlv_9= RULE_ID ) ) (otherlv_10= Comma ( (otherlv_11= RULE_ID ) ) )*
                            {
                            otherlv_8=(Token)match(input,Of,FOLLOW_Of_in_ruleNote5606); 

                                	newLeafNode(otherlv_8, grammarAccess.getNoteAccess().getOfKeyword_2_1_1_0());
                                
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2202:1: ( (otherlv_9= RULE_ID ) )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2203:1: (otherlv_9= RULE_ID )
                            {
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2203:1: (otherlv_9= RULE_ID )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2204:3: otherlv_9= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getNoteRule());
                            	        }
                                    
                            otherlv_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote5625); 

                            		newLeafNode(otherlv_9, grammarAccess.getNoteAccess().getLidDefinitionCrossReference_2_1_1_1_0()); 
                            	

                            }


                            }

                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2215:2: (otherlv_10= Comma ( (otherlv_11= RULE_ID ) ) )*
                            loop29:
                            do {
                                int alt29=2;
                                int LA29_0 = input.LA(1);

                                if ( (LA29_0==Comma) ) {
                                    alt29=1;
                                }


                                switch (alt29) {
                            	case 1 :
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2216:2: otherlv_10= Comma ( (otherlv_11= RULE_ID ) )
                            	    {
                            	    otherlv_10=(Token)match(input,Comma,FOLLOW_Comma_in_ruleNote5639); 

                            	        	newLeafNode(otherlv_10, grammarAccess.getNoteAccess().getCommaKeyword_2_1_1_2_0());
                            	        
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2220:1: ( (otherlv_11= RULE_ID ) )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2221:1: (otherlv_11= RULE_ID )
                            	    {
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2221:1: (otherlv_11= RULE_ID )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2222:3: otherlv_11= RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = createModelElement(grammarAccess.getNoteRule());
                            	    	        }
                            	            
                            	    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote5658); 

                            	    		newLeafNode(otherlv_11, grammarAccess.getNoteAccess().getLidsDefinitionCrossReference_2_1_1_2_1_0()); 
                            	    	

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop29;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2234:6: (otherlv_12= Over ( (otherlv_13= RULE_ID ) ) (otherlv_14= Comma ( (otherlv_15= RULE_ID ) ) )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2234:6: (otherlv_12= Over ( (otherlv_13= RULE_ID ) ) (otherlv_14= Comma ( (otherlv_15= RULE_ID ) ) )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2235:2: otherlv_12= Over ( (otherlv_13= RULE_ID ) ) (otherlv_14= Comma ( (otherlv_15= RULE_ID ) ) )*
                    {
                    otherlv_12=(Token)match(input,Over,FOLLOW_Over_in_ruleNote5683); 

                        	newLeafNode(otherlv_12, grammarAccess.getNoteAccess().getOverKeyword_2_2_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2239:1: ( (otherlv_13= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2240:1: (otherlv_13= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2240:1: (otherlv_13= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2241:3: otherlv_13= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getNoteRule());
                    	        }
                            
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote5702); 

                    		newLeafNode(otherlv_13, grammarAccess.getNoteAccess().getOidDefinitionCrossReference_2_2_1_0()); 
                    	

                    }


                    }

                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2252:2: (otherlv_14= Comma ( (otherlv_15= RULE_ID ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==Comma) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2253:2: otherlv_14= Comma ( (otherlv_15= RULE_ID ) )
                    	    {
                    	    otherlv_14=(Token)match(input,Comma,FOLLOW_Comma_in_ruleNote5716); 

                    	        	newLeafNode(otherlv_14, grammarAccess.getNoteAccess().getCommaKeyword_2_2_2_0());
                    	        
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2257:1: ( (otherlv_15= RULE_ID ) )
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2258:1: (otherlv_15= RULE_ID )
                    	    {
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2258:1: (otherlv_15= RULE_ID )
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2259:3: otherlv_15= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getNoteRule());
                    	    	        }
                    	            
                    	    otherlv_15=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote5735); 

                    	    		newLeafNode(otherlv_15, grammarAccess.getNoteAccess().getOidsDefinitionCrossReference_2_2_2_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2270:6: ( ruleColor )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==NumberSign) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2271:5: ruleColor
            	    {
            	     
            	            newCompositeNode(grammarAccess.getNoteAccess().getColorParserRuleCall_3()); 
            	        
            	    pushFollow(FOLLOW_ruleColor_in_ruleNote5756);
            	    ruleColor();

            	    state._fsp--;


            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2278:3: ( (otherlv_17= Colon this_ID_18= RULE_ID ) | ( (this_NEWLINE_19= RULE_NEWLINE (this_ID_20= RULE_ID )* )* this_NEWLINE_21= RULE_NEWLINE otherlv_22= End otherlv_23= Note ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==Colon) ) {
                alt36=1;
            }
            else if ( (LA36_0==RULE_NEWLINE) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2278:4: (otherlv_17= Colon this_ID_18= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2278:4: (otherlv_17= Colon this_ID_18= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2279:2: otherlv_17= Colon this_ID_18= RULE_ID
                    {
                    otherlv_17=(Token)match(input,Colon,FOLLOW_Colon_in_ruleNote5772); 

                        	newLeafNode(otherlv_17, grammarAccess.getNoteAccess().getColonKeyword_4_0_0());
                        
                    this_ID_18=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote5782); 
                     
                        newLeafNode(this_ID_18, grammarAccess.getNoteAccess().getIDTerminalRuleCall_4_0_1()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2288:6: ( (this_NEWLINE_19= RULE_NEWLINE (this_ID_20= RULE_ID )* )* this_NEWLINE_21= RULE_NEWLINE otherlv_22= End otherlv_23= Note )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2288:6: ( (this_NEWLINE_19= RULE_NEWLINE (this_ID_20= RULE_ID )* )* this_NEWLINE_21= RULE_NEWLINE otherlv_22= End otherlv_23= Note )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2288:7: (this_NEWLINE_19= RULE_NEWLINE (this_ID_20= RULE_ID )* )* this_NEWLINE_21= RULE_NEWLINE otherlv_22= End otherlv_23= Note
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2288:7: (this_NEWLINE_19= RULE_NEWLINE (this_ID_20= RULE_ID )* )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==RULE_NEWLINE) ) {
                            int LA35_1 = input.LA(2);

                            if ( (LA35_1==RULE_NEWLINE||LA35_1==RULE_ID) ) {
                                alt35=1;
                            }


                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2288:8: this_NEWLINE_19= RULE_NEWLINE (this_ID_20= RULE_ID )*
                    	    {
                    	    this_NEWLINE_19=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleNote5801); 
                    	     
                    	        newLeafNode(this_NEWLINE_19, grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_4_1_0_0()); 
                    	        
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2292:1: (this_ID_20= RULE_ID )*
                    	    loop34:
                    	    do {
                    	        int alt34=2;
                    	        int LA34_0 = input.LA(1);

                    	        if ( (LA34_0==RULE_ID) ) {
                    	            alt34=1;
                    	        }


                    	        switch (alt34) {
                    	    	case 1 :
                    	    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2292:2: this_ID_20= RULE_ID
                    	    	    {
                    	    	    this_ID_20=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote5812); 
                    	    	     
                    	    	        newLeafNode(this_ID_20, grammarAccess.getNoteAccess().getIDTerminalRuleCall_4_1_0_1()); 
                    	    	        

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop34;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);

                    this_NEWLINE_21=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleNote5826); 
                     
                        newLeafNode(this_NEWLINE_21, grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_4_1_1()); 
                        
                    otherlv_22=(Token)match(input,End,FOLLOW_End_in_ruleNote5838); 

                        	newLeafNode(otherlv_22, grammarAccess.getNoteAccess().getEndKeyword_4_1_2());
                        
                    otherlv_23=(Token)match(input,Note,FOLLOW_Note_in_ruleNote5850); 

                        	newLeafNode(otherlv_23, grammarAccess.getNoteAccess().getNoteKeyword_4_1_3());
                        

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2318:1: entryRuleDivider returns [String current=null] : iv_ruleDivider= ruleDivider EOF ;
    public final String entryRuleDivider() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDivider = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2319:1: (iv_ruleDivider= ruleDivider EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2320:2: iv_ruleDivider= ruleDivider EOF
            {
             newCompositeNode(grammarAccess.getDividerRule()); 
            pushFollow(FOLLOW_ruleDivider_in_entryRuleDivider5887);
            iv_ruleDivider=ruleDivider();

            state._fsp--;

             current =iv_ruleDivider.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDivider5898); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2327:1: ruleDivider returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign ) ;
    public final AntlrDatatypeRuleToken ruleDivider() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2331:6: ( (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2332:1: (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2332:1: (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2333:2: kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign
            {
            kw=(Token)match(input,EqualsSignEqualsSign,FOLLOW_EqualsSignEqualsSign_in_ruleDivider5936); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDividerAccess().getEqualsSignEqualsSignKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2338:1: (this_ID_1= RULE_ID )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_ID) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2338:6: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDivider5952); 

            	    		current.merge(this_ID_1);
            	        
            	     
            	        newLeafNode(this_ID_1, grammarAccess.getDividerAccess().getIDTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            kw=(Token)match(input,EqualsSignEqualsSign,FOLLOW_EqualsSignEqualsSign_in_ruleDivider5972); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2359:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2360:2: (iv_ruleReference= ruleReference EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2361:2: iv_ruleReference= ruleReference EOF
            {
             newCompositeNode(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference6011);
            iv_ruleReference=ruleReference();

            state._fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference6021); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2368:1: ruleReference returns [EObject current=null] : (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon (this_ID_6= RULE_ID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )* otherlv_9= End otherlv_10= Ref ) ) ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token this_ID_6=null;
        Token this_NEWLINE_7=null;
        Token this_ID_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2371:28: ( (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon (this_ID_6= RULE_ID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )* otherlv_9= End otherlv_10= Ref ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2372:1: (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon (this_ID_6= RULE_ID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )* otherlv_9= End otherlv_10= Ref ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2372:1: (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon (this_ID_6= RULE_ID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )* otherlv_9= End otherlv_10= Ref ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2373:2: otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon (this_ID_6= RULE_ID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )* otherlv_9= End otherlv_10= Ref ) )
            {
            otherlv_0=(Token)match(input,Ref,FOLLOW_Ref_in_ruleReference6059); 

                	newLeafNode(otherlv_0, grammarAccess.getReferenceAccess().getRefKeyword_0());
                
            otherlv_1=(Token)match(input,Over,FOLLOW_Over_in_ruleReference6071); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceAccess().getOverKeyword_1());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2382:1: ( (otherlv_2= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2383:1: (otherlv_2= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2383:1: (otherlv_2= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2384:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference6090); 

            		newLeafNode(otherlv_2, grammarAccess.getReferenceAccess().getIdDefinitionCrossReference_2_0()); 
            	

            }


            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2395:2: (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==Comma) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2396:2: otherlv_3= Comma ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,Comma,FOLLOW_Comma_in_ruleReference6104); 

            	        	newLeafNode(otherlv_3, grammarAccess.getReferenceAccess().getCommaKeyword_3_0());
            	        
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2400:1: ( (otherlv_4= RULE_ID ) )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2401:1: (otherlv_4= RULE_ID )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2401:1: (otherlv_4= RULE_ID )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2402:3: otherlv_4= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getReferenceRule());
            	    	        }
            	            
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference6123); 

            	    		newLeafNode(otherlv_4, grammarAccess.getReferenceAccess().getIdsDefinitionCrossReference_3_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2413:4: ( (otherlv_5= Colon (this_ID_6= RULE_ID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )* otherlv_9= End otherlv_10= Ref ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==Colon) ) {
                alt42=1;
            }
            else if ( (LA42_0==End||LA42_0==RULE_NEWLINE) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2413:5: (otherlv_5= Colon (this_ID_6= RULE_ID )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2413:5: (otherlv_5= Colon (this_ID_6= RULE_ID )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2414:2: otherlv_5= Colon (this_ID_6= RULE_ID )*
                    {
                    otherlv_5=(Token)match(input,Colon,FOLLOW_Colon_in_ruleReference6140); 

                        	newLeafNode(otherlv_5, grammarAccess.getReferenceAccess().getColonKeyword_4_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2418:1: (this_ID_6= RULE_ID )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==RULE_ID) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2418:2: this_ID_6= RULE_ID
                    	    {
                    	    this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference6151); 
                    	     
                    	        newLeafNode(this_ID_6, grammarAccess.getReferenceAccess().getIDTerminalRuleCall_4_0_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2423:6: ( (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )* otherlv_9= End otherlv_10= Ref )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2423:6: ( (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )* otherlv_9= End otherlv_10= Ref )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2423:7: (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )* otherlv_9= End otherlv_10= Ref
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2423:7: (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==RULE_NEWLINE) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2423:8: this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )*
                    	    {
                    	    this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleReference6172); 
                    	     
                    	        newLeafNode(this_NEWLINE_7, grammarAccess.getReferenceAccess().getNEWLINETerminalRuleCall_4_1_0_0()); 
                    	        
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2427:1: (this_ID_8= RULE_ID )*
                    	    loop40:
                    	    do {
                    	        int alt40=2;
                    	        int LA40_0 = input.LA(1);

                    	        if ( (LA40_0==RULE_ID) ) {
                    	            alt40=1;
                    	        }


                    	        switch (alt40) {
                    	    	case 1 :
                    	    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2427:2: this_ID_8= RULE_ID
                    	    	    {
                    	    	    this_ID_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference6183); 
                    	    	     
                    	    	        newLeafNode(this_ID_8, grammarAccess.getReferenceAccess().getIDTerminalRuleCall_4_1_0_1()); 
                    	    	        

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop40;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop41;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,End,FOLLOW_End_in_ruleReference6199); 

                        	newLeafNode(otherlv_9, grammarAccess.getReferenceAccess().getEndKeyword_4_1_1());
                        
                    otherlv_10=(Token)match(input,Ref,FOLLOW_Ref_in_ruleReference6211); 

                        	newLeafNode(otherlv_10, grammarAccess.getReferenceAccess().getRefKeyword_4_1_2());
                        

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2449:1: entryRuleDelay returns [String current=null] : iv_ruleDelay= ruleDelay EOF ;
    public final String entryRuleDelay() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDelay = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2450:1: (iv_ruleDelay= ruleDelay EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2451:2: iv_ruleDelay= ruleDelay EOF
            {
             newCompositeNode(grammarAccess.getDelayRule()); 
            pushFollow(FOLLOW_ruleDelay_in_entryRuleDelay6248);
            iv_ruleDelay=ruleDelay();

            state._fsp--;

             current =iv_ruleDelay.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDelay6259); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2458:1: ruleDelay returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? ) ;
    public final AntlrDatatypeRuleToken ruleDelay() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2462:6: ( (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2463:1: (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2463:1: (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2464:2: kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )?
            {
            kw=(Token)match(input,FullStopFullStopFullStop,FOLLOW_FullStopFullStopFullStop_in_ruleDelay6297); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2469:1: ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==FullStopFullStopFullStop||LA44_0==RULE_ID) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2469:2: (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2469:2: (this_ID_1= RULE_ID )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==RULE_ID) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2469:7: this_ID_1= RULE_ID
                    	    {
                    	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDelay6314); 

                    	    		current.merge(this_ID_1);
                    	        
                    	     
                    	        newLeafNode(this_ID_1, grammarAccess.getDelayAccess().getIDTerminalRuleCall_1_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);

                    kw=(Token)match(input,FullStopFullStopFullStop,FOLLOW_FullStopFullStopFullStop_in_ruleDelay6334); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_1_1()); 
                        

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
    // $ANTLR end "ruleDelay"


    // $ANTLR start "entryRuleSpace"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2490:1: entryRuleSpace returns [String current=null] : iv_ruleSpace= ruleSpace EOF ;
    public final String entryRuleSpace() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSpace = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2491:1: (iv_ruleSpace= ruleSpace EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2492:2: iv_ruleSpace= ruleSpace EOF
            {
             newCompositeNode(grammarAccess.getSpaceRule()); 
            pushFollow(FOLLOW_ruleSpace_in_entryRuleSpace6376);
            iv_ruleSpace=ruleSpace();

            state._fsp--;

             current =iv_ruleSpace.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpace6387); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2499:1: ruleSpace returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine ) ) ;
    public final AntlrDatatypeRuleToken ruleSpace() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2503:6: ( (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2504:1: (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2504:1: (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==VerticalLineVerticalLineVerticalLine) ) {
                alt45=1;
            }
            else if ( (LA45_0==VerticalLineVerticalLine) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2505:2: kw= VerticalLineVerticalLineVerticalLine
                    {
                    kw=(Token)match(input,VerticalLineVerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLineVerticalLine_in_ruleSpace6425); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSpaceAccess().getVerticalLineVerticalLineVerticalLineKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2511:6: (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2511:6: (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2512:2: kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine
                    {
                    kw=(Token)match(input,VerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLine_in_ruleSpace6445); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSpaceAccess().getVerticalLineVerticalLineKeyword_1_0()); 
                        
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpace6460); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getSpaceAccess().getINTTerminalRuleCall_1_1()); 
                        
                    kw=(Token)match(input,VerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLine_in_ruleSpace6478); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2538:1: entryRuleHidefootbox returns [String current=null] : iv_ruleHidefootbox= ruleHidefootbox EOF ;
    public final String entryRuleHidefootbox() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHidefootbox = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2539:1: (iv_ruleHidefootbox= ruleHidefootbox EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2540:2: iv_ruleHidefootbox= ruleHidefootbox EOF
            {
             newCompositeNode(grammarAccess.getHidefootboxRule()); 
            pushFollow(FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox6519);
            iv_ruleHidefootbox=ruleHidefootbox();

            state._fsp--;

             current =iv_ruleHidefootbox.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHidefootbox6530); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2547:1: ruleHidefootbox returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Hide kw= Footbox ) ;
    public final AntlrDatatypeRuleToken ruleHidefootbox() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2551:6: ( (kw= Hide kw= Footbox ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2552:1: (kw= Hide kw= Footbox )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2552:1: (kw= Hide kw= Footbox )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2553:2: kw= Hide kw= Footbox
            {
            kw=(Token)match(input,Hide,FOLLOW_Hide_in_ruleHidefootbox6568); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getHidefootboxAccess().getHideKeyword_0()); 
                
            kw=(Token)match(input,Footbox,FOLLOW_Footbox_in_ruleHidefootbox6581); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getHidefootboxAccess().getFootboxKeyword_1()); 
                

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
    // $ANTLR end "ruleHidefootbox"


    // $ANTLR start "entryRuleActivate"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2572:1: entryRuleActivate returns [EObject current=null] : iv_ruleActivate= ruleActivate EOF ;
    public final EObject entryRuleActivate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActivate = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2573:2: (iv_ruleActivate= ruleActivate EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2574:2: iv_ruleActivate= ruleActivate EOF
            {
             newCompositeNode(grammarAccess.getActivateRule()); 
            pushFollow(FOLLOW_ruleActivate_in_entryRuleActivate6620);
            iv_ruleActivate=ruleActivate();

            state._fsp--;

             current =iv_ruleActivate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActivate6630); 

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
    // $ANTLR end "entryRuleActivate"


    // $ANTLR start "ruleActivate"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2581:1: ruleActivate returns [EObject current=null] : (otherlv_0= Activate ( ruleColor )? ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleActivate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2584:28: ( (otherlv_0= Activate ( ruleColor )? ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2585:1: (otherlv_0= Activate ( ruleColor )? ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2585:1: (otherlv_0= Activate ( ruleColor )? ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2586:2: otherlv_0= Activate ( ruleColor )? ( (lv_name_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,Activate,FOLLOW_Activate_in_ruleActivate6668); 

                	newLeafNode(otherlv_0, grammarAccess.getActivateAccess().getActivateKeyword_0());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2590:1: ( ruleColor )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==NumberSign) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2591:5: ruleColor
                    {
                     
                            newCompositeNode(grammarAccess.getActivateAccess().getColorParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleColor_in_ruleActivate6684);
                    ruleColor();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2598:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2599:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2599:1: (lv_name_2_0= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2600:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActivate6702); 

            			newLeafNode(lv_name_2_0, grammarAccess.getActivateAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getActivateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


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
    // $ANTLR end "ruleActivate"


    // $ANTLR start "entryRuleDeactivate"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2624:1: entryRuleDeactivate returns [EObject current=null] : iv_ruleDeactivate= ruleDeactivate EOF ;
    public final EObject entryRuleDeactivate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeactivate = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2625:2: (iv_ruleDeactivate= ruleDeactivate EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2626:2: iv_ruleDeactivate= ruleDeactivate EOF
            {
             newCompositeNode(grammarAccess.getDeactivateRule()); 
            pushFollow(FOLLOW_ruleDeactivate_in_entryRuleDeactivate6742);
            iv_ruleDeactivate=ruleDeactivate();

            state._fsp--;

             current =iv_ruleDeactivate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeactivate6752); 

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
    // $ANTLR end "entryRuleDeactivate"


    // $ANTLR start "ruleDeactivate"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2633:1: ruleDeactivate returns [EObject current=null] : ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleDeactivate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2636:28: ( ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2637:1: ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2637:1: ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2637:2: (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2637:2: (otherlv_0= Deactivate | otherlv_1= Destroy )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==Deactivate) ) {
                alt47=1;
            }
            else if ( (LA47_0==Destroy) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2638:2: otherlv_0= Deactivate
                    {
                    otherlv_0=(Token)match(input,Deactivate,FOLLOW_Deactivate_in_ruleDeactivate6791); 

                        	newLeafNode(otherlv_0, grammarAccess.getDeactivateAccess().getDeactivateKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2644:2: otherlv_1= Destroy
                    {
                    otherlv_1=(Token)match(input,Destroy,FOLLOW_Destroy_in_ruleDeactivate6809); 

                        	newLeafNode(otherlv_1, grammarAccess.getDeactivateAccess().getDestroyKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2648:2: ( (otherlv_2= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2649:1: (otherlv_2= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2649:1: (otherlv_2= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2650:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDeactivateRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeactivate6829); 

            		newLeafNode(otherlv_2, grammarAccess.getDeactivateAccess().getIdActivateCrossReference_1_0()); 
            	

            }


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
    // $ANTLR end "ruleDeactivate"


    // $ANTLR start "entryRuleParticipantCreation"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2669:1: entryRuleParticipantCreation returns [String current=null] : iv_ruleParticipantCreation= ruleParticipantCreation EOF ;
    public final String entryRuleParticipantCreation() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleParticipantCreation = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2670:1: (iv_ruleParticipantCreation= ruleParticipantCreation EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2671:2: iv_ruleParticipantCreation= ruleParticipantCreation EOF
            {
             newCompositeNode(grammarAccess.getParticipantCreationRule()); 
            pushFollow(FOLLOW_ruleParticipantCreation_in_entryRuleParticipantCreation6865);
            iv_ruleParticipantCreation=ruleParticipantCreation();

            state._fsp--;

             current =iv_ruleParticipantCreation.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParticipantCreation6876); 

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
    // $ANTLR end "entryRuleParticipantCreation"


    // $ANTLR start "ruleParticipantCreation"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2678:1: ruleParticipantCreation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Create this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleParticipantCreation() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2682:6: ( (kw= Create this_ID_1= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2683:1: (kw= Create this_ID_1= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2683:1: (kw= Create this_ID_1= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2684:2: kw= Create this_ID_1= RULE_ID
            {
            kw=(Token)match(input,Create,FOLLOW_Create_in_ruleParticipantCreation6914); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getParticipantCreationAccess().getCreateKeyword_0()); 
                
            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParticipantCreation6929); 

            		current.merge(this_ID_1);
                
             
                newLeafNode(this_ID_1, grammarAccess.getParticipantCreationAccess().getIDTerminalRuleCall_1()); 
                

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
    // $ANTLR end "ruleParticipantCreation"


    // $ANTLR start "entryRuleBox"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2704:1: entryRuleBox returns [EObject current=null] : iv_ruleBox= ruleBox EOF ;
    public final EObject entryRuleBox() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBox = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2705:2: (iv_ruleBox= ruleBox EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2706:2: iv_ruleBox= ruleBox EOF
            {
             newCompositeNode(grammarAccess.getBoxRule()); 
            pushFollow(FOLLOW_ruleBox_in_entryRuleBox6973);
            iv_ruleBox=ruleBox();

            state._fsp--;

             current =iv_ruleBox; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBox6983); 

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
    // $ANTLR end "entryRuleBox"


    // $ANTLR start "ruleBox"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2713:1: ruleBox returns [EObject current=null] : ( () otherlv_1= Box otherlv_2= QuotationMark (this_ID_3= RULE_ID )* otherlv_4= QuotationMark ( ruleColor )? this_NEWLINE_6= RULE_NEWLINE ( ( (lv_definitions_7_0= ruleDefinition ) )? this_NEWLINE_8= RULE_NEWLINE )* otherlv_9= End otherlv_10= Box ) ;
    public final EObject ruleBox() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token this_ID_3=null;
        Token otherlv_4=null;
        Token this_NEWLINE_6=null;
        Token this_NEWLINE_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_definitions_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2716:28: ( ( () otherlv_1= Box otherlv_2= QuotationMark (this_ID_3= RULE_ID )* otherlv_4= QuotationMark ( ruleColor )? this_NEWLINE_6= RULE_NEWLINE ( ( (lv_definitions_7_0= ruleDefinition ) )? this_NEWLINE_8= RULE_NEWLINE )* otherlv_9= End otherlv_10= Box ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2717:1: ( () otherlv_1= Box otherlv_2= QuotationMark (this_ID_3= RULE_ID )* otherlv_4= QuotationMark ( ruleColor )? this_NEWLINE_6= RULE_NEWLINE ( ( (lv_definitions_7_0= ruleDefinition ) )? this_NEWLINE_8= RULE_NEWLINE )* otherlv_9= End otherlv_10= Box )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2717:1: ( () otherlv_1= Box otherlv_2= QuotationMark (this_ID_3= RULE_ID )* otherlv_4= QuotationMark ( ruleColor )? this_NEWLINE_6= RULE_NEWLINE ( ( (lv_definitions_7_0= ruleDefinition ) )? this_NEWLINE_8= RULE_NEWLINE )* otherlv_9= End otherlv_10= Box )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2717:2: () otherlv_1= Box otherlv_2= QuotationMark (this_ID_3= RULE_ID )* otherlv_4= QuotationMark ( ruleColor )? this_NEWLINE_6= RULE_NEWLINE ( ( (lv_definitions_7_0= ruleDefinition ) )? this_NEWLINE_8= RULE_NEWLINE )* otherlv_9= End otherlv_10= Box
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2717:2: ()
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2718:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBoxAccess().getBoxAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,Box,FOLLOW_Box_in_ruleBox7030); 

                	newLeafNode(otherlv_1, grammarAccess.getBoxAccess().getBoxKeyword_1());
                
            otherlv_2=(Token)match(input,QuotationMark,FOLLOW_QuotationMark_in_ruleBox7042); 

                	newLeafNode(otherlv_2, grammarAccess.getBoxAccess().getQuotationMarkKeyword_2());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2733:1: (this_ID_3= RULE_ID )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_ID) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2733:2: this_ID_3= RULE_ID
            	    {
            	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBox7053); 
            	     
            	        newLeafNode(this_ID_3, grammarAccess.getBoxAccess().getIDTerminalRuleCall_3()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            otherlv_4=(Token)match(input,QuotationMark,FOLLOW_QuotationMark_in_ruleBox7067); 

                	newLeafNode(otherlv_4, grammarAccess.getBoxAccess().getQuotationMarkKeyword_4());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2742:1: ( ruleColor )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==NumberSign) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2743:5: ruleColor
                    {
                     
                            newCompositeNode(grammarAccess.getBoxAccess().getColorParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleColor_in_ruleBox7083);
                    ruleColor();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            this_NEWLINE_6=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleBox7095); 
             
                newLeafNode(this_NEWLINE_6, grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_6()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2754:1: ( ( (lv_definitions_7_0= ruleDefinition ) )? this_NEWLINE_8= RULE_NEWLINE )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==Participant||LA51_0==Boundary||LA51_0==Database||LA51_0==Control||LA51_0==Entity||LA51_0==Actor||LA51_0==RULE_NEWLINE) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2754:2: ( (lv_definitions_7_0= ruleDefinition ) )? this_NEWLINE_8= RULE_NEWLINE
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2754:2: ( (lv_definitions_7_0= ruleDefinition ) )?
            	    int alt50=2;
            	    int LA50_0 = input.LA(1);

            	    if ( (LA50_0==Participant||LA50_0==Boundary||LA50_0==Database||LA50_0==Control||LA50_0==Entity||LA50_0==Actor) ) {
            	        alt50=1;
            	    }
            	    switch (alt50) {
            	        case 1 :
            	            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2755:1: (lv_definitions_7_0= ruleDefinition )
            	            {
            	            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2755:1: (lv_definitions_7_0= ruleDefinition )
            	            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2756:3: lv_definitions_7_0= ruleDefinition
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getBoxAccess().getDefinitionsDefinitionParserRuleCall_7_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleDefinition_in_ruleBox7116);
            	            lv_definitions_7_0=ruleDefinition();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getBoxRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"definitions",
            	                    		lv_definitions_7_0, 
            	                    		"Definition");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }
            	            break;

            	    }

            	    this_NEWLINE_8=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleBox7128); 
            	     
            	        newLeafNode(this_NEWLINE_8, grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_7_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

            otherlv_9=(Token)match(input,End,FOLLOW_End_in_ruleBox7142); 

                	newLeafNode(otherlv_9, grammarAccess.getBoxAccess().getEndKeyword_8());
                
            otherlv_10=(Token)match(input,Box,FOLLOW_Box_in_ruleBox7154); 

                	newLeafNode(otherlv_10, grammarAccess.getBoxAccess().getBoxKeyword_9());
                

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
    // $ANTLR end "ruleBox"

    // Delegated rules


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\u009a\uffff";
    static final String DFA8_eofS =
        "\u009a\uffff";
    static final String DFA8_minS =
        "\1\u00bf\1\u00c6\1\uffff\1\u00c1\1\u00be\1\4\u0091\u00c0\1\u00ba"+
        "\2\uffff";
    static final String DFA8_maxS =
        "\2\u00c6\1\uffff\1\u00c1\1\u00be\1\u00b0\u0091\u00c0\1\u00c6\2"+
        "\uffff";
    static final String DFA8_acceptS =
        "\2\uffff\1\3\u0095\uffff\1\2\1\1";
    static final String DFA8_specialS =
        "\u009a\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1\6\uffff\1\2",
            "\1\3",
            "",
            "\1\4",
            "\1\5",
            "\1\114\1\143\1\135\1\142\1\144\1\145\1\16\1\27\1\43\1\124"+
            "\1\125\1\126\1\141\1\35\1\50\1\51\1\52\1\53\1\106\1\122\1\161"+
            "\1\163\1\164\1\7\1\47\1\110\1\123\1\137\1\140\1\146\1\42\1\57"+
            "\1\64\1\65\1\75\1\121\1\127\1\152\1\177\1\u008a\1\u0096\1\uffff"+
            "\1\11\1\20\1\24\1\44\1\54\1\55\1\62\1\70\1\112\1\116\1\136\1"+
            "\165\1\172\1\u0081\1\u0094\2\uffff\1\6\1\22\1\23\1\25\1\37\1"+
            "\41\1\46\1\63\1\67\1\72\1\101\1\107\1\111\1\113\1\115\1\117"+
            "\1\120\1\131\1\147\1\150\1\156\1\157\1\162\1\166\1\175\1\176"+
            "\1\u0086\1\u0087\1\u0088\1\u008b\1\u0090\1\uffff\1\30\1\33\1"+
            "\34\1\36\1\40\1\56\1\77\1\105\1\151\1\u0082\4\uffff\1\31\1\45"+
            "\1\60\1\61\1\66\1\100\1\133\1\154\1\u0085\1\u008e\4\uffff\1"+
            "\14\1\102\1\134\1\160\1\173\1\u0080\1\u0083\1\u0084\1\u008f"+
            "\1\u0091\1\u0095\4\uffff\1\12\1\13\1\15\1\21\1\26\1\74\1\103"+
            "\1\104\1\132\1\155\1\u0092\1\u0093\5\uffff\1\10\1\17\1\32\1"+
            "\71\1\73\1\76\1\130\1\153\1\167\1\170\1\171\1\u0089\1\u008d"+
            "\7\uffff\1\174\1\u008c",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u0099\13\uffff\1\u0098",
            "",
            ""
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
            return "595:1: ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma ruleColor otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma ruleColor otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID )";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_ruleModel122 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDiagram_in_entryRuleDiagram157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDiagram167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_START_in_ruleDiagram212 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleDiagram222 = new BitSet(new long[]{0x6000200000000000L,0x05801E0000000000L,0x12F65A0005C00380L,0x0000000000000068L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleDiagram242 = new BitSet(new long[]{0x6000200000000000L,0x05801E0000000000L,0x12F65A0005C00380L,0x0000000000000068L});
    public static final BitSet FOLLOW_RULE_END_in_ruleDiagram254 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleDiagram265 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_ruleInstruction359 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleInstruction387 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleColor_in_ruleInstruction403 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_ruleInstruction427 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleTitle_in_ruleInstruction448 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleLegend_in_ruleInstruction469 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleNewpage_in_ruleInstruction490 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleAltElse_in_ruleInstruction517 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_ruleInstruction544 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleNote_in_ruleInstruction571 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleDivider_in_ruleInstruction592 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleReference_in_ruleInstruction619 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleDelay_in_ruleInstruction640 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleSpace_in_ruleInstruction661 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_ruleInstruction682 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleActivate_in_ruleInstruction709 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleDeactivate_in_ruleInstruction736 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleParticipantCreation_in_ruleInstruction757 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleBox_in_ruleInstruction784 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleInstruction796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_entryRuleArrow830 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrow840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArrow882 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_SEQUENCE_in_ruleArrow898 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArrow914 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_Colon_in_ruleArrow933 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArrow944 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Actor_in_ruleDefinition1031 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Boundary_in_ruleDefinition1073 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Control_in_ruleDefinition1115 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Entity_in_ruleDefinition1157 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Database_in_ruleDefinition1199 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Participant_in_ruleDefinition1241 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1257 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_LessThanSignLessThanSign_in_ruleDefinition1276 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x8000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LeftParenthesis_in_ruleDefinition1290 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1300 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_ruleDefinition1312 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_ruleColor_in_ruleDefinition1327 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RightParenthesis_in_ruleDefinition1339 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_LeftParenthesis_in_ruleDefinition1359 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1369 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_ruleDefinition1381 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_ruleColor_in_ruleDefinition1396 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RightParenthesis_in_ruleDefinition1408 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1418 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1435 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_GreaterThanSignGreaterThanSign_in_ruleDefinition1448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber1486 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAutoNumber1497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Autonumber_in_ruleAutoNumber1535 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAutoNumber1551 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAutoNumber1572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_entryRuleColor1621 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColor1632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NumberSign_in_ruleColor1670 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000180FFF83FFC3FL});
    public static final BitSet FOLLOW_AliceBlue_in_ruleColor1684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AntiqueWhite_in_ruleColor1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Aqua_in_ruleColor1722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Aquamarine_in_ruleColor1741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Azure_in_ruleColor1760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Beige_in_ruleColor1779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bisque_in_ruleColor1798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Black_in_ruleColor1817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BlanchedAlmond_in_ruleColor1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Blue_in_ruleColor1855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BlueViolet_in_ruleColor1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Brown_in_ruleColor1893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BurlyWood_in_ruleColor1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CadetBlue_in_ruleColor1931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Chartreuse_in_ruleColor1950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Chocolate_in_ruleColor1969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Coral_in_ruleColor1988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CornflowerBlue_in_ruleColor2007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Cornsilk_in_ruleColor2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Crimson_in_ruleColor2045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Cyan_in_ruleColor2064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkBlue_in_ruleColor2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkCyan_in_ruleColor2102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGoldenRod_in_ruleColor2121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGray_in_ruleColor2140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGreen_in_ruleColor2159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGrey_in_ruleColor2178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkKhaki_in_ruleColor2197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkMagenta_in_ruleColor2216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkOliveGreen_in_ruleColor2235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkOrchid_in_ruleColor2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkRed_in_ruleColor2273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSalmo_in_ruleColor2292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSeaGreen_in_ruleColor2311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSlateBlue_in_ruleColor2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSlateGray_in_ruleColor2349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSlateGrey_in_ruleColor2368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkTurquoise_in_ruleColor2387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkViolet_in_ruleColor2406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Darkorange_in_ruleColor2425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DeepPink_in_ruleColor2444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DeepSkyBlue_in_ruleColor2463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DimGray_in_ruleColor2482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DimGrey_in_ruleColor2501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DodgerBlue_in_ruleColor2520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FireBrick_in_ruleColor2539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FloralWhite_in_ruleColor2558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ForestGreen_in_ruleColor2577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Fuchsia_in_ruleColor2596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Gainsboro_in_ruleColor2615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GhostWhite_in_ruleColor2634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Gold_in_ruleColor2653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GoldenRod_in_ruleColor2672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Gray_in_ruleColor2691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Green_in_ruleColor2710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GreenYellow_in_ruleColor2729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Grey_in_ruleColor2748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HoneyDew_in_ruleColor2767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HotPink_in_ruleColor2786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IndianRed_in_ruleColor2805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Indigo_in_ruleColor2824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ivory_in_ruleColor2843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Khaki_in_ruleColor2862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lavender_in_ruleColor2881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LavenderBlush_in_ruleColor2900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LawnGreen_in_ruleColor2919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LemonChiffon_in_ruleColor2938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightBlue_in_ruleColor2957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightCoral_in_ruleColor2976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightCyan_in_ruleColor2995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGoldenRodYellow_in_ruleColor3014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGray_in_ruleColor3033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGreen_in_ruleColor3052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGrey_in_ruleColor3071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightPink_in_ruleColor3090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSalmon_in_ruleColor3109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSeaGreen_in_ruleColor3128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSkyBlue_in_ruleColor3147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSlateGray_in_ruleColor3166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSlateGrey_in_ruleColor3185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSteelBlue_in_ruleColor3204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightYellow_in_ruleColor3223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lime_in_ruleColor3242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LimeGreen_in_ruleColor3261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Linen_in_ruleColor3280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Magenta_in_ruleColor3299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Maroon_in_ruleColor3318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumAquaMarine_in_ruleColor3337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumBlue_in_ruleColor3356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumOrchid_in_ruleColor3375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumPurple_in_ruleColor3394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumSeaGreen_in_ruleColor3413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumSlateBlue_in_ruleColor3432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumSpringGreen_in_ruleColor3451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumTurquoise_in_ruleColor3470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumVioletRed_in_ruleColor3489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MidnightBlue_in_ruleColor3508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MintCream_in_ruleColor3527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MistyRose_in_ruleColor3546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Moccasin_in_ruleColor3565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NavajoWhite_in_ruleColor3584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Navy_in_ruleColor3603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OldLace_in_ruleColor3622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Olive_in_ruleColor3641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OliveDrab_in_ruleColor3660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OrangeRed_in_ruleColor3679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Orchid_in_ruleColor3698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleGoldenRod_in_ruleColor3717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleGreen_in_ruleColor3736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleTurquoise_in_ruleColor3755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleVioletRed_in_ruleColor3774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PapayaWhip_in_ruleColor3793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PeachPuff_in_ruleColor3812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Peru_in_ruleColor3831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Pink_in_ruleColor3850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plum_in_ruleColor3869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PowderBlue_in_ruleColor3888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Purple_in_ruleColor3907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Red_in_ruleColor3926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RosyBrown_in_ruleColor3945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RoyalBlue_in_ruleColor3964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SaddleBrown_in_ruleColor3983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Salmon_in_ruleColor4002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SandyBrown_in_ruleColor4021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SeaGreen_in_ruleColor4040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Sienna_in_ruleColor4059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Silver_in_ruleColor4078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SkyBlue_in_ruleColor4097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SlateBlue_in_ruleColor4116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SlateGray_in_ruleColor4135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SlateGrey_in_ruleColor4154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Snow_in_ruleColor4173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SpringGreen_in_ruleColor4192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SteelBlue_in_ruleColor4211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Tan_in_ruleColor4230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Teal_in_ruleColor4249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Thistle_in_ruleColor4268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Tomato_in_ruleColor4287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Turquoise_in_ruleColor4306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Violet_in_ruleColor4325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Wheat_in_ruleColor4344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_White_in_ruleColor4363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WhiteSmoke_in_ruleColor4382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Yellow_in_ruleColor4401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_YellowGreen_in_ruleColor4420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_entryRuleTitle4461 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTitle4472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Title_in_ruleTitle4510 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTitle4526 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleLegend_in_entryRuleLegend4573 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLegend4584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Legend_in_ruleLegend4622 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000040002000040L,0x0000000000000008L});
    public static final BitSet FOLLOW_Right_in_ruleLegend4636 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_Left_in_ruleLegend4655 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_Center_in_ruleLegend4674 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleLegend4692 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLegend4713 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_Endlegend_in_ruleLegend4735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_entryRuleNewpage4775 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNewpage4786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Newpage_in_ruleNewpage4824 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNewpage4840 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleAltElse_in_entryRuleAltElse4886 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAltElse4896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Alt_in_ruleAltElse4943 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAltElse4954 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleAltElse4966 = new BitSet(new long[]{0x6000200000000000L,0x05801E0000000000L,0x12FE5B0005C00380L,0x0000000000000048L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleAltElse4986 = new BitSet(new long[]{0x6000200000000000L,0x05801E0000000000L,0x12FE5B0005C00380L,0x0000000000000048L});
    public static final BitSet FOLLOW_ruleElse_in_ruleAltElse5008 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008010000000000L});
    public static final BitSet FOLLOW_End_in_ruleAltElse5022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElse_in_entryRuleElse5056 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElse5066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Else_in_ruleElse5113 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleElse5124 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleElse5136 = new BitSet(new long[]{0x6000200000000002L,0x05801E0000000000L,0x12F65A0005C00380L,0x0000000000000048L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleElse5156 = new BitSet(new long[]{0x6000200000000002L,0x05801E0000000000L,0x12F65A0005C00380L,0x0000000000000048L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages5192 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroupingMessages5202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Opt_in_ruleGroupingMessages5250 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_Loop_in_ruleGroupingMessages5268 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_Par_in_ruleGroupingMessages5286 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_Break_in_ruleGroupingMessages5304 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_Critical_in_ruleGroupingMessages5322 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_Group_in_ruleGroupingMessages5340 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGroupingMessages5352 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleGroupingMessages5364 = new BitSet(new long[]{0x6000200000000000L,0x05801E0000000000L,0x12FE5A0005C00380L,0x0000000000000048L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleGroupingMessages5384 = new BitSet(new long[]{0x6000200000000000L,0x05801E0000000000L,0x12FE5A0005C00380L,0x0000000000000048L});
    public static final BitSet FOLLOW_End_in_ruleGroupingMessages5398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNote_in_entryRuleNote5432 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNote5442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Note_in_ruleNote5489 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000240002000000L});
    public static final BitSet FOLLOW_Right_in_ruleNote5503 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4800000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_Of_in_ruleNote5516 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote5535 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x000000000000000EL});
    public static final BitSet FOLLOW_Comma_in_ruleNote5549 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote5568 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x000000000000000EL});
    public static final BitSet FOLLOW_Left_in_ruleNote5593 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4800000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_Of_in_ruleNote5606 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote5625 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x000000000000000EL});
    public static final BitSet FOLLOW_Comma_in_ruleNote5639 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote5658 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x000000000000000EL});
    public static final BitSet FOLLOW_Over_in_ruleNote5683 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote5702 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x000000000000000EL});
    public static final BitSet FOLLOW_Comma_in_ruleNote5716 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote5735 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleColor_in_ruleNote5756 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_Colon_in_ruleNote5772 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote5782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleNote5801 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote5812 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleNote5826 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_End_in_ruleNote5838 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_Note_in_ruleNote5850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDivider_in_entryRuleDivider5887 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDivider5898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EqualsSignEqualsSign_in_ruleDivider5936 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDivider5952 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_EqualsSignEqualsSign_in_ruleDivider5972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference6011 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference6021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_ruleReference6059 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_Over_in_ruleReference6071 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference6090 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L,0x000000000000000EL});
    public static final BitSet FOLLOW_Comma_in_ruleReference6104 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference6123 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L,0x000000000000000EL});
    public static final BitSet FOLLOW_Colon_in_ruleReference6140 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference6151 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleReference6172 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference6183 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_End_in_ruleReference6199 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_Ref_in_ruleReference6211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDelay_in_entryRuleDelay6248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDelay6259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStopFullStopFullStop_in_ruleDelay6297 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000400000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDelay6314 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000400000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_FullStopFullStopFullStop_in_ruleDelay6334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpace_in_entryRuleSpace6376 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpace6387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLineVerticalLine_in_ruleSpace6425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLine_in_ruleSpace6445 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpace6460 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_VerticalLineVerticalLine_in_ruleSpace6478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox6519 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHidefootbox6530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hide_in_ruleHidefootbox6568 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_Footbox_in_ruleHidefootbox6581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActivate_in_entryRuleActivate6620 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActivate6630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Activate_in_ruleActivate6668 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleColor_in_ruleActivate6684 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActivate6702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeactivate_in_entryRuleDeactivate6742 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeactivate6752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Deactivate_in_ruleDeactivate6791 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_Destroy_in_ruleDeactivate6809 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeactivate6829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParticipantCreation_in_entryRuleParticipantCreation6865 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParticipantCreation6876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_ruleParticipantCreation6914 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParticipantCreation6929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBox_in_entryRuleBox6973 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBox6983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Box_in_ruleBox7030 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_QuotationMark_in_ruleBox7042 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBox7053 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_QuotationMark_in_ruleBox7067 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleColor_in_ruleBox7083 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleBox7095 = new BitSet(new long[]{0x0000200000000000L,0x0080140000000000L,0x0008000000400100L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleBox7116 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleBox7128 = new BitSet(new long[]{0x0000200000000000L,0x0080140000000000L,0x0008000000400100L,0x0000000000000008L});
    public static final BitSet FOLLOW_End_in_ruleBox7142 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_Box_in_ruleBox7154 = new BitSet(new long[]{0x0000000000000002L});

}