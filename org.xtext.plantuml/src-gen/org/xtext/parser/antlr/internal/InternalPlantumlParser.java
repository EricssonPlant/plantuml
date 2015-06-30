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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LightGoldenRodYellow", "MediumSpringGreen", "MediumAquaMarine", "MediumSlateBlue", "MediumTurquoise", "MediumVioletRed", "BlanchedAlmond", "CornflowerBlue", "DarkOliveGreen", "LightSlateGray", "LightSlateGrey", "LightSteelBlue", "MediumSeaGreen", "DarkGoldenRod", "DarkSlateBlue", "DarkSlateGray", "DarkSlateGrey", "DarkTurquoise", "LavenderBlush", "LightSeaGreen", "PaleGoldenRod", "PaleTurquoise", "PaleVioletRed", "AntiqueWhite", "DarkSeaGreen", "LemonChiffon", "LightSkyBlue", "MediumOrchid", "MediumPurple", "MidnightBlue", "DarkMagenta", "DeepSkyBlue", "FloralWhite", "ForestGreen", "GreenYellow", "LightSalmon", "LightYellow", "NavajoWhite", "SaddleBrown", "SpringGreen", "YellowGreen", "Participant", "Aquamarine", "BlueViolet", "Chartreuse", "DarkOrchid", "DarkViolet", "Darkorange", "DodgerBlue", "GhostWhite", "LightCoral", "LightGreen", "MediumBlue", "PapayaWhip", "PowderBlue", "SandyBrown", "WhiteSmoke", "Autonumber", "Deactivate", "AliceBlue", "BurlyWood", "CadetBlue", "Chocolate", "DarkGreen", "DarkKhaki", "DarkSalmo", "FireBrick", "Gainsboro", "GoldenRod", "IndianRed", "LawnGreen", "LightBlue", "LightCyan", "LightGray", "LightGrey", "LightPink", "LimeGreen", "MintCream", "MistyRose", "OliveDrab", "OrangeRed", "PaleGreen", "PeachPuff", "RosyBrown", "RoyalBlue", "SlateBlue", "SlateGray", "SlateGrey", "SteelBlue", "Turquoise", "Endlegend", "Cornsilk", "DarkBlue", "DarkCyan", "DarkGray", "DarkGrey", "DeepPink", "HoneyDew", "Lavender", "Moccasin", "SeaGreen", "Activate", "Boundary", "Critical", "Database", "Crimson", "DarkRed", "DimGray", "DimGrey", "Fuchsia", "HotPink", "Magenta", "OldLace", "SkyBlue", "Thistle", "Control", "Destroy", "Footbox", "Newpage", "Bisque", "Indigo", "Maroon", "Orchid", "Purple", "Salmon", "Sienna", "Silver", "Tomato", "Violet", "Yellow", "Center", "Create", "Entity", "Legend", "Azure", "Beige", "Black", "Brown", "Coral", "Green", "Ivory", "Khaki", "Linen", "Olive", "Wheat", "White", "Actor", "Break", "Group", "Right", "Title", "Aqua", "Blue", "Cyan", "Gold", "Gray", "Grey", "Lime", "Navy", "Peru", "Pink", "Plum", "Snow", "Teal", "Else", "Hide", "Left", "Loop", "Note", "Over", "FullStopFullStopFullStop", "Red", "Tan", "Alt", "Box", "End", "Opt", "Par", "Ref", "VerticalLineVerticalLineVerticalLine", "LessThanSignLessThanSign", "EqualsSignEqualsSign", "GreaterThanSignGreaterThanSign", "As", "Of", "VerticalLineVerticalLine", "QuotationMark", "NumberSign", "LeftParenthesis", "RightParenthesis", "Comma", "HyphenMinus", "FullStop", "Colon", "LessThanSign", "EqualsSign", "GreaterThanSign", "RULE_NEWLINE", "RULE_START", "RULE_END", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_SEQUENCE", "RULE_HEXCODE", "RULE_INT", "RULE_ID", "RULE_WS", "RULE_ANY_OTHER"
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
    public static final int LessThanSign=198;
    public static final int DarkGrey=99;
    public static final int DodgerBlue=52;
    public static final int Aquamarine=46;
    public static final int Beige=139;
    public static final int Actor=150;
    public static final int OliveDrab=83;
    public static final int GreaterThanSign=200;
    public static final int Violet=132;
    public static final int LimeGreen=80;
    public static final int RULE_ID=209;
    public static final int PowderBlue=58;
    public static final int Magenta=115;
    public static final int DarkTurquoise=21;
    public static final int IndianRed=73;
    public static final int LightGray=77;
    public static final int PeachPuff=86;
    public static final int Participant=45;
    public static final int Activate=105;
    public static final int RULE_INT=208;
    public static final int Note=172;
    public static final int LightBlue=75;
    public static final int RULE_HEXCODE=207;
    public static final int SpringGreen=43;
    public static final int Indigo=124;
    public static final int DarkRed=110;
    public static final int Wheat=148;
    public static final int LessThanSignLessThanSign=184;
    public static final int MediumAquaMarine=6;
    public static final int DarkCyan=97;
    public static final int Group=152;
    public static final int LawnGreen=74;
    public static final int QuotationMark=190;
    public static final int DarkSalmo=69;
    public static final int As=187;
    public static final int Teal=167;
    public static final int HoneyDew=101;
    public static final int Maroon=125;
    public static final int FullStop=196;
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
    public static final int RightParenthesis=193;
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
    public static final int RULE_END=203;
    public static final int Aqua=155;
    public static final int RULE_START=202;
    public static final int Bisque=123;
    public static final int Footbox=121;
    public static final int MediumBlue=56;
    public static final int RULE_SL_COMMENT=205;
    public static final int BlueViolet=47;
    public static final int Over=173;
    public static final int Control=119;
    public static final int Lavender=102;
    public static final int CornflowerBlue=11;
    public static final int Colon=197;
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
    public static final int LeftParenthesis=192;
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
    public static final int RULE_ML_COMMENT=204;
    public static final int Peru=163;
    public static final int RosyBrown=87;
    public static final int Hide=169;
    public static final int FireBrick=70;
    public static final int Legend=137;
    public static final int VerticalLineVerticalLine=189;
    public static final int RULE_NEWLINE=201;
    public static final int Right=153;
    public static final int Newpage=122;
    public static final int Comma=194;
    public static final int HyphenMinus=195;
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
    public static final int RULE_SEQUENCE=206;
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
    public static final int NumberSign=191;
    public static final int PapayaWhip=57;
    public static final int MediumTurquoise=8;
    public static final int AntiqueWhite=27;
    public static final int LightPink=79;
    public static final int OldLace=116;
    public static final int DarkGoldenRod=17;
    public static final int CadetBlue=65;
    public static final int BurlyWood=64;
    public static final int Lime=161;
    public static final int EqualsSign=199;
    public static final int Destroy=120;
    public static final int Create=135;
    public static final int LightSteelBlue=15;
    public static final int GhostWhite=53;
    public static final int SteelBlue=92;
    public static final int PaleTurquoise=25;
    public static final int RULE_WS=210;
    public static final int RULE_ANY_OTHER=211;
    public static final int DeepPink=100;
    public static final int MediumVioletRed=9;
    public static final int HotPink=114;
    public static final int LightYellow=40;
    public static final int Navy=162;
    public static final int SaddleBrown=42;
    public static final int Coral=142;
    public static final int SlateGrey=91;
    public static final int Of=188;
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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:441:1: ruleDefinition returns [EObject current=null] : ( (otherlv_0= Actor ( (lv_name_1_0= ruleMyID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= ruleMyID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= ruleMyID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= ruleMyID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= ruleMyID ) ) ) | (otherlv_10= Participant ( ( (lv_name_11_0= ruleMyID ) ) | (otherlv_12= QuotationMark ( ruleEndID )* otherlv_14= QuotationMark otherlv_15= As this_ID_16= RULE_ID ) ) (otherlv_17= LessThanSignLessThanSign (otherlv_18= LeftParenthesis ruleEndID otherlv_20= Comma otherlv_21= NumberSign this_HEXCODE_22= RULE_HEXCODE otherlv_23= RightParenthesis )? ( ruleEndID )* otherlv_25= GreaterThanSignGreaterThanSign )? ) ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token this_ID_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token this_HEXCODE_22=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;

        AntlrDatatypeRuleToken lv_name_7_0 = null;

        AntlrDatatypeRuleToken lv_name_9_0 = null;

        AntlrDatatypeRuleToken lv_name_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:444:28: ( ( (otherlv_0= Actor ( (lv_name_1_0= ruleMyID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= ruleMyID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= ruleMyID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= ruleMyID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= ruleMyID ) ) ) | (otherlv_10= Participant ( ( (lv_name_11_0= ruleMyID ) ) | (otherlv_12= QuotationMark ( ruleEndID )* otherlv_14= QuotationMark otherlv_15= As this_ID_16= RULE_ID ) ) (otherlv_17= LessThanSignLessThanSign (otherlv_18= LeftParenthesis ruleEndID otherlv_20= Comma otherlv_21= NumberSign this_HEXCODE_22= RULE_HEXCODE otherlv_23= RightParenthesis )? ( ruleEndID )* otherlv_25= GreaterThanSignGreaterThanSign )? ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:445:1: ( (otherlv_0= Actor ( (lv_name_1_0= ruleMyID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= ruleMyID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= ruleMyID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= ruleMyID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= ruleMyID ) ) ) | (otherlv_10= Participant ( ( (lv_name_11_0= ruleMyID ) ) | (otherlv_12= QuotationMark ( ruleEndID )* otherlv_14= QuotationMark otherlv_15= As this_ID_16= RULE_ID ) ) (otherlv_17= LessThanSignLessThanSign (otherlv_18= LeftParenthesis ruleEndID otherlv_20= Comma otherlv_21= NumberSign this_HEXCODE_22= RULE_HEXCODE otherlv_23= RightParenthesis )? ( ruleEndID )* otherlv_25= GreaterThanSignGreaterThanSign )? ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:445:1: ( (otherlv_0= Actor ( (lv_name_1_0= ruleMyID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= ruleMyID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= ruleMyID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= ruleMyID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= ruleMyID ) ) ) | (otherlv_10= Participant ( ( (lv_name_11_0= ruleMyID ) ) | (otherlv_12= QuotationMark ( ruleEndID )* otherlv_14= QuotationMark otherlv_15= As this_ID_16= RULE_ID ) ) (otherlv_17= LessThanSignLessThanSign (otherlv_18= LeftParenthesis ruleEndID otherlv_20= Comma otherlv_21= NumberSign this_HEXCODE_22= RULE_HEXCODE otherlv_23= RightParenthesis )? ( ruleEndID )* otherlv_25= GreaterThanSignGreaterThanSign )? ) )
            int alt13=6;
            switch ( input.LA(1) ) {
            case Actor:
                {
                alt13=1;
                }
                break;
            case Boundary:
                {
                alt13=2;
                }
                break;
            case Control:
                {
                alt13=3;
                }
                break;
            case Entity:
                {
                alt13=4;
                }
                break;
            case Database:
                {
                alt13=5;
                }
                break;
            case Participant:
                {
                alt13=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:565:6: (otherlv_10= Participant ( ( (lv_name_11_0= ruleMyID ) ) | (otherlv_12= QuotationMark ( ruleEndID )* otherlv_14= QuotationMark otherlv_15= As this_ID_16= RULE_ID ) ) (otherlv_17= LessThanSignLessThanSign (otherlv_18= LeftParenthesis ruleEndID otherlv_20= Comma otherlv_21= NumberSign this_HEXCODE_22= RULE_HEXCODE otherlv_23= RightParenthesis )? ( ruleEndID )* otherlv_25= GreaterThanSignGreaterThanSign )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:565:6: (otherlv_10= Participant ( ( (lv_name_11_0= ruleMyID ) ) | (otherlv_12= QuotationMark ( ruleEndID )* otherlv_14= QuotationMark otherlv_15= As this_ID_16= RULE_ID ) ) (otherlv_17= LessThanSignLessThanSign (otherlv_18= LeftParenthesis ruleEndID otherlv_20= Comma otherlv_21= NumberSign this_HEXCODE_22= RULE_HEXCODE otherlv_23= RightParenthesis )? ( ruleEndID )* otherlv_25= GreaterThanSignGreaterThanSign )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:566:2: otherlv_10= Participant ( ( (lv_name_11_0= ruleMyID ) ) | (otherlv_12= QuotationMark ( ruleEndID )* otherlv_14= QuotationMark otherlv_15= As this_ID_16= RULE_ID ) ) (otherlv_17= LessThanSignLessThanSign (otherlv_18= LeftParenthesis ruleEndID otherlv_20= Comma otherlv_21= NumberSign this_HEXCODE_22= RULE_HEXCODE otherlv_23= RightParenthesis )? ( ruleEndID )* otherlv_25= GreaterThanSignGreaterThanSign )?
                    {
                    otherlv_10=(Token)match(input,Participant,FOLLOW_Participant_in_ruleDefinition1230); 

                        	newLeafNode(otherlv_10, grammarAccess.getDefinitionAccess().getParticipantKeyword_5_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:570:1: ( ( (lv_name_11_0= ruleMyID ) ) | (otherlv_12= QuotationMark ( ruleEndID )* otherlv_14= QuotationMark otherlv_15= As this_ID_16= RULE_ID ) )
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0>=Autonumber && LA9_0<=Deactivate)||LA9_0==Endlegend||LA9_0==Activate||LA9_0==Critical||(LA9_0>=Destroy && LA9_0<=Newpage)||(LA9_0>=Center && LA9_0<=Create)||LA9_0==Legend||(LA9_0>=Break && LA9_0<=Title)||(LA9_0>=Else && LA9_0<=Over)||(LA9_0>=Alt && LA9_0<=Ref)||LA9_0==Of||(LA9_0>=NumberSign && LA9_0<=GreaterThanSign)||(LA9_0>=RULE_INT && LA9_0<=RULE_ID)) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==QuotationMark) ) {
                        alt9=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:570:2: ( (lv_name_11_0= ruleMyID ) )
                            {
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:570:2: ( (lv_name_11_0= ruleMyID ) )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:571:1: (lv_name_11_0= ruleMyID )
                            {
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:571:1: (lv_name_11_0= ruleMyID )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:572:3: lv_name_11_0= ruleMyID
                            {
                             
                            	        newCompositeNode(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_5_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleMyID_in_ruleDefinition1251);
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


                            }
                            break;
                        case 2 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:589:6: (otherlv_12= QuotationMark ( ruleEndID )* otherlv_14= QuotationMark otherlv_15= As this_ID_16= RULE_ID )
                            {
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:589:6: (otherlv_12= QuotationMark ( ruleEndID )* otherlv_14= QuotationMark otherlv_15= As this_ID_16= RULE_ID )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:590:2: otherlv_12= QuotationMark ( ruleEndID )* otherlv_14= QuotationMark otherlv_15= As this_ID_16= RULE_ID
                            {
                            otherlv_12=(Token)match(input,QuotationMark,FOLLOW_QuotationMark_in_ruleDefinition1271); 

                                	newLeafNode(otherlv_12, grammarAccess.getDefinitionAccess().getQuotationMarkKeyword_5_1_1_0());
                                
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:594:1: ( ruleEndID )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( ((LA8_0>=Autonumber && LA8_0<=Deactivate)||LA8_0==Endlegend||LA8_0==Activate||LA8_0==Critical||(LA8_0>=Destroy && LA8_0<=Newpage)||(LA8_0>=Center && LA8_0<=Create)||LA8_0==Legend||(LA8_0>=Break && LA8_0<=Title)||(LA8_0>=Else && LA8_0<=Over)||(LA8_0>=Alt && LA8_0<=Box)||(LA8_0>=Opt && LA8_0<=Ref)||LA8_0==Of||(LA8_0>=NumberSign && LA8_0<=GreaterThanSign)||(LA8_0>=RULE_INT && LA8_0<=RULE_ID)) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:595:5: ruleEndID
                            	    {
                            	     
                            	            newCompositeNode(grammarAccess.getDefinitionAccess().getEndIDParserRuleCall_5_1_1_1()); 
                            	        
                            	    pushFollow(FOLLOW_ruleEndID_in_ruleDefinition1287);
                            	    ruleEndID();

                            	    state._fsp--;


                            	            afterParserOrEnumRuleCall();
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop8;
                                }
                            } while (true);

                            otherlv_14=(Token)match(input,QuotationMark,FOLLOW_QuotationMark_in_ruleDefinition1301); 

                                	newLeafNode(otherlv_14, grammarAccess.getDefinitionAccess().getQuotationMarkKeyword_5_1_1_2());
                                
                            otherlv_15=(Token)match(input,As,FOLLOW_As_in_ruleDefinition1313); 

                                	newLeafNode(otherlv_15, grammarAccess.getDefinitionAccess().getAsKeyword_5_1_1_3());
                                
                            this_ID_16=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1323); 
                             
                                newLeafNode(this_ID_16, grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_1_1_4()); 
                                

                            }


                            }
                            break;

                    }

                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:616:3: (otherlv_17= LessThanSignLessThanSign (otherlv_18= LeftParenthesis ruleEndID otherlv_20= Comma otherlv_21= NumberSign this_HEXCODE_22= RULE_HEXCODE otherlv_23= RightParenthesis )? ( ruleEndID )* otherlv_25= GreaterThanSignGreaterThanSign )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==LessThanSignLessThanSign) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:617:2: otherlv_17= LessThanSignLessThanSign (otherlv_18= LeftParenthesis ruleEndID otherlv_20= Comma otherlv_21= NumberSign this_HEXCODE_22= RULE_HEXCODE otherlv_23= RightParenthesis )? ( ruleEndID )* otherlv_25= GreaterThanSignGreaterThanSign
                            {
                            otherlv_17=(Token)match(input,LessThanSignLessThanSign,FOLLOW_LessThanSignLessThanSign_in_ruleDefinition1338); 

                                	newLeafNode(otherlv_17, grammarAccess.getDefinitionAccess().getLessThanSignLessThanSignKeyword_5_2_0());
                                
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:621:1: (otherlv_18= LeftParenthesis ruleEndID otherlv_20= Comma otherlv_21= NumberSign this_HEXCODE_22= RULE_HEXCODE otherlv_23= RightParenthesis )?
                            int alt10=2;
                            alt10 = dfa10.predict(input);
                            switch (alt10) {
                                case 1 :
                                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:622:2: otherlv_18= LeftParenthesis ruleEndID otherlv_20= Comma otherlv_21= NumberSign this_HEXCODE_22= RULE_HEXCODE otherlv_23= RightParenthesis
                                    {
                                    otherlv_18=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_ruleDefinition1351); 

                                        	newLeafNode(otherlv_18, grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_0());
                                        
                                     
                                            newCompositeNode(grammarAccess.getDefinitionAccess().getEndIDParserRuleCall_5_2_1_1()); 
                                        
                                    pushFollow(FOLLOW_ruleEndID_in_ruleDefinition1366);
                                    ruleEndID();

                                    state._fsp--;


                                            afterParserOrEnumRuleCall();
                                        
                                    otherlv_20=(Token)match(input,Comma,FOLLOW_Comma_in_ruleDefinition1378); 

                                        	newLeafNode(otherlv_20, grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_2());
                                        
                                    otherlv_21=(Token)match(input,NumberSign,FOLLOW_NumberSign_in_ruleDefinition1390); 

                                        	newLeafNode(otherlv_21, grammarAccess.getDefinitionAccess().getNumberSignKeyword_5_2_1_3());
                                        
                                    this_HEXCODE_22=(Token)match(input,RULE_HEXCODE,FOLLOW_RULE_HEXCODE_in_ruleDefinition1400); 
                                     
                                        newLeafNode(this_HEXCODE_22, grammarAccess.getDefinitionAccess().getHEXCODETerminalRuleCall_5_2_1_4()); 
                                        
                                    otherlv_23=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_ruleDefinition1412); 

                                        	newLeafNode(otherlv_23, grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_5());
                                        

                                    }
                                    break;

                            }

                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:653:3: ( ruleEndID )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( ((LA11_0>=Autonumber && LA11_0<=Deactivate)||LA11_0==Endlegend||LA11_0==Activate||LA11_0==Critical||(LA11_0>=Destroy && LA11_0<=Newpage)||(LA11_0>=Center && LA11_0<=Create)||LA11_0==Legend||(LA11_0>=Break && LA11_0<=Title)||(LA11_0>=Else && LA11_0<=Over)||(LA11_0>=Alt && LA11_0<=Box)||(LA11_0>=Opt && LA11_0<=Ref)||LA11_0==Of||(LA11_0>=NumberSign && LA11_0<=GreaterThanSign)||(LA11_0>=RULE_INT && LA11_0<=RULE_ID)) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:654:5: ruleEndID
                            	    {
                            	     
                            	            newCompositeNode(grammarAccess.getDefinitionAccess().getEndIDParserRuleCall_5_2_2()); 
                            	        
                            	    pushFollow(FOLLOW_ruleEndID_in_ruleDefinition1430);
                            	    ruleEndID();

                            	    state._fsp--;


                            	            afterParserOrEnumRuleCall();
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop11;
                                }
                            } while (true);

                            otherlv_25=(Token)match(input,GreaterThanSignGreaterThanSign,FOLLOW_GreaterThanSignGreaterThanSign_in_ruleDefinition1444); 

                                	newLeafNode(otherlv_25, grammarAccess.getDefinitionAccess().getGreaterThanSignGreaterThanSignKeyword_5_2_3());
                                

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:676:1: entryRuleEndID returns [String current=null] : iv_ruleEndID= ruleEndID EOF ;
    public final String entryRuleEndID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEndID = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:677:1: (iv_ruleEndID= ruleEndID EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:678:2: iv_ruleEndID= ruleEndID EOF
            {
             newCompositeNode(grammarAccess.getEndIDRule()); 
            pushFollow(FOLLOW_ruleEndID_in_entryRuleEndID1484);
            iv_ruleEndID=ruleEndID();

            state._fsp--;

             current =iv_ruleEndID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndID1495); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:685:1: ruleEndID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= Create | kw= Autonumber | kw= Title | kw= Legend | kw= Right | kw= Left | kw= Center | kw= Endlegend | kw= Alt | kw= Else | kw= Newpage | kw= Opt | kw= Loop | kw= Par | kw= Break | kw= Critical | kw= Group | kw= Note | kw= Over | kw= Of | kw= Ref | kw= Hide | kw= Footbox | kw= Activate | kw= Deactivate | kw= Destroy | kw= Box | kw= NumberSign | kw= Comma | kw= LeftParenthesis | kw= RightParenthesis | kw= EqualsSign | this_INT_33= RULE_INT | kw= HyphenMinus | kw= FullStop | kw= Colon | kw= GreaterThanSign | kw= LessThanSign ) ;
    public final AntlrDatatypeRuleToken ruleEndID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_INT_33=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:689:6: ( (this_ID_0= RULE_ID | kw= Create | kw= Autonumber | kw= Title | kw= Legend | kw= Right | kw= Left | kw= Center | kw= Endlegend | kw= Alt | kw= Else | kw= Newpage | kw= Opt | kw= Loop | kw= Par | kw= Break | kw= Critical | kw= Group | kw= Note | kw= Over | kw= Of | kw= Ref | kw= Hide | kw= Footbox | kw= Activate | kw= Deactivate | kw= Destroy | kw= Box | kw= NumberSign | kw= Comma | kw= LeftParenthesis | kw= RightParenthesis | kw= EqualsSign | this_INT_33= RULE_INT | kw= HyphenMinus | kw= FullStop | kw= Colon | kw= GreaterThanSign | kw= LessThanSign ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:690:1: (this_ID_0= RULE_ID | kw= Create | kw= Autonumber | kw= Title | kw= Legend | kw= Right | kw= Left | kw= Center | kw= Endlegend | kw= Alt | kw= Else | kw= Newpage | kw= Opt | kw= Loop | kw= Par | kw= Break | kw= Critical | kw= Group | kw= Note | kw= Over | kw= Of | kw= Ref | kw= Hide | kw= Footbox | kw= Activate | kw= Deactivate | kw= Destroy | kw= Box | kw= NumberSign | kw= Comma | kw= LeftParenthesis | kw= RightParenthesis | kw= EqualsSign | this_INT_33= RULE_INT | kw= HyphenMinus | kw= FullStop | kw= Colon | kw= GreaterThanSign | kw= LessThanSign )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:690:1: (this_ID_0= RULE_ID | kw= Create | kw= Autonumber | kw= Title | kw= Legend | kw= Right | kw= Left | kw= Center | kw= Endlegend | kw= Alt | kw= Else | kw= Newpage | kw= Opt | kw= Loop | kw= Par | kw= Break | kw= Critical | kw= Group | kw= Note | kw= Over | kw= Of | kw= Ref | kw= Hide | kw= Footbox | kw= Activate | kw= Deactivate | kw= Destroy | kw= Box | kw= NumberSign | kw= Comma | kw= LeftParenthesis | kw= RightParenthesis | kw= EqualsSign | this_INT_33= RULE_INT | kw= HyphenMinus | kw= FullStop | kw= Colon | kw= GreaterThanSign | kw= LessThanSign )
            int alt14=39;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt14=1;
                }
                break;
            case Create:
                {
                alt14=2;
                }
                break;
            case Autonumber:
                {
                alt14=3;
                }
                break;
            case Title:
                {
                alt14=4;
                }
                break;
            case Legend:
                {
                alt14=5;
                }
                break;
            case Right:
                {
                alt14=6;
                }
                break;
            case Left:
                {
                alt14=7;
                }
                break;
            case Center:
                {
                alt14=8;
                }
                break;
            case Endlegend:
                {
                alt14=9;
                }
                break;
            case Alt:
                {
                alt14=10;
                }
                break;
            case Else:
                {
                alt14=11;
                }
                break;
            case Newpage:
                {
                alt14=12;
                }
                break;
            case Opt:
                {
                alt14=13;
                }
                break;
            case Loop:
                {
                alt14=14;
                }
                break;
            case Par:
                {
                alt14=15;
                }
                break;
            case Break:
                {
                alt14=16;
                }
                break;
            case Critical:
                {
                alt14=17;
                }
                break;
            case Group:
                {
                alt14=18;
                }
                break;
            case Note:
                {
                alt14=19;
                }
                break;
            case Over:
                {
                alt14=20;
                }
                break;
            case Of:
                {
                alt14=21;
                }
                break;
            case Ref:
                {
                alt14=22;
                }
                break;
            case Hide:
                {
                alt14=23;
                }
                break;
            case Footbox:
                {
                alt14=24;
                }
                break;
            case Activate:
                {
                alt14=25;
                }
                break;
            case Deactivate:
                {
                alt14=26;
                }
                break;
            case Destroy:
                {
                alt14=27;
                }
                break;
            case Box:
                {
                alt14=28;
                }
                break;
            case NumberSign:
                {
                alt14=29;
                }
                break;
            case Comma:
                {
                alt14=30;
                }
                break;
            case LeftParenthesis:
                {
                alt14=31;
                }
                break;
            case RightParenthesis:
                {
                alt14=32;
                }
                break;
            case EqualsSign:
                {
                alt14=33;
                }
                break;
            case RULE_INT:
                {
                alt14=34;
                }
                break;
            case HyphenMinus:
                {
                alt14=35;
                }
                break;
            case FullStop:
                {
                alt14=36;
                }
                break;
            case Colon:
                {
                alt14=37;
                }
                break;
            case GreaterThanSign:
                {
                alt14=38;
                }
                break;
            case LessThanSign:
                {
                alt14=39;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:690:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEndID1535); 

                    		current.merge(this_ID_0);
                        
                     
                        newLeafNode(this_ID_0, grammarAccess.getEndIDAccess().getIDTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:699:2: kw= Create
                    {
                    kw=(Token)match(input,Create,FOLLOW_Create_in_ruleEndID1559); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getCreateKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:706:2: kw= Autonumber
                    {
                    kw=(Token)match(input,Autonumber,FOLLOW_Autonumber_in_ruleEndID1578); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getAutonumberKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:713:2: kw= Title
                    {
                    kw=(Token)match(input,Title,FOLLOW_Title_in_ruleEndID1597); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getTitleKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:720:2: kw= Legend
                    {
                    kw=(Token)match(input,Legend,FOLLOW_Legend_in_ruleEndID1616); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getLegendKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:727:2: kw= Right
                    {
                    kw=(Token)match(input,Right,FOLLOW_Right_in_ruleEndID1635); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getRightKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:734:2: kw= Left
                    {
                    kw=(Token)match(input,Left,FOLLOW_Left_in_ruleEndID1654); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getLeftKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:741:2: kw= Center
                    {
                    kw=(Token)match(input,Center,FOLLOW_Center_in_ruleEndID1673); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getCenterKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:748:2: kw= Endlegend
                    {
                    kw=(Token)match(input,Endlegend,FOLLOW_Endlegend_in_ruleEndID1692); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getEndlegendKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:755:2: kw= Alt
                    {
                    kw=(Token)match(input,Alt,FOLLOW_Alt_in_ruleEndID1711); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getAltKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:762:2: kw= Else
                    {
                    kw=(Token)match(input,Else,FOLLOW_Else_in_ruleEndID1730); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getElseKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:769:2: kw= Newpage
                    {
                    kw=(Token)match(input,Newpage,FOLLOW_Newpage_in_ruleEndID1749); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getNewpageKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:776:2: kw= Opt
                    {
                    kw=(Token)match(input,Opt,FOLLOW_Opt_in_ruleEndID1768); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getOptKeyword_12()); 
                        

                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:783:2: kw= Loop
                    {
                    kw=(Token)match(input,Loop,FOLLOW_Loop_in_ruleEndID1787); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getLoopKeyword_13()); 
                        

                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:790:2: kw= Par
                    {
                    kw=(Token)match(input,Par,FOLLOW_Par_in_ruleEndID1806); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getParKeyword_14()); 
                        

                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:797:2: kw= Break
                    {
                    kw=(Token)match(input,Break,FOLLOW_Break_in_ruleEndID1825); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getBreakKeyword_15()); 
                        

                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:804:2: kw= Critical
                    {
                    kw=(Token)match(input,Critical,FOLLOW_Critical_in_ruleEndID1844); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getCriticalKeyword_16()); 
                        

                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:811:2: kw= Group
                    {
                    kw=(Token)match(input,Group,FOLLOW_Group_in_ruleEndID1863); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getGroupKeyword_17()); 
                        

                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:818:2: kw= Note
                    {
                    kw=(Token)match(input,Note,FOLLOW_Note_in_ruleEndID1882); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getNoteKeyword_18()); 
                        

                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:825:2: kw= Over
                    {
                    kw=(Token)match(input,Over,FOLLOW_Over_in_ruleEndID1901); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getOverKeyword_19()); 
                        

                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:832:2: kw= Of
                    {
                    kw=(Token)match(input,Of,FOLLOW_Of_in_ruleEndID1920); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getOfKeyword_20()); 
                        

                    }
                    break;
                case 22 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:839:2: kw= Ref
                    {
                    kw=(Token)match(input,Ref,FOLLOW_Ref_in_ruleEndID1939); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getRefKeyword_21()); 
                        

                    }
                    break;
                case 23 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:846:2: kw= Hide
                    {
                    kw=(Token)match(input,Hide,FOLLOW_Hide_in_ruleEndID1958); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getHideKeyword_22()); 
                        

                    }
                    break;
                case 24 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:853:2: kw= Footbox
                    {
                    kw=(Token)match(input,Footbox,FOLLOW_Footbox_in_ruleEndID1977); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getFootboxKeyword_23()); 
                        

                    }
                    break;
                case 25 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:860:2: kw= Activate
                    {
                    kw=(Token)match(input,Activate,FOLLOW_Activate_in_ruleEndID1996); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getActivateKeyword_24()); 
                        

                    }
                    break;
                case 26 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:867:2: kw= Deactivate
                    {
                    kw=(Token)match(input,Deactivate,FOLLOW_Deactivate_in_ruleEndID2015); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getDeactivateKeyword_25()); 
                        

                    }
                    break;
                case 27 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:874:2: kw= Destroy
                    {
                    kw=(Token)match(input,Destroy,FOLLOW_Destroy_in_ruleEndID2034); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getDestroyKeyword_26()); 
                        

                    }
                    break;
                case 28 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:881:2: kw= Box
                    {
                    kw=(Token)match(input,Box,FOLLOW_Box_in_ruleEndID2053); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getBoxKeyword_27()); 
                        

                    }
                    break;
                case 29 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:888:2: kw= NumberSign
                    {
                    kw=(Token)match(input,NumberSign,FOLLOW_NumberSign_in_ruleEndID2072); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getNumberSignKeyword_28()); 
                        

                    }
                    break;
                case 30 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:895:2: kw= Comma
                    {
                    kw=(Token)match(input,Comma,FOLLOW_Comma_in_ruleEndID2091); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getCommaKeyword_29()); 
                        

                    }
                    break;
                case 31 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:902:2: kw= LeftParenthesis
                    {
                    kw=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_ruleEndID2110); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getLeftParenthesisKeyword_30()); 
                        

                    }
                    break;
                case 32 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:909:2: kw= RightParenthesis
                    {
                    kw=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_ruleEndID2129); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getRightParenthesisKeyword_31()); 
                        

                    }
                    break;
                case 33 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:916:2: kw= EqualsSign
                    {
                    kw=(Token)match(input,EqualsSign,FOLLOW_EqualsSign_in_ruleEndID2148); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getEqualsSignKeyword_32()); 
                        

                    }
                    break;
                case 34 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:922:10: this_INT_33= RULE_INT
                    {
                    this_INT_33=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEndID2169); 

                    		current.merge(this_INT_33);
                        
                     
                        newLeafNode(this_INT_33, grammarAccess.getEndIDAccess().getINTTerminalRuleCall_33()); 
                        

                    }
                    break;
                case 35 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:931:2: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FOLLOW_HyphenMinus_in_ruleEndID2193); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getHyphenMinusKeyword_34()); 
                        

                    }
                    break;
                case 36 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:938:2: kw= FullStop
                    {
                    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleEndID2212); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getFullStopKeyword_35()); 
                        

                    }
                    break;
                case 37 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:945:2: kw= Colon
                    {
                    kw=(Token)match(input,Colon,FOLLOW_Colon_in_ruleEndID2231); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getColonKeyword_36()); 
                        

                    }
                    break;
                case 38 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:952:2: kw= GreaterThanSign
                    {
                    kw=(Token)match(input,GreaterThanSign,FOLLOW_GreaterThanSign_in_ruleEndID2250); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getGreaterThanSignKeyword_37()); 
                        

                    }
                    break;
                case 39 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:959:2: kw= LessThanSign
                    {
                    kw=(Token)match(input,LessThanSign,FOLLOW_LessThanSign_in_ruleEndID2269); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:972:1: entryRuleMyID returns [String current=null] : iv_ruleMyID= ruleMyID EOF ;
    public final String entryRuleMyID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyID = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:973:1: (iv_ruleMyID= ruleMyID EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:974:2: iv_ruleMyID= ruleMyID EOF
            {
             newCompositeNode(grammarAccess.getMyIDRule()); 
            pushFollow(FOLLOW_ruleMyID_in_entryRuleMyID2309);
            iv_ruleMyID=ruleMyID();

            state._fsp--;

             current =iv_ruleMyID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMyID2320); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:981:1: ruleMyID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EndID_0= ruleEndID | kw= End ) ;
    public final AntlrDatatypeRuleToken ruleMyID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EndID_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:985:6: ( (this_EndID_0= ruleEndID | kw= End ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:986:1: (this_EndID_0= ruleEndID | kw= End )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:986:1: (this_EndID_0= ruleEndID | kw= End )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=Autonumber && LA15_0<=Deactivate)||LA15_0==Endlegend||LA15_0==Activate||LA15_0==Critical||(LA15_0>=Destroy && LA15_0<=Newpage)||(LA15_0>=Center && LA15_0<=Create)||LA15_0==Legend||(LA15_0>=Break && LA15_0<=Title)||(LA15_0>=Else && LA15_0<=Over)||(LA15_0>=Alt && LA15_0<=Box)||(LA15_0>=Opt && LA15_0<=Ref)||LA15_0==Of||(LA15_0>=NumberSign && LA15_0<=GreaterThanSign)||(LA15_0>=RULE_INT && LA15_0<=RULE_ID)) ) {
                alt15=1;
            }
            else if ( (LA15_0==End) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:987:5: this_EndID_0= ruleEndID
                    {
                     
                            newCompositeNode(grammarAccess.getMyIDAccess().getEndIDParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleEndID_in_ruleMyID2367);
                    this_EndID_0=ruleEndID();

                    state._fsp--;


                    		current.merge(this_EndID_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:999:2: kw= End
                    {
                    kw=(Token)match(input,End,FOLLOW_End_in_ruleMyID2391); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1012:1: entryRuleAutoNumber returns [String current=null] : iv_ruleAutoNumber= ruleAutoNumber EOF ;
    public final String entryRuleAutoNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAutoNumber = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1013:1: (iv_ruleAutoNumber= ruleAutoNumber EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1014:2: iv_ruleAutoNumber= ruleAutoNumber EOF
            {
             newCompositeNode(grammarAccess.getAutoNumberRule()); 
            pushFollow(FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber2431);
            iv_ruleAutoNumber=ruleAutoNumber();

            state._fsp--;

             current =iv_ruleAutoNumber.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAutoNumber2442); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1021:1: ruleAutoNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? ) ;
    public final AntlrDatatypeRuleToken ruleAutoNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1025:6: ( (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1026:1: (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1026:1: (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1027:2: kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )?
            {
            kw=(Token)match(input,Autonumber,FOLLOW_Autonumber_in_ruleAutoNumber2480); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getAutoNumberAccess().getAutonumberKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1032:1: (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_INT) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1032:6: this_INT_1= RULE_INT (this_INT_2= RULE_INT )?
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAutoNumber2496); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_0()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1039:1: (this_INT_2= RULE_INT )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==RULE_INT) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1039:6: this_INT_2= RULE_INT
                            {
                            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAutoNumber2517); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1054:1: entryRuleTitle returns [String current=null] : iv_ruleTitle= ruleTitle EOF ;
    public final String entryRuleTitle() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTitle = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1055:1: (iv_ruleTitle= ruleTitle EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1056:2: iv_ruleTitle= ruleTitle EOF
            {
             newCompositeNode(grammarAccess.getTitleRule()); 
            pushFollow(FOLLOW_ruleTitle_in_entryRuleTitle2566);
            iv_ruleTitle=ruleTitle();

            state._fsp--;

             current =iv_ruleTitle.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTitle2577); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1063:1: ruleTitle returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Title (this_ID_1= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleTitle() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1067:6: ( (kw= Title (this_ID_1= RULE_ID )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1068:1: (kw= Title (this_ID_1= RULE_ID )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1068:1: (kw= Title (this_ID_1= RULE_ID )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1069:2: kw= Title (this_ID_1= RULE_ID )*
            {
            kw=(Token)match(input,Title,FOLLOW_Title_in_ruleTitle2615); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTitleAccess().getTitleKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1074:1: (this_ID_1= RULE_ID )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1074:6: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTitle2631); 

            	    		current.merge(this_ID_1);
            	        
            	     
            	        newLeafNode(this_ID_1, grammarAccess.getTitleAccess().getIDTerminalRuleCall_1()); 
            	        

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
    // $ANTLR end "ruleTitle"


    // $ANTLR start "entryRuleLegend"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1089:1: entryRuleLegend returns [String current=null] : iv_ruleLegend= ruleLegend EOF ;
    public final String entryRuleLegend() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLegend = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1090:1: (iv_ruleLegend= ruleLegend EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1091:2: iv_ruleLegend= ruleLegend EOF
            {
             newCompositeNode(grammarAccess.getLegendRule()); 
            pushFollow(FOLLOW_ruleLegend_in_entryRuleLegend2678);
            iv_ruleLegend=ruleLegend();

            state._fsp--;

             current =iv_ruleLegend.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLegend2689); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1098:1: ruleLegend returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend ) ;
    public final AntlrDatatypeRuleToken ruleLegend() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_NEWLINE_4=null;
        Token this_ID_5=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1102:6: ( (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1103:1: (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1103:1: (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1104:2: kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend
            {
            kw=(Token)match(input,Legend,FOLLOW_Legend_in_ruleLegend2727); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getLegendAccess().getLegendKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1109:1: (kw= Right | kw= Left | kw= Center )?
            int alt19=4;
            switch ( input.LA(1) ) {
                case Right:
                    {
                    alt19=1;
                    }
                    break;
                case Left:
                    {
                    alt19=2;
                    }
                    break;
                case Center:
                    {
                    alt19=3;
                    }
                    break;
            }

            switch (alt19) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1110:2: kw= Right
                    {
                    kw=(Token)match(input,Right,FOLLOW_Right_in_ruleLegend2741); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getRightKeyword_1_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1117:2: kw= Left
                    {
                    kw=(Token)match(input,Left,FOLLOW_Left_in_ruleLegend2760); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1124:2: kw= Center
                    {
                    kw=(Token)match(input,Center,FOLLOW_Center_in_ruleLegend2779); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getCenterKeyword_1_2()); 
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1129:3: (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_NEWLINE) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1129:8: this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )*
            	    {
            	    this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleLegend2797); 

            	    		current.merge(this_NEWLINE_4);
            	        
            	     
            	        newLeafNode(this_NEWLINE_4, grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_0()); 
            	        
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1136:1: (this_ID_5= RULE_ID )*
            	    loop20:
            	    do {
            	        int alt20=2;
            	        int LA20_0 = input.LA(1);

            	        if ( (LA20_0==RULE_ID) ) {
            	            alt20=1;
            	        }


            	        switch (alt20) {
            	    	case 1 :
            	    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1136:6: this_ID_5= RULE_ID
            	    	    {
            	    	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLegend2818); 

            	    	    		current.merge(this_ID_5);
            	    	        
            	    	     
            	    	        newLeafNode(this_ID_5, grammarAccess.getLegendAccess().getIDTerminalRuleCall_2_1()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop20;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            kw=(Token)match(input,Endlegend,FOLLOW_Endlegend_in_ruleLegend2840); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1157:1: entryRuleNewpage returns [String current=null] : iv_ruleNewpage= ruleNewpage EOF ;
    public final String entryRuleNewpage() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNewpage = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1158:1: (iv_ruleNewpage= ruleNewpage EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1159:2: iv_ruleNewpage= ruleNewpage EOF
            {
             newCompositeNode(grammarAccess.getNewpageRule()); 
            pushFollow(FOLLOW_ruleNewpage_in_entryRuleNewpage2880);
            iv_ruleNewpage=ruleNewpage();

            state._fsp--;

             current =iv_ruleNewpage.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNewpage2891); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1166:1: ruleNewpage returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Newpage (this_ID_1= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleNewpage() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1170:6: ( (kw= Newpage (this_ID_1= RULE_ID )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1171:1: (kw= Newpage (this_ID_1= RULE_ID )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1171:1: (kw= Newpage (this_ID_1= RULE_ID )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1172:2: kw= Newpage (this_ID_1= RULE_ID )*
            {
            kw=(Token)match(input,Newpage,FOLLOW_Newpage_in_ruleNewpage2929); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getNewpageAccess().getNewpageKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1177:1: (this_ID_1= RULE_ID )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1177:6: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNewpage2945); 

            	    		current.merge(this_ID_1);
            	        
            	     
            	        newLeafNode(this_ID_1, grammarAccess.getNewpageAccess().getIDTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1192:1: entryRuleAltElse returns [EObject current=null] : iv_ruleAltElse= ruleAltElse EOF ;
    public final EObject entryRuleAltElse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltElse = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1193:2: (iv_ruleAltElse= ruleAltElse EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1194:2: iv_ruleAltElse= ruleAltElse EOF
            {
             newCompositeNode(grammarAccess.getAltElseRule()); 
            pushFollow(FOLLOW_ruleAltElse_in_entryRuleAltElse2991);
            iv_ruleAltElse=ruleAltElse();

            state._fsp--;

             current =iv_ruleAltElse; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAltElse3001); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1201:1: ruleAltElse returns [EObject current=null] : (otherlv_0= Alt ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End ) ;
    public final EObject ruleAltElse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_NEWLINE_2=null;
        Token otherlv_5=null;
        EObject lv_instructions_3_0 = null;

        EObject lv_elses_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1204:28: ( (otherlv_0= Alt ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1205:1: (otherlv_0= Alt ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1205:1: (otherlv_0= Alt ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1206:2: otherlv_0= Alt ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End
            {
            otherlv_0=(Token)match(input,Alt,FOLLOW_Alt_in_ruleAltElse3039); 

                	newLeafNode(otherlv_0, grammarAccess.getAltElseAccess().getAltKeyword_0());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1210:1: ( ruleMyID )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=Autonumber && LA23_0<=Deactivate)||LA23_0==Endlegend||LA23_0==Activate||LA23_0==Critical||(LA23_0>=Destroy && LA23_0<=Newpage)||(LA23_0>=Center && LA23_0<=Create)||LA23_0==Legend||(LA23_0>=Break && LA23_0<=Title)||(LA23_0>=Else && LA23_0<=Over)||(LA23_0>=Alt && LA23_0<=Ref)||LA23_0==Of||(LA23_0>=NumberSign && LA23_0<=GreaterThanSign)||(LA23_0>=RULE_INT && LA23_0<=RULE_ID)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1211:5: ruleMyID
            	    {
            	     
            	            newCompositeNode(grammarAccess.getAltElseAccess().getMyIDParserRuleCall_1()); 
            	        
            	    pushFollow(FOLLOW_ruleMyID_in_ruleAltElse3055);
            	    ruleMyID();

            	    state._fsp--;


            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleAltElse3067); 
             
                newLeafNode(this_NEWLINE_2, grammarAccess.getAltElseAccess().getNEWLINETerminalRuleCall_2()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1222:1: ( (lv_instructions_3_0= ruleInstruction ) )*
            loop24:
            do {
                int alt24=2;
                switch ( input.LA(1) ) {
                case Else:
                    {
                    int LA24_1 = input.LA(2);

                    if ( (LA24_1==RULE_SEQUENCE) ) {
                        alt24=1;
                    }


                    }
                    break;
                case End:
                    {
                    int LA24_2 = input.LA(2);

                    if ( (LA24_2==RULE_SEQUENCE) ) {
                        alt24=1;
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
                    alt24=1;
                    }
                    break;

                }

                switch (alt24) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1223:1: (lv_instructions_3_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1223:1: (lv_instructions_3_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1224:3: lv_instructions_3_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAltElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleAltElse3087);
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
            	    break loop24;
                }
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1240:3: ( (lv_elses_4_0= ruleElse ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==Else) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1241:1: (lv_elses_4_0= ruleElse )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1241:1: (lv_elses_4_0= ruleElse )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1242:3: lv_elses_4_0= ruleElse
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAltElseAccess().getElsesElseParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleElse_in_ruleAltElse3109);
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
            	    break loop25;
                }
            } while (true);

            otherlv_5=(Token)match(input,End,FOLLOW_End_in_ruleAltElse3123); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1271:1: entryRuleElse returns [EObject current=null] : iv_ruleElse= ruleElse EOF ;
    public final EObject entryRuleElse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElse = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1272:2: (iv_ruleElse= ruleElse EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1273:2: iv_ruleElse= ruleElse EOF
            {
             newCompositeNode(grammarAccess.getElseRule()); 
            pushFollow(FOLLOW_ruleElse_in_entryRuleElse3157);
            iv_ruleElse=ruleElse();

            state._fsp--;

             current =iv_ruleElse; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElse3167); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1280:1: ruleElse returns [EObject current=null] : (otherlv_0= Else ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ) ;
    public final EObject ruleElse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_NEWLINE_2=null;
        EObject lv_instructions_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1283:28: ( (otherlv_0= Else ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1284:1: (otherlv_0= Else ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1284:1: (otherlv_0= Else ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1285:2: otherlv_0= Else ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )*
            {
            otherlv_0=(Token)match(input,Else,FOLLOW_Else_in_ruleElse3205); 

                	newLeafNode(otherlv_0, grammarAccess.getElseAccess().getElseKeyword_0());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1289:1: ( ruleMyID )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=Autonumber && LA26_0<=Deactivate)||LA26_0==Endlegend||LA26_0==Activate||LA26_0==Critical||(LA26_0>=Destroy && LA26_0<=Newpage)||(LA26_0>=Center && LA26_0<=Create)||LA26_0==Legend||(LA26_0>=Break && LA26_0<=Title)||(LA26_0>=Else && LA26_0<=Over)||(LA26_0>=Alt && LA26_0<=Ref)||LA26_0==Of||(LA26_0>=NumberSign && LA26_0<=GreaterThanSign)||(LA26_0>=RULE_INT && LA26_0<=RULE_ID)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1290:5: ruleMyID
            	    {
            	     
            	            newCompositeNode(grammarAccess.getElseAccess().getMyIDParserRuleCall_1()); 
            	        
            	    pushFollow(FOLLOW_ruleMyID_in_ruleElse3221);
            	    ruleMyID();

            	    state._fsp--;


            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleElse3233); 
             
                newLeafNode(this_NEWLINE_2, grammarAccess.getElseAccess().getNEWLINETerminalRuleCall_2()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1301:1: ( (lv_instructions_3_0= ruleInstruction ) )*
            loop27:
            do {
                int alt27=2;
                switch ( input.LA(1) ) {
                case End:
                    {
                    int LA27_1 = input.LA(2);

                    if ( (LA27_1==RULE_SEQUENCE) ) {
                        alt27=1;
                    }


                    }
                    break;
                case Else:
                    {
                    int LA27_2 = input.LA(2);

                    if ( (LA27_2==RULE_SEQUENCE) ) {
                        alt27=1;
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
                    alt27=1;
                    }
                    break;

                }

                switch (alt27) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1302:1: (lv_instructions_3_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1302:1: (lv_instructions_3_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1303:3: lv_instructions_3_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleElse3253);
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
            	    break loop27;
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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1327:1: entryRuleGroupingMessages returns [EObject current=null] : iv_ruleGroupingMessages= ruleGroupingMessages EOF ;
    public final EObject entryRuleGroupingMessages() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupingMessages = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1328:2: (iv_ruleGroupingMessages= ruleGroupingMessages EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1329:2: iv_ruleGroupingMessages= ruleGroupingMessages EOF
            {
             newCompositeNode(grammarAccess.getGroupingMessagesRule()); 
            pushFollow(FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages3289);
            iv_ruleGroupingMessages=ruleGroupingMessages();

            state._fsp--;

             current =iv_ruleGroupingMessages; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroupingMessages3299); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1336:1: ruleGroupingMessages returns [EObject current=null] : ( (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End ) ;
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1339:28: ( ( (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1340:1: ( (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1340:1: ( (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1340:2: (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1340:2: (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group )
            int alt28=6;
            switch ( input.LA(1) ) {
            case Opt:
                {
                alt28=1;
                }
                break;
            case Loop:
                {
                alt28=2;
                }
                break;
            case Par:
                {
                alt28=3;
                }
                break;
            case Break:
                {
                alt28=4;
                }
                break;
            case Critical:
                {
                alt28=5;
                }
                break;
            case Group:
                {
                alt28=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1341:2: otherlv_0= Opt
                    {
                    otherlv_0=(Token)match(input,Opt,FOLLOW_Opt_in_ruleGroupingMessages3338); 

                        	newLeafNode(otherlv_0, grammarAccess.getGroupingMessagesAccess().getOptKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1347:2: otherlv_1= Loop
                    {
                    otherlv_1=(Token)match(input,Loop,FOLLOW_Loop_in_ruleGroupingMessages3356); 

                        	newLeafNode(otherlv_1, grammarAccess.getGroupingMessagesAccess().getLoopKeyword_0_1());
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1353:2: otherlv_2= Par
                    {
                    otherlv_2=(Token)match(input,Par,FOLLOW_Par_in_ruleGroupingMessages3374); 

                        	newLeafNode(otherlv_2, grammarAccess.getGroupingMessagesAccess().getParKeyword_0_2());
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1359:2: otherlv_3= Break
                    {
                    otherlv_3=(Token)match(input,Break,FOLLOW_Break_in_ruleGroupingMessages3392); 

                        	newLeafNode(otherlv_3, grammarAccess.getGroupingMessagesAccess().getBreakKeyword_0_3());
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1365:2: otherlv_4= Critical
                    {
                    otherlv_4=(Token)match(input,Critical,FOLLOW_Critical_in_ruleGroupingMessages3410); 

                        	newLeafNode(otherlv_4, grammarAccess.getGroupingMessagesAccess().getCriticalKeyword_0_4());
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1371:2: otherlv_5= Group
                    {
                    otherlv_5=(Token)match(input,Group,FOLLOW_Group_in_ruleGroupingMessages3428); 

                        	newLeafNode(otherlv_5, grammarAccess.getGroupingMessagesAccess().getGroupKeyword_0_5());
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1375:2: (this_ID_6= RULE_ID )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_ID) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1375:3: this_ID_6= RULE_ID
            	    {
            	    this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGroupingMessages3440); 
            	     
            	        newLeafNode(this_ID_6, grammarAccess.getGroupingMessagesAccess().getIDTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleGroupingMessages3452); 
             
                newLeafNode(this_NEWLINE_7, grammarAccess.getGroupingMessagesAccess().getNEWLINETerminalRuleCall_2()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1383:1: ( (lv_instructions_8_0= ruleInstruction ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==End) ) {
                    int LA30_1 = input.LA(2);

                    if ( (LA30_1==RULE_SEQUENCE) ) {
                        alt30=1;
                    }


                }
                else if ( (LA30_0==Participant||(LA30_0>=Autonumber && LA30_0<=Deactivate)||LA30_0==Endlegend||(LA30_0>=Activate && LA30_0<=Database)||(LA30_0>=Control && LA30_0<=Newpage)||(LA30_0>=Center && LA30_0<=Legend)||(LA30_0>=Actor && LA30_0<=Title)||(LA30_0>=Else && LA30_0<=FullStopFullStopFullStop)||(LA30_0>=Alt && LA30_0<=Box)||(LA30_0>=Opt && LA30_0<=VerticalLineVerticalLineVerticalLine)||LA30_0==EqualsSignEqualsSign||(LA30_0>=Of && LA30_0<=VerticalLineVerticalLine)||(LA30_0>=NumberSign && LA30_0<=RULE_NEWLINE)||(LA30_0>=RULE_INT && LA30_0<=RULE_ID)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1384:1: (lv_instructions_8_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1384:1: (lv_instructions_8_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1385:3: lv_instructions_8_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGroupingMessagesAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleGroupingMessages3472);
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
            	    break loop30;
                }
            } while (true);

            otherlv_9=(Token)match(input,End,FOLLOW_End_in_ruleGroupingMessages3486); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1414:1: entryRuleNote returns [EObject current=null] : iv_ruleNote= ruleNote EOF ;
    public final EObject entryRuleNote() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNote = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1415:2: (iv_ruleNote= ruleNote EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1416:2: iv_ruleNote= ruleNote EOF
            {
             newCompositeNode(grammarAccess.getNoteRule()); 
            pushFollow(FOLLOW_ruleNote_in_entryRuleNote3520);
            iv_ruleNote=ruleNote();

            state._fsp--;

             current =iv_ruleNote; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNote3530); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1423:1: ruleNote returns [EObject current=null] : (otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) ( ruleColor )* ( (otherlv_16= Colon ( ruleMyID )* ) | ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note ) ) ) ;
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1426:28: ( (otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) ( ruleColor )* ( (otherlv_16= Colon ( ruleMyID )* ) | ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1427:1: (otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) ( ruleColor )* ( (otherlv_16= Colon ( ruleMyID )* ) | ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1427:1: (otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) ( ruleColor )* ( (otherlv_16= Colon ( ruleMyID )* ) | ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1428:2: otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) ( ruleColor )* ( (otherlv_16= Colon ( ruleMyID )* ) | ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note ) )
            {
            otherlv_0=(Token)match(input,Note,FOLLOW_Note_in_ruleNote3568); 

                	newLeafNode(otherlv_0, grammarAccess.getNoteAccess().getNoteKeyword_0());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1432:1: ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) )
            int alt36=3;
            switch ( input.LA(1) ) {
            case Right:
                {
                alt36=1;
                }
                break;
            case Left:
                {
                alt36=2;
                }
                break;
            case Over:
                {
                alt36=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1432:2: (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1432:2: (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1433:2: otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )?
                    {
                    otherlv_1=(Token)match(input,Right,FOLLOW_Right_in_ruleNote3582); 

                        	newLeafNode(otherlv_1, grammarAccess.getNoteAccess().getRightKeyword_1_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1437:1: (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==Of) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1438:2: otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )*
                            {
                            otherlv_2=(Token)match(input,Of,FOLLOW_Of_in_ruleNote3595); 

                                	newLeafNode(otherlv_2, grammarAccess.getNoteAccess().getOfKeyword_1_0_1_0());
                                
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1442:1: ( (otherlv_3= RULE_ID ) )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1443:1: (otherlv_3= RULE_ID )
                            {
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1443:1: (otherlv_3= RULE_ID )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1444:3: otherlv_3= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getNoteRule());
                            	        }
                                    
                            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote3614); 

                            		newLeafNode(otherlv_3, grammarAccess.getNoteAccess().getRidDefinitionCrossReference_1_0_1_1_0()); 
                            	

                            }


                            }

                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1455:2: (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )*
                            loop31:
                            do {
                                int alt31=2;
                                int LA31_0 = input.LA(1);

                                if ( (LA31_0==Comma) ) {
                                    alt31=1;
                                }


                                switch (alt31) {
                            	case 1 :
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1456:2: otherlv_4= Comma ( (otherlv_5= RULE_ID ) )
                            	    {
                            	    otherlv_4=(Token)match(input,Comma,FOLLOW_Comma_in_ruleNote3628); 

                            	        	newLeafNode(otherlv_4, grammarAccess.getNoteAccess().getCommaKeyword_1_0_1_2_0());
                            	        
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1460:1: ( (otherlv_5= RULE_ID ) )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1461:1: (otherlv_5= RULE_ID )
                            	    {
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1461:1: (otherlv_5= RULE_ID )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1462:3: otherlv_5= RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = createModelElement(grammarAccess.getNoteRule());
                            	    	        }
                            	            
                            	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote3647); 

                            	    		newLeafNode(otherlv_5, grammarAccess.getNoteAccess().getRidsDefinitionCrossReference_1_0_1_2_1_0()); 
                            	    	

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
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1474:6: (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1474:6: (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1475:2: otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )?
                    {
                    otherlv_6=(Token)match(input,Left,FOLLOW_Left_in_ruleNote3672); 

                        	newLeafNode(otherlv_6, grammarAccess.getNoteAccess().getLeftKeyword_1_1_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1479:1: (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==Of) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1480:2: otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )*
                            {
                            otherlv_7=(Token)match(input,Of,FOLLOW_Of_in_ruleNote3685); 

                                	newLeafNode(otherlv_7, grammarAccess.getNoteAccess().getOfKeyword_1_1_1_0());
                                
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1484:1: ( (otherlv_8= RULE_ID ) )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1485:1: (otherlv_8= RULE_ID )
                            {
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1485:1: (otherlv_8= RULE_ID )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1486:3: otherlv_8= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getNoteRule());
                            	        }
                                    
                            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote3704); 

                            		newLeafNode(otherlv_8, grammarAccess.getNoteAccess().getLidDefinitionCrossReference_1_1_1_1_0()); 
                            	

                            }


                            }

                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1497:2: (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )*
                            loop33:
                            do {
                                int alt33=2;
                                int LA33_0 = input.LA(1);

                                if ( (LA33_0==Comma) ) {
                                    alt33=1;
                                }


                                switch (alt33) {
                            	case 1 :
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1498:2: otherlv_9= Comma ( (otherlv_10= RULE_ID ) )
                            	    {
                            	    otherlv_9=(Token)match(input,Comma,FOLLOW_Comma_in_ruleNote3718); 

                            	        	newLeafNode(otherlv_9, grammarAccess.getNoteAccess().getCommaKeyword_1_1_1_2_0());
                            	        
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1502:1: ( (otherlv_10= RULE_ID ) )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1503:1: (otherlv_10= RULE_ID )
                            	    {
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1503:1: (otherlv_10= RULE_ID )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1504:3: otherlv_10= RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = createModelElement(grammarAccess.getNoteRule());
                            	    	        }
                            	            
                            	    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote3737); 

                            	    		newLeafNode(otherlv_10, grammarAccess.getNoteAccess().getLidsDefinitionCrossReference_1_1_1_2_1_0()); 
                            	    	

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop33;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1516:6: (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1516:6: (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1517:2: otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )*
                    {
                    otherlv_11=(Token)match(input,Over,FOLLOW_Over_in_ruleNote3762); 

                        	newLeafNode(otherlv_11, grammarAccess.getNoteAccess().getOverKeyword_1_2_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1521:1: ( (otherlv_12= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1522:1: (otherlv_12= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1522:1: (otherlv_12= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1523:3: otherlv_12= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getNoteRule());
                    	        }
                            
                    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote3781); 

                    		newLeafNode(otherlv_12, grammarAccess.getNoteAccess().getOidDefinitionCrossReference_1_2_1_0()); 
                    	

                    }


                    }

                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1534:2: (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==Comma) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1535:2: otherlv_13= Comma ( (otherlv_14= RULE_ID ) )
                    	    {
                    	    otherlv_13=(Token)match(input,Comma,FOLLOW_Comma_in_ruleNote3795); 

                    	        	newLeafNode(otherlv_13, grammarAccess.getNoteAccess().getCommaKeyword_1_2_2_0());
                    	        
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1539:1: ( (otherlv_14= RULE_ID ) )
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1540:1: (otherlv_14= RULE_ID )
                    	    {
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1540:1: (otherlv_14= RULE_ID )
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1541:3: otherlv_14= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getNoteRule());
                    	    	        }
                    	            
                    	    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote3814); 

                    	    		newLeafNode(otherlv_14, grammarAccess.getNoteAccess().getOidsDefinitionCrossReference_1_2_2_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1552:6: ( ruleColor )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=LightGoldenRodYellow && LA37_0<=YellowGreen)||(LA37_0>=Aquamarine && LA37_0<=WhiteSmoke)||(LA37_0>=AliceBlue && LA37_0<=Turquoise)||(LA37_0>=Cornsilk && LA37_0<=SeaGreen)||(LA37_0>=Crimson && LA37_0<=Thistle)||(LA37_0>=Bisque && LA37_0<=Yellow)||(LA37_0>=Azure && LA37_0<=White)||(LA37_0>=Aqua && LA37_0<=Teal)||(LA37_0>=Red && LA37_0<=Tan)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1553:5: ruleColor
            	    {
            	     
            	            newCompositeNode(grammarAccess.getNoteAccess().getColorParserRuleCall_2()); 
            	        
            	    pushFollow(FOLLOW_ruleColor_in_ruleNote3835);
            	    ruleColor();

            	    state._fsp--;


            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1560:3: ( (otherlv_16= Colon ( ruleMyID )* ) | ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==Colon) ) {
                alt41=1;
            }
            else if ( (LA41_0==End||LA41_0==RULE_NEWLINE) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1560:4: (otherlv_16= Colon ( ruleMyID )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1560:4: (otherlv_16= Colon ( ruleMyID )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1561:2: otherlv_16= Colon ( ruleMyID )*
                    {
                    otherlv_16=(Token)match(input,Colon,FOLLOW_Colon_in_ruleNote3851); 

                        	newLeafNode(otherlv_16, grammarAccess.getNoteAccess().getColonKeyword_3_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1565:1: ( ruleMyID )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( ((LA38_0>=Autonumber && LA38_0<=Deactivate)||LA38_0==Endlegend||LA38_0==Activate||LA38_0==Critical||(LA38_0>=Destroy && LA38_0<=Newpage)||(LA38_0>=Center && LA38_0<=Create)||LA38_0==Legend||(LA38_0>=Break && LA38_0<=Title)||(LA38_0>=Else && LA38_0<=Over)||(LA38_0>=Alt && LA38_0<=Ref)||LA38_0==Of||(LA38_0>=NumberSign && LA38_0<=GreaterThanSign)||(LA38_0>=RULE_INT && LA38_0<=RULE_ID)) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1566:5: ruleMyID
                    	    {
                    	     
                    	            newCompositeNode(grammarAccess.getNoteAccess().getMyIDParserRuleCall_3_0_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleMyID_in_ruleNote3867);
                    	    ruleMyID();

                    	    state._fsp--;


                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1574:6: ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1574:6: ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1574:7: (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1574:7: (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==RULE_NEWLINE) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1574:8: this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )*
                    	    {
                    	    this_NEWLINE_18=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleNote3888); 
                    	     
                    	        newLeafNode(this_NEWLINE_18, grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_3_1_0_0()); 
                    	        
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1578:1: ( ruleEndID )*
                    	    loop39:
                    	    do {
                    	        int alt39=2;
                    	        int LA39_0 = input.LA(1);

                    	        if ( ((LA39_0>=Autonumber && LA39_0<=Deactivate)||LA39_0==Endlegend||LA39_0==Activate||LA39_0==Critical||(LA39_0>=Destroy && LA39_0<=Newpage)||(LA39_0>=Center && LA39_0<=Create)||LA39_0==Legend||(LA39_0>=Break && LA39_0<=Title)||(LA39_0>=Else && LA39_0<=Over)||(LA39_0>=Alt && LA39_0<=Box)||(LA39_0>=Opt && LA39_0<=Ref)||LA39_0==Of||(LA39_0>=NumberSign && LA39_0<=GreaterThanSign)||(LA39_0>=RULE_INT && LA39_0<=RULE_ID)) ) {
                    	            alt39=1;
                    	        }


                    	        switch (alt39) {
                    	    	case 1 :
                    	    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1579:5: ruleEndID
                    	    	    {
                    	    	     
                    	    	            newCompositeNode(grammarAccess.getNoteAccess().getEndIDParserRuleCall_3_1_0_1()); 
                    	    	        
                    	    	    pushFollow(FOLLOW_ruleEndID_in_ruleNote3904);
                    	    	    ruleEndID();

                    	    	    state._fsp--;


                    	    	            afterParserOrEnumRuleCall();
                    	    	        

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop39;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,End,FOLLOW_End_in_ruleNote3920); 

                        	newLeafNode(otherlv_20, grammarAccess.getNoteAccess().getEndKeyword_3_1_1());
                        
                    otherlv_21=(Token)match(input,Note,FOLLOW_Note_in_ruleNote3932); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1604:1: entryRuleDivider returns [String current=null] : iv_ruleDivider= ruleDivider EOF ;
    public final String entryRuleDivider() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDivider = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1605:1: (iv_ruleDivider= ruleDivider EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1606:2: iv_ruleDivider= ruleDivider EOF
            {
             newCompositeNode(grammarAccess.getDividerRule()); 
            pushFollow(FOLLOW_ruleDivider_in_entryRuleDivider3969);
            iv_ruleDivider=ruleDivider();

            state._fsp--;

             current =iv_ruleDivider.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDivider3980); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1613:1: ruleDivider returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign ) ;
    public final AntlrDatatypeRuleToken ruleDivider() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1617:6: ( (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1618:1: (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1618:1: (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1619:2: kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign
            {
            kw=(Token)match(input,EqualsSignEqualsSign,FOLLOW_EqualsSignEqualsSign_in_ruleDivider4018); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDividerAccess().getEqualsSignEqualsSignKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1624:1: (this_ID_1= RULE_ID )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_ID) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1624:6: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDivider4034); 

            	    		current.merge(this_ID_1);
            	        
            	     
            	        newLeafNode(this_ID_1, grammarAccess.getDividerAccess().getIDTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            kw=(Token)match(input,EqualsSignEqualsSign,FOLLOW_EqualsSignEqualsSign_in_ruleDivider4054); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1645:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1646:2: (iv_ruleReference= ruleReference EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1647:2: iv_ruleReference= ruleReference EOF
            {
             newCompositeNode(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference4093);
            iv_ruleReference=ruleReference();

            state._fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference4103); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1654:1: ruleReference returns [EObject current=null] : (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon ( ruleMyID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref ) ) ) ;
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1657:28: ( (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon ( ruleMyID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1658:1: (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon ( ruleMyID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1658:1: (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon ( ruleMyID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1659:2: otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon ( ruleMyID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref ) )
            {
            otherlv_0=(Token)match(input,Ref,FOLLOW_Ref_in_ruleReference4141); 

                	newLeafNode(otherlv_0, grammarAccess.getReferenceAccess().getRefKeyword_0());
                
            otherlv_1=(Token)match(input,Over,FOLLOW_Over_in_ruleReference4153); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceAccess().getOverKeyword_1());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1668:1: ( (otherlv_2= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1669:1: (otherlv_2= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1669:1: (otherlv_2= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1670:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference4172); 

            		newLeafNode(otherlv_2, grammarAccess.getReferenceAccess().getIdDefinitionCrossReference_2_0()); 
            	

            }


            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1681:2: (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==Comma) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1682:2: otherlv_3= Comma ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,Comma,FOLLOW_Comma_in_ruleReference4186); 

            	        	newLeafNode(otherlv_3, grammarAccess.getReferenceAccess().getCommaKeyword_3_0());
            	        
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1686:1: ( (otherlv_4= RULE_ID ) )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1687:1: (otherlv_4= RULE_ID )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1687:1: (otherlv_4= RULE_ID )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1688:3: otherlv_4= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getReferenceRule());
            	    	        }
            	            
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference4205); 

            	    		newLeafNode(otherlv_4, grammarAccess.getReferenceAccess().getIdsDefinitionCrossReference_3_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1699:4: ( (otherlv_5= Colon ( ruleMyID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==Colon) ) {
                alt47=1;
            }
            else if ( (LA47_0==End||LA47_0==RULE_NEWLINE) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1699:5: (otherlv_5= Colon ( ruleMyID )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1699:5: (otherlv_5= Colon ( ruleMyID )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1700:2: otherlv_5= Colon ( ruleMyID )*
                    {
                    otherlv_5=(Token)match(input,Colon,FOLLOW_Colon_in_ruleReference4222); 

                        	newLeafNode(otherlv_5, grammarAccess.getReferenceAccess().getColonKeyword_4_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1704:1: ( ruleMyID )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( ((LA44_0>=Autonumber && LA44_0<=Deactivate)||LA44_0==Endlegend||LA44_0==Activate||LA44_0==Critical||(LA44_0>=Destroy && LA44_0<=Newpage)||(LA44_0>=Center && LA44_0<=Create)||LA44_0==Legend||(LA44_0>=Break && LA44_0<=Title)||(LA44_0>=Else && LA44_0<=Over)||(LA44_0>=Alt && LA44_0<=Ref)||LA44_0==Of||(LA44_0>=NumberSign && LA44_0<=GreaterThanSign)||(LA44_0>=RULE_INT && LA44_0<=RULE_ID)) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1705:5: ruleMyID
                    	    {
                    	     
                    	            newCompositeNode(grammarAccess.getReferenceAccess().getMyIDParserRuleCall_4_0_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleMyID_in_ruleReference4238);
                    	    ruleMyID();

                    	    state._fsp--;


                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1713:6: ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1713:6: ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1713:7: (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1713:7: (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==RULE_NEWLINE) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1713:8: this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )*
                    	    {
                    	    this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleReference4259); 
                    	     
                    	        newLeafNode(this_NEWLINE_7, grammarAccess.getReferenceAccess().getNEWLINETerminalRuleCall_4_1_0_0()); 
                    	        
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1717:1: ( ruleEndID )*
                    	    loop45:
                    	    do {
                    	        int alt45=2;
                    	        int LA45_0 = input.LA(1);

                    	        if ( ((LA45_0>=Autonumber && LA45_0<=Deactivate)||LA45_0==Endlegend||LA45_0==Activate||LA45_0==Critical||(LA45_0>=Destroy && LA45_0<=Newpage)||(LA45_0>=Center && LA45_0<=Create)||LA45_0==Legend||(LA45_0>=Break && LA45_0<=Title)||(LA45_0>=Else && LA45_0<=Over)||(LA45_0>=Alt && LA45_0<=Box)||(LA45_0>=Opt && LA45_0<=Ref)||LA45_0==Of||(LA45_0>=NumberSign && LA45_0<=GreaterThanSign)||(LA45_0>=RULE_INT && LA45_0<=RULE_ID)) ) {
                    	            alt45=1;
                    	        }


                    	        switch (alt45) {
                    	    	case 1 :
                    	    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1718:5: ruleEndID
                    	    	    {
                    	    	     
                    	    	            newCompositeNode(grammarAccess.getReferenceAccess().getEndIDParserRuleCall_4_1_0_1()); 
                    	    	        
                    	    	    pushFollow(FOLLOW_ruleEndID_in_ruleReference4275);
                    	    	    ruleEndID();

                    	    	    state._fsp--;


                    	    	            afterParserOrEnumRuleCall();
                    	    	        

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop45;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,End,FOLLOW_End_in_ruleReference4291); 

                        	newLeafNode(otherlv_9, grammarAccess.getReferenceAccess().getEndKeyword_4_1_1());
                        
                    otherlv_10=(Token)match(input,Ref,FOLLOW_Ref_in_ruleReference4303); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1743:1: entryRuleDelay returns [String current=null] : iv_ruleDelay= ruleDelay EOF ;
    public final String entryRuleDelay() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDelay = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1744:1: (iv_ruleDelay= ruleDelay EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1745:2: iv_ruleDelay= ruleDelay EOF
            {
             newCompositeNode(grammarAccess.getDelayRule()); 
            pushFollow(FOLLOW_ruleDelay_in_entryRuleDelay4340);
            iv_ruleDelay=ruleDelay();

            state._fsp--;

             current =iv_ruleDelay.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDelay4351); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1752:1: ruleDelay returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? ) ;
    public final AntlrDatatypeRuleToken ruleDelay() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1756:6: ( (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1757:1: (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1757:1: (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1758:2: kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )?
            {
            kw=(Token)match(input,FullStopFullStopFullStop,FOLLOW_FullStopFullStopFullStop_in_ruleDelay4389); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1763:1: ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==FullStopFullStopFullStop||LA49_0==RULE_ID) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1763:2: (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1763:2: (this_ID_1= RULE_ID )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==RULE_ID) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1763:7: this_ID_1= RULE_ID
                    	    {
                    	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDelay4406); 

                    	    		current.merge(this_ID_1);
                    	        
                    	     
                    	        newLeafNode(this_ID_1, grammarAccess.getDelayAccess().getIDTerminalRuleCall_1_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);

                    kw=(Token)match(input,FullStopFullStopFullStop,FOLLOW_FullStopFullStopFullStop_in_ruleDelay4426); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1784:1: entryRuleSpace returns [String current=null] : iv_ruleSpace= ruleSpace EOF ;
    public final String entryRuleSpace() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSpace = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1785:1: (iv_ruleSpace= ruleSpace EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1786:2: iv_ruleSpace= ruleSpace EOF
            {
             newCompositeNode(grammarAccess.getSpaceRule()); 
            pushFollow(FOLLOW_ruleSpace_in_entryRuleSpace4468);
            iv_ruleSpace=ruleSpace();

            state._fsp--;

             current =iv_ruleSpace.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpace4479); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1793:1: ruleSpace returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine (this_INT_2= RULE_INT )+ kw= VerticalLineVerticalLine ) ) ;
    public final AntlrDatatypeRuleToken ruleSpace() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1797:6: ( (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine (this_INT_2= RULE_INT )+ kw= VerticalLineVerticalLine ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1798:1: (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine (this_INT_2= RULE_INT )+ kw= VerticalLineVerticalLine ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1798:1: (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine (this_INT_2= RULE_INT )+ kw= VerticalLineVerticalLine ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==VerticalLineVerticalLineVerticalLine) ) {
                alt51=1;
            }
            else if ( (LA51_0==VerticalLineVerticalLine) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1799:2: kw= VerticalLineVerticalLineVerticalLine
                    {
                    kw=(Token)match(input,VerticalLineVerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLineVerticalLine_in_ruleSpace4517); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSpaceAccess().getVerticalLineVerticalLineVerticalLineKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1805:6: (kw= VerticalLineVerticalLine (this_INT_2= RULE_INT )+ kw= VerticalLineVerticalLine )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1805:6: (kw= VerticalLineVerticalLine (this_INT_2= RULE_INT )+ kw= VerticalLineVerticalLine )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1806:2: kw= VerticalLineVerticalLine (this_INT_2= RULE_INT )+ kw= VerticalLineVerticalLine
                    {
                    kw=(Token)match(input,VerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLine_in_ruleSpace4537); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSpaceAccess().getVerticalLineVerticalLineKeyword_1_0()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1811:1: (this_INT_2= RULE_INT )+
                    int cnt50=0;
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==RULE_INT) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1811:6: this_INT_2= RULE_INT
                    	    {
                    	    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpace4553); 

                    	    		current.merge(this_INT_2);
                    	        
                    	     
                    	        newLeafNode(this_INT_2, grammarAccess.getSpaceAccess().getINTTerminalRuleCall_1_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt50 >= 1 ) break loop50;
                                EarlyExitException eee =
                                    new EarlyExitException(50, input);
                                throw eee;
                        }
                        cnt50++;
                    } while (true);

                    kw=(Token)match(input,VerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLine_in_ruleSpace4573); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1832:1: entryRuleHidefootbox returns [String current=null] : iv_ruleHidefootbox= ruleHidefootbox EOF ;
    public final String entryRuleHidefootbox() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHidefootbox = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1833:1: (iv_ruleHidefootbox= ruleHidefootbox EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1834:2: iv_ruleHidefootbox= ruleHidefootbox EOF
            {
             newCompositeNode(grammarAccess.getHidefootboxRule()); 
            pushFollow(FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox4614);
            iv_ruleHidefootbox=ruleHidefootbox();

            state._fsp--;

             current =iv_ruleHidefootbox.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHidefootbox4625); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1841:1: ruleHidefootbox returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Hide kw= Footbox ) ;
    public final AntlrDatatypeRuleToken ruleHidefootbox() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1845:6: ( (kw= Hide kw= Footbox ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1846:1: (kw= Hide kw= Footbox )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1846:1: (kw= Hide kw= Footbox )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1847:2: kw= Hide kw= Footbox
            {
            kw=(Token)match(input,Hide,FOLLOW_Hide_in_ruleHidefootbox4663); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getHidefootboxAccess().getHideKeyword_0()); 
                
            kw=(Token)match(input,Footbox,FOLLOW_Footbox_in_ruleHidefootbox4676); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1866:1: entryRuleActivate returns [EObject current=null] : iv_ruleActivate= ruleActivate EOF ;
    public final EObject entryRuleActivate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActivate = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1867:2: (iv_ruleActivate= ruleActivate EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1868:2: iv_ruleActivate= ruleActivate EOF
            {
             newCompositeNode(grammarAccess.getActivateRule()); 
            pushFollow(FOLLOW_ruleActivate_in_entryRuleActivate4715);
            iv_ruleActivate=ruleActivate();

            state._fsp--;

             current =iv_ruleActivate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActivate4725); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1875:1: ruleActivate returns [EObject current=null] : (otherlv_0= Activate ( ruleColor )? ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleActivate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1878:28: ( (otherlv_0= Activate ( ruleColor )? ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1879:1: (otherlv_0= Activate ( ruleColor )? ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1879:1: (otherlv_0= Activate ( ruleColor )? ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1880:2: otherlv_0= Activate ( ruleColor )? ( (lv_name_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,Activate,FOLLOW_Activate_in_ruleActivate4763); 

                	newLeafNode(otherlv_0, grammarAccess.getActivateAccess().getActivateKeyword_0());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1884:1: ( ruleColor )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=LightGoldenRodYellow && LA52_0<=YellowGreen)||(LA52_0>=Aquamarine && LA52_0<=WhiteSmoke)||(LA52_0>=AliceBlue && LA52_0<=Turquoise)||(LA52_0>=Cornsilk && LA52_0<=SeaGreen)||(LA52_0>=Crimson && LA52_0<=Thistle)||(LA52_0>=Bisque && LA52_0<=Yellow)||(LA52_0>=Azure && LA52_0<=White)||(LA52_0>=Aqua && LA52_0<=Teal)||(LA52_0>=Red && LA52_0<=Tan)) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1885:5: ruleColor
                    {
                     
                            newCompositeNode(grammarAccess.getActivateAccess().getColorParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleColor_in_ruleActivate4779);
                    ruleColor();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1892:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1893:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1893:1: (lv_name_2_0= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1894:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActivate4797); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1918:1: entryRuleDeactivate returns [EObject current=null] : iv_ruleDeactivate= ruleDeactivate EOF ;
    public final EObject entryRuleDeactivate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeactivate = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1919:2: (iv_ruleDeactivate= ruleDeactivate EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1920:2: iv_ruleDeactivate= ruleDeactivate EOF
            {
             newCompositeNode(grammarAccess.getDeactivateRule()); 
            pushFollow(FOLLOW_ruleDeactivate_in_entryRuleDeactivate4837);
            iv_ruleDeactivate=ruleDeactivate();

            state._fsp--;

             current =iv_ruleDeactivate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeactivate4847); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1927:1: ruleDeactivate returns [EObject current=null] : ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleDeactivate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1930:28: ( ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1931:1: ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1931:1: ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1931:2: (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1931:2: (otherlv_0= Deactivate | otherlv_1= Destroy )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==Deactivate) ) {
                alt53=1;
            }
            else if ( (LA53_0==Destroy) ) {
                alt53=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1932:2: otherlv_0= Deactivate
                    {
                    otherlv_0=(Token)match(input,Deactivate,FOLLOW_Deactivate_in_ruleDeactivate4886); 

                        	newLeafNode(otherlv_0, grammarAccess.getDeactivateAccess().getDeactivateKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1938:2: otherlv_1= Destroy
                    {
                    otherlv_1=(Token)match(input,Destroy,FOLLOW_Destroy_in_ruleDeactivate4904); 

                        	newLeafNode(otherlv_1, grammarAccess.getDeactivateAccess().getDestroyKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1942:2: ( (otherlv_2= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1943:1: (otherlv_2= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1943:1: (otherlv_2= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1944:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDeactivateRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeactivate4924); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1963:1: entryRuleParticipantCreation returns [String current=null] : iv_ruleParticipantCreation= ruleParticipantCreation EOF ;
    public final String entryRuleParticipantCreation() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleParticipantCreation = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1964:1: (iv_ruleParticipantCreation= ruleParticipantCreation EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1965:2: iv_ruleParticipantCreation= ruleParticipantCreation EOF
            {
             newCompositeNode(grammarAccess.getParticipantCreationRule()); 
            pushFollow(FOLLOW_ruleParticipantCreation_in_entryRuleParticipantCreation4960);
            iv_ruleParticipantCreation=ruleParticipantCreation();

            state._fsp--;

             current =iv_ruleParticipantCreation.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParticipantCreation4971); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1972:1: ruleParticipantCreation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Create this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleParticipantCreation() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1976:6: ( (kw= Create this_ID_1= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1977:1: (kw= Create this_ID_1= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1977:1: (kw= Create this_ID_1= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1978:2: kw= Create this_ID_1= RULE_ID
            {
            kw=(Token)match(input,Create,FOLLOW_Create_in_ruleParticipantCreation5009); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getParticipantCreationAccess().getCreateKeyword_0()); 
                
            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParticipantCreation5024); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1998:1: entryRuleBox returns [EObject current=null] : iv_ruleBox= ruleBox EOF ;
    public final EObject entryRuleBox() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBox = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1999:2: (iv_ruleBox= ruleBox EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2000:2: iv_ruleBox= ruleBox EOF
            {
             newCompositeNode(grammarAccess.getBoxRule()); 
            pushFollow(FOLLOW_ruleBox_in_entryRuleBox5068);
            iv_ruleBox=ruleBox();

            state._fsp--;

             current =iv_ruleBox; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBox5078); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2007:1: ruleBox returns [EObject current=null] : (otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark ( ruleColor )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box ) ;
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2010:28: ( (otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark ( ruleColor )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2011:1: (otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark ( ruleColor )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2011:1: (otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark ( ruleColor )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2012:2: otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark ( ruleColor )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box
            {
            otherlv_0=(Token)match(input,Box,FOLLOW_Box_in_ruleBox5116); 

                	newLeafNode(otherlv_0, grammarAccess.getBoxAccess().getBoxKeyword_0());
                
            otherlv_1=(Token)match(input,QuotationMark,FOLLOW_QuotationMark_in_ruleBox5128); 

                	newLeafNode(otherlv_1, grammarAccess.getBoxAccess().getQuotationMarkKeyword_1());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2021:1: (this_ID_2= RULE_ID )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_ID) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2021:2: this_ID_2= RULE_ID
            	    {
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBox5139); 
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getBoxAccess().getIDTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            otherlv_3=(Token)match(input,QuotationMark,FOLLOW_QuotationMark_in_ruleBox5153); 

                	newLeafNode(otherlv_3, grammarAccess.getBoxAccess().getQuotationMarkKeyword_3());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2030:1: ( ruleColor )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=LightGoldenRodYellow && LA55_0<=YellowGreen)||(LA55_0>=Aquamarine && LA55_0<=WhiteSmoke)||(LA55_0>=AliceBlue && LA55_0<=Turquoise)||(LA55_0>=Cornsilk && LA55_0<=SeaGreen)||(LA55_0>=Crimson && LA55_0<=Thistle)||(LA55_0>=Bisque && LA55_0<=Yellow)||(LA55_0>=Azure && LA55_0<=White)||(LA55_0>=Aqua && LA55_0<=Teal)||(LA55_0>=Red && LA55_0<=Tan)) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2031:5: ruleColor
                    {
                     
                            newCompositeNode(grammarAccess.getBoxAccess().getColorParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleColor_in_ruleBox5169);
                    ruleColor();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleBox5181); 
             
                newLeafNode(this_NEWLINE_5, grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_5()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2042:1: ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==Participant||LA57_0==Boundary||LA57_0==Database||LA57_0==Control||LA57_0==Entity||LA57_0==Actor||LA57_0==RULE_NEWLINE) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2042:2: ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2042:2: ( (lv_definitions_6_0= ruleDefinition ) )?
            	    int alt56=2;
            	    int LA56_0 = input.LA(1);

            	    if ( (LA56_0==Participant||LA56_0==Boundary||LA56_0==Database||LA56_0==Control||LA56_0==Entity||LA56_0==Actor) ) {
            	        alt56=1;
            	    }
            	    switch (alt56) {
            	        case 1 :
            	            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2043:1: (lv_definitions_6_0= ruleDefinition )
            	            {
            	            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2043:1: (lv_definitions_6_0= ruleDefinition )
            	            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2044:3: lv_definitions_6_0= ruleDefinition
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getBoxAccess().getDefinitionsDefinitionParserRuleCall_6_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleDefinition_in_ruleBox5202);
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

            	    this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleBox5214); 
            	     
            	        newLeafNode(this_NEWLINE_7, grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_6_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            otherlv_8=(Token)match(input,End,FOLLOW_End_in_ruleBox5228); 

                	newLeafNode(otherlv_8, grammarAccess.getBoxAccess().getEndKeyword_7());
                
            otherlv_9=(Token)match(input,Box,FOLLOW_Box_in_ruleBox5240); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2082:1: entryRuleColors returns [String current=null] : iv_ruleColors= ruleColors EOF ;
    public final String entryRuleColors() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleColors = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2083:1: (iv_ruleColors= ruleColors EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2084:2: iv_ruleColors= ruleColors EOF
            {
             newCompositeNode(grammarAccess.getColorsRule()); 
            pushFollow(FOLLOW_ruleColors_in_entryRuleColors5275);
            iv_ruleColors=ruleColors();

            state._fsp--;

             current =iv_ruleColors.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColors5286); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2091:1: ruleColors returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= NumberSign (this_Color_1= ruleColor | this_HEXCODE_2= RULE_HEXCODE ) ) ;
    public final AntlrDatatypeRuleToken ruleColors() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_HEXCODE_2=null;
        AntlrDatatypeRuleToken this_Color_1 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2095:6: ( (kw= NumberSign (this_Color_1= ruleColor | this_HEXCODE_2= RULE_HEXCODE ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2096:1: (kw= NumberSign (this_Color_1= ruleColor | this_HEXCODE_2= RULE_HEXCODE ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2096:1: (kw= NumberSign (this_Color_1= ruleColor | this_HEXCODE_2= RULE_HEXCODE ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2097:2: kw= NumberSign (this_Color_1= ruleColor | this_HEXCODE_2= RULE_HEXCODE )
            {
            kw=(Token)match(input,NumberSign,FOLLOW_NumberSign_in_ruleColors5324); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getColorsAccess().getNumberSignKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2102:1: (this_Color_1= ruleColor | this_HEXCODE_2= RULE_HEXCODE )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=LightGoldenRodYellow && LA58_0<=YellowGreen)||(LA58_0>=Aquamarine && LA58_0<=WhiteSmoke)||(LA58_0>=AliceBlue && LA58_0<=Turquoise)||(LA58_0>=Cornsilk && LA58_0<=SeaGreen)||(LA58_0>=Crimson && LA58_0<=Thistle)||(LA58_0>=Bisque && LA58_0<=Yellow)||(LA58_0>=Azure && LA58_0<=White)||(LA58_0>=Aqua && LA58_0<=Teal)||(LA58_0>=Red && LA58_0<=Tan)) ) {
                alt58=1;
            }
            else if ( (LA58_0==RULE_HEXCODE) ) {
                alt58=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2103:5: this_Color_1= ruleColor
                    {
                     
                            newCompositeNode(grammarAccess.getColorsAccess().getColorParserRuleCall_1_0()); 
                        
                    pushFollow(FOLLOW_ruleColor_in_ruleColors5347);
                    this_Color_1=ruleColor();

                    state._fsp--;


                    		current.merge(this_Color_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2114:10: this_HEXCODE_2= RULE_HEXCODE
                    {
                    this_HEXCODE_2=(Token)match(input,RULE_HEXCODE,FOLLOW_RULE_HEXCODE_in_ruleColors5373); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2129:1: entryRuleColor returns [String current=null] : iv_ruleColor= ruleColor EOF ;
    public final String entryRuleColor() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleColor = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2130:1: (iv_ruleColor= ruleColor EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2131:2: iv_ruleColor= ruleColor EOF
            {
             newCompositeNode(grammarAccess.getColorRule()); 
            pushFollow(FOLLOW_ruleColor_in_entryRuleColor5419);
            iv_ruleColor=ruleColor();

            state._fsp--;

             current =iv_ruleColor.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColor5430); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2138:1: ruleColor returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= AliceBlue | kw= AntiqueWhite | kw= Aqua | kw= Aquamarine | kw= Azure | kw= Beige | kw= Bisque | kw= Black | kw= BlanchedAlmond | kw= Blue | kw= BlueViolet | kw= Brown | kw= BurlyWood | kw= CadetBlue | kw= Chartreuse | kw= Chocolate | kw= Coral | kw= CornflowerBlue | kw= Cornsilk | kw= Crimson | kw= Cyan | kw= DarkBlue | kw= DarkCyan | kw= DarkGoldenRod | kw= DarkGray | kw= DarkGreen | kw= DarkGrey | kw= DarkKhaki | kw= DarkMagenta | kw= DarkOliveGreen | kw= DarkOrchid | kw= DarkRed | kw= DarkSalmo | kw= DarkSeaGreen | kw= DarkSlateBlue | kw= DarkSlateGray | kw= DarkSlateGrey | kw= DarkTurquoise | kw= DarkViolet | kw= Darkorange | kw= DeepPink | kw= DeepSkyBlue | kw= DimGray | kw= DimGrey | kw= DodgerBlue | kw= FireBrick | kw= FloralWhite | kw= ForestGreen | kw= Fuchsia | kw= Gainsboro | kw= GhostWhite | kw= Gold | kw= GoldenRod | kw= Gray | kw= Green | kw= GreenYellow | kw= Grey | kw= HoneyDew | kw= HotPink | kw= IndianRed | kw= Indigo | kw= Ivory | kw= Khaki | kw= Lavender | kw= LavenderBlush | kw= LawnGreen | kw= LemonChiffon | kw= LightBlue | kw= LightCoral | kw= LightCyan | kw= LightGoldenRodYellow | kw= LightGray | kw= LightGreen | kw= LightGrey | kw= LightPink | kw= LightSalmon | kw= LightSeaGreen | kw= LightSkyBlue | kw= LightSlateGray | kw= LightSlateGrey | kw= LightSteelBlue | kw= LightYellow | kw= Lime | kw= LimeGreen | kw= Linen | kw= Magenta | kw= Maroon | kw= MediumAquaMarine | kw= MediumBlue | kw= MediumOrchid | kw= MediumPurple | kw= MediumSeaGreen | kw= MediumSlateBlue | kw= MediumSpringGreen | kw= MediumTurquoise | kw= MediumVioletRed | kw= MidnightBlue | kw= MintCream | kw= MistyRose | kw= Moccasin | kw= NavajoWhite | kw= Navy | kw= OldLace | kw= Olive | kw= OliveDrab | kw= OrangeRed | kw= Orchid | kw= PaleGoldenRod | kw= PaleGreen | kw= PaleTurquoise | kw= PaleVioletRed | kw= PapayaWhip | kw= PeachPuff | kw= Peru | kw= Pink | kw= Plum | kw= PowderBlue | kw= Purple | kw= Red | kw= RosyBrown | kw= RoyalBlue | kw= SaddleBrown | kw= Salmon | kw= SandyBrown | kw= SeaGreen | kw= Sienna | kw= Silver | kw= SkyBlue | kw= SlateBlue | kw= SlateGray | kw= SlateGrey | kw= Snow | kw= SpringGreen | kw= SteelBlue | kw= Tan | kw= Teal | kw= Thistle | kw= Tomato | kw= Turquoise | kw= Violet | kw= Wheat | kw= White | kw= WhiteSmoke | kw= Yellow | kw= YellowGreen ) ;
    public final AntlrDatatypeRuleToken ruleColor() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2142:6: ( (kw= AliceBlue | kw= AntiqueWhite | kw= Aqua | kw= Aquamarine | kw= Azure | kw= Beige | kw= Bisque | kw= Black | kw= BlanchedAlmond | kw= Blue | kw= BlueViolet | kw= Brown | kw= BurlyWood | kw= CadetBlue | kw= Chartreuse | kw= Chocolate | kw= Coral | kw= CornflowerBlue | kw= Cornsilk | kw= Crimson | kw= Cyan | kw= DarkBlue | kw= DarkCyan | kw= DarkGoldenRod | kw= DarkGray | kw= DarkGreen | kw= DarkGrey | kw= DarkKhaki | kw= DarkMagenta | kw= DarkOliveGreen | kw= DarkOrchid | kw= DarkRed | kw= DarkSalmo | kw= DarkSeaGreen | kw= DarkSlateBlue | kw= DarkSlateGray | kw= DarkSlateGrey | kw= DarkTurquoise | kw= DarkViolet | kw= Darkorange | kw= DeepPink | kw= DeepSkyBlue | kw= DimGray | kw= DimGrey | kw= DodgerBlue | kw= FireBrick | kw= FloralWhite | kw= ForestGreen | kw= Fuchsia | kw= Gainsboro | kw= GhostWhite | kw= Gold | kw= GoldenRod | kw= Gray | kw= Green | kw= GreenYellow | kw= Grey | kw= HoneyDew | kw= HotPink | kw= IndianRed | kw= Indigo | kw= Ivory | kw= Khaki | kw= Lavender | kw= LavenderBlush | kw= LawnGreen | kw= LemonChiffon | kw= LightBlue | kw= LightCoral | kw= LightCyan | kw= LightGoldenRodYellow | kw= LightGray | kw= LightGreen | kw= LightGrey | kw= LightPink | kw= LightSalmon | kw= LightSeaGreen | kw= LightSkyBlue | kw= LightSlateGray | kw= LightSlateGrey | kw= LightSteelBlue | kw= LightYellow | kw= Lime | kw= LimeGreen | kw= Linen | kw= Magenta | kw= Maroon | kw= MediumAquaMarine | kw= MediumBlue | kw= MediumOrchid | kw= MediumPurple | kw= MediumSeaGreen | kw= MediumSlateBlue | kw= MediumSpringGreen | kw= MediumTurquoise | kw= MediumVioletRed | kw= MidnightBlue | kw= MintCream | kw= MistyRose | kw= Moccasin | kw= NavajoWhite | kw= Navy | kw= OldLace | kw= Olive | kw= OliveDrab | kw= OrangeRed | kw= Orchid | kw= PaleGoldenRod | kw= PaleGreen | kw= PaleTurquoise | kw= PaleVioletRed | kw= PapayaWhip | kw= PeachPuff | kw= Peru | kw= Pink | kw= Plum | kw= PowderBlue | kw= Purple | kw= Red | kw= RosyBrown | kw= RoyalBlue | kw= SaddleBrown | kw= Salmon | kw= SandyBrown | kw= SeaGreen | kw= Sienna | kw= Silver | kw= SkyBlue | kw= SlateBlue | kw= SlateGray | kw= SlateGrey | kw= Snow | kw= SpringGreen | kw= SteelBlue | kw= Tan | kw= Teal | kw= Thistle | kw= Tomato | kw= Turquoise | kw= Violet | kw= Wheat | kw= White | kw= WhiteSmoke | kw= Yellow | kw= YellowGreen ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2143:1: (kw= AliceBlue | kw= AntiqueWhite | kw= Aqua | kw= Aquamarine | kw= Azure | kw= Beige | kw= Bisque | kw= Black | kw= BlanchedAlmond | kw= Blue | kw= BlueViolet | kw= Brown | kw= BurlyWood | kw= CadetBlue | kw= Chartreuse | kw= Chocolate | kw= Coral | kw= CornflowerBlue | kw= Cornsilk | kw= Crimson | kw= Cyan | kw= DarkBlue | kw= DarkCyan | kw= DarkGoldenRod | kw= DarkGray | kw= DarkGreen | kw= DarkGrey | kw= DarkKhaki | kw= DarkMagenta | kw= DarkOliveGreen | kw= DarkOrchid | kw= DarkRed | kw= DarkSalmo | kw= DarkSeaGreen | kw= DarkSlateBlue | kw= DarkSlateGray | kw= DarkSlateGrey | kw= DarkTurquoise | kw= DarkViolet | kw= Darkorange | kw= DeepPink | kw= DeepSkyBlue | kw= DimGray | kw= DimGrey | kw= DodgerBlue | kw= FireBrick | kw= FloralWhite | kw= ForestGreen | kw= Fuchsia | kw= Gainsboro | kw= GhostWhite | kw= Gold | kw= GoldenRod | kw= Gray | kw= Green | kw= GreenYellow | kw= Grey | kw= HoneyDew | kw= HotPink | kw= IndianRed | kw= Indigo | kw= Ivory | kw= Khaki | kw= Lavender | kw= LavenderBlush | kw= LawnGreen | kw= LemonChiffon | kw= LightBlue | kw= LightCoral | kw= LightCyan | kw= LightGoldenRodYellow | kw= LightGray | kw= LightGreen | kw= LightGrey | kw= LightPink | kw= LightSalmon | kw= LightSeaGreen | kw= LightSkyBlue | kw= LightSlateGray | kw= LightSlateGrey | kw= LightSteelBlue | kw= LightYellow | kw= Lime | kw= LimeGreen | kw= Linen | kw= Magenta | kw= Maroon | kw= MediumAquaMarine | kw= MediumBlue | kw= MediumOrchid | kw= MediumPurple | kw= MediumSeaGreen | kw= MediumSlateBlue | kw= MediumSpringGreen | kw= MediumTurquoise | kw= MediumVioletRed | kw= MidnightBlue | kw= MintCream | kw= MistyRose | kw= Moccasin | kw= NavajoWhite | kw= Navy | kw= OldLace | kw= Olive | kw= OliveDrab | kw= OrangeRed | kw= Orchid | kw= PaleGoldenRod | kw= PaleGreen | kw= PaleTurquoise | kw= PaleVioletRed | kw= PapayaWhip | kw= PeachPuff | kw= Peru | kw= Pink | kw= Plum | kw= PowderBlue | kw= Purple | kw= Red | kw= RosyBrown | kw= RoyalBlue | kw= SaddleBrown | kw= Salmon | kw= SandyBrown | kw= SeaGreen | kw= Sienna | kw= Silver | kw= SkyBlue | kw= SlateBlue | kw= SlateGray | kw= SlateGrey | kw= Snow | kw= SpringGreen | kw= SteelBlue | kw= Tan | kw= Teal | kw= Thistle | kw= Tomato | kw= Turquoise | kw= Violet | kw= Wheat | kw= White | kw= WhiteSmoke | kw= Yellow | kw= YellowGreen )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2143:1: (kw= AliceBlue | kw= AntiqueWhite | kw= Aqua | kw= Aquamarine | kw= Azure | kw= Beige | kw= Bisque | kw= Black | kw= BlanchedAlmond | kw= Blue | kw= BlueViolet | kw= Brown | kw= BurlyWood | kw= CadetBlue | kw= Chartreuse | kw= Chocolate | kw= Coral | kw= CornflowerBlue | kw= Cornsilk | kw= Crimson | kw= Cyan | kw= DarkBlue | kw= DarkCyan | kw= DarkGoldenRod | kw= DarkGray | kw= DarkGreen | kw= DarkGrey | kw= DarkKhaki | kw= DarkMagenta | kw= DarkOliveGreen | kw= DarkOrchid | kw= DarkRed | kw= DarkSalmo | kw= DarkSeaGreen | kw= DarkSlateBlue | kw= DarkSlateGray | kw= DarkSlateGrey | kw= DarkTurquoise | kw= DarkViolet | kw= Darkorange | kw= DeepPink | kw= DeepSkyBlue | kw= DimGray | kw= DimGrey | kw= DodgerBlue | kw= FireBrick | kw= FloralWhite | kw= ForestGreen | kw= Fuchsia | kw= Gainsboro | kw= GhostWhite | kw= Gold | kw= GoldenRod | kw= Gray | kw= Green | kw= GreenYellow | kw= Grey | kw= HoneyDew | kw= HotPink | kw= IndianRed | kw= Indigo | kw= Ivory | kw= Khaki | kw= Lavender | kw= LavenderBlush | kw= LawnGreen | kw= LemonChiffon | kw= LightBlue | kw= LightCoral | kw= LightCyan | kw= LightGoldenRodYellow | kw= LightGray | kw= LightGreen | kw= LightGrey | kw= LightPink | kw= LightSalmon | kw= LightSeaGreen | kw= LightSkyBlue | kw= LightSlateGray | kw= LightSlateGrey | kw= LightSteelBlue | kw= LightYellow | kw= Lime | kw= LimeGreen | kw= Linen | kw= Magenta | kw= Maroon | kw= MediumAquaMarine | kw= MediumBlue | kw= MediumOrchid | kw= MediumPurple | kw= MediumSeaGreen | kw= MediumSlateBlue | kw= MediumSpringGreen | kw= MediumTurquoise | kw= MediumVioletRed | kw= MidnightBlue | kw= MintCream | kw= MistyRose | kw= Moccasin | kw= NavajoWhite | kw= Navy | kw= OldLace | kw= Olive | kw= OliveDrab | kw= OrangeRed | kw= Orchid | kw= PaleGoldenRod | kw= PaleGreen | kw= PaleTurquoise | kw= PaleVioletRed | kw= PapayaWhip | kw= PeachPuff | kw= Peru | kw= Pink | kw= Plum | kw= PowderBlue | kw= Purple | kw= Red | kw= RosyBrown | kw= RoyalBlue | kw= SaddleBrown | kw= Salmon | kw= SandyBrown | kw= SeaGreen | kw= Sienna | kw= Silver | kw= SkyBlue | kw= SlateBlue | kw= SlateGray | kw= SlateGrey | kw= Snow | kw= SpringGreen | kw= SteelBlue | kw= Tan | kw= Teal | kw= Thistle | kw= Tomato | kw= Turquoise | kw= Violet | kw= Wheat | kw= White | kw= WhiteSmoke | kw= Yellow | kw= YellowGreen )
            int alt59=145;
            switch ( input.LA(1) ) {
            case AliceBlue:
                {
                alt59=1;
                }
                break;
            case AntiqueWhite:
                {
                alt59=2;
                }
                break;
            case Aqua:
                {
                alt59=3;
                }
                break;
            case Aquamarine:
                {
                alt59=4;
                }
                break;
            case Azure:
                {
                alt59=5;
                }
                break;
            case Beige:
                {
                alt59=6;
                }
                break;
            case Bisque:
                {
                alt59=7;
                }
                break;
            case Black:
                {
                alt59=8;
                }
                break;
            case BlanchedAlmond:
                {
                alt59=9;
                }
                break;
            case Blue:
                {
                alt59=10;
                }
                break;
            case BlueViolet:
                {
                alt59=11;
                }
                break;
            case Brown:
                {
                alt59=12;
                }
                break;
            case BurlyWood:
                {
                alt59=13;
                }
                break;
            case CadetBlue:
                {
                alt59=14;
                }
                break;
            case Chartreuse:
                {
                alt59=15;
                }
                break;
            case Chocolate:
                {
                alt59=16;
                }
                break;
            case Coral:
                {
                alt59=17;
                }
                break;
            case CornflowerBlue:
                {
                alt59=18;
                }
                break;
            case Cornsilk:
                {
                alt59=19;
                }
                break;
            case Crimson:
                {
                alt59=20;
                }
                break;
            case Cyan:
                {
                alt59=21;
                }
                break;
            case DarkBlue:
                {
                alt59=22;
                }
                break;
            case DarkCyan:
                {
                alt59=23;
                }
                break;
            case DarkGoldenRod:
                {
                alt59=24;
                }
                break;
            case DarkGray:
                {
                alt59=25;
                }
                break;
            case DarkGreen:
                {
                alt59=26;
                }
                break;
            case DarkGrey:
                {
                alt59=27;
                }
                break;
            case DarkKhaki:
                {
                alt59=28;
                }
                break;
            case DarkMagenta:
                {
                alt59=29;
                }
                break;
            case DarkOliveGreen:
                {
                alt59=30;
                }
                break;
            case DarkOrchid:
                {
                alt59=31;
                }
                break;
            case DarkRed:
                {
                alt59=32;
                }
                break;
            case DarkSalmo:
                {
                alt59=33;
                }
                break;
            case DarkSeaGreen:
                {
                alt59=34;
                }
                break;
            case DarkSlateBlue:
                {
                alt59=35;
                }
                break;
            case DarkSlateGray:
                {
                alt59=36;
                }
                break;
            case DarkSlateGrey:
                {
                alt59=37;
                }
                break;
            case DarkTurquoise:
                {
                alt59=38;
                }
                break;
            case DarkViolet:
                {
                alt59=39;
                }
                break;
            case Darkorange:
                {
                alt59=40;
                }
                break;
            case DeepPink:
                {
                alt59=41;
                }
                break;
            case DeepSkyBlue:
                {
                alt59=42;
                }
                break;
            case DimGray:
                {
                alt59=43;
                }
                break;
            case DimGrey:
                {
                alt59=44;
                }
                break;
            case DodgerBlue:
                {
                alt59=45;
                }
                break;
            case FireBrick:
                {
                alt59=46;
                }
                break;
            case FloralWhite:
                {
                alt59=47;
                }
                break;
            case ForestGreen:
                {
                alt59=48;
                }
                break;
            case Fuchsia:
                {
                alt59=49;
                }
                break;
            case Gainsboro:
                {
                alt59=50;
                }
                break;
            case GhostWhite:
                {
                alt59=51;
                }
                break;
            case Gold:
                {
                alt59=52;
                }
                break;
            case GoldenRod:
                {
                alt59=53;
                }
                break;
            case Gray:
                {
                alt59=54;
                }
                break;
            case Green:
                {
                alt59=55;
                }
                break;
            case GreenYellow:
                {
                alt59=56;
                }
                break;
            case Grey:
                {
                alt59=57;
                }
                break;
            case HoneyDew:
                {
                alt59=58;
                }
                break;
            case HotPink:
                {
                alt59=59;
                }
                break;
            case IndianRed:
                {
                alt59=60;
                }
                break;
            case Indigo:
                {
                alt59=61;
                }
                break;
            case Ivory:
                {
                alt59=62;
                }
                break;
            case Khaki:
                {
                alt59=63;
                }
                break;
            case Lavender:
                {
                alt59=64;
                }
                break;
            case LavenderBlush:
                {
                alt59=65;
                }
                break;
            case LawnGreen:
                {
                alt59=66;
                }
                break;
            case LemonChiffon:
                {
                alt59=67;
                }
                break;
            case LightBlue:
                {
                alt59=68;
                }
                break;
            case LightCoral:
                {
                alt59=69;
                }
                break;
            case LightCyan:
                {
                alt59=70;
                }
                break;
            case LightGoldenRodYellow:
                {
                alt59=71;
                }
                break;
            case LightGray:
                {
                alt59=72;
                }
                break;
            case LightGreen:
                {
                alt59=73;
                }
                break;
            case LightGrey:
                {
                alt59=74;
                }
                break;
            case LightPink:
                {
                alt59=75;
                }
                break;
            case LightSalmon:
                {
                alt59=76;
                }
                break;
            case LightSeaGreen:
                {
                alt59=77;
                }
                break;
            case LightSkyBlue:
                {
                alt59=78;
                }
                break;
            case LightSlateGray:
                {
                alt59=79;
                }
                break;
            case LightSlateGrey:
                {
                alt59=80;
                }
                break;
            case LightSteelBlue:
                {
                alt59=81;
                }
                break;
            case LightYellow:
                {
                alt59=82;
                }
                break;
            case Lime:
                {
                alt59=83;
                }
                break;
            case LimeGreen:
                {
                alt59=84;
                }
                break;
            case Linen:
                {
                alt59=85;
                }
                break;
            case Magenta:
                {
                alt59=86;
                }
                break;
            case Maroon:
                {
                alt59=87;
                }
                break;
            case MediumAquaMarine:
                {
                alt59=88;
                }
                break;
            case MediumBlue:
                {
                alt59=89;
                }
                break;
            case MediumOrchid:
                {
                alt59=90;
                }
                break;
            case MediumPurple:
                {
                alt59=91;
                }
                break;
            case MediumSeaGreen:
                {
                alt59=92;
                }
                break;
            case MediumSlateBlue:
                {
                alt59=93;
                }
                break;
            case MediumSpringGreen:
                {
                alt59=94;
                }
                break;
            case MediumTurquoise:
                {
                alt59=95;
                }
                break;
            case MediumVioletRed:
                {
                alt59=96;
                }
                break;
            case MidnightBlue:
                {
                alt59=97;
                }
                break;
            case MintCream:
                {
                alt59=98;
                }
                break;
            case MistyRose:
                {
                alt59=99;
                }
                break;
            case Moccasin:
                {
                alt59=100;
                }
                break;
            case NavajoWhite:
                {
                alt59=101;
                }
                break;
            case Navy:
                {
                alt59=102;
                }
                break;
            case OldLace:
                {
                alt59=103;
                }
                break;
            case Olive:
                {
                alt59=104;
                }
                break;
            case OliveDrab:
                {
                alt59=105;
                }
                break;
            case OrangeRed:
                {
                alt59=106;
                }
                break;
            case Orchid:
                {
                alt59=107;
                }
                break;
            case PaleGoldenRod:
                {
                alt59=108;
                }
                break;
            case PaleGreen:
                {
                alt59=109;
                }
                break;
            case PaleTurquoise:
                {
                alt59=110;
                }
                break;
            case PaleVioletRed:
                {
                alt59=111;
                }
                break;
            case PapayaWhip:
                {
                alt59=112;
                }
                break;
            case PeachPuff:
                {
                alt59=113;
                }
                break;
            case Peru:
                {
                alt59=114;
                }
                break;
            case Pink:
                {
                alt59=115;
                }
                break;
            case Plum:
                {
                alt59=116;
                }
                break;
            case PowderBlue:
                {
                alt59=117;
                }
                break;
            case Purple:
                {
                alt59=118;
                }
                break;
            case Red:
                {
                alt59=119;
                }
                break;
            case RosyBrown:
                {
                alt59=120;
                }
                break;
            case RoyalBlue:
                {
                alt59=121;
                }
                break;
            case SaddleBrown:
                {
                alt59=122;
                }
                break;
            case Salmon:
                {
                alt59=123;
                }
                break;
            case SandyBrown:
                {
                alt59=124;
                }
                break;
            case SeaGreen:
                {
                alt59=125;
                }
                break;
            case Sienna:
                {
                alt59=126;
                }
                break;
            case Silver:
                {
                alt59=127;
                }
                break;
            case SkyBlue:
                {
                alt59=128;
                }
                break;
            case SlateBlue:
                {
                alt59=129;
                }
                break;
            case SlateGray:
                {
                alt59=130;
                }
                break;
            case SlateGrey:
                {
                alt59=131;
                }
                break;
            case Snow:
                {
                alt59=132;
                }
                break;
            case SpringGreen:
                {
                alt59=133;
                }
                break;
            case SteelBlue:
                {
                alt59=134;
                }
                break;
            case Tan:
                {
                alt59=135;
                }
                break;
            case Teal:
                {
                alt59=136;
                }
                break;
            case Thistle:
                {
                alt59=137;
                }
                break;
            case Tomato:
                {
                alt59=138;
                }
                break;
            case Turquoise:
                {
                alt59=139;
                }
                break;
            case Violet:
                {
                alt59=140;
                }
                break;
            case Wheat:
                {
                alt59=141;
                }
                break;
            case White:
                {
                alt59=142;
                }
                break;
            case WhiteSmoke:
                {
                alt59=143;
                }
                break;
            case Yellow:
                {
                alt59=144;
                }
                break;
            case YellowGreen:
                {
                alt59=145;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2144:2: kw= AliceBlue
                    {
                    kw=(Token)match(input,AliceBlue,FOLLOW_AliceBlue_in_ruleColor5468); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAliceBlueKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2151:2: kw= AntiqueWhite
                    {
                    kw=(Token)match(input,AntiqueWhite,FOLLOW_AntiqueWhite_in_ruleColor5487); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2158:2: kw= Aqua
                    {
                    kw=(Token)match(input,Aqua,FOLLOW_Aqua_in_ruleColor5506); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAquaKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2165:2: kw= Aquamarine
                    {
                    kw=(Token)match(input,Aquamarine,FOLLOW_Aquamarine_in_ruleColor5525); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAquamarineKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2172:2: kw= Azure
                    {
                    kw=(Token)match(input,Azure,FOLLOW_Azure_in_ruleColor5544); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getAzureKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2179:2: kw= Beige
                    {
                    kw=(Token)match(input,Beige,FOLLOW_Beige_in_ruleColor5563); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBeigeKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2186:2: kw= Bisque
                    {
                    kw=(Token)match(input,Bisque,FOLLOW_Bisque_in_ruleColor5582); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBisqueKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2193:2: kw= Black
                    {
                    kw=(Token)match(input,Black,FOLLOW_Black_in_ruleColor5601); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlackKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2200:2: kw= BlanchedAlmond
                    {
                    kw=(Token)match(input,BlanchedAlmond,FOLLOW_BlanchedAlmond_in_ruleColor5620); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlanchedAlmondKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2207:2: kw= Blue
                    {
                    kw=(Token)match(input,Blue,FOLLOW_Blue_in_ruleColor5639); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlueKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2214:2: kw= BlueViolet
                    {
                    kw=(Token)match(input,BlueViolet,FOLLOW_BlueViolet_in_ruleColor5658); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBlueVioletKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2221:2: kw= Brown
                    {
                    kw=(Token)match(input,Brown,FOLLOW_Brown_in_ruleColor5677); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBrownKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2228:2: kw= BurlyWood
                    {
                    kw=(Token)match(input,BurlyWood,FOLLOW_BurlyWood_in_ruleColor5696); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getBurlyWoodKeyword_12()); 
                        

                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2235:2: kw= CadetBlue
                    {
                    kw=(Token)match(input,CadetBlue,FOLLOW_CadetBlue_in_ruleColor5715); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCadetBlueKeyword_13()); 
                        

                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2242:2: kw= Chartreuse
                    {
                    kw=(Token)match(input,Chartreuse,FOLLOW_Chartreuse_in_ruleColor5734); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getChartreuseKeyword_14()); 
                        

                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2249:2: kw= Chocolate
                    {
                    kw=(Token)match(input,Chocolate,FOLLOW_Chocolate_in_ruleColor5753); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getChocolateKeyword_15()); 
                        

                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2256:2: kw= Coral
                    {
                    kw=(Token)match(input,Coral,FOLLOW_Coral_in_ruleColor5772); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCoralKeyword_16()); 
                        

                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2263:2: kw= CornflowerBlue
                    {
                    kw=(Token)match(input,CornflowerBlue,FOLLOW_CornflowerBlue_in_ruleColor5791); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCornflowerBlueKeyword_17()); 
                        

                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2270:2: kw= Cornsilk
                    {
                    kw=(Token)match(input,Cornsilk,FOLLOW_Cornsilk_in_ruleColor5810); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCornsilkKeyword_18()); 
                        

                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2277:2: kw= Crimson
                    {
                    kw=(Token)match(input,Crimson,FOLLOW_Crimson_in_ruleColor5829); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCrimsonKeyword_19()); 
                        

                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2284:2: kw= Cyan
                    {
                    kw=(Token)match(input,Cyan,FOLLOW_Cyan_in_ruleColor5848); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getCyanKeyword_20()); 
                        

                    }
                    break;
                case 22 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2291:2: kw= DarkBlue
                    {
                    kw=(Token)match(input,DarkBlue,FOLLOW_DarkBlue_in_ruleColor5867); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkBlueKeyword_21()); 
                        

                    }
                    break;
                case 23 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2298:2: kw= DarkCyan
                    {
                    kw=(Token)match(input,DarkCyan,FOLLOW_DarkCyan_in_ruleColor5886); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkCyanKeyword_22()); 
                        

                    }
                    break;
                case 24 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2305:2: kw= DarkGoldenRod
                    {
                    kw=(Token)match(input,DarkGoldenRod,FOLLOW_DarkGoldenRod_in_ruleColor5905); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGoldenRodKeyword_23()); 
                        

                    }
                    break;
                case 25 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2312:2: kw= DarkGray
                    {
                    kw=(Token)match(input,DarkGray,FOLLOW_DarkGray_in_ruleColor5924); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGrayKeyword_24()); 
                        

                    }
                    break;
                case 26 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2319:2: kw= DarkGreen
                    {
                    kw=(Token)match(input,DarkGreen,FOLLOW_DarkGreen_in_ruleColor5943); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGreenKeyword_25()); 
                        

                    }
                    break;
                case 27 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2326:2: kw= DarkGrey
                    {
                    kw=(Token)match(input,DarkGrey,FOLLOW_DarkGrey_in_ruleColor5962); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkGreyKeyword_26()); 
                        

                    }
                    break;
                case 28 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2333:2: kw= DarkKhaki
                    {
                    kw=(Token)match(input,DarkKhaki,FOLLOW_DarkKhaki_in_ruleColor5981); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkKhakiKeyword_27()); 
                        

                    }
                    break;
                case 29 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2340:2: kw= DarkMagenta
                    {
                    kw=(Token)match(input,DarkMagenta,FOLLOW_DarkMagenta_in_ruleColor6000); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkMagentaKeyword_28()); 
                        

                    }
                    break;
                case 30 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2347:2: kw= DarkOliveGreen
                    {
                    kw=(Token)match(input,DarkOliveGreen,FOLLOW_DarkOliveGreen_in_ruleColor6019); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkOliveGreenKeyword_29()); 
                        

                    }
                    break;
                case 31 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2354:2: kw= DarkOrchid
                    {
                    kw=(Token)match(input,DarkOrchid,FOLLOW_DarkOrchid_in_ruleColor6038); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkOrchidKeyword_30()); 
                        

                    }
                    break;
                case 32 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2361:2: kw= DarkRed
                    {
                    kw=(Token)match(input,DarkRed,FOLLOW_DarkRed_in_ruleColor6057); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkRedKeyword_31()); 
                        

                    }
                    break;
                case 33 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2368:2: kw= DarkSalmo
                    {
                    kw=(Token)match(input,DarkSalmo,FOLLOW_DarkSalmo_in_ruleColor6076); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSalmoKeyword_32()); 
                        

                    }
                    break;
                case 34 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2375:2: kw= DarkSeaGreen
                    {
                    kw=(Token)match(input,DarkSeaGreen,FOLLOW_DarkSeaGreen_in_ruleColor6095); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSeaGreenKeyword_33()); 
                        

                    }
                    break;
                case 35 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2382:2: kw= DarkSlateBlue
                    {
                    kw=(Token)match(input,DarkSlateBlue,FOLLOW_DarkSlateBlue_in_ruleColor6114); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSlateBlueKeyword_34()); 
                        

                    }
                    break;
                case 36 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2389:2: kw= DarkSlateGray
                    {
                    kw=(Token)match(input,DarkSlateGray,FOLLOW_DarkSlateGray_in_ruleColor6133); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSlateGrayKeyword_35()); 
                        

                    }
                    break;
                case 37 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2396:2: kw= DarkSlateGrey
                    {
                    kw=(Token)match(input,DarkSlateGrey,FOLLOW_DarkSlateGrey_in_ruleColor6152); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkSlateGreyKeyword_36()); 
                        

                    }
                    break;
                case 38 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2403:2: kw= DarkTurquoise
                    {
                    kw=(Token)match(input,DarkTurquoise,FOLLOW_DarkTurquoise_in_ruleColor6171); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkTurquoiseKeyword_37()); 
                        

                    }
                    break;
                case 39 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2410:2: kw= DarkViolet
                    {
                    kw=(Token)match(input,DarkViolet,FOLLOW_DarkViolet_in_ruleColor6190); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkVioletKeyword_38()); 
                        

                    }
                    break;
                case 40 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2417:2: kw= Darkorange
                    {
                    kw=(Token)match(input,Darkorange,FOLLOW_Darkorange_in_ruleColor6209); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDarkorangeKeyword_39()); 
                        

                    }
                    break;
                case 41 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2424:2: kw= DeepPink
                    {
                    kw=(Token)match(input,DeepPink,FOLLOW_DeepPink_in_ruleColor6228); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDeepPinkKeyword_40()); 
                        

                    }
                    break;
                case 42 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2431:2: kw= DeepSkyBlue
                    {
                    kw=(Token)match(input,DeepSkyBlue,FOLLOW_DeepSkyBlue_in_ruleColor6247); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDeepSkyBlueKeyword_41()); 
                        

                    }
                    break;
                case 43 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2438:2: kw= DimGray
                    {
                    kw=(Token)match(input,DimGray,FOLLOW_DimGray_in_ruleColor6266); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDimGrayKeyword_42()); 
                        

                    }
                    break;
                case 44 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2445:2: kw= DimGrey
                    {
                    kw=(Token)match(input,DimGrey,FOLLOW_DimGrey_in_ruleColor6285); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDimGreyKeyword_43()); 
                        

                    }
                    break;
                case 45 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2452:2: kw= DodgerBlue
                    {
                    kw=(Token)match(input,DodgerBlue,FOLLOW_DodgerBlue_in_ruleColor6304); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getDodgerBlueKeyword_44()); 
                        

                    }
                    break;
                case 46 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2459:2: kw= FireBrick
                    {
                    kw=(Token)match(input,FireBrick,FOLLOW_FireBrick_in_ruleColor6323); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getFireBrickKeyword_45()); 
                        

                    }
                    break;
                case 47 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2466:2: kw= FloralWhite
                    {
                    kw=(Token)match(input,FloralWhite,FOLLOW_FloralWhite_in_ruleColor6342); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getFloralWhiteKeyword_46()); 
                        

                    }
                    break;
                case 48 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2473:2: kw= ForestGreen
                    {
                    kw=(Token)match(input,ForestGreen,FOLLOW_ForestGreen_in_ruleColor6361); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getForestGreenKeyword_47()); 
                        

                    }
                    break;
                case 49 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2480:2: kw= Fuchsia
                    {
                    kw=(Token)match(input,Fuchsia,FOLLOW_Fuchsia_in_ruleColor6380); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getFuchsiaKeyword_48()); 
                        

                    }
                    break;
                case 50 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2487:2: kw= Gainsboro
                    {
                    kw=(Token)match(input,Gainsboro,FOLLOW_Gainsboro_in_ruleColor6399); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGainsboroKeyword_49()); 
                        

                    }
                    break;
                case 51 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2494:2: kw= GhostWhite
                    {
                    kw=(Token)match(input,GhostWhite,FOLLOW_GhostWhite_in_ruleColor6418); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGhostWhiteKeyword_50()); 
                        

                    }
                    break;
                case 52 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2501:2: kw= Gold
                    {
                    kw=(Token)match(input,Gold,FOLLOW_Gold_in_ruleColor6437); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGoldKeyword_51()); 
                        

                    }
                    break;
                case 53 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2508:2: kw= GoldenRod
                    {
                    kw=(Token)match(input,GoldenRod,FOLLOW_GoldenRod_in_ruleColor6456); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGoldenRodKeyword_52()); 
                        

                    }
                    break;
                case 54 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2515:2: kw= Gray
                    {
                    kw=(Token)match(input,Gray,FOLLOW_Gray_in_ruleColor6475); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGrayKeyword_53()); 
                        

                    }
                    break;
                case 55 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2522:2: kw= Green
                    {
                    kw=(Token)match(input,Green,FOLLOW_Green_in_ruleColor6494); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGreenKeyword_54()); 
                        

                    }
                    break;
                case 56 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2529:2: kw= GreenYellow
                    {
                    kw=(Token)match(input,GreenYellow,FOLLOW_GreenYellow_in_ruleColor6513); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGreenYellowKeyword_55()); 
                        

                    }
                    break;
                case 57 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2536:2: kw= Grey
                    {
                    kw=(Token)match(input,Grey,FOLLOW_Grey_in_ruleColor6532); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getGreyKeyword_56()); 
                        

                    }
                    break;
                case 58 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2543:2: kw= HoneyDew
                    {
                    kw=(Token)match(input,HoneyDew,FOLLOW_HoneyDew_in_ruleColor6551); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getHoneyDewKeyword_57()); 
                        

                    }
                    break;
                case 59 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2550:2: kw= HotPink
                    {
                    kw=(Token)match(input,HotPink,FOLLOW_HotPink_in_ruleColor6570); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getHotPinkKeyword_58()); 
                        

                    }
                    break;
                case 60 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2557:2: kw= IndianRed
                    {
                    kw=(Token)match(input,IndianRed,FOLLOW_IndianRed_in_ruleColor6589); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getIndianRedKeyword_59()); 
                        

                    }
                    break;
                case 61 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2564:2: kw= Indigo
                    {
                    kw=(Token)match(input,Indigo,FOLLOW_Indigo_in_ruleColor6608); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getIndigoKeyword_60()); 
                        

                    }
                    break;
                case 62 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2571:2: kw= Ivory
                    {
                    kw=(Token)match(input,Ivory,FOLLOW_Ivory_in_ruleColor6627); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getIvoryKeyword_61()); 
                        

                    }
                    break;
                case 63 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2578:2: kw= Khaki
                    {
                    kw=(Token)match(input,Khaki,FOLLOW_Khaki_in_ruleColor6646); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getKhakiKeyword_62()); 
                        

                    }
                    break;
                case 64 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2585:2: kw= Lavender
                    {
                    kw=(Token)match(input,Lavender,FOLLOW_Lavender_in_ruleColor6665); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLavenderKeyword_63()); 
                        

                    }
                    break;
                case 65 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2592:2: kw= LavenderBlush
                    {
                    kw=(Token)match(input,LavenderBlush,FOLLOW_LavenderBlush_in_ruleColor6684); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLavenderBlushKeyword_64()); 
                        

                    }
                    break;
                case 66 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2599:2: kw= LawnGreen
                    {
                    kw=(Token)match(input,LawnGreen,FOLLOW_LawnGreen_in_ruleColor6703); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLawnGreenKeyword_65()); 
                        

                    }
                    break;
                case 67 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2606:2: kw= LemonChiffon
                    {
                    kw=(Token)match(input,LemonChiffon,FOLLOW_LemonChiffon_in_ruleColor6722); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLemonChiffonKeyword_66()); 
                        

                    }
                    break;
                case 68 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2613:2: kw= LightBlue
                    {
                    kw=(Token)match(input,LightBlue,FOLLOW_LightBlue_in_ruleColor6741); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightBlueKeyword_67()); 
                        

                    }
                    break;
                case 69 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2620:2: kw= LightCoral
                    {
                    kw=(Token)match(input,LightCoral,FOLLOW_LightCoral_in_ruleColor6760); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightCoralKeyword_68()); 
                        

                    }
                    break;
                case 70 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2627:2: kw= LightCyan
                    {
                    kw=(Token)match(input,LightCyan,FOLLOW_LightCyan_in_ruleColor6779); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightCyanKeyword_69()); 
                        

                    }
                    break;
                case 71 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2634:2: kw= LightGoldenRodYellow
                    {
                    kw=(Token)match(input,LightGoldenRodYellow,FOLLOW_LightGoldenRodYellow_in_ruleColor6798); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_70()); 
                        

                    }
                    break;
                case 72 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2641:2: kw= LightGray
                    {
                    kw=(Token)match(input,LightGray,FOLLOW_LightGray_in_ruleColor6817); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGrayKeyword_71()); 
                        

                    }
                    break;
                case 73 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2648:2: kw= LightGreen
                    {
                    kw=(Token)match(input,LightGreen,FOLLOW_LightGreen_in_ruleColor6836); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGreenKeyword_72()); 
                        

                    }
                    break;
                case 74 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2655:2: kw= LightGrey
                    {
                    kw=(Token)match(input,LightGrey,FOLLOW_LightGrey_in_ruleColor6855); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightGreyKeyword_73()); 
                        

                    }
                    break;
                case 75 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2662:2: kw= LightPink
                    {
                    kw=(Token)match(input,LightPink,FOLLOW_LightPink_in_ruleColor6874); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightPinkKeyword_74()); 
                        

                    }
                    break;
                case 76 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2669:2: kw= LightSalmon
                    {
                    kw=(Token)match(input,LightSalmon,FOLLOW_LightSalmon_in_ruleColor6893); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSalmonKeyword_75()); 
                        

                    }
                    break;
                case 77 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2676:2: kw= LightSeaGreen
                    {
                    kw=(Token)match(input,LightSeaGreen,FOLLOW_LightSeaGreen_in_ruleColor6912); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSeaGreenKeyword_76()); 
                        

                    }
                    break;
                case 78 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2683:2: kw= LightSkyBlue
                    {
                    kw=(Token)match(input,LightSkyBlue,FOLLOW_LightSkyBlue_in_ruleColor6931); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSkyBlueKeyword_77()); 
                        

                    }
                    break;
                case 79 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2690:2: kw= LightSlateGray
                    {
                    kw=(Token)match(input,LightSlateGray,FOLLOW_LightSlateGray_in_ruleColor6950); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSlateGrayKeyword_78()); 
                        

                    }
                    break;
                case 80 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2697:2: kw= LightSlateGrey
                    {
                    kw=(Token)match(input,LightSlateGrey,FOLLOW_LightSlateGrey_in_ruleColor6969); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSlateGreyKeyword_79()); 
                        

                    }
                    break;
                case 81 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2704:2: kw= LightSteelBlue
                    {
                    kw=(Token)match(input,LightSteelBlue,FOLLOW_LightSteelBlue_in_ruleColor6988); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightSteelBlueKeyword_80()); 
                        

                    }
                    break;
                case 82 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2711:2: kw= LightYellow
                    {
                    kw=(Token)match(input,LightYellow,FOLLOW_LightYellow_in_ruleColor7007); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLightYellowKeyword_81()); 
                        

                    }
                    break;
                case 83 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2718:2: kw= Lime
                    {
                    kw=(Token)match(input,Lime,FOLLOW_Lime_in_ruleColor7026); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLimeKeyword_82()); 
                        

                    }
                    break;
                case 84 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2725:2: kw= LimeGreen
                    {
                    kw=(Token)match(input,LimeGreen,FOLLOW_LimeGreen_in_ruleColor7045); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLimeGreenKeyword_83()); 
                        

                    }
                    break;
                case 85 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2732:2: kw= Linen
                    {
                    kw=(Token)match(input,Linen,FOLLOW_Linen_in_ruleColor7064); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getLinenKeyword_84()); 
                        

                    }
                    break;
                case 86 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2739:2: kw= Magenta
                    {
                    kw=(Token)match(input,Magenta,FOLLOW_Magenta_in_ruleColor7083); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMagentaKeyword_85()); 
                        

                    }
                    break;
                case 87 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2746:2: kw= Maroon
                    {
                    kw=(Token)match(input,Maroon,FOLLOW_Maroon_in_ruleColor7102); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMaroonKeyword_86()); 
                        

                    }
                    break;
                case 88 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2753:2: kw= MediumAquaMarine
                    {
                    kw=(Token)match(input,MediumAquaMarine,FOLLOW_MediumAquaMarine_in_ruleColor7121); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumAquaMarineKeyword_87()); 
                        

                    }
                    break;
                case 89 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2760:2: kw= MediumBlue
                    {
                    kw=(Token)match(input,MediumBlue,FOLLOW_MediumBlue_in_ruleColor7140); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumBlueKeyword_88()); 
                        

                    }
                    break;
                case 90 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2767:2: kw= MediumOrchid
                    {
                    kw=(Token)match(input,MediumOrchid,FOLLOW_MediumOrchid_in_ruleColor7159); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumOrchidKeyword_89()); 
                        

                    }
                    break;
                case 91 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2774:2: kw= MediumPurple
                    {
                    kw=(Token)match(input,MediumPurple,FOLLOW_MediumPurple_in_ruleColor7178); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumPurpleKeyword_90()); 
                        

                    }
                    break;
                case 92 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2781:2: kw= MediumSeaGreen
                    {
                    kw=(Token)match(input,MediumSeaGreen,FOLLOW_MediumSeaGreen_in_ruleColor7197); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumSeaGreenKeyword_91()); 
                        

                    }
                    break;
                case 93 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2788:2: kw= MediumSlateBlue
                    {
                    kw=(Token)match(input,MediumSlateBlue,FOLLOW_MediumSlateBlue_in_ruleColor7216); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumSlateBlueKeyword_92()); 
                        

                    }
                    break;
                case 94 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2795:2: kw= MediumSpringGreen
                    {
                    kw=(Token)match(input,MediumSpringGreen,FOLLOW_MediumSpringGreen_in_ruleColor7235); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumSpringGreenKeyword_93()); 
                        

                    }
                    break;
                case 95 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2802:2: kw= MediumTurquoise
                    {
                    kw=(Token)match(input,MediumTurquoise,FOLLOW_MediumTurquoise_in_ruleColor7254); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumTurquoiseKeyword_94()); 
                        

                    }
                    break;
                case 96 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2809:2: kw= MediumVioletRed
                    {
                    kw=(Token)match(input,MediumVioletRed,FOLLOW_MediumVioletRed_in_ruleColor7273); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMediumVioletRedKeyword_95()); 
                        

                    }
                    break;
                case 97 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2816:2: kw= MidnightBlue
                    {
                    kw=(Token)match(input,MidnightBlue,FOLLOW_MidnightBlue_in_ruleColor7292); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMidnightBlueKeyword_96()); 
                        

                    }
                    break;
                case 98 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2823:2: kw= MintCream
                    {
                    kw=(Token)match(input,MintCream,FOLLOW_MintCream_in_ruleColor7311); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMintCreamKeyword_97()); 
                        

                    }
                    break;
                case 99 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2830:2: kw= MistyRose
                    {
                    kw=(Token)match(input,MistyRose,FOLLOW_MistyRose_in_ruleColor7330); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMistyRoseKeyword_98()); 
                        

                    }
                    break;
                case 100 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2837:2: kw= Moccasin
                    {
                    kw=(Token)match(input,Moccasin,FOLLOW_Moccasin_in_ruleColor7349); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getMoccasinKeyword_99()); 
                        

                    }
                    break;
                case 101 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2844:2: kw= NavajoWhite
                    {
                    kw=(Token)match(input,NavajoWhite,FOLLOW_NavajoWhite_in_ruleColor7368); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getNavajoWhiteKeyword_100()); 
                        

                    }
                    break;
                case 102 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2851:2: kw= Navy
                    {
                    kw=(Token)match(input,Navy,FOLLOW_Navy_in_ruleColor7387); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getNavyKeyword_101()); 
                        

                    }
                    break;
                case 103 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2858:2: kw= OldLace
                    {
                    kw=(Token)match(input,OldLace,FOLLOW_OldLace_in_ruleColor7406); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOldLaceKeyword_102()); 
                        

                    }
                    break;
                case 104 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2865:2: kw= Olive
                    {
                    kw=(Token)match(input,Olive,FOLLOW_Olive_in_ruleColor7425); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOliveKeyword_103()); 
                        

                    }
                    break;
                case 105 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2872:2: kw= OliveDrab
                    {
                    kw=(Token)match(input,OliveDrab,FOLLOW_OliveDrab_in_ruleColor7444); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOliveDrabKeyword_104()); 
                        

                    }
                    break;
                case 106 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2879:2: kw= OrangeRed
                    {
                    kw=(Token)match(input,OrangeRed,FOLLOW_OrangeRed_in_ruleColor7463); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOrangeRedKeyword_105()); 
                        

                    }
                    break;
                case 107 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2886:2: kw= Orchid
                    {
                    kw=(Token)match(input,Orchid,FOLLOW_Orchid_in_ruleColor7482); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getOrchidKeyword_106()); 
                        

                    }
                    break;
                case 108 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2893:2: kw= PaleGoldenRod
                    {
                    kw=(Token)match(input,PaleGoldenRod,FOLLOW_PaleGoldenRod_in_ruleColor7501); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleGoldenRodKeyword_107()); 
                        

                    }
                    break;
                case 109 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2900:2: kw= PaleGreen
                    {
                    kw=(Token)match(input,PaleGreen,FOLLOW_PaleGreen_in_ruleColor7520); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleGreenKeyword_108()); 
                        

                    }
                    break;
                case 110 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2907:2: kw= PaleTurquoise
                    {
                    kw=(Token)match(input,PaleTurquoise,FOLLOW_PaleTurquoise_in_ruleColor7539); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleTurquoiseKeyword_109()); 
                        

                    }
                    break;
                case 111 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2914:2: kw= PaleVioletRed
                    {
                    kw=(Token)match(input,PaleVioletRed,FOLLOW_PaleVioletRed_in_ruleColor7558); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPaleVioletRedKeyword_110()); 
                        

                    }
                    break;
                case 112 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2921:2: kw= PapayaWhip
                    {
                    kw=(Token)match(input,PapayaWhip,FOLLOW_PapayaWhip_in_ruleColor7577); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPapayaWhipKeyword_111()); 
                        

                    }
                    break;
                case 113 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2928:2: kw= PeachPuff
                    {
                    kw=(Token)match(input,PeachPuff,FOLLOW_PeachPuff_in_ruleColor7596); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPeachPuffKeyword_112()); 
                        

                    }
                    break;
                case 114 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2935:2: kw= Peru
                    {
                    kw=(Token)match(input,Peru,FOLLOW_Peru_in_ruleColor7615); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPeruKeyword_113()); 
                        

                    }
                    break;
                case 115 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2942:2: kw= Pink
                    {
                    kw=(Token)match(input,Pink,FOLLOW_Pink_in_ruleColor7634); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPinkKeyword_114()); 
                        

                    }
                    break;
                case 116 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2949:2: kw= Plum
                    {
                    kw=(Token)match(input,Plum,FOLLOW_Plum_in_ruleColor7653); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPlumKeyword_115()); 
                        

                    }
                    break;
                case 117 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2956:2: kw= PowderBlue
                    {
                    kw=(Token)match(input,PowderBlue,FOLLOW_PowderBlue_in_ruleColor7672); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPowderBlueKeyword_116()); 
                        

                    }
                    break;
                case 118 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2963:2: kw= Purple
                    {
                    kw=(Token)match(input,Purple,FOLLOW_Purple_in_ruleColor7691); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getPurpleKeyword_117()); 
                        

                    }
                    break;
                case 119 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2970:2: kw= Red
                    {
                    kw=(Token)match(input,Red,FOLLOW_Red_in_ruleColor7710); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getRedKeyword_118()); 
                        

                    }
                    break;
                case 120 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2977:2: kw= RosyBrown
                    {
                    kw=(Token)match(input,RosyBrown,FOLLOW_RosyBrown_in_ruleColor7729); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getRosyBrownKeyword_119()); 
                        

                    }
                    break;
                case 121 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2984:2: kw= RoyalBlue
                    {
                    kw=(Token)match(input,RoyalBlue,FOLLOW_RoyalBlue_in_ruleColor7748); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getRoyalBlueKeyword_120()); 
                        

                    }
                    break;
                case 122 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2991:2: kw= SaddleBrown
                    {
                    kw=(Token)match(input,SaddleBrown,FOLLOW_SaddleBrown_in_ruleColor7767); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSaddleBrownKeyword_121()); 
                        

                    }
                    break;
                case 123 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2998:2: kw= Salmon
                    {
                    kw=(Token)match(input,Salmon,FOLLOW_Salmon_in_ruleColor7786); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSalmonKeyword_122()); 
                        

                    }
                    break;
                case 124 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3005:2: kw= SandyBrown
                    {
                    kw=(Token)match(input,SandyBrown,FOLLOW_SandyBrown_in_ruleColor7805); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSandyBrownKeyword_123()); 
                        

                    }
                    break;
                case 125 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3012:2: kw= SeaGreen
                    {
                    kw=(Token)match(input,SeaGreen,FOLLOW_SeaGreen_in_ruleColor7824); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSeaGreenKeyword_124()); 
                        

                    }
                    break;
                case 126 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3019:2: kw= Sienna
                    {
                    kw=(Token)match(input,Sienna,FOLLOW_Sienna_in_ruleColor7843); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSiennaKeyword_125()); 
                        

                    }
                    break;
                case 127 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3026:2: kw= Silver
                    {
                    kw=(Token)match(input,Silver,FOLLOW_Silver_in_ruleColor7862); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSilverKeyword_126()); 
                        

                    }
                    break;
                case 128 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3033:2: kw= SkyBlue
                    {
                    kw=(Token)match(input,SkyBlue,FOLLOW_SkyBlue_in_ruleColor7881); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSkyBlueKeyword_127()); 
                        

                    }
                    break;
                case 129 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3040:2: kw= SlateBlue
                    {
                    kw=(Token)match(input,SlateBlue,FOLLOW_SlateBlue_in_ruleColor7900); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSlateBlueKeyword_128()); 
                        

                    }
                    break;
                case 130 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3047:2: kw= SlateGray
                    {
                    kw=(Token)match(input,SlateGray,FOLLOW_SlateGray_in_ruleColor7919); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSlateGrayKeyword_129()); 
                        

                    }
                    break;
                case 131 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3054:2: kw= SlateGrey
                    {
                    kw=(Token)match(input,SlateGrey,FOLLOW_SlateGrey_in_ruleColor7938); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSlateGreyKeyword_130()); 
                        

                    }
                    break;
                case 132 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3061:2: kw= Snow
                    {
                    kw=(Token)match(input,Snow,FOLLOW_Snow_in_ruleColor7957); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSnowKeyword_131()); 
                        

                    }
                    break;
                case 133 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3068:2: kw= SpringGreen
                    {
                    kw=(Token)match(input,SpringGreen,FOLLOW_SpringGreen_in_ruleColor7976); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSpringGreenKeyword_132()); 
                        

                    }
                    break;
                case 134 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3075:2: kw= SteelBlue
                    {
                    kw=(Token)match(input,SteelBlue,FOLLOW_SteelBlue_in_ruleColor7995); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getSteelBlueKeyword_133()); 
                        

                    }
                    break;
                case 135 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3082:2: kw= Tan
                    {
                    kw=(Token)match(input,Tan,FOLLOW_Tan_in_ruleColor8014); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTanKeyword_134()); 
                        

                    }
                    break;
                case 136 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3089:2: kw= Teal
                    {
                    kw=(Token)match(input,Teal,FOLLOW_Teal_in_ruleColor8033); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTealKeyword_135()); 
                        

                    }
                    break;
                case 137 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3096:2: kw= Thistle
                    {
                    kw=(Token)match(input,Thistle,FOLLOW_Thistle_in_ruleColor8052); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getThistleKeyword_136()); 
                        

                    }
                    break;
                case 138 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3103:2: kw= Tomato
                    {
                    kw=(Token)match(input,Tomato,FOLLOW_Tomato_in_ruleColor8071); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTomatoKeyword_137()); 
                        

                    }
                    break;
                case 139 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3110:2: kw= Turquoise
                    {
                    kw=(Token)match(input,Turquoise,FOLLOW_Turquoise_in_ruleColor8090); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getTurquoiseKeyword_138()); 
                        

                    }
                    break;
                case 140 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3117:2: kw= Violet
                    {
                    kw=(Token)match(input,Violet,FOLLOW_Violet_in_ruleColor8109); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getVioletKeyword_139()); 
                        

                    }
                    break;
                case 141 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3124:2: kw= Wheat
                    {
                    kw=(Token)match(input,Wheat,FOLLOW_Wheat_in_ruleColor8128); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getWheatKeyword_140()); 
                        

                    }
                    break;
                case 142 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3131:2: kw= White
                    {
                    kw=(Token)match(input,White,FOLLOW_White_in_ruleColor8147); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getWhiteKeyword_141()); 
                        

                    }
                    break;
                case 143 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3138:2: kw= WhiteSmoke
                    {
                    kw=(Token)match(input,WhiteSmoke,FOLLOW_WhiteSmoke_in_ruleColor8166); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getWhiteSmokeKeyword_142()); 
                        

                    }
                    break;
                case 144 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3145:2: kw= Yellow
                    {
                    kw=(Token)match(input,Yellow,FOLLOW_Yellow_in_ruleColor8185); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getColorAccess().getYellowKeyword_143()); 
                        

                    }
                    break;
                case 145 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:3152:2: kw= YellowGreen
                    {
                    kw=(Token)match(input,YellowGreen,FOLLOW_YellowGreen_in_ruleColor8204); 

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
    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA5_eotS =
        "\47\uffff";
    static final String DFA5_eofS =
        "\47\uffff";
    static final String DFA5_minS =
        "\1\55\1\uffff\1\u00ce\2\u00c9\1\136\1\75\7\u00c9\1\u0099\1\u00ad"+
        "\1\171\1\4\2\u00ce\1\u00be\22\uffff";
    static final String DFA5_maxS =
        "\1\u00d1\1\uffff\1\u00d1\1\u00d0\1\u00d1\1\u00ce\10\u00d1\3\u00ce"+
        "\3\u00d1\1\u00ce\22\uffff";
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
            "\26\2\uffff\1\1\1\30\1\uffff\12\1\1\31\6\uffff\2\1",
            "",
            "\1\1\2\uffff\1\32",
            "\1\33\4\uffff\1\1\1\uffff\1\33",
            "\1\34\4\uffff\1\1\2\uffff\1\34",
            "\1\35\47\uffff\1\35\22\uffff\1\35\20\uffff\1\35\36\uffff\1"+
            "\35\4\uffff\1\1",
            "\2\36\37\uffff\1\36\12\uffff\1\36\1\uffff\1\36\14\uffff\3"+
            "\36\13\uffff\2\36\1\uffff\1\36\15\uffff\4\36\15\uffff\6\36\3"+
            "\uffff\6\36\5\uffff\1\36\2\uffff\13\36\4\uffff\1\1\1\uffff\2"+
            "\36",
            "\1\37\4\uffff\1\1\2\uffff\1\37",
            "\1\40\4\uffff\1\1\2\uffff\1\40",
            "\1\40\4\uffff\1\1\2\uffff\1\40",
            "\1\40\4\uffff\1\1\2\uffff\1\40",
            "\1\40\4\uffff\1\1\2\uffff\1\40",
            "\1\40\4\uffff\1\1\2\uffff\1\40",
            "\1\40\4\uffff\1\1\2\uffff\1\40",
            "\1\41\20\uffff\1\41\2\uffff\1\41\40\uffff\1\1",
            "\1\42\40\uffff\1\1",
            "\1\43\124\uffff\1\1",
            "\51\44\1\uffff\17\44\2\uffff\37\44\1\uffff\12\44\4\uffff\12"+
            "\44\4\uffff\13\44\4\uffff\14\44\5\uffff\15\44\7\uffff\2\44\35"+
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
    static final String DFA10_eotS =
        "\55\uffff";
    static final String DFA10_eofS =
        "\55\uffff";
    static final String DFA10_minS =
        "\2\75\1\uffff\51\75\1\uffff";
    static final String DFA10_maxS =
        "\2\u00d1\1\uffff\51\u00d1\1\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\2\51\uffff\1\1";
    static final String DFA10_specialS =
        "\55\uffff}>";
    static final String[] DFA10_transitionS = {
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\1\2\1\1\10\2\7"+
            "\uffff\2\2",
            "\1\5\1\34\37\uffff\1\13\12\uffff\1\33\1\uffff\1\23\14\uffff"+
            "\1\35\1\32\1\16\13\uffff\1\12\1\4\1\uffff\1\7\15\uffff\1\22"+
            "\1\24\1\10\1\6\15\uffff\1\15\1\31\1\11\1\20\1\25\1\26\3\uffff"+
            "\1\14\1\36\1\uffff\1\17\1\21\1\30\3\uffff\1\2\1\uffff\1\27\2"+
            "\uffff\1\37\1\41\1\42\1\40\1\45\1\46\1\47\1\51\1\43\1\50\7\uffff"+
            "\1\44\1\3",
            "",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\1\52\6\2\7"+
            "\uffff\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\1\53\11\2\7\uffff"+
            "\2\2",
            "\2\2\37\uffff\1\2\12\uffff\1\2\1\uffff\1\2\14\uffff\3\2\13"+
            "\uffff\2\2\1\uffff\1\2\15\uffff\4\2\15\uffff\6\2\3\uffff\2\2"+
            "\1\uffff\3\2\3\uffff\1\2\1\uffff\1\2\2\uffff\12\2\6\uffff\1"+
            "\54\2\2",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "621:1: (otherlv_18= LeftParenthesis ruleEndID otherlv_20= Comma otherlv_21= NumberSign this_HEXCODE_22= RULE_HEXCODE otherlv_23= RightParenthesis )?";
        }
    }
 

    public static final BitSet FOLLOW_rulePlantuml_in_entryRulePlantuml67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlantuml77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_rulePlantuml122 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_ruleDiagram_in_entryRuleDiagram157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDiagram167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_START_in_ruleDiagram203 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleDiagram213 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xB2FE7F0007C003C0L,0x0000000000030BFFL});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleDiagram233 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xB2FE7F0007C003C0L,0x0000000000030BFFL});
    public static final BitSet FOLLOW_RULE_END_in_ruleDiagram245 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleDiagram256 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_ruleInstruction350 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleInstruction378 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x8000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleColors_in_ruleInstruction394 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_ruleInstruction418 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleTitle_in_ruleInstruction439 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleLegend_in_ruleInstruction460 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleNewpage_in_ruleInstruction481 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleAltElse_in_ruleInstruction508 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_ruleInstruction535 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleNote_in_ruleInstruction562 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleDivider_in_ruleInstruction583 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleReference_in_ruleInstruction610 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleDelay_in_ruleInstruction631 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleSpace_in_ruleInstruction652 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_ruleInstruction673 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleActivate_in_ruleInstruction700 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleDeactivate_in_ruleInstruction727 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleParticipantCreation_in_ruleInstruction748 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleBox_in_ruleInstruction775 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleInstruction787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_entryRuleArrow821 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrow831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_ruleArrow877 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_RULE_SEQUENCE_in_ruleArrow888 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000301FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleArrow908 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_Colon_in_ruleArrow922 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000301FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleArrow938 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000301FFL});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition976 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Actor_in_ruleDefinition1025 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000301FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleDefinition1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Boundary_in_ruleDefinition1066 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000301FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleDefinition1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Control_in_ruleDefinition1107 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000301FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleDefinition1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Entity_in_ruleDefinition1148 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000301FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleDefinition1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Database_in_ruleDefinition1189 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000301FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleDefinition1209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Participant_in_ruleDefinition1230 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xD07E3F00078002C0L,0x00000000000301FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleDefinition1251 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_QuotationMark_in_ruleDefinition1271 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xD0763F00078002C0L,0x00000000000301FFL});
    public static final BitSet FOLLOW_ruleEndID_in_ruleDefinition1287 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xD0763F00078002C0L,0x00000000000301FFL});
    public static final BitSet FOLLOW_QuotationMark_in_ruleDefinition1301 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_As_in_ruleDefinition1313 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1323 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_LessThanSignLessThanSign_in_ruleDefinition1338 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0x94763F00078002C0L,0x00000000000301FFL});
    public static final BitSet FOLLOW_LeftParenthesis_in_ruleDefinition1351 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0x90763F00078002C0L,0x00000000000301FFL});
    public static final BitSet FOLLOW_ruleEndID_in_ruleDefinition1366 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_Comma_in_ruleDefinition1378 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_NumberSign_in_ruleDefinition1390 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_RULE_HEXCODE_in_ruleDefinition1400 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_RightParenthesis_in_ruleDefinition1412 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0x94763F00078002C0L,0x00000000000301FFL});
    public static final BitSet FOLLOW_ruleEndID_in_ruleDefinition1430 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0x94763F00078002C0L,0x00000000000301FFL});
    public static final BitSet FOLLOW_GreaterThanSignGreaterThanSign_in_ruleDefinition1444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndID_in_entryRuleEndID1484 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndID1495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEndID1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_ruleEndID1559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Autonumber_in_ruleEndID1578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Title_in_ruleEndID1597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Legend_in_ruleEndID1616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Right_in_ruleEndID1635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Left_in_ruleEndID1654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Center_in_ruleEndID1673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Endlegend_in_ruleEndID1692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Alt_in_ruleEndID1711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Else_in_ruleEndID1730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Newpage_in_ruleEndID1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Opt_in_ruleEndID1768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Loop_in_ruleEndID1787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Par_in_ruleEndID1806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Break_in_ruleEndID1825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Critical_in_ruleEndID1844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Group_in_ruleEndID1863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Note_in_ruleEndID1882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Over_in_ruleEndID1901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Of_in_ruleEndID1920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_ruleEndID1939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hide_in_ruleEndID1958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Footbox_in_ruleEndID1977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Activate_in_ruleEndID1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Deactivate_in_ruleEndID2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Destroy_in_ruleEndID2034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Box_in_ruleEndID2053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NumberSign_in_ruleEndID2072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_ruleEndID2091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftParenthesis_in_ruleEndID2110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightParenthesis_in_ruleEndID2129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EqualsSign_in_ruleEndID2148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEndID2169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HyphenMinus_in_ruleEndID2193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleEndID2212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_ruleEndID2231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GreaterThanSign_in_ruleEndID2250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LessThanSign_in_ruleEndID2269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_entryRuleMyID2309 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMyID2320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndID_in_ruleMyID2367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_ruleMyID2391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber2431 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAutoNumber2442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Autonumber_in_ruleAutoNumber2480 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAutoNumber2496 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAutoNumber2517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_entryRuleTitle2566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTitle2577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Title_in_ruleTitle2615 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTitle2631 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_ruleLegend_in_entryRuleLegend2678 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLegend2689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Legend_in_ruleLegend2727 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000040002000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_Right_in_ruleLegend2741 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_Left_in_ruleLegend2760 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_Center_in_ruleLegend2779 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleLegend2797 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000000000000000L,0x0000000000020200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLegend2818 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000000000000000L,0x0000000000020200L});
    public static final BitSet FOLLOW_Endlegend_in_ruleLegend2840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_entryRuleNewpage2880 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNewpage2891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Newpage_in_ruleNewpage2929 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNewpage2945 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_ruleAltElse_in_entryRuleAltElse2991 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAltElse3001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Alt_in_ruleAltElse3039 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000303FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleAltElse3055 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000303FFL});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleAltElse3067 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xB2FE7F0007C003C0L,0x00000000000303FFL});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleAltElse3087 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xB2FE7F0007C003C0L,0x00000000000303FFL});
    public static final BitSet FOLLOW_ruleElse_in_ruleAltElse3109 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008010000000000L});
    public static final BitSet FOLLOW_End_in_ruleAltElse3123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElse_in_entryRuleElse3157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElse3167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Else_in_ruleElse3205 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000303FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleElse3221 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000303FFL});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleElse3233 = new BitSet(new long[]{0x6000200000000002L,0x07801E0040000000L,0xB2FE7F0007C003C0L,0x00000000000303FFL});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleElse3253 = new BitSet(new long[]{0x6000200000000002L,0x07801E0040000000L,0xB2FE7F0007C003C0L,0x00000000000303FFL});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages3289 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroupingMessages3299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Opt_in_ruleGroupingMessages3338 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020200L});
    public static final BitSet FOLLOW_Loop_in_ruleGroupingMessages3356 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020200L});
    public static final BitSet FOLLOW_Par_in_ruleGroupingMessages3374 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020200L});
    public static final BitSet FOLLOW_Break_in_ruleGroupingMessages3392 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020200L});
    public static final BitSet FOLLOW_Critical_in_ruleGroupingMessages3410 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020200L});
    public static final BitSet FOLLOW_Group_in_ruleGroupingMessages3428 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGroupingMessages3440 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020200L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleGroupingMessages3452 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xB2FE7F0007C003C0L,0x00000000000303FFL});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleGroupingMessages3472 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xB2FE7F0007C003C0L,0x00000000000303FFL});
    public static final BitSet FOLLOW_End_in_ruleGroupingMessages3486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNote_in_entryRuleNote3520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNote3530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Note_in_ruleNote3568 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000240002000000L});
    public static final BitSet FOLLOW_Right_in_ruleNote3582 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x100980FFF83FFC3FL,0x0000000000000220L});
    public static final BitSet FOLLOW_Of_in_ruleNote3595 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote3614 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000980FFF83FFC3FL,0x0000000000000224L});
    public static final BitSet FOLLOW_Comma_in_ruleNote3628 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote3647 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000980FFF83FFC3FL,0x0000000000000224L});
    public static final BitSet FOLLOW_Left_in_ruleNote3672 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x100980FFF83FFC3FL,0x0000000000000220L});
    public static final BitSet FOLLOW_Of_in_ruleNote3685 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote3704 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000980FFF83FFC3FL,0x0000000000000224L});
    public static final BitSet FOLLOW_Comma_in_ruleNote3718 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote3737 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000980FFF83FFC3FL,0x0000000000000224L});
    public static final BitSet FOLLOW_Over_in_ruleNote3762 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote3781 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000980FFF83FFC3FL,0x0000000000000224L});
    public static final BitSet FOLLOW_Comma_in_ruleNote3795 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote3814 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000980FFF83FFC3FL,0x0000000000000224L});
    public static final BitSet FOLLOW_ruleColor_in_ruleNote3835 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000980FFF83FFC3FL,0x0000000000000220L});
    public static final BitSet FOLLOW_Colon_in_ruleNote3851 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000301FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleNote3867 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000301FFL});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleNote3888 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000303FFL});
    public static final BitSet FOLLOW_ruleEndID_in_ruleNote3904 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000303FFL});
    public static final BitSet FOLLOW_End_in_ruleNote3920 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_Note_in_ruleNote3932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDivider_in_entryRuleDivider3969 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDivider3980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EqualsSignEqualsSign_in_ruleDivider4018 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDivider4034 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_EqualsSignEqualsSign_in_ruleDivider4054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference4093 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference4103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_ruleReference4141 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_Over_in_ruleReference4153 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference4172 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L,0x0000000000000224L});
    public static final BitSet FOLLOW_Comma_in_ruleReference4186 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference4205 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L,0x0000000000000224L});
    public static final BitSet FOLLOW_Colon_in_ruleReference4222 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000301FFL});
    public static final BitSet FOLLOW_ruleMyID_in_ruleReference4238 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000301FFL});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleReference4259 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000303FFL});
    public static final BitSet FOLLOW_ruleEndID_in_ruleReference4275 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0x907E3F00078002C0L,0x00000000000303FFL});
    public static final BitSet FOLLOW_End_in_ruleReference4291 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_Ref_in_ruleReference4303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDelay_in_entryRuleDelay4340 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDelay4351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStopFullStopFullStop_in_ruleDelay4389 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000400000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDelay4406 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000400000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_FullStopFullStopFullStop_in_ruleDelay4426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpace_in_entryRuleSpace4468 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpace4479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLineVerticalLine_in_ruleSpace4517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLine_in_ruleSpace4537 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpace4553 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_VerticalLineVerticalLine_in_ruleSpace4573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox4614 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHidefootbox4625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hide_in_ruleHidefootbox4663 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_Footbox_in_ruleHidefootbox4676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActivate_in_entryRuleActivate4715 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActivate4725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Activate_in_ruleActivate4763 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000180FFF83FFC3FL,0x0000000000020000L});
    public static final BitSet FOLLOW_ruleColor_in_ruleActivate4779 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActivate4797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeactivate_in_entryRuleDeactivate4837 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeactivate4847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Deactivate_in_ruleDeactivate4886 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_Destroy_in_ruleDeactivate4904 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeactivate4924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParticipantCreation_in_entryRuleParticipantCreation4960 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParticipantCreation4971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_ruleParticipantCreation5009 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParticipantCreation5024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBox_in_entryRuleBox5068 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBox5078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Box_in_ruleBox5116 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_QuotationMark_in_ruleBox5128 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBox5139 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_QuotationMark_in_ruleBox5153 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000180FFF83FFC3FL,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleColor_in_ruleBox5169 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleBox5181 = new BitSet(new long[]{0x0000200000000000L,0x0080140000000000L,0x0008000000400100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleBox5202 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleBox5214 = new BitSet(new long[]{0x0000200000000000L,0x0080140000000000L,0x0008000000400100L,0x0000000000000200L});
    public static final BitSet FOLLOW_End_in_ruleBox5228 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_Box_in_ruleBox5240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColors_in_entryRuleColors5275 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColors5286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NumberSign_in_ruleColors5324 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000180FFF83FFC3FL,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleColor_in_ruleColors5347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEXCODE_in_ruleColors5373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_entryRuleColor5419 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColor5430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AliceBlue_in_ruleColor5468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AntiqueWhite_in_ruleColor5487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Aqua_in_ruleColor5506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Aquamarine_in_ruleColor5525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Azure_in_ruleColor5544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Beige_in_ruleColor5563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bisque_in_ruleColor5582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Black_in_ruleColor5601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BlanchedAlmond_in_ruleColor5620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Blue_in_ruleColor5639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BlueViolet_in_ruleColor5658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Brown_in_ruleColor5677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BurlyWood_in_ruleColor5696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CadetBlue_in_ruleColor5715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Chartreuse_in_ruleColor5734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Chocolate_in_ruleColor5753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Coral_in_ruleColor5772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CornflowerBlue_in_ruleColor5791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Cornsilk_in_ruleColor5810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Crimson_in_ruleColor5829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Cyan_in_ruleColor5848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkBlue_in_ruleColor5867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkCyan_in_ruleColor5886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGoldenRod_in_ruleColor5905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGray_in_ruleColor5924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGreen_in_ruleColor5943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGrey_in_ruleColor5962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkKhaki_in_ruleColor5981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkMagenta_in_ruleColor6000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkOliveGreen_in_ruleColor6019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkOrchid_in_ruleColor6038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkRed_in_ruleColor6057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSalmo_in_ruleColor6076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSeaGreen_in_ruleColor6095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSlateBlue_in_ruleColor6114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSlateGray_in_ruleColor6133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSlateGrey_in_ruleColor6152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkTurquoise_in_ruleColor6171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkViolet_in_ruleColor6190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Darkorange_in_ruleColor6209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DeepPink_in_ruleColor6228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DeepSkyBlue_in_ruleColor6247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DimGray_in_ruleColor6266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DimGrey_in_ruleColor6285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DodgerBlue_in_ruleColor6304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FireBrick_in_ruleColor6323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FloralWhite_in_ruleColor6342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ForestGreen_in_ruleColor6361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Fuchsia_in_ruleColor6380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Gainsboro_in_ruleColor6399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GhostWhite_in_ruleColor6418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Gold_in_ruleColor6437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GoldenRod_in_ruleColor6456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Gray_in_ruleColor6475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Green_in_ruleColor6494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GreenYellow_in_ruleColor6513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Grey_in_ruleColor6532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HoneyDew_in_ruleColor6551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HotPink_in_ruleColor6570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IndianRed_in_ruleColor6589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Indigo_in_ruleColor6608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ivory_in_ruleColor6627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Khaki_in_ruleColor6646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lavender_in_ruleColor6665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LavenderBlush_in_ruleColor6684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LawnGreen_in_ruleColor6703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LemonChiffon_in_ruleColor6722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightBlue_in_ruleColor6741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightCoral_in_ruleColor6760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightCyan_in_ruleColor6779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGoldenRodYellow_in_ruleColor6798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGray_in_ruleColor6817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGreen_in_ruleColor6836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGrey_in_ruleColor6855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightPink_in_ruleColor6874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSalmon_in_ruleColor6893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSeaGreen_in_ruleColor6912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSkyBlue_in_ruleColor6931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSlateGray_in_ruleColor6950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSlateGrey_in_ruleColor6969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSteelBlue_in_ruleColor6988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightYellow_in_ruleColor7007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lime_in_ruleColor7026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LimeGreen_in_ruleColor7045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Linen_in_ruleColor7064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Magenta_in_ruleColor7083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Maroon_in_ruleColor7102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumAquaMarine_in_ruleColor7121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumBlue_in_ruleColor7140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumOrchid_in_ruleColor7159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumPurple_in_ruleColor7178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumSeaGreen_in_ruleColor7197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumSlateBlue_in_ruleColor7216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumSpringGreen_in_ruleColor7235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumTurquoise_in_ruleColor7254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumVioletRed_in_ruleColor7273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MidnightBlue_in_ruleColor7292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MintCream_in_ruleColor7311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MistyRose_in_ruleColor7330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Moccasin_in_ruleColor7349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NavajoWhite_in_ruleColor7368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Navy_in_ruleColor7387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OldLace_in_ruleColor7406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Olive_in_ruleColor7425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OliveDrab_in_ruleColor7444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OrangeRed_in_ruleColor7463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Orchid_in_ruleColor7482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleGoldenRod_in_ruleColor7501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleGreen_in_ruleColor7520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleTurquoise_in_ruleColor7539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleVioletRed_in_ruleColor7558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PapayaWhip_in_ruleColor7577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PeachPuff_in_ruleColor7596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Peru_in_ruleColor7615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Pink_in_ruleColor7634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plum_in_ruleColor7653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PowderBlue_in_ruleColor7672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Purple_in_ruleColor7691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Red_in_ruleColor7710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RosyBrown_in_ruleColor7729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RoyalBlue_in_ruleColor7748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SaddleBrown_in_ruleColor7767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Salmon_in_ruleColor7786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SandyBrown_in_ruleColor7805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SeaGreen_in_ruleColor7824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Sienna_in_ruleColor7843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Silver_in_ruleColor7862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SkyBlue_in_ruleColor7881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SlateBlue_in_ruleColor7900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SlateGray_in_ruleColor7919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SlateGrey_in_ruleColor7938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Snow_in_ruleColor7957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SpringGreen_in_ruleColor7976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SteelBlue_in_ruleColor7995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Tan_in_ruleColor8014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Teal_in_ruleColor8033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Thistle_in_ruleColor8052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Tomato_in_ruleColor8071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Turquoise_in_ruleColor8090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Violet_in_ruleColor8109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Wheat_in_ruleColor8128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_White_in_ruleColor8147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WhiteSmoke_in_ruleColor8166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Yellow_in_ruleColor8185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_YellowGreen_in_ruleColor8204 = new BitSet(new long[]{0x0000000000000002L});

}