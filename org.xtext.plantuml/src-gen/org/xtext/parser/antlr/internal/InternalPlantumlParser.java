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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LightGoldenRodYellow", "MediumSpringGreen", "MediumAquaMarine", "MediumSlateBlue", "MediumTurquoise", "MediumVioletRed", "BlanchedAlmond", "CornflowerBlue", "DarkOliveGreen", "LightSlateGray", "LightSlateGrey", "LightSteelBlue", "MediumSeaGreen", "DarkGoldenRod", "DarkSlateBlue", "DarkSlateGray", "DarkSlateGrey", "DarkTurquoise", "LavenderBlush", "LightSeaGreen", "PaleGoldenRod", "PaleTurquoise", "PaleVioletRed", "AntiqueWhite", "DarkSeaGreen", "LemonChiffon", "LightSkyBlue", "MediumOrchid", "MediumPurple", "MidnightBlue", "DarkMagenta", "DeepSkyBlue", "FloralWhite", "ForestGreen", "GreenYellow", "LightSalmon", "LightYellow", "NavajoWhite", "SaddleBrown", "SpringGreen", "YellowGreen", "Participant", "Aquamarine", "BlueViolet", "Chartreuse", "DarkOrchid", "DarkViolet", "Darkorange", "DodgerBlue", "GhostWhite", "LightCoral", "LightGreen", "MediumBlue", "PapayaWhip", "PowderBlue", "SandyBrown", "WhiteSmoke", "Autonumber", "Deactivate", "AliceBlue", "BurlyWood", "CadetBlue", "Chocolate", "DarkGreen", "DarkKhaki", "DarkSalmo", "FireBrick", "Gainsboro", "GoldenRod", "IndianRed", "LawnGreen", "LightBlue", "LightCyan", "LightGray", "LightGrey", "LightPink", "LimeGreen", "MintCream", "MistyRose", "OliveDrab", "OrangeRed", "PaleGreen", "PeachPuff", "RosyBrown", "RoyalBlue", "SlateBlue", "SlateGray", "SlateGrey", "SteelBlue", "Turquoise", "Endlegend", "Cornsilk", "DarkBlue", "DarkCyan", "DarkGray", "DarkGrey", "DeepPink", "HoneyDew", "Lavender", "Moccasin", "SeaGreen", "Activate", "Boundary", "Critical", "Database", "Crimson", "DarkRed", "DimGray", "DimGrey", "Fuchsia", "HotPink", "Magenta", "OldLace", "SkyBlue", "Thistle", "Control", "Destroy", "Footbox", "Newpage", "Bisque", "Indigo", "Maroon", "Orchid", "Purple", "Salmon", "Sienna", "Silver", "Tomato", "Violet", "Yellow", "Center", "Create", "Entity", "Legend", "Azure", "Beige", "Black", "Brown", "Coral", "Green", "Ivory", "Khaki", "Linen", "Olive", "Wheat", "White", "Actor", "Break", "Group", "Right", "Title", "Aqua", "Blue", "Cyan", "Gold", "Gray", "Grey", "Lime", "Navy", "Peru", "Pink", "Plum", "Snow", "Teal", "Else", "Hide", "Left", "Loop", "Note", "Over", "FullStopFullStopFullStop", "Red", "Tan", "Alt", "Box", "End", "Opt", "Par", "Ref", "VerticalLineVerticalLineVerticalLine", "LessThanSignLessThanSign", "EqualsSignEqualsSign", "GreaterThanSignGreaterThanSign", "Of", "VerticalLineVerticalLine", "QuotationMark", "NumberSign", "LeftParenthesis", "RightParenthesis", "Comma", "HyphenMinus", "FullStop", "Colon", "LessThanSign", "EqualsSign", "GreaterThanSign", "RULE_NEWLINE", "RULE_START", "RULE_END", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_SEQUENCE", "RULE_HEXCODE", "RULE_INT", "RULE_ID", "RULE_WS", "RULE_ANY_OTHER"
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
    public static final int LessThanSign=197;
    public static final int DarkGrey=99;
    public static final int DodgerBlue=52;
    public static final int Aquamarine=46;
    public static final int Beige=139;
    public static final int Actor=150;
    public static final int OliveDrab=83;
    public static final int GreaterThanSign=199;
    public static final int Violet=132;
    public static final int LimeGreen=80;
    public static final int RULE_ID=208;
    public static final int PowderBlue=58;
    public static final int Magenta=115;
    public static final int DarkTurquoise=21;
    public static final int IndianRed=73;
    public static final int LightGray=77;
    public static final int PeachPuff=86;
    public static final int Participant=45;
    public static final int Activate=105;
    public static final int RULE_INT=207;
    public static final int Note=172;
    public static final int LightBlue=75;
    public static final int RULE_HEXCODE=206;
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
    public static final int FullStop=195;
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
    public static final int RULE_END=202;
    public static final int Aqua=155;
    public static final int RULE_START=201;
    public static final int Bisque=123;
    public static final int Footbox=121;
    public static final int MediumBlue=56;
    public static final int RULE_SL_COMMENT=204;
    public static final int BlueViolet=47;
    public static final int Over=173;
    public static final int Control=119;
    public static final int Lavender=102;
    public static final int CornflowerBlue=11;
    public static final int Colon=196;
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
    public static final int RULE_ML_COMMENT=203;
    public static final int Peru=163;
    public static final int RosyBrown=87;
    public static final int Hide=169;
    public static final int FireBrick=70;
    public static final int Legend=137;
    public static final int VerticalLineVerticalLine=188;
    public static final int RULE_NEWLINE=200;
    public static final int Right=153;
    public static final int Newpage=122;
    public static final int Comma=193;
    public static final int HyphenMinus=194;
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
    public static final int RULE_SEQUENCE=205;
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
    public static final int EqualsSign=198;
    public static final int Destroy=120;
    public static final int Create=135;
    public static final int LightSteelBlue=15;
    public static final int GhostWhite=53;
    public static final int SteelBlue=92;
    public static final int PaleTurquoise=25;
    public static final int RULE_WS=209;
    public static final int RULE_ANY_OTHER=210;
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
    		return "Plantuml";	
    	} 
    	   	   	
    	@Override
    	protected PlantumlGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRulePlantuml"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:61:1: entryRulePlantuml returns [EObject current=null] : iv_rulePlantuml= rulePlantuml EOF ;
    public final EObject entryRulePlantuml() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlantuml = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:62:2: (iv_rulePlantuml= rulePlantuml EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:63:2: iv_rulePlantuml= rulePlantuml EOF
            {
             newCompositeNode(grammarAccess.getPlantumlRule()); 
            pushFollow(FOLLOW_rulePlantuml_in_entryRulePlantuml67);
            iv_rulePlantuml=rulePlantuml();

            state._fsp--;

             current =iv_rulePlantuml; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePlantuml77); 

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
    // $ANTLR end "entryRulePlantuml"


    // $ANTLR start "rulePlantuml"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:70:1: rulePlantuml returns [EObject current=null] : ( (lv_diagrams_0_0= ruleDiagram ) )* ;
    public final EObject rulePlantuml() throws RecognitionException {
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
            	     
            	    	        newCompositeNode(grammarAccess.getPlantumlAccess().getDiagramsDiagramParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDiagram_in_rulePlantuml122);
            	    lv_diagrams_0_0=ruleDiagram();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPlantumlRule());
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
    // $ANTLR end "rulePlantuml"


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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:109:1: ruleDiagram returns [EObject current=null] : (this_START_0= RULE_START this_NEWLINE_1= RULE_NEWLINE ( (lv_instructions_2_0= ruleInstruction ) )* this_END_3= RULE_END (this_NEWLINE_4= RULE_NEWLINE )* ) ;
    public final EObject ruleDiagram() throws RecognitionException {
        EObject current = null;

        Token this_START_0=null;
        Token this_NEWLINE_1=null;
        Token this_END_3=null;
        Token this_NEWLINE_4=null;
        EObject lv_instructions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:112:28: ( (this_START_0= RULE_START this_NEWLINE_1= RULE_NEWLINE ( (lv_instructions_2_0= ruleInstruction ) )* this_END_3= RULE_END (this_NEWLINE_4= RULE_NEWLINE )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:113:1: (this_START_0= RULE_START this_NEWLINE_1= RULE_NEWLINE ( (lv_instructions_2_0= ruleInstruction ) )* this_END_3= RULE_END (this_NEWLINE_4= RULE_NEWLINE )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:113:1: (this_START_0= RULE_START this_NEWLINE_1= RULE_NEWLINE ( (lv_instructions_2_0= ruleInstruction ) )* this_END_3= RULE_END (this_NEWLINE_4= RULE_NEWLINE )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:113:2: this_START_0= RULE_START this_NEWLINE_1= RULE_NEWLINE ( (lv_instructions_2_0= ruleInstruction ) )* this_END_3= RULE_END (this_NEWLINE_4= RULE_NEWLINE )*
            {
            this_START_0=(Token)match(input,RULE_START,FOLLOW_RULE_START_in_ruleDiagram203); 
             
                newLeafNode(this_START_0, grammarAccess.getDiagramAccess().getSTARTTerminalRuleCall_0()); 
                
            this_NEWLINE_1=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleDiagram213); 
             
                newLeafNode(this_NEWLINE_1, grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_1()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:121:1: ( (lv_instructions_2_0= ruleInstruction ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Participant||(LA2_0>=Autonumber && LA2_0<=Deactivate)||LA2_0==Endlegend||(LA2_0>=Activate && LA2_0<=Database)||(LA2_0>=Control && LA2_0<=Newpage)||(LA2_0>=Center && LA2_0<=Legend)||(LA2_0>=Actor && LA2_0<=Title)||(LA2_0>=Else && LA2_0<=Over)||LA2_0==FullStopFullStopFullStop||(LA2_0>=Alt && LA2_0<=VerticalLineVerticalLineVerticalLine)||LA2_0==EqualsSignEqualsSign||(LA2_0>=Of && LA2_0<=VerticalLineVerticalLine)||(LA2_0>=NumberSign && LA2_0<=RULE_NEWLINE)||(LA2_0>=RULE_INT && LA2_0<=RULE_ID)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:122:1: (lv_instructions_2_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:122:1: (lv_instructions_2_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:123:3: lv_instructions_2_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleDiagram233);
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

            this_END_3=(Token)match(input,RULE_END,FOLLOW_RULE_END_in_ruleDiagram245); 
             
                newLeafNode(this_END_3, grammarAccess.getDiagramAccess().getENDTerminalRuleCall_3()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:143:1: (this_NEWLINE_4= RULE_NEWLINE )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_NEWLINE) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:143:2: this_NEWLINE_4= RULE_NEWLINE
            	    {
            	    this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleDiagram256); 
            	     
            	        newLeafNode(this_NEWLINE_4, grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_4()); 
            	        

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:155:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:156:2: (iv_ruleInstruction= ruleInstruction EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:157:2: iv_ruleInstruction= ruleInstruction EOF
            {
             newCompositeNode(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_ruleInstruction_in_entryRuleInstruction292);
            iv_ruleInstruction=ruleInstruction();

            state._fsp--;

             current =iv_ruleInstruction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstruction302); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:164:1: ruleInstruction returns [EObject current=null] : ( (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition ( ruleColors )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_7= ruleAltElse | this_GroupingMessages_8= ruleGroupingMessages | this_Note_9= ruleNote | ruleDivider | this_Reference_11= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_15= ruleActivate | this_Deactivate_16= ruleDeactivate | ruleParticipantCreation | this_Box_18= ruleBox )? this_NEWLINE_19= RULE_NEWLINE ) ;
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:167:28: ( ( (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition ( ruleColors )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_7= ruleAltElse | this_GroupingMessages_8= ruleGroupingMessages | this_Note_9= ruleNote | ruleDivider | this_Reference_11= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_15= ruleActivate | this_Deactivate_16= ruleDeactivate | ruleParticipantCreation | this_Box_18= ruleBox )? this_NEWLINE_19= RULE_NEWLINE ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:168:1: ( (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition ( ruleColors )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_7= ruleAltElse | this_GroupingMessages_8= ruleGroupingMessages | this_Note_9= ruleNote | ruleDivider | this_Reference_11= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_15= ruleActivate | this_Deactivate_16= ruleDeactivate | ruleParticipantCreation | this_Box_18= ruleBox )? this_NEWLINE_19= RULE_NEWLINE )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:168:1: ( (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition ( ruleColors )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_7= ruleAltElse | this_GroupingMessages_8= ruleGroupingMessages | this_Note_9= ruleNote | ruleDivider | this_Reference_11= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_15= ruleActivate | this_Deactivate_16= ruleDeactivate | ruleParticipantCreation | this_Box_18= ruleBox )? this_NEWLINE_19= RULE_NEWLINE )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:168:2: (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition ( ruleColors )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_7= ruleAltElse | this_GroupingMessages_8= ruleGroupingMessages | this_Note_9= ruleNote | ruleDivider | this_Reference_11= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_15= ruleActivate | this_Deactivate_16= ruleDeactivate | ruleParticipantCreation | this_Box_18= ruleBox )? this_NEWLINE_19= RULE_NEWLINE
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:168:2: (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition ( ruleColors )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_7= ruleAltElse | this_GroupingMessages_8= ruleGroupingMessages | this_Note_9= ruleNote | ruleDivider | this_Reference_11= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_15= ruleActivate | this_Deactivate_16= ruleDeactivate | ruleParticipantCreation | this_Box_18= ruleBox )?
            int alt5=19;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:169:5: this_Arrow_0= ruleArrow
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getArrowParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_ruleArrow_in_ruleInstruction350);
                    this_Arrow_0=ruleArrow();

                    state._fsp--;


                            current = this_Arrow_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:178:6: (this_Definition_1= ruleDefinition ( ruleColors )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:178:6: (this_Definition_1= ruleDefinition ( ruleColors )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:179:5: this_Definition_1= ruleDefinition ( ruleColors )?
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_0_1_0()); 
                        
                    pushFollow(FOLLOW_ruleDefinition_in_ruleInstruction378);
                    this_Definition_1=ruleDefinition();

                    state._fsp--;


                            current = this_Definition_1;
                            afterParserOrEnumRuleCall();
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:187:1: ( ruleColors )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==NumberSign) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:188:5: ruleColors
                            {
                             
                                    newCompositeNode(grammarAccess.getInstructionAccess().getColorsParserRuleCall_0_1_1()); 
                                
                            pushFollow(FOLLOW_ruleColors_in_ruleInstruction394);
                            ruleColors();

                            state._fsp--;


                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:197:5: ruleAutoNumber
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 
                        
                    pushFollow(FOLLOW_ruleAutoNumber_in_ruleInstruction418);
                    ruleAutoNumber();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:206:5: ruleTitle
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 
                        
                    pushFollow(FOLLOW_ruleTitle_in_ruleInstruction439);
                    ruleTitle();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:215:5: ruleLegend
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 
                        
                    pushFollow(FOLLOW_ruleLegend_in_ruleInstruction460);
                    ruleLegend();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:224:5: ruleNewpage
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 
                        
                    pushFollow(FOLLOW_ruleNewpage_in_ruleInstruction481);
                    ruleNewpage();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:233:5: this_AltElse_7= ruleAltElse
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getAltElseParserRuleCall_0_6()); 
                        
                    pushFollow(FOLLOW_ruleAltElse_in_ruleInstruction508);
                    this_AltElse_7=ruleAltElse();

                    state._fsp--;


                            current = this_AltElse_7;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:243:5: this_GroupingMessages_8= ruleGroupingMessages
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getGroupingMessagesParserRuleCall_0_7()); 
                        
                    pushFollow(FOLLOW_ruleGroupingMessages_in_ruleInstruction535);
                    this_GroupingMessages_8=ruleGroupingMessages();

                    state._fsp--;


                            current = this_GroupingMessages_8;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:253:5: this_Note_9= ruleNote
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getNoteParserRuleCall_0_8()); 
                        
                    pushFollow(FOLLOW_ruleNote_in_ruleInstruction562);
                    this_Note_9=ruleNote();

                    state._fsp--;


                            current = this_Note_9;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:263:5: ruleDivider
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDividerParserRuleCall_0_9()); 
                        
                    pushFollow(FOLLOW_ruleDivider_in_ruleInstruction583);
                    ruleDivider();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:272:5: this_Reference_11= ruleReference
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getReferenceParserRuleCall_0_10()); 
                        
                    pushFollow(FOLLOW_ruleReference_in_ruleInstruction610);
                    this_Reference_11=ruleReference();

                    state._fsp--;


                            current = this_Reference_11;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:282:5: ruleDelay
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDelayParserRuleCall_0_11()); 
                        
                    pushFollow(FOLLOW_ruleDelay_in_ruleInstruction631);
                    ruleDelay();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:291:5: ruleSpace
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getSpaceParserRuleCall_0_12()); 
                        
                    pushFollow(FOLLOW_ruleSpace_in_ruleInstruction652);
                    ruleSpace();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:300:5: ruleHidefootbox
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getHidefootboxParserRuleCall_0_13()); 
                        
                    pushFollow(FOLLOW_ruleHidefootbox_in_ruleInstruction673);
                    ruleHidefootbox();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:309:5: this_Activate_15= ruleActivate
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getActivateParserRuleCall_0_14()); 
                        
                    pushFollow(FOLLOW_ruleActivate_in_ruleInstruction700);
                    this_Activate_15=ruleActivate();

                    state._fsp--;


                            current = this_Activate_15;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:319:5: this_Deactivate_16= ruleDeactivate
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDeactivateParserRuleCall_0_15()); 
                        
                    pushFollow(FOLLOW_ruleDeactivate_in_ruleInstruction727);
                    this_Deactivate_16=ruleDeactivate();

                    state._fsp--;


                            current = this_Deactivate_16;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:329:5: ruleParticipantCreation
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getParticipantCreationParserRuleCall_0_16()); 
                        
                    pushFollow(FOLLOW_ruleParticipantCreation_in_ruleInstruction748);
                    ruleParticipantCreation();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:338:5: this_Box_18= ruleBox
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getBoxParserRuleCall_0_17()); 
                        
                    pushFollow(FOLLOW_ruleBox_in_ruleInstruction775);
                    this_Box_18=ruleBox();

                    state._fsp--;


                            current = this_Box_18;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            this_NEWLINE_19=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleInstruction787); 
             
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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:358:1: entryRuleArrow returns [EObject current=null] : iv_ruleArrow= ruleArrow EOF ;
    public final EObject entryRuleArrow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrow = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:359:2: (iv_ruleArrow= ruleArrow EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:360:2: iv_ruleArrow= ruleArrow EOF
            {
             newCompositeNode(grammarAccess.getArrowRule()); 
            pushFollow(FOLLOW_ruleArrow_in_entryRuleArrow821);
            iv_ruleArrow=ruleArrow();

            state._fsp--;

             current =iv_ruleArrow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrow831); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:367:1: ruleArrow returns [EObject current=null] : ( ( (lv_name_0_0= ruleMyID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_names_2_0= ruleMyID ) ) (otherlv_3= Colon ( ruleMyID )* )? ) ;
    public final EObject ruleArrow() throws RecognitionException {
        EObject current = null;

        Token this_SEQUENCE_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_names_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:370:28: ( ( ( (lv_name_0_0= ruleMyID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_names_2_0= ruleMyID ) ) (otherlv_3= Colon ( ruleMyID )* )? ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:371:1: ( ( (lv_name_0_0= ruleMyID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_names_2_0= ruleMyID ) ) (otherlv_3= Colon ( ruleMyID )* )? )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:371:1: ( ( (lv_name_0_0= ruleMyID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_names_2_0= ruleMyID ) ) (otherlv_3= Colon ( ruleMyID )* )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:371:2: ( (lv_name_0_0= ruleMyID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_names_2_0= ruleMyID ) ) (otherlv_3= Colon ( ruleMyID )* )?
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:371:2: ( (lv_name_0_0= ruleMyID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:372:1: (lv_name_0_0= ruleMyID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:372:1: (lv_name_0_0= ruleMyID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:373:3: lv_name_0_0= ruleMyID
            {
             
            	        newCompositeNode(grammarAccess.getArrowAccess().getNameMyIDParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleMyID_in_ruleArrow877);
            lv_name_0_0=ruleMyID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getArrowRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"MyID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            this_SEQUENCE_1=(Token)match(input,RULE_SEQUENCE,FOLLOW_RULE_SEQUENCE_in_ruleArrow888); 
             
                newLeafNode(this_SEQUENCE_1, grammarAccess.getArrowAccess().getSEQUENCETerminalRuleCall_1()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:393:1: ( (lv_names_2_0= ruleMyID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:394:1: (lv_names_2_0= ruleMyID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:394:1: (lv_names_2_0= ruleMyID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:395:3: lv_names_2_0= ruleMyID
            {
             
            	        newCompositeNode(grammarAccess.getArrowAccess().getNamesMyIDParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleMyID_in_ruleArrow908);
            lv_names_2_0=ruleMyID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getArrowRule());
            	        }
                   		add(
                   			current, 
                   			"names",
                    		lv_names_2_0, 
                    		"MyID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:411:2: (otherlv_3= Colon ( ruleMyID )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Colon) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:412:2: otherlv_3= Colon ( ruleMyID )*
                    {
                    otherlv_3=(Token)match(input,Colon,FOLLOW_Colon_in_ruleArrow922); 

                        	newLeafNode(otherlv_3, grammarAccess.getArrowAccess().getColonKeyword_3_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:416:1: ( ruleMyID )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=Autonumber && LA6_0<=Deactivate)||LA6_0==Endlegend||LA6_0==Activate||LA6_0==Critical||(LA6_0>=Destroy && LA6_0<=Newpage)||(LA6_0>=Center && LA6_0<=Create)||LA6_0==Legend||(LA6_0>=Break && LA6_0<=Title)||(LA6_0>=Else && LA6_0<=Over)||(LA6_0>=Alt && LA6_0<=Ref)||LA6_0==Of||(LA6_0>=NumberSign && LA6_0<=GreaterThanSign)||(LA6_0>=RULE_INT && LA6_0<=RULE_ID)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:417:5: ruleMyID
                    	    {
                    	     
                    	            newCompositeNode(grammarAccess.getArrowAccess().getMyIDParserRuleCall_3_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleMyID_in_ruleArrow938);
                    	    ruleMyID();

                    	    state._fsp--;


                    	            afterParserOrEnumRuleCall();
                    	        

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:432:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:433:2: (iv_ruleDefinition= ruleDefinition EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:434:2: iv_ruleDefinition= ruleDefinition EOF
            {
             newCompositeNode(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition976);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition986); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:441:1: ruleDefinition returns [EObject current=null] : ( (otherlv_0= Actor ( (lv_name_1_0= ruleMyID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= ruleMyID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= ruleMyID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= ruleMyID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= ruleMyID ) ) ) | (otherlv_10= Participant ( (lv_name_11_0= ruleMyID ) ) (otherlv_12= LessThanSignLessThanSign (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma otherlv_16= NumberSign this_HEXCODE_17= RULE_HEXCODE otherlv_18= RightParenthesis )? ( ruleEndID )* otherlv_20= GreaterThanSignGreaterThanSign )? ) ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token this_HEXCODE_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;

        AntlrDatatypeRuleToken lv_name_7_0 = null;

        AntlrDatatypeRuleToken lv_name_9_0 = null;

        AntlrDatatypeRuleToken lv_name_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:444:28: ( ( (otherlv_0= Actor ( (lv_name_1_0= ruleMyID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= ruleMyID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= ruleMyID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= ruleMyID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= ruleMyID ) ) ) | (otherlv_10= Participant ( (lv_name_11_0= ruleMyID ) ) (otherlv_12= LessThanSignLessThanSign (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma otherlv_16= NumberSign this_HEXCODE_17= RULE_HEXCODE otherlv_18= RightParenthesis )? ( ruleEndID )* otherlv_20= GreaterThanSignGreaterThanSign )? ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:445:1: ( (otherlv_0= Actor ( (lv_name_1_0= ruleMyID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= ruleMyID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= ruleMyID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= ruleMyID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= ruleMyID ) ) ) | (otherlv_10= Participant ( (lv_name_11_0= ruleMyID ) ) (otherlv_12= LessThanSignLessThanSign (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma otherlv_16= NumberSign this_HEXCODE_17= RULE_HEXCODE otherlv_18= RightParenthesis )? ( ruleEndID )* otherlv_20= GreaterThanSignGreaterThanSign )? ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:445:1: ( (otherlv_0= Actor ( (lv_name_1_0= ruleMyID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= ruleMyID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= ruleMyID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= ruleMyID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= ruleMyID ) ) ) | (otherlv_10= Participant ( (lv_name_11_0= ruleMyID ) ) (otherlv_12= LessThanSignLessThanSign (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma otherlv_16= NumberSign this_HEXCODE_17= RULE_HEXCODE otherlv_18= RightParenthesis )? ( ruleEndID )* otherlv_20= GreaterThanSignGreaterThanSign )? ) )
            int alt11=6;
            switch ( input.LA(1) ) {
            case Actor:
                {
                alt11=1;
                }
                break;
            case Boundary:
                {
                alt11=2;
                }
                break;
            case Control:
                {
                alt11=3;
                }
                break;
            case Entity:
                {
                alt11=4;
                }
                break;
            case Database:
                {
                alt11=5;
                }
                break;
            case Participant:
                {
                alt11=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:445:2: (otherlv_0= Actor ( (lv_name_1_0= ruleMyID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:445:2: (otherlv_0= Actor ( (lv_name_1_0= ruleMyID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:446:2: otherlv_0= Actor ( (lv_name_1_0= ruleMyID ) )
                    {
                    otherlv_0=(Token)match(input,Actor,FOLLOW_Actor_in_ruleDefinition1025); 

                        	newLeafNode(otherlv_0, grammarAccess.getDefinitionAccess().getActorKeyword_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:450:1: ( (lv_name_1_0= ruleMyID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:451:1: (lv_name_1_0= ruleMyID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:451:1: (lv_name_1_0= ruleMyID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:452:3: lv_name_1_0= ruleMyID
                    {
                     
                    	        newCompositeNode(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMyID_in_ruleDefinition1045);
                    lv_name_1_0=ruleMyID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"MyID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:469:6: (otherlv_2= Boundary ( (lv_name_3_0= ruleMyID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:469:6: (otherlv_2= Boundary ( (lv_name_3_0= ruleMyID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:470:2: otherlv_2= Boundary ( (lv_name_3_0= ruleMyID ) )
                    {
                    otherlv_2=(Token)match(input,Boundary,FOLLOW_Boundary_in_ruleDefinition1066); 

                        	newLeafNode(otherlv_2, grammarAccess.getDefinitionAccess().getBoundaryKeyword_1_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:474:1: ( (lv_name_3_0= ruleMyID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:475:1: (lv_name_3_0= ruleMyID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:475:1: (lv_name_3_0= ruleMyID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:476:3: lv_name_3_0= ruleMyID
                    {
                     
                    	        newCompositeNode(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMyID_in_ruleDefinition1086);
                    lv_name_3_0=ruleMyID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_3_0, 
                            		"MyID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:493:6: (otherlv_4= Control ( (lv_name_5_0= ruleMyID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:493:6: (otherlv_4= Control ( (lv_name_5_0= ruleMyID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:494:2: otherlv_4= Control ( (lv_name_5_0= ruleMyID ) )
                    {
                    otherlv_4=(Token)match(input,Control,FOLLOW_Control_in_ruleDefinition1107); 

                        	newLeafNode(otherlv_4, grammarAccess.getDefinitionAccess().getControlKeyword_2_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:498:1: ( (lv_name_5_0= ruleMyID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:499:1: (lv_name_5_0= ruleMyID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:499:1: (lv_name_5_0= ruleMyID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:500:3: lv_name_5_0= ruleMyID
                    {
                     
                    	        newCompositeNode(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMyID_in_ruleDefinition1127);
                    lv_name_5_0=ruleMyID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_5_0, 
                            		"MyID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:517:6: (otherlv_6= Entity ( (lv_name_7_0= ruleMyID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:517:6: (otherlv_6= Entity ( (lv_name_7_0= ruleMyID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:518:2: otherlv_6= Entity ( (lv_name_7_0= ruleMyID ) )
                    {
                    otherlv_6=(Token)match(input,Entity,FOLLOW_Entity_in_ruleDefinition1148); 

                        	newLeafNode(otherlv_6, grammarAccess.getDefinitionAccess().getEntityKeyword_3_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:522:1: ( (lv_name_7_0= ruleMyID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:523:1: (lv_name_7_0= ruleMyID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:523:1: (lv_name_7_0= ruleMyID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:524:3: lv_name_7_0= ruleMyID
                    {
                     
                    	        newCompositeNode(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMyID_in_ruleDefinition1168);
                    lv_name_7_0=ruleMyID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_7_0, 
                            		"MyID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:541:6: (otherlv_8= Database ( (lv_name_9_0= ruleMyID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:541:6: (otherlv_8= Database ( (lv_name_9_0= ruleMyID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:542:2: otherlv_8= Database ( (lv_name_9_0= ruleMyID ) )
                    {
                    otherlv_8=(Token)match(input,Database,FOLLOW_Database_in_ruleDefinition1189); 

                        	newLeafNode(otherlv_8, grammarAccess.getDefinitionAccess().getDatabaseKeyword_4_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:546:1: ( (lv_name_9_0= ruleMyID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:547:1: (lv_name_9_0= ruleMyID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:547:1: (lv_name_9_0= ruleMyID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:548:3: lv_name_9_0= ruleMyID
                    {
                     
                    	        newCompositeNode(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMyID_in_ruleDefinition1209);
                    lv_name_9_0=ruleMyID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_9_0, 
                            		"MyID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:565:6: (otherlv_10= Participant ( (lv_name_11_0= ruleMyID ) ) (otherlv_12= LessThanSignLessThanSign (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma otherlv_16= NumberSign this_HEXCODE_17= RULE_HEXCODE otherlv_18= RightParenthesis )? ( ruleEndID )* otherlv_20= GreaterThanSignGreaterThanSign )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:565:6: (otherlv_10= Participant ( (lv_name_11_0= ruleMyID ) ) (otherlv_12= LessThanSignLessThanSign (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma otherlv_16= NumberSign this_HEXCODE_17= RULE_HEXCODE otherlv_18= RightParenthesis )? ( ruleEndID )* otherlv_20= GreaterThanSignGreaterThanSign )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:566:2: otherlv_10= Participant ( (lv_name_11_0= ruleMyID ) ) (otherlv_12= LessThanSignLessThanSign (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma otherlv_16= NumberSign this_HEXCODE_17= RULE_HEXCODE otherlv_18= RightParenthesis )? ( ruleEndID )* otherlv_20= GreaterThanSignGreaterThanSign )?
                    {
                    otherlv_10=(Token)match(input,Participant,FOLLOW_Participant_in_ruleDefinition1230); 

                        	newLeafNode(otherlv_10, grammarAccess.getDefinitionAccess().getParticipantKeyword_5_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:570:1: ( (lv_name_11_0= ruleMyID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:571:1: (lv_name_11_0= ruleMyID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:571:1: (lv_name_11_0= ruleMyID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:572:3: lv_name_11_0= ruleMyID
                    {
                     
                    	        newCompositeNode(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMyID_in_ruleDefinition1250);
                    lv_name_11_0=ruleMyID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_11_0, 
                            		"MyID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:588:2: (otherlv_12= LessThanSignLessThanSign (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma otherlv_16= NumberSign this_HEXCODE_17= RULE_HEXCODE otherlv_18= RightParenthesis )? ( ruleEndID )* otherlv_20= GreaterThanSignGreaterThanSign )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==LessThanSignLessThanSign) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:589:2: otherlv_12= LessThanSignLessThanSign (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma otherlv_16= NumberSign this_HEXCODE_17= RULE_HEXCODE otherlv_18= RightParenthesis )? ( ruleEndID )* otherlv_20= GreaterThanSignGreaterThanSign
                            {
                            otherlv_12=(Token)match(input,LessThanSignLessThanSign,FOLLOW_LessThanSignLessThanSign_in_ruleDefinition1264); 

                                	newLeafNode(otherlv_12, grammarAccess.getDefinitionAccess().getLessThanSignLessThanSignKeyword_5_2_0());
                                
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:593:1: (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma otherlv_16= NumberSign this_HEXCODE_17= RULE_HEXCODE otherlv_18= RightParenthesis )?
                            int alt8=2;
                            alt8 = dfa8.predict(input);
                            switch (alt8) {
                                case 1 :
                                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:594:2: otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma otherlv_16= NumberSign this_HEXCODE_17= RULE_HEXCODE otherlv_18= RightParenthesis
                                    {
                                    otherlv_13=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_ruleDefinition1277); 

                                        	newLeafNode(otherlv_13, grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_0());
                                        
                                     
                                            newCompositeNode(grammarAccess.getDefinitionAccess().getEndIDParserRuleCall_5_2_1_1()); 
                                        
                                    pushFollow(FOLLOW_ruleEndID_in_ruleDefinition1292);
                                    ruleEndID();

                                    state._fsp--;


                                            afterParserOrEnumRuleCall();
                                        
                                    otherlv_15=(Token)match(input,Comma,FOLLOW_Comma_in_ruleDefinition1304); 

                                        	newLeafNode(otherlv_15, grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_2());
                                        
                                    otherlv_16=(Token)match(input,NumberSign,FOLLOW_NumberSign_in_ruleDefinition1316); 

                                        	newLeafNode(otherlv_16, grammarAccess.getDefinitionAccess().getNumberSignKeyword_5_2_1_3());
                                        
                                    this_HEXCODE_17=(Token)match(input,RULE_HEXCODE,FOLLOW_RULE_HEXCODE_in_ruleDefinition1326); 
                                     
                                        newLeafNode(this_HEXCODE_17, grammarAccess.getDefinitionAccess().getHEXCODETerminalRuleCall_5_2_1_4()); 
                                        
                                    otherlv_18=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_ruleDefinition1338); 

                                        	newLeafNode(otherlv_18, grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_5());
                                        

                                    }
                                    break;

                            }

                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:625:3: ( ruleEndID )*
                            loop9:
                            do {
                                int alt9=2;
                                int LA9_0 = input.LA(1);

                                if ( ((LA9_0>=Autonumber && LA9_0<=Deactivate)||LA9_0==Endlegend||LA9_0==Activate||LA9_0==Critical||(LA9_0>=Destroy && LA9_0<=Newpage)||(LA9_0>=Center && LA9_0<=Create)||LA9_0==Legend||(LA9_0>=Break && LA9_0<=Title)||(LA9_0>=Else && LA9_0<=Over)||(LA9_0>=Alt && LA9_0<=Box)||(LA9_0>=Opt && LA9_0<=Ref)||LA9_0==Of||(LA9_0>=NumberSign && LA9_0<=GreaterThanSign)||(LA9_0>=RULE_INT && LA9_0<=RULE_ID)) ) {
                                    alt9=1;
                                }


                                switch (alt9) {
                            	case 1 :
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:626:5: ruleEndID
                            	    {
                            	     
                            	            newCompositeNode(grammarAccess.getDefinitionAccess().getEndIDParserRuleCall_5_2_2()); 
                            	        
                            	    pushFollow(FOLLOW_ruleEndID_in_ruleDefinition1356);
                            	    ruleEndID();

                            	    state._fsp--;


                            	            afterParserOrEnumRuleCall();
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop9;
                                }
                            } while (true);

                            otherlv_20=(Token)match(input,GreaterThanSignGreaterThanSign,FOLLOW_GreaterThanSignGreaterThanSign_in_ruleDefinition1370); 

                                	newLeafNode(otherlv_20, grammarAccess.getDefinitionAccess().getGreaterThanSignGreaterThanSignKeyword_5_2_3());
                                

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


    // $ANTLR start "entryRuleEndID"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:648:1: entryRuleEndID returns [String current=null] : iv_ruleEndID= ruleEndID EOF ;
    public final String entryRuleEndID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEndID = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:649:1: (iv_ruleEndID= ruleEndID EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:650:2: iv_ruleEndID= ruleEndID EOF
            {
             newCompositeNode(grammarAccess.getEndIDRule()); 
            pushFollow(FOLLOW_ruleEndID_in_entryRuleEndID1410);
            iv_ruleEndID=ruleEndID();

            state._fsp--;

             current =iv_ruleEndID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndID1421); 

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
    // $ANTLR end "entryRuleEndID"


    // $ANTLR start "ruleEndID"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:657:1: ruleEndID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= Create | kw= Autonumber | kw= Title | kw= Legend | kw= Right | kw= Left | kw= Center | kw= Endlegend | kw= Alt | kw= Else | kw= Newpage | kw= Opt | kw= Loop | kw= Par | kw= Break | kw= Critical | kw= Group | kw= Note | kw= Over | kw= Of | kw= Ref | kw= Hide | kw= Footbox | kw= Activate | kw= Deactivate | kw= Destroy | kw= Box | kw= NumberSign | kw= Comma | kw= LeftParenthesis | kw= RightParenthesis | kw= EqualsSign | this_INT_33= RULE_INT | kw= HyphenMinus | kw= FullStop | kw= Colon | kw= GreaterThanSign | kw= LessThanSign ) ;
    public final AntlrDatatypeRuleToken ruleEndID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_INT_33=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:661:6: ( (this_ID_0= RULE_ID | kw= Create | kw= Autonumber | kw= Title | kw= Legend | kw= Right | kw= Left | kw= Center | kw= Endlegend | kw= Alt | kw= Else | kw= Newpage | kw= Opt | kw= Loop | kw= Par | kw= Break | kw= Critical | kw= Group | kw= Note | kw= Over | kw= Of | kw= Ref | kw= Hide | kw= Footbox | kw= Activate | kw= Deactivate | kw= Destroy | kw= Box | kw= NumberSign | kw= Comma | kw= LeftParenthesis | kw= RightParenthesis | kw= EqualsSign | this_INT_33= RULE_INT | kw= HyphenMinus | kw= FullStop | kw= Colon | kw= GreaterThanSign | kw= LessThanSign ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:662:1: (this_ID_0= RULE_ID | kw= Create | kw= Autonumber | kw= Title | kw= Legend | kw= Right | kw= Left | kw= Center | kw= Endlegend | kw= Alt | kw= Else | kw= Newpage | kw= Opt | kw= Loop | kw= Par | kw= Break | kw= Critical | kw= Group | kw= Note | kw= Over | kw= Of | kw= Ref | kw= Hide | kw= Footbox | kw= Activate | kw= Deactivate | kw= Destroy | kw= Box | kw= NumberSign | kw= Comma | kw= LeftParenthesis | kw= RightParenthesis | kw= EqualsSign | this_INT_33= RULE_INT | kw= HyphenMinus | kw= FullStop | kw= Colon | kw= GreaterThanSign | kw= LessThanSign )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:662:1: (this_ID_0= RULE_ID | kw= Create | kw= Autonumber | kw= Title | kw= Legend | kw= Right | kw= Left | kw= Center | kw= Endlegend | kw= Alt | kw= Else | kw= Newpage | kw= Opt | kw= Loop | kw= Par | kw= Break | kw= Critical | kw= Group | kw= Note | kw= Over | kw= Of | kw= Ref | kw= Hide | kw= Footbox | kw= Activate | kw= Deactivate | kw= Destroy | kw= Box | kw= NumberSign | kw= Comma | kw= LeftParenthesis | kw= RightParenthesis | kw= EqualsSign | this_INT_33= RULE_INT | kw= HyphenMinus | kw= FullStop | kw= Colon | kw= GreaterThanSign | kw= LessThanSign )
            int alt12=39;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt12=1;
                }
                break;
            case Create:
                {
                alt12=2;
                }
                break;
            case Autonumber:
                {
                alt12=3;
                }
                break;
            case Title:
                {
                alt12=4;
                }
                break;
            case Legend:
                {
                alt12=5;
                }
                break;
            case Right:
                {
                alt12=6;
                }
                break;
            case Left:
                {
                alt12=7;
                }
                break;
            case Center:
                {
                alt12=8;
                }
                break;
            case Endlegend:
                {
                alt12=9;
                }
                break;
            case Alt:
                {
                alt12=10;
                }
                break;
            case Else:
                {
                alt12=11;
                }
                break;
            case Newpage:
                {
                alt12=12;
                }
                break;
            case Opt:
                {
                alt12=13;
                }
                break;
            case Loop:
                {
                alt12=14;
                }
                break;
            case Par:
                {
                alt12=15;
                }
                break;
            case Break:
                {
                alt12=16;
                }
                break;
            case Critical:
                {
                alt12=17;
                }
                break;
            case Group:
                {
                alt12=18;
                }
                break;
            case Note:
                {
                alt12=19;
                }
                break;
            case Over:
                {
                alt12=20;
                }
                break;
            case Of:
                {
                alt12=21;
                }
                break;
            case Ref:
                {
                alt12=22;
                }
                break;
            case Hide:
                {
                alt12=23;
                }
                break;
            case Footbox:
                {
                alt12=24;
                }
                break;
            case Activate:
                {
                alt12=25;
                }
                break;
            case Deactivate:
                {
                alt12=26;
                }
                break;
            case Destroy:
                {
                alt12=27;
                }
                break;
            case Box:
                {
                alt12=28;
                }
                break;
            case NumberSign:
                {
                alt12=29;
                }
                break;
            case Comma:
                {
                alt12=30;
                }
                break;
            case LeftParenthesis:
                {
                alt12=31;
                }
                break;
            case RightParenthesis:
                {
                alt12=32;
                }
                break;
            case EqualsSign:
                {
                alt12=33;
                }
                break;
            case RULE_INT:
                {
                alt12=34;
                }
                break;
            case HyphenMinus:
                {
                alt12=35;
                }
                break;
            case FullStop:
                {
                alt12=36;
                }
                break;
            case Colon:
                {
                alt12=37;
                }
                break;
            case GreaterThanSign:
                {
                alt12=38;
                }
                break;
            case LessThanSign:
                {
                alt12=39;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:662:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEndID1461); 

                    		current.merge(this_ID_0);
                        
                     
                        newLeafNode(this_ID_0, grammarAccess.getEndIDAccess().getIDTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:671:2: kw= Create
                    {
                    kw=(Token)match(input,Create,FOLLOW_Create_in_ruleEndID1485); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getCreateKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:678:2: kw= Autonumber
                    {
                    kw=(Token)match(input,Autonumber,FOLLOW_Autonumber_in_ruleEndID1504); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getAutonumberKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:685:2: kw= Title
                    {
                    kw=(Token)match(input,Title,FOLLOW_Title_in_ruleEndID1523); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getTitleKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:692:2: kw= Legend
                    {
                    kw=(Token)match(input,Legend,FOLLOW_Legend_in_ruleEndID1542); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getLegendKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:699:2: kw= Right
                    {
                    kw=(Token)match(input,Right,FOLLOW_Right_in_ruleEndID1561); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getRightKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:706:2: kw= Left
                    {
                    kw=(Token)match(input,Left,FOLLOW_Left_in_ruleEndID1580); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getLeftKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:713:2: kw= Center
                    {
                    kw=(Token)match(input,Center,FOLLOW_Center_in_ruleEndID1599); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getCenterKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:720:2: kw= Endlegend
                    {
                    kw=(Token)match(input,Endlegend,FOLLOW_Endlegend_in_ruleEndID1618); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getEndlegendKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:727:2: kw= Alt
                    {
                    kw=(Token)match(input,Alt,FOLLOW_Alt_in_ruleEndID1637); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getAltKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:734:2: kw= Else
                    {
                    kw=(Token)match(input,Else,FOLLOW_Else_in_ruleEndID1656); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getElseKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:741:2: kw= Newpage
                    {
                    kw=(Token)match(input,Newpage,FOLLOW_Newpage_in_ruleEndID1675); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getNewpageKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:748:2: kw= Opt
                    {
                    kw=(Token)match(input,Opt,FOLLOW_Opt_in_ruleEndID1694); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getOptKeyword_12()); 
                        

                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:755:2: kw= Loop
                    {
                    kw=(Token)match(input,Loop,FOLLOW_Loop_in_ruleEndID1713); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getLoopKeyword_13()); 
                        

                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:762:2: kw= Par
                    {
                    kw=(Token)match(input,Par,FOLLOW_Par_in_ruleEndID1732); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getParKeyword_14()); 
                        

                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:769:2: kw= Break
                    {
                    kw=(Token)match(input,Break,FOLLOW_Break_in_ruleEndID1751); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getBreakKeyword_15()); 
                        

                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:776:2: kw= Critical
                    {
                    kw=(Token)match(input,Critical,FOLLOW_Critical_in_ruleEndID1770); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getCriticalKeyword_16()); 
                        

                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:783:2: kw= Group
                    {
                    kw=(Token)match(input,Group,FOLLOW_Group_in_ruleEndID1789); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getGroupKeyword_17()); 
                        

                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:790:2: kw= Note
                    {
                    kw=(Token)match(input,Note,FOLLOW_Note_in_ruleEndID1808); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getNoteKeyword_18()); 
                        

                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:797:2: kw= Over
                    {
                    kw=(Token)match(input,Over,FOLLOW_Over_in_ruleEndID1827); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getOverKeyword_19()); 
                        

                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:804:2: kw= Of
                    {
                    kw=(Token)match(input,Of,FOLLOW_Of_in_ruleEndID1846); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getOfKeyword_20()); 
                        

                    }
                    break;
                case 22 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:811:2: kw= Ref
                    {
                    kw=(Token)match(input,Ref,FOLLOW_Ref_in_ruleEndID1865); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getRefKeyword_21()); 
                        

                    }
                    break;
                case 23 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:818:2: kw= Hide
                    {
                    kw=(Token)match(input,Hide,FOLLOW_Hide_in_ruleEndID1884); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getHideKeyword_22()); 
                        

                    }
                    break;
                case 24 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:825:2: kw= Footbox
                    {
                    kw=(Token)match(input,Footbox,FOLLOW_Footbox_in_ruleEndID1903); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getFootboxKeyword_23()); 
                        

                    }
                    break;
                case 25 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:832:2: kw= Activate
                    {
                    kw=(Token)match(input,Activate,FOLLOW_Activate_in_ruleEndID1922); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getActivateKeyword_24()); 
                        

                    }
                    break;
                case 26 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:839:2: kw= Deactivate
                    {
                    kw=(Token)match(input,Deactivate,FOLLOW_Deactivate_in_ruleEndID1941); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getDeactivateKeyword_25()); 
                        

                    }
                    break;
                case 27 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:846:2: kw= Destroy
                    {
                    kw=(Token)match(input,Destroy,FOLLOW_Destroy_in_ruleEndID1960); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getDestroyKeyword_26()); 
                        

                    }
                    break;
                case 28 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:853:2: kw= Box
                    {
                    kw=(Token)match(input,Box,FOLLOW_Box_in_ruleEndID1979); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getBoxKeyword_27()); 
                        

                    }
                    break;
                case 29 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:860:2: kw= NumberSign
                    {
                    kw=(Token)match(input,NumberSign,FOLLOW_NumberSign_in_ruleEndID1998); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getNumberSignKeyword_28()); 
                        

                    }
                    break;
                case 30 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:867:2: kw= Comma
                    {
                    kw=(Token)match(input,Comma,FOLLOW_Comma_in_ruleEndID2017); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getCommaKeyword_29()); 
                        

                    }
                    break;
                case 31 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:874:2: kw= LeftParenthesis
                    {
                    kw=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_ruleEndID2036); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getLeftParenthesisKeyword_30()); 
                        

                    }
                    break;
                case 32 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:881:2: kw= RightParenthesis
                    {
                    kw=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_ruleEndID2055); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getRightParenthesisKeyword_31()); 
                        

                    }
                    break;
                case 33 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:888:2: kw= EqualsSign
                    {
                    kw=(Token)match(input,EqualsSign,FOLLOW_EqualsSign_in_ruleEndID2074); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getEqualsSignKeyword_32()); 
                        

                    }
                    break;
                case 34 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:894:10: this_INT_33= RULE_INT
                    {
                    this_INT_33=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEndID2095); 

                    		current.merge(this_INT_33);
                        
                     
                        newLeafNode(this_INT_33, grammarAccess.getEndIDAccess().getINTTerminalRuleCall_33()); 
                        

                    }
                    break;
                case 35 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:903:2: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FOLLOW_HyphenMinus_in_ruleEndID2119); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getHyphenMinusKeyword_34()); 
                        

                    }
                    break;
                case 36 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:910:2: kw= FullStop
                    {
                    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleEndID2138); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getFullStopKeyword_35()); 
                        

                    }
                    break;
                case 37 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:917:2: kw= Colon
                    {
                    kw=(Token)match(input,Colon,FOLLOW_Colon_in_ruleEndID2157); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getColonKeyword_36()); 
                        

                    }
                    break;
                case 38 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:924:2: kw= GreaterThanSign
                    {
                    kw=(Token)match(input,GreaterThanSign,FOLLOW_GreaterThanSign_in_ruleEndID2176); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getGreaterThanSignKeyword_37()); 
                        

                    }
                    break;
                case 39 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:931:2: kw= LessThanSign
                    {
                    kw=(Token)match(input,LessThanSign,FOLLOW_LessThanSign_in_ruleEndID2195); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getLessThanSignKeyword_38()); 
                        

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
    // $ANTLR end "ruleEndID"


    // $ANTLR start "entryRuleMyID"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:944:1: entryRuleMyID returns [String current=null] : iv_ruleMyID= ruleMyID EOF ;
    public final String entryRuleMyID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyID = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:945:1: (iv_ruleMyID= ruleMyID EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:946:2: iv_ruleMyID= ruleMyID EOF
            {
             newCompositeNode(grammarAccess.getMyIDRule()); 
            pushFollow(FOLLOW_ruleMyID_in_entryRuleMyID2235);
            iv_ruleMyID=ruleMyID();

            state._fsp--;

             current =iv_ruleMyID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMyID2246); 

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
    // $ANTLR end "entryRuleMyID"


    // $ANTLR start "ruleMyID"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:953:1: ruleMyID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EndID_0= ruleEndID | kw= End ) ;
    public final AntlrDatatypeRuleToken ruleMyID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EndID_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:957:6: ( (this_EndID_0= ruleEndID | kw= End ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:958:1: (this_EndID_0= ruleEndID | kw= End )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:958:1: (this_EndID_0= ruleEndID | kw= End )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=Autonumber && LA13_0<=Deactivate)||LA13_0==Endlegend||LA13_0==Activate||LA13_0==Critical||(LA13_0>=Destroy && LA13_0<=Newpage)||(LA13_0>=Center && LA13_0<=Create)||LA13_0==Legend||(LA13_0>=Break && LA13_0<=Title)||(LA13_0>=Else && LA13_0<=Over)||(LA13_0>=Alt && LA13_0<=Box)||(LA13_0>=Opt && LA13_0<=Ref)||LA13_0==Of||(LA13_0>=NumberSign && LA13_0<=GreaterThanSign)||(LA13_0>=RULE_INT && LA13_0<=RULE_ID)) ) {
                alt13=1;
            }
            else if ( (LA13_0==End) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:959:5: this_EndID_0= ruleEndID
                    {
                     
                            newCompositeNode(grammarAccess.getMyIDAccess().getEndIDParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleEndID_in_ruleMyID2293);
                    this_EndID_0=ruleEndID();

                    state._fsp--;


                    		current.merge(this_EndID_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:971:2: kw= End
                    {
                    kw=(Token)match(input,End,FOLLOW_End_in_ruleMyID2317); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getMyIDAccess().getEndKeyword_1()); 
                        

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
    // $ANTLR end "ruleMyID"


    // $ANTLR start "entryRuleAutoNumber"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:984:1: entryRuleAutoNumber returns [String current=null] : iv_ruleAutoNumber= ruleAutoNumber EOF ;
    public final String entryRuleAutoNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAutoNumber = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:985:1: (iv_ruleAutoNumber= ruleAutoNumber EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:986:2: iv_ruleAutoNumber= ruleAutoNumber EOF
            {
             newCompositeNode(grammarAccess.getAutoNumberRule()); 
            pushFollow(FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber2357);
            iv_ruleAutoNumber=ruleAutoNumber();

            state._fsp--;

             current =iv_ruleAutoNumber.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAutoNumber2368); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:993:1: ruleAutoNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? ) ;
    public final AntlrDatatypeRuleToken ruleAutoNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:997:6: ( (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:998:1: (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:998:1: (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:999:2: kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )?
            {
            kw=(Token)match(input,Autonumber,FOLLOW_Autonumber_in_ruleAutoNumber2406); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getAutoNumberAccess().getAutonumberKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1004:1: (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_INT) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1004:6: this_INT_1= RULE_INT (this_INT_2= RULE_INT )?
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAutoNumber2422); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_0()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1011:1: (this_INT_2= RULE_INT )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==RULE_INT) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1011:6: this_INT_2= RULE_INT
                            {
                            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAutoNumber2443); 

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


    // $ANTLR start "entryRuleTitle"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1026:1: entryRuleTitle returns [String current=null] : iv_ruleTitle= ruleTitle EOF ;
    public final String entryRuleTitle() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTitle = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1027:1: (iv_ruleTitle= ruleTitle EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1028:2: iv_ruleTitle= ruleTitle EOF
            {
             newCompositeNode(grammarAccess.getTitleRule()); 
            pushFollow(FOLLOW_ruleTitle_in_entryRuleTitle2492);
            iv_ruleTitle=ruleTitle();

            state._fsp--;

             current =iv_ruleTitle.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTitle2503); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1035:1: ruleTitle returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Title (this_ID_1= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleTitle() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1039:6: ( (kw= Title (this_ID_1= RULE_ID )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1040:1: (kw= Title (this_ID_1= RULE_ID )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1040:1: (kw= Title (this_ID_1= RULE_ID )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1041:2: kw= Title (this_ID_1= RULE_ID )*
            {
            kw=(Token)match(input,Title,FOLLOW_Title_in_ruleTitle2541); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTitleAccess().getTitleKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1046:1: (this_ID_1= RULE_ID )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1046:6: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTitle2557); 

            	    		current.merge(this_ID_1);
            	        
            	     
            	        newLeafNode(this_ID_1, grammarAccess.getTitleAccess().getIDTerminalRuleCall_1()); 
            	        

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
    // $ANTLR end "ruleTitle"


    // $ANTLR start "entryRuleLegend"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1061:1: entryRuleLegend returns [String current=null] : iv_ruleLegend= ruleLegend EOF ;
    public final String entryRuleLegend() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLegend = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1062:1: (iv_ruleLegend= ruleLegend EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1063:2: iv_ruleLegend= ruleLegend EOF
            {
             newCompositeNode(grammarAccess.getLegendRule()); 
            pushFollow(FOLLOW_ruleLegend_in_entryRuleLegend2604);
            iv_ruleLegend=ruleLegend();

            state._fsp--;

             current =iv_ruleLegend.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLegend2615); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1070:1: ruleLegend returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend ) ;
    public final AntlrDatatypeRuleToken ruleLegend() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_NEWLINE_4=null;
        Token this_ID_5=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1074:6: ( (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1075:1: (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1075:1: (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1076:2: kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend
            {
            kw=(Token)match(input,Legend,FOLLOW_Legend_in_ruleLegend2653); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getLegendAccess().getLegendKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1081:1: (kw= Right | kw= Left | kw= Center )?
            int alt17=4;
            switch ( input.LA(1) ) {
                case Right:
                    {
                    alt17=1;
                    }
                    break;
                case Left:
                    {
                    alt17=2;
                    }
                    break;
                case Center:
                    {
                    alt17=3;
                    }
                    break;
            }

            switch (alt17) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1082:2: kw= Right
                    {
                    kw=(Token)match(input,Right,FOLLOW_Right_in_ruleLegend2667); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getRightKeyword_1_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1089:2: kw= Left
                    {
                    kw=(Token)match(input,Left,FOLLOW_Left_in_ruleLegend2686); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1096:2: kw= Center
                    {
                    kw=(Token)match(input,Center,FOLLOW_Center_in_ruleLegend2705); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getCenterKeyword_1_2()); 
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1101:3: (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_NEWLINE) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1101:8: this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )*
            	    {
            	    this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleLegend2723); 

            	    		current.merge(this_NEWLINE_4);
            	        
            	     
            	        newLeafNode(this_NEWLINE_4, grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_0()); 
            	        
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1108:1: (this_ID_5= RULE_ID )*
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0==RULE_ID) ) {
            	            alt18=1;
            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1108:6: this_ID_5= RULE_ID
            	    	    {
            	    	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLegend2744); 

            	    	    		current.merge(this_ID_5);
            	    	        
            	    	     
            	    	        newLeafNode(this_ID_5, grammarAccess.getLegendAccess().getIDTerminalRuleCall_2_1()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop18;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            kw=(Token)match(input,Endlegend,FOLLOW_Endlegend_in_ruleLegend2766); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1129:1: entryRuleNewpage returns [String current=null] : iv_ruleNewpage= ruleNewpage EOF ;
    public final String entryRuleNewpage() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNewpage = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1130:1: (iv_ruleNewpage= ruleNewpage EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1131:2: iv_ruleNewpage= ruleNewpage EOF
            {
             newCompositeNode(grammarAccess.getNewpageRule()); 
            pushFollow(FOLLOW_ruleNewpage_in_entryRuleNewpage2806);
            iv_ruleNewpage=ruleNewpage();

            state._fsp--;

             current =iv_ruleNewpage.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNewpage2817); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1138:1: ruleNewpage returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Newpage (this_ID_1= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleNewpage() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1142:6: ( (kw= Newpage (this_ID_1= RULE_ID )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1143:1: (kw= Newpage (this_ID_1= RULE_ID )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1143:1: (kw= Newpage (this_ID_1= RULE_ID )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1144:2: kw= Newpage (this_ID_1= RULE_ID )*
            {
            kw=(Token)match(input,Newpage,FOLLOW_Newpage_in_ruleNewpage2855); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getNewpageAccess().getNewpageKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1149:1: (this_ID_1= RULE_ID )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1149:6: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNewpage2871); 

            	    		current.merge(this_ID_1);
            	        
            	     
            	        newLeafNode(this_ID_1, grammarAccess.getNewpageAccess().getIDTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1164:1: entryRuleAltElse returns [EObject current=null] : iv_ruleAltElse= ruleAltElse EOF ;
    public final EObject entryRuleAltElse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltElse = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1165:2: (iv_ruleAltElse= ruleAltElse EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1166:2: iv_ruleAltElse= ruleAltElse EOF
            {
             newCompositeNode(grammarAccess.getAltElseRule()); 
            pushFollow(FOLLOW_ruleAltElse_in_entryRuleAltElse2917);
            iv_ruleAltElse=ruleAltElse();

            state._fsp--;

             current =iv_ruleAltElse; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAltElse2927); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1173:1: ruleAltElse returns [EObject current=null] : (otherlv_0= Alt ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End ) ;
    public final EObject ruleAltElse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_NEWLINE_2=null;
        Token otherlv_5=null;
        EObject lv_instructions_3_0 = null;

        EObject lv_elses_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1176:28: ( (otherlv_0= Alt ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1177:1: (otherlv_0= Alt ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1177:1: (otherlv_0= Alt ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1178:2: otherlv_0= Alt ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End
            {
            otherlv_0=(Token)match(input,Alt,FOLLOW_Alt_in_ruleAltElse2965); 

                	newLeafNode(otherlv_0, grammarAccess.getAltElseAccess().getAltKeyword_0());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1182:1: ( ruleMyID )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=Autonumber && LA21_0<=Deactivate)||LA21_0==Endlegend||LA21_0==Activate||LA21_0==Critical||(LA21_0>=Destroy && LA21_0<=Newpage)||(LA21_0>=Center && LA21_0<=Create)||LA21_0==Legend||(LA21_0>=Break && LA21_0<=Title)||(LA21_0>=Else && LA21_0<=Over)||(LA21_0>=Alt && LA21_0<=Ref)||LA21_0==Of||(LA21_0>=NumberSign && LA21_0<=GreaterThanSign)||(LA21_0>=RULE_INT && LA21_0<=RULE_ID)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1183:5: ruleMyID
            	    {
            	     
            	            newCompositeNode(grammarAccess.getAltElseAccess().getMyIDParserRuleCall_1()); 
            	        
            	    pushFollow(FOLLOW_ruleMyID_in_ruleAltElse2981);
            	    ruleMyID();

            	    state._fsp--;


            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleAltElse2993); 
             
                newLeafNode(this_NEWLINE_2, grammarAccess.getAltElseAccess().getNEWLINETerminalRuleCall_2()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1194:1: ( (lv_instructions_3_0= ruleInstruction ) )*
            loop22:
            do {
                int alt22=2;
                switch ( input.LA(1) ) {
                case Else:
                    {
                    int LA22_1 = input.LA(2);

                    if ( (LA22_1==RULE_SEQUENCE) ) {
                        alt22=1;
                    }


                    }
                    break;
                case End:
                    {
                    int LA22_2 = input.LA(2);

                    if ( (LA22_2==RULE_SEQUENCE) ) {
                        alt22=1;
                    }


                    }
                    break;
                case Participant:
                case Autonumber:
                case Deactivate:
                case Endlegend:
                case Activate:
                case Boundary:
                case Critical:
                case Database:
                case Control:
                case Destroy:
                case Footbox:
                case Newpage:
                case Center:
                case Create:
                case Entity:
                case Legend:
                case Actor:
                case Break:
                case Group:
                case Right:
                case Title:
                case Hide:
                case Left:
                case Loop:
                case Note:
                case Over:
                case FullStopFullStopFullStop:
                case Alt:
                case Box:
                case Opt:
                case Par:
                case Ref:
                case VerticalLineVerticalLineVerticalLine:
                case EqualsSignEqualsSign:
                case Of:
                case VerticalLineVerticalLine:
                case NumberSign:
                case LeftParenthesis:
                case RightParenthesis:
                case Comma:
                case HyphenMinus:
                case FullStop:
                case Colon:
                case LessThanSign:
                case EqualsSign:
                case GreaterThanSign:
                case RULE_NEWLINE:
                case RULE_INT:
                case RULE_ID:
                    {
                    alt22=1;
                    }
                    break;

                }

                switch (alt22) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1195:1: (lv_instructions_3_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1195:1: (lv_instructions_3_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1196:3: lv_instructions_3_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAltElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleAltElse3013);
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
            	    break loop22;
                }
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1212:3: ( (lv_elses_4_0= ruleElse ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==Else) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1213:1: (lv_elses_4_0= ruleElse )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1213:1: (lv_elses_4_0= ruleElse )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1214:3: lv_elses_4_0= ruleElse
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAltElseAccess().getElsesElseParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleElse_in_ruleAltElse3035);
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
            	    break loop23;
                }
            } while (true);

            otherlv_5=(Token)match(input,End,FOLLOW_End_in_ruleAltElse3049); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1243:1: entryRuleElse returns [EObject current=null] : iv_ruleElse= ruleElse EOF ;
    public final EObject entryRuleElse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElse = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1244:2: (iv_ruleElse= ruleElse EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1245:2: iv_ruleElse= ruleElse EOF
            {
             newCompositeNode(grammarAccess.getElseRule()); 
            pushFollow(FOLLOW_ruleElse_in_entryRuleElse3083);
            iv_ruleElse=ruleElse();

            state._fsp--;

             current =iv_ruleElse; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElse3093); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1252:1: ruleElse returns [EObject current=null] : (otherlv_0= Else ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ) ;
    public final EObject ruleElse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_NEWLINE_2=null;
        EObject lv_instructions_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1255:28: ( (otherlv_0= Else ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1256:1: (otherlv_0= Else ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1256:1: (otherlv_0= Else ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1257:2: otherlv_0= Else ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )*
            {
            otherlv_0=(Token)match(input,Else,FOLLOW_Else_in_ruleElse3131); 

                	newLeafNode(otherlv_0, grammarAccess.getElseAccess().getElseKeyword_0());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1261:1: ( ruleMyID )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=Autonumber && LA24_0<=Deactivate)||LA24_0==Endlegend||LA24_0==Activate||LA24_0==Critical||(LA24_0>=Destroy && LA24_0<=Newpage)||(LA24_0>=Center && LA24_0<=Create)||LA24_0==Legend||(LA24_0>=Break && LA24_0<=Title)||(LA24_0>=Else && LA24_0<=Over)||(LA24_0>=Alt && LA24_0<=Ref)||LA24_0==Of||(LA24_0>=NumberSign && LA24_0<=GreaterThanSign)||(LA24_0>=RULE_INT && LA24_0<=RULE_ID)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1262:5: ruleMyID
            	    {
            	     
            	            newCompositeNode(grammarAccess.getElseAccess().getMyIDParserRuleCall_1()); 
            	        
            	    pushFollow(FOLLOW_ruleMyID_in_ruleElse3147);
            	    ruleMyID();

            	    state._fsp--;


            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleElse3159); 
             
                newLeafNode(this_NEWLINE_2, grammarAccess.getElseAccess().getNEWLINETerminalRuleCall_2()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1273:1: ( (lv_instructions_3_0= ruleInstruction ) )*
            loop25:
            do {
                int alt25=2;
                switch ( input.LA(1) ) {
                case End:
                    {
                    int LA25_1 = input.LA(2);

                    if ( (LA25_1==RULE_SEQUENCE) ) {
                        alt25=1;
                    }


                    }
                    break;
                case Else:
                    {
                    int LA25_2 = input.LA(2);

                    if ( (LA25_2==RULE_SEQUENCE) ) {
                        alt25=1;
                    }


                    }
                    break;
                case Participant:
                case Autonumber:
                case Deactivate:
                case Endlegend:
                case Activate:
                case Boundary:
                case Critical:
                case Database:
                case Control:
                case Destroy:
                case Footbox:
                case Newpage:
                case Center:
                case Create:
                case Entity:
                case Legend:
                case Actor:
                case Break:
                case Group:
                case Right:
                case Title:
                case Hide:
                case Left:
                case Loop:
                case Note:
                case Over:
                case FullStopFullStopFullStop:
                case Alt:
                case Box:
                case Opt:
                case Par:
                case Ref:
                case VerticalLineVerticalLineVerticalLine:
                case EqualsSignEqualsSign:
                case Of:
                case VerticalLineVerticalLine:
                case NumberSign:
                case LeftParenthesis:
                case RightParenthesis:
                case Comma:
                case HyphenMinus:
                case FullStop:
                case Colon:
                case LessThanSign:
                case EqualsSign:
                case GreaterThanSign:
                case RULE_NEWLINE:
                case RULE_INT:
                case RULE_ID:
                    {
                    alt25=1;
                    }
                    break;

                }

                switch (alt25) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1274:1: (lv_instructions_3_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1274:1: (lv_instructions_3_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1275:3: lv_instructions_3_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleElse3179);
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
            	    break loop25;
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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1299:1: entryRuleGroupingMessages returns [EObject current=null] : iv_ruleGroupingMessages= ruleGroupingMessages EOF ;
    public final EObject entryRuleGroupingMessages() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupingMessages = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1300:2: (iv_ruleGroupingMessages= ruleGroupingMessages EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1301:2: iv_ruleGroupingMessages= ruleGroupingMessages EOF
            {
             newCompositeNode(grammarAccess.getGroupingMessagesRule()); 
            pushFollow(FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages3215);
            iv_ruleGroupingMessages=ruleGroupingMessages();

            state._fsp--;

             current =iv_ruleGroupingMessages; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroupingMessages3225); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1308:1: ruleGroupingMessages returns [EObject current=null] : ( (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End ) ;
    public final EObject ruleGroupingMessages() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token this_ID_6=null;
        Token this_NEWLINE_7=null;
        Token otherlv_9=null;
        EObject lv_instructions_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1311:28: ( ( (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1312:1: ( (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1312:1: ( (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1312:2: (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1312:2: (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group )
            int alt26=6;
            switch ( input.LA(1) ) {
            case Opt:
                {
                alt26=1;
                }
                break;
            case Loop:
                {
                alt26=2;
                }
                break;
            case Par:
                {
                alt26=3;
                }
                break;
            case Break:
                {
                alt26=4;
                }
                break;
            case Critical:
                {
                alt26=5;
                }
                break;
            case Group:
                {
                alt26=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1313:2: otherlv_0= Opt
                    {
                    otherlv_0=(Token)match(input,Opt,FOLLOW_Opt_in_ruleGroupingMessages3264); 

                        	newLeafNode(otherlv_0, grammarAccess.getGroupingMessagesAccess().getOptKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1319:2: otherlv_1= Loop
                    {
                    otherlv_1=(Token)match(input,Loop,FOLLOW_Loop_in_ruleGroupingMessages3282); 

                        	newLeafNode(otherlv_1, grammarAccess.getGroupingMessagesAccess().getLoopKeyword_0_1());
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1325:2: otherlv_2= Par
                    {
                    otherlv_2=(Token)match(input,Par,FOLLOW_Par_in_ruleGroupingMessages3300); 

                        	newLeafNode(otherlv_2, grammarAccess.getGroupingMessagesAccess().getParKeyword_0_2());
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1331:2: otherlv_3= Break
                    {
                    otherlv_3=(Token)match(input,Break,FOLLOW_Break_in_ruleGroupingMessages3318); 

                        	newLeafNode(otherlv_3, grammarAccess.getGroupingMessagesAccess().getBreakKeyword_0_3());
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1337:2: otherlv_4= Critical
                    {
                    otherlv_4=(Token)match(input,Critical,FOLLOW_Critical_in_ruleGroupingMessages3336); 

                        	newLeafNode(otherlv_4, grammarAccess.getGroupingMessagesAccess().getCriticalKeyword_0_4());
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1343:2: otherlv_5= Group
                    {
                    otherlv_5=(Token)match(input,Group,FOLLOW_Group_in_ruleGroupingMessages3354); 

                        	newLeafNode(otherlv_5, grammarAccess.getGroupingMessagesAccess().getGroupKeyword_0_5());
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1347:2: (this_ID_6= RULE_ID )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1347:3: this_ID_6= RULE_ID
            	    {
            	    this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGroupingMessages3366); 
            	     
            	        newLeafNode(this_ID_6, grammarAccess.getGroupingMessagesAccess().getIDTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleGroupingMessages3378); 
             
                newLeafNode(this_NEWLINE_7, grammarAccess.getGroupingMessagesAccess().getNEWLINETerminalRuleCall_2()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1355:1: ( (lv_instructions_8_0= ruleInstruction ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==End) ) {
                    int LA28_1 = input.LA(2);

                    if ( (LA28_1==RULE_SEQUENCE) ) {
                        alt28=1;
                    }


                }
                else if ( (LA28_0==Participant||(LA28_0>=Autonumber && LA28_0<=Deactivate)||LA28_0==Endlegend||(LA28_0>=Activate && LA28_0<=Database)||(LA28_0>=Control && LA28_0<=Newpage)||(LA28_0>=Center && LA28_0<=Legend)||(LA28_0>=Actor && LA28_0<=Title)||(LA28_0>=Else && LA28_0<=FullStopFullStopFullStop)||(LA28_0>=Alt && LA28_0<=Box)||(LA28_0>=Opt && LA28_0<=VerticalLineVerticalLineVerticalLine)||LA28_0==EqualsSignEqualsSign||(LA28_0>=Of && LA28_0<=VerticalLineVerticalLine)||(LA28_0>=NumberSign && LA28_0<=RULE_NEWLINE)||(LA28_0>=RULE_INT && LA28_0<=RULE_ID)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1356:1: (lv_instructions_8_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1356:1: (lv_instructions_8_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1357:3: lv_instructions_8_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGroupingMessagesAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleGroupingMessages3398);
            	    lv_instructions_8_0=ruleInstruction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGroupingMessagesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"instructions",
            	            		lv_instructions_8_0, 
            	            		"Instruction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            otherlv_9=(Token)match(input,End,FOLLOW_End_in_ruleGroupingMessages3412); 

                	newLeafNode(otherlv_9, grammarAccess.getGroupingMessagesAccess().getEndKeyword_4());
                

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1386:1: entryRuleNote returns [EObject current=null] : iv_ruleNote= ruleNote EOF ;
    public final EObject entryRuleNote() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNote = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1387:2: (iv_ruleNote= ruleNote EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1388:2: iv_ruleNote= ruleNote EOF
            {
             newCompositeNode(grammarAccess.getNoteRule()); 
            pushFollow(FOLLOW_ruleNote_in_entryRuleNote3446);
            iv_ruleNote=ruleNote();

            state._fsp--;

             current =iv_ruleNote; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNote3456); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1395:1: ruleNote returns [EObject current=null] : (otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) ( ruleColor )* ( (otherlv_16= Colon ( ruleMyID )* ) | ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note ) ) ) ;
    public final EObject ruleNote() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
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
        Token otherlv_16=null;
        Token this_NEWLINE_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1398:28: ( (otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) ( ruleColor )* ( (otherlv_16= Colon ( ruleMyID )* ) | ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1399:1: (otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) ( ruleColor )* ( (otherlv_16= Colon ( ruleMyID )* ) | ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1399:1: (otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) ( ruleColor )* ( (otherlv_16= Colon ( ruleMyID )* ) | ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1400:2: otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) ( ruleColor )* ( (otherlv_16= Colon ( ruleMyID )* ) | ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note ) )
            {
            otherlv_0=(Token)match(input,Note,FOLLOW_Note_in_ruleNote3494); 

                	newLeafNode(otherlv_0, grammarAccess.getNoteAccess().getNoteKeyword_0());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1404:1: ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) )
            int alt34=3;
            switch ( input.LA(1) ) {
            case Right:
                {
                alt34=1;
                }
                break;
            case Left:
                {
                alt34=2;
                }
                break;
            case Over:
                {
                alt34=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1404:2: (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1404:2: (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1405:2: otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )?
                    {
                    otherlv_1=(Token)match(input,Right,FOLLOW_Right_in_ruleNote3508); 

                        	newLeafNode(otherlv_1, grammarAccess.getNoteAccess().getRightKeyword_1_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1409:1: (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==Of) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1410:2: otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )*
                            {
                            otherlv_2=(Token)match(input,Of,FOLLOW_Of_in_ruleNote3521); 

                                	newLeafNode(otherlv_2, grammarAccess.getNoteAccess().getOfKeyword_1_0_1_0());
                                
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1414:1: ( (otherlv_3= RULE_ID ) )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1415:1: (otherlv_3= RULE_ID )
                            {
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1415:1: (otherlv_3= RULE_ID )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1416:3: otherlv_3= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getNoteRule());
                            	        }
                                    
                            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote3540); 

                            		newLeafNode(otherlv_3, grammarAccess.getNoteAccess().getRidDefinitionCrossReference_1_0_1_1_0()); 
                            	

                            }


                            }

                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1427:2: (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )*
                            loop29:
                            do {
                                int alt29=2;
                                int LA29_0 = input.LA(1);

                                if ( (LA29_0==Comma) ) {
                                    alt29=1;
                                }


                                switch (alt29) {
                            	case 1 :
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1428:2: otherlv_4= Comma ( (otherlv_5= RULE_ID ) )
                            	    {
                            	    otherlv_4=(Token)match(input,Comma,FOLLOW_Comma_in_ruleNote3554); 

                            	        	newLeafNode(otherlv_4, grammarAccess.getNoteAccess().getCommaKeyword_1_0_1_2_0());
                            	        
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1432:1: ( (otherlv_5= RULE_ID ) )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1433:1: (otherlv_5= RULE_ID )
                            	    {
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1433:1: (otherlv_5= RULE_ID )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1434:3: otherlv_5= RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = createModelElement(grammarAccess.getNoteRule());
                            	    	        }
                            	            
                            	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote3573); 

                            	    		newLeafNode(otherlv_5, grammarAccess.getNoteAccess().getRidsDefinitionCrossReference_1_0_1_2_1_0()); 
                            	    	

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
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1446:6: (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1446:6: (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1447:2: otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )?
                    {
                    otherlv_6=(Token)match(input,Left,FOLLOW_Left_in_ruleNote3598); 

                        	newLeafNode(otherlv_6, grammarAccess.getNoteAccess().getLeftKeyword_1_1_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1451:1: (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==Of) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1452:2: otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )*
                            {
                            otherlv_7=(Token)match(input,Of,FOLLOW_Of_in_ruleNote3611); 

                                	newLeafNode(otherlv_7, grammarAccess.getNoteAccess().getOfKeyword_1_1_1_0());
                                
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1456:1: ( (otherlv_8= RULE_ID ) )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1457:1: (otherlv_8= RULE_ID )
                            {
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1457:1: (otherlv_8= RULE_ID )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1458:3: otherlv_8= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getNoteRule());
                            	        }
                                    
                            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote3630); 

                            		newLeafNode(otherlv_8, grammarAccess.getNoteAccess().getLidDefinitionCrossReference_1_1_1_1_0()); 
                            	

                            }


                            }

                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1469:2: (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )*
                            loop31:
                            do {
                                int alt31=2;
                                int LA31_0 = input.LA(1);

                                if ( (LA31_0==Comma) ) {
                                    alt31=1;
                                }


                                switch (alt31) {
                            	case 1 :
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1470:2: otherlv_9= Comma ( (otherlv_10= RULE_ID ) )
                            	    {
                            	    otherlv_9=(Token)match(input,Comma,FOLLOW_Comma_in_ruleNote3644); 

                            	        	newLeafNode(otherlv_9, grammarAccess.getNoteAccess().getCommaKeyword_1_1_1_2_0());
                            	        
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1474:1: ( (otherlv_10= RULE_ID ) )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1475:1: (otherlv_10= RULE_ID )
                            	    {
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1475:1: (otherlv_10= RULE_ID )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1476:3: otherlv_10= RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = createModelElement(grammarAccess.getNoteRule());
                            	    	        }
                            	            
                            	    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote3663); 

                            	    		newLeafNode(otherlv_10, grammarAccess.getNoteAccess().getLidsDefinitionCrossReference_1_1_1_2_1_0()); 
                            	    	

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop31;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1488:6: (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1488:6: (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1489:2: otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )*
                    {
                    otherlv_11=(Token)match(input,Over,FOLLOW_Over_in_ruleNote3688); 

                        	newLeafNode(otherlv_11, grammarAccess.getNoteAccess().getOverKeyword_1_2_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1493:1: ( (otherlv_12= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1494:1: (otherlv_12= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1494:1: (otherlv_12= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1495:3: otherlv_12= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getNoteRule());
                    	        }
                            
                    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote3707); 

                    		newLeafNode(otherlv_12, grammarAccess.getNoteAccess().getOidDefinitionCrossReference_1_2_1_0()); 
                    	

                    }


                    }

                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1506:2: (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==Comma) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1507:2: otherlv_13= Comma ( (otherlv_14= RULE_ID ) )
                    	    {
                    	    otherlv_13=(Token)match(input,Comma,FOLLOW_Comma_in_ruleNote3721); 

                    	        	newLeafNode(otherlv_13, grammarAccess.getNoteAccess().getCommaKeyword_1_2_2_0());
                    	        
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1511:1: ( (otherlv_14= RULE_ID ) )
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1512:1: (otherlv_14= RULE_ID )
                    	    {
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1512:1: (otherlv_14= RULE_ID )
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1513:3: otherlv_14= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getNoteRule());
                    	    	        }
                    	            
                    	    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote3740); 

                    	    		newLeafNode(otherlv_14, grammarAccess.getNoteAccess().getOidsDefinitionCrossReference_1_2_2_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1524:6: ( ruleColor )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=LightGoldenRodYellow && LA35_0<=YellowGreen)||(LA35_0>=Aquamarine && LA35_0<=WhiteSmoke)||(LA35_0>=AliceBlue && LA35_0<=Turquoise)||(LA35_0>=Cornsilk && LA35_0<=SeaGreen)||(LA35_0>=Crimson && LA35_0<=Thistle)||(LA35_0>=Bisque && LA35_0<=Yellow)||(LA35_0>=Azure && LA35_0<=White)||(LA35_0>=Aqua && LA35_0<=Teal)||(LA35_0>=Red && LA35_0<=Tan)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1525:5: ruleColor
            	    {
            	     
            	            newCompositeNode(grammarAccess.getNoteAccess().getColorParserRuleCall_2()); 
            	        
            	    pushFollow(FOLLOW_ruleColor_in_ruleNote3761);
            	    ruleColor();

            	    state._fsp--;


            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1532:3: ( (otherlv_16= Colon ( ruleMyID )* ) | ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==Colon) ) {
                alt39=1;
            }
            else if ( (LA39_0==End||LA39_0==RULE_NEWLINE) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1532:4: (otherlv_16= Colon ( ruleMyID )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1532:4: (otherlv_16= Colon ( ruleMyID )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1533:2: otherlv_16= Colon ( ruleMyID )*
                    {
                    otherlv_16=(Token)match(input,Colon,FOLLOW_Colon_in_ruleNote3777); 

                        	newLeafNode(otherlv_16, grammarAccess.getNoteAccess().getColonKeyword_3_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1537:1: ( ruleMyID )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( ((LA36_0>=Autonumber && LA36_0<=Deactivate)||LA36_0==Endlegend||LA36_0==Activate||LA36_0==Critical||(LA36_0>=Destroy && LA36_0<=Newpage)||(LA36_0>=Center && LA36_0<=Create)||LA36_0==Legend||(LA36_0>=Break && LA36_0<=Title)||(LA36_0>=Else && LA36_0<=Over)||(LA36_0>=Alt && LA36_0<=Ref)||LA36_0==Of||(LA36_0>=NumberSign && LA36_0<=GreaterThanSign)||(LA36_0>=RULE_INT && LA36_0<=RULE_ID)) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1538:5: ruleMyID
                    	    {
                    	     
                    	            newCompositeNode(grammarAccess.getNoteAccess().getMyIDParserRuleCall_3_0_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleMyID_in_ruleNote3793);
                    	    ruleMyID();

                    	    state._fsp--;


                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1546:6: ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1546:6: ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1546:7: (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1546:7: (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==RULE_NEWLINE) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1546:8: this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )*
                    	    {
                    	    this_NEWLINE_18=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleNote3814); 
                    	     
                    	        newLeafNode(this_NEWLINE_18, grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_3_1_0_0()); 
                    	        
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1550:1: ( ruleEndID )*
                    	    loop37:
                    	    do {
                    	        int alt37=2;
                    	        int LA37_0 = input.LA(1);

                    	        if ( ((LA37_0>=Autonumber && LA37_0<=Deactivate)||LA37_0==Endlegend||LA37_0==Activate||LA37_0==Critical||(LA37_0>=Destroy && LA37_0<=Newpage)||(LA37_0>=Center && LA37_0<=Create)||LA37_0==Legend||(LA37_0>=Break && LA37_0<=Title)||(LA37_0>=Else && LA37_0<=Over)||(LA37_0>=Alt && LA37_0<=Box)||(LA37_0>=Opt && LA37_0<=Ref)||LA37_0==Of||(LA37_0>=NumberSign && LA37_0<=GreaterThanSign)||(LA37_0>=RULE_INT && LA37_0<=RULE_ID)) ) {
                    	            alt37=1;
                    	        }


                    	        switch (alt37) {
                    	    	case 1 :
                    	    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1551:5: ruleEndID
                    	    	    {
                    	    	     
                    	    	            newCompositeNode(grammarAccess.getNoteAccess().getEndIDParserRuleCall_3_1_0_1()); 
                    	    	        
                    	    	    pushFollow(FOLLOW_ruleEndID_in_ruleNote3830);
                    	    	    ruleEndID();

                    	    	    state._fsp--;


                    	    	            afterParserOrEnumRuleCall();
                    	    	        

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop37;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,End,FOLLOW_End_in_ruleNote3846); 

                        	newLeafNode(otherlv_20, grammarAccess.getNoteAccess().getEndKeyword_3_1_1());
                        
                    otherlv_21=(Token)match(input,Note,FOLLOW_Note_in_ruleNote3858); 

                        	newLeafNode(otherlv_21, grammarAccess.getNoteAccess().getNoteKeyword_3_1_2());
                        

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1576:1: entryRuleDivider returns [String current=null] : iv_ruleDivider= ruleDivider EOF ;
    public final String entryRuleDivider() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDivider = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1577:1: (iv_ruleDivider= ruleDivider EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1578:2: iv_ruleDivider= ruleDivider EOF
            {
             newCompositeNode(grammarAccess.getDividerRule()); 
            pushFollow(FOLLOW_ruleDivider_in_entryRuleDivider3895);
            iv_ruleDivider=ruleDivider();

            state._fsp--;

             current =iv_ruleDivider.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDivider3906); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1585:1: ruleDivider returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign ) ;
    public final AntlrDatatypeRuleToken ruleDivider() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1589:6: ( (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1590:1: (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1590:1: (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1591:2: kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign
            {
            kw=(Token)match(input,EqualsSignEqualsSign,FOLLOW_EqualsSignEqualsSign_in_ruleDivider3944); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDividerAccess().getEqualsSignEqualsSignKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1596:1: (this_ID_1= RULE_ID )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_ID) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1596:6: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDivider3960); 

            	    		current.merge(this_ID_1);
            	        
            	     
            	        newLeafNode(this_ID_1, grammarAccess.getDividerAccess().getIDTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            kw=(Token)match(input,EqualsSignEqualsSign,FOLLOW_EqualsSignEqualsSign_in_ruleDivider3980); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1617:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1618:2: (iv_ruleReference= ruleReference EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1619:2: iv_ruleReference= ruleReference EOF
            {
             newCompositeNode(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference4019);
            iv_ruleReference=ruleReference();

            state._fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference4029); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1626:1: ruleReference returns [EObject current=null] : (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon ( ruleMyID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref ) ) ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token this_NEWLINE_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1629:28: ( (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon ( ruleMyID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1630:1: (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon ( ruleMyID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1630:1: (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon ( ruleMyID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1631:2: otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon ( ruleMyID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref ) )
            {
            otherlv_0=(Token)match(input,Ref,FOLLOW_Ref_in_ruleReference4067); 

                	newLeafNode(otherlv_0, grammarAccess.getReferenceAccess().getRefKeyword_0());
                
            otherlv_1=(Token)match(input,Over,FOLLOW_Over_in_ruleReference4079); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceAccess().getOverKeyword_1());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1640:1: ( (otherlv_2= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1641:1: (otherlv_2= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1641:1: (otherlv_2= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1642:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference4098); 

            		newLeafNode(otherlv_2, grammarAccess.getReferenceAccess().getIdDefinitionCrossReference_2_0()); 
            	

            }


            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1653:2: (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==Comma) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1654:2: otherlv_3= Comma ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,Comma,FOLLOW_Comma_in_ruleReference4112); 

            	        	newLeafNode(otherlv_3, grammarAccess.getReferenceAccess().getCommaKeyword_3_0());
            	        
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1658:1: ( (otherlv_4= RULE_ID ) )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1659:1: (otherlv_4= RULE_ID )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1659:1: (otherlv_4= RULE_ID )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1660:3: otherlv_4= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getReferenceRule());
            	    	        }
            	            
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference4131); 

            	    		newLeafNode(otherlv_4, grammarAccess.getReferenceAccess().getIdsDefinitionCrossReference_3_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1671:4: ( (otherlv_5= Colon ( ruleMyID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==Colon) ) {
                alt45=1;
            }
            else if ( (LA45_0==End||LA45_0==RULE_NEWLINE) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1671:5: (otherlv_5= Colon ( ruleMyID )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1671:5: (otherlv_5= Colon ( ruleMyID )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1672:2: otherlv_5= Colon ( ruleMyID )*
                    {
                    otherlv_5=(Token)match(input,Colon,FOLLOW_Colon_in_ruleReference4148); 

                        	newLeafNode(otherlv_5, grammarAccess.getReferenceAccess().getColonKeyword_4_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1676:1: ( ruleMyID )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( ((LA42_0>=Autonumber && LA42_0<=Deactivate)||LA42_0==Endlegend||LA42_0==Activate||LA42_0==Critical||(LA42_0>=Destroy && LA42_0<=Newpage)||(LA42_0>=Center && LA42_0<=Create)||LA42_0==Legend||(LA42_0>=Break && LA42_0<=Title)||(LA42_0>=Else && LA42_0<=Over)||(LA42_0>=Alt && LA42_0<=Ref)||LA42_0==Of||(LA42_0>=NumberSign && LA42_0<=GreaterThanSign)||(LA42_0>=RULE_INT && LA42_0<=RULE_ID)) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1677:5: ruleMyID
                    	    {
                    	     
                    	            newCompositeNode(grammarAccess.getReferenceAccess().getMyIDParserRuleCall_4_0_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleMyID_in_ruleReference4164);
                    	    ruleMyID();

                    	    state._fsp--;


                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1685:6: ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1685:6: ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1685:7: (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1685:7: (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==RULE_NEWLINE) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1685:8: this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )*
                    	    {
                    	    this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleReference4185); 
                    	     
                    	        newLeafNode(this_NEWLINE_7, grammarAccess.getReferenceAccess().getNEWLINETerminalRuleCall_4_1_0_0()); 
                    	        
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1689:1: ( ruleEndID )*
                    	    loop43:
                    	    do {
                    	        int alt43=2;
                    	        int LA43_0 = input.LA(1);

                    	        if ( ((LA43_0>=Autonumber && LA43_0<=Deactivate)||LA43_0==Endlegend||LA43_0==Activate||LA43_0==Critical||(LA43_0>=Destroy && LA43_0<=Newpage)||(LA43_0>=Center && LA43_0<=Create)||LA43_0==Legend||(LA43_0>=Break && LA43_0<=Title)||(LA43_0>=Else && LA43_0<=Over)||(LA43_0>=Alt && LA43_0<=Box)||(LA43_0>=Opt && LA43_0<=Ref)||LA43_0==Of||(LA43_0>=NumberSign && LA43_0<=GreaterThanSign)||(LA43_0>=RULE_INT && LA43_0<=RULE_ID)) ) {
                    	            alt43=1;
                    	        }


                    	        switch (alt43) {
                    	    	case 1 :
                    	    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1690:5: ruleEndID
                    	    	    {
                    	    	     
                    	    	            newCompositeNode(grammarAccess.getReferenceAccess().getEndIDParserRuleCall_4_1_0_1()); 
                    	    	        
                    	    	    pushFollow(FOLLOW_ruleEndID_in_ruleReference4201);
                    	    	    ruleEndID();

                    	    	    state._fsp--;


                    	    	            afterParserOrEnumRuleCall();
                    	    	        

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop43;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,End,FOLLOW_End_in_ruleReference4217); 

                        	newLeafNode(otherlv_9, grammarAccess.getReferenceAccess().getEndKeyword_4_1_1());
                        
                    otherlv_10=(Token)match(input,Ref,FOLLOW_Ref_in_ruleReference4229); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1715:1: entryRuleDelay returns [String current=null] : iv_ruleDelay= ruleDelay EOF ;
    public final String entryRuleDelay() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDelay = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1716:1: (iv_ruleDelay= ruleDelay EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1717:2: iv_ruleDelay= ruleDelay EOF
            {
             newCompositeNode(grammarAccess.getDelayRule()); 
            pushFollow(FOLLOW_ruleDelay_in_entryRuleDelay4266);
            iv_ruleDelay=ruleDelay();

            state._fsp--;

             current =iv_ruleDelay.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDelay4277); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1724:1: ruleDelay returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? ) ;
    public final AntlrDatatypeRuleToken ruleDelay() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1728:6: ( (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1729:1: (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1729:1: (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1730:2: kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )?
            {
            kw=(Token)match(input,FullStopFullStopFullStop,FOLLOW_FullStopFullStopFullStop_in_ruleDelay4315); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1735:1: ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==FullStopFullStopFullStop||LA47_0==RULE_ID) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1735:2: (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1735:2: (this_ID_1= RULE_ID )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==RULE_ID) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1735:7: this_ID_1= RULE_ID
                    	    {
                    	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDelay4332); 

                    	    		current.merge(this_ID_1);
                    	        
                    	     
                    	        newLeafNode(this_ID_1, grammarAccess.getDelayAccess().getIDTerminalRuleCall_1_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);

                    kw=(Token)match(input,FullStopFullStopFullStop,FOLLOW_FullStopFullStopFullStop_in_ruleDelay4352); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1756:1: entryRuleSpace returns [String current=null] : iv_ruleSpace= ruleSpace EOF ;
    public final String entryRuleSpace() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSpace = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1757:1: (iv_ruleSpace= ruleSpace EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1758:2: iv_ruleSpace= ruleSpace EOF
            {
             newCompositeNode(grammarAccess.getSpaceRule()); 
            pushFollow(FOLLOW_ruleSpace_in_entryRuleSpace4394);
            iv_ruleSpace=ruleSpace();

            state._fsp--;

             current =iv_ruleSpace.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpace4405); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1765:1: ruleSpace returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine ) ) ;
    public final AntlrDatatypeRuleToken ruleSpace() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1769:6: ( (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1770:1: (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1770:1: (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==VerticalLineVerticalLineVerticalLine) ) {
                alt48=1;
            }
            else if ( (LA48_0==VerticalLineVerticalLine) ) {
                alt48=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1771:2: kw= VerticalLineVerticalLineVerticalLine
                    {
                    kw=(Token)match(input,VerticalLineVerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLineVerticalLine_in_ruleSpace4443); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSpaceAccess().getVerticalLineVerticalLineVerticalLineKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1777:6: (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1777:6: (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1778:2: kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine
                    {
                    kw=(Token)match(input,VerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLine_in_ruleSpace4463); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSpaceAccess().getVerticalLineVerticalLineKeyword_1_0()); 
                        
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpace4478); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getSpaceAccess().getINTTerminalRuleCall_1_1()); 
                        
                    kw=(Token)match(input,VerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLine_in_ruleSpace4496); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1804:1: entryRuleHidefootbox returns [String current=null] : iv_ruleHidefootbox= ruleHidefootbox EOF ;
    public final String entryRuleHidefootbox() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHidefootbox = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1805:1: (iv_ruleHidefootbox= ruleHidefootbox EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1806:2: iv_ruleHidefootbox= ruleHidefootbox EOF
            {
             newCompositeNode(grammarAccess.getHidefootboxRule()); 
            pushFollow(FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox4537);
            iv_ruleHidefootbox=ruleHidefootbox();

            state._fsp--;

             current =iv_ruleHidefootbox.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHidefootbox4548); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1813:1: ruleHidefootbox returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Hide kw= Footbox ) ;
    public final AntlrDatatypeRuleToken ruleHidefootbox() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1817:6: ( (kw= Hide kw= Footbox ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1818:1: (kw= Hide kw= Footbox )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1818:1: (kw= Hide kw= Footbox )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1819:2: kw= Hide kw= Footbox
            {
            kw=(Token)match(input,Hide,FOLLOW_Hide_in_ruleHidefootbox4586); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getHidefootboxAccess().getHideKeyword_0()); 
                
            kw=(Token)match(input,Footbox,FOLLOW_Footbox_in_ruleHidefootbox4599); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1838:1: entryRuleActivate returns [EObject current=null] : iv_ruleActivate= ruleActivate EOF ;
    public final EObject entryRuleActivate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActivate = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1839:2: (iv_ruleActivate= ruleActivate EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1840:2: iv_ruleActivate= ruleActivate EOF
            {
             newCompositeNode(grammarAccess.getActivateRule()); 
            pushFollow(FOLLOW_ruleActivate_in_entryRuleActivate4638);
            iv_ruleActivate=ruleActivate();

            state._fsp--;

             current =iv_ruleActivate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActivate4648); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1847:1: ruleActivate returns [EObject current=null] : (otherlv_0= Activate ( ruleColor )? ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleActivate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1850:28: ( (otherlv_0= Activate ( ruleColor )? ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1851:1: (otherlv_0= Activate ( ruleColor )? ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1851:1: (otherlv_0= Activate ( ruleColor )? ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1852:2: otherlv_0= Activate ( ruleColor )? ( (lv_name_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,Activate,FOLLOW_Activate_in_ruleActivate4686); 

                	newLeafNode(otherlv_0, grammarAccess.getActivateAccess().getActivateKeyword_0());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1856:1: ( ruleColor )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=LightGoldenRodYellow && LA49_0<=YellowGreen)||(LA49_0>=Aquamarine && LA49_0<=WhiteSmoke)||(LA49_0>=AliceBlue && LA49_0<=Turquoise)||(LA49_0>=Cornsilk && LA49_0<=SeaGreen)||(LA49_0>=Crimson && LA49_0<=Thistle)||(LA49_0>=Bisque && LA49_0<=Yellow)||(LA49_0>=Azure && LA49_0<=White)||(LA49_0>=Aqua && LA49_0<=Teal)||(LA49_0>=Red && LA49_0<=Tan)) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1857:5: ruleColor
                    {
                     
                            newCompositeNode(grammarAccess.getActivateAccess().getColorParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleColor_in_ruleActivate4702);
                    ruleColor();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1864:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1865:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1865:1: (lv_name_2_0= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1866:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActivate4720); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1890:1: entryRuleDeactivate returns [EObject current=null] : iv_ruleDeactivate= ruleDeactivate EOF ;
    public final EObject entryRuleDeactivate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeactivate = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1891:2: (iv_ruleDeactivate= ruleDeactivate EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1892:2: iv_ruleDeactivate= ruleDeactivate EOF
            {
             newCompositeNode(grammarAccess.getDeactivateRule()); 
            pushFollow(FOLLOW_ruleDeactivate_in_entryRuleDeactivate4760);
            iv_ruleDeactivate=ruleDeactivate();

            state._fsp--;

             current =iv_ruleDeactivate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeactivate4770); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1899:1: ruleDeactivate returns [EObject current=null] : ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleDeactivate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1902:28: ( ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1903:1: ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1903:1: ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1903:2: (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1903:2: (otherlv_0= Deactivate | otherlv_1= Destroy )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==Deactivate) ) {
                alt50=1;
            }
            else if ( (LA50_0==Destroy) ) {
                alt50=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1904:2: otherlv_0= Deactivate
                    {
                    otherlv_0=(Token)match(input,Deactivate,FOLLOW_Deactivate_in_ruleDeactivate4809); 

                        	newLeafNode(otherlv_0, grammarAccess.getDeactivateAccess().getDeactivateKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1910:2: otherlv_1= Destroy
                    {
                    otherlv_1=(Token)match(input,Destroy,FOLLOW_Destroy_in_ruleDeactivate4827); 

                        	newLeafNode(otherlv_1, grammarAccess.getDeactivateAccess().getDestroyKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1914:2: ( (otherlv_2= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1915:1: (otherlv_2= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1915:1: (otherlv_2= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1916:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDeactivateRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeactivate4847); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1935:1: entryRuleParticipantCreation returns [String current=null] : iv_ruleParticipantCreation= ruleParticipantCreation EOF ;
    public final String entryRuleParticipantCreation() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleParticipantCreation = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1936:1: (iv_ruleParticipantCreation= ruleParticipantCreation EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1937:2: iv_ruleParticipantCreation= ruleParticipantCreation EOF
            {
             newCompositeNode(grammarAccess.getParticipantCreationRule()); 
            pushFollow(FOLLOW_ruleParticipantCreation_in_entryRuleParticipantCreation4883);
            iv_ruleParticipantCreation=ruleParticipantCreation();

            state._fsp--;

             current =iv_ruleParticipantCreation.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParticipantCreation4894); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1944:1: ruleParticipantCreation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Create this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleParticipantCreation() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1948:6: ( (kw= Create this_ID_1= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1949:1: (kw= Create this_ID_1= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1949:1: (kw= Create this_ID_1= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1950:2: kw= Create this_ID_1= RULE_ID
            {
            kw=(Token)match(input,Create,FOLLOW_Create_in_ruleParticipantCreation4932); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getParticipantCreationAccess().getCreateKeyword_0()); 
                
            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParticipantCreation4947); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1970:1: entryRuleBox returns [EObject current=null] : iv_ruleBox= ruleBox EOF ;
    public final EObject entryRuleBox() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBox = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1971:2: (iv_ruleBox= ruleBox EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1972:2: iv_ruleBox= ruleBox EOF
            {
             newCompositeNode(grammarAccess.getBoxRule()); 
            pushFollow(FOLLOW_ruleBox_in_entryRuleBox4991);
            iv_ruleBox=ruleBox();

            state._fsp--;

             current =iv_ruleBox; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBox5001); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1979:1: ruleBox returns [EObject current=null] : (otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark ( ruleColor )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box ) ;
    public final EObject ruleBox() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_ID_2=null;
        Token otherlv_3=null;
        Token this_NEWLINE_5=null;
        Token this_NEWLINE_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_definitions_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1982:28: ( (otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark ( ruleColor )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1983:1: (otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark ( ruleColor )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1983:1: (otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark ( ruleColor )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1984:2: otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark ( ruleColor )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box
            {
            otherlv_0=(Token)match(input,Box,FOLLOW_Box_in_ruleBox5039); 

                	newLeafNode(otherlv_0, grammarAccess.getBoxAccess().getBoxKeyword_0());
                
            otherlv_1=(Token)match(input,QuotationMark,FOLLOW_QuotationMark_in_ruleBox5051); 

                	newLeafNode(otherlv_1, grammarAccess.getBoxAccess().getQuotationMarkKeyword_1());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1993:1: (this_ID_2= RULE_ID )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_ID) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1993:2: this_ID_2= RULE_ID
            	    {
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBox5062); 
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getBoxAccess().getIDTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

            otherlv_3=(Token)match(input,QuotationMark,FOLLOW_QuotationMark_in_ruleBox5076); 

                	newLeafNode(otherlv_3, grammarAccess.getBoxAccess().getQuotationMarkKeyword_3());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2002:1: ( ruleColor )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=LightGoldenRodYellow && LA52_0<=YellowGreen)||(LA52_0>=Aquamarine && LA52_0<=WhiteSmoke)||(LA52_0>=AliceBlue && LA52_0<=Turquoise)||(LA52_0>=Cornsilk && LA52_0<=SeaGreen)||(LA52_0>=Crimson && LA52_0<=Thistle)||(LA52_0>=Bisque && LA52_0<=Yellow)||(LA52_0>=Azure && LA52_0<=White)||(LA52_0>=Aqua && LA52_0<=Teal)||(LA52_0>=Red && LA52_0<=Tan)) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2003:5: ruleColor
                    {
                     
                            newCompositeNode(grammarAccess.getBoxAccess().getColorParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleColor_in_ruleBox5092);
                    ruleColor();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleBox5104); 
             
                newLeafNode(this_NEWLINE_5, grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_5()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2014:1: ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==Participant||LA54_0==Boundary||LA54_0==Database||LA54_0==Control||LA54_0==Entity||LA54_0==Actor||LA54_0==RULE_NEWLINE) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2014:2: ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2014:2: ( (lv_definitions_6_0= ruleDefinition ) )?
            	    int alt53=2;
            	    int LA53_0 = input.LA(1);

            	    if ( (LA53_0==Participant||LA53_0==Boundary||LA53_0==Database||LA53_0==Control||LA53_0==Entity||LA53_0==Actor) ) {
            	        alt53=1;
            	    }
            	    switch (alt53) {
            	        case 1 :
            	            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2015:1: (lv_definitions_6_0= ruleDefinition )
            	            {
            	            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2015:1: (lv_definitions_6_0= ruleDefinition )
            	            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2016:3: lv_definitions_6_0= ruleDefinition
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getBoxAccess().getDefinitionsDefinitionParserRuleCall_6_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleDefinition_in_ruleBox5125);
            	            lv_definitions_6_0=ruleDefinition();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getBoxRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"definitions",
            	                    		lv_definitions_6_0, 
            	                    		"Definition");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }
            	            break;

            	    }

            	    this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleBox5137); 
            	     
            	        newLeafNode(this_NEWLINE_7, grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_6_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            otherlv_8=(Token)match(input,End,FOLLOW_End_in_ruleBox5151); 

                	newLeafNode(otherlv_8, grammarAccess.getBoxAccess().getEndKeyword_7());
                
            otherlv_9=(Token)match(input,Box,FOLLOW_Box_in_ruleBox5163); 

                	newLeafNode(otherlv_9, grammarAccess.getBoxAccess().getBoxKeyword_8());
                

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


    // $ANTLR start "entryRuleColors"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2054:1: entryRuleColors returns [String current=null] : iv_ruleColors= ruleColors EOF ;
    public final String entryRuleColors() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleColors = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2055:1: (iv_ruleColors= ruleColors EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2056:2: iv_ruleColors= ruleColors EOF
            {
             newCompositeNode(grammarAccess.getColorsRule()); 
            pushFollow(FOLLOW_ruleColors_in_entryRuleColors5198);
            iv_ruleColors=ruleColors();

            state._fsp--;

             current =iv_ruleColors.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColors5209); 

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
    // $ANTLR end "entryRuleColors"


    // $ANTLR start "ruleColors"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2063:1: ruleColors returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= NumberSign (this_Color_1= ruleColor | this_HEXCODE_2= RULE_HEXCODE ) ) ;
    public final AntlrDatatypeRuleToken ruleColors() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_HEXCODE_2=null;
        AntlrDatatypeRuleToken this_Color_1 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2067:6: ( (kw= NumberSign (this_Color_1= ruleColor | this_HEXCODE_2= RULE_HEXCODE ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2068:1: (kw= NumberSign (this_Color_1= ruleColor | this_HEXCODE_2= RULE_HEXCODE ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2068:1: (kw= NumberSign (this_Color_1= ruleColor | this_HEXCODE_2= RULE_HEXCODE ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2069:2: kw= NumberSign (this_Color_1= ruleColor | this_HEXCODE_2= RULE_HEXCODE )
            {
            kw=(Token)match(input,NumberSign,FOLLOW_NumberSign_in_ruleColors5247); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getColorsAccess().getNumberSignKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2074:1: (this_Color_1= ruleColor | this_HEXCODE_2= RULE_HEXCODE )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=LightGoldenRodYellow && LA55_0<=YellowGreen)||(LA55_0>=Aquamarine && LA55_0<=WhiteSmoke)||(LA55_0>=AliceBlue && LA55_0<=Turquoise)||(LA55_0>=Cornsilk && LA55_0<=SeaGreen)||(LA55_0>=Crimson && LA55_0<=Thistle)||(LA55_0>=Bisque && LA55_0<=Yellow)||(LA55_0>=Azure && LA55_0<=White)||(LA55_0>=Aqua && LA55_0<=Teal)||(LA55_0>=Red && LA55_0<=Tan)) ) {
                alt55=1;
            }
            else if ( (LA55_0==RULE_HEXCODE) ) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2075:5: this_Color_1= ruleColor
                    {
                     
                            newCompositeNode(grammarAccess.getColorsAccess().getColorParserRuleCall_1_0()); 
                        
                    pushFollow(FOLLOW_ruleColor_in_ruleColors5270);
                    this_Color_1=ruleColor();

                    state._fsp--;


                    		current.merge(this_Color_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2086:10: this_HEXCODE_2= RULE_HEXCODE
                    {
                    this_HEXCODE_2=(Token)match(input,RULE_HEXCODE,FOLLOW_RULE_HEXCODE_in_ruleColors5296); 

                    		current.merge(this_HEXCODE_2);
                        
                     
                        newLeafNode(this_HEXCODE_2, grammarAccess.getColorsAccess().getHEXCODETerminalRuleCall_1_1()); 
                        

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
    // $ANTLR end "ruleColors"


    // $ANTLR start "entryRuleColor"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2101:1: entryRuleColor returns [String current=null] : iv_ruleColor= ruleColor EOF ;
    public final String entryRuleColor() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleColor = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2102:1: (iv_ruleColor= ruleColor EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2103:2: iv_ruleColor= ruleColor EOF
            {
             newCompositeNode(grammarAccess.getColorRule()); 
            pushFollow(FOLLOW_ruleColor_in_entryRuleColor5342);
            iv_ruleColor=ruleColor();

            state._fsp--;

             current =iv_ruleColor.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColor5353); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2110:1: ruleColor returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= AliceBlue | kw= AntiqueWhite | kw= Aqua | kw= Aquamarine | kw= Azure | kw= Beige | kw= Bisque | kw= Black | kw= BlanchedAlmond | kw= Blue | kw= BlueViolet | kw= Brown | kw= BurlyWood | kw= CadetBlue | kw= Chartreuse | kw= Chocolate | kw= Coral | kw= CornflowerBlue | kw= Cornsilk | kw= Crimson | kw= Cyan | kw= DarkBlue | kw= DarkCyan | kw= DarkGoldenRod | kw= DarkGray | kw= DarkGreen | kw= DarkGrey | kw= DarkKhaki | kw= DarkMagenta | kw= DarkOliveGreen | kw= DarkOrchid | kw= DarkRed | kw= DarkSalmo | kw= DarkSeaGreen | kw= DarkSlateBlue | kw= DarkSlateGray | kw= DarkSlateGrey | kw= DarkTurquoise | kw= DarkViolet | kw= Darkorange | kw= DeepPink | kw= DeepSkyBlue | kw= DimGray | kw= DimGrey | kw= DodgerBlue | kw= FireBrick | kw= FloralWhite | kw= ForestGreen | kw= Fuchsia | kw= Gainsboro | kw= GhostWhite | kw= Gold | kw= GoldenRod | kw= Gray | kw= Green | kw= GreenYellow | kw= Grey | kw= HoneyDew | kw= HotPink | kw= IndianRed | kw= Indigo | kw= Ivory | kw= Khaki | kw= Lavender | kw= LavenderBlush | kw= LawnGreen | kw= LemonChiffon | kw= LightBlue | kw= LightCoral | kw= LightCyan | kw= LightGoldenRodYellow | kw= LightGray | kw= LightGreen | kw= LightGrey | kw= LightPink | kw= LightSalmon | kw= LightSeaGreen | kw= LightSkyBlue | kw= LightSlateGray | kw= LightSlateGrey | kw= LightSteelBlue | kw= LightYellow | kw= Lime | kw= LimeGreen | kw= Linen | kw= Magenta | kw= Maroon | kw= MediumAquaMarine | kw= MediumBlue | kw= MediumOrchid | kw= MediumPurple | kw= MediumSeaGreen | kw= MediumSlateBlue | kw= MediumSpringGreen | kw= MediumTurquoise | kw= MediumVioletRed | kw= MidnightBlue | kw= MintCream | kw= MistyRose | kw= Moccasin | kw= NavajoWhite | kw= Navy | kw= OldLace | kw= Olive | kw= OliveDrab | kw= OrangeRed | kw= Orchid | kw= PaleGoldenRod | kw= PaleGreen | kw= PaleTurquoise | kw= PaleVioletRed | kw= PapayaWhip | kw= PeachPuff | kw= Peru | kw= Pink | kw= Plum | kw= PowderBlue | kw= Purple | kw= Red | kw= RosyBrown | kw= RoyalBlue | kw= SaddleBrown | kw= Salmon | kw= SandyBrown | kw= SeaGreen | kw= Sienna | kw= Silver | kw= SkyBlue | kw= SlateBlue | kw= SlateGray | kw= SlateGrey | kw= Snow | kw= SpringGreen | kw= SteelBlue | kw= Tan | kw= Teal | kw= Thistle | kw= Tomato | kw= Turquoise | kw= Violet | kw= Wheat | kw= White | kw= WhiteSmoke | kw= Yellow | kw= YellowGreen ) ;
    public final AntlrDatatypeRuleToken ruleColor() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2114:6: ( (kw= AliceBlue | kw= AntiqueWhite | kw= Aqua | kw= Aquamarine | kw= Azure | kw= Beige | kw= Bisque | kw= Black | kw= BlanchedAlmond | kw= Blue | kw= BlueViolet | kw= Brown | kw= BurlyWood | kw= CadetBlue | kw= Chartreuse | kw= Chocolate | kw= Coral | kw= CornflowerBlue | kw= Cornsilk | kw= Crimson | kw= Cyan | kw= DarkBlue | kw= DarkCyan | kw= DarkGoldenRod | kw= DarkGray | kw= DarkGreen | kw= DarkGrey | kw= DarkKhaki | kw= DarkMagenta | kw= DarkOliveGreen | kw= DarkOrchid | kw= DarkRed | kw= DarkSalmo | kw= DarkSeaGreen | kw= DarkSlateBlue | kw= DarkSlateGray | kw= DarkSlateGrey | kw= DarkTurquoise | kw= DarkViolet | kw= Darkorange | kw= DeepPink | kw= DeepSkyBlue | kw= DimGray | kw= DimGrey | kw= DodgerBlue | kw= FireBrick | kw= FloralWhite | kw= ForestGreen | kw= Fuchsia | kw= Gainsboro | kw= GhostWhite | kw= Gold | kw= GoldenRod | kw= Gray | kw= Green | kw= GreenYellow | kw= Grey | kw= HoneyDew | kw= HotPink | kw= IndianRed | kw= Indigo | kw= Ivory | kw= Khaki | kw= Lavender | kw= LavenderBlush | kw= LawnGreen | kw= LemonChiffon | kw= LightBlue | kw= LightCoral | kw= LightCyan | kw= LightGoldenRodYellow | kw= LightGray | kw= LightGreen | kw= LightGrey | kw= LightPink | kw= LightSalmon | kw= LightSeaGreen | kw= LightSkyBlue | kw= LightSlateGray | kw= LightSlateGrey | kw= LightSteelBlue | kw= LightYellow | kw= Lime | kw= LimeGreen | kw= Linen | kw= Magenta | kw= Maroon | kw= MediumAquaMarine | kw= MediumBlue | kw= MediumOrchid | kw= MediumPurple | kw= MediumSeaGreen | kw= MediumSlateBlue | kw= MediumSpringGreen | kw= MediumTurquoise | kw= MediumVioletRed | kw= MidnightBlue | kw= MintCream | kw= MistyRose | kw= Moccasin | kw= NavajoWhite | kw= Navy | kw= OldLace | kw= Olive | kw= OliveDrab | kw= OrangeRed | kw= Orchid | kw= PaleGoldenRod | kw= PaleGreen | kw= PaleTurquoise | kw= PaleVioletRed | kw= PapayaWhip | kw= PeachPuff | kw= Peru | kw= Pink | kw= Plum | kw= PowderBlue | kw= Purple | kw= Red | kw= RosyBrown | kw= RoyalBlue | kw= SaddleBrown | kw= Salmon | kw= SandyBrown | kw= SeaGreen | kw= Sienna | kw= Silver | kw= SkyBlue | kw= SlateBlue | kw= SlateGray | kw= SlateGrey | kw= Snow | kw= SpringGreen | kw= SteelBlue | kw= Tan | kw= Teal | kw= Thistle | kw= Tomato | kw= Turquoise | kw= Violet | kw= Wheat | kw= White | kw= WhiteSmoke | kw= Yellow | kw= YellowGreen ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2115:1: (kw= AliceBlue | kw= AntiqueWhite | kw= Aqua | kw= Aquamarine | kw= Azure | kw= Beige | kw= Bisque | kw= Black | kw= BlanchedAlmond | kw= Blue | kw= BlueViolet | kw= Brown | kw= BurlyWood | kw= CadetBlue | kw= Chartreuse | kw= Chocolate | kw= Coral | kw= CornflowerBlue | kw= Cornsilk | kw= Crimson | kw= Cyan | kw= DarkBlue | kw= DarkCyan | kw= DarkGoldenRod | kw= DarkGray | kw= DarkGreen | kw= DarkGrey | kw= DarkKhaki | kw= DarkMagenta | kw= DarkOliveGreen | kw= DarkOrchid | kw= DarkRed | kw= DarkSalmo | kw= DarkSeaGreen | kw= DarkSlateBlue | kw= DarkSlateGray | kw= DarkSlateGrey | kw= DarkTurquoise | kw= DarkViolet | kw= Darkorange | kw= DeepPink | kw= DeepSkyBlue | kw= DimGray | kw= DimGrey | kw= DodgerBlue | kw= FireBrick | kw= FloralWhite | kw= ForestGreen | kw= Fuchsia | kw= Gainsboro | kw= GhostWhite | kw= Gold | kw= GoldenRod | kw= Gray | kw= Green | kw= GreenYellow | kw= Grey | kw= HoneyDew | kw= HotPink | kw= IndianRed | kw= Indigo | kw= Ivory | kw= Khaki | kw= Lavender | kw= LavenderBlush | kw= LawnGreen | kw= LemonChiffon | kw= LightBlue | kw= LightCoral | kw= LightCyan | kw= LightGoldenRodYellow | kw= LightGray | kw= LightGreen | kw= LightGrey | kw= LightPink | kw= LightSalmon | kw= LightSeaGreen | kw= LightSkyBlue | kw= LightSlateGray | kw= LightSlateGrey | kw= LightSteelBlue | kw= LightYellow | kw= Lime | kw= LimeGreen | kw= Linen | kw= Magenta | kw= Maroon | kw= MediumAquaMarine | kw= MediumBlue | kw= MediumOrchid | kw= MediumPurple | kw= MediumSeaGreen | kw= MediumSlateBlue | kw= MediumSpringGreen | kw= MediumTurquoise | kw= MediumVioletRed | kw= MidnightBlue | kw= MintCream | kw= MistyRose | kw= Moccasin | kw= NavajoWhite | kw= Navy | kw= OldLace | kw= Olive | kw= OliveDrab | kw= OrangeRed | kw= Orchid | kw= PaleGoldenRod | kw= PaleGreen | kw= PaleTurquoise | kw= PaleVioletRed | kw= PapayaWhip | kw= PeachPuff | kw= Peru | kw= Pink | kw= Plum | kw= PowderBlue | kw= Purple | kw= Red | kw= RosyBrown | kw= RoyalBlue | kw= SaddleBrown | kw= Salmon | kw= SandyBrown | kw= SeaGreen | kw= Sienna | kw= Silver | kw= SkyBlue | kw= SlateBlue | kw= SlateGray | kw= SlateGrey | kw= Snow | kw= SpringGreen | kw= SteelBlue | kw= Tan | kw= Teal | kw= Thistle | kw= Tomato | kw= Turquoise | kw= Violet | kw= Wheat | kw= White | kw= WhiteSmoke | kw= Yellow | kw= YellowGreen )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2115:1: (kw= AliceBlue | kw= AntiqueWhite | kw= Aqua | kw= Aquamarine | kw= Azure | kw= Beige | kw= Bisque | kw= Black | kw= BlanchedAlmond | kw= Blue | kw= BlueViolet | kw= Brown | kw= BurlyWood | kw= CadetBlue | kw= Chartreuse | kw= Chocolate | kw= Coral | kw= CornflowerBlue | kw= Cornsilk | kw= Crimson | kw= Cyan | kw= DarkBlue | kw= DarkCyan | kw= DarkGoldenRod | kw= DarkGray | kw= DarkGreen | kw= DarkGrey | kw= DarkKhaki | kw= DarkMagenta | kw= DarkOliveGreen | kw= DarkOrchid | kw= DarkRed | kw= DarkSalmo | kw= DarkSeaGreen | kw= DarkSlateBlue | kw= DarkSlateGray | kw= DarkSlateGrey | kw= DarkTurquoise | kw= DarkViolet | kw= Darkorange | kw= DeepPink | kw= DeepSkyBlue | kw= DimGray | kw= DimGrey | kw= DodgerBlue | kw= FireBrick | kw= FloralWhite | kw= ForestGreen | kw= Fuchsia | kw= Gainsboro | kw= GhostWhite | kw= Gold | kw= GoldenRod | kw= Gray | kw= Green | kw= GreenYellow | kw= Grey | kw= HoneyDew | kw= HotPink | kw= IndianRed | kw= Indigo | kw= Ivory | kw= Khaki | kw= Lavender | kw= LavenderBlush | kw= LawnGreen | kw= LemonChiffon | kw= LightBlue | kw= LightCoral | kw= LightCyan | kw= LightGoldenRodYellow | kw= LightGray | kw= LightGreen | kw= LightGrey | kw= LightPink | kw= LightSalmon | kw= LightSeaGreen | kw= LightSkyBlue | kw= LightSlateGray | kw= LightSlateGrey | kw= LightSteelBlue | kw= LightYellow | kw= Lime | kw= LimeGreen | kw= Linen | kw= Magenta | kw= Maroon | kw= MediumAquaMarine | kw= MediumBlue | kw= MediumOrchid | kw= MediumPurple | kw= MediumSeaGreen | kw= MediumSlateBlue | kw= MediumSpringGreen | kw= MediumTurquoise | kw= MediumVioletRed | kw= MidnightBlue | kw= MintCream | kw= MistyRose | kw= Moccasin | kw= NavajoWhite | kw= Navy | kw= OldLace | kw= Olive | kw= OliveDrab | kw= OrangeRed | kw= Orchid | kw= PaleGoldenRod | kw= PaleGreen | kw= PaleTurquoise | kw= PaleVioletRed | kw= PapayaWhip | kw= PeachPuff | kw= Peru | kw= Pink | kw= Plum | kw= PowderBlue | kw= Purple | kw= Red | kw= RosyBrown | kw= RoyalBlue | kw= SaddleBrown | kw= Salmon | kw= SandyBrown | kw= SeaGreen | kw= Sienna | kw= Silver | kw= SkyBlue | kw= SlateBlue | kw= SlateGray | kw= SlateGrey | kw= Snow | kw= SpringGreen | kw= SteelBlue | kw= Tan | kw= Teal | kw= Thistle | kw= Tomato | kw= Turquoise | kw= Violet | kw= Wheat | kw= White | kw= WhiteSmoke | kw= Yellow | kw= YellowGreen )
            int alt56=145;
            switch ( input.LA(1) ) {
            case AliceBlue:
                {
                alt56=1;
                }
                break;
            case AntiqueWhite:
                {
                alt56=2;
                }
                break;
            case Aqua:
                {
                alt56=3;
                }
                break;
            case Aquamarine:
                {
                alt56=4;
                }
                break;
            case Azure:
                {
                alt56=5;
                }
                break;
            case Beige:
                {
                alt56=6;
                }
                break;
            case Bisque:
                {
                alt56=7;
                }
                break;
            case Black:
                {
                alt56=8;
                }
                break;
            case BlanchedAlmond:
                {
                alt56=9;
                }
                break;
            case Blue:
                {
                alt56=10;
                }
                break;
            case BlueViolet:
                {
                alt56=11;
                }
                break;
            case Brown:
                {
                alt56=12;
                }
                break;
            case BurlyWood:
                {
                alt56=13;
                }
                break;
            case CadetBlue:
                {
                alt56=14;
                }
                break;
            case Chartreuse:
                {
                alt56=15;
                }
                break;
            case Chocolate:
                {
                alt56=16;
                }
                break;
            case Coral:
                {
                alt56=17;
                }
                break;
            case CornflowerBlue:
                {
                alt56=18;
                }
                break;
            case Cornsilk:
                {
                alt56=19;
                }
                break;
            case Crimson:
                {
                alt56=20;
                }
                break;
            case Cyan:
                {
                alt56=21;
                }
                break;
            case DarkBlue:
                {
                alt56=22;
                }
                break;
            case DarkCyan:
                {
                alt56=23;
                }
                break;
            case DarkGoldenRod:
                {
                alt56=24;
                }
                break;
            case DarkGray:
                {
                alt56=25;
                }
                break;
            case DarkGreen:
                {
                alt56=26;
                }
                break;
            case DarkGrey:
                {
                alt56=27;
                }
                break;
            case DarkKhaki:
                {
                alt56=28;
                }
                break;
            case DarkMagenta:
                {
                alt56=29;
                }
                break;
            case DarkOliveGreen:
                {
                alt56=30;
                }
                break;
            case DarkOrchid:
                {
                alt56=31;
                }
                break;
            case DarkRed:
                {
                alt56=32;
                }
                break;
            case DarkSalmo:
                {
                alt56=33;
                }
                break;
            case DarkSeaGreen:
                {
                alt56=34;
                }
                break;
            case DarkSlateBlue:
                {
                alt56=35;
                }
                break;
            case DarkSlateGray:
                {
                alt56=36;
                }
                break;
            case DarkSlateGrey:
                {
                alt56=37;
                }
                break;
            case DarkTurquoise:
                {
                alt56=38;
                }
                break;
            case DarkViolet:
                {
                alt56=39;
                }
                break;
            case Darkorange:
                {
                alt56=40;
                }
                break;
            case DeepPink:
                {
                alt56=41;
                }
                break;
            case DeepSkyBlue:
                {
                alt56=42;
                }
                break;
            case DimGray:
                {
                alt56=43;
                }
                break;
            case DimGrey:
                {
                alt56=44;
                }
                break;
            case DodgerBlue:
                {
                alt56=45;
                }
                break;
            case FireBrick:
                {
                alt56=46;
                }
                break;
            case FloralWhite:
                {
                alt56=47;
                }
                break;
            case ForestGreen:
                {
                alt56=48;
                }
                break;
            case Fuchsia:
                {
                alt56=49;
                }
                break;
            case Gainsboro:
                {
                alt56=50;
                }
                break;
            case GhostWhite:
                {
                alt56=51;
                }
                break;
            case Gold:
                {
                alt56=52;
                }
                break;
            case GoldenRod:
                {
                alt56=53;
                }
                break;
            case Gray:
                {
                alt56=54;
                }
                break;
            case Green:
                {
                alt56=55;
                }
                break;
            case GreenYellow:
                {
                alt56=56;
                }
                break;
            case Grey:
                {
                alt56=57;
                }
                break;
            case HoneyDew:
                {
                alt56=58;
                }
                break;
            case HotPink:
                {
                alt56=59;
                }
                break;
            case IndianRed:
                {
                alt56=60;
                }
                break;
            case Indigo:
                {
                alt56=61;
                }
                break;
            case Ivory:
                {
                alt56=62;
                }
                break;
            case Khaki:
                {
                alt56=63;
                }
                break;
            case Lavender:
                {
                alt56=64;
                }
                break;
            case LavenderBlush:
                {
                alt56=65;
                }
                break;
            case LawnGreen:
                {
                alt56=66;
                }
                break;
            case LemonChiffon:
                {
                alt56=67;
                }
                break;
            case LightBlue:
                {
                alt56=68;
                }
                break;
            case LightCoral:
                {
                alt56=69;
                }
                break;
            case LightCyan:
                {
                alt56=70;
                }
                break;
            case LightGoldenRodYellow:
                {
                alt56=71;
                }
                break;
            case LightGray:
                {
                alt56=72;
                }
                break;
            case LightGreen:
                {
                alt56=73;
                }
                break;
            case LightGrey:
                {
                alt56=74;
                }
                break;
            case LightPink:
                {
                alt56=75;
                }
                break;
            case LightSalmon:
                {
                alt56=76;
                }
                break;
            case LightSeaGreen:
                {
                alt56=77;
                }
                break;
            case LightSkyBlue:
                {
                alt56=78;
                }
                break;
            case LightSlateGray:
                {
                alt56=79;
                }
                break;
            case LightSlateGrey:
                {
                alt56=80;
                }
                break;
            case LightSteelBlue:
                {
                alt56=81;
                }
                break;
            case LightYellow:
                {
                alt56=82;
                }
                break;
            case Lime:
                {
                alt56=83;
                }
                break;
            case LimeGreen:
                {
                alt56=84;
                }
                break;
            case Linen:
                {
                alt56=85;
                }
                break;
            case Magenta:
                {
                alt56=86;
                }
                break;
            case Maroon:
                {
                alt56=87;
                }
                break;
            case MediumAquaMarine:
                {
                alt56=88;
                }
                break;
            case MediumBlue:
                {
                alt56=89;
                }
                break;
            case MediumOrchid:
                {
                alt56=90;
                }
                break;
            case MediumPurple:
                {
                alt56=91;
                }
                break;
            case MediumSeaGreen:
                {
                alt56=92;
                }
                break;
            case MediumSlateBlue:
                {
                alt56=93;
                }
                break;
            case MediumSpringGreen:
                {
                alt56=94;
                }
                break;
            case MediumTurquoise:
                {
                alt56=95;
                }
                break;
            case MediumVioletRed:
                {
                alt56=96;
                }
                break;
            case MidnightBlue:
                {
                alt56=97;
                }
                break;
            case MintCream:
                {
                alt56=98;
                }
                break;
            case MistyRose:
                {
                alt56=99;
                }
                break;
            case Moccasin:
                {
                alt56=100;
                }
                break;
            case NavajoWhite:
                {
                alt56=101;
                }
                break;
            case Navy:
                {
                alt56=102;
                }
                break;
            case OldLace:
                {
                alt56=103;
                }
                break;
            case Olive:
                {
                alt56=104;
                }
                break;
            case OliveDrab:
                {
                alt56=105;
                }
                break;
            case OrangeRed:
                {
                alt56=106;
                }
                break;
            case Orchid:
                {
                alt56=107;
                }
                break;
            case PaleGoldenRod:
                {
                alt56=108;
                }
                break;
            case PaleGreen:
                {
                alt56=109;
                }
                break;
            case PaleTurquoise:
                {
                alt56=110;
                }
                break;
            case PaleVioletRed:
                {
                alt56=111;
                }
                break;
            case PapayaWhip:
                {
                alt56=112;
                }
                break;
            case PeachPuff:
                {
                alt56=113;
                }
                break;
            case Peru:
                {
                alt56=114;
                }
                break;
            case Pink:
                {
                alt56=115;
                }
                break;
            case Plum:
                {
                alt56=116;
                }
                break;
            case PowderBlue:
                {
                alt56=117;
                }
                break;
            case Purple:
                {
                alt56=118;
                }
                break;
            case Red:
                {
                alt56=119;
                }
                break;
            case RosyBrown:
                {
                alt56=120;
                }
                break;
            case RoyalBlue:
                {
                alt56=121;
                }
                break;
            case SaddleBrown:
                {
                alt56=122;
                }
                break;
            case Salmon:
                {
                alt56=123;
                }
                break;
            case SandyBrown:
                {
                alt56=124;
                }
                break;
            case SeaGreen:
                {
                alt56=125;
                }
                break;
            case Sienna:
                {
                alt56=126;
                }
                break;
            case Silver:
                {
                alt56=127;
                }
                break;
            case SkyBlue:
                {
                alt56=128;
                }
                break;
            case SlateBlue:
                {
                alt56=129;
                }
                break;
            case SlateGray:
                {
                alt56=130;
                }
                break;
            case SlateGrey:
                {
                alt56=131;
                }
                break;
            case Snow:
                {
                alt56=132;
                }
                break;
            case SpringGreen:
                {
                alt56=133;
                }
                break;
            case SteelBlue:
                {
                alt56=134;
                }
                break;
            case Tan:
                {
                alt56=135;
                }
                break;
            case Teal:
                {
                alt56=136;
                }
                break;
            case Thistle:
                {
                alt56=137;
                }
                break;
            case Tomato:
                {
                alt56=138;
                }
                break;
            case Turquoise:
                {
                alt56=139;
                }
                break;
            case Violet:
                {
                alt56=140;
                }
                break;
            case Wheat:
                {
                alt56=141;
                }
                break;
            case White:
                {
                alt56=142;
                }
                break;
            case WhiteSmoke:
                {
                alt56=143;
                }
                break;
            case Yellow:
                {
                alt56=144;
                }
                break;
            case YellowGreen:
                {
                alt56=145;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2116:2: kw= AliceBlue
                    {
                    kw=(Token)match(input,AliceBlue,FOLLOW_AliceBlue_in_ruleColor5391); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAliceBlueKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2123:2: kw= AntiqueWhite
                    {
                    kw=(Token)match(input,AntiqueWhite,FOLLOW_AntiqueWhite_in_ruleColor5410); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2130:2: kw= Aqua
                    {
                    kw=(Token)match(input,Aqua,FOLLOW_Aqua_in_ruleColor5429); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAquaKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2137:2: kw= Aquamarine
                    {
                    kw=(Token)match(input,Aquamarine,FOLLOW_Aquamarine_in_ruleColor5448); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAquamarineKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2144:2: kw= Azure
                    {
                    kw=(Token)match(input,Azure,FOLLOW_Azure_in_ruleColor5467); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAzureKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2151:2: kw= Beige
                    {
                    kw=(Token)match(input,Beige,FOLLOW_Beige_in_ruleColor5486); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBeigeKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2158:2: kw= Bisque
                    {
                    kw=(Token)match(input,Bisque,FOLLOW_Bisque_in_ruleColor5505); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBisqueKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2165:2: kw= Black
                    {
                    kw=(Token)match(input,Black,FOLLOW_Black_in_ruleColor5524); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlackKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2172:2: kw= BlanchedAlmond
                    {
                    kw=(Token)match(input,BlanchedAlmond,FOLLOW_BlanchedAlmond_in_ruleColor5543); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlanchedAlmondKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2179:2: kw= Blue
                    {
                    kw=(Token)match(input,Blue,FOLLOW_Blue_in_ruleColor5562); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlueKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2186:2: kw= BlueViolet
                    {
                    kw=(Token)match(input,BlueViolet,FOLLOW_BlueViolet_in_ruleColor5581); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlueVioletKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2193:2: kw= Brown
                    {
                    kw=(Token)match(input,Brown,FOLLOW_Brown_in_ruleColor5600); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBrownKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2200:2: kw= BurlyWood
                    {
                    kw=(Token)match(input,BurlyWood,FOLLOW_BurlyWood_in_ruleColor5619); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBurlyWoodKeyword_12()); 
                        

                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2207:2: kw= CadetBlue
                    {
                    kw=(Token)match(input,CadetBlue,FOLLOW_CadetBlue_in_ruleColor5638); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCadetBlueKeyword_13()); 
                        

                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2214:2: kw= Chartreuse
                    {
                    kw=(Token)match(input,Chartreuse,FOLLOW_Chartreuse_in_ruleColor5657); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getChartreuseKeyword_14()); 
                        

                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2221:2: kw= Chocolate
                    {
                    kw=(Token)match(input,Chocolate,FOLLOW_Chocolate_in_ruleColor5676); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getChocolateKeyword_15()); 
                        

                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2228:2: kw= Coral
                    {
                    kw=(Token)match(input,Coral,FOLLOW_Coral_in_ruleColor5695); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCoralKeyword_16()); 
                        

                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2235:2: kw= CornflowerBlue
                    {
                    kw=(Token)match(input,CornflowerBlue,FOLLOW_CornflowerBlue_in_ruleColor5714); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCornflowerBlueKeyword_17()); 
                        

                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2242:2: kw= Cornsilk
                    {
                    kw=(Token)match(input,Cornsilk,FOLLOW_Cornsilk_in_ruleColor5733); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCornsilkKeyword_18()); 
                        

                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2249:2: kw= Crimson
                    {
                    kw=(Token)match(input,Crimson,FOLLOW_Crimson_in_ruleColor5752); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCrimsonKeyword_19()); 
                        

                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2256:2: kw= Cyan
                    {
                    kw=(Token)match(input,Cyan,FOLLOW_Cyan_in_ruleColor5771); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCyanKeyword_20()); 
                        

                    }
                    break;
                case 22 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2263:2: kw= DarkBlue
                    {
                    kw=(Token)match(input,DarkBlue,FOLLOW_DarkBlue_in_ruleColor5790); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkBlueKeyword_21()); 
                        

                    }
                    break;
                case 23 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2270:2: kw= DarkCyan
                    {
                    kw=(Token)match(input,DarkCyan,FOLLOW_DarkCyan_in_ruleColor5809); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkCyanKeyword_22()); 
                        

                    }
                    break;
                case 24 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2277:2: kw= DarkGoldenRod
                    {
                    kw=(Token)match(input,DarkGoldenRod,FOLLOW_DarkGoldenRod_in_ruleColor5828); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGoldenRodKeyword_23()); 
                        

                    }
                    break;
                case 25 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2284:2: kw= DarkGray
                    {
                    kw=(Token)match(input,DarkGray,FOLLOW_DarkGray_in_ruleColor5847); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGrayKeyword_24()); 
                        

                    }
                    break;
                case 26 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2291:2: kw= DarkGreen
                    {
                    kw=(Token)match(input,DarkGreen,FOLLOW_DarkGreen_in_ruleColor5866); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGreenKeyword_25()); 
                        

                    }
                    break;
                case 27 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2298:2: kw= DarkGrey
                    {
                    kw=(Token)match(input,DarkGrey,FOLLOW_DarkGrey_in_ruleColor5885); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGreyKeyword_26()); 
                        

                    }
                    break;
                case 28 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2305:2: kw= DarkKhaki
                    {
                    kw=(Token)match(input,DarkKhaki,FOLLOW_DarkKhaki_in_ruleColor5904); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkKhakiKeyword_27()); 
                        

                    }
                    break;
                case 29 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2312:2: kw= DarkMagenta
                    {
                    kw=(Token)match(input,DarkMagenta,FOLLOW_DarkMagenta_in_ruleColor5923); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkMagentaKeyword_28()); 
                        

                    }
                    break;
                case 30 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2319:2: kw= DarkOliveGreen
                    {
                    kw=(Token)match(input,DarkOliveGreen,FOLLOW_DarkOliveGreen_in_ruleColor5942); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkOliveGreenKeyword_29()); 
                        

                    }
                    break;
                case 31 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2326:2: kw= DarkOrchid
                    {
                    kw=(Token)match(input,DarkOrchid,FOLLOW_DarkOrchid_in_ruleColor5961); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkOrchidKeyword_30()); 
                        

                    }
                    break;
                case 32 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2333:2: kw= DarkRed
                    {
                    kw=(Token)match(input,DarkRed,FOLLOW_DarkRed_in_ruleColor5980); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkRedKeyword_31()); 
                        

                    }
                    break;
                case 33 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2340:2: kw= DarkSalmo
                    {
                    kw=(Token)match(input,DarkSalmo,FOLLOW_DarkSalmo_in_ruleColor5999); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSalmoKeyword_32()); 
                        

                    }
                    break;
                case 34 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2347:2: kw= DarkSeaGreen
                    {
                    kw=(Token)match(input,DarkSeaGreen,FOLLOW_DarkSeaGreen_in_ruleColor6018); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSeaGreenKeyword_33()); 
                        

                    }
                    break;
                case 35 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2354:2: kw= DarkSlateBlue
                    {
                    kw=(Token)match(input,DarkSlateBlue,FOLLOW_DarkSlateBlue_in_ruleColor6037); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSlateBlueKeyword_34()); 
                        

                    }
                    break;
                case 36 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2361:2: kw= DarkSlateGray
                    {
                    kw=(Token)match(input,DarkSlateGray,FOLLOW_DarkSlateGray_in_ruleColor6056); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSlateGrayKeyword_35()); 
                        

                    }
                    break;
                case 37 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2368:2: kw= DarkSlateGrey
                    {
                    kw=(Token)match(input,DarkSlateGrey,FOLLOW_DarkSlateGrey_in_ruleColor6075); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSlateGreyKeyword_36()); 
                        

                    }
                    break;
                case 38 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2375:2: kw= DarkTurquoise
                    {
                    kw=(Token)match(input,DarkTurquoise,FOLLOW_DarkTurquoise_in_ruleColor6094); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkTurquoiseKeyword_37()); 
                        

                    }
                    break;
                case 39 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2382:2: kw= DarkViolet
                    {
                    kw=(Token)match(input,DarkViolet,FOLLOW_DarkViolet_in_ruleColor6113); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkVioletKeyword_38()); 
                        

                    }
                    break;
                case 40 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2389:2: kw= Darkorange
                    {
                    kw=(Token)match(input,Darkorange,FOLLOW_Darkorange_in_ruleColor6132); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkorangeKeyword_39()); 
                        

                    }
                    break;
                case 41 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2396:2: kw= DeepPink
                    {
                    kw=(Token)match(input,DeepPink,FOLLOW_DeepPink_in_ruleColor6151); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDeepPinkKeyword_40()); 
                        

                    }
                    break;
                case 42 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2403:2: kw= DeepSkyBlue
                    {
                    kw=(Token)match(input,DeepSkyBlue,FOLLOW_DeepSkyBlue_in_ruleColor6170); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDeepSkyBlueKeyword_41()); 
                        

                    }
                    break;
                case 43 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2410:2: kw= DimGray
                    {
                    kw=(Token)match(input,DimGray,FOLLOW_DimGray_in_ruleColor6189); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDimGrayKeyword_42()); 
                        

                    }
                    break;
                case 44 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2417:2: kw= DimGrey
                    {
                    kw=(Token)match(input,DimGrey,FOLLOW_DimGrey_in_ruleColor6208); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDimGreyKeyword_43()); 
                        

                    }
                    break;
                case 45 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2424:2: kw= DodgerBlue
                    {
                    kw=(Token)match(input,DodgerBlue,FOLLOW_DodgerBlue_in_ruleColor6227); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDodgerBlueKeyword_44()); 
                        

                    }
                    break;
                case 46 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2431:2: kw= FireBrick
                    {
                    kw=(Token)match(input,FireBrick,FOLLOW_FireBrick_in_ruleColor6246); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getFireBrickKeyword_45()); 
                        

                    }
                    break;
                case 47 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2438:2: kw= FloralWhite
                    {
                    kw=(Token)match(input,FloralWhite,FOLLOW_FloralWhite_in_ruleColor6265); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getFloralWhiteKeyword_46()); 
                        

                    }
                    break;
                case 48 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2445:2: kw= ForestGreen
                    {
                    kw=(Token)match(input,ForestGreen,FOLLOW_ForestGreen_in_ruleColor6284); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getForestGreenKeyword_47()); 
                        

                    }
                    break;
                case 49 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2452:2: kw= Fuchsia
                    {
                    kw=(Token)match(input,Fuchsia,FOLLOW_Fuchsia_in_ruleColor6303); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getFuchsiaKeyword_48()); 
                        

                    }
                    break;
                case 50 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2459:2: kw= Gainsboro
                    {
                    kw=(Token)match(input,Gainsboro,FOLLOW_Gainsboro_in_ruleColor6322); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGainsboroKeyword_49()); 
                        

                    }
                    break;
                case 51 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2466:2: kw= GhostWhite
                    {
                    kw=(Token)match(input,GhostWhite,FOLLOW_GhostWhite_in_ruleColor6341); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGhostWhiteKeyword_50()); 
                        

                    }
                    break;
                case 52 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2473:2: kw= Gold
                    {
                    kw=(Token)match(input,Gold,FOLLOW_Gold_in_ruleColor6360); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGoldKeyword_51()); 
                        

                    }
                    break;
                case 53 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2480:2: kw= GoldenRod
                    {
                    kw=(Token)match(input,GoldenRod,FOLLOW_GoldenRod_in_ruleColor6379); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGoldenRodKeyword_52()); 
                        

                    }
                    break;
                case 54 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2487:2: kw= Gray
                    {
                    kw=(Token)match(input,Gray,FOLLOW_Gray_in_ruleColor6398); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGrayKeyword_53()); 
                        

                    }
                    break;
                case 55 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2494:2: kw= Green
                    {
                    kw=(Token)match(input,Green,FOLLOW_Green_in_ruleColor6417); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGreenKeyword_54()); 
                        

                    }
                    break;
                case 56 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2501:2: kw= GreenYellow
                    {
                    kw=(Token)match(input,GreenYellow,FOLLOW_GreenYellow_in_ruleColor6436); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGreenYellowKeyword_55()); 
                        

                    }
                    break;
                case 57 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2508:2: kw= Grey
                    {
                    kw=(Token)match(input,Grey,FOLLOW_Grey_in_ruleColor6455); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGreyKeyword_56()); 
                        

                    }
                    break;
                case 58 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2515:2: kw= HoneyDew
                    {
                    kw=(Token)match(input,HoneyDew,FOLLOW_HoneyDew_in_ruleColor6474); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getHoneyDewKeyword_57()); 
                        

                    }
                    break;
                case 59 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2522:2: kw= HotPink
                    {
                    kw=(Token)match(input,HotPink,FOLLOW_HotPink_in_ruleColor6493); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getHotPinkKeyword_58()); 
                        

                    }
                    break;
                case 60 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2529:2: kw= IndianRed
                    {
                    kw=(Token)match(input,IndianRed,FOLLOW_IndianRed_in_ruleColor6512); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getIndianRedKeyword_59()); 
                        

                    }
                    break;
                case 61 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2536:2: kw= Indigo
                    {
                    kw=(Token)match(input,Indigo,FOLLOW_Indigo_in_ruleColor6531); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getIndigoKeyword_60()); 
                        

                    }
                    break;
                case 62 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2543:2: kw= Ivory
                    {
                    kw=(Token)match(input,Ivory,FOLLOW_Ivory_in_ruleColor6550); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getIvoryKeyword_61()); 
                        

                    }
                    break;
                case 63 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2550:2: kw= Khaki
                    {
                    kw=(Token)match(input,Khaki,FOLLOW_Khaki_in_ruleColor6569); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getKhakiKeyword_62()); 
                        

                    }
                    break;
                case 64 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2557:2: kw= Lavender
                    {
                    kw=(Token)match(input,Lavender,FOLLOW_Lavender_in_ruleColor6588); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLavenderKeyword_63()); 
                        

                    }
                    break;
                case 65 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2564:2: kw= LavenderBlush
                    {
                    kw=(Token)match(input,LavenderBlush,FOLLOW_LavenderBlush_in_ruleColor6607); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLavenderBlushKeyword_64()); 
                        

                    }
                    break;
                case 66 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2571:2: kw= LawnGreen
                    {
                    kw=(Token)match(input,LawnGreen,FOLLOW_LawnGreen_in_ruleColor6626); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLawnGreenKeyword_65()); 
                        

                    }
                    break;
                case 67 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2578:2: kw= LemonChiffon
                    {
                    kw=(Token)match(input,LemonChiffon,FOLLOW_LemonChiffon_in_ruleColor6645); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLemonChiffonKeyword_66()); 
                        

                    }
                    break;
                case 68 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2585:2: kw= LightBlue
                    {
                    kw=(Token)match(input,LightBlue,FOLLOW_LightBlue_in_ruleColor6664); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightBlueKeyword_67()); 
                        

                    }
                    break;
                case 69 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2592:2: kw= LightCoral
                    {
                    kw=(Token)match(input,LightCoral,FOLLOW_LightCoral_in_ruleColor6683); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightCoralKeyword_68()); 
                        

                    }
                    break;
                case 70 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2599:2: kw= LightCyan
                    {
                    kw=(Token)match(input,LightCyan,FOLLOW_LightCyan_in_ruleColor6702); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightCyanKeyword_69()); 
                        

                    }
                    break;
                case 71 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2606:2: kw= LightGoldenRodYellow
                    {
                    kw=(Token)match(input,LightGoldenRodYellow,FOLLOW_LightGoldenRodYellow_in_ruleColor6721); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_70()); 
                        

                    }
                    break;
                case 72 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2613:2: kw= LightGray
                    {
                    kw=(Token)match(input,LightGray,FOLLOW_LightGray_in_ruleColor6740); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGrayKeyword_71()); 
                        

                    }
                    break;
                case 73 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2620:2: kw= LightGreen
                    {
                    kw=(Token)match(input,LightGreen,FOLLOW_LightGreen_in_ruleColor6759); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGreenKeyword_72()); 
                        

                    }
                    break;
                case 74 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2627:2: kw= LightGrey
                    {
                    kw=(Token)match(input,LightGrey,FOLLOW_LightGrey_in_ruleColor6778); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGreyKeyword_73()); 
                        

                    }
                    break;
                case 75 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2634:2: kw= LightPink
                    {
                    kw=(Token)match(input,LightPink,FOLLOW_LightPink_in_ruleColor6797); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightPinkKeyword_74()); 
                        

                    }
                    break;
                case 76 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2641:2: kw= LightSalmon
                    {
                    kw=(Token)match(input,LightSalmon,FOLLOW_LightSalmon_in_ruleColor6816); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSalmonKeyword_75()); 
                        

                    }
                    break;
                case 77 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2648:2: kw= LightSeaGreen
                    {
                    kw=(Token)match(input,LightSeaGreen,FOLLOW_LightSeaGreen_in_ruleColor6835); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSeaGreenKeyword_76()); 
                        

                    }
                    break;
                case 78 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2655:2: kw= LightSkyBlue
                    {
                    kw=(Token)match(input,LightSkyBlue,FOLLOW_LightSkyBlue_in_ruleColor6854); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSkyBlueKeyword_77()); 
                        

                    }
                    break;
                case 79 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2662:2: kw= LightSlateGray
                    {
                    kw=(Token)match(input,LightSlateGray,FOLLOW_LightSlateGray_in_ruleColor6873); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSlateGrayKeyword_78()); 
                        

                    }
                    break;
                case 80 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2669:2: kw= LightSlateGrey
                    {
                    kw=(Token)match(input,LightSlateGrey,FOLLOW_LightSlateGrey_in_ruleColor6892); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSlateGreyKeyword_79()); 
                        

                    }
                    break;
                case 81 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2676:2: kw= LightSteelBlue
                    {
                    kw=(Token)match(input,LightSteelBlue,FOLLOW_LightSteelBlue_in_ruleColor6911); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSteelBlueKeyword_80()); 
                        

                    }
                    break;
                case 82 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2683:2: kw= LightYellow
                    {
                    kw=(Token)match(input,LightYellow,FOLLOW_LightYellow_in_ruleColor6930); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightYellowKeyword_81()); 
                        

                    }
                    break;
                case 83 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2690:2: kw= Lime
                    {
                    kw=(Token)match(input,Lime,FOLLOW_Lime_in_ruleColor6949); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLimeKeyword_82()); 
                        

                    }
                    break;
                case 84 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2697:2: kw= LimeGreen
                    {
                    kw=(Token)match(input,LimeGreen,FOLLOW_LimeGreen_in_ruleColor6968); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLimeGreenKeyword_83()); 
                        

                    }
                    break;
                case 85 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2704:2: kw= Linen
                    {
                    kw=(Token)match(input,Linen,FOLLOW_Linen_in_ruleColor6987); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLinenKeyword_84()); 
                        

                    }
                    break;
                case 86 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2711:2: kw= Magenta
                    {
                    kw=(Token)match(input,Magenta,FOLLOW_Magenta_in_ruleColor7006); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMagentaKeyword_85()); 
                        

                    }
                    break;
                case 87 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2718:2: kw= Maroon
                    {
                    kw=(Token)match(input,Maroon,FOLLOW_Maroon_in_ruleColor7025); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMaroonKeyword_86()); 
                        

                    }
                    break;
                case 88 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2725:2: kw= MediumAquaMarine
                    {
                    kw=(Token)match(input,MediumAquaMarine,FOLLOW_MediumAquaMarine_in_ruleColor7044); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumAquaMarineKeyword_87()); 
                        

                    }
                    break;
                case 89 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2732:2: kw= MediumBlue
                    {
                    kw=(Token)match(input,MediumBlue,FOLLOW_MediumBlue_in_ruleColor7063); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumBlueKeyword_88()); 
                        

                    }
                    break;
                case 90 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2739:2: kw= MediumOrchid
                    {
                    kw=(Token)match(input,MediumOrchid,FOLLOW_MediumOrchid_in_ruleColor7082); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumOrchidKeyword_89()); 
                        

                    }
                    break;
                case 91 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2746:2: kw= MediumPurple
                    {
                    kw=(Token)match(input,MediumPurple,FOLLOW_MediumPurple_in_ruleColor7101); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumPurpleKeyword_90()); 
                        

                    }
                    break;
                case 92 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2753:2: kw= MediumSeaGreen
                    {
                    kw=(Token)match(input,MediumSeaGreen,FOLLOW_MediumSeaGreen_in_ruleColor7120); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumSeaGreenKeyword_91()); 
                        

                    }
                    break;
                case 93 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2760:2: kw= MediumSlateBlue
                    {
                    kw=(Token)match(input,MediumSlateBlue,FOLLOW_MediumSlateBlue_in_ruleColor7139); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumSlateBlueKeyword_92()); 
                        

                    }
                    break;
                case 94 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2767:2: kw= MediumSpringGreen
                    {
                    kw=(Token)match(input,MediumSpringGreen,FOLLOW_MediumSpringGreen_in_ruleColor7158); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumSpringGreenKeyword_93()); 
                        

                    }
                    break;
                case 95 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2774:2: kw= MediumTurquoise
                    {
                    kw=(Token)match(input,MediumTurquoise,FOLLOW_MediumTurquoise_in_ruleColor7177); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumTurquoiseKeyword_94()); 
                        

                    }
                    break;
                case 96 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2781:2: kw= MediumVioletRed
                    {
                    kw=(Token)match(input,MediumVioletRed,FOLLOW_MediumVioletRed_in_ruleColor7196); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumVioletRedKeyword_95()); 
                        

                    }
                    break;
                case 97 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2788:2: kw= MidnightBlue
                    {
                    kw=(Token)match(input,MidnightBlue,FOLLOW_MidnightBlue_in_ruleColor7215); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMidnightBlueKeyword_96()); 
                        

                    }
                    break;
                case 98 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2795:2: kw= MintCream
                    {
                    kw=(Token)match(input,MintCream,FOLLOW_MintCream_in_ruleColor7234); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMintCreamKeyword_97()); 
                        

                    }
                    break;
                case 99 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2802:2: kw= MistyRose
                    {
                    kw=(Token)match(input,MistyRose,FOLLOW_MistyRose_in_ruleColor7253); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMistyRoseKeyword_98()); 
                        

                    }
                    break;
                case 100 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2809:2: kw= Moccasin
                    {
                    kw=(Token)match(input,Moccasin,FOLLOW_Moccasin_in_ruleColor7272); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMoccasinKeyword_99()); 
                        

                    }
                    break;
                case 101 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2816:2: kw= NavajoWhite
                    {
                    kw=(Token)match(input,NavajoWhite,FOLLOW_NavajoWhite_in_ruleColor7291); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getNavajoWhiteKeyword_100()); 
                        

                    }
                    break;
                case 102 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2823:2: kw= Navy
                    {
                    kw=(Token)match(input,Navy,FOLLOW_Navy_in_ruleColor7310); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getNavyKeyword_101()); 
                        

                    }
                    break;
                case 103 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2830:2: kw= OldLace
                    {
                    kw=(Token)match(input,OldLace,FOLLOW_OldLace_in_ruleColor7329); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOldLaceKeyword_102()); 
                        

                    }
                    break;
                case 104 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2837:2: kw= Olive
                    {
                    kw=(Token)match(input,Olive,FOLLOW_Olive_in_ruleColor7348); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOliveKeyword_103()); 
                        

                    }
                    break;
                case 105 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2844:2: kw= OliveDrab
                    {
                    kw=(Token)match(input,OliveDrab,FOLLOW_OliveDrab_in_ruleColor7367); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOliveDrabKeyword_104()); 
                        

                    }
                    break;
                case 106 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2851:2: kw= OrangeRed
                    {
                    kw=(Token)match(input,OrangeRed,FOLLOW_OrangeRed_in_ruleColor7386); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOrangeRedKeyword_105()); 
                        

                    }
                    break;
                case 107 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2858:2: kw= Orchid
                    {
                    kw=(Token)match(input,Orchid,FOLLOW_Orchid_in_ruleColor7405); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOrchidKeyword_106()); 
                        

                    }
                    break;
                case 108 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2865:2: kw= PaleGoldenRod
                    {
                    kw=(Token)match(input,PaleGoldenRod,FOLLOW_PaleGoldenRod_in_ruleColor7424); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleGoldenRodKeyword_107()); 
                        

                    }
                    break;
                case 109 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2872:2: kw= PaleGreen
                    {
                    kw=(Token)match(input,PaleGreen,FOLLOW_PaleGreen_in_ruleColor7443); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleGreenKeyword_108()); 
                        

                    }
                    break;
                case 110 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2879:2: kw= PaleTurquoise
                    {
                    kw=(Token)match(input,PaleTurquoise,FOLLOW_PaleTurquoise_in_ruleColor7462); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleTurquoiseKeyword_109()); 
                        

                    }
                    break;
                case 111 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2886:2: kw= PaleVioletRed
                    {
                    kw=(Token)match(input,PaleVioletRed,FOLLOW_PaleVioletRed_in_ruleColor7481); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleVioletRedKeyword_110()); 
                        

                    }
                    break;
                case 112 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2893:2: kw= PapayaWhip
                    {
                    kw=(Token)match(input,PapayaWhip,FOLLOW_PapayaWhip_in_ruleColor7500); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPapayaWhipKeyword_111()); 
                        

                    }
                    break;
                case 113 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2900:2: kw= PeachPuff
                    {
                    kw=(Token)match(input,PeachPuff,FOLLOW_PeachPuff_in_ruleColor7519); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPeachPuffKeyword_112()); 
                        

                    }
                    break;
                case 114 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2907:2: kw= Peru
                    {
                    kw=(Token)match(input,Peru,FOLLOW_Peru_in_ruleColor7538); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPeruKeyword_113()); 
                        

                    }
                    break;
                case 115 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2914:2: kw= Pink
                    {
                    kw=(Token)match(input,Pink,FOLLOW_Pink_in_ruleColor7557); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPinkKeyword_114()); 
                        

                    }
                    break;
                case 116 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2921:2: kw= Plum
                    {
                    kw=(Token)match(input,Plum,FOLLOW_Plum_in_ruleColor7576); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPlumKeyword_115()); 
                        

                    }
                    break;
                case 117 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2928:2: kw= PowderBlue
                    {
                    kw=(Token)match(input,PowderBlue,FOLLOW_PowderBlue_in_ruleColor7595); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPowderBlueKeyword_116()); 
                        

                    }
                    break;
                case 118 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2935:2: kw= Purple
                    {
                    kw=(Token)match(input,Purple,FOLLOW_Purple_in_ruleColor7614); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPurpleKeyword_117()); 
                        

                    }
                    break;
                case 119 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2942:2: kw= Red
                    {
                    kw=(Token)match(input,Red,FOLLOW_Red_in_ruleColor7633); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getRedKeyword_118()); 
                        

                    }
                    break;
                case 120 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2949:2: kw= RosyBrown
                    {
                    kw=(Token)match(input,RosyBrown,FOLLOW_RosyBrown_in_ruleColor7652); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getRosyBrownKeyword_119()); 
                        

                    }
                    break;
                case 121 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2956:2: kw= RoyalBlue
                    {
                    kw=(Token)match(input,RoyalBlue,FOLLOW_RoyalBlue_in_ruleColor7671); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getRoyalBlueKeyword_120()); 
                        

                    }
                    break;
                case 122 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2963:2: kw= SaddleBrown
                    {
                    kw=(Token)match(input,SaddleBrown,FOLLOW_SaddleBrown_in_ruleColor7690); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSaddleBrownKeyword_121()); 
                        

                    }
                    break;
                case 123 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2970:2: kw= Salmon
                    {
                    kw=(Token)match(input,Salmon,FOLLOW_Salmon_in_ruleColor7709); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSalmonKeyword_122()); 
                        

                    }
                    break;
                case 124 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2977:2: kw= SandyBrown
                    {
                    kw=(Token)match(input,SandyBrown,FOLLOW_SandyBrown_in_ruleColor7728); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSandyBrownKeyword_123()); 
                        

                    }
                    break;
                case 125 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2984:2: kw= SeaGreen
                    {
                    kw=(Token)match(input,SeaGreen,FOLLOW_SeaGreen_in_ruleColor7747); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSeaGreenKeyword_124()); 
                        

                    }
                    break;
                case 126 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2991:2: kw= Sienna
                    {
                    kw=(Token)match(input,Sienna,FOLLOW_Sienna_in_ruleColor7766); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSiennaKeyword_125()); 
                        

                    }
                    break;
                case 127 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2998:2: kw= Silver
                    {
                    kw=(Token)match(input,Silver,FOLLOW_Silver_in_ruleColor7785); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSilverKeyword_126()); 
                        

                    }
                    break;
                case 128 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3005:2: kw= SkyBlue
                    {
                    kw=(Token)match(input,SkyBlue,FOLLOW_SkyBlue_in_ruleColor7804); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSkyBlueKeyword_127()); 
                        

                    }
                    break;
                case 129 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3012:2: kw= SlateBlue
                    {
                    kw=(Token)match(input,SlateBlue,FOLLOW_SlateBlue_in_ruleColor7823); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSlateBlueKeyword_128()); 
                        

                    }
                    break;
                case 130 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3019:2: kw= SlateGray
                    {
                    kw=(Token)match(input,SlateGray,FOLLOW_SlateGray_in_ruleColor7842); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSlateGrayKeyword_129()); 
                        

                    }
                    break;
                case 131 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3026:2: kw= SlateGrey
                    {
                    kw=(Token)match(input,SlateGrey,FOLLOW_SlateGrey_in_ruleColor7861); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSlateGreyKeyword_130()); 
                        

                    }
                    break;
                case 132 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3033:2: kw= Snow
                    {
                    kw=(Token)match(input,Snow,FOLLOW_Snow_in_ruleColor7880); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSnowKeyword_131()); 
                        

                    }
                    break;
                case 133 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3040:2: kw= SpringGreen
                    {
                    kw=(Token)match(input,SpringGreen,FOLLOW_SpringGreen_in_ruleColor7899); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSpringGreenKeyword_132()); 
                        

                    }
                    break;
                case 134 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3047:2: kw= SteelBlue
                    {
                    kw=(Token)match(input,SteelBlue,FOLLOW_SteelBlue_in_ruleColor7918); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSteelBlueKeyword_133()); 
                        

                    }
                    break;
                case 135 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3054:2: kw= Tan
                    {
                    kw=(Token)match(input,Tan,FOLLOW_Tan_in_ruleColor7937); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTanKeyword_134()); 
                        

                    }
                    break;
                case 136 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3061:2: kw= Teal
                    {
                    kw=(Token)match(input,Teal,FOLLOW_Teal_in_ruleColor7956); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTealKeyword_135()); 
                        

                    }
                    break;
                case 137 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3068:2: kw= Thistle
                    {
                    kw=(Token)match(input,Thistle,FOLLOW_Thistle_in_ruleColor7975); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getThistleKeyword_136()); 
                        

                    }
                    break;
                case 138 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3075:2: kw= Tomato
                    {
                    kw=(Token)match(input,Tomato,FOLLOW_Tomato_in_ruleColor7994); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTomatoKeyword_137()); 
                        

                    }
                    break;
                case 139 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3082:2: kw= Turquoise
                    {
                    kw=(Token)match(input,Turquoise,FOLLOW_Turquoise_in_ruleColor8013); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTurquoiseKeyword_138()); 
                        

                    }
                    break;
                case 140 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3089:2: kw= Violet
                    {
                    kw=(Token)match(input,Violet,FOLLOW_Violet_in_ruleColor8032); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getVioletKeyword_139()); 
                        

                    }
                    break;
                case 141 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3096:2: kw= Wheat
                    {
                    kw=(Token)match(input,Wheat,FOLLOW_Wheat_in_ruleColor8051); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getWheatKeyword_140()); 
                        

                    }
                    break;
                case 142 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3103:2: kw= White
                    {
                    kw=(Token)match(input,White,FOLLOW_White_in_ruleColor8070); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getWhiteKeyword_141()); 
                        

                    }
                    break;
                case 143 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3110:2: kw= WhiteSmoke
                    {
                    kw=(Token)match(input,WhiteSmoke,FOLLOW_WhiteSmoke_in_ruleColor8089); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getWhiteSmokeKeyword_142()); 
                        

                    }
                    break;
                case 144 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3117:2: kw= Yellow
                    {
                    kw=(Token)match(input,Yellow,FOLLOW_Yellow_in_ruleColor8108); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getYellowKeyword_143()); 
                        

                    }
                    break;
                case 145 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3124:2: kw= YellowGreen
                    {
                    kw=(Token)match(input,YellowGreen,FOLLOW_YellowGreen_in_ruleColor8127); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getYellowGreenKeyword_144()); 
                        

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
    // $ANTLR end "ruleColor"

    // Delegated rules


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA5_eotS =
        "\47\uffff";
    static final String DFA5_eofS =
        "\47\uffff";
    static final String DFA5_minS =
        "\1\55\1\uffff\1\u00cd\2\u00c8\1\136\1\75\7\u00c8\1\u0099\1\u00ad"+
        "\1\171\1\4\2\u00cd\1\u00bd\22\uffff";
    static final String DFA5_maxS =
        "\1\u00d0\1\uffff\1\u00d0\1\u00cf\1\u00d0\1\u00cd\10\u00d0\3\u00cd"+
        "\3\u00d0\1\u00cd\22\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\23\uffff\1\2\1\12\1\14\1\15\1\23\1\21\1\3\1\4\1\5"+
        "\1\7\1\6\1\10\1\11\1\13\1\16\1\17\1\20\1\22";
    static final String DFA5_specialS =
        "\47\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\25\17\uffff\1\3\1\22\37\uffff\1\1\12\uffff\1\21\1\25\1\14"+
            "\1\25\12\uffff\1\25\1\23\1\1\1\7\13\uffff\1\1\1\2\1\25\1\5\14"+
            "\uffff\1\25\1\13\1\15\1\1\1\4\15\uffff\1\1\1\20\1\1\1\11\1\16"+
            "\1\1\1\27\2\uffff\1\6\1\24\1\1\1\10\1\12\1\17\1\30\1\uffff\1"+
            "\26\1\uffff\1\1\1\30\1\uffff\12\1\1\31\6\uffff\2\1",
            "",
            "\1\1\2\uffff\1\32",
            "\1\33\4\uffff\1\1\1\uffff\1\33",
            "\1\34\4\uffff\1\1\2\uffff\1\34",
            "\1\35\47\uffff\1\35\22\uffff\1\35\20\uffff\1\35\35\uffff\1"+
            "\35\4\uffff\1\1",
            "\2\36\37\uffff\1\36\12\uffff\1\36\1\uffff\1\36\14\uffff\3"+
            "\36\13\uffff\2\36\1\uffff\1\36\15\uffff\4\36\15\uffff\6\36\3"+
            "\uffff\6\36\4\uffff\1\36\2\uffff\13\36\4\uffff\1\1\1\uffff\2"+
            "\36",
            "\1\37\4\uffff\1\1\2\uffff\1\37",
            "\1\40\4\uffff\1\1\2\uffff\1\40",
            "\1\40\4\uffff\1\1\2\uffff\1\40",
            "\1\40\4\uffff\1\1\2\uffff\1\40",
            "\1\40\4\uffff\1\1\2\uffff\1\40",
            "\1\40\4\uffff\1\1\2\uffff\1\40",
            "\1\40\4\uffff\1\1\2\uffff\1\40",
            "\1\41\20\uffff\1\41\2\uffff\1\41\37\uffff\1\1",
            "\1\42\37\uffff\1\1",
            "\1\43\123\uffff\1\1",
            "\51\44\1\uffff\17\44\2\uffff\37\44\1\uffff\12\44\4\uffff\12"+
            "\44\4\uffff\13\44\4\uffff\14\44\5\uffff\15\44\7\uffff\2\44\34"+
            "\uffff\1\1\2\uffff\1\44",
            "\1\1\2\uffff\1\45",
            "\1\1\2\uffff\1\45",
            "\1\46\17\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "168:2: (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition ( ruleColors )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_7= ruleAltElse | this_GroupingMessages_8= ruleGroupingMessages | this_Note_9= ruleNote | ruleDivider | this_Reference_11= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_15= ruleActivate | this_Deactivate_16= ruleDeactivate | ruleParticipantCreation | this_Box_18= ruleBox )?";
        }
    }
    static final String DFA8_eotS =
        "\55\uffff";
    static final String DFA8_eofS =
        "\55\uffff";
    static final String DFA8_minS =
        "\2\75\1\uffff\51\75\1\uffff";
    static final String DFA8_maxS =
        "\2\u00d0\1\uffff\51\u00d0\1\uffff";
    static final String DFA8_acceptS =
        "\2\uffff\1\2\51\uffff\1\1";
    static final String DFA8_specialS =
        "\55\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\1\2\1\1\10\2\7\uffff\2\2",
            "\1\5\1\34\37\uffff\1\13\12\uffff\1\33\1\uffff\1\23\14\uffff"+
            "\1\35\1\32\1\16\13\uffff\1\12\1\4\1\uffff\1\7\15\uffff\1\22"+
            "\1\24\1\10\1\6\15\uffff\1\15\1\31\1\11\1\20\1\25\1\26\3\uffff"+
            "\1\14\1\36\1\uffff\1\17\1\21\1\30\3\uffff\1\2\1\27\2\uffff\1"+
            "\37\1\41\1\42\1\40\1\45\1\46\1\47\1\51\1\43\1\50\7\uffff\1\44"+
            "\1\3",
            "",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\1\53\11\2\7\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\2\2\2\uffff\12\2\6\uffff\1\54\2\2",
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
            return "593:1: (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma otherlv_16= NumberSign this_HEXCODE_17= RULE_HEXCODE otherlv_18= RightParenthesis )?";
        }
    }
 

    public static final BitSet FOLLOW_rulePlantuml_in_entryRulePlantuml67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlantuml77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_rulePlantuml122 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleDiagram_in_entryRuleDiagram157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDiagram167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_START_in_ruleDiagram203 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleDiagram213 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000185FFL});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleDiagram233 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000185FFL});
    public static final BitSet FOLLOW_RULE_END_in_ruleDiagram245 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleDiagram256 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_ruleInstruction350 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleInstruction378 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleColors_in_ruleInstruction394 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_ruleInstruction418 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleTitle_in_ruleInstruction439 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleLegend_in_ruleInstruction460 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleNewpage_in_ruleInstruction481 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleAltElse_in_ruleInstruction508 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_ruleInstruction535 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleNote_in_ruleInstruction562 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleDivider_in_ruleInstruction583 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleReference_in_ruleInstruction610 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleDelay_in_ruleInstruction631 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleSpace_in_ruleInstruction652 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_ruleInstruction673 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleActivate_in_ruleInstruction700 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleDeactivate_in_ruleInstruction727 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleParticipantCreation_in_ruleInstruction748 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleBox_in_ruleInstruction775 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleInstruction787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_entryRuleArrow821 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrow831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_ruleArrow877 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_RULE_SEQUENCE_in_ruleArrow888 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleArrow908 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_Colon_in_ruleArrow922 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleArrow938 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition976 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Actor_in_ruleDefinition1025 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleDefinition1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Boundary_in_ruleDefinition1066 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleDefinition1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Control_in_ruleDefinition1107 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleDefinition1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Entity_in_ruleDefinition1148 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleDefinition1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Database_in_ruleDefinition1189 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleDefinition1209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Participant_in_ruleDefinition1230 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleDefinition1250 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_LessThanSignLessThanSign_in_ruleDefinition1264 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xCC763F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_LeftParenthesis_in_ruleDefinition1277 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC8763F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_ruleEndID_in_ruleDefinition1292 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_ruleDefinition1304 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_NumberSign_in_ruleDefinition1316 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_RULE_HEXCODE_in_ruleDefinition1326 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RightParenthesis_in_ruleDefinition1338 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xCC763F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_ruleEndID_in_ruleDefinition1356 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xCC763F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_GreaterThanSignGreaterThanSign_in_ruleDefinition1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndID_in_entryRuleEndID1410 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndID1421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEndID1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_ruleEndID1485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Autonumber_in_ruleEndID1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Title_in_ruleEndID1523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Legend_in_ruleEndID1542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Right_in_ruleEndID1561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Left_in_ruleEndID1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Center_in_ruleEndID1599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Endlegend_in_ruleEndID1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Alt_in_ruleEndID1637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Else_in_ruleEndID1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Newpage_in_ruleEndID1675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Opt_in_ruleEndID1694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Loop_in_ruleEndID1713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Par_in_ruleEndID1732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Break_in_ruleEndID1751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Critical_in_ruleEndID1770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Group_in_ruleEndID1789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Note_in_ruleEndID1808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Over_in_ruleEndID1827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Of_in_ruleEndID1846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_ruleEndID1865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hide_in_ruleEndID1884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Footbox_in_ruleEndID1903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Activate_in_ruleEndID1922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Deactivate_in_ruleEndID1941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Destroy_in_ruleEndID1960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Box_in_ruleEndID1979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NumberSign_in_ruleEndID1998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_ruleEndID2017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftParenthesis_in_ruleEndID2036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightParenthesis_in_ruleEndID2055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EqualsSign_in_ruleEndID2074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEndID2095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HyphenMinus_in_ruleEndID2119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleEndID2138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_ruleEndID2157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GreaterThanSign_in_ruleEndID2176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LessThanSign_in_ruleEndID2195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_entryRuleMyID2235 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMyID2246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndID_in_ruleMyID2293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_ruleMyID2317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber2357 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAutoNumber2368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Autonumber_in_ruleAutoNumber2406 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAutoNumber2422 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAutoNumber2443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_entryRuleTitle2492 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTitle2503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Title_in_ruleTitle2541 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTitle2557 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleLegend_in_entryRuleLegend2604 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLegend2615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Legend_in_ruleLegend2653 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000040002000040L,0x0000000000000100L});
    public static final BitSet FOLLOW_Right_in_ruleLegend2667 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_Left_in_ruleLegend2686 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_Center_in_ruleLegend2705 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleLegend2723 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000000000000000L,0x0000000000010100L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLegend2744 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000000000000000L,0x0000000000010100L});
    public static final BitSet FOLLOW_Endlegend_in_ruleLegend2766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_entryRuleNewpage2806 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNewpage2817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Newpage_in_ruleNewpage2855 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNewpage2871 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleAltElse_in_entryRuleAltElse2917 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAltElse2927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Alt_in_ruleAltElse2965 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleAltElse2981 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleAltElse2993 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleAltElse3013 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_ruleElse_in_ruleAltElse3035 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008010000000000L});
    public static final BitSet FOLLOW_End_in_ruleAltElse3049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElse_in_entryRuleElse3083 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElse3093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Else_in_ruleElse3131 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleElse3147 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleElse3159 = new BitSet(new long[]{0x6000200000000002L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleElse3179 = new BitSet(new long[]{0x6000200000000002L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages3215 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroupingMessages3225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Opt_in_ruleGroupingMessages3264 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010100L});
    public static final BitSet FOLLOW_Loop_in_ruleGroupingMessages3282 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010100L});
    public static final BitSet FOLLOW_Par_in_ruleGroupingMessages3300 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010100L});
    public static final BitSet FOLLOW_Break_in_ruleGroupingMessages3318 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010100L});
    public static final BitSet FOLLOW_Critical_in_ruleGroupingMessages3336 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010100L});
    public static final BitSet FOLLOW_Group_in_ruleGroupingMessages3354 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010100L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGroupingMessages3366 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010100L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleGroupingMessages3378 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleGroupingMessages3398 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_End_in_ruleGroupingMessages3412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNote_in_entryRuleNote3446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNote3456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Note_in_ruleNote3494 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000240002000000L});
    public static final BitSet FOLLOW_Right_in_ruleNote3508 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x080980FFF83FFC3FL,0x0000000000000110L});
    public static final BitSet FOLLOW_Of_in_ruleNote3521 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote3540 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000980FFF83FFC3FL,0x0000000000000112L});
    public static final BitSet FOLLOW_Comma_in_ruleNote3554 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote3573 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000980FFF83FFC3FL,0x0000000000000112L});
    public static final BitSet FOLLOW_Left_in_ruleNote3598 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x080980FFF83FFC3FL,0x0000000000000110L});
    public static final BitSet FOLLOW_Of_in_ruleNote3611 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote3630 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000980FFF83FFC3FL,0x0000000000000112L});
    public static final BitSet FOLLOW_Comma_in_ruleNote3644 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote3663 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000980FFF83FFC3FL,0x0000000000000112L});
    public static final BitSet FOLLOW_Over_in_ruleNote3688 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote3707 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000980FFF83FFC3FL,0x0000000000000112L});
    public static final BitSet FOLLOW_Comma_in_ruleNote3721 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote3740 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000980FFF83FFC3FL,0x0000000000000112L});
    public static final BitSet FOLLOW_ruleColor_in_ruleNote3761 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000980FFF83FFC3FL,0x0000000000000110L});
    public static final BitSet FOLLOW_Colon_in_ruleNote3777 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleNote3793 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleNote3814 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_ruleEndID_in_ruleNote3830 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_End_in_ruleNote3846 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_Note_in_ruleNote3858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDivider_in_entryRuleDivider3895 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDivider3906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EqualsSignEqualsSign_in_ruleDivider3944 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDivider3960 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_EqualsSignEqualsSign_in_ruleDivider3980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference4019 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference4029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_ruleReference4067 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_Over_in_ruleReference4079 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference4098 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L,0x0000000000000112L});
    public static final BitSet FOLLOW_Comma_in_ruleReference4112 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference4131 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L,0x0000000000000112L});
    public static final BitSet FOLLOW_Colon_in_ruleReference4148 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleReference4164 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleReference4185 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_ruleEndID_in_ruleReference4201 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_End_in_ruleReference4217 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_Ref_in_ruleReference4229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDelay_in_entryRuleDelay4266 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDelay4277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStopFullStopFullStop_in_ruleDelay4315 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000400000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDelay4332 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000400000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_FullStopFullStopFullStop_in_ruleDelay4352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpace_in_entryRuleSpace4394 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpace4405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLineVerticalLine_in_ruleSpace4443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLine_in_ruleSpace4463 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpace4478 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_VerticalLineVerticalLine_in_ruleSpace4496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox4537 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHidefootbox4548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hide_in_ruleHidefootbox4586 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_Footbox_in_ruleHidefootbox4599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActivate_in_entryRuleActivate4638 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActivate4648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Activate_in_ruleActivate4686 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000180FFF83FFC3FL,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleColor_in_ruleActivate4702 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActivate4720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeactivate_in_entryRuleDeactivate4760 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeactivate4770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Deactivate_in_ruleDeactivate4809 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_Destroy_in_ruleDeactivate4827 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeactivate4847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParticipantCreation_in_entryRuleParticipantCreation4883 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParticipantCreation4894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_ruleParticipantCreation4932 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParticipantCreation4947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBox_in_entryRuleBox4991 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBox5001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Box_in_ruleBox5039 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_QuotationMark_in_ruleBox5051 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBox5062 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_QuotationMark_in_ruleBox5076 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000180FFF83FFC3FL,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleColor_in_ruleBox5092 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleBox5104 = new BitSet(new long[]{0x0000200000000000L,0x0080140000000000L,0x0008000000400100L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleBox5125 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleBox5137 = new BitSet(new long[]{0x0000200000000000L,0x0080140000000000L,0x0008000000400100L,0x0000000000000100L});
    public static final BitSet FOLLOW_End_in_ruleBox5151 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_Box_in_ruleBox5163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColors_in_entryRuleColors5198 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColors5209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NumberSign_in_ruleColors5247 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000180FFF83FFC3FL,0x0000000000004000L});
    public static final BitSet FOLLOW_ruleColor_in_ruleColors5270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEXCODE_in_ruleColors5296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_entryRuleColor5342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColor5353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AliceBlue_in_ruleColor5391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AntiqueWhite_in_ruleColor5410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Aqua_in_ruleColor5429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Aquamarine_in_ruleColor5448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Azure_in_ruleColor5467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Beige_in_ruleColor5486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bisque_in_ruleColor5505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Black_in_ruleColor5524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BlanchedAlmond_in_ruleColor5543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Blue_in_ruleColor5562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BlueViolet_in_ruleColor5581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Brown_in_ruleColor5600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BurlyWood_in_ruleColor5619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CadetBlue_in_ruleColor5638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Chartreuse_in_ruleColor5657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Chocolate_in_ruleColor5676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Coral_in_ruleColor5695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CornflowerBlue_in_ruleColor5714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Cornsilk_in_ruleColor5733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Crimson_in_ruleColor5752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Cyan_in_ruleColor5771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkBlue_in_ruleColor5790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkCyan_in_ruleColor5809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGoldenRod_in_ruleColor5828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGray_in_ruleColor5847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGreen_in_ruleColor5866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGrey_in_ruleColor5885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkKhaki_in_ruleColor5904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkMagenta_in_ruleColor5923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkOliveGreen_in_ruleColor5942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkOrchid_in_ruleColor5961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkRed_in_ruleColor5980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSalmo_in_ruleColor5999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSeaGreen_in_ruleColor6018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSlateBlue_in_ruleColor6037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSlateGray_in_ruleColor6056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSlateGrey_in_ruleColor6075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkTurquoise_in_ruleColor6094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkViolet_in_ruleColor6113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Darkorange_in_ruleColor6132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DeepPink_in_ruleColor6151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DeepSkyBlue_in_ruleColor6170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DimGray_in_ruleColor6189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DimGrey_in_ruleColor6208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DodgerBlue_in_ruleColor6227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FireBrick_in_ruleColor6246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FloralWhite_in_ruleColor6265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ForestGreen_in_ruleColor6284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Fuchsia_in_ruleColor6303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Gainsboro_in_ruleColor6322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GhostWhite_in_ruleColor6341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Gold_in_ruleColor6360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GoldenRod_in_ruleColor6379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Gray_in_ruleColor6398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Green_in_ruleColor6417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GreenYellow_in_ruleColor6436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Grey_in_ruleColor6455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HoneyDew_in_ruleColor6474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HotPink_in_ruleColor6493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IndianRed_in_ruleColor6512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Indigo_in_ruleColor6531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ivory_in_ruleColor6550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Khaki_in_ruleColor6569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lavender_in_ruleColor6588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LavenderBlush_in_ruleColor6607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LawnGreen_in_ruleColor6626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LemonChiffon_in_ruleColor6645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightBlue_in_ruleColor6664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightCoral_in_ruleColor6683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightCyan_in_ruleColor6702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGoldenRodYellow_in_ruleColor6721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGray_in_ruleColor6740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGreen_in_ruleColor6759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGrey_in_ruleColor6778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightPink_in_ruleColor6797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSalmon_in_ruleColor6816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSeaGreen_in_ruleColor6835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSkyBlue_in_ruleColor6854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSlateGray_in_ruleColor6873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSlateGrey_in_ruleColor6892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSteelBlue_in_ruleColor6911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightYellow_in_ruleColor6930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lime_in_ruleColor6949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LimeGreen_in_ruleColor6968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Linen_in_ruleColor6987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Magenta_in_ruleColor7006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Maroon_in_ruleColor7025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumAquaMarine_in_ruleColor7044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumBlue_in_ruleColor7063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumOrchid_in_ruleColor7082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumPurple_in_ruleColor7101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumSeaGreen_in_ruleColor7120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumSlateBlue_in_ruleColor7139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumSpringGreen_in_ruleColor7158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumTurquoise_in_ruleColor7177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumVioletRed_in_ruleColor7196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MidnightBlue_in_ruleColor7215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MintCream_in_ruleColor7234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MistyRose_in_ruleColor7253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Moccasin_in_ruleColor7272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NavajoWhite_in_ruleColor7291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Navy_in_ruleColor7310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OldLace_in_ruleColor7329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Olive_in_ruleColor7348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OliveDrab_in_ruleColor7367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OrangeRed_in_ruleColor7386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Orchid_in_ruleColor7405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleGoldenRod_in_ruleColor7424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleGreen_in_ruleColor7443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleTurquoise_in_ruleColor7462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleVioletRed_in_ruleColor7481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PapayaWhip_in_ruleColor7500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PeachPuff_in_ruleColor7519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Peru_in_ruleColor7538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Pink_in_ruleColor7557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plum_in_ruleColor7576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PowderBlue_in_ruleColor7595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Purple_in_ruleColor7614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Red_in_ruleColor7633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RosyBrown_in_ruleColor7652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RoyalBlue_in_ruleColor7671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SaddleBrown_in_ruleColor7690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Salmon_in_ruleColor7709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SandyBrown_in_ruleColor7728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SeaGreen_in_ruleColor7747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Sienna_in_ruleColor7766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Silver_in_ruleColor7785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SkyBlue_in_ruleColor7804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SlateBlue_in_ruleColor7823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SlateGray_in_ruleColor7842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SlateGrey_in_ruleColor7861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Snow_in_ruleColor7880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SpringGreen_in_ruleColor7899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SteelBlue_in_ruleColor7918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Tan_in_ruleColor7937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Teal_in_ruleColor7956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Thistle_in_ruleColor7975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Tomato_in_ruleColor7994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Turquoise_in_ruleColor8013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Violet_in_ruleColor8032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Wheat_in_ruleColor8051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_White_in_ruleColor8070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WhiteSmoke_in_ruleColor8089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Yellow_in_ruleColor8108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_YellowGreen_in_ruleColor8127 = new BitSet(new long[]{0x0000000000000002L});

}